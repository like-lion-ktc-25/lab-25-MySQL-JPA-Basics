package com.likelion.ktc.mysqljpabasics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.likelion.ktc.mysqljpabasics.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
