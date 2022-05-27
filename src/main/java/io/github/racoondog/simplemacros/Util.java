package io.github.racoondog.simplemacros;

import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

import java.util.List;

public class Util {
    private static final List<Integer> cantCancel = Lists.newArrayList();

    public static boolean verifyMacroValidity(Enums.Modifier modifier, Enums.Key key, boolean cancel) {
        return true;
    }

    public static void sendChatMessage(String message) {
        assert MinecraftClient.getInstance().getNetworkHandler() != null;
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new ChatMessageC2SPacket(message));
    }
}
