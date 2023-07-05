;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 952)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	sysLogger 0
)

(local
	logHandle
)

(procedure (Log how aLabel anArg &tmp [buffer 40] tm retval)
	(FileIO fiWRITE_STRING logHandle aLabel)
	(FileIO fiWRITE_STRING logHandle {: })
	(= buffer 0)
	(switch how
		(1
			(StrCpy @buffer anArg)
		)
		(2
			(Format @buffer 952 0 anArg)
		)
		(3
			(Format @buffer 952 1 anArg)
		)
		(4
			(if anArg
				(GetInput @buffer 50 anArg)
			)
			(= retval (StrLen @buffer))
		)
		(5
			(= tm (GetTime 2)) ; SysTime24
			(Format
				@buffer
				952
				2
				(>> tm $000b)
				(& (>> tm $0005) $003f)
				(* (& tm $001f) 2)
			)
		)
		(6
			(= tm (GetTime 3)) ; SysDate
			(Format
				@buffer
				952
				3
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

	(method (doit &tmp i j l c firstNote theDrv commented [saveInfont 40] [str 30] [cfgPath 30] [thePath 30] [theToken 30] [QAinitials 5] [kbdDrvEntry 40] [joyDrvEntry 40] [videoDrvEntry 40] [soundDrvEntry 40] [mouseDrvEntry 40] [audioDrvEntry 40])
		(= saveInfont
			(= cfgPath
				(= theToken
					(= kbdDrvEntry
						(= joyDrvEntry (= videoDrvEntry (= soundDrvEntry (= mouseDrvEntry 0))))
					)
				)
			)
		)
		(if (= firstNote (== 0 (StrLen @gSysLogPath)))
			(GetInput @cfgPath 30 {Enter drive letter and your name...})
			(StrCpy @thePath @cfgPath 19)
		)
		(Format @cfgPath 952 4 @thePath)
		(if (!= -1 (= logHandle (FileIO fiOPEN @cfgPath 1)))
			(FileIO fiREAD_STRING @QAinitials 80 logHandle)
			(FileIO fiREAD_STRING @str 80 logHandle)
			(FileIO fiREAD_STRING @audioDrvEntry 80 logHandle)
			(FileIO fiCLOSE logHandle)
		else
			(= QAinitials 0)
			(StrCpy @str {resource.cfg})
			(StrCpy @audioDrvEntry {IBM})
		)
		(while
			(and
				(or
					(not firstNote)
					(GetInput
						@str
						30
						{Enter configuration file name (or hit return to skip):}
					)
				)
				(== -1 (= logHandle (FileIO fiOPEN @str 1)))
				(StrAt @str 0)
			)
			(StrAt @str 0 0)
		)
		(if (!= -1 logHandle)
			(while (FileIO fiREAD_STRING @saveInfont 80 logHandle)
				(for
					((= i 0))
					(and
						(= c (StrAt @saveInfont i))
						(not (OneOf c 61 58 9 32))
					)
					((++ i))
					
					(StrAt @theToken i c)
				)
				(StrAt @theToken i 0)
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
						)
					)
					(while
						(and
							(= c (StrAt @saveInfont i))
							(OneOf c 61 58 9 32)
						)
						(++ i)
					)
					(= j i)
					(= l 0)
					(while (= c (StrAt @saveInfont j))
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
					(StrCpy theDrv (+ @saveInfont i) l)
				)
			)
			(FileIO fiCLOSE logHandle)
		else
			(StrCpy @kbdDrvEntry {noConfigFileSpecified})
			(StrCpy @joyDrvEntry @kbdDrvEntry)
			(StrCpy @videoDrvEntry @kbdDrvEntry)
			(StrCpy @soundDrvEntry @kbdDrvEntry)
			(StrCpy @mouseDrvEntry @kbdDrvEntry)
		)
		(Format @cfgPath 952 5 @thePath)
		(if (== -1 (= logHandle (FileIO fiOPEN @cfgPath 0)))
			(Printf 952 6 @cfgPath)
		else
			(if (and firstNote (Print 952 7 #button {yes} 1 #button {no} 0))
				(FileIO fiCLOSE logHandle)
				(= logHandle (FileIO fiOPEN @cfgPath 2))
				(if (== -1 logHandle)
					(= logHandle (FileIO fiOPEN @cfgPath 0))
				)
			)
			(Log 1 {GAME} (gGame name:))
			(Log 1 {VERSION} gVersion)
			(Log 2 {ROOM} gCurRoomNum)
			(Log 2 {EGO-X} (gEgo x:))
			(Log 2 {EGO-Y} (gEgo y:))
			(Log 2 {EGO-Z} (gEgo z:))
			(Log 2 {EGO-HEADING} (gEgo heading:))
			(Log 2 {EGO-VIEW} (gEgo view:))
			(Log 2 {EGO-LOOP} (gEgo loop:))
			(Log 2 {EGO-CEL} (gEgo cel:))
			(Log 2 {EGO-PRIORITY} (gEgo priority:))
			(Log 3 {SIGNAL-BITS} (gEgo signal:))
			(Log
				1
				{CYCLER}
				(if (gEgo cycler:)
					((gEgo cycler:) name:)
				else
					{noCycler}
				)
			)
			(Log
				1
				{SCRIPT}
				(if (gEgo script:)
					((gEgo script:) name:)
				else
					{noScript}
				)
			)
			(if firstNote
				(GetInput
					@audioDrvEntry
					5
					{Enter your computer name (up to 3 characters):}
				)
				(StrAt @audioDrvEntry 3 0)
			)
			(Log 1 {MACHINE} @audioDrvEntry)
			(Log 1 {VIDEO} @videoDrvEntry)
			(Log 1 {SOUND} @soundDrvEntry)
			(Log 1 {KEYBOARD} @kbdDrvEntry)
			(Log 1 {JOYSTICK} @joyDrvEntry)
			(Log 1 {MOUSE} @mouseDrvEntry)
			(Log 6 {QA-DATE})
			(if firstNote
				(GetInput
					@QAinitials
					5
					{Enter your initials (up to 3 characters):}
				)
				(StrAt @QAinitials 3 0)
			)
			(Log 1 {ANALYST} @QAinitials)
			(Log
				1
				{SEVERITY}
				(Print
					952
					8
					#button
					{FATAL}
					{F}
					#button
					{NON-FATAL}
					{N}
					#button
					{SUGGESTION}
					{S}
				)
			)
			(= commented (Log 4 {QA-COMMENT1} {Comment line 1 of 5:}))
			(= commented
				(Log 4 {QA-COMMENT2} (and commented {Comment line 2 of 5:}))
			)
			(= commented
				(Log 4 {QA-COMMENT3} (and commented {Comment line 3 of 5:}))
			)
			(= commented
				(Log 4 {QA-COMMENT4} (and commented {Comment line 4 of 5:}))
			)
			(Log 4 {QA-COMMENT5} (and commented {Comment line 5 of 5:}))
			(Log
				1
				{DEPARTMENT}
				(Print 952 8 #button {PROG} {P} #button {ART} {A} #button {DESIGN} {D})
			)
			(FileIO fiWRITE_STRING logHandle {**********************************\r\n})
			(FileIO fiCLOSE logHandle)
		)
		(Format @cfgPath 952 4 @thePath)
		(if
			(and
				(== -1 (= logHandle (FileIO fiOPEN @cfgPath 2)))
				(== -1 (= logHandle (FileIO fiOPEN @cfgPath 0)))
			)
			(Printf 952 9 @cfgPath)
		else
			(FileIO fiWRITE_STRING logHandle @QAinitials)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle @str)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle @audioDrvEntry)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiCLOSE logHandle)
		)
		(StrCpy @gSysLogPath @thePath)
		(DisposeScript 952)
	)
)

