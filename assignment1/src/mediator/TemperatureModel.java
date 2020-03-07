package mediator;

import model.Temperature;

import java.beans.PropertyChangeListener;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemp(Temperature temperature);

    double[] getDataValues();

    String getLastUpdateTimeStamp();

    void addListener(String name, PropertyChangeListener listener);

    void saveData(double[] data);
}
