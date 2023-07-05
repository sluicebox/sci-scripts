;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use Talker)
(use User)
(use System)

(public
	InitGame 0
	InitGlobals 1
)

(procedure (InitGame &tmp temp0 [temp1 10] [temp11 10] [temp21 10])
	(User alterEgo: gEgo)
	(= global17 0)
	(= gUseSortedFeatures 1)
	(= gMsgType 1)
	(= gPossibleScore 500)
	(= gSmallFont 999)
	(= gBigFont 300)
	(= global197 20)
	(= global198 15)
	(= global415 5)
	(Format @global428 {Unknown Hero})
	((= gNarrator Narrator)
		x: -1
		y: 14
		keepWindow: 1
		font: (= gUserFont 300)
		color: 66
		back: 69
	)
	(InitGlobals)
	(FixTime 11)
	(HandsOn)
	(if (HaveMouse)
		(= gEatMice 30)
		(gGame setCursor: gNormalCursor 1)
	else
		(gGame setCursor: gNormalCursor 1 304 174)
	)
	(SetFlag 129)
	(Joystick 12 0)
	(= temp1 (= temp11 (= temp21 0)))
	(Message msgGET 999 15 0 1 1 @temp11) ; "%d.scr"
	(Format @temp21 @temp11 298)
	(if (FileIO fiEXISTS @temp21)
		(= temp0
			(Print
				addText: 1 0 1 1 0 0 1 ; "Where to, Hero?"
				addEdit: @temp1 5 115 0
				addButton: 200 1 0 0 1 0 12 1 ; "Introduction"
				addButton: 202 1 0 0 2 100 12 1 ; "Start New Hero"
				addButton: -100 1 0 0 3 0 26 1 ; "Restore Game"
				addButton: 300 1 0 0 4 100 26 1 ; "Go to Town"
				addButton: 2 1 0 0 5 0 40 1 ; "Continue Normally"
				init:
			)
		)
	else
		(= temp0 2)
	)
	(if (== temp0 -100)
		(gGame restore:)
	)
	(if (not (OneOf temp0 200 202 300 2))
		(= temp0 300)
	)
	(if temp1
		(= temp0 (ReadNumber @temp1))
	)
	(= global124 temp0)
	(gGame newRoom: 299) ; speedRoom
)

(procedure (InitGlobals)
	(= global196 (DoSound sndGET_POLYPHONY))
	(if (< (= global195 (Graph grGET_COLOURS)) 8)
		(= global270 804)
		(= global253 0)
		(= global254 4)
	else
		(= global270 803)
		(= global253 42)
		(= global254 54)
	)
)

