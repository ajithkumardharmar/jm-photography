package com.jmphotography.controller;
import com.jmphotography.entity.Inquiry; import com.jmphotography.repository.*; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*; import jakarta.validation.Valid;
@Controller public class PublicController {
 private final ProductRepository products; private final GalleryRepository gallery; private final InquiryRepository inquiries;
 public PublicController(ProductRepository p,GalleryRepository g,InquiryRepository i){products=p;gallery=g;inquiries=i;}
 @GetMapping("/") public String home(Model m){m.addAttribute("products",products.findByFeaturedTrue());m.addAttribute("gallery",gallery.findByFeaturedTrue());return "index";}
 @GetMapping("/about") public String about(){return "about";}
 @GetMapping("/services") public String services(){return "services";}
 @GetMapping("/portfolio") public String portfolio(Model m){m.addAttribute("gallery",gallery.findAll());return "portfolio";}
 @GetMapping("/contact") public String contact(Model m){m.addAttribute("inquiry",new Inquiry());return "contact";}
 @PostMapping("/enquiry") public String enquiry(@Valid @ModelAttribute("inquiry") Inquiry inquiry, BindingResult result, Model m){if(result.hasErrors()) return "contact"; inquiries.save(inquiry);m.addAttribute("success",true);m.addAttribute("inquiry",new Inquiry());return "contact";}
}
