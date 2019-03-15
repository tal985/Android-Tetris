package tetris.cs371m.tetris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingsMenu extends AppCompatActivity implements View.OnClickListener
{
    int level;
    ImageButton levelDown, levelUp, cancel, save;
    Bundle extras;
    TextView levelText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

        //Buttons
        levelDown = findViewById(R.id.levelDown);
        levelUp = findViewById(R.id.levelUp);
        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);
        levelDown.setOnClickListener(this);
        levelUp.setOnClickListener(this);
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

        //Display current level
        levelText = findViewById(R.id.levelText);
        extras = getIntent().getExtras();
        level = extras.getInt("level");
        levelText.setText("Level: " + level);
    }

    //Button functionality
    public void onClick(View v)
    {
        Intent result = new Intent();
        switch(v.getId())
        {
            case R.id.levelDown:
                if(level > 1)
                    level--;
                levelText.setText("Level: " + level);
                break;
            case R.id.levelUp:
                level++;
                levelText.setText("Level: " + level);
                break;
            case R.id.saveButton:
                result.putExtra("level", level);
                setResult(RESULT_OK, result);
                finish();
                break;
            case R.id.cancelButton:
                setResult(RESULT_CANCELED, result);
                finish();
                break;
        }
    }
}
