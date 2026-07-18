package com.prectisPerojectJava21.java_21.sealedClasses;

public sealed class Animal permits Dog, Cat {

}

//final class Dog extends Animal {
//
//}

final class Cat extends Animal {

}


non-sealed class Dog extends Animal {

}

class Labrador extends Dog { } // ✅ Allowed
class Pug extends Dog { }      // ✅ Allowed
