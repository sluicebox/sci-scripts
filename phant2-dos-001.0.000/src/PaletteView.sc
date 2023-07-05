;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64976)
(include sci.sh)
(use Main)
(use Str)
(use PolyEdit)
(use Sight)
(use System)

(class PaletteView of View
	(properties)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new:))
		(temp0 draw: param1 param2)
		(return temp0)
	)

	(method (draw param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap (Bitmap 0 512 320 0 0)) ; Create
		(= left (= top 0))
		(= right 511)
		(= bottom 319)
		(= temp1 -20)
		(= temp3 -1)
		(for ((= temp5 0)) (< temp5 256) ((++ temp5))
			(if (mod temp5 16)
				(+= temp0 32) ; UNINIT
				(+= temp2 32) ; UNINIT
			else
				(= temp0 0)
				(= temp2 31)
				(+= temp1 20)
				(+= temp3 20)
			)
			(if (== param2 temp5)
				(Bitmap 5 bitmap temp0 temp1 temp2 temp3 255) ; AddRect
				(Bitmap
					5 ; AddRect
					bitmap
					(+ temp0 1)
					(+ temp1 1)
					(- temp2 1)
					(- temp3 1)
					temp5
				)
			else
				(Bitmap 5 bitmap temp0 temp1 temp2 temp3 temp5) ; AddRect
			)
		)
		(if param1
			(= temp4 (Str new:))
			(= temp1 -18)
			(= temp3 -3)
			(for ((= temp5 0)) (< temp5 256) ((++ temp5))
				(if (mod temp5 16)
					(+= temp0 32)
					(+= temp2 32)
				else
					(= temp0 3)
					(= temp2 28)
					(+= temp1 20)
					(+= temp3 20)
				)
				(temp4 format: {%d} temp5)
				(Bitmap
					4 ; AddText
					bitmap
					(KArray 9 temp4) ; ArrayGetData
					temp0
					temp1
					temp2
					temp3
					255
					0
					0
					0
					1
					-1
					0
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (- (event x:) x))
		(return (+ (<< (/ (= temp1 (- (event y:) y)) 20) $0004) (/ temp0 32)))
	)
)

(class PalPlane of Window
	(properties
		state 2
		borderWidth 0
	)

	(method (init param1 param2 &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0 (if argc param1 else 0))
		(= temp6 (if (> argc 1) param2 else -1))
		(= scratch (= temp3 (PaletteView new: temp0 temp6)))
		(= priority (+ 1 (GetHighPlanePri)))
		(= temp8 (TitleBar celHeight:))
		(= temp4 (+ 5 (temp3 right:)))
		(= temp5 (+ 5 temp8 (temp3 bottom:)))
		(super init: 5 5 temp4 temp5)
		(temp3 posn: 0 temp8 init: self)
		(= temp7 (Str with: {Select a color}))
		(if (!= temp6 -1)
			(temp7 format: {Current color is %d} temp6)
		)
		(self addTitle: TitleBar 255 0 0 (KArray 9 temp7)) ; ArrayGetData
		(temp7 dispose:)
		((gUser hogs:) push: self 1)
		(FrameOut)
		(gUser doit:)
		(return scratch)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: self)
		(if (and (& (= temp1 (event type:)) evMOUSEBUTTON) (title onMe: event))
			(title handleEvent: event)
			(return)
		)
		(if (or (= temp0 (& temp1 evMOUSERELEASE)) (& temp1 evKEYUP))
			((gUser hogs:) pop:)
			(event claimed: 1)
			(self hide:)
			(Send new: self 8 0)
			(= scratch
				(if (and temp0 (scratch onMe: event))
					(scratch handleEvent: event)
				else
					-1
				)
			)
		else
			(event claimed: 0)
		)
		(event claimed:)
	)
)

