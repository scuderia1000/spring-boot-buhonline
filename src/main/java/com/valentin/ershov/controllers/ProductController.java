package com.valentin.ershov.controllers;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.domain.Product;
import com.valentin.ershov.domain.ProductPrice;
import com.valentin.ershov.service.PriceServiceImpl;
import com.valentin.ershov.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Ershov-V-V on 12.01.2017.
 */
@Controller
public class ProductController {
    private ProductServiceImpl productService;
    private PriceServiceImpl priceService;

    @Autowired
    public void setPriceService(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @Autowired
    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("prices", priceService.findAll());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(@RequestParam Integer id, @RequestParam String name, @RequestParam(required=false) Integer priceId,
                              @RequestParam Long value, @RequestParam String action, Model model) {
        Product product;
        Price price;
        ProductPrice productPrice;

        if (id != null) {
            product = productService.getById(id);
        } else {
            product = new Product();
        }
        product.setName(name);
        if (priceId != null) {
            price = priceService.getById(priceId);
        } else {
            price = null;
        }

        if (price != null && !product.hasPrice(price)) {
            productPrice = new ProductPrice(product, price, value, new Date());
            product.getProductPrices().add(productPrice);
        }
        productService.save(product);
        model.addAttribute("product", productService.getById(product.getId()));
        model.addAttribute("prices", priceService.findAll());

        return action.equals("add_price") ? "productform" : "redirect:/product/" + product.getId();

    }

//    @RequestMapping(value = "product", method = RequestMethod.POST, params="action=add_price")
//    public String savePrice(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer priceId,
//                              @RequestParam long value, Model model) {
//
//
//        return "redirect:product/new";
//
//    }
//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer priceId, Model model) {
//        Product product = null;
//        product = id != null ? productService.getProductById(id) : new Product();
//
//        product.setName(name);
//        Price price = priceService.getPriceById(priceId);
//        if (!product.hasPrice(price)) {
//            product.getPrices().add(price);
//        }
//        productService.saveProduct(product);
//        model.addAttribute("product", productService.getProductById(product.getId()));
//        model.addAttribute("prices", priceService.listAllPrices());
//        return "redirect:/product/" + product.getId();
//
//    }
//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(Product product) {
//        productService.saveProduct(product);
//        return "redirect:/product/" + product.getId();
//    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("prices", priceService.findAll());
        return "productform";
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @RequestMapping("product/delete_product_price/{id}/{priceIdToDelete}")
    public String deleteProductPrice(@PathVariable Integer id, @PathVariable Integer priceIdToDelete, Model model) {
        Product product = productService.getById(id);
        product.deleteProductPrice(priceIdToDelete);
        productService.save(product);
        model.addAttribute("product", productService.getById(product.getId()));
        model.addAttribute("prices", priceService.findAll());
        return "productform";
    }

//    @RequestMapping(value = "/product/{id}/prices", method = RequestMethod.POST)
//    public String productAddPrice(@PathVariable Integer id, @RequestParam Integer priceId, Model model) {
//        Price price = priceService.getPriceById(priceId);
//        Product product = productService.getProductById(id);
//        if (product != null) {
//            if (!product.hasPrice(price)) {
//                product.getPrices().add(price);
//            }
//            productService.saveProduct(product);
//            model.addAttribute("product", productService.getProductById(id));
//            model.addAttribute("prices", priceService.listAllPrices());
//            return "redirect:/product/new";
//        }
//        model.addAttribute("products", productService.listAllProducts());
//        return "redirect:/products";
//    }
}
