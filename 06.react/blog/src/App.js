/*eslint-disable*/

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  
  let post = '강남 우동 맛집';
  let [글제목, b] = useState(['남자 코트 추천','뭐야','개졸림']);
  let [따봉, c] = useState([0,0,0]);
  let [modal, setModal] = useState(false);
  let [title, setTitle] = useState(0);
  let [입력값, 입력값변경] = useState('');
  

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

      {/* <div className="list">
        <h4>
          { 글제목[0] } 
          <span key={i} onClick={ 함수 }>👍</span> {따봉} 
        </h4>
        <p>4월 29일 썼음</p>
      </div>
      <div className="list">
        <h4>{ 글제목[1] } <span onClick={ ()=>{ b(['여자 코트 추천','뭐야','개졸림']) } }>😁</span>
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
       */}


      <div>
      { 
        글제목.map(function(a,i){
          return (
          <div className="list" key={i}>
           <h4 onClick={()=>{ setModal(!modal); setTitle(i)}
          } >
            { 글제목[i] }
              <span onClick={(e)=>{ 
              e.stopPropagation();
              let copy = [...따봉];
              copy[i] = copy[i] + 1;
              c(copy)  
            }}>👍</span> {따봉[i]}
            </h4>
            <p>6월 27일 발행</p>
            <button onClick={()=>{
              let copy2 = [...글제목];
              copy2.splice(i,1)
              b(copy2)
            }}>글삭제</button>
          </div> )
        }) 
      }
    </div>

        {/* {
           [1,2,3].map(function(){
            return <div>안녕</div>
          })
        } */}
     
      <input onChange={(e)=>{입력값변경(e.target.value);
      }}/>
      <button onClick={()=>{
        let copy3 = [...글제목];
        copy3.unshift(입력값);
        b(copy3)
      }}>글쓰기</button>
   
      {
        modal == true ? <Modal title={title} 글수정={b} color={'skyblue'} 글제목={글제목}/> : null
      }

    </div>
  );
}

function Modal(props){

  return (
    <>
      <div className="modal" style={{background : props.color}}>
        <h4>{props.글제목[props.title]}</h4>
        <p>날씨</p>
        <p>상세내용</p>
        <button>글수정</button>
      </div>
    </>
  )
}



export default App;
