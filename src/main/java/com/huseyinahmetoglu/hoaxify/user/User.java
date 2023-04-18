package com.huseyinahmetoglu.hoaxify.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tblUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull(message = "{hoaxify.validation.constraints.username.NotNull.message}")
    @NotBlank(message = "{hoaxify.validation.constraints.username.NotNull.message}")
    @Size(min = 4, max = 20, message = "{hoaxify.validation.constraints.display.Size.message}")
    @UniqueUsername(message = "{hoaxify.validation.constraints.display.Unique.message}")
    private String username;

    @NotNull(message = "{hoaxify.validation.constraints.display.NotNull.message}")
    @NotBlank(message = "{hoaxify.validation.constraints.display.NotNull.message}")
    @Size(min = 4, max = 20, message = "{hoaxify.validation.constraints.display.Size.message}")
    private String displayName;

    @NotNull(message = "{hoaxify.validation.constraints.password.NotNull.message}")
    @NotBlank(message = "{hoaxify.validation.constraints.password.NotNull.message}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hoaxify.validation.constraints.password.Pattern.message}")
    @Size(min = 4, max = 20, message = "{hoaxify.validation.constraints.display.Size.message}")
    private String password;

    private String image;

}
