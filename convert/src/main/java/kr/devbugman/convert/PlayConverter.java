package kr.devbugman.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Converter
@Component
public class PlayConverter implements AttributeConverter<List<Long>, String> {

    private final ObjectMapper objectMapper;

    private static final String SPLIT_CHAR = ",";

    public PlayConverter(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String convertToDatabaseColumn(final List<Long> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<Long> convertToEntityAttribute(final String dbData) {
//        if (dbData == null || dbData.isBlank()) {
//            return new ArrayList<>();
//        }
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<Long>>() {});
        } catch (JsonProcessingException e) {
            return new ArrayList<>();
        }
    }
}
