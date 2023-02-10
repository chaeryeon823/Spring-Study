package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.exception.DMakerException;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkilType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@Transactional
@RequiredArgsConstructor  //service나 controller는 이걸 달아주는게 편리하다.
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validateCreateDeveloperRequest(request);
        //business logic start
        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkilType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId((request.getMemberId()))
                .name(request.getName())
                .age(request.getAge())
                .build();
        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);
//            /* A -> B 1만원 송금 */
//            // A 계좌에서 1만원 줄임
//            developerRepository.save(developer);
//            // B 계좌에서 1만원 늘림
//            developerRepository.delete(developer1);
//            //business logic end
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        //business validation
        //개발하는 어플리케이션에서 요구하는 커스텀 exception을 정해주는 것이 좋다.
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        // Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공하는 메소드로 간단히 회피할 수 있따.
//        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
//        if(developer.isPresent()) {
//            throw  new DMakerException(DUPLICATED_MEMBER_ID);
//        }

        developerRepository.findByMemberId(request.getMemberId()).ifPresent((developer -> {
            throw new DMakerException(DUPLICATED_MEMBER_ID);
        }));
    }

}

