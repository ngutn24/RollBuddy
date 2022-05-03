package test.java;

import main.java.CharacterSession;
import org.junit.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CharacterSessionTest {
    private static CharacterSession session;

    @DataPoints("Session IDs")
    public static int[] ids = new int[] {0, 1, 123, 456, 25698721, 999999999};

    @Before
    public void Setup(){
        session = new CharacterSession(12345);
    }

    @Theory
    public void TestSessionID(@FromDataPoints("Session IDs") int ID){
        System.out.println("Testing Session ID: " + ID);
        CharacterSession session = new CharacterSession(ID);
        assert(session.getSessionID() == ID);
        System.out.println("SESSION ID TEST PASSED");
    }

    //TODO: This test will need to be updated when generateCharacter() is fully implemented
    @Test
    public void testSessionUpdateTime(){
        System.out.println("Testing Session Update Time");
        String preTime = session.getLastUpdated();
        session.generateCharacter("MEEP");
        String postTime = session.getLastUpdated();
        assert(!preTime.equals(postTime));
        System.out.println("SESSION UPDATE TIME TEST PASSED");
    }

}
