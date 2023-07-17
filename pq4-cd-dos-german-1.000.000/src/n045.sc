;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	proc45_0 0
	proc45_1 1
	proc45_2 2
	proc45_3 3
)

(procedure (proc45_0)
	(if (or (!= gPrevRoomNum 6) (not global105)) ; speedRoom
		(return)
	)
	(if (OneOf gCurRoomNum 545 240)
		(gEgo get: 1) ; ammoBaggie
		(gEgo get: 43) ; parkerID
		(gEgo get: 36) ; notebook
		(gEgo get: 33) ; handcuffs
		(gEgo get: 32) ; keys
		(gEgo get: 18) ; coins
		(gEgo get: 11) ; handgun
		(gEgo get: 16) ; badge
		(gEgo get: 13) ; fullClip
		(gEgo get: 10) ; wallet
		(gEgo get: 3) ; evidenceCase
		(gEgo get: 4) ; hickmanStuff
		(gEgo get: 40) ; washStuff
		(gEgo get: 9) ; apple
		(gPqFlags set: 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26)
	else
		(switch gCurRoomNum
			(360
				(= gDay 5)
				(gPqFlags set: 90 39)
				(gPqFlags set: 39 44)
			)
			(860
				(gEgo get: 10 20 11 13 18 32 33 36 43 16) ; wallet
				(= gPrevRoomNum 850)
			)
			(170
				(gEgo get: 10 5 11 13 18 32 33 36 43 16) ; wallet
			)
			(810
				(gEgo get: 10 11 13 18 32 33 36 43 16) ; wallet
				(= gPrevRoomNum 800)
				(gPqFlags set: 143)
			)
			(115
				(gEgo get: 10 11 13 18 32 33 36 43 16) ; wallet
				(gPqFlags set: 47)
			)
			(220
				(gEgo get: 10 11 13 18 32 33 36 43 16 45) ; wallet
			)
			(880
				(gEgo get: 33) ; handcuffs
				(gEgo get: 11) ; handgun
				(gEgo get: 16) ; badge
			)
			(515
				(gEgo get: 1) ; ammoBaggie
				(gPqFlags set: 32)
			)
			(755
				(gPqFlags set: 123)
				(gEgo get: 34 29 28) ; torch
			)
			(315
				(= gDay 4)
				(gPqFlags clear: 96)
			)
		)
	)
	(DisposeScript 45)
)

(procedure (proc45_1)
	(= global172 (Print back:))
	(= global171 (Print fore:))
	(= global173 (Print x:))
	(= global174 (Print y:))
	(= global175 (Print width:))
	(= global176 (Print mode:))
	(= global180 (Print margin:))
	(DisposeScript 45)
)

(procedure (proc45_2)
	(Print
		width: global175
		modeless: 0
		shadowText: 0
		plane: 0
		fore: global171
		back: global172
		x: global173
		y: global174
		mode: global176
		margin: global180
	)
	(DisposeScript 45)
)

(procedure (proc45_3 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

