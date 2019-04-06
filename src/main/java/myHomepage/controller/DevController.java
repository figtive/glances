package myHomepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller are for development purpose only
 */
@RestController
public class DevController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DevController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/get")
    public String SQLSelect() {
        return jdbcTemplate.queryForObject("select t.name from glanse.test_table t where t.id = 2", String.class);
    }
}
