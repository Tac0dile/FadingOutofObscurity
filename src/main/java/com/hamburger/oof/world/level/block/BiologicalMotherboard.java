package com.hamburger.oof.world.level.block;

import com.hamburger.oof.Oof;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class BiologicalMotherboard extends Block {
    public BiologicalMotherboard(Properties properties) {
        super(properties);
    }

    //WHY THE FUCK ARE THERE LIKE 5 DIFFERENT METHODS TO GET BRIGHTNESS, TWO OF WHICH ARE RAW!?!?
    public boolean isBlockLit(LevelReader level, BlockPos pos) {
        return level.getMaxLocalRawBrightness(pos) >= 9;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        System.out.println(isBlockLit(level, pos)); //For debugging
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + Oof.MODID + ".biological_motherboard"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
