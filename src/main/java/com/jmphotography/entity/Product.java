package com.jmphotography.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.math.BigDecimal;
@Entity @Table(name="products") public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=120) private String name;
 @NotBlank @Size(max=80) private String category;
 @Column(length=2000) private String description;
 @DecimalMin("0.0") private BigDecimal price;
 private String imageUrl;
 private boolean featured;
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getName(){return name;} public void setName(String name){this.name=name;} public String getCategory(){return category;} public void setCategory(String category){this.category=category;} public String getDescription(){return description;} public void setDescription(String description){this.description=description;} public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;} public String getImageUrl(){return imageUrl;} public void setImageUrl(String imageUrl){this.imageUrl=imageUrl;} public boolean isFeatured(){return featured;} public void setFeatured(boolean featured){this.featured=featured;}
}
