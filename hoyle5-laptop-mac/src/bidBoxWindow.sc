;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 745)
(include sci.sh)
(use Main)
(use Piles)
(use Plane)
(use Str)
(use System)

(public
	bidBoxWindow 0
)

(local
	[local0 2]
	local2
	local3
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(if (not (bidBoxWindow casts:))
		(return)
	)
	(= temp1 (Str format: {bidBox}))
	(= temp2 ((bidBoxWindow casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
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

	(method (draw param1 param2 &tmp temp0)
		(if argc
			(cond
				((== bidNumber 0)
					(proc0_10 701 0 0 x y (+ param2 1) param1 {review})
				)
				((== bidNumber 50)
					(proc0_10 701 0 1 x y (+ param2 1) param1 {review})
				)
				((== bidNumber 99)
					(proc0_10 701 0 2 x y (+ param2 1) param1 {review})
				)
				(else
					(proc0_10
						701
						level
						(- suit 1)
						x
						y
						(+ param2 1)
						param1
						{review}
					)
				)
			)
		else
			(if local2
				(if (== local3 703)
					(gSound play: local3)
				else
					(proc0_12 local3)
				)
				(= local2 0)
			)
			(cond
				((== bidNumber 0)
					(proc0_10 701 0 0 x y 14 bidBoxWindow {bidBox})
				)
				((== bidNumber 50)
					(proc0_10 701 0 1 x y 14 bidBoxWindow {bidBox})
				)
				((== bidNumber 99)
					(proc0_10 701 0 2 x y 14 bidBoxWindow {bidBox})
				)
				(else
					(proc0_10 701 level (- suit 1) x y 14 bidBoxWindow {bidBox})
				)
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
		x 0
		y 0
		priority 14
		westOffset 9
		northOffset 69
		eastOffset 129
		southOffset 189
		firstRowYOffset 23
		rowHeight 20
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
		(= local2 0)
		(if (== (param1 type:) 0)
			(cond
				(
					(or
						(== (Dealer curPlayer:) (ScriptID 700 2)) ; hand1
						(== (Dealer curPlayer:) (ScriptID 700 3)) ; hand2
					)
					(if (== (bidBoxWindow top:) 140)
						(BidBox erase:)
						(bidBoxWindow init: param1)
						(BidBox redraw: 1)
					)
				)
				((== (bidBoxWindow top:) 180)
					(BidBox erase:)
					(bidBoxWindow init: param1)
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
		(= underBits 0)
	)

	(method (restore)
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
				(self erase:)
				(bidBoxWindow init: (Dealer curPlayer:))
				(self redraw:)
			)
		)
	)

	(method (init param1)
		(if size
			(self eachElementDo: #dispose)
		)
		(= scrollOffset (= offset (= rowsUsed 0)))
		(bidBoxWindow init: param1)
		(proc0_10 view loop cel 0 0 priority bidBoxWindow)
		(= active 1)
		(= local2 0)
	)

	(method (redraw &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local2 0)
		(if
			(and
				(>= rowsUsed 5)
				(== ((BidBox at: (- (BidBox size:) 1)) location:) 4)
			)
			(BidBox erase:)
			(bidBoxWindow init: (Dealer curPlayer:))
		)
		(= temp5 scrollOffset)
		(proc0_10 view loop cel 0 0 priority bidBoxWindow)
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
		(bidBoxWindow dispose:)
		(= active (= underBits 0))
	)

	(method (addToEnd param1 param2)
		(if argc
			(super addToEnd: param1)
			(param1
				y:
					(+
						0
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
						0
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
					(localproc_0)
					(self redraw:)
				else
					(= selectorForDelayDraw 1330)
				)
			)
			(cond
				((and (== (param1 location:) 4) (> rowsUsed 4))
					(= scrollOffset (+= offset 4))
					(if (or (<= argc 1) (not param2))
						(localproc_0)
						(self redraw:)
					else
						(= objectForDelayDraw self)
						(= selectorForDelayDraw 1330)
					)
				)
				((or (<= argc 1) (not param2))
					(param1 draw:)
				)
				(else
					(= objectForDelayDraw param1)
					(= selectorForDelayDraw 87)
				)
			)
		else
			(super add:)
		)
	)

	(method (newBid param1 param2 &tmp temp0)
		(= local2 1)
		(= local3
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
				(= temp0
					(== (param1 at: temp1) ((BidBox at: temp1) bidNumber:))
				)
			)
		)
		(return temp0)
	)

	(method (isBidObject param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if (== param1 (self at: temp0))
				(return 1)
			)
		)
		(return 0)
	)
)

(instance bidBoxWindow of Plane
	(properties)

	(method (init param1 &tmp [temp0 2])
		(= left 187)
		(= top 180)
		(if
			(and
				(== (param1 type:) 0)
				(or (== param1 (ScriptID 700 4)) (== param1 (ScriptID 700 5))) ; hand3, hand4
			)
			(= top 140)
			(= left 187)
		)
		(= bottom (+ top 130))
		(= right (+ left 255))
		(= priority 9)
		(= picture -2)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
	)

	(method (dispose)
		(if (self casts:)
			(super dispose:)
		)
	)
)

