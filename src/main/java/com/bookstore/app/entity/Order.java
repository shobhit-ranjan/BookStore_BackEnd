package com.bookstore.app.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    
    @CreatedDate
    @Temporal(TemporalType.DATE)
	private Date registerDate;
    
    @JsonFormat(pattern="dd MM yyyy")
    private LocalDate updatedDate;
    
    
    @OneToOne
    private UserEntity userEntity; 
	@OneToMany
	private List<BookEntity> bookList; 
}
