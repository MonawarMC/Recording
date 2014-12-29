package com.Monawar.recording;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Chat implements Listener {

	Main main;
	public Chat(Main pl){
		this.main = pl;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if(main.recording.contains(e.getPlayer())){
			e.setCancelled(true);
		}
		for(Player p : main.recording){
			if(e.getMessage().contains(p.getName())){
				e.getPlayer().sendMessage(ChatColor.RED + "That player is recording and did not receive your message.");
			}
		}
	}
	@EventHandler
	public void onMsg(PlayerCommandPreprocessEvent e){
		for(Player p : main.recording){
			if(e.getMessage().contains("/msg") && e.getMessage().contains(p.getName())){
				e.setCancelled(true);
			}
		}
	}
}
