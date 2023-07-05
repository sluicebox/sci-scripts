;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64004)
(include sci.sh)
(use Main)
(use ScrollBar)
(use oMessager)
(use PushButton)
(use Plane)
(use Str)
(use System)

(public
	oTextWindow 0
)

(class TextDisplayClass of Obj
	(properties
		back 0
		x 0
		y 0
		font 0
		fore 1
		mode 0
		skip 0
		nHeight 0
		nSelectMethod 0
		border 0
		oText 0
		oTextWindowThingy 0
		oTextSaver 0
		displayWidth 0
		whoWidth 0
		speakerView 0
		speakerLoop 0
		speakerCel 0
		oWho 0
		oSpeaker 0
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(= oText (TextButton new:))
		(= oSpeaker (PushButton new:))
		(= oWho (TextButton new:))
		(= temp0 (Str new: 1000))
		(= temp1 (oTextWindowThingy getMessage: oTextSaver temp0))
		(= temp2 (Str with: (TalkerName temp1)))
		(oWho
			y: -500
			priority: 10
			fixPriority: 1
			text: temp2
			fore: fore
			back: back
			skip: skip
			font: font
			border: border
			maxWidth: whoWidth
			oSelectNotify: oTextWindowThingy
			nSelectMethod: nSelectMethod
			nSelectValue: oTextSaver
			init: param1
		)
		(oSpeaker
			y: -500
			priority: 10
			fixPriority: 1
			view: speakerView
			loop: speakerLoop
			cel: speakerCel
			oSelectNotify: oTextWindowThingy
			nSelectMethod: nSelectMethod
			nSelectValue: oTextSaver
			init: param1
		)
		(oText
			y: -500
			priority: 10
			fixPriority: 1
			text: temp0
			mode: mode
			fore: fore
			back: back
			skip: skip
			font: font
			border: border
			maxWidth: (- displayWidth (+ whoWidth border 25))
			oSelectNotify: oTextWindowThingy
			nSelectMethod: nSelectMethod
			nSelectValue: oTextSaver
			init: param1
		)
		(= nHeight
			(Max
				(+
					(oWho nHeight:)
					(CelHigh (oSpeaker view:) (oSpeaker loop:) (oSpeaker cel:))
				)
				(oText nHeight:)
			)
		)
		(super init:)
		(self posn: x y)
	)

	(method (dispose)
		(oText dispose:)
		(oWho dispose:)
		(oSpeaker dispose:)
		(super dispose: &rest)
	)

	(method (posn param1 param2 &tmp temp0 temp1)
		(+= param1 5)
		(+= param2 5)
		(= temp0 param1)
		(oSpeaker posn: temp0 param2)
		(= temp1
			(/
				(-
					(CelHigh (oSpeaker view:) (oSpeaker loop:) (oSpeaker cel:))
					(oWho nHeight:)
				)
				2
			)
		)
		(+=
			temp0
			(+ 1 (CelWide (oSpeaker view:) (oSpeaker loop:) (oSpeaker cel:)))
		)
		(oWho posn: temp0 (+ temp1 param2))
		(+= temp0 (+ 1 whoWidth))
		(oText posn: temp0 param2)
		(= x param1)
		(= y param2)
	)

	(method (show)
		(oText show:)
		(oSpeaker show:)
		(oWho show:)
	)

	(method (hide)
		(oText hide:)
		(oSpeaker hide:)
		(oWho hide:)
	)
)

(class TextSaverClass of Obj
	(properties
		x 0
		y 0
		nHeight 0
		aMod 0
		aNoun 0
		aVerb 0
		aCase 0
		aSeq 0
		oTextDisplay 0
	)

	(method (dispose)
		(if oTextDisplay
			(oTextDisplay dispose:)
		)
		(= oTextDisplay 0)
		(super dispose: &rest)
	)

	(method (show)
		(if oTextDisplay
			(oTextDisplay show:)
		)
	)

	(method (hide)
		(if oTextDisplay
			(oTextDisplay hide:)
		)
	)
)

(class TextWindowClass of Plane
	(properties
		font 0
		fore 0
		mode 0
		skip 0
		dimmed 0
		border 2
		nMaxMessages 20
		oMessageList 0
		nTextWidth 0
	)

	(method (init &tmp temp0)
		(super init: left top right bottom)
		(self setPri: -1)
		(textScrollBar
			object: self
			selector: #scrolled
			minPosn: 0
			maxPosn: 1
			init: self
		)
		(= nTextWidth (- (+ 1 (- right left)) (textScrollBar width:)))
		(textScrollBar posn: nTextWidth 0)
		(= oMessageList (List new:))
	)

	(method (dispose)
		(oMessageList dispose: &rest)
		(super dispose: &rest)
	)

	(method (updateScrollbar &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (oMessageList size:)) ((++ temp0))
			(+= temp1 ((oMessageList at: temp0) nHeight:))
		)
		(-= temp1 (- bottom top))
		(= temp1 (Max 1 temp1))
		(= temp2 (Max 1 (/ temp1 20)))
		(= temp3 (* 3 temp2))
		(textScrollBar setMinMax: 0 temp1 setIncrement: temp2 temp3)
	)

	(method (show)
		(self setPri: 450)
		(oMessageList eachElementDo: #show)
	)

	(method (hide)
		(self setPri: -1)
		(oMessageList eachElementDo: #hide)
	)

	(method (sayMessage param1 &tmp temp0)
		(gGame handsOff:)
		(if param1
			(gMessager
				sayNoSave:
					(param1 aNoun:)
					(param1 aVerb:)
					(param1 aCase:)
					(param1 aSeq:)
					(ScriptID 64039 0) ; oHandsOnWhenCued
					(param1 aMod:)
			)
		)
	)

	(method (getMessage param1 param2 &tmp temp0)
		(if param1
			(= temp0
				(Message
					msgGET
					(param1 aMod:)
					(param1 aNoun:)
					(param1 aVerb:)
					(param1 aCase:)
					(param1 aSeq:)
					(param2 data:)
				)
			)
		else
			(= temp0 -1)
			(param2 with: {The unknown message})
		)
		(return temp0)
	)

	(method (createDisplay param1 &tmp temp0)
		((= temp0 (TextDisplayClass new:))
			oTextWindowThingy: self
			oTextSaver: param1
			displayWidth: nTextWidth
			whoWidth: 75
			mode: mode
			fore: fore
			back: back
			skip: skip
			font: font
			border: border
			speakerView: 60004
			speakerLoop: 21
			nSelectMethod: 1256
			init: self
		)
		(param1 nHeight: (temp0 nHeight:))
		(param1 oTextDisplay: temp0)
	)

	(method (rememberMessage param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (>= (oMessageList size:) nMaxMessages)
			(= temp0 (oMessageList at: 0))
			(oMessageList delete: temp0)
			(temp0 dispose:)
		)
		(= temp0 (TextSaverClass new:))
		(temp0
			aMod: param1
			aNoun: param2
			aVerb: param3
			aCase: param4
			aSeq: param5
			init:
		)
		(oMessageList addToEnd: temp0)
		(self createDisplay: temp0)
		(if (== priority -1)
			(temp0 hide:)
		)
		(self updateScrollbar:)
		(= temp1 (textScrollBar maxPosn:))
		(textScrollBar setPos: temp1)
		(= temp1 (- 0 temp1))
		(self posnList: temp1)
	)

	(method (posnList param1 &tmp temp0 temp1 temp2)
		(= temp2 (- bottom top))
		(for
			((= temp0 (oMessageList first:)))
			temp0
			((= temp0 (oMessageList next: temp0)))
			
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (or (< (+ param1 (temp1 nHeight:)) 0) (> param1 temp2))
				(if (temp1 oTextDisplay:)
					((temp1 oTextDisplay:) dispose:)
					(temp1 oTextDisplay: 0)
				)
			else
				(if (not (temp1 oTextDisplay:))
					(self createDisplay: temp1 (oMessageList indexOf: temp1))
				)
				((temp1 oTextDisplay:) posn: 0 param1)
			)
			(+= param1 (temp1 nHeight:))
		)
	)

	(method (scrolled)
		(self posnList: (- 0 (textScrollBar getPos:)))
	)
)

(instance textScrollBar of ScrollBar
	(properties
		priority 16
		loop 11
		view 60004
		fixPriority 1
		vThumbView 60004
		lThumbLoop 14
		vDownArrowView 60004
		lDownArrowLoop 13
		vUpArrowView 60004
		lUpArrowLoop 12
	)
)

(instance oTextWindow of TextWindowClass
	(properties)
)

