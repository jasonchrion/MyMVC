package lxw.mymvc.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lxw.mymvc.servlet.mvc.SimpleUrlHandlerMapping;


public class ContextLoaderListener implements ServletContextListener {

    public ContextLoaderListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("应用初始化：读取配置文件");
    	ServletContext context = sce.getServletContext();
		String xmlpath = context.getInitParameter("mvc-config");
		String tomcatpath =context.getRealPath("\\");
		context.setAttribute("mymvc", SimpleUrlHandlerMapping.handleUrlMapping(tomcatpath+xmlpath));
		System.out.println("应用初始化完毕");
    }

    //应用
    public void contextDestroyed(ServletContextEvent sce) {
       
    }
	
}
