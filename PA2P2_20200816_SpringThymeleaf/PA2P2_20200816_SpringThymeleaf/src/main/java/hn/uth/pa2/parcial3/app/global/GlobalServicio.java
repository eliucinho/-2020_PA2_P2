package hn.uth.pa2.parcial3.app.global;

import java.io.Serializable;
import java.util.List;

public interface GlobalServicio<T, ID extends Serializable> {

	T guardar(T entity);
	
	void eliminar(ID id);
	
	T getValor(ID id);
	
	List<T> getTodos();
}
