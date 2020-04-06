package com.minjie.dao;

import com.minjie.domain.Book;


import java.util.List;

public interface BookDao {

	void add(Book book);

	Book find(String id);
	
	public List<Book> getPageData(int startindex, int pagesize);
	
	public int getTotalRecord();

	public List<Book> getPageData(int startindex, int pagesize, String category_id);
	
	public int getTotalRecord(String category_id);

}