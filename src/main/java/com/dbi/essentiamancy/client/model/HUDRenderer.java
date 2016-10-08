package com.dbi.essentiamancy.client.model;

import com.dbi.essentiamancy.Essentiamancy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.opengl.GL11;


/**
 * Created by Falken on 10/7/2016.
 */
public class HUDRenderer {

    @SubscribeEvent
    public void handleRender(RenderGameOverlayEvent event)
    {
        if(event.getType()== RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft mc = FMLClientHandler.instance().getClient();
            GL11.glEnable(GL11.GL_BLEND);
            mc.getTextureManager().bindTexture(new ResourceLocation(Essentiamancy.MODID,"textures/hud/orange_circle.png"));
            mc.ingameGUI.drawTexturedModalRect(mc.displayWidth/2+5,mc.displayHeight/2-37,0,0,32,32);
        }
    }
}
