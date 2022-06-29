package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserDto;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.services.auth.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController extends AbstractController<UserService> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @RequestMapping(value = "/admin/create/{id}", method = RequestMethod.GET)
    public String adminPage(Model model, @PathVariable String id) {
        model.addAttribute("organization", id);
        return "admin/create";
    }

/*
    @RequestMapping(value = "/admin/create/", method = RequestMethod.GET)
    public String sAdmin(Model model) {
        model.addAttribute("authRole");
        return "admin/create";
    }*/


    @RequestMapping(value = "/admin/create/{id}", method = RequestMethod.POST)
    public String create(@ModelAttribute UserCreateDto dto) {
//       dto.setOrganizationId(Long.valueOf(id));
        service.create(dto);
        return "redirect:/organization/organizations/";
    }


    @RequestMapping(value = "/superadmin/create/", method = RequestMethod.POST)
    public String superAdminCreate(@ModelAttribute UserCreateDto dto) {
//       dto.setOrganizationId(Long.valueOf(id));
        dto.setOrganizationId(1L);
        service.create(dto);
        return "redirect:/superAdmin/lists/";
    }

 /*   @RequestMapping(value = "/admin/list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "admin/list";
    }*/

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "/superAdmin/lists/", method = RequestMethod.GET)
    public String superAdminPage(Model model) {
        List<UserDto> all = service.getAll(new GenericCriteria());
        List<UserDto> superAdminList = new ArrayList<>();
        for (UserDto dto : all) {
            if (dto.getRole().getCode().equals("SUPER_ADMIN")) {
                superAdminList.add(dto);
            }
        }
        model.addAttribute("superAdmins", superAdminList);
        return "superAdmin/list";
    }


    @RequestMapping(value = "/superAdmin/detail/{id}/", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("superAdmin", service.get(id));
        return "superAdmin/detail";
    }

    @RequestMapping(value = "/admin/detail/{id}/", method = RequestMethod.GET)
    public String adminDetail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("admin", service.get(id));
        return "admin/detail";
    }

    @RequestMapping(value = "/manager/detail/{id}/", method = RequestMethod.GET)
    public String managerDetail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("manager", service.get(id));
        return "manager/detail";
    }

    @RequestMapping(value = "/member/detail/{id}/", method = RequestMethod.GET)
    public String memberDetail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("member", service.get(id));
        return "member/detail";
    }


    @RequestMapping(value = "/user/create/", method = RequestMethod.POST)
    public String userCreate(@ModelAttribute UserCreateDto dto) {
//       dto.setOrganizationId(Long.valueOf(id));
        AuthUser authUser = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        dto.setOrganizationId(authUser.getOrganization().getId());
        service.create(dto);
        return "redirect:/project/projects/";
    }


    @RequestMapping(value = "/user/member/", method = RequestMethod.GET)
    public String memberPage(Model model) {
        List<UserDto> all = service.getAll(new GenericCriteria());
        List<UserDto> memberList = new ArrayList<>();
        for (UserDto dto : all) {
            if (Objects.nonNull(dto.getRole()) && dto.getRole().getCode().equals("MEMBER") && !dto.getRole().getCode().equals("SUPER_ADMIN")) {
                memberList.add(dto);
            }
        }

        model.addAttribute("members", memberList);
        return "user/memberList";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/user/manager/", method = RequestMethod.GET)
    public String managerPage(Model model) {
        List<UserDto> all = service.getAll(new GenericCriteria());
        List<UserDto> managerList = new ArrayList<>();
        for (UserDto dto : all) {
            if (Objects.nonNull(dto.getRole()) && dto.getRole().getCode().equals("MANAGER")) {
                managerList.add(dto);
            }
        }

        model.addAttribute("managers", managerList);
        return "user/manager";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/user/admin/", method = RequestMethod.GET)
    public String adminPage(Model model) {
        List<UserDto> all = service.getAll(new GenericCriteria());
        List<UserDto> adminList = new ArrayList<>();
        for (UserDto dto : all) {
            if (Objects.nonNull(dto.getRole()) && dto.getRole().getCode().equals("ADMIN")) {
                adminList.add(dto);
            }
        }

        model.addAttribute("admins", adminList);
        return "user/admin";
    }

}

