package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    public void testAddComment() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");
        forumUser.addComment(forumPost, "mrsmith", "Thank you for all good words!");
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    public void testGetPost() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");
        forumUser.addPost(forumPost.getPostBody(), forumPost.getAuthor());
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);
        Assert.assertEquals(forumPost, retrievedPost);
    }

    @Test
    public void testGetComment() {
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(forumPost, "Thank you for all good words!", "mrsmith");
        forumUser.addComment(forumPost, theComment.getCommentBody(), theComment.getAuthor());
        ForumComment retrievedComment = forumUser.getComment(0);
        Assert.assertEquals(theComment, retrievedComment);
    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        boolean result = forumUser.removePost(thePost);
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        forumUser.addPost(forumPost.getPostBody(), forumPost.getAuthor());

        //When
        boolean result = forumUser.removePost(forumPost);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!",
                "mrsmith");
        forumUser.addComment(thePost, theComment.getCommentBody(), theComment.getAuthor());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }
}
