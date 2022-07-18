package org.example.model;

import javax.persistence.*;

@Table(name ="product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id ;
    @Basic
    @Column(name="product_name")
    private String productname;
    @Basic
    @Column(name="product_create_time")
    private String createtime;
    @Basic
    @Column(name="product_price")
    private float productprice;
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}
    public String getProduct_name(){return productname;}
    public void setProduct_name(String productname){this.productname= productname;}
    public String getCreate_time(){return createtime;}
    public void setCreate_time(String createTime){this.createtime=createTime;}
    public float getProduct_price(){return productprice;}
    public void setProduct_price(float productprice){this.productprice=productprice;}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product_name=").append(productname);
        sb.append(", product_create_time=").append(createtime);
        sb.append(", product_price=").append(productprice);
        sb.append("]");
        return sb.toString();
    }

}
