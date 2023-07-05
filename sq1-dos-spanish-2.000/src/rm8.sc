;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use eRS)
(use Elevator)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)

(public
	rm8 0
)

(instance rm8 of SQRoom
	(properties
		lookStr {This is a section of one of the lower levels of Arcada.}
		picture 8
		east 9
	)

	(method (init)
		(Load rsVIEW 108)
		(self setRegions: 700) ; arcadaRegion
		(= global166 2)
		(monitor setCycle: Fwd init:)
		(dials setCycle: Fwd init:)
		(= style (if (== gPrevRoomNum 9) 11 else 10))
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 119 262 93 244 100 220 103 210 101 195 106 186 103 178 101 169 112 155 115 149 96 135 96 138 112 131 117 119 112 86 123 62 120 58 131 27 132 27 158 123 186 319 186 319 189 0 189 0 0 319 0
					yourself:
				)
		)
		(gEgo init:)
		(super init:)
		(gFeatures
			add: pipes conduit thing1 thing2 mouseThing
			eachElementDo: #init
		)
		(door exiting: (!= gPrevRoomNum 9) light: elevatorLight init: whereTo: 4)
		(if (!= gPrevRoomNum 4)
			(HandsOn)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((door inFront:)
				(door open:)
			)
		)
		(super doit:)
	)

	(method (notify)
		(if (== gPrevRoomNum 4)
			(HandsOff)
		)
	)
)

(instance elevatorLight of View
	(properties
		description {elevator light}
		sightAngle 45
		lookStr {This elevator must go up.}
		view 108
		loop 1
	)
)

(instance door of Elevator
	(properties
		x 144
		y 111
		description {elevator}
		sightAngle 45
		lookStr {This is one way to change your altitude.}
		view 108
		level 2
	)
)

(instance monitor of Prop
	(properties
		x 91
		y 90
		description {monitor}
		sightAngle 45
		lookStr {This monitor gives a readout about the ship's status. Only the lab scientist really knows... er... knew exactly what it monitored.}
		view 108
		loop 3
		signal 16400
		cycleSpeed 7
		detailLevel 2
	)
)

(instance dials of Prop
	(properties
		x 235
		y 81
		description {lights}
		sightAngle 45
		lookStr {A pair of viewing ports protrude from the materials testing device.}
		view 108
		loop 2
		signal 16400
		cycleSpeed 8
		detailLevel 2
	)
)

(instance pipes of Feature
	(properties
		description {pipes}
		sightAngle 45
		onMeCheck 2
		lookStr {Pipes whose purpose is known only to the architect wrap around the upper back of the room.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance conduit of Feature
	(properties
		description {conduit}
		sightAngle 45
		onMeCheck 4
		lookStr {A designer conduit system runs through here. It carries the ventilation ducting as well as different types of wiring.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance thing1 of Feature
	(properties
		description {thing in foreground}
		sightAngle 45
		onMeCheck 8
		lookStr {It appears to be some sort of wiring harness. You never cared much for electrical hardware.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance thing2 of Feature
	(properties
		description {round thing}
		sightAngle 45
		onMeCheck 16
		lookStr {Who knows what this is.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance mouseThing of Feature
	(properties
		x 225
		y 76
		nsTop 55
		nsLeft 198
		nsBottom 97
		nsRight 252
		description {mouse thing}
		sightAngle 45
		onMeCheck 64
		lookStr {This interesting device was used to test materials early in the project.}
	)
)

