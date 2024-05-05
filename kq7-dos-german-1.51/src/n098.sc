;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use ExitButton)
(use DText)
(use Str)
(use Timer)
(use System)

(public
	proc98_0 0
	proc98_1 1
	proc98_2 2
	proc98_3 3
	proc98_4 4
	proc98_5 5
	proc98_6 6
	proc98_8 8
	proc98_9 9
	proc98_11 11
	proc98_12 12
	proc98_14 14
	proc98_15 15
)

(local
	[local0 7] = [0 0 0 0 0 0 -2]
	[local7 38] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -2]
	[local45 38] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -2]
)

(procedure (proc98_15)
	(if
		(or
			(< (gGame speedRating:) 80)
			(OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550)
		)
		(return 0)
	else
		((gCast plane:) setRect: -1 0 319 136)
		(UpdatePlane (gCast plane:))
		(FrameOut)
		((gCast plane:) setRect: 0 0 320 136)
		(UpdatePlane (gCast plane:))
		(FrameOut)
		(return 1)
	)
)

(procedure (proc98_14)
	(if
		(or
			(not (IsFlag 97))
			(OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550)
		)
		(return 0)
	else
		((gCast plane:) setRect: 0 2 320 138)
		(UpdatePlane (gCast plane:))
		(FrameOut)
		((gCast plane:) setRect: 0 0 320 136)
		(UpdatePlane (gCast plane:))
		(FrameOut)
		(return 1)
	)
)

(procedure (proc98_5 param1)
	(if (== gTheCursor gNormalCursor)
		(gNormalCursor cel: 0 setCycle: 0)
	)
	(gWaitCursor view: 997 loop: 0 cel: 0)
	(if global308
		(= global321 gTheInvCursor)
	)
	(cond
		((and argc (== param1 2))
			(= global321 0)
			(if global308
				((ScriptID 16 3) doVerb: (global308 verb:)) ; invHole
			)
		)
		((and argc (== param1 1))
			((ScriptID 16 0) init:) ; skipCartoon
			(SetFlag 540)
		)
		((and argc (== param1 3) (global108 contains: (ScriptID 16 0))) ; skipCartoon
			(ClearFlag 539)
			(ClearFlag 540)
			((ScriptID 16 0) dispose:) ; skipCartoon
		)
	)
	(gGame oldCurs: gNormalCursor isHandsOn: 0 setCursor: gWaitCursor 1)
	(gUser canControl: 0 canInput: 0)
	(SetCursor 165 145)
)

(procedure (proc98_6)
	(gNormalCursor view: 999 loop: 0 cel: 0)
	(if argc
		(ClearFlag 539)
		(ClearFlag 540)
		(if (global108 contains: (ScriptID 16 0)) ; skipCartoon
			((ScriptID 16 0) dispose:) ; skipCartoon
		)
		(gUser canControl: 1 canInput: 1)
	else
		(gUser canControl: 0 canInput: 1)
	)
	(gGame oldCurs: gWaitCursor isHandsOn: 1)
	(if global321
		(gGame setCursor: global321 1)
		(= global321 0)
	else
		(gGame setCursor: gNormalCursor 1)
	)
)

(procedure (proc98_11 param1 param2 param3 &tmp temp0) ; UNUSED
	(= temp0 (+ gGameTime param2))
	(while (< gGameTime temp0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if (not param1)
			(gTimers eachElementDo: #doit)
			(gCast doit:)
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
				(if (gCuees isEmpty:)
					(gCuees dispose:)
					(= gCuees 0)
				)
			)
			(gTheDoits doit:)
		)
		(if (gUser curEvent:)
			((gUser curEvent:) dispose:)
		)
	)
	(if (and param3 (> argc 2))
		(param3 cue:)
	)
)

(procedure (proc98_9 &tmp temp0 temp1)
	(if (or global323 (IsFlag 541))
		(return 1)
	)
	(= temp0 (Str with: {c:\\carlos.kq7}))
	(if (FileIO fiEXISTS (temp0 data:))
		(SetFlag 541)
	else
		(ClearFlag 541)
	)
	(temp0 dispose:)
	(= temp0 0)
	(return (IsFlag 541))
)

(procedure (proc98_8 param1 param2 &tmp temp0 temp1 temp2)
	(if (proc98_9)
		(if (proc98_2 lowDlg)
			(FrameOut)
		)
		(lowStr data: param1)
		(lowDlg
			font: 0
			text: (KString 8 (lowStr data:)) ; StrDup
			fore: 99
			back: 0
			posn: 76 35
			setSize: 132
			setPri: 255
			init: ((gInterfacePlane casts:) at: 0)
		)
		(UpdatePlane gInterfacePlane)
		(if (== param2 32768)
			(FrameOut)
		)
		(= temp1 (lowStr size:))
		(= temp2 (* (/ (* 24 temp1) 10) 3))
		(cond
			(global323
				(lowTextTimer setTicks: global323 lowTextTimer)
				(= global323 0)
			)
			((== param2 (OneOf -2 -2 -2)))
			((== param2 -6)
				(lowTextTimer setTicks: (Max 500 temp2) lowTextTimer)
			)
			(else
				(lowTextTimer setTicks: (Max 300 temp2) lowTextTimer)
			)
		)
	)
)

(procedure (proc98_1 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(if (proc98_9)
		(proc98_2 txtDlg)
		(txtStr data: param1)
		(if (not global320)
			(= temp2 84)
		else
			(= temp2 global320)
		)
		(= global320 0)
		(txtDlg
			font: 0
			text: (KString 8 (txtStr data:)) ; StrDup
			fore: temp2
			back: 0
			posn: 76 20
			setSize: 132
			setPri: 255
			init: ((gInterfacePlane casts:) at: 0)
		)
		(UpdatePlane gInterfacePlane)
		(if (== param2 32768)
			(FrameOut)
		)
		(= temp1 (txtStr size:))
		(= temp0 (* (/ (* 24 temp1) 10) 3))
		(if global323
			(textTimer setTicks: global323 textTimer)
			(= global323 0)
		else
			(textTimer setTicks: temp0 textTimer)
		)
	)
)

(procedure (proc98_12 &tmp [temp0 4]) ; UNUSED
	(if (or (not (proc98_9)) (and (midStr data:) (midStr compare: &rest)))
		(return)
	else
		(midStr data: (midStr callKernel: 11 &rest))
		(midDlg
			font: 0
			text: (KString 8 (midStr data:)) ; StrDup
			fore: global325
			back: 0
			posn: 76 28
			setSize: 132
			setPri: 255
			init: ((gInterfacePlane casts:) at: 0)
		)
		(UpdatePlane gInterfacePlane)
	)
)

(procedure (proc98_2 param1 &tmp temp0 temp1)
	(= temp0 0)
	(switch [param1 0]
		(-1
			(proc98_2 txtDlg lowDlg midDlg)
		)
		(-3
			(proc98_2 lowDlg)
		)
		(-4
			(proc98_2 txtDlg)
		)
		(-5
			(proc98_2 midDlg)
		)
		(else
			(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
				(switch [param1 temp1]
					(txtDlg
						(if (txtDlg text:)
							(txtDlg dispose: 1 text: 0)
						)
						(textTimer perform: timerCode)
						(= temp0 1)
					)
					(lowDlg
						(if (lowDlg text:)
							(lowDlg dispose: 1 text: 0)
						)
						(lowTextTimer perform: timerCode)
						(= temp0 1)
					)
					(midDlg
						(if (midDlg text:)
							(midDlg dispose: 1 text: 0)
						)
						(= temp0 1)
					)
				)
			)
		)
	)
	(if temp0
		(UpdatePlane gInterfacePlane)
	)
	(return temp0)
)

(procedure (proc98_0 param1 &tmp temp0 temp1 temp2)
	(gTimers eachElementDo: #perform timerCode)
	(for ((= temp0 global329)) (>= temp0 0) ((-- temp0))
		(if [local45 temp0]
			(Lock rsVIEW [local45 temp0] 0)
			(UnLoad 128 [local45 temp0])
			(= [local45 temp0] 0)
		)
	)
	(for ((= temp0 global330)) (>= temp0 0) ((-- temp0))
		(if (= temp1 [local7 temp0])
			(Lock 140 temp1 0) ; WAVE
			(if (== (DoAudio audPOSITION temp1) -1)
				(UnLoad 140 temp1)
			)
			(= [local7 temp0] 0)
		)
	)
	(= global329 -1)
	(= global330 -1)
	(= global371 0)
	(if (proc98_2 -1)
		(FrameOut)
	)
	(if (and argc param1)
		(ClearFlag 539)
		(ClearFlag 540)
		(if (global108 contains: (ScriptID 16 0)) ; skipCartoon
			((ScriptID 16 0) dispose:) ; skipCartoon
		)
		(if global375
			(global375 dispose:)
			(= global375 0)
		)
		(if global376
			(global376 dispose:)
			(= global376 0)
		)
		(DisposeScript 98)
	)
)

(procedure (proc98_4 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp6 0)
	(= temp0 -1)
	(if (and (== global329 -1) (== global330 -1))
		(Purge 2000)
	)
	(for ((= temp1 1)) (< temp1 argc) ((++ temp1))
		(= temp4 [param1 temp1])
		(switch [param1 0]
			(128
				(for ((= temp2 global329)) (>= temp2 0) ((-- temp2))
					(if (== [local45 temp2] temp4)
						(= temp0 temp2)
					)
				)
				(cond
					((!= temp0 -1)
						(= temp0 -1)
					)
					((not (ResCheck rsVIEW temp4)))
					(else
						(++ global329)
						(= [local45 global329] temp4)
						(Load rsVIEW temp4)
						(if (and (> (MemoryInfo 0) 500) (> global322 2000))
							(Lock rsVIEW temp4 1)
							(if global375
								((= temp5 (Str new:)) format: {%hu } temp4)
								(global375 cat: temp5)
								(temp5 dispose:)
							)
							(= temp6 1)
						)
					)
				)
			)
			(140
				(for ((= temp2 global330)) (>= temp2 0) ((-- temp2))
					(if (== [local7 temp2] temp4)
						(= temp0 temp2)
					)
				)
				(cond
					((!= temp0 -1)
						(= temp0 -1)
					)
					((not (ResCheck 140 temp4))) ; WAVE
					(else
						(++ global330)
						(= [local7 global330] temp4)
						(Load 140 temp4) ; WAVE
						(if (and (> (MemoryInfo 0) 500) (> global322 2000))
							(Load 140 temp4) ; WAVE
							(if global376
								((= temp5 (Str new:)) format: {%hu } temp4)
								(global376 cat: temp5)
								(temp5 dispose:)
							)
							(= temp6 1)
						)
					)
				)
			)
		)
	)
	(return temp6)
)

(procedure (proc98_3 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
		(= temp2 [param1 temp0])
		(switch [param1 0]
			(128
				(for ((= temp1 0)) (<= temp1 35) ((++ temp1))
					(if (== [local45 temp1] temp2)
						(= [local45 temp1] 0)
					)
				)
				(Lock rsVIEW temp2 0)
				(UnLoad 128 temp2)
			)
			(140
				(for ((= temp1 0)) (<= temp1 35) ((++ temp1))
					(if (== [local7 temp1] temp2)
						(= [local7 temp1] 0)
					)
				)
				(Lock 140 temp2 0) ; WAVE
				(if (== (DoAudio audPOSITION temp2) -1)
					(UnLoad 140 temp2)
				)
			)
		)
	)
)

(instance txtDlg of DText
	(properties)
)

(instance lowDlg of DText
	(properties)
)

(instance midDlg of DText
	(properties)
)

(instance txtStr of Str
	(properties)
)

(instance lowStr of Str
	(properties)
)

(instance midStr of Str
	(properties)
)

(instance textTimer of Timer
	(properties)

	(method (cue)
		(proc98_2 txtDlg)
	)
)

(instance lowTextTimer of Timer
	(properties)

	(method (cue)
		(proc98_2 lowDlg)
	)
)

(instance timerCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (OneOf param1 textTimer lowTextTimer)
			(if (param1 client:)
				(= temp0 (param1 client:))
				(param1 client: 0)
				(if (temp0 respondsTo: #timer)
					(temp0 timer: 0)
				)
				(if (temp0 respondsTo: #cue)
					(temp0 cue:)
				)
			)
			(if (gTimers contains: param1)
				(param1 dispose: delete:)
			)
		)
	)
)

