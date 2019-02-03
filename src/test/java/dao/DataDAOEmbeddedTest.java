package dao;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import dto.Data;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_10;

public class DataDAOEmbeddedTest {

          EmbeddedMysql mysqld;
    @Before
    public void before() {
        MysqldConfig config = aMysqldConfig(v5_7_10).withPort(4545).withUser("test", "test").build();
        mysqld = anEmbeddedMysql(config).addSchema("pogodaEmbedded", classPathScript("pogodaTest.sql")).start();
    }
    @After
    public void after() {
        mysqld.stop();
    }

    DataDAOImpl dataDAO = new DataDAOImpl("test", "test", "4545","pogodaEmbedded");

    String dateOne ="2018-03-20T20:20:16";
    String dateTwo ="2018-01-20T13:13:16";

    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));
    Data data = new Data(29, 43, currentlyDate);
    Data data2 = new Data(33, 50, currentlyDate);
    Data data3 = new Data(13, 40, LocalDateTime.parse(dateOne));
    Data data4 = new Data(43, 57, currentlyDate);
    Data data5 = new Data(23, 70, LocalDateTime.parse(dateOne));
    Data data6 = new Data(22, 30, currentlyDate);
    Data data7 = new Data(18, 51, LocalDateTime.parse(dateTwo));
    Data data8 = new Data(31, 59, currentlyDate);

    List<Data> expected = new ArrayList<>();
   public DataDAOEmbeddedTest(){
       expected.add(data);
   }


    @Test
    public void ShouldCheckIfInsertAddsCorrectRecordToDatabase() {
        dataDAO.insert(data);
        Assert.assertEquals(data, dataDAO.getRecentRecord());
    }

    @Test
    public void ShouldGetAllRecordsFromDatabase() {
        dataDAO.deleteRecords();
        dataDAO.insert(data);
        dataDAO.insert(data2);
        expected.add(data2);

        List<Data> result = new DataDAOImpl("test", "test", "4545","pogodaEmbedded").getAll();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void ShouldGetRecordsFromRecent7Days() {
        dataDAO.deleteRecords();
        dataDAO.insert(data);
        dataDAO.insert(data2);
        dataDAO.insert(data3);
        dataDAO.insert(data4);
        dataDAO.insert(data5);
        dataDAO.insert(data6);
        dataDAO.insert(data7);
        dataDAO.insert(data8);

        List<Data> expected7days = new ArrayList<>();
        expected7days.add(data);
        expected7days.add(data2);
        expected7days.add(data4);
        expected7days.add(data6);
        expected7days.add(data8);

        List<Data> result = new DataDAOImpl("test", "test", "4545","pogodaEmbedded").getRecent7Days();
        Assert.assertEquals(expected7days, result);
    }

    @Test
    public void ShouldGetRecentRecord() {
        dataDAO.deleteRecords();
        dataDAO.insert(data);
        dataDAO.insert(data2);
        dataDAO.insert(data3);
        dataDAO.insert(data4);
//        List<Data> expectedLast = new ArrayList<>();
//        expectedLast.add(data4);
        Data result = new DataDAOImpl("test", "test", "4545","pogodaEmbedded").getRecentRecord();
        Assert.assertEquals(data4, result);
    }

    @Test
    public void deleteRecords() {
        dataDAO.insert(data);
        dataDAO.insert(data2);
        dataDAO.insert(data3);
        dataDAO.insert(data4);
        dataDAO.deleteRecords();
        Assert.assertTrue(dataDAO.deleteRecords());
        List<Data> expectedEmpty = new ArrayList<>();
        Assert.assertEquals(expectedEmpty,dataDAO.getAll());
    }
}