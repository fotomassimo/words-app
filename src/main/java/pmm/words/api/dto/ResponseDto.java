package pmm.words.api.dto;

import java.util.List;
import lombok.Data;

@Data
public class ResponseDto {
    private List<String> wordsAndTheirEntries;
    private String uniqueWordsCount;
}
