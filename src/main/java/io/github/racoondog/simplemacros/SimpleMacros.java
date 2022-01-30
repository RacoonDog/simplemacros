package io.github.racoondog.simplemacros;

import io.github.racoondog.simplemacros.client.KeyMacro;
import io.github.racoondog.simplemacros.client.KeyMacros;
import io.github.racoondog.simplemacros.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.util.List;

@Environment(EnvType.CLIENT)
public class SimpleMacros implements ClientModInitializer {
    public static final String MODID = "simplemacros";
    public static final ModConfig CONFIG;

    static {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    private static final KeyBinding modifierKeyBinding = keybind("modifier", InputUtil.GLFW_KEY_RIGHT_ALT);
    private static final KeyBinding modifierKeyBinding2 = keybind("modifier2", InputUtil.GLFW_KEY_RIGHT_CONTROL);

    private static final List<KeyMacro> MACROS_ALT = KeyMacros.generateAlt();
    private static final List<KeyMacro> MACROS_CTRL = KeyMacros.generateCtrl();
    private static final List<KeyMacro> MACROS_ALT_CTRL = KeyMacros.generateAltCtrl();

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean bl1 = modifierKeyBinding.isPressed();
            boolean bl2 = modifierKeyBinding2.isPressed();
            if (bl1 && bl2) {
                for (var macro : MACROS_ALT_CTRL) {
                    if (macro.pressed()) {
                        macro.execute();
                    }
                }
            } else if (bl1) {
                for (var macro : MACROS_ALT) {
                    if (macro.pressed()) {
                        macro.execute();
                    }
                }
            } else if (bl2) {
                for (var macro : MACROS_CTRL) {
                    if (macro.pressed()) {
                        macro.execute();
                    }
                }
            }
        });
    }

    private static KeyBinding keybind(String id, int keybind) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.%s.%s".formatted(MODID, id),
                keybind,
                "category.%s.keys".formatted(MODID)
        ));
    }
}
