package com.taskDomain.taskDomain.Dto;


import java.util.UUID;

public record TaskUpdateRequest(String task,
                                UUID userID
                                ) {

}
