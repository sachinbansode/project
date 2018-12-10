package com.scp.HbNtv.HbNav;


import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestNativeQueries {
	
	public static void main(String[] args) {
		
		Mobile mobile1= new Mobile(1, "A1", 15000, "appo");
		Mobile mobile2= new Mobile(2, "J7", 20000, "Samsung");
		Mobile mobile3= new Mobile(3, "note", 80000, "mi");
		Mobile mobile4= new Mobile(4, "note3", 10000, "Xiomi");
		Mobile mobile5= new Mobile(5, "iphoneX", 550000, "iphone");
		
	//first change
		//sachin
		 
		 Configuration configuration= new Configuration();
			SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tr= session.beginTransaction();
			
			session.save(mobile1);
			session.save(mobile2);
			session.save(mobile3);
			session.save(mobile4);
			session.save(mobile5);
			
			session.flush();
			tr.commit();
			
		 
		 
	}

}
@NamedNativeQueries({
    @NamedNativeQuery(name = "getallmobiles", query = "select * from mobile_info"),
    @NamedNativeQuery(name = "getallMobilepriceGt20k", query = "select * from mobile_info where mobileprice>20000")
})


@Entity
@Table(name="mobile_info")
class Mobile
{
	@Id
	private int mobileId;
	private String mobileName;
	private int mobilrPrice;
	private String vendorName;
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public int getMobilrPrice() {
		return mobilrPrice;
	}
	public void setMobilrPrice(int mobilrPrice) {
		this.mobilrPrice = mobilrPrice;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobilrPrice=" + mobilrPrice
				+ ", vendorName=" + vendorName + "]";
	}
	public Mobile(int mobileId, String mobileName, int mobilrPrice, String vendorName) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobilrPrice = mobilrPrice;
		this.vendorName = vendorName;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}




