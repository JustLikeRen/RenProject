import { createSlice } from '@reduxjs/toolkit'


//useState역할 redex수정하는 함수만들고 원할때 함수 실행해달라고 요청
let user = createSlice({
    name : 'user',
    initialState : { name : 'kim', age : 20 },
    reducers : {
        changeName(state){
            state.name = 'park'
        },
        increase(state, a){
            state.age += a.payload
        }
    }
})

export let { changeName,increase } = user.actions

export default user