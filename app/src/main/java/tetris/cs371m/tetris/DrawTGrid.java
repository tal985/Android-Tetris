package tetris.cs371m.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawTGrid extends View
{
    TGrid tempGrid;
    int rows = 0, cols = 0;
    Paint paint = new Paint();

    public DrawTGrid(Context c, TGrid tGrid)
    {
        super(c);
        cols = tGrid.getWidth();
        rows = tGrid.getHeight();
        tempGrid = tGrid;
    }

    public DrawTGrid(Context c, AttributeSet a)
    {
        super(c, a);
    }

    public DrawTGrid(Context c, AttributeSet a, int ds)
    {
        super(c, a, ds);
    }

    public void inputTGrid(TGrid tGrid)
    {
        tempGrid = tGrid;
        cols = tGrid.getWidth();
        rows = tGrid.getHeight();
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        float x, y, gridPX = getWidth() / 10f;;
        int i, j;

        paint.setStrokeWidth(6);
        paint.setColor(Color.LTGRAY);


        //Draw horizontal lines
        for(i = 0; i < rows - 2; i++)
        {
            y = i * gridPX;
            canvas.drawLine(0, y, getWidth(), y, paint);
        }
        //Draw vertical lines
        for(j = 0; j < cols + 1; j++)
        {
            x = j * gridPX;
            canvas.drawLine(x, 0, x, getHeight(), paint);
        }


        //Draw grid w/ tetromino
        for(i = 0; i < rows; i++)
        {
           for(j = 0; j < cols; j++)
           {
               if(tempGrid.getCellAt(j, i) != null)
               {
                   //Draw rectangle
                   paint.setStyle(Paint.Style.FILL);
                   paint.setColor(tempGrid.getCellAt(j, i).getColor());
                   canvas.drawRect(j * gridPX, (i - 3) * gridPX, (j + 1) * gridPX, (i - 2) * gridPX, paint);
                   //Draw rectangle border
                   paint.setStyle(Paint.Style.STROKE);
                   paint.setColor(Color.DKGRAY);
                   canvas.drawRect(j * gridPX, (i - 3) * gridPX, (j + 1) * gridPX, (i - 2) * gridPX, paint);
               }
           }
        }
    }

}
