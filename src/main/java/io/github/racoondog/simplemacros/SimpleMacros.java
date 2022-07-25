package io.github.racoondog.simplemacros;

import com.mojang.logging.LogUtils;
import io.github.racoondog.simplemacros.commands.CommandManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import org.slf4j.Logger;

@Environment(EnvType.CLIENT)
public class SimpleMacros implements ClientModInitializer {
    public static final String MODID = "simplemacros";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final MacroHandler MACRO_HANDLER = new MacroHandler().load();

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) -> {
            CommandManager.registerCommands(dispatcher);
        }));
    }
}
