;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)

(public
	endChapter 0
)

(instance endChapter of P2Room
	(properties
		picture 0
		style 0
	)

	(method (init)
		(gP2SongPlyr fadeOut: 0)
		(super init: &rest)
		(gGame handsOn:)
		(proc63002_8)
		(++ gChapter)
		(gGame getDisc: gChapter)
		((ScriptID 63020) doit:) ; networkInitCode
		(switch gChapter
			(2
				(= global209 5670)
				(gCurRoom newRoom: 2122) ; livingRoomCH2SR2
			)
			(3
				(= global209 990)
				(gCurRoom newRoom: 2013) ; bedRoomCH3SR1
			)
			(4
				(= global209 1160)
				(SetFlag 519)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
			(5
				(= global209 1230)
				(SetFlag 712)
				(gCurRoom newRoom: 2115) ; livingRoomCH5SR1
			)
		)
	)
)

