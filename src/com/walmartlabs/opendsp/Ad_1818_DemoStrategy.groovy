package com.walmartlabs.opendsp

import com.enremmeta.rtb.api.AdImpl

import com.enremmeta.rtb.api.TargetingGeo









class Ad_1818_DemoStrategy extends AdImpl {

	void init() {

		adomain = ["test.com"]
		desc = "Demo Strategy"
		iurl = "http://creative.us.s3.opendsp.com/creatives/2184/myip300x250_updated.jpg"
                
                bidAmount = 0
                bidPriceCalculator = new BidPriceCalculator_1();
                
		tags = [
			new Tag_2184_DemoCreative_1818_DemoStrategy(this)
		]
                
                adVersion=16
                
                
 		clientId="136"
		campaignId="313"
		advertiser="Demo Advertiser"
		advertiserId="236"

		abTesting = true
		abTestingControlShare = 0.2

 		geos = [
			new TargetingGeo(null,null,null,"us",null)
		]

 		targetingSegments="OR(\"386:fp:236\",\"387:fp:236\")"

                
	}
}