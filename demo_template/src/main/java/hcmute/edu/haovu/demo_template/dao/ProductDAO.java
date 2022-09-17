package hcmute.edu.haovu.demo_template.dao;

import hcmute.edu.haovu.demo_template.entities.ProductEntity;
import hcmute.edu.haovu.demo_template.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
  private Connection conn = null;
  private PreparedStatement ps = null;
  protected ResultSet rs = null;

  public List<ProductEntity> getAllProduct() {
    List<ProductEntity> products = new ArrayList<>();
    String sql = "SELECT * FROM product ";
    try {
      conn = ConnectionUtil.getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        ProductEntity product = new ProductEntity();

        product.setId(rs.getLong("id"));
        product.setTitle(rs.getString("title"));
        product.setPrice(rs.getLong("price"));
        product.setSize(rs.getString("size"));
        product.setColor(rs.getString("color"));
        product.setDescription(rs.getString("description"));
        product.setImage(rs.getString("image"));

        products.add(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return products;
  }

  public static void main(String[] args) {
    ProductDAO productDAO = new ProductDAO();
    List<ProductEntity> products = productDAO.getAllProduct();
    for (ProductEntity product : products) {
      System.out.println(product);
    }
  }
}
