;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use fileScr)
(use Print)
(use System)

(public
	proc98_0 0
)

(procedure (proc98_0 &tmp temp0)
	(= temp0 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(gSounds eachElementDo: #pause)
	(SetCursor 275 130)
	(switch
		(Print
			font: gUserFont
			posn: -1 80
			addTitle: 1 0 1 1 98
			addText: 1 0 0 1 50 3 98 ; "You're always in such a hurry! Don't you want to read the names of all the wonderful people who slapped this game together for you? Don't you want to know what it's about? Oh, go on. Ignore us. Click that "Open Game" button to restore your game..."
			addIcon: 1910 0 0 0 0
			addButton: 100 1 0 2 1 50 33 98 ; "Open Game"
			addButton: -1 1 0 3 1 (proc79_15 85 93 85 93 93) 33 98 ; "Continue"
			addButton: 110 1 0 4 1 (proc79_15 134 128 126 128 128) 33 98 ; "Intro"
			addButton: 200 1 0 5 1 (proc79_15 161 153 155 153 153) 33 98 ; "Credits"
			addButton: 400 1 0 7 1 (proc79_15 196 183 189 183 183) 33 98 ; "Text On/Off"
			addButton: 300 1 0 6 1 229 33 98 ; "Play"
			init:
		)
		(100
			(gGame restore:)
		)
		(110
			(gCurRoom newRoom: 130)
		)
		(200
			(gCurRoom newRoom: 120)
		)
		(300
			(cond
				((gGlobalSound1 handle:)
					(gGlobalSound1 fade:)
				)
				((gGlobalSound2 handle:)
					(gGlobalSound2 fade:)
				)
			)
			(gCurRoom newRoom: 200)
		)
		(400
			(if (and (not (OneOf gCurRoomNum 100 110 120)) (IsFlag 105))
				(gTextScroller show:)
				(ClearFlag 105)
			else
				(gTextScroller hide:)
				(SetFlag 105)
			)
		)
	)
	(gGame setCursor: temp0 1)
	(gSounds eachElementDo: #pause 0)
	(UnLoad 128 1910)
	(DisposeScript 98)
)

