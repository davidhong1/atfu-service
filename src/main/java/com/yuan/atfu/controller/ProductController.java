package com.yuan.atfu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.atfu.domain.entity.Product;
import com.yuan.atfu.domain.vo.BRB;
import com.yuan.atfu.domain.vo.BRStatus;
import com.yuan.atfu.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // TODO David 多条件查询处理
    @GetMapping("/{page}")
    public BRB products(@PathVariable Integer page) {
        IPage<Product> iPage = productService.page(new Page<>(page, 8), new QueryWrapper<Product>().orderByDesc("gmt_create"));
        List<Product> list = iPage.getRecords();
        Map<String, Object> ret = new HashMap<>();
        ret.put("list", list);
        ret.put("total", iPage.getTotal());
        ret.put("currentPage", page);
        return new BRB(BRStatus.SUCCESS, ret);
    }

    @GetMapping("/search/{content}/{page}")
    public BRB search(@PathVariable("content")String content, @PathVariable("page")Integer page) {
        log.info("search={}, page={}", content, page);
        IPage<Product> iPage = productService.search(content, page);
        List<Product> list = iPage.getRecords();
        Map<String, Object> ret = new HashMap<>();
        ret.put("list", list);
        ret.put("total", iPage.getTotal());
        ret.put("currentPage", page);
        return new BRB(BRStatus.SUCCESS, ret);
    }

}
