;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	sqRm 0
)

(local
	local0
	local1
	local2
	local3 = 960
	local4 = 200
	local5
	local6
)

(instance sqRm of ExitRoom ; "Rittersberg Town Square"
	(properties
		noun 8
		picture 7001
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(!= (gGk2Music number:) 100)
				(not (OneOf newRoomNumber 7011 7012 710 7013)) ; courtRm
			)
			(gGk2Music fade:)
			(Lock 140 700 0) ; WAVE
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(if (or (not (gGk2Music handle:)) (!= (gGk2Music number:) 700))
			(Lock 140 700 1) ; WAVE
			(gGk2Music number: 700 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(= local1 0)
		(= local2 local3)
		(churchDoors init:)
		(churchCourtyard init:)
		(exitToCastle init:)
		(rathausDoor init:)
		(postOffice init:)
		(gasthofDoor init:)
		(gEgo
			view: 5
			heading: 180
			BAD_SELECTOR:
			setScaler: Scaler 100 33 333 273
			init:
			setStep: 10 2
			setSpeed: 3
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 729 296 679 310 534 322 456 314 453 289 594 285 766 281 767 292
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 943 275 813 259 803 260 392 285 0 284 0 -3 959 -15 953 461
					yourself:
				)
		)
		(super init: &rest)
		(cond
			((OneOf gPrevRoomNum 7042 7011 7310 7012)
				(gThePlane setRect: 0 15 960 349)
				(gEgo posn: 303 284 setMotion: MoveTo 313 292)
			)
			((OneOf gPrevRoomNum 710 720 7122 7121) ; courtRm, dungeonRm, rm711c2d2
				(= local1 -320)
				(gThePlane setRect: -320 15 960 349)
				(gEgo posn: 746 261 setMotion: MoveTo 775 275)
				(if (and (== gPrevRoomNum 7121) (not (IsFlag 8))) ; rm711c2d2
					(gMessager say: 1 62 0 1 0 710) ; "(CLICK ON MAYOR HABERMAS'S WINDOW--ALL DIALOGUE DONE)I don't have anything to say right now."
				)
			)
			((== gPrevRoomNum 740) ; gastRm
				(= local1 -320)
				(gThePlane setRect: -320 15 960 349)
				(gEgo posn: 914 268 setMotion: MoveTo 911 278)
			)
			((OneOf gPrevRoomNum 7013 7030)
				(= local1 -320)
				(gThePlane setRect: -320 15 960 349)
				(gEgo posn: 828 259 setMotion: MoveTo 775 275)
			)
			(else
				(= local1 -80)
				(gThePlane setRect: -160 15 960 349)
				(self setScript: sFromCastle)
			)
		)
		(UpdatePlane gThePlane)
		(= temp0 (Abs local1))
		(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50) init:)
		(+= temp0 gScreenWidth)
		(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50) init:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (> (gEgo y:) 350)
			(gEgo setMotion: 0 y: 350)
		)
		(if (!= (gEgo x:) local0)
			(cond
				((<= (= local0 (gEgo x:)) 30)
					(gEgo setMotion: 0 x: 30)
				)
				((>= local0 922)
					(gEgo setMotion: 0 x: 922)
				)
				(else
					(= temp1 (gThePlane left:))
					(= temp2 (gThePlane right:))
					(cond
						(
							(and
								(= temp0
									(cond
										((< local0 (- local4 temp1))
											(gEgo xStep:)
										)
										(
											(>
												local0
												(- (- gScreenWidth temp1) local4)
											)
											(- 0 (gEgo xStep:))
										)
										(else 0)
									)
								)
								(> (- gScreenWidth (+ local1 temp0)) local3)
							)
							(eastEdgeExit dispose:)
							(= local6 1)
						)
						((and temp0 (> (+ local1 temp0) 0))
							(westEdgeExit dispose:)
							(= local5 1)
						)
						(else
							(+= local1 temp0)
							(+= local2 temp0)
							(gThePlane setRect: local1 15 local2 349)
							(UpdatePlane gThePlane)
							(= temp0 (Abs local1))
							(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50))
							(+= temp0 gScreenWidth)
							(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50))
							(if local5
								(westEdgeExit init:)
								(= local5 0)
							)
							(if local6
								(eastEdgeExit init:)
								(= local6 0)
							)
						)
					)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance sFromCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 468 268 setMotion: MoveTo 458 283 self)
			)
			(1
				(gGame handsOn: 1)
				(self dispose:)
			)
		)
	)
)

(instance westEdgeExit of ExitFeature
	(properties
		nsTop 170
		nsBottom 349
		x 63536
		y 300
		BAD_SELECTOR 6
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath 58 (gEgo y:))
	)
)

(instance eastEdgeExit of ExitFeature
	(properties
		nsTop 170
		nsBottom 349
		x 2000
		y 300
		BAD_SELECTOR 2
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath 900 (gEgo y:))
	)
)

(instance churchDoors of GKFeature
	(properties
		approachX 270
		approachY 276
		x 196
		y 182
		BAD_SELECTOR 7012
	)

	(method (init)
		(self approachVerbs: 62) ; Do
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 144 203 161 203 233 192 248 258 248 258 162
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance churchCourtyard of GKFeature
	(properties
		nsLeft 286
		nsTop 192
		nsRight 450
		nsBottom 278
		sightAngle 40
		approachX 270
		approachY 276
		x 372
		y 235
		BAD_SELECTOR 7011
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

(instance exitToCastle of ExitFeature
	(properties
		nsLeft 460
		nsTop 144
		nsRight 518
		nsBottom 264
		sightAngle 40
		approachX 490
		approachY 259
		x 488
		y 204
		BAD_SELECTOR 1460
		BAD_SELECTOR 100
		BAD_SELECTOR 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(Lock 140 700 0) ; WAVE
			(Lock 140 100 1) ; WAVE
			(gGk2Music number: 100 play:)
		)
		(super doVerb: theVerb &rest)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

(instance rathausDoor of GKFeature
	(properties
		nsLeft 688
		nsTop 177
		nsRight 794
		nsBottom 254
		sightAngle 40
		approachX 746
		approachY 261
		x 740
		y 216
		BAD_SELECTOR 710
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

(instance postOffice of GKFeature
	(properties
		nsLeft 820
		nsTop 189
		nsRight 848
		nsBottom 252
		sightAngle 40
		approachX 828
		approachY 259
		x 834
		y 220
		BAD_SELECTOR 7013
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 720)
			(= noun 6)
			(= BAD_SELECTOR 0)
		)
		(self approachVerbs: 62) ; Do
	)
)

(instance gasthofDoor of GKFeature
	(properties
		nsLeft 914
		nsTop 180
		nsRight 948
		nsBottom 259
		sightAngle 40
		approachX 922
		approachY 266
		x 930
		y 218
		BAD_SELECTOR 740
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

