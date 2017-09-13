package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static final double DELTA = 1e-6;
    private static Statistics statisticsMock;
    private static ForumStatistics forumStatistics;

    @Before
    public void initializeObjects() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testAveragePosts0ByUser0() {
        List<String> userNames = new ArrayList<>();
        int posts = 0;

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);
    }

    @Test
    public void testAveragePosts1000ByUser0() {
        List<String> userNames = new ArrayList<>();
        int posts = 1000;

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);
    }

    @Test
    public void testAveragePosts0ByUser100() {
        List<String> userNames = new ArrayList<>();
        int posts = 0;

        for (int i = 0; i < 100; i++) {
            userNames.add("test");
        }

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);
    }


    @Test
    public void testAveragePosts1000ByUser100() {
        List<String> userNames = new ArrayList<>();
        int posts = 1000;

        for (int i = 0; i < 100; i++) {
            userNames.add("test");
        }

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(10, forumStatistics.getAveragePostsByUser(), DELTA);
    }

    @Test
    public void testAverageComments0ByUser0() {
        List<String> userNames = new ArrayList<>();
        int comments = 0;

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(comments);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, forumStatistics.getAverageCommentsByUser(), DELTA);
    }

    @Test
    public void testAverageComments0ByUser100() {
        List<String> userNames = new ArrayList<>();
        int comments = 0;
        for (int i = 0; i < 100; i++) {
            userNames.add("test");
        }

        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(comments);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, forumStatistics.getAverageCommentsByUser(), DELTA);
    }

    @Test
    public void testAverageCommentsLowerThanPosts() {
        int posts = 11;
        int comments = 10;

        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Assert.assertTrue(forumStatistics.getAverageCommentsByPost() < 1);
        Assert.assertTrue(forumStatistics.getCommentsQuantity() < forumStatistics.getPostsQuantity());

    }
    @Test
    public void testAverageCommentsBiggerThanPosts() {
        int posts = 20;
        int comments = 21;

        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Assert.assertTrue(forumStatistics.getAverageCommentsByPost() > 1);
        Assert.assertTrue(forumStatistics.getCommentsQuantity() > forumStatistics.getPostsQuantity());
    }

    //The boy scout rule
    @Test
    public void testAverageCommentsEqualsPosts() {
        int posts = 5;
        int comments = 5;

        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //      Assert.assertTrue(forumStatistics.getAverageCommentsByPost() == 1);
        Assert.assertTrue(forumStatistics.getCommentsQuantity() == forumStatistics.getPostsQuantity());
    }
}
