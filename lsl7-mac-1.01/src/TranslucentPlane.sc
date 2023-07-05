;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64884)
(include sci.sh)
(use Plane)
(use Actor)
(use System)

(class TranslucentPlane of Plane
	(properties
		picture -2
		nBorderWidth 4
		remapColor 239
		remapPercent 45
	)

	(method (changeRemap param1)
		(= remapPercent param1)
		(RemapColors 2 remapColor remapPercent) ; ByPercent
	)

	(method (setPri)
		(RemapColors 2 remapColor remapPercent) ; ByPercent
		(super setPri: &rest)
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(super init: &rest)
		(self addCast: (Cast new:))
		(RemapColors 2 remapColor remapPercent) ; ByPercent
		(= temp0 (self getWidth:))
		(= temp1 (self getHeight:))
		(= temp2 (* nBorderWidth 48))
		(= temp4 (* temp0 48))
		(= temp3 (* temp1 48))
		((TransView new:)
			remapColor: remapColor
			x: 0
			y: 0
			setPri: 0
			scaleSignal: 1
			scaleX: temp4
			scaleY: temp3
			maxScale: 20480
			init: (casts at: 0)
		)
		(if nBorderWidth
			((TransView new:)
				remapColor: remapColor
				x: 0
				y: 0
				setPri: 1
				scaleSignal: 1
				scaleX: temp4
				scaleY: temp2
				maxScale: 20480
				init: (casts at: 0)
			)
			((TransView new:)
				remapColor: remapColor
				x: 0
				y: nBorderWidth
				setPri: 1
				scaleSignal: 1
				scaleX: temp2
				scaleY: (* (- temp1 nBorderWidth) 48)
				maxScale: 20480
				init: (casts at: 0)
			)
			((TransView new:)
				remapColor: remapColor
				x: (- temp0 nBorderWidth)
				y: nBorderWidth
				setPri: 1
				scaleSignal: 1
				scaleX: temp2
				scaleY: (* (- temp1 nBorderWidth) 48)
				maxScale: 20480
				init: (casts at: 0)
			)
			((TransView new:)
				remapColor: remapColor
				x: nBorderWidth
				y: (- temp1 nBorderWidth)
				setPri: 1
				scaleSignal: 1
				scaleX: (* (- temp0 (+ nBorderWidth nBorderWidth)) 48)
				scaleY: temp2
				maxScale: 20480
				init: (casts at: 0)
			)
		)
	)
)

(class TransView of View
	(properties
		remapColor 236
	)

	(method (init)
		(= bitmap (Bitmap 0 4 4 255 remapColor 640 480 1)) ; Create
		(Bitmap 5 bitmap 0 0 3 3 remapColor) ; AddRect
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(= temp0 0)
		(if bitmap
			(= temp0 bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)
)

