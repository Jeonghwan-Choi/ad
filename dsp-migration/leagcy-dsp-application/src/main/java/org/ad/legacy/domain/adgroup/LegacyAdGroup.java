package org.ad.legacy.domain.adgroup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class LegacyAdGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String text;
  private Long adGroupId;
  private Long userId;
  private LocalDateTime createdAt;
  private LocalDateTime deletedAt;

  public LegacyAdGroup(String text, Long userId, Long adGroupId, LocalDateTime createdAt) {
    this.text = text;
    this.adGroupId = adGroupId;
    this.userId = userId;
    this.createdAt = createdAt;
    this.deletedAt = null;
  }

  public static LegacyAdGroup of(String text, Long adGroupId, Long userId,
      LocalDateTime createdAt) {
    return new LegacyAdGroup(text, adGroupId, userId, LocalDateTime.now());
  }
}
