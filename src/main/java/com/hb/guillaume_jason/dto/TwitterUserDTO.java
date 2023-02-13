package com.hb.guillaume_jason.dto;

import java.util.List;

public record TwitterUserDTO(String username, String password, List<Integer> categoriesId) {
}
