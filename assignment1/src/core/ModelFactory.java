package core;

import model.Radiator;
import model.RadiatorState;
import viewmodel.BarChartViewModel;

public class ModelFactory
{
  private RadiatorState radiatorState;
  private BarChartViewModel barChartViewModel;

  public RadiatorState getRadiatorState()
  {
    if(radiatorState == null)
    {
      radiatorState = new Radiator();
    }
    return radiatorState;
  }
  public BarChartViewModel getBarChartViewModel()
  {
    if(barChartViewModel == null)
    {
      barChartViewModel = new BarChartViewModel(radiatorState);
    }
      return barChartViewModel;
  }
}
