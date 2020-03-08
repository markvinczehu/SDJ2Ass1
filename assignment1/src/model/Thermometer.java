package model;

import util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Thermometer implements Runnable, PropertyChangeListener
{
    private String id;
    private double t;
    private int d;
    private Temperature temperature;

  public Thermometer(String id, double t, int d)
    {
      this.id = id;
      this.t = t;
      this.d = d;
    }
    public Thermometer(PropertyChangeSubject subject)
    {
      subject.addPropertyChangeListener(this::reactToChange);
    }
    public void reactToChange(PropertyChangeEvent event)
    {
      double oldValue = (double) event.getOldValue();
      double newValue = (double) event.getNewValue();
      for (int i = 0; i < 5000; i++)
      {
        temperature.setValue(newValue);
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {}

      }

    }

  public double temperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  @Override public void run()
  {
    while (true)
    {
      t = temperature(t, 2, d, 0, 6);
      try
      {
        Thread.sleep(1500);
      }
      catch (InterruptedException e){}
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {


  }
}
