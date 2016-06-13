package com.enremmeta.rtb.groovy.tc

import com.enremmeta.rtb.api.AdImpl

import com.enremmeta.rtb.api.TargetingGeo









class Ad_1818_DemoStrategy extends AdImpl {

	void init() {

		adomain = ["test.com"]
		desc = "Demo Strategy"
		bidAmount = 0
		iurl = "http://creative.us.s3.opendsp.com/creatives/2184/myip300x250_updated.jpg"
                
		tags = [
			new Tag_2184_DemoCreative_1818_DemoStrategy(this)
		]
                
                adVersion=8
                
                
 		clientId="136"
		campaignId="313"
		advertiser="Demo Advertiser"
		advertiserId="236"

		abTesting = true
		abTestingControlShare = 1

 		geos = [
			new TargetingGeo(null,null,null,"us",null)
		]

                
	}
}