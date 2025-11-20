package com.programm.Spring.Boot.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link Project}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto implements Serializable {
    private String name;
    @Size(message = "Project code length must be between {min} and {max}", min = 4, max = 30)
    @NotBlank(message = "Project Column can not blank")
    private String code;
    private List<ProjectColumnDto> projectColumn = new ArrayList<>();
}