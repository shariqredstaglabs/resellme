package com.resellme.resellme.service.impl;

import com.resellme.resellme.entity.Catalog;
import com.resellme.resellme.entity.Product;
import com.resellme.resellme.repository.CatalogRepository;
import com.resellme.resellme.repository.ProductRepository;
import com.resellme.resellme.service.CatalogService;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    Logger logger = LoggerFactory.getLogger(CatalogService.class);
    private final CatalogRepository catalogRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository, ProductRepository productRepository) {
        this.catalogRepository = catalogRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Catalog> getByBrandId(String brandId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return catalogRepository.findByBrandId(brandId,pageable);
    }

    @Override
    public HashMap<String, String> addWithImage(List<MultipartFile> files, Catalog catalogModel) {
        HashMap<String,String> result = new HashMap<>();
        try {
            Catalog catalog = catalogRepository.save(catalogModel);
            result.put("id", catalog.getId());
            result.put("status", "success");
            result.put("message", "catalog saved to DB");
            ImageUpload imageUpload = new ImageUpload(files, catalog.getProducts(), productRepository);
            imageUpload.start();
        }catch (Exception e){
            result.put("status", "failed");
            result.put("message", e.getMessage());
            logger.info(e.getMessage());
        }
        return result;
    }
    private  static  void saveImages(List<MultipartFile> files, Catalog catalog){

    }
}
class  ImageUpload extends Thread {
    Logger logger = LoggerFactory.getLogger(ImageUpload.class);
    private List<MultipartFile> files;
    private List<Product> products;
    private ProductRepository productRepository;


    public ImageUpload(List<MultipartFile> files, List<Product> products, ProductRepository productRepository) {
        this.files = files;
        this.productRepository = productRepository;
        this.products = products;
    }

    @Override
    public void run() {
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            Product product = products.get(i);
            String destination = "/images/";
            try {
                File folder = new File(destination + product.getId());
                folder.mkdir();
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folder.getCanonicalPath() + "/" + file.getOriginalFilename());
                Files.write(path, bytes);
                logger.info("Image Saved " + file.getOriginalFilename());

                File thumbnailFolder = new File(destination + product.getId()+"/thumbnail");
                thumbnailFolder.mkdir();
                Thumbnails.of(thumbnailFolder.getParentFile()+"/"+file.getOriginalFilename())
                                .size(100,100).toFile(thumbnailFolder.getCanonicalPath()+"/"+ file.getOriginalFilename());
                product.setImage(thumbnailFolder.getCanonicalPath()+ file.getOriginalFilename());
            } catch (IOException e) {
                logger.info(e.getMessage());
            }
        }
        productRepository.saveAll(products);
    }


}
