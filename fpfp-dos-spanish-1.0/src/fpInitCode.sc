;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use Window)
(use System)

(public
	fpInitCode 0
)

(local
	[local0 160]
)

(instance fpInitCode of Code
	(properties)

	(method (init &tmp temp0)
		(= gScore 0)
		(= gPossibleScore 999)
		(= gUserFont 69)
		(= gBigFont 2108)
		(= gSmallFont 1207)
		(= global116 2407)
		(= global117 4115)
		(= global118 2510)
		(= global121 30)
		(Print font: gUserFont)
		((= gNarrator Narrator) font: gUserFont back: global134 keepWindow: 1)
		(= gMsgType 1)
		(= gSystemWindow (ScriptID 0 10)) ; fpWin
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp0)
		(FileIO fiREAD_STRING global111 20 temp0)
		(FileIO fiREAD_STRING global112 20 temp0)
		(FileIO fiREAD_STRING global113 20 temp0)
		(FileIO fiCLOSE temp0)
		(= gUseSortedFeatures 1)
		(= gEatMice 30)
		(StrCpy @gSysLogPath {})
		(gGame setCursor: gTheCursor 1 304 172 detailLevel: 5 masterVolume: 15)
		(= gTextSpeed 10)
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 0)
		else
			(SetFlag 0)
		)
		(gSystemWindow color: 0 back: global134)
		(SysWindow back: global134)
		((ScriptID 15 1) ; invWin
			color: 0
			back: 17
			topBordColor: 17
			lftBordColor: 17
			rgtBordColor: 17
			botBordColor: 17
			insideColor: 19
			topBordColor2: 18
			lftBordColor2: 18
			botBordColor2: 20
			rgtBordColor2: 20
		)
		(TextFonts 0 4)
		(TextColors 40 72 10 74)
		(Palette palSET_FROM_RESOURCE 999 2)
		(Message msgGET 0 21 0 0 (Random 1 8) @local0)
		(SetQuitStr @local0)
	)
)

