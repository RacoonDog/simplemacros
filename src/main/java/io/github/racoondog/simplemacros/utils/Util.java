package io.github.racoondog.simplemacros.utils;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.lwjgl.glfw.GLFW;

import java.util.List;

@Environment(EnvType.CLIENT)
public class Util {
    //todo replace cantCancel with a check for if keybind is already used elsewhere
    private static final List<Integer> cantCancel = Lists.newArrayList(GLFW.GLFW_KEY_SPACE, GLFW.GLFW_KEY_LEFT_SHIFT, GLFW.GLFW_KEY_LEFT_CONTROL, GLFW.GLFW_KEY_A, GLFW.GLFW_KEY_D, GLFW.GLFW_KEY_S, GLFW.GLFW_KEY_W, GLFW.GLFW_MOUSE_BUTTON_LEFT, GLFW.GLFW_MOUSE_BUTTON_RIGHT, GLFW.GLFW_MOUSE_BUTTON_MIDDLE, GLFW.GLFW_KEY_Q, GLFW.GLFW_KEY_1, GLFW.GLFW_KEY_2, GLFW.GLFW_KEY_3, GLFW.GLFW_KEY_4, GLFW.GLFW_KEY_5, GLFW.GLFW_KEY_6, GLFW.GLFW_KEY_7, GLFW.GLFW_KEY_8, GLFW.GLFW_KEY_9, GLFW.GLFW_KEY_E, GLFW.GLFW_KEY_F, GLFW.GLFW_KEY_TAB, GLFW.GLFW_KEY_T, GLFW.GLFW_KEY_SLASH, GLFW.GLFW_KEY_P, GLFW.GLFW_KEY_F1, GLFW.GLFW_KEY_F2, GLFW.GLFW_KEY_F3, GLFW.GLFW_KEY_F5);

    public static boolean verifyMacroValidity(Enums.Modifier modifier, Enums.Key key, boolean cancel) {
        if (cantCancel.contains(key.keyIdentifier) && cancel) return false;
        if (!Enums.Modifier.isShift(modifier) && (key.equals(Enums.Key.LeftShift) || key.equals(Enums.Key.RightShift))) return false;
        if (!Enums.Modifier.isCtrl(modifier) && (key.equals(Enums.Key.LeftControl) || key.equals(Enums.Key.RightControl))) return false;
        if (!Enums.Modifier.isAlt(modifier) && (key.equals(Enums.Key.LeftAlt) || key.equals(Enums.Key.RightAlt))) return false;
        return true;
    }

    public static void sendChatMessage(String message) {
        assert MinecraftClient.getInstance().getNetworkHandler() != null;
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new ChatMessageC2SPacket(message));
    }
}
