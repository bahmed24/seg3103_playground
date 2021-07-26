defmodule Grades.Calculator do
  # percentage_grade Stub
  #
  # returns a random percentage value
  def percentage_grade(marks) do
    :rand.uniform(100)
  end

  # letter_grade Stub
  #
  # returns a random letter grade from the list below
  def letter_grade(marks) do
    Enum.random(["A+", "A", "A-","B+","B","C+","C","D+","D","EIN","F"])
    end

  # numeric_grade Stub
  #
  # returns a random numeric value between 0 and 10
  def numeric_grade(marks) do
    :rand.uniform(10)
  end
end