package uz.pdp.spring_boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.services.task.TaskService;

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {
    public TaskController(TaskService service) {
        super(service);
    }

//    @RequestMapping(value = "create/", method = RequestMethod.GET)
//    public String createPage() {
//        return "task/create";
//    }


    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto dto) {
        service.create(dto);
        return "redirect:/project/projects/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("task", service.get(id));
        return "task/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskUpdateDto dto) {
        service.update(dto);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("tasks", service.getAll(new GenericCriteria()));
        return "task/list";
    }
}
