;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64952)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use PolyPath)
(use System)

(public
	sysLogger 0
)

(local
	logHandle
)

(procedure (Log how aLabel anArg &tmp buffer tm retval)
	(= buffer (Str newWith: 80 {}))
	(buffer format: {%15s: } aLabel)
	(FileIO fiWRITE_STRING logHandle (buffer data:))
	(buffer copy: {})
	(switch how
		(1
			(buffer copy: (if anArg anArg else {}))
		)
		(2
			(buffer format: {%d} anArg)
		)
		(3
			(buffer format: {%u} anArg)
		)
		(4
			(buffer format: {%x} anArg)
		)
		(5
			(if anArg
				(GetInput buffer 50 anArg 999)
			)
			(= retval (buffer size:))
		)
		(6
			(= tm (GetTime 2)) ; SysTime24
			(buffer
				format:
					{%02d:%02d:%02d}
					(>> tm $000b)
					(& (>> tm $0005) $003f)
					(* (& tm $001f) 2)
			)
		)
		(7
			(= tm (GetTime 3)) ; SysDate
			(buffer
				format:
					{%02d/%02d/%02d}
					(& (>> tm $0005) $000f)
					(& tm $001f)
					(+ 80 (>> tm $0009))
			)
		)
	)
	(buffer cat: {\0d\n})
	(FileIO fiWRITE_STRING logHandle (buffer data:))
	(buffer dispose:)
	(return retval)
)

(instance sysLogger of Code
	(properties)

	(method (doit &tmp i j l c firstNote theDrv commented saveInfont str cfgPath thePath theToken QAinitials kbdDrvEntry joyDrvEntry videoDrvEntry soundDrvEntry mouseDrvEntry audioDrvEntry)
		(= str (Str new: 80))
		(= cfgPath (Str new: 60))
		(= thePath (Str new: 60))
		(= theToken (Str new: 60))
		(= QAinitials (Str new: 40))
		(= kbdDrvEntry (Str new: 80))
		(= joyDrvEntry (Str new: 80))
		(= videoDrvEntry (Str new: 80))
		(= soundDrvEntry (Str new: 80))
		(= mouseDrvEntry (Str new: 80))
		(= audioDrvEntry (Str new: 80))
		(= saveInfont gInputFont)
		(= gInputFont 999)
		(if (= firstNote (not (gSysLogPath size:)))
			(while (not (< 0 (thePath size:) 19))
				(Print
					font: 999
					fore: 0
					back: (Palette 3 127 127 127) ; PalMatch
					addText:
						{Enter drive letter, path, and your name\n(no extension, max 40 characters)}
					addEdit: thePath 40 0 30
					init:
				)
			)
			(gSysLogPath copy: (thePath data:))
		)
		(thePath format: {%s.mem} (KString 9 gSysLogPath)) ; StrGetData
		(if (!= -1 (= logHandle (FileIO fiOPEN (thePath data:) 1)))
			(FileIO fiREAD_STRING (QAinitials data:) 80 logHandle)
			(FileIO fiREAD_STRING (cfgPath data:) 80 logHandle)
			(FileIO fiCLOSE logHandle)
		else
			(QAinitials copy: {})
			(cfgPath copy: {resource.cfg})
		)
		(if firstNote
			(Print
				font: 999
				addText: {Enter your login name\n(max 8 characters):}
				addEdit: QAinitials 12 0 30
				init:
			)
			(QAinitials at: 8 0)
		)
		(while
			(and
				(or
					(not firstNote)
					(Print
						font: 999
						addText: {Enter configuration file name:}
						addEdit: cfgPath 30 0 30 cfgPath
						init:
					)
				)
				(cfgPath at: 0)
				(== -1 (= logHandle (FileIO fiOPEN (cfgPath data:) 1)))
			)
			(cfgPath at: 0 0)
		)
		(if (!= -1 logHandle)
			(while (FileIO fiREAD_STRING (str data:) 80 logHandle)
				(for
					((= i 0))
					(and (= c (str at: i)) (OneOf c 9 32))
					((++ i))
				)
				(for
					((= j 0))
					(and
						(= c (str at: i))
						(not (OneOf c 61 58 9 32))
					)
					((++ j))
					
					(theToken at: j c)
					(++ i)
				)
				(theToken at: j 0)
				(if
					(= theDrv
						(cond
							((theToken compToFrom: 0 {kbdDrv} 0 6) kbdDrvEntry)
							((theToken compToFrom: 0 {joyDrv} 0 6) joyDrvEntry)
							((theToken compToFrom: 0 {videoDrv} 0 8) videoDrvEntry)
							((theToken compToFrom: 0 {soundDrv} 0 8) soundDrvEntry)
							((theToken compToFrom: 0 {mouseDrv} 0 8) mouseDrvEntry)
							((theToken compToFrom: 0 {audioDrv} 0 8) audioDrvEntry)
							(else 0)
						)
					)
					(while
						(and
							(= c (str at: i))
							(OneOf c 61 58 9 32)
						)
						(++ i)
					)
					(= j i)
					(= l 0)
					(while (= c (str at: j))
						(cond
							((OneOf c 58 92 47)
								(= i (+ j 1))
							)
							((== c 46)
								(= l (- j i))
							)
						)
						(++ j)
					)
					(if (== l 0)
						(= l (- j i))
					)
					(theDrv copyToFrom: 0 (str data:) i l)
				)
			)
			(FileIO fiCLOSE logHandle)
		)
		(thePath format: {%s.log} (KString 9 gSysLogPath)) ; StrGetData
		(if
			(and
				firstNote
				(or
					(== -1 (= logHandle (FileIO fiOPEN (thePath data:) 1)))
					(and
						(str format: {Log file "%s" exists} (thePath data:))
						0
					)
					(Print
						font: 999
						addText: str
						addButtonBM: 64990 2 0 0 {Append to it} 0 12
						addButtonBM: 64990 2 0 1 {Overwrite it} 75 12
						init:
					)
				)
			)
			(FileIO fiCLOSE logHandle)
			(= logHandle (FileIO fiOPEN (thePath data:) 2))
		else
			(= logHandle (FileIO fiOPEN (thePath data:) 0))
		)
		(if (== -1 logHandle)
			(Print font: 999 addTextF: {Error: Couldn't open %s} thePath init:)
		else
			(Log 1 {GAME} (gGlory name:))
			(Log 1 {VERSION} (if gVersion gVersion else {unknown}))
			(Log 7 {QA-DATE})
			(Log 1 {ANALYST} (QAinitials data:))
			(Log
				1
				{SEVERITY}
				(Print
					font: 999
					addText: {Severity of bug...}
					addButtonBM: 64990 2 0 {Fatal} {FATAL} 0 12
					addButtonBM: 64990 2 0 {Moderate} {MODERATE} 70 12
					addButtonBM: 64990 2 0 {Minor} {MINOR} 140 12
					saveCursor: 1
					init:
				)
			)
			(Log
				1
				{REPRODUCIBLE}
				(Print
					font: 999
					addText: {Reproducible?}
					addButtonBM: 64990 0 0 {Yes} {YES} 0 12
					addButtonBM: 64990 0 0 {No} {NO} 55 12
					addButtonBM: 64990 2 0 {Intermittent} {INTERMIT.} 110 12
					saveCursor: 1
					init:
				)
			)
			(= i 1)
			(= commented 1)
			(while (<= i 10)
				(theToken format: {QA-COMMENT%d} i)
				(str format: {Comment line %d of %d:} i 10)
				(if commented
					(= commented (Log 5 (theToken data:) (str data:)))
				else
					(Log 1 (theToken data:) 0)
				)
				(++ i)
			)
			(Log
				1
				{DEPARTMENT}
				(Print
					font: 999
					addText: {Who can fix bug...}
					addButtonBM: 64990 0 0 {Art} {ART} 0 12
					addButtonBM: 64990 0 0 {Programming} {PROG} 55 12
					addButtonBM: 64990 0 0 {Music} {MUSIC} 110 12
					addButtonBM: 64990 0 0 {Design} {DESIGN} 165 12
					saveCursor: 1
					init:
				)
			)
			(str format: {%5hu} gCurRoomNum)
			(Log 1 {ROOM} (str data:))
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
			(Log 2 {DETAIL-LEVEL} (gGlory detailLevel:))
			(Log 2 {CD-AUDIO} (& gMsgType $0002))
			(Log 1 {VIDEO-DRV} (videoDrvEntry data:))
			(Log 1 {SOUND-DRV} (soundDrvEntry data:))
			(Log 1 {AUDIO-DRV} (audioDrvEntry data:))
			(Log 1 {KEYBOARD-DRV} (kbdDrvEntry data:))
			(Log 1 {JOY-DRV} (joyDrvEntry data:))
			(Log 1 {MOUSE} (mouseDrvEntry data:))
			(Log 3 {LARGEST-HEAP} (MemoryInfo 0))
			(Log 3 {FREE-HEAP} (MemoryInfo 0))
			(Log 3 {TOTAL-HUNK} (>> (MemoryInfo 0) $0006))
			(Log 3 {LARGEST-HUNK} (MemoryInfo 0))
			(Log 3 {FREE-HUNK} (>> (MemoryInfo 0) $0006))
			(FileIO fiWRITE_STRING logHandle {**********************************\0d\n})
			(FileIO fiCLOSE logHandle)
		)
		(thePath format: {%s.mem} (KString 9 gSysLogPath)) ; StrGetData
		(if
			(and
				(== -1 (= logHandle (FileIO fiOPEN (thePath data:) 2)))
				(== -1 (= logHandle (FileIO fiOPEN (thePath data:) 0)))
			)
			(Print
				font: 999
				addTextF: {Error: Couldn't open memory file %s!} (thePath data:)
				init:
			)
		else
			(FileIO fiWRITE_STRING logHandle (QAinitials data:))
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle (cfgPath data:))
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiCLOSE logHandle)
		)
		(= gInputFont saveInfont)
		(str dispose:)
		(cfgPath dispose:)
		(thePath dispose:)
		(theToken dispose:)
		(QAinitials dispose:)
		(kbdDrvEntry dispose:)
		(joyDrvEntry dispose:)
		(videoDrvEntry dispose:)
		(soundDrvEntry dispose:)
		(mouseDrvEntry dispose:)
		(audioDrvEntry dispose:)
		(DisposeScript 64952)
	)
)

