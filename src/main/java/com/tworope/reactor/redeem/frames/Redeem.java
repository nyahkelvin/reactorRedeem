/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tworope.reactor.redeem.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import java.util.Date;

/**
 *
 * @author tobah
 */
public interface Redeem extends VertexFrame{
    
    @Property("checkedIn_time")
    public Date getCheckedInTime();
    
    @Property("checkedIn_time")
    public void setCheckedInTime(Date checkedInTime);
}
