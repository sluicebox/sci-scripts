;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Talker)
(use User)

(public
	InitGame 0
	InitGlobals 1
)

(procedure (InitGame &tmp temp0 [temp1 30])
	(User alterEgo: gEgo)
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
	(HandsOn)
	(gGame setCursor: 999 1 304 174)
	(SetFlag 129)
	(= global124 (= temp0 2))
	(gGame newRoom: 299) ; speedRoom
)

(procedure (InitGlobals))

