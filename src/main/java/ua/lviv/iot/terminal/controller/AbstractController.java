package ua.lviv.iot.terminal.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.lviv.iot.terminal.service.Service;

public abstract class AbstractController<T> {
  protected final Service<T> service;

  public AbstractController(Service<T> service) {
    this.service = service;
  }

  @GetMapping
  public List<T> getAllObjects() {
    return service.getAllObjects();
  }

  @GetMapping("/{id}")
  public ResponseEntity<T> getObject(@PathVariable final Integer id) {
    T foundObject = service.getObjectById(id);
    return foundObject == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(foundObject, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public T createObject(@RequestBody final T object) {
    return service.createObject(object);
  }

  @PutMapping("/{id}")
  public abstract ResponseEntity<T> updateObject(@PathVariable final Integer id,
                                                 @RequestBody final T city);

  @DeleteMapping("/{id}")
  public ResponseEntity<T> deleteObject(@PathVariable final Integer id) {
    HttpStatus status = service.deleteObject(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(status);
  }
}
