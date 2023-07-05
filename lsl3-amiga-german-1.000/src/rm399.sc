;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 399)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm399 0
)

(instance rm399 of Locale
	(properties)

	(method (init)
		(super init:)
		(if (not (OneOf gPrevRoomNum 360 370 375 380 390))
			(gMusic number: 399 loop: gBgMusicLoops play:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'look,look<down') (Said '/carpet'))
				(Print 399 0) ; "Fat City's floor is covered with dried sweat droplets."
			)
			((Said 'look,look/card,membership,keycard[<membership]')
				(if (gEgo has: 9) ; Spa_Keycard
					(event claimed: 0)
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'look,look/(ceiling,up)')
				(Print 399 1) ; "Fat City's ceiling is the same color as their old gym towels."
			)
			((Said '/wall')
				(Print 399 2) ; "The walls here are nearly vertical."
			)
			((Said '/door')
				(Printf 399 3 gEgoName gEgoName) ; "Yes, Fat City does have doors, %s."
			)
		)
	)
)

