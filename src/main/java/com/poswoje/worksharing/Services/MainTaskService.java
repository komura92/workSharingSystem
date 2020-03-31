package com.poswoje.worksharing.Services;

import com.poswoje.worksharing.Entities.MainTask;
import com.poswoje.worksharing.Exceptions.MainTaskNotFoundException;
import com.poswoje.worksharing.Repositories.MainTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class MainTaskService {
    private final MainTaskRepository mainTaskRepository;

    public List<MainTask> getActualMainTasks() {
        return mainTaskRepository.findAllByDone(false);
    }

    public List<MainTask> getMainTaskHistory() {
        return mainTaskRepository.findAllByDone(true);
    }

    @Transactional
    public MainTask addMainTask(MainTask mainTask) {
        return mainTaskRepository.save(mainTask);
    }

    @Transactional
    public MainTask editMainTask(MainTask mainTask) {
        return mainTaskRepository.save(mainTask);
    }

    @Transactional
    public String deleteMainTask(MainTask mainTask) {
        mainTaskRepository.delete(mainTask);
        return "Zadanie \"" + mainTask.getName() + "\" zostało usunięte z bazy.";
    }

    public MainTask getMainTaskById(Long id) {
        return mainTaskRepository.findById(id).orElseThrow(() -> new MainTaskNotFoundException(id));
    }
}
