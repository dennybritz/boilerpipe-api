This API wraps the Java [boilerpipe library](https://code.google.com/p/boilerpipe/) into an HTTP API to extract raw article text from HTML pages.

### Usage

There are two ways to use the API. You can either pass a url or raw html:

```bash
curl -X POST http://localhost:3000/extract -H "Content-Type: application/json" -d '
  {
    "url": "http://techcrunch.com/2014/07/07/matterport-16m-dcm/"
  }
'
```

```bash
curl -X POST http://localhost:3000/extract -H "Content-Type: application/json" -d '
  {
    "html": "YOUR HTML CODE HERE"
  }
'
```

### Running

The easiest way to run the API is using Docker. A published version is available as `blikk/boilerpipe-api` on Dockerhub.
