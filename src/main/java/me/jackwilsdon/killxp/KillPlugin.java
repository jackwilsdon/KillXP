package com.jackwilsdon.killxp;
 
import org.bukkit.plugin.java.JavaPlugin;

public class KillPlugin extends JavaPlugin {

    @Override
    public void onEnable()
    {
    	getLogger().info(getDescription().getFullName()+" enabled!");
    	saveDefaultConfig();
    	getServer().getPluginManager().registerEvents(new KillEventListener(this), this);
    }

    @Override
    public void onDisable()
    {
    	getLogger().info(getDescription().getFullName()+" disabled!");
    }
}
