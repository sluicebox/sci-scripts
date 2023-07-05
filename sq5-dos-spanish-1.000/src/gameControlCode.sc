;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Print)
(use Slider)
(use BorderWindow)
(use IconBar)
(use GameControls)
(use System)

(public
	gameControlCode 0
	gcWin 1
)

(class SQ5ControlItem of ControlIcon
	(properties)

	(method (select)
		(super select: &rest)
		(self doit:)
	)
)

(instance gameControls of GameControls
	(properties)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 [temp3 50] temp53 temp54)
		(= temp53 (event type:))
		(= temp54 (event message:))
		(cond
			((& temp53 evHELP)
				(if
					(and
						(= temp1 (self firstTrue: #onMe event))
						(temp1 helpVerb:)
					)
					(= temp2 (GetPort))
					(if (gSystemWindow respondsTo: #eraseOnly)
						(= temp0 (gSystemWindow eraseOnly:))
						(gSystemWindow eraseOnly: 1)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp1 noun:)
								(temp1 helpVerb:)
								0
								1
								0
								0
								(temp1 modNum:)
							init:
						)
						(gSystemWindow eraseOnly: temp0)
					else
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp1 noun:)
								(temp1 helpVerb:)
								0
								1
								0
								0
								(temp1 modNum:)
							init:
						)
					)
					(SetPort temp2)
				)
				(if helpIconItem
					(helpIconItem signal: (& (helpIconItem signal:) $ffef))
				)
				(gGame setCursor: 999)
				(return 0)
			)
			((& temp53 $0040) ; direction
				(switch temp54
					(JOY_DOWN
						(cond
							(
								(and
									(IsObject highlightedIcon)
									(highlightedIcon respondsTo: #retreat)
								)
								(highlightedIcon retreat:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
									(& (highlightedIcon signal:) $0100)
								)
								(self advance:)
								(return 0)
							)
						)
					)
					(JOY_UP
						(cond
							(
								(and
									(IsObject highlightedIcon)
									(highlightedIcon respondsTo: #advance)
								)
								(highlightedIcon advance:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
									(& (highlightedIcon signal:) $0100)
								)
								(self retreat:)
								(return 0)
							)
						)
					)
					(else
						(super dispatchEvent: event)
					)
				)
			)
			(else
				(super dispatchEvent: event)
			)
		)
	)
)

(instance gameControlCode of Code
	(properties)

	(method (doit)
		(= gGameControls gameControls)
		(gGameControls
			add:
				detailSlider
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(speedSlider theObj: gEgo selector: #setSpeed yourself:)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				iconOk
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 4
			eachElementDo: #modNum 0
			eachElementDo: #helpVerb 5
			helpIconItem: iconHelp
			window: gcWin
			curIcon: iconSave
			state: 2048
			show:
		)
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 [temp1 25] [temp26 25] temp51)
		(= temp51 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			left: (/ (- 320 (+ 151 (CelWide 995 0 1))) 2)
			bottom:
				(+ (CelHigh 995 1 1) 6 (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2))
			right:
				(+
					151
					(CelWide 995 0 1)
					(/ (- 320 (+ 151 (CelWide 995 0 1))) 2)
				)
			priority: temp51
		)
		(super open:)
		(DrawCel
			995
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 995 0 1)) (+ 4 (CelWide 995 1 1)))
						(CelWide 995 0 5)
					)
					2
				)
				4
				(CelWide 995 1 1)
			)
			3
			temp51
		)
		(DrawCel 995 1 1 4 3 temp51)
		(DrawCel 995 1 0 94 (Localize 38 28 38 28 38) temp51)
		(DrawCel 995 1 0 135 (Localize 38 28 38 28 38) temp51)
		(DrawCel
			995
			0
			4
			63
			(Localize
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 8)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 8)
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			0
			3
			(Localize 101 101 101 105 101)
			(Localize
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(+ (- 37 (+ (CelHigh 995 0 4) 3)) (CelHigh 995 0 1) 3)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(+ (- 37 (+ (CelHigh 995 0 4) 3)) (CelHigh 995 0 1) 3)
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			0
			2
			(Localize 140 134 146 134 146)
			(Localize
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 8)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 8)
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			9
			0
			(+ 5 (CelWide 995 1 1))
			(+ 38 (CelHigh 995 0 1))
			temp51
		)
		(Graph grUPDATE_BOX 12 1 15 (+ 151 (CelWide 995 0 1)) 1)
		(Message msgGET 0 18 0 1 1 @temp1) ; "OUT OF"
		(Format @temp26 {%d %s %d} gScore @temp1 gPossibleScore)
		(Display
			@temp26
			dsFONT
			gUserFont
			dsCOORD
			(+ 5 (CelWide 995 1 1) 6)
			(- (+ 38 (CelHigh 995 0 1) 15) (Localize 0 2 0 2 0))
		)
		(SetPort 0)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 139
		nsTop 73
		signal 128
		noun 5
		helpVerb 5
		sliderView 995
		bottomValue 1
		topValue 3
	)

	(method (show)
		(= nsTop (- 73 (Localize 0 10 0 10 0)))
		(super show: &rest)
	)

	(method (doit param1)
		(if argc
			(gGame detailLevel: param1)
		)
		(gGame detailLevel:)
	)
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 179
		nsTop 73
		signal 128
		noun 24
		helpVerb 5
		sliderView 995
		topValue 15
	)

	(method (show)
		(= nsTop (- 73 (Localize 0 10 0 10 0)))
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 219
		nsTop 73
		signal 128
		noun 25
		helpVerb 5
		sliderView 995
		bottomValue 15
	)

	(method (show)
		(= nsTop (- 73 (Localize 0 10 0 10 0)))
		(if (not (gUser controls:))
			(= signal 132)
		else
			(= signal 128)
		)
		(super show: &rest)
	)

	(method (move)
		(if (gUser controls:)
			(super move: &rest)
		)
	)

	(method (doit param1)
		(if argc
			(gEgo setSpeed: param1)
		)
		(return global123)
	)

	(method (mask))
)

(instance iconSave of SQ5ControlItem
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 80
		nsTop 42
		message 8
		signal 451
		noun 23
		helpVerb 5
	)
)

(instance iconRestore of SQ5ControlItem
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 80
		nsTop 62
		message 8
		signal 451
		noun 21
		helpVerb 5
	)
)

(instance iconRestart of SQ5ControlItem
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 80
		nsTop 82
		message 8
		signal 451
		noun 20
		helpVerb 5
	)
)

(instance iconQuit of SQ5ControlItem
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 80
		nsTop 102
		message 8
		signal 451
		noun 19
		helpVerb 5
	)
)

(instance iconAbout of SQ5ControlItem
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 80
		nsTop 142
		message 8
		signal 451
		noun 1
		helpVerb 5
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 106
		nsTop 142
		cursor 989
		message 5
		signal 387
		noun 7
		helpVerb 5
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 80
		nsTop 122
		cursor 989
		message 8
		signal 451
		noun 17
		helpVerb 5
	)
)

