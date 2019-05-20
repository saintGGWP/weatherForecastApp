import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Demo3SharedLibsModule, Demo3SharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [Demo3SharedLibsModule, Demo3SharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [Demo3SharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Demo3SharedModule {
  static forRoot() {
    return {
      ngModule: Demo3SharedModule
    };
  }
}
