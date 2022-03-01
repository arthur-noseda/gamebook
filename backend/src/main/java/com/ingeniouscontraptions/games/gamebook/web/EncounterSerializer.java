package com.ingeniouscontraptions.games.gamebook.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

import java.io.IOException;

public class EncounterSerializer extends StdSerializer<Encounter> {

    public EncounterSerializer(Class<Encounter> t) {
        super(t);
    }

    @Override
    public void serialize(Encounter value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("roundNumber", value.getRoundNumber());
        gen.writeStringField("message", value.getMessage());
        gen.writeEndObject();
    }

}