package com.wxine;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxine.domain.Blog;
import com.wxine.repository.BlogDao;

@Controller
public class IndexController {
	@Resource
	private BlogDao blogDao;
	
	@RequestMapping("/")
	public String Index(Model m) {
		List<Blog> blog = blogDao.findAll();
		m.addAttribute("blog", blog);
		return "index";
	}
	
	@RequestMapping("/insertblog")
	public String InsertBlog(String title, String blogcontent) {
		Blog blog = new Blog();
		blog.setId(UUID.randomUUID().toString().replace("-", ""));
		blog.setTitle(title);
		blog.setBlogcontent(blogcontent);
		blog.setCtime(new Timestamp(System.currentTimeMillis()));
		blogDao.insert(blog);
		return "success";
	}
	
	@RequestMapping("/updateblog")
	public String UpdateBlog(String id, String title, String blogcontent) {
		Blog blog =  blogDao.findById(id);
		blog.setTitle(title);
		blog.setBlogcontent(blogcontent);
		blogDao.merge(blog);
		return "success";
		
	}
	
	@RequestMapping("/deleteblog")
	public String DeleteBlog(String id) {
		Blog blog = blogDao.findById(id);
		blogDao.delete(blog);
		return "success";
	}
	
	@RequestMapping("/insertcontroller")
	public String InsertController() {
		return "insertblog";
	}
	
	@RequestMapping("/updatecontroller")
	public String UpdateController(Model m, String id) {
		Blog blog = blogDao.findById(id);
		m.addAttribute("blog", blog);
		return "updateblog";
	}
}
