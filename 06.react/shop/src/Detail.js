import { useParams } from "react-router-dom";

function Detail(props){
    
    let {id} = useParams();
    
    // shoes = array 형식이여서 뒤에 find를 붙일수있음 바로 함수넣어서 매개변수 설정
    // 이렇게 나온 findshoes도 array 형식임
    let findshoes = props.shoes.find(function(x){
        return x.id == id
      });
    
    console.log(findshoes);
    return (
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <img src={`https://codingapple1.github.io/shop/shoes${findshoes.id+1}.jpg`} width="100%" />
          </div>
          <div className="col-md-6">
            <h4 className="pt-5">{[findshoes.title]}</h4>
            <p>{[findshoes.content]}</p>
            <p>{[findshoes.price]}</p>
            <button className="btn btn-danger">주문하기</button> 
          </div>
        </div>
      </div> 
    )
  }

  export default Detail;