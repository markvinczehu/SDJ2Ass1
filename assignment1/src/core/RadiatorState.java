package core;

public interface RadiatorState
{
  void onButtonUp(Radiator radiator);
  void onButtonDown(Radiator radiator);
  int getPower();
}
