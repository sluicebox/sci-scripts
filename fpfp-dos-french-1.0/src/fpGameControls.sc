;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Slider)
(use GameControls)
(use Window)

(public
	fpGameControls 0
	gcWin 1
)

(local
	local0
	local1
	local2
)

(class FreddyControlIcon of ControlIcon
	(properties)

	(method (highlight param1 &tmp temp0)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(if (and argc param1)
			(= temp0 3)
		else
			(= temp0 0)
		)
		(DrawCel view loop temp0 nsLeft nsTop 15)
	)
)

(instance fpGameControls of GameControls
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
			eachElementDo: #highlightColor 40
			eachElementDo: #lowlightColor 0
			helpIconItem: iconHelp
			curIcon: iconSave
			state: 2048
			window: gcWin
		)
		(super init: &rest)
	)

	(method (show)
		(gGame setCursor: 997)
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

	(method (open &tmp temp0 [temp1 4] temp5 [temp6 20] temp26)
		(= local0 (proc0_16 117 113 117 113 113))
		(= local1 (- (/ (- 200 local0) 2) 5))
		(= local2 (+ local0 local1))
		(= type 128)
		(= left 51)
		(= top local1)
		(= right 268)
		(= bottom local2)
		(= lsLeft left)
		(= lsTop top)
		(= lsRight right)
		(= lsBottom bottom)
		(= priority 15)
		(= temp26 (PicNotValid))
		(PicNotValid 1)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(DrawCel 995 0 0 51 local1 temp5) ; UNINIT
		(DrawCel
			995
			2
			0
			(proc0_16 130 110 127 110 110)
			(proc0_16
				(+ local1 3)
				(- local2 12)
				(+ local1 3)
				(- local2 12)
				(- local2 12)
			)
			15
		)
		(DrawCel 995 2 1 (proc0_16 148 151 154 151 151) (- local2 12) 15)
		(DrawCel
			995
			2
			2
			(proc0_16 164 195 179 195 195)
			(proc0_16
				(+ local1 3)
				(- local2 12)
				(+ local1 3)
				(- local2 12)
				(- local2 12)
			)
			15
		)
		(DrawCel 995 2 3 (proc0_16 214 232 213 232 232) (- local2 12) 15)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(gGame setCursor: 999)
		(SetPort temp0)
		(PicNotValid temp26)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 1
		cel 4
		nsLeft 79
		signal 128
		noun 1
		modNum 24
		helpVerb 7
		sliderView 995
		sliderLoop 1
		bottomValue 1
		topValue 5
	)

	(method (show)
		(= nsTop (proc0_16 26 22 26 22 22))
		(= maxY 37)
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
		loop 1
		cel 5
		nsLeft 107
		signal 128
		noun 2
		modNum 24
		helpVerb 7
		sliderView 995
		sliderLoop 1
		sliderCel 1
		topValue 15
	)

	(method (show)
		(= nsTop (proc0_16 26 22 26 22 22))
		(= maxY 37)
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 1
		cel 6
		nsLeft 130
		signal 128
		noun 3
		modNum 24
		helpVerb 7
		sliderView 995
		sliderLoop 1
		sliderCel 2
		bottomValue 15
	)

	(method (show)
		(= nsTop (proc0_16 26 22 26 22 22))
		(= maxY 37)
		(if (not (gUser controls:))
			(= signal 132)
			(= sliderLoop 10)
		else
			(= sliderLoop 1)
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
		(gEgo moveSpeed:)
	)

	(method (mask))
)

(instance textSlider of Slider
	(properties
		view 995
		loop 1
		cel 7
		nsLeft 160
		signal 128
		noun 4
		modNum 24
		helpVerb 7
		sliderView 995
		sliderLoop 1
		sliderCel 3
		bottomValue 24
		topValue 1
	)

	(method (show)
		(= nsTop (proc0_16 26 22 26 22 22))
		(= maxY 37)
		(super show: &rest)
	)

	(method (doit param1)
		(if argc
			(= gTextSpeed param1)
		)
		(return gTextSpeed)
	)
)

(instance iconSave of FreddyControlIcon
	(properties
		view 995
		loop 3
		cel 0
		message 8
		signal 451
		noun 5
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 15 11 15 11 11))
		(= nsLeft (proc0_16 5 5 3 5 5))
		(super show: &rest)
	)
)

(instance iconRestore of FreddyControlIcon
	(properties
		view 995
		loop 4
		cel 0
		message 8
		signal 451
		noun 6
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 31 27 31 27 27))
		(= nsLeft (proc0_16 5 5 3 5 5))
		(super show: &rest)
	)
)

(instance iconRestart of FreddyControlIcon
	(properties
		view 995
		loop 5
		cel 0
		message 8
		signal 451
		noun 7
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 46 42 46 42 42))
		(= nsLeft (proc0_16 5 5 3 5 5))
		(super show: &rest)
	)
)

(instance iconQuit of FreddyControlIcon
	(properties
		view 995
		loop 6
		cel 0
		message 8
		signal 451
		noun 8
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 61 57 61 57 57))
		(= nsLeft (proc0_16 5 5 3 5 5))
		(super show: &rest)
	)
)

(instance iconAbout of FreddyControlIcon
	(properties
		view 995
		loop 7
		cel 0
		message 8
		signal 451
		noun 9
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 77 73 77 73 73))
		(= nsLeft (+ 2 (proc0_16 5 5 3 5 5)))
		(super show: &rest)
	)
)

(instance iconHelp of FreddyControlIcon
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 27
		cursor 9
		message 7
		signal 387
		noun 10
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 78 74 78 74 74))
		(super show: &rest)
	)
)

(instance iconOk of FreddyControlIcon
	(properties
		view 995
		loop 9
		cel 0
		cursor 9
		message 8
		signal 451
		noun 11
		modNum 24
		helpVerb 7
	)

	(method (show)
		(= nsTop (proc0_16 93 89 93 89 89))
		(= nsLeft (proc0_16 5 5 3 5 5))
		(super show: &rest)
	)
)

