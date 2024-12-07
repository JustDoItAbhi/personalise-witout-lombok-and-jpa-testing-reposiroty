package testinglombok.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import testinglombok.entity.TestingLombok;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestingLombokRepo {
    private  JdbcTemplate jdbctemplate;

    public TestingLombokRepo(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    private TestingLombok mapRowforTesting(ResultSet ex, int rowNum) throws SQLException {
        return new TestingLombok(
                ex.getInt("Id"),
                ex.getString("name"),
                ex.getInt("age")
                );
    }

    // CRUD Operations
    public List<TestingLombok> getAllTestigLomboks() {
        String sql = "SELECT * FROM TestingLombok";
        return jdbctemplate.query (sql, this::mapRowforTesting);
    }

    public int saveTestigLombok(TestingLombok testingLombok) {
        String sql = "INSERT INTO TestingLombok (name,age) VALUES (?, ?)";
        return jdbctemplate.update(sql, testingLombok.getName(), testingLombok.getAge());
    }
    public TestingLombok findById(int id) {
        String sql = "SELECT * FROM TestingLombok WHERE id = ?";
            return jdbctemplate.queryForObject(sql, this::mapRowforTesting, id);
    }
    public TestingLombok findByName(String name) {
        String sql = "SELECT * FROM TestingLombok WHERE name LIKE ?";
        List<TestingLombok> results = jdbctemplate.query(sql, this::mapRowforTesting, "%" + name + "%");

        // Return the first result or null if the list is empty
        if (results.isEmpty()) {
            return null; // Return null if no results are found
        } else {
            return results.get(0); // Return the first result if present
        }
    }

    public int deleteTestigLombok(int id) {
        String sql = "DELETE FROM TestingLombok WHERE id = ?";
        return jdbctemplate.update(sql, id);
    }
}
