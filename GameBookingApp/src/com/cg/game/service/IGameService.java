package com.cg.game.service;

import java.util.List;

import com.cg.game.bean.GameDetails;
import com.cg.game.exception.GameException;

public interface IGameService 
{
	
	
	public void updateGameDetails(int seats , String gameName) throws GameException ;
	List<GameDetails> getGameDetails() throws GameException;
	GameDetails getGameDetail(String gameId) throws GameException;
}
