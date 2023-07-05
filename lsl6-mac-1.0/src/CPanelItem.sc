;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class CPanelItem of Obj
	(properties
		view -1
		loop 0
		cel 0
		x 0
		y 0
		nsRight 0
		nsBottom 0
		uBits 0
		noClickNoun 0
		noClickVerb 0
		noClickModNum 0
	)

	(method (onMe param1)
		(return (and (<= x (param1 x:) nsRight) (<= y (param1 y:) nsBottom)))
	)

	(method (show)
		(if (not argc)
			(if (not nsRight)
				(= nsRight (+ x (CelWide view loop cel)))
				(= nsBottom (+ y (CelHigh view loop cel)))
			)
			(if (not uBits)
				(= uBits (Graph grSAVE_BOX y x nsBottom nsRight 1))
			)
			(DrawCel view loop cel x y -1)
		)
		(if (not (PicNotValid))
			(Graph grUPDATE_BOX y x nsBottom nsRight 1)
		)
	)

	(method (hide)
		(Graph grRESTORE_BOX uBits)
		(if (not (PicNotValid))
			(Graph grUPDATE_BOX y x nsBottom nsRight 1)
		)
		(= uBits 0)
	)

	(method (select)
		(return 1)
	)
)

(class RadialDial of CPanelItem
	(properties
		points 0
		locations 0
		curPos 0
	)

	(method (init param1)
		(= locations param1)
		(= curPos (= cel (self doit:)))
	)

	(method (increment)
		(= cel (++ curPos))
		(self doit: curPos)
		(self show:)
		(Wait 5)
	)

	(method (decrement)
		(= cel (-- curPos))
		(self doit: curPos)
		(self show:)
		(Wait 5)
	)

	(method (findClosestPoint param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for ((= temp0 0)) (< temp0 points) ((++ temp0))
			(= temp3 (* temp0 4))
			(= temp1 (+ x (Memory memPEEK (+ locations temp3))))
			(= temp2 (+ y (Memory memPEEK (+ locations temp3 2))))
			(cond
				((== temp0 0)
					(= temp4 (GetDistance (param1 x:) (param1 y:) temp1 temp2))
					(= temp5 0)
				)
				(
					(<
						(= temp6
							(GetDistance (param1 x:) (param1 y:) temp1 temp2)
						)
						temp4 ; UNINIT
					)
					(= temp4 temp6)
					(= temp5 temp0)
				)
			)
		)
		(return temp5)
	)

	(method (select &tmp temp0 temp1)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize:)
			(= temp1 (self findClosestPoint: temp0))
			(cond
				((> curPos temp1)
					(self decrement:)
				)
				((< curPos temp1)
					(self increment:)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(return curPos)
	)
)

(class CButton of CPanelItem
	(properties)

	(method (select &tmp temp0)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize:)
			(cond
				((self onMe: temp0)
					(if (!= cel 1)
						(= cel 1)
						(self show:)
					)
				)
				((!= cel 0)
					(= cel 0)
					(self show:)
				)
			)
			(temp0 dispose:)
		)
		(self
			doit:
				(if cel
					(= cel 0)
					(self show:)
					1
				else
					0
				)
		)
		(temp0 dispose:)
	)
)

(class ControlPanel of Set
	(properties
		view -1
		loop 0
		cel 0
		uBits 0
		pBits 0
		x 0
		y 0
		nsRight 0
		nsBottom 0
		noClickHelp 0
		lastHelp 0
		done 0
	)

	(method (show &tmp temp0)
		(Platform 0 4 3 -1)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(= nsRight (+ (CelWide view loop cel) x 35))
		(= nsBottom (+ (CelHigh view loop cel) y))
		(= uBits (Graph grSAVE_BOX y x nsBottom nsRight 1))
		(= pBits (Graph grSAVE_BOX y x nsBottom nsRight 2))
		(DrawCel view loop cel x y -1)
		(self eachElementDo: #show)
		(PicNotValid temp0)
		(Graph grUPDATE_BOX y x nsBottom nsRight 1)
	)

	(method (noClickMessage param1)
		(Print modeless: 1 font: gUserFont)
		(gMessager
			say:
				(param1 noClickNoun:)
				(param1 noClickVerb:)
				0
				1
				0
				(param1 noClickModNum:)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp2 (GetPort))
		(= temp3 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not done)
			(= temp0 (Event new:))
			(temp0 localize:)
			(cond
				((and (not noClickHelp) (& (temp0 type:) evMOUSEBUTTON))
					(if (= temp1 (self firstTrue: #onMe temp0))
						(temp1 select:)
					)
				)
				((and noClickHelp (& (temp0 type:) evMOUSEBUTTON))
					(gGame setCursor: gNormalCursor)
					(= noClickHelp 0)
				)
				((and noClickHelp (= temp1 (self firstTrue: #onMe temp0)))
					(if (!= temp1 lastHelp)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(= lastHelp temp1)
						(self noClickMessage: lastHelp)
						(SetPort temp2)
					)
				)
				(gModelessDialog
					(= lastHelp 0)
					(gModelessDialog dispose:)
				)
			)
			(temp0 dispose:)
		)
		(gSystemWindow eraseOnly: temp3)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort temp2)
	)

	(method (hide)
		(self eachElementDo: #hide)
		(Graph grRESTORE_BOX uBits)
		(Graph grRESTORE_BOX pBits)
		(Graph grUPDATE_BOX y x nsBottom nsRight 1)
		(Animate (gCast elements:) 1)
		(Platform 0 4 2 -1)
	)
)

