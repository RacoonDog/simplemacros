package io.github.racoondog.simplemacros;

import com.google.gson.JsonObject;

public interface Serializable<T> {
    T deserialize(JsonObject json);
    JsonObject serialize();
}
