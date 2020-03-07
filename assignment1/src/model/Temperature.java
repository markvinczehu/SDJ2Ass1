package model;

public class Temperature
{
  private String id;
  private double value;
  private DateTime time;
  private Radiator radiator;

  public Temperature(String id, double value)
  {
    this.id = id;
    this.value = value;
    time = new DateTime();
  }
  public Temperature()
  {
    this.id = "id1";
    this.value = 0;
    time = new DateTime();
  }
  public Temperature(double value)
  {
    this.id = "id2";
    this.value = 0;
    time = new DateTime();
  }
  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;
  }

  public String getId() {
    return id;
  }
  public DateTime getTime()
  {
    return time;
  }
  public String toString()
  {
    return String.format("%s: %.1f (%s)", id, value, time.getTimestamp());
  }
}
