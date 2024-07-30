package org.ad.legacy.domain.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class LegacyUserTest {

  LegacyUser user = LegacyUser.of("name");

  @Test
  void updateName() {
    LocalDateTime before = LocalDateTime.now();
    user.updateName("newName");
    LocalDateTime after = LocalDateTime.now();
    assertAll(
        () -> assertThat(user.getName()).isEqualTo("newName"),
        () -> assertThat(user.getUpdatedAt())
            .isAfter(after)
            .isBefore(before));
  }

  @Test
  void deleteUser() {
    LocalDateTime before = LocalDateTime.now();
    user.deleteUser();
    LocalDateTime after = LocalDateTime.now();
    assertThat(user.getDeletedAt())
        .isAfter(after)
        .isBefore(before);

  }
}