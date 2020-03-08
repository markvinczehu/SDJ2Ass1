package core;

import mediator.TemperatureModel;
import mediator.TemperatureModelManager;
import model.Radiator;
import model.RadiatorState;
import model.Temperature;
import view.BarChartViewModel;
import view.LineChartViewModel;

public class ModelFactory
{
  private TemperatureModel model;

  public TemperatureModel getModel() {
    if(model == null) model = new TemperatureModelManager();
    return model;
  }
}
