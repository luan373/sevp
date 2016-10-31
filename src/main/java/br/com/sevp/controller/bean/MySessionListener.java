package br.com.sevp.controller.bean;

import java.util.Date;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	public MySessionListener() {

	}

	public void sessionCreated(HttpSessionEvent event) {

		System.out.println("Current Session created : " + event.getSession().getId() + " at " + new Date());

	}

	public void sessionDestroyed(HttpSessionEvent event) {

		// get the destroying session...

		HttpSession session = event.getSession();

		System.out.println("Current Session destroyed :" + session.getId() + " Logging out user...");

		// Only if needed

		try {

			prepareLogoutInfoAndLogoutActiveUser(session);

		} catch (Exception e) {
			System.out.println("Error while logging out at session destroyed : " + e.getMessage());

		}

	}

	/**
	 * Clean your logout operations.
	 */

	public void prepareLogoutInfoAndLogoutActiveUser(HttpSession httpSession) {
		FacesContext fc = FacesContext.getCurrentInstance();
		NavigationHandler nav = fc.getApplication().getNavigationHandler();
		nav.handleNavigation(fc, null, "/login.xhtml");
	}
}
