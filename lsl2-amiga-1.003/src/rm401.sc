;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm401 0
)

(local
	seenMessage
)

(instance rm401 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0100)
			(if (and (== seenMessage 0) (!= gCurrentStatus 21))
				(= seenMessage 1)
				(Print 401 0) ; "You have no desire to return to the ocean after all you went through on that lifeboat, Larry!"
			)
		else
			(= seenMessage 0)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'talk')
			(Print 401 1) ; "We're too busy recreating to talk to you, buddy."
		)
		(if (or (Said 'get/suntan') (Said 'lie<down'))
			(Print 401 2) ; "You got plenty of sun on that lifeboat."
		)
		(if (Said 'dig')
			(Print 401 3) ; "Yeah! You can dig it!"
			(Print 401 4 #at -1 130) ; "(But not here.)"
		)
		(if (Said '/umbrella')
			(Print 401 5) ; "The umbrellas are not important to your escape from this place."
		)
		(if (Said '/boulder')
			(Print 401 6) ; "The rocks will not help you."
		)
		(if (Said 'climb/palm')
			(Print 401 7) ; "If you did climb a tree, you'd just see the airport, and long even more for escape from this place, and your freedom. So... don't!"
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,cloud')
				(Print 401 8) ; "This sky could sunburn you in just a few seconds."
				(Print 401 9 #at -1 130) ; "(It's a good thing you rubbed on that SPF-90 earlier.)"
			)
			(if (Said '/children,man,woman')
				(Print 401 10) ; "Everyone here appears to be wearing even less clothing than you, Larry."
			)
			(if (Said '/lagoon,water,lagoon')
				(Print 401 11) ; "The ocean certainly looks peaceful, but after what you've been through in that lifeboat you have no desire to return to it for some time."
			)
			(if (Said '/beach,beach,carpet')
				(Print 401 12) ; "The hot sand burns your feet."
			)
			(if (Said '/palm,bush,bush')
				(Print 401 13) ; "Palm trees sway overhead, while tropical succulents suc away in the bushes."
			)
		)
	)
)

