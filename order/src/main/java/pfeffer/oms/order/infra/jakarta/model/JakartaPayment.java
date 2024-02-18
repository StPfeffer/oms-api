package pfeffer.oms.order.infra.jakarta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class JakartaPayment {

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "amount", precision = 10, scale = 4, nullable = false)
    private BigDecimal amount;

    @Column(name = "tariff", precision = 10, scale = 4, nullable = false)
    private BigDecimal tariff = BigDecimal.ZERO;

    @Column(name = "discount", precision = 10, scale = 4, nullable = false)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(name = "acquirer")
    private String acquirer;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "installments", nullable = false)
    private Integer installments;

    @Column(name = "payment_number")
    private Integer paymentNumber;

    @Column(name = "transaction_number")
    private String transactionNumber;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "payment_date")
    private Date paymentDate;

}
