;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	starnSeeRm 0
)

(local
	local0
	local1
	local2
	local3 = 1280
	local4 = 240
	local5
	local6
	local7 = 1
)

(instance starnSeeRm of ExitRoom ; "Starnberger See"
	(properties
		noun 18
		picture 8401
	)

	(method (init &tmp temp0)
		(gEgo
			normalize: 5
			init:
			setSpeed: 3
			setStep: 5 3
			heading: 270
			setLoop: 1
			setScaler: Scaler 60 30 321 259
		)
		(switch gPrevRoomNum
			(800 ; bavMapRm
				(gEgo posn: 1114 280)
			)
			(8413
				(gEgo posn: 166 306)
			)
			(8442
				(gEgo setLoop: 3 heading: 0 posn: 764 298)
			)
			(else
				(gEgo posn: 166 307)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 538 291 259 266 96 328 1320 329 1320 265 1090 282
					yourself:
				)
		)
		(super init: &rest)
		(gSoundManager play: 0 842 843 844)
		(viewPoint init:)
		(chapel init:)
		(mapExit init:)
		(= local1 (Min 0 (- (/ gScreenWidth 2) (gEgo x:))))
		(= local2 (- local3 local1))
		(if (> (- gScreenWidth local1) local3)
			(= local1 (- gScreenWidth local3))
			(= local2 (- gScreenWidth local1))
		)
		(gThePlane setRect: local1 15 local2 349)
		(UpdatePlane gThePlane)
		(= temp0 (Abs local1))
		(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50) init:)
		(+= temp0 gScreenWidth)
		(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50) init:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (!= (gEgo x:) local0)
			(= local0 (gEgo x:))
			(= temp1 (gThePlane left:))
			(= temp2 (gThePlane right:))
			(if
				(and
					(= temp0
						(cond
							((< local0 (- local4 temp1))
								(gEgo xStep:)
							)
							((> local0 (- (- gScreenWidth temp1) local4))
								(- 0 (gEgo xStep:))
							)
							(else 0)
						)
					)
					(or
						(= local5 (> (- gScreenWidth (+ local1 temp0)) local3))
						(= local6 (> (+ local1 temp0) 0))
					)
				)
				0
			else
				(+= local1 temp0)
				(+= local2 temp0)
				(gThePlane setRect: local1 15 local2 349)
				(UpdatePlane gThePlane)
				(= temp0 (Abs local1))
				(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50))
				(+= temp0 gScreenWidth)
				(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50))
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (OneOf newRoomNumber 800 8412) local7) ; bavMapRm
			(gCurRoom setScript: fadeScript 0 newRoomNumber)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)
)

(instance fadeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundManager fade: 0 20 10 1 self)
			)
			(1
				(= local7 0)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance toMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 1295 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 800) ; bavMapRm
			)
		)
	)
)

(instance westEdgeExit of ExitFeature
	(properties
		nsTop 10
		nsBottom 349
		x 63536
		y 300
		exitDir 6
	)

	(method (onMe)
		(return
			(and
				(not local6)
				(super onMe: &rest)
				(self setCursor: (gUser hotCursor:))
			)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp1 (param1 loop:))
		(= temp0 (param1 view:))
		(param1 view: 998)
		(if (> gMouseY 200)
			(param1 loop: 0)
			(param1 cel: exitDir)
		else
			(param1 loop: 2)
			(param1 cel: 0)
		)
		(if (or (!= temp0 998) (!= temp1 (param1 loop:)))
			(param1 init:)
		)
		(return 1)
	)

	(method (doVerb &tmp temp0)
		(if ((gUser hotCursor:) loop:)
			(gEgo x: 230)
			(= local1 0)
			(= local2 local3)
			(gThePlane setRect: local1 15 local2 349)
			(UpdatePlane gThePlane)
			(= local6 1)
			(= local5 0)
			(= temp0 (Abs local1))
			(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50))
			(+= temp0 gScreenWidth)
			(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50))
		else
			(gEgo setMotion: PolyPath 167 (gEgo y:))
		)
	)
)

(instance eastEdgeExit of ExitFeature
	(properties
		nsTop 10
		nsBottom 349
		x 2000
		y 300
		exitDir 2
	)

	(method (onMe)
		(return
			(and
				(not local5)
				(super onMe: &rest)
				(self setCursor: (gUser hotCursor:))
			)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp1 (param1 loop:))
		(= temp0 (param1 view:))
		(param1 view: 998)
		(if (> gMouseY 200)
			(param1 loop: 0)
			(param1 cel: exitDir)
		else
			(param1 loop: 2)
			(param1 cel: 1)
		)
		(if (or (!= temp0 998) (!= temp1 (param1 loop:)))
			(param1 init:)
		)
		(return 1)
	)

	(method (doVerb &tmp temp0)
		(if ((gUser hotCursor:) loop:)
			(gEgo x: (- local3 130))
			(= local1 64897)
			(= local2 641)
			(gThePlane setRect: local1 15 641 349)
			(UpdatePlane gThePlane)
			(= local6 0)
			(= local5 1)
			(= temp0 (Abs local1))
			(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50))
			(+= temp0 gScreenWidth)
			(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50))
		else
			(gEgo setMotion: PolyPath 2000 (gEgo y:))
		)
	)
)

(instance chapel of GKFeature
	(properties
		nsLeft 670
		nsTop 12
		nsRight 834
		nsBottom 182
		approachX 764
		approachY 288
		x 764
		y 48
		nextRoomNum 8442 ; rm8442
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 4) ; Do, ???
	)
)

(instance viewPoint of GKFeature
	(properties
		nsTop 201
		nsRight 144
		nsBottom 333
		approachX 140
		approachY 290
		y 288
		nextRoomNum 8412 ; rm8412
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 4) ; Do, ???
	)
)

(instance mapExit of ExitFeature
	(properties
		nsLeft 1160
		nsTop 19
		nsRight 1280
		nsBottom 333
		approachX 1280
		approachY 300
		x 1300
		y 300
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 4) ; Do, ???
	)

	(method (doVerb)
		(gCurRoom setScript: toMap)
	)
)

