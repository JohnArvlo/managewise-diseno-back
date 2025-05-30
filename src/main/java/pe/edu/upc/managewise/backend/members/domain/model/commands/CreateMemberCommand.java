package pe.edu.upc.managewise.backend.members.domain.model.commands;

import pe.edu.upc.managewise.backend.members.domain.model.valueobjects.ScrumRoles;

public record CreateMemberCommand(
        Long userId,
        String fullName,
        String email,
        String streetAddress,
        ScrumRoles role
) {}
