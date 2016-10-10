package com.dbi.essentiamancy;

import com.dbi.essentiamancy.event.WandVisionToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

/**
 * Created by Falken on 10/8/2016.
 */
public class GameState {
    public static final GameState INSTANCE = new GameState();

    private boolean wandVisionActive = false;

    private GameState(){}

    @SubscribeEvent
    public void handleWandVisionToggle(WandVisionToggle event)
    {
        if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
        {
            wandVisionActive = !wandVisionActive;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isWandVisionActive()
    {
        return wandVisionActive;
    }
}
