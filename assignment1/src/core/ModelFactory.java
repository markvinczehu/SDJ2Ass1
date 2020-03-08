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
    if (radiatorModel == null) radiatorModel = new RadiatorState()
    {
      @Override public void onButtonUp(Radiator radiator)
      {
        radiator.turnUp();
      }

      @Override public void onButtonDown(Radiator radiator)
      {
        radiator.turnDown();
      }

      @Override public int getPower()
      {
        return 0;
      }
    };
    return radiatorModel;
  }
}
