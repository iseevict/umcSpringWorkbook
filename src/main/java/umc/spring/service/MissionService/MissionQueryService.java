package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MissionQueryService {

    Page<Mission> getStoreMissionPreviewList(Long storeId, Integer page);
}
