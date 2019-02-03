package controlers;

import dao.DataDAO;
import dto.Data;
import dto.SensorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import threads.TemperatureWatcher;

import java.util.List;

public class WeatherAppControler {

    @FXML private Button pobierz;

    @FXML private TextField temperature;

    @FXML private TextField humidity;

    @FXML
    void onClick(ActionEvent event){
        SensorService sensorService = new SensorService();
         Data lastRecord = sensorService.getLast();

         temperature.setText(String.valueOf(lastRecord.getTemperature()));
         humidity.setText(String.valueOf(lastRecord.getHumidity()));

    }

   public void setDisplayData(Data data){
        temperature.setText(Double.toString(data.getTemperature()));
        humidity.setText(Double.toString(data.getHumidity()));

    }


}
