package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.dto.ResultData;
import com.example.demo.service.ArticleService;
import com.example.demo.util.Util;

@Controller
public class MpaUsrArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {
		if(Util.isEmpty(body)) {
			return new ResultData("F-1","내용을 입력해주세요.");
		}
		if(Util.isEmpty(title)) {
			return new ResultData("F-2","제목을 입력해주세요.");
		}
		
		return articleService.writeArticle(title,body);
	}
	
	@RequestMapping("/mpaUsr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(Integer id) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", id + "번 글은 존재하지 않습니다.", "id", id);
		}

		return new ResultData("S-1", article.getId() + "번 글 입니다.", "article", article);
	}
	
	@RequestMapping("/mpaUsr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(Integer id) {
		if(Util.isEmpty(id)) {
			return new ResultData("F-1","id값을 입력해주세요.");
		}

		Article article = articleService.getArticleById(id);
		if (article == null) {
			return new ResultData("F-1", id + "번 글은 존재하지 않습니다.", "id", id);
		}
		
		return articleService.DeleteArticle(id);
	}
	
}











