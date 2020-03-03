package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import view.BarChartViewController;
import viewmodel.BarChartViewModel;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private ViewModelFactory viewModelFactory;
  private Scene barChartViewScene, lineChartViewScene;
  private BarChartViewModel barChartVM;

  public ViewHandler(Stage stage, ViewModelFactory vmf) {

    viewModelFactory = vmf;
    mainStage = stage;
  }

  public void start() {
    barChartViewScene();
    lineChartViewScene();
  }

  public void barChartViewScene() {
    FXMLLoader loader = new FXMLLoader();

    if(barChartViewScene == null) {
      Parent root = getRootByPath("../BarChartView.fxml", loader);
      BarChartViewController controller = loader.getController();
      controller.init(barChartVM);
      barChartViewScene = new Scene(root);
    }
    mainStage.setTitle("Bar Chart");
    mainStage.setScene(barChartViewScene);
    mainStage.show();
  }

  public void lineChartViewScene() {

  }

  private Parent getRootByPath(String path, FXMLLoader loader) {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return root;
  }

}
