package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    @Autowired
    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "organizations/", method = RequestMethod.GET)
    public String orgPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }

   /* @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }*/
 /*  @PreAuthorize("hasAnyRole('SUPER_ADMIN')")*/
    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/organizations/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }


    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @RequestMapping(value = "update/", method = RequestMethod.POST)
    public String update(@ModelAttribute OrganizationUpdateDto dto) {
        service.update(dto);
        return "redirect:/organization/organizations/";
    }

    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }
}
