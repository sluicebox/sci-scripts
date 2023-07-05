;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use IconBar)
(use Polygon)
(use Cursor)
(use Tutorial)
(use Actor)
(use System)

(public
	SQ6Controls 0
)

(local
	local0
)

(class sqControlIcon of IconI
	(properties
		theObj 0
	)

	(method (highlight param1)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= cel (* 1 (if argc param1)))
		(UpdateScreenItem self)
	)

	(method (doit)
		(if theObj
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)

(class SlideBar of sqControlIcon
	(properties
		signal 128
		maxValue 99
		minValue 0
		minX 0
		maxX 0
		inc 0
		value 0
		realValue 0
		position 0
		barObj 0
		oppose 0
		indicator1 0
		indicator2 0
		minusButton 0
		plusButton 0
	)

	(method (init)
		(= inc (/ 990 inc))
		(super init: &rest)
		((= indicator1 (View new:))
			view: 950
			loop: 11
			init: local0
			posn: 140 y
			setCel: (/ value 10)
		)
		((= indicator2 (View new:))
			view: 950
			loop: 11
			init: local0
			posn: 148 y
			setCel: (mod value 10)
		)
		((= minusButton (buttonIcon new:))
			mainView: 950
			mainLoop: 9
			mainCel: 0
			theObj: self
			selector: #retreat
			posn: x y
			noun: noun
			helpVerb: helpVerb
			signal: 3
		)
		((= plusButton (buttonIcon new:))
			mainView: 950
			mainLoop: 10
			mainCel: 0
			theObj: self
			selector: #advance
			posn: (+ x 68) y
			noun: noun
			helpVerb: helpVerb
			signal: 3
		)
		(SQ6Controls add: minusButton plusButton)
	)

	(method (show)
		(|= signal $0020)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (not position)
			(self valueToPosn: value)
		)
		(self refresh:)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if (& signal $0004)
			(return 0)
		)
		(if (and argc param1)
			(= temp1 500)
			(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
				(temp0 localize: (SQ6Controls plane:))
				(if (!= (= temp2 (temp0 x:)) temp1)
					(if (< temp2 minX)
						(= temp2 minX)
					)
					(if (> temp2 maxX)
						(= temp2 maxX)
					)
					(= value (self posnToValue: temp2))
					(self valueToPosn: value)
					(self doit:)
					(self refresh:)
					(FrameOut)
				)
				(= temp1 temp2)
				(temp0 dispose:)
			)
			(self refresh:)
			(FrameOut)
			(temp0 dispose:)
		else
			(return 1)
		)
	)

	(method (mask))

	(method (highlight))

	(method (valueToPosn param1)
		(cond
			((>= param1 maxValue)
				(= position maxX)
			)
			((<= param1 minValue)
				(= position minX)
			)
			(else
				(= position
					(+ minX (/ (* (/ (* (- maxX minX) 10) 99) param1) 10))
				)
			)
		)
	)

	(method (posnToValue param1 &tmp temp0)
		(cond
			((<= param1 minX)
				(= temp0 minValue)
			)
			((>= param1 maxX)
				(= temp0 maxValue)
			)
			(else
				(= temp0 (/ (* (- param1 minX) 99) 53))
			)
		)
		(return temp0)
	)

	(method (refresh)
		(UpdateScreenItem barObj)
		(indicator1 setCel: (/ value 10))
		(indicator2 setCel: (mod value 10))
		(barObj x: position)
		(UpdateScreenItem barObj)
		(UpdateScreenItem indicator1)
		(UpdateScreenItem indicator2)
		(self doit:)
	)

	(method (advance)
		(if (< value maxValue)
			(+= value 1)
			(if (> value maxValue)
				(= value maxValue)
			)
			(self valueToPosn: value)
			(self refresh:)
		)
	)

	(method (retreat)
		(if (> value minValue)
			(-= value 1)
			(if (< value minValue)
				(= value minValue)
			)
			(self valueToPosn: value)
			(self refresh:)
		)
	)
)

(instance controlWind of Plane
	(properties)
)

(class SQ6Controls of IconBar
	(properties)

	(method (init)
		(= gGameControls self)
		((= local0 (Cast new:)) add:)
		((= plane controlWind)
			picture: -3
			priority: (+ (GetHighPlanePri) 1)
			init: 0 0 0 0
			addCast: local0
		)
		(controlWind setBitmap: 950 13 0 0)
		(self
			add:
				(iconSave theObj: gGame selector: #save yourself:)
				(iconLoad theObj: gGame selector: #restore yourself:)
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
				(iconSpeech theObj: iconSpeech selector: #doit yourself:)
				(iconText theObj: iconText selector: #doit yourself:)
				(iconScroll theObj: iconScroll selector: #doit yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				iconPlay
				detailBar
				speedBar
				soundBar
				musicBar
				textBar
			curIcon: iconLoad
			helpIconItem: iconHelp
			state: 2048
		)
		(super init:)
		(plane
			setRect:
				(plane left:)
				(plane top:)
				(+ (plane right:) 24)
				(+ (plane bottom:) 5)
		)
		(plane posn: -1 11)
		(UpdatePlane plane)
		(testBar init: local0)
		(testBar1 init: local0)
		(testBar2 init: local0)
		(testBar3 init: local0)
		(testBar4 init: local0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			(
				(and
					(not temp1)
					(& state $0400)
					(self shouldOpen: event)
					(not (= temp0 0))
				)
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(self doit:)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(self getCursor:)
					else
						gWaitCursor
					)
				)
				(gGame setCursor: temp3 1)
				(self hide:)
			)
			((& temp1 evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon: show: highlight: curIcon hide:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon: show: highlight: curIcon hide:)
						)
						(event claimed: 1)
					)
					(curIcon
						(event
							type: (curIcon type:)
							message:
								(if (== curIcon useIconItem)
									(curInvIcon message:)
								else
									(curIcon message:)
								)
						)
					)
				)
			)
		)
	)

	(method (showSelf)
		(= curIcon iconPlay)
		(self show: doit: hide:)
	)

	(method (show &tmp [temp0 3] temp3 temp4 temp5 temp6)
		(|= state $0020)
		(gGame setCursor: gNormalCursor 1)
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (KList 3 elements))) temp5 ((= temp5 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp5)) ; NextNode
			(= temp6 (KList 8 temp5)) ; NodeValue
			(if (<= (temp6 nsRight:) 0)
				(temp6 show: temp3 temp4)
				(= temp3 (temp6 nsRight:))
			else
				(temp6 show:)
			)
		)
		(self highlight: curIcon)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if (gNarrator initialized:)
				(gNarrator doit:)
				(gNarrator handleEvent: temp0)
			else
				(if (and (= temp4 (gGame script:)) (temp4 isKindOf: Tutorial))
					(temp4 doit:)
				)
				(if (== temp1 32)
					(= temp1 4)
					(= temp2 (if (& temp3 $0003) 27 else 13))
					(= temp3 0)
					(temp0 type: temp1 message: temp2 modifiers: 0)
				)
				(temp0 localize: plane)
				(if
					(and
						(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
						helpIconItem
						(& (helpIconItem signal:) $0010)
					)
					(temp0 type: 24576 message: (helpIconItem message:))
				)
				(MapKeyToDir temp0)
				(breakif (self dispatchEvent: temp0))
			)
		)
	)
)

(instance buttonIcon of sqControlIcon
	(properties)

	(method (select &tmp temp0 temp1 temp2)
		(= temp2 15)
		(= scratch gGameTime)
		(= temp1 1)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize: plane)
			(if (self onMe: temp0)
				(if temp1
					(Eval theObj selector)
					(FrameOut)
				)
				(if (< (Abs (- gGameTime scratch)) temp2)
					(= temp1 0)
				else
					(= temp1 1)
					(= scratch gGameTime)
					(= temp2 1)
				)
			)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(temp0 dispose:)
	)

	(method (doit &tmp temp0)
		(Eval theObj #doit)
	)
)

(instance iconSave of sqControlIcon
	(properties
		noun 4
		x 8
		y 6
		signal 451
		message 0
		mainView 950
		helpVerb 17
	)
)

(instance iconLoad of sqControlIcon
	(properties
		noun 5
		x 8
		y 17
		signal 451
		message 0
		mainView 950
		mainLoop 1
		helpVerb 17
	)
)

(instance iconAbout of sqControlIcon
	(properties
		noun 6
		x 8
		y 31
		signal 449
		message 0
		mainView 950
		mainLoop 2
		helpVerb 17
	)
)

(instance iconHelp of sqControlIcon
	(properties
		noun 7
		x 8
		y 42
		signal 387
		message 17
		mainView 950
		mainLoop 3
		helpVerb 17
	)

	(method (init)
		(= cursorView cHelpControl)
		(super init: &rest)
	)
)

(instance iconSpeech of sqControlIcon
	(properties
		noun 8
		x 8
		y 55
		signal 387
		message 0
		mainView 950
		mainLoop 4
		helpVerb 17
	)

	(method (init)
		(if (& gMsgType $0002)
			(= mainCel 2)
		)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(if (& gMsgType $0002)
				(&= gMsgType $fffd)
				(= mainCel 0)
				(= cel 1)
				(if (not (& gMsgType $0001))
					(= gMsgType 1)
					(iconText mainCel: 2 cel: 2)
					(UpdateScreenItem iconText)
				)
			else
				(|= gMsgType $0002)
				(= mainCel 2)
				(= cel 3)
			)
			(UpdateScreenItem self)
		)
	)

	(method (highlight param1)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(cond
			((and (& gMsgType $0002) argc param1)
				(= cel 3)
			)
			((& gMsgType $0002)
				(= cel 2)
			)
			((and argc param1)
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
		(UpdateScreenItem self)
	)
)

(instance iconText of sqControlIcon
	(properties
		noun 9
		x 8
		y 66
		signal 387
		mainView 950
		mainLoop 5
		helpVerb 17
	)

	(method (init)
		(if (& gMsgType $0001)
			(= mainCel 2)
		)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(if (& gMsgType $0001)
				(&= gMsgType $fffe)
				(= mainCel 0)
				(= cel 1)
				(if (not (& gMsgType $0002))
					(= gMsgType 2)
					(iconSpeech mainCel: 2 cel: 2)
					(UpdateScreenItem iconSpeech)
				)
			else
				(|= gMsgType $0001)
				(= mainCel 2)
				(= cel 3)
			)
			(UpdateScreenItem self)
		)
	)

	(method (highlight param1)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(cond
			((and (& gMsgType $0001) argc param1)
				(= cel 3)
			)
			((& gMsgType $0001)
				(= cel 2)
			)
			((and argc param1)
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
		(UpdateScreenItem self)
	)
)

(instance iconScroll of sqControlIcon
	(properties
		noun 10
		x 8
		y 77
		signal 387
		message 0
		mainView 950
		mainLoop 6
		helpVerb 17
	)

	(method (show)
		(if (IsFlag 202)
			(= mainCel 2)
		)
		(super show: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(if (IsFlag 202)
				(ClearFlag 202)
				(= mainCel 0)
				(= cel 1)
			else
				(SetFlag 202)
				(= mainCel 2)
				(= cel 3)
			)
			(UpdateScreenItem self)
		)
	)

	(method (highlight param1)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(cond
			((and (IsFlag 202) argc param1)
				(= cel 3)
			)
			((IsFlag 202)
				(= cel 2)
			)
			((and argc param1)
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
		(UpdateScreenItem self)
	)
)

(instance iconQuit of sqControlIcon
	(properties
		noun 11
		x 8
		y 91
		signal 451
		message 0
		mainView 950
		mainLoop 7
		helpVerb 17
	)

	(method (select &tmp temp0)
		(switch
			(Print
				y: 50
				addBitmap: 975 0 0
				addButtonBM: 975 1 0 1 { } 11 23
				addButtonBM: 975 2 0 0 { } 79 23
				init:
			)
			(1
				(= gQuit 1)
			)
		)
	)
)

(instance iconPlay of sqControlIcon
	(properties
		noun 12
		x 8
		y 102
		signal 451
		message 0
		mainView 950
		mainLoop 8
		helpVerb 17
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance speedBar of SlideBar
	(properties
		noun 13
		x 57
		y 14
		mainView 950
		mainLoop 14
		helpVerb 17
		minX 68
		maxX 121
		inc 11
		value 6
	)

	(method (init)
		(= scratch -10)
		(= barObj testBar)
		(super init: &rest)
		(= value (- maxValue (/ (* inc global158) 10)))
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 15 124 15 124 22 68 22
					yourself:
				)
		)
	)

	(method (show)
		(if (!= scratch global158)
			(= value (- maxValue (/ (* inc global158) 10)))
			(if (== global158 11)
				(= value 0)
			)
		)
		(self valueToPosn: value)
		(self refresh:)
	)

	(method (doit)
		(if (== (= global158 (/ (* (- maxValue value) 10) inc)) 11)
			(= value 0)
		)
		(= scratch global158)
		(if (!= (gEgo view:) 578)
			(gEgo setSpeed: global158)
		)
	)
)

(instance musicBar of SlideBar
	(properties
		noun 16
		x 57
		y 79
		mainView 950
		mainLoop 14
		mainCel 1
		helpVerb 17
		minX 68
		maxX 121
		inc 2
	)

	(method (init)
		(= barObj testBar1)
		(= value (/ (* maxValue (DoSound sndMASTER_VOLUME)) 127))
		(= scratch value)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 80 124 80 124 87 68 87
					yourself:
				)
		)
	)

	(method (show)
		(= value (/ (* maxValue (DoSound sndMASTER_VOLUME)) 127))
		(= scratch value)
		(self valueToPosn: scratch)
		(self refresh:)
	)

	(method (doit &tmp [temp0 2])
		(if (!= value scratch)
			(DoSound sndMASTER_VOLUME (/ (* value 127) maxValue))
			(= scratch value)
		)
	)
)

(instance soundBar of SlideBar
	(properties
		noun 15
		x 57
		y 58
		mainView 950
		mainLoop 14
		helpVerb 17
		minX 68
		maxX 121
		inc 2
	)

	(method (init)
		(= barObj testBar2)
		(= value (/ (* maxValue (DoAudio audVOLUME)) 127))
		(= scratch value)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 59 124 59 124 66 68 66
					yourself:
				)
		)
	)

	(method (show)
		(= value (/ (* maxValue (DoAudio audVOLUME)) 127))
		(= scratch value)
		(self valueToPosn: scratch)
		(self refresh:)
	)

	(method (doit &tmp [temp0 2])
		(if (!= value scratch)
			(DoAudio audVOLUME (/ (* value 127) maxValue))
			(= scratch value)
		)
	)
)

(instance textBar of SlideBar
	(properties
		noun 17
		x 57
		y 101
		mainView 950
		mainLoop 14
		mainCel 1
		helpVerb 17
		minX 68
		maxX 121
		inc 8
		oppose 1
	)

	(method (init)
		(= barObj testBar3)
		(= value (- maxValue (* inc gTextSpeed)))
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 102 124 102 124 109 68 109
					yourself:
				)
		)
	)

	(method (show)
		(self valueToPosn: value)
		(self refresh:)
	)

	(method (doit &tmp [temp0 2])
		(= gTextSpeed (/ (* (- maxValue value) 10) inc))
	)
)

(instance detailBar of SlideBar
	(properties
		noun 14
		x 57
		y 36
		mainView 950
		mainLoop 14
		helpVerb 17
		minX 68
		maxX 121
		inc 3
	)

	(method (init)
		(= barObj testBar4)
		(super init: &rest)
		(= inc 330)
		(= value (* (gGame detailLevel:) 33))
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 37 124 37 124 44 68 44
					yourself:
				)
		)
	)

	(method (show)
		(= value (* (gGame detailLevel:) 33))
		(self valueToPosn: value)
		(self refresh:)
		(super show:)
	)

	(method (doit)
		(gGame detailLevel: (/ (* value 10) inc))
	)
)

(instance testBar of View
	(properties
		x 68
		y 15
		view 950
		loop 12
	)
)

(instance testBar1 of View
	(properties
		x 68
		y 81
		view 950
		loop 12
		cel 1
	)
)

(instance testBar2 of View
	(properties
		x 68
		y 59
		view 950
		loop 12
	)
)

(instance testBar3 of View
	(properties
		x 68
		y 103
		view 950
		loop 12
		cel 1
	)
)

(instance testBar4 of View
	(properties
		x 68
		y 37
		view 950
		loop 12
	)
)

(instance backGround of View ; UNUSED
	(properties
		view 950
		loop 13
	)
)

(instance cHelpControl of Cursor
	(properties
		view 953
		loop 8
	)
)

(instance myP of Print ; UNUSED
	(properties)

	(method (init)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(dialog mouseHiliting: 1)
		(plane picture: -2)
		(super init: &rest)
	)
)

(instance theArrowCurs of Cursor ; UNUSED
	(properties
		view 999
	)
)

