package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.mappers.CategoryMapper;
import fr.uga.gestioncinema.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CategoryApi;
import org.openapitools.model.CategoryOpenApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;


    @Override
    public ResponseEntity<CategoryOpenApiModel> findOne(Long id) throws Exception {
        return ResponseEntity.ok().body(categoryMapper.toOpenApiModel(categoryService.fetchOne(id)));
    }

}
