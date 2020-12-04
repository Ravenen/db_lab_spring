package ua.lviv.iot.terminal.service;

import java.util.List;

public interface Service<T> {
  List<T> getAllObjects();

  T getObjectById(Integer id);

  T createObject(T object);

  T updateObject(Integer id, T object, T oldObject);

  boolean deleteObject(Integer id);
}
