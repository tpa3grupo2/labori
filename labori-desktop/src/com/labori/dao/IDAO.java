package com.labori.dao;

import java.io.Serializable;

public interface IDAO<T, PK extends Serializable> {
	//T será o objeto a ser persistido, as Entities
	//PK será a chave primária, geralmente Integer
	
	PK create(T newInstance);
	T read(PK id);
	void update(T transientObject);
	void delete(T persistentObject);
	
}
