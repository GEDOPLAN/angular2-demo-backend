package de.gedoplan.knowhow.angular2cli.model;

import com.fasterxml.jackson.annotation.JsonView;
import de.gedoplan.knowhow.angular2cli.model.dto.JSONViews;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JSONViews.Summary.class)
    private Integer orderID;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(JSONViews.Summary.class)
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(JSONViews.Details.class)
    private Date requiredDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(JSONViews.Details.class)
    private Date shippedDate;

    @JsonView(JSONViews.Summary.class)
    private Double freight;

    @JsonView(JSONViews.Summary.class)
    private String shipName;

    @JsonView(JSONViews.Summary.class)
    private String shipAddress;

    @JsonView(JSONViews.Summary.class)
    private String shipCity;

    @JsonView(JSONViews.Details.class)
    private String shipRegion;

    @JsonView(JSONViews.Summary.class)
    private String shipPostalCode;

    @JsonView(JSONViews.Details.class)
    private String shipCountry;

    @JoinColumn(name = "CustomerID", referencedColumnName = "customerID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(JSONViews.Details.class)
    private Customer customer;

    @JoinColumn(name = "EmployeeID", referencedColumnName = "employeeID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(JSONViews.Details.class)
    private Employee employee;

    @JoinColumn(name = "ShipVia", referencedColumnName = "shipperID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(JSONViews.Details.class)
    private Shipper shipVia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonView(JSONViews.Details.class)
    private Collection<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Integer orderID) {
        this.orderID = orderID;
    }

    public Order(Integer orderID, Date orderDate, double freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public Shipper getShipVia() {
        return shipVia;
    }

    public void setShipVia(Shipper shipVia) {
        this.shipVia = shipVia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.gedoplan.angular.rw.model.Orders[ orderID=" + orderID + " ]";
    }

}
