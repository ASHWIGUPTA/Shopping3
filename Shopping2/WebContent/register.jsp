<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.shoppingWeb.POJO.ProductDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Mirrored from p.w3layouts.com/demos/shopin/web/register.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 18 Apr 2017 19:28:29 GMT -->
<head>
<title>Shopin A Ecommerce Category Flat Bootstrap Responsive Website Template | Register :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
	<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>
<!---//End-rate---->
</head>
<body>
	<%! HashSet list=null;
public void jspInit(){
	System.out.print("****************");
	 list=new HashSet();

	}
	
	%>	
	
	<%session.setAttribute("userId",session.getAttribute("userId"));
	session.setAttribute("productNo",session.getAttribute("productNo"));
	
	if(session.getAttribute("ProductNo")!=null){   //session
		 list=(HashSet)session.getAttribute("ProductNo");
		Iterator it=list.iterator();
			
			while(it.hasNext()){
				System.out.println("index pid1111111 "+it.next());
			}
		
		 
		       session.setAttribute("ProductNo",list);
		 }
		  if( session.getAttribute("UserId")==null){
			  
		  }
		   
	 else{                                                           //Login Attribute Added
		        	  int userID=(Integer)session.getAttribute("UserId");
		        		session.setAttribute("UserId", userID);
		        		        		
		        }
 %>

<script src='../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script><script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../../www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-30027142-1', 'w3layouts.com');
  ga('send', 'pageview');
</script>


<script async type='text/javascript' src='../../../../cdn.fancybar.net/ac/fancybar6a2f.js?zoneid=1502&amp;serve=C6ADVKE&amp;placement=w3layouts' id='_fancybar_js'></script>
<style type='text/css'>  .adsense_fixed{position:fixed;bottom:-8px;width:100%;z-index:999999999999;}.adsense_content{width:720px;margin:0 auto;position:relative;background:#fff;}.adsense_btn_close,.adsense_btn_info{font-size:12px;color:#fff;height:20px;width:20px;vertical-align:middle;text-align:center;background:#000;top:4px;left:4px;position:absolute;z-index:99999999;font-family:Georgia;cursor:pointer;line-height:18px}.adsense_btn_info{left:26px;font-family:Georgia;font-style:italic}.adsense_info_content{display:none;width:260px;height:340px;position:absolute;top:-360px;background:rgba(255,255,255,.9);font-size:14px;padding:20px;font-family:Arial;border-radius:4px;-webkit-box-shadow:0 1px 26px -2px rgba(0,0,0,.3);-moz-box-shadow:0 1px 26px -2px rgba(0,0,0,.3);box-shadow:0 1px 26px -2px rgba(0,0,0,.3)}.adsense_info_content:after{content:'';position:absolute;left:25px;top:100%;width:0;height:0;border-left:10px solid transparent;border-right:10px solid transparent;border-top:10px solid #fff;clear:both}.adsense_info_content #adsense_h3{color:#000;margin:0;font-size:18px!important;font-family:'Arial'!important;margin-bottom:20px!important;}.adsense_info_content .adsense_p{color:#888;font-size:13px!important;line-height:20px;font-family:'Arial'!important;margin-bottom:20px!important;}.adsense_fh5co-team{color:#000;font-style:italic;}</style>
<script>

    $(function() {
      $('.adsense_btn_close').click(function() {
        $(this).closest('.adsense_fixed').css('display', 'none');
      });

      $('.adsense_btn_info').click(function() {
        if ($('.adsense_info_content').is(':visible')) {
          $('.adsense_info_content').css('display', 'none');
        } else {
          $('.adsense_info_content').css('display', 'block');
        }
      });

    });

  </script>
<body>

<div class='adsense_fixed'>
<div class='adsense_content'> <span class='adsense_btn_close' title='Hide Ads'>x</span>
  <div class='adsense_info_content'>
    <h3 id='adsense_h3'>Why Ads?</h3>
    <p class='adsense_p'>We hope you'll understand us why we display Ads here at w3layouts. We use Ads in order for us to continue working and provide you new template every day. As we all know domain, hosting servers and designers is not free and
      for us to pay it we have to display Ads. Thank you for Supporting Us.</p>
    <p class='adsense_p'>Love,
      <br><span class='adsense_fh5co-team'>w3layouts Team</span></p>
  </div><span class='adsense_btn_info' title='Why Ads'>i</span>

<script async src='../../../../pagead2.googlesyndication.com/pagead/js/f.txt'></script>
<!-- ResponsiveW3layouts -->

<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>

<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>

  </div>
  </div>

<!--header-->
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="index.jsp"><img src="images/logo.png" alt=""></a>	
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container">
		<div class="col-sm-5 col-md-offset-2  header-login">
					<ul >
						<li><a href="login.jsp">Login</a></li>
						<li><a href="register.jsp">Register</a></li>
						<li><a href="CartProduct">Checkout</a></li>
					</ul>
				</div>
				
			<div class="col-sm-5 header-social">		
					<ul >
						<li><a href="#"><i></i></a></li>
						<li><a href="#"><i class="ic1"></i></a></li>
						<li><a href="#"><i class="ic2"></i></a></li>
						<li><a href="#"><i class="ic3"></i></a></li>
						<li><a href="#"><i class="ic4"></i></a></li>
					</ul>
					
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		
		<div class="container">
		
			<div class="head-top">
			
		 <div class="col-sm-8 col-md-offset-2 h_menu4">
				<nav class="navbar nav_bottom" role="navigation">
 
 <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header nav_2">
      <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     
   </div> 
   <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
        <ul class="nav navbar-nav nav_1">
            <li><a class="color" href="index.jsp">Home</a></li>
            
    		<li class="dropdown mega-dropdown active">
			    <a class="color1" href="#" class="dropdown-toggle" data-toggle="dropdown">Women<span class="caret"></span></a>				
				<div class="dropdown-menu ">
                    <div class="menu-top">
						<div class="col1">
							<div class="h_nav">
								
								<ul>
										<li><a href="MenuController?menu=women_coat">Coats</a></li>
										<li><a href="MenuController?menu=women_jeans">Jeans</a></li>
										<li><a href="MenuController?menu=women_jewellery">Jewellery</a></li>
										<li><a href="MenuController?menu=women_cardigans">Jumpers & Cardigans</a></li>
										<li><a href="MenuController?menu=women_jackets">Leather Jackets</a></li>
										<li><a href="MenuController?menu=women_t-shirtlong">Long Sleeve T-Shirts</a></li>
									</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								
									<ul>
										<li><a href="MenuController?menu=women_shirt">Shirts</a></li>
										<li><a href="MenuController?menu=women_shoes">Shoes, Boots & Trainers</a></li>
										<li><a href="MenuController?menu=women_sunglasses">Sunglasses</a></li>
										<li><a href="MenuController?menu=women_sweatpants">Sweatpants</a></li>
										<li><a href="MenuController?menu=women_swimwear">Swimwear</a></li>
										<li><a href="MenuController?menu=women_trousers">Trousers & Chinos</a></li>
										
									</ul>	
								
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<ul>
									<li><a href="MenuController?menu=women_t-shirt">T-Shirts</a></li>
									<li><a href="MenuController?menu=women_underwear">Underwear</a></li>
									<li><a href="MenuController?menu=women_vests">Vests</a></li>
									<li><a href="MenuController?menu=women_socks">Socks</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1 col5">
						<img src="images/me.png" class="img-responsive" alt="">
						</div>
						<div class="clearfix"></div>
					</div>                  
				</div>				
			</li>
			<li class="dropdown mega-dropdown active">
			    <a class="color2" href="#" class="dropdown-toggle" data-toggle="dropdown">Men<span class="caret"></span></a>				
				<div class="dropdown-menu mega-dropdown-menu">
                    <div class="menu-top">
						
						<div class="col1">
							<div class="h_nav">
								<ul>
										<li><a href="MenuController?menu=men_coats">Jackets & Coats</a></li>
										<li><a href="MenuController?menu=men_jeans">Jeans</a></li>
										<li><a href="MenuController?menu=men_jewellery">Jewellery</a></li>
										<li><a href="MenuController?menu=men_jumpers">Jumpers</a></li>
										<li><a href="MenuController?menu=men_jackets">Leather Jackets</a></li>
										<li><a href="MenuController?menu=men_t-shirtlong">Long Sleeve T-Shirts</a></li>
									</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								
								
<ul>
										<li><a href="MenuController?menu=men_shirts">Shirts</a></li>
										<li><a href="MenuController?menu=men_shoes">Shoes, Boots & Trainers</a></li>
										<li><a href="MenuController?menu=men_sunglasses">Sunglasses</a></li>
										<li><a href="MenuController?menu=men_sweatpants">Sweatpants</a></li>
										<li><a href="MenuController?menu=men_swimwear">Swimwear</a></li>
										<li><a href="MenuController?menu=men_trousers">Trousers & Chinos</a></li>
										
									</ul>	
								
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								
								<ul>
									<li><a href="MenuController?menu=men_t-shirt">T-Shirts</a></li>
									<li><a href="MenuController?menu=men_underwear">Underwear</a></li>
									<li><a href="MenuController?menu=men_socks">Vests</a></li>
									<li><a href="MenuController?menu=men_socks">Socks</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1 col5">
						<img src="images/me1.png" class="img-responsive" alt="">
						</div>
						<div class="clearfix"></div>
					</div>                  
				</div>				
			</li>
			<li><a class="color3" href="product.html">Sale</a></li>
			
            <li ><a class="color6" href="contact.html">Contact</a></li>
        </ul>
     </div><!-- /.navbar-collapse -->

</nav>
			</div>
			<div class="col-sm-2 search-right">
				<ul class="heart">
				<li>
				<a href="wishlist.html" >
				<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
				</a></li>
				<li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i></a></li>
					</ul>
					<div class="cart box_1">
						<a href="CartProduct">
						<h3> 
							<img src="images/cart.png" alt=""/></h3>
						</a>
						  

					</div>
					<div class="clearfix"> </div>
					
						<!----->

						<!---pop-up-box---->					  
			<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
			<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!---//pop-up-box---->
			<div id="small-dialog" class="mfp-hide">
				<div class="login-search">
					<div class="login">
						<input type="submit" value="">
						<input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}">		
					</div>
					<p>Shopin</p>
				</div>				
			</div>
		 <script>
			$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
			});
																						
			});
		</script>		
						<!----->
			</div>
			<div class="clearfix"></div>
		</div>	
	</div>	
</div>
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>Register</h1>
		<em></em>
		<h2><a href="index.jsp">Home</a><label>/</label>Register</a></h2>
	</div>
</div>
<!---728x90--->
<!--login-->
<div class="container">
		<div class="login">
			<form action="Register" method="post">
			<div class="col-md-6 login-do">
			<div class="login-mail">
					<input type="text" placeholder="Name" name="UserName" required="">
					<i  class="glyphicon glyphicon-user"></i>
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Phone Number" name="PhoneNo" required="">
					<i  class="glyphicon glyphicon-phone"></i>
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Email" name="Email"required="">
					<i  class="glyphicon glyphicon-envelope"></i>
				</div>
				<div class="login-mail">
					<input type="password" placeholder="Password" name="Password"required="">
					<i class="glyphicon glyphicon-lock"></i>
				</div>
						<div class="login-mail">
					<input type="text" placeholder="Address" name="Address"required="">
					<i class="glyphicon glyphicon-home"></i>
				</div>		
				<div class="login-mail">
					<input type="text" placeholder="City" name="City"required="">
					<i class="glyphicon glyphicon-home"></i>
				</div>		
				<div class="login-mail">
					<input type="text" placeholder="State" name="State"required="">
					<i class="glyphicon glyphicon-home"></i>
				</div>		
				<div class="login-mail">
					<input type="text" placeholder="Country" name="Country"required="">
					<i class="glyphicon glyphicon-map-marker"></i>
				</div>
				<div class="login-mail">
					<input type="text" placeholder="zipcode" name="zipcode"required="">
					<i class="glyphicon glyphicon-map-marker"></i>
				</div>
				   <a class="news-letter " href="#">
						 <label class="checkbox1"><input type="checkbox" name="checkbox" ><i> </i>Forget Password</label>
					   </a>
				<label class="hvr-skew-backward">
					<input type="submit" value="Submit">
				</label>
			
			</div>
			<div class="col-md-6 login-right">
				 <h3>Completely Free Account</h3>
				 
				 <p>Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio 
				 libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
				<a href="login.jsp" class="hvr-skew-backward">Login</a>

			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>

</div>

<!--//login-->
<!---728x90--->
		<!--brand-->
		<div class="container">
			<div class="brand">
				<div class="col-md-3 brand-grid">
					<img src="images/ic.png" class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img src="images/ic1.png" class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img src="images/ic2.png" class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img src="images/ic3.png" class="img-responsive" alt="">
				</div>
				<div class="clearfix"></div>
			</div>
			</div>
			<!--//brand-->
			</div>
			
		</div>
	<!--//content-->
	<!---728x90--->
		<!--//footer-->
	<div class="footer">
	<div class="footer-middle">
				<div class="container">
					<div class="col-md-3 footer-middle-in">
						<a href="index.jsp"><img src="images/log.png" alt=""></a>
						<p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
					</div>
					
					<div class="col-md-3 footer-middle-in">
						<h6>Information</h6>
						<ul class=" in">
							<li><a href="404.html">About</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Returns</a></li>
							<li><a href="contact.html">Site Map</a></li>
						</ul>
						<ul class="in in1">
							<li><a href="#">Order History</a></li>
							<li><a href="wishlist.html">Wish List</a></li>
							<li><a href="login.jsp">Login</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-3 footer-middle-in">
						<h6>Tags</h6>
						<ul class="tag-in">
							<li><a href="#">Lorem</a></li>
							<li><a href="#">Sed</a></li>
							<li><a href="#">Ipsum</a></li>
							<li><a href="#">Contrary</a></li>
							<li><a href="#">Chunk</a></li>
							<li><a href="#">Amet</a></li>
							<li><a href="#">Omnis</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-middle-in">
						<h6>Newsletter</h6>
						<span>Sign up for News Letter</span>
							<form>
								<input type="text" value="Enter your E-mail" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
								<input type="submit" value="Subscribe">	
							</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="container">
					<ul class="footer-bottom-top">
						<li><a href="#"><img src="images/f1.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f2.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f3.png" class="img-responsive" alt=""></a></li>
					</ul>
					<p class="footer-class">&copy; 2016 Shopin. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<!--//footer-->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>
 
</body>

<!-- Mirrored from p.w3layouts.com/demos/shopin/web/register.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 18 Apr 2017 19:28:29 GMT -->
</html>