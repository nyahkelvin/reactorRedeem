/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.redeem.data;

import com.orientechnologies.orient.core.id.ORecordId;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;
import com.tinkerpop.frames.modules.javahandler.JavaHandlerModule;
import com.tworope.reactor.redeem.dto.RedeemDTO;
import com.tworope.reactor.redeem.frames.Redeem;
import com.tworope.reactor.redeem.util.ReactiveFrame;

/**
 *
 * @author tobah
 */
public class RedeemDAO {
    
    public boolean saveRedeem(RedeemDTO redeemDTO){
         OrientGraphFactory factory = new ReactiveFrame().getOrientGraphFactory();
        FramedGraph<OrientGraph> framedGraph = null;
        try {

            OrientGraph graph = factory.getTx();
            framedGraph = new FramedGraphFactory(new JavaHandlerModule()).create(graph);

            Redeem redeem = framedGraph.addVertex("class:Redeem", Redeem.class);
            
            redeem.setCheckedInTime(redeemDTO.getCheckedInTime());

            graph.commit();

            System.out.println("Redeem id before save " + redeem.asVertex().getId());
            
            return true;
            
        } catch (Exception e) {
            System.out.println("exception to add Redeem " + e);
        } finally {
            if (framedGraph != null) {
                framedGraph.shutdown();
            }
        }
        return false;

    }

    public RedeemDTO getAllRedeemed() {

        OrientGraphFactory factory = new ReactiveFrame().getOrientGraphFactory();
        FramedGraph<OrientGraph> framedGraph = null;
        RedeemDTO redeemDTO = null;
        
        try {

            OrientGraph graph = factory.getTx();
            framedGraph = new FramedGraphFactory(new JavaHandlerModule()).create(graph);

            ORecordId orid = new ORecordId("#21:1");

            Redeem redeem = framedGraph.getVertex(orid, Redeem.class);

            redeemDTO = saveRedeemDTO(redeem);
            
            System.out.println("Redeem details " + redeemDTO);
            
        } catch (Exception e) {
            System.out.println("exception to retrieve Redeem " + e);
        } finally {
            if (framedGraph != null) {
                framedGraph.shutdown();
            }
        }
        return redeemDTO;
    }

    public static RedeemDTO saveRedeemDTO(Redeem redeem) {

        RedeemDTO redeemDTO = new RedeemDTO();
        
        redeemDTO.setCheckedInTime(redeem.getCheckedInTime());
                
        return redeemDTO;
    }
}
