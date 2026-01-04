package com.hamburger.oof.datagen;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import com.hamburger.oof.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LOLGenerator extends LanguageProvider {

    public LOLGenerator(PackOutput output) {
        super(output, Oof.MODID, "lol_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.oof.equipment_blocks", "Speshul Workstufs");
        this.add("itemGroup.oof.anomalous_items", "Magicl Tings");

        this.addItem(ModItems.VOID_RESONATOR, "Nowher lokatr");

        //Log of Anomalous Items
        this.addItem(ModItems.DIAMOND_BRICK, "Shineee rektangl");

        //SCPs
        this.addItem(ModItems.EVIL_WATER_BOTLLEF, "EEVIILLLLL");
        this.addItem(ModItems.CUP_OF_JOE, "Yuckie Cupp");

        this.addBlock(ModBlocks.BIG_RED_BUTTON, "PRES IT!");
        this.addBlock(ModBlocks.HUME_INFUSER, "Spooky Makr");

        //UI Elements
        this.add("block.oof.big_red_disconnect", "U presd teh big shinee red buton and kild all deh kittees :/");
    }
}
