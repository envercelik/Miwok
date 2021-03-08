package com.envercelik.miwok

 class Word {

     val defaultTranslation: String
     val miwokTranslation: String
     var imageId: Int = 0
     var pronunciationId: Int = 0

     constructor(defaultTranslation: String, miwokTranslation: String) {

         this.defaultTranslation = defaultTranslation
         this.miwokTranslation = miwokTranslation
     }


     constructor(defaultTranslation: String, miwokTranslation: String,  pronunciationId: Int):this(defaultTranslation,miwokTranslation) {
         this.pronunciationId = pronunciationId
     }

     constructor(defaultTranslation: String, miwokTranslation: String,  imageId: Int,pronunciationId: Int):
             this(defaultTranslation,miwokTranslation,imageId) {
         this.pronunciationId = pronunciationId
     }


     fun hasImage():Boolean {
         return imageId != 0
     }

}
