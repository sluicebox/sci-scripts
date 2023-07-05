;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 879)
(include sci.sh)
(use Main)
(use n897)
(use User)
(use System)

(public
	initCode 0
)

(instance initCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(SetFlag 5)
		(SetFlag 12)
		(SetFlag 8)
		(SetFlag 10)
		(SetFlag 11)
		(SetFlag 38)
		(= gSystemWindow param1)
		(= gUseSortedFeatures 1)
		(StrCpy @gSysLogPath {})
		(proc897_0)
		(Palette palSET_FROM_RESOURCE 999 2)
		(= gEatMice 5)
		(gGame setCursor: gTheCursor 1 304 172)
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp0)
		(FileIO fiREAD_STRING global113 20 temp0)
		(FileIO fiREAD_STRING global114 20 temp0)
		(FileIO fiCLOSE temp0)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(= gPossibleScore 225)
		(= gUserFont 4)
		(= gBigFont 2108)
		(= gSmallFont 1207)
		(= global109 2407)
		(= global110 4115)
		(= global111 2510)
		(= gWaitCursor 602)
		(= global103 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global102 (Graph grGET_COLOURS)) 2) (<= global102 16))
			(ClearFlag 0)
		else
			(SetFlag 0)
		)
		(= global104 (if (GameIsRestarting) 11 else 1))
		(param1 color: global119 back: 5)
		(param2
			color: global119
			back: 5
			topBordColor: global125
			lftBordColor: global124
			rgtBordColor: global122
			botBordColor: global121
		)
		((ScriptID 894 1) ; invWin
			color: 5
			back: global121
			topBordColor: global123
			lftBordColor: global122
			rgtBordColor: global120
			botBordColor: global119
			insideColor: global130
			topBordColor2: global119
			lftBordColor2: global119
			botBordColor2: global123
			rgtBordColor2: global124
			botBordHgt: 25
		)
		((ScriptID 894 0) init:) ; invCode
		(DisposeScript 897)
		(DisposeScript 879)
	)
)

