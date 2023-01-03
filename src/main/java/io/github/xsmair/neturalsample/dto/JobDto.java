package io.github.xsmair.neturalsample.dto;

import io.github.xsmair.neturalsample.model.Job;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JobDto {
    private String name;

    private String description;

    public static JobDto fromEntity(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setName(job.getName());
        jobDto.setDescription(job.getDescription());
        return jobDto;
    }

    public static Job toEntity(JobDto jobDto) {
        Job job = new Job();
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        return job;
    }
}
