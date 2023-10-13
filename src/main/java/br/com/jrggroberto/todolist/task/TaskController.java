package br.com.jrggroberto.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    var idUs = request.getAttribute("idUser");
    taskModel.setIdUser((UUID) idUs);

    var currentDate = LocalDateTime.now();
    if (currentDate.isAfter(taskModel.getStartAt())) {
      return ResponseEntity.status(403).body("A data de início deve ser maior que a atual");
    }

    if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
      return ResponseEntity.status(401).body("A data início deve ser menor que a data de térmno");
    }

    var task = this.taskRepository.save(taskModel);
    return ResponseEntity.status(200).body(task);

  }

}
