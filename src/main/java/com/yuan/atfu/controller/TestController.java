package com.yuan.atfu.controller;

import com.yuan.atfu.domain.vo.ProductRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mac
 * @Date: 2019-04-09 01:11
 * @Version: 0.1
 **/
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public Object test(@RequestBody Object req) throws Exception {
        Thread.sleep(6000);
        log.info(req.toString());
        return "helloworld";
    }

    @GetMapping("/table")
    public List<ProductRep> table() {
        List<ProductRep> ret = new ArrayList<>(10);
        ProductRep productRep = null;
        for (int i=0; i<20; i++) {
            productRep = new ProductRep();
            productRep.setBrand("brand"+i);
            productRep.setType("micron");
            productRep.setInventory("12932");
            ret.add(productRep);
        }
        return ret;
    }

}
