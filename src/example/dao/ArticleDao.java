package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.dto.Article;

public class ArticleDao extends Dao {
	private List<Article> articles; // 필드 (articles는 인스턴스 변수)

	public ArticleDao() {
		this.articles = new ArrayList<>();
	}

	public void doWrite(Article article) {
		this.articles.add(article);
		this.lastId ++;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void doModify(Article foundArticle, String title, String body) {
		foundArticle.title = title;
		foundArticle.body = body;
	}

	public void doDelete(Article foundArticle) {
		this.articles.remove(foundArticle);
	}

	public Article getArticleById(int id) {

		for (Article article : this.articles) {
			if (article.id == id) {
				return article;
			}
		}
		return null;
	}

}
