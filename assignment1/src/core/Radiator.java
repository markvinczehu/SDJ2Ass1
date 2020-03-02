package core;

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
    public int getPower()
    {
        return currentState.getPower();
    }
}
