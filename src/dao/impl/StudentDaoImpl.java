package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Assistant;
import model.Student;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	// protected Logger log = Logger.getLogger(this.getClass());
	@Resource
	private SessionFactory sessionFactory;
	private static StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

	public  StudentDaoImpl getInstance() {
		return studentDaoImpl;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Student> getStudentList() {
		ArrayList<Student> slist = (ArrayList<Student>) new HibernateTemplate(sessionFactory).find("from Student");
		return slist;

	}

	public void add(Student stu) {
//		try {
//		Configuration config = new Configuration().configure();
//		@SuppressWarnings("deprecation")
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction tx=session.beginTransaction();
//		session.save(stu);
//		tx.commit();
//		session.close();
//		sessionFactory.close();
//		//this.getHibernateTemplate().save(user);
//		System.out.println("ok");
//	    } 
//		catch (Exception e) {
//		e.printStackTrace();
//	    }
		new HibernateTemplate(sessionFactory).save(stu);
		
	}

		//
		// Class.forName("com.mysql.jdbc.Driver").newInstance();
		//
		// Connection connection = DriverManager.getConnection(url);
		// PreparedStatement stmt=null;
		// try {
		// stmt=connection.prepareStatement("insert into student(stuid,stuname,stupwd) values(1,'a','a')");
		// stmt.setLong(1, stu.getId());
		// stmt.setString(2, stu.getName());
		// stmt.setString(3, stu.getPwd());
		//
		// stmt.executeUpdate();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	

	// public Student find(String name, String password) {
	// // 驱动程序名
	// String driverName = "com.mysql.jdbc.Driver";
	// // 数据库用户名
	// String userName = "root";
	// // 密码
	// String userPasswd = "";
	// // 数据库名
	// String dbName = "myscoredata";
	// // 表名
	// String tableName = "student";
	// // 联结字符串
	// String url = "jdbc:mysql://localhost/" + dbName + "?user=" + userName
	// + "&password=" + userPasswd;
	//
	// // System.out.println(url);
	// Student stu = null;
	//
	// try {
	// Class.forName("com.mysql.jdbc.Driver").newInstance();
	//
	// Connection connection = DriverManager.getConnection(url);
	// Statement statement = connection.createStatement();
	// String sql = "SELECT * FROM " + tableName; // 注意FROM后面有空格。
	// ResultSet rs = statement.executeQuery(sql);
	// // 输出每一个数据值
	// while (rs.next()) {
	// if ((name.equals(rs.getString(2).trim()) && (password.equals(rs
	// .getString(3).trim())))) {
	// double score = Double.parseDouble(rs.getString(4).trim());
	// stu = new Student(name, score);
	// }
	// }
	// rs.close();
	// connection.close();
	// }
	//
	// catch (Exception ex) {
	// System.out.println(ex);
	// System.exit(0);
	// }
	// return stu;
	// }

	public Student findById(int stuid) {
		Student stu = new HibernateTemplate(sessionFactory).get(Student.class, stuid);
		return stu;
	}

	public void updateStudent(Student stu) {
		new HibernateTemplate(sessionFactory).update(stu);
	}

	@Override
	public Student findStudent(String name, String pw) {
		String hql = "from Student s where s.stuname=? and s.stupwd=?";
		Student s = (Student) new HibernateTemplate(sessionFactory).find(hql,new String[]{name, pw}).get(0);
		return s;
	}
}
