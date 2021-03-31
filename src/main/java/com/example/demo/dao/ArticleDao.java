package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Article;
import com.example.demo.util.Util;

@Component
public class ArticleDao {
	
	private List<Article> articles;
	private int articleLastId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		articleLastId = 0;
		makeTestData();
	}

	private void makeTestData() {
		for (int i = 0; i < 11; i++) {
			writeArticle("제목"+i, "내용"+i);
		}
	}

	public int writeArticle(String title, String body) {
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}

	public boolean deleteArticle(Integer id) {
		Article article = getArticleById(id);

		if(article==null) return false;
		else {
			articles.remove(article);
			return true;
		}
	}

}
