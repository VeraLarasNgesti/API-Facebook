import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/*

A simple Facebook4J client which
illustrates how to access group feeds / posts / comments.
@param args
@throws FacebookException
*/
public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("veralaras06@gmail.com", "laras2019");
// Get an access token from:
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAGCLkySMe4BAF45NimEw6QDKNgMTyrheFwqiXxoLZAYZClrZCkJakeFXJlRjTp0ZCxrO3p4uVbNpZBV7gbw2cYTs6h4esMQYJbzzbnj0Jztk8iaV4yupEi6PUomZCuZCv5Qj87Ios4E4K2pYj7heRksiBkHegsy13hijCVdBU6jTg3y4t4M2oinwMhQfYGWOHCz6by5WdRIh9bc3TaJAn2";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

ResponseList< Post > feeds = facebook.getFeed("108185607142541",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }
}
