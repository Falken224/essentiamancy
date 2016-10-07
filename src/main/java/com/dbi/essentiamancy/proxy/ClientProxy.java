package com.dbi.essentiamancy.proxy;

import com.dbi.essentiamancy.Essentiamancy;
import com.dbi.essentiamancy.client.model.Manager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Falken on 10/6/2016.
 */
@SideOnly(Side.CLIENT)
public class ClientProxy implements Proxy {
    @Override
    public void preInit() {
        Manager.INSTANCE.registerModels();
    }

    @Override
    public void init() {

    }
}
