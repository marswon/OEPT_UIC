package com.oept.uic.unit.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.snmp4j.mp.SnmpConstants;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.oept.uic.dao.UserDao;
import com.oept.uic.dao.impl.UserDaoImpl;
import com.oept.uic.model.User;

@SuppressWarnings("deprecation")
public class UnitTest {

	//private static Log logger = LogFactory.getLog(WebServiceManagerTest.class);
	@Test
	public void testFunc() throws Exception {
		try{
//			PropFileManager fm = new PropFileManager("interface.properties");
//
//			String strURI = fm.getProperty("ContentManagerAPI.uri");
//
//			//logger.info("test test test");
//			//POST
//			String apiName = fm.getProperty("ContentManagerAPI.login.post");
//			CmAuthAPIObj userlogin = new CmAuthAPIObj();
//			userlogin.setUsername(fm.getProperty("ContentManagerAPI.username"));
//			userlogin.setPassword(fm.getProperty("ContentManagerAPI.password"));
//			userlogin.setRememberMe(Boolean.parseBoolean(fm.getProperty("ContentManagerAPI.loginParam.rememberMe")));
//			WebServiceManager ws = new WebServiceManager();
//
//			Map<String, Object> response = ws.sendRESTRequestPost(strURI+apiName, userlogin);
//			System.out.println(response);
//			System.out.println(response.get("status"));
//			System.out.println(((Map<String,Object>) response.get("user")).get("username"));
//			//Get
////			apiName = fm.getProperty("ContentManagerAPI.getSession.get");
////			response = ws.sendRESTRequestGet(strURL+apiName, true);
//			
//			apiName = fm.getProperty("ContentManagerAPI.listMedia.get");
//			String params = "?limit=2&offset=0&sort=name";
//			response = ws.sendRESTRequestGetwithAPIToken(strURI+apiName+params);
//			
//			ResourceBundle rb = ResourceBundle.getBundle("language/messages", Locale.US);
//			String message1 = rb.getString("main.title");
//			
//			
//			System.out.println(message1);
//
//			assertNotNull(rb);
			
//			CmAPIMediaListInt mediaList = new CmAPIMediaListImpl();
//			mediaList.generateList("?limit=10&offset=0&sort=name");
//			System.out.println(mediaList.getMediaList());
//			System.out.println(mediaList.getMediaListCount());
//			System.out.println(mediaList.getMediaListOffset());
//			System.out.println(mediaList.getMedia(1));
			
			//System.out.println(System.getProperty("java.class.path"));
//			ApplicationContext  context = new ClassPathXmlApplicationContext("config/beans.xml");
//			Resource resource = new ClassPathResource("../WebContent/WEB-INF/springMVC.xml");
//			
//			userDao userdao = (userDao) context.getBean("userDao");
//			User user = new User();
//			user.set_NAME("test1");
//			user.set_PASSWORD("1234");
//			userdao.insertUser(user);
//			SnmpUtil util = new SnmpUtil();
//			util.initComm();
//			util.sendPDU();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}