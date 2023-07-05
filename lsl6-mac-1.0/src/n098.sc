;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use Print)

(public
	proc98_0 0
)

(procedure (proc98_0 &tmp temp0)
	(if (!= gCurRoomNum 140)
		(SetPort 0)
		(SetPort 0 0 190 320 10 0)
	)
	(gSounds eachElementDo: #pause)
	(= temp0 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(switch
		(Print
			font: gUserFont
			posn: 30 157
			addButton: 100 {Open Game} 0 0
			addButton: -1 {Continue} 71 0
			addButton: 110 {Intro} 126 0
			addButton: 200 {Credits} 165 0
			addButton: 300 {Play} 220 0
			init:
		)
		(100
			(gGame restore:)
		)
		(110
			(Platform 0 4 3 6)
			(gCurRoom newRoom: 130)
		)
		(200
			(Platform 0 4 3 6)
			(gGame setCursor: gNormalCursor)
			(gCurRoom newRoom: 120)
		)
		(300
			(gCurRoom newRoom: 200)
		)
	)
	(gGame setCursor: gNormalCursor)
	(gSounds eachElementDo: #pause 0)
	(DisposeScript 98)
)

