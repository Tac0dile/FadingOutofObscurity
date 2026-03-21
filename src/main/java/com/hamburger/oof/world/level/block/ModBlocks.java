package com.hamburger.oof.world.level.block;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Oof.MODID);

    public static final DeferredBlock<Block> HUME_INFUSER = registerBlock(
            "hume_infuser",
            HumeInfuser::new,
            BlockBehaviour.Properties.of());

    public static final DeferredBlock<Block> BIG_RED_BUTTON = registerBlock(
            "big_red_button",
            BigRedButton::new,
            BlockBehaviour.Properties.of());

    //SCP-003
    public static final DeferredBlock<Block> BIOLOGICAL_MOTHERBOARD = registerBlock(
            "biological_motherboard",
            BiologicalMotherboard::new,
            BlockBehaviour.Properties.of().strength(0.0F, 0.5F).randomTicks().sound(SoundType.MUD));

    public static final DeferredBlock<Block> STONE_TABLET = registerBlock(
            "stone_tablet",
            StoneTablet::new,
            BlockBehaviour.Properties.of().strength(1.5F, 6F).requiresCorrectToolForDrops().sound(SoundType.STONE));

    public static final DeferredBlock<Block> BIOLOGICAL_BIPRODUCT = registerBlock(
            "biological_biproduct",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.MUD));


    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> blockFactory, BlockBehaviour.Properties blockProperties) {
        DeferredBlock<B> block = BLOCKS.registerBlock(name, blockFactory, blockProperties);
        registerBlockItem(name, block);
        return block;
    }

    private static <B extends Block> void registerBlockItem(String name, DeferredBlock<B> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}