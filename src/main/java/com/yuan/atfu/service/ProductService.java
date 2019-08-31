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

    /**
     * 使用mybatis-plus提供的lambda的方式
     *
     * @param pageNum
     * @param pageSize
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    IPage<Product> pageOrderByGmtCreateDesc(Integer pageNum, Integer pageSize);

    /**
     * 使用sql注解的方式
     *
     * @param content
     * @param pageNum
     * @param pageSize
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    IPage<Product> search(String content, Integer pageNum, Integer pageSize);

}
