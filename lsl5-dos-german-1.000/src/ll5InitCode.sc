;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use n012)
(use System)

(public
	ll5InitCode 0
)

(instance ll5InitCode of Code
	(properties)

	(method (init &tmp temp0)
		(= gSystemWindow (ScriptID 0 21)) ; ll5Win
		(ColorInit)
		(= gUseSortedFeatures 1)
		(= gEatMice 30)
		(StrCpy @gSysLogPath {})
		(gGame egoMoveSpeed: 6 setCursor: gTheCursor 1 304 172 detailLevel: 5)
		(= gWaitCursor 997)
		(= gPossibleScore 1000)
		(= gUserFont 2107)
		(= gBigFont 2108)
		(= gSmallFont 1207)
		(= gMonoFont 2407)
		(= gGiantFont 4115)
		(= gNiceFont 2510)
		(= global155 12)
		(= gNumVoices (DoSound sndGET_POLYPHONY))
		(if (and (>= (= gNumColors (Graph grGET_COLOURS)) 2) (<= gNumColors 16))
			(ClearFlag 0) ; isVga
		else
			(SetFlag 0) ; isVga
		)
		(gSystemWindow color: 0 back: gColWindow)
		((ScriptID 19 1) ; invWin
			color: 0
			back: gColWindow
			topBordColor: gColWindow
			lftBordColor: gColWindow
			rgtBordColor: gColWindow
			botBordColor: gColWindow
			insideColor: gColDBlue
			topBordColor2: gColMagenta
			lftBordColor2: gColMagenta
			botBordColor2: gColLMagenta
			rgtBordColor2: gColLMagenta
		)
		((ScriptID 0 20) color: 0 back: gColWindow) ; gcWin
		((ScriptID 19 0) init:) ; invCode
		(UnLoad 130 12)
	)
)

