;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 952)
(include sci.sh)
(use Main)
(use Print)
(use PolyPath)
(use System)

(public
	sysLogger 0
)

(local
	logHandle
)

(procedure (Log how aLabel anArg &tmp [buffer 40] tm retval)
	(Format @buffer 952 0 aLabel)
	(FileIO fiWRITE_STRING logHandle @buffer)
	(= buffer 0)
	(switch how
		(1
			(StrCpy @buffer (if anArg anArg else {}))
		)
		(2
			(Format @buffer 952 1 anArg)
		)
		(3
			(Format @buffer 952 2 anArg)
		)
		(4
			(Format @buffer 952 3 anArg)
		)
		(5
			(if anArg
				(GetInput @buffer 66 anArg 999)
			)
			(= retval (StrLen @buffer))
		)
		(6
			(= tm (GetTime 2)) ; SysTime24
			(Format
				@buffer
				952
				4
				(>> tm $000b)
				(& (>> tm $0005) $003f)
				(* (& tm $001f) 2)
			)
		)
		(7
			(= tm (GetTime 3)) ; SysDate
			(Format
				@buffer
				952
				5
				(& (>> tm $0005) $000f)
				(& tm $001f)
				(+ 80 (>> tm $0009))
			)
		)
	)
	(StrCat @buffer {\r\n})
	(FileIO fiWRITE_STRING logHandle @buffer)
	(return retval)
)

(instance sysLogger of Code
	(properties)

	(method (doit &tmp i j l c firstNote theDrv commented saveInfont [str 40] [cfgPath 30] [thePath 30] [theToken 30] [QAinitials 20] [kbdDrvEntry 40] [joyDrvEntry 40] [videoDrvEntry 40] [soundDrvEntry 40] [mouseDrvEntry 40] [audioDrvEntry 40])
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
				(Print
					font: 999
					addText:
						{Enter drive letter, path, and your name\n(no extension, max 40 characters)}
					addEdit: @thePath 40 0 20
					init:
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
			(Print
				font: 999
				addText: {Enter your login name\n(max 8 characters):}
				addEdit: @QAinitials 12 0 20
				init:
			)
			(StrAt @QAinitials 8 0)
		)
		(while
			(and
				(or
					(not firstNote)
					(Print
						font: 999
						addText:
							{Enter configuration file name\n(or hit return to skip):}
						addEdit: @cfgPath 30 0 20
						init:
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
						font: 999
						addText: @str
						addButton: 0 {Append to it} 0 12
						addButton: 1 {Overwrite it} 75 12
						saveCursor: 1
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
			(Print font: 999 addTextF: {Error: Couldn't open %s} @thePath init:)
		else
			(Log 1 {GAME} (gGame name:))
			(Log 1 {VERSION} gVersion)
			(Log 7 {QA-DATE})
			(Log 1 {ANALYST} @QAinitials)
			(Log
				1
				{SEVERITY}
				(Print
					font: 999
					addText: {Severity of bug...}
					addButton: {F} {FATAL} 0 12
					addButton: {N} {NON-FATAL} 40 12
					addButton: {S} {SUGGESTION} 110 12
					saveCursor: 1
					init:
				)
			)
			(= i 1)
			(= commented 1)
			(while (<= i 10)
				(Format @theToken 952 9 i)
				(Format @str 952 10 i 10)
				(if commented
					(= commented (Log 5 @theToken @str))
				else
					(Log 1 @theToken 0)
				)
				(++ i)
			)
			(Log
				1
				{DEPARTMENT}
				(Print
					font: 999
					addText: {Who can fix bug...}
					addButton: {P} {PROG} 0 12
					addButton: {A} {ART} 40 12
					addButton: {D} {DESIGN} 80 12
					saveCursor: 1
					init:
				)
			)
			(Log 2 {ROOM} gCurRoomNum)
			(= i (gCurRoom script:))
			(Log 1 {ROOM-SCRIPT} (and i (i name:)))
			(Log 2 {ROOM-STATE} (and i (i state:)))
			(Log 2 {EGO-X} (gEgo x:))
			(Log 2 {EGO-Y} (gEgo y:))
			(Log 2 {EGO-Z} (gEgo z:))
			(= i (gEgo script:))
			(Log 1 {EGO-SCRIPT} (and i (i name:)))
			(Log 2 {EGO-STATE} (and i (i state:)))
			(Log 2 {EGO-VIEW} (gEgo view:))
			(Log 2 {EGO-LOOP} (gEgo loop:))
			(Log 2 {EGO-CEL} (gEgo cel:))
			(Log 2 {EGO-PRIORITY} (gEgo priority:))
			(Log 2 {EGO-HEADING} (gEgo heading:))
			(Log
				1
				{CYCLER}
				(and (gEgo cycler:) ((gEgo cycler:) name:))
			)
			(= i (gEgo mover:))
			(Log 1 {EGO-MOVER} (and i (i name:)))
			(Log
				2
				{MOVER-X}
				(cond
					((not i) 0)
					((i isMemberOf: PolyPath)
						(i finalX:)
					)
					(else
						(i x:)
					)
				)
			)
			(Log
				2
				{MOVER-Y}
				(cond
					((not i) 0)
					((i isMemberOf: PolyPath)
						(i finalY:)
					)
					(else
						(i y:)
					)
				)
			)
			(Log 2 {EGO-MOVESPD} (gEgo moveSpeed:))
			(Log 4 {SIGNAL-BITS} (gEgo signal:))
			(Log 4 {ILLEGAL-BITS} (gEgo illegalBits:))
			(Log 2 {HOWFAST} gHowFast)
			(Log 1 {ICONBAR} (and gTheIconBar (gTheIconBar name:)))
			(Log
				1
				{CUR-ICON}
				(and gTheIconBar (gTheIconBar curIcon:) ((gTheIconBar curIcon:) name:))
			)
			(Log 2 {DETAIL-LEVEL} (gGame detailLevel:))
			(Log 2 {CD-AUDIO} (& gMsgType $0002))
			(Log 1 {VIDEO-DRV} @videoDrvEntry)
			(Log 1 {SOUND-DRV} @soundDrvEntry)
			(Log 1 {AUDIO-DRV} @audioDrvEntry)
			(Log 1 {KEYBOARD-DRV} @kbdDrvEntry)
			(Log 1 {JOY-DRV} @joyDrvEntry)
			(Log 1 {MOUSE} @mouseDrvEntry)
			(Log 3 {LARGEST-HEAP} (MemoryInfo 0)) ; LargestPtr
			(Log 3 {FREE-HEAP} (MemoryInfo 1)) ; FreeHeap
			(Log 3 {TOTAL-HUNK} (>> (MemoryInfo 4) $0006)) ; TotalHunk
			(Log 3 {LARGEST-HUNK} (MemoryInfo miLARGESTHUNK))
			(Log 3 {FREE-HUNK} (>> (MemoryInfo miFREEHUNK) $0006))
			(FileIO fiWRITE_STRING logHandle {**********************************\r\n})
			(FileIO fiCLOSE logHandle)
		)
		(Format @thePath 952 6 @gSysLogPath)
		(if
			(and
				(== -1 (= logHandle (FileIO fiOPEN @thePath 2)))
				(== -1 (= logHandle (FileIO fiOPEN @thePath 0)))
			)
			(Print
				font: 999
				addTextF: {Error: Couldn't open memory file %s!} @thePath
				init:
			)
		else
			(FileIO fiWRITE_STRING logHandle @QAinitials)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle @cfgPath)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiCLOSE logHandle)
		)
		(= gInputFont saveInfont)
		(DisposeScript 952)
	)
)

