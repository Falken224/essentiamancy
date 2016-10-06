package com.dbi.essentiamancy.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Falken on 10/6/2016.
 */
@SideOnly(Side.CLIENT)
public class Manager {
    public static final Manager INSTANCE = new Manager();

    private Manager() {
    }

    public void registerItemModel(Item item) {
        final ModelResourceLocation fullModelLocation = new ModelResourceLocation(item.getRegistryName().toString(), "inventory");
        ModelBakery.registerItemVariants(item, fullModelLocation); // Ensure the custom model is loaded and prevent the default model from being loaded
        ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return fullModelLocation;
            }
        });
    }
}
