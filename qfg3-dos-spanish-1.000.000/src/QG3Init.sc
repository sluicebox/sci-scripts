;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Talker)
(use User)
(use System)

(public
	QG3Init 0
)

(instance QG3Init of Code
	(properties)

	(method (init &tmp temp0 temp1 [temp2 9])
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(if (FileIO fiEXISTS {18.scr})
			(= global201 1)
		)
		((= gNarrator Narrator) keepWindow: 1 y: 120 back: 57)
		(= gMsgType 1)
		(= global17 0)
		(= gUseSortedFeatures 1)
		(= global133 (DoSound sndGET_POLYPHONY))
		(= gPossibleScore 500)
		(= gUserFont 0)
		(= gSmallFont 999)
		(= gBigFont 300)
		(= global134 20)
		(= global135 15)
		(= global198 20)
		((ScriptID 7 4) init: 11) ; fixTime
		(if (HaveMouse)
			(= gEatMice 6)
			(gGame setCursor: gNormalCursor 1)
		else
			(gGame setCursor: gNormalCursor 1 304 174)
		)
		(= temp1 0)
		(if (FileIO fiEXISTS {18.scr})
			(gGame newRoom: 101)
		else
			(gGame newRoom: 130)
		)
	)
)

