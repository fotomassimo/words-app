package pmm.words.api.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import pmm.words.api.dto.ResponseDto;
import pmm.words.api.model.Request;

@Component
public class RequestToResponseDtoMapper implements ResponseDtoMapper<Request, ResponseDto> {
    private static final String WORD_AND_ENTRY_SEPARATOR = " - ";
    private static final String TOTAL_COUNT_TITLE = "Unique: ";

    @Override
    public ResponseDto mapToDto(Request request) {
        ResponseDto responseDto = new ResponseDto();
        List<String> wordsWithEntriesList = request
                .getWords()
                .stream()
                .map(element -> new StringBuilder(element.getWord())
                        .append(WORD_AND_ENTRY_SEPARATOR)
                        .append(element.getEntry())
                        .toString())
                .collect(Collectors.toList());
        responseDto.setWordsAndTheirEntries(wordsWithEntriesList);
        responseDto.setUniqueWordsCount(TOTAL_COUNT_TITLE + wordsWithEntriesList.size());
        return responseDto;
    }
}
