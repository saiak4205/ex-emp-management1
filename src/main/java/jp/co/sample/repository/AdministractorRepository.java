package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administractor;

@Repository
public class AdministractorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administractor>ADMIN_ROW_MAPPER = new BeanPropertyRowMapper<>(Administractor.class);
	
	public void insert(Administractor administractor) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administractor);
		String insertSql = "INSERT INTO administractors(name,mail_address,password) "
						 + "VALUES(:name,:mailAddress,:password);";
		template.update(insertSql, param);
	}
	
	public Administractor findByMailAddressAndPassword(String mailAddress,String password) {
		String sql = "SELECT * FROM administractors WHERE mail_address = :mailAddress AND password = :password;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress",mailAddress).addValue("password", password);
		Administractor administractor = template.queryForObject(sql, param,ADMIN_ROW_MAPPER);
		if(administractor == null) {
			return null;
		}else {
			return administractor;
		}
	}
}

