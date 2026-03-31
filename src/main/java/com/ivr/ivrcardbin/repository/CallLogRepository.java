package com.ivr.ivrcardbin.repository;

import com.ivr.ivrcardbin.entity.CallLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallLogRepository extends JpaRepository<CallLog, Long> {
}