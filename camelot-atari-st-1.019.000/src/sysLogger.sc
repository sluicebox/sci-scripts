;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 952)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use System)

(public
	sysLogger 0
	login 1
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 (GetTime 2)) ; SysTime24
	(Format
		param1
		952
		0
		(>> temp0 $000b)
		(& (>> temp0 $0005) $003f)
		(* (& temp0 $001f) 2)
	)
	(return param1)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 (GetTime 3)) ; SysDate
	(Format
		param1
		952
		1
		(& (>> temp0 $0005) $000f)
		(& temp0 $001f)
		(+ 84 (& (>> temp0 $0009) $003f))
	)
	(return param1)
)

(procedure (localproc_2 param1)
	(if (IsObject (gEgo mover:))
		(StrCat param1 ((gEgo mover:) name:))
		(StrCat param1 { })
	)
)

(procedure (localproc_3 param1)
	(if (IsObject (gEgo cycler:))
		(StrCat param1 ((gEgo cycler:) name:))
		(StrCat param1 { })
	)
)

(procedure (localproc_4 param1 &tmp [temp0 10])
	(if (IsObject (gEgo script:))
		(StrCat param1 ((gEgo script:) name:))
		(StrCat param1 (Format @temp0 952 2 ((gEgo script:) state:)))
	)
)

(procedure (localproc_5 param1 &tmp [temp0 30])
	(StrCpy @temp0 {})
	(GetInput @temp0 30 {Please enter your name...})
	(StrCat @temp0 {.log})
	(StrCpy param1 @temp0 19)
)

(procedure (localproc_6 param1 &tmp [temp0 200] temp200 temp201)
	(= temp201 (FOpen param1 0))
	(FPuts temp201 {CONFIGURATION~})
	(FPuts temp201 param1)
	(FPuts temp201 {~})
	(= temp200 (FOpen {resource.cfg} 1))
	(while (FGets @temp0 80 temp200)
		(FPuts temp201 @temp0)
		(FPuts temp201 { })
	)
	(FPuts temp201 {\0d\n\0d\n})
	(FClose temp200)
	(FClose temp201)
)

(instance sysLogger of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 [temp1 200] [temp201 10] [temp211 10] temp221 [temp222 9])
		(if (not (StrLen param1))
			(localproc_5 param1)
			(localproc_6 param1)
		)
		(if
			(switch
				(Print
					952
					3
					#button
					{PROG}
					1
					#button
					{ART}
					2
					#button
					{DESIGN}
					3
					#button
					{FATAL}
					4
				)
				(0 0)
				(1
					(= temp221 {PROG})
				)
				(2
					(= temp221 { ART })
				)
				(3
					(= temp221 {DESIGN})
				)
				(4
					(= temp221 {FATAL})
				)
			)
			(= temp0 (FOpen param1 0))
			(Format
				@temp1
				952
				4
				gCurRoomNum
				gVersion
				(localproc_1 @temp211)
				(localproc_0 @temp201)
				temp221
				param1
			)
			(FPuts temp0 @temp1)
			(Format
				@temp1
				952
				5
				(gEgo x:)
				(gEgo y:)
				(gEgo view:)
				(gEgo loop:)
				(gEgo cel:)
				(gEgo signal:)
			)
			(localproc_2 @temp1)
			(localproc_3 @temp1)
			(localproc_4 @temp1)
			(if (IsObject param2)
				(param2 doit: (StrEnd @temp1))
			)
			(StrCat @temp1 {\0d\n~})
			(FPuts temp0 @temp1)
			(repeat
				(= temp1 0)
				(GetInput @temp1 50 {Log Entry...})
				(if (== (StrLen @temp1) 0)
					(FPuts temp0 {~\0d\n\0d\n})
					(FClose temp0)
					(break)
				)
				(FPuts temp0 @temp1)
				(FPuts temp0 {\0d\n})
			)
		)
		(DisposeScript 952)
	)
)

(instance login of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 [temp2 32])
		(= temp1 0)
		(while 1
			(StrCpy @temp2 {})
			(switch
				(= temp0
					(Print
						{ Enter Room # }
						#edit
						@temp2
						10
						#button
						{Restore}
						1
						#button
						{QA}
						2
						#title
						{ Conquests of Camelot }
						#window
						SysWindow
					)
				)
				(0 0)
				(1
					(gGame restore:)
				)
				(2
					(= temp2 0)
					(StrCat @temp2 {C:\\CAMLOGS\5c})
					(Print
						{Please enter your log name...}
						#edit
						@temp2
						25
						#window
						SysWindow
					)
					(if (<= (StrLen @temp2) 4)
						(Printf 952 6)
						(continue)
					else
						(StrCat @temp2 {.log})
						(StrCpy param1 @temp2 19)
						(break)
					)
				)
				(else
					(= temp1 (ReadNumber @temp2))
					(break)
				)
			)
		)
		(localproc_6 param1)
		(DisposeScript 952)
		(return temp1)
	)
)

