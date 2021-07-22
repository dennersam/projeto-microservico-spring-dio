package one.digitalinnovation.experts.productproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "product", type="catalog")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer amount;

}
