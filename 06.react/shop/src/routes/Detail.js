import { useContext, useEffect, useState } from "react";
import { useDispatch } from 'react-redux';
import { Routes, Route,useParams,useNavigate } from "react-router-dom";
import styled from "styled-components";
import { Nav } from 'react-bootstrap';
import { Context1 } from "../App";
import { order } from "./../store.js";

// let Box = styled.div`
//   padding : 20px;
//   color : grey
// `;
// if문 처럼 사용가능
let YellowBtn = styled.button`
  background : ${ props => props.bg };
  color : ${ props => props.bg === 'blue'? 'white' : 'black' };
  padding : 10px;
`;

function Detail(props){

    let {재고, shoes, titles} = useContext(Context1);

    let [count, setCount] = useState(0);
    let [timeover, setTimeover] = useState(true);
    let [numbertime, setNumbertime] = useState(true);
    let [숫자 , 숫자변경] = useState('');
    let [탭 , 탭변경] = useState(0);
    let [화면, 화면변경] = useState('');
    
    const navigate = useNavigate();                             // 2
    const dispatch = useDispatch();
      

    useEffect(()=>{
        let a = setTimeout(()=>{ setTimeover(false) } , 2000 )
        return ()=>{
            //useEffect 동작전에 여기가 먼저 실행됨 남아있는것들 지우고 시작하기 위해
            clearTimeout(a)
        }
    }, [])
    
    useEffect(()=>{
            화면변경('end')
        return ()=>{    
            화면변경('')
        }
    }, [])
    
    // 코딩 애플 답
    // useEffect(()=>{
    //     if (isNaN(숫자)==true) {
    //         alert('숫자외에는 쓰지마세요')
    //     }
    // } , [숫자])

    // 내가 쓴답 useEffect없이 되었음
    let numberOnly = function(e) {
        let numbertime = e.target.value;
        if(isNaN(numbertime) === true) {
            setNumbertime(false);
        } else {
            setNumbertime(true);
        } 
    }
    
    let {id} = useParams();
    
    // shoes = array 형식이여서 뒤에 find를 붙일수있음 바로 함수넣어서 매개변수 설정
    // 이렇게 나온 findshoes도 array 형식임
    let findshoes = shoes.find(function(x){
        return x.id == id
      });

      const handleOrder = () => {
        const newItem = {
          id: findshoes.id,
          name: findshoes.title,
          count: 1  // 예시로 count를 1로 설정하거나, 필요한 경우 다른 속성도 추가할 수 있습니다.
        };
        dispatch(order(newItem));
        navigate('/cart');
      };
    
    return (
        
      <div className={`containe start ${화면}`}>
        {findshoes.id}
        {timeover && <Timeover/>}
        <button onClick={()=>{ setCount(count+1) }}>버튼</button>
        <div className="row">
          <div className="col-md-6">
            <img src={`https://codingapple1.github.io/shop/shoes${findshoes.id+1}.jpg`} width="100%" />
          </div>
          <div className="col-md-6">
          {/* <input onChange={(e)=>{숫자변경(e.target.value);
      }}/> */}
      {!numbertime && <Numbertime/>}
          <input onChange={ numberOnly }/>
      <button onClick={()=>{}}>숫자입력</button>
      <h4>{숫자}</h4>
            <h4 className="pt-5">{[findshoes.title]}</h4>
            <p>{[findshoes.content]}</p>
            <p>{[findshoes.price]}원</p>
            <button className="btn btn-danger" onClick={()=> handleOrder() }>주문하기</button> 
          </div>
        </div>
            <Nav variant="tabs" defaultActiveKey="link0">
                <Nav.Item>
                    <Nav.Link onClick={()=>{
                        탭변경(0)
                    }} 
                    eventKey="link0">버튼0</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link onClick={()=>{
                        탭변경(1)
                    }} 
                    eventKey="link1">버튼1</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link onClick={()=>{
                        탭변경(2)
                    }}
                    eventKey="link2">버튼2</Nav.Link>
                </Nav.Item>
            </Nav>
            <TapContent 탭={탭}/>
      </div> 
    )
  }
  function TapContent({탭}){
      let [fade, setFade]= useState('');
      let {재고} = useContext(Context1);
    useEffect(()=>{
        setTimeout(()=>{
            setFade('end')}, 10)
        return (()=>{
            setFade('');
        })
    }, [탭])
    return (<div className={`start ${fade}`}>
    {[<div>내용0{재고}</div>,<div>내용1</div>,<div>내용2</div>][탭]}
    </div>)

//     if (탭 === 0) {
//         return <div>내용0</div>
//   } if (탭 === 1) {
//         return <div>내용1</div>
//   } if (탭 === 2) {
//         return <div>내용2</div>
//   }
  
  }
  

  function Timeover(){

    return (
      <>
        <div className="alert alert-warning">
            2초이내 구매시 할인
        </div>
      </>
    )
}

// useEffect 없이 쓴 답
function Numbertime(){
    return (
      <>
        <div className="alert alert-warning">
            숫자외에는 쓰지마세요
        </div>
      </>
    )
}

  export default Detail;