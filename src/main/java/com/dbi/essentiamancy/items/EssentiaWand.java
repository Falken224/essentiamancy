package com.dbi.essentiamancy.items;

import com.dbi.essentiamancy.Essentiamancy;
import com.dbi.essentiamancy.event.WandVisionToggle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;

/**
 * Created by Falken on 10/5/2016.
 */
public class EssentiaWand extends Item{
    private final String name = "essentiawand";

    public EssentiaWand()
    {
        setRegistryName(Essentiamancy.MODID,name);
        setUnlocalizedName(name);
    }
    public String getName()
    {
        return name;
    }

    @Override
    public int getItemEnchantability() {
        return super.getItemEnchantability();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        MinecraftForge.EVENT_BUS.post(new WandVisionToggle());
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,itemStackIn);
    }
}
