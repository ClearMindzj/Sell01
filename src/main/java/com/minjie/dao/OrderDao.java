package com.minjie.dao;

import com.minjie.domain.Order;


import java.util.List;

public interface OrderDao {

	void add(Order order);

	Order find(String id);

	List<Order> getAll(boolean state);

	void update(Order order);

	List<Order> getAll(boolean state, String userid);

	List<Order> getAllOrder(String userid);

}