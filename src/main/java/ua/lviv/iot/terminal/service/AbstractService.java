package ua.lviv.iot.terminal.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> implements Service<T> {
  private final JpaRepository<T, Integer> repository;

  public AbstractService(JpaRepository<T, Integer> repository) {
    this.repository = repository;
  }

  public List<T> getAllObjects() {
    return repository.findAll();
  }

  public T getObjectById(Integer id) {
    return repository.findById(id).orElse(null);
  }

  public T createObject(T object) {
    return repository.saveAndFlush(object);
  }

  public T updateObject(Integer id, T object, T oldObject) {
    T foundObject = repository.findById(id).orElse(null);
    if (foundObject != null) {
      BeanUtils.copyProperties(foundObject, oldObject);
      repository.saveAndFlush(object);
    } else {
      oldObject = null;
    }
    return oldObject;
  }

  public boolean deleteObject(Integer id) {
    try {
      repository.deleteById(id);
      return true;
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
  }
}
