;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use System)

(public
	eco2InitCode 0
)

(instance eco2InitCode of Code
	(properties)

	(method (init &tmp temp0 temp1 [temp2 5] [temp7 10] [temp17 10])
		(= gPossibleScore 1000)
		(= gUserFont 1207)
		(Print font: 1207)
		((ScriptID 99 0) init:) ; invSetupCode
		((= gNarrator Narrator) font: gUserFont keepWindow: 1)
		(= gMsgType 1)
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiREAD_STRING global131 20 temp1)
		(FileIO fiREAD_STRING global132 20 temp1)
		(FileIO fiREAD_STRING global133 20 temp1)
		(FileIO fiCLOSE temp1)
		(= gUseSortedFeatures 1)
		(= gEatMice 6)
		(Message msgGET 999 14 0 1 1 @temp7) ; "%d.scr"
		(Format @temp17 @temp7 98)
		(if (FileIO fiEXISTS @temp17)
			(= global134 1)
			(StrCpy @gSysLogPath {})
			(gGame setCursor: 999 1 304 172)
			(while 1
				(= temp0
					(Print
						font: gSmallFont
						addText: 14 0 11 1 0 0 999 ; "Where to, Mac?"
						addEdit: @temp2 5 115 0
						addButton: 40 14 0 3 1 0 16 999 ; "INTRO"
						addButton: 100 14 0 4 1 0 32 999 ; "DOCKS"
						addButton: 700 14 0 9 1 0 48 999 ; "FLOODED FOREST"
						addButton: 501 14 0 7 1 0 64 999 ; "CIBOLA"
						addButton: 600 14 0 8 1 0 80 999 ; "CAVES"
						addButton: 840 14 0 10 1 0 96 999 ; "CITY OF GOLD"
						addButton: 220 14 0 5 1 0 112 999 ; "JUNGLE"
						addButton: 300 14 0 6 1 0 128 999 ; "VILLAGE"
						addButton: -100 14 0 12 1 0 144 999 ; "RESTORE"
						init:
					)
				)
				(if temp2
					(= temp0 (ReadNumber @temp2))
				)
				(cond
					((> temp0 0)
						(= global100 temp0)
						(break)
					)
					((< temp0 0)
						(gGame restore:)
					)
				)
			)
		else
			(= global134 0)
			(= global100 40)
		)
		(gGame setCursor: gWaitCursor 1 304 172 detailLevel: 5)
		(= global105 (DoSound sndGET_POLYPHONY))
		(gSystemWindow color: 0 back: 67)
	)
)

