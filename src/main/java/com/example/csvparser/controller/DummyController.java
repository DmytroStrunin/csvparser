package com.example.csvparser.controller;

import com.example.csvparser.entity.Dummy;
import com.example.csvparser.repository.DummyRepository;
import com.example.csvparser.util.ReadFile;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.List;

@Controller
public class DummyController {

    private final DummyRepository repository;

    public DummyController(DummyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dummy")
    @ResponseBody List<Dummy> all() {
        System.out.println("**GET**");
        return repository.findAll();
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        new ReadFile(repository).readFile(file);
        return "file upload";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer",new Dummy());
        modelAndView.setViewName("start");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody String check(@ModelAttribute("userFromServer") Dummy dummy){
        return "строка";
    }



    @PostMapping("/dummy")
    Dummy newDummy(@RequestBody Dummy newDummy) {
        return repository.save(newDummy);
    }


    @RequestMapping("/dummy/{id}")
    @ResponseBody Dummy one(@PathVariable Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }


    @PutMapping("/dummy/{id}")
    Dummy replaceDummy(@RequestBody Dummy newDummy, @PathVariable Long id) {

        return repository.findById(id)
                .map(dummy -> {
                    dummy.setData(newDummy.getData());
                    return repository.save(dummy);
                })
                .orElseGet(() -> {
                    newDummy.setId(id);
                    return repository.save(newDummy);
                });
    }

    @DeleteMapping("/dummy/{id}")
    void deleteDummy(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
