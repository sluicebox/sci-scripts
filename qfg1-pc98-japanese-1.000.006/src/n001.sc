;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use User)
(use Menu)

(public
	InitGame 0
	InitGlobals 1
)

(procedure (InitGame &tmp temp0)
	(User alterEgo: gEgo)
	(User blocks: 0 y: 160)
	(= gShowStyle 0)
	(= global101 0)
	(MenuBar init:)
	(= global270 (Random 0 6))
	(= gPossibleScore 500)
	(= gUserFont 300)
	(= gSmallFont 999)
	(= gBigFont 300)
	(= global213 20)
	(= global214 15)
	(= global591 5)
	(InitGlobals)
	(FixTime 11)
	(DoSound sndVOLUME 15)
	(HandsOn)
	(if (HaveMouse)
		(gGame setCursor: gNormalCursor 1)
	else
		(gGame setCursor: gNormalCursor 1 304 174)
	)
	(SetFlag 129)
	(Joystick 12 0)
	(if (GameIsRestarting)
		(= global138 9)
	else
		(= global138 2)
	)
	(gGame newRoom: 299) ; speedChecker
)

(procedure (InitGlobals)
	(= global212 (DoSound sndCHECK_DRIVER))
	(if (< (= global211 (Graph grGET_COLOURS)) 8)
		(= global302 804)
		(= global303 15)
		(= global274 0)
		(= global275 4)
	else
		(= global302 803)
		(= global303 11)
		(= global274 9)
		(= global275 12)
	)
)

