package com.yuan.atfu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.atfu.domain.entity.Product;
import com.yuan.atfu.domain.vo.BaseResponse;
import com.yuan.atfu.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description 产品controller
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 产品分页接口
     *
     * @param page
     * @return com.yuan.atfu.domain.vo.BaseResponse
     * @author David Hong
     */
    @GetMapping("/{page}")
    public BaseResponse products(@PathVariable Integer page) {
        IPage<Product> iPage = productService.pageOrderByGmtCreateDesc(page, 10);
        Map<String, Object> ret = new HashMap<>(1);
        ret.put("list", iPage.getRecords());
        ret.put("total", iPage.getTotal());
        ret.put("currentPage", page);
        return BaseResponse.ok(ret);
    }

    /**
     * 产品搜索分页接口
     *
     * @param content
     * @param page
     * @return com.yuan.atfu.domain.vo.BaseResponse
     * @author David Hong
     */
    @GetMapping("/search/{content}/{page}")
    public BaseResponse search(@PathVariable("content")String content, @PathVariable("page")Integer page) {
        log.info("search={}, page={}", content, page);
        IPage<Product> iPage = productService.search(content, page, 10);
        Map<String, Object> ret = new HashMap<>(1);
        ret.put("list", iPage.getRecords());
        ret.put("total", iPage.getTotal());
        ret.put("currentPage", page);
        return BaseResponse.ok(ret);
    }

}
