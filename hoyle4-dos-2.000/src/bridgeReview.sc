;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Bid)
(use GameControls)
(use System)

(public
	bridgeReview 0
)

(local
	local0
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
	(DrawCel 703 0 1 7 12 14)
	(= temp3 (BidBox scrollOffset:))
	(= temp1 0)
	(while (and (< temp3 (BidBox size:)) (< temp1 5))
		(= temp2 (BidBox at: temp3))
		(temp2
			x:
				(switch (temp2 location:)
					(4 7)
					(1 40)
					(2 73)
					(3 106)
				)
			y: (+ (* temp1 10) 26)
			draw:
		)
		(if (== (temp2 location:) 3)
			(++ temp1)
		)
		(++ temp3)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	((= gGameControls bridgeReviewControls)
		window: bridgeReviewWindow
		helpIconItem: 0
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(if (>= (BidBox rowsUsed:) 5)
		(gGameControls
			add:
				(scrollUp theObj: scrollUp selector: #doit yourself:)
				(scrollDown theObj: scrollDown selector: #doit yourself:)
		)
	)
	(gGameControls show:)
)

(instance bridgeReview of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance bridgeReviewWindow of InvisibleWindow
	(properties
		top 40
		left 78
		bottom 148
		right 243
	)

	(method (open &tmp [temp0 2])
		(super open:)
		(DrawCel 703 0 0 0 0 14)
		(localproc_0)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance bridgeReviewControls of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 703
		loop 1
		cel 0
		nsLeft 71
		nsTop 81
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance scrollUp of ControlIcon
	(properties
		view 703
		loop 2
		cel 0
		nsLeft 140
		nsTop 12
		signal 385
		highlightColor -1
	)

	(method (doit)
		(localproc_0 1)
	)
)

(instance scrollDown of ControlIcon
	(properties
		view 703
		loop 3
		cel 0
		nsLeft 140
		nsTop 19
		signal 385
		highlightColor -1
	)

	(method (doit)
		(localproc_0 0)
	)
)

