import javax.net.ssl.*;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.Properties;

public class FileUpload {
    public static void main(String[] args) throws  Exception{

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(
                null,
                new TrustManager[]
                        {
                                new X509ExtendedTrustManager()
                                {
                                    public X509Certificate[] getAcceptedIssuers()
                                    {
                                        return null;
                                    }

                                    public void checkClientTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type)
                                    {
                                    }

                                    public void checkServerTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type)
                                    {
                                    }
                                    public void checkClientTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type,
                                            final Socket a_socket)
                                    {
                                    }
                                    public void checkServerTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type,
                                            final Socket a_socket)
                                    {
                                    }
                                    public void checkClientTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type,
                                            final SSLEngine a_engine)
                                    {
                                    }
                                    public void checkServerTrusted(
                                            final X509Certificate[] a_certificates,
                                            final String a_auth_type,
                                            final SSLEngine a_engine)
                                    {
                                    }
                                }
                        },
                null);


        String serviceUrl = "https://test.ultraamps.com/uaweb/openinv?user=quisitive-test&pass=qtest123";
        String fileName = "avaxml07132022163210.xml";

        Path file = Path.of("D:\\GitHub\\java_samples\\Java11HttpClient\\src\\main\\resources\\avaxml07132022163210.xml");

        Properties props = System.getProperties();
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(60* 1000))
                .sslContext(context) // SSL context 'sc' initialised as earlier
                //.sslParameters(parameters) // ssl parameters if overriden
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serviceUrl))
                .POST(HttpRequest.BodyPublishers.ofFile(file))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
    }
}
