package core;

import model.Radiator;
import model.RadiatorState;
import view.BarChartViewModel;
import viewmodel.LineChartViewModel;

public class ModelFactory
{
  private RadiatorState radiatorState;
  private BarChartViewModel barChartViewModel;
  private LineChartViewModel lineChartViewModel;

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
  public LineChartViewModel getLineChartViewModel()
  {
    if(lineChartViewModel == null)
    {
      lineChartViewModel = new LineChartViewModel(radiatorState);
    }
    return lineChartViewModel;
  }
}
