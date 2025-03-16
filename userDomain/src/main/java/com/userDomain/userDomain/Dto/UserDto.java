package com.userDomain.userDomain.Dto;

import java.util.UUID;

public record UserDto(
                        UUID id,
                        String email,
                        String name,
                        String password
                        ) {

}
