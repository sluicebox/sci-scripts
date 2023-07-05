;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use IconBar)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	controlPanel 0
)

(local
	local0
	local1
)

(class QGSlider of IconI
	(properties
		nsTop 33
		nsBottom 97
		view 933
		loop 10
		cel 2
		theObj 0
		cycler 0
		cycleSpeed 6
	)

	(method (init)
		(= x (- nsLeft 8))
		(= nsRight (+ nsLeft 23))
		(&= signal $fff7)
		(local0 add: self)
		(= plane controlPlane)
		(AddScreenItem self)
	)

	(method (setCycle param1)
		(if cycler
			(cycler dispose:)
		)
		(if param1
			(= cycler
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(cycler init: self &rest)
		else
			(= cycler 0)
		)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (select &tmp temp0)
		(while
			(not
				(OneOf
					((= temp0 ((gUser curEvent:) new:)) type:)
					2
					8
					64
				)
			)
			(temp0 localize: controlPlane)
			(cond
				((< (temp0 y:) nsTop)
					(= y nsTop)
				)
				((> (temp0 y:) 84)
					(= y 84)
				)
				(else
					(= y (temp0 y:))
				)
			)
			(UpdateScreenItem self)
			(self move:)
			(FrameOut)
		)
		(temp0 localize: controlPlane)
		(cond
			((< (temp0 y:) nsTop)
				(= y nsTop)
			)
			((> (temp0 y:) 84)
				(= y 84)
			)
			(else
				(= y (temp0 y:))
			)
		)
		(UpdateScreenItem self)
	)

	(method (show)
		(|= signal $0020)
		(UpdateScreenItem self)
	)

	(method (highlight))

	(method (move))

	(method (dispose)
		(if cycler
			(self setCycle: 0)
		)
	)
)

(class QGControlIcon of IconI
	(properties)

	(method (init)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(&= signal $fff7)
		(local0 add: self)
		(= plane controlPlane)
		(AddScreenItem self)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(return
			(if (and argc param1 (& signal $0001))
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: controlPlane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
				)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
				temp1
			else
				1
			)
		)
	)

	(method (show)
		(|= signal $0020)
		(UpdateScreenItem self)
	)

	(method (highlight param1)
		(= cel (if param1 2 else 0))
		(UpdateScreenItem self)
	)

	(method (dispose))
)

(instance controlPanel of IconBar
	(properties
		state 2048
	)

	(method (init)
		(= plane controlPlane)
		(plane
			bitmap: 0
			picture: -2
			priority: (+ (GetHighPlanePri) 1)
			init:
			setBitmap: 933 14 0
			addCast: (= local0 (Cast new:))
		)
		(self
			add:
				detailSlider
				volumeSlider
				speedSlider
				arcadeSlider
				iconSave
				iconRestore
				iconRestart
				iconQuit
				iconAbout
				iconHelp
				iconOk
				iconArcadeMode
				iconText
				iconAutoSave
				arcadeLight
				textLight
				autoSaveLight
				iconAudio
				audioLight
		)
		(if (or (not (User canInput:)) (not (User canInput:)))
			(= local1 1)
		else
			(= local1 0)
		)
		(self eachElementDo: #init self)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp2 (= temp3 0)))
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(temp0 localize: controlPlane)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(if (== (temp2 modNum:) -1)
									0
								else
									(temp2 modNum:)
								)
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
						(FrameOut)
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
					(FrameOut)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(gGlory setCursor: gNormalCursor 1)
		(if temp3
			(temp3 dispose:)
			(= temp3 0)
			(FrameOut)
		)
		(if (and helpIconItem (not (helpIconItem onMe: temp0)))
			(self dispatchEvent: temp0)
		)
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(gSounds pause:)
		(|= state $0020)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(self doit: hide:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3)
		(= temp1 (event claimed:))
		(= temp0 (self firstTrue: #onMe event))
		(self eachElementDo: #perform doCycleCode)
		(FrameOut)
		(if temp0
			(= temp2 (temp0 signal:))
			(= temp3 (== temp0 helpIconItem))
		)
		(switch (event type:)
			(evNULL
				(if temp0
					(if (!= temp0 highlightedIcon)
						(= oldMouseY 0)
						(self highlight: temp0)
					)
				else
					(self highlight: 0)
				)
			)
			(evMOUSEBUTTON
				(if (and temp0 (self select: temp0 1))
					(= temp1 (& temp2 $0040))
				)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_ESCAPE)
					(return 1)
				)
			)
		)
		(return temp1)
	)

	(method (select param1)
		(= curIcon param1)
		(super select: curIcon &rest)
	)

	(method (highlight param1 param2)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGlory
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (dispose)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(self eachElementDo: #dispose)
			(DisposeList elements)
		)
		(= size (= elements 0))
		(switch curIcon
			(iconAbout
				((ScriptID 19 0) doit:) ; aboutCode
			)
			(iconSave
				(gGlory panelObj: gGlory)
				(gGlory panelSelector: 86)
			)
			(iconRestore
				(gGlory panelObj: gGlory)
				(gGlory panelSelector: 87)
			)
			(iconRestart
				(gGlory panelObj: gGlory)
				(gGlory panelSelector: 111)
			)
			(iconQuit
				(gGlory panelObj: gGlory)
				(gGlory panelSelector: 110)
			)
		)
		(= highlightedIcon (= curIcon 0))
		(DisposeClone self)
	)
)

(instance controlPlane of Plane
	(properties)

	(method (init)
		(AddPlane self)
		(= casts (Set new:))
		(= inTop (= top (/ (- 200 (CelHigh 933 14 0)) 2)))
		(= inLeft (= left (/ (- 320 (CelWide 933 14 0)) 2)))
		(= inBottom
			(= bottom (+ (CelHigh 933 14 0) (/ (- 200 (CelHigh 933 14 0)) 2)))
		)
		(= inRight
			(= right (+ (CelWide 933 14 0) (/ (- 320 (CelWide 933 14 0)) 2)))
		)
	)
)

(instance detailSlider of QGSlider
	(properties
		noun 15
		modNum 25
		nsLeft 82
		helpVerb 9
	)

	(method (init)
		(= theObj gGlory)
		(= selector 340)
		(= y (- (+ nsTop (* (- 5 (Eval theObj selector)) 13)) 1))
		(super init: &rest)
	)

	(method (select)
		(super select:)
		(Eval theObj selector (+ (/ (+ (- 84 y) 1) 13) 1))
		(volumeSlider setCycle: (turnLeft new:))
		(speedSlider setCycle: (turnLeft new:))
		(arcadeSlider setCycle: (turnLeft new:))
	)
)

(instance volumeSlider of QGSlider
	(properties
		noun 24
		modNum 25
		nsLeft 118
		helpVerb 9
	)

	(method (init)
		(= theObj gGlory)
		(= selector 535)
		(= y (- 84 (/ (* (gGlory masterVolume:) 34) 10)))
		(super init: &rest)
	)

	(method (select)
		(super select:)
		(gGlory masterVolume: (/ (* (- 84 y) 10) 34))
		(detailSlider setCycle: (turnRight new:))
		(speedSlider setCycle: (turnLeft new:))
		(arcadeSlider setCycle: (turnLeft new:))
	)

	(method (move)
		(gGlory masterVolume: (/ (* (- 84 y) 10) 34))
	)
)

(instance speedSlider of QGSlider
	(properties
		noun 23
		modNum 25
		nsLeft 154
		helpVerb 9
	)

	(method (init)
		(= theObj gEgo)
		(= selector 358)
		(= y (+ nsTop (/ (* (Eval theObj selector) 34) 10)))
		(if local1
			(= loop 11)
		)
		(super init: &rest)
	)

	(method (onMe)
		(if local1
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (select)
		(super select:)
		(Eval theObj selector (/ (* (- y nsTop) 10) 34))
		(detailSlider setCycle: (turnRight new:))
		(volumeSlider setCycle: (turnRight new:))
		(arcadeSlider setCycle: (turnLeft new:))
	)
)

(instance arcadeSlider of QGSlider
	(properties
		noun 26
		modNum 25
		nsLeft 189
		helpVerb 9
	)

	(method (init)
		(= y (+ nsTop (* (- 3 global439) 25)))
		(super init: &rest)
	)

	(method (select)
		(super select:)
		(= global439 (+ (/ (- 84 y) 25) 1))
		(detailSlider setCycle: (turnRight new:))
		(volumeSlider setCycle: (turnRight new:))
		(speedSlider setCycle: (turnRight new:))
	)
)

(instance iconSave of QGControlIcon
	(properties
		noun 22
		modNum 25
		nsLeft 8
		nsTop 11
		x 8
		y 11
		view 933
		loop 2
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconRestore of QGControlIcon
	(properties
		noun 21
		modNum 25
		nsLeft 8
		nsTop 28
		x 8
		y 28
		view 933
		loop 3
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconRestart of QGControlIcon
	(properties
		noun 20
		modNum 25
		nsLeft 8
		nsTop 45
		x 8
		y 45
		view 933
		loop 4
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconQuit of QGControlIcon
	(properties
		noun 19
		modNum 25
		nsLeft 8
		nsTop 62
		x 8
		y 62
		view 933
		loop 5
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconAbout of QGControlIcon
	(properties
		noun 16
		modNum 25
		nsLeft 8
		nsTop 79
		x 8
		y 79
		view 933
		loop 6
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconHelp of QGControlIcon
	(properties
		noun 17
		modNum 25
		nsLeft 8
		nsTop 96
		x 8
		y 96
		view 933
		loop 7
		signal 387
		message 9
		cursorView 949
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(gGlory setCursor: (self getCursor:))
			(controlPanel noClickHelp:)
		)
		(return 0)
	)
)

(instance iconOk of QGControlIcon
	(properties
		noun 18
		modNum 25
		nsLeft 8
		nsTop 113
		x 8
		y 113
		view 933
		loop 8
		signal 451
		message 9
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(controlPanel state: (& (controlPanel state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconArcadeMode of QGControlIcon
	(properties
		noun 25
		modNum 25
		nsLeft 89
		nsTop 106
		x 89
		y 106
		view 933
		signal 387
		message 9
		helpVerb 9
	)

	(method (init)
		(if (IsFlag 374)
			(self loop: 1)
			(= noun 4)
		else
			(self loop: 0)
			(= noun 25)
		)
		(super init: &rest)
		(-= nsLeft 10)
	)

	(method (select)
		(if (super select: &rest)
			(if (IsFlag 374)
				(self loop: 0)
				(= noun 25)
				(ClearFlag 374)
			else
				(self loop: 1)
				(= noun 4)
				(SetFlag 374)
			)
			(UpdateScreenItem iconArcadeMode)
		)
		(return 0)
	)
)

(instance arcadeLight of View
	(properties
		nsLeft 81
		nsTop 109
		x 81
		y 109
		view 933
		loop 15
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose))
)

(instance iconText of QGControlIcon
	(properties
		noun 29
		modNum 25
		nsLeft 89
		nsTop 119
		x 89
		y 119
		view 939
		loop 1
		signal 387
		message 9
		helpVerb 9
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 10)
	)

	(method (select)
		(if (super select: &rest)
			(if (and (not (audioLight cel:)) (& gMsgType $0001))
				(^= gMsgType $0001)
				(textLight cel: 1)
			else
				(|= gMsgType $0001)
				(textLight cel: 0)
			)
		)
		(UpdateScreenItem textLight)
		(return 0)
	)
)

(instance textLight of View
	(properties
		nsLeft 81
		nsTop 121
		x 81
		y 121
		view 933
		loop 15
	)

	(method (init)
		(if (& gMsgType $0001)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose))
)

(instance iconAutoSave of QGControlIcon
	(properties
		noun 27
		modNum 25
		nsLeft 153
		nsTop 108
		x 153
		y 108
		view 933
		loop 9
		signal 387
		message 9
		helpVerb 9
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 10)
	)

	(method (select)
		(if (super select: &rest)
			(if (IsFlag 379)
				(ClearFlag 379)
				(autoSaveLight cel: 1)
			else
				(SetFlag 379)
				(autoSaveLight cel: 0)
			)
			(UpdateScreenItem autoSaveLight)
		)
		(return 0)
	)
)

(instance autoSaveLight of View
	(properties
		nsLeft 143
		nsTop 109
		x 143
		y 109
		view 933
		loop 15
	)

	(method (init)
		(if (IsFlag 379)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose))
)

(instance iconAudio of QGControlIcon
	(properties
		noun 28
		modNum 25
		nsLeft 153
		nsTop 117
		x 153
		y 117
		view 939
		signal 387
		message 9
		helpVerb 9
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 10)
	)

	(method (select)
		(if (super select: &rest)
			(if (and (not (textLight cel:)) (IsFlag 400))
				(ClearFlag 400)
				(^= gMsgType $0002)
				(audioLight cel: 1)
			else
				(SetFlag 400)
				(|= gMsgType $0002)
				(audioLight cel: 0)
			)
			(UpdateScreenItem audioLight)
		)
		(return 0)
	)
)

(instance audioLight of View
	(properties
		nsLeft 143
		nsTop 121
		x 143
		y 121
		view 933
		loop 15
	)

	(method (init)
		(if (IsFlag 400)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose))
)

(instance doCycleCode of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: QGSlider) (param1 cycler:))
			((param1 cycler:) doit:)
			(UpdateScreenItem param1)
		)
	)
)

(instance turnRight of CT
	(properties)

	(method (init param1)
		(super init: param1 0 -1)
	)

	(method (cycleDone)
		(if (== (client cel:) 0)
			(super init: client 2 1)
		else
			(super cycleDone:)
		)
	)
)

(instance turnLeft of CT
	(properties)

	(method (init param1)
		(super init: param1 (param1 lastCel:) 1)
	)

	(method (cycleDone)
		(if (== (client cel:) 4)
			(super init: client 2 -1)
		else
			(super cycleDone:)
		)
	)
)

