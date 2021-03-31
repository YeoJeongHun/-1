package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;
import com.example.demo.dto.ResultData;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	public ResultData writeArticle(String title, String body) {
		int id = articleDao.writeArticle(title, body);
		
		return new ResultData("S-1","게시물이 작성되었습니다.","id",id);
	}
	
	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public ResultData DeleteArticle(Integer id) {
		if(articleDao.deleteArticle(id)) {
			return new ResultData("S-1","게시물이 삭제되었습니다.");
		}
		else return new ResultData("F-2","해당 게시물이 존재하지 않습니다.");
		
	}
}
