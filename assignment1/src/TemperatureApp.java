
import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Thermometer;

public class TemperatureApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf, stage);
        Thermometer t1 = new Thermometer("One", 1, 2);
        Thermometer t2 = new Thermometer("One", 1, 5);
        Thermometer t3 = new Thermometer("One", 1, 9);

        vh.start();
    }
}
