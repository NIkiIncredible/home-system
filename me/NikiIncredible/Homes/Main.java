package me.NikiIncredible.Homes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static File fhome = new File("plugins//Homes//data.yml");
	public static YamlConfiguration home = YamlConfiguration.loadConfiguration(fhome);
	public static File Mfile = new File("plugins//Homes//messages.yml");
	public static YamlConfiguration Messages = YamlConfiguration.loadConfiguration(Mfile);
	public static Main main;
				
	@Override
	public void onEnable() {
		
		main = this;
		
		Bukkit.getConsoleSender().sendMessage("Home - Plugin enabled");
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		register();
		Config();
		
	}
	
	@Override
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("WorldCreator - Plugin disabled");
	}
	
	
	public void register() {
		
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
		
		getCommand("home").setExecutor(new HomeCMD());
		getCommand("sethome").setExecutor(new SetHomeCMD());
		getCommand("setspawn").setExecutor(new SetSpawnCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		
	}
	
	public void Config() {
				
	    Messages.options().configuration().addDefault("Prefix", "&9Home &8- ");
	    Messages.options().configuration().addDefault("NoPerm", "&cDu hast daruf keine Rechte!");
	    Messages.options().configuration().addDefault("SetHome", "&aDu hast einen Home gesetzt!");
	    Messages.options().configuration().addDefault("TpHome", "&7Du wurdest zu deinem Home telepotiert!");
	    Messages.options().configuration().addDefault("SetSpawn", "&aDu hast den Spawn gesetzt!");
	    Messages.options().configuration().addDefault("TpSpawn", "&7Du wurdest zum Spawn teleportiert!");
	    Messages.options().configuration().addDefault("NoHome", "&cDu musst den Home zuerst setzen!");
	    Messages.options().configuration().addDefault("LoreHome", "&7Klicke um zu deinem Home zu gelangen!");
	    Messages.options().configuration().addDefault("LoreSetHome", "&7Klicke um Home zu setzen!");
	    
	    Messages.options().copyDefaults(true);
	    
		
		try {
			Messages.save(Mfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
