;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 764)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	noticeRoom 0
)

(instance rightsWin of SysWindow
	(properties)
)

(instance noticeRoom of Rm
	(properties
		style 1
	)

	(method (init)
		(super init: &rest)
		(Print 764 0 #mode 1 #width 300 #window rightsWin) ; "The software you are now using was produced through the efforts of many people: designers, artists, programmers, musicians, and many other hard-working professionals. If you make copies of this software for any reason other than to make a personal backup, you are not only breaking the law, but raising the cost of software for all legitimate users. PLEASE DO NOT MAKE ILLEGAL COPIES OF THIS GAME !"
		(gCurRoom newRoom: 2) ; introRoom
	)
)

