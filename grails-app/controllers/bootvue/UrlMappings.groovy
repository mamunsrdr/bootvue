package bootvue

class UrlMappings {

    static mappings = {
        "/"(uri: "/index.html")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
