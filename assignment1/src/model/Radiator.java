package model;

import model.OffState;
import model.RadiatorState;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;

public class Radiator implements RadiatorState, PropertyChangeSubject
{
    private RadiatorState currentState = new OffState();
    private Thermometer thermometer;

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

    }

    @Override public void addPropertyChangeListener(
        PropertyChangeListener listener)
    {

    }

    @Override public void removePropertyChangeListener(String eventName,
        PropertyChangeListener listener)
    {

    }

    @Override public void removePropertyChangeListener(
        PropertyChangeListener listener)
    {

    }
}
