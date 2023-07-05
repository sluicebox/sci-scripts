;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	srSecretRoom 0
)

(instance srSecretRoom of ExitRoom ; "Schloss Ritter: Passageway"
	(properties
		noun 7
		picture 1601
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 170) ; srExtWallRoom
			(gGk2Music fade:)
			(Lock rsAUDIO 160 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(Lock 140 (gGk2Music number:) 0) ; WAVE
		(Lock rsAUDIO 160 1)
		(gGk2Music number: 160 setLoop: -1 play: 0 0 fade: 63 25 10 0)
		(super init: &rest)
		(exitGabe init:)
		(exitGerde init:)
		(stairs init:)
		(cond
			((== gPrevRoomNum 170) ; srExtWallRoom
				(PlayScene 148)
			)
			((not (IsFlag 453))
				(SetFlag 453)
				(PlayScene 146)
			)
		)
		(switch gPrevRoomNum
			(1510
				(gEgo posn: 510 308 heading: 225)
			)
			(else
				(gEgo posn: 250 320 heading: 135)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 93 67 329 249 init:)
	)
)

(instance exitGabe of ExitFeature
	(properties
		nsLeft 140
		nsTop 52
		nsRight 190
		nsBottom 297
		approachY 290
		BAD_SELECTOR 140
		BAD_SELECTOR 6
	)
)

(instance exitGerde of ExitFeature
	(properties
		nsLeft 548
		nsTop 50
		nsRight 594
		nsBottom 271
		approachX 640
		approachY 290
		BAD_SELECTOR 2
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 475))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(if (not (IsFlag 475))
			(if (not (IsFlag 639))
				(SetFlag 639)
				(gMessager say: 1 62 0 1) ; "(SCHLOSS RITTER SECRET PASSAGE, SLIGHTLY SUSPICIOUS)Now I wonder where this goes?"
			)
			(gCurRoom newRoom: 150) ; srGerdaRoom
		else
			(gMessager say: 2 62 0 1) ; "(DOUBTFUL)I don't want to go back in Gerde's bedroom. She might catch me in there."
		)
	)
)

(instance stairs of ExitFeature
	(properties
		nsLeft 212
		nsTop 208
		nsRight 328
		nsBottom 240
		approachX 100
		BAD_SELECTOR 170
		BAD_SELECTOR 4
	)
)

