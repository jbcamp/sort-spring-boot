package carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by jonathancampbell on 10/7/14.
 */
@RestController
@RequestMapping("/car")
public class CarRestController {

  private CarRepository carRepository;
  private CrudRepository<Car, Long> crudRepository;

  @Value("${car.default.color}")
  private String defaultColor;

  @Autowired
  CarRestController(CrudRepository<Car, Long> crudRepository) {
    this.crudRepository = crudRepository;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Car getCar(@PathVariable Long id) throws CarDoesNotExistException {
    Car car = crudRepository.findOne(id);
    if (car == null) {
      throw new CarDoesNotExistException(id);
    }
    car.add(linkTo(methodOn(CarRestController.class).getCar(car.getCarId())).withSelfRel());

    return car;

  }


  @RequestMapping(method = RequestMethod.POST, value="")
  @ResponseStatus(HttpStatus.CREATED)
  public HttpHeaders createCar(@RequestBody Car car){
    //if (car.getColor() == null) {
    //  car.setColor(defaultColor);
    //}
    this.crudRepository.save(car);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(linkTo(CarRestController.class).slash(car.getCarId()).toUri());
    return headers;
  }



}
