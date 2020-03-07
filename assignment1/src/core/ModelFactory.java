package core;

import mediator.TemperatureModel;
import model.Radiator;
import model.RadiatorState;
import view.BarChartViewModel;
import view.LineChartViewModel;

public class ModelFactory
{
  private Model model;

  public Model getModel() {
    if(model == null) model = new DataModel();
    return model;
  }
}
