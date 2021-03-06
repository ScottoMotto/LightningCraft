package sblectric.lightningcraft.init;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import sblectric.lightningcraft.network.MessageLightningUpgrade;
import sblectric.lightningcraft.network.MessageSpawnParticle;
import sblectric.lightningcraft.network.MessageSyncTNT;
import sblectric.lightningcraft.ref.RefStrings;

public class LCNetwork {
	
	public static SimpleNetworkWrapper net;
	public static int id;
	
	public static void mainRegistry() {
		id = 0;
		registerNetwork();
	}
	
	private static void registerNetwork() {
		net = NetworkRegistry.INSTANCE.newSimpleChannel(RefStrings.SHORTNAME + ".net");
		net.registerMessage(MessageSpawnParticle.Handler.class, MessageSpawnParticle.class, id++, Side.CLIENT);
		net.registerMessage(MessageLightningUpgrade.Handler.class, MessageLightningUpgrade.class, id++, Side.CLIENT);
		net.registerMessage(MessageSyncTNT.Handler.class, MessageSyncTNT.class, id++, Side.CLIENT);
	}

}
