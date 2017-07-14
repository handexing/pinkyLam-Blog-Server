package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.Article;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet rs, int index) throws SQLException {
		Article article = new Article();
		article.setId(rs.getLong("ID"));
		article.setTitle(rs.getString("TITLE"));
		article.setSubtitle(rs.getString("SUBTITLE"));
		article.setContent(rs.getString("CONTENT"));
		article.setStatus(rs.getInt("STATUS"));
		article.setHits(rs.getInt("HITS"));
		article.setAuthorId(rs.getLong("AUTHOR_ID"));
		article.setCreateTime(rs.getTimestamp("CREATE_TIME"));
		article.setUpdateTime(rs.getTimestamp("UPDATE_TIME"));
		return article;
	}
}