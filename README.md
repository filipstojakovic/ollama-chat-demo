
## Running the Ollama Container

**Step 1: Start the container:**

To create the Ollama container, run the following command:

```bash
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
```

**Step 2: Connect to Ollama Container and Start Llama3 Model**

To connect to the Ollama container and start the `llama3` model, run the following command:

**Note:** If the model does not already exist in the container, it will be downloaded first. The model size is approximately 4-5GB, so the download may take some time.
```bash
docker exec -it ollama ollama run llama3
```

Step 3. **Test response with curl (or Postman)**

Once the download is complete and the model has started, you can test its response.

```bash
curl -X POST http://localhost:11434/api/generate -d '{
    "model": "llama3",
    "prompt": "Your awesome prompt"
    }'
```
