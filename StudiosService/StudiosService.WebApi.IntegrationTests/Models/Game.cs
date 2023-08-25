namespace StudiosService.WebApi.IntegrationTests.Models
{
    public class Game
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public double Rating { get; set; }

        public int StudioKey { get; set; }

        public string Content { get; set; }

        public Game(string name, double rating, int studioKey, string content)
        {
            Name = name;
            Rating = rating;
            StudioKey = studioKey;
            Content = content;
        }
    }
}
