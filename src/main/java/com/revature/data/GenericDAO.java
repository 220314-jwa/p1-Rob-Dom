package com.revature.data;

import java.sql.SQLException;
import java.util.List;

import com.revature.trms.Event;

public interface GenericDAO <T> {
	// CRUD methods: create, read, update, delete
	public int create(T newObj) throws SQLException; // returns the generated ID
	public T getById(int id); // read one
	public List<T> getAll(); // read all
	public void update(T updatedObj);
	public void delete(T objToDelete);
	// new method that deletes an object by just an id
	public void deleteById(int id);
	int create(Event newObj);
}
