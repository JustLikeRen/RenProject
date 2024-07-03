import {Table} from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { changeName,changePlus,changeMinus } from './../store';

function Cart(){
    
    // a.user 이런식으로 오브젝트에서 꺼내쓰듯이 사용
    let state = useSelector((state)=>state)
    // store.js로 요청 보내주는 함수
    let dispatch = useDispatch();
    
    return (
        <div>
            {state.user}의 장바구니
            <Table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>변경하기</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        // 오브젝트형을 i만큼 뿌릴려면 맵으로 돌려야함 
                        // 다른방식도 있나? 일단 이거밖에 몰라서 이거만 씀 ㅋㅋ
                        state.buy.map((id, i) => (
                            <tr key={id.id}>
                                <td>{i+1}</td>
                                <td>{id.name}</td>
                                <td>{id.count}</td>
                                <td>안녕</td>
                                <td>
                                    <button style={{marginRight : "10px"}} onClick={()=>{
                                        dispatch(changeMinus(id.id))
                                    }}>-</button>
                                    <button onClick={()=>{
                                        dispatch(changePlus(id.id))
                                    }}>+</button>
                                </td>
                                
                                   
                                
                            </tr>
                        ))
                    }
                </tbody>
            </Table> 
        </div>
    )
}

export default Cart;