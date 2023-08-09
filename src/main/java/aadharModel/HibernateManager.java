package aadharModel;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import aadharBin.AadharDetail;

public class HibernateManager {
	private Session session;

	 

    public HibernateManager() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
        ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

 

        session = sessionFactory.openSession();
        System.out.println("Connected to pf...");
    }
    
    public boolean register(AadharDetail ad) {
    	Transaction tran=session.beginTransaction();
    	Serializable save = session.save(ad);
    	tran.commit();
    	System.out.println("Object saved");
    	if(save==null) {
    		return false;
    	}
    	return true;
    }
    
    public List allUserDetails() {
    	Transaction tran=session.beginTransaction();
    	Query q = session.createQuery("From AadharDetail");
    	List li = q.list();
    	Iterator itr = li.iterator();
    	        
    	tran.commit();
    	return li;

    	
    }

	public void updateData(String aadharNo, String changeColumn, String newValue) {
		Transaction tran=session.beginTransaction();
		AadharDetail s = (AadharDetail) session.get(AadharDetail.class, aadharNo); // value is based on Primary key

		switch(changeColumn) {
		case "name":
			s.setName(newValue);
			break;
		case "father_name":
			s.setFatherName(newValue);
			break;
		case "email":
			s.setEmail(newValue);
			break;
		case "phone_no":
			s.setPhoneNo(newValue);
			break;
		}
		
		session.update(s);
		
		System.out.println("Update Success");
		tran.commit();
		
	}
	public void deleteData(String aadharNo) {
		Transaction tran=session.beginTransaction();
		AadharDetail s = (AadharDetail) session.get(AadharDetail.class, aadharNo); // value is based on Primary key
		
		session.delete(s);
		
		System.out.println("Delete Success");
		tran.commit();
		
	}

	public AadharDetail getSpecificUser(String aadharNo) {
		session.beginTransaction();
		AadharDetail s = (AadharDetail) session.get(AadharDetail.class, aadharNo);
		System.out.println(s.getName());
		
		return s;
		
	}
 

    
    
}
