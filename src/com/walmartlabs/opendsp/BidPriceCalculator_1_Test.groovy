/**
 * 
 */
package com.walmartlabs.opendsp

import com.enremmeta.rtb.api.Ad
import com.enremmeta.rtb.api.BidPriceCalculatorImpl
import com.enremmeta.rtb.api.proto.openrtb.OpenRtbRequest
import com.enremmeta.rtb.api.proto.openrtb.lot49.Lot49ExtRemote
import com.enremmeta.rtb.spi.providers.integral.IntegralInfoReceived

/** 
 * @author Gregory Golberg (<a
 *         href="mailto:grisha@alum.mit.edu">grisha@alum.mit.edu</a>)
 *         <p>
 *         Copyright © <a href="http://www.enremmeta.com">Enremmeta LLC</a>
 *         2015. All Rights Reserved. This code is licensed under <a
 *         href="http://www.gnu.org/licenses/agpl-3.0.html">Alfero GPL 3.0</a>
 *         </p>
 */
class BidPriceCalculator_1 extends BidPriceCalculatorImpl {

    /**
     * @throws Lot49Exception
     */
    public BidPriceCalculator_1()  {
        super();
    }


    public long getBidPrice(Ad ad, OpenRtbRequest req) {
        Lot49ExtRemote extRem = req.getLot49Ext().getLot49ExtRemote();
        IntegralInfoReceived iir = extRem.getIntegralInfoReceived();
        long iirScore = 1;
        if (iir != null) {
            iirScore =  iir.getViewabilityDto().getIviab();
        }
        extRem.userSegments.getUserSegmentsMap();
    }
}
