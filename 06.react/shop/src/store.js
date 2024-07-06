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
            const item = state.find(item => item.id === action.payload.id);
            if (item){
                item.count += 1;
            } else {
                state.push(action.payload);
            }},
        remove(state,action){
            // state는 우리가 쓰고있는 배열을 말해
            // 그리고 .filter는 해당되는 요소들만 배열에 새롭게 추가해주세요 이런뜻인데
            // !== action.payload 는 삭제하려고 하는애를 제외한 친구들을 새로운 배열에 추가해주세요 라는뜻
            return state.filter(item => item.id !== action.payload);
            }
    }})

export let { changePlus, changeMinus, order, remove } = buy.actions

//redux 쓰는이유 컴포넌트간 state공유가 편해짐
export default configureStore({
  reducer: { 
    // 작명 : 위에 정해둔 변수.reducer
    buy : buy.reducer,
    user : user.reducer
  }
}) 