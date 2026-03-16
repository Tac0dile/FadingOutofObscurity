package com.hamburger.oof.world.level.block;

import com.hamburger.oof.Oof;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class BiologicalMotherboard extends Block {
    public static final VoxelShape AABB = Block.box(3, 0, 3, 13, 3, 13);

    public BiologicalMotherboard(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    //WHY THE FUCK ARE THERE LIKE 5 DIFFERENT METHODS TO GET BRIGHTNESS, TWO OF WHICH ARE RAW!?!?
    //To answer your question, Mojang did this to give you the understanding of what it's like to be raw dogged by number magic :D
    protected boolean isBlockLit(LevelReader level, BlockPos pos) {
        return level.getMaxLocalRawBrightness(pos) >= 9;
    }

    protected boolean isBlockWarm(Level level, Biome biome) {
        return biome.getBaseTemperature() >= 2.0 && level.isDay();
    }

    protected boolean isContained(Level level, BlockPos pos) {
        BlockState blockState = level.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        return blockState.is(ModBlocks.STONE_TABLET);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!level.isClientSide) {
            if (isBlockLit(level, pos) || isBlockWarm(level, level.getBiome(pos).value())){
                if (!isContained(level, pos)){
                    System.out.println("SCP-003-1 ATTEMPTED GROWTH");
                }
            }
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + Oof.MODID + ".biological_motherboard"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
