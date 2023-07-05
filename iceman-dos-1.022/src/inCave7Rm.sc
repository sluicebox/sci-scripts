;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Game)

(public
	inCave7Rm 0
)

(instance inCave7Rm of Rm
	(properties
		picture 43
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
	)
)

