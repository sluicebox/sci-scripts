;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Print)
(use Inventory)
(use System)

(class ScrollableInventory of Inv
	(properties
		normalHeading -1
		empty -1
		curPos 0
		dispAmount 12
		items 0
		numCols 6
		numRows 2
		scrollAmount 6
		firstThru 1
		upIcon 0
		downIcon 0
	)

	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp2 (self indexOf: highlightedIcon))
		(= temp3 (mod (+ temp1 temp2) size))
		(repeat
			(= temp0 (self at: temp3))
			(if
				(and
					(IsObject temp0)
					(not (& (temp0 signal:) $0004))
					(or (> (temp0 nsLeft:) -1) (not (temp0 isKindOf: InvI)))
				)
				(break)
			)
			(= temp3 (mod (+ temp3 1) size))
		)
		(self highlight: temp0 1)
	)

	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(if (< (= temp3 (- (= temp2 (self indexOf: highlightedIcon)) temp1)) 0)
			(= temp3 (- size 1))
		)
		(repeat
			(= temp0 (self at: temp3))
			(if
				(and
					(IsObject temp0)
					(not (& (temp0 signal:) $0004))
					(or (> (temp0 nsLeft:) -1) (not (temp0 isKindOf: InvI)))
				)
				(break)
			)
			(if (< (-- temp3) 0)
				(= temp3 (- size 1))
			)
		)
		(self highlight: temp0 1)
	)

	(method (scroll param1)
		(cond
			((and argc (> 0 param1))
				(if (< (-= curPos scrollAmount) 0)
					(= curPos 0)
				)
			)
			((> (+= curPos scrollAmount) (- size dispAmount))
				(= curPos (- size dispAmount))
			)
		)
		(= firstThru 0)
		(selectIcon select:)
		(self show: gEgo)
	)

	(method (dispose)
		(if (IsObject items)
			(items dispose:)
			(= items 0)
		)
		(super dispose: &rest)
	)

	(method (hide)
		(if (IsObject items)
			(items dispose:)
			(= items 0)
		)
		(= firstThru 1)
		(super hide: &rest)
	)

	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21)
		(= temp20 (= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))))
		(if firstThru
			(if (IsObject items)
				(items dispose:)
				(= items 0)
			)
			(= items (Set new:))
		)
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal:) $fffb))
					(items add: temp9)
					(temp9 nsLeft: -5 nsRight: -5 nsTop: -5 nsBottom: -5)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal:) $0004))
				)
			else
				(++ temp3)
				(+= temp5 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if
					(>
						(= temp7
							(CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (not (items size:))
			(if (and (<= 0 normalHeading) (<= 0 empty))
				(Print addText: empty 0 0 0 0 0 normalHeading init:)
			else
				(Prints {You'll get nothing and like it!})
			)
			(if (IsObject items)
				(items dispose:)
			)
			(return 0)
		)
		(= temp0
			(if (< (items size:) dispAmount)
				(items size:)
			else
				dispAmount
			)
		)
		(= temp10 (Max (+ 4 temp5) (* numCols (+ 4 temp2))))
		(= temp11 (* numRows (+ 4 temp1)))
		(= temp12 (/ (- 190 temp11) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self window:))
			(temp21
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open: (not firstThru)
			)
		)
		(= temp19 numCols)
		(if temp0
			(= temp17
				(+
					2
					(if (temp21 respondsTo: #yOffset)
						(temp21 yOffset:)
					)
				)
			)
			(= temp18
				(= temp16
					(+
						4
						(if (temp21 respondsTo: #xOffset)
							(temp21 xOffset:)
						)
					)
				)
			)
			(for
				((= temp20 curPos))
				(and (< temp20 (+ curPos dispAmount)) (< temp20 (items size:)))
				((++ temp20))
				
				(= temp9 (items at: temp20))
				(if (not (& (temp9 signal:) $0080))
					(temp9
						nsLeft:
							(+
								temp16
								(/
									(-
										temp2
										(= temp6
											(CelWide
												(temp9 view:)
												(temp9 loop:)
												(temp9 cel:)
											)
										)
									)
									2
								)
							)
						nsTop:
							(+
								temp17
								(/
									(-
										temp1
										(= temp7
											(CelHigh
												(temp9 view:)
												(temp9 loop:)
												(temp9 cel:)
											)
										)
									)
									2
								)
							)
					)
					(temp9
						nsRight: (+ (temp9 nsLeft:) temp6)
						nsBottom: (+ (temp9 nsTop:) temp7)
					)
					(if (-- temp19)
						(+= temp16 temp2)
					else
						(= temp19 numCols)
						(+= temp17 temp1)
						(= temp16 temp18)
					)
				else
					(= temp16 (temp9 nsLeft:))
					(= temp17 (temp9 nsTop:))
				)
				(temp9 show:)
				(if (== temp9 param2)
					(temp9 highlight:)
				)
			)
		)
		(= temp16 (/ (- (- (temp21 right:) (temp21 left:)) temp5) 2))
		(= temp11 (- (temp21 bottom:) (temp21 top:)))
		(= temp17 32767)
		(if firstThru
			(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
				(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
					(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
					(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
					(if (not (& (temp9 signal:) $0080))
						(if (== temp17 32767)
							(= temp17 (- temp11 temp7))
						)
						(temp9
							nsLeft: temp16
							nsTop: temp17
							nsBottom: (+ temp17 temp7)
							nsRight: (+ temp16 temp6)
						)
					)
					(= temp16 (+ (temp9 nsLeft:) temp6))
					(= temp17 (temp9 nsTop:))
					(temp9 signal: (& (temp9 signal:) $fffb))
					(temp9 show:)
				)
			)
		)
		(if (not curPos)
			(upIcon signal: (| (upIcon signal:) $0004))
		else
			(upIcon signal: (& (upIcon signal:) $fffb))
		)
		(if (>= curPos (- (items size:) dispAmount))
			(downIcon signal: (| (downIcon signal:) $0004))
		else
			(downIcon signal: (& (downIcon signal:) $fffb))
		)
		(upIcon show:)
		(downIcon show:)
		(return 1)
	)
)

