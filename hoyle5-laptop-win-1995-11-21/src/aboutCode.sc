;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use File)
(use System)

(public
	aboutCode 0
)

(local
	local0
	local1
	local2
	local3
)

(instance aboutCode of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= temp0 (Str new: 500))
		(= temp1 (Str new: 500))
		(= temp2 (Str new: 100))
		(= local0 (Str new: 50))
		(= local1 (Str new: 50))
		(= local2 (Str new: 50))
		(= local3 (Str new: 50))
		(version doit:)
		(phone_txt doit:)
		(= global122 4)
		(Message msgGET 4 0 0 0 1 (temp1 data:)) ; "Hoyle Classic Games, Volume 5, will entertain the entire family. Whatever your favorite, you just might find it in Hoyle Classic Games. This latest in the Hoyle series includes eight card games (Poker, Bridge, Crazy Eights, Gin, Hearts, Old Maid, Cribbage, and Solitaire) and two board games (Backgammon and Checkers). What's more, Hoyle Classic Games provides opponents when you want to play, not when you can get four people to agree on a time and place. Note: the laptop version does not include Old Maid."
		(temp1 cat: local0)
		(if (Print addText: temp1 init:)
			(Message msgGET 4 0 0 0 2 (temp1 data:)) ; "Draw Poker is the new card in the Hoyle hand. You can ante, bet, fold, and bluff against characters with their own habits and quirks (developed especially for this edition of Hoyle). You can even change the atmosphere: customize the screen to set the game in the Old West, for example, without having to worry about cigar smoke and bullet holes in your living room."
			(if (Print addText: temp1 init:)
				(Message msgGET 4 0 0 0 3 (temp1 data:)) ; "Hoyle Classic Games also introduces the Attitude Meter: set the tone of the opposition, from serious to absurd. In serious mode you get intense opposition and good manners. In the absurd game you get sore losers and a breakdown in sportsmanship!"
				(if (Print addText: temp1 init:)
					(Message msgGET 4 0 0 0 4 (temp1 data:)) ; "Don't let conflicting schedules stop you. When you want to play backgammon you want to roll the dice now, not a week from Thursday. Hoyle Classic Games is just what the classic game player has been looking for."
					(temp1 cat: local1)
					(temp1 cat: {\n})
					(Message msgGET 4 0 0 0 19 (temp2 data:))
					(temp1 cat: temp2)
					(temp1 cat: local2)
					(if (Print addText: temp1 init:)
						(Message msgGET 4 0 0 0 5 (temp1 data:))
						(temp1 cat: local3)
						(if (Print addText: temp1 init:)
							(Message msgGET 4 0 0 0 8 (temp1 data:))
							(Message msgGET 4 0 0 0 7 (temp0 data:))
							(temp1 cat: temp0)
							(if (Print addText: temp1 init:)
								(Message msgGET 4 0 0 0 9 (temp1 data:))
								(Message msgGET 4 0 0 0 6 (temp0 data:))
								(temp1 cat: temp0)
								(if (Print addText: temp1 init:)
									(Message msgGET 4 0 0 0 12 (temp1 data:))
									(Message msgGET 4 0 0 0 13 (temp0 data:))
									(temp1 cat: temp0)
									(if (Print addText: temp1 init:)
										(Message msgGET 4 0 0 0 10 (temp1 data:))
										(Message msgGET 4 0 0 0 11 (temp0 data:))
										(temp1 cat: temp0)
										(if (Print addText: temp1 init:)
											(Message msgGET 4 0 0 0 14 (temp1 data:))
											(Message msgGET 4 0 0 0 15 (temp0 data:))
											(temp1 cat: temp0)
											(if (Print addText: temp1 init:)
												(Message
													msgGET
													4
													0
													0
													0
													16
													(temp1 data:)
												)
												(Message
													msgGET
													4
													0
													0
													0
													17
													(temp0 data:)
												)
												(temp1 cat: temp0)
												(Print addText: temp1 init:)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(temp0 dispose:)
		(temp1 dispose:)
		(temp2 dispose:)
		(local0 dispose:)
		(local1 dispose:)
		(local2 dispose:)
		(local3 dispose:)
		(= global122 1)
		(DisposeScript 4)
	)
)

(instance version of File
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (Str new: 50))
		(if (self open: 1)
			(self readString: temp0 6 close:)
			(Message msgGET 4 1 0 0 1 (local0 data:))
			(local0 cat: temp0)
		else
			(Message msgGET 4 2 0 0 1 (local0 data:))
		)
		(temp0 dispose:)
	)
)

(instance phone_txt of File
	(properties
		name {phone.txt}
	)

	(method (doit)
		(if (self open: 1)
			(self
				readString: local1 15
				readString: local2 15
				readString: local3 14
				close:
			)
		else
			(Message msgGET 4 0 0 0 20 (local1 data:))
			(Message msgGET 4 0 0 0 21 (local2 data:))
			(Message msgGET 4 0 0 0 22 (local3 data:))
		)
	)
)

