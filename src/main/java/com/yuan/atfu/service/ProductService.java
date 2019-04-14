package com.yuan.atfu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.atfu.domain.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
public interface ProductService extends IService<Product> {

    IPage<Product> search(String content, Integer page);

}
