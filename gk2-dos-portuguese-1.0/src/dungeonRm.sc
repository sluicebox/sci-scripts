;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	dungeonRm 0
)

(instance dungeonRm of ExitRoom ; "Rittersberg Rathaus: Dungeon"
	(properties
		noun 13
		picture 7201
		south 7202 ; rm7202
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 7202 7212 7240))
			(gGk2Music fade:)
			(Lock rsAUDIO 720 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(dungeonDoor init:)
		(dungeonWindow init:)
		(gEgo
			posn: 181 316
			heading: 135
			sel_737:
			setScaler: Scaler 87 70 320 270
			init:
		)
		(if (and (== gChapter 6) (not (IsFlag 710)))
			(dove init:)
		)
		(super init: &rest)
		(if
			(and
				(IsFlag 470)
				(or (not (gGk2Music handle:)) (== gPrevRoomNum 7133))
			)
			(Lock 140 (gGk2Music number:) 0) ; WAVE
			(Lock rsAUDIO 720 1)
			(gGk2Music number: 720 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(cond
			((not (IsFlag 470))
				(SetFlag 470)
				(PlayScene 203)
				(PlayScene 211)
				(if (or (not (gGk2Music handle:)) (== gPrevRoomNum 7133))
					(Lock 140 (gGk2Music number:) 0) ; WAVE
					(Lock rsAUDIO 720 1)
					(gGk2Music
						number: 720
						setLoop: -1
						play: 0 0
						fade: 63 10 10 0
					)
				)
			)
			((and (OneOf gPrevRoomNum 7212 7240) (!= gChapter 6))
				(PlayScene 1213)
			)
			((!= gChapter 6))
			((not (IsFlag 707))
				(SetFlag 707)
				(gEgo heading: 135)
				(PlayScene 751)
			)
			((not (OneOf gPrevRoomNum 7212 7240 7202))
				(PlayScene 752)
			)
		)
	)
)

(instance dungeonDoor of ExitFeature
	(properties
		nsLeft 42
		nsTop 57
		nsRight 188
		nsBottom 268
		approachX 120
		approachY 278
		x 114
		y 163
		BAD_SELECTOR 700
		BAD_SELECTOR 7
	)
)

(instance dove of Prop
	(properties
		modNum 720
		sightAngle 360
		approachX 442
		approachY 300
		x 482
		y 144
		view 20720
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= noun
					(cond
						((IsFlag 712) 11)
						((IsFlag 711) 10)
						(else
							(SetFlag 711)
							9
						)
					)
				)
				(super doVerb: theVerb)
			)
			(30 ; invPillowcase
				(if (IsFlag 712)
					(PlayScene 757)
					(SetFlag 710)
					(gEgo put: 61 get: 77) ; invPillowcase, invDove
					(self dispose:)
				else
					(= noun 12)
					(super doVerb: theVerb)
				)
			)
			(132 ; invRoll
				(self setScript: 0)
				(gEgo put: 75) ; invRoll
				(SetFlag 712)
				(PlayScene 756)
			)
			(else
				(= noun 14)
				(super doVerb: 62)
			)
		)
	)
)

(instance dungeonWindow of GKFeature
	(properties
		nsLeft 466
		nsTop 60
		nsRight 510
		nsBottom 136
		approachX 442
		approachY 300
		x 488
		y 98
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gChapter 6)
					(gCurRoom newRoom: 7240)
				else
					(PlayScene 213 0 7240) ; rm7240
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

