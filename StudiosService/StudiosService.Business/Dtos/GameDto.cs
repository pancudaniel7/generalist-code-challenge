using StudiosService.Data.Models;

namespace StudiosService.Business.Dtos
{
    public class GameDto
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public double Rating { get; set; }

        public int StudioKey { get; set; }

        public string Content { get; set; }

        public static GameDto MapGameToDto(Game game)
        {
            return new GameDto
            {
                Id = game.Id,
                Name = game.Name,
                Content = game.Content,
                StudioKey = game.StudioKey,
                Rating = game.Rating
            };
        }
    }
}
