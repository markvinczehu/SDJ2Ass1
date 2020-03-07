package view;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import mediator.TemperatureModel;

import java.beans.PropertyChangeEvent;

public class LineChartViewModel
{

  private DoubleProperty x;
  private DoubleProperty y;
  private DoubleProperty z;
  private StringProperty thermometer;
  private StringProperty temperature;

  private StringProperty updateTimeStamp;

  public  LineChartViewModel(TemperatureModel model)
  {
    updateTimeStamp = new SimpleStringProperty("Last update: ");
    model.addListener("Data", evt -> updateLineChart(evt));
    model.addListener("TimeUpdate", evt -> timeStampUpdated(evt));
    x = new SimpleDoubleProperty();
    y = new SimpleDoubleProperty();
    z = new SimpleDoubleProperty();
    this.thermometer = new SimpleStringProperty();
    this.temperature = new SimpleStringProperty();
  }

  public void updateLineChart(PropertyChangeEvent evt) {
    Platform.runLater(() -> {
      double[] vals = (double[]) evt.getNewValue();
      x.setValue(vals[0]);
      y.setValue(vals[1]);
      z.setValue(vals[2]);
    });

  }

  public StringProperty updateTimeStampProperty() {
    return updateTimeStamp;
  }
  public ObservableValue xProperty() {
    return x;
  }

  public ObservableValue yProperty() {
    return y;
  }

  public ObservableValue zProperty() {
    return z;
  }
  private void timeStampUpdated(PropertyChangeEvent evt) {
    Platform.runLater(() -> updateTimeStamp.setValue("Last updated: " + evt.getNewValue()));
  }

  public StringProperty thermometerProperty()
  {
    return thermometer;
  }

  public StringProperty temperatureProperty()
  {
    return temperature;
  }
}
