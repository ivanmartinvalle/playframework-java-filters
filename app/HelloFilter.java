import play.api.mvc.RequestHeader;
import play.api.mvc.Result;

public class HelloFilter extends JavaFilter {

    @Override
    public Result Apply(Result currentResult, RequestHeader requestHeader) {
        if (requestHeader.headers().get("X-Filter").isDefined()) {
            ResultAdapter resultAdapter = new ResultAdapter(currentResult);
            return resultAdapter.WithHeader("X-Hello", "World!");
        }
        return currentResult;
    }
}