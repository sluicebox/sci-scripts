;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use n814)
(use Game)

(public
	rm66 0
)

(instance rm66 of Rm
	(properties
		picture 66
		style 8
		horizon 54
	)

	(method (dispose)
		(SetFlag 56)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
	)

	(method (doVerb)
		(return 0)
	)
)

