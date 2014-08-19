@Grab('org.eclipse.jetty.aggregate:jetty-all:9.2.+')
import org.eclipse.jetty.servlet.ServletContextHandler
import groovy.servlet.GroovyServlet
import org.eclipse.jetty.server.Server

def SERVER_PORT = 8094
def context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
context.with {
    contextPath = '/'
    resourceBase = 'src'
    addServlet(GroovyServlet, '*.groovy')
}

def server = new Server(SERVER_PORT)
server.with {
    setHandler(context)
    start()
}
