package io.github.racoondog.simplemacros;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenericHandler<T> implements Serializable<T> {
    private static final TypeAdapter<JsonObject> ADAPTER = new Gson().getAdapter(JsonObject.class);
    private final File file;

    public GenericHandler(Identifier id) {
        String namespace = id.getNamespace();

        Path configDir = FabricLoader.getInstance().getConfigDir();
        if (!Files.isDirectory(configDir.resolve(namespace))) {
            try {
                Files.createDirectory(configDir.resolve(namespace));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.file = configDir.resolve(id.getNamespace()).resolve(id.getPath() + ".json").toFile();
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(this.file);
            JsonWriter jsonWriter = new JsonWriter(writer);
            ADAPTER.write(jsonWriter, this.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T load() {
        if (this.file.exists()) {
            try {
                FileReader fileReader = new FileReader(this.file);
                JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
                return this.deserialize(jsonObject);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            this.save();
            return this.load();
        }
    }

    @Override
    public JsonObject serialize() {
        return null;
    }

    @Override
    public T deserialize(JsonObject json) {
        return null;
    }
}
