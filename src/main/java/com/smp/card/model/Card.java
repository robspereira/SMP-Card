package com.smp.card.model;

import com.smp.card.util.YearMonthAttributeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.YearMonth;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long id;

    @Setter
    @Column(nullable = false, name = "CARD_NUMBER")
    private String cardNumber;

    @Setter
    @Column(nullable = false, name = "SECURITY_NUMBER")
    private String securityNumber;

    @Setter
    @Column(nullable = false, name = "EXPIRATION_DATE")
    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth expirationDate;

    @Setter
    @Column(nullable = false, name = "BALANCE")
    private Double balance;

    @Column(nullable = false, name = "CLIENT_ID")
    private Long clientId;

    @Column(nullable = false, name = "CARD_CLIENT_NAME")
    private String clientName;

    @Column(nullable = false, name = "CARD_CLIENT_DOCUMENT_NUMBER")
    private String clientDocumentNumber;

    @Column(nullable = false, name = "COMPANY_ID")
    private Long companyId;

    @Column(nullable = false, name = "CARD_COMPANY_NAME")
    private String companyName;

}