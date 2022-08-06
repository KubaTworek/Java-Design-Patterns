package pl.pjatk.Proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();

    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("whatever.com");
        bannedSites.add("nope.com");
        bannedSites.add("yup.com");
        bannedSites.add("hello.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception {
        if(bannedSites.contains(serverhost.toLowerCase())) {
            throw new Exception("Access denied");
        }

        internet.connectTo(serverhost);
    }
}
