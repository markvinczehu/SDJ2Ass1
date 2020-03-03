package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import model.RadiatorState;


public class BarChartViewModel
{
  private RadiatorState radiatorState;
  private DoubleProperty upperBound;
  private DoubleProperty lowerBound;
  private StringProperty thermometer;
  private StringProperty temperature;

  public BarChartViewModel(RadiatorState model)
  {
    this.radiatorState = model;
    this.upperBound = new SimpleDoubleProperty();
    this.lowerBound = new SimpleDoubleProperty();
    this.thermometer = new SimpleStringProperty();
    this.temperature = new SimpleStringProperty();
  }


  public ObservableValue<? extends Number> upperBoundProperty()
  {
    return upperBound;
  }

  public ObservableValue<? extends Number> lowerBoundProperty()
  {
    return lowerBound;
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
