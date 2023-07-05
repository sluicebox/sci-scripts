;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 511)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	showRules 0
)

(local
	local0
	local1
	local2
	local3
)

(instance showRules of Code
	(properties)

	(method (doit)
		(= local2 (gSystemWindow color:))
		(= local3 (gSystemWindow back:))
		(gSystemWindow color: 24 back: 28)
		(= local0 0)
		(while (!= local0 14)
			(switch local0
				(0
					(Format @global550 511 0) ; "The object of Yacht is to score as high of a score as possible in each of the twelve individual categories, thus scoring the highest possible total score."
				)
				(1
					(Format @global550 511 1) ; "Each Player's turn consists of a maximum of three rolls. After the third roll, a category must be selected in which to score the turn. Players may, however, choose to score the turn after only one or two rolls if desired. A category may only be used once each game."
				)
				(2
					(Format @global550 511 2) ; "If the Option `LOCK ON SELECTION' is ON, the player must lock in a category to roll for after the first roll. The selection may not be changed after rolling the second time in the turn. If OFF, a player may change their mind as often as desired."
				)
				(3
					(Format @global550 511 3) ; "After rolling the dice each time, the player may decide to keep any of the dice and roll only the dice wanted on subsequent rolls. Dice kept on a previous roll may also be rolled on later rolls."
				)
				(4
					(Format @global550 511 4) ; "There are twelve categories as follows: Ones, Twos, Threes, Fours, Fives, Sixes, Four of a Kind, Full House, Small Straight, Large Straight, Yacht, and Choice."
				)
				(5
					(Format @global550 511 5) ; "Ones, Twos, Threes, Fours, Fives, and Sixes score as follows: Add up all dice with the specific number being tried for only."
				)
				(6
					(Format @global550 511 6) ; "Example: If the Dice are 3 3 5 6 6, you could score 6 points in the Threes category, or 5 pts in the Fives category, 12 Points in the Sixes category, or even 0 points in any of the other categories."
				)
				(7
					(Format @global550 511 7) ; "Four of a Kind: When four of the five dice (or even all five) are the same, you may score in this category. Add up the total of all five dice. Example: 4 4 4 4 6 would score 22 points."
				)
				(8
					(Format @global550 511 8) ; "Full House: A Full House is three of a kind of one number, and a pair of a different number. Add up the total of all five dice. Example: 3 3 3 6 6 would score 21 points."
				)
				(9
					(Format @global550 511 9) ; "Small Straight: A Small Straight may be scored when four of the five dice are in sequential order. Small Straights score 25 points."
				)
				(10
					(Format @global550 511 10) ; "Examples: 1 2 3 4 4, 2 3 4 5 2, 2 3 4 5 6 are all Small Straights. Note: 2 3 4 5 6 is also a Large Straight but may be scored in Small Straight if desired."
				)
				(11
					(Format @global550 511 11) ; "Large Straight: A Large Straight may be scored when all five dice form a sequence five long. A Large Straight scores 30 points. Examples: 1 2 3 4 5, and 2 3 4 5 6 are the only 2 possible Large Straights."
				)
				(12
					(Format @global550 511 12) ; "Yacht: A Yacht may be scored when all five dice have the same numbers. A Yacht scores 50 points. Example: 1 1 1 1 1."
				)
				(13
					(Format @global550 511 13) ; "Choice: Choice may be scored no matter what combination of numbers are on the dice. It scores the total of all five dice. Example: 4 4 5 6 6 totals 25 points. Choice is useful when no other category fits the numbers on the dice."
				)
			)
			(cond
				((== local0 0)
					(= local1
						(Print
							@global550
							81
							{Next}
							2
							81
							{   Cancel    }
							0
							70
							250
							1
						)
					)
				)
				((== local0 13)
					(= local1
						(Print @global550 81 {Prev} 1 81 {Cancel} 0 70 250 1)
					)
				)
				(else
					(= local1
						(Print
							@global550
							81
							{Next}
							2
							81
							{Prev}
							1
							81
							{Cancel}
							0
							70
							250
							1
						)
					)
				)
			)
			(switch local1
				(0
					(= local0 14)
				)
				(1
					(if (< (-= local0 1) 0)
						(= local0 0)
					)
				)
				(2
					(+= local0 1)
				)
			)
		)
		(gSystemWindow color: local2 back: local3)
		(DisposeScript 511)
	)
)

