package io.github.racoondog.simplemacros;

import com.google.gson.JsonObject;
import io.github.racoondog.simplemacros.utils.Enums;
import io.github.racoondog.simplemacros.utils.Util;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class Macro implements Serializable<Macro> {
    public int key;
    public int modifier;
    public String command;
    public Function<Integer, Boolean> isActionTypeValid;

    public Macro() {}

    public Macro(int key, int modifier, String command, int actionType) {
        this.key = key;
        this.modifier = modifier;
        this.command = command;
        this.isActionTypeValid = Enums.ActionType.indexToFunction(actionType);
    }

    public boolean canRun(int key, int action, int modifier) {
        if (!this.isActionTypeValid.apply(action)) return false;
        if (this.modifier != modifier) return false;
        return this.key == key;
    }

    public void run() {
        Util.sendChatMessage(this.command);
    }

    @Override
    public Macro deserialize(JsonObject json) {
        this.key = json.get("key").getAsInt();
        this.modifier = json.get("modifier").getAsInt();
        this.command = json.get("command").getAsString();
        this.isActionTypeValid = Enums.ActionType.indexToFunction(json.get("actionType").getAsInt());
        return this;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("key", this.key);
        json.addProperty("modifier", this.modifier);
        json.addProperty("command", this.command);
        json.addProperty("actionType", Enums.ActionType.functionToIndex(this.isActionTypeValid));
        return json;
    }

    @Override
    public String toString() {
        return "%s, %s, Action: %s, \"%s\"".formatted(Enums.Key.fromIndex(this.key), Enums.Modifier.fromIndex(this.modifier), Enums.ActionType.functionToIndex(this.isActionTypeValid), this.command);
    }
}
