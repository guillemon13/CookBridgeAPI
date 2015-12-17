package edu.upc.ase.helper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

import io.swagger.model.Application;
import io.swagger.model.Chef;
import io.swagger.model.JobOffer;
import io.swagger.model.Restaurant;
import io.swagger.model.Work;

/**
 * OfyHelper, a ServletContextListener, is setup in web.xml to run before a JSP
 * is run. This is required to let JSP's access Ofy.
 **/
public class OfyHelper implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		// This will be invoked as part of a warmup request, or the first user
		// request if no warmup
		// request.
		ObjectifyService.register(Chef.class);
		ObjectifyService.register(Work.class);
		ObjectifyService.register(Restaurant.class);
		ObjectifyService.register(Application.class);
		ObjectifyService.register(JobOffer.class);
	}

	public void contextDestroyed(ServletContextEvent event) {
		// App Engine does not currently invoke this method.
	}
}