package pmm.words.api.service.mapper;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pmm.words.api.dto.ResponseDto;
import pmm.words.api.model.Request;
import pmm.words.api.model.Word;

class RequestToResponseDtoMapperTest {
    private static ResponseDtoMapper<Request, ResponseDto> mapper;
    private static ResponseDto expected;
    private static Request request;

    @BeforeAll
    static void beforeAll() {
        mapper = new RequestToResponseDtoMapper();
        expected = new ResponseDto();
        request = new Request();
    }

    @Test
    void mapToDto_EmptyRequest_Ok() {
        request.setPayload("");
        request.setWords(new ArrayList<>());
                expected.setWordsAndTheirEntries(new ArrayList<>());
                expected.setUniqueWordsCount("Unique: 0");
        Assertions.assertEquals(expected, mapper.mapToDto(request));
    }

    @Test
    void mapToDto_RandomRequest_Ok() {
        request.setPayload("first, second");
        request.setWords(List.of(new Word("first", 1), new Word("second", 1)));
        expected.setWordsAndTheirEntries(List.of("first - 1", "second - 1"));
        expected.setUniqueWordsCount("Unique: 2");
        Assertions.assertEquals(expected, mapper.mapToDto(request));
    }
}