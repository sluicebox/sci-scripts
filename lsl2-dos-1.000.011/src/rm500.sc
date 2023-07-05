;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm500 0
)

(instance rm500 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gCurrentTimer 4)
				(not gRgTimer)
				(!= gCurRoomNum 57)
				(> gSecondsInRoom 5)
				(or (== gCurrentStatus 0) (== gCurrentStatus 8))
			)
			(= gCurrentStatus 1001)
			(= gCurrentTimer 0)
			(Print 500 0) ; "The airport's PA system crackles to life, "Ladies and gentlemen, we are pleased to announce the departure of Flight #1 from Gate #1. Thank you."
			(Print 500 1) ; "Way to go, Larry. You just missed your last chance at escape from this place!"
			(Print 500 2) ; "The next time you buy a airplane ticket, you'd better hotfoot it to Gate #1!"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (gEgo has: 24) (Said '(drop<on),apply,wear/parachute')) ; Parachute
			(Print 500 3) ; "Not yet!"
		)
		(if (and (gEgo has: 25) (Said 'wear,drop,apply/bobbypin')) ; Bobby_Pin
			(Print 500 4) ; "You'd wear the bobby pin if you just had the hair!"
		)
		(if (and (gEgo has: 26) (Said '(look<in),look/pamphlet')) ; Pamphlet
			(Print 500 5) ; "Repent!"
			(Print 500 6) ; "And send money."
		)
		(if (and (gEgo has: 23) (Said 'look<in/ticket<airline')) ; Airline_Ticket
			(Print 500 7) ; "It says "Your flight is about to leave!""
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,ceiling')
				(Print 500 8) ; "Looking up, your mind wanders home to your beloved collection of asbestos ceiling tiles!"
			)
			(if (Said '/art')
				(Print 500 9) ; "For such a primitive country, they have an appreciation for art."
			)
			(if (Said '/children,man,woman')
				(Print 500 10) ; "They look like they're going someplace."
			)
			(if (Said '/airline')
				(Print 500 11) ; "They have a lot of air traffic here for such a small airport."
			)
			(if (Said '/brick')
				(Print 500 12) ; "For a small, tropical, resort airport they certainly have a lot of public artwork."
			)
		)
	)
)

