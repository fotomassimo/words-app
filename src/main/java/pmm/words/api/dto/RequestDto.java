package pmm.words.api.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestDto {
    @NotNull(message = "Please, provide a text")
    private String payload;
}
