/**************************************************************
File Name   : ShowDAOImpl.java
Author      : Vinayak Kanase.
Description : Performin various operation on database
***************************************************************/
package com.cg.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.game.bean.GameDetails;
import com.cg.game.exception.GameException;
import com.cg.game.util.DBUtil;

public class GameDAOImpl implements IGameDAO 
{
	Connection con ;
	Statement stm ;
	PreparedStatement pstm ;
	ResultSet res ;

	@Override
	public List<GameDetails> getGameDetails() throws GameException 
	{
		List<GameDetails> games = new ArrayList<GameDetails>();
		try
		{
			con = DBUtil.getConnection();
			stm = con.createStatement();
			res = stm.executeQuery("select * from Games");
			while(res.next())
			{
				GameDetails game = new GameDetails() ;
				game.setGameId(res.getString(1));
				game.setGameName(res.getString(2));
				game.setLocation(res.getString(3));
				game.setGameDate(res.getDate(4));
				game.setAvSeats(res.getInt(5));
				game.setPriceTicket(res.getDouble(6));
				games.add(game);
			}
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new GameException("Something went wrong while fetching game Details");
		}
		finally
		{
			try 
			{
				res.close();
				stm.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace();
				throw new GameException("SQLException occurred");
			}
		}
		return games;
	}

	@Override
	public GameDetails getGameDetail(String gameId) throws GameException {
		GameDetails game = null ;
		try
		{
			con = DBUtil.getConnection();
			pstm = con.prepareStatement("select * from Games where gameId=?");
			pstm.setString(1, gameId);
			res = pstm.executeQuery() ;
			res.next() ;
			game= new GameDetails() ;
			game.setGameId(res.getString(1));
			game.setGameName(res.getString(2));
			game.setLocation(res.getString(3));
			game.setGameDate(res.getDate(4));
			game.setAvSeats(res.getInt(5));
			game.setPriceTicket(res.getDouble(6));
			
			
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new GameException("Problem while fetching game details");
		}
		finally
		{
			try 
			{
				res.close();
				pstm.close();
				con.close();
			} 
			catch (SQLException e)
			{
				//e.printStackTrace();
				throw new GameException("SQLException occurred");
			}
			
		}
		return game;
		
	}

	@Override
	public void updateGameDetails(int seats , String gameName) throws GameException 
	{
		try
		{
			System.out.println("updating..");
			con = DBUtil.getConnection() ;
			
			pstm = con.prepareStatement("update Games set AvSeats = ? where gameName = ?") ;
			pstm.setInt(1, seats);
			pstm.setString(2, gameName);
			pstm.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new GameException("Problem while updating the table");
		}
	}

}
