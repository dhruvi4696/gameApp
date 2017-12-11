/**************************************************************
File Name   : ShowController.java
Author      : Vinayak Kanase.
Description : Consist of Logic 
***************************************************************/
package com.cg.game.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.game.bean.GameDetails;
import com.cg.game.exception.GameException;
import com.cg.game.service.GameServiceImpl;
import com.cg.game.service.IGameService;


@WebServlet(urlPatterns={"/listAllGames","/getGameDetails","/BookGame"})
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGameService gameService ;
    public GameController() 
    {
        super();
        gameService = new GameServiceImpl();
       
    }

	public void init(ServletConfig config) throws ServletException 
	{
		
	}

	public void destroy() 
	{
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//calling doPost in doGet
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath() ;
		String url="" ;
		
		try
		{
		switch (path) 
		{
			
			case "/listAllGames":
				System.out.println("Hello");
				List<GameDetails> gameList = gameService.getGameDetails();
				HttpSession session = request.getSession();
				session.setAttribute("gameList", gameList);
				url="gameDetails.jsp";
				break;
				
			case "/getGameDetails" :
				System.out.println("Getting Game Details");
				String gameid = request.getParameter("gameId") ;
				System.out.println(gameid);
				GameDetails game = gameService.getGameDetail(gameid);
				request.setAttribute("game", game);
				url="bookNow.jsp";
				break;
	
	
		
		
		case "/BookGame":
			String GameName = request.getParameter("txtGameName");
			double price = Double.parseDouble(request.getParameter("txtPrice")) ;
			String customerName = request.getParameter("txtCustName");
			long mob =Long.parseLong(request.getParameter("txtMobNo"));
			int availGames = Integer.parseInt(request.getParameter("txtGamesAvail"));
			int noOfGames = Integer.parseInt(request.getParameter("txtGamesBook"));
			
			if(noOfGames == 0 || noOfGames < 0)
			{
				throw new GameException("Please Enter valid no of Games");
			}
			
			if(availGames < noOfGames)
			{
				throw new GameException("Please Enter valid no of Games");
			}
			else
			{
				int updatedGames = availGames-noOfGames ;
				System.out.println(updatedGames+GameName);
				request.setAttribute("gamename", GameName);
				request.setAttribute("name", customerName);
				request.setAttribute("mobileNo", mob);
				request.setAttribute("noOfGames", noOfGames);
				double totalPrice = price * noOfGames;
				request.setAttribute("totalPrice", totalPrice);
				gameService.updateGameDetails(updatedGames , GameName);
				url = "success.jsp" ;
			}
			
			break ;
		
	default:
		break;
	}
		}
	catch(GameException e)
	{
		request.setAttribute("error", e.getMessage());
		url = "error.jsp" ;
	}
	
	
	RequestDispatcher rd = request.getRequestDispatcher(url);
	rd.forward(request, response);
}

		
		}
	
