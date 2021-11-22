package com.example.accessingdatamysql;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sun.management.AgentConfigurationError;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static org.yaml.snakeyaml.nodes.NodeId.sequence;

@Entity // This tells Hibernate to make a table out of this class
public class Department {
   @Id
   @GeneratedValue(generator = "sequence-generator")
   @GenericGenerator(
           name = "sequence-generator",
           strategy =  "org.hibernate.id.enhanced.SequenceStyleGenerator",
           parameters = {
                   @Parameter(name = "sequence_name", value = "user_sequence"),
                   @Parameter(name = "initial_value", value = "1"),
                   @Parameter(name = "increment_size", value = "100")
           }
   )
    private Integer id;
    private String name;
    private String depHead;


    public Integer getId() {
        return id;
    }
   public void setId(Integer id) {
       this.id = id;
   }

   public String getName(){
        return this.name;
   }

   public void  setName(String name){
        this.name = name;
    }

    public String getDepHead(){
        return this.depHead;
    }

    public void setDepHead(String depHead){
        this.depHead = depHead;
    }
}
