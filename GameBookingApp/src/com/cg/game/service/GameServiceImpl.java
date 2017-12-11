package com.cg.game.service;

import java.util.List;

import com.cg.game.bean.GameDetails;
import com.cg.game.dao.IGameDAO;
import com.cg.game.dao.GameDAOImpl;
import com.cg.game.exception.GameException;

public class GameServiceImpl implements IGameService 
{
	IGameDAO showDAO ;
	
	public GameServiceImpl()
	{
		showDAO = new GameDAOImpl();
	}
	
	@Override
	public List<GameDetails> getGameDetails() throws GameException 
	{
		return showDAO.getGameDetails();
	}

	@Override
	public GameDetails getGameDetail(String gameId) throws GameException 
	{
		return showDAO.getGameDetail(gameId);
	}

	@Override
	public void updateGameDetails(int seats, String gameName)
			throws GameException {

		 showDAO.updateGameDetails(seats , gameName);
	}
}
