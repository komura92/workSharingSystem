package com.poswoje.worksharing.Repositories;

import com.poswoje.worksharing.Entities.MainTask;
import com.poswoje.worksharing.Entities.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findAllByDoneAndMainTask(boolean done, MainTask mainTask);
    List<SubTask> findAllByMainTask(MainTask mainTask);
}
