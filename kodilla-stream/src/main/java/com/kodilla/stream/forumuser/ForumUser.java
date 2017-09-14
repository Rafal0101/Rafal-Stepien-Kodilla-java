package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String userName;
    private final Sex sex;
    private final LocalDate birthDate;
    private final int postsQuantity;

    public ForumUser(final int id, final String userName, final Sex sex, final LocalDate birthDate, final int postsQuantity) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsQuantity = postsQuantity;
    }

    /*
    public ForumUser(final int id, final String userName, final char sex, final LocalDate birthDate, final int postsQuantity) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsQuantity = postsQuantity;
    }
*/

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsQuantity=" + postsQuantity +
                '}';
    }
}
