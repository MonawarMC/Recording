package com.bwfcwalshy.recording;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	ArrayList<Player> recording = new ArrayList<Player>();
	
	public void onEnable(){
		getCommand("record").setExecutor(new Recording(this));
		getServer().getPluginManager().registerEvents(new Chat(this), this);
	}
	public void onDisable(){ recording.clear(); }
}
