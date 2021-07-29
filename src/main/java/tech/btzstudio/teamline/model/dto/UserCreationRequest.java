package tech.btzstudio.teamline.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor
public class UserCreationRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
