;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1213)
(include sci.sh)
(use Main)
(use CloseUpFork)
(use Polygon)
(use Sound)
(use Motion)
(use System)

(public
	cuCutter 0
)

(instance cuCutter of CloseUpFork
	(properties
		animSnd 20007
	)

	(method (init)
		(super init: &rest)
		(Trigger
			client: self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 141 186 144 186 150 180 154 175 150 175 145
					yourself:
				)
		)
		(gMouseDownHandler addToFront: Trigger)
	)

	(method (dispose)
		(gMouseDownHandler delete: Trigger)
		(Trigger client: 0 setPolygon:)
		(super dispose: &rest)
	)

	(method (start)
		(self setScript: nathanKeepYourFingersOut)
	)
)

(instance nathanKeepYourFingersOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(client view: 20540 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(whack number: 20007 setVol: 127 play: self)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client view: 20539 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance whack of Sound
	(properties
		flags 5
	)
)

