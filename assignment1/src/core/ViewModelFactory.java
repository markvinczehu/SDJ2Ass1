package core;

import viewmodel.BarChartViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private BarChartViewModel barChartViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public BarChartViewModel getBarChartViewModel()
  {
    if(barChartViewModel == null)
    {
    barChartViewModel = new BarChartViewModel(modelFactory.getRadiatorState());
    }
    return barChartViewModel;
  }
}
