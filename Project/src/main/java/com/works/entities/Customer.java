package com.works.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;

@Entity
@Data
//@Table(name = "customerx")
public class Customer extends Base {

    @Id
    //@Column(name = "cidx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String name;

    @Column(unique = true)
    @Size(min = 7, max = 100)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    @NotNull
    @Max(80)
    @Min(18)
    private Integer age;



}
