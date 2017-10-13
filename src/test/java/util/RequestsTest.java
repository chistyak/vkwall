package util;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class RequestsTest {
    int userId;
    int lastPostId;
    String lastPostText;

    @org.junit.Test
    public void getLastPostId() throws Exception {
        int postIdTest = Requests.getLastPostId(userId);
        Assert.assertEquals(postIdTest, lastPostId);
    }

    @org.junit.Test
    public void getLastPostText() throws Exception {
        String postTextTest = Requests.getLastPostText(userId);
        Assert.assertEquals(postTextTest, lastPostText);
    }

    @Before
    public void setUp() throws Exception {
        userId = 34662135;
        lastPostId = 3669;
        lastPostText = "двапеченья";
    }
}