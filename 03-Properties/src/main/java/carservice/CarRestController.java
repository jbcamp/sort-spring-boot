package carservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonathancampbell on 10/7/14.
 */
@RestController
public class CarRestController {

  @Value("${car.default.color}")
  private String defaultColor;

  @RequestMapping(value="", method=RequestMethod.GET)
  public Car basicGet(){
    return new Car("Honda", "Accord", 2009, defaultColor);
  }

}
