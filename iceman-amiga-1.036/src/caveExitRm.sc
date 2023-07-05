;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	caveExitRm 0
)

(instance caveExitRm of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
		(if (== gPrevRoomNum 53) ; antiSubNetRm
			(gEgo posn: 298 110 setMotion: MoveTo 139 110)
		)
	)
)

