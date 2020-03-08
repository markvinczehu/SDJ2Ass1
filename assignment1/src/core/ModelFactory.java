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
  private RadiatorState radiatorModel;

  public TemperatureModel getModel() {
    if(model == null) model = new TemperatureModelManager();
    return model;
  }
  public RadiatorState radiatorModel()
  {
    if (radiatorModel == null) radiatorModel = new Radiator();
    return radiatorModel;
  }
}
