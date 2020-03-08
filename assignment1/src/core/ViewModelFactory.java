package core;

import view.BarChartViewModel;
import view.LineChartViewModel;

public class ViewModelFactory {

  private BarChartViewModel barChartViewModel;
  private LineChartViewModel lineChartViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
     lineChartViewModel = new LineChartViewModel(mf.getModel());
     barChartViewModel = new BarChartViewModel(mf.getModel());
  }

  public LineChartViewModel getLineChartViewModel() {
    return lineChartViewModel;
  }

  public BarChartViewModel getBarChartViewModel() {
    return barChartViewModel;
  }

}
