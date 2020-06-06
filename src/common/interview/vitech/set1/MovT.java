package common.interview.vitech.set1;

public class MovT {

	/*static String[] getMovieTitles(String substr) {
        List<String> ans = new ArrayList<>();
        String res;
        int tp = 2, p = 1;
        while (p <= tp) {
            try {
                URL url =
                        new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + p);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((res = reader.readLine()) != null) {
                    JsonObject json = new Gson().fromJson(res, JsonObject.class);
                    tp = json.get("total_pages").getAsInt();
                    JsonArray data = json.getAsJsonArray("data");
                    for (JsonElement d : data) {
                        String title = d.getAsJsonObject().get("Title").getAsString();
                        ans.add(title);
                    }
                }
                reader.close();
                p++;
            } catch (Exception ex) {
                //Nothing to log
            }
        }
        ans.sort(Comparator.naturalOrder());
        return ans.toArray(new String[0]);
    }*/
}
