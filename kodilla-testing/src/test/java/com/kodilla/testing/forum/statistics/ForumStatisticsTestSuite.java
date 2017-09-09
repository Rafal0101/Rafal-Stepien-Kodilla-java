package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static final double DELTA = 1e-6;

    @Test
    public void testAveragePostsByUser() {
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> userNames = new ArrayList<>();
        int posts = 0;

        //Case 1: posts:0, users:0
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);

        //Case 2: posts:1000, users:0
        posts = 1000;
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);

        //Case 2: posts:0, users:100
        posts = 0;
        for (int i = 0; i < 100; i++) {
            userNames.add("test");
        }
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(0, forumStatistics.getAveragePostsByUser(), DELTA);

        //Case 2: posts:1000, users:100
        posts = 1000;
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(10, forumStatistics.getAveragePostsByUser(), DELTA);
    }

    @Test
    public void testAverageCommentsByUser() {
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> userNames = new ArrayList<>();
        int comments = 0;

        //Case 1: comments:0, users:0
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.commentsCount()).thenReturn(comments);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(0, forumStatistics.getAverageCommentsByUser(), DELTA);

        //Case 2: comments:0, users:100
        for (int i = 0; i < 100; i++) {
            userNames.add("test");
        }
        when(statisticsMock.userName()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(comments);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertEquals(0, forumStatistics.getAverageCommentsByUser(), DELTA);
    }

    @Test
    public void testAverageCommentsByPost() {
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        int posts = 11;
        int comments = 10;

        //Case 1: comments < posts
        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertTrue(forumStatistics.getAverageCommentsByPost() < 1);

        //Case 2: comments > posts
        posts = 20;
        comments = 21;
        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertTrue(forumStatistics.getAverageCommentsByPost() > 1);

        //The boy scout rule Case 3: comments == posts
        posts = 5;
        comments = 5;
        when(statisticsMock.commentsCount()).thenReturn(comments);
        when(statisticsMock.postsCount()).thenReturn(posts);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        Assert.assertTrue(forumStatistics.getAverageCommentsByPost() == 1);
    }
}
