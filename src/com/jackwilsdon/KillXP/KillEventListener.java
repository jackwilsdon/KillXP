package com.jackwilsdon.KillXP;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/*
 * PvPointsEventListener
 * Event listener for PvPoints
 */
public class KillEventListener implements Listener {

	/*
	 * Variables for plugin
	 */
	KillPlugin plugin;
	
	/*
	 * PvPointsEventListener()
	 * Constructor
	 */
	KillEventListener(KillPlugin pl)
	{
		plugin = pl;
	}
	
	/*
	 * onDeath()
	 * Called when a player is killed/dies
	 */
	@EventHandler
	public void onDeath(PlayerDeathEvent pDeath)
	{
		// Check if the player was killed by a player or by other means
		if (pDeath.getEntity().getKiller() != null)
		{
			// Get killer
			Player killer = pDeath.getEntity().getKiller();
			
			// Get config options
			boolean dropXP = plugin.getConfig().getBoolean("KillXP.drop-on-pvp.drop-xp");
			int xpToGive = plugin.getConfig().getInt("KillXP.drop-on-pvp.killer-xp-given");
			
			// Check if the player should not drop XP
			if (!dropXP)
			{
				pDeath.setKeepLevel(true);
				pDeath.setDroppedExp(0);
			}
			
			// Give the killer XP
			killer.giveExp(xpToGive);
		} else {
			// Get config options
			boolean dropXP = plugin.getConfig().getBoolean("KillXP.drop-on-death.drop-xp");
			
			// Check if player should not drop XP
			if (!dropXP)
			{
				pDeath.setKeepLevel(true);
				pDeath.setDroppedExp(0);
			}
		}
	}
}
