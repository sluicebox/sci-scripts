;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use EcoDialog)
(use Timer)

(public
	proc804_1 1
	proc804_2 2
	proc804_3 3
	proc804_5 5
	proc804_6 6
	proc804_7 7
	proc804_8 8
	proc804_9 9
)

(local
	local0
	[local1 4]
)

(procedure (proc804_1 param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (proc804_2 param1 param2) ; UNUSED
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (proc804_6 param1 param2) ; UNUSED
	(if (== (param1 onControl:) param2)
		(return 1)
	)
)

(procedure (proc804_3)
	(= global200 0)
	(= global218 1)
	(= global219 2)
	(= global220 3)
	(= global221 3)
	(= global222 9)
	(= global201 4)
	(= global202 6)
	(= global203 7)
	(= global204 8)
	(= global205 13)
	(= global206 14)
	(= global207 15)
	(= global199 17)
	(= global214 18)
	(= global208 19)
	(= global209 20)
	(= global210 25)
	(= global213 26)
	(= global216 27)
	(= global217 28)
	(= global211 23)
	(= global212 31)
	(= global198 6)
)

(procedure (proc804_5 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8) ; UNUSED
	(if (== argc 1)
		(Display {} dsRESTOREPIXELS [param1 0])
	else
		(= temp4 (= temp5 -1))
		(= temp0 0)
		(= temp1 68)
		(= temp2 69)
		(= temp3 -1)
		(= temp6 global201)
		(= temp7 global200)
		(for ((= temp8 1)) (< temp8 argc) ((++ temp8))
			(switch [param1 temp8]
				(27
					(= temp0 [param1 (++ temp8)])
				)
				(30
					(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
				)
				(67
					(= temp3 [param1 (++ temp8)])
				)
				(64
					(= temp4 [param1 (++ temp8)])
					(= temp5 [param1 (++ temp8)])
				)
				(25
					(= temp6 [param1 (++ temp8)])
				)
				(26
					(= temp7 [param1 (++ temp8)])
				)
			)
		)
		(= temp8
			(Display
				[param1 0]
				dsCOORD
				temp4
				temp5
				dsCOLOR
				temp7
				dsWIDTH
				temp3
				dsALIGN
				temp0
				dsFONT
				temp2
				dsSAVEPIXELS
			)
		)
		(Display
			[param1 0]
			dsCOORD
			temp4
			temp5
			dsCOLOR
			temp6
			dsWIDTH
			temp3
			dsALIGN
			temp0
			dsFONT
			temp1
		)
		(return temp8)
	)
)

(procedure (proc804_7) ; UNUSED
	(proc821_1 &rest 64 -1 10)
)

(procedure (proc804_8 param1 &tmp temp0)
	(= temp0 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(param1 y: (- (param1 y:) temp0) z: (- (param1 z:) temp0))
)

(procedure (proc804_9 param1 &tmp temp0) ; UNUSED
	(localproc_0 0 gUserFont param1 &rest)
	(= temp0 [local1 2])
	(proc821_1 param1 &rest 64 -1 (- 180 temp0))
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 [temp1 100])
	(if (u< (= temp0 param3) 1000)
		(= temp0 @temp1)
		(Format @temp1 param3 &rest)
	)
	(if param1
		(= local0 (StrLen temp0))
	else
		(TextSize @[local1 0] temp0 param2 0)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1) ; UNUSED
	(= temp1 0)
	(StrCpy 0 param2)
	(StrCpy temp1 gNewRoomNum)
	(StrCpy temp1 param1)
	(SetDebug)
	(proc821_2 {%d} temp1)
)

(instance speakTimer of Timer ; UNUSED
	(properties)
)

