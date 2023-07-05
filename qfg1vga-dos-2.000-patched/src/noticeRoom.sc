;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Window)
(use Game)
(use System)

(public
	noticeRoom 0
)

(instance noticeRoom of Rm
	(properties
		noun 1
		picture 750
		style 1
	)

	(method (init)
		(super init: &rest)
		(gGame setCursor: 999 0)
		(SetFlag 359)
		(self setScript: sayRights)
	)
)

(instance rightsWin of SysWindow
	(properties)
)

(instance sayRights of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (< global195 8)
					(rightsWin color: 0 back: 15)
				)
				(gMessager say: 1 0 1 0 self) ; "The software you are now using was produced through the efforts of many people: designers, artists, programmers, musicians, and lots of other hard-working folks."
			)
			(2
				(gCurRoom newRoom: 603) ; LogoRoom
			)
		)
	)
)

