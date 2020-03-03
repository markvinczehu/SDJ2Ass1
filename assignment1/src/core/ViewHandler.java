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
  private Stage stage;
  private ViewModelFactory viewModelFactory;
  private Scene barChartViewScene, lineChartViewScene;
  private BarChartViewModel barChartVM;
  private LineChartViewModel lineChartVM;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf, Stage stage) {

    this.vmf = vmf;
    this.stage = stage;
  }

  public void start() throws Exception
  {
    openChartView("LineChart");
  }

    public void openChartView(String viewToOpen) throws IOException
    {
      Scene scene = null;
      FXMLLoader loader = new FXMLLoader();
      Parent root = null;

      loader.setLocation(getClass().getResource("../view" + "/" + viewToOpen + "View.fxml"));
      root = loader.load();
      /*if("BarChart".equals(viewToOpen)){
        BarChartViewController view = loader.getController();
        view.init(vmf.getBarChartViewModel());
        stage.setTitle("BarChartView");
      }*/
      if("LineChart".equals(viewToOpen))
      {
        LineChartViewController view = loader.getController();
        view.init(vmf.getLineChartViewModel());
        stage.setTitle("LineChartView");
      }
      scene = new Scene(root);
      //barStage.setScene(scene);
      //barStage.show();
      stage.setScene(scene);
      stage.show();
    }

  /*public void barChartViewScene() {
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
    stage.setTitle("Bar Chart");
    stage.setScene(barChartViewScene);
    stage.setTitle("Line chart");
    stage.setScene(lineChartViewScene);
    stage.show();
    stage.show();
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
   */
}

