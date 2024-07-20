;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use bidBoxWindow)
(use Str)
(use GameControls)
(use System)

(public
	bridgeReview 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(if argc
		(if (== param1 1)
			(= temp0 (BidBox scrollOffset:))
			(BidBox scrollOffset: (- (BidBox scrollOffset:) 4))
			(if (< (BidBox scrollOffset:) 0)
				(BidBox scrollOffset: 0)
				(if (== temp0 0)
					(return)
				)
			)
		else
			(BidBox scrollOffset: (+ (BidBox scrollOffset:) 4))
			(if (> (BidBox scrollOffset:) (BidBox offset:))
				(BidBox scrollOffset: (BidBox offset:))
				(return)
			)
		)
	else
		(BidBox scrollOffset: 0)
	)
	(if (!= (BidBox scrollOffset:) 0)
		(= temp3 (= temp4 (BidBox scrollOffset:)))
		(while (> temp3 (- (BidBox scrollOffset:) 4))
			(if (and (>= temp4 0) (== ((BidBox at: temp4) location:) 4))
				(break)
			)
			(-- temp4)
		)
		(BidBox scrollOffset: temp4)
	)
	(= temp3 (BidBox scrollOffset:))
	(= temp1 0)
	(while (and (< temp3 (BidBox size:)) (< temp1 5))
		(= temp2 (BidBox at: temp3))
		(temp2
			x:
				(switch (temp2 location:)
					(4 28)
					(1 88)
					(2 148)
					(3 208)
				)
			y: (+ (* temp1 20) 42)
			draw: bridgeReviewWindow 15
		)
		(if (== (temp2 location:) 3)
			(++ temp1)
		)
		(++ temp3)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(gGame setCursor: 999)
	((= gGameControls bridgeReviewControls)
		plane: bridgeReviewWindow
		helpIconItem: 0
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(if (>= (BidBox rowsUsed:) 1)
		(gGameControls
			add:
				(scrolUp theObj: scrolUp selector: #doit yourself:)
				(scrolDown theObj: scrolDown selector: #doit yourself:)
		)
	)
	(gGameControls show:)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {review}))
	(= temp2 ((bridgeReviewWindow casts:) at: 0))
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

(procedure (localproc_3 &tmp temp0)
	(= temp0 4)
	(if (!= (Dealer dealer:) (ScriptID 700 3)) ; hand2
		(= temp0 (- 4 ((Dealer dealer:) location:)))
	)
	(if (== (BidBox size:) (+ (* (- (BidBox rowsUsed:) 1) 4) temp0))
		(return (BidBox rowsUsed:))
	else
		(return (+ (BidBox rowsUsed:) 1))
	)
)

(instance bridgeReview of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance bridgeReviewWindow of InvisibleWindow
	(properties)

	(method (init &tmp [temp0 2])
		(= top 114)
		(= left (/ (- gScreenWidth 293) 2))
		(= bottom 316)
		(= right (+ (/ (- gScreenWidth 293) 2) 293))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local1 5)
		(super init:)
		(proc0_10 703 0 0 0 0 14 self)
		(proc0_10 703 0 1 19 19 15 bridgeReviewWindow {reviewBid})
		(localproc_0)
	)
)

(instance bridgeReviewControls of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 150
		nsTop 161
		x 150
		y 161
		signal 387
		mainView 703
		mainLoop 1
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance scrolUp of ControlIcon
	(properties
		nsLeft 20
		nsTop 161
		x 20
		y 161
		signal 385
		mainView 703
		mainLoop 2
		highlightColor -1
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(if (> local1 5)
			(-- local1)
			(localproc_2)
			(localproc_0 1)
		)
	)
)

(instance scrolDown of ControlIcon
	(properties
		nsLeft 74
		nsTop 161
		x 74
		y 161
		signal 385
		mainView 703
		mainLoop 3
		highlightColor -1
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(if (> (localproc_3) local1)
			(++ local1)
			(localproc_2)
			(localproc_0 0)
		)
	)
)

