;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 877)
(include sci.sh)
(use LoadMany)
(use Window)

(class SpeakWindow of SysWindow
	(properties
		priority -1
		hMargin 0
		vMargin 0
		tailTop 0
		tailLeft 0
		tailBottom 0
		tailRight 0
		tailBits 0
		tailX 0
		tailY 0
		isBottom 1
		xOffset 0
		underBits1 0
		underBits2 0
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 993)
	)

	(method (move param1 param2)
		(+= top param2)
		(+= left param1)
		(+= bottom param2)
		(+= right param1)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 left) (- param2 top))
	)

	(method (repos param1 param2)
		(+= top param2)
		(+= left param1)
		(-= bottom param2)
		(-= right param1)
	)

	(method (open &tmp [temp0 2] temp2 temp3 temp4 [temp5 2] temp7 temp8 temp9)
		(SetPort 0)
		(= priority 15)
		(= color 0)
		(= back 6)
		(= temp8 1)
		(if (!= priority -1)
			(|= temp8 $0002)
		)
		(= temp2 (- right left))
		(= temp9 (- bottom top))
		(cond
			((not xOffset)
				(= temp3 2)
			)
			((< 0 xOffset)
				(= temp3 0)
			)
			(else
				(= temp3 1)
			)
		)
		(if (not isBottom)
			(+= temp3 3)
			(= lsTop (+ tailY (CelHigh 993 0 temp3)))
			(= top (+ lsTop 3))
			(= bottom (+ top temp9))
			(= lsBottom (+ bottom 3))
		else
			(= lsBottom tailY)
			(= bottom (- lsBottom 3))
			(= top (- bottom temp9))
			(= lsTop (- top 3))
		)
		(= lsLeft (- (= temp4 (+ (- tailX (/ temp2 2)) xOffset)) 3))
		(= left temp4)
		(= right (+ left temp2))
		(= lsRight (+ 4 right))
		(= type 128)
		(= tailTop tailY)
		(= tailLeft tailX)
		(= tailBottom (+ tailY (if isBottom -2 else 1) (CelHigh 993 0 temp3)))
		(= tailRight (+ tailX (CelWide 993 0 temp3)))
		(= underBits1 (Graph grSAVE_BOX tailTop tailLeft tailBottom tailRight temp8))
		(super open: &rest)
		(= temp7 (GetPort))
		(SetPort 0)
		(Graph
			grFILL_BOX
			(- top 3)
			(+ left 3)
			(+ bottom 2)
			(- right 3)
			temp8
			back
			priority
		)
		(Graph
			grFILL_BOX
			(+ top 3)
			(- left 3)
			(- bottom 3)
			(+ right 3)
			temp8
			back
			priority
		)
		(DrawCel 993 1 0 (- left 3) (- top 3) priority)
		(DrawCel 993 1 1 (+ (- right (CelWide 993 1 0)) 3) (- top 3) priority)
		(DrawCel
			993
			1
			3
			(+ (- right (CelWide 993 1 0)) 3)
			(+ (- bottom (CelHigh 993 1 0)) 3)
			priority
		)
		(DrawCel 993 1 2 (- left 3) (+ (- bottom (CelHigh 993 1 0)) 3) priority)
		(= temp2 6)
		(= temp9 3)
		(Graph grDRAW_LINE lsTop (+ left temp2) (- top temp9) (- right temp2) 7 -1 -1)
		(Graph
			grDRAW_LINE
			(+ top (* temp9 2))
			lsLeft
			(- bottom (* temp9 2))
			lsLeft
			7
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ top (* temp9 2))
			(- lsRight 2)
			(- bottom (* temp9 2))
			(- lsRight 2)
			5
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- lsBottom 2)
			(+ left temp2)
			(- lsBottom 2)
			(- right temp2)
			4
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- lsBottom 1)
			(+ left temp2)
			(- lsBottom 1)
			(- right temp2)
			0
			-1
			-1
		)
		(DrawCel 993 0 temp3 tailX (+ tailY (if isBottom -2 else 1)) priority)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(Graph
			grREDRAW_BOX
			tailY
			tailX
			(+ tailY (if isBottom -2 else 1) (CelHigh 993 0 temp3))
			(+ tailX (CelWide 993 0 temp3))
		)
		(SetPort temp7)
	)

	(method (dispose &tmp temp0)
		(super dispose: &rest)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX underBits1)
		(Graph grUPDATE_BOX tailTop tailLeft tailBottom tailRight 1)
		(SetPort temp0)
	)
)

