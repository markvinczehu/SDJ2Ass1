package view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import viewmodel.BarChartViewModel;

public class BarChartViewController
{
 @FXML NumberAxis temperature;
 @FXML CategoryAxis thermometers;
 @FXML BarChart barChart;

 private BarChartViewModel vm;

 public void init(BarChartViewModel viewModel)
 {
   vm = viewModel;

   temperature.setLabel("Temperature");
   thermometers.setLabel("Thermometers");

   temperature.setAutoRanging(false);
   temperature.upperBoundProperty().bind(vm.upperBoundProperty());
   temperature.lowerBoundProperty().bind(vm.lowerBoundProperty());
   temperature.setTickUnit(0.1);

   barChart.getData().add(vm.temperatureProperty());
   barChart.getData().add(vm.thermometerProperty());
 }
}
