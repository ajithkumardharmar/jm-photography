package com.jmphotography.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.LocalDateTime;
@Entity @Table(name="enquiries") public class Inquiry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @NotBlank @Email private String email; @NotBlank private String phone; private String eventType; private String eventDate; @Column(length=2000) private String message; private String status="NEW"; private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public String getEventType(){return eventType;} public void setEventType(String v){eventType=v;} public String getEventDate(){return eventDate;} public void setEventDate(String v){eventDate=v;} public String getMessage(){return message;} public void setMessage(String v){message=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}
