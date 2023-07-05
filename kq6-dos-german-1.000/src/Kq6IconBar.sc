;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use IconBar)

(class Kq6IconBar of IconBar
	(properties)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh ((= temp0 (self at: 0)) view:) (temp0 loop:) (temp0 cel:))
		)
		(= port (GetPort))
		(SetPort -1)
		(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 show:)
			)
		)
		(self updateInvIcon:)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
		(self highlight: curIcon)
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((++ temp1))
			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((++ temp1))
			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (updateInvIcon &tmp temp0 temp1)
		(if (and curInvIcon (not (& (useIconItem state:) $0004)))
			(if (gEgo has: (gInventory indexOf: curInvIcon))
				(= temp0
					(+
						(/
							(-
								(- (useIconItem nsRight:) (useIconItem nsLeft:))
								(CelWide
									(curInvIcon view:)
									(curInvIcon loop:)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsLeft:)
					)
				)
				(= temp1
					(+
						y
						(/
							(-
								(- (useIconItem nsBottom:) (useIconItem nsTop:))
								(CelHigh
									(curInvIcon view:)
									(curInvIcon loop:)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsTop:)
					)
				)
				(DrawCel
					(curInvIcon view:)
					(curInvIcon loop:)
					(curInvIcon cel:)
					temp0
					temp1
					-1
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
	)
)

(class Kq6IconItem of IconI
	(properties)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(if (and argc param1)
			(= temp4 highlightColor)
			(= temp0 (+ nsTop 2))
			(= temp1 (+ nsLeft 2))
			(= temp2 (- nsBottom 3))
			(= temp3 (- nsRight 4))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		else
			(self show:)
			(if (Kq6IconBar curInvIcon:)
				(Kq6IconBar updateInvIcon:)
			)
		)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

