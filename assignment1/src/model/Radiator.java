package model;

import model.OffState;
import model.RadiatorState;

public class Radiator implements RadiatorState
{
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
}
