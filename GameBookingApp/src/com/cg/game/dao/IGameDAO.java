package com.cg.game.dao;

import java.util.List;

import com.cg.game.bean.GameDetails;
import com.cg.game.exception.GameException;

public interface IGameDAO 
{
	List<GameDetails> getGameDetails() throws GameException ;
	
	GameDetails getGameDetail(String gameId) throws GameException;

	void updateGameDetails(int seats, String gameName) throws GameException;
}
