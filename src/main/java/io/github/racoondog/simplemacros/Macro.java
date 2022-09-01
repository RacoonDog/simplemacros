package io.github.racoondog.simplemacros;

import com.google.gson.JsonObject;
import io.github.racoondog.simplemacros.utils.Enums;
import io.github.racoondog.simplemacros.utils.Util;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.function.Function;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class Macro implements Serializable<Macro> {
    public boolean isCommand;
    public int key;
    public int modifier;
    public String command;
    public Function<Integer, Boolean> isActionTypeValid;

    public Macro() {}

    public Macro(int key, int modifier, String command, int actionType) {
        this.key = key;
        this.modifier = modifier;
        if (command.startsWith("/")) {
            this.isCommand = true;
            this.command = command.substring(1);
        } else {
            this.isCommand = false;
            this.command = command;
        }
        this.isActionTypeValid = Enums.ActionType.indexToFunction(actionType);
    }

    public boolean canRun(int key, int action, int modifier) {
        if (!this.isActionTypeValid.apply(action)) return false;
        if (this.modifier != modifier) return false;
        if (MinecraftClient.getInstance().currentScreen != null) return false;
        return this.key == key;
    }

    public void run() {
        if (isCommand) Util.sendCommand(this.command);
        else Util.sendChatMessage(this.command);
    }

    @Override
    public Macro deserialize(JsonObject json) {
        this.key = json.get("key").getAsInt();
        this.modifier = json.get("modifier").getAsInt();
        this.command = json.get("command").getAsString();
        if (json.has("isCommand")) this.isCommand = json.get("isCommand").getAsBoolean();
        else {
            if (command.startsWith("/")) {
                this.isCommand = true;
                this.command = command.substring(1);
            } else this.isCommand = false;
        }
        this.isActionTypeValid = Enums.ActionType.indexToFunction(json.get("actionType").getAsInt());
        return this;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("key", this.key);
        json.addProperty("modifier", this.modifier);
        json.addProperty("command", this.command);
        json.addProperty("isCommand", this.isCommand);
        json.addProperty("actionType", Enums.ActionType.functionToIndex(this.isActionTypeValid));
        return json;
    }

    @Override
    public String toString() {
        return "%s, %s, Action: %s, \"%s\", Type: %s".formatted(Enums.Key.fromIndex(this.key), Enums.Modifier.fromIndex(this.modifier), Enums.ActionType.functionToIndex(this.isActionTypeValid), this.command, this.isCommand ? "Command" : "Message");
    }
}
