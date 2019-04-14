package com.yuan.atfu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.atfu.domain.entity.Product;
import com.yuan.atfu.mapper.ProductMapper;
import com.yuan.atfu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> search(String content, Integer page) {
        IPage<Product> queryPage = new Page<>(page, 8);
        IPage<Product> retPage = productMapper.search(queryPage, "%"+content+"%");
        return retPage;
    }
}
