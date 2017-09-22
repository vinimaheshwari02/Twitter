import com.Tweet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class TweetClassTest {

    @Test
    public void checkTweet(){
        Tweet t=mock(Tweet.class);

        when(t.getLid()).thenReturn((long) 1);
        assertEquals(t.getLid(),1);

        when(t.getTweeter()).thenReturn("hey");
        assertEquals(t.getTweeter(),"hey");

        when(t.getDislikee()).thenReturn(1);
        assertEquals(t.getDislikee(),1);
    }
}
