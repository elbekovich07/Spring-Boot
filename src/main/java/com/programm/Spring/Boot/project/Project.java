package com.programm.Spring.Boot.project;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "uc_project_code", columnNames = {"code"})
})
@NamedQueries({
        @NamedQuery(name = "Project.findByNameIgnoreCaseOrderByIdDesc", query = "select p from Project p where upper(p.name) = upper(:name) order by p.id DESC")
})
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Size(message = "Project code length must be between {min} and {max}", min = 4, max = 30)
    @NotBlank(message = "Project Column can not blank")
    @Column(updatable = false, nullable = false)
    String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project")
    private ProjectColumn projectColumn;

}
