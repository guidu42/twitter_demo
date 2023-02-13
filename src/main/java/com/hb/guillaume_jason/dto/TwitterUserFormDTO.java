package com.hb.guillaume_jason.dto;

import jakarta.validation.constraints.NotBlank;

public record TwitterUserFormDTO(@NotBlank String username, @NotBlank String password) {

}
