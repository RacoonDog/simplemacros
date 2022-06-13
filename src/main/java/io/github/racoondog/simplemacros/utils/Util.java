package io.github.racoondog.simplemacros.utils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

@Environment(EnvType.CLIENT)
public class Util {
    public static boolean verifyMacroValidity(Enums.Modifier modifier, Enums.Key key) {
        if (!Enums.Modifier.hasShift(modifier) && (key.equals(Enums.Key.LeftShift) || key.equals(Enums.Key.RightShift))) return false;
        if (!Enums.Modifier.hasCtrl(modifier) && (key.equals(Enums.Key.LeftControl) || key.equals(Enums.Key.RightControl))) return false;
        if (!Enums.Modifier.hasAlt(modifier) && (key.equals(Enums.Key.LeftAlt) || key.equals(Enums.Key.RightAlt))) return false;
        return true;
    }

    public static void sendChatMessage(String message) {
        assert MinecraftClient.getInstance().getNetworkHandler() != null;
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new ChatMessageC2SPacket(message));
    }
}
