import {formattedDate} from "./formateDate";
import {HitInfo} from "../../helpers/types/api";

export const addHitInfoAtTable = (hitInfo: HitInfo, table: Element) => {

    const newElementOfTable = `
      <tr style='text-align: center;outline:1px solid black;'>
      <td>${hitInfo.hitX}</td>
      <td>${hitInfo.hitY}</td>
      <td>${hitInfo.hitR}</td>
      <td>${hitInfo.areaHit}</td>
      <td>${formattedDate(hitInfo.hitCurrentTime)}</td>
      <td>${hitInfo.hitExecutionTime} ms</td>
    </tr>`

    table.insertAdjacentHTML('afterbegin', newElementOfTable)
}

export const addInitialInfoAtTable = (listOfHits: Array<HitInfo>,table: Element) => {

    const listOfTableFormatHits = listOfHits.map(hit => `
      <tr style='text-align: center;outline:1px solid black;'>
      <td>${hit.hitX}</td>
      <td>${hit.hitY}</td>
      <td>${hit.hitR}</td>
      <td>${hit.areaHit}</td>
      <td>${formattedDate(hit.hitCurrentTime)}</td>
      <td>${hit.hitExecutionTime} ms</td>
    </tr>`)
    listOfTableFormatHits.forEach(tableHit=>table.insertAdjacentHTML('afterbegin',tableHit))
}