package pmm.words.api.service.mapper;

public interface RequestDtoMapper<R, M> {
    M mapToModel(R dto);
}
