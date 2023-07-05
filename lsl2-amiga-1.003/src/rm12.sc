;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm12 0
)

(instance rm12 of Rm
	(properties
		picture 12
		horizon 5
		east 13
		south 16
		west 11
	)

	(method (init)
		(Load rsVIEW 247)
		(super init:)
		(aView1 loop: 0 cel: 0 setPri: 0 ignoreActors: addToPic:)
		(aStreet loop: 1 cel: 0 setCycle: Fwd cycleSpeed: 4 isExtra: 1 init:)
		(aFreeway1 loop: 2 cel: 1 setCycle: Fwd cycleSpeed: 1 isExtra: 1 init:)
		(aFreeway2 loop: 3 setCycle: Fwd cycleSpeed: 2 isExtra: 1 init:)
		(cond
			((== gPrevRoomNum 16)
				(gEgo posn: 230 187)
			)
			((== gPrevRoomNum 0)
				(gEgo posn: 230 187)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm12Script) ; rm200
	)
)

(instance rm12Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/hill')
				(Print 12 0) ; "The Hollywood Hills are almost hidden by that smog."
			)
			(if (Said '/freeway,auto')
				(Print 12 1) ; "Traffic on the Hollywood Freeway is medium to moderate, but surface streets offer a reasonable alternative for commuters."
			)
			(if (Said '/building')
				(Print 12 2) ; "Busy show-biz execs chase secretaries on every floor."
			)
			(if (Said '[/angeles,sign,brick,fence,airport]')
				(Print 12 3) ; "You wonder what part of Los Angeles you are in now."
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 29
		x 152
		view 247
	)
)

(instance aStreet of Prop
	(properties
		y 107
		x 123
		view 247
	)
)

(instance aFreeway1 of Prop
	(properties
		y 93
		x 156
		view 247
	)
)

(instance aFreeway2 of Prop
	(properties
		y 73
		x 220
		view 247
	)
)

