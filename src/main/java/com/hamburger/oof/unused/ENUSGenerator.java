package com.hamburger.oof.unused;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import com.hamburger.oof.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ENUSGenerator extends LanguageProvider {
    public ENUSGenerator(PackOutput output) {
        super(output, Oof.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        this.add("itemGroup.oof.equipment_blocks", "Equipment Blocks");
        this.add("itemGroup.oof.anomalous_items", "Anomalous Items");

        this.addItem(ModItems.VOID_RESONATOR, "Void Resonator");

        //Log of Anomalous Items
        this.addItem(ModItems.DIAMOND_BRICK, "Diamond Brick");

        //SCPs
        this.addItem(ModItems.EVIL_WATER_BOTLLEF, "Evil :(");
        this.addItem(ModItems.CUP_OF_JOE, "SCP-198");

        this.addBlock(ModBlocks.BIG_RED_BUTTON, "The Big Red Button");
        this.addBlock(ModBlocks.HUME_INFUSER, "Hume Infuser");

        //UI Elements
        this.add("block.oof.big_red_disconnect", "You destroyed everything.");
    }
}
