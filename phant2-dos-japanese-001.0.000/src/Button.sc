;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64987)
(include sci.sh)
(use Main)
(use DItem)
(use TextField)
(use Menu)
(use System)

(class Button of DItem
	(properties)

	(method (update)
		(if (not (not (& state $0001)))
			(= cel 0)
			(if (not (not (& state $0002)))
				(= cel 2)
			)
			(if (not (not (& state $0020)))
				(++ cel)
			)
		else
			(= cel 4)
		)
		(super update: &rest)
	)
)

(class TextButton of DItem
	(properties
		back 0
		text 0
		textLeft 3
		textTop 3
		bitmaps 0
		celHeight -1
		celWidth -1
	)

	(method (init)
		(self draw:)
		(super init: &rest)
	)

	(method (dispose)
		(if text
			(text dispose:)
			(= text 0)
		)
		(self disposeMaps: 0 1)
		(super dispose: &rest)
	)

	(method (disposeMaps param1 param2 &tmp temp0 temp1)
		(if bitmaps
			(if (and argc param1)
				(= bitmap 0)
			)
			(for
				((= temp0 (bitmaps first:)))
				temp0
				((= temp0 (bitmaps next: temp0)))
				
				(= temp1 (bitmaps value: temp0))
				(if (or (and argc param1) (!= temp1 bitmap))
					(Bitmap 1 temp1) ; Dispose
				)
			)
			(bitmaps release:)
			(if (and (> argc 1) param2)
				(bitmaps dispose:)
				(= bitmaps 0)
			)
		)
	)

	(method (draw param1 &tmp temp0 temp1 temp2 temp3)
		(if bitmaps
			(self disposeMaps: 1)
		else
			(= bitmaps (List new:))
		)
		(if (== view -1)
			(= temp0 (text skip:))
			(= temp1 (+ 1 gSystemPlane))
			(= temp2 (- celWidth temp1))
			(= temp3 (- celHeight temp1))
			(bitmaps addToEnd: (Bitmap 0 celWidth celHeight temp0 back)) ; Create
			(bitmaps addToEnd: (Bitmap 0 celWidth celHeight temp0 back)) ; Create
			(= temp1 (Bitmap 0 celWidth celHeight temp0 global35)) ; Create
			(Bitmap
				5 ; AddRect
				temp1
				gSystemPlane
				gSystemPlane
				(- celWidth (+ 1 gSystemPlane))
				(- celHeight (+ 1 gSystemPlane))
				back
			)
			(bitmaps addToEnd: temp1)
			(= temp1 (Bitmap 0 celWidth celHeight temp0 global35)) ; Create
			(Bitmap
				5 ; AddRect
				temp1
				gSystemPlane
				gSystemPlane
				(- celWidth (+ 1 gSystemPlane))
				(- celHeight (+ 1 gSystemPlane))
				back
			)
			(bitmaps addToEnd: temp1)
			(bitmaps addToEnd: (Bitmap 0 celWidth celHeight temp0 back)) ; Create
		else
			(bitmaps addToEnd: (Bitmap 9 view loop 0)) ; CreateWithCel
			(bitmaps addToEnd: (Bitmap 9 view loop 1)) ; CreateWithCel
			(bitmaps addToEnd: (Bitmap 9 view loop 2)) ; CreateWithCel
			(bitmaps addToEnd: (Bitmap 9 view loop 3)) ; CreateWithCel
			(bitmaps addToEnd: (Bitmap 9 view loop 4)) ; CreateWithCel
		)
		(text fore: gUseSortedFeatures draw: (bitmaps at: 0))
		(text fore: gOverlays draw: (bitmaps at: 1))
		(text fore: gUseSortedFeatures draw: (bitmaps at: 2))
		(text fore: gOverlays draw: (bitmaps at: 3))
		(text fore: gDoMotionCue draw: (bitmaps at: 4))
		(= bitmap (bitmaps at: 0))
		(if (and argc param1)
			(self update:)
		)
	)

	(method (setSize &tmp temp0 temp1)
		(text textLeft: textLeft textTop: textTop back: back setSize:)
		(if (== view -1)
			(if (== celWidth -1)
				(= celWidth (+ (text textWidth:) (<< textLeft $0001)))
			)
			(if (== celHeight -1)
				(= celHeight (+ (text textHeight:) (<< textTop $0001)))
			)
		else
			(= celWidth (CelWide view loop 0))
			(= celHeight (CelHigh view loop 0))
		)
		(= temp0 (+ textLeft (text textWidth:)))
		(= temp1 (+ textTop (text textHeight:)))
		(if (or (> temp0 celWidth) (> temp1 celHeight))
			(PrintDebug
				{Cel(%d,%d) too small for text(%d,%d)\n}
				celWidth
				celHeight
				temp0
				temp1
			)
			(Empty self)
		)
		(= left x)
		(= top y)
		(= right (+ x celWidth -1))
		(= bottom (+ y celHeight -1))
	)

	(method (setText param1)
		(if (not (OneOf argc 1 5))
			(PrintDebug {Bad argc(%d) for TextButton setText} argc)
			(Empty self)
		)
		(if (not text)
			(= text (TextField new:))
		)
		(if (== argc 1)
			(text format: (KArray 9 param1)) ; ArrayGetData
		else
			(text read: param1 &rest)
		)
	)

	(method (update)
		(if (not (not (& state $0001)))
			(= cel 0)
			(if (not (not (& state $0002)))
				(= cel 2)
			)
			(if (not (not (& state $0020)))
				(++ cel)
			)
		else
			(= cel 4)
		)
		(= bitmap (bitmaps at: cel))
		(super update: &rest)
	)
)

