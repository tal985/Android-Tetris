package tetris.cs371m.tetris;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//Some code borrowed from Cody

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Boolean gameover = false;
    int score = 0, level = 1, delay = 1000, clearCount = 0, rowCount = 0;
    ImageButton left, ccw, down, cw, right, reset;
    Tetromino piece, nextPiece;
    TGrid tGrid, displayGrid;
    DrawTGrid dtGrid;
    DrawDisplayGrid ddpGrid;
    TextView levelboard, scoreboard, rowboard;
    Toast toast;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tetris music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tetris_loop);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        //Set scoreboard's text, set levelboard's text, set rowboard's text
        scoreboard = findViewById(R.id.scoreboard);
        scoreboard.setText("Score:\n" + score);
        levelboard = findViewById(R.id.levelboard);
        levelboard.setText("Level:\n" + level);
        rowboard = findViewById(R.id.rowboard);
        rowboard.setText("Row:\n" + rowCount);

        //Create grid and add to view
        tGrid = new TGrid(10, 23);
        dtGrid = new DrawTGrid(this, tGrid);
        int cellSize = (int) (25 * getResources().getDisplayMetrics().density);
        dtGrid.setLayoutParams(new ConstraintLayout.LayoutParams(cellSize * tGrid.getWidth(), cellSize * (tGrid.getHeight() - 3)));
        ConstraintLayout mainCLO = findViewById(R.id.main_CLO);
        mainCLO.addView(dtGrid);

        //Generate first two pieces randomly, insert piece into the grid
        piece = TetrominoBuilder.Random();
        nextPiece = TetrominoBuilder.Random();
        piece.insertIntoGrid(4, 0, tGrid);
        dtGrid.inputTGrid(tGrid);

        //Create next piece display grid
        createDisplayGrid();

        //Handler to run game based on delay
        final Handler gameHandler = new Handler();
        gameHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //Clear full rows
                while(tGrid.getFirstFullRow() != -1)
                {
                    tGrid.deleteRow(tGrid.getFirstFullRow());
                    score += level;
                    rowCount++;
                    clearCount++;
                    scoreboard.setText("Score:\n" + score);
                    rowboard.setText("Row:\n" + rowCount);
                }
                //Increase level after 5 rows are cleared
                if(clearCount >= 5)
                {
                    clearCount = 0;
                    level++;
                    levelboard.setText("Level:\n" + level);
                    //Change the delay
                    delay = (int) (1000 * Math.pow(0.8, level - 1));
                }
                //Move piece down by one spot; check for gameover
                downOne();
                if(!gameover)
                    gameHandler.postDelayed(this, delay);
                else
                {
                    toast = Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        }, delay);


        //Buttons
        left = findViewById(R.id.leftButton);
        ccw = findViewById(R.id.ccwButton);
        down = findViewById(R.id.downButton);
        cw = findViewById(R.id.cwButton);
        right = findViewById(R.id.rightButton);
        reset = findViewById(R.id.resetButton);
        left.setOnClickListener(this);
        ccw.setOnClickListener(this);
        down.setOnClickListener(this);
        cw.setOnClickListener(this);
        right.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    //Action bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Selecting action bar options
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.settingsOption)
        {
            Intent settingsIntent = new Intent(getApplicationContext(), SettingsMenu.class);
            settingsIntent.putExtra("level", level);
            startActivityForResult(settingsIntent, 1);
        }
        return true;
    }

    //Get results back from settings menu to set level
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle extras = data.getExtras();
        if(requestCode == 1 && resultCode == RESULT_OK && level != extras.getInt("level"))
        {
            level = extras.getInt("level");
            levelboard.setText("Level: " + level);
            delay = (int) (1000 * Math.pow(0.8, level - 1));
        }
    }

    //Button functionality
    public void onClick(View v)
    {
        if(v.getId() == R.id.resetButton)
            reset();

        if(!gameover)
        {
            switch (v.getId()) {
                case R.id.downButton:
                    down();
                    break;
                case R.id.rightButton:
                    right();
                    break;
                case R.id.leftButton:
                    left();
                    break;
                case R.id.ccwButton:
                    ccw();
                    break;
                case R.id.cwButton:
                    cw();
                    break;
            }
        }
    }

    //Piece goes down one
    public void downOne()
    {
        if(piece.shiftDown())
        {
            //Do nothing since the condition check already changes the piece
        }
        else
        {
            if(tGrid.rowIsEmpty(2) && tGrid.rowIsEmpty(1) && tGrid.rowIsEmpty(0))
                switchPiece();
            else
                gameover = true;
        }
        dtGrid.invalidate();
    }

    //Piece goes all the way down
    public void down()
    {
        while(piece.shiftDown())
        {
            //Do nothing since the condition check already changes the piece
        }
        if(tGrid.rowIsEmpty(2) && tGrid.rowIsEmpty(1) && tGrid.rowIsEmpty(0))
            switchPiece();
        else
            gameover = true;
        dtGrid.invalidate();
    }

    //Piece goes right
    public void right()
    {
        piece.shiftRight();
        dtGrid.invalidate();
    }

    //Piece goes left
    public void left()
    {
        piece.shiftLeft();
        dtGrid.invalidate();
    }

    //Piece rotates clockwise
    public void cw()
    {
        piece.rotateClockwise();
        dtGrid.invalidate();
    }

    //Piece rotaes counter-clockwise
    public void ccw()
    {
        piece.rotateCounterClockwise();
        dtGrid.invalidate();
    }

    //Game resets by ending current activity and starting a new one
    public void reset()
    {
        mediaPlayer.release();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    //Switch to next piece, create new random next piece, insert into grid
    public void switchPiece()
    {
        piece = nextPiece;
        nextPiece = TetrominoBuilder.Random();
        piece.insertIntoGrid(4, 0, tGrid);

        //Update next piece display grid
        displayGrid.clear();
        nextPiece.insertIntoGrid(0, 1, displayGrid);
        ddpGrid.inputTGrid(displayGrid);
        ddpGrid.invalidate();

    }

    //Create the next piece display grid
    public void createDisplayGrid()
    {
        displayGrid = new TGrid(4, 4);
        nextPiece.insertIntoGrid(0, 1, displayGrid);
        ddpGrid = findViewById(R.id.nextPieceDisplay);
        ddpGrid.inputTGrid(displayGrid);
        ddpGrid.invalidate();
    }
}
