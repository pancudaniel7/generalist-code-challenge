using System.Reflection;
using System.Text;
using CSharpFunctionalExtensions;

namespace StudiosService.WebApi.IntegrationTests
{
    public static class FileHelperComponent
    {
        public static Result<string> ExtractStringContentFromFile(Assembly fileAssembly, string filePath)
        {
            var deleteScriptStream = fileAssembly.GetManifestResourceStream(filePath);

            if (deleteScriptStream == null)
            {
                return Result.Failure<string>("The stream could not be read");
            }

            var sqlCommand = ConvertStreamToString(deleteScriptStream);

            return sqlCommand;
        }

        private static string ConvertStreamToString(Stream fileStream)
        {
            fileStream.Position = 0;
            using var reader = new StreamReader(fileStream, Encoding.UTF8);
            return reader.ReadToEnd();
        }
    }
}
