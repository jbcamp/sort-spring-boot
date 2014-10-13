package carservice;

/**
 * Created by jonathancampbell on 10/7/14.
 */
public class Car {


  private String make;
  private String model;
  private long year;

  public Car (String make, String model, long year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

}
