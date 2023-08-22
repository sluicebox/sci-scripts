;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64986)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Array)
(use PolyEdit)
(use System)

(public
	proc64986_0 0
	proc64986_1 1
	proc64986_2 2
)

(procedure (proc64986_0 &tmp temp0 temp1)
	(= temp1 (TextField format: &rest))
	(= temp0 (TextView new:))
	(temp1 font: gKeyDownHandler fore: gMouseDownHandler back: gDirectionHandler skip: gSpeechHandler)
	(temp0 text: temp1 setSize:)
	(QuickPrint new: temp0)
	(FrameOut)
	(gUser doit:)
)

(procedure (proc64986_1 param1 param2 param3)
	(InputText (KArray 9 param1) (KArray 9 param3) param2) ; ArrayGetData, ArrayGetData
)

(procedure (proc64986_2 param1 param2 &tmp temp0 temp1)
	(= temp0 (Str new: 80))
	(= temp1 -1)
	(if (> argc 1)
		(temp0 format: {%d} param2)
		(= temp1 param2)
	)
	(if (InputText (KArray 9 temp0) (KArray 9 param1) 24) ; ArrayGetData, ArrayGetData
		(= temp1 (temp0 asInteger:))
	)
	(temp0 dispose:)
	(return temp1)
)

(class TextField of Str
	(properties
		back 0
		textLeft 0
		textTop 0
		fore 255
		skip 1
		font 0
		mode 0
		textRight -1
		textBottom -1
		textWidth 0
		textHeight -1
		width 0
	)

	(method (draw param1)
		(Bitmap
			4 ; AddText
			param1
			data
			textLeft
			textTop
			textRight
			textBottom
			fore
			back
			skip
			font
			mode
			-1
			0
		)
		(return param1)
	)

	(method (read param1)
		(Message msgGET param1 &rest data)
	)

	(method (getSize param1 &tmp temp0)
		(if argc
			(= width param1)
		)
		(= temp0 (IntArray with: 0 0 0 0))
		(Text 0 (temp0 data:) data font width) ; TextSize
		(= textWidth (+ 1 (temp0 at: 2)))
		(= textHeight (+ 1 (temp0 at: 3)))
		(temp0 dispose:)
		(if (not (self size:))
			(= textHeight (Font 0 font)) ; PointSize
		)
		(++ textWidth)
	)

	(method (setSize param1 param2 &tmp temp0 temp1)
		(self getSize: (if argc param1 else width))
		(cond
			((== textRight -1)
				(if (== textLeft -1)
					(PrintDebug {Must set at least one of text left/right.\n})
					(SetDebug self)
				)
				(= textRight (+ textLeft textWidth -1))
			)
			((== textLeft -1)
				(= textLeft (- textRight (- textWidth 1)))
			)
		)
		(= temp0
			(if (> argc 1)
				(>> (- param2 textHeight) $0001)
			else
				0
			)
		)
		(cond
			((== textBottom -1)
				(if (== textTop -1)
					(PrintDebug {Must set at least one of text top/bottom\n})
					(SetDebug self)
				)
				(+= textTop temp0)
				(= textBottom (+ textTop textHeight -1))
			)
			((== textTop -1)
				(-= textBottom temp0)
				(= textTop (- textBottom (- textHeight 1)))
			)
			(else
				(if temp0
					(PrintDebug {Height ignored if both top/bottom are set\n})
					(SetDebug self)
				)
				(= temp1
					(&
						(= temp0 (- (+ 1 (- textBottom textTop)) textHeight))
						$0001
					)
				)
				(>>= temp0 $0001)
				(+= textTop temp0)
				(-= textBottom (+ temp0 temp1))
			)
		)
	)
)

(class TextView of View
	(properties
		text 0
		borderColor 0
		textLeft 0
		textTop 0
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
		(super dispose: &rest)
	)

	(method (setText param1)
		(if (not (OneOf argc 1 5))
			(PrintDebug {Bad argc(%d) for TextView} argc)
			(SetDebug self)
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

	(method (setSize &tmp temp0 temp1)
		(text textLeft: textLeft textTop: textTop setSize:)
		(if (== view -1)
			(if (== celWidth -1)
				(= celWidth (+ (text textWidth:) (<< textLeft $0001)))
			)
			(if (== celHeight -1)
				(= celHeight (+ (text textHeight:) (<< textTop $0001)))
			)
		else
			(= celWidth (CelWide view loop cel))
			(= celHeight (CelHigh view loop cel))
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
			(SetDebug self)
		)
		(= left x)
		(= top y)
		(= right (+ x celWidth -1))
		(= bottom (+ y celHeight -1))
	)

	(method (draw)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap
			(if (== view -1)
				(Bitmap 0 celWidth celHeight (text skip:) borderColor) ; Create
			else
				(Bitmap 9 view loop cel) ; CreateWithCel
			)
		)
		(text draw: bitmap)
	)
)

(class QuickPrint of Plane
	(properties)

	(method (new param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (Clone self))
		(= temp1 (param1 celWidth:))
		(= temp2 (param1 celHeight:))
		(= temp4 (+ (= temp3 (>> (- gScreenWidth temp1) $0001)) temp1 -1))
		(= temp6 (+ (= temp5 (>> (- gScreenHeight temp2) $0001)) temp2 -1))
		(temp0 priority: (+ 1 (GetHighPlanePri)) init: temp3 temp5 temp4 temp6)
		(param1 init: temp0)
		((gUser hogs:) push: temp0 1)
		(return temp0)
	)

	(method (handleEvent event)
		(if (& (event type:) $000a) ; evKEYUP | evMOUSERELEASE
			((gUser hogs:) pop:)
			(event claimed: 1)
			(self dispose:)
		)
		(return 0)
	)
)

