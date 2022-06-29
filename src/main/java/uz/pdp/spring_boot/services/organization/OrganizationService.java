package uz.pdp.spring_boot.services.organization;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationDto;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface OrganizationService extends GenericCrudService<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {


}
