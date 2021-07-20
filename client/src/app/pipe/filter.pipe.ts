import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

   /**
   * Transform
   *
   * @param {any[]} items
   * @param {string} filterText
   * @returns {any[]}
   */
   transform(items: any[], filterText: string): any {
    // return list ? list.filter(item => item.lastName.search(new RegExp(filterText, 'i')) > -1) : [];
    if(!items) return [];
    if(!filterText) return items;
    return items ? items.filter(item => item.name.toLowerCase().search(filterText.toLowerCase()) > -1) : [];
  }

}
