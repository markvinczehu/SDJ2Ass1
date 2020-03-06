package model;

import model.Radiator;
import model.RadiatorState;

public class PowerStateTwo implements RadiatorState
{
  private int POWER = 2;

  @Override public void onButtonUp(Radiator radiator)
  {
    radiator.setPowerState(new PowerStateThree(radiator));
  }

  @Override public void onButtonDown(Radiator radiator)
  {
    radiator.setPowerState(new PowerStateOne());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
