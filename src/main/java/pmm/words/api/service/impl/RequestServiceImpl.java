package pmm.words.api.service.impl;

import org.springframework.stereotype.Service;
import pmm.words.api.model.Request;
import pmm.words.api.repository.RequestRepository;
import pmm.words.api.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService<Request> {
    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request addStatistics(Request request) {
        return requestRepository.save(request);
    }
}
