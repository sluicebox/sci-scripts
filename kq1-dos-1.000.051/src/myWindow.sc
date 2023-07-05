;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 778)
(include sci.sh)
(use Save)

(class myWindow of SysWindow
	(properties
		back 11
		type 129
		blunderBits 0
		underBits 0
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp7 (CelHigh 657 0 0))
		(= temp5 (CelHigh 657 0 1))
		(= temp6 (CelHigh 657 0 2))
		(= temp8 (CelWide 657 0 3))
		(= temp9 (CelWide 657 1 0))
		(SetPort 0)
		(= temp1 (- top 5))
		(= temp2 (* (/ (= temp2 (- left 8)) 8) 8))
		(= temp3 (+ bottom 8))
		(if (mod (= temp4 (+ right 8)) 8)
			(= temp4 (+ (* (/ temp4 8) 8) 8))
		)
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= underBits (Graph grSAVE_BOX temp1 temp2 temp3 temp4 temp0))
		(= temp1 (- top 15))
		(= blunderBits
			(Graph
				grSAVE_BOX
				temp1
				(- (/ (+ left right) 2) (/ temp9 2))
				(+ temp1 10)
				(+ (/ (+ left right) 2) (/ temp9 2) 1)
				temp0
			)
		)
		(Graph grFILL_BOX (+ temp1 10) temp2 temp3 temp4 temp0 0 priority)
		(Graph
			grFILL_BOX
			(+ temp1 16)
			(+ temp2 6)
			(- temp3 6)
			(- temp4 6)
			temp0
			back
			priority
		)
		(DrawCel 657 1 0 (- (/ (+ left right) 2) (/ temp9 2)) temp1 -1)
		(DrawCel 657 0 0 temp2 (+ temp1 10) -1)
		(DrawCel 657 0 0 temp2 (- temp3 temp5) -1)
		(DrawCel 657 0 0 (- temp4 temp6) (+ temp1 10) -1)
		(DrawCel 657 0 0 (- temp4 temp6) (- temp3 temp5) -1)
		(Graph
			grDRAW_LINE
			(+ temp1 10)
			(- (+ temp2 temp8) 1)
			(+ temp1 10)
			(- temp4 temp8)
			53
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 13)
			(- (+ temp2 temp8) 1)
			(+ temp1 13)
			(- temp4 temp8)
			53
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 1)
			(- (+ temp2 temp8) 1)
			(- temp3 1)
			(- temp4 temp8)
			53
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 4)
			(- (+ temp2 temp8) 1)
			(- temp3 4)
			(- temp4 temp8)
			53
			-1
			-1
		)
		(Graph grDRAW_LINE (+ temp1 temp7 9) temp2 (- temp3 temp7) temp2 53 -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7 9)
			(+ temp2 3)
			(- temp3 temp7)
			(+ temp2 3)
			53
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7 9)
			(- temp4 1)
			(- temp3 temp7)
			(- temp4 1)
			53
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7 9)
			(- temp4 4)
			(- temp3 temp7)
			(- temp4 4)
			53
			-1
			-1
		)
		(Graph grUPDATE_BOX (+ temp1 10) temp2 temp3 temp4 1)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX blunderBits)
		(Graph grREDRAW_BOX (- top 20) (- left 20) (+ bottom 20) (+ right 20))
		(DisposeWindow window)
		(DisposeClone self)
	)
)

