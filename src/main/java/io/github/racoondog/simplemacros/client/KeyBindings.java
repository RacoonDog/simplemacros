package io.github.racoondog.simplemacros.client;

import io.github.racoondog.simplemacros.SimpleMacros;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class KeyBindings {
    public static final KeyBinding B = make("b", InputUtil.GLFW_KEY_B);
    public static final KeyBinding G = make("g", InputUtil.GLFW_KEY_G);
    public static final KeyBinding H = make("h", InputUtil.GLFW_KEY_H);
    public static final KeyBinding I = make("i", InputUtil.GLFW_KEY_I);
    public static final KeyBinding J = make("j", InputUtil.GLFW_KEY_J);
    public static final KeyBinding K = make("k", InputUtil.GLFW_KEY_K);
    public static final KeyBinding M = make("m", InputUtil.GLFW_KEY_M);
    public static final KeyBinding N = make("n", InputUtil.GLFW_KEY_N);
    public static final KeyBinding O = make("o", InputUtil.GLFW_KEY_O);
    public static final KeyBinding R = make("r", InputUtil.GLFW_KEY_R);
    public static final KeyBinding U = make("u", InputUtil.GLFW_KEY_U);
    public static final KeyBinding V = make("v", InputUtil.GLFW_KEY_V);
    public static final KeyBinding Y = make("y", InputUtil.GLFW_KEY_Y);
    public static final KeyBinding Z = make("z", InputUtil.GLFW_KEY_Z);
    public static final KeyBinding F4 = make("f4", InputUtil.GLFW_KEY_F4);
    public static final KeyBinding F6 = make("f6", InputUtil.GLFW_KEY_F6);
    public static final KeyBinding F7 = make("f7", InputUtil.GLFW_KEY_F7);
    public static final KeyBinding F8 = make("f8", InputUtil.GLFW_KEY_F8);
    public static final KeyBinding F9 = make("f9", InputUtil.GLFW_KEY_F9);
    public static final KeyBinding F10 = make("f10", InputUtil.GLFW_KEY_F10);
    public static final KeyBinding F12 = make("f12", InputUtil.GLFW_KEY_F12);
    public static final KeyBinding NUMLOCK = make("numlock", InputUtil.GLFW_KEY_NUM_LOCK);
    public static final KeyBinding KP0 = make("kp0", InputUtil.GLFW_KEY_KP_0);
    public static final KeyBinding KP1 = make("kp1", InputUtil.GLFW_KEY_KP_1);
    public static final KeyBinding KP2 = make("kp2", InputUtil.GLFW_KEY_KP_2);
    public static final KeyBinding KP3 = make("kp3", InputUtil.GLFW_KEY_KP_3);
    public static final KeyBinding KP4 = make("kp4", InputUtil.GLFW_KEY_KP_4);
    public static final KeyBinding KP5 = make("kp5", InputUtil.GLFW_KEY_KP_5);
    public static final KeyBinding KP6 = make("kp6", InputUtil.GLFW_KEY_KP_6);
    public static final KeyBinding KP7 = make("kp7", InputUtil.GLFW_KEY_KP_7);
    public static final KeyBinding KP8 = make("kp8", InputUtil.GLFW_KEY_KP_8);
    public static final KeyBinding KP9 = make("kp9", InputUtil.GLFW_KEY_KP_9);
    public static final KeyBinding KPADD = make("kpadd", InputUtil.GLFW_KEY_KP_ADD);
    public static final KeyBinding KPDECIMAL = make("kpdecimal", InputUtil.GLFW_KEY_KP_DECIMAL);
    public static final KeyBinding KPENTER = make("kpenter", InputUtil.GLFW_KEY_KP_ENTER);
    public static final KeyBinding KPMULTIPLY = make("kpmultiply", InputUtil.GLFW_KEY_KP_MULTIPLY);
    public static final KeyBinding DOWN = make("down", InputUtil.GLFW_KEY_DOWN);
    public static final KeyBinding LEFT = make("left", InputUtil.GLFW_KEY_LEFT);
    public static final KeyBinding RIGHT = make("right", InputUtil.GLFW_KEY_RIGHT);
    public static final KeyBinding UP = make("up", InputUtil.GLFW_KEY_UP);
    public static final KeyBinding APOSTROPHE = make("apostrophe", InputUtil.GLFW_KEY_APOSTROPHE);
    public static final KeyBinding BACKSLASH = make("backslash", InputUtil.GLFW_KEY_BACKSLASH);
    public static final KeyBinding COMMA = make("comma", InputUtil.GLFW_KEY_COMMA);
    public static final KeyBinding EQUAL = make("equal", InputUtil.GLFW_KEY_EQUAL);
    public static final KeyBinding GRAVE = make("grave", InputUtil.GLFW_KEY_GRAVE_ACCENT);
    public static final KeyBinding LBRACKET = make("leftbracket", InputUtil.GLFW_KEY_LEFT_BRACKET);
    public static final KeyBinding MINUS = make("minus", InputUtil.GLFW_KEY_MINUS);
    public static final KeyBinding PERIOD = make("period", InputUtil.GLFW_KEY_PERIOD);
    public static final KeyBinding RBRACKET = make("rightbracket", InputUtil.GLFW_KEY_RIGHT_BRACKET);
    public static final KeyBinding SEMICOLON = make("semicolon", InputUtil.GLFW_KEY_SEMICOLON);

    public static final KeyBinding M4 = mouse("m4", GLFW.GLFW_MOUSE_BUTTON_4);
    public static final KeyBinding M5 = mouse("m5", GLFW.GLFW_MOUSE_BUTTON_5);
    public static final KeyBinding M6 = mouse("m6", GLFW.GLFW_MOUSE_BUTTON_6);
    public static final KeyBinding M7 = mouse("m7", GLFW.GLFW_MOUSE_BUTTON_7);
    public static final KeyBinding M8 = mouse("m8", GLFW.GLFW_MOUSE_BUTTON_8);

    private static KeyBinding make(String id, int keybind) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.%s.%s".formatted(SimpleMacros.MODID, id),
                keybind,
                "category.%s.keys".formatted(SimpleMacros.MODID)
        ));
    }

    private static KeyBinding mouse(String id, int keybind) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.%s.%s".formatted(SimpleMacros.MODID, id),
                InputUtil.Type.MOUSE,
                keybind,
                "category.%s.keys".formatted(SimpleMacros.MODID)
        ));
    }
}
