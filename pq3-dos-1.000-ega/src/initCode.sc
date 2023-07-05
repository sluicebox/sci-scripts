;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 879)
(include sci.sh)
(use Main)
(use User)
(use System)

(public
	initCode 0
)

(instance initCode of Code
	(properties)

	(method (doit param1 param2 param3)
		(= gSystemWindow param1)
		(= gUseSortedFeatures 0)
		(StrCpy @gSysLogPath {})
		(= global108 0)
		(Graph grFILL_BOX 0 0 190 320 1 0)
		(Graph grUPDATE_BOX 0 0 190 320 1)
		(Palette palSET_FROM_RESOURCE 999 2)
		(if (> (Graph grGET_COLOURS) 16)
			(= global118 (Palette palFIND_COLOR 0 0 0))
			(= global119 (Palette palFIND_COLOR 31 31 31))
			(= global120 (Palette palFIND_COLOR 63 63 63))
			(= global121 (Palette palFIND_COLOR 95 95 95))
			(= global122 (Palette palFIND_COLOR 127 127 127))
			(= global123 (Palette palFIND_COLOR 159 159 159))
			(= global124 (Palette palFIND_COLOR 191 191 191))
			(= global125 (Palette palFIND_COLOR 223 223 223))
			(= global137 (Palette palFIND_COLOR 187 35 35))
			(= global138 (Palette palFIND_COLOR 39 39 219))
			(= global155 (Palette palFIND_COLOR 23 119 119))
		else
			(= global119 0)
			(= global138 1)
			(= global155 3)
			(= global137 4)
			(= global120 7)
			(= global121 8)
			(= global183 12)
			(= global125 31)
		)
		(= gEatMice 5)
		(gGame egoMoveSpeed: 6 setCursor: gTheCursor 1 304 172)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(= gPossibleScore 460)
		(= gUserFont 4)
		(= gWaitCursor 997)
		(= gDay 1)
		(= global105 14)
		(= global106 (= global107 0))
		(if (and (>= (= global102 (Graph grGET_COLOURS)) 2) (<= global102 16))
			(ClearFlag 2)
		else
			(SetFlag 2)
		)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global104 (if (GameIsRestarting) 18 else 1))
		(param1
			color: global119
			back: (proc0_15 global123 global120)
			topBordColor: global125
			lftBordColor: (proc0_15 global124 global125)
			rgtBordColor: (proc0_15 global122 global121)
			botBordColor: (proc0_15 global121 global121)
		)
		(param3
			color: global119
			back: (proc0_15 global123 global120)
			topBordColor: global125
			lftBordColor: (proc0_15 global124 global125)
			rgtBordColor: (proc0_15 global122 global121)
			botBordColor: (proc0_15 global121 global121)
		)
		(param2
			color: global119
			back: (proc0_15 global121 global120)
			topBordColor: (proc0_15 global123 global125)
			lftBordColor: (proc0_15 global122 global125)
			rgtBordColor: (proc0_15 global120 global121)
			botBordColor: (proc0_15 global119 global121)
			insideColor: global155
			topBordColor2: global119
			lftBordColor2: global119
			botBordColor2: (proc0_15 global123 global125)
			rgtBordColor2: (proc0_15 global124 global125)
			botBordHgt: 25
		)
		(DisposeScript 879)
	)
)

