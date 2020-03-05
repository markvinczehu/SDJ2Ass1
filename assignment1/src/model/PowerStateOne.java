package model;

import model.Radiator;
import model.RadiatorState;
import org.w3c.dom.CDATASection;

public class PowerStateOne implements RadiatorState
{
  private int POWER = 1;

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
}
