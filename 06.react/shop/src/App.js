// import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button,Container,Nav,Navbar } from 'react-bootstrap';
import { useState } from 'react';
// export default 에서는 변수명을 정해줘야함 exprot 는 {a,b,c} 중괄호를 포함해서 꺼내서 써야함 {a},{b}는 변수임
import data from './data.js';
import { Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom';
import Detail from './Detail.js';


function App() {
  // 변수안에는 array형태랑 object형으로 보관가능
  let [shoes, setShoes] = useState(data);
  let [goods, setGoods] = useState(false);
  let [titles, setTitles] = useState(0);
  let navigate = useNavigate();
  
  
  return (
    <div className="App">
      
      <Button variant="primary">Primary</Button>{' '}
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Nav className="me-auto">
            <Nav.Link onClick={function(){navigate('/')}}>Home</Nav.Link>
            <Nav.Link onClick={function(){navigate('/detail')}}>Detail</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      
      <Routes>
        <Route path="/" element={
          <div>
            <div className="main-bg"></div>
            {/* 키속성이 없으면 식별하는데 어려움이 생김 map먼저 돌리고 나중에 props를 보냄  */}
            <div className="container">
              <div className="row">
                {
                  shoes.map(function (a, i) {
                    return (
                      <Goods key={a.id} titles={i} shoes={shoes} />
                    )
                  })
                }

              </div>

            </div>
          </div>
        }
        />
        <Route path="/detail/:id" element={<Detail titles={titles} shoes={shoes} />} />

        <Route path="/about" element={<About/>}>
          <Route path="member" element={<div>멤버임</div>}/>
          <Route path="location" element={<div>로케이션임</div>}/>
        </Route>
        <Route path="*" element={<div>404 NOT FOUND</div>}></Route>
          
        <Route path="/event" element={<Event/>}>
          <Route path="one" element={<p>첫 주문시 양배추즙 서비스</p>}/>
          <Route path="two" element={<p>생일기념 쿠폰받기</p>}/>
        </Route>
      </Routes>
    {
      goods == true ? <Goods titles={titles} shoes={shoes}/> : null
    } 

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

  return (
    <>
      <div className="col-md-4">
        <img src={`https://codingapple1.github.io/shop/shoes${props.titles+1}.jpg`} width="80%" />
        <h4>
          {props.shoes[props.titles].title}
          </h4>
        <p>
          {props.shoes[props.titles].price}
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