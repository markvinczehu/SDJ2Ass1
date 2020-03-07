package mediator;

import model.Temperature;
import model.TemperatureList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
    private TemperatureList temperatureList;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public TemperatureModelManager()
    {
      temperatureList = new TemperatureList();
    }

    @Override public void addTemperature(String id, double value)
    {
      Temperature temperature = new Temperature(id, value);
      Temperature old = getLastInsertedTemperature();
      this.temperatureList.addTemperature(temperature);
      changeSupport.firePropertyChange("Temperature Update", old, temperature);
      if (old != null && old.getValue() != temperature.getValue())
      {
        System.out.println("-->" + temperature + " (from: " + old + ")");
      }
    }

  @Override public Temperature getLastInsertedTemp(Temperature temperature)
  {
    return temperatureList.getLastTemperature("");
  }

  @Override public double[] getDataValues()
  {
    return new double[0];
  }

  @Override public String getLastUpdateTimeStamp()
  {
    return null;
  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {

  }

  @Override public void saveData(double[] data)
  {

  }

  public Temperature getLastInsertedTemperature()
    {
      return temperatureList.getLastTemperature(null);
    }

    public Temperature getLastInsertedTemperature(String id)
    {
      return temperatureList.getLastTemperature(id);
    }

    public void addListener(PropertyChangeListener listener)
    {

    }

     public void removeListener(PropertyChangeListener listener)
    {

    }

    public void actionPerformed(PropertyChangeListener e)
    {

    }
}
