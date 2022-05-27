package io.github.racoondog.simplemacros;

import com.mojang.logging.LogUtils;
import io.github.racoondog.simplemacros.commands.CommandManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;

@Environment(EnvType.CLIENT)
public class SimpleMacros implements ClientModInitializer {
    //todo fix saving
    //todo make enum suggestions change based on what's written
    //todo make better add command

    public static final String MODID = "simplemacros";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final MacroHandler MACRO_HANDLER = new MacroHandler().load();

    @Override
    public void onInitializeClient() {
        CommandManager.registerCommands();
    }
}
