package com.controllers;

import com.models.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
		view.forward(request,  response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session
		HttpSession session = request.getSession();
		
		// Instantiates the Roster from session
		Roster r = (Roster) session.getAttribute("roster");
		
		// Instantiates the teams ArrayList from Roster
		ArrayList<Team> rTeams = r.getTeams();
		
		// Grabs Team object from ArrayList using the form data
		Team t = rTeams.get(Integer.parseInt(request.getParameter("id")));
		
		// Sets the Team as the model for the view
		request.setAttribute("team", t);
		request.setAttribute("index", Integer.parseInt(request.getParameter("id")));
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		view.forward(request,  response);	
	}

}