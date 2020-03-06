package mediator;

import model.Temperature;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemp(Temperature temperature);
}
