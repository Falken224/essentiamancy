package com.dbi.essentiamancy.items;

import com.dbi.essentiamancy.Essentiamancy;
import net.minecraft.item.Item;

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
}
