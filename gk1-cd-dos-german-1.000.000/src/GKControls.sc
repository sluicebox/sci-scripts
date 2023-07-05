;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use HRView)
(use GKIconbar)
(use n013)
(use Plane)
(use Print)
(use IconBar)
(use Cursor)
(use Tutorial)
(use Game)
(use Actor)
(use System)

(public
	GKControls 0
)

(local
	local0
)

(class GKControlIcon of GKIconItem
	(properties
		theObj 0
	)

	(method (doit)
		(if theObj
			(if (& signal $0040)
				(gGameControls hide:)
			)
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)

(class SlideBar of GKIconItem
	(properties
		signal 128
		maxValue 0
		minValue 0
		minX 0
		maxX 0
		resolution 0
		inc 0
		value 0
		position 0
		theObj 0
		barObj 0
		oppose 0
	)

	(method (show)
		(|= signal $0020)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(= resolution (+ (/ (- maxX minX) inc) 1))
		(if (not position)
			(= position (self valueToPosn:))
		)
		(self refresh: position)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if (& signal $0004)
			(return 0)
		)
		(if (and argc param1)
			(= temp1 500)
			(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
				(temp0 localize: (GKControls plane:))
				(if (!= (= temp2 (- (temp0 x:) 7)) temp1)
					(if (< temp2 minX)
						(= temp2 minX)
					)
					(if (> temp2 maxX)
						(= temp2 maxX)
					)
					(= position temp2)
					(self refresh:)
				)
				(= temp1 temp2)
				(temp0 dispose:)
			)
			(= value (self posnToValue: position))
			(temp0 dispose:)
		else
			(return 1)
		)
	)

	(method (mask))

	(method (highlight))

	(method (valueToPosn)
		(= position
			(+ minX (* inc (/ (* value resolution) (- maxValue minValue))))
		)
	)

	(method (posnToValue param1 &tmp temp0)
		(= temp0
			(+ (/ (* (- maxValue minValue) (- param1 minX)) (- maxX minX)) 1)
		)
		(if (<= param1 minX)
			(= temp0 minValue)
		)
		(if (>= param1 (- nsRight nsLeft))
			(= temp0 maxValue)
		)
		(cond
			((< temp0 minValue)
				(= temp0 minValue)
			)
			((> temp0 maxValue)
				(= temp0 maxValue)
			)
		)
		(return temp0)
	)

	(method (refresh &tmp [temp0 3])
		(if (> position (- (CelWide view loop cel) 6))
			(= position (- (CelWide view loop cel) 6))
		)
		(barObj setInsetRect: 0 0 position 10)
		(UpdateScreenItem barObj)
		(UpdatePlane (GKControls plane:))
		(FrameOut)
	)

	(method (advance)
		(if (< position maxX)
			(+= position inc)
			(self refresh:)
			(= value (self posnToValue: position))
		)
	)

	(method (retreat)
		(if (> position minX)
			(-= position inc)
			(self refresh:)
			(= value (self posnToValue: position))
		)
	)
)

(instance controlWind of Plane
	(properties)
)

(class GKControls of IconBar
	(properties)

	(method (init)
		(= gGameControls self)
		(= local0 (Cast new:))
		(= plane controlWind)
		(self
			add:
				iconExit
				(iconVoice theObj: iconVoice selector: #doit yourself:)
				(iconNar theObj: iconNar selector: #doit yourself:)
				(iconBarUp theObj: gGame selector: #keepIconBar yourself:)
				(iconText theObj: iconText selector: #doit yourself:)
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconSave theObj: gGame selector: #save yourself:)
				(detailBar theObj: gGame selector: #detailLevel yourself:)
				speedBar
				soundBar
				musicBar
				textBar
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 2
			curIcon: iconRestore
			helpIconItem: iconHelp
			state: 2048
		)
		(super init:)
		(plane addCast: local0)
		(controlCel init: local0)
		(testBar init: local0)
		(testBar1 init: local0)
		(testBar2 init: local0)
		(testBar3 init: local0)
		(testBar4 init: local0)
		(maskObj init: local0 hide:)
		(plane setSize: posn: -1 32)
	)

	(method (showSelf)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(= curIcon iconExit)
		(self show: doit: hide:)
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

(instance iconNar of GKControlIcon
	(properties
		noun 33
		x 7
		y 99
		signal 387
		message 0
		mainView 9533
		mainLoop 2
		helpVerb 68
	)

	(method (show)
		(= mainLoop (if global166 2 else 3))
		(super show: &rest)
	)

	(method (doit)
		(if (or (IsFlag 470) (not (DoSound sndGET_AUDIO_CAPABILITY)))
			(gMessager say: 30 0 13 0 0 0) ; "That option is supported for CD-ROM only."
			(return)
		)
		(if
			(and
				global166
				(== (iconText mainLoop:) 5)
				(== (iconVoice mainLoop:) 6)
			)
			(gMessager say: 30 0 16 0 0 0) ; "The NARRATOR button can only be set to TEXT if the TEXT button is ON."
			(return)
		)
		(if (and (not global166) (== (iconVoice mainLoop:) 7))
			(gMessager say: 30 0 15 0 0 0) ; "The NARRATOR button can only be set to VOICE if the VOICE button is ON."
			(return)
		)
		(= mainLoop (= loop (if (== mainLoop 2) 3 else 2)))
		(UpdateScreenItem self)
		(switch mainLoop
			(2
				(= global166 1)
			)
			(3
				(= global166 0)
			)
		)
	)
)

(instance iconBarUp of GKControlIcon
	(properties
		noun 25
		x 90
		y 99
		signal 451
		message 0
		mainView 9533
		mainLoop 1
		helpVerb 68
	)

	(method (init)
		(= topIcon musicBar)
		(= leftIcon iconHelp)
		(= bottomIcon iconRestore)
		(= rightIcon iconQuit)
		(super init: &rest)
	)

	(method (show)
		(= mainLoop (if (gGame keepBar:) 0 else 1))
		(super show: &rest)
	)

	(method (doit)
		(gGame keepBar: (not (gGame keepBar:)))
		(self show:)
		(super doit: &rest)
	)
)

(instance iconText of GKControlIcon
	(properties
		noun 32
		x 44
		y 99
		signal 387
		mainView 9533
		mainLoop 4
		helpVerb 68
	)

	(method (init)
		(= topIcon musicBar)
		(= leftIcon iconExit)
		(= bottomIcon detailBar)
		(= rightIcon iconAbout)
		(super init: &rest)
	)

	(method (show)
		(= mainLoop (if (& gMsgType $0001) 4 else 5))
		(super show: &rest)
	)

	(method (doit &tmp temp0)
		(if (or (IsFlag 470) (not (DoSound sndGET_AUDIO_CAPABILITY)))
			(gMessager say: 30 0 13 0 0 0) ; "That option is supported for CD-ROM only."
			(return)
		)
		(if (and (== mainLoop 4) (== (iconVoice mainLoop:) 7))
			(gMessager say: 30 0 14 0 0 0) ; "Either TEXT or VOICE must be set to ON."
			(return)
		)
		(= mainLoop (= loop (if (== mainLoop 5) 4 else 5)))
		(UpdateScreenItem self)
		(switch mainLoop
			(4
				(|= gMsgType $0001)
			)
			(5
				(^= gMsgType $0001)
			)
		)
	)
)

(instance iconVoice of GKControlIcon
	(properties
		noun 31
		x 67
		y 99
		signal 387
		message 0
		mainView 9533
		mainLoop 6
		helpVerb 68
	)

	(method (show)
		(= mainLoop (if (& gMsgType $0002) 6 else 7))
		(super show: &rest)
	)

	(method (doit)
		(if (or (IsFlag 470) (not (DoSound sndGET_AUDIO_CAPABILITY)))
			(gMessager say: 30 0 13 0 0 0) ; "That option is supported for CD-ROM only."
			(return)
		)
		(if (and (== mainLoop 6) (== (iconText mainLoop:) 5))
			(gMessager say: 30 0 14 0 0 0) ; "Either TEXT or VOICE must be set to ON."
			(return)
		)
		(if (and (== mainLoop 6) (== (iconNar mainLoop:) 2))
			(return)
		)
		(= mainLoop (= loop (if (== mainLoop 6) 7 else 6)))
		(UpdateScreenItem self)
		(switch mainLoop
			(6
				(|= gMsgType $0002)
			)
			(7
				(^= gMsgType $0002)
			)
		)
	)
)

(instance iconAbout of GKControlIcon
	(properties
		noun 23
		x 120
		y 22
		signal 449
		message 0
		mainView 953
		mainLoop 7
		helpVerb 68
	)

	(method (init)
		(= topIcon musicBar)
		(= leftIcon iconText)
		(= bottomIcon detailBar)
		(= rightIcon iconHelp)
		(super init: &rest)
	)
)

(instance iconHelp of GKControlIcon
	(properties
		noun 24
		x 120
		y 70
		signal 387
		message 68
		mainView 953
		mainLoop 12
		helpVerb 68
	)

	(method (init)
		(= cursorView cHelpControl)
		(= topIcon musicBar)
		(= leftIcon iconAbout)
		(= bottomIcon iconRestore)
		(= rightIcon iconBarUp)
		(super init: &rest)
	)
)

(instance iconExit of GKIconItem
	(properties
		noun 19
		x 120
		y 102
		signal 451
		message 0
		mainView 953
		mainLoop 5
		helpVerb 68
	)

	(method (init)
		(= topIcon musicBar)
		(= leftIcon iconQuit)
		(= bottomIcon detailBar)
		(= rightIcon iconText)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconQuit of GKControlIcon
	(properties
		noun 20
		x 120
		y 6
		signal 451
		message 0
		mainView 953
		mainLoop 9
		helpVerb 68
	)

	(method (init)
		(= topIcon iconRestart)
		(= leftIcon iconBarUp)
		(= bottomIcon iconRestore)
		(= rightIcon iconExit)
		(super init: &rest)
	)
)

(instance iconRestart of GKControlIcon
	(properties
		noun 21
		x 120
		y 86
		signal 451
		message 0
		mainView 953
		mainLoop 8
		helpVerb 68
	)

	(method (init)
		(= topIcon iconSave)
		(= leftIcon musicBar)
		(= bottomIcon iconQuit)
		(= rightIcon musicBar)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(= temp0 gTheCursor)
		(gGame setCursor: theArrowCurs 1)
		(if
			(myP
				addIcon: 967 0 0 0 0
				addButtonBM: 967 1 0 1 {} 21 27
				addButtonBM: 967 2 0 0 {} 21 49
				init:
			)
			(if (gGame script:)
				((gGame script:) dispose:)
			)
			(if (gCurRoom script:)
				((gCurRoom script:) dispose:)
			)
			(for ((= temp1 0)) (< temp1 (gCast size:)) ((+= temp1 1))
				(= temp2 (gCast at: temp1))
				(if (and (temp2 isKindOf: Prop) (temp2 script:))
					((temp2 script:) dispose:)
				)
			)
			(gGame newRoom: 93) ; restartGame
		else
			(gGame setCursor: temp0 1)
		)
	)
)

(instance iconRestore of GKControlIcon
	(properties
		noun 27
		x 120
		y 38
		signal 451
		message 0
		mainView 953
		mainLoop 13
		helpVerb 68
	)

	(method (init)
		(= topIcon iconQuit)
		(= leftIcon detailBar)
		(= bottomIcon iconSave)
		(= rightIcon detailBar)
		(super init: &rest)
	)
)

(instance iconSave of GKControlIcon
	(properties
		noun 26
		x 120
		y 54
		signal 451
		message 0
		mainView 953
		mainLoop 6
		helpVerb 68
	)

	(method (init)
		(= topIcon iconRestore)
		(= leftIcon speedBar)
		(= bottomIcon iconRestart)
		(= rightIcon speedBar)
		(super init: &rest)
	)
)

(instance speedBar of SlideBar
	(properties
		noun 16
		x 7
		y 6
		mainView 953
		mainLoop 15
		helpVerb 68
		maxValue 12
		minX 28
		maxX 106
		inc 2
		oppose 1
	)

	(method (init)
		(= barObj testBar)
		(= topIcon detailBar)
		(= bottomIcon soundBar)
		(super init: &rest)
	)

	(method (show)
		(= value (- maxValue (gGame currentSpeed:)))
		(if (or (not (gGame isHandsOn:)) (IsFlag 200))
			(= signal 132)
		else
			(= signal 128)
		)
		(|= signal $0020)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(= resolution (+ (/ (- maxX minX) inc) 1))
		(if (not position)
			(= position (self valueToPosn:))
		)
		(if (& signal $0004)
			(maskObj show:)
			(UpdateScreenItem maskObj)
		else
			(maskObj hide:)
			(self refresh: position)
		)
	)

	(method (doit)
		(if (== value 11)
			(= value maxValue)
		)
		(gGame currentSpeed: (- maxValue value))
		(gEgo setSpeed: (gGame currentSpeed:))
	)
)

(instance musicBar of SlideBar
	(properties
		noun 18
		x 7
		y 21
		mainView 953
		mainLoop 15
		mainCel 1
		helpVerb 68
		maxValue 85
		minX 28
		maxX 106
		inc 2
	)

	(method (init)
		(= barObj testBar1)
		(= topIcon soundBar)
		(= bottomIcon iconExit)
		(super init: &rest)
	)

	(method (show)
		(= value (gGkMusic1 musicVolume:))
		(super show:)
	)

	(method (doit &tmp temp0 temp1)
		(if (> value maxValue)
			(= value maxValue)
		)
		(if (< value minValue)
			(= value minValue)
		)
		(for ((= temp0 0)) (< temp0 (Sounds size:)) ((++ temp0))
			(= temp1 (Sounds at: temp0))
			(if (== (temp1 type:) 0)
				(temp1 setVol: value musicVolume: value)
			)
		)
	)
)

(instance soundBar of SlideBar
	(properties
		noun 17
		x 7
		y 36
		mainView 953
		mainLoop 15
		mainCel 2
		helpVerb 68
		maxValue 127
		minX 28
		maxX 106
		inc 2
	)

	(method (init)
		(= barObj testBar2)
		(= topIcon speedBar)
		(= bottomIcon musicBar)
		(super init: &rest)
	)

	(method (show)
		(= value (gGkSound1 soundVolume:))
		(super show:)
	)

	(method (doit &tmp temp0 temp1)
		(if (> value maxValue)
			(= value maxValue)
		)
		(if (< value minValue)
			(= value minValue)
		)
		(for ((= temp0 0)) (< temp0 (Sounds size:)) ((++ temp0))
			(= temp1 (Sounds at: temp0))
			(if (== (temp1 type:) 1)
				(temp1 setVol: value soundVolume: value)
			)
		)
	)
)

(instance textBar of SlideBar
	(properties
		noun 34
		x 7
		y 51
		mainView 953
		mainLoop 15
		mainCel 3
		helpVerb 68
		maxValue 8
		minX 28
		maxX 106
		inc 2
		oppose 1
	)

	(method (init)
		(= barObj testBar3)
		(= topIcon soundBar)
		(= bottomIcon iconExit)
		(super init: &rest)
	)

	(method (show)
		(= value (- maxValue gTextSpeed))
		(super show:)
	)

	(method (doit &tmp [temp0 2])
		(if (> value maxValue)
			(= value maxValue)
		)
		(if (< value minValue)
			(= value minValue)
		)
		(= gTextSpeed (- maxValue value))
	)
)

(instance detailBar of SlideBar
	(properties
		noun 15
		x 7
		y 66
		mainView 953
		mainLoop 15
		mainCel 4
		helpVerb 68
		maxValue 3
		minX 28
		maxX 106
		inc 2
	)

	(method (init)
		(= barObj testBar4)
		(= topIcon iconExit)
		(= bottomIcon speedBar)
		(super init: &rest)
	)

	(method (show)
		(= value (gGame detailLevel:))
		(super show:)
	)

	(method (doit)
		(gGame detailLevel: value)
	)
)

(instance testBar of HRView
	(properties
		x 7
		y 6
		view 953
		loop 11
	)
)

(instance testBar1 of HRView
	(properties
		x 7
		y 21
		view 953
		loop 11
	)
)

(instance testBar2 of HRView
	(properties
		x 7
		y 36
		view 953
		loop 11
	)
)

(instance testBar3 of HRView
	(properties
		x 7
		y 51
		view 953
		loop 11
	)
)

(instance testBar4 of HRView
	(properties
		x 7
		y 66
		view 953
		loop 11
	)
)

(instance controlCel of HRView
	(properties
		view 953
		loop 10
	)
)

(instance maskObj of HRView
	(properties
		x 7
		y 6
		view 953
		loop 14
	)
)

(instance cHelpControl of Cursor
	(properties
		view 958
		loop 8
	)
)

(instance myP of Print
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

(instance theArrowCurs of Cursor
	(properties
		view 999
	)
)

