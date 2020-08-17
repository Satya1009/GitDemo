package section11;

public class GetCourse {
	
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		this.Url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	private String Url;
	private String services;
	private String expertise;
	private Course courses;  //Inject sub json to main json
	private String instructor;
	private String linkedin;

}
