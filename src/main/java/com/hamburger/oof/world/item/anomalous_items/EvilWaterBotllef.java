package com.hamburger.oof.world.item.anomalous_items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.level.Level;

public class EvilWaterBotllef extends Item implements ConsumableListener {
    public EvilWaterBotllef(Properties properties) {
        super(properties);
    }

    @Override
    public void onConsume(Level level, LivingEntity livingEntity, ItemStack itemStack, Consumable consumable) {

    }
}
