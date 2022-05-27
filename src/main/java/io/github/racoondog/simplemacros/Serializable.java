package io.github.racoondog.simplemacros;

import com.google.gson.JsonObject;

public interface Serializable<T> {
    JsonObject serialize();
}
