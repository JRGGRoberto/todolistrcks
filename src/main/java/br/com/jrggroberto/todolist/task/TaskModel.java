package br.com.jrggroberto.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//import lombok.Data;
@Entity(name = "tb_tasks")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private String description;

  @Column(length = 50)
  private String title;
  private LocalDateTime startAt;
  private LocalDateTime endAt;
  private String priority;

  @CreationTimestamp
  private LocalDateTime crDateTime;

  private UUID idUser;

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() throws Exception {
    if (title.length() > 50) {
      throw new Exception("Titulo limite 50 caracteres", null);
    }
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDateTime getStartAt() {
    return this.startAt;
  }

  public void setStartAt(LocalDateTime startAt) {
    this.startAt = startAt;
  }

  public LocalDateTime getEndAt() {
    return this.endAt;
  }

  public void setEndAt(LocalDateTime endAt) {
    this.endAt = endAt;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public LocalDateTime getCrDateTime() {
    return this.crDateTime;
  }

  public void setCrDateTime(LocalDateTime crDateTime) {
    this.crDateTime = crDateTime;
  }

  public UUID getIdUser() {
    return this.idUser;
  }

  public void setIdUser(UUID idUser) {
    this.idUser = idUser;
  }

}
