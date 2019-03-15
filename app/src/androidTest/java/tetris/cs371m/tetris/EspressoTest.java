package tetris.cs371m.tetris;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by zhitingz on 2/10/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {
    private static final short RIGHT = 0;
    private static final short LEFT = 1;
    private static final short DOWN = 2;
    private static final short RCOUNTER = 3;
    private static final short RCLOCK = 4;
    private static final short RESET = 5;
    private List<Short> level2, level3, lose;

    private ViewInteraction
            left_button, roll_counter_button, down_button,
            rotate_clock_button, right_button, reset_button,
            level, score, cleared;

    private List<Short> readCommands(String fileName) throws IOException {
        Context context = InstrumentationRegistry.getContext();
        InputStream testInput = context.getAssets().open(fileName);
        List<Short> commands = new ArrayList<Short>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(testInput));
        String line;
        while ((line = reader.readLine()) != null) {
            switch (line) {
                case "right":
                    commands.add(RIGHT);
                    break;
                case "left":
                    commands.add(LEFT);
                    break;
                case "down":
                    commands.add(DOWN);
                    break;
                case "rcounter":
                    commands.add(RCOUNTER);
                    break;
                case "rclock":
                    commands.add(RCLOCK);
                    break;
                case "reset":
                    commands.add(RESET);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command");
            }
        }
        return commands;
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void prepareCommands() throws Exception {
        level2 = readCommands("level2.txt");
        level3 = readCommands("level3.txt");
        lose = readCommands("lose.txt");

        left_button = onView(withId(R.id.leftButton));
        roll_counter_button = onView(withId(R.id.ccwButton));
        down_button = onView(withId(R.id.downButton));
        rotate_clock_button = onView(withId(R.id.cwButton));
        right_button = onView(withId(R.id.rightButton));
        reset_button = onView(withId(R.id.resetButton));
        level = onView(withId(R.id.levelboard));
        score = onView(withId(R.id.scoreboard));
        cleared = onView(withId(R.id.rowboard));
    }

    @Test
    public void runToLevel2() throws Exception {
        for (int i = 0; i < level2.size(); i++) {
            clickButton(level2.get(i));
            SystemClock.sleep(1000);
        }

        level.check(matches(withText("2")));
        score.check(matches(withText("7")));
        cleared.check(matches(withText("6")));
    }

    @Test
    public void runToLevel3() throws Exception {
        for (int i = 0; i < level3.size(); i++) {
            clickButton(level3.get(i));
            SystemClock.sleep(1000);
        }
        level.check(matches(withText("3")));
        score.check(matches(withText("24")));
        cleared.check(matches(withText("13")));
    }

    @Test
    public void lose() throws Exception {
        for (int i = 0; i < lose.size(); i++) {
            clickButton(lose.get(i));
            SystemClock.sleep(1000);
        }
        level.check(matches(withText("1")));
        score.check(matches(withText("0")));
        cleared.check(matches(withText("0")));
        onView(withText(R.string.lose)).inRoot(withDecorView(not(mActivityRule.getActivity()
                .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    private void clickButton(short button) throws Exception {
        switch (button) {
            case RIGHT:
                right_button.perform(click());
                break;
            case LEFT:
                left_button.perform(click());
                break;
            case DOWN:
                down_button.perform(click());
                SystemClock.sleep(2000);
                break;
            case RCOUNTER:
                roll_counter_button.perform(click());
                break;
            case RCLOCK:
                rotate_clock_button.perform(click());
                break;
            case RESET:
                reset_button.perform(click());
                break;
            default:
                throw new Exception("Invalid code");
        }
    }
}
