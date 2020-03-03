import javafx.application.Application;
import javafx.stage.Stage;
import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;

public class TemperatureApp extends Application
{
  @Override
  public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(stage, vmf);
    viewHandler.start();
  }
}
