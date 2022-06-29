package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.services.project.ProjectService;
import uz.pdp.spring_boot.services.task.TaskService;


@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    protected final TaskService taskService;

    @Autowired
    public ProjectController(ProjectService service, TaskService taskService) {
        super(service);
        this.taskService = taskService;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "projects/", method = RequestMethod.GET)
    public String projectPage(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "project/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "project/create";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto dto) {
        service.create(dto);
        return "redirect:/project/projects/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/project/projects/";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("project", service.get(id));
        return "project/update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute ProjectUpdateDto dto) {
        service.update(dto);
        return "redirect:/project/list/";
    }


    @RequestMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        model.addAttribute("tasks", taskService.getAll(new GenericCriteria()));
        return "project/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "project/list";
    }
}
