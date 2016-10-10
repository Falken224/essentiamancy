package com.dbi.essentiamancy.client.model;

import com.dbi.essentiamancy.Essentiamancy;
import com.dbi.essentiamancy.GameState;
import com.dbi.essentiamancy.essentia.EssentiaFlavor;
import com.dbi.essentiamancy.essentia.EssentiaSignature;
import com.dbi.essentiamancy.essentia.EssentiaSignatureRegistry;
import com.dbi.essentiamancy.essentia.EssentiaValue;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;


/**
 * Created by Falken on 10/7/2016.
 */
public class HUDRenderer {

    @SubscribeEvent
    public void handleRender(RenderGameOverlayEvent event)
    {
        if(GameState.INSTANCE.isWandVisionActive()) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
                Minecraft mc = FMLClientHandler.instance().getClient();
                if(mc.objectMouseOver!=null && mc.objectMouseOver.typeOfHit==RayTraceResult.Type.BLOCK && mc.getRenderViewEntity()!=null)
                {
                    EssentiaSignature sig = EssentiaSignatureRegistry.INSTANCE.findSignature(mc.objectMouseOver,mc.theWorld);
                    if(sig!=null)
                    {
                        GL11.glEnable(GL11.GL_BLEND);
                        mc.getTextureManager().bindTexture(new ResourceLocation(Essentiamancy.MODID, "textures/hud/hud_texture.png"));
                        int essentiaCount=0;
                        for(EssentiaFlavor flavor : EssentiaFlavor.values()) {
                            EssentiaValue value = sig.getFlavorValue(flavor);
                            if(value.getValue()>0) {
                                mc.ingameGUI.drawTexturedModalRect(mc.displayWidth / 2 + (essentiaCount*34) + 5, mc.displayHeight / 2 - 37, value.getType().getTextureX(), value.getType().getTextureY(), 32, 32);
                                essentiaCount++;
                            }
                        }
                        essentiaCount=0;
                        for(EssentiaFlavor flavor : EssentiaFlavor.values()) {
                            EssentiaValue value = sig.getFlavorValue(flavor);
                            if(value.getValue()>0) {
                                mc.fontRendererObj.drawString(""+value.getValue(),mc.displayWidth / 2 + (essentiaCount*34) + 18,mc.displayHeight / 2 - 26,0xFFFFFF);
                                essentiaCount++;
                            }
                        }
                    }
                }
            }
        }
    }
}
