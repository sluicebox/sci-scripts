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
		oTextWindowThingy 0
		oTextSaver 0
		displayWidth 0
		whoWidth 0
		mode 0
		fore 1
		back 0
		skip 0
		font 0
		border 0
		speakerView 0
		speakerLoop 0
		speakerCel 0
		nSelectMethod 0
		x 0
		y 0
		oText 0
		oWho 0
		oSpeaker 0
		nHeight 0
	)

	(method (init myCast &tmp strText nTalker strWho)
		(= oText (TextButton new:))
		(= oSpeaker (PushButton new:))
		(= oWho (TextButton new:))
		(= strText (Str new: 1000))
		(= nTalker (oTextWindowThingy getMessage: oTextSaver strText))
		(= strWho (Str with: (TalkerName nTalker)))
		(oWho
			y: -500
			priority: 10
			fixPriority: 1
			text: strWho
			fore: fore
			back: back
			skip: skip
			font: font
			border: border
			maxWidth: whoWidth
			oSelectNotify: oTextWindowThingy
			nSelectMethod: nSelectMethod
			nSelectValue: oTextSaver
			init: myCast
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
			init: myCast
		)
		(oText
			y: -500
			priority: 10
			fixPriority: 1
			text: strText
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
			init: myCast
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

	(method (posn nx ny &tmp nextX centY)
		(+= nx 5)
		(+= ny 5)
		(= nextX nx)
		(oSpeaker posn: nextX ny)
		(= centY
			(/
				(-
					(CelHigh (oSpeaker view:) (oSpeaker loop:) (oSpeaker cel:))
					(oWho nHeight:)
				)
				2
			)
		)
		(+=
			nextX
			(+ 1 (CelWide (oSpeaker view:) (oSpeaker loop:) (oSpeaker cel:)))
		)
		(oWho posn: nextX (+ centY ny))
		(+= nextX (+ 1 whoWidth))
		(oText posn: nextX ny)
		(= x nx)
		(= y ny)
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
		aMod 0
		aNoun 0
		aVerb 0
		aCase 0
		aSeq 0
		nHeight 0
		x 0
		y 0
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
		fore 0
		skip 0
		dimmed 0
		font 0
		mode 0
		border 2
		nMaxMessages 20
		oMessageList 0
		nTextWidth 0
	)

	(method (init &tmp sbWidth)
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

	(method (updateScrollbar &tmp i totHeight inc page)
		(= totHeight 0)
		(for ((= i 0)) (< i (oMessageList size:)) ((++ i))
			(+= totHeight ((oMessageList at: i) nHeight:))
		)
		(-= totHeight (- bottom top))
		(= totHeight (Max 1 totHeight))
		(= inc (Max 1 (/ totHeight 20)))
		(= page (* 3 inc))
		(textScrollBar setMinMax: 0 totHeight setIncrement: inc page)
	)

	(method (show)
		(self setPri: 450)
		(oMessageList eachElementDo: #show)
	)

	(method (hide)
		(self setPri: -1)
		(oMessageList eachElementDo: #hide)
	)

	(method (sayMessage oMessage &tmp str)
		(gGame handsOff:)
		(if oMessage
			(gMessager
				sayNoSave:
					(oMessage aNoun:)
					(oMessage aVerb:)
					(oMessage aCase:)
					(oMessage aSeq:)
					(ScriptID 64020 0) ; oHandsOnWhenCued
					(oMessage aMod:)
			)
		)
	)

	(method (getMessage oMessage oStr &tmp nTalker)
		(if oMessage
			(= nTalker
				(Message
					msgGET
					(oMessage aMod:)
					(oMessage aNoun:)
					(oMessage aVerb:)
					(oMessage aCase:)
					(oMessage aSeq:)
					(oStr data:)
				)
			)
		else
			(= nTalker -1)
			(oStr with: {The unknown message})
		)
		(return nTalker)
	)

	(method (createDisplay oMessage &tmp oMessageDisplay)
		((= oMessageDisplay (TextDisplayClass new:))
			oTextWindowThingy: self
			oTextSaver: oMessage
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
			nSelectMethod: 1197
			init: self
		)
		(oMessage nHeight: (oMessageDisplay nHeight:))
		(oMessage oTextDisplay: oMessageDisplay)
	)

	(method (rememberMessage modi noun verb case seq &tmp oMessage yLoc)
		(if (>= (oMessageList size:) nMaxMessages)
			(= oMessage (oMessageList at: 0))
			(oMessageList delete: oMessage)
			(oMessage dispose:)
		)
		(= oMessage (TextSaverClass new:))
		(oMessage
			aMod: modi
			aNoun: noun
			aVerb: verb
			aCase: case
			aSeq: seq
			init:
		)
		(oMessageList addToEnd: oMessage)
		(self createDisplay: oMessage)
		(if (== priority -1)
			(oMessage hide:)
		)
		(self updateScrollbar:)
		(= yLoc (textScrollBar maxPosn:))
		(textScrollBar setPos: yLoc)
		(= yLoc (- 0 yLoc))
		(self posnList: yLoc)
	)

	(method (posnList curY &tmp curNode curSaver nPlaneHeight)
		(= nPlaneHeight (- bottom top))
		(for
			((= curNode (oMessageList first:)))
			curNode
			((= curNode (oMessageList next: curNode)))
			
			(= curSaver (KList 8 curNode)) ; NodeValue
			(if (or (< (+ curY (curSaver nHeight:)) 0) (> curY nPlaneHeight))
				(if (curSaver oTextDisplay:)
					((curSaver oTextDisplay:) dispose:)
					(curSaver oTextDisplay: 0)
				)
			else
				(if (not (curSaver oTextDisplay:))
					(self createDisplay: curSaver (oMessageList indexOf: curSaver))
				)
				((curSaver oTextDisplay:) posn: 0 curY)
			)
			(+= curY (curSaver nHeight:))
		)
	)

	(method (scrolled)
		(self posnList: (- 0 (textScrollBar getPos:)))
	)
)

(instance textScrollBar of ScrollBar
	(properties
		priority 16
		fixPriority 1
		view 60004
		loop 11
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

