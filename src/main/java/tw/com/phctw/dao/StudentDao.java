//Model層

package tw.com.phctw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tw.com.phctw.bean.RandomStudent;
import tw.com.phctw.bean.Student;
import tw.com.phctw.utils.JDBCUtils;

public class StudentDao {
	
	public List<Student> selectStudent() throws SQLException{
		System.out.println("進入model層 並準備搜尋資料");
		List<Student> ls = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT2";
		
		//1.獲取資料庫資訊
		Connection con = JDBCUtils.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		//2.從結果提取資料
		while(rs.next()) {
			Student st = new Student();
			st.setSno(rs.getString("SNO"));
			st.setSname(rs.getString("SNAME"));
			st.setSbday(rs.getDate("SBDAY"));
			st.setSsex(rs.getInt("SSEX"));
			st.setSid(rs.getString("SID"));
			//新增設定年齡
			st.setAge(RandomStudent.getAgeByBirth(st.getSbday()));
			ls.add(st);
		}
		//3.關閉連線
		JDBCUtils.close(rs,stmt,con);
		return ls;
	}
	
	//新增學生資料dao
	public Integer insertStudents(List<Student> student) throws SQLException {
		//插入多筆就用List方式 一筆一筆擷取再存入db
		Integer flag = 0;
		System.out.println("進入model層 並準備插入資料");
		String sql = "INSERT  INTO STUDENT2(SNO,SNAME,SBDAY,SSEX,SID) VALUES(?,?,?,?,?)";
		
		//1.獲取資料庫資訊
		Connection con = JDBCUtils.getConnection();
		PreparedStatement  stmt =  con.prepareStatement(sql);
		for(Student stu:student) {
			System.out.println("學號:" + stu.getSno());
			System.out.println("身分證:" + stu.getSid());
			stmt.setString(1, stu.getSno());
			stmt.setString(2, stu.getSname());
			stmt.setDate(3, (java.sql.Date)(stu.getSbday()));
			stmt.setInt(4, stu.getSsex());
			stmt.setString(5, stu.getSid());
			
			//2.插入資料
			int success = stmt.executeUpdate();
			if(success >=1 ) {
				flag +=1 ;
				System.out.println("插入資料成功");
			}else {
				System.out.println("插入資料失敗");
			}
		}
		//3.關閉連線
		JDBCUtils.close(con, stmt);
		return flag;
	}
	
}
