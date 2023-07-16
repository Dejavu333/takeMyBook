<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="stylesheet" type="text/css" href="../login.css">
    <link rel="icon" href="../takeMyBookLogo.png">
    <title>Login</title>
</head>
<body style="padding: 2em">
<div style="display: inline-block">
    <h1>Welcome to takeMyBook!</h1>
    <h2>Join us and trade your books with other Bookworms.</h2>
    <p class="message">${message}</p>
</div>
    <!-- login -->
    <section id="login">
        <!-- <button class="loginButton">Login</button> -->
        <form class="popUpForm" action="/login" method="post">

          </div>
          <div class="clear"></div>
          <div class="loginText">
            <p>Sign Into Your Account</p>
          </div>
          <div class="clear"></div>
          <div class="login">
            <p>Username:</p>
            <input name="p_username" type="text" />
          </div>
          <div class="clear"></div>
          <div class="password">
            <p>Password:</p>
            <input name="p_password" type="password" />
          </div>
          <button type="submit">Sign In</button>
        </form>
    </section>
        <!-- register -->
        <section id="registration">
            <!-- <button class="loginButton">Login</button> -->
            <form:form  modelAttribute="registerForm" class="popUpForm" action="/register" method="post">
              </div>
              <div class="clear"></div>
              <div class="loginText">
                <p>Register Your Account</p>
              </div>
              <div class="clear"></div>
              <div class="login">
                <p><form:label path="username">Username</form:label></p>
                <form:input path="username" type="text" />
              </div>
              <div class="clear"></div>
              <div class="login">
                   <p><form:label path="password">Password</form:label></p>
                <form:input path="password" type="password" />
              </div>
              <div class="clear"></div>
              <div class="login">
                 <p><form:label path="passwordAgain">Re-password</form:label></p>
                <form:input path="passwordAgain" type="password" />
              </div>
              <div class="clear"></div>
              <div class="login">
                  <p><form:label path="nickName">Nickname</form:label></p>
                <form:input path="nickName" type="text" />
              </div>
              <div class="clear"></div>
              <div class="login">
               <p><form:label path="phone">Phone</form:label></p>
                <form:input path="phone" type="text" />
              </div>
                <div class="login">
                   <p><form:label path="email">Email</form:label></p>
                    <form:input type="email" path="email" />
                </div>
                <form:input type="hidden" id="inlon" path="inlon"/>
                 <form:input type="hidden" id="inlat" path="inlat"/>
              <button type="submit">Register</button>
            </form:form>
        </section>

    <!--login book -->
    <div id="loginBookContainer">
        <?xml version="1.0" encoding="UTF-8"?>
        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 117.6149 93.6659">
            <defs>
            <style>
                .cls-1 {
                fill: url(#linear-gradient-27);
                }
    
                .cls-2 {
                fill: url(#linear-gradient-24);
                }
    
                .cls-3 {
                fill: url(#linear-gradient-32);
                }
    
                .cls-4 {
                fill: url(#linear-gradient-20);
                }
    
                .cls-5 {
                fill: url(#linear-gradient-5);
                }
    
                .cls-6 {
                fill: url(#linear-gradient-6);
                }
    
                .cls-7 {
                fill: url(#linear-gradient-23);
                }
    
                .cls-8 {
                fill: url(#linear-gradient-15);
                }
    
                .cls-9 {
                fill: url(#linear-gradient-8);
                }
    
                .cls-10 {
                fill: url(#linear-gradient);
                }
    
                .cls-11 {
                fill: url(#linear-gradient-7);
                }
    
                .cls-12 {
                fill: url(#linear-gradient-36);
                }
    
                .cls-13 {
                fill: url(#linear-gradient-14);
                }
    
                .cls-14 {
                fill: url(#linear-gradient-35);
                }
    
                .cls-15 {
                fill: url(#linear-gradient-18);
                }
    
                .cls-16 {
                fill: url(#linear-gradient-26);
                }
    
                .cls-17 {
                fill: url(#linear-gradient-29);
                }
    
                .cls-18 {
                fill: url(#linear-gradient-9);
                }
    
                .cls-19 {
                fill: url(#linear-gradient-10);
                }
    
                .cls-20 {
                fill: url(#linear-gradient-2);
                }
    
                .cls-21 {
                fill: url(#linear-gradient-33);
                }
    
                .cls-22 {
                fill: url(#linear-gradient-40);
                }
    
                .cls-23 {
                fill: url(#linear-gradient-30);
                }
    
                .cls-24 {
                fill: url(#linear-gradient-34);
                }
    
                .cls-25 {
                fill: url(#linear-gradient-16);
                }
    
                .cls-26 {
                fill: url(#linear-gradient-37);
                }
    
                .cls-27 {
                fill: url(#linear-gradient-39);
                }
    
                .cls-28 {
                fill: url(#linear-gradient-12);
                }
    
                .cls-29 {
                fill: url(#linear-gradient-28);
                }
    
                .cls-30 {
                fill: url(#linear-gradient-11);
                }
    
                .cls-31 {
                fill: url(#linear-gradient-4);
                }
    
                .cls-32 {
                fill: url(#linear-gradient-19);
                }
    
                .cls-33 {
                fill: url(#linear-gradient-25);
                }
    
                .cls-34 {
                fill: url(#linear-gradient-3);
                }
    
                .cls-35 {
                fill: url(#linear-gradient-38);
                }
    
                .cls-36 {
                fill: url(#linear-gradient-17);
                }
    
                .cls-37 {
                fill: url(#linear-gradient-21);
                }
    
                .cls-38 {
                fill: url(#linear-gradient-13);
                }
    
                .cls-39 {
                fill: url(#linear-gradient-22);
                }
    
                .cls-40 {
                fill: url(#linear-gradient-31);
                }
            </style>
            <linearGradient id="linear-gradient" x1="78.8349" y1="84.0587" x2="8.1318" y2="45.2105" gradientTransform="matrix(1, 0, 0, 1, 0, 0)" gradientUnits="userSpaceOnUse">
                <stop offset="0" stop-color="#ba681f"/>
                <stop offset=".2056" stop-color="#a35219"/>
                <stop offset=".7409" stop-color="#6b1e0a"/>
                <stop offset="1" stop-color="#560a05"/>
            </linearGradient>
            <linearGradient id="linear-gradient-2" x1="4.9748" y1="64.3352" x2="2.1249" y2="62.7693" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-3" x1="227.2264" y1="141.5614" x2="-38.5497" y2="-4.4705" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-4" x1="-547.1687" y1="810.105" x2="-719.3103" y2="720.8246" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-5" x1="-667.7665" y1="828.5753" x2="-900.788" y2="649.5298" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-6" x1="228.3299" y1="142.4731" x2="-38.6207" y2="-4.2042" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-7" x1="-425.4575" y1="940.7477" x2="-1345.7844" y2="512.9349" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-8" x1="235.8876" y1="153.827" x2="121.8632" y2="84.7031" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-9" x1="-181.8713" y1="1101.9051" x2="-436.7091" y2="947.4173" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-10" x1="-36.4153" y1="124.1859" x2="129.6602" y2="3.0287" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-11" x1="128.3768" y1="81.5068" x2="-276.4864" y2="-106.6934" gradientTransform="matrix(1, 0, 0, 1, 0, 0)" gradientUnits="userSpaceOnUse">
                <stop offset="0" stop-color="#f5f5f5"/>
                <stop offset="1" stop-color="#ccc"/>
            </linearGradient>
            <linearGradient id="linear-gradient-12" x1="140.2881" y1="84.0158" x2="-26.9598" y2="9.8049" xlink:href="#linear-gradient-11"/>
            <linearGradient id="linear-gradient-13" x1="128.3818" y1="78.8441" x2="-276.4706" y2="-109.3511" xlink:href="#linear-gradient-11"/>
            <linearGradient id="linear-gradient-14" x1="140.28" y1="81.3517" x2="-26.9679" y2="7.1408" xlink:href="#linear-gradient-11"/>
            <linearGradient id="linear-gradient-15" x1="128.3818" y1="76.1841" x2="-276.4626" y2="-112.0073" xlink:href="#linear-gradient-11"/>
            <linearGradient id="linear-gradient-16" x1="140.2834" y1="78.6987" x2="-26.972" y2="4.4845" xlink:href="#linear-gradient-11"/>
            <linearGradient id="linear-gradient-17" x1="-547.1687" y1="810.105" x2="-719.3103" y2="720.8246" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-18" x1="-667.7665" y1="828.5753" x2="-900.788" y2="649.5298" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-19" x1="-425.4575" y1="940.7477" x2="-1345.7844" y2="512.9349" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-20" x1="-181.8713" y1="1101.9051" x2="-436.7091" y2="947.4173" gradientTransform="translate(322.5084 -347.8697) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-21" x1="-659.66" y1="836.5065" x2="-1088.8027" y2="651.6441" gradientTransform="translate(325.5231 -344.0347) rotate(.4823) scale(.4514)" gradientUnits="userSpaceOnUse">
                <stop offset="0" stop-color="#fdd01c"/>
                <stop offset=".1839" stop-color="#f8bc19"/>
                <stop offset=".7338" stop-color="#eb8413"/>
                <stop offset="1" stop-color="#e66f11"/>
            </linearGradient>
            <linearGradient id="linear-gradient-22" x1="-39.1862" y1="120.3823" x2="126.8847" y2="-.7716" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-23" x1="-210.2816" y1="1101.0552" x2="-522.6076" y2="959.0898" gradientTransform="translate(274.3956 -335.2307) scale(.3993)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-24" x1="-456.2135" y1="970.4312" x2="-710.4179" y2="853.5639" gradientTransform="translate(274.3956 -335.2307) scale(.3993)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-25" x1="27.011" y1="91.4907" x2="153.7887" y2="33.2419" gradientTransform="matrix(1, 0, 0, 1, 0, 0)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-26" x1="-532.0985" y1="978.2041" x2="-684.3158" y2="886.6262" gradientTransform="translate(331.3717 -342.6788) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-27" x1="-517.0646" y1="953.2875" x2="-669.3273" y2="861.6823" gradientTransform="translate(331.3717 -342.6788) scale(.4476)" xlink:href="#linear-gradient"/>
            <linearGradient id="linear-gradient-28" x1="-549.7784" y1="939.8045" x2="-665.3988" y2="899.4488" gradientTransform="translate(331.3717 -342.6788) scale(.4476)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-29" x1="-508.0368" y1="1052.2698" x2="-497.0754" y2="1041.4942" gradientTransform="translate(283.0514 -334.7794) scale(.3771)" gradientUnits="userSpaceOnUse">
                <stop offset="0" stop-color="#fdd01c"/>
                <stop offset=".4139" stop-color="#e88f0f"/>
                <stop offset=".8096" stop-color="#d65704"/>
                <stop offset="1" stop-color="#cf4200"/>
            </linearGradient>
            <linearGradient id="linear-gradient-30" x1="-470.6016" y1="1066.5576" x2="-499.6745" y2="1052.1961" xlink:href="#linear-gradient-29"/>
            <linearGradient id="linear-gradient-31" x1="-507.319" y1="1053.0104" x2="-496.3391" y2="1042.2166" xlink:href="#linear-gradient-29"/>
            <linearGradient id="linear-gradient-32" x1="-6.199" y1="4076.5632" x2="-157.2143" y2="4076.5632" gradientTransform="translate(73.3826 -309.1966) scale(.089)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-33" x1="-268.7994" y1="4125.3372" x2="-242.2689" y2="4119.524" gradientTransform="translate(73.3826 -309.1966) scale(.089)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-34" x1="-296.7741" y1="2181.3979" x2="-419.5822" y2="2171.6639" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-35" x1="-420.6626" y1="2140.3237" x2="-283.0793" y2="2261.6398" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-36" x1="-566.783" y1="2224.9825" x2="-432.5685" y2="2187.8296" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-37" x1="-473.7921" y1="2243.71" x2="-383.1458" y2="2174.4448" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-38" x1="-544.0403" y1="2276.5795" x2="-433.4205" y2="2174.7902" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-39" x1="-557.7141" y1="2261.7226" x2="-447.0845" y2="2159.9243" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            <linearGradient id="linear-gradient-40" x1="-466.6452" y1="2155.7856" x2="-668.8349" y2="2014.948" gradientTransform="translate(126.5004 -315.3889) scale(.1706)" xlink:href="#linear-gradient-21"/>
            </defs>
            <g id="Layer_1" data-name="Layer 1"/>
            <g id="Layer_2" data-name="Layer 2">
            <g id="_层_1" data-name="图层 1">
                <g>
                <g>
                    <g>
                    <g>
                        <path class="cls-10" d="M86.33,66.626l-.01,3.81-21.03,21.22L5.25,65.1559c-.23-.1-.45-.22-.66-.35-.22-.14-.42-.29-.62-.45-.29-.24-.57-.51-.81-.8-.07-.08-.14-.16-.2-.25-.07-.09-.13-.17-.19-.26l-.09-.15c-.12-.18-.23-.37-.32-.56-.2599-.53-.4-1.07-.4-1.58v-3.75l.02-.32c.01-.07,.02-.14,.04-.2,.02-.07,.03-.14,.06-.2,.01-.02,.02-.05,.02-.07,.0099-.02,.02-.05,.03-.07,.04-.08,.07-.15,.12-.22,.13-.21,.31-.37,.52-.49,.02-.02,.05-.03,.08-.04,.02-.02,.04-.03,.0699-.04,.02-.01,.04-.02,.06-.02,.13-.07,.28-.11,.44-.13,.12-.02,.2401-.03,.37-.03,.41,0,.86,.09,1.33,.29l-.46,.47,.92,.4-.92,.93,.92,.4-.92,.93,.92,.4-.92,.93,.92,.4-.92,.9301,.92,.4-.92,.93,2.18,.96,57.41,25.35,22.08-22.27Z"/>
                        <path class="cls-20" d="M2.77,63.0459c.06,.09,.12,.17,.19,.26-.02-.01-.03-.03-.04-.04-.05-.0699-.1-.15-.15-.22Z"/>
                        <path class="cls-34" d="M57.58,12.3659L20.34,49.9259l-2.92,2.95-4.14,4.18-1.38,1.39-.47,.48-.92,.92-.92,.93-.91,.92-.92,.93-.92,.92-2.18-.96,.92-.93-.92-.4,.92-.9301-.92-.4,.92-.93-.92-.4,.92-.93-.92-.4,.92-.93-.92-.4,.46-.47c-.47-.2-.92-.29-1.33-.29-.1299,0-.25,.01-.37,.03-.16,.02-.31,.06-.44,.13-.02,0-.04,.01-.06,.02q0-.01,.01-.01l1.97-1.99L54.49,3.3359c-.12,.25-.2,.54-.2,.88v3.75c0,.17,.02,.34,.05,.52,.06,.33,.17,.66,.33,1v.01c.13,.28,.29,.56,.4901,.83,.03,.05,.06,.1,.1,.15,.13,.18,.28,.36,.44,.53,.02,.02,.04,.04,.05,.06,.46,.47,1,.88,1.58,1.18,.08,.04,.16,.08,.25,.12Z"/>
                        <path class="cls-31" d="M54.4909,3.3371l.7666-.7764c-.3486,.1611-.6074,.4238-.7666,.7764Z"/>
                    </g>
                    <path class="cls-5" d="M52.943,.7248L.611,53.5119c1.2735-1.0909,2.7627-.8321,4.0498-.2666L56.9899,.4562c-1.2851-.5664-2.6933-.7383-4.0469,.2686Z"/>
                    <polygon class="cls-6" points="117.61 38.8659 99.36 57.2759 87.18 69.566 86.32 70.436 86.33 66.626 64.25 88.8959 6.84 63.5459 7.76 62.626 8.68 61.696 9.59 60.7759 10.51 59.8459 11.43 58.9259 11.9 58.446 13.28 57.056 17.42 52.876 20.34 49.9259 57.58 12.3659 100.8 31.446 103.96 32.8359 109.58 35.3259 110.41 35.686 110.97 35.936 111.32 36.0859 112.23 36.496 113.15 36.8959 114.07 37.306 114.99 37.7059 117.61 38.8659"/>
                    <polygon class="cls-11" points="65.2878 80.0138 4.6608 53.2453 56.9899 .4562 117.6149 27.2238 65.2878 80.0138"/>
                    <polygon class="cls-9" points="117.61 38.8659 117.61 40.8859 99.36 59.2959 87.18 71.5859 86.31 72.4559 65.29 93.6659 65.29 91.6559 86.32 70.436 87.18 69.566 99.36 57.2759 117.61 38.8659"/>
                    <polygon class="cls-18" points="65.2878 82.0187 65.2878 80.0138 117.6149 27.2238 117.6149 29.2316 65.2878 82.0187"/>
                    </g>
                    <path class="cls-19" d="M65.29,80.0159v2l-.56-.25L11.9,58.446l-2.18-.96-.92-.4-.92-.41-.92-.4-.91-.41-.8-.35c-.04-.02-.08-.03-.12-.05h-.01c-.47-.2-.92-.29-1.33-.29-.1299,0-.25,.01-.37,.03-.16,.02-.31,.06-.44,.13-.02,0-.04,.01-.06,.02-.03,.01-.05,.02-.0699,.04-.01,0-.03,0-.04,.01-.02,.01-.03,.02-.04,.03-.21,.12-.39,.28-.52,.49-.05,.07-.09,.15-.12,.22-.01,.02-.02,.05-.03,.07-.01,.02-.01,.05-.02,.07-.03,.06-.04,.13-.06,.2-.02,.06-.03,.13-.04,.2l-.02,.32v3.75c0,.5099,.14,1.05,.4,1.58,.09,.19,.2,.38,.32,.56l.09,.15c.06,.09,.12,.17,.19,.26,.06,.09,.13,.17,.2,.25,.24,.29,.52,.56,.81,.8,.2,.17,.4,.32,.62,.45,.21,.13,.43,.25,.66,.35l60.04,26.5v2.01L4.66,66.9059c-1.28-.57-2.45-1.56-3.29-2.68-.85-1.13-1.37-2.4-1.37-3.55v-5.32c0-.33,.04-.64,.13-.91,.03-.1,.06-.19,.1-.27,.03-.08,.07-.17,.1201-.24,.02-.05,.05-.1,.09-.14,.03-.06,.07-.12,.12-.17,.07-.08,.14-.16,.21-.23,.04-.04,.09-.07,.13-.11,.14-.1,.29-.19,.44-.26,.08-.04,.17-.07,.25-.1,.09-.02,.18-.05,.27-.07,.07-.02,.14-.04,.21-.05,.08-.01,.16-.02,.25-.03,.21-.02,.42-.02,.65,.01,.06,0,.12,.01,.18,.02s.11,.01,.16,.02c.09,.02,.18,.03,.27,.06,.03,0,.06,.01,.09,.01,.14,.04,.28,.08,.42,.13,.03,.01,.06,.02,.08,.03,.16,.05,.33,.12,.4901,.19l.24,.11,1.62,.71,.91,.4,.92,.41,.92,.4,.91,.41,.92,.4,2.18,.97,52.0099,22.96Z"/>
                </g>
                <g>
                    <g>
                    <polygon class="cls-30" points="115.68 37.0159 114.99 37.7059 99.36 53.4759 94.76 58.126 92.89 60.006 92.8 60.0959 87.18 65.7659 86.33 66.626 64.25 88.8959 6.84 63.5459 4.66 62.5859 5.58 61.6559 6.49 60.7359 7.41 59.806 8.33 58.8859 9.25 57.9559 9.72 57.4859 11.1 56.0859 17.95 49.1759 19.02 48.1059 54.71 12.1059 55.75 11.066 55.79 11.0159 56.1 10.7059 56.92 11.0759 56.93 11.0759 58.84 11.9159 100.46 30.2959 102.71 31.2859 110.27 34.626 111.09 34.996 111.66 35.2359 112.01 35.3959 112.92 35.7959 113.84 36.2059 114.76 36.6059 115.68 37.0159"/>
                    <polygon class="cls-28" points="115.68 35.6759 114.76 36.6059 114.07 37.306 99.36 52.1459 87.18 64.4259 86.33 65.2859 64.25 87.566 7.76 62.626 5.58 61.6559 4.66 61.256 5.58 60.3259 6.49 59.4059 7.41 58.4759 8.33 57.556 8.8 57.0859 10.18 55.686 17.13 48.6759 54.75 10.7359 54.76 10.7359 55.16 10.3259 56.1 9.376 58.85 10.5859 60.32 11.2359 100.68 29.056 102.21 29.7359 111.2 33.696 112.02 34.056 112.58 34.306 112.93 34.4659 113.85 34.8659 114.76 35.2759 115.68 35.6759"/>
                    </g>
                    <g>
                    <polygon class="cls-38" points="115.68 34.3459 113.84 36.2059 113.15 36.8959 99.36 50.816 87.18 63.0959 86.34 63.946 86.34 63.9559 64.25 86.2359 8.68 61.696 6.49 60.7359 5.58 60.3259 4.66 59.9259 5.58 58.996 6.49 58.0759 7.41 57.1459 7.88 56.6759 9.27 55.2759 54.67 9.496 54.67 9.4859 56.1 8.0459 60.04 9.7859 102.72 28.626 112.11 32.7759 112.94 33.1359 113.5 33.3859 113.85 33.5359 114.76 33.946 115.68 34.3459"/>
                    <polygon class="cls-13" points="115.68 33.0159 114.76 33.946 113.85 34.8659 112.92 35.7959 112.23 36.496 99.36 49.4759 87.18 61.7659 86.34 62.6159 64.25 84.8959 9.59 60.7759 7.41 59.806 6.49 59.4059 5.58 58.996 4.66 58.5959 5.58 57.6659 6.49 56.746 6.96 56.2759 8.35 54.876 54.34 8.4859 56.1 6.7159 113.03 31.8459 113.85 32.2059 114.42 32.4559 114.76 32.6159 115.68 33.0159"/>
                    </g>
                    <g>
                    <polygon class="cls-8" points="115.68 31.686 114.76 32.6159 113.85 33.5359 112.93 34.4659 112.01 35.3959 111.32 36.0859 99.36 48.1559 87.18 60.436 86.34 61.2859 64.25 83.5759 10.51 59.8459 8.33 58.8859 7.41 58.4759 6.49 58.0759 5.58 57.6659 4.66 57.2659 5.58 56.3359 6.05 55.8659 7.43 54.4659 54.29 7.2159 56.1 5.3859 113.95 30.9259 114.77 31.2859 115.33 31.5359 115.68 31.686"/>
                    <polygon class="cls-25" points="115.68 30.3659 114.77 31.2859 113.85 32.2059 112.94 33.1359 112.02 34.056 111.09 34.996 110.41 35.686 99.36 46.8259 87.18 59.1159 86.35 59.9559 65.29 81.196 64.73 81.7659 64.25 82.246 11.43 58.9259 9.25 57.9559 8.33 57.556 7.41 57.1459 6.49 56.746 5.58 56.3359 4.66 55.936 5.12 55.4659 5.13 55.4659 6.52 54.066 54.29 5.8859 56.1 4.056 114.86 30.006 115.68 30.3659"/>
                    </g>
                </g>
                <g>
                    <g>
                    <path class="cls-36" d="M54.4909,3.3371l.7666-.7764c-.3486,.1611-.6074,.4238-.7666,.7764Z"/>
                    <path class="cls-15" d="M52.943,.7248L.611,53.5119c1.2735-1.0909,2.7627-.8321,4.0498-.2666L56.9899,.4562c-1.2851-.5664-2.6933-.7383-4.0469,.2686Z"/>
                    <polygon class="cls-32" points="65.2878 80.0138 4.6608 53.2453 56.9899 .4562 117.6149 27.2238 65.2878 80.0138"/>
                    <polygon class="cls-4" points="65.2878 82.0187 65.2878 80.0138 117.6149 27.2238 117.6149 29.2316 65.2878 82.0187"/>
                    </g>
                    <path class="cls-37" d="M61.3805,9.4835l-.7314-.3173h0l-.585,.6035h0c-1.2519,1.2578-3.6357,1.6924-5.3066,.9697h0l-.7344-.3213h0l-.5927,.5371h0L16.3747,48.3459h0l.79,.3378h0c1.666,.7276,2.0069,2.3516,.7617,3.6133h0l-.5537,.5615h0l.6934,.3516h0l42.1543,18.2901h0l.5791-.6036h0c1.2539-1.2539,3.6328-1.6943,5.3076-.9629h0l.7324,.3135h0l.5909-.5263h0l37.0517-37.4063h0l-.7812-.333h0c-1.6748-.7324-2.0118-2.3467-.7618-3.6123h0l.5489-.5557h0l-.6846-.3633h0L61.3805,9.4835Zm39.7168,18.8194c-1.1298,1.581-.7617,3.3086,.917,4.375h0c-.8701,.8848-34.7392,35.0732-35.6093,35.9433h0c-2.1387-.5947-4.6885-.1308-6.4317,1.1807h0c-1.1387-.4951-39.0615-16.9404-40.206-17.4394h0c1.1298-1.5743,.7627-3.3145-.916-4.3799h0c.8623-.876,34.7382-35.0713,35.6005-35.9366h0c2.1475,.5977,4.7002,.1299,6.4327-1.1845h0c1.1455,.498,39.0673,16.9414,40.2128,17.4414Z"/>
                    <path class="cls-39" d="M65.29,80.0159v2l-.56-.25L11.9,58.446l-2.18-.96-.92-.4-.92-.41-.92-.4-.91-.41-.8-.35c-.04-.02-.08-.03-.12-.05h-.01c-.47-.2-.92-.29-1.33-.29-.1299,0-.25,.01-.37,.03-.16,.02-.31,.06-.44,.13-.02,0-.04,0-.05,.01q-.01,0-.01,.01c-.04,.01-.08,.03-.11,.05-.02,.01-.03,.02-.04,.03-.21,.12-.39,.28-.52,.49-.05,.07-.08,.14-.12,.22-.01,.02-.02,.05-.03,.07-.01,.02-.01,.05-.02,.07-.03,.06-.04,.13-.06,.2H0v-1.13c0-.33,.04-.64,.13-.91,.03-.1,.06-.19,.1-.27,.03-.08,.07-.17,.1201-.24,.02-.05,.05-.1,.09-.14,.03-.06,.07-.12,.12-.17,.07-.08,.14-.16,.21-.23,.04-.04,.09-.07,.13-.11,.14-.1,.29-.19,.44-.26,.08-.04,.17-.07,.25-.1,.09-.02,.18-.05,.27-.07,.07-.02,.14-.04,.21-.05,.08-.01,.16-.02,.25-.03,.21-.02,.42-.02,.65,.01,.06,0,.12,.01,.18,.02,.14,.02,.29,.04,.43,.08,.17,.03,.34,.08,.51,.14,.03,.01,.06,.02,.08,.03,.16,.05,.33,.12,.4901,.19l.24,.11,1.62,.71,.91,.4,.92,.41,.92,.4,.91,.41,.92,.4,2.18,.97,52.0099,22.96Z"/>
                </g>
                <g>
                    <g>
                    <polygon class="cls-7" points="87.1823 73.965 87.1823 58.8351 99.361 46.5509 99.361 61.674 87.1823 73.965"/>
                    <polygon class="cls-2" points="87.1823 58.8351 81.5163 56.3273 93.6852 44.0421 99.361 46.5509 87.1823 58.8351"/>
                    </g>
                    <polygon class="cls-33" points="87.18 58.8359 87.18 73.9659 85.75 73.3359 86.2 72.8659 86.31 72.7259 86.31 72.4559 86.32 70.436 86.33 66.626 86.33 65.2859 86.34 63.9559 86.34 61.2859 86.35 60.7759 86.35 59.2059 86.05 59.0759 81.52 57.066 81.52 56.3259 86.56 58.556 87.18 58.8359"/>
                </g>
                <g>
                    <g>
                    <path class="cls-16" d="M41.072,64.8966c.3906,.5655,1.3261,.7852,2.0918,.4991l1.5791-.6075-3.1495-1.3652c-.6377,.3242-.8847,.9434-.5214,1.4736Z"/>
                    <path class="cls-1" d="M53.029,61.6125l.6387,.9287c.2197,.3252,.75,.4482,1.1865,.2861l4.542-1.7412c2.2011,1.0058,5.0127,1.1807,7.4736,.2402,3.7441-1.4394,5.2178-4.8554,3.2998-7.6435-1.9267-2.7852-6.5146-3.8848-10.2627-2.4532-2.4687,.9434-3.915,2.751-4.0889,4.6739l-4.5498,1.7363c-.4296,.1621-.5986,.5605-.3789,.8779l.7198,1.0362-6.7432,2.58c-1.5195,.5303-2.0615-.499-2.0615-.499v.0156l-.5069-.7304-1.4892,.5683c2,.8741,3.9873,1.7334,5.8838,2.5528l6.3369-2.4287Zm8.498-8.0264c1.9961-.7705,4.4522-.1817,5.4815,1.3027,1.0293,1.4854,.2441,3.3194-1.7588,4.0781-2,.7735-4.4531,.1846-5.4795-1.2998-1.0283-1.4931-.2354-3.3193,1.7568-4.081Z"/>
                    </g>
                    <path class="cls-29" d="M40.8083,61.4884l-.0117,.0078,1.1953,1.7413-.2471,.0966c-.0625,.0235-.0977,.0577-.1514,.0889l3.1495,1.3652,1.9492-.747c-1.8965-.8194-3.8838-1.6787-5.8838-2.5528Z"/>
                </g>
                <g>
                    <path class="cls-17" d="M93.9372,58.34c-.5225,.3555-.9483,1.0215-1.1104,1.6328l1.4307,.6338c.5029-.4912,.8672-1.2373,.8672-1.8184,0-.7041-.5303-.9052-1.1875-.4482Z"/>
                    <path class="cls-23" d="M92.8268,59.9728c-.0429,.1543-.0771,.3164-.0771,.4561,0,.1045,.0303,.1855,.0498,.2627l.8154,.3564h0v1.5391c0,.1933,.1475,.248,.3223,.1201,.1777-.1201,.3203-.3682,.3203-.5684v-1.5322h0l-1.4307-.6338Z"/>
                    <path class="cls-40" d="M93.6149,61.048l-.8154-.3564c.1006,.3789,.4023,.5146,.8154,.3564Z"/>
                </g>
                <g>
                    <path class="cls-3" d="M65.7009,53.3419c-.5108-.7392-1.3809-1.2617-2.3711-1.497-.9981-.2324-2.1045-.1973-3.1065,.1894-.9941,.3867-1.6982,1.0323-2.0146,1.7725v.0068l-.0078-.0068s-.4063,.7959-.0391,1.7285c0,0-.0654-.3135,.0469-.6846,.3164-.7392,1.0205-1.3847,2.0146-1.7636,1.002-.3838,2.1084-.4307,3.1065-.1944,.9902,.2403,1.8603,.7588,2.3711,1.501,.1904,.2783,.3212,.5566,.3955,.8506,.1425-.626,.0263-1.2949-.3955-1.9024Z"/>
                    <path class="cls-21" d="M49.5895,56.9709v.0068c-.0195-.0225-.1084-.1465-.1084-.3096v1.0137s0,.1855,.1084,.3408l.711,1.0371v-1.0488l-.711-1.04Z"/>
                    <g>
                    <g>
                        <path class="cls-24" d="M65.9684,55.6544v1.0567c.1934-.4756,.2393-.9707,.128-1.4668-.0362,.1367-.0772,.2793-.128,.4101Z"/>
                        <path class="cls-14" d="M69.6813,55.3527v-.293c-.0312,.4756-.1465,.9512-.3437,1.4082-.2979,.6807-.7735,1.334-1.4082,1.8985-.6299,.5693-1.419,1.0488-2.3604,1.4082-1.2334,.4756-2.5566,.6699-3.8369,.6152-1.2881-.0508-2.541-.3477-3.6357-.8545v1.0479c1.0947,.5068,2.3476,.8007,3.6357,.8515,1.2803,.0537,2.6035-.1396,3.8369-.6113,.9414-.3555,1.7305-.8399,2.3604-1.4082,.6347-.5654,1.1103-1.207,1.4082-1.8994,.3027-.6924,.4179-1.4307,.3437-2.1631Z"/>
                        <polygon class="cls-12" points="39.4929 59.9484 40.696 61.6896 40.696 62.7423 39.4929 61.0011 39.4929 59.9484"/>
                        <path class="cls-26" d="M53.5466,61.2794c-.2168,.0772-.461,.0928-.669,.0391-.2129-.0469-.4053-.1621-.5107-.3213l-.6426-.9238v1.0439l.6426,.9278c.1054,.1631,.2978,.2715,.5107,.3252,.208,.0468,.4522,.039,.669-.0469l4.5498-1.7402v-1.0479l-4.5498,1.7441Z"/>
                        <g>
                        <path class="cls-35" d="M41.8571,63.8488c-.3838,.1465-.8047,.166-1.1885,.0771-.3711-.1006-.708-.2939-.9052-.581-.0342-.0537-.1592-.1973-.1661-.5069v.7012c0,.4336-.0312,.5684,.1661,.8545,.1972,.291,.5341,.4834,.9052,.5772,.3838,.0839,.8047,.0693,1.1885-.0743l9.8672-3.7793v-1.0439l-9.8672,3.7754Z"/>
                        <path class="cls-27" d="M39.6667,63.1603v-.6963c-.0928,.2197-.1006,.4639,0,.6963Z"/>
                        </g>
                    </g>
                    <path class="cls-22" d="M65.569,59.7746c3.7412-1.4268,5.211-4.8545,3.292-7.6407h0c-1.9258-2.7851-6.5127-3.8769-10.2578-2.4443h0c-2.46,.9404-3.9189,2.7393-4.0937,4.666h0l-4.544,1.7403h0c-.4307,.163-.6045,.5566-.376,.875h0l.711,1.04h0l-6.7383,2.5801h0c-1.5205,.5263-2.0615-.502-2.0615-.502h0v.0147h0l-.5069-.7344h0l-1.5009,.5791h0l1.2031,1.7412h0l-.2559,.1045h0c-.7656,.29-1.0674,.9863-.6767,1.5508h0c.3945,.5654,1.33,.7939,2.0937,.5039h0l9.8672-3.7754h0l.6426,.9238h0c.2207,.3213,.75,.4453,1.1797,.2822h0l4.5498-1.7441h0c2.1933,1.0137,5.0097,1.1875,7.4726,.2393Zm-7.1015-3.6631c-1.0293-1.4815-.2432-3.3115,1.7558-4.0772h0c2.0039-.7627,4.4531-.1777,5.4776,1.3076h0c1.0332,1.4893,.248,3.3184-1.7598,4.085h0c-1.9961,.7627-4.4443,.1777-5.4736-1.3154Z"/>
                    </g>
                </g>
                </g>
            </g>
            </g>
        </svg>
    </div>

    <script src="./login.js" ></script>
    <script>
    function myLocation() {
        return new Promise((resolve, reject) => {
            navigator.geolocation.getCurrentPosition((position) => {
                resolve(position.coords);
            });
        });
    } myLocation().then((cor)=>{document.querySelector("#inlon").value=cor.longitude;document.querySelector("#inlat").value=cor.latitude})
    </script>
</body>
</html>