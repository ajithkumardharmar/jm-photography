package com.jmphotography.repository;
import com.jmphotography.entity.GalleryItem; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface GalleryRepository extends JpaRepository<GalleryItem,Long> { List<GalleryItem> findByFeaturedTrue(); }
