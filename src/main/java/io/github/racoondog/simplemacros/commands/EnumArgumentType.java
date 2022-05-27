package io.github.racoondog.simplemacros.commands;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import io.github.racoondog.simplemacros.Enums;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class EnumArgumentType<T extends Enum<?>> implements ArgumentType<Enum<?>> {
    private static final DynamicCommandExceptionType READER_INVALID_MODIFIER = new DynamicCommandExceptionType(value -> new LiteralMessage("Invalid modifier, '" + value + "' is not a valid modifier"));
    private static final DynamicCommandExceptionType READER_INVALID_ACTIONTYPE = new DynamicCommandExceptionType(value -> new LiteralMessage("Invalid action type, '" + value + "' is not a valid action type"));
    private static final DynamicCommandExceptionType READER_INVALID_KEY = new DynamicCommandExceptionType(value -> new LiteralMessage("Invalid key, '" + value + "' is not a valid key"));
    private static final DynamicCommandExceptionType READER_INVALID_ENUM = new DynamicCommandExceptionType(value -> new LiteralMessage("Invalid enum, '" + value + "' is not a valid enum"));

    private final Class<T> enumKlass;

    private EnumArgumentType(Class<T> enumKlass) {
        this.enumKlass = enumKlass;
    }

    public static EnumArgumentType<Enums.Modifier> modifier() {
        return new EnumArgumentType<>(Enums.Modifier.class);
    }

    public static Enums.Modifier getModifier(final CommandContext<FabricClientCommandSource> context, final String name) {
        return context.getArgument(name, Enums.Modifier.class);
    }

    public static EnumArgumentType<Enums.ActionType> actionType() {
        return new EnumArgumentType<>(Enums.ActionType.class);
    }

    public static Enums.ActionType getActionType(final CommandContext<FabricClientCommandSource> context, final String name) {
        return context.getArgument(name, Enums.ActionType.class);
    }

    public static EnumArgumentType<Enums.Key> key() {
        return new EnumArgumentType<>(Enums.Key.class);
    }

    public static Enums.Key getKey(final CommandContext<FabricClientCommandSource> context, final String name) {
        return context.getArgument(name, Enums.Key.class);
    }

    @Override
    public Enum<?> parse(StringReader reader) throws CommandSyntaxException {
        String string = reader.readString();
        if (enumKlass.equals(Enums.Modifier.class)) {
            try {
                return Enums.Modifier.valueOf(string);
            } catch (IllegalArgumentException e) {
                throw READER_INVALID_MODIFIER.create(string);
            }
        }
        if (enumKlass.equals(Enums.ActionType.class)) {
            try {
                return Enums.ActionType.valueOf(string);
            } catch (IllegalArgumentException e) {
                throw READER_INVALID_ACTIONTYPE.create(string);
            }
        }
        if (enumKlass.equals(Enums.Key.class)) {
            try {
                return Enums.Key.valueOf(string);
            } catch (IllegalArgumentException e) {
                throw READER_INVALID_KEY.create(string);
            }
        }
        throw READER_INVALID_ENUM.create(string);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        if (this.enumKlass.equals(Enums.Modifier.class)) {
            for (var value : Enums.Modifier.values()) {
                builder.suggest(value.name());
            }
        } else if (this.enumKlass.equals(Enums.ActionType.class)) {
            for (var value : Enums.ActionType.values()) {
                builder.suggest(value.name());
            }
        } else if (this.enumKlass.equals(Enums.Key.class)) {
            for (var value : Enums.Key.values()) {
                builder.suggest(value.name());
            }
        }
        return CompletableFuture.supplyAsync(builder::build);
    }

    @Override
    public Collection<String> getExamples() {
        return ArgumentType.super.getExamples();
    }
}
