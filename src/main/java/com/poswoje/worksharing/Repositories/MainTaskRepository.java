package com.poswoje.worksharing.Repositories;

import com.poswoje.worksharing.Entities.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainTaskRepository extends JpaRepository<MainTask, Long> {
    List<MainTask> findAllByDone(boolean done);
}
