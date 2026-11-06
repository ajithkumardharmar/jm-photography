package com.jmphotography.repository;
import com.jmphotography.entity.Inquiry; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface InquiryRepository extends JpaRepository<Inquiry,Long> { List<Inquiry> findAllByOrderByCreatedAtDesc(); }
