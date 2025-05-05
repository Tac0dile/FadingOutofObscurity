package com.hamburger.oof.datagen;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import com.hamburger.oof.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, Oof.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItems.VOID_RESONATOR, "Void Resonator");

        //SCPs
        this.addItem(ModItems.CUP_OF_JOE, "SCP-198");

        this.addBlock(ModBlocks.HUME_INFUSER, "Hume Infuser");
    }
}
