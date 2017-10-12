package com.kodilla.patterns.patterns.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUsers = new ArrayList<>();

    public Forum() {
        theForumUsers.add(new ForumUser(1, "Adam", Sex.M, LocalDate.of(1990, 1, 1), 100));
        theForumUsers.add(new ForumUser(2, "Sarah", Sex.F, LocalDate.of(1995, 5, 2), 200));
        theForumUsers.add(new ForumUser(3, "John", Sex.M, LocalDate.of(1980, 9, 22), 0));
        theForumUsers.add(new ForumUser(4, "Clair", Sex.F, LocalDate.of(2001, 11, 26), 400));
        theForumUsers.add(new ForumUser(5, "Chris", Sex.M, LocalDate.of(1997, 9, 13), 1));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theForumUsers);
    }
}
