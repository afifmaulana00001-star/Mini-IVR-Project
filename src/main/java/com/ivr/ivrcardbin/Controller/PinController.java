package com.ivr.ivrcardbin.Controller;

import com.ivr.ivrcardbin.Service.PinService;
import com.ivr.ivrcardbin.dto.PinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ivr")
public class PinController {

    @Autowired
    private PinService pinService;

    @PostMapping("/verifypin")
    public String verifyPin(@RequestBody PinRequest request){

      return pinService.verifyPin(request.getPin());

    }

}