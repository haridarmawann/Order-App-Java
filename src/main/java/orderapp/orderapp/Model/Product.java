package orderapp.orderapp.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Set;

@Document(collection ="Product")
    public class Product {

        @Id
        private String id;
        @Field("name")
        private String name;
        @Field("description")
        private String description;
        @DBRef
        private Category category;
        @Field("prices")
        private Float prices;
        @Field("qty")
        private int qty;
        @Field("images")
        private String images;
        @CreatedDate
        @Field("created_at")
        private Date createdAt;

        @LastModifiedDate
        @Field("updated_at")
        private Date updatedAt;


//        public Product(String name, String description, Float prices, int qty, String images, Date createdAt, Date updatedAt) {
//            this.name = name;
//            this.description = description;
//            this.prices = prices;
//            this.qty = qty;
//            this.images = images;
//            this.createdAt = createdAt;
//            this.updatedAt = updatedAt;
//        }


        public Product() {
        }

    public Product(String name, String description, Category category, Float prices, int qty, String images) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.prices = prices;
        this.qty = qty;
        this.images = images;
    }

//    public Product(String name, String description, Float prices, int qty, String images) {
//        this.name = name;
//        this.description = description;
//        this.prices = prices;
//        this.qty = qty;
//        this.images = images;
//    }

    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Float getPrices() {
            return prices;
        }

        public void setPrices(Float prices) {
            this.prices = prices;
        }

        public int getQty() {
            return qty;
        }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQty(int qty) {
            this.qty = qty;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
}
