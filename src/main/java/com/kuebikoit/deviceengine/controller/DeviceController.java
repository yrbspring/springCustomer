package com.kuebikoit.deviceengine.controller;

import com.kuebikoit.deviceengine.persistence.model.Device;
import com.kuebikoit.deviceengine.persistence.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@Slf4j
public class DeviceController {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceController(DeviceRepository deviceRepository) {
        log.debug("********Service constructor invoked by Spring******");
        this.deviceRepository = deviceRepository;
    }

    @PostMapping("devices")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void load(@RequestBody Device device) {
        log.info("Post endpoint invoked");

        deviceRepository.save(device);
    }

    @GetMapping("devices")
    public List<Device> getDevices() {
        log.info("Get endpoint invoked");

        return (List<Device>) deviceRepository.findAll();
    }

}
