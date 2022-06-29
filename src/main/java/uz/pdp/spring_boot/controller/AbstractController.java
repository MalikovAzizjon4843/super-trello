package uz.pdp.spring_boot.controller;

import uz.pdp.spring_boot.services.BaseService;

public abstract class AbstractController<S extends BaseService> {
    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
