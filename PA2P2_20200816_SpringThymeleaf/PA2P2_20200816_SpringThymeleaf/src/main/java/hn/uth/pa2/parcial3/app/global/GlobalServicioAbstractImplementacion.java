package hn.uth.pa2.parcial3.app.global;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GlobalServicioAbstractImplementacion<T, ID extends Serializable> implements GlobalServicio<T, ID> {

	@Override
	public T guardar(T entity) {
		return getRepositorio().save(entity);
	}

	@Override
	public void eliminar(ID id) {
		getRepositorio().deleteById(id);
	}

	@Override
	public T getValor(ID id) {
		Optional<T> obj = getRepositorio().findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getTodos() {
		List<T> returnList = new ArrayList<>();
		getRepositorio().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getRepositorio();

}
