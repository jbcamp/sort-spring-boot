package carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarRestController {

  private CarRepository carRepository;

  @Value("${car.default.color}")
  private String defaultColor;

  @Autowired
  CarRestController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Car getCar(@PathVariable Long id) throws CarDoesNotExistException {
    Car car = carRepository.findOne(id);
    if (car == null) {
      throw new CarDoesNotExistException(id);
    }
    return car;
  }

  @RequestMapping(method = RequestMethod.GET, value = "")
  @ResponseStatus(HttpStatus.OK)
  public List<Car> getMatchingCars(@RequestParam(value="make") String make) {
    return carRepository.findByMake(make);
  }


  @RequestMapping(method = RequestMethod.POST, value="")
  @ResponseStatus(HttpStatus.CREATED)
  public void createCar(@RequestBody Car car){
    if (car.getColor() == null) {
      car.setColor(defaultColor);
    }
    this.carRepository.save(car);
  }



}
