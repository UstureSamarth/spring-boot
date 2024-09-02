package in.app.comp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.app.dto.*;

@Repository
public class EmployeeDaoImpl implements IEmplyeeDAO {

	private static final String SELECT_ALL_QUERY = "select eid,ename,eage,eaddress from Employee ;";
	
	@Autowired
	private DataSource datasource;

	@Override
	public List<Employee> findAllEmployees() {
		System.out.println(datasource.getClass().getName());
		List<Employee> lEo = new ArrayList<Employee>();
		try (Connection connection = datasource.getConnection();
				PreparedStatement psmt = connection.prepareStatement(SELECT_ALL_QUERY);) {
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				Integer eid = rs.getInt(1);
				String eName = rs.getString(2);
				Integer eAge = rs.getInt(3);
				String eAddr = rs.getString(4);
				emp.setEid(eid);
				emp.setEname(eName);
				emp.setEage(eAge);
				emp.setEaddress(eAddr);
				lEo.add(emp);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lEo;
	}

}
