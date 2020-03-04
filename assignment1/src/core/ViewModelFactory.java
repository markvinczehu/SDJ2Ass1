package core;

import viewmodel.BarChartViewModel;
import viewmodel.LineChartViewModel;

public class ViewModelFactory {

  private ModelFactory modelFactory;
  private BarChartViewModel barChartViewModel;
  private LineChartViewModel lineChartViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public BarChartViewModel getBarChartViewModel() {
    if(barChartViewModel == null) {
    barChartViewModel = new BarChartViewModel(modelFactory.getRadiatorState());
    }
    return barChartViewModel;
  }

  public LineChartViewModel getLineChartViewModel() {
    if(getLineChartViewModel() == null) {
      lineChartViewModel = new LineChartViewModel(modelFactory.getRadiatorState());
    }
    return lineChartViewModel;
  }
}
