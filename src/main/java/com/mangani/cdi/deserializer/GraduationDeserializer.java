package com.mangani.cdi.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mangani.cdi.type.GraduationType;

import java.io.IOException;

public class GraduationDeserializer extends StdDeserializer<GraduationType> {

    protected GraduationDeserializer() {
        super(GraduationType.class);
    }

    @Override
    public GraduationType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        String name = jsonNode.get("name").asText();

        for (GraduationType graduationType : GraduationType.values()) {
            if (graduationType.name().equals(name)) {
                return graduationType;
            }
        }

        return null;
    }
}
