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
	(Format @buffer {%15s: } aLabel)
	(FileIO fiWRITE_STRING logHandle @buffer)
	(= buffer 0)
	(switch how
		(1
			(StrCpy @buffer (if anArg anArg else {}))
		)
		(2
			(Format @buffer {%d} anArg)
		)
		(3
			(Format @buffer {%u} anArg)
		)
		(4
			(Format @buffer {%x} anArg)
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
				{%02d:%02d:%02d}
				(>> tm $000b)
				(& (>> tm $0005) $003f)
				(* (& tm $001f) 2)
			)
		)
		(7
			(= tm (GetTime 3)) ; SysDate
			(Format
				@buffer
				{%02d/%02d/%02d}
				(& (>> tm $0005) $000f)
				(& tm $001f)
				(+ 80 (>> tm $0009))
			)
		)
	)
	(StrCat @buffer {\0d\n})
	(FileIO fiWRITE_STRING logHandle @buffer)
	(return retval)
)

(instance sysLogger of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 40] [temp48 30] [temp78 30] [temp108 30] [temp138 30] [temp168 20] [temp188 40] [temp228 40] [temp268 40] [temp308 40] [temp348 40] [temp388 40])
		(= temp7 gInputFont)
		(= gInputFont 999)
		(= temp8
			(= temp78
				(= temp138
					(= temp188
						(= temp228
							(= temp268 (= temp308 (= temp348 (= temp388 0))))
						)
					)
				)
			)
		)
		(if (= temp4 (== 0 (StrLen @gSysLogPath)))
			(while (not (< 0 (StrLen @temp78) 19))
				(Print
					font: 999
					addText: {Enter drive letter, and path.}
					addEdit: @temp78 40 0 20
					init:
				)
			)
			(if
				(and
					(!= (StrAt @temp78 (- (StrLen @temp78) 1)) 92)
					(!= (StrAt @temp78 (- (StrLen @temp78) 1)) 58)
				)
				(Format @gSysLogPath {%s\5c} @temp78)
			else
				(StrCpy @gSysLogPath @temp78 40)
			)
		)
		(Format @temp78 {%sgame.mem} @gSysLogPath)
		(StrCpy @temp108 @temp78)
		(if (!= -1 (= logHandle (FileIO fiOPEN @temp78 1)))
			(FileIO fiREAD_STRING @temp168 80 logHandle)
			(FileIO fiREAD_STRING @temp48 80 logHandle)
			(FileIO fiCLOSE logHandle)
		else
			(= temp168 0)
			(StrCpy @temp48 {resource.cfg})
		)
		(if temp4
			(Print
				font: 999
				addText: {Enter your login name\n(max 8 characters):}
				addEdit: @temp168 12 0 20
				init:
			)
			(StrAt @temp168 8 0)
		)
		(while
			(and
				(or
					(not temp4)
					(Print
						font: 999
						addText:
							{Enter configuration file name\n(or hit return to skip):}
						addEdit: @temp48 30 0 20
						init:
					)
				)
				(== -1 (= logHandle (FileIO fiOPEN @temp48 1)))
				(StrAt @temp48 0)
			)
			(StrAt @temp48 0 0)
		)
		(if (!= -1 logHandle)
			(while (FileIO fiREAD_STRING @temp8 80 logHandle)
				(for
					((= temp0 0))
					(and (= temp3 (StrAt @temp8 temp0)) (OneOf temp3 9 32))
					((++ temp0))
				)
				(for
					((= temp1 0))
					(and
						(= temp3 (StrAt @temp8 temp0))
						(not (OneOf temp3 61 58 9 32))
					)
					((++ temp1))
					
					(StrAt @temp138 temp1 temp3)
					(++ temp0)
				)
				(StrAt @temp138 temp1 0)
				(if
					(= temp5
						(cond
							((== 0 (StrCmp @temp138 {kbdDrv}))
								@temp188
							)
							((== 0 (StrCmp @temp138 {joyDrv}))
								@temp228
							)
							((== 0 (StrCmp @temp138 {videoDrv}))
								@temp268
							)
							((== 0 (StrCmp @temp138 {soundDrv}))
								@temp308
							)
							((== 0 (StrCmp @temp138 {mouseDrv}))
								@temp348
							)
							((== 0 (StrCmp @temp138 {audioDrv}))
								@temp388
							)
						)
					)
					(while
						(and
							(= temp3 (StrAt @temp8 temp0))
							(OneOf temp3 61 58 9 32)
						)
						(++ temp0)
					)
					(= temp1 temp0)
					(= temp2 0)
					(while (= temp3 (StrAt @temp8 temp1))
						(if (OneOf temp3 58 92 47)
							(= temp0 (+ temp1 1))
						)
						(if (== temp3 46)
							(= temp2 (- temp1 temp0))
						)
						(++ temp1)
					)
					(if (== temp2 0)
						(= temp2 (- temp1 temp0))
					)
					(StrCpy temp5 (+ @temp8 temp0) temp2)
				)
			)
			(FileIO fiCLOSE logHandle)
		)
		(switch
			(Print
				font: 999
				addText: {Who messed up?}
				addButton: 0 {Carlos} 0 12
				addButton: 1 {Victor} 40 12
				addButton: 2 {Chris} 80 12
				addButton: 3 {Al} 120 12
				addButton: 4 {Art} 145 12
				init:
			)
			(0
				(Format @temp78 {%scarlos.log} @gSysLogPath)
			)
			(1
				(Format @temp78 {%svictor.log} @gSysLogPath)
			)
			(2
				(Format @temp78 {%schris.log} @gSysLogPath)
			)
			(3
				(Format @temp78 {%sal.log} @gSysLogPath)
			)
			(4
				(Format @temp78 {%sart.log} @gSysLogPath)
			)
		)
		(if
			(and
				temp4
				(or
					(== -1 (= logHandle (FileIO fiOPEN @temp78 1)))
					(and (Format @temp8 {Log file "%s" exists} @temp78) 0)
					(Print
						font: 999
						addText: @temp8
						addButton: 0 {Append to it} 0 12
						addButton: 1 {Overwrite it} 75 12
						init:
					)
				)
			)
			(FileIO fiCLOSE logHandle)
			(= logHandle (FileIO fiOPEN @temp78 2))
		else
			(= logHandle (FileIO fiOPEN @temp78 0))
		)
		(if (== -1 logHandle)
			(Print font: 999 addTextF: {Error: Couldn't open %s} @temp78 init:)
		else
			(Log 1 {GAME} (gGame name:))
			(Log 1 {VERSION} gVersion)
			(Log 7 {QA-DATE})
			(Log 1 {ANALYST} @temp168)
			(Log
				1
				{SEVERITY}
				(Print
					font: 999
					addText: {Severity of bug...}
					addButton: {Fatal} {FATAL} 0 12
					addButton: {Moderate} {MODERATE} 40 12
					addButton: {Minor} {MINOR} 100 12
					init:
				)
			)
			(Log
				1
				{REPRODUCIBLE}
				(Print
					font: 999
					addText: {Reproducible?}
					addButton: {Yes} {YES} 0 12
					addButton: {No} {NO} 40 12
					addButton: {Intermittent} {INTERMITTENT} 80 12
					init:
				)
			)
			(= temp0 1)
			(= temp6 1)
			(while (<= temp0 10)
				(Format @temp138 {QA-COMMENT%d} temp0)
				(Format @temp8 {Comment line %d of %d:} temp0 10)
				(if temp6
					(= temp6 (Log 5 @temp138 @temp8))
				else
					(Log 1 @temp138 0)
				)
				(++ temp0)
			)
			(Log 1 {DEPARTMENT} {N/A})
			(Format @temp8 {%04d} gCurRoomNum)
			(Log 1 {ROOM} @temp8)
			(= temp0 (gCurRoom script:))
			(Log 1 {ROOM-SCRIPT} (and temp0 (temp0 name:)))
			(Log 2 {ROOM-STATE} (and temp0 (temp0 state:)))
			(Log 2 {EGO-X} (gEgo x:))
			(Log 2 {EGO-Y} (gEgo y:))
			(Log 2 {EGO-Z} (gEgo z:))
			(= temp0 (gEgo script:))
			(Log 1 {EGO-SCRIPT} (and temp0 (temp0 name:)))
			(Log 2 {EGO-STATE} (and temp0 (temp0 state:)))
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
			(= temp0 (gEgo mover:))
			(Log 1 {EGO-MOVER} (and temp0 (temp0 name:)))
			(Log
				2
				{MOVER-X}
				(cond
					((not temp0) 0)
					((temp0 isMemberOf: PolyPath)
						(temp0 finalX:)
					)
					(else
						(temp0 x:)
					)
				)
			)
			(Log
				2
				{MOVER-Y}
				(cond
					((not temp0) 0)
					((temp0 isMemberOf: PolyPath)
						(temp0 finalY:)
					)
					(else
						(temp0 y:)
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
			(Log 1 {VIDEO-DRV} @temp268)
			(Log 1 {SOUND-DRV} @temp308)
			(Log 1 {AUDIO-DRV} @temp388)
			(Log 1 {KEYBOARD-DRV} @temp188)
			(Log 1 {JOY-DRV} @temp228)
			(Log 1 {MOUSE} @temp348)
			(Log 3 {LARGEST-HEAP} (MemoryInfo 0)) ; LargestPtr
			(Log 3 {FREE-HEAP} (MemoryInfo 1)) ; FreeHeap
			(Log 3 {TOTAL-HUNK} (>> (MemoryInfo 4) $0006)) ; TotalHunk
			(Log 3 {LARGEST-HUNK} (MemoryInfo miLARGESTHUNK))
			(Log 3 {FREE-HUNK} (>> (MemoryInfo miFREEHUNK) $0006))
			(FileIO fiWRITE_STRING logHandle {**********************************\0d\n})
			(FileIO fiCLOSE logHandle)
		)
		(if
			(and
				(== -1 (= logHandle (FileIO fiOPEN @temp108 2)))
				(== -1 (= logHandle (FileIO fiOPEN @temp108 0)))
			)
			(Print
				font: 999
				addTextF: {Error: Couldn't open memory file %s!} @temp108
				init:
			)
		else
			(FileIO fiWRITE_STRING logHandle @temp168)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiWRITE_STRING logHandle @temp48)
			(FileIO fiWRITE_STRING logHandle {\n})
			(FileIO fiCLOSE logHandle)
		)
		(= gInputFont temp7)
		(DisposeScript 952)
	)
)

