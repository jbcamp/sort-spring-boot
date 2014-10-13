package carservice;

public class Car {

  private String make;
  private String model;
  private String color;
  private long year;

  public Car (String make, String model, long year, String color) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;

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

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
