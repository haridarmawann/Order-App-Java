package orderapp.orderapp.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void saveFile(MultipartFile file, String filename, String savepath);

	void deleteFile(String filepath) throws IOException;

	void store(MultipartFile file);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

//	void deleteAll();

	void init();
}
