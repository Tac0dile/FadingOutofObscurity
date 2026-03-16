package com.hamburger.oof.world.level.block;

import com.hamburger.oof.Oof;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class BigRedButton extends Block {
    public BigRedButton(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (player instanceof ServerPlayer)
                ((ServerPlayer) player).connection.disconnect(Component.translatable("block." + Oof.MODID + ".big_red_disconnect"));
            System.out.println("SCP-001-J has been triggered.  All hope is lost.  Dummy!!!");
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + Oof.MODID + ".big_red_button"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
