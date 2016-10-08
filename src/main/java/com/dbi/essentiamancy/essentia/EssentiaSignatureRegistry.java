package com.dbi.essentiamancy.essentia;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Falken on 10/6/2016.
 */
public class EssentiaSignatureRegistry
{

    public static final EssentiaSignatureRegistry INSTANCE = new EssentiaSignatureRegistry();

    private EssentiaSignatureRegistry(){}

    private Map<Block,EssentiaSignature> blockSignatureRegistry = new HashMap<>();
    private Configuration config;

    public void loadFromConfig(File configFile)
    {
        LogManager.getLogger("Essentiamancy").info("Checking config file -- "+configFile.getAbsolutePath());
        config = new Configuration(configFile);
        if(!config.hasCategory("BlockSigs"))
        {
            config.addCustomCategoryComment("BlockSigs","Essentia Signatures for blocks.");
        }
        IForgeRegistry<Block> blockRegistry = GameRegistry.findRegistry(Block.class);
        for(Block block : blockRegistry)
        {
            Property prop = config.get("BlockSigs",block.getRegistryName().toString(),"");
            if(prop.getString()==null || StringUtils.isEmpty(prop.getString())) continue;
            blockSignatureRegistry.put(block,new EssentiaSignature(prop.getString()));
        }
        config.save();
    }

    public void logBlocksWithoutSigs()
    {
        Logger log = LogManager.getLogger("Essentiamancy");

        IForgeRegistry<Block> blockRegistry = GameRegistry.findRegistry(Block.class);

        int missingBlockCount=0;
        for(Block block : blockRegistry.getValues())
        {
            if(!blockSignatureRegistry.containsKey(block))
            {
                log.info("**MISSING BLOCK FROM REGISTRY** -- "+block.getRegistryName());
            }
        }
    }
}
