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

  public ViewHandler(ViewModelFactory mvViewModel) {
    this.mvViewModel = mvViewModel;
  }

  public void start() throws Exception {
    openView("BarChart");
    openView("LineChart");
  }

  public void openView(String viewToOpen) throws IOException {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    Stage tmpStage = new Stage();
    if("LineChart".equals(viewToOpen)) {
      loader.setLocation(getClass().getResource("../view/LineChart.fxml"));
      root = loader.load();
      LineChartViewController view = loader.getController();
      view.init(mvViewModel.getLineChartViewModel());
      tmpStage.setTitle("Pie Chart");
    } else if("BarChart".equals(viewToOpen)) {
      loader.setLocation(getClass().getResource("../view/BarChart.fxml"));
      root = loader.load();
      BarChartViewController view = loader.getController();
      view.init(mvViewModel.getBarChartViewModel());
      tmpStage.setTitle("Bar Chart");
    }

    scene = new Scene(root);
    tmpStage.setScene(scene);
    tmpStage.show();
  }
}

