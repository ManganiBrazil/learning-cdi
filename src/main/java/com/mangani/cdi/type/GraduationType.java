package com.mangani.cdi.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mangani.cdi.deserializer.GraduationDeserializer;
import com.mangani.cdi.serializer.GraduationSerializer;

@JsonDeserialize(using = GraduationDeserializer.class)
@JsonSerialize(using = GraduationSerializer.class)
public enum GraduationType {

    FUNDAMENTAL, MEDIUM, SUPERIOR, SPECIALIST, MASTER, DOCTORATE
}
