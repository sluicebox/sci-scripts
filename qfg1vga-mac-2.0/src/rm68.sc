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
		(avalanche init: setOnMeCheck: 1 512)
		(NormalEgo)
	)
)

(instance avalanche of Feature
	(properties
		x 290
		y 100
		noun 1
	)
)

