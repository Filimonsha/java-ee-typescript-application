import {addHitInfoAtTable, addInitialInfoAtTable} from "./utils/elementsInteracion";
import axiosInstance from "../helpers/axios";
import {HITS_ROUTE} from "../helpers/const/routes";
import {resultTable} from "../helpers/const/elements";


export function testHit(x: number, y: number, r: number) {
    axiosInstance.post(HITS_ROUTE, {
        x,
        y,
        r
    }).then(res => {
            console.log("Ответ", res)
            res.data && addHitInfoAtTable(res.data, resultTable)
        })
}

export function getAllHits(){
    axiosInstance.get(HITS_ROUTE).then(res=>res.data && addInitialInfoAtTable(res.data,resultTable))
}

