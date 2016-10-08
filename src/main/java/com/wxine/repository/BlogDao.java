package com.wxine.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wxine.domain.Blog;

@Component
@Transactional
public class BlogDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public void insert(Blog blog) {
		getSession().save(blog);
	}
	public void merge(Blog blog) {
		getSession().update(blog);
	}
	public void delete(Blog blog) {
		getSession().delete(blog);
	}
	
	public Blog findById(String id) {
		Blog blog = (Blog)getSession().get(Blog.class, id);
		return blog;
	}
	
	public List<Blog> findAll() {
		List<Blog> blog =  getSession().createCriteria(Blog.class).list();
		return blog;
	}

}
