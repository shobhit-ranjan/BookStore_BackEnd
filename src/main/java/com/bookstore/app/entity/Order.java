package com.bookstore.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.bookstore.app.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Orders") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int OrderId;
    private int totalPrice;
    
    @CreatedDate
    @Temporal(TemporalType.DATE)
	private Date registerDate;
    
    
    @JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@ManyToOne
	@JoinColumn(name="user")
	private UserEntity user;
    
    @JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="order_booklistnew",
    			joinColumns = @JoinColumn(name="book_id", nullable=false),
    			inverseJoinColumns = @JoinColumn(name="booklist_id", nullable=false), 
    			foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), 
    			inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<BookEntity> bookList; 
    
    public Order(OrderDto Dto) {
    	
    }
}
