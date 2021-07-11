package pmm.words.api.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pmm.words.api.dto.RequestDto;
import pmm.words.api.model.Request;
import pmm.words.api.model.Word;


class RequestDtoToRequestMapperTest {
    private static RequestDtoMapper<RequestDto, Request> mapper;
    private static RequestDto requestDto;

    @BeforeAll
    static void beforeAll() {
        mapper = new RequestDtoToRequestMapper();
        requestDto = new RequestDto();
    }

    @Test
    void mapToModel_EmptyInput_Ok() {
        String payload = "";
        requestDto.setPayload(payload);
        Request expected = new Request();
        expected.setPayload(payload);
        expected.setWords(new ArrayList<>());
        Assertions.assertEquals(expected, mapper.mapToModel(requestDto));
    }

    @Test
    void mapToModel_OnlyWordsInOutput_Ok() {
        String payload = "5 5.0 5. .5 \n \r @ ! # $ % ^ & * ( ) _ : ? > < , | ~ ` \\ / \" . word";
        requestDto.setPayload(payload);
        Collection<Word> actual = mapper.mapToModel(requestDto).getWords();
        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(new Word("word", 1)));
    }

    @Test
    void mapToModel_CaseInsensitiveOutputAndCount_Ok() {
        String payload = "Word, WORD! wORD: word.";
        requestDto.setPayload(payload);
        int count = 4;
        Collection<Word> actual = mapper.mapToModel(requestDto).getWords();
        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(new Word("word", count)));
    }
}