package com.sda.studysystem.controllers;


import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    private Teacher teacher;

    @GetMapping
    public String showTeacherListPage(Model model, @ModelAttribute("message") String message,
                                      @ModelAttribute("messageType") String messageType) {
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "teacher/list-teacher";
    }

   /* @GetMapping("/{id}")
    public String showTeacherViewPage(@PathVariable UUID id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("teacher", teacherService.findTeacherById(id));
            return "teacher/view-teacher";
        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(id, redirectAttributes);
        }
    }*/
    /*@GetMapping("/create")
    public String showCreateTeacherPage (@ModelAttribute("teacher") Teacher teacher,
                @ModelAttribute("message") String message,
                @ModelAttribute("messageType") String messageType){
            return "teacher/create-teacher";
        }*/
    @PostMapping
    public String createTeacher (Teacher teacher, RedirectAttributes redirectAttributes){
            try {
                Teacher searchTeacher = teacherService.findTeacherByIdCode(teacher.getIdCode());
                redirectAttributes.addFlashAttribute("message",
                        String.format("School(%s) already exists!", searchTeacher.getIdCode()));
                redirectAttributes.addFlashAttribute("messageType", "error");
                return "redirect:/teacher/create";
            } catch (TeacherNotFoundException e) {
                teacherService.createTeacher(teacher);
                redirectAttributes.addFlashAttribute("message",
                        String.format("School(%s) created successfully!", teacher.getIdCode()));
                redirectAttributes.addFlashAttribute("messageType", "success");
                return "redirect:/teacher";
            }
        }
    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage (@PathVariable UUID id, Model model, RedirectAttributes redirectAttributes,
                    @RequestParam(value = "school", required = false) Teacher teacher){
                if (teacher == null) {
                    try {
                        model.addAttribute("teacher", teacherService.findTeacherById(id));
                    } catch (TeacherNotFoundException e) {
                        return handleTeacherNotFoundExceptionById(id, redirectAttributes);
                    }
                }
                return "teacher/update-teacher";
            }
    @PostMapping("/update")
    public String updateTeacher(Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            teacherService.updateTeacher(teacher);
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(id=%s) updated successfully!", teacher.getId()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/teacher";
        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(teacher.getId(), redirectAttributes);
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteTeacher (@PathVariable UUID id, RedirectAttributes redirectAttributes){
            try {
                teacherService.deleteTeacherById(id);
                redirectAttributes.addFlashAttribute("message",
                        String.format("Teacher(id=%s) deleted successfully!", id));
                redirectAttributes.addFlashAttribute("messageType", "success");
                return "redirect:/teacher";
            } catch (TeacherNotFoundException e) {
                return handleTeacherNotFoundExceptionById(id, redirectAttributes);
            }
    }
    @GetMapping("/restore/{id}")
    public String restoreTeacher(@PathVariable UUID id, RedirectAttributes redirectAttributes){
        try {
            teacherService.restoreTeacherById(id);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(id=%s) restored successfully!", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/teacher";
        }catch (TeacherNotFoundException e)   {
            return handleTeacherNotFoundExceptionById(id, redirectAttributes);
        }
    }


    private String handleTeacherNotFoundExceptionById (UUID id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher (id=%s) not found!", id));
        redirectAttributes.addFlashAttribute("messageType", "error");
        return "redirect:/teacher";
        }
}
