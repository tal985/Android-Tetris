package tetris.cs371m.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawDisplayGrid extends View
{
    int rows, cols;
    TGrid tempGrid;
    Paint paint = new Paint();

    public DrawDisplayGrid(Context c, TGrid tGrid)
    {
        super(c);
        cols = tGrid.getWidth();
        rows = tGrid.getHeight();
        tempGrid = tGrid;
    }

    public DrawDisplayGrid(Context c, AttributeSet a)
    {
        super(c, a);
    }

    public DrawDisplayGrid(Context c, AttributeSet a, int ds)
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
        float x, y, gridPX = getWidth()/ 4f;
        int i, j;
        paint.setStrokeWidth(6);
        paint.setColor(Color.LTGRAY);

        //Draw horizontal lines
        for(i = 0; i < rows; i++)
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


        //Draw next piece
        for(i = 0; i < rows; i++)
        {
            for (j = 0; j < cols; j++)
            {
                if(tempGrid.getCellAt(j, i) != null)
                {
                    //Draw rectangle
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(tempGrid.getCellAt(j, i).getColor());
                    canvas.drawRect(j * gridPX, i * gridPX, (j + 1) * gridPX, (i + 1) * gridPX, paint);
                    //Draw rectangle border
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.DKGRAY);
                    canvas.drawRect(j * gridPX, i * gridPX, (j + 1) * gridPX, (i + 1) * gridPX, paint);
                }
            }
        }
    }
}
