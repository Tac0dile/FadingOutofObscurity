package com.hamburger.oof.data;

import com.hamburger.oof.Oof;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPE = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Oof.MODID);

    public static final Supplier<AttachmentType<ItemStackHandler>> JOE_ACTIVE = ATTACHMENT_TYPE.register(
            "joe_active", () -> AttachmentType.serializable(() -> new ItemStackHandler(1)).build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPE.register(eventBus);
    }
}
