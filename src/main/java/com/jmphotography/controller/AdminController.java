package com.jmphotography.controller;
import com.jmphotography.entity.*; import com.jmphotography.repository.*; import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/admin") public class AdminController {
 private final ProductRepository products; private final GalleryRepository gallery; private final InquiryRepository inquiries;
 public AdminController(ProductRepository p,GalleryRepository g,InquiryRepository i){products=p;gallery=g;inquiries=i;}
 @GetMapping("/login") public String login(){return "admin/login";}
 @GetMapping public String dashboard(Model m){m.addAttribute("productCount",products.count());m.addAttribute("galleryCount",gallery.count());m.addAttribute("inquiryCount",inquiries.count());m.addAttribute("recent",inquiries.findAllByOrderByCreatedAtDesc().stream().limit(5).toList());return "admin/dashboard";}
 @GetMapping("/products") public String products(Model m){m.addAttribute("products",products.findAll());return "admin/products";}
 @GetMapping("/products/new") public String newProduct(Model m){m.addAttribute("product",new Product());return "admin/product-form";}
 @PostMapping("/products/save") public String saveProduct(@Valid @ModelAttribute Product product,BindingResult result){if(result.hasErrors())return "admin/product-form";products.save(product);return "redirect:/admin/products?saved";}
 @GetMapping("/products/edit/{id}") public String editProduct(@PathVariable Long id,Model m){m.addAttribute("product",products.findById(id).orElseThrow());return "admin/product-form";}
 @PostMapping("/products/delete/{id}") public String deleteProduct(@PathVariable Long id){products.deleteById(id);return "redirect:/admin/products?deleted";}
 @GetMapping("/gallery") public String gallery(Model m){m.addAttribute("gallery",gallery.findAll());return "admin/gallery";}
 @GetMapping("/gallery/new") public String newGallery(Model m){m.addAttribute("item",new GalleryItem());return "admin/gallery-form";}
 @PostMapping("/gallery/save") public String saveGallery(@Valid @ModelAttribute("item") GalleryItem item,BindingResult result){if(result.hasErrors())return "admin/gallery-form";gallery.save(item);return "redirect:/admin/gallery?saved";}
 @PostMapping("/gallery/delete/{id}") public String deleteGallery(@PathVariable Long id){gallery.deleteById(id);return "redirect:/admin/gallery?deleted";}
 @GetMapping("/enquiries") public String enquiries(Model m){m.addAttribute("enquiries",inquiries.findAllByOrderByCreatedAtDesc());return "admin/enquiries";}
 @PostMapping("/enquiries/status/{id}") public String status(@PathVariable Long id,@RequestParam String status){Inquiry i=inquiries.findById(id).orElseThrow();i.setStatus(status);inquiries.save(i);return "redirect:/admin/enquiries";}
}
