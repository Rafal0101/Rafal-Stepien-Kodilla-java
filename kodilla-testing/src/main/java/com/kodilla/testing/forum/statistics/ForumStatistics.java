package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsByUser = 0;
    private double averageCommentsByUser = 0;
    private double averageCommentsByPost = 0;

    public double getAveragePostsByUser() {
        return averagePostsByUser;
    }

    public double getAverageCommentsByUser() {
        return averageCommentsByUser;
    }

    public double getAverageCommentsByPost() {
        return averageCommentsByPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.userName().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if (usersQuantity > 0) {
            averagePostsByUser = postsQuantity / usersQuantity;
            averageCommentsByUser = commentsQuantity / usersQuantity;
        }
        if (postsQuantity > 0) {
            averageCommentsByPost = commentsQuantity / postsQuantity;
        }
    }
}
