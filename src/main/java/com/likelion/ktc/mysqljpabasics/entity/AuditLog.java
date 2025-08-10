package com.likelion.ktc.mysqljpabasics.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String action;
  private LocalDateTime timestamp;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getAction() { return action; }
  public void setAction(String action) { this.action = action; }
  public LocalDateTime getTimestamp() { return timestamp; }
  public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
