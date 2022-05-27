package io.github.racoondog.simplemacros;

public class InputManager {
    public static boolean handleInput(int key, int action, int modifiers) {
        SimpleMacros.LOGGER.info("Input Event Triggered - Key: %s, Action: %s, Modifiers: %s".formatted(key, action, modifiers));
        for (var macro : SimpleMacros.MACRO_HANDLER.macroMap.values()) {
            SimpleMacros.LOGGER.info("Testing Macro - Name: %s".formatted(macro.name));
            if (macro.canRun(key, action, modifiers)) {
                SimpleMacros.LOGGER.info("Macro Passed Test");
                macro.run();
                if (macro.cancel) return true;
            }
        }
        return false;
    }
}
