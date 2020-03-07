package mediator;

import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TemperatureModelManager implements TemperatureModel
{
    private double x;
    private double y;
    private double z;
    private TemperatureList temperatureList;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private String lastUpdate;

    private Random random = new Random();

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
    return new double[]{x, y, z};
  }

  @Override public String getLastUpdateTimeStamp()
  {
    return lastUpdate;
  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {
    if(name == null)
      changeSupport.addPropertyChangeListener(listener);
    else
      changeSupport.addPropertyChangeListener(name, listener);
  }

  @Override public void saveData(double[] data)
  {
    x = data[0];
    y = data[1];
    z = data[2];
    changeSupport.firePropertyChange("Data", null, new double[]{x, y, z});
    calcTimeStamp();
  }

  public Temperature getLastInsertedTemperature()
    {
      return temperatureList.getLastTemperature(null);
    }

    public Temperature getLastInsertedTemperature(String id)
    {
      return temperatureList.getLastTemperature(id);
    }

  public void recalculateData() {
    int first = random.nextInt(100)+1;
    int second = random.nextInt(100)+1;
    int bottom = Math.min(first, second);
    int top = Math.max(first, second);

    x = bottom;
    y = top - bottom;
    z = 100 - top;

    changeSupport.firePropertyChange("Data", null, new double[]{x, y, z});
    calcTimeStamp();
  }

  private void calcTimeStamp() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
    Date now = new Date();
    String strDate = sdfDate.format(now);
    changeSupport.firePropertyChange("TimeUpdate", lastUpdate, strDate);
    lastUpdate = strDate;
  }
}
