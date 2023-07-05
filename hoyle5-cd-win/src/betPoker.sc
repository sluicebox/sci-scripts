;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1110)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use h5Messager)
(use pokerRoom)
(use iconBGMusicF)
(use Str)
(use Print)
(use IconBar)
(use GameControls)
(use System)

(public
	betPoker 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(cond
		((>= param1 1000)
			(proc0_10
				1181
				6
				(mod (/ param1 1000) 10)
				param2
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod (/ param1 100) 10)
				(+ param2 12)
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod (/ param1 10) 10)
				(+ param2 24)
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod param1 10)
				(+ param2 36)
				param3
				15
				param5
				param4
			)
		)
		((>= param1 100)
			(proc0_10
				1181
				6
				(mod (/ param1 100) 10)
				(+ param2 12)
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod (/ param1 10) 10)
				(+ param2 24)
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod param1 10)
				(+ param2 36)
				param3
				15
				param5
				param4
			)
		)
		((>= param1 10)
			(proc0_10
				1181
				6
				(mod (/ param1 10) 10)
				(+ param2 24)
				param3
				15
				param5
				param4
			)
			(proc0_10
				1181
				6
				(mod param1 10)
				(+ param2 36)
				param3
				15
				param5
				param4
			)
		)
		((>= param1 0)
			(proc0_10
				1181
				6
				(mod param1 10)
				(+ param2 36)
				param3
				15
				param5
				param4
			)
		)
	)
)

(procedure (localproc_1)
	(= local9 0)
	(= local10 1)
	(= local6 0)
	(= local0 gGameControls)
	((= gGameControls pokerBet2)
		plane: pokerWindow2
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconWhite theObj: iconWhite selector: #doit yourself:)
			(iconRed theObj: iconRed selector: #doit yourself:)
			(iconBlue theObj: iconBlue selector: #doit yourself:)
			(iconCancel theObj: iconCancel selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
			(iconIconBar0 theObj: iconIconBar0 selector: #doit yourself:)
			(iconIconBar1 theObj: iconIconBar1 selector: #doit yourself:)
			(iconIconBar2 theObj: iconIconBar2 selector: #doit yourself:)
			(iconIconBar3 theObj: iconIconBar3 selector: #doit yourself:)
			(iconIconBar4 theObj: iconIconBar4 selector: #doit yourself:)
			(iconIconBar5 theObj: iconIconBar5 selector: #doit yourself:)
	)
	(gGameControls show:)
	(if local9
		(= local7 (proc1115_1))
		(= local10 2)
	else
		(= local10 1)
	)
	(if local6
		(= local7 1)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(= local9 0)
	(= local10 1)
	(= local5 0)
	(= local7 0)
	(= global917 0)
	(= local4 0)
	(Arrow setLoop: ((Dealer at: param1) getLocation:) init:)
	(cond
		((and (== ((Dealer at: param1) type:) 0) ((Dealer at: param1) stillIn:))
			(EnableCursor)
			(= local0 gGameControls)
			((= gGameControls pokerBet)
				plane: pokerWindow
				curIcon: (if (not (HaveMouse)) iconFold else 0)
				add:
					(iconFold theObj: iconFold selector: #doit yourself:)
					(iconIconBar0
						theObj: iconIconBar0
						selector: #doit
						yourself:
					)
					(iconIconBar1
						theObj: iconIconBar1
						selector: #doit
						yourself:
					)
					(iconIconBar2
						theObj: iconIconBar2
						selector: #doit
						yourself:
					)
					(iconIconBar3
						theObj: iconIconBar3
						selector: #doit
						yourself:
					)
					(iconIconBar4
						theObj: iconIconBar4
						selector: #doit
						yourself:
					)
					(iconIconBar5
						theObj: iconIconBar5
						selector: #doit
						yourself:
					)
			)
			(if (== global904 0)
				(gGameControls
					add:
						(iconCheck theObj: iconCheck selector: #doit yourself:)
						(iconOpen theObj: iconOpen selector: #doit yourself:)
				)
			)
			(if global906
				(gGameControls
					add:
						(iconCall theObj: iconCall selector: #doit yourself:)
						(iconRaise theObj: iconRaise selector: #doit yourself:)
				)
				(if (== global889 1)
					(= temp2 0)
				else
					(= temp2 1)
				)
				(= temp1 (- global888 ((global117 at: 0) currentBet:)))
				(if
					(or
						(== global906 4)
						(<
							((global117 at: 0) total:)
							(+ temp1 [global894 temp2])
						)
					)
					(iconRaise signal: (| (iconRaise signal:) $0004))
				)
				(if (> temp1 ((global117 at: 0) total:))
					(iconCall signal: (| (iconRaise signal:) $0004))
				)
			)
			(= local1 0)
			(gGameControls show:)
			(if (and local9 (= local7 (proc1115_1)))
				(= local10 1)
			)
			(if local4
				(localproc_1)
			)
		)
		(((Dealer at: param1) stillInGame:)
			(localproc_3 param1)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
	(= temp2 (- global888 ((Dealer at: param1) currentBet:)))
	(if (== global889 1)
		(= temp4 0)
	else
		(= temp4 1)
	)
	(= temp3 (Str format: {PENGIN16.DLL}))
	(global900 at: 0 1)
	(global900 at: 1 2000)
	(global900 at: 2 global887)
	(global900 at: 3 [global891 temp4])
	(global900
		at:
			4
			((global117 at: 0) total:)
			((global117 at: 1) total:)
			((global117 at: 2) total:)
			((global117 at: 3) total:)
	)
	(global900
		at:
			8
			((global117 at: 0) lastPlay:)
			((global117 at: 1) lastPlay:)
			((global117 at: 2) lastPlay:)
			((global117 at: 3) lastPlay:)
	)
	(global900
		at:
			12
			((global117 at: 0) totalBet:)
			((global117 at: 1) totalBet:)
			((global117 at: 2) totalBet:)
			((global117 at: 3) totalBet:)
	)
	(global900 at: 16 temp2)
	(global900 at: 17 ((Dealer at: param1) handNum:))
	(global900 at: 18 global889)
	(global900
		at:
			19
			(((Dealer at: param1) at: 0) rank:)
			(((Dealer at: param1) at: 0) suit:)
	)
	(global900
		at:
			21
			(((Dealer at: param1) at: 1) rank:)
			(((Dealer at: param1) at: 1) suit:)
	)
	(global900
		at:
			23
			(((Dealer at: param1) at: 2) rank:)
			(((Dealer at: param1) at: 2) suit:)
	)
	(global900
		at:
			25
			(((Dealer at: param1) at: 3) rank:)
			(((Dealer at: param1) at: 3) suit:)
	)
	(global900
		at:
			27
			(((Dealer at: param1) at: 4) rank:)
			(((Dealer at: param1) at: 4) suit:)
	)
	(global900 at: 59 global906)
	(global900
		at:
			68
			((global117 at: 0) gull:)
			((global117 at: 1) gull:)
			((global117 at: 2) gull:)
			((global117 at: 3) gull:)
	)
	(global900
		at:
			72
			((global117 at: 0) aggr:)
			((global117 at: 1) aggr:)
			((global117 at: 2) aggr:)
			((global117 at: 3) aggr:)
	)
	(global900 at: 76 [global894 temp4])
	(global900 at: 77 (Random 0 32767))
	(global900
		at:
			78
			((global117 at: 0) lastRaise:)
			((global117 at: 1) lastRaise:)
			((global117 at: 2) lastRaise:)
			((global117 at: 3) lastRaise:)
	)
	(global900
		at:
			82
			((global117 at: 0) lastSaw:)
			((global117 at: 1) lastSaw:)
			((global117 at: 2) lastSaw:)
			((global117 at: 3) lastSaw:)
	)
	(global900
		at:
			86
			((global117 at: 0) tookCard:)
			((global117 at: 1) tookCard:)
			((global117 at: 2) tookCard:)
			((global117 at: 3) tookCard:)
	)
	(global900 at: 90 global899)
	(if (== (WinDLL 2 (temp3 data:) (global900 data:)) 0)
		(Printf {Error calling DLL})
	)
	(cond
		((> (= temp0 (global900 at: 60)) 5)
			(= temp0 (* (/ (+ temp0 3) 5) 5))
		)
		((> temp0 0)
			(= temp0 5)
		)
	)
	(if
		(and
			(> temp0 0)
			(< ((Dealer at: param1) total:) (+ temp2 temp0 [global891 temp4]))
		)
		(if global906
			(= temp0 0)
		else
			(= temp0 -2)
		)
	)
	(if (and (> temp0 0) (< temp0 [global894 temp4]))
		(= temp0 [global894 temp4])
	)
	(if (> temp0 0)
		(= temp0 (localproc_10 temp2 temp0 (Dealer at: param1)))
	)
	(if (> (+ temp0 temp2) ((Dealer at: param1) total:))
		(if (> temp2 ((Dealer at: param1) total:))
			(= temp0 -1)
		else
			(= temp0 0)
		)
	)
	(switch temp0
		(-2
			(= temp5 0)
		)
		(-1
			(= temp5 3)
		)
		(0
			(= temp5 1)
		)
		(else
			(= temp5 2)
		)
	)
	(if (and (== temp5 2) (== global904 0))
		(= temp7 4)
		(= temp8 1)
	else
		(= temp7 2)
		(= temp8 temp5)
	)
	(cond
		((and ((Dealer at: param1) tookCard:) (!= temp0 -1))
			(= temp10 3)
		)
		((or (== temp0 -1) (== temp0 -2))
			(= temp10 2)
		)
		(else
			(= temp10 0)
		)
	)
	(if (== temp0 0)
		(= temp9 temp2)
	else
		(= temp9 temp0)
	)
	(= temp6 (Dealer at: param1))
	(switch temp0
		(-2
			(if (!= (temp6 lastPlay:) -2)
				(((Dealer at: param1) owner:)
					sayReg:
						1100
						(+ (((Dealer at: param1) owner:) view:) 1)
						98
						0
						2
				)
			)
			((Dealer at: param1) lastPlay: -2)
		)
		(-1
			(if (and (!= (temp6 type:) 0) (!= (temp6 lastPlay:) -1))
				(if (or (Random 0 1) (== gAttitudeSetting 1))
					(((Dealer at: param1) owner:)
						sayReg:
							1100
							(+ (((Dealer at: param1) owner:) view:) 1)
							100
							0
							2
					)
				else
					(((Dealer at: param1) owner:)
						sayReg:
							1100
							(+ (((Dealer at: param1) owner:) view:) 1)
							115
							0
							2
					)
				)
			)
			((Dealer at: param1) lastPlay: -1)
			((Dealer at: param1) stillIn: 0)
			(++ global907)
		)
		(0
			(if (or (Random 0 1) (== gAttitudeSetting 1))
				(((Dealer at: param1) owner:)
					sayReg:
						1100
						(+ (((Dealer at: param1) owner:) view:) 1)
						99
						0
						2
				)
			else
				(((Dealer at: param1) owner:)
					sayReg:
						1100
						(+ (((Dealer at: param1) owner:) view:) 1)
						113
						0
						2
				)
			)
			(= temp1 (- global888 ((Dealer at: param1) currentBet:)))
			(localproc_4 temp1 param1)
			((Dealer at: param1) lastRaise: 0)
			((Dealer at: param1) lastSaw: temp1)
			((Dealer at: param1) total: (- ((Dealer at: param1) total:) temp1))
			((Dealer at: param1)
				currentBet: (+ ((Dealer at: param1) currentBet:) temp1)
			)
			((Dealer at: param1)
				totalBet: (+ ((Dealer at: param1) totalBet:) temp1)
			)
			((Dealer at: param1) lastPlay: 0)
			(+= global887 temp1)
			(+= global888 temp0)
			(++ global905)
		)
		(else
			(if global904
				(if (or (Random 0 1) (== gAttitudeSetting 1))
					(((Dealer at: param1) owner:)
						sayReg:
							1100
							(+ (((Dealer at: param1) owner:) view:) 1)
							101
							0
							2
					)
				else
					(((Dealer at: param1) owner:)
						sayReg:
							1100
							(+ (((Dealer at: param1) owner:) view:) 1)
							114
							0
							2
					)
				)
			else
				((Dealer at: param1) open: 1)
				(((Dealer at: param1) owner:)
					sayReg:
						1100
						(+ (((Dealer at: param1) owner:) view:) 1)
						103
						0
						2
				)
			)
			(= temp2 (- global888 ((Dealer at: param1) currentBet:)))
			(= temp1 (+ temp0 temp2))
			(localproc_4 temp1 param1)
			((Dealer at: param1) lastRaise: temp0)
			((Dealer at: param1) lastSaw: temp2)
			((Dealer at: param1) total: (- ((Dealer at: param1) total:) temp1))
			((Dealer at: param1)
				currentBet: (+ ((Dealer at: param1) currentBet:) temp1)
			)
			((Dealer at: param1)
				totalBet: (+ ((Dealer at: param1) totalBet:) temp1)
			)
			((Dealer at: param1) lastPlay: 1)
			(+= global887 temp1)
			(+= global888 temp0)
			(= global905 0)
			(= global904 1)
			(++ global906)
		)
	)
	(switch ((Dealer at: param1) location:)
		(1
			((ScriptID 1100 4) loop: temp7 cel: temp8 setPri: 9 init: hide:) ; float1
			((ScriptID 1100 5) loop: 0 cel: temp10 setPri: 8 init:) ; float1b
			(= temp11
				(+
					((ScriptID 1100 5) nsLeft:) ; float1b
					(/
						(-
							(-
								((ScriptID 1100 5) nsRight:) ; float1b
								((ScriptID 1100 5) nsLeft:) ; float1b
							)
							(-
								((ScriptID 1100 4) nsRight:) ; float1
								((ScriptID 1100 4) nsLeft:) ; float1
							)
						)
						2
					)
				)
			)
			(if (not (or (== temp0 -1) (== temp0 -2)))
				(-= temp11 20)
			)
			(= temp12
				(+
					((ScriptID 1100 5) nsTop:) ; float1b
					(/
						(-
							(-
								((ScriptID 1100 5) nsBottom:) ; float1b
								((ScriptID 1100 5) nsTop:) ; float1b
							)
							(-
								((ScriptID 1100 4) nsBottom:) ; float1
								((ScriptID 1100 4) nsTop:) ; float1
							)
						)
						2
					)
				)
			)
			(if
				(and
					((Dealer at: param1) stillIn:)
					(== global889 2)
					(!= temp0 -1)
				)
				(cond
					((== temp0 -2)
						(if (not ((ScriptID 1100 17) isNotHidden:)) ; float1c
							((ScriptID 1100 17) ; float1c
								loop: 1
								cel: ((Dealer at: param1) tookCard:)
								setPri: 10
								posn: temp11 (- temp12 5)
								init:
							)
						)
					)
					((not ((ScriptID 1100 17) isNotHidden:)) ; float1c
						((ScriptID 1100 17) ; float1c
							loop: 1
							cel: ((Dealer at: param1) tookCard:)
							setPri: 10
							posn: (+ temp11 17) (- temp12 5)
							init:
						)
					)
				)
				((ScriptID 1100 4) posn: temp11 (+ temp12 7) show:) ; float1
			else
				(if ((ScriptID 1100 17) isNotHidden:) ; float1c
					((ScriptID 1100 17) hide:) ; float1c
				)
				((ScriptID 1100 4) posn: temp11 temp12 show:) ; float1
			)
			(proc1100_15 temp9 2 ((ScriptID 1100 4) x:) ((ScriptID 1100 4) y:)) ; float1, float1
		)
		(3
			((ScriptID 1100 6) loop: temp7 cel: temp8 setPri: 8 init: hide:) ; float2
			((ScriptID 1100 7) loop: 0 cel: temp10 setPri: 7 init:) ; float2b
			(= temp11
				(+
					((ScriptID 1100 7) nsLeft:) ; float2b
					(/
						(-
							(-
								((ScriptID 1100 7) nsRight:) ; float2b
								((ScriptID 1100 7) nsLeft:) ; float2b
							)
							(-
								((ScriptID 1100 6) nsRight:) ; float2
								((ScriptID 1100 6) nsLeft:) ; float2
							)
						)
						2
					)
				)
			)
			(if (not (or (== temp0 -1) (== temp0 -2)))
				(-= temp11 20)
			)
			(= temp12
				(+
					((ScriptID 1100 7) nsTop:) ; float2b
					(/
						(-
							(-
								((ScriptID 1100 7) nsBottom:) ; float2b
								((ScriptID 1100 7) nsTop:) ; float2b
							)
							(-
								((ScriptID 1100 6) nsBottom:) ; float2
								((ScriptID 1100 6) nsTop:) ; float2
							)
						)
						2
					)
				)
			)
			(if
				(and
					((Dealer at: param1) stillIn:)
					(== global889 2)
					(!= temp0 -1)
				)
				(cond
					((== temp0 -2)
						(if (not ((ScriptID 1100 18) isNotHidden:)) ; float2c
							((ScriptID 1100 18) ; float2c
								loop: 1
								cel: ((Dealer at: param1) tookCard:)
								setPri: 10
								posn: temp11 (- temp12 5)
								init:
							)
						)
					)
					((not ((ScriptID 1100 18) isNotHidden:)) ; float2c
						((ScriptID 1100 18) ; float2c
							loop: 1
							cel: ((Dealer at: param1) tookCard:)
							setPri: 10
							posn: (+ temp11 17) (- temp12 5)
							init:
						)
					)
				)
				((ScriptID 1100 6) posn: temp11 (+ temp12 7) show:) ; float2
			else
				(if ((ScriptID 1100 18) isNotHidden:) ; float2c
					((ScriptID 1100 18) hide:) ; float2c
				)
				((ScriptID 1100 6) posn: temp11 temp12 show:) ; float2
			)
			(proc1100_15 temp9 0 ((ScriptID 1100 6) x:) ((ScriptID 1100 6) y:)) ; float2, float2
		)
		(2
			((ScriptID 1100 8) loop: temp7 cel: temp8 setPri: 8 init: hide:) ; float3
			((ScriptID 1100 9) loop: 0 cel: temp10 setPri: 7 init:) ; float3b
			(= temp11
				(+
					((ScriptID 1100 9) nsLeft:) ; float3b
					(/
						(-
							(-
								((ScriptID 1100 9) nsRight:) ; float3b
								((ScriptID 1100 9) nsLeft:) ; float3b
							)
							(-
								((ScriptID 1100 8) nsRight:) ; float3
								((ScriptID 1100 8) nsLeft:) ; float3
							)
						)
						2
					)
				)
			)
			(if (not (or (== temp0 -1) (== temp0 -2)))
				(-= temp11 20)
			)
			(= temp12
				(+
					((ScriptID 1100 9) nsTop:) ; float3b
					(/
						(-
							(-
								((ScriptID 1100 9) nsBottom:) ; float3b
								((ScriptID 1100 9) nsTop:) ; float3b
							)
							(-
								((ScriptID 1100 8) nsBottom:) ; float3
								((ScriptID 1100 8) nsTop:) ; float3
							)
						)
						2
					)
				)
			)
			(if
				(and
					((Dealer at: param1) stillIn:)
					(== global889 2)
					(!= temp0 -1)
				)
				(cond
					((== temp0 -2)
						(if (not ((ScriptID 1100 19) isNotHidden:)) ; float3c
							((ScriptID 1100 19) ; float3c
								loop: 1
								cel: ((Dealer at: param1) tookCard:)
								setPri: 10
								posn: temp11 (- temp12 5)
								init:
							)
						)
					)
					((not ((ScriptID 1100 19) isNotHidden:)) ; float3c
						((ScriptID 1100 19) ; float3c
							loop: 1
							cel: ((Dealer at: param1) tookCard:)
							setPri: 10
							posn: (+ temp11 17) (- temp12 5)
							init:
						)
					)
				)
				((ScriptID 1100 8) posn: temp11 (+ temp12 7) show:) ; float3
			else
				(if ((ScriptID 1100 19) isNotHidden:) ; float3c
					((ScriptID 1100 19) hide:) ; float3c
				)
				((ScriptID 1100 8) posn: temp11 temp12 show:) ; float3
			)
			(proc1100_15 temp9 3 ((ScriptID 1100 8) x:) ((ScriptID 1100 8) y:)) ; float3, float3
		)
		(4
			((ScriptID 1100 10) loop: temp7 cel: temp8 setPri: 8 init: hide:) ; float4
			((ScriptID 1100 11) loop: 0 cel: temp10 setPri: 7 init:) ; float4b
			(= temp11
				(+
					((ScriptID 1100 11) nsLeft:) ; float4b
					(/
						(-
							(-
								((ScriptID 1100 11) nsRight:) ; float4b
								((ScriptID 1100 11) nsLeft:) ; float4b
							)
							(-
								((ScriptID 1100 10) nsRight:) ; float4
								((ScriptID 1100 10) nsLeft:) ; float4
							)
						)
						2
					)
				)
			)
			(if (not (or (== temp0 -1) (== temp0 -2)))
				(-= temp11 20)
			)
			(= temp12
				(+
					((ScriptID 1100 11) nsTop:) ; float4b
					(/
						(-
							(-
								((ScriptID 1100 11) nsBottom:) ; float4b
								((ScriptID 1100 11) nsTop:) ; float4b
							)
							(-
								((ScriptID 1100 10) nsBottom:) ; float4
								((ScriptID 1100 10) nsTop:) ; float4
							)
						)
						2
					)
				)
			)
			(if
				(and
					((Dealer at: param1) stillIn:)
					(== global889 2)
					(!= temp0 -1)
				)
				(cond
					((== temp0 -2)
						(if (not ((ScriptID 1100 20) isNotHidden:)) ; float4c
							((ScriptID 1100 20) ; float4c
								loop: 1
								cel: ((Dealer at: param1) tookCard:)
								setPri: 10
								posn: temp11 (- temp12 5)
								init:
							)
						)
					)
					((not ((ScriptID 1100 20) isNotHidden:)) ; float4c
						((ScriptID 1100 20) ; float4c
							loop: 1
							cel: ((Dealer at: param1) tookCard:)
							setPri: 10
							posn: (+ temp11 17) (- temp12 5)
							init:
						)
					)
				)
				((ScriptID 1100 10) posn: temp11 (+ temp12 7) show:) ; float4
			else
				(if ((ScriptID 1100 20) isNotHidden:) ; float4c
					((ScriptID 1100 20) hide:) ; float4c
				)
				((ScriptID 1100 10) posn: temp11 temp12 show:) ; float4
			)
			(proc1100_15
				temp9
				1
				((ScriptID 1100 10) x:) ; float4
				((ScriptID 1100 10) y:) ; float4
			)
		)
	)
	(proc1100_14)
	(temp3 dispose:)
)

(procedure (localproc_4 param1 param2 &tmp temp0)
	(((ScriptID 1100 2) at: ((Dealer at: param2) handNum:)) ; theChipPiles
		play: param1 (ScriptID 1100 3) ; potPile
	)
	(RedrawCast)
)

(procedure (localproc_5 param1) ; UNUSED
	((Dealer at: param1) floater: 6)
	(-- global890)
	((Dealer curPlayer:) stillIn: 0)
)

(procedure (localproc_6 param1 param2) ; UNUSED
	(if param2
		(param1 signal: (& (param1 signal:) $fffb))
	else
		(param1 signal: (| (param1 signal:) $0004))
	)
	(param1 show:)
	(UpdateScreenItem param1)
)

(procedure (localproc_7 param1 param2 param3 param4) ; UNUSED
	(param1 mainView: param2)
	(param1 mainLoop: param3)
	(param1 mainCel: param4)
	(param1 show:)
	(FrameOut)
	(UpdateScreenItem param1)
)

(procedure (localproc_8 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: param1))
	(= temp2 ((pokerWindow2 casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(cond
		((temp1 compare: {bet})
			(localproc_0 param2 340 189 param1 pokerWindow2)
		)
		((temp1 compare: {total})
			(localproc_0 param2 340 138 param1 pokerWindow2)
		)
		(else
			(localproc_0 param2 340 163 param1 pokerWindow2)
		)
	)
	(temp1 dispose:)
)

(procedure (localproc_9 param1 &tmp temp0)
	(switch global880
		(0
			(= temp0 2)
		)
		(1
			(= temp0 4)
		)
		(2
			(= temp0 5)
		)
	)
	(if (== (- temp0 global889) 0)
		(switch param1
			(0
				(return [global894 1])
			)
			(1
				(return [global891 1])
			)
		)
	else
		(switch param1
			(0
				(return [global894 0])
			)
			(1
				(return [global891 0])
			)
		)
	)
)

(procedure (localproc_10 param1 param2 param3 &tmp temp0)
	(= temp0 (localproc_11 param3))
	(cond
		((== global889 1)
			(if (and (> param1 (/ (* [global891 0] 3) 5)) (< temp0 2))
				(if global906
					(return 0)
				else
					(return -2)
				)
			else
				(return param2)
			)
		)
		((and (> param1 (/ (* [global891 1] 3) 5)) (< temp0 4))
			(if global906
				(return 0)
			else
				(return -2)
			)
		)
		(else
			(return param2)
		)
	)
)

(procedure (localproc_11 param1 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {PENGIN16.DLL}))
	(global900 at: 0 4)
	(global900 at: 8 1)
	(global900 at: 19 ((param1 at: 0) rank:) ((param1 at: 0) suit:))
	(global900 at: 21 ((param1 at: 1) rank:) ((param1 at: 1) suit:))
	(global900 at: 23 ((param1 at: 2) rank:) ((param1 at: 2) suit:))
	(global900 at: 25 ((param1 at: 3) rank:) ((param1 at: 3) suit:))
	(global900 at: 27 ((param1 at: 4) rank:) ((param1 at: 4) suit:))
	(if (== (WinDLL 2 (temp1 data:) (global900 data:)) 0)
		(Printf {Error calling DLL})
	)
	(switch (= temp0 (global900 at: 61))
		(0
			(= temp0 0)
		)
		(1
			(= temp0 1)
		)
		(2
			(= temp0 2)
		)
		(4
			(= temp0 3)
		)
		(8
			(= temp0 4)
		)
		(16
			(= temp0 5)
		)
		(32
			(= temp0 6)
		)
		(64
			(= temp0 7)
		)
		(128
			(= temp0 8)
		)
	)
	(return temp0)
)

(instance betPoker of Code
	(properties)

	(method (init param1)
		(proc17_2)
		(= local4 0)
		(= local7 1)
		(= local10 1)
		(Load rsVIEW 1181)
		(while local7
			(= local7 0)
			(if (== local10 1)
				(localproc_2 param1)
			else
				(localproc_1)
			)
		)
	)
)

(class PokerGameControls of IconBar
	(properties
		state 0
		height 200
		okButton 0
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(if plane
			(gGameControls init:)
		else
			(= plane
				((gSystemPlane new:)
					left: 0
					top: 0
					right: 640
					bottom: 480
					priority: 15
					init:
					yourself:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (KList 3 elements))) temp2 ((= temp2 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp2)) ; NextNode
			(= temp3 (KList 8 temp2)) ; NodeValue
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(if (not okButton)
			(= okButton (KList 8 (self first:))) ; NodeValue
		)
		(if curIcon
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(self doit: hide:)
	)
)

(class PokerControls of PokerGameControls
	(properties
		okIconItem 0
	)

	(method (dispatchEvent event &tmp temp0)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL claimed: 1)
			(if okIconItem
				(okIconItem doit: -1)
			)
			(return)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance pokerWindow of InvisibleWindow
	(properties
		left 240
		top 117
		right 558
		bottom 355
	)

	(method (init &tmp temp0)
		(= left (= top 0))
		(= bottom 480)
		(= right 640)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 5)
		(super init:)
		(= local3 (- global888 ((global117 at: 0) currentBet:)))
		(proc0_10 1181 0 0 240 150 5 pokerWindow)
		(localproc_0 local3 325 175 {bet} pokerWindow)
	)
)

(instance pokerWindow2 of InvisibleWindow
	(properties
		left 240
		top 117
		right 558
		bottom 355
	)

	(method (init &tmp temp0)
		(= left (= top 0))
		(= bottom 480)
		(= right 640)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 5)
		(super init:)
		(= local3 (- global888 ((global117 at: 0) currentBet:)))
		(if (== global904 0)
			(proc0_10 1181 7 1 220 117 5 pokerWindow2)
		else
			(proc0_10 1181 7 0 220 117 5 pokerWindow2)
		)
		(localproc_0 ((global117 at: 0) total:) 340 138 {total} pokerWindow2)
		(if (!= global904 0)
			(localproc_0 0 340 163 {raise} pokerWindow2)
			(localproc_0 local3 340 189 {bet} pokerWindow2)
		else
			(localproc_0 0 340 163 {raise} pokerWindow2)
		)
	)
)

(instance pokerBet of HoyleGameControls
	(properties)
)

(instance pokerBet2 of HoyleGameControls
	(properties)
)

(instance iconCheck of ControlIcon
	(properties
		noun 5
		modNum 1190
		nsLeft 255
		nsTop 164
		x 255
		y 164
		mainView 1181
		mainLoop 1
		maskView 1181
		maskLoop 1
		maskCel 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 3] temp3 temp4)
		(= local1 1)
		(= mainLoop 2)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
		((global117 at: 0) lastPlay: -2)
		(gGameControls delete: self)
		(iconCheck mainLoop: 1)
		(gGameControls delete: iconOpen)
		(gGameControls hide:)
		(= gGameControls local0)
		((ScriptID 1100 7) loop: 0 cel: 2 setPri: 7 init:) ; float2b
		((ScriptID 1100 6) loop: 2 cel: 0 setPri: 8 init: hide:) ; float2
		(= temp3
			(+
				((ScriptID 1100 7) nsLeft:) ; float2b
				(/
					(-
						(-
							((ScriptID 1100 7) nsRight:) ; float2b
							((ScriptID 1100 7) nsLeft:) ; float2b
						)
						(-
							((ScriptID 1100 6) nsRight:) ; float2
							((ScriptID 1100 6) nsLeft:) ; float2
						)
					)
					2
				)
			)
		)
		(= temp4
			(+
				((ScriptID 1100 7) nsTop:) ; float2b
				(/
					(-
						(-
							((ScriptID 1100 7) nsBottom:) ; float2b
							((ScriptID 1100 7) nsTop:) ; float2b
						)
						(-
							((ScriptID 1100 6) nsBottom:) ; float2
							((ScriptID 1100 6) nsTop:) ; float2
						)
					)
					2
				)
			)
		)
		((ScriptID 1100 6) posn: temp3 temp4 show:) ; float2
		(proc1100_15 -2 0 ((ScriptID 1100 6) x:) ((ScriptID 1100 6) y:)) ; float2, float2
	)
)

(instance iconOpen of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 255
		nsTop 206
		x 255
		y 206
		mainView 1181
		mainLoop 3
		maskView 1181
		maskLoop 3
		maskCel 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 3])
		(= local1 2)
		(= local2 0)
		(= mainLoop 3)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
		(gGameControls delete: self)
		(gGameControls hide:)
		(= gGameControls local0)
		(= local4 1)
	)
)

(instance iconCall of ControlIcon
	(properties
		noun 2
		modNum 1190
		nsLeft 255
		nsTop 164
		x 255
		y 164
		mainView 1181
		mainLoop 2
		maskView 1181
		maskLoop 2
		maskCel 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= local1 3)
		(= mainLoop 4)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
		(= temp1 (- global888 ((global117 at: 0) currentBet:)))
		((global117 at: 0) lastRaise: 0)
		((global117 at: 0) lastSaw: temp1)
		((global117 at: 0) total: (- ((global117 at: 0) total:) temp1))
		((global117 at: 0) currentBet: temp1)
		((global117 at: 0) totalBet: (+ temp1 ((global117 at: 0) totalBet:)))
		(+= global887 temp1)
		(++ global905)
		((global117 at: 0) lastPlay: 0)
		(((ScriptID 1100 2) at: 0) play: temp1 (ScriptID 1100 3)) ; theChipPiles, potPile
		(iconCall mainLoop: 2)
		(gGameControls delete: self)
		(gGameControls hide:)
		(= gGameControls local0)
		((ScriptID 1100 7) loop: 0 cel: 0 setPri: 7 init:) ; float2b
		((ScriptID 1100 6) loop: 2 cel: 1 setPri: 8 init: hide:) ; float2
		(= temp3
			(-
				(= temp3
					(+
						((ScriptID 1100 7) nsLeft:) ; float2b
						(/
							(-
								(-
									((ScriptID 1100 7) nsRight:) ; float2b
									((ScriptID 1100 7) nsLeft:) ; float2b
								)
								(-
									((ScriptID 1100 6) nsRight:) ; float2
									((ScriptID 1100 6) nsLeft:) ; float2
								)
							)
							2
						)
					)
				)
				20
			)
		)
		(= temp4
			(+
				((ScriptID 1100 7) nsTop:) ; float2b
				(/
					(-
						(-
							((ScriptID 1100 7) nsBottom:) ; float2b
							((ScriptID 1100 7) nsTop:) ; float2b
						)
						(-
							((ScriptID 1100 6) nsBottom:) ; float2
							((ScriptID 1100 6) nsTop:) ; float2
						)
					)
					2
				)
			)
		)
		((ScriptID 1100 6) posn: temp3 temp4 show:) ; float2
		(proc1100_15 temp1 0 ((ScriptID 1100 6) x:) ((ScriptID 1100 6) y:)) ; float2, float2
	)
)

(instance iconRaise of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 255
		nsTop 206
		x 255
		y 206
		mainView 1181
		mainLoop 4
		maskView 1181
		maskLoop 4
		maskCel 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 3])
		(if (== global906 4)
			(= global920 1)
			(gChar1 sayReg: 1014 1 86 0 1)
		else
			(= local1 4)
			(= local2 0)
			(= mainLoop 4)
			(gGameControls delete: self)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
			(gGameControls delete: self)
			(gGameControls hide:)
			(= gGameControls local0)
			(= local4 1)
		)
	)
)

(instance iconFold of ControlIcon
	(properties
		noun 1
		modNum 1190
		nsLeft 255
		nsTop 248
		nsRight 130
		nsBottom 200
		x 255
		y 248
		mainView 1181
		mainLoop 5
		maskView 1181
		maskLoop 5
		maskCel 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 3] temp3 temp4)
		(= local1 5)
		(= mainLoop 5)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
		((global117 at: 0) lastPlay: -1)
		((global117 at: 0) stillIn: 0)
		(++ global907)
		(iconFold mainLoop: 5)
		(gGameControls delete: self)
		(gGameControls hide:)
		(= gGameControls local0)
		((ScriptID 1100 7) loop: 0 cel: 2 setPri: 7 init:) ; float2b
		((ScriptID 1100 6) loop: 2 cel: 3 setPri: 8 init: hide:) ; float2
		(= temp3
			(+
				((ScriptID 1100 7) nsLeft:) ; float2b
				(/
					(-
						(-
							((ScriptID 1100 7) nsRight:) ; float2b
							((ScriptID 1100 7) nsLeft:) ; float2b
						)
						(-
							((ScriptID 1100 6) nsRight:) ; float2
							((ScriptID 1100 6) nsLeft:) ; float2
						)
					)
					2
				)
			)
		)
		(= temp4
			(+
				((ScriptID 1100 7) nsTop:) ; float2b
				(/
					(-
						(-
							((ScriptID 1100 7) nsBottom:) ; float2b
							((ScriptID 1100 7) nsTop:) ; float2b
						)
						(-
							((ScriptID 1100 6) nsBottom:) ; float2
							((ScriptID 1100 6) nsTop:) ; float2
						)
					)
					2
				)
			)
		)
		((ScriptID 1100 6) posn: temp3 temp4 show:) ; float2
		(proc1100_15 -1 0 ((ScriptID 1100 6) x:) ((ScriptID 1100 6) y:)) ; float2, float2
	)
)

(instance iconWhite of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 243
		nsTop 218
		x 243
		y 218
		signal 387
		mainView 1181
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
		(self plane: pokerWindow2)
		(self show:)
	)

	(method (doit &tmp [temp0 2])
		(cond
			((> (+ local2 local3 5) ((global117 at: 0) total:))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 178 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 178 0 1)
				)
			)
			((> (localproc_9 0) (+ local2 5))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 175 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 175 0 1)
				)
			)
			((< (localproc_9 1) (+ local2 5))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 176 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 176 0 1)
				)
			)
			(else
				(+= local2 5)
				(localproc_8 {raise} local2)
				(if global904
					(localproc_8 {bet} (+ local2 local3))
				)
				(localproc_8
					{total}
					(- ((global117 at: 0) total:) (+ local2 local3))
				)
				(= local5 1)
			)
		)
	)
)

(instance iconRed of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 301
		nsTop 218
		x 301
		y 218
		signal 387
		mainView 1181
		mainLoop 8
		mainCel 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self plane: pokerWindow2)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 2])
		(cond
			((> (+ local2 local3 25) ((global117 at: 0) total:))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 178 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 178 0 1)
				)
			)
			((< (localproc_9 1) (+ local2 25))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 176 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 176 0 1)
				)
			)
			(else
				(+= local2 25)
				(localproc_8 {raise} local2)
				(if global904
					(localproc_8 {bet} (+ local2 local3))
				)
				(localproc_8
					{total}
					(- ((global117 at: 0) total:) (+ local2 local3))
				)
				(= local5 1)
			)
		)
	)
)

(instance iconBlue of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 358
		nsTop 217
		x 358
		y 217
		signal 387
		mainView 1181
		mainLoop 8
		mainCel 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self plane: pokerWindow2)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 2])
		(cond
			((> (+ local2 local3 50) ((global117 at: 0) total:))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 178 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 178 0 1)
				)
			)
			((< (localproc_9 1) (+ local2 50))
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 176 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1014 1 176 0 1)
				)
			)
			(else
				(+= local2 50)
				(localproc_8 {raise} local2)
				(if global904
					(localproc_8 {bet} (+ local2 local3))
				)
				(localproc_8
					{total}
					(- ((global117 at: 0) total:) (+ local2 local3))
				)
				(= local5 1)
			)
		)
	)
)

(instance iconCancel of ControlIcon
	(properties
		noun 4
		modNum 1190
		nsLeft 235
		nsTop 264
		x 235
		y 264
		signal 387
		mainView 1181
		mainLoop 10
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(= local6 1)
		(gGameControls hide:)
		(= gGameControls local0)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 4
		modNum 1190
		nsLeft 319
		nsTop 264
		x 319
		y 264
		signal 387
		mainView 1181
		mainLoop 9
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= local6 0)
		(if (!= param1 -1)
			(cond
				(local5
					(switch local1
						(1
							((global117 at: 0) lastPlay: -2)
							(iconCheck mainLoop: 1)
							(gGameControls delete: iconOpen)
						)
						(2
							(++ global906)
							(iconOpen mainLoop: 3)
							(gGameControls delete: iconCheck)
							(= global904 1)
							(= temp2 local2)
							((global117 at: 0) lastRaise: temp2)
							((global117 at: 0) lastSaw: 0)
							(((ScriptID 1100 13) at: 0) open: 1) ; theHands
							((global117 at: 0)
								total: (- ((global117 at: 0) total:) temp2)
							)
							((global117 at: 0)
								currentBet:
									(+ ((global117 at: 0) currentBet:) temp2)
							)
							((global117 at: 0)
								totalBet:
									(+ ((global117 at: 0) totalBet:) temp2)
							)
							((global117 at: 0) lastPlay: 1)
							(+= global887 temp2)
							(+= global888 local2)
							(((ScriptID 1100 2) at: 0) ; theChipPiles
								play: temp2 (ScriptID 1100 3) ; potPile
							)
							((ScriptID 1100 7) loop: 0 cel: 0 setPri: 7 init:) ; float2b
							((ScriptID 1100 6) ; float2
								loop: 4
								cel: 1
								setPri: 8
								init:
								hide:
							)
							(= temp3
								(-
									(= temp3
										(+
											((ScriptID 1100 7) nsLeft:) ; float2b
											(/
												(-
													(-
														((ScriptID 1100 7) ; float2b
															nsRight:
														)
														((ScriptID 1100 7) ; float2b
															nsLeft:
														)
													)
													(-
														((ScriptID 1100 6) ; float2
															nsRight:
														)
														((ScriptID 1100 6) ; float2
															nsLeft:
														)
													)
												)
												2
											)
										)
									)
									20
								)
							)
							(= temp4
								(+
									((ScriptID 1100 7) nsTop:) ; float2b
									(/
										(-
											(-
												((ScriptID 1100 7) nsBottom:) ; float2b
												((ScriptID 1100 7) nsTop:) ; float2b
											)
											(-
												((ScriptID 1100 6) nsBottom:) ; float2
												((ScriptID 1100 6) nsTop:) ; float2
											)
										)
										2
									)
								)
							)
							((ScriptID 1100 6) posn: temp3 temp4 show:) ; float2
							(proc1100_15
								temp2
								0
								((ScriptID 1100 6) x:) ; float2
								((ScriptID 1100 6) y:) ; float2
							)
						)
						(3
							(= temp1
								(- global888 ((global117 at: 0) currentBet:))
							)
							((global117 at: 0) lastRaise: 0)
							((global117 at: 0) lastSaw: temp1)
							((global117 at: 0)
								total: (- ((global117 at: 0) total:) temp1)
							)
							((global117 at: 0) currentBet: temp1)
							((global117 at: 0)
								totalBet:
									(+ temp1 ((global117 at: 0) totalBet:))
							)
							(+= global887 temp1)
							(++ global905)
							((global117 at: 0) lastPlay: 0)
							(((ScriptID 1100 2) at: 0) ; theChipPiles
								play: temp1 (ScriptID 1100 3) ; potPile
							)
							(iconCall mainLoop: 2)
						)
						(4
							(++ global906)
							(= global905 0)
							(iconRaise mainLoop: 4)
							(= temp1
								(- global888 ((global117 at: 0) currentBet:))
							)
							(= temp2 (+ local2 temp1))
							((global117 at: 0) lastRaise: local2)
							((global117 at: 0) lastSaw: temp1)
							((global117 at: 0)
								total: (- ((global117 at: 0) total:) temp2)
							)
							((global117 at: 0)
								currentBet:
									(+ ((global117 at: 0) currentBet:) temp2)
							)
							((global117 at: 0)
								totalBet:
									(+ ((global117 at: 0) totalBet:) temp2)
							)
							((global117 at: 0) lastPlay: 1)
							(+= global887 temp2)
							(+= global888 local2)
							(((ScriptID 1100 2) at: 0) ; theChipPiles
								play: temp2 (ScriptID 1100 3) ; potPile
							)
							(self show:)
							(FrameOut)
							(UpdateScreenItem self)
							((ScriptID 1100 7) loop: 0 cel: 0 setPri: 7 init:) ; float2b
							((ScriptID 1100 6) ; float2
								loop: 2
								cel: 2
								setPri: 8
								init:
								hide:
							)
							(= temp3
								(-
									(= temp3
										(+
											((ScriptID 1100 7) nsLeft:) ; float2b
											(/
												(-
													(-
														((ScriptID 1100 7) ; float2b
															nsRight:
														)
														((ScriptID 1100 7) ; float2b
															nsLeft:
														)
													)
													(-
														((ScriptID 1100 6) ; float2
															nsRight:
														)
														((ScriptID 1100 6) ; float2
															nsLeft:
														)
													)
												)
												2
											)
										)
									)
									20
								)
							)
							(= temp4
								(+
									((ScriptID 1100 7) nsTop:) ; float2b
									(/
										(-
											(-
												((ScriptID 1100 7) nsBottom:) ; float2b
												((ScriptID 1100 7) nsTop:) ; float2b
											)
											(-
												((ScriptID 1100 6) nsBottom:) ; float2
												((ScriptID 1100 6) nsTop:) ; float2
											)
										)
										2
									)
								)
							)
							((ScriptID 1100 6) posn: temp3 temp4 show:) ; float2
							(proc1100_15
								local2
								0
								((ScriptID 1100 6) x:) ; float2
								((ScriptID 1100 6) y:) ; float2
							)
						)
						(5
							((global117 at: 0) lastPlay: -1)
							((global117 at: 0) stillIn: 0)
							(++ global905)
							(iconFold mainLoop: 5)
						)
					)
					(gGameControls hide:)
					(= gGameControls local0)
				)
				((== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1014 1 181 0 2)
				)
				(else
					(= global920 1)
					(gChar1 sayReg: 1014 1 181 0 1)
				)
			)
		else
			(= local6 1)
			(= gGameControls local0)
		)
	)
)

(instance iconIconBar0 of ControlIcon
	(properties
		noun 1
		modNum 12
		nsLeft 66
		nsTop 420
		x 66
		y 420
		signal 387
		mainView 902
		maskView 902
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		(= local9 1)
		(gGameControls hide:)
		(= gGameControls local0)
	)
)

(instance iconIconBar1 of ControlIcon
	(properties
		noun 2
		modNum 12
		nsLeft 152
		nsTop 420
		x 152
		y 420
		priority 1
		signal 387
		mainView 902
		mainLoop 1
		maskView 902
		maskLoop 1
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(iconIconBar1 signal: (| (iconIconBar1 signal:) $0004))
		(super init: &rest)
	)

	(method (doit)
		((IconBar at: 1) doit:)
	)
)

(instance iconIconBar2 of ControlIcon
	(properties
		noun 3
		modNum 12
		nsLeft 238
		nsTop 420
		x 238
		y 420
		signal 387
		mainView 902
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		((IconBar at: 2) doit:)
	)
)

(instance iconIconBar3 of ControlIcon
	(properties
		noun 4
		modNum 12
		nsLeft 324
		nsTop 420
		x 324
		y 420
		signal 387
		mainView 902
		mainLoop 3
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((IconBar at: 3) doit:)
	)
)

(instance iconIconBar4 of ControlIcon
	(properties
		noun 5
		modNum 12
		nsLeft 410
		nsTop 420
		x 410
		y 420
		signal 387
		mainView 902
		mainLoop 4
		maskView 902
		maskLoop 4
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(self signal: (| (self signal:) $0004))
			(self mainCel: 2)
		)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(= temp0 (+ global877 global385))
		((IconBar at: 4) doit:)
		(if (!= (+ global877 global385) temp0)
			(gChipsPlane drawPic: (+ global877 global385) 0)
		)
	)
)

(instance iconIconBar5 of ControlIcon
	(properties
		noun 6
		modNum 12
		nsLeft 496
		nsTop 420
		x 496
		y 420
		signal 387
		mainView 902
		mainLoop 5
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(= global748 0)
		(if global924
			((ScriptID 930 0) init: 9131 0 900) ; yesNo
		else
			((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
		)
		(DisposeScript 930)
		(cond
			((== global748 1)
				(if global924
					(gGame quitGame:)
					(proc0_8 0)
				else
					(= gNewRoomNum 975) ; chooseGame
				)
				(gGameControls hide:)
				(= gGameControls local0)
			)
			((== global748 3)
				(gGame quitGame:)
				(proc0_8 0)
				(gGameControls hide:)
				(= gGameControls local0)
			)
		)
	)
)

(class PokerIcon of IconI
	(properties
		theObj 0
	)

	(method (doit)
		(if theObj
			(if (& signal $0040)
				((if gGameControls gGameControls else gGameControls) hide:)
			)
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)

