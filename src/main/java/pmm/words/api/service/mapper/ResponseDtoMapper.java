package pmm.words.api.service.mapper;

public interface ResponseDtoMapper<M, R> {
    R mapToDto(M model);
}
