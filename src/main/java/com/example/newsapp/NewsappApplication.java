package com.example.newsapp;

import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class NewsappApplication {



	public static void main(String[] args) {
		SpringApplication.run(NewsappApplication.class, args);
	}

	public abstract void start(Stage primaryStage);
}
