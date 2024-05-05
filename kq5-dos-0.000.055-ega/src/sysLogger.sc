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
		(+ 80 (>> temp0 $0009))
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

(instance sysLogger of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 [temp2 200] [temp202 10] [temp212 10] temp222 [temp223 9] [temp232 30])
		(if (not (StrLen param1))
			(StrCpy @temp232 {})
			(while (< (StrLen @temp232) 4)
				(GetInput @temp232 30 {Enter drive letter and your initials:})
			)
			(StrCat @temp232 {.log})
			(StrCpy param1 @temp232 19)
			(= temp0 (FileIO fiOPEN param1 0))
			(FileIO fiWRITE_STRING temp0 {CONFIGURATION~})
			(FileIO fiWRITE_STRING temp0 param1)
			(FileIO fiWRITE_STRING temp0 {~})
			(= temp1 (FileIO fiOPEN {resource.cfg} 1))
			(while (FileIO fiREAD_STRING @temp2 80 temp1)
				(FileIO fiWRITE_STRING temp0 @temp2)
				(FileIO fiWRITE_STRING temp0 { })
			)
			(FileIO fiWRITE_STRING temp0 {\0d\n\0d\n})
			(FileIO fiCLOSE temp1)
			(FileIO fiCLOSE temp0)
		)
		(= temp0 (FileIO fiOPEN param1 0))
		(switch (Print 952 3 #button {PROG} 0 #button {ART} 1 #button {DESIGN} 2)
			(0
				(= temp222 {PROG})
			)
			(1
				(= temp222 { ART })
			)
			(2
				(= temp222 {DESIGN})
			)
		)
		(Format
			@temp2
			952
			4
			gCurRoomNum
			gVersion
			(localproc_1 @temp212)
			(localproc_0 @temp202)
			temp222
			param1
		)
		(FileIO fiWRITE_STRING temp0 @temp2)
		(Format
			@temp2
			952
			5
			(gEgo x:)
			(gEgo y:)
			(gEgo heading:)
			(gEgo view:)
			(gEgo loop:)
			(gEgo cel:)
			(gEgo signal:)
		)
		(localproc_2 @temp2)
		(localproc_3 @temp2)
		(localproc_4 @temp2)
		(if (IsObject param2)
			(param2 doit: (StrEnd @temp2))
		)
		(StrCat @temp2 {\0d\n~})
		(FileIO fiWRITE_STRING temp0 @temp2)
		(repeat
			(= temp2 0)
			(GetInput @temp2 30 {Log Entry...})
			(if (== (StrLen @temp2) 0)
				(FileIO fiWRITE_STRING temp0 {~\0d\n\0d\n})
				(FileIO fiCLOSE temp0)
				(break)
			)
			(FileIO fiWRITE_STRING temp0 @temp2)
			(FileIO fiWRITE_STRING temp0 {\0d\n})
		)
		(DisposeScript 952)
	)
)

