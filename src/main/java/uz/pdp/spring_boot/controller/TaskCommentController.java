package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.comment.TaskCommentCreateDto;
import uz.pdp.spring_boot.dto.comment.TaskCommentUpdateDto;
import uz.pdp.spring_boot.services.comment.TaskCommentService;


@Controller
@RequestMapping("/comment/*")
public class TaskCommentController extends AbstractController<TaskCommentService> {


    @Autowired
    public TaskCommentController(TaskCommentService service) {
        super(service);
    }


    @RequestMapping(value = "comment/", method = RequestMethod.GET)
    public String commentPage() {
        return "comment/comment";
    }


    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "comment/create";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCommentCreateDto dto) {
        service.create(dto);
        return "comment/create";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("comment", service.get(id));
        return "comment/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("comment", service.get(id));
        return "comment/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskCommentUpdateDto dto) {
        service.update(dto);
        return "redirect:/comment/list";
    }


    @RequestMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("comment", service.get(id));
        return "comment/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("comments", service.getAll(new GenericCriteria()));
        return "comment/list";
    }

}
