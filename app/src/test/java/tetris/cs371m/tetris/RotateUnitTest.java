package tetris.cs371m.tetris;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by zhitingz on 2/11/18.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RotateUnitTest {

    @Test
    public void rotateClockI() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedI.checkOrig(tet);
        WellFormedI.checkOrigPos(tet, x, y);
        tet.rotateClockwise();
        WellFormedI.checkRClockOnce(tet);
        WellFormedI.checkRClockOncePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedI.checkRClockTwice(tet);
        WellFormedI.checkRClockTwicePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedI.checkRCounterOnce(tet);
        WellFormedI.checkRCounterOncePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedI.checkOrig(tet);
        WellFormedI.checkOrigPos(tet, x,y);
    }

    @Test
    public void rotateCounterI() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedI.checkOrig(tet);
        WellFormedI.checkOrigPos(tet, x, y);
        tet.rotateCounterClockwise();
        WellFormedI.checkRCounterOnce(tet);
        WellFormedI.checkRCounterOncePos(tet, x, y);
        tet.rotateCounterClockwise();
        WellFormedI.checkRClockTwice(tet);
        WellFormedI.checkRClockTwicePos(tet, x, y);
        tet.rotateCounterClockwise();
        WellFormedI.checkRClockOnce(tet);
        WellFormedI.checkRClockOncePos(tet, x, y);
        tet.rotateCounterClockwise();
        WellFormedI.checkOrig(tet);
        WellFormedI.checkOrigPos(tet, x, y);
    }

    @Test
    public void rotateClockJ() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedJ.checkOrig(tet);
        WellFormedJ.checkOrigPos(tet, x, y);
        tet.rotateClockwise();
        WellFormedJ.checkRClockOnce(tet);
        WellFormedJ.checkRClockOncePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedJ.checkRClockTwice(tet);
        WellFormedJ.checkRClockTwicePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedJ.checkRCounterOnce(tet);
        WellFormedJ.checkRCounterOncePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedJ.checkOrig(tet);
        WellFormedJ.checkOrigPos(tet, x, y);
    }

    @Test
    public void rotateCounterJ() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedJ.checkOrig(tet);
        WellFormedJ.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedJ.checkRCounterOnce(tet);
        WellFormedJ.checkRCounterOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedJ.checkRClockTwice(tet);
        WellFormedJ.checkRClockTwicePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedJ.checkRClockOnce(tet);
        WellFormedJ.checkRClockOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedJ.checkOrig(tet);
        WellFormedJ.checkOrigPos(tet, x, y);
    }

    @Test
    public void rotateClockL() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedL.checkOrig(tet);
        WellFormedL.checkOrigPos(tet, x, y);
        tet.rotateClockwise();
        WellFormedL.checkRClockOnce(tet);
        WellFormedL.checkRClockOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedL.checkRClockTwice(tet);
        WellFormedL.checkRClockTwicePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedL.checkRCounterOnce(tet);
        WellFormedL.checkRCounterOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedL.checkOrig(tet);
        WellFormedL.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateCounterL() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedL.checkOrig(tet);
        WellFormedL.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedL.checkRCounterOnce(tet);
        WellFormedL.checkRCounterOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedL.checkRClockTwice(tet);
        WellFormedL.checkRClockTwicePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedL.checkRClockOnce(tet);
        WellFormedL.checkRClockOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedL.checkOrig(tet);
        WellFormedL.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateClockO() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateCounterO() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedO.checkOrig(tet);
        WellFormedO.checkOrigPos(tet, x, y);
    }

    @Test
    public void rotateClockS() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedS.checkOrig(tet);
        WellFormedS.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedS.checkRClockOnce(tet);
        WellFormedS.checkRClockOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedS.checkRClockTwice(tet);
        WellFormedS.checkRClockTwicePos(tet, x, y);
        tet.rotateClockwise();
        WellFormedS.checkRCounterOnce(tet);
        WellFormedS.checkRCounterOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedS.checkOrig(tet);
        WellFormedS.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateCounterS() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedS.checkOrig(tet);
        WellFormedS.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedS.checkRCounterOnce(tet);
        WellFormedS.checkRCounterOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedS.checkRClockTwice(tet);
        WellFormedS.checkRClockTwicePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedS.checkRClockOnce(tet);
        WellFormedS.checkRClockOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedS.checkOrig(tet);
        WellFormedS.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateClockT() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        
        WellFormedT.checkOrig(tet);
        WellFormedT.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedT.checkRClockOnce(tet);
        WellFormedT.checkRClockOncePos(tet, x, y);


        tet.rotateClockwise();
        WellFormedT.checkRClockTwice(tet);
        WellFormedT.checkRClockTwicePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedT.checkRCounterOnce(tet);
        WellFormedT.checkRCounterOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedT.checkOrig(tet);
        WellFormedT.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateCounterT() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);

        WellFormedT.checkOrig(tet);
        WellFormedT.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedT.checkRCounterOnce(tet);
        WellFormedT.checkRCounterOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedT.checkRClockTwice(tet);
        WellFormedT.checkRClockTwicePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedT.checkRClockOnce(tet);
        WellFormedT.checkRClockOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedT.checkOrig(tet);
        WellFormedT.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateClockZ() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedZ.checkOrig(tet);
        WellFormedZ.checkOrigPos(tet, x, y);

        tet.rotateClockwise();
        WellFormedZ.checkRClockOnce(tet);
        WellFormedZ.checkRClockOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedZ.checkRClockTwice(tet);
        WellFormedZ.checkRClockTwicePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedZ.checkRCounterOnce(tet);
        WellFormedZ.checkRCounterOncePos(tet, x, y);

        tet.rotateClockwise();
        WellFormedZ.checkOrig(tet);
        WellFormedZ.checkOrigPos(tet, x, y);

    }

    @Test
    public void rotateCounterZ() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        int x = 5;
        int y = 5;
        tet.insertIntoGrid(x, y, tg);
        WellFormedZ.checkOrig(tet);
        WellFormedZ.checkOrigPos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedZ.checkRCounterOnce(tet);
        WellFormedZ.checkRCounterOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedZ.checkRClockTwice(tet);
        WellFormedZ.checkRClockTwicePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedZ.checkRClockOnce(tet);
        WellFormedZ.checkRClockOncePos(tet, x, y);

        tet.rotateCounterClockwise();
        WellFormedZ.checkOrig(tet);
        WellFormedZ.checkOrigPos(tet, x, y);
    }
}
