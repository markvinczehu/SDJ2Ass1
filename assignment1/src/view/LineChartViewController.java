package view;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import viewmodel.LineChartViewModel;

public class LineChartViewController
{
    @FXML NumberAxis temperature;
    @FXML CategoryAxis thermometers;
    @FXML LineChart lineChart;

    private LineChartViewModel vm;


    public void init(LineChartViewModel viewModel)
    {
      vm = viewModel;

      temperature.setLabel("Temperature");
      thermometers.setLabel("Thermometers");

      temperature.setAutoRanging(false);
      temperature.upperBoundProperty().bind(vm.upperBoundProperty());
      temperature.lowerBoundProperty().bind(vm.lowerBoundProperty());
      temperature.setTickUnit(0.1);

      while(true)
      {
        lineChart.getData().add(vm.temperatureProperty());
        lineChart.getData().add(vm.thermometerProperty());
      }
    }
}
