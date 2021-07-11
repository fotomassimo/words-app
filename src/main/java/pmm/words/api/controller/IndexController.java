package pmm.words.api.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pmm.words.api.dto.RequestDto;
import pmm.words.api.dto.ResponseDto;
import pmm.words.api.model.Request;
import pmm.words.api.service.RequestService;
import pmm.words.api.service.mapper.RequestDtoToRequestMapper;
import pmm.words.api.service.mapper.RequestToResponseDtoMapper;

@Controller
@RequestMapping("/index")
public class IndexController {
    private final RequestService requestService;
    private final RequestDtoToRequestMapper dtoToRequestMapper;
    private final RequestToResponseDtoMapper requestToResponseDtoMapper;

    public IndexController(RequestService requestService,
                           RequestDtoToRequestMapper dtoToRequestMapper,
                           RequestToResponseDtoMapper requestToResponseDtoMapper) {
        this.requestService = requestService;
        this.dtoToRequestMapper = dtoToRequestMapper;
        this.requestToResponseDtoMapper = requestToResponseDtoMapper;
    }

    @PostMapping
    @ResponseBody
    public ResponseDto getWordsFromRequest(@Valid @RequestBody RequestDto requestDto) {
        Request request = dtoToRequestMapper.mapToModel(requestDto);
        requestService.addStatistics(request);
        return requestToResponseDtoMapper.mapToDto(request);
    }
}
