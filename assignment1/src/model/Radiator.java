package model;

import model.OffState;
import model.RadiatorState;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements RadiatorState, PropertyChangeSubject, Runnable
{
    private RadiatorState currentState = new OffState();
    private Thermometer thermometer;
    private PropertyChangeSupport support;

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

    @Override public void onButtonUp(Radiator radiator)
    {
        radiator.turnUp();
    }

    @Override public void onButtonDown(Radiator radiator)
    {
        radiator.turnDown();
    }

    public int getPower(){
       return getPower();
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

    @Override public void run()
    {

    }
}
