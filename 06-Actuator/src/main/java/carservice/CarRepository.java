package carservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jonathancampbell on 10/7/14.
 */
public interface CarRepository extends CrudRepository<Car, Long  > {

  List<Car> findByMake(String make);

}