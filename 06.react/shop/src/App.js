// import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button,Container,Nav,Navbar } from 'react-bootstrap';
import { createContext, useState } from 'react';
// export default 에서는 변수명을 정해줘야함 exprot 는 {a,b,c} 중괄호를 포함해서 꺼내서 써야함 {a},{b}는 변수임
import data from './data.js';
import { Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom';
import Detail from './routes/Detail.js';
import axios from 'axios';
import Cart from './routes/Cart.js';

// 스테이트 보관함
export let Context1 = createContext();

function App() {
  // 변수안에는 array형태랑 object형으로 보관가능
  let [shoes, setShoes] = useState(data);
  let [titles] = useState(0);
  let [click,setClick] = useState(0);
  let [로딩중,로딩중변경] = useState(false);
  let [재고] = useState([10, 11, 12]);
  

  let navigate = useNavigate();

  return (
    <div className="App">
      
      {/* <Button variant="primary">Primary</Button>{' '} */}
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Nav className="me-auto">
            <Nav.Link onClick={function(){navigate('/')}}>Home</Nav.Link>
            <Nav.Link onClick={function(){navigate('/cart')}}>Cart</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      
      <Routes>
        <Route path="/" element={
          <div>
            <div className="main-bg"></div>
            {/* 키속성이 없으면 식별하는데 어려움이 생김 map먼저 돌리고 나중에 props를 보냄  */}
            <div className="container">
              {로딩중 && <p>ㅋㅋ로딩중</p>}
              <div className="row">
                {
                  shoes.map(function (a, i) {
                    return (
                      <Goods key={a.id} i={i} shoes={shoes[i]} />
                    )
                  })
                }
                
              </div>
            </div>
           { click<2 && <button onClick={ ()=>{
              로딩중변경(true);
              setClick(click+1);
              axios.get('https://codingapple1.github.io/shop/data2.json')
              .then((axiosdata)=>{ 
                // Array.isArray는 배열인지 확인하는 내장함수 딱히 필요없는거 같아서 변수 바꿈
                if (click===0) {
                setShoes(shoes => [...shoes, ...axiosdata.data]);
              }
                if (click===1){
                  axios.get('https://codingapple1.github.io/shop/data3.json')
                  .then((xxx)=>{
                    setShoes(shoes => [...shoes, ...xxx.data])
                  }).catch(()=>{
                    console.log('실패함')
                  })
                }
              })
            .catch(()=>{
              console.log('실패함')
            }).finally(() => {
              // finally는 실패하든 성공하든 마지막에 이걸 무조건 실행함
              로딩중변경(false);
            })
          }
        }>버튼</button> }
         </div>
      }
        />
        <Route path="/detail/:id" element={
          <Context1.Provider value={{ titles, shoes, 재고 }}>
          <Detail titles={titles} shoes={shoes} />
          </Context1.Provider>
          } />

        <Route path="/about" element={<About/>}>
          <Route path="member" element={<div>멤버임</div>}/>
          <Route path="location" element={<div>로케이션임</div>}/>
        </Route>
        <Route path="*" element={<div>404 NOT FOUND</div>}></Route>
          
        <Route path="/event" element={<Event/>}>
          <Route path="one" element={<p>첫 주문시 양배추즙 서비스</p>}/>
          <Route path="two" element={<p>생일기념 쿠폰받기</p>}/>
        </Route>

        <Route path="/cart" element={<Cart/>}>
          <Route path="one" element={<p>첫 주문시 양배추즙 서비스</p>}/>
          <Route path="two" element={<p>생일기념 쿠폰받기</p>}/>
        </Route>

      </Routes>
    
    {/* {
      detail == true ? <Detail titles={titles} shoes={shoes}/> : null
    } */}

    </div>
  );
}

export default App;

function About(){
  return (
    <div>
      <h4>
        회사정보임
        <Outlet></Outlet>
      </h4>
    </div>
 )
}
function Event(){
  return (
    <div>
      <h4>
        오늘의 이벤트
        <Outlet></Outlet>
      </h4>
    </div>
 )
}

//매개변수로 props(상속이랑같음) Modal안에 상속할거 변수명 정해주고 스테이트를 넣으면 사용가능
function Goods(props){

    const navigate = useNavigate();                             // 2
    const goToDetail = () => {                                    // 3
      navigate(`/detail/${props.i}`);
    };
  
  return (
    <>
    <style>
        {`
          .hover-div:hover {
          background-color: #f0f0f0; /* 약회색 배경 */
          }
        `}
      </style>
      <div className="col-md-4 hover-div">
        <img 
        src={`https://codingapple1.github.io/shop/shoes${props.i+1}.jpg`} 
        width="80%" 
        onClick={goToDetail}
        style={{ cursor: 'pointer',  }}
        hover={{}}
        />
        <h4>
          {props.shoes.title}
          </h4>
        <p>
          {props.shoes.price}
        </p>
      </div>
    </>
  )
}





//  코딩애플 답 
//    {
//       shoes.map((a,i)=>{
//        return (
//          <Card shoes={shoes[i]} i={i}/></Card>
//        )
//      })
//    } 

//코딩애플 답안
// function Card(props){
//   return (
//     <div className="col-md-4">
//       <img src={'https://codingapple1.github.io/shop/shoes' + props.i + '.jpg'} width="80%" />
//       <h4>{ props.shoes.title }</h4>
//       <p>{ props.shoes.price }</p>
//     </div>
//   )
// }