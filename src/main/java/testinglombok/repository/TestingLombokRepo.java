package testinglombok.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import testinglombok.entity.TestingLombok;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestingLombokRepo implements iTestingLombokRepo {
    private static final String SAVE_USER="INSERT INTO students(id,name,age)VALUE(?,?,?)";
    private static final String UPDATE_USER="UPDATE students SET name = ?, age = ? WHERE id = ?";
    private static final String FIND_USER_BY_ID="SELECT * FROM students WHERE id=?";
    private static final String FIND_USER_BY_NAME="SELECT * FROM students WHERE name=?";
    private static final String FIND_ALL_USER="SELECT * FROM students";
    private static final String DELETE_USER="DELETE FROM students WHERE ID=?";

    private final JdbcTemplate jdbctemplate;

    public TestingLombokRepo(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }


    @Override
    public List<TestingLombok> getAllTestigLomboks() {
        return jdbctemplate.query(FIND_ALL_USER,(rs, rowNum)->{
            return new TestingLombok(rs.getInt("id"),rs.getString("name"),
                    rs.getInt("age"));
        });
    }

    @Override
    public TestingLombok saveTestigLombok(TestingLombok testingLombok) {

      jdbctemplate.update(SAVE_USER,testingLombok.getId(), testingLombok.getName(),testingLombok.getAge());
    return testingLombok;
    }

    @Override
    public TestingLombok findById(int id) {
    return  jdbctemplate.queryForObject(FIND_USER_BY_ID,(rs,rowNum)->{
            return new TestingLombok(rs.getInt("id"),rs.getString("name"),
                    rs.getInt("age"));
        },id);
    }

    @Override
    public TestingLombok findByName(String name) {
        return  jdbctemplate.queryForObject(FIND_USER_BY_NAME,(rs,rowNum)->{
            return new TestingLombok(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"));
        },name);
    }

    @Override
    public boolean deleteTestigLombok(int id) {
         jdbctemplate.update(DELETE_USER,id);
         return true;
    }

    @Override
    public int updating(TestingLombok testingLombok) {
        return jdbctemplate.update(UPDATE_USER, testingLombok.getName(),testingLombok.getAge(),testingLombok.getId());

    }

}
