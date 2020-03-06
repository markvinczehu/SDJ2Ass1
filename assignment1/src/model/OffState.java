package model;

import model.Radiator;
import model.RadiatorState;

public class OffState implements RadiatorState
{
  private int POWER = 0;

  @Override public void onButtonUp(Radiator radiator)
  {
    radiator.setPowerState(new PowerStateOne());
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
