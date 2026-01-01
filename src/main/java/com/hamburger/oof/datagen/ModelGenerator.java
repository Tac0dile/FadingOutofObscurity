package com.hamburger.oof.datagen;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import com.hamburger.oof.world.level.block.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;

import java.util.Optional;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, Oof.MODID);
    }

    public static final ModelTemplate MULTIFACE_TEMPLATE = new ModelTemplate(
            Optional.of(
                    ModelLocationUtils.decorateBlockModelLocation("minecraft:cube")
            ),
            Optional.of("_model"),
            TextureSlot.NORTH,
            TextureSlot.SOUTH,
            TextureSlot.EAST,
            TextureSlot.WEST,
            TextureSlot.UP,
            TextureSlot.DOWN
    );

    public static final TexturedModel.Provider MULTIFACE_PROVIDER = TexturedModel.createDefault(
            block -> new TextureMapping()
                    .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_north"))
                    .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_south"))
                    .put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_east"))
                    .put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_west"))
                    .put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_up"))
                    .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_down")),
            MULTIFACE_TEMPLATE
    );

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.CUP_OF_JOE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EVIL_WATER_BOTLLEF.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VOID_RESONATOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.DIAMOND_BRICK.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialBlock(ModBlocks.HUME_INFUSER.get(), MULTIFACE_PROVIDER);
        blockModels.createTrivialBlock(ModBlocks.BIG_RED_BUTTON.get(), MULTIFACE_PROVIDER);


    }
}
