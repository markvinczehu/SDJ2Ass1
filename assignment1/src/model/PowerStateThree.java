package model;

import model.Radiator;
import model.RadiatorState;

public class PowerStateThree implements RadiatorState, Runnable
{
  private int POWER = 3;
  private Radiator radiator;
  private Thread thread;

  public PowerStateThree(Radiator radiator)
  {
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
    return 3;
  }

  @Override public void run()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e){}
    radiator.setPowerState(new PowerStateTwo());
  }
}

