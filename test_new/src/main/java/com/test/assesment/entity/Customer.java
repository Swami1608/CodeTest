package com.test.assesment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(nullable = false, length = 50)
    private String customerName;

    @Column(nullable = true)
    private String customerAddress;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private LocalDateTime joinedDate;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CustomerTransaction> transactionList;


    private Integer rewardPoint;

	public void setJoinedDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}
