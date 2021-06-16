package przemowskyy.przemowskyyalerts.main;

import org.bukkit.plugin.java.JavaPlugin;

import przemowskyy.przemowskyyalerts.cmds.Alert;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		new Alert(this);
	}
}
