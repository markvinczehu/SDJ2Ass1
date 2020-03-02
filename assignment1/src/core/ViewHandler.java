package core;

import javafx.scene.*;
import javafx.stage.*;

public class ViewHandler
{
  private Scene scene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, ViewModelFactory vmf)
  {
    this.stage = stage;
    this.vmf = vmf;
  }


}
