package me.NikiIncredible.Homes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.NikiIncredible.Utils.Messages;;

public class SpawnCMD implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		Location loc = p.getLocation();
		double yaw = Main.home.getDouble("Spawn.Yaw");
		double pitch = Main.home.getDouble("Spawn.Pitch");
		World world = Bukkit.getWorld(Main.home.getString("Spawn.World"));
		
		if(sender instanceof ConsoleCommandSender) {return true;}
		
		loc.setX(Main.home.getDouble("Spawn.X"));
        loc.setY(Main.home.getDouble("Spawn.Y"));
        loc.setZ(Main.home.getDouble("Spawn.Z"));		              
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);
        loc.setWorld(world);
        p.teleport(loc);
        
        p.sendTitle("", Messages.tpSpawn);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
		
		
		return false; }

}
