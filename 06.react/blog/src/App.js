/*eslint-disable*/

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let post = '강남 우동 맛집';
  let [글제목, b] = useState(['남자 코트 추천','뭐야','개졸림']);
  let [따봉, c] = useState(0,1,2);
  let [modal, setModal] = useState(false);

  function 함수(){
    c(따봉+1)
  }
  
  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={ {color:'red', fontSize : '16px'} }>
          블로그임</h4>
      </div>

      <button onClick={()=>{
        let copy1 = [...글제목];
        copy1 = copy1.sort();
        b(copy1)
      }}>가나다순정렬</button>

      <div className="list">
        <h4>{ 글제목[0] } <span onClick={ 함수 }>👍</span> {따봉} </h4>
        <p>4월 29일 썼음</p>
      </div>
      <div className="list">
        <h4>{ 글제목[1] } <span onClick={ ()=>{ b(['남자 코트 추천','여자 코트 추천','개졸림']) } }>😁</span>
        <span onClick={ 함수 }>👍</span> {따봉} </h4>
        <p>5월 3일 썼음</p>
      </div>
      <div className="list">
        <h4 onClick={()=>{ setModal(true) }} >{ 글제목[2] } <span onClick={ ()=>{ 
          let copy = [...글제목];
          copy[2]= '이제 안졸림';
          b(copy);
          } }>😉</span>
          <span onClick={ 함수 }>👍</span> {따봉}</h4>
        <p>5월 3일 썼음</p>
      </div>
      
        {
           [1,2,3].map(function(){
            return <div>안녕</div>
          })
        }

      {
        modal == true ? <Modal/> : null
      }

    </div>
  );
}

function Modal(){
  return (
    <>
      <div className="modal">
        <h4>제목</h4>
        <p>날씨</p>
        <p>상세내용</p>
      </div>
    </>
  )
}

export default App;
