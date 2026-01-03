package com.hamburger.oof.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BigRedButton extends Block {
    public BigRedButton(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (player instanceof ServerPlayer)
                ((ServerPlayer) player).connection.disconnect(Component.literal("YOU DESTROYED REALITY"));
            System.out.println("DIEE!!!!!!");
        }
        return InteractionResult.SUCCESS;
    }
}
