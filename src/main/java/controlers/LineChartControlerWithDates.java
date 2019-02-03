package controlers;


import dto.Data;
import dto.SensorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LineChartControlerWithDates {


    @FXML private CategoryAxis xDate;

    @FXML private NumberAxis yValue;

    @FXML
    private LineChart<?,?> LineChartDates;

    @FXML
    private Button pobierzDaty;


    @FXML
    private DatePicker firstDate;

    @FXML
    private DatePicker lastDate;


    @FXML
    void onClick2(ActionEvent event) {

        LocalDate fromDate = firstDate.getValue();
        LocalDate toDate = lastDate.getValue();
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SensorService sensorService = new SensorService();
        List<Data> selectedDate = sensorService.getSelectedRecordsService(fromDate.toString(),toDate.toString());

            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();

            LineChart<String, Number> lineChartDates = new LineChart<>(xAxis, yAxis);
            lineChartDates.setTitle("Dane z zakresu");

            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Temp");
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Humi");

            for(int i=0;i<selectedDate.size()-1;i++){
                String xValue = selectedDate.get(i).getDateTime().format(dTF).toString();
                series1.getData().add(new XYChart.Data(""+xValue, selectedDate.get(i).getTemperature()));
                series2.getData().add(new XYChart.Data(""+xValue, selectedDate.get(i).getHumidity()));
            }
//
//            series1.getData().add(new XYChart.Data("6 day ago", selectedDate.get(0).getTemperature()));
//            series1.getData().add(new XYChart.Data("5 day ago", selectedDate.get(1).getTemperature()));
//            series1.getData().add(new XYChart.Data("4 day ago", selectedDate.get(2).getTemperature()));
//            series1.getData().add(new XYChart.Data("3 day ago", selectedDate.get(3).getTemperature()));
//            series1.getData().add(new XYChart.Data("2 day ago", selectedDate.get(4).getTemperature()));
//            series1.getData().add(new XYChart.Data("Yesterday", selectedDate.get(5).getTemperature()));
//            series1.getData().add(new XYChart.Data("Today", selectedDate.get(6).getTemperature()));
//
//            series2.getData().add(new XYChart.Data("6 day ago", selectedDate.get(0).getHumidity()));
//            series2.getData().add(new XYChart.Data("5 day ago", selectedDate.get(1).getHumidity()));
//            series2.getData().add(new XYChart.Data("4 day ago", selectedDate.get(2).getHumidity()));
//            series2.getData().add(new XYChart.Data("3 day ago", selectedDate.get(3).getHumidity()));
//            series2.getData().add(new XYChart.Data("2 day ago", selectedDate.get(4).getHumidity()));
//            series2.getData().add(new XYChart.Data("Yesterday", selectedDate.get(5).getHumidity()));
//            series2.getData().add(new XYChart.Data("Today", selectedDate.get(6).getHumidity()));

            LineChartDates.getData().clear();
            LineChartDates.getData().addAll(series1, series2);


    }

}
