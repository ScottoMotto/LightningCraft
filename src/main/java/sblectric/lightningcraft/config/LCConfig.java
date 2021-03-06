package sblectric.lightningcraft.config;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Property;
import sblectric.lightningcraft.integration.energy.EnergyApiHelper;
import sblectric.lightningcraft.ref.Log;
import sblectric.lightningcraft.ref.RefStrings;

public class LCConfig {
	
	public static boolean portalEnabled;
	public static int portalCooldown;
	public static boolean demonSoldiersAlwaysNeutral, demonSoldiersInNether, demonSoldiersFullPower;
	public static boolean useVanillaGhastSounds;
	
	public static boolean upgradeEnabled;
	public static String[] minerFillerBlocks;
	public static int minerMaxRetries;
	
	public static boolean autoSmelt, autoRepair, mysticGear;
	
	public static int underworldDimensionID;
	public static boolean JEIIntegration, RFIntegration;
	public static int RFtoLEConversion;
	public static boolean tinkersIntegration;
	public static boolean disableOtherRods;
	public static boolean chiselIntegration, chiselCorruptStone;
	
	/** Set config defaults */
	private static void setDefaultValues() {
		// general
		portalEnabled = true;
		portalCooldown = 200;
		demonSoldiersAlwaysNeutral = false;
		demonSoldiersFullPower = false;
		demonSoldiersInNether = true;
		useVanillaGhastSounds = false;
		
		// machines
		upgradeEnabled = true;
		minerFillerBlocks = new String[]{Blocks.COBBLESTONE.getRegistryName().toString(), 
										 Blocks.DIRT.getRegistryName().toString(), 
										 Blocks.SAND.getRegistryName().toString()};
		minerMaxRetries = 256;
		
		// tools
		autoSmelt = true;
		autoRepair = true;
		mysticGear = true;
		
		// worldgen
		underworldDimensionID = -9;
		
		// mod integration
		JEIIntegration = true;
		RFIntegration = true;
		RFtoLEConversion = 50;
		tinkersIntegration = true;
		disableOtherRods = true;
		chiselIntegration = true;
		chiselCorruptStone = true;
	}
	
	/** Load the mod config */
	public static void loadConfig(File f) {
		// load the config file and default values
		ConfigurationCustom config = new ConfigurationCustom(f);
		setDefaultValues();
		config.load();
		Property p;
		String category;
		
		// General
		category = "General";
		portalEnabled = config.getBoolean("Portal Enabled", category, portalEnabled, "Set to false to disable default portal creation.");
		portalCooldown = config.getInt("Portal Cooldown Time", category, portalCooldown, 
				"The cooldown time for the underworld portal. Increase if repeated teleporting occurs.");
		demonSoldiersAlwaysNeutral = config.getBoolean("Wuss Mode", category, demonSoldiersAlwaysNeutral,
				"Set to true if Demon Soldiers should only attack the player if they are attacked first");
		demonSoldiersInNether = config.getBoolean("Demon Soldiers Spawn in Nether", category, demonSoldiersInNether,
				"Set to false if Demon Soldiers should not spawn in the Nether");
		demonSoldiersFullPower = config.getBoolean("Classic Demon Soldiers", category, demonSoldiersFullPower, 
				"Set to true if Demon Soldiers should NOT be weaker outside of the Underworld");
		useVanillaGhastSounds = config.getBoolean("Use Vanilla Ghast Sounds", category, useVanillaGhastSounds,
				"Whether or not to use the vanilla ghast sounds for the Underghast instead of the provided ones");
		
		// Machines
		category = "Machines";
		upgradeEnabled = config.getBoolean("Enable Lightning Upgrading", category, upgradeEnabled, 
				"If false, right clicking machines with the Lightning Upgrade will do nothing");
		minerFillerBlocks = config.getStringList("Miner Filler Blocks", category, minerFillerBlocks,
				"This is the list of blocks the miner considers filler. It will optionally use these to fill its mined area, and won't mine these blocks.");
		minerMaxRetries = config.getInt("Max Miner Block Search Retries", category, minerMaxRetries, 
				"The max amount of mining retries. Decrease if StackOverflowExceptions occur.");
		
		// Tools
		category = "Tools and Armor";
		autoSmelt = config.getBoolean("Enable Skyfather Autosmelting", category, autoSmelt, 
				"Whether or not Skyfather and Mystic tools will auto-smelt mined blocks.");
		autoRepair = config.getBoolean("Enable Mystic Auto-repair", category, autoRepair, 
				"Whether or not Mystic tools will auto-repair.");
		mysticGear = config.getBoolean("Enable Mystic Gear", category, autoRepair, 
				"If false, Mystic gear will not be able to be created.");
		
		// World Gen
		category = "Worldgen";
		underworldDimensionID = config.getInt("Underworld Dimension ID", category, underworldDimensionID, 
				"The ID for the Underworld dimension");
		
		// Mod Integration
		category = "Mod Integration";
		JEIIntegration = config.getBoolean("JEI integration", category, JEIIntegration, "Enable JEI integration?");
		RFIntegration = config.getBoolean("RF integration", category, RFIntegration, "Enable LE <-> RF / TESLA conversion machines?");
		if(!RFIntegration) EnergyApiHelper.rfOrTeslaLoaded = false; // force unloaded condition
		RFtoLEConversion = config.getInt("RF to LE conversion", category, RFtoLEConversion,
				"This amount of RF / TESLA is equal to 1 LE (for 1 LE -> x RF conversion). The reverse will be 10 times costlier.");
		tinkersIntegration = config.getBoolean("Tinker's Construct integration", category, tinkersIntegration,
				"Enable smeltery support for electricium, skyfather, and mystic metals");
		disableOtherRods = config.getBoolean("Remove Other Mods' Rods", category, disableOtherRods,
				"Will remove the crafting recipes of all other mods' rods that " + RefStrings.NAME + " has its own versions of.");
		chiselIntegration = config.getBoolean("Chisel integration", category, chiselIntegration,
				"Enable support for chiseling several " + RefStrings.NAME + " block types");
		chiselCorruptStone = config.getBoolean("Enable corrupt stone chiseling", category, chiselCorruptStone,
				"Should one be able to chisel stone and stone bricks to corrupt stone? Will only apply if chisel integration is enabled.");
		
		// save the config if fields were missing
		if(config.hasChanged()) config.save();
		Log.logger.info("Config loaded.");
	}

}
