package core;

import model.Radiator;
import model.RadiatorState;
import viewmodel.BarChartViewModel;

public class ModelFactory
{
  private RadiatorState radiatorState;
  private BarChartViewModel bcvm;

  public RadiatorState getRadiatorState()
  {
    if(radiatorState == null)
    {
      radiatorState = new RadiatorState();
    }
    return radiatorState;
  }
}
