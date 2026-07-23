package by.vstu.vsrpp.exam.studgroup.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import by.vstu.vsrpp.exam.studgroup.dto.GroupRequest;
import by.vstu.vsrpp.exam.studgroup.dto.GroupResponse;
import by.vstu.vsrpp.exam.studgroup.entity.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {


    GroupResponse toResponse(Group group);
    java.util.List<GroupResponse> toResponseList(java.util.List<Group> groups);

    // NEW: Для CREATE
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusDate", ignore = true)
    Group toEntity(GroupRequest request);

    // NEW: Для UPDATE (обновляет существующую сущность)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusDate", ignore = true)
    void updateEntityFromDto(GroupRequest request, @MappingTarget Group group);
}