import React, { useState, useEffect } from 'react';
import { Button, Col, Image } from 'react-bootstrap';
import axios from 'axios';
import styles from './style/page.module.css';
import images from './style/images.js'; //이미지 모아뒀습니다.
import 'bootstrap/dist/css/bootstrap.min.css';


function Page() {
  const [activeItem, setActiveItem] = useState(null);
    
  const handleClick = (item) => {
    setActiveItem(item);
  };

  return (
       <div className={styles.whole}>
        <div className={styles.ad}>배너</div>
            <div className={styles.top}>
              <div className={styles.wrapperHeader}>
                <div className={styles.headerTop}>
                  <div className={styles.headerTopLeft}>
                      <img className={styles.headerTopLogo} src={images.cinema} alt="로고" />
                      <div className={styles.headerTopTitle}><h1>게시판</h1></div>
                  </div>
                  <div className={styles.headerTopRight}>
                      <div className={styles.topUser} onClick={() => window.location.href = '../signIn'} style={{ cursor: 'pointer' }}>
                        <img className={styles.topUserImg} src={images.login} alt="로그인" />
                       <div className={styles.topUserBtn}>로그인</div>
                      </div>
                      <div className={styles.topUser} onClick={() => window.location.href = '../signUp'} style={{ cursor: 'pointer' }}>
                        <img className={styles.topUserImg} src={images.register} alt="회원가입" />
                        <div className={styles.topUserBtn}>회원가입</div>
                      </div>
                      <div className={styles.topUser} onClick={() => window.location.href = '../myPage'} style={{ cursor: 'pointer' }}>
                        <img className={styles.topUserImg} src={images.mypage} alt="마이페이지" />
                  </div>
                </div>
                </div>
                <div className={styles.wrapperHeaderCategory}>
                  <div className={styles.categoryLeft}>
                  <ul className={styles.navbar}>
        <li className={styles.dropdown}>
            <a href="#" class="dropbtn">게시판 만들것</a>
            <ul className={styles.dropdownContent}>
            </ul>
        </li>
        
        
       
        
    </ul>
                  </div>
                  
                </div>
              </div>
            </div>  
                 
          <div className={styles.container}>
            <div className={styles.info}>
              <div className={styles.infoTop}>
                <div className={styles.infoTopLeft}>
                  <img className={styles.mypageImg} src={images.mypage} alt="프로피르" />
                </div>
                <div className={styles.infoTopRig}>
                  
                </div>
              </div>
              <div className={styles.infoBot}>
                
              </div>
            </div>
            <div className={styles.content}>
              <div className={styles.containerleft}>
                <ul className={styles.containermenu}>
                  <li className={styles.li}>
                    나의 예매내역
                    <ul>
                    </ul>
                  </li>
                  <li className={styles.li}>관람권/할인쿠폰 관리
                    <ul>
                    </ul>
                  </li>
                  <li className={styles.li}>기프트샵
                    <ul>
                    </ul>
                  </li>
                  <li className={styles.li}>회원정보
                    <ul>
                      <li>개인정보 변경</li>
                    </ul>
                  </li>
                  <li className={styles.li}>프로필 관리
                    <ul>
                    </ul>
                  </li>
                  <li className={styles.li}>문의 내역
                    <ul>
                      <li>1대1문의</li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div className={styles.containerinfo}></div>
            </div>
          </div>
        </div>
    
  );
}

export default Page;