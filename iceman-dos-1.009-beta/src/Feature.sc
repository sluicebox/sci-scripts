;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use System)

(public
	sysLogger 0
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 (GetTime 2)) ; SysTime24
	(Format
		param1
		950
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
		950
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
		(StrCat param1 (Format @temp0 950 2 ((gEgo script:) state:)))
		(StrCat param1 { })
	)
	(if
		(OneOf
			gCurRoomNum
			25 ; controlRm
			26 ; scopeViewRm
			27 ; controlPanel
			28 ; bridgeRm
			29
			30 ; captsQuartersRm
			31 ; egosQuartersRm
			32 ; galleyRm
			33 ; torpedoRm
			34 ; machineRm
			35 ; storageRm
			36 ; passagewayRm2
			37 ; engineRm
			38 ; escapeHatchRm
			39 ; diceRm
			40 ; chartRm
			41 ; hatchTubeRm
			42 ; bHatchTubeRm
			51 ; scubaCycle
			50 ; launchDiver
		)
		(StrCat param1 (Format @temp0 950 3 ((subMarine script:) state:)))
	)
)

(instance sysLogger of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 [temp2 200] [temp202 10] [temp212 10] temp222 [temp223 9] [temp232 30])
		(if (not (StrLen param1))
			(StrCpy @temp232 {})
			(GetInput @temp232 30 {Enter drive letter and your name...})
			(StrCat @temp232 {.log})
			(StrCpy param1 @temp232 19)
			(= temp0 (FOpen param1 0))
			(FPuts temp0 {CONFIGURATION~})
			(FPuts temp0 param1)
			(FPuts temp0 {~})
			(= temp1 (FOpen {resource.cfg} 1))
			(while (FGets @temp2 80 temp1)
				(FPuts temp0 @temp2)
				(FPuts temp0 { })
			)
			(FPuts temp0 {\0d\n\0d\n})
			(FClose temp1)
			(FClose temp0)
		)
		(= temp0 (FOpen param1 0))
		(switch (Print 950 4 #button {PROG} 0 #button {ART} 1 #button {DESIGN} 2)
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
			950
			5
			gCurRoomNum
			gVersion
			(localproc_1 @temp212)
			(localproc_0 @temp202)
			temp222
			param1
		)
		(FPuts temp0 @temp2)
		(Format
			@temp2
			950
			6
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
		(FPuts temp0 @temp2)
		(repeat
			(= temp2 0)
			(GetInput @temp2 50 {Log Entry...})
			(if (== (StrLen @temp2) 0)
				(FPuts temp0 {~\0d\n\0d\n})
				(FClose temp0)
				(break)
			)
			(FPuts temp0 @temp2)
			(FPuts temp0 {\0d\n})
		)
		(DisposeScript 950)
	)
)

