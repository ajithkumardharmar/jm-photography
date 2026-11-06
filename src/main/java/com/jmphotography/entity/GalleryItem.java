package com.jmphotography.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="gallery_items") public class GalleryItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String title; private String category; @Column(length=1000) private String imageUrl; private String caption; private boolean featured=true;
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;} public String getCaption(){return caption;} public void setCaption(String v){caption=v;} public boolean isFeatured(){return featured;} public void setFeatured(boolean v){featured=v;}
}
