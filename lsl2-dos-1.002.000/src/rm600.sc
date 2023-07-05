;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm600 0
)

(instance rm600 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gCurrentTimer 5)
				(not gRgTimer)
				(> gSecondsInRoom 5)
				(== gCurrentStatus 0)
			)
			(= gCurrentStatus 1001)
			(= gCurrentTimer 0)
			(gEgo hide:)
			(Print 600 0 #draw) ; "The airplane comes to an abrupt landing, without you in your seat!"
			(Print 600 1) ; "You suffer major injuries, too numerous to mention here. Next time, listen to your pilot!"
		)
		(if (and (== gCurrentTimer 5) (== gRgTimer 300))
			(-- gRgTimer)
			(Print 600 2) ; "The airplane's PA system crackles to life, "Ladies and gentlemen, we are approaching our destination. Please return to your seat, fasten your seatbelt, and return your tray table to its upright and fully locked position. Thank you.""
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (gEgo has: 24) (Said '(drop<on),apply,wear/parachute')) ; Parachute
			(Print 600 3) ; "Not yet!"
		)
		(if (and (gEgo has: 25) (Said 'wear,drop,apply/bobbypin')) ; Bobby_Pin
			(Print 600 4) ; "You'd wear the bobby pin if you just had the hair!"
		)
		(if (and (gEgo has: 26) (Said '(look<in),look/pamphlet')) ; Pamphlet
			(Print 600 5) ; "Repent!"
			(Print 600 6) ; "And send money."
		)
		(if (and (gEgo has: 27) (or (Said 'barf') (Said 'apply/bag'))) ; Airsick_Bag
			(Ok) ; "Ok."
			(Print 600 7) ; "You do so and immediately discard the now-soiled airsick bag."
			(gEgo put: 27 -1) ; Airsick_Bag
			(gGame changeScore: -2)
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,ceiling')
				(Print 600 8) ; "The ceiling is overhead."
			)
			(if (Said '/woman')
				(Print 600 9) ; "In spite of her sarcastic introduction, you think you are in love again!"
			)
			(if (Said '/barstool')
				(if (== gCurrentStatus 1009)
					(Print 600 10) ; "The guy behind you has stuffed his carry on bag under your seat, and he doesn't want you to muck with it!"
				else
					(Print 600 11) ; "It's difficult to see the bottom of your trousers in your current position!"
				)
			)
			(if (Said '[/airport]')
				(Print 600 12) ; "From your current viewpoint, you can only see sky."
			)
		)
		(if (Said 'talk,talk/woman')
			(Print 600 13) ; "She can't help you solve this flight!"
		)
		(if (Said 'carry,caress,caress/woman')
			(Print 600 14) ; "Whee!"
		)
		(if (Said 'talk/children,man')
			(if (Random 0 1)
				(Print (Format @gString 600 15 gLaffer)) ; "You proudly announce, %s"
				(Print 600 16) ; "They're underwhelmed!"
			else
				(Print 600 17) ; "All businessmen look alike to you."
			)
		)
	)
)

