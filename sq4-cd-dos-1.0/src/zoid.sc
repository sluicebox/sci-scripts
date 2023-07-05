;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 819)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use System)

(public
	zoid 0
)

(instance zoid of Sq4View
	(properties
		x 106
		y 25
		view 1950
		priority 15
		signal 24593
	)

	(method (init &tmp temp0)
		(= view 1950)
		(= cel (= loop 0))
		(= x 106)
		(= y 25)
		(= priority 15)
		(self show:)
		(while
			(not
				(OneOf
					((= temp0 ((gUser curEvent:) new:)) type:)
					4
					1
					256
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(self dispose:)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 [temp4 30])
		(= nsRight (+ x (CelWide view loop cel)))
		(= nsBottom (+ y (CelHigh view loop cel)))
		(= underBits (Graph grSAVE_BOX y x nsBottom nsRight 3))
		(DrawCel view loop cel x y priority)
		(Format @temp4 {%d} gBuckazoidCount)
		(= temp3 (StrLen @temp4))
		(self loop: 1 cel: 0 x: (- 194 (* 8 temp3)) y: 66)
		(for ((= temp1 0)) (< temp1 temp3) ((++ temp1))
			(= temp0 (- (StrAt @temp4 temp1) 48))
			(DrawCel view loop temp0 x 66 priority)
			(+= x 8)
		)
		(Graph grUPDATE_BOX 66 x nsBottom nsRight 1)
	)

	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(Graph grUPDATE_BOX 25 106 nsBottom nsRight 1)
		(Graph grREDRAW_BOX 25 106 nsBottom nsRight)
		(= underBits 0)
	)

	(method (dispose)
		(self hide:)
		(super dispose: &rest)
	)
)

