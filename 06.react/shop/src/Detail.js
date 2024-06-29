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
    
    let {id} = useParams();
    
    // shoes = array 형식이여서 뒤에 find를 붙일수있음 바로 함수넣어서 매개변수 설정
    // 이렇게 나온 findshoes도 array 형식임
    let findshoes = props.shoes.find(function(x){
        return x.id == id
      });
    
    return (
        
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <img src={`https://codingapple1.github.io/shop/shoes${findshoes.id+1}.jpg`} width="100%" />
          </div>
          <div className="col-md-6">
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

  export default Detail;