package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.StoreJoinResultDto toJoinResultDto(Store store) {
        return StoreResponseDTO.StoreJoinResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreJoinDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(null)
                .build();
    }
}
