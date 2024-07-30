package org.ad.legacy.domain.keyword;

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
public class LegacyKeyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Long userId;
  private Long campaignId;
  private String linkUrl;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  public LegacyKeyword(String name, Long userId, Long campaignId, String linkUrl,
      LocalDateTime createdAt) {
    this.name = name;
    this.userId = userId;
    this.campaignId = campaignId;
    this.linkUrl = linkUrl;
    this.createdAt = createdAt;
    this.updatedAt = createdAt;
    this.deletedAt = updatedAt;
  }

  public static LegacyKeyword of(String name, Long userId, Long campaignId, String linkUrl) {
    return new LegacyKeyword(name, userId, campaignId, linkUrl, LocalDateTime.now());
  }

  public void updateName(String newName) {
    name = newName;
    updatedAt = LocalDateTime.now();
  }

  public void deleteUser() {
    deletedAt = LocalDateTime.now();
  }
}
