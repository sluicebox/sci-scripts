;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Game)

(public
	inCave5Rm 0
)

(instance inCave5Rm of Rm
	(properties
		picture 67
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
	)
)

