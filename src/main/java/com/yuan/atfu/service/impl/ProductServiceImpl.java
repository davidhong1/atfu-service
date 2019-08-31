package com.yuan.atfu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.atfu.domain.entity.Product;
import com.yuan.atfu.mapper.ProductMapper;
import com.yuan.atfu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    /**
     * 使用mybatis-plus提供的lambda的方式
     *
     * @param pageNum
     * @param pageSize
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    @Override
    public IPage<Product> pageOrderByGmtCreateDesc(Integer pageNum, Integer pageSize) {
        return lambdaQuery()
                .orderByDesc(Product::getGmtCreate)
                .page(new Page<>(pageNum, pageSize));
    }

    /**
     * 使用sql注解的方式
     *
     * @param content
     * @param pageNum
     * @param pageSize
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    @Override
    public IPage<Product> search(String content, Integer pageNum, Integer pageSize) {
        IPage<Product> queryPage = new Page<>(pageNum, pageSize);
        IPage<Product> retPage = this.getBaseMapper().search(queryPage, "%"+content+"%");
        return retPage;
    }

}
