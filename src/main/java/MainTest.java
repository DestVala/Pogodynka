import dao.DataDAOImpl;
import dto.SensorService;
import multicast.IntroduceService;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class MainTest {

    public static void main(String[] args) {
        String login = "root";
        String password = "kakashi6";
        String databaseTest = "pogodynka";
        String port ="3306";

        DataDAOImpl dataDAO=new DataDAOImpl(login,password,port,databaseTest);

        String from = "2018-05-22";
        String to ="2018-05-24";

        System.out.println(dataDAO.getSelectedRecords(from,to));

        System.out.println(dataDAO.getRecentRecord());

        SensorService sensorService=new SensorService();

        System.out.println("wadaW"+sensorService.getSelectedRecordsService(from,to));

        //        MulticastReceiver multicastReceiver = new MulticastReceiver();
//        multicastReceiver.run();

//        IntroduceService introduceService=new IntroduceService();
//        introduceService.run();

//        MulticastPublisher multicastPublisher=new MulticastPublisher();
//        try {
//            multicastPublisher.multicast("tralala");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

      //  multicastReceiver.start();

//        String database = "pogodynka";
//        String databaseTest = "pogodynkaTest";
        //        port(8080);
//        get("/hello", (req, res) -> "Hello World");
//        // http://localhost:8080/sensor?temperature=22.4&humidity=33
//        post("/sensor", (request, response) -> {
//            String temperature = request.queryParams("temperature");
//            String humidity = request.queryParams("humidity");
//            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
//        });
//        double temp = 22;
//        double humi = 23;
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Podaj login: ");
//        String login = scanner.next();
//        System.out.print("Podaj hasło: ");
//        String password = scanner.next();
//
//        Data newData = new Data(temp, humi, localDateTime);
//        new DataDAOImpl(login, password,database).insert(newData);
//
//        System.out.println("it gets all");
//        List<Data> result = new DataDAOImpl(login, password,database).getAll();
//        result.forEach(data -> System.out.println(data));
//        System.out.println("7days");
//        List<Data> result2 = new DataDAOImpl(login, password,database).getRecent7Days();
//        result2.forEach(data -> System.out.println(data));
//        System.out.println("recent record");


//        Boolean result3 = new DataDAOImpl(login, password, databaseTest).deleteRecords();
//        System.out.println(result3);


    }
}
