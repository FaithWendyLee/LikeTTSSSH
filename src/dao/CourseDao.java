package dao;

import java.util.ArrayList;

import model.Course;

public interface CourseDao {

	public ArrayList<Course> getCourseList();

	public void addCourse(Course c);

	public Course getCourse(int courseid);

	public void alterCourse(Course c);


}
