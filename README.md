# atfu SpringBoot后台项目
[配套前端项目](https://github.com/HYUANT/atfu-web)

> 本项目主要演示：

1. SpringBoot项目入门

2. SpringBoot发送邮件

3. SpringBoot集成mybatis-plus

--------

## 准备数据库，执行以下MySQL脚本
```
mysql -uroot -p < ./sql/atfu.sql
```
修改application-dev.properties中你的MySQL密码
```properties
# 你的MySQL密码
spring.datasource.password=
```

## 设置application.properties中的你的QQ邮箱和授权码
```properties
# 你的邮箱
spring.mail.username=1751632917@qq.com
# 你的QQ邮箱授权码，获取方式 https://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256
spring.mail.password=
```
[获取QQ邮箱授权码方式](https://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256)

## 从idea导入项目，依赖下载完成后运行

## 下载前端项目并运行
[前端项目链接](https://github.com/HYUANT/atfu-web)

## 两个接口
### 产品数据接口，展示mybatis-plus的使用 [mybatis-plus官网](https://mp.baomidou.com/)
```java
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
```
mybatis-plus lambda方式拼接MySQL
```java
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
```
mybatis-plus mapper注解方式使用MySQL
```java
    /**
     * MySQL like 查询
     *
     * @param page
     * @param content
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    @Select("select * from product where no like #{content} or type like #{content} or brand like #{content} or package_type like #{content} order by gmt_create desc")
    IPage<Product> search(IPage<Product> page, String content);
```
![产品展示页面](https://github.com/HYUANT/atfu-web/tree/master/doc/products.png)

### 询问下单接口，发送邮件，展示SpringBootMail的使用
```java
/**
 * @author David Hong
 * @version 1.0
 * @description 询问下单controller
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/intention")
public class IntentionController {

    @Autowired
    private IntentionService intentionService;

    @PostMapping
    public BaseResponse post(@RequestBody IntentionForm reqIntention) {
        log.info(reqIntention.toString());
        Intention intention = new Intention();
        BeanUtils.copyProperties(reqIntention, intention);
        // 插入 咨询意向 记录
        intention.insert();
        // 发送邮件
        intentionService.sendEmail(intention);
        return BaseResponse.ok("我们已收到询价下单请求，我们会尽快联系您!");
    }

}
```
![询问下单发送邮件页面](https://github.com/HYUANT/atfu-web/tree/master/doc/contact.png)

