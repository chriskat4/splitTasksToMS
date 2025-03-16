package com.taskDomain.taskDomain.Dto;

import java.util.List;
import java.util.UUID;


public record TaskDto(
                    List<String> tasks,
                    UUID userID
                    ) {

}
