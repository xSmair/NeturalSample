package io.github.xsmair.neturalsample.repository;

import io.github.xsmair.neturalsample.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
