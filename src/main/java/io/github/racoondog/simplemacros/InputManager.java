package io.github.racoondog.simplemacros;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class InputManager {
    public static boolean handleInput(int key, int action, int modifiers) {
        for (var macro : SimpleMacros.MACRO_HANDLER.macroList) {
            if (macro.canRun(key, action, modifiers)) {
                macro.run();
                if (macro.cancel) return true;
            }
        }
        return false;
    }
}
