;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 745)
(include sci.sh)
(use Main)
(use Piles)
(use System)

(local
	local0
	local1
)

(class Bid of Obj
	(properties
		bidNumber 0
		level 0
		suit 0
		x 0
		y 0
		location 0
		artificial 0
	)

	(method (draw &tmp temp0)
		(cond
			((== bidNumber 0)
				(DrawCel 701 0 0 x y 14)
			)
			((== bidNumber 50)
				(DrawCel 701 0 1 x y 14)
			)
			((== bidNumber 99)
				(DrawCel 701 0 2 x y 14)
			)
			(else
				(DrawCel 701 level (- suit 1) x y 14)
			)
		)
	)
)

(class BidBox of List
	(properties
		underBits 0
		view 702
		loop 0
		cel 0
		x 87
		y 85
		priority 14
		westOffset 0
		northOffset 33
		eastOffset 66
		southOffset 99
		firstRowYOffset 14
		rowHeight 10
		rowsUsed 0
		offset 0
		scrollOffset 0
		active 0
		saveBits 0
		openingBidder 0
		overcaller 0
		openingBidValue 0
		bidsSinceOpen 0
		objectForDelayDraw 0
		selectorForDelayDraw 0
	)

	(method (move param1)
		(if (== (param1 type:) 0)
			(cond
				(
					(or
						(== (Dealer curPlayer:) (ScriptID 700 2)) ; hand1
						(== (Dealer curPlayer:) (ScriptID 700 3)) ; hand2
					)
					(if (== y 50)
						(BidBox erase:)
						(= y 85)
						(= x 96)
						(= local0 x)
						(= local1 y)
						(BidBox redraw: 1)
					)
				)
				((== y 85)
					(BidBox erase:)
					(= y 50)
					(= x 115)
					(= local0 x)
					(= local1 y)
					(BidBox redraw: 1)
				)
			)
		)
	)

	(method (review)
		((ScriptID 703 0) init:) ; bridgeReview
		(DisposeScript 703)
	)

	(method (save)
		(= saveBits
			(Graph
				grSAVE_BOX
				y
				x
				(+ y (CelHigh view loop cel))
				(+ x (CelWide view loop cel))
				1
			)
		)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
	)

	(method (restore)
		(= underBits
			(Graph
				grSAVE_BOX
				(- y 1)
				(- x 1)
				(+ y (CelHigh view loop cel) 1)
				(+ x (CelWide view loop cel) 1)
				3
			)
		)
		(Graph grRESTORE_BOX saveBits)
		(Graph
			grUPDATE_BOX
			y
			x
			(+ y (CelHigh view loop cel))
			(+ x (CelWide view loop cel))
			1
		)
		(= saveBits 0)
	)

	(method (setDeclarer param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if
				(and
					(<= 1 ((self at: temp0) bidNumber:) 35)
					(or
						(== (global429 location:) ((self at: temp0) location:))
						(==
							((global429 partner:) location:)
							((self at: temp0) location:)
						)
					)
					(or
						(and
							(<= 1 param1 4)
							(== (mod ((self at: temp0) bidNumber:) 5) param1)
						)
						(and
							(== param1 5)
							(not (mod ((self at: temp0) bidNumber:) 5))
						)
					)
				)
				(= global429
					(switch ((self at: temp0) location:)
						(1
							(ScriptID 700 4) ; hand3
						)
						(3
							(ScriptID 700 2) ; hand1
						)
						(2
							(ScriptID 700 5) ; hand4
						)
						(4
							(ScriptID 700 3) ; hand2
						)
					)
				)
				(return)
			)
		)
	)

	(method (newHand)
		(self dispose:)
		(self add:)
		(= global424 -2)
		(= global426 (= global427 (= global116 0)))
		(= openingBidder (= openingBidValue (= overcaller (= bidsSinceOpen 0))))
	)

	(method (scroll param1 &tmp temp0 temp1)
		(if (>= rowsUsed 5)
			(= temp0 (GetPort))
			(SetPort 0)
			(= temp1 scrollOffset)
			(cond
				((== param1 1)
					(if (< (-= scrollOffset 4) 0)
						(= scrollOffset 0)
					)
				)
				((> (+= scrollOffset 4) offset)
					(= scrollOffset offset)
				)
			)
			(if (!= temp1 scrollOffset)
				(self redraw:)
			)
			(SetPort temp0)
		)
	)

	(method (init param1)
		(= x 96)
		(= y 85)
		(if (== (param1 type:) 0)
			(= y
				(if
					(or
						(== param1 (ScriptID 700 4)) ; hand3
						(== param1 (ScriptID 700 5)) ; hand4
					)
					50
				else
					85
				)
			)
			(= x
				(if
					(or
						(== param1 (ScriptID 700 4)) ; hand3
						(== param1 (ScriptID 700 5)) ; hand4
					)
					115
				else
					96
				)
			)
		)
		(= local0 x)
		(= local1 y)
		(if size
			(self eachElementDo: #dispose)
		)
		(= scrollOffset (= offset (= rowsUsed 0)))
		(= underBits
			(Graph
				grSAVE_BOX
				(- y 1)
				(- x 1)
				(+ y (CelHigh view loop cel) 1)
				(+ x (CelWide view loop cel) 1)
				3
			)
		)
		(DrawCel view loop cel x y priority)
		(= active 1)
	)

	(method (redraw param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and argc param1)
			(= underBits
				(Graph
					grSAVE_BOX
					(- y 1)
					(- x 1)
					(+ y (CelHigh view loop cel) 1)
					(+ x (CelWide view loop cel) 1)
					3
				)
			)
		)
		(= temp5 scrollOffset)
		(DrawCel view loop cel x y priority)
		(if (!= scrollOffset 0)
			(= temp3 (= temp4 scrollOffset))
			(while (> temp3 (- scrollOffset 4))
				(if (and (>= temp4 0) (== ((self at: temp4) location:) 4))
					(break)
				)
				(-- temp4)
			)
			(= scrollOffset temp4)
		)
		(= temp3 scrollOffset)
		(= temp1 0)
		(while (and (< temp3 size) (< temp1 5))
			(= temp2 (self at: temp3))
			(temp2
				x:
					(+
						x
						(switch (temp2 location:)
							(4 westOffset)
							(1 northOffset)
							(2 eastOffset)
							(3 southOffset)
						)
					)
				y: (+ y (* temp1 rowHeight) firstRowYOffset)
				draw:
			)
			(if (== (temp2 location:) 3)
				(++ temp1)
			)
			(++ temp3)
		)
		(= scrollOffset temp5)
	)

	(method (erase)
		(Graph grRESTORE_BOX underBits)
		(Graph
			grUPDATE_BOX
			y
			x
			(+ y (CelHigh view loop cel))
			(+ x (CelWide view loop cel))
			1
		)
		(= active (= underBits 0))
	)

	(method (addToEnd param1 param2)
		(if argc
			(super addToEnd: param1)
			(param1
				y:
					(+
						y
						firstRowYOffset
						(*
							(cond
								((< rowsUsed 5) rowsUsed)
								((== ((Dealer curPlayer:) location:) 4) 5)
								(else 4)
							)
							rowHeight
						)
					)
				x:
					(+
						x
						(switch (param1 location:)
							(4 westOffset)
							(1 northOffset)
							(2 eastOffset)
							(3 southOffset)
						)
					)
			)
			(if (== (param1 location:) 3)
				(++ rowsUsed)
			)
			(if
				(and
					(!= scrollOffset offset)
					(not (and (== (param1 location:) 4) (> rowsUsed 4)))
				)
				(= scrollOffset offset)
				(if (or (<= argc 1) (not param2))
					(self redraw:)
				else
					(= selectorForDelayDraw 1020)
				)
			)
			(cond
				((and (== (param1 location:) 4) (> rowsUsed 4))
					(= scrollOffset (+= offset 4))
					(if (or (<= argc 1) (not param2))
						(self redraw:)
					else
						(= objectForDelayDraw self)
						(= selectorForDelayDraw 1020)
					)
				)
				((or (<= argc 1) (not param2))
					(param1 draw:)
				)
				(else
					(= objectForDelayDraw param1)
					(= selectorForDelayDraw 80)
				)
			)
		else
			(super add:)
		)
	)

	(method (newBid param1 param2 &tmp temp0)
		(self
			addToEnd:
				((= temp0 (Bid new:))
					bidNumber: param1
					location: ((Dealer curPlayer:) location:)
					suit: (+ (mod (- param1 1) 5) 1)
					level: (+ (/ (- param1 1) 5) 1)
					yourself:
				)
				(if (and (>= argc 2) param2) 1 else 0)
		)
		(gSound
			play:
				(if (== param1 0)
					703
				else
					(switch ((Dealer curPlayer:) location:)
						(1 701)
						(3 701)
						(2 702)
						(4 702)
					)
				)
		)
		(if openingBidValue
			(++ bidsSinceOpen)
		)
		(return temp0)
	)

	(method (checkBids param1 &tmp temp0 temp1)
		(if (> argc size)
			(return 0)
		else
			(= temp0 1)
			(for ((= temp1 0)) (and (< temp1 argc) temp0) ((++ temp1))
				(= temp0 (== [param1 temp1] ((BidBox at: temp1) bidNumber:)))
			)
		)
		(return temp0)
	)
)

