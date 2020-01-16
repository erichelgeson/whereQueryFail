package davetestentity

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        save()
    }
    def destroy = {
    }

    @Transactional
    void save() {
        def friend = new Friend(friendName: "Eric").save(flush: true)
        def dave = new User(name: "Dave", friend: friend).save(flush: true)
        println "bootstrapped"
    }
}
