package me.flyness.groovy.overview.mop

/**
 * Created by lizhitao on 2018/5/2.
 */
class Friend {
    def listen() {
        "$name is listening as a friend"
    }
}

@Mixin(Friend)
class Person3 {
    String firstName
    String lastName

    String getName() { "$firstName $lastName" }
}

john = new Person3(firstName: "john", lastName: "Smith")
println john.listen()

class Dog {
    String name
}

Dog.mixin Friend
buddy = new Dog(name: "Buddy")
println buddy.listen()