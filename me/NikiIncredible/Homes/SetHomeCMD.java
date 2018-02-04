package me.NikiIncredible.Homes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.NikiIncredible.Utils.Items;



public class SetHomeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(sender instanceof ConsoleCommandSender) {return true;}
		
		
		Inventory inv = Bukkit.createInventory(null, 9, "§cSethome");	
			
		inv.setItem(2, Items.ItemSet(1, p));
		inv.setItem(3, Items.ItemSet(2, p));
		inv.setItem(4, Items.ItemSet(3, p));
		inv.setItem(5, Items.ItemSet(4, p));
		inv.setItem(6, Items.ItemSet(5, p));
		
		p.openInventory(inv);		
		return false; }

}
