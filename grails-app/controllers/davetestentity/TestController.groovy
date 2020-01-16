package davetestentity

import grails.converters.JSON
import grails.gorm.transactions.Transactional


class TestController {

    @Transactional
    def works() {
        def friend2 = Friend.first()
        def users
        Friend tmpFriend = friend2

        if (friend2) {
            users = User.where {
                friend.id == tmpFriend.id
            }.list()
        }
        render users as JSON
    }

    @Transactional // Remove me, exception goes away.
    def fails() {
        def friend = Friend.first()
        def users
        Friend tmpFriend = friend

        if (friend) {
            users = User.where {
                friend.id == tmpFriend.id // No signature of method: davetestentity.Friend.call() is applicable for argument types: (davetestentity.TestController$__tt__fails_closure4$_closure6) values: [davetestentity.TestController$__tt__fails_closure4$_closure6@5c16fc2a] Possible solutions: wait(), last(), save(), any(), getAll(), wait(long)
            }.list()
        }
        render users as JSON
    }
}
