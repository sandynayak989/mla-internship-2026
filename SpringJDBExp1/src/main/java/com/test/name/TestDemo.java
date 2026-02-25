package com.test.name;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.MLATeamDao;
import com.test.dao.MLATeamDao1;
import com.test.model.MLATeam;


public class TestDemo {

	public static void main(String[] args) {
//		MLATeamDao dao = new MLATeamDao();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		MLATeamDao dao = ctx.getBean("tdao",MLATeamDao.class);
		MLATeamDao1 dao1= ctx.getBean("tdao1",MLATeamDao1.class);
		MLATeam obj = new MLATeam();
		
		obj.setId(104);
		obj.setName("Raju");
		obj.setSkill("c#");
		obj.setManager("Dinesh");
		
		dao1.createMLATeam(obj);
		
//		dao.saveMLATeam(obj); //insert
//		dao.updateMLATeam(obj); //update
//		dao.deletMLATeamMember(obj); //delete
		

		
		
		List<MLATeam> list = dao.getAllMembers();
		list.forEach(team->System.out.println(team.getId()+" "+team.getName()+" "+team.getSkill()+" "+team.getManager()));
		
	}

}
