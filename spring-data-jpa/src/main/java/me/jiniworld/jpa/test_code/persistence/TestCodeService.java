package me.jiniworld.jpa.test_code.persistence;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.user.domain.TestCodeSimple;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TestCodeService {
  private final TestCodeRepository testCodeRepository;

  public TestCodeSimple select(Long id) {
    return testCodeRepository.findById(id)
        .map(m ->  new TestCodeSimple(m.getId(), m.getName(), m.isVerified()))
        .orElseThrow(() -> new IllegalArgumentException("Not found id: " + id));
  }

}
