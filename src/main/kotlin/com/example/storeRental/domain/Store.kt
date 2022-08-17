package com.example.storeRental.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate
import javax.persistence.*

@Entity
class Store(

    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StoreTypeID", referencedColumnName = "id")
    var storeType: StoreType,

    @JsonIgnore
    @OneToOne( fetch = FetchType.LAZY, mappedBy = "store", cascade = [CascadeType.ALL], orphanRemoval = true)
    var img: StoreImage? = null,

    @Column(nullable = false)
    var unitPrice:Double,

    @Column(nullable = false, length = 16)
    var floor:String,

    @Column(name = "rentedStatus")
    var rented: Boolean = false,

    @JsonIgnore
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var rentalDetail:MutableList<RentalDetail>? = null,

    var updatedDate:LocalDate? = null
    ):BaseModel()