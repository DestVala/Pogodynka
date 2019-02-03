package dao;

import dto.Data;

import java.util.List;

public interface DataDAO {
    List<Data> getAll();

    List<Data> getRecent7Days();

    Data getRecentRecord();

    List<Data> getSelectedRecords(String from, String to);

    Integer insert(Data data);

    Boolean deleteRecords();
}
