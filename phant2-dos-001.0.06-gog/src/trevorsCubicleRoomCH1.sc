;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4101)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	trevorsCubicleRoomCH1 0
)

(instance trevorsCubicleRoomCH1 of P2Room
	(properties
		picture 240
		south 3331
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= global241 60)
		(if (and (not (IsFlag 70)) (IsFlag 39))
			(trevorProp init: setPri: 1)
			(trevor init: whoDoit: trevorCode)
		else
			(= picture 241)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance trevorProp of P2Fidget
	(properties
		x 178
		y 337
		view 12400
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(trevor handleEvent: &rest)
	)
)

(instance trevor of P2Feature
	(properties
		priority 2
		readyFlag 39
	)

	(method (onMe)
		(return (trevorProp onMe: &rest))
	)

	(method (init)
		(if (super init: &rest)
			(if (not (IsFlag 40))
				(self addVerb: 9)
			)
			(if (not (IsFlag 41))
				(self addVerb: 10)
			)
			(if (not (IsFlag 42))
				(self addVerb: 11)
			)
			(if (not (IsFlag 43))
				(self addVerb: 6)
			)
			(if (and (IsFlag 45) (not (IsFlag 44)))
				(self addVerb: 13)
			)
			(maybeDeleteDoVerbCode doit:)
		)
	)
)

(instance trevorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(9 ; parentPhotoI
				(if (not (SetFlag 40))
					(proc63002_7 3550)
					(trevor delVerb: 9)
				)
			)
			(10 ; xmasPhotoI
				(if (not (SetFlag 41))
					(proc63002_7 3560)
					(trevor delVerb: 10)
				)
			)
			(11 ; sexyCardI
				(if (not (SetFlag 42))
					(proc63002_7 3570)
					(trevor delVerb: 11)
				)
			)
			(6 ; cardKeyI
				(if (not (SetFlag 43))
					(proc63002_7 4110)
					(trevor delVerb: 6)
				)
			)
			(13 ; harburgCardI
				(if (and (IsFlag 45) (not (SetFlag 44)))
					(proc63002_7 4150)
					(trevor delVerb: 13)
				)
			)
			(else
				(cond
					((IsFlag 26)
						(cond
							((IsFlag 46)
								(cond
									((not (SetFlag 45))
										(= global209 3980)
										(gRoboGary stop: 1)
										(gCurRoom newRoom: 7001) ; dreamingTreeRoomCH1
									)
									(
										(and
											(IsFlag 47)
											(not (SetFlag 48))
										)
										(proc63002_7 3520)
									)
								)
							)
							((not (SetFlag 49))
								(proc63002_7 3460)
							)
						)
					)
					((and (IsFlag 47) (not (SetFlag 48)))
						(proc63002_7 3520)
					)
					((not (proc63002_3 52 26))
						(SetFlag 52)
						(proc63002_7 3440)
					)
				)
				(maybeDeleteDoVerbCode doit:)
			)
		)
	)
)

(instance maybeDeleteDoVerbCode of Code
	(properties)

	(method (doit)
		(if
			(or
				(and
					(IsFlag 26)
					(or
						(and
							(IsFlag 46)
							(IsFlag 45)
							(or (IsFlag 48) (not (IsFlag 47)))
						)
						(and (not (IsFlag 46)) (proc63002_4 49))
					)
				)
				(and
					(not (IsFlag 26))
					(IsFlag 52)
					(or (IsFlag 48) (not (IsFlag 47)))
				)
			)
			(trevor delVerb: 4)
		)
	)
)

