;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use BertaWindow)
(use KQCursor)
(use GameControls)
(use IconBar)

(public
	slowControls 0
	fastControls 1
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(procedure (localproc_1)
	(localproc_0 1026 1040 1051 1050 946)
)

(class KQ5Controls of GameControls
	(properties)

	(method (init)
		(Load rsVIEW 946)
		(= gGameControls self)
		(self
			add:
				iconOk
				(iconSave init: theObj: gGame selector: #save yourself:)
				(iconRestore init: theObj: gGame selector: #restore yourself:)
				(iconRestart init: theObj: gGame selector: #restart yourself:)
				(iconQuit init: theObj: gGame selector: #quitGame yourself:)
				(iconAbout
					init:
					theObj: (ScriptID 756 0) ; about
					selector: #doit
					yourself:
				)
				(iconHelp cursor: helpCursor yourself:)
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (if global159 19 else 7)
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(super init: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (and (== (event type:) evVERB) (== (event message:) 6))
			(= temp2 0)
			(= temp1 (self firstTrue: #onMe event))
			(event dispose:)
			(if (and temp1 (temp1 helpStr:))
				(self hide:)
				(= temp0 (GetPort))
				(DoAudio audPLAY (temp1 helpStr:))
				(SetPort temp0)
				(= temp2 1)
			)
			(if helpIconItem
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(gGame setCursor: gNormalCursor)
			(if temp2
				(self show:)
			)
			(return temp1)
		else
			(super dispatchEvent: event)
		)
	)
)

(instance fastControls of KQ5Controls
	(properties)

	(method (init)
		(self
			window:
				(fastWin
					top: (- (/ (- 200 (+ (CelHigh (localproc_1) 1 1) 6)) 2) 10)
					left:
						(-
							(/
								(-
									320
									(+
										67
										(localproc_0 -2 4 4 4 0)
										(CelWide (localproc_1) 0 1)
										(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
										(localproc_0 2 2 2 2 4)
										(localproc_0 30 30 30 30 0)
									)
								)
								2
							)
							10
						)
					bottom:
						(+
							(CelHigh (localproc_1) 1 1)
							6
							(/ (- 200 (+ (CelHigh (localproc_1) 1 1) 6)) 2)
							(localproc_0 -1 -1 -1 -1 10)
						)
					right:
						(+
							67
							(localproc_0 -2 4 4 4 0)
							(CelWide (localproc_1) 0 1)
							(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
							(localproc_0 2 2 2 2 4)
							(localproc_0 30 30 30 30 0)
							(/
								(-
									320
									(+
										67
										(localproc_0 -2 4 4 4 0)
										(CelWide (localproc_1) 0 1)
										(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
										(localproc_0 2 2 2 2 4)
										(localproc_0 30 30 30 30 0)
									)
								)
								2
							)
							(localproc_0 5 -5 -5 -5 10)
						)
					yourself:
				)
			add:
				(detailSlider
					init:
					theObj: gGame
					selector: #detailLevel
					topValue: 3
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(volumeSlider
					init:
					theObj: gGame
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(speedSlider
					init:
					theObj: 0
					selector: #species
					topValue: 0
					bottomValue: 10
					yStep: 2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance slowControls of KQ5Controls
	(properties)

	(method (init)
		(self
			window:
				(slowWin
					top: (- (/ (- 200 (+ (CelHigh (localproc_1) 1 1) 6)) 2) 5)
					left:
						(-
							(/
								(-
									320
									(+
										67
										(localproc_0 -2 4 4 4 0)
										(CelWide (localproc_1) 0 1)
										(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
										(localproc_0 2 2 2 2 4)
										(localproc_0 30 30 30 30 0)
									)
								)
								2
							)
							5
						)
					bottom:
						(+
							(CelHigh (localproc_1) 1 1)
							6
							(/ (- 200 (+ (CelHigh (localproc_1) 1 1) 6)) 2)
							(localproc_0 -1 -1 -1 -1 10)
						)
					right:
						(+
							67
							(localproc_0 -2 4 4 4 0)
							(CelWide (localproc_1) 0 1)
							(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
							(localproc_0 2 2 2 2 4)
							(localproc_0 30 30 30 30 0)
							(/
								(-
									320
									(+
										67
										(localproc_0 -2 4 4 4 0)
										(CelWide (localproc_1) 0 1)
										(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
										(localproc_0 2 2 2 2 4)
										(localproc_0 30 30 30 30 0)
									)
								)
								2
							)
							(localproc_0 5 -5 -5 -5 10)
						)
					yourself:
				)
			add:
				(volumeSlider
					init:
					theObj: gGame
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(speedSlider
					init:
					theObj: 0
					selector: #species
					topValue: 0
					bottomValue: 15
					yStep: 2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fastWin of BertaWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] [temp5 45])
		(super open:)
		(= local0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel
			(localproc_1)
			0
			5
			(+
				(/
					(-
						(-
							(+
								67
								(localproc_0 -2 4 4 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
								(localproc_0 2 2 2 2 4)
								(localproc_0 30 30 30 30 0)
							)
							(+
								(localproc_0 2 2 2 2 4)
								(localproc_0 2 2 2 2 0)
								(CelWide (localproc_1) 1 1)
							)
						)
						(CelWide (localproc_1) 0 5)
					)
					2
				)
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				(CelWide (localproc_1) 1 1)
				10
			)
			(+ (localproc_0 -2 0 0 0 6) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			1
			1
			(+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 10)
			(+ (- 3 (localproc_0 5 5 5 5 0)) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			1
			0
			(+ 67 (localproc_0 -2 4 4 4 0) (localproc_0 42 41 41 41 27) 10)
			48
			-1
			0
		)
		(DrawCel
			(localproc_1)
			1
			0
			(+
				67
				(localproc_0 -2 4 4 4 0)
				(- (+ 40 (localproc_0 10 15 15 15 0)) (localproc_0 3 8 8 8 0))
				(localproc_0 42 48 48 48 28)
				10
			)
			48
			-1
			0
		)
		(DrawCel
			(localproc_1)
			0
			4
			(+ (- (+ 67 (localproc_0 -2 4 4 4 0)) (localproc_0 -2 0 0 0 4)) 10)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			0
			3
			(+
				(-
					(+
						67
						(localproc_0 -2 4 4 4 0)
						(-
							(+ 40 (localproc_0 10 15 15 15 0))
							(localproc_0 3 8 8 8 0)
						)
					)
					(localproc_0 -2 1 1 1 6)
				)
				10
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			0
			2
			(+
				(-
					(+
						67
						(localproc_0 -2 4 4 4 0)
						(-
							(+ 40 (localproc_0 10 15 15 15 0))
							(localproc_0 3 8 8 8 0)
						)
						(-
							(+ 40 (localproc_0 10 15 15 15 0))
							(localproc_0 15 15 15 15 0)
						)
					)
					(localproc_0 -5 -10 -10 -10 1)
				)
				10
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			-1
			0
		)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
		(Format @temp5 755 0 gScore gPossibleScore) ; "Score: %d/%d"
		(TextSize @temp1 @temp5 69 0)
		(Display
			@temp5
			dsFONT
			69
			dsCOLOR
			0
			dsCOORD
			(+
				6
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				(CelWide (localproc_1) 1 1)
				(/
					(-
						(-
							(+
								67
								(localproc_0 -2 4 4 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
								(localproc_0 2 2 2 2 4)
								(localproc_0 30 30 30 30 0)
							)
							(+
								6
								(localproc_0 2 2 2 2 4)
								(localproc_0 2 2 2 2 0)
								(CelWide (localproc_1) 1 1)
								(localproc_0 2 2 2 2 4)
								2
							)
						)
						[temp1 3]
					)
					2
				)
				10
			)
			(+ (localproc_0 6 3 3 3 9) 37 (CelHigh (localproc_1) 0 1) 3 10)
		)
	)
)

(instance slowWin of BertaWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] [temp5 45])
		(super open:)
		(= local0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel
			(localproc_1)
			0
			5
			(+
				(/
					(-
						(-
							(+
								67
								(localproc_0 -2 4 4 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
								(localproc_0 2 2 2 2 4)
								(localproc_0 30 30 30 30 0)
							)
							(+
								(localproc_0 2 2 2 2 4)
								(localproc_0 2 2 2 2 0)
								(CelWide (localproc_1) 1 1)
							)
						)
						(CelWide (localproc_1) 0 5)
					)
					2
				)
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				(CelWide (localproc_1) 1 1)
				10
			)
			(+ (localproc_0 -2 0 0 0 6) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			1
			1
			(+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 10)
			(+ (- 3 (localproc_0 5 5 5 5 0)) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			1
			0
			(-
				(+
					67
					(localproc_0 -2 4 4 4 0)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 3 8 8 8 0)
					)
					(localproc_0 42 48 48 48 28)
				)
				10
			)
			48
			-1
			0
		)
		(DrawCel
			(localproc_1)
			0
			3
			(-
				(-
					(+
						67
						(localproc_0 -2 4 4 4 0)
						(-
							(+ 40 (localproc_0 10 15 15 15 0))
							(localproc_0 3 8 8 8 0)
						)
					)
					(localproc_0 -2 1 1 1 6)
				)
				20
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			-1
			0
		)
		(DrawCel
			(localproc_1)
			0
			2
			(-
				(+
					67
					(localproc_0 -2 4 4 4 0)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 3 8 8 8 0)
					)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 15 15 15 15 0)
					)
				)
				(localproc_0 -5 -10 -10 -10 1)
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			-1
			0
		)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
		(Format @temp5 755 0 gScore gPossibleScore) ; "Score: %d/%d"
		(TextSize @temp1 @temp5 69 0)
		(Display
			@temp5
			dsFONT
			69
			dsCOLOR
			0
			dsCOORD
			(+
				6
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				(CelWide (localproc_1) 1 1)
				(/
					(-
						(-
							(+
								67
								(localproc_0 -2 4 4 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 15 15 0)) 2)
								(localproc_0 2 2 2 2 4)
								(localproc_0 30 30 30 30 0)
							)
							(+
								6
								(localproc_0 2 2 2 2 4)
								(localproc_0 2 2 2 2 0)
								(CelWide (localproc_1) 1 1)
								(localproc_0 2 2 2 2 4)
								2
							)
						)
						[temp1 3]
					)
					2
				)
				10
			)
			(+ (localproc_0 6 3 3 3 9) 37 (CelHigh (localproc_1) 0 1) 3 10)
		)
	)
)

(instance detailSlider of Slider
	(properties
		loop 0
		cel 1
		signal 128
		helpStr 9220
		topValue 3
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ 67 (localproc_0 -2 4 4 4 0) 10))
		(= nsTop 47)
		(= sliderView (localproc_1))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(localproc_0
				(+ 67 (localproc_0 -2 4 4 4 0) 20)
				(+ 67 (localproc_0 -2 4 4 4 0) 20)
				(+ 67 (localproc_0 -2 4 4 4 0) 20)
				(+ 67 (localproc_0 -2 4 4 4 0) 20)
				(+ 67 (localproc_0 -2 4 4 4 0) 10)
			)
		)
		(= sliderView (localproc_1))
		(= nsTop 47)
		(= sRight 0)
		(super show: &rest)
	)
)

(instance volumeSlider of Slider
	(properties
		loop 0
		cel 1
		signal 128
		helpStr 9221
		topValue 15
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft
			(+
				67
				(localproc_0 -2 4 4 4 0)
				(- (+ 40 (localproc_0 10 15 15 15 0)) (localproc_0 3 8 8 8 0))
				10
			)
		)
		(= nsTop 47)
		(= sliderView (localproc_1))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(if (== gGameControls fastControls)
				(+
					67
					(localproc_0 -2 4 4 4 0)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 3 8 8 8 0)
					)
					10
				)
			else
				(-
					(+
						67
						(localproc_0 -2 4 4 4 0)
						(-
							(+ 40 (localproc_0 10 15 15 15 0))
							(localproc_0 3 8 8 8 0)
						)
					)
					20
				)
			)
		)
		(= sliderView (localproc_1))
		(= nsTop 47)
		(= sRight 0)
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		loop 0
		cel 1
		signal 128
		helpStr 9222
		bottomValue 15
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft
			(+
				67
				(localproc_0 -2 4 4 4 0)
				(- (+ 40 (localproc_0 10 15 15 15 0)) (localproc_0 3 8 8 8 0))
				(-
					(+ 40 (localproc_0 10 15 15 15 0))
					(localproc_0 15 15 15 15 0)
				)
				10
			)
		)
		(= nsTop 47)
		(= sliderView (localproc_1))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(if (== gGameControls fastControls)
				(+
					67
					(localproc_0 -2 4 4 4 0)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 3 8 8 8 0)
					)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 15 15 15 15 0)
					)
					10
				)
			else
				(+
					67
					(localproc_0 -2 4 4 4 0)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 3 8 8 8 0)
					)
					(-
						(+ 40 (localproc_0 10 15 15 15 0))
						(localproc_0 15 15 15 15 0)
					)
				)
			)
		)
		(= nsTop 47)
		(= sRight 0)
		(super show: &rest)
	)

	(method (doit param1)
		(if argc
			(gEgo moveSpeed: param1 cycleSpeed: param1)
			(gGame egoMoveSpeed: param1)
		)
		(gEgo moveSpeed:)
	)
)

(instance iconSave of ControlIcon
	(properties
		loop 2
		cel 0
		message 9
		signal 451
		helpStr 9223
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 3 else 4) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 3 else 4) 10))
		(super init: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		loop 3
		cel 0
		message 9
		signal 451
		helpStr 9224
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 23 else 24) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 23 else 24) 10))
		(super init: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		loop 4
		cel 0
		message 9
		signal 451
		helpStr 9225
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 43 else 44) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 43 else 44) 10))
		(super init: &rest)
	)
)

(instance iconQuit of ControlIcon
	(properties
		loop 5
		cel 0
		message 9
		signal 451
		helpStr 9226
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 63 else 64) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 63 else 64) 10))
		(super init: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		loop 6
		cel 0
		message 9
		signal 451
		helpStr 9227
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 83 else 84) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 2 2 4) (localproc_0 2 2 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 83 else 84) 10))
		(super init: &rest)
	)
)

(instance iconHelp of IconI
	(properties
		loop 7
		cel 0
		message 6
		signal 387
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				(localproc_0 32 32 32 32 30)
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 83 else 84) 10))
		(super show: &rest)
	)
)

(instance iconOk of IconI
	(properties
		loop 8
		cel 0
		message 9
		signal 451
		helpStr 9228
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 2 2 4)
				(localproc_0 2 2 2 2 0)
				4
				(localproc_0 10 11 11 11 10)
			)
		)
		(= nsTop
			(+ (- 3 (localproc_0 5 5 5 5 0)) (if global159 103 else 104) 10)
		)
		(super show: &rest)
	)
)

(instance helpCursor of KQCursor
	(properties
		view 942
		loop 1
		cel 4
	)

	(method (init)
		(if global400
			(self number: 70 yourself:)
		)
		(super init: &rest)
	)
)

