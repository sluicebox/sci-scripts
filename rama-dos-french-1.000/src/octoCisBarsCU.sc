;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7508)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Feature)

(public
	octoCisBarsCU 0
)

(instance octoCisBarsCU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(if (== (proc70_9 92) 7508)
			(= picture 38970)
			(super init: 38970)
			(GATEDARK_315 init: case: 5)
			(bars init:)
		else
			(= picture 38979)
			(super init: 38979)
			(GATEDARK_315 init: case: 6)
		)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(proc201_1 12)
	)
)

(instance bars of Feature
	(properties
		nsBottom 250
		nsLeft 200
		nsRight 440
		nsTop 80
	)

	(method (init)
		(= plane global116)
		(super init:)
		(self setHotspot: 43 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc1111_31 29)
			)
			(43
				(proc201_1 13)
				(falstaffGetsKey play:)
				(proc70_1 92 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance GATEDARK_315 of Feature
	(properties
		noun 36
		nsBottom 262
		nsLeft 115
		nsRight 538
		nsTop 30
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance falstaffGetsKey of VMDMovie
	(properties
		movieName 38971
		begPic 38970
		endPic 38979
	)
)

