package threads;

import controlers.WeatherAppControler;
import dao.DataDAO;
import dto.Data;
import javafx.application.Platform;

public class TemperatureWatcher extends Thread{

    private DataDAO dataDAO;
    private WeatherAppControler weatherAppControler;

    public TemperatureWatcher(DataDAO dataDAO, WeatherAppControler weatherAppControler) {
        this.dataDAO = dataDAO;
        this.weatherAppControler = weatherAppControler;
    }
    boolean isWorking;
    @Override
    public void run(){
        isWorking=true;
        while(isWorking){
         Data actualData = dataDAO.getRecentRecord();

         if(actualData!=null) {
             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     weatherAppControler.setDisplayData(actualData);
                 }
             });
         }
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                isWorking=false;
            }
        }

    }
}
