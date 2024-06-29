import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

let Box = styled.div`
  padding : 20px;
  color : grey
`;
// if문 처럼 사용가능
let YellowBtn = styled.button`
  background : ${ props => props.bg };
  color : ${ props => props.bg == 'blue'? 'white' : 'black' };
  padding : 10px;
`;

function Detail(props){

    let [count, setCount] = useState(0);
    let [timeover, setTimeover] = useState(true);
    let [numbertime, setNumbertime] = useState(true);
    let [숫자 , 숫자변경] = useState('');

    useEffect(()=>{
        let a = setTimeout(()=>{ setTimeover(false) } , 2000 )
        return ()=>{
            //useEffect 동작전에 여기가 먼저 실행됨 남아있는것들 지우고 시작하기 위해
            clearTimeout(a)
        }
    }, [])
    
    useEffect(()=>{
        if (isNaN(숫자)==true) {
            alert('숫자외에는 쓰지마세요')
        }
    } , [숫자])

    // 내가 쓴답 useEffect없이 되었음
    // let numberOnly = function(e) {
    //     let numbertime = e.target.value;
    //     if(isNaN(numbertime) === true) {
    //         setNumbertime(false);
    //     } else {
    //         setNumbertime(true);
    //     } 
    // }
    
    let {id} = useParams();
    
    // shoes = array 형식이여서 뒤에 find를 붙일수있음 바로 함수넣어서 매개변수 설정
    // 이렇게 나온 findshoes도 array 형식임
    let findshoes = props.shoes.find(function(x){
        return x.id == id
      });
    
    return (
        
      <div className="container">

        {timeover && <Timeover/>}
        {count}
        <button onClick={()=>{ setCount(count+1) }}>버튼</button>
        <div className="row">
          <div className="col-md-6">
            <img src={`https://codingapple1.github.io/shop/shoes${findshoes.id+1}.jpg`} width="100%" />
          </div>
          <div className="col-md-6">
          <input onChange={(e)=>{숫자변경(e.target.value);
      }}/>
      {/* {!numbertime && <Numbertime/>} */}
      <button onClick={()=>{}}>숫자입력</button>
      {/* <h4>{numbertime}</h4> */}
      <h4>{숫자}</h4>
            <h4 className="pt-5">{[findshoes.title]}</h4>
            <p>{[findshoes.content]}</p>
            <p>{[findshoes.price]}원</p>
            <button className="btn btn-danger">주문하기</button> 
          </div>
        </div>
        <div>
        <YellowBtn bg="blue">파란색 버튼임</YellowBtn>
        <YellowBtn bg="gray">그래이색 버튼임</YellowBtn>
        </div>
      </div> 
    )
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
// function Numbertime(){
//     return (
//       <>
//         <div className="alert alert-warning">
//             숫자외에는 쓰지마세요
//         </div>
//       </>
//     )
// }

  export default Detail;