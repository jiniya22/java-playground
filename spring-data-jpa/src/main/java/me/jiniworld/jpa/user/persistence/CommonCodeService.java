package me.jiniworld.jpa.user.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommonCodeService {
  private final CommonCodeRepository commonCodeRepository;

  public CommonCode select(Long id) {
    CommonCode commonCode = commonCodeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Not found id: " + id));
    System.out.println(commonCode);
    return commonCode;
  }

  @Transactional
  public void update(Long id, String data) {
    commonCodeRepository.findById(id).ifPresent(commonCode -> {
      commonCode.setDescription(data);  // 동작 안됨
    });
  }
}
