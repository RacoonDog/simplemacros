package io.github.racoondog.simplemacros;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Iterator;

public class MacroHandler extends GenericHandler<MacroHandler> {
    public final HashMap<String, Macro> macroMap = new HashMap<>();

    public MacroHandler() {
        super(new Identifier(SimpleMacros.MODID, "macrohandler"));
    }

    @Override
    public JsonObject serialize() {
        JsonArray array = new JsonArray();
        for (var macro : this.macroMap.values()) {
            array.add(macro.serialize());
        }
        JsonObject json = new JsonObject();
        json.add("macros", array);
        return json;
    }

    @Override
    public MacroHandler deserialize(JsonObject json) {
        if (json != null && json.has("macros")) {
            JsonArray array = json.getAsJsonArray("macros");
            Iterator<JsonElement> iterator = array.iterator();
            MacroHandler macroHandler = new MacroHandler();
            while (iterator.hasNext()) {
                JsonObject object = iterator.next().getAsJsonObject();
                Macro macro = Macro.deserialize(object);
                macroHandler.macroMap.put(macro.name, macro);
            }
            return macroHandler;
        }
        return this;
    }
}
