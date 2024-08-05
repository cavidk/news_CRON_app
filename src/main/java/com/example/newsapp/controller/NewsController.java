package com.example.newsapp.controller;


import com.example.newsapp.model.News;
import com.example.newsapp.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getNews(@RequestParam String period) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start, end;

        switch (period) {
            case "morning":
                start = now.withHour(6).withMinute(0);
                end = now.withHour(12).withMinute(0);
                break;
            case "day":
                start = now.withHour(12).withMinute(0);
                end = now.withHour(18).withMinute(0);
                break;
            case "evening":
                start = now.withHour(18).withMinute(0);
                end = now.withHour(24).withMinute(0);
                break;
            default:
                start = now.withHour(0).withMinute(0);
                end = now.withHour(23).withMinute(59);
        }

        return newsService.getNews(start, end);
    }
}

