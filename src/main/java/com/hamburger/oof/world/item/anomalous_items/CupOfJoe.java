package com.hamburger.oof.world.item.anomalous_items;

import com.hamburger.oof.Oof;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
    ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Oof.MODID, "joe_health_modifer");

    AttributeModifier joeHealthModifier = new AttributeModifier(
            id,
            -8.0,
            AttributeModifier.Operation.ADD_VALUE
    );

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        AttributeMap attributes = player.getAttributes();
        attributes.getInstance(Attributes.MAX_HEALTH).addPermanentModifier(joeHealthModifier);
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public void onConsume(Level level, LivingEntity livingEntity, ItemStack itemStack, Consumable consumable) {

    }
}
