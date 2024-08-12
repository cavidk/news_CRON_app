package com.example.newsapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsViewerApp extends Application {
    private List<String> newsList = new ArrayList<>(Arrays.asList("News 1", "News 2", "News 3"));
    private int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Label headlineLabel = new Label();
        Label descriptionLabel = new Label("This is the description");

        Button prevButton = new Button("<");
        prevButton.setOnAction(e -> showPreviousNews(headlineLabel));

        Button nextButton = new Button(">");
        nextButton.setOnAction(e -> showNextNews(headlineLabel));

        HBox navigationBox = new HBox(10, prevButton, nextButton);
        VBox newsBox = new VBox(10, headlineLabel, descriptionLabel);

        root.setCenter(newsBox);
        root.setBottom(navigationBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("News Viewer");
        primaryStage.show();

        showNews(headlineLabel);
    }

    private void showNews(Label headlineLabel) {
        if (!newsList.isEmpty()) {
            String currentNews = newsList.get(currentIndex);
            headlineLabel.setText(currentNews);
        }
    }

    private void showPreviousNews(Label headlineLabel) {
        if (currentIndex > 0) {
            currentIndex--;
            showNews(headlineLabel);
        }
    }

    private void showNextNews(Label headlineLabel) {
        if (currentIndex < newsList.size() - 1) {
            currentIndex++;
            showNews(headlineLabel);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
