package io.github.racoondog.simplemacros;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MacroHandler extends GenericHandler<MacroHandler> {
    public final List<Macro> macroList = Lists.newArrayList();

    public MacroHandler() {
        super(new Identifier(SimpleMacros.MODID, "macrohandler"));
    }

    @Override
    public JsonObject serialize() {
        JsonArray array = new JsonArray();
        for (var macro : this.macroList) {
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
            for (JsonElement jsonElement : array) {
                JsonObject object = jsonElement.getAsJsonObject();
                Macro macro = new Macro();
                macro.deserialize(object);
                this.macroList.add(macro);
            }
        } else {
            SimpleMacros.LOGGER.info("Could not load macros.");
        }
        return this;
    }
}
