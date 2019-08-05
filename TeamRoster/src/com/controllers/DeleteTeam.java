package com.controllers;

import com.models.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteTeam
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		// Removes indexed player from the instantiated list
		rTeams.remove(Integer.parseInt(request.getParameter("id")));
		
		// Sets the roster for r
		r.setTeams(rTeams);
		
		// Overwrites session roster with new roster
		session.setAttribute("roster", r);
		
		// Let the view handle the request
		response.sendRedirect("Home");
}

}
