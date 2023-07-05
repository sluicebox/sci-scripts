;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5512)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm5512 0
)

(instance rm5512 of ExitRoom
	(properties
		modNum 543
		picture 5512
		south 543 ; priessRm
	)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 5541 5542)
			(Lock 140 250 0) ; WAVE
			(gSoundManager play: 521 522 523 524)
		)
		(fWindowExit init:)
		(gGame handsOn:)
	)

	(method (cue)
		(gCurRoom newRoom: 570) ; ledgeRm
	)
)

(instance fWindowExit of GKFeature
	(properties
		modNum 543
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 115 14 465 16 466 314 113 318)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 6291 0 5541) ; rm5541
			)
			(22 ; invRope
				(if (not (IsFlag 668))
					(SetFlag 668)
					(gMessager say: 6 theVerb 0 1 gCurRoom 543) ; "(CLICK ROPE ON LEDGE TO CLIMB OUT)I hate it when I come up with ideas like this."
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

