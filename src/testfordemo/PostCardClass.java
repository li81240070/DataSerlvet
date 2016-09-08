package testfordemo;

public class PostCardClass {

    private String couponsname,couponsstarttime,couponsendtime,couponscontent,couponsid,couponsrules1,couponsrules2,username,token,couponsonlytype;
    private int couponssharestate,couponstype,couponsstate,couponslowprice;
	public String getCouponsname() {
		return couponsname;
	}
	public void setCouponsname(String couponsname) {
		this.couponsname = couponsname;
	}
	public String getCouponsstarttime() {
		return couponsstarttime;
	}
	public void setCouponsstarttime(String couponsstarttime) {
		this.couponsstarttime = couponsstarttime;
	}
	public String getCouponsendtime() {
		return couponsendtime;
	}
	public void setCouponsendtime(String couponsendtime) {
		this.couponsendtime = couponsendtime;
	}
	public String getCouponscontent() {
		return couponscontent;
	}
	public void setCouponscontent(String couponscontent) {
		this.couponscontent = couponscontent;
	}
	public String getCouponsid() {
		return couponsid;
	}
	public void setCouponsid(String couponsid) {
		this.couponsid = couponsid;
	}
	public String getCouponsrules1() {
		return couponsrules1;
	}
	public void setCouponsrules1(String couponsrules1) {
		this.couponsrules1 = couponsrules1;
	}
	public String getCouponsrules2() {
		return couponsrules2;
	}
	public void setCouponsrules2(String couponsrules2) {
		this.couponsrules2 = couponsrules2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCouponsonlytype() {
		return couponsonlytype;
	}
	public void setCouponsonlytype(String couponsonlytype) {
		this.couponsonlytype = couponsonlytype;
	}
	public int getCouponssharestate() {
		return couponssharestate;
	}
	public void setCouponssharestate(int couponssharestate) {
		this.couponssharestate = couponssharestate;
	}
	public int getCouponstype() {
		return couponstype;
	}
	public void setCouponstype(int couponstype) {
		this.couponstype = couponstype;
	}
	public int getCouponsstate() {
		return couponsstate;
	}
	public void setCouponsstate(int couponsstate) {
		this.couponsstate = couponsstate;
	}
	public int getCouponslowprice() {
		return couponslowprice;
	}
	public void setCouponslowprice(int couponslowprice) {
		this.couponslowprice = couponslowprice;
	}
	public PostCardClass(String couponsname, String couponsstarttime,
			String couponsendtime, String couponscontent, String couponsid,
			String couponsrules1, String couponsrules2, String username,
			String token, String couponsonlytype, int couponssharestate,
			int couponstype, int couponsstate, int couponslowprice) {
		super();
		this.couponsname = couponsname;
		this.couponsstarttime = couponsstarttime;
		this.couponsendtime = couponsendtime;
		this.couponscontent = couponscontent;
		this.couponsid = couponsid;
		this.couponsrules1 = couponsrules1;
		this.couponsrules2 = couponsrules2;
		this.username = username;
		this.token = token;
		this.couponsonlytype = couponsonlytype;
		this.couponssharestate = couponssharestate;
		this.couponstype = couponstype;
		this.couponsstate = couponsstate;
		this.couponslowprice = couponslowprice;
	}
	public PostCardClass() {
		super();
	}

  
}
