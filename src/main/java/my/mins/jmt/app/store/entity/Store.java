package my.mins.jmt.app.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Store {

    @Id
    @GeneratedValue
    private Long id;


}
