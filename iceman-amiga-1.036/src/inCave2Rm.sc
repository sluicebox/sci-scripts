;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Game)

(public
	inCave2Rm 0
)

(instance inCave2Rm of Rm
	(properties
		picture 60
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
	)
)

