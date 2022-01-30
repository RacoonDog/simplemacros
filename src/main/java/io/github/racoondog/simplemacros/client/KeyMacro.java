package io.github.racoondog.simplemacros.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public record KeyMacro(KeyBinding keyBinding, Supplier<String> command) {
    public boolean pressed() {
        return this.keyBinding.isPressed() && this.keyBinding.wasPressed();
    }

    @SuppressWarnings("ConstantConditions")
    public void execute() {
        final String cmd = this.command.get();
        if (!cmd.equals("")) MinecraftClient.getInstance().player.sendChatMessage(cmd);
    }
}
