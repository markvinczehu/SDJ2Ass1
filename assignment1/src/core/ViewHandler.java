package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import view.BarChartViewController;
import view.LineChartViewController;
import viewmodel.BarChartViewModel;
import viewmodel.LineChartViewModel;

import java.io.IOException;

public class ViewHandler {
  private Stage barStage, lineStage;
  private ViewModelFactory viewModelFactory;
  private Scene barChartViewScene, lineChartViewScene;
  private BarChartViewModel barChartVM;
  private LineChartViewModel lineChartVM;

  public ViewHandler(Stage stage, ViewModelFactory vmf) {

    viewModelFactory = vmf;
    barStage = stage;
    lineStage = stage;
  }

  public void start() {
    barChartViewScene();
    lineChartViewScene();
  }

  public void barChartViewScene() {
    FXMLLoader();
  }

  public void lineChartViewScene() {
    FXMLLoader();
  }

  private void FXMLLoader() {
    FXMLLoader loader = new FXMLLoader();

    if(barChartViewScene == null && lineChartViewScene == null) {
      Parent root1 = getRootByPath("../BarChartView.fxml", loader);
      Parent root2 = getRootByPath("../LineChartView.fxml", loader);
      BarChartViewController controller1 = loader.getController();
      LineChartViewController controller2 = loader.getController();
      controller1.init(barChartVM);
      controller2.init(lineChartVM);
      barChartViewScene = new Scene(root1);
      lineChartViewScene = new Scene(root2);
    }
    barStage.setTitle("Bar Chart");
    barStage.setScene(barChartViewScene);
    lineStage.setTitle("Line chart");
    lineStage.setScene(lineChartViewScene);
    barStage.show();
    lineStage.show();
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
