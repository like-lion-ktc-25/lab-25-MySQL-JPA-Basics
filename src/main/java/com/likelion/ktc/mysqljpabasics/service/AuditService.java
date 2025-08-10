package com.likelion.ktc.mysqljpabasics.service;

import org.springframework.stereotype.Service;

import com.likelion.ktc.mysqljpabasics.entity.AuditLog;
import com.likelion.ktc.mysqljpabasics.repository.AuditLogRepository;
import java.time.LocalDateTime;

@Service
public class AuditService {

  private final AuditLogRepository auditLogRepository;

  public AuditService(AuditLogRepository auditLogRepository) {
    this.auditLogRepository = auditLogRepository;
  }

  public void log(String action) {
    AuditLog log = new AuditLog();
    log.setAction(action);
    log.setTimestamp(LocalDateTime.now());
    auditLogRepository.save(log);
  }
}