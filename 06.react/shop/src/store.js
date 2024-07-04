import { configureStore, createSlice } from '@reduxjs/toolkit'
import user from './store/userSlice.js'

let buy = createSlice({
   name : 'buy',
   initialState : [
        {id : 0, name : 'White and Black', count : 2},
        {id : 2, name : 'Grey Yordan', count : 1}
      ],
      reducers : {
        changePlus(state, action){
            // action.payload에 담긴 id로 해당 아이템을 찾습니다.
            const item = state.find(item => item.id === action.payload);
            if (item) {
            // 해당 아이템의 count를 1 증가시킵니다.
            item.count += 1;
        }},
        changeMinus(state, action){
            // action.payload에 담긴 id로 해당 아이템을 찾습니다.
            const item = state.find(item => item.id === action.payload);
            if (item && item.count > 0) {
            // 해당 아이템의 count를 1 씩 줄이고 item.count가 0보다 크도록 예외처리
            item.count -= 1;
        }},
        order(state,action){
            state.push(action.payload);
        }
    }})

export let { changePlus, changeMinus, order } = buy.actions

//redux 쓰는이유 컴포넌트간 state공유가 편해짐
export default configureStore({
  reducer: { 
    // 작명 : 위에 정해둔 변수.reducer
    buy : buy.reducer,
    user : user.reducer
  }
}) 