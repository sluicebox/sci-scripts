;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Window)

(class InvisibleWindow of SysWindow
	(properties)

	(method (open)
		(SetPort 0)
		(Graph grUPDATE_BOX (- top 1) (- left 1) (+ bottom 1) (+ right 1) 1)
		(= lsTop top)
		(= lsBottom bottom)
		(= lsRight right)
		(= lsLeft (- left 1))
		(|= type $0080)
		(super open:)
	)
)

(class HoyleWindow of SysWindow
	(properties
		brBottom 200
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(SetPort 0)
		(= temp11 0)
		(= priority 15)
		(= temp0 1)
		(= lsTop (- top 3))
		(= lsLeft (- left 3))
		(= lsBottom (+ bottom 4))
		(= lsRight (+ right 3))
		(= type 128)
		(super open:)
		(= temp2 (- (CelWide 924 0 0) (- right left)))
		(= temp3 (- (CelHigh 924 0 0) (- bottom top)))
		(= temp8 (PicNotValid))
		(PicNotValid 1)
		(if (> global254 (+ global255 15))
			(DrawCel
				924
				0
				0
				(- 0 (Random 0 temp2))
				(- 0 (Random 0 temp3))
				priority
			)
			(= temp11 1)
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(if (not temp11)
			(Graph
				grFILL_BOX
				(+ lsTop 3)
				(+ lsLeft 3)
				(- lsBottom 4)
				(- lsRight 4)
				1
				49
				priority
			)
		)
		(= temp4 (+ lsLeft (CelWide 923 2 0)))
		(= temp5 lsTop)
		(= temp6 (CelWide 923 3 1))
		(while (<= temp4 (- lsRight temp6))
			(if (> (+ 4 temp4) (- lsRight temp6))
				(-= temp4 4)
			)
			(DrawCel 923 3 1 temp4 temp5 priority)
			(+= temp4 temp6)
		)
		(= temp4 (+ lsLeft (CelWide 923 2 0)))
		(= temp5 (- (- lsBottom (CelHigh 923 3 0)) 1))
		(= temp6 (CelWide 923 3 0))
		(while (<= temp4 (- lsRight temp6))
			(if (> (+ 4 temp4) (- lsRight temp6))
				(-= temp4 4)
			)
			(DrawCel 923 3 0 temp4 temp5 priority)
			(+= temp4 temp6)
		)
		(= temp4 lsLeft)
		(= temp5 (+ lsTop (CelHigh 923 2 0)))
		(= temp7 (CelHigh 923 2 0))
		(while (<= temp5 (- lsBottom temp7))
			(if (> (+ 4 temp5) (- lsBottom temp7))
				(-= temp5 4)
			)
			(DrawCel 923 2 0 temp4 temp5 priority)
			(+= temp5 temp7)
		)
		(= temp4 (- (- lsRight (CelWide 923 2 1)) 1))
		(= temp5 (+ lsTop (CelHigh 923 2 0)))
		(= temp7 (CelHigh 923 2 1))
		(while (<= temp5 (- lsBottom temp7))
			(if (> (+ 4 temp5) (- lsBottom temp7))
				(-= temp5 4)
			)
			(DrawCel 923 2 1 temp4 temp5 priority)
			(+= temp5 temp7)
		)
		(= temp9
			(switch global122
				(1 1)
				(4 4)
				(else 1)
			)
		)
		(= temp10
			(switch global122
				(1 923)
				(4 924)
				(else 923)
			)
		)
		(DrawCel temp10 temp9 0 lsLeft lsTop priority)
		(DrawCel
			temp10
			temp9
			1
			(- lsRight (+ (CelWide temp10 temp9 1) 1))
			lsTop
			priority
		)
		(DrawCel
			temp10
			temp9
			2
			lsLeft
			(- lsBottom (+ (CelHigh temp10 temp9 2) 1))
			priority
		)
		(DrawCel
			temp10
			temp9
			3
			(- lsRight (+ (CelWide temp10 temp9 3) 1))
			(- lsBottom (+ (CelHigh temp10 temp9 3) 1))
			priority
		)
		(PicNotValid temp8)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight temp0)
		(SetPort temp1)
	)
)

