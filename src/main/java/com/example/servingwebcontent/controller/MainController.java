//package com.example.servingwebcontent.controller;
//
//import com.example.servingwebcontent.models.Message;
//import com.example.servingwebcontent.models.Stock;
//import com.example.servingwebcontent.repos.MessageRepo;
//import com.example.servingwebcontent.repos.StockRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
////import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.io.IOException;
//import java.util.Map;
//
//@Controller
//public class MainController {
//    @Autowired
//    private MessageRepo messageRepo;
//
//    @Autowired
//    private StockRepo stockRepo;
//
//    @Value("${upload.path}")
//    private String uploadPath;
//
//    @GetMapping("/")
//    public String greeting(Model model) {
//        Iterable<Stock> stocks = stockRepo.findAll();
//        model.addAttribute("stocks", stocks);
//        return "stock";
//    }
//
//    @GetMapping("/main")
//    public String main(@RequestParam(required = false) String filter, Model model) {
//        Iterable<Message> messages = messageRepo.findAll();
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.addAttribute("messages", messages);
//        model.addAttribute("filter", filter);
//        return "main";
//    }
//
////    @PostMapping("/main")
////    public String add(
//////            @AuthenticationPrincipal User user,
////            @RequestParam String text,
////            @RequestParam String tag,
////            Map<String, Object> model,
////            @RequestParam("file") MultipartFile file
////
////            ) throws IOException {
//////        Message message = new Message(text, tag, user);
////
////        if (file != null && !file.getOriginalFilename().isEmpty()) {
////            File uploadDir = new File(uploadPath);
////
////            if (!uploadDir.exists()) {
////                uploadDir.mkdir();
////            }
////
////            String uuidFile = UUID.randomUUID().toString();
////            String resultFilename = uuidFile + "." + file.getOriginalFilename();
////
////            file.transferTo(new File(uploadPath + "/" + resultFilename));
////
////            message.setFilename(resultFilename);
////        }
////        messageRepo.save(message);
////
////        Iterable<Message> messages = messageRepo.findAll();
////        model.put("messages", messages);
////
////        return "main";
////    }
//
//    @PostMapping("/")
//    public String addStock(
//            @RequestParam String nameStock,
//            Map<String, Object> model
//
//    ) throws IOException {
//        Stock stock = new Stock(nameStock);
//
//        if (nameStock != null && !nameStock.isEmpty()) {
//            stockRepo.save(stock);
//        }
//        Iterable<Stock> stocks = stockRepo.findAll();
//        model.put("stocks", stocks);
//
//        return "stock";
//    }
//}