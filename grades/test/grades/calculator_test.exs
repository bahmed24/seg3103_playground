defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    test "percentage_grade_test1" do
      assert 0 ==
               Calculator.percentage_grade(%{
                 homework: [0],
                 labs: [0, 0, 0],
                 midterm: 0,
                 final: 0
               })
    end
  end

  describe "percentage_grade/2" do
    test "percentage_grade_test2" do
      assert 100 ==
               Calculator.percentage_grade(%{
                 homework: [1],
                 labs: [1, 1, 1],
                 midterm: 1,
                 final: 1
               })
    end
  end

  describe "percentage_grade/3" do
    test "percentage_grade_test3" do
      assert 0 ==
               Calculator.percentage_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 0,
                 final: 0
               })
    end
  end

  describe "letter_grade/1" do
    test "letter_grade_test1" do
      assert "EIN" ==
               Calculator.letter_grade(%{
                 homework: [0],
                 labs: [0, 0, 0],
                 midterm: 0,
                 final: 0
               })
    end
  end

  describe "letter_grade/2" do
    test "letter_grade_test2" do
      assert "A+" ==
               Calculator.letter_grade(%{
                 homework: [1],
                 labs: [1, 1, 1],
                 midterm: 1,
                 final: 1
               })
    end
  end

    describe "letter_grade/3" do
    test "letter_grade_test3" do
      assert "E" ==
               Calculator.letter_grade(%{
                 homework: [0.5],
                 labs: [0.5, 0.5, 0.5],
                 midterm: 0.4,
                 final: 0.4
               })
    end
  end

  describe "letter_grade/4" do
    test "letter_grade_test4" do
      assert "EIN" ==
               Calculator.letter_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 0.40,
                 final: 0.40
               })
    end
  end


  describe "numeric_grade/1" do
    test "numeric_grade_test1" do
      assert 0 ==
               Calculator.numeric_grade(%{
                 homework: [0],
                 labs: [0, 0, 0],
                 midterm: 0,
                 final: 0
               })
    end
  end

  describe "numeric_grade/2" do
    test "numeric_grade_test2" do
      assert 10 ==
               Calculator.numeric_grade(%{
                 homework: [1],
                 labs: [1, 1, 1],
                 midterm: 1,
                 final: 1
               })
    end
  end

  describe "numeric_grade/3" do
    test "numeric_grade_test3" do
      assert 1 ==
               Calculator.numeric_grade(%{
                 homework: [0.5],
                 labs: [0.5, 0.5, 0.5],
                 midterm: 0.4,
                 final: 0.4
               })
    end
  end

  describe "numeric_grade/4" do
    test "numeric_grade_test4" do
      assert 0 ==
               Calculator.numeric_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 0.4,
                 final: 0.4
               })
    end
  end
end

