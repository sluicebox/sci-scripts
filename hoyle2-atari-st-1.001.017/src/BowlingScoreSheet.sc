;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 314)
(include sci.sh)
(use Main)
(use Column)
(use WastePile)
(use Reserve)
(use System)

(public
	proc314_0 0
	proc314_1 1
	proc314_2 2
	proc314_3 3
	proc314_4 4
	proc314_5 5
)

(procedure (proc314_4 param1)
	(if
		(and
			(param1 isMemberOf: Reserve)
			(not
				(or
					(and
						(param1 size:)
						(==
							((param1 at: 0) rank:)
							(((gTheWastePiles at: 0) at: 0) rank:)
						)
					)
					(and
						(not (param1 size:))
						(<
							(proc314_2 (gTheReserves indexOf: param1))
							(((gTheWastePiles at: 0) at: 0) rank:)
							(proc314_3 (gTheReserves indexOf: param1))
						)
					)
				)
			)
		)
		(proc0_5 (Format @global100 314 0)) ; "Illegal Move."
		(return 1)
	)
	(return 0)
)

(procedure (proc314_1 param1)
	(if
		(and
			(param1 isMemberOf: Column)
			(== (param1 size:) (+ 2 (if (< global337 400) 1 else 0)))
			(or
				global420
				(and
					(== ((global418 at: (- global417 1)) frame:) 11)
					(not ((global418 at: (- global417 1)) strikes:))
				)
				(and
					(== ((global418 at: (- global417 1)) frame:) 12)
					(== ((global418 at: (- global417 1)) strikes:) 1)
					(== ((global418 at: (- global417 1)) lastFrameScored:) 10)
				)
			)
		)
		(= global420 0)
		(proc314_0)
	)
)

(procedure (proc314_0 &tmp temp0)
	(if
		(and
			(< ((global418 at: (- global417 1)) frame:) 12)
			(>= ((global418 at: (- global417 1)) frame:) 10)
			(< ((global418 at: (- global417 1)) lastFrameScored:) 10)
			(or
				((global418 at: (- global417 1)) spare:)
				((global418 at: (- global417 1)) strikes:)
			)
		)
		(= temp0 3)
		((global418 at: (- global417 1))
			frame: (+ ((global418 at: (- global417 1)) frame:) 1)
		)
	else
		((global418 at: (- global417 1))
			frame: (+ ((global418 at: (- global417 1)) frame:) 1)
		)
		(if (> (++ global417) global422)
			(= global417 1)
			(= temp0 0)
			(if (>= ((global418 at: (- global417 1)) lastFrameScored:) 10)
				(= temp0 2)
				(= global421 1)
			)
		else
			(= temp0 1)
		)
	)
	(proc0_1 11 0 temp0 ((gTheWastePiles at: 0) x:) ((gTheWastePiles at: 0) y:) 8)
	(= global419 1)
)

(procedure (proc314_2 param1 &tmp temp0)
	(if param1
		(for ((= temp0 (- param1 1))) (>= temp0 0) ((-- temp0))
			(if ((gTheReserves at: temp0) size:)
				(return (((gTheReserves at: temp0) at: 0) rank:))
			)
		)
	)
	(return -1)
)

(procedure (proc314_3 param1 &tmp temp0)
	(if (!= param1 9)
		(for ((= temp0 (+ param1 1))) (<= temp0 9) ((++ temp0))
			(if ((gTheReserves at: temp0) size:)
				(return (((gTheReserves at: temp0) at: 0) rank:))
			)
		)
	)
	(return 14)
)

(procedure (proc314_5 param1)
	(if (and global419 (not (param1 isMemberOf: WastePile)))
		(proc0_5 (Format @global100 314 1)) ; "Frame is over."
		(return 1)
	)
	(return 0)
)

(class BowlingScoreSheet of Obj
	(properties
		x 0
		y 0
		view 0
		loop 0
		cel 0
		frame 1
		lastFrameScored 0
		subTotal 0
		strikes 0
		spare 0
		ball 0
		firstBall 0
	)

	(method (init)
		(proc0_1 view loop cel x y 8)
		(= firstBall
			(= ball
				(= strikes
					(= spare
						(= global419
							(= lastFrameScored (= subTotal (= global420 0)))
						)
					)
				)
			)
		)
		(= frame (= global417 1))
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (self howManyPins:))
		(if (== (++ ball) 1)
			(if (== temp0 10)
				(++ strikes)
				(self showLittle: 10)
				(= ball (= firstBall 0))
			else
				(self showLittle: (= firstBall temp0))
			)
			(cond
				((== strikes 3)
					(-- strikes)
					(self showBig: (+= subTotal 30) (++ lastFrameScored))
				)
				((and (== strikes 2) (!= temp0 10))
					(-- strikes)
					(self
						showBig: (+= subTotal (+ 20 temp0)) (++ lastFrameScored)
					)
					(if (and (== frame 12) (== strikes 2))
						(= firstBall (= ball 0))
						(= global420 1)
					)
				)
				(spare
					(= spare 0)
					(self
						showBig: (+= subTotal (+ 10 temp0)) (++ lastFrameScored)
					)
				)
			)
		else
			(= spare (if (== temp0 10) 1 else 0))
			(if spare
				(self showLittle: 11)
			else
				(self showLittle: (- temp0 firstBall))
			)
			(cond
				((== strikes 1)
					(-- strikes)
					(self
						showBig: (+= subTotal (+ 10 temp0)) (++ lastFrameScored)
					)
					(if (and (not spare) (<= frame 10))
						(self showBig: (+= subTotal temp0) (++ lastFrameScored))
					)
				)
				((not spare)
					(self showBig: (+= subTotal temp0) (++ lastFrameScored))
				)
			)
			(= firstBall (= ball 0))
		)
	)

	(method (showLittle param1 &tmp temp0)
		(if (and (< frame 10) (or (== param1 10) (== param1 11)))
			(proc0_1 view 2 param1 (+ x (* (- frame 1) 14) 8) (+ y 1) 8)
		else
			(= temp0 (if (== ball 1) 1 else 8))
			(if (>= frame 10)
				(= temp0 (+ 1 (* (+ (- frame 10) (- ball 1)) 7)))
			)
			(if (and spare (== frame 11))
				(= temp0 15)
			)
			(proc0_1
				view
				2
				param1
				(+ x (* (- (if (< frame 10) frame else 10) 1) 14) temp0)
				(+ y 1)
				8
			)
		)
	)

	(method (showBig param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (mod param1 10))
		(= temp1 (mod (/ param1 10) 10))
		(= temp2 (/ param1 100))
		(= temp3 (if (< lastFrameScored 10) 0 else 3))
		(if temp2
			(proc0_1 view 3 temp2 (+ x (* (- param2 1) 14) 2 temp3) (+ y 10))
		)
		(if (or temp1 temp2)
			(proc0_1 view 3 temp1 (+ x (* (- param2 1) 14) 6 temp3) (+ y 10))
		)
		(proc0_1 view 3 temp0 (+ x (* (- param2 1) 14) 10 temp3) (+ y 10))
	)

	(method (howManyPins &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 10) ((++ temp0))
			(if ((gTheReserves at: temp0) size:)
				(++ temp1)
			)
		)
		(return temp1)
	)
)

