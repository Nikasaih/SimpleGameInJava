package com.example.firstcourse;

import com.example.firstcourse.tp1.service.Game;

import java.io.IOException;

public class HelloApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.play();
    }

}