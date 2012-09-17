package dao;

import java.io.Serializable;

public interface IDAO<T, PK extends Serializable> {

	PK create(T newInstance);

	T read(PK id);

	void update(T transientObject);

	void delete(T persistentObject);
}
