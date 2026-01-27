package com.hamburger.oof.world.item.anomalous_items;

import com.hamburger.oof.Oof;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.level.Level;

import java.util.List;

public class EvilWaterBotllef extends Item implements ConsumableListener {
    public EvilWaterBotllef(Properties properties) {
        super(properties);
    }

    @Override
    public void onConsume(Level level, LivingEntity livingEntity, ItemStack itemStack, Consumable consumable) {

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + Oof.MODID + ".evil_water_botllef"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
