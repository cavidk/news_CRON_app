package com.example.newsapp.service;

import com.example.newsapp.model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsParsingService {

    private final NewsService newsService;

    public NewsParsingService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void parseNews() {
        List<News> parsedNews = parseNewsFromWebsite();
        parsedNews.forEach(newsService::saveNews);
        newsService.deleteOldNews();
    }

    private List<News> parseNewsFromWebsite() {
        List<News> newsList = new ArrayList<>();
        try {
            // Connect to the news website (replace with the actual URL)
            Document doc = Jsoup.connect("https://example-news-website.com").get();
            // Select elements containing news articles
            Elements articles = doc.select(".article"); // Adjust the CSS selector based on the website's structure

            for (Element article : articles) {
                try {
                    String headline = article.select(".headline").text(); // Adjust the CSS selector based on the website's structure
                    String description = article.select(".description").text(); // Adjust the CSS selector based on the website's structure
                    String timeString = article.select(".time").text(); // Adjust the CSS selector based on the website's structure

                    // Parse the publication time (adjust the format based on the website's date format)
                    LocalDateTime publicationTime = LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    News news = new News();
                    news.setHeadline(headline);
                    news.setDescription(description);
                    news.setPublicationTime(publicationTime);

                    newsList.add(news);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error parsing news article: " + article);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsList;
    }

}
