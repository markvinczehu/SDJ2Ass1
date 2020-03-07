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
  public double getValue()
  {
    return value;
  }
  public double changeValue()
  {
    if(radiator.currentState().equals(new OffState()))
    {
      value = 0;
    }
    else if(radiator.currentState().equals(new PowerStateOne()))
    {
      value = 20;
    }
    else if(radiator.currentState().equals(new PowerStateTwo()))
    {
      value = 30;
    }
    else if(radiator.currentState().equals(new PowerStateThree(radiator)))
    {
      value = 50;
    }
    return value;
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
