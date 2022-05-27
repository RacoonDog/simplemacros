package io.github.racoondog.simplemacros.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import io.github.racoondog.simplemacros.*;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.text.LiteralText;

import java.util.Map;
import java.util.Set;

import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.literal;

public class CommandManager {
    public static void registerCommands() {
        ClientCommandManager.DISPATCHER.register(literal("macro")
                .then(literal("add")
                        .then(argument("name", StringArgumentType.word())
                                .then(argument("modifier", EnumArgumentType.modifier())
                                        .then(argument("key", EnumArgumentType.key())
                                                .then(argument("actionType", EnumArgumentType.actionType())
                                                        .then(argument("cancel", BoolArgumentType.bool())
                                                                .then(argument("command", StringArgumentType.greedyString())
                                                                        .executes(CommandManager::add))))))))
                .then(literal("list").executes(CommandManager::list))
                .then(literal("remove").then(argument("name", StringArgumentType.word()).executes(CommandManager::remove)))
                .then(literal("test").executes(CommandManager::test))
                .then(literal("save").executes(CommandManager::save)));
    }

    private static int save(CommandContext<FabricClientCommandSource> context) {
        SimpleMacros.MACRO_HANDLER.save();
        return 1;
    }

    private static int test(CommandContext<FabricClientCommandSource> context) {
        SimpleMacros.MACRO_HANDLER.macroMap.put("test", new Macro("test", Enums.Key.U.keyIdentifier, Enums.Modifier.Alt.modifierIdentifier, "/say testCommand", Enums.ActionType.Press.isValid, false));
        return 1;
    }

    private static int add(CommandContext<FabricClientCommandSource> context) {
        String name = StringArgumentType.getString(context, "name");
        Enums.Modifier modifier = EnumArgumentType.getModifier(context, "modifier");
        Enums.Key key = EnumArgumentType.getKey(context, "key");
        Enums.ActionType actionType = EnumArgumentType.getActionType(context, "actionType");
        boolean cancel = BoolArgumentType.getBool(context, "cancel");
        String command = StringArgumentType.getString(context, "command");

        if (!Util.verifyMacroValidity(modifier, key, cancel)) return 0;

        SimpleMacros.MACRO_HANDLER.macroMap.put(name, new Macro(name, key.keyIdentifier, modifier.modifierIdentifier, command, actionType.isValid, cancel));
        SimpleMacros.MACRO_HANDLER.save();

        return 1;
    }

    private static int list(CommandContext<FabricClientCommandSource> context) {
        Set<Map.Entry<String, Macro>> macros = SimpleMacros.MACRO_HANDLER.macroMap.entrySet();
        for (var macro : macros) {
            context.getSource().sendFeedback(new LiteralText("'%s': '%s'".formatted(macro.getKey(), macro.getValue())));
        }
        return 1;
    }

    private static int remove(CommandContext<FabricClientCommandSource> context) {
        String name = StringArgumentType.getString(context, "name");
        if (!SimpleMacros.MACRO_HANDLER.macroMap.containsKey(name)) {
            context.getSource().sendFeedback(new LiteralText("Unknown macro. Use /macro list to see all macros."));
            return 0;
        }
        SimpleMacros.MACRO_HANDLER.macroMap.remove(name);
        return 1;
    }
}
