package com.programm.Spring.Boot.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Project}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreateDto implements Serializable {
    private String name;
}