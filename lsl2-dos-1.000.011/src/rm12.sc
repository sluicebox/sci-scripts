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

(local
	aStreet
	aFreeway1
	aFreeway2
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
		((View new:)
			view: 247
			loop: 0
			cel: 0
			posn: 152 30
			setPri: 0
			ignoreActors:
			addToPic:
		)
		((= aStreet (Prop new:))
			view: 247
			loop: 1
			cel: 0
			posn: 123 108
			setCycle: Fwd
			cycleSpeed: 4
			isExtra: 1
			init:
		)
		((= aFreeway1 (Prop new:))
			view: 247
			loop: 2
			cel: 1
			posn: 156 94
			setCycle: Fwd
			cycleSpeed: 1
			isExtra: 1
			init:
		)
		((= aFreeway2 (Prop new:))
			view: 247
			loop: 3
			posn: 220 74
			setCycle: Fwd
			cycleSpeed: 2
			isExtra: 1
			init:
		)
		(cond
			((== gPrevRoomNum 16)
				(gEgo posn: 230 188)
			)
			((== gPrevRoomNum 0)
				(gEgo posn: 230 188)
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

