package io.github.racoondog.simplemacros;

import com.google.gson.JsonObject;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

import java.util.function.Function;

public class Macro implements Serializable<Macro> {
    public final String name;
    public final int key;
    public final int modifier;
    public final String command;
    public final Function<Integer, Boolean> isActionTypeValid;
    public final boolean cancel;

    public Macro(String name, int key, int modifier, String command, Function<Integer, Boolean> isActionTypeValid, boolean cancel) {
        this.name = name;
        this.key = key;
        this.modifier = modifier;
        this.command = command;
        this.isActionTypeValid = isActionTypeValid;
        this.cancel = cancel;
    }

    public boolean canRun(int key, int action, int modifier) {
        SimpleMacros.LOGGER.info("Macro Info - Key: %s, Action: %s, Modifiers: %s".formatted(this.key, this.isActionTypeValid.toString(), this.modifier));
        SimpleMacros.LOGGER.info("Input Info - Key: %s, Action: %s, Modifiers: %s".formatted(key, action, modifier));
        if (!this.isActionTypeValid.apply(action)) return false;
        if (this.modifier != modifier) return false;
        return this.key == key;
    }

    public void run() {
        Util.sendChatMessage(this.command);
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("name", this.name);
        json.addProperty("key", this.key);
        json.addProperty("modifer", this.modifier);
        json.addProperty("command", this.command);
        json.addProperty("actionType", Enums.ActionType.functionToIndex(this.isActionTypeValid));
        json.addProperty("cancel", this.cancel);
        return json;
    }

    public static Macro deserialize(JsonObject json) {
        String name = json.get("name").getAsString();
        int key = json.get("key").getAsInt();
        int modifier = json.get("modifier").getAsInt();
        String command = json.get("command").getAsString();
        int actionType = json.get("actionType").getAsInt();
        boolean cancel = json.get("cancel").getAsBoolean();
        return new Macro(name, key, modifier, command, Enums.ActionType.indexToFunction(actionType), cancel);
    }
}
