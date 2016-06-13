
package com.walmartlabs.opendsp

import groovy.transform.InheritConstructors

import com.enremmeta.rtb.api.FixedDimension
import com.enremmeta.rtb.api.MarkupType
import com.enremmeta.rtb.api.TagImpl
import com.enremmeta.rtb.api.proto.openrtb.Bid
import com.enremmeta.rtb.api.proto.openrtb.Impression
import com.enremmeta.rtb.api.proto.openrtb.OpenRtbRequest
import com.enremmeta.rtb.api.proto.openrtb.Site;
import com.enremmeta.rtb.constants.Macros
import com.enremmeta.rtb.proto.ExchangeAdapter


@InheritConstructors
public class Tag_2184_DemoCreative_1818_DemoStrategy extends TagImpl {
	private String myTagId

	@Override
	public void init() {
                tagVersion=9
		markupType = MarkupType.THIRD_PARTY_FLASH 
		video = false
		banner = true

		int width = 300
		int height = 250
		dim =  new FixedDimension(width, height);
	}

	//@Override
	//@Override
	public String getClickRedir(final OpenRtbRequest req, final Bid bid) {
		String brId = req.getId()
		String bId = bid.getId();
		String iId = bid.getImpid()
                String proto = getProto(req)
		final ExchangeAdapter adapter = req.getLot49Ext().getAdapter();
		final String exchange = adapter.getName();
		final String ssp = adapter.isAggregator() ? req.getLot49Ext().getSsp()
				: exchange;

		String clickRedir= proto + "://s.opendsp.com/man/click/?cid=" + adId +
				"&crid=" + id +
				"&iid=" + iId +
				"&bid=" + bId +
				"&brid=" + brId +
				"&comment=GGTEST"+
				"&xch=" + exchange +
				"&ssp=" +ssp +
				"&r=";
		return clickRedir;
	}

	public String getTagTemplate(OpenRtbRequest req, Impression imp, Bid bid) {
		ExchangeAdapter adapter = req.getLot49Ext().getAdapter();
		String exchange = adapter.getName();
		String ssp = adapter.isAggregator() ? req.getLot49Ext().getSsp()
				: exchange;


		String brId = req.getId()
		String bId = bid.getId();
		String iId = imp.getId();
                String proto = getProto(req)
                
		int width = 300
		int height = 250

		Random random = new Random() ;
		int randomNumber = random.nextInt(900000000) + 100000000;
		String randomValue = String.valueOf(randomNumber);
		
 		
		Site site = req.getSite();
		String domain = site.getDomain(); //domain
		String site_page = site.getPage();
		String site_page_enc = (site_page != null) ? URLEncoder.encode(site_page) : 'null'; //site page enc
		
		String uId = req.getLot49Ext().getModUid() //user ID
		
		//winning price
		String winningPrice= adapter.getWinningPriceMacro(); //winning price
		
		String campaignId = "313" ;
		String advertiserId="236" ;
        
        
		String tagTemplate = """
 <!--/*
*
* OpenDSP Adserver Javascript Tag
*
*/-->
<!--/*
  * The backup image section of this tag has been generated for use on a
  * non-SSL page. If this tag is to be placed on an SSL page, change the
  *   'http://ads.opendsp.com/service/...'
  * to
  *   'https://ads.opendsp.com/service/...'
  *
  * This noscript section of this tag only shows image banners. There
  * is no width or height in these banners, so if you want these tags to
  * allocate space for the ad before it shows, you will need to add this
  * information to the <img> tag.
  *
  * If you do not want to deal with the intricities of the noscript
  * section, delete the tag (from <noscript>... to </noscript>). On
  * average, the noscript tag is called from less than 1% of internet
  * users.
*/-->
<script type='text/javascript'><!--//<![CDATA[
	var m3_3rdPclickEncoded = \"\";
    var m3_u = (location.protocol=='https:'?'https://ads.opendsp.com/service/adserviceV.php':'http://ads.opendsp.com/service/adserviceV.php');
    var m3_r = Math.floor(Math.random()*99999999999);
    if (!document.MAX_used) document.MAX_used = ',';
    document.write (\"<scr\"+\"ipt type='text/javascript' src='\"+m3_u);
    document.write (\"?cb=\" + m3_r);
	document.write ("&amp;loc=js");
	document.write ("&amp;tagID=OpenDSP");  
	document.write ("&amp;click="+m3_3rdPclickEncoded);  // optional. the 3rd party click tracking URL - encoded
        document.write (\"&amp;clickb=$Macros.MACRO_LOT49_CLICK_CHAIN_ENC\");

    document.write ("&amp;cid=$adId");
    document.write ("&amp;crid=$id");
    document.write ("&amp;domain=$domain");
    document.write ("&amp;site_ref=$site_page_enc");
    document.write ("&amp;exchange=$exchange");

    
    if (document.MAX_used != ',') document.write (\"&amp;exclude=\" + document.MAX_used);
    document.write (document.charset ? '&amp;charset='+document.charset : (document.characterSet ? '&amp;charset='+document.characterSet : ''));
    document.write (\"&amp;locUrl=\" + escape(window.location));
    if (document.referrer) document.write (\"&amp;referer=\" + escape(document.referrer));
    if (document.context) document.write (\"&context=\" + escape(document.context));
    if (document.mmm_fo) document.write (\"&amp;mmm_fo=1\");
    document.write (\"'><\\/scr\"+\"ipt>\");
//]]>--></script>

<img src=\"$proto://s.opendsp.com/man/impression/?iid=$iId&cid=$adId&crid=$id&bid=$bId&brId=$brId&comment=GGTEST&xch=$exchange&ssp=$ssp\" width=\"0\" height=\"0\"></img>
<img src=\"$Macros.MACRO_LOT49_IMPRESSION\" width=\"0\" height=\"0\"></img>





"""
		return tagTemplate
	}
}