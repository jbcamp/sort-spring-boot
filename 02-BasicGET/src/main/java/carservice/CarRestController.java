package carservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class CarRestController {

  @RequestMapping(value="")
  public Car basicGet(){
    return new Car("Honda", "Accord", 2009);
  }

}
