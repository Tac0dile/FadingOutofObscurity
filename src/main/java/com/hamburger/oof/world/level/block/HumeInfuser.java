package com.hamburger.oof.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;

public class HumeInfuser extends Block {
    public HumeInfuser(Properties properties) {
        super(properties);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return super.rotate(state, rot);
    }
}
