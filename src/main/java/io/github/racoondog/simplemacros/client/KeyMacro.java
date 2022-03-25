package io.github.racoondog.simplemacros.client;

import com.mojang.text2speech.Narrator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public record KeyMacro(KeyBinding keyBinding, Supplier<String> command) {
    public boolean pressed() {
        return this.keyBinding.isPressed() && this.keyBinding.wasPressed();
    }

    private static String getBiomeString(RegistryEntry<Biome> biome) {
        return (String)biome.getKeyOrValue().map((biomeKey) -> {
            return biomeKey.getValue().toString();
        }, (biome_) -> {
            return "[unregistered " + biome_ + "]";
        });
    }

    private static String tts(String string) {
        if (string.contains("<tts>") && string.contains("</tts>")) {
            while (string.contains("<tts>") && string.contains("</tts>")) {
                String subbed = string.substring(string.indexOf("<tts>") + 5);
                subbed = subbed.substring(0, subbed.indexOf("</tts>"));
                Narrator.getNarrator().say(subbed, true);
                string = string.substring(0, string.indexOf("<tts>")) + string.substring(string.indexOf("</tts>") + 6);
            }
        }
        return string;
    }

    public static String modifications(String string) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;
        while (string.contains("<coords>")) {
            string = string.replace("<coords>", "%s %s %s".formatted(Math.round(player.getX()), Math.round(player.getY()), Math.round(player.getZ())));
        }
        while (string.contains("<x>")) {
            string = string.replace("<x>", "%s".formatted(Math.round(player.getX())));
        }
        while (string.contains("<y>")) {
            string = string.replace("<y>", "%s".formatted(Math.round(player.getY())));
        }
        while (string.contains("<z>")) {
            string = string.replace("<z>", "%s".formatted(Math.round(player.getZ())));
        }
        while (string.contains("<biome>")) {
            String biomeStr = getBiomeString(MinecraftClient.getInstance().world.getBiome(MinecraftClient.getInstance().getCameraEntity().getBlockPos()));
            string = string.replace("<biome>", biomeStr);
        }
        while (string.contains("<hand>")) {
            String itemStr = player.getMainHandStack().getItem().toString();
            string = string.replace("<hand>", "[%s]".formatted(itemStr));
        }
        return string;
    }

    @SuppressWarnings("ConstantConditions")
    public void execute() {
        String cmd = this.command.get();
        cmd = tts(cmd);
        if (cmd.contains("<&&>")) {
            String[] cmds = cmd.split("<&&>");
            for (var toRun : cmds) {
                if (!toRun.equals("")) MinecraftClient.getInstance().player.sendChatMessage(toRun);
            }
            return;
        }
        if (!cmd.equals("")) MinecraftClient.getInstance().player.sendChatMessage(cmd);
    }
}
