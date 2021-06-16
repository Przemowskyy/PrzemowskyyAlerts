package przemowskyy.przemowskyyalerts.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import przemowskyy.przemowskyyalerts.main.Main;

public class Alert implements CommandExecutor {

	Main plugin;
	
	public Alert(Main m) {
		plugin = m;
		m.getCommand("alert").setExecutor(this);
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender.hasPermission("alert.send")) {
			if(args.length >= 1) {
				StringBuilder sb = new StringBuilder();
				
				for(int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				
				String msg = sb.toString();
				
				switch(args[1].toLowerCase()) {
				case "chat":
					for(Player ps : Bukkit.getOnlinePlayers()) {
						ps.sendMessage("§8§l[§c§lUWAGA§8§l] §6" + msg.replace("&", "§"));
						break;
					}
				case "title":
					for(Player ps : Bukkit.getOnlinePlayers()) {
						ps.sendTitle("§c§l! UWAGA !", "§6" + msg.replace("&", "§"));
						break;
					}
				case "actionbar":
					for(Player ps : Bukkit.getOnlinePlayers()) {
						ps.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§a" + msg.replace("&", "§")));
						break;
					}
				default:
					sender.sendMessage("§7Poprawne Uzycie: §a/alert (chat/title/actionbar)");
					break;
				}
			} else {
				sender.sendMessage("§7Poprawne Uzycie: §a/alert (chat/title/actionbar)");
			}
			
		} else {
			sender.sendMessage("§cNie masz permisji");
		}
		return false;
	}
}
