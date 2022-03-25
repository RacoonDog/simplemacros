package io.github.racoondog.simplemacros.mixin;

import io.github.racoondog.simplemacros.client.KeyMacro;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void applyChatMessageModifications(String message, CallbackInfo info) {
        if (message.contains("<") && message.contains(">")) {
            MinecraftClient.getInstance().player.networkHandler.sendPacket(new ChatMessageC2SPacket(KeyMacro.modifications(message)));
            info.cancel();
        }
    }
}
