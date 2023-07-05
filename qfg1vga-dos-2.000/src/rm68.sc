;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use n814)
(use Feature)
(use Game)

(public
	rm68 0
)

(instance rm68 of Rm
	(properties
		picture 68
		style 8
	)

	(method (dispose)
		(SetFlag 58)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(gFeatures add: avalanche eachElementDo: #init doit:)
		(NormalEgo)
	)
)

(instance avalanche of Feature
	(properties
		x 290
		y 100
		noun 1
	)

	(method (init)
		(= onMeCheck 512)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
	)
)

