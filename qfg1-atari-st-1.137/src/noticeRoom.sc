;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Game)
(use System)

(public
	noticeRoom 0
)

(instance noticeRoom of Rm
	(properties
		picture 750
		style 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: sayRights)
	)
)

(instance rightsWin of SysWindow
	(properties
		back 11
	)
)

(instance sayRights of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (< global211 8)
					(rightsWin color: 0 back: 15)
				)
				(Print 2 0 #mode 1 #width 300 #window rightsWin) ; "The software you are now using was produced through the efforts of many people: designers, artists, programmers, musicians, and lots of other hard-working folks. If you make copies of this software for any reason other than to make a personal backup, you are not only breaking the law, but raising the cost of software for all legitimate users. PLEASE DO NOT MAKE ILLEGAL COPIES OF THIS GAME !"
				(Print 2 1 #mode 1 #width 300 #window rightsWin) ; "Oh, by the way . . . You will need the information contained in the printed documentation to successfully complete this game. In other words, it's not just the law . . . It's a good idea."
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 9) ; notice2Room
			)
		)
	)
)

