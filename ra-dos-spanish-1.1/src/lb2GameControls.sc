;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Slider)
(use IconBar)
(use GameControls)
(use Window)

(public
	lb2GameControls 0
	gcWin 1
)

(instance lb2GameControls of GameControls
	(properties)

	(method (init)
		(= gGameControls self)
		(self
			add:
				iconOk
				detailSlider
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(speedSlider theObj: gEgo selector: #setSpeed yourself:)
				textSlider
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
			eachElementDo: #highlightColor global169
			eachElementDo: #lowlightColor global151
			helpIconItem: iconHelp
			curIcon: iconSave
			state: 2048
			window: gcWin
		)
		(super init: &rest)
	)

	(method (show)
		(gGame setCursor: 999)
		(super show: &rest)
	)

	(method (dispose)
		(super dispose:)
		(gGame setCursor: gNormalCursor)
		(DisposeScript 934)
		(DisposeScript 978)
		(DisposeScript 24)
	)
)

(instance gcWin of SysWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] temp5 [temp6 20])
		(= type 128)
		(= top (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2))
		(= left (/ (- 320 (+ 191 (CelWide 995 0 1))) 2))
		(= bottom (+ (CelHigh 995 1 1) 6 (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)))
		(= right
			(+ 191 (CelWide 995 0 1) (/ (- 320 (+ 191 (CelWide 995 0 1))) 2))
		)
		(= lsLeft (- left 6))
		(= lsTop (- top 6))
		(= lsRight (+ right 6))
		(= lsBottom (+ bottom 6))
		(= priority 15)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX top left bottom right 3 global151 15)
		(Graph grDRAW_LINE 33 49 33 269 global171 15)
		(Graph grDRAW_LINE 34 50 34 268 global168 15)
		(Graph grDRAW_LINE 35 51 35 267 global170 15)
		(Graph grDRAW_LINE 33 49 166 49 global171 15)
		(Graph grDRAW_LINE 34 50 165 50 global168 15)
		(Graph grDRAW_LINE 35 51 164 51 global170 15)
		(Graph grDRAW_LINE 166 49 166 269 global171 15)
		(Graph grDRAW_LINE 165 50 165 268 global168 15)
		(Graph grDRAW_LINE 164 51 164 267 global170 15)
		(Graph grDRAW_LINE 33 269 166 269 global171 15)
		(Graph grDRAW_LINE 34 268 165 268 global168 15)
		(Graph grDRAW_LINE 35 267 164 267 global170 15)
		(DrawCel 995 0 6 155 (Localize 42 45 45 45 45) temp5) ; UNINIT
		(DrawCel 995 1 1 56 39 temp5) ; UNINIT
		(DrawCel 995 1 0 146 73 temp5) ; UNINIT
		(DrawCel 995 1 0 186 73 temp5) ; UNINIT
		(DrawCel 995 1 0 226 73 temp5) ; UNINIT
		(DrawCel 995 0 4 116 (Localize 58 60 60 60 60) temp5) ; UNINIT
		(DrawCel
			995
			0
			3
			(Localize 145 154 154 154 154)
			(Localize 134 60 60 60 60)
			temp5 ; UNINIT
		)
		(DrawCel
			995
			0
			2
			(Localize 178 198 198 198 198)
			(Localize 58 60 60 60 60)
			temp5 ; UNINIT
		)
		(DrawCel 995 0 5 238 (Localize 134 60 60 60 60) temp5) ; UNINIT
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 67
		nsTop 35
		signal 128
		noun 1
		modNum 24
		helpVerb 12
		sliderView 995
		bottomValue 1
		topValue 5
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
		nsLeft 107
		nsTop 35
		signal 128
		noun 2
		modNum 24
		helpVerb 12
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 147
		nsTop 35
		signal 128
		noun 3
		modNum 24
		helpVerb 12
		sliderView 995
		bottomValue 15
	)

	(method (show)
		(if (not (gUser controls:))
			(= signal 132)
			(= sliderLoop 9)
		else
			(= sliderLoop 0)
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
			(= gSpeed param1)
		)
		(gEgo moveSpeed:)
	)

	(method (mask))
)

(instance textSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 187
		nsTop 35
		signal 128
		noun 4
		modNum 24
		helpVerb 12
		sliderView 995
		bottomValue 24
		topValue 1
	)

	(method (doit param1)
		(if argc
			(= gTextSpeed param1)
		)
		(return gTextSpeed)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 8
		nsTop 8
		message 8
		signal 451
		noun 5
		modNum 24
		helpVerb 12
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 8
		nsTop 28
		message 8
		signal 451
		noun 6
		modNum 24
		helpVerb 12
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 8
		nsTop 48
		message 8
		signal 451
		noun 7
		modNum 24
		helpVerb 12
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 8
		nsTop 68
		message 8
		signal 451
		noun 8
		modNum 24
		helpVerb 12
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 8
		nsTop 88
		message 8
		signal 451
		noun 9
		modNum 24
		helpVerb 12
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 34
		nsTop 88
		cursor 9
		message 12
		signal 387
		noun 10
		modNum 24
		helpVerb 12
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 8
		nsTop 108
		cursor 9
		message 8
		signal 451
		noun 11
		modNum 24
		helpVerb 12
	)
)

