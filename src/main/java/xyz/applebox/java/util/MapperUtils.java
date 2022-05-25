package xyz.applebox.java.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MapperUtils {

    public static final ObjectMapper jsonMapper;

    static {
        SimpleModule simpleModule = new SimpleModule()
                .addSerializer(LocalDate.class, new LocalDateSerializer())
                .addDeserializer(LocalDate.class, new LocalDateDeserializer())
                .addSerializer(LocalTime.class, new LocalTimeSerializer())
                .addDeserializer(LocalTime.class, new LocalTimeDeserializer())
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer())
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        jsonMapper = JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .addModule(simpleModule)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
                .disable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
                .build();
    }

    static class LocalDateSerializer extends StdSerializer<LocalDate> {
        public LocalDateSerializer() {
            this(null);
        }
        protected LocalDateSerializer(Class<LocalDate> t) {
            super(t);
        }

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.format(DateTimeUtils.DTF_DATE));
        }
    }
    static class LocalDateDeserializer extends StdDeserializer<LocalDate> {
        public LocalDateDeserializer() {
            this(null);
        }
        public LocalDateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(p.getText(), DateTimeUtils.DTF_DATE);
        }
    }

    static class LocalTimeSerializer extends StdSerializer<LocalTime> {
        public LocalTimeSerializer() {
            this(null);
        }
        protected LocalTimeSerializer(Class<LocalTime> t) {
            super(t);
        }

        @Override
        public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.format(DateTimeUtils.DTF_TIME));
        }
    }
    static class LocalTimeDeserializer extends StdDeserializer<LocalTime> {
        public LocalTimeDeserializer() {
            this(null);
        }
        public LocalTimeDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return LocalTime.parse(p.getText(), DateTimeUtils.DTF_TIME);
        }
    }

    static class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
        public LocalDateTimeSerializer() {
            this(null);
        }
        protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
            super(t);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.format(DateTimeUtils.DTF_DATETIME));
        }
    }
    static class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
        public LocalDateTimeDeserializer() {
            this(null);
        }
        public LocalDateTimeDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return LocalDateTime.parse(p.getText(), DateTimeUtils.DTF_DATETIME);
        }
    }
}
