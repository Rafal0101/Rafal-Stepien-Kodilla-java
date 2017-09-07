package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
    private LinkedList<ForumComment> comments = new LinkedList<ForumComment>();


    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String postBody, String author){
        ForumPost forumPost = new ForumPost(postBody, author);
        posts.add(forumPost);
    }

    public void addComment(ForumPost forumPost, String commentBody, String author){

        ForumComment forumComment = new ForumComment(forumPost, commentBody, author);
        comments.add(forumComment);
    }

    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentsQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost forumPost = null;
        if (postNumber >= 0 && postNumber < posts.size()) {
            forumPost = posts.get(postNumber);
        }
        return forumPost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment forumComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            forumComment = comments.get(commentNumber);
        }
        return forumComment;
    }

    public boolean removePost(ForumPost forumPost){
        boolean result = false;
        if (posts.contains(forumPost)) {
            posts.remove(forumPost);
            result =  true;
        }
        return result;
    }

    public boolean removeComment(ForumComment forumComment){
        boolean result = false;
        if (comments.contains(forumComment)) {
            comments.remove(forumComment);
            result =  true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
