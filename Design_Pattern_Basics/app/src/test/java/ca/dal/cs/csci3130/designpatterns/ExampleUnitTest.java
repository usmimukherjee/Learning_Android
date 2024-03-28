package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.antipattern.AntiPatternChild;
import ca.dal.cs.csci3130.designpatterns.antipattern.AntiPatternParent;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testAntiPatterns(){
        //new AntiPatternParent();
        new AntiPatternChild();
    }

}