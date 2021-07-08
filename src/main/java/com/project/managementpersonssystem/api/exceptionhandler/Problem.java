package com.project.managementpersonssystem.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {

    private Integer status;
    private LocalDateTime dateTime;
    private String text;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private final String name;
        private final String message;
    }

}
