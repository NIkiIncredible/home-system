package me.NikiIncredible.Homes;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.NikiIncredible.Utils.Messages;

public class InventoryClickListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		try {

			String s1 = e.getCurrentItem().getItemMeta().getDisplayName().replace(" ", "");
			String[] s2 = s1.split("•");
				
			Player p = (Player) e.getWhoClicked();
			Location loc = p.getLocation();
			
			if(e.getInventory().getName().equalsIgnoreCase("§cSethome")) {
				
				e.setCancelled(true);
				if(!p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
					
					if(p.hasPermission("home." + s2[1])) {
						
						double x = loc.getX();
						double y = loc.getY();
						double z = loc.getZ();
						float yaw = loc.getYaw();
						float pitch = loc.getPitch();
						String world = loc.getWorld().getName();
						
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".X", x);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".Y", y);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".Z", z);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".Yaw", yaw);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".Pitch", pitch);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".World", world);
						Main.home.set(p.getUniqueId() + "." + s2[1] + ".Home", true);
						
						p.sendTitle("", Messages.setHome);
				        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
				        p.closeInventory();
		
						try {
							Main.home.save(Main.fhome);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        
					} else {
						
						p.sendMessage(Messages.noPerm);
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
						
					}
					
				} else {
					p.sendMessage(Messages.prefix + " §cDu darfst im End keinen Home setzen!");
				}
				
			}
			
			if(e.getInventory().getName().equalsIgnoreCase("§cHomes")) {
				
				e.setCancelled(true);
				
				if(Main.home.isSet(p.getUniqueId() + "." + s2[1] + ".X")) {
					
					double yaw = Main.home.getDouble(p.getUniqueId() + "." + s2[1] + ".Yaw");
					double pitch = Main.home.getDouble(p.getUniqueId() + "." + s2[1] + ".Pitch");
					World world = Bukkit.getWorld(Main.home.getString(p.getUniqueId() + "." + s2[1] + ".World"));
					
					loc.setX(Main.home.getDouble(p.getUniqueId() + "." + s2[1] + ".X"));
			        loc.setY(Main.home.getDouble(p.getUniqueId() + "." + s2[1] + ".Y"));
			        loc.setZ(Main.home.getDouble(p.getUniqueId() + "." + s2[1] + ".Z"));		              
			        loc.setYaw((float) yaw);
			        loc.setPitch((float) pitch);
			        loc.setWorld(world);
			        p.teleport(loc);
					
					p.sendTitle("", Messages.tpHome);
			        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
			        p.closeInventory();

					try {
						Main.home.save(Main.fhome);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			        
				} else {
					p.sendMessage(Messages.prefix + Messages.noHome);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
				}
				
			}
		
		} catch (NullPointerException localNullPointerException) {}
		
	}

}
