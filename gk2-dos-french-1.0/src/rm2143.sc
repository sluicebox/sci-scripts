;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2143)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm2143 0
)

(instance rm2143 of ExitRoom
	(properties
		picture 2143
		east 210 ; farmIntRm
		south 210 ; farmIntRm
		west 210 ; farmIntRm
	)

	(method (init)
		(switch gChapter
			(3
				(= picture 2146)
			)
			(5)
		)
		(super init: &rest)
		(newspaper init:)
		(gGame handsOn: 0)
	)

	(method (dispose)
		(PlayScene 1009 0 210) ; farmIntRm
		(super dispose:)
	)
)

(instance newspaper of GKFeature
	(properties
		modNum 210
		x 306
		y 152
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 26 0 586 0 587 303 26 304
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(gMessager say: 1 62 0 1 0 210) ; "(LOOKING AT NEWSPAPER CH 1)I can't read much of it, but they give the name of the zoo --it's in Thalkirchen. The name of the Detective on the case is Leber, from the police station near Prinzregentenplatz."
					(gGame changeScore: 849)
					(SetFlag 27)
					(SetFlag 24)
				)
				(3
					(gMessager say: 11 62 0 1 0 210) ; "(READING NEWSPAPER CH 3)It looks like there's been another wolf killing. And this one occurred last night in downtown Munich!"
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

