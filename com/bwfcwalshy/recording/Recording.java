package com.bwfcwalshy.recording;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Recording implements CommandExecutor {

	Main main;
	public Recording(Main pl){ this.main = pl; }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("record")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("recording.record")){
					if(main.recording.contains(player)){
						Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " has finished recording.");
					}else{
						Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " is recording. Please do not disturb.");
					}
				}else{
					player.sendMessage(ChatColor.RED + "You do not have permission for that command.");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You have to be a player to do this command.");
			}
		}
		return false;
	}
}
