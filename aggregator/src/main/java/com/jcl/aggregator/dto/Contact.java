/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JCLog
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Contact {

    @NotEmpty(message = "You must supply a value for Name.")
    @Length(max = 150, message = "Name must be no more than 150 characters in length.")
    private String name;
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 150, message = "Title must be no more than 150 characters in length.")
    private String title;
    @NotEmpty(message = "You must supply a value for Phone Number.")
    @Length(max = 15, message = "Phone Number must be no more than 15 characters in length.")
    private String phoneNumber;
    @NotEmpty(message = "You must supply a value for Web Address.")
    @Length(max = 250, message = "Web Address must be no more than 150 characters in length.")
    private String webAddress;
    
    public Contact(String name) {
        this.name = name;
    }
    
}
