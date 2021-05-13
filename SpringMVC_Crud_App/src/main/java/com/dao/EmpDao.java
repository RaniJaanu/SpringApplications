package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Emp;

public class EmpDao {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Emp e){
		String sql="insert into Employee(name,salary,designation,phoneno,email) values('"+e.getName()+"',"+e.getSalary()+",'"+e.getDesignation()+"',"+e.getPhoneno()+",'"+e.getEmail()+"')";
		return template.update(sql);
		}
		public int update(Emp e){
		String sql="update Employee set name='"+e.getName()+"', salary="+e.getSalary()+",designation='"+e.getDesignation()+"' ,phoneno="+e.getPhoneno()+",email= '"+e.getEmail()+"' where id="+e.getId()+"";
		return template.update(sql);
		}
		public int delete(int id){
			String sql="delete from Employee where id="+id+"";
			return template.update(sql);
			}
			public Emp getEmpById(int id){
			String sql="select * from Employee where id=?";
			return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
			}
			public List<Emp> getEmployees(){
			return template.query("select * from Employee",new RowMapper<Emp>(){
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
			e.setDesignation(rs.getString(4));
			e.setPhoneno(rs.getLong(5));
			e.setEmail(rs.getString(6));
			return e;
			}
			});
			}
		
		
}
