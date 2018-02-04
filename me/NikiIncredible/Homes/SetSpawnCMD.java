package me.NikiIncredible.Homes;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.NikiIncredible.Utils.Messages;;

public class SetSpawnCMD implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		Location loc = p.getLocation();
		
		if(sender instanceof ConsoleCommandSender) {return true;}
		
		if(!p.hasPermission("home.setspawn")) {p.sendMessage(Messages.noPerm);return true;}
		
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();
		String world = loc.getWorld().getName();
		
		Main.home.set("Spawn.X", x);
		Main.home.set("Spawn.Y", y);
		Main.home.set("Spawn.Z", z);
		Main.home.set("Spawn.Yaw", yaw);
		Main.home.set("Spawn.Pitch", pitch);
		Main.home.set("Spawn.World", world);
		
		try {
			Main.home.save(Main.fhome);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.sendTitle("", Messages.setSpawn);
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 12, 3);
		
		
		return false; }

}
