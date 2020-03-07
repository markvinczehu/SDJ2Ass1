package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.BarChartViewController;
import view.LineChartViewController;

import java.io.IOException;

public class ViewHandler {

  private ViewModelFactory mvViewModel;
  private Stage stage;

  public ViewHandler(ViewModelFactory mvViewModel, Stage stage) {
    this.mvViewModel = mvViewModel;
    this.stage = stage;
  }

  public void start() throws Exception {
    openView("LineChart");
    openView("Bar Chart");
  }

  public void openView(String viewToOpen) throws IOException {
    Scene scene;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    if("LineChart".equals(viewToOpen))
    {
      loader.setLocation(getClass().getResource("../view/LineChartView.fxml"));
      root = loader.load();
      LineChartViewController view = loader.getController();
      view.init(mvViewModel.getLineChartViewModel());
      stage.setTitle("Line Chart");
    }
    else if("BarChart".equals(viewToOpen)) {
      loader.setLocation(getClass().getResource("../view/BarChartView.fxml"));
      root = loader.load();
      BarChartViewController view = loader.getController();
      view.init(mvViewModel.getBarChartViewModel());
      stage.setTitle("Bar Chart");
    }

    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}

