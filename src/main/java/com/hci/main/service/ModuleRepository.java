package com.hci.main.service;

import com.hci.main.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ModuleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ModuleRowMapper implements RowMapper<Module> {
        @Override
        public Module mapRow(ResultSet rs, int rowNum) throws SQLException {
            Module module = new Module();
            module.setModuleName(rs.getString("moduleName") + "Card");
            module.setModuleOrder(rs.getInt("moduleOrder"));
            return module;
        }

    }

    public List<Module> findByUserID(String userID) {
        return jdbcTemplate.query("SELECT moduleName,moduleOrder FROM MODULE M JOIN USER U ON U.groupID=M.groupID WHERE U.ID = ?", new Object[]{userID}, new ModuleRowMapper());
    }
}
