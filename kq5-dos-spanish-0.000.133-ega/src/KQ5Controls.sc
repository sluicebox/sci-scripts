;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use KQ5Window)
(use GameControls)
(use BorderWindow)
(use IconBar)

(public
	KQ5Controls 0
)

(procedure (localproc_0 param1 param2 param3)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(else param3)
		)
	)
)

(procedure (localproc_1)
	(localproc_0 1026 1040 946)
)

(instance KQ5Controls of GameControls
	(properties)

	(method (init)
		(= gGameControls self)
		(self
			window:
				(gcWin
					color: 20
					back: 20
					topBordColor: 22
					lftBordColor: 21
					rgtBordColor: 19
					botBordColor: 18
					yourself:
				)
			add:
				iconOk
				(detailSlider
					init:
					theObj: gGame
					selector: #detailLevel
					topValue: 3
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					init:
					theObj: gGame
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yourself:
				)
				(speedSlider
					init:
					theObj: 0
					selector: #species
					topValue: 0
					bottomValue: 15
					yourself:
				)
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
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo:
				#lowlightColor
				(cond
					((== global105 256) 19)
					((== global105 32) 9)
					(else 7)
				)
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 45] [temp59 4])
		(self
			top: (- (/ (- 200 (+ (CelHigh (localproc_1) 1 1) 6)) 2) 10)
			left:
				(-
					(/
						(-
							320
							(+
								67
								(localproc_0 -2 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 0)) 2)
								(localproc_0 2 2 4)
								(localproc_0 30 30 0)
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
					(localproc_0 -1 -1 10)
				)
			right:
				(+
					67
					(localproc_0 -2 4 0)
					(CelWide (localproc_1) 0 1)
					(* (+ 40 (localproc_0 10 15 0)) 2)
					(localproc_0 2 2 4)
					(localproc_0 30 30 0)
					(/
						(-
							320
							(+
								67
								(localproc_0 -2 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 0)) 2)
								(localproc_0 2 2 4)
								(localproc_0 30 30 0)
							)
						)
						2
					)
					(localproc_0 5 -5 10)
				)
			priority: 15
		)
		(= bevelWid 0)
		(= shadowWid 2)
		(= color (KQ5Window color:))
		(= back (KQ5Window back:))
		(super open:)
		(DrawCel 944 0 0 1 0 15)
		(DrawCel 944 0 1 1 (localproc_0 127 127 138) 15)
		(DrawCel 944 0 2 (localproc_0 224 230 184) 0 15)
		(DrawCel 944 0 3 (localproc_0 224 230 184) (localproc_0 127 127 138) 15)
		(Graph
			grDRAW_LINE
			0
			11
			0
			(localproc_0 224 230 184)
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			2
			11
			2
			(localproc_0 224 230 184)
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			(+ (CelHigh 944 0 0) (localproc_0 124 124 135))
			11
			(+ (CelHigh 944 0 0) (localproc_0 124 124 135))
			(localproc_0 224 230 184)
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			(+ (CelHigh 944 0 0) (localproc_0 126 126 137))
			11
			(+ (CelHigh 944 0 0) (localproc_0 126 126 137))
			(localproc_0 224 230 184)
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			10
			1
			(+ (CelWide 944 0 0) (localproc_0 126 126 138))
			1
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			10
			3
			(+ (CelWide 944 0 0) (localproc_0 126 126 138))
			3
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			10
			(+ (CelWide 944 0 0) (localproc_0 221 227 181))
			(localproc_0 126 126 138)
			(+ (CelWide 944 0 0) (localproc_0 221 227 181))
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph
			grDRAW_LINE
			10
			(+ (CelWide 944 0 0) (localproc_0 223 229 183))
			(localproc_0 126 126 138)
			(+ (CelWide 944 0 0) (localproc_0 223 229 183))
			(KQ5Window lineColor:)
			temp12 ; UNINIT
			-1
		)
		(Graph grUPDATE_BOX 0 11 3 (localproc_0 224 231 184) 1)
		(Graph
			grUPDATE_BOX
			(+ (CelHigh 944 0 0) (localproc_0 124 124 135))
			11
			(+ (CelHigh 944 0 0) (localproc_0 127 127 138))
			(localproc_0 224 231 184)
			1
		)
		(Graph grUPDATE_BOX 10 1 (localproc_0 127 127 138) 4 1)
		(Graph
			grUPDATE_BOX
			10
			(+ (CelWide 944 0 0) (localproc_0 221 227 181))
			138
			(+ (CelWide 944 0 0) (localproc_0 223 229 184))
			1
		)
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
								(localproc_0 -2 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 0)) 2)
								(localproc_0 2 2 4)
								(localproc_0 30 30 0)
							)
							(+
								(localproc_0 2 2 4)
								(localproc_0 2 2 0)
								(CelWide (localproc_1) 1 1)
							)
						)
						(CelWide (localproc_1) 0 5)
					)
					2
				)
				(localproc_0 2 2 4)
				(localproc_0 2 2 0)
				(CelWide (localproc_1) 1 1)
				10
			)
			(+ (localproc_0 -2 0 6) 10)
			15
		)
		(DrawCel
			(localproc_1)
			1
			1
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 10)
			(+ (- 3 (localproc_0 5 5 0)) 10)
			15
		)
		(DrawCel
			(localproc_1)
			1
			0
			(+ 67 (localproc_0 -2 4 0) (localproc_0 42 41 27) 10)
			48
			15
		)
		(DrawCel
			(localproc_1)
			1
			0
			(+
				67
				(localproc_0 -2 4 0)
				(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
				(localproc_0 42 48 28)
				10
			)
			48
			15
		)
		(DrawCel
			(localproc_1)
			0
			4
			(+ (- (+ 67 (localproc_0 -2 4 0)) (localproc_0 -2 0 4)) 10)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			15
		)
		(DrawCel
			(localproc_1)
			0
			3
			(+
				(-
					(+
						67
						(localproc_0 -2 4 0)
						(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					)
					(localproc_0 -2 1 6)
				)
				10
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			15
		)
		(DrawCel
			(localproc_1)
			0
			2
			(+
				(-
					(+
						67
						(localproc_0 -2 4 0)
						(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
						(- (+ 40 (localproc_0 10 15 0)) (localproc_0 15 15 0))
					)
					(localproc_0 -5 -10 1)
				)
				10
			)
			(+ (- 37 (+ (CelHigh (localproc_1) 0 4) 3)) 10)
			15
		)
		(= temp5
			(+
				(= temp2
					(+ (localproc_0 6 3 9) 37 (CelHigh (localproc_1) 0 1) 10)
				)
				13
			)
		)
		(= temp4
			(+
				(= temp3
					(+
						6
						(localproc_0 2 2 4)
						(localproc_0 2 2 0)
						(CelWide (localproc_1) 1 1)
						10
					)
				)
				(-
					(+
						67
						(localproc_0 -2 4 0)
						(CelWide (localproc_1) 0 1)
						(* (+ 40 (localproc_0 10 15 0)) 2)
						(localproc_0 2 2 4)
						(localproc_0 30 30 0)
					)
					(+
						6
						(localproc_0 2 2 4)
						(localproc_0 2 2 0)
						(CelWide (localproc_1) 1 1)
						(localproc_0 2 2 4)
						2
					)
				)
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 18)
		(= temp11 19)
		(= temp10 21)
		(= temp9 22)
		(= temp1 3)
		(= temp7 3)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 755 0 gScore gPossibleScore gScore gPossibleScore) ; "Score: %d/%d"
		(TextSize @temp59 @temp14 69 0)
		(Display
			@temp14
			dsFONT
			69
			dsCOLOR
			0
			dsCOORD
			(+
				6
				(localproc_0 2 2 4)
				(localproc_0 2 2 0)
				(CelWide (localproc_1) 1 1)
				(/
					(-
						(-
							(+
								67
								(localproc_0 -2 4 0)
								(CelWide (localproc_1) 0 1)
								(* (+ 40 (localproc_0 10 15 0)) 2)
								(localproc_0 2 2 4)
								(localproc_0 30 30 0)
							)
							(+
								6
								(localproc_0 2 2 4)
								(localproc_0 2 2 0)
								(CelWide (localproc_1) 1 1)
								(localproc_0 2 2 4)
								2
							)
						)
						[temp59 3]
					)
					2
				)
				10
			)
			(+ (localproc_0 6 3 9) 37 (CelHigh (localproc_1) 0 1) 3 10)
		)
	)
)

(instance detailSlider of Slider
	(properties
		loop 0
		cel 1
		signal 128
		helpStr {Raises and lowers the level of graphics detail.}
		topValue 3
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ 67 (localproc_0 -2 4 0) 10))
		(= nsTop 47)
		(= sliderView (localproc_1))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(localproc_0
				(+ 67 (localproc_0 -2 4 0) 20)
				(+ 67 (localproc_0 -2 4 0) 20)
				(+ 67 (localproc_0 -2 4 0) 10)
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
		helpStr {Adjusts sound volume.}
		topValue 15
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft
			(+
				67
				(localproc_0 -2 4 0)
				(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
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
			(localproc_0
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					20
				)
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					20
				)
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					10
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
		helpStr {Adjusts the speed of the game's animation (within the limits of your computer's capability).}
		bottomValue 15
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft
			(+
				67
				(localproc_0 -2 4 0)
				(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
				(- (+ 40 (localproc_0 10 15 0)) (localproc_0 15 15 0))
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
			(localproc_0
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 15 15 0))
					35
				)
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 15 15 0))
					35
				)
				(+
					67
					(localproc_0 -2 4 0)
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 3 8 0))
					(- (+ 40 (localproc_0 10 15 0)) (localproc_0 15 15 0))
					10
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
		helpStr {Saves your current game.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 3 else 4) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 3 else 4) 10))
		(super init: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		loop 3
		cel 0
		message 9
		signal 451
		helpStr {Restores a previously saved game.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 23 else 24) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 23 else 24) 10))
		(super init: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		loop 4
		cel 0
		message 9
		signal 451
		helpStr {Restarts the Game.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 43 else 44) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 43 else 44) 10))
		(super init: &rest)
	)
)

(instance iconQuit of ControlIcon
	(properties
		loop 5
		cel 0
		message 9
		signal 451
		helpStr {Exits the game.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 63 else 64) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 63 else 64) 10))
		(super init: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		loop 6
		cel 0
		message 9
		signal 451
		helpStr {Information about the game.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 83 else 84) 10))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_1))
		(= nsLeft (+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 10))
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 83 else 84) 10))
		(super init: &rest)
	)
)

(instance iconHelp of IconI
	(properties
		loop 7
		cel 0
		cursor 70
		message 6
		signal 387
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+
				(localproc_0 2 2 4)
				(localproc_0 2 2 0)
				(localproc_0 32 32 30)
				(localproc_0 10 11 10)
			)
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 83 else 84) 10))
		(super show: &rest)
	)
)

(instance iconOk of IconI
	(properties
		loop 8
		cel 0
		cursor 70
		message 9
		signal 451
		helpStr {Exits this menu.}
	)

	(method (show)
		(= view (localproc_1))
		(= nsLeft
			(+ (localproc_0 2 2 4) (localproc_0 2 2 0) 4 (localproc_0 10 11 10))
		)
		(= nsTop (+ (- 3 (localproc_0 5 5 0)) (if global159 103 else 104) 10))
		(super show: &rest)
	)
)

