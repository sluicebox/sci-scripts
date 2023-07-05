;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use Interface)
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

(procedure (localproc_0 param1 param2)
	(return (if (== gHowFast 0) param1 else param2))
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
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

(procedure (localproc_2)
	(localproc_1 1026 1040 1051 1050 946)
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
				(Printf 755 0 (temp1 helpStr:)) ; "%s"
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
			window: (fastWin top: 40 left: 60 bottom: 165 right: 260 yourself:)
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
			window: (slowWin top: 40 left: 75 bottom: 165 right: 245 yourself:)
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
			(localproc_2)
			0
			5
			(localproc_1 95 95 95 115 102)
			(localproc_1 2 6 6 14 14)
			-1
			0
		)
		(DrawCel (localproc_2) 1 1 (localproc_1 1 14 14 1 1) 2 -1 0)
		(DrawCel (localproc_2) 1 0 (localproc_1 97 122 122 111 108) 46 -1 0)
		(DrawCel (localproc_2) 1 0 (localproc_1 144 176 176 153 149) 46 -1 0)
		(DrawCel
			(localproc_2)
			0
			4
			(localproc_1 65 81 81 66 77)
			(localproc_1 19 33 33 33 33)
			-1
			0
		)
		(DrawCel
			(localproc_2)
			0
			3
			(localproc_1 103 127 127 116 115)
			(localproc_1 19 33 33 33 33)
			-1
			0
		)
		(DrawCel
			(localproc_2)
			0
			2
			(localproc_1 140 158 158 155 160)
			(localproc_1 19 33 33 33 33)
			-1
			0
		)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
		(Format @temp5 755 1 gScore gPossibleScore gScore gPossibleScore) ; "Score: %d/%d"
		(TextSize @temp1 @temp5 69 0)
		(Display @temp5 dsFONT 69 dsCOLOR 0 dsCOORD (localproc_1 90 95 95 95 95) 114)
	)
)

(instance slowWin of BertaWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] [temp5 45])
		(super open:)
		(= local0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel
			(localproc_2)
			0
			5
			(localproc_1 85 95 95 108 88)
			(localproc_1 2 6 6 14 14)
			-1
			0
		)
		(DrawCel (localproc_2) 1 1 (localproc_1 1 14 14 1 1) 2 -1 0)
		(DrawCel (localproc_2) 1 0 (localproc_1 111 176 176 115 117) 46 -1 0)
		(DrawCel
			(localproc_2)
			0
			3
			(localproc_1 70 127 127 72 74)
			(localproc_1 19 33 33 33 33)
			-1
			0
		)
		(DrawCel
			(localproc_2)
			0
			2
			(localproc_1 110 158 158 125 135)
			(localproc_1 19 33 33 33 33)
			-1
			0
		)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
		(Format @temp5 755 1 gScore gPossibleScore gScore gPossibleScore) ; "Score: %d/%d"
		(TextSize @temp1 @temp5 69 0)
		(Display @temp5 dsFONT 69 dsCOLOR 0 dsCOORD 75 114)
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 71 81 81 81 81))
		(= nsTop 45)
		(= sliderView (localproc_2))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_2))
		(= nsLeft (localproc_1 71 81 81 81 81))
		(= sliderView (localproc_2))
		(= nsTop 45)
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
		(= view (localproc_2))
		(= nsLeft
			(localproc_0
				(localproc_1 78 118 118 80 81)
				(localproc_1 110 118 118 124 121)
			)
		)
		(= nsTop 45)
		(= sliderView (localproc_2))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_2))
		(= nsLeft
			(localproc_0
				(localproc_1 78 118 118 80 81)
				(localproc_1 110 118 118 124 121)
			)
		)
		(= sliderView (localproc_2))
		(= nsTop 45)
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
		(= view (localproc_2))
		(= nsLeft
			(localproc_0
				(localproc_1 130 168 168 135 136)
				(localproc_1 160 168 168 165 161)
			)
		)
		(= nsTop 45)
		(= sliderView (localproc_2))
		(super init: &rest)
	)

	(method (show)
		(= view (localproc_2))
		(= nsLeft
			(localproc_0
				(localproc_1 130 168 168 135 136)
				(localproc_1 160 168 168 165 161)
			)
		)
		(= nsTop 45)
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 3 else 4)))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 3 else 4)))
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 23 else 24)))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 23 else 24)))
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 43 else 44)))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 43 else 44)))
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 63 else 64)))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 63 else 64)))
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 83 else 84)))
		(super show: &rest)
	)

	(method (init)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 83 else 84)))
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
		(= view (localproc_2))
		(= nsLeft (localproc_1 33 47 47 34 31))
		(= nsTop (+ 2 (if global159 83 else 84)))
		(super show: &rest)
	)
)

(instance iconOk of IconI
	(properties
		loop 8
		cel 0
		message 9
		signal 451
		helpStr {Exits this menu.}
	)

	(method (show)
		(= view (localproc_2))
		(= nsLeft (localproc_1 5 19 19 6 5))
		(= nsTop (+ 2 (if global159 103 else 104)))
		(super show: &rest)
	)
)

(instance helpCursor of KQCursor
	(properties
		number 70
	)

	(method (init)
		(if global400
			(self number: 70 yourself:)
		)
		(super init: &rest)
	)
)

