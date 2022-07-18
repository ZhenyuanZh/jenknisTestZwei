package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.api.CommonPage;
import org.example.common.api.CommonResult;
import org.example.common.utils.DateUtil;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Api(tags = "product", description = "test")
@RequestMapping("/product")
@Controller
public class ProductController {
    @Resource(name = "productService")
    private ProductService productService;
    @ApiOperation(value = "")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult<Product> create(@RequestBody Product product) throws UnsupportedEncodingException {
        String name = URLDecoder.decode(product.getProduct_name(), "utf-8");
        Product checkProduct= productService.getProductByProduct_name(name);
        if(checkProduct !=null){
            return CommonResult.failed("exist");
        }
        product.setProduct_name(product.getProduct_name());
        product.setProduct_price(product.getProduct_price());
        product.setCreate_time(DateUtil.getLocalTime());
        productService.saveProduct(product);
        return CommonResult.success(product);
    }
    @ApiOperation("")
    @PostMapping("/listAll")
    @ResponseBody
    @PreAuthorize("hasAuthority('2')")
    public CommonResult<CommonPage<Product>> listAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Product> productList = productService.listAllProduct(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(productList));
    }
    @ApiOperation("")
    @RequestMapping(value = "/listOne", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<Product> listOne(@RequestParam(value = "product_name", defaultValue = "string") String product_name) {
        Product serchProduct= productService.getProductByProduct_name(product_name);
        return CommonResult.success(serchProduct);
    }
    @ApiOperation("")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult delete(@RequestParam(value = "product_name", defaultValue = "string") String product_name) {
        productService.deleteProductByName(product_name);
        return CommonResult.success("success");
    }
    @ApiOperation("")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Product> update(@RequestBody Product product, BindingResult result) throws UnsupportedEncodingException {
        String name = URLDecoder.decode(product.getProduct_name(), "utf-8");
        Product checkProduct= productService.getProductByProduct_name(name);
        if(checkProduct ==null){
            return CommonResult.failed("exist");
        }
        productService.updatePrice(product.getId(),product.getProduct_price());
        return CommonResult.success(product);
    }
}


