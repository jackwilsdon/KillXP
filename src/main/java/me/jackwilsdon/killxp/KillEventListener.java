package com.jackwilsdon.KillXP;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillEventListener implements Listener {

	KillPlugin plugin;

	public KillEventListener(KillPlugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent pDeath)
	{
		if (pDeath.getEntity().getKiller() != null)
		{
			Player killer = pDeath.getEntity().getKiller();
			
			boolean dropXP = plugin.getConfig().getBoolean("KillXP.drop-on-pvp.drop-xp");
			int xpToGive = plugin.getConfig().getInt("KillXP.drop-on-pvp.killer-xp-given");
			if (!dropXP)
			{
				pDeath.setKeepLevel(true);
				pDeath.setDroppedExp(0);
			}
			
			killer.giveExp(xpToGive);
		} else {
			boolean dropXP = plugin.getConfig().getBoolean("KillXP.drop-on-death.drop-xp");
			
			if (!dropXP)
			{
				pDeath.setKeepLevel(true);
				pDeath.setDroppedExp(0);
			}
		}
	}
}
