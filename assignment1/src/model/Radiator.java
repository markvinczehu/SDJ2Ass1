package model;

import model.OffState;
import model.RadiatorState;

public class Radiator {
    private RadiatorState currentState = new OffState();

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
    public void getPower(){

    }
}
