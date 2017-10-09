package com.kodilla.spring.portfolio;


import org.springframework.context.annotation.Bean;

public class BoardConfig {
    @Bean
    public Board createBoard() {
        return new Board(createToDoTask(), createInProgressTask(), createDoneTask());
    }

    @Bean
    public TaskList createToDoTask() {
        return new TaskList();
    }

    @Bean
    public TaskList createInProgressTask() {
        return new TaskList();
    }

    @Bean
    public TaskList createDoneTask() {
        return new TaskList();
    }

}
