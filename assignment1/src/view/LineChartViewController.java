package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import viewmodel.LineChartViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LineChartViewController
{
    @FXML NumberAxis tempY;
    @FXML CategoryAxis timeX;
    @FXML LineChart lineChart;
    @FXML Button plusButton, minusButton;

    private LineChartViewModel vm;


    public void init(LineChartViewModel viewModel)
    {
      vm = viewModel;

      tempY.setLabel("Temperature");
      timeX.setLabel("Time");


      tempY.setAutoRanging(false);
      tempY.upperBoundProperty().bind(vm.upperBoundProperty());
      tempY.lowerBoundProperty().bind(vm.lowerBoundProperty());
      tempY.setTickUnit(0.1);


        lineChart.getData().add(vm.temperatureProperty());
        lineChart.getData().add(vm.thermometerProperty());
    }

  public void onIncTemp(ActionEvent actionEvent)
  {
    if(actionEvent.equals(plusButton))
    {

    }
  }
}
