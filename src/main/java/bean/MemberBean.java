package bean;

public class MemberBean {

	private Integer user_id;
	private String nick;
	private String account;
	private String password;
	private int status;
	private String name;
	private String img;
	private String sex;
	private String birthday;
	private String cellphone;
	private String email;
	private String joinDate;

	@Override
	public String toString() {
		return "MemberBean [user_id=" + user_id + ", nick=" + nick + ", account=" + account + ", password=" + password
				+ ", status=" + status + ", name=" + name + ", img=" + img + ", sex=" + sex + ", birthday=" + birthday
				+ ", cellphone=" + cellphone + ", email=" + email + ", joinDate=" + joinDate + "]";
	}
	public MemberBean(Integer user_id, String nick, String account, String password, int status, String name, String img,
			String sex, String birthday, String cellphone, String email, String joinDate) {
		super();
		this.user_id = user_id;
		this.nick = nick;
		this.account = account;
		this.password = password;
		this.status = status;
		this.name = name;
		this.img = img;
		this.sex = sex;
		this.birthday = birthday;
		this.cellphone = cellphone;
		this.email = email;
		this.joinDate = joinDate;
	}
	public MemberBean() {
		
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void  setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
	
}
