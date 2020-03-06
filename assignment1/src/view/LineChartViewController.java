package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.*;
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
    private Thermometer thermometer;
    private DateTime dateTime;
    private Stage stage;
    private Scene scene;
    private Radiator radiator;


    public void init(LineChartViewModel viewModel)
    {
      vm = viewModel;

      tempY.setLabel("Temperature");
      timeX.setLabel("Time");
      LineChart lineChart = new LineChart(timeX, tempY);
      System.out.println("linechart creation");
      XYChart.Series dataSeries = new XYChart.Series();
      dataSeries.setName("111");
      System.out.println("linechart creation");

      dataSeries.getData().add(new XYChart.Data(dateTime, thermometer));

      lineChart.getData().add(dataSeries);

    }
//maybe change to two separate buttons
  public void onIncTemp(ActionEvent actionEvent)
  {
    System.out.println("blablblasd");
    try
    {
      if (actionEvent.equals(plusButton))
      {

        do
        {
          radiator.onButtonUp(radiator);
        }
        while(!radiator.currentState().equals(new PowerStateThree(radiator)));

      }
      if (actionEvent.equals(minusButton))
      {
        do
        {
          radiator.onButtonDown(radiator);
        }
        while (!radiator.currentState().equals(new OffState()));
      }
    }
    catch (Exception e)
    {}
  }
}
