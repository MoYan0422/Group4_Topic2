
package bean;

import java.io.Serializable;
import java.sql.Date;

public class CourseBean implements Serializable {
	
	private int course_id;
	private int user_id;
	private int subject_id;
	private int education_id;
	private String course_name;
	private String course_introduction;
	private double course_price;
	private String course_duration;
	private int enrollment;
	private String course_date;
	private String lecturer_name;
	private String lecturer_email;
	private String course_picture;
	
	public CourseBean() {
		
	}

	

	

	public CourseBean(int course_id, int user_id, int subject_id, int education_id, String course_name,
			String course_introduction, double course_price, String course_duration, int enrollment, String course_date,
			String lecturer_name, String lecturer_email, String course_picture) {
		super();
		this.course_id = course_id;
		this.user_id = user_id;
		this.subject_id = subject_id;
		this.education_id = education_id;
		this.course_name = course_name;
		this.course_introduction = course_introduction;
		this.course_price = course_price;
		this.course_duration = course_duration;
		this.enrollment = enrollment;
		this.course_date = course_date;
		this.lecturer_name = lecturer_name;
		this.lecturer_email = lecturer_email;
		this.course_picture = course_picture;
	}
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_introduction() {
		return course_introduction;
	}

	public void setCourse_introduction(String course_introduction) {
		this.course_introduction = course_introduction;
	}

	public double getCourse_price() {
		return course_price;
	}

	public void setCourse_price(double course_price) {
		this.course_price = course_price;
	}

	public String getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public String getCourse_date() {
		return course_date;
	}

	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}

	public String getLecturer_name() {
		return lecturer_name;
	}

	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}

	public String getLecturer_email() {
		return lecturer_email;
	}

	public void setLecturer_email(String lecturer_email) {
		this.lecturer_email = lecturer_email;
	}

	public String getCourse_picture() {
		return course_picture;
	}

	public void setCourse_picture(String course_picture) {
		this.course_picture = course_picture;
	}

	@Override
	public String toString() {
		return "CourseBean [user_id=" + user_id + ", subject_id=" + subject_id + ", education_id=" + education_id
				+ ", course_name=" + course_name + ", course_introduction=" + course_introduction + ", course_price="
				+ course_price + ", course_duration=" + course_duration + ", enrollment=" + enrollment
				+ ", course_date=" + course_date + ", lecturer_name=" + lecturer_name + ", lecturer_email="
				+ lecturer_email + ", course_picture=" + course_picture + "]";
	}

	



	
	
	
	
	

	
	

}
