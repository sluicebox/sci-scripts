;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2140)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Cursor)
(use Actor)

(public
	rm2140 0
)

(instance rm2140 of ExitRoom
	(properties
		picture 2140
		south 210 ; farmIntRm
	)

	(method (init)
		(super init: &rest)
		(vPaper init:)
		(vStationery init:)
		(gGame handsOn:)
	)
)

(instance vStationery of View
	(properties
		modNum 210
		x 440
		y 192
		view 2140
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (and (== gChapter 3) (not (IsFlag 241))) ; "Ludwig II" in rm4220b
			(GKHotCursor delete: self)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(if (IsFlag 411)
						(gMessager say: 22 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE AGAIN CH 1)I already wrote one letter to Gracie. Don't want to give the poor girl a heart attack!"
					else
						(PlayScene 10)
						(gEgo get: 9) ; invGabeEnvelope1
						(SetFlag 411)
					)
				)
				(3
					(PlayScene 232)
					(gEgo get: 31) ; invGabeEnvelope2
					(SetFlag 411)
					(GKHotCursor delete: self)
				)
				(5
					(gMessager say: 13 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE, CH 5)I don't want to write to Gracie. If she knew about the huntin' trip, she'd REALLY freak."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vPaper of View
	(properties
		modNum 210
		x 294
		y 168
		view 2140
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(PlayScene 9)
					(gMessager say: 1 62 0 1 0 210) ; "(LOOKING AT NEWSPAPER CH 1)I can't read much of it, but they give the name of the zoo --it's in Thalkirchen. The name of the Detective on the case is Leber, from the police station near Prinzregentenplatz."
					(SetFlag 27)
					(SetFlag 24)
				)
				(3
					(PlayScene 9)
					(gMessager say: 11 62 0 1 0 210) ; "(READING NEWSPAPER CH 3)It looks like there's been another wolf killing. And this one occurred last night in downtown Munich!"
				)
				(5
					(PlayScene 548)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

