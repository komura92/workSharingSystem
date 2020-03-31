package com.poswoje.worksharing.Controllers;

import com.poswoje.worksharing.Entities.MainTask;
import com.poswoje.worksharing.Services.MainTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainTasks")
@RequiredArgsConstructor
@Slf4j
public class MainTaskController {
    private final MainTaskService mainTaskService;

    @GetMapping
    public ResponseEntity<List<MainTask>> getActualMainTasks() {
        return ResponseEntity.ok(mainTaskService.getActualMainTasks());
    }

    @GetMapping(value = "/done")
    public ResponseEntity<List<MainTask>> getMainTaskHistory() {
        return ResponseEntity.ok(mainTaskService.getMainTaskHistory());
    }

    @PostMapping
    public ResponseEntity<MainTask> addMainTask(@RequestBody MainTask mainTask) {
        return ResponseEntity.ok(mainTaskService.addMainTask(mainTask));
    }

    @PutMapping
    public ResponseEntity<MainTask> editMainTask(@RequestBody MainTask mainTask) {
        return ResponseEntity.ok(mainTaskService.editMainTask(mainTask));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMainTask(@RequestBody MainTask mainTask) {
        return ResponseEntity.ok(mainTaskService.deleteMainTask(mainTask));
    }
}
