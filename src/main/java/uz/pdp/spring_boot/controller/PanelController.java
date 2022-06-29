package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.services.auth.UserService;
import uz.pdp.spring_boot.services.organization.OrganizationService;
import uz.pdp.spring_boot.services.project.ProjectService;


@Controller
@RequestMapping("/panel/*")
public class PanelController extends AbstractController<ProjectService> {


    public PanelController(ProjectService service) {
        super(service);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "superAdmin/", method = RequestMethod.GET)
    public String orgPage(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "panel/superAdmin";
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String projectPage(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "panel/admin";
    }

//    @RequestMapping(value = "superAdmin/", method = RequestMethod.GET)
//    public String ProfilePage(Model model) {
//        model.addAttribute("users", service.getAll(new GenericCriteria()));
//        return "panel/superAdmin";
//    }
}
