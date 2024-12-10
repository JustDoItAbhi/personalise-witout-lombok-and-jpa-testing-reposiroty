package testinglombok.repository;

import testinglombok.entity.TestingLombok;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface iTestingLombokRepo {
    List<TestingLombok> getAllTestigLomboks();
     TestingLombok saveTestigLombok(TestingLombok testingLombok);
    TestingLombok findById(int id);
    TestingLombok findByName(String name);
    boolean deleteTestigLombok(int id);
    int updating(TestingLombok lombok);
}
