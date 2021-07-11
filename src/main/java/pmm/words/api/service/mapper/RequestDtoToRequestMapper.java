package pmm.words.api.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import pmm.words.api.dto.RequestDto;
import pmm.words.api.model.Request;
import pmm.words.api.model.Word;

@Component
public class RequestDtoToRequestMapper implements RequestDtoMapper<RequestDto, Request> {
    private static final String WORD_REGEX_PATTERN = "[\\p{Alpha}]+\\w*|\\w*[\\p{Alpha}]";

    @Override
    public Request mapToModel(RequestDto requestDto) {
        Request request = new Request();
        request.setPayload(requestDto.getPayload());
        request.setWords(parseRequest(requestDto.getPayload()));
        return request;
    }

    private Collection<Word> parseRequest(String payload) {
        Map<String, Integer> wordsMap = new HashMap<>();
        Matcher matcher = Pattern.compile(WORD_REGEX_PATTERN).matcher(payload.trim());
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        return wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(mapEntry -> new Word(mapEntry.getKey(), mapEntry.getValue()))
                .collect(Collectors.toCollection(ArrayList<Word>::new));
    }
}
