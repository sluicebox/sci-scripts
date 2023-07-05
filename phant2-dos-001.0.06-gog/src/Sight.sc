;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64982)
(include sci.sh)
(use Main)
(use Plane)
(use Array)
(use PolyEdit)
(use Responder)
(use TextField)

(class PlaneResizer of Responder
	(properties
		case -1
		baseLine -1
	)

	(method (check param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (client plane:))
		(= temp1 (temp0 left:))
		(= temp2 (temp0 top:))
		(= temp3 (temp0 right:))
		(= temp4 (temp0 bottom:))
		(if (& case $0001)
			(= temp5 (- param2 baseLine))
			(= baseLine param2)
			(if (& case $0002)
				(+= temp4 temp5)
			else
				(+= temp2 temp5)
			)
		else
			(= temp5 (- param1 baseLine))
			(= baseLine param1)
			(if (& case $0002)
				(+= temp3 temp5)
			else
				(+= temp1 temp5)
			)
		)
		(temp0 setRect: temp1 temp2 temp3 temp4 1)
	)

	(method (handleEvent event)
		(cond
			((& state $0008)
				(event claimed: self)
				(if (gUser mouseMoved:)
					(event globalize:)
					(self check: (event x:) (event y:))
					(FrameOut)
				)
				(if (and (& evMOUSERELEASE (event type:)) (not (event modifiers:)))
					((gUser hogs:) pop:)
					(= case -1)
					(&= state $fff7)
				)
			)
			((and (& evMOUSEBUTTON (event type:)) (not (event modifiers:)))
				(event globalize:)
				(= case (client edge:))
				(= baseLine
					(if (& case $0001)
						(event y:)
					else
						(event x:)
					)
				)
				(event claimed: self)
				((client plane:) setPri: (+ 1 (GetHighPlanePri)) 1)
				(|= state $0008)
				((gUser hogs:) push: self 1)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(if (& state $0008)
			(&= state $fff7)
			(= case -1)
			((gUser hogs:) pop:)
		)
		(super dispose: &rest)
	)
)

(class Border of View
	(properties
		edge -1
	)

	(method (new param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 (super new:))
		(if argc
			(temp0
				draw: param1 param2 param3 param4 param5
				setPri: gScreenHeight
				init: param6
			)
			(if (& (param6 state:) $0001)
				(PlaneResizer new: temp0)
			)
		)
		(return temp0)
	)

	(method (draw param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= edge param1)
		(= temp0 (not param5))
		(= x (= y 0))
		(if (& param1 $0001)
			(= temp1 param2)
			(= temp2 param4)
			(if (& param1 $0002)
				(= y (- param3 param4))
			)
		else
			(= temp1 param4)
			(= temp2 param3)
			(if (& param1 $0002)
				(= x (- param2 param4))
			)
		)
		(= bitmap (Bitmap 0 temp1 temp2 temp0 param5)) ; Create
	)
)

(class Window of Plane
	(properties
		state 3
		borderColor 255
		borderWidth 2
		borderLines 0
		title 0
	)

	(method (init)
		(super init: &rest)
		(self drawBorder: 1)
	)

	(method (dispose)
		(if borderLines
			(borderLines dispose:)
			(= borderLines 0)
		)
		(= title 0)
		(super dispose:)
	)

	(method (addTitle param1 param2 param3 param4 param5)
		(if title
			(title dispose:)
		)
		((= title (param1 new:)) fore: param2 borderColor: param3 font: param4)
		(title setText: param5 &rest)
		(title init: self (& state $0002))
	)

	(method (drawBorder param1 &tmp temp0 temp1 temp2)
		(= temp2 (+ 1 (- right left)))
		(= temp1 (+ 1 (- bottom top)))
		(cond
			(borderLines
				((borderLines at: 0)
					draw: 0 temp2 temp1 borderWidth borderColor
					update:
				)
				((borderLines at: 1)
					draw: 1 temp2 temp1 borderWidth borderColor
					update:
				)
				((borderLines at: 2)
					draw: 2 temp2 temp1 borderWidth borderColor
					update:
				)
				((borderLines at: 3)
					draw: 3 temp2 temp1 borderWidth borderColor
					update:
				)
			)
			(borderWidth
				(= borderLines
					(IntArray
						with:
							(Border
								new: 0 temp2 temp1 borderWidth borderColor self
							)
							(Border
								new: 1 temp2 temp1 borderWidth borderColor self
							)
							(Border
								new: 2 temp2 temp1 borderWidth borderColor self
							)
							(Border
								new: 3 temp2 temp1 borderWidth borderColor self
							)
					)
				)
			)
		)
		(if (and (> argc 1) param1)
			(self update:)
		)
	)

	(method (setRect param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (- (- param3 param1) (- right left)))
		(= temp3 (- (- param4 param2) (- bottom top)))
		(= temp1 (if title temp2))
		(= temp0 (if (> argc 4) param5 else 0))
		(super setRect: param1 param2 param3 param4)
		(if temp1
			(title setSize: draw: update:)
		)
		(if (and borderLines (or temp2 temp3))
			(self drawBorder:)
		)
		(if temp0
			(self update:)
		)
	)
)

(class TitleBar of TextView
	(properties
		celHeight 20
		fore 255
		font 0
	)

	(method (init param1 param2)
		(= plane
			(cond
				(argc param1)
				(plane plane)
				(else gThePlane)
			)
		)
		(self setSize:)
		(super init:)
		(if (and (> argc 1) param2)
			((Dragger new: self) state: 32 dragOrigin: 0 yourself:)
		)
	)

	(method (posn param1 param2)
		(plane posn: (- param1 x) (- param2 y) plane)
	)

	(method (setPri)
		(plane setPri: (+ 1 (GetHighPlanePri)) 1)
	)

	(method (setSize &tmp temp0)
		(= x
			(= y
				(= temp0
					(if (plane respondsTo: #borderWidth)
						(plane borderWidth:)
					else
						0
					)
				)
			)
		)
		(= celWidth (- (+ 1 (- (plane right:) (plane left:))) (<< temp0 $0001)))
		(text
			textLeft: 0
			textRight: (- celWidth 1)
			textTop: 0
			textBottom: -1
			setSize: celWidth celHeight
		)
		(= left x)
		(= top y)
		(= right (+ x celWidth -1))
		(= bottom (+ y celHeight -1))
	)

	(method (setText)
		(if (not text)
			(= text (TextField new:))
			(text fore: fore back: borderColor font: font mode: 1)
		)
		(super setText: &rest)
	)
)

