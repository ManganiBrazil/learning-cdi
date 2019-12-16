package com.mangani.cdi.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.mangani.cdi.type.DateType.PAYROLL_DATE;

public class PayrollDateDeserializer extends StdDeserializer<Date> {

    private static final SimpleDateFormat SDF = new SimpleDateFormat(PAYROLL_DATE.format());

    public PayrollDateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String date = jsonParser.getText();

        try {
            return SDF.parse(date);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
