package com.mangani.cdi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.mangani.cdi.type.DateType.PAYROLL_DATE;

public class PayrollDateSerializer extends StdSerializer<Date> {

    private static final SimpleDateFormat SDF = new SimpleDateFormat(PAYROLL_DATE.format());

    public PayrollDateSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(SDF.format(date));
    }
}
