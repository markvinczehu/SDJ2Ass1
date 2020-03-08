import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.TemperatureModelManager;
import model.Radiator;
import model.Thermometer;

import java.util.Random;

public class TemperatureApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf, stage);
        Radiator r1 = new Radiator();

        vh.start();

        runAutoUpdate((TemperatureModelManager) mf.getModel());
    }

    private void runAutoUpdate(TemperatureModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(10000) + 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }

    @Override
    public void stop() throws Exception {

    }
}
