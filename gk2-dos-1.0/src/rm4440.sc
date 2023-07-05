;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4440)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm4440 0
)

(instance rm4440 of ExitRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4446
	)

	(method (init)
		(if (and (== gChapter 5) (not (IsFlag 677)))
			(vMagazine init:)
		else
			(fMagazine init:)
		)
		(= south gPrevRoomNum)
		(super init: &rest)
		(gGame handsOn:)
	)
)

(instance vMagazine of View
	(properties
		x 282
		y 320
		view 30275
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 677)
				(gEgo get: 6) ; invTapeRecorder
				(gEgo get: 82) ; invVonZellTape
				(gEgo put: 35) ; invMagazine
				((ScriptID 0 5) mask: 0) ; recButton
				(PlayScene 562 0 gPrevRoomNum)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMagazine of Feature
	(properties)

	(method (init)
		(self createPoly: 269 304 319 277 406 289 366 321)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gChapter 5)
					(gMessager say: 5 62 0 0 0 440) ; "(HUNT CLUB MAIN HALL. TRY TO TAKE MAGAZINE)I'll leave the magazines here."
				else
					(PlayScene 275 0 gPrevRoomNum)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

