;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm300 0
)

(instance rm300 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gCurrentTimer 3)
				(not gRgTimer)
				(!= gCurRoomNum 38)
				(!= gCurRoomNum 31)
				(!= gCurRoomNum 131)
				(!= gCurRoomNum 138)
				(> gSecondsInRoom 5)
				(== gCurrentStatus 0)
			)
			(= gCurrentStatus 1001)
			(= gCurrentTimer 0)
			(Print 300 0) ; "The ship's PA system crackles to life, "We are sorry, ladies and gentlemen, but due to unknown reasons our lifeboats have inadvertently been lowered into the water. We regret this inconvenience.""
			(Print 300 1) ; "You just missed your last chance at escape!"
			(Print 300 2) ; "The next time you start something, you'd better be prepared to finish it!"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((and (gEgo has: 11) (Said 'eat,apply/basket')) ; Fruit
				(Print 300 3) ; "Ok. You feel refreshed, but fruitless."
				(gEgo put: 11 -1) ; Fruit
				(gGame changeScore: -2)
			)
			((and (gEgo has: 13) (Said 'eat,apply/bread')) ; Spinach_Dip
				(Print 300 4) ; "Ok. You rapidly glom down a quart of spinach dip and a whole loaf of sourdough bread."
				(gEgo put: 13 -1) ; Spinach_Dip
				(gGame changeScore: -5)
			)
			((and (gEgo has: 14) (Said 'wear,apply,(drop<on)/wig')) ; Wig
				(NotNow) ; "Not now!"
			)
			((and (gEgo has: 12) (Said 'sew,fix,apply/kit')) ; Sewing_Kit
				(Print 300 5) ; "You have nothing which needs mending."
			)
			(
				(and
					(gEgo has: 9) ; Sunscreen
					(Said 'wear,caress,drop,apply/lotion,(lotion<suntan)')
				)
				(cond
					((!= gCurrentEgoView 132)
						(Print 300 6) ; "You apply the sunscreen to your neck and hands."
						(= gWearingSunscreen 3)
						(if (not gScoredWoreSunscreen)
							(= gScoredWoreSunscreen 1)
							(gGame changeScore: 1)
						)
					)
					((== gWearingSunscreen 2)
						(Print 300 7) ; "You are clever to reapply the sunscreen after your swim washed it off!"
						(= gWearingSunscreen 1)
						(if (not gReappliedSunscreen)
							(= gReappliedSunscreen 1)
							(gGame changeScore: 3)
						)
					)
					(else
						(Print 300 8) ; "Ok. You carefully rub the sunscreen over every exposed part of your body."
						(= gWearingSunscreen 1)
						(if (not gScoredWoreSunscreen)
							(= gScoredWoreSunscreen 1)
							(gGame changeScore: 3)
						)
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '/cup,down,cup,lagoon,water')
						(Print 300 9) ; "You look to sea to see what you can see, but soon you see that all you can see is sea."
					)
					((Said '/up,overhead,cloud')
						(Print 300 10) ; "The bright tropical sun smiles down from an azure sky. Ah! There's nothing like a sea voyage to freshen the lungs of a lounge lizard!"
					)
					((Said '[/craft,cloud]')
						(Print 300 11) ; "Scud scuds past the ship, messing up an otherwise clear blue sky."
					)
					((Said '/children,man,woman')
						(Print 300 12) ; "Everyone here ALSO has a better tan than you, Larry."
					)
					((Said '/carpet,carpet,deck')
						(Print 300 13) ; "Sway."
						(Print 300 13) ; "Sway."
						(Print 300 13) ; "Sway."
					)
					((Said '/palm,bush,bush')
						(Print 300 14) ; "Where?"
					)
				)
			)
		)
	)
)

