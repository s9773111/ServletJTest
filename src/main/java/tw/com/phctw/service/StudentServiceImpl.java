package tw.com.phctw.service;

import java.sql.SQLException;
import java.util.List;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> selectStudent() throws SQLException {
		StudentDao std = new StudentDao();
		List<Student> result = std.selectStudent();
		return result;
	}
	
	@Override
	public  Integer insertStudent(List<Student> student) throws SQLException {
		StudentDao std = new StudentDao();
		Integer flag = std.insertStudents(student);
		return flag;
	}
}

