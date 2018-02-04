package me.NikiIncredible.Homes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.NikiIncredible.Utils.Items;;

public class HomeCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(sender instanceof ConsoleCommandSender) {return true;}
		 else {
		
		Inventory inv = Bukkit.createInventory(null, 9, "§cHomes");	
			
		inv.setItem(2, Items.ItemGet(1, p));
		inv.setItem(3, Items.ItemGet(2, p));
		inv.setItem(4, Items.ItemGet(3, p));
		inv.setItem(5, Items.ItemGet(4, p));
		inv.setItem(6, Items.ItemGet(5, p));	
		
		p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
		}
		
		return false; }

}
