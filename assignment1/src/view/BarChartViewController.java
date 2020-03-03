package view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
   XYChart.Series set1 = new XYChart.Series<>();
   set1.getData().add(new XYChart.Data("ThermometerOne", vm.thermometerProperty()));
   set1.getData().add(new XYChart.Data("ThermometerTwo", vm.thermometerProperty()));
   set1.getData().add(new XYChart.Data("ThermometerThree", vm.thermometerProperty()));

   temperature.setLabel("Temperature");
   thermometers.setLabel("Thermometers");

   barChart.getData().addAll(set1);

 }
}
