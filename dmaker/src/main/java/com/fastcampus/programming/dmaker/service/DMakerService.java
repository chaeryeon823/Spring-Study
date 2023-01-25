package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkilType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@Transactional
@RequiredArgsConstructor  //service나 controller는 이걸 달아주는게 편리하다.
public class DMakerService {
    private final DeveloperRepository developerRepository;

    private final EntityManager em;
    @Transactional
    public void createDeveloper(CreateDeveloper.Request request) {
            //business logic start
            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkilType(DeveloperSkilType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();

//            /* A -> B 1만원 송금 */
//            // A 계좌에서 1만원 줄임
//            developerRepository.save(developer);
//            // B 계좌에서 1만원 늘림
//            developerRepository.delete(developer1);
//            //business logic end
    }

}
