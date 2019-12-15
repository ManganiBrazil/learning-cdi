package com.mangani.cdi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mangani.cdi.type.GraduationType;

import java.io.IOException;

public class GraduationSerializer extends StdSerializer<GraduationType> {

    public GraduationSerializer() {
        super(GraduationType.class);
    }

    @Override
    public void serialize(GraduationType graduationType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(graduationType.name());
        jsonGenerator.writeEndObject();
    }
}
