package model;

import model.Radiator;
import model.RadiatorState;
import org.w3c.dom.CDATASection;

public class PowerStateOne implements RadiatorState
{
  private int POWER = 1;
  private Temperature temperature;

  public PowerStateOne()
  {
    temperature = new Temperature(20);
  }

  @Override public void onButtonUp(Radiator radiator)
  {
    radiator.setPowerState(new PowerStateTwo());
  }

  @Override public void onButtonDown(Radiator radiator)
  {
    radiator.setPowerState(new OffState());
  }

  @Override public int getPower()
  {
    return POWER;
  }
  public Temperature temperature()
  {
    return temperature;
  }
}
