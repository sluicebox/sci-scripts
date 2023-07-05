;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Game)

(class BubbleWindow of SysWindow
	(properties
		priority 15
		type 129
		underBits 0
		view 0
		vColor 0
		tailUnderbits 0
		tailLeft 0
		tailTop 0
		tailBottom 0
		tailRight 0
		tNum 0
		pPort 0
	)

	(method (open param1 param2 param3 param4 &tmp temp0 temp1)
		(= pPort (GetPort))
		(SetPort 0)
		(= color
			(if (or (not global535) global439)
				global511
			else
				(Palette palFIND_COLOR 164 59 59)
			)
		)
		(= back
			(if (or (not global535) global439)
				global512
			else
				(Palette palFIND_COLOR 248 236 156)
			)
		)
		(if global552
			(= color 0)
			(= back 15)
			(= global513 8)
		)
		(= priority 15)
		(= tNum param2)
		(if (and (>= argc 2) tNum)
			(= temp0 (- right left))
			(= temp1 (- bottom top))
			(cond
				((or (== tNum 1) (>= tNum 9))
					(= tailTop (- param4 (CelHigh view global513 (- tNum 1))))
				)
				((<= 3 tNum 7)
					(= tailTop param4)
				)
				(else
					(= tailTop
						(- param4 (/ (CelHigh view global513 (- tNum 1)) 2))
					)
				)
			)
			(cond
				((or (<= tNum 4) (== tNum 12))
					(= tailLeft (- param3 (CelWide view global513 (- tNum 1))))
				)
				((<= 5 tNum 10)
					(= tailLeft param3)
				)
				(else
					(= tailLeft
						(- param3 (/ (CelWide view global513 (- tNum 1)) 2))
					)
				)
			)
			(= tailBottom (+ tailTop (CelHigh view global513 (- tNum 1))))
			(= tailRight (+ tailLeft (CelWide view global513 (- tNum 1))))
			(if (< global534 2)
				(= tailUnderbits
					(Graph grSAVE_BOX tailTop tailLeft tailBottom tailRight 3)
				)
			)
			(cond
				((<= tNum 3)
					(= right (+ tailLeft 1))
					(= left (- right temp0))
				)
				((<= 4 tNum 6)
					(= top (- tailBottom 1))
					(= bottom (+ top temp1))
				)
				((<= 7 tNum 9)
					(= left (- tailRight 1))
					(= right (+ left temp0))
				)
				(else
					(= bottom (+ tailTop 1))
					(= top (- bottom temp1))
				)
			)
			(switch tNum
				(1
					(= bottom (+ tailBottom 12))
					(= top (- bottom temp1))
				)
				(2
					(= bottom (+ (/ (+ tailBottom tailTop) 2) (/ temp1 2)))
					(= top (- bottom temp1))
				)
				(3
					(= top (- tailTop 12))
					(= bottom (+ top temp1))
				)
				(4
					(= right (+ tailRight 12))
					(= left (- right temp0))
				)
				(5
					(= right (+ (/ (+ tailRight tailLeft) 2) (/ temp0 2)))
					(= left (- right temp0))
				)
				(6
					(= left (- tailLeft 12))
					(= right (+ left temp0))
				)
				(7
					(= top (- tailTop 12))
					(= bottom (+ top temp1))
				)
				(8
					(= bottom (+ (/ (+ tailBottom tailTop) 2) (/ temp1 2)))
					(= top (- bottom temp1))
				)
				(9
					(= bottom (+ tailBottom 12))
					(= top (- bottom temp1))
				)
				(10
					(= left (- tailLeft 12))
					(= right (+ left temp0))
				)
				(11
					(= right (+ (/ (+ tailRight tailLeft) 2) (/ temp0 2)))
					(= left (- right temp0))
				)
				(12
					(= right (+ tailRight 12))
					(= left (- right temp0))
				)
			)
			(if (and (<= temp1 24) (or (<= tNum 3) (<= 7 tNum 9)))
				(= top (- tailTop 6))
				(= bottom (+ top temp1))
			)
		)
		(= underBits (Graph grSAVE_BOX top left bottom right 3))
		(Graph
			grFILL_BOX
			(+ top 12)
			(+ left 12)
			(- bottom 12)
			(- right 12)
			3
			back
			priority
		)
		(Graph grFILL_BOX top (+ left 12) (+ top 12) (- right 12) 3 back priority)
		(Graph grFILL_BOX (+ top 12) left (- bottom 12) (+ left 12) 3 back priority)
		(Graph grFILL_BOX (- bottom 12) (+ left 12) bottom (- right 12) 3 back priority)
		(Graph grFILL_BOX (+ top 12) (- right 12) (- bottom 12) right 3 back priority)
		(DrawCel view global513 12 left top priority)
		(DrawCel
			view
			global513
			13
			(- right (CelWide view global513 13))
			top
			priority
		)
		(DrawCel
			view
			global513
			14
			left
			(- bottom (CelHigh view global513 14))
			priority
		)
		(DrawCel
			view
			global513
			15
			(- right (CelWide view global513 15))
			(- bottom (CelHigh view global513 15))
			priority
		)
		(Graph grDRAW_LINE top (+ left 12) top (- right 12) vColor priority -1)
		(Graph
			grDRAW_LINE
			(- bottom 1)
			(+ left 12)
			(- bottom 1)
			(- right 12)
			vColor
			priority
			-1
		)
		(Graph grDRAW_LINE (+ top 12) left (- bottom 12) left vColor priority -1)
		(Graph
			grDRAW_LINE
			(+ top 12)
			(- right 1)
			(- bottom 12)
			(- right 1)
			vColor
			priority
			-1
		)
		(if (and (< global534 2) (>= argc 2) tNum)
			(DrawCel view global513 (- param2 1) tailLeft tailTop priority)
		)
		(Graph grUPDATE_BOX top left bottom right 1)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(if tailUnderbits
			(Graph grRESTORE_BOX tailUnderbits)
			(Graph grUPDATE_BOX tailTop tailLeft tailBottom tailRight 1)
			(= tailUnderbits 0)
		)
		(Graph grRESTORE_BOX underBits)
		(Graph grUPDATE_BOX top left bottom right 1)
		(SetPort pPort)
		(DisposeWindow window)
		(DisposeClone self)
	)
)

