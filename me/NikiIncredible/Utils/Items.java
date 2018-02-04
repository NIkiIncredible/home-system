package me.NikiIncredible.Utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.NikiIncredible.Homes.Main;

public class Items {
	
		@SuppressWarnings("deprecation")
		public static ItemStack createItemLore(Material material, int subid, String displayname, int amount, String lore) {
			
			ItemStack item = new ItemStack(material, amount,(short) subid);
			ItemMeta mitem = item.getItemMeta();
			ArrayList<String> Lore =  new ArrayList<String>();
			Lore.add(lore);
			mitem.setLore(Lore);
			mitem.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	        mitem.spigot().setUnbreakable(true);

			mitem.setDisplayName(displayname);
			item.setItemMeta(mitem);
			
			
			
			return item;
		}
		
		public static ItemStack createAir() {
			ItemStack item = new ItemStack(Material.AIR, 1,(short) 0);
			return item;
		}
	
		public static ItemStack ItemGet(int home, Player p) {
			
			ItemStack i = createAir();
			
			if(Main.home.isSet(p.getUniqueId() + "." + home + ".X")) {
				i = Items.createItemLore(Material.INK_SACK, 10, "§9Home • " + home, home, "§7➥ " + Messages.loreHome);
			} else {
				i =Items.createItemLore(Material.INK_SACK, 7, "§9Home • " + home, home, "§7➥ " + Messages.loreHome);
			}
			return i;
			
		}
		
		public static ItemStack ItemSet(int home, Player p) {
			
			ItemStack i = createAir();
			
			if(Main.home.isSet(p.getUniqueId() + "." + home + ".X")) {
				i = Items.createItemLore(Material.INK_SACK, 10, "§9Home • " + home, home, "§7➥ " + Messages.loreSetHome);
			} else {
				i =Items.createItemLore(Material.INK_SACK, 7, "§9Home • " + home, home, "§7➥ " + Messages.loreSetHome);
			}
			return i;
			
		}
		
	}