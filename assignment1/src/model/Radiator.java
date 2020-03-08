package model;

import model.OffState;
import model.RadiatorState;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements RadiatorState, PropertyChangeSubject
{
    private RadiatorState currentState;
    private Thermometer thermometer;
    private PropertyChangeSupport support;
    private Temperature temp;

    public void turnUp()
    {
        currentState.onButtonUp(this);
    }
    public void turnDown()
    {
        currentState.onButtonDown(this);
    }
    public void setPowerState(RadiatorState radiatorState)
    {
        currentState = radiatorState;
    }
    public RadiatorState currentState()
    {
        return currentState;
    }

    public Radiator()
    {
        currentState = new OffState();
        support = new PropertyChangeSupport(this);
        this.temp = new Temperature();
    }

    public void setTemp(Temperature temp)
    {
        this.temp = temp;
    }

    public double getTemp()
    {
        return temp.getValue();
    }


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

    public void start() throws InterruptedException
    {
        for (int i = 0; i < 5000; i++)
        {
            temp.setValue(getTemp());
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println("I am error");
            }
        }
    }
    @Override public void addPropertyChangeListener(String eventName,
        PropertyChangeListener listener)
    {
        if(eventName == null || "".equals(eventName)){
            addPropertyChangeListener(listener);
        }
        else{
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override public void addPropertyChangeListener(
        PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(String eventName,
        PropertyChangeListener listener)
    {
        if(eventName == null || "".equals(eventName)){
            removePropertyChangeListener(listener);
        }
        else {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override public void removePropertyChangeListener(
        PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }

}
