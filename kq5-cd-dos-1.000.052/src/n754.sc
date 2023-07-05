;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 754)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	proc754_0 0
)

(local
	[local0 52]
	[local52 26]
	[local78 4]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= temp2 (& (= temp1 [local78 temp0]) $0100))
		(&= temp1 $feff)
		(if (and (not temp2) (== temp1 (param1 value:)))
			(|= [local78 temp0] $0100)
			(= temp3 1)
			(break)
		)
	)
	(return temp3)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(&= [local78 temp0] $feff)
	)
)

(procedure (proc754_0 &tmp temp0 temp1 temp2) ; UNUSED
	(CPCheckD window: gSystemWindow)
	(CPCheckD init: &rest)
	(CPCheckD open: 0 0)
	(= temp1 (gGame setCursor: gNormalCursor))
	(= temp2 0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(cond
			((CPCheckD doit:)
				(= temp2 1)
				(break)
			)
			((<= temp0 1)
				(Print 754 0) ; "Incorrect, please try again."
			)
		)
		(localproc_1)
	)
	(CPCheckD dispose:)
	(gGame setCursor: temp1)
	(DisposeScript 754)
	(return temp2)
)

(instance CPCheckD of Dialog
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp0 (= temp2 0))
		(while (< temp0 26)
			(StrAt @local0 temp2 (+ 65 temp0))
			(StrAt @local0 (+ temp2 1) 0)
			(++ temp0)
			(+= temp2 2)
		)
		(= temp6 0)
		(= temp7 0)
		(= temp0 0)
		(for ((= temp4 @local0)) (< temp0 26) ((+= temp4 2))
			((= temp3 (DButton new:))
				value: temp0
				state: 3
				text: temp4
				key: (+ 65 temp0)
				setSize:
				moveTo: temp6 temp7
			)
			(self add: temp3)
			(= [local52 temp0] temp3)
			(if (== temp0 12)
				(= temp6 0)
				(= temp7 (+ (temp3 nsBottom:) 4))
			else
				(= temp6 (+ (temp3 nsRight:) 4))
			)
			(++ temp0)
		)
		(= temp11 (temp3 nsRight:))
		(cond
			((u< [param1 0] 1000)
				(= temp5 (GetFarText [param1 0] [param1 1] 0))
			)
			([param1 0]
				(= temp5 (Memory memALLOC_CRIT (+ (StrLen [param1 0]) 1)))
				(StrCpy temp5 [param1 0])
			)
			(else
				(= temp5 (Memory memALLOC_CRIT 2))
				(StrCpy temp5 { })
			)
		)
		((= temp3 (DText new:))
			disposeText: 1
			text: temp5
			font: gUserFont
			setSize: temp11
		)
		(temp3 moveTo: (/ (- temp11 (- (temp3 nsRight:) (temp3 nsLeft:))) 2) 4)
		(self add: temp3)
		(= temp6 0)
		(= temp7 (+ (temp3 nsBottom:) 0))
		(= temp9 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(repeat
				(= [local78 temp0] (= temp8 (Random 0 25)))
				(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
					(breakif (== [local78 temp1] temp8))
				)
				(breakif (== temp1 temp0))
			)
			((= temp3 (DIcon new:))
				view: 940
				loop: (/ temp8 16)
				cel: (mod temp8 16)
				setSize:
				moveTo: temp6 temp7
			)
			(self add: temp3)
			(if (> (= temp1 (- (temp3 nsBottom:) (temp3 nsTop:))) temp9)
				(= temp9 temp1)
			)
			(= temp6 (+ (temp3 nsRight:) 12))
		)
		(= temp6 (/ (- temp11 (temp3 nsRight:)) 2))
		(= temp0 0)
		(for
			((= temp10 (self contains: temp3)))
			(and (< temp0 4) temp10)
			((= temp10 (self prev: temp10)))
			
			((NodeValue temp10) move: temp6 0)
			(++ temp0)
		)
		(+= temp7 (+ temp9 8))
		(= temp0 0)
		(for
			((= temp10 (self contains: [local52 0])))
			(and (< temp0 26) temp10)
			((= temp10 (self next: temp10)))
			
			((NodeValue temp10) move: 0 temp7)
			(++ temp0)
		)
		(self setSize: center:)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 0)
		(= temp6 0)
		(= busy 1)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= temp3 gEatMice)
			(= temp4 (GetTime))
		else
			(= temp3 0)
		)
		(for ((= temp5 0)) (< temp5 4) ((++ temp5))
			(= temp2 0)
			(while (not temp2)
				(self eachElementDo: #cycle)
				(= temp1 ((Event new:) localize:))
				(if temp3
					(-- temp3)
					(if (== (temp1 type:) 1)
						(temp1 type: 0)
					)
					(while (== temp4 (GetTime))
					)
					(= temp4 (GetTime))
				)
				(if (== (= temp2 (self handleEvent: temp1)) -1)
					(= temp2 0)
				)
				(temp1 dispose:)
				(self check:)
				(if (or (== temp2 -1) (not busy))
					(= temp2 0)
					(EditControl theItem 0)
					(break)
				)
				(Wait 1)
			)
			(+= temp6 (localproc_0 temp2))
		)
		(= busy 0)
		(return (== temp6 4))
	)
)

