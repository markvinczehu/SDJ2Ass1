package mediator;

import model.Temperature;
import model.TemperatureList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

   public Temperature getLastInsertedTemperature()
    {
      return temperatureList.getLastTemperature(null);
    }

    public Temperature getLastInsertedTemperature(String id)
    {
      return temperatureList.getLastTemperature(id);
    }

    public void addListener(ActionListener listener)
    {

    }

     public void removeListener(ActionListener listener)
    {

    }

    public void actionPerformed(ActionEvent e)
    {

    }
}
