package mediator;

import model.Temperature;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);
  void getLastInsertedTemp(Temperature temperature);
}
