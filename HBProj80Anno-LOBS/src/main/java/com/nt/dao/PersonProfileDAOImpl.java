//PersonProfileDAOImpl.java
package com.nt.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonProfile;
import com.nt.utility.HibernateUtil;

public class PersonProfileDAOImpl implements IPersonProfileDAO {

	@Override
	public void saveData(){
		//get Session 
		Session ses=HibernateUtil.getSession();
		File file=new File("E:/classcontent/images/biodata.txt");
		Transaction tx=null;
		try(ses;	 FileInputStream fis=new FileInputStream("E:\\classcontent\\images\\deepu.jpeg");
			FileReader reader=new FileReader(file)){	 
			//retrive  photo file content  to  byte[]
            byte[] photoContent=new byte[fis.available()];
            fis.read(photoContent);
			//retrive  resume file content  to char[]
            char[]  resumeContent=new char[(int)file.length()];
            reader.read(resumeContent);
          //prepre object
            PersonProfile profile=new PersonProfile();
            profile.setPname("deepika");
            profile.setResume(resumeContent);
            profile.setPhoto(photoContent);
            //begin Tx
             tx=ses.beginTransaction();
               ses.save(profile);
              tx.commit();
              System.out.println("Object is saved");
		}
		catch(Exception e) {
			e.printStackTrace();
			   if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				    tx.rollback();
				    System.out.println("Problem in saving object");
			   }
		}

	}
	
	@Override
	public void loadData() {
		//get Session 
		Session ses=HibernateUtil.getSession();
		try(ses; FileOutputStream fos=new FileOutputStream("retrieved_photo.jpeg");
				FileWriter writer=new FileWriter("retrieved_resume.txt")){	 
		    //Load object
		  PersonProfile profile=ses.get(PersonProfile.class, 70);
		  if(profile!=null) {
		      System.out.println(profile.getPid()+"  "+profile.getPname());
		      byte[] photoContent=profile.getPhoto();
		      char[] resumeContent=profile.getResume();
		      fos.write(photoContent);
		      writer.write(resumeContent);
		      System.out.println("LOB files are retrieved");
		  }
		  else {
			  System.out.println("Person not found");
		  }
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
