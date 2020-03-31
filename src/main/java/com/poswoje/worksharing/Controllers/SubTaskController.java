package com.poswoje.worksharing.Controllers;

import com.poswoje.worksharing.Entities.SubTask;
import com.poswoje.worksharing.Services.SubTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subTasks")
@RequiredArgsConstructor
@Slf4j
public class SubTaskController {
    private final SubTaskService subTaskService;

    @GetMapping("/{mainTaskId}")
    public ResponseEntity<List<SubTask>> geActualtTasksForMainTask(@PathVariable Long mainTaskId) {
        return ResponseEntity.ok(subTaskService.getActualTasksForMainTask(mainTaskId));
    }

    @GetMapping("/{mainTaskId}/done")
    public ResponseEntity<List<SubTask>> getDoneTasksForMainTask(@PathVariable Long mainTaskId) {
        return ResponseEntity.ok(subTaskService.getDoneTasksForMainTask(mainTaskId));
    }

    @GetMapping("/{mainTaskId}/all")
    public ResponseEntity<List<SubTask>> getTasksForMainTask(@PathVariable Long mainTaskId) {
        return ResponseEntity.ok(subTaskService.getTasksForMainTask(mainTaskId));
    }

    @PostMapping
    public ResponseEntity<SubTask> addSubTask(@RequestBody SubTask subTask) {
        return ResponseEntity.ok(subTaskService.addSubTask(subTask));
    }

    @PutMapping
    public ResponseEntity<SubTask> editSubTask(@RequestBody SubTask subTask) {
        return ResponseEntity.ok(subTaskService.editSubTask(subTask));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSubTask(@RequestBody SubTask subTask) {
        return ResponseEntity.ok(subTaskService.deleteSubTask(subTask));
    }
}
