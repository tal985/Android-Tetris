package tetris.cs371m.tetris;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static tetris.cs371m.tetris.TestUtil.shiftDown;
import tetris.cs371m.tetris.TestUtil.DIRECTION;

/**
 * Created by zhitingz on 2/11/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ShiftDownUnitTest {

    @Test
    public void shiftDownI() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        // Normal
        shiftDown(tet, tg, 5, 5, 5, 6, 1, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownIBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        shiftDown(tet, tg, 5, 16, 5, 18, 3, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownIBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        shiftDown(tet, tg, 5, 16, 5, 16, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownIBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        shiftDown(tet, tg, 5, 16, 5, 17, 2, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownIBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        shiftDown(tet, tg, 5, 16, 5, 16, 1, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownJ() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        shiftDown(tet, tg, 5, 5, 5, 6, 1, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownJBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownJBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownJBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        shiftDown(tet, tg, 5, 17, 5, 17, 2, 2,
                DIRECTION.CLOCK);
    }
    @Test
    public void shiftDownJBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownL() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        shiftDown(tet, tg, 5, 5, 5, 6,1, 0, DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownLBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownLBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownLBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        shiftDown(tet, tg, 5, 17, 5, 17, 2, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownLBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownO() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        shiftDown(tet, tg, 5, 5, 5, 6,1, 0, DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownOBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownOBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownOBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownOBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownS() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        shiftDown(tet, tg, 5, 5, 5, 6,1, 0, DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownSBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownSBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownSBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownSBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownT() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();

        shiftDown(tet, tg, 5, 5, 5, 6,1, 0, DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownTBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownTBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownTBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownTBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.COUNTER);
    }

    @Test
    public void shiftDownZ() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        shiftDown(tet, tg, 5, 5, 5, 6,1, 0, DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownZBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        shiftDown(tet, tg, 5, 17, 5, 18, 2, 0,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownZBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownZBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 2,
                DIRECTION.CLOCK);
    }

    @Test
    public void shiftDownZBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        shiftDown(tet, tg, 5, 17, 5, 17, 1, 1,
                DIRECTION.COUNTER);
    }
}
