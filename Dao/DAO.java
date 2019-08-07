package com.Anderson.LMS.Dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	
	List<T> getAll() throws IOException;
	void Update(T t) throws IOException;

}
