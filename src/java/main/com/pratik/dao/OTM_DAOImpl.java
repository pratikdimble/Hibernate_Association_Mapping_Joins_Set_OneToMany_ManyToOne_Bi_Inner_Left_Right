package com.pratik.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.PhoneNumber;
import com.pratik.domain.User;
import com.pratik.utility.HibernateUtil;

public class OTM_DAOImpl implements OTM_DAO {
 
	@Override
	public void SaveDataUsingChild() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 user=new User();
		 //user.setUserId(1001);
		 user.setFirstName("rohit");
		//child objs
		 ph1=new PhoneNumber();
		ph1.setPhone(999999988);
		ph1.setNumberType("office");
		ph1.setOperator("Idea");

		 ph2=new PhoneNumber();
		ph2.setPhone(88888877);
		ph2.setNumberType("home");
		ph2.setOperator("Airtel");

		ph1.setPerson(user);
		ph2.setPerson(user);
		
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		//set childs to parent
		user.setPhones(childs);

		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(ph1);
		   ses.save(ph2);
		 tx.commit();
		 System.out.println("Objects are saved....");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}//method
					//Inner Join
	@Override
	public void loadDataUsingChildInnerJoin() {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		List<Object[]> list=null;
		User user=null;
		
		//get Session
		//ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("select u.userId,u.firstName,ph.phone,ph.numberType,ph.Operator"
									+ " from PhoneNumber ph inner join ph.person u");
		//execute Query
		list=query.list();
		//process the Results
		list.forEach(row->{
			for(Object val:row) {
				System.out.println(val+" ");
			}
			System.out.println("\n--------------");
		});
	}//method

				//Left Join
	
	@Override
	public void loadDataUsingChildLeftJoin() {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		List<Object[]> list=null;
		User user=null;
		
		//get Session
		//ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("select u.userId,u.firstName,ph.phone,ph.numberType,ph.Operator"
									+ " from PhoneNumber ph left join ph.person u");
		//execute Query
		list=query.list();
		//process the Results
		list.forEach(row->{
			for(Object val:row) {
				System.out.println(val+" ");
			}
			System.out.println("\n--------------");
		});
	}//method
	@Override
	public void loadDataUsingChildRightJoin() {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		List<Object[]> list=null;
		User user=null;
		
		//get Session
		//ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("select u.userId,u.firstName,ph.phone,ph.numberType,ph.Operator"
									+ " from PhoneNumber ph right join ph.person u");
		//execute Query
		list=query.list();
		//process the Results
		list.forEach(row->{
			for(Object val:row) {
				System.out.println(val+" ");
			}
			System.out.println("\n--------------");
		});
		
	}
}//class
