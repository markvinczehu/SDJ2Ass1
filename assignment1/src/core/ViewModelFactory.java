package core;

import view.BarChartViewModel;
import view.LineChartViewModel;

public class ViewModelFactory {

  private ModelFactory modelFactory;
  private BarChartViewModel barChartViewModel;
  private LineChartViewModel lineChartViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public BarChartViewModel getBarChartViewModel() {
    if(barChartViewModel == null) {
    barChartViewModel = new BarChartViewModel(modelFactory.getModel());
    }
    return barChartViewModel;
  }

  public LineChartViewModel getLineChartViewModel() {
    if(lineChartViewModel == null) {
      lineChartViewModel = new LineChartViewModel(modelFactory.getModel());
    }
    return lineChartViewModel;
  }
}
