;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64914)
(include sci.sh)
(use Main)
(use Str)
(use WriteFeature)
(use Button)

(class DEditStruct of Obj
	(properties
		plane 0
		client 0
		lastKey 0
		back 0
		x 0
		y 0
		bitmap 0
		text 0
		borderColor 0
		fore 255
		skip 0
		font 1
		mode 0
		width 0
		dimmed 0
		frameOut 1
		titleFore 0
		titleBack 0
		titleFont 0
		title 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= temp1
			(if argc
				(Str with: (KArray 9 param1)) ; ArrayGetData
			else
				(Str new:)
			)
		)
		(= temp0 (temp1 data:))
		(temp1 data: text dispose:)
		(= text temp0)
	)

	(method (dispose)
		(if text
			(KArray 4 text) ; ArrayFree
			(= text 0)
		)
		(if title
			(KArray 4 title) ; ArrayFree
			(= title 0)
		)
		(super dispose:)
	)

	(method (doit param1)
		(if argc
			(self init: param1)
		)
		(EditText self)
	)
)

(class DEdit of TextButton
	(properties
		width 36
	)

	(method (action)
		(self enable: 0)
		(self getInput:)
		(self enable: 1 hilite: 0)
	)

	(method (draw &tmp temp0)
		(= temp0 gDoMotionCue)
		(= gDoMotionCue back)
		(super draw: &rest)
		(text fore: gUseSortedFeatures back: back)
		(= gDoMotionCue temp0)
	)

	(method (getInput param1 &tmp temp0 temp1)
		(if argc
			(= temp1 param1)
		else
			(= temp1 (DEditStruct new:))
			(temp1
				x: x
				y: y
				font: (text font:)
				fore: (text fore:)
				back: (text skip:)
				skip: (text skip:)
				borderColor: (text skip:)
				width: width
				plane: plane
			)
		)
		(if (= temp0 (temp1 doit: (KArray 9 text))) ; ArrayGetData
			(self setText: (temp1 text:) setSize: draw:)
		)
		(if (not argc)
			(temp1 dispose:)
		)
		(return temp0)
	)

	(method (setText)
		(super setText: &rest)
		(text textRight: -1 textBottom: -1)
	)
)

