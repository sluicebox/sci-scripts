;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 952)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Print)
(use Window)
(use System)

(public
	sysLogger 0
)

(local
	logHandle
)

(procedure (localproc_0 param1 param2 param3 param4)
	(if
		(Print
			font: (if (> argc 3) param4 else 0)
			addText: (if (and (> argc 2) param3) param3 else {})
			addEdit: param1 param2 0 30 param1
			init:
		)
		(StrLen param1)
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp [temp0 40] temp40 temp41)
	(Format @temp0 952 0 param2)
	(FileIO fiWRITE_STRING logHandle @temp0)
	(= temp0 0)
	(switch param1
		(1
			(StrCpy @temp0 (if param3 param3 else {}))
		)
		(2
			(Format @temp0 952 1 param3)
		)
		(3
			(Format @temp0 952 2 param3)
		)
		(4
			(Format @temp0 952 3 param3)
		)
		(5
			(if param3
				(localproc_0 @temp0 66 param3 3)
			)
			(= temp41 (StrLen @temp0))
		)
		(6
			(= temp40 (GetTime 2)) ; SysTime24
			(Format
				@temp0
				952
				4
				(>> temp40 $000b)
				(& (>> temp40 $0005) $003f)
				(* (& temp40 $001f) 2)
			)
		)
		(7
			(= temp40 (GetTime 3)) ; SysDate
			(Format
				@temp0
				952
				5
				(& (>> temp40 $0005) $000f)
				(& temp40 $001f)
				(+ 80 (>> temp40 $0009))
			)
		)
	)
	(StrCat @temp0 {\r\n})
	(FileIO fiWRITE_STRING logHandle @temp0)
	(return temp41)
)

(instance sysLogger of Code
	(properties)

	(method (doit &tmp i j l c firstNote theDrv commented saveInfont [str 40] [cfgPath 30] [thePath 30] [theToken 30] [QAinitials 5] [kbdDrvEntry 40] [joyDrvEntry 40] [videoDrvEntry 40] [soundDrvEntry 40] [mouseDrvEntry 40] [audioDrvEntry 40])
		(= gSystemWindow SysWindow)
		(= saveInfont gInputFont)
		(= gInputFont 999)
		(= str
			(= thePath
				(= theToken
					(= kbdDrvEntry
						(= joyDrvEntry
							(= videoDrvEntry (= soundDrvEntry (= mouseDrvEntry (= audioDrvEntry 0))))
						)
					)
				)
			)
		)
		(if (= firstNote (== 0 (StrLen @gSysLogPath)))
			(while (not (< 0 (StrLen @thePath) 19))
				(localproc_0
					@thePath
					40
					{Enter drive letter, path and your name\n(no extension, max 40 characters)}
					3
				)
			)
			(StrCpy @gSysLogPath @thePath 40)
		)
		(Format @thePath 952 6 @gSysLogPath)
		(if (!= -1 (= logHandle (FileIO fiOPEN @thePath 1)))
			(FileIO fiREAD_STRING @QAinitials 80 logHandle)
			(FileIO fiREAD_STRING @cfgPath 80 logHandle)
			(FileIO fiCLOSE logHandle)
		else
			(= QAinitials 0)
			(StrCpy @cfgPath {resource.cfg})
		)
		(if firstNote
			(localproc_0
				@QAinitials
				5
				{Enter your initials (up to 3 characters):}
				3
			)
			(StrAt @QAinitials 3 0)
		)
		(while
			(and
				(or
					(not firstNote)
					(localproc_0
						@cfgPath
						30
						{Enter configuration file name\n(or press Enter to skip):}
						3
					)
				)
				(== -1 (= logHandle (FileIO fiOPEN @cfgPath 1)))
				(StrAt @cfgPath 0)
			)
			(StrAt @cfgPath 0 0)
		)
		(if (!= -1 logHandle)
			(while (FileIO fiREAD_STRING @str 80 logHandle)
				(for
					((= i 0))
					(and (= c (StrAt @str i)) (OneOf c 9 32))
					((++ i))
				)
				(for
					((= j 0))
					(and
						(= c (StrAt @str i))
						(not (OneOf c 61 58 9 32))
					)
					((++ j))
					
					(StrAt @theToken j c)
					(++ i)
				)
				(StrAt @theToken j 0)
				(if
					(= theDrv
						(cond
							((== 0 (StrCmp @theToken {kbdDrv}))
								@kbdDrvEntry
							)
							((== 0 (StrCmp @theToken {joyDrv}))
								@joyDrvEntry
							)
							((== 0 (StrCmp @theToken {videoDrv}))
								@videoDrvEntry
							)
							((== 0 (StrCmp @theToken {soundDrv}))
								@soundDrvEntry
							)
							((== 0 (StrCmp @theToken {mouseDrv}))
								@mouseDrvEntry
							)
							((== 0 (StrCmp @theToken {audioDrv}))
								@audioDrvEntry
							)
						)
					)
					(while
						(and
							(= c (StrAt @str i))
							(OneOf c 61 58 9 32)
						)
						(++ i)
					)
					(= j i)
					(= l 0)
					(while (= c (StrAt @str j))
						(if (OneOf c 58 92 47)
							(= i (+ j 1))
						)
						(if (== c 46)
							(= l (- j i))
						)
						(++ j)
					)
					(if (== l 0)
						(= l (- j i))
					)
					(StrCpy theDrv (+ @str i) l)
				)
			)
			(FileIO fiCLOSE logHandle)
		)
		(Format @thePath 952 7 @gSysLogPath)
		(if
			(and
				firstNote
				(or
					(== -1 (= logHandle (FileIO fiOPEN @thePath 1)))
					(and (Format @str 952 8 @thePath) 0)
					(Print
						addText: @str
						addButton: 0 {append to it} 0 12
						addButton: 1 {overwrite it} 75 12
						init:
					)
				)
			)
			(FileIO fiCLOSE logHandle)
			(= logHandle (FileIO fiOPEN @thePath 2))
		else
			(= logHandle (FileIO fiOPEN @thePath 0))
		)
		(if (== -1 logHandle)
			(Print addTextF: @str {error: couldn't open %s} @thePath init:)
		else
			(localproc_1 1 {GAME} (gGame name:))
			(localproc_1 1 {VERSION} gVersion)
			(localproc_1 7 {QA-DATE})
			(localproc_1 1 {ANALYST} @QAinitials)
			(localproc_1
				1
				{SEVERITY}
				(Print
					addText: {Severity of bug...}
					addButton: {F} {FATAL} 0 12
					addButton: {N} {NON-FATAL} 54 12
					addButton: {S} {SUGGESTION} 140 12
					init:
				)
			)
			(= i 1)
			(= commented 1)
			(while (<= i 10)
				(Format @theToken 952 9 i)
				(Format @str 952 10 i 10)
				(if commented
					(= commented (localproc_1 5 @theToken @str))
				else
					(localproc_1 1 @theToken 0)
				)
				(++ i)
			)
			(localproc_1
				1
				{DEPARTMENT}
				(Print
					addText: {Who can fix bug...}
					addButton: {P} {PROG} 0 12
					addButton: {A} {ART} 55 12
					addButton: {D} {DESIGN} 92 12
					init:
				)
			)
			(localproc_1 2 {ROOM} gCurRoomNum)
			(= i (gCurRoom script:))
			(localproc_1 1 {ROOM-SCRIPT} (and i (i name:)))
			(localproc_1 2 {ROOM-STATE} (and i (i state:)))
			(localproc_1 2 {EGO-X} (gEgo x:))
			(localproc_1 2 {EGO-Y} (gEgo y:))
			(localproc_1 2 {EGO-Z} (gEgo z:))
			(= i (gEgo script:))
			(localproc_1 1 {EGO-SCRIPT} (and i (i name:)))
			(localproc_1 2 {EGO-STATE} (and i (i state:)))
			(localproc_1 2 {EGO-VIEW} (gEgo view:))
			(localproc_1 2 {EGO-LOOP} (gEgo loop:))
			(localproc_1 2 {EGO-CEL} (gEgo cel:))
			(localproc_1 2 {EGO-PRIORITY} (gEgo priority:))
			(localproc_1 2 {EGO-HEADING} (gEgo heading:))
			(localproc_1
				1
				{CYCLER}
				(and (gEgo cycler:) ((gEgo cycler:) name:))
			)
			(= i (gEgo mover:))
			(localproc_1 1 {EGO-MOVER} (and i (i name:)))
			(localproc_1
				2
				{MOVER-X}
				(if (not i)
					0
				else
					(i x:)
				)
			)
			(localproc_1
				2
				{MOVER-Y}
				(if (not i)
					0
				else
					(i y:)
				)
			)
			(localproc_1 2 {EGO-MOVESPD} (gEgo moveSpeed:))
			(localproc_1 4 {SIGNAL-BITS} (gEgo signal:))
			(localproc_1 4 {ILLEGAL-BITS} (gEgo illegalBits:))
			(localproc_1 2 {HOWFAST} gHowFast)
			(localproc_1 1 {ICONBAR} (and gTheIconBar (gTheIconBar name:)))
			(localproc_1
				1
				{CUR-ICON}
				(and gTheIconBar (gTheIconBar curIcon:) ((gTheIconBar curIcon:) name:))
			)
			(localproc_1 2 {DETAIL-LEVEL} (gGame detailLevel:))
			(localproc_1 2 {CD-AUDIO} global83)
			(localproc_1 1 {VIDEO-DRV} @videoDrvEntry)
			(localproc_1 1 {SOUND-DRV} @soundDrvEntry)
			(localproc_1 1 {AUDIO-DRV} @audioDrvEntry)
			(localproc_1 1 {KEYBOARD-DRV} @kbdDrvEntry)
			(localproc_1 1 {JOY-DRV} @joyDrvEntry)
			(localproc_1 1 {MOUSE} @mouseDrvEntry)
			(localproc_1 3 {LARGEST-HEAP} (MemoryInfo 0)) ; LargestPtr
			(localproc_1 3 {FREE-HEAP} (MemoryInfo 1)) ; FreeHeap
			(localproc_1 3 {TOTAL-HUNK} (>> (MemoryInfo 4) $0006)) ; TotalHunk
			(localproc_1 3 {LARGEST-HUNK} (MemoryInfo miLARGESTHUNK))
			(localproc_1 3 {FREE-HUNK} (>> (MemoryInfo miFREEHUNK) $0006))
			(FileIO fiWRITE_STRING logHandle {**********************************\r\n})
			(FileIO fiCLOSE logHandle)
		)
		(Format @thePath 952 6 @gSysLogPath)
		(if
			(and
				(== -1 (= logHandle (FileIO fiOPEN @thePath 2)))
				(== -1 (= logHandle (FileIO fiOPEN @thePath 0)))
			)
			(Print addTextF: @str {couldn't open memory file %s!} @thePath init:)
		else
			(FileIO fiWRITE_STRING logHandle @QAinitials)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle @cfgPath)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiCLOSE logHandle)
		)
		(= gInputFont saveInfont)
		(= gSystemWindow HoyleWindow)
		(DisposeScript 952)
		(DisposeScript 922)
	)
)

