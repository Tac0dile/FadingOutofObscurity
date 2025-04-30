package com.hamburger.oof.world.item.anomalous_items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.level.Level;

public class CupOfJoe extends Item implements ConsumableListener {
    public CupOfJoe(Properties properties) {
        super(properties);
    }


    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        System.out.println("Owie");
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public void onConsume(Level level, LivingEntity livingEntity, ItemStack itemStack, Consumable consumable) {

    }
}
