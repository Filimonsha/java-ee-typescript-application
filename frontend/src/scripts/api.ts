import {addHitInfoAtTable} from "./utils/elementsInteracion";
import axiosInstance from "../helpers/axios";
import {POST_HIT_INFO_ROUTE} from "../helpers/const/routes";
import {resultTable} from "../helpers/const/elements";


export default function testHit(x: number, y: number, r: number) {

    axiosInstance.post(POST_HIT_INFO_ROUTE, {
        x,
        y,
        r
    }).then(res => {
            console.log("Ответ", res)
            addHitInfoAtTable(res.data, resultTable)
        })
}


