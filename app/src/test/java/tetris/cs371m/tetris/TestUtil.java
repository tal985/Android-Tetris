package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class TestUtil {

    public enum DIRECTION {
        CLOCK,
        COUNTER,
    }
    
    public enum MOTION {
        SHIFT_RIGHT,
        SHIFT_LEFT,
        SHIFT_DOWN,
    }

    public static void shiftDown(Tetromino tet, TGrid parent, int initialX, int initialY,
                                 int expectedX, int expectedY, int numMotion,
                                 int numRotate, DIRECTION dir) throws Exception {
        shift(tet, parent, initialX, initialY, expectedX, expectedY, numMotion, MOTION.SHIFT_DOWN,
                numRotate, dir);
    }

    public static void shiftRight(Tetromino tet, TGrid parent, int initialX, int initialY,
                                 int expectedX, int expectedY, int numMotion, int numRotate,
                                 DIRECTION dir) throws Exception {
        shift(tet, parent, initialX, initialY, expectedX, expectedY, numMotion, MOTION.SHIFT_RIGHT,
                numRotate, dir);
    }

    public static void shiftLeft(Tetromino tet, TGrid parent, int initialX, int initialY,
                                  int expectedX, int expectedY, int numMotion, int numRotate,
                                  DIRECTION dir) throws Exception {
        shift(tet, parent, initialX, initialY, expectedX, expectedY, numMotion, MOTION.SHIFT_LEFT,
                numRotate, dir);
    }

    private static void shift(Tetromino tet, TGrid parent, int initialX, int initialY,
                           int expectedX, int expectedY, int numMotion, MOTION motion, int numRotate,
                           DIRECTION dir) throws Exception {
        tet.insertIntoGrid(initialX, initialY, parent);
        if (numRotate > 0) {
            for (int i = 0; i < numRotate; i++) {
                if (dir == DIRECTION.CLOCK) {
                    tet.rotateClockwise();
                } else if (dir == DIRECTION.COUNTER){
                    tet.rotateCounterClockwise();
                }
            }
        }
        if (numMotion > 0) {
            for (int i = 0; i < numMotion; i++)
                switch (motion) {
                    case SHIFT_DOWN:
                        tet.shiftDown();
                        break;
                    case SHIFT_LEFT:
                        tet.shiftLeft();
                        break;
                    case SHIFT_RIGHT:
                        tet.shiftRight();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid motion code: " + motion);
                }
        }
        assertEquals(expectedX, tet.xPos);
        assertEquals(expectedY, tet.yPos);
        tet.removeFromGrid();
    }


}
