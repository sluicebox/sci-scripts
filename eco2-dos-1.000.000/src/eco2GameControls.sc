;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Slider)
(use IconBar)
(use GameControls)
(use Window)

(public
	eco2GameControls 0
	gcWin 1
)

(instance eco2GameControls of GameControls
	(properties)

	(method (init)
		(= gGameControls self)
		(self
			add:
				iconOk
				detailSlider
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(speedSlider theObj: gEgo selector: #setSpeed yourself:)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			helpIconItem: iconHelp
			curIcon: iconSave
			state: 2048
			window: gcWin
		)
		(super init: &rest)
	)

	(method (show)
		(= gTheCursor 999)
		(super show: &rest)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 934)
		(DisposeScript 5)
	)
)

(instance gcWin of SysWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] temp5 [temp6 20])
		(= temp5 15)
		(= type 128)
		(= top (/ (- 200 (* (CelHigh 995 1 1) 3)) 2))
		(= left (/ (- 320 (* (CelWide 995 1 1) 4)) 2))
		(= bottom
			(+ (* (CelHigh 995 1 1) 3) (/ (- 200 (* (CelHigh 995 1 1) 3)) 2))
		)
		(= right
			(+ (* (CelWide 995 1 1) 4) (/ (- 320 (* (CelWide 995 1 1) 4)) 2))
		)
		(= lsLeft (- left 4))
		(= lsTop (- top 4))
		(= lsRight (+ right 4))
		(= lsBottom (+ bottom 4))
		(= priority temp5)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(DrawCel
			995
			10
			0
			(- (/ (- 320 (* (CelWide 995 1 1) 4)) 2) 4)
			(- (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) 4)
		)
		(DrawCel
			995
			13
			0
			(/ (- 320 (* (CelWide 995 1 1) 4)) 2)
			(- (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) 4)
		)
		(DrawCel
			995
			10
			1
			(+ (* (CelWide 995 1 1) 4) (/ (- 320 (* (CelWide 995 1 1) 4)) 2))
			(- (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) 4)
		)
		(DrawCel
			995
			12
			0
			(- (/ (- 320 (* (CelWide 995 1 1) 4)) 2) 4)
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
		)
		(DrawCel
			995
			1
			1
			(/ (- 320 (* (CelWide 995 1 1) 4)) 2)
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
			temp5
		)
		(DrawCel
			995
			1
			1
			(/ (- 320 (* (CelWide 995 1 1) 4)) 2)
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (CelHigh 995 1 1))
			temp5
		)
		(DrawCel
			995
			1
			1
			(/ (- 320 (* (CelWide 995 1 1) 4)) 2)
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (* (CelHigh 995 1 1) 2))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (CelWide 995 1 1))
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (CelWide 995 1 1))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (CelHigh 995 1 1))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (CelWide 995 1 1))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (* (CelHigh 995 1 1) 2))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 2))
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 2))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (CelHigh 995 1 1))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 2))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (* (CelHigh 995 1 1) 2))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 3))
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 3))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (CelHigh 995 1 1))
			temp5
		)
		(DrawCel
			995
			1
			1
			(+ (/ (- 320 (* (CelWide 995 1 1) 4)) 2) (* (CelWide 995 1 1) 3))
			(+ (/ (- 200 (* (CelHigh 995 1 1) 3)) 2) (* (CelHigh 995 1 1) 2))
			temp5
		)
		(DrawCel
			995
			12
			0
			(+ (* (CelWide 995 1 1) 4) (/ (- 320 (* (CelWide 995 1 1) 4)) 2))
			(/ (- 200 (* (CelHigh 995 1 1) 3)) 2)
		)
		(DrawCel
			995
			10
			3
			(- (/ (- 320 (* (CelWide 995 1 1) 4)) 2) 4)
			(+ (* (CelHigh 995 1 1) 3) (/ (- 200 (* (CelHigh 995 1 1) 3)) 2))
		)
		(DrawCel
			995
			11
			0
			(/ (- 320 (* (CelWide 995 1 1) 4)) 2)
			(+ (* (CelHigh 995 1 1) 3) (/ (- 200 (* (CelHigh 995 1 1) 3)) 2))
		)
		(DrawCel
			995
			10
			2
			(+ (* (CelWide 995 1 1) 4) (/ (- 320 (* (CelWide 995 1 1) 4)) 2))
			(+ (* (CelHigh 995 1 1) 3) (/ (- 200 (* (CelHigh 995 1 1) 3)) 2))
		)
		(DrawCel 995 1 0 125 85 temp5)
		(DrawCel 995 1 0 173 85 temp5)
		(DrawCel 995 1 0 223 85 temp5)
		(DrawCel 995 0 4 130 59 temp5)
		(DrawCel 995 0 3 177 59 temp5)
		(DrawCel 995 0 2 230 59 temp5)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 85
		nsTop 37
		signal 128
		noun 1
		modNum 5
		helpVerb 6
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

	(method (show)
		(if (not (gUser controls:))
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
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 134
		nsTop 37
		signal 128
		noun 2
		modNum 5
		helpVerb 6
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 183
		nsTop 37
		signal 128
		noun 3
		modNum 5
		helpVerb 6
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
			(= global136 param1)
		)
		(gEgo moveSpeed:)
	)

	(method (mask))
)

(instance iconSave of ControlIcon
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 9
		nsTop 8
		signal 451
		noun 4
		modNum 5
		helpVerb 6
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 9
		nsTop 26
		signal 451
		noun 5
		modNum 5
		helpVerb 6
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 9
		nsTop 44
		signal 451
		noun 6
		modNum 5
		helpVerb 6
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 9
		nsTop 62
		signal 451
		noun 7
		modNum 5
		helpVerb 6
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 9
		nsTop 80
		signal 451
		noun 8
		modNum 5
		helpVerb 6
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 37
		nsTop 80
		cursor 9
		message 6
		signal 387
		noun 9
		modNum 5
		helpVerb 6
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 9
		nsTop 98
		signal 451
		noun 10
		modNum 5
		helpVerb 6
	)
)

