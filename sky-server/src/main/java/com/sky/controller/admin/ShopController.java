package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    @Resource
    private ShopService shopService;

    /**
     * 设置店铺的营业状态
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result<?> setStatus(@PathVariable Integer status) {
        log.info("设置店铺的营业状态为：{}",status == 1 ? "营业中" : "已打烊");
        shopService.setStatus(status);
        return Result.success();
    }

    /**
     * 获取店铺的营业状态
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus() {
        Integer status = shopService.getStatus();
        log.info("获取到店铺的营业状态为：{}", status == 1 ? "营业中" : "已打烊");
        return Result.success(status);
    }
}
