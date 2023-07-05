;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Game)

(public
	inCave6Rm 0
)

(instance inCave6Rm of Rm
	(properties
		picture 62
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
	)
)

