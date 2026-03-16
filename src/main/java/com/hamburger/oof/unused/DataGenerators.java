package com.hamburger.oof.unused;

import com.hamburger.oof.Oof;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Oof.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        event.createProvider(ModelGenerator::new);
        event.createProvider(ENUSGenerator::new);
        event.createProvider(LOLGenerator::new);
    }

}
