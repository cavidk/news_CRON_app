package com.example.newsapp.service;

import com.example.newsapp.model.News;
import com.example.newsapp.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNews(LocalDateTime start, LocalDateTime end) {
        return newsRepository.findByPublicationTimeBetween(start, end);
    }

    public void saveNews(News news) {
        newsRepository.save(news);
    }

    public void deleteOldNews() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        newsRepository.deleteByPublicationTimeBefore(yesterday);
    }

}
