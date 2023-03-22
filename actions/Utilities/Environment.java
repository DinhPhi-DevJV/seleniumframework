package Utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;;
@Sources({"file:environmentconfig/${evn}.properties"})
public interface Environment extends Config{
	@Key("App.Url")
	String ulr();
	@Key("App.User")
	String appUserName();
	@Key("App.Pass")
	String appPassWord();
	@Key("DB.Host")
	String databaseHostname();
	@Key("DB.User")
	String databaseUser();
	@Key("DB.Pass")
	String databasePassWord();
	

}
