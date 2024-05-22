package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        Long regionId;
    }
}
