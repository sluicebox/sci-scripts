;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use Polygon)
(use Motion)
(use System)

(public
	rm321 0
)

(procedure (localproc_0)
	(gCurRoom
		addObstacle:
			((Polygon new:) type: PContainedAccess init: 217 189 171 76 0 76 0 189 yourself:)
	)
	(easternCliffs init:)
)

(procedure (localproc_1)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PContainedAccess
				init: 319 189 319 75 138 75 181 189
				yourself:
			)
	)
	(westernCliffs init:)
)

(instance rm321 of EcoRoom
	(properties
		picture 320
		style -32759
		horizon 118
		north 322
		south 320
		lookStr 2
	)

	(method (init)
		(= global250 1)
		(NormalEgo)
		(gEgo init: ignoreHorizon: 1)
		((gEgo cycler:) caller: sepEgoDel)
		(super init: &rest)
		(ship init: setMotion: MoveTo 440 70)
		(wake init: setCycle: Fwd)
		(gFeatures add: sky eachElementDo: #init)
		(= global112 2)
	)

	(method (doit)
		(if (not script)
			(switch (gEgo edgeHit:)
				(EDGE_RIGHT
					(self setScript: toEast)
				)
				(EDGE_LEFT
					(self setScript: toWest)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance sepEgoDel of Script
	(properties)

	(method (cue param1)
		(if param1
			(gDelph dispose:)
		else
			(gDelph
				view: 826
				init:
				setCycle: Fwd
				x:
					(switch (gEgo loop:)
						(3
							(- (gEgo x:) 2)
						)
						(2
							(gEgo x:)
						)
						(0
							(+ (gEgo x:) 18)
						)
						(1
							(- (gEgo x:) 18)
						)
						(7
							(- (gEgo x:) 10)
						)
						(6
							(+ (gEgo x:) 10)
						)
						(5
							(- (gEgo x:) 16)
						)
						(4
							(+ (gEgo x:) 16)
						)
					)
				y:
					(switch (gEgo loop:)
						(3
							(- (gEgo y:) 12)
						)
						(2
							(+ (gEgo y:) 12)
						)
						(7
							(- (gEgo y:) 7)
						)
						(5
							(+ (gEgo y:) 8)
						)
						(6
							(- (gEgo y:) 7)
						)
						(4
							(+ (gEgo y:) 8)
						)
						(else
							(- (gEgo y:) 2)
						)
					)
				loop: (gEgo loop:)
			)
		)
	)
)

(instance toWest of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -19 (gEgo y:) self)
			)
			(1
				(gEgo x: 300 edgeHit: EDGE_NONE setMotion: 0)
				(ship x: (+ (ship x:) 319))
				(if (< (ship x:) 480)
					(ship setMotion: MoveTo 480 70)
				)
				(gCurRoom drawPic: 320)
				(switch global112
					(0
						(easternCliffs init:)
						(if (gCurRoom obstacles:)
							((gCurRoom obstacles:)
								eachElementDo: #dispose
								release:
							)
						)
						(= global112 1)
					)
					(3
						(localproc_1)
						(= global112 4)
					)
					(2
						(= global112 3)
					)
					(else
						(= global112 2)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance toEast of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 339 (gEgo y:) self)
			)
			(1
				(gEgo x: 20 edgeHit: EDGE_NONE setMotion: 0)
				(ship x: (- (ship x:) 319))
				(if (< (ship x:) 480)
					(ship setMotion: MoveTo 480 70)
				)
				(gCurRoom drawPic: 320)
				(switch global112
					(4
						(westernCliffs init:)
						(if (gCurRoom obstacles:)
							((gCurRoom obstacles:)
								eachElementDo: #dispose
								release:
							)
						)
						(= global112 3)
					)
					(1
						(localproc_0)
						(if (> (ship x:) 280)
							(ship x: 160)
						)
						(ship setMotion: 0)
						(= global112 0)
					)
					(2
						(= global112 1)
					)
					(else
						(= global112 2)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance easternCliffs of EcoView
	(properties
		x 235
		y 56
		view 326
		signal 20481
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(EcoNarrator init: 1 0 0 3 0 320) ; "Rocky cliffs mark the coastline here."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance westernCliffs of EcoView
	(properties
		y 50
		view 325
		signal 20481
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(EcoNarrator init: 1 0 0 3 0 320) ; "Rocky cliffs mark the coastline here."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ship of EcoActor
	(properties
		x 103
		y 70
		view 320
		signal 24576
		illegalBits 0
		xStep 1
		moveSpeed 15
		lookStr 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 1 0 0 6) ; "Adam can't swim that fast."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wake of EcoProp
	(properties
		y 70
		view 320
		loop 1
		cycleSpeed 10
	)

	(method (doit)
		(if (ship mover:)
			(= x (ship x:))
		else
			(= x -1000)
		)
		(super doit: &rest)
	)
)

(instance sky of EcoFeature
	(properties
		lookStr 3
	)

	(method (onMe param1)
		(return (< (param1 y:) 70))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 1 0 0 5) ; "Adam can't get there from here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

