package model;

import model.Radiator;
import model.RadiatorState;

public class PowerStateThree implements RadiatorState, Runnable
{
  private int POWER = 3;
  private Radiator radiator;
  private Thread thread;
  private Temperature temperature;

  public PowerStateThree(Radiator radiator)
  {
    temperature = new Temperature(50);
    this.radiator = radiator;
    this.thread = new Thread(this);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void onButtonUp(Radiator radiator)
  {
    System.out.println("Does nothing");
  }

  @Override public void onButtonDown(Radiator radiator)
  {
    thread.interrupt();
  }

  @Override public int getPower()
  {
    return POWER;
  }

  @Override public void run()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e){
      System.out.println("I am Error");
    }
    radiator.setPowerState(new PowerStateTwo());
  }
  public Temperature temperature()
  {
    return temperature;
  }
}

