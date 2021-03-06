package sblectric.lightningcraft.events;

//import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.text.TextComponentString;
//import net.minecraftforge.event.entity.player.AchievementEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
//import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
//import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
//import sblectric.lightningcraft.api.IInventoryLEUser;
//import sblectric.lightningcraft.api.util.StackHelper;
//import sblectric.lightningcraft.init.LCAchievements;
//import sblectric.lightningcraft.init.LCBlocks;
//import sblectric.lightningcraft.items.ItemBattery;
//import sblectric.lightningcraft.items.ItemLightningGuide;
//import sblectric.lightningcraft.items.base.ItemSpecialSword;
//import sblectric.lightningcraft.ref.LCText;

/** Events that give achievements */
//public class AchievementEvents {
//	
//	/** When stuff happens */
//	@SubscribeEvent
//	public void onGetAchievement(AchievementEvent e) {
//		if(!e.getEntity().getEntityWorld().isRemote && e.getAchievement() == LCAchievements.infuseSkyfather) {
//			e.getEntityPlayer().sendMessage(new TextComponentString(LCText.getAngerGodsChatLore()));
//		}
//	}
//	
//	/** Crafting achievements */
//	@SubscribeEvent
//	public void onCraftThing(ItemCraftedEvent e) {
//		ItemStack output = e.crafting;
//		Item item = output.getItem();
//		Block block = Block.getBlockFromItem(item);
//		int meta = output.getItemDamage();
//		
//		if(!output.isEmpty()) {
//		
//			// items
//			
//			if(StackHelper.oreDictNameEquals(output, "rodLC")) {
//				e.player.addStat(LCAchievements.craftRod, 1);
//			}
//			
//			if(item instanceof ItemLightningGuide) {
//				e.player.addStat(LCAchievements.craftGuide, 1);
//			}
//			
//			if(item instanceof ItemBattery) {
//				e.player.addStat(LCAchievements.craftBattery, 1);
//			}
//			
//			if(item instanceof IInventoryLEUser) {
//				e.player.addStat(LCAchievements.craftKinetic, 1);
//			}
//			
//			// blocks
//			
//			if(block == LCBlocks.lightningCell) {
//				e.player.addStat(LCAchievements.craftCell, 1);
//			}
//			
//			if(block == LCBlocks.airTerminal) {
//				e.player.addStat(LCAchievements.craftTerminal, 1);
//			}
//			
//			if(block == LCBlocks.lightningFurnace) {
//				e.player.addStat(LCAchievements.craftFurnace, 1);
//			}
//			
//			if(block == LCBlocks.lightningCrusher) {
//				e.player.addStat(LCAchievements.craftCrusher, 1);
//			}
//			
//			if(block == LCBlocks.lightningInfuser) {
//				e.player.addStat(LCAchievements.craftInfuser, 1);
//			}
//			
//			if(block == LCBlocks.lightningMiner) {
//				e.player.addStat(LCAchievements.craftMiner, 1);
//			}
//			
//			if(block == LCBlocks.staticGenerator) {
//				e.player.addStat(LCAchievements.craftGenerator, 1);
//			}
//			
//			if(block == LCBlocks.wirelessBlock) {
//				e.player.addStat(LCAchievements.craftWireless, 1);
//			}
//			
//			if(block == LCBlocks.enchReallocator) {
//				e.player.addStat(LCAchievements.craftReallocator, 1);
//			}
//		
//		}
//		
//	}
//	
//	/** Infusion achievements */
//	@SubscribeEvent
//	public void onInfuseThing(ItemSmeltedEvent e) {
//		ItemStack output = e.smelting;
//		Item item = output.getItem();
//		int meta = output.getItemDamage();
//		
//		if(!output.isEmpty()) {
//		
//			if(StackHelper.oreDictNameEquals(output, "ingotElectricium")) {
//				e.player.addStat(LCAchievements.getElectricium, 1);
//			}
//			
//			if(StackHelper.oreDictNameEquals(output, "ingotSkyfather")) {
//				// force unlock this one even without parents
//				if(e.player instanceof EntityPlayerMP) {
//					if(!((EntityPlayerMP)e.player).getStatFile().hasAchievementUnlocked(LCAchievements.infuseSkyfather))
//					((EntityPlayerMP)e.player).getStatFile().unlockAchievement(e.player, LCAchievements.infuseSkyfather, 1);
//				}
//				e.player.addStat(LCAchievements.infuseSkyfather, 1);
//			}
//			
//			if(StackHelper.oreDictNameEquals(output, "ingotMystic")) {
//				e.player.addStat(LCAchievements.infuseMystic, 1);
//			}
//			
//			if(item instanceof ItemSpecialSword) {
//				e.player.addStat(LCAchievements.infuseSpecialSword, 1);
//			}
//		
//		}
//	}
//	
//	/** Picking up item achievements */
//	@SubscribeEvent
//	public void onPickUpThing(ItemPickupEvent e) {
//		ItemStack got = e.pickedUp.getEntityItem();
//		if(!got.isEmpty()) {
//			
//			if(StackHelper.oreDictNameEquals(got, "ingotElectricium")) {
//				e.player.addStat(LCAchievements.getElectricium, 1);
//			}
//			
//		}
//	}
//
//}
