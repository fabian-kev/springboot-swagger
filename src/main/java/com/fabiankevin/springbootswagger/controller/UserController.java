package com.fabiankevin.springbootswagger.controller;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping
    List<User> getAll(){
        return Arrays.asList(
                User.builder()
                    .birthDate(LocalDate.now())
                    .id(2L)
                    .name("Avi")
                        .build()
        ) ;
    }

    @PostMapping
    User create(@RequestBody @Valid User user){
        return User.builder()
                .birthDate(LocalDate.now())
                .id(2L)
                .name("Avi")
                .build();
    }

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class User {
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
//    @Pattern()
    private String email;
    @Min(18)
    private Integer age;
}