;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use System)

(public
	rm152 0
)

(instance theSound of Sound
	(properties
		number 6
	)
)

(instance rm152 of Rm
	(properties
		picture 152
		style 4
		horizon 1
	)

	(method (init)
		(super init:)
		(self setScript: rm152Script)
		(HandsOff)
		(gEgo posn: 99 1099)
		(if (== gCurrentStatus 16)
			(Load rsSOUND 4)
			(theSound number: 4 play:)
		else
			(Load rsSOUND 6)
			(theSound play:)
		)
	)
)

(instance rm152Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 0)
			(ShakeScreen 1 (Random 1 3))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(cond
					((== gCurrentStatus 15)
						(= gCurrentStatus 1001)
						(Print 152 0) ; "The next time you make a Molotov cocktail, why not try using a wick?!"
					)
					((== gCurrentStatus 14)
						(= gCurrentStatus 1001)
						(Print 152 1 #at -1 130) ; "(No one has ever accused you of having a long fuse, Larry!)"
					)
					((== gCurrentStatus 16)
						(= gCurrentStatus 1001)
						(Print 152 2) ; "The volcano eruption has interrupted your wedding plans in a most insistent manner! Perhaps this is one time you'll require outside assistance?"
					)
					((== gCurrentStatus 7)
						(if (== (theSound state:) 3)
							(-- state)
							(= cycles 3)
						else
							(= gBombStatus 2)
							(gCurRoom newRoom: 52)
						)
					)
					((== gCurrentStatus 17)
						(= gCurrentStatus 1001)
						(Print 152 3) ; "Next time, you'd better read the label on that bottle of hair rejuvenator!"
					)
					(else
						(= gCurrentStatus 1001)
						(Print 152 4) ; "Oops. You're dead."
					)
				)
			)
		)
	)
)

