using System.ComponentModel.DataAnnotations;

namespace StudiosService.Infrastructure.Utils
{
    public static class RandomGenerator
    {
        private static readonly Random Random = new();

        public static double GenerateRandomNumberBetween(double minimumValue, double maximumValue)
        {
            var next = Random.NextDouble();
            var valueInsideInterval = minimumValue + next * (maximumValue - minimumValue);
            var valueInsideIntervalRounded = Math.Round(valueInsideInterval, 1, MidpointRounding.AwayFromZero);

            return valueInsideIntervalRounded;
        }

        public static int GenerateRandomIndexLessThan(int maximumValue)
        {
            return Random.Next(maximumValue);
        }
    }
}
