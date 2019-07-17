package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.dao.JDBCParkDAO;
import com.techelevator.npgeek.model.dao.Park;
import com.techelevator.npgeek.model.dao.ParkDAO;


public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {
	

	private ParkDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	
	@Before
	public void setup() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCParkDAO(dataSource);
		
	}

	@Test
	public void get_all_parks_returns_all_parks() {
		List<Park> parkList = dao.getAllParks();
		
		int parkListOriginalSize = parkList.size();
		
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + 
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES ('CODE', 'TEST', 'TEST', 10, 10, 10.0, 10, 'TEST', 1999, 10, 'TEST', 'TEST', 'TEST', 10, 10);";
		jdbcTemplate.update(sql);
		
		List<Park> parkListTwo = dao.getAllParks();
		int parkListNewSize = parkListTwo.size();
		
		Assert.assertEquals(parkListOriginalSize + 1, parkListNewSize);
	}
	
	@Test
	public void get_park_by_code_returns_park() {
		
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + 
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES ('CODE', 'TEST', 'TEST', 10, 10, 10.0, 10, 'TEST', 1999, 10, 'TEST', 'TEST', 'TEST', 10, 10);";
		jdbcTemplate.update(sql);
		
		Park actual = dao.getParkByCode("CODE");
		
		Assert.assertEquals("CODE", actual.getParkCode());
	}
	
}
