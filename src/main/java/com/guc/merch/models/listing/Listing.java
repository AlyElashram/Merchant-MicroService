package com.guc.merch.models.listing;

import com.guc.merch.controllers.ListingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Document(collection = "listings")
public class Listing {
    @Id
    private String id;
    private double price;
    private String title;
    private String description;
    private List<String> category;
    private String city;
    private ListingStatus status;
    private String sellerUID;

    public String getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (String) id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = (double) price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = (String) title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = (String) description;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = (List<String>) category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ListingStatus getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = (ListingStatus) status;
    }

    public String getSellerUID() {
        return sellerUID;
    }

    public void setSellerUID(Object sellerUID) {
        this.sellerUID = (String) sellerUID;
    }

    public void setField(String methodName, Object value) {
        try {
            // Get the method with the specified name
            Method method = this.getClass().getDeclaredMethod(methodName, Object.class);
            // Invoke the method
            method.invoke(this, value);
        } catch (NoSuchMethodException e) {
            System.out.println("Invalid input: " + methodName);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error calling method: " + methodName);
        }
    }


}
