package com.newt.my.training.Entity;





	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="stub_tbl")
	public class Student {
		 @Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    private int sid;
		 
		    @Column
		    private String sname;
		 
		    
		    @Column
		    private int smarks;


			public int getSid() {
				return sid;
			}


			public void setSid(int sid) {
				this.sid = sid;
			}


			public String getSname() {
				return sname;
			}


			public void setSname(String sname) {
				this.sname = sname;
			}


			public int getSmarks() {
				return smarks;
			}


			public void setSmarks(int smarks) {
				this.smarks = smarks;
			}
		 
		   
		 
		 
		}
		







