package com.minjie.dao;

import com.minjie.domain.Category;


import java.util.List;

public interface CategoryDao {

	public abstract void add(Category category);

	public abstract Category find(String id);

	public abstract List<Category> getAll();

	public abstract void delete(String id);

	public abstract void update(String id, String name, String description);

}