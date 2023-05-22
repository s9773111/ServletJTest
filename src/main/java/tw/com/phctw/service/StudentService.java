package tw.com.phctw.service;

import java.sql.SQLException;
import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentService {
	//查詢學生資料
	public List<Student> selectStudent() throws SQLException;

	//插入學生資料
	public Integer insertStudent(List<Student> studnet) throws SQLException;
}
