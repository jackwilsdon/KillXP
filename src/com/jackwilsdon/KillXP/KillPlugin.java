package com.jackwilsdon.KillXP;
 
import org.bukkit.plugin.java.JavaPlugin;

/*
 * PvPointsPlugin
 * Main class - Manages enabling and disabling
 */
public class KillPlugin extends JavaPlugin {
	
	/*
	 * onEnable()
	 * Called on plugin enable
	 */
	public void onEnable()
	{
		/*
		 * Output enable message
		 */
		getLogger().info(getDescription().getFullName()+" enabled!");
		
		/*
		 * Save default config
		 */
		saveDefaultConfig();
		
		/*
		 * Register event listener
		 */
		getServer().getPluginManager().registerEvents(new KillEventListener(this), this);
	}
	
	/*
	 * onDisable()
	 * Called on plugin disable
	 */
	public void onDisable()
	{
		/*
		 * Output disable message
		 */
		getLogger().info(getDescription().getFullName()+" disabled!");
	}
}