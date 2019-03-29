package ch.hslu.ninopadrutt.vuzibladeprototype

class ListItemHolder {
    private var message: String = ""
    public var Message : String
        get() = this.message
        set(value) {
            this.message = value
        }

    private var machine: String = ""
    public var Machine : String
        get() = this.machine
        set(value) {
            this.machine = value
        }
}