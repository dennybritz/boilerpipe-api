This API wraps the Java [boilepipe library](https://code.google.com/p/boilerpipe/) into an HTTP API to extract raw text from HTML articles.

### Usage

There are two ways to use the API. You can either pass a URL or raw HTML:

```
curl -X POST http://localhost:3000/extract -H "Content-Type: application/json" -d '
  {
    "url": "http://techcrunch.com/2014/07/07/matterport-16m-dcm/"
  }
'

curl -X POST http://localhost:3000/extract -H "Content-Type: application/json" -d '
  {
    "html": "YOUR HTML CODE HERE"
  }
'
```

### Running

The easiest way to run the API is using Docker. A published version is available as `blikk/boilepipe-api` on Dockerhub.
