package java63.servlets.test04;

import java.io.InputStream;
import java63.servlets.test04.dao.StudentDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ContextLoaderListener implements ServletContextListener {
  
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      StudentDao studentDao = new StudentDao();
      studentDao.setSqlSessionFactory(sqlSessionFactory);
      
      ctx.setAttribute("studentDao", studentDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
