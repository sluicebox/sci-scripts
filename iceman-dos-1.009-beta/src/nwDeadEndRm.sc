;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Game)

(public
	nwDeadEndRm 0
)

(instance nwDeadEndRm of Rm
	(properties
		picture 65
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
	)
)

