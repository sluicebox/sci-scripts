;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50000)
(include sci.sh)
(use Main)
(use FlipPoly)
(use Cel)

(class P2ScrollBar of Scrollbar
	(properties)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (and (> argc 6) param7)
			(|= state $0080)
		)
		((= temp1 (ScrollbarArrow new:))
			view: param4
			loop: 0
			cel: 0
			cueSelector: 441
			setPri: 200
			x: param5
			y: param6
		)
		((= temp2 (ScrollbarArrow new:))
			view: param4
			loop: 1
			cel: 0
			cueSelector: 440
			setPri: 200
			x:
				(if (& state $0080)
					(+ param5 (CelWide param4 3 0) (CelWide param4 0 0))
				else
					param5
				)
			y:
				(if (& state $0080)
					param6
				else
					(+ param6 (CelHigh param4 3 0) (CelHigh param4 0 0))
				)
		)
		((= temp3 (PageRegion new:))
			type: -1
			celWidth:
				(if (& state $0080)
					(CelHigh param4 3 0)
				else
					(CelWide param4 3 0)
				)
			celHeight: 0
			setPri: 200
			x:
				(if (& state $0080)
					(+ param5 (CelWide param4 0 0))
				else
					param5
				)
			y:
				(if (& state $0080)
					param6
				else
					(+ param6 (CelHigh param4 0 0))
				)
		)
		((= temp4 (PageRegion new:))
			type: 1
			celWidth: (temp3 celWidth:)
			celHeight:
				(if (& state $0080)
					(- (CelWide param4 3 0) (CelWide param4 2 0))
				else
					(- (CelHigh param4 3 0) (CelHigh param4 2 0))
				)
			setPri: 200
			x:
				(if (& state $0080)
					(+ param5 (CelWide param4 0 0) (CelWide param4 2 0))
				else
					param5
				)
			y:
				(if (& state $0080)
					param6
				else
					(+ param6 (CelHigh param4 0 0) (CelHigh param4 2 0))
				)
		)
		((= temp5 (Cel new:))
			view: param4
			loop: 3
			cel: 0
			setPri: 199
			x:
				(if (& state $0080)
					(+ param5 (CelWide param4 0 0))
				else
					param5
				)
			y:
				(if (& state $0080)
					param6
				else
					(+ param6 (CelHigh param4 0 0))
				)
		)
		((= temp0 (Thumb new:))
			view: param4
			loop: 2
			cel: 0
			thumbMin:
				(if (& state $0080)
					(+ param5 (CelWide param4 0 0))
				else
					(+ param6 (CelHigh param4 0 0))
				)
			thumbMax:
				(if (& state $0080)
					(-
						(+ param5 (CelWide param4 0 0) (CelWide param4 3 0))
						(CelWide param4 2 0)
					)
				else
					(-
						(+ param6 (CelHigh param4 0 0) (CelHigh param4 3 0))
						(CelHigh param4 2 0)
					)
				)
			setPri: 200
		)
		(if (& state $0080)
			(temp0 y: param6)
		else
			(temp0 x: param5)
		)
		(= thumbMax (- (temp0 thumbMax:) (temp0 thumbMin:)))
		(= clientPageSize param3)
		(= clientMax param2)
		(= thumbSize
			(if (& state $0080)
				(CelWide (temp0 view:) (temp0 loop:) (temp0 cel:))
			else
				(CelHigh (temp0 view:) (temp0 loop:) (temp0 cel:))
			)
		)
		(= client param1)
		(= temp6 (if (== argc 8) param8 else gThePlane))
		(super init: temp6 temp2 temp1 temp0 temp4 temp3 temp5)
		(return self)
	)

	(method (dispose)
		(if forwardArrow
			(forwardArrow dispose:)
			(= forwardArrow 0)
		)
		(if reverseArrow
			(reverseArrow dispose:)
			(= reverseArrow 0)
		)
		(if thumbButton
			(thumbButton dispose:)
			(= thumbButton 0)
		)
		(if forwardRegion
			(forwardRegion dispose:)
			(= forwardRegion 0)
		)
		(if reverseRegion
			(reverseRegion dispose:)
			(= reverseRegion 0)
		)
		(if physicalBar
			(physicalBar dispose:)
			(= physicalBar 0)
		)
		(super dispose:)
	)
)

