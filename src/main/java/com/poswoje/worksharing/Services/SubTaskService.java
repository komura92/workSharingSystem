package com.poswoje.worksharing.Services;

import com.poswoje.worksharing.Entities.MainTask;
import com.poswoje.worksharing.Entities.SubTask;
import com.poswoje.worksharing.Repositories.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class SubTaskService {
    private final SubTaskRepository subTaskRepository;
    private final MainTaskService mainTaskService;

    public List<SubTask> getActualTasksForMainTask(Long mainTaskId) {
        MainTask mainTask = mainTaskService.getMainTaskById(mainTaskId);
        return subTaskRepository.findAllByDoneAndMainTask(false, mainTask);
    }

    public List<SubTask> getDoneTasksForMainTask(Long mainTaskId) {
        MainTask mainTask = mainTaskService.getMainTaskById(mainTaskId);
        return subTaskRepository.findAllByDoneAndMainTask(true, mainTask);
    }

    public List<SubTask> getTasksForMainTask(Long mainTaskId) {
        MainTask mainTask = mainTaskService.getMainTaskById(mainTaskId);
        return subTaskRepository.findAllByMainTask(mainTask);
    }

    @Transactional
    public SubTask addSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    @Transactional
    public SubTask editSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    @Transactional
    public String deleteSubTask(SubTask subTask) {
        subTaskRepository.delete(subTask);
        return "(Pod)Zadanie \"" + subTask.getName() + "\" zostało usunięte z bazy.";
    }
}
