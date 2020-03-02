package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class BarChartViewModel
{
  private DoubleProperty upperBound = new SimpleDoubleProperty();
  private DoubleProperty lowerBound = new SimpleDoubleProperty();
  private StringProperty thermometer = new SimpleStringProperty();
  private StringProperty temperature = new SimpleStringProperty();



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
