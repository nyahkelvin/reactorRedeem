/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.redeem.test;

import com.tworope.reactor.redeem.data.RedeemDAO;
import com.tworope.reactor.redeem.dto.RedeemDTO;
import java.util.Date;

/**
 *
 * @author tobah
 */
public class Test {

    public static void main(String[] args) {

        Test test = new Test();

        RedeemDAO redeemDAO = new RedeemDAO();
        redeemDAO.saveRedeem(test.createRedeem());
    }

    public RedeemDTO createRedeem() {

        RedeemDTO redeemDTO = new RedeemDTO();
        
        redeemDTO.setCheckedInTime(new Date());
        
        return redeemDTO;
    }
}
