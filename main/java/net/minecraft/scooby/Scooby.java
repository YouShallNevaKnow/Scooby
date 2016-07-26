package net.minecraft.scooby;

import net.minecraft.client.Minecraft;
import net.minecraft.scooby.event.EventHandler;
import net.minecraft.scooby.handlers.Handler;
import net.minecraft.scooby.mod.ModHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.ArrayList;
import java.util.List;


@Mod(modid = Scooby.MOD_NAME)
public class Scooby {

	public static final String MOD_NAME = "PlayerAPI";
	public Minecraft mc = Minecraft.getMinecraft();
	private List<Handler> handlers = new ArrayList<Handler>();
	
	public ModHandler modHandler;
	public EventHandler eventHandler;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		addHandler(modHandler = new ModHandler());
		addHandler(eventHandler = new EventHandler());
		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}

	public void addHandler(Handler handler) {
		getHandlers().add(handler);
		handler.init(this);
	}
	
	public List<Handler> getHandlers() {
		return handlers;
	}
}
