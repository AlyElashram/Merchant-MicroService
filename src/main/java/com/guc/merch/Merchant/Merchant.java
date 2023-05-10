package com.guc.merch.Merchant;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Merchant")
public class Merchant {
    @Id
    private String id;

    private String name;
    private String email;

    private List<String> postingIDs;

    public Merchant(String id,String name,String email,List<String> postingIDs){
        this.id=id;
        this.name=name;
        this.email=email;
        this.postingIDs = postingIDs;
    }



}
