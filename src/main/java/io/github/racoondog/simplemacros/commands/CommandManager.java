package io.github.racoondog.simplemacros.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import io.github.racoondog.simplemacros.Macro;
import io.github.racoondog.simplemacros.SimpleMacros;
import io.github.racoondog.simplemacros.utils.Enums;
import io.github.racoondog.simplemacros.utils.Util;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

@Environment(EnvType.CLIENT)
public class CommandManager {
    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) dispatcher.register(literal("macro").then(literal("test").executes(CommandManager::test)));

        dispatcher.register(literal("macro").then(literal("list").executes(CommandManager::list)));

        dispatcher.register(literal("macro").then(literal("remove").then(argument("index", IntegerArgumentType.integer()).executes(CommandManager::remove))));

        dispatcher.register(literal("macro").then(literal("save").executes(CommandManager::save)));

        dispatcher.register(literal("macro").then(literal("add")
                .then(argument("key", EnumArgumentType.key())
                        .then(argument("modifier", EnumArgumentType.modifier())
                                .then(argument("actionType", EnumArgumentType.actionType())
                                        .then(argument("command", StringArgumentType.greedyString())
                                                .executes(CommandManager::add)
                                        )
                                )
                        )
                )
        ));
    }

    private static int save(CommandContext<FabricClientCommandSource> context) {
        SimpleMacros.MACRO_HANDLER.save();
        context.getSource().sendFeedback(Text.literal("Saved macros."));
        return 1;
    }

    private static int test(CommandContext<FabricClientCommandSource> context) {
        SimpleMacros.MACRO_HANDLER.macroList.add(new Macro(Enums.Key.U.keyIdentifier, Enums.Modifier.Alt.modifierIdentifier, "/say testCommand", Enums.ActionType.Press.index));
        context.getSource().sendFeedback(Text.literal("Created test macro."));
        return 1;
    }

    private static int add(CommandContext<FabricClientCommandSource> context) {
        Enums.Key key = EnumArgumentType.getKey(context, "key");
        Enums.Modifier modifier = EnumArgumentType.getModifier(context, "modifier");
        Enums.ActionType actionType = EnumArgumentType.getActionType(context, "actionType");
        String command = StringArgumentType.getString(context, "command");

        if (!Util.verifyMacroValidity(modifier, key)) return 0;

        SimpleMacros.MACRO_HANDLER.macroList.add(new Macro(key.keyIdentifier, modifier.modifierIdentifier, command, actionType.index));
        SimpleMacros.MACRO_HANDLER.save();

        context.getSource().sendFeedback(Text.literal("Successfully created new macro."));

        return 1;
    }

    private static int list(CommandContext<FabricClientCommandSource> context) {
        if (SimpleMacros.MACRO_HANDLER.macroList.size() == 0) context.getSource().sendFeedback(Text.literal("You do not have any macros.").formatted(Formatting.RED));
        for (int i = 0; i < SimpleMacros.MACRO_HANDLER.macroList.size(); i++) {
            context.getSource().sendFeedback(Text.literal("%s: {%s}".formatted(i, SimpleMacros.MACRO_HANDLER.macroList.get(i))));
        }
        return 1;
    }

    private static int remove(CommandContext<FabricClientCommandSource> context) {
        int index = IntegerArgumentType.getInteger(context, "index");
        if (index > SimpleMacros.MACRO_HANDLER.macroList.size() - 1) {
            context.getSource().sendFeedback(Text.literal("Could not remove macro: Index out of bounds.").formatted(Formatting.RED));
            return 0;
        }
        SimpleMacros.MACRO_HANDLER.macroList.remove(index);
        context.getSource().sendFeedback(Text.literal("Successfully removed macro."));
        return 1;
    }
}
