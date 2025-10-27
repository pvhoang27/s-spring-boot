package com.example.demo.dto.request;
import com.example.demo.exception.ErrorCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

//@Getter
//@Setter

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE)

public class UserCreationRequest {
    @Size(min = 3,message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
     String firstName;
     String lastName ;
     LocalDate dob;
}
