package io.github.racoondog.simplemacros.client;

import com.google.common.collect.Lists;
import io.github.racoondog.simplemacros.SimpleMacros;
import io.github.racoondog.simplemacros.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;

import java.util.List;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class KeyMacros {
    private static final ModConfig CONFIG = SimpleMacros.CONFIG;

    public static List<KeyMacro> generateAlt() {
        return Lists.newArrayList(
                make(KeyBindings.B, () -> CONFIG.ALT_B),
                make(KeyBindings.G, () -> CONFIG.ALT_G),
                make(KeyBindings.H, () -> CONFIG.ALT_H),
                make(KeyBindings.I, () -> CONFIG.ALT_I),
                make(KeyBindings.J, () -> CONFIG.ALT_J),
                make(KeyBindings.K, () -> CONFIG.ALT_K),
                make(KeyBindings.M, () -> CONFIG.ALT_M),
                make(KeyBindings.N, () -> CONFIG.ALT_N),
                make(KeyBindings.O, () -> CONFIG.ALT_O),
                make(KeyBindings.R, () -> CONFIG.ALT_R),
                make(KeyBindings.U, () -> CONFIG.ALT_U),
                make(KeyBindings.V, () -> CONFIG.ALT_V),
                make(KeyBindings.Y, () -> CONFIG.ALT_Y),
                make(KeyBindings.Z, () -> CONFIG.ALT_Z),
                make(KeyBindings.F6, () -> CONFIG.ALT_F6),
                make(KeyBindings.F7, () -> CONFIG.ALT_F7),
                make(KeyBindings.F8, () -> CONFIG.ALT_F8),
                make(KeyBindings.F9, () -> CONFIG.ALT_F9),
                make(KeyBindings.F10, () -> CONFIG.ALT_F10),
                make(KeyBindings.F12, () -> CONFIG.ALT_F12),
                make(KeyBindings.NUMLOCK, () -> CONFIG.ALT_NUMLOCK),
                make(KeyBindings.KP0, () -> CONFIG.ALT_KP_0),
                make(KeyBindings.KP1, () -> CONFIG.ALT_KP_1),
                make(KeyBindings.KP2, () -> CONFIG.ALT_KP_2),
                make(KeyBindings.KP3, () -> CONFIG.ALT_KP_3),
                make(KeyBindings.KP4, () -> CONFIG.ALT_KP_4),
                make(KeyBindings.KP5, () -> CONFIG.ALT_KP_5),
                make(KeyBindings.KP6, () -> CONFIG.ALT_KP_6),
                make(KeyBindings.KP7, () -> CONFIG.ALT_KP_7),
                make(KeyBindings.KP8, () -> CONFIG.ALT_KP_8),
                make(KeyBindings.KP9, () -> CONFIG.ALT_KP_9),
                make(KeyBindings.KPADD, () -> CONFIG.ALT_KP_ADD),
                make(KeyBindings.KPDECIMAL, () -> CONFIG.ALT_KP_DECIMAL),
                make(KeyBindings.KPENTER, () -> CONFIG.ALT_KP_ENTER),
                make(KeyBindings.KPMULTIPLY, () -> CONFIG.ALT_KP_MULTIPLY),
                make(KeyBindings.DOWN, () -> CONFIG.ALT_DOWN),
                make(KeyBindings.LEFT, () -> CONFIG.ALT_LEFT),
                make(KeyBindings.RIGHT, () -> CONFIG.ALT_RIGHT),
                make(KeyBindings.UP, () -> CONFIG.ALT_UP),
                make(KeyBindings.APOSTROPHE, () -> CONFIG.ALT_APOSTROPHE),
                make(KeyBindings.BACKSLASH, () -> CONFIG.ALT_BACKSLASH),
                make(KeyBindings.COMMA, () -> CONFIG.ALT_COMMA),
                make(KeyBindings.EQUAL, () -> CONFIG.ALT_EQUAL),
                make(KeyBindings.GRAVE, () -> CONFIG.ALT_GRAVEACCENT),
                make(KeyBindings.LBRACKET, () -> CONFIG.ALT_LEFTBRACKET),
                make(KeyBindings.MINUS, () -> CONFIG.ALT_MINUS),
                make(KeyBindings.PERIOD, () -> CONFIG.ALT_PERIOD),
                make(KeyBindings.RBRACKET, () -> CONFIG.ALT_RIGHTBRACKET),
                make(KeyBindings.SEMICOLON, () -> CONFIG.ALT_SEMICOLON)
        );
    }

    public static List<KeyMacro> generateCtrl() {
        return Lists.newArrayList(
                make(KeyBindings.G, () -> CONFIG.CTRL_G),
                make(KeyBindings.H, () -> CONFIG.CTRL_H),
                make(KeyBindings.I, () -> CONFIG.CTRL_I),
                make(KeyBindings.J, () -> CONFIG.CTRL_J),
                make(KeyBindings.K, () -> CONFIG.CTRL_K),
                make(KeyBindings.M, () -> CONFIG.CTRL_M),
                make(KeyBindings.N, () -> CONFIG.CTRL_N),
                make(KeyBindings.O, () -> CONFIG.CTRL_O),
                make(KeyBindings.R, () -> CONFIG.CTRL_R),
                make(KeyBindings.U, () -> CONFIG.CTRL_U),
                make(KeyBindings.V, () -> CONFIG.CTRL_V),
                make(KeyBindings.Y, () -> CONFIG.CTRL_Y),
                make(KeyBindings.Z, () -> CONFIG.CTRL_Z),
                make(KeyBindings.F4, () -> CONFIG.CTRL_F4),
                make(KeyBindings.F6, () -> CONFIG.CTRL_F6),
                make(KeyBindings.F7, () -> CONFIG.CTRL_F7),
                make(KeyBindings.F8, () -> CONFIG.CTRL_F8),
                make(KeyBindings.F9, () -> CONFIG.CTRL_F9),
                make(KeyBindings.F10, () -> CONFIG.CTRL_F10),
                make(KeyBindings.F12, () -> CONFIG.CTRL_F12),
                make(KeyBindings.NUMLOCK, () -> CONFIG.CTRL_NUMLOCK),
                make(KeyBindings.KP0, () -> CONFIG.CTRL_KP_0),
                make(KeyBindings.KP1, () -> CONFIG.CTRL_KP_1),
                make(KeyBindings.KP2, () -> CONFIG.CTRL_KP_2),
                make(KeyBindings.KP3, () -> CONFIG.CTRL_KP_3),
                make(KeyBindings.KP4, () -> CONFIG.CTRL_KP_4),
                make(KeyBindings.KP5, () -> CONFIG.CTRL_KP_5),
                make(KeyBindings.KP6, () -> CONFIG.CTRL_KP_6),
                make(KeyBindings.KP7, () -> CONFIG.CTRL_KP_7),
                make(KeyBindings.KP8, () -> CONFIG.CTRL_KP_8),
                make(KeyBindings.KP9, () -> CONFIG.CTRL_KP_9),
                make(KeyBindings.KPADD, () -> CONFIG.CTRL_KP_ADD),
                make(KeyBindings.KPDECIMAL, () -> CONFIG.CTRL_KP_DECIMAL),
                make(KeyBindings.KPENTER, () -> CONFIG.CTRL_KP_ENTER),
                make(KeyBindings.KPMULTIPLY, () -> CONFIG.CTRL_KP_MULTIPLY),
                make(KeyBindings.DOWN, () -> CONFIG.CTRL_DOWN),
                make(KeyBindings.LEFT, () -> CONFIG.CTRL_LEFT),
                make(KeyBindings.RIGHT, () -> CONFIG.CTRL_RIGHT),
                make(KeyBindings.UP, () -> CONFIG.CTRL_UP),
                make(KeyBindings.APOSTROPHE, () -> CONFIG.CTRL_APOSTROPHE),
                make(KeyBindings.BACKSLASH, () -> CONFIG.CTRL_BACKSLASH),
                make(KeyBindings.COMMA, () -> CONFIG.CTRL_COMMA),
                make(KeyBindings.EQUAL, () -> CONFIG.CTRL_EQUAL),
                make(KeyBindings.GRAVE, () -> CONFIG.CTRL_GRAVEACCENT),
                make(KeyBindings.LBRACKET, () -> CONFIG.CTRL_LEFTBRACKET),
                make(KeyBindings.MINUS, () -> CONFIG.CTRL_MINUS),
                make(KeyBindings.PERIOD, () -> CONFIG.CTRL_PERIOD),
                make(KeyBindings.RBRACKET, () -> CONFIG.CTRL_RIGHTBRACKET),
                make(KeyBindings.SEMICOLON, () -> CONFIG.CTRL_SEMICOLON)
        );
    }

    public static List<KeyMacro> generateAltCtrl() {
        return Lists.newArrayList(
                make(KeyBindings.G, () -> CONFIG.ALTCTRL_G),
                make(KeyBindings.H, () -> CONFIG.ALTCTRL_H),
                make(KeyBindings.I, () -> CONFIG.ALTCTRL_I),
                make(KeyBindings.J, () -> CONFIG.ALTCTRL_J),
                make(KeyBindings.K, () -> CONFIG.ALTCTRL_K),
                make(KeyBindings.M, () -> CONFIG.ALTCTRL_M),
                make(KeyBindings.N, () -> CONFIG.ALTCTRL_N),
                make(KeyBindings.O, () -> CONFIG.ALTCTRL_O),
                make(KeyBindings.R, () -> CONFIG.ALTCTRL_R),
                make(KeyBindings.U, () -> CONFIG.ALTCTRL_U),
                make(KeyBindings.V, () -> CONFIG.ALTCTRL_V),
                make(KeyBindings.Y, () -> CONFIG.ALTCTRL_Y),
                make(KeyBindings.Z, () -> CONFIG.ALTCTRL_Z),
                make(KeyBindings.F6, () -> CONFIG.ALTCTRL_F6),
                make(KeyBindings.F7, () -> CONFIG.ALTCTRL_F7),
                make(KeyBindings.F8, () -> CONFIG.ALTCTRL_F8),
                make(KeyBindings.F9, () -> CONFIG.ALTCTRL_F9),
                make(KeyBindings.F10, () -> CONFIG.ALTCTRL_F10),
                make(KeyBindings.F12, () -> CONFIG.ALTCTRL_F12),
                make(KeyBindings.NUMLOCK, () -> CONFIG.ALTCTRL_NUMLOCK),
                make(KeyBindings.KP0, () -> CONFIG.ALTCTRL_KP_0),
                make(KeyBindings.KP1, () -> CONFIG.ALTCTRL_KP_1),
                make(KeyBindings.KP2, () -> CONFIG.ALTCTRL_KP_2),
                make(KeyBindings.KP3, () -> CONFIG.ALTCTRL_KP_3),
                make(KeyBindings.KP4, () -> CONFIG.ALTCTRL_KP_4),
                make(KeyBindings.KP5, () -> CONFIG.ALTCTRL_KP_5),
                make(KeyBindings.KP6, () -> CONFIG.ALTCTRL_KP_6),
                make(KeyBindings.KP7, () -> CONFIG.ALTCTRL_KP_7),
                make(KeyBindings.KP8, () -> CONFIG.ALTCTRL_KP_8),
                make(KeyBindings.KP9, () -> CONFIG.ALTCTRL_KP_9),
                make(KeyBindings.KPADD, () -> CONFIG.ALTCTRL_KP_ADD),
                make(KeyBindings.KPDECIMAL, () -> CONFIG.ALTCTRL_KP_DECIMAL),
                make(KeyBindings.KPENTER, () -> CONFIG.ALTCTRL_KP_ENTER),
                make(KeyBindings.KPMULTIPLY, () -> CONFIG.ALTCTRL_KP_MULTIPLY),
                make(KeyBindings.DOWN, () -> CONFIG.ALTCTRL_DOWN),
                make(KeyBindings.LEFT, () -> CONFIG.ALTCTRL_LEFT),
                make(KeyBindings.RIGHT, () -> CONFIG.ALTCTRL_RIGHT),
                make(KeyBindings.UP, () -> CONFIG.ALTCTRL_UP),
                make(KeyBindings.APOSTROPHE, () -> CONFIG.ALTCTRL_APOSTROPHE),
                make(KeyBindings.BACKSLASH, () -> CONFIG.ALTCTRL_BACKSLASH),
                make(KeyBindings.COMMA, () -> CONFIG.ALTCTRL_COMMA),
                make(KeyBindings.EQUAL, () -> CONFIG.ALTCTRL_EQUAL),
                make(KeyBindings.GRAVE, () -> CONFIG.ALTCTRL_GRAVEACCENT),
                make(KeyBindings.LBRACKET, () -> CONFIG.ALTCTRL_LEFTBRACKET),
                make(KeyBindings.MINUS, () -> CONFIG.ALTCTRL_MINUS),
                make(KeyBindings.PERIOD, () -> CONFIG.ALTCTRL_PERIOD),
                make(KeyBindings.RBRACKET, () -> CONFIG.ALTCTRL_RIGHTBRACKET),
                make(KeyBindings.SEMICOLON, () -> CONFIG.ALTCTRL_SEMICOLON)
        );
    }

    private static KeyMacro make(KeyBinding keyBinding, Supplier<String> command) {
        return new KeyMacro(keyBinding, command);
    }
}
