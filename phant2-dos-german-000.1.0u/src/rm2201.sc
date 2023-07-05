;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42201)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)
(use Cel)

(public
	rm2201 0
)

(instance rm2201 of P2Room
	(properties
		picture 2201
		north 42200
		south 42200
		east 42200
		west 42200
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 1007)
			(ClearFlag 1007)
			(proc63002_7 10400)
		)
		(alienF init: 400 130 540 300)
		(alien init: setPri: 1000)
		(food init:)
		(gGame handsOn: 1)
	)
)

(instance alien of P2Fidget
	(properties
		x 347
		y 130
		view 2201
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance alienF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(alien hide:)
			(alien setScript: delayIt)
		)
	)
)

(instance delayIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo get: 35) ; electricAlienI
				(SetFlag 721)
				(gCurRoom newRoom: 42200)
			)
		)
	)
)

(instance food of Cel
	(properties
		x 88
		y 140
		view 2201
		loop 1
	)
)

