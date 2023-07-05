;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Slider)
(use IconBar)
(use GameControls)
(use User)

(public
	controlPanel 0
)

(instance controlPanel of GameControls
	(properties)

	(method (init)
		(= window gcWin)
		(self
			add:
				detailSlider
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(speedSlider theObj: gGame selector: #setSpeed yourself:)
				arcadeSlider
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: gGame selector: #showAbout yourself:)
				iconHelp
				iconOk
		)
		(self eachElementDo: #highlightColor -1)
		(self eachElementDo: #lowlightColor -1)
		(= helpIconItem iconHelp)
		(= curIcon iconRestore)
		(= state 2048)
	)
)

(instance gcWin of GloryWindow
	(properties)

	(method (open &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 [temp8 4] temp12 temp13 [temp14 25] [temp39 4])
		(= temp12 -1)
		(= top (/ (- 200 (+ (CelHigh 933 1 1) 6)) 2))
		(= left (/ (- 320 (+ 184 (CelWide 933 0 1))) 2))
		(= bottom (+ (CelHigh 933 1 1) 6 (/ (- 200 (+ (CelHigh 933 1 1) 6)) 2)))
		(= right
			(+ 184 (CelWide 933 0 1) (/ (- 320 (+ 184 (CelWide 933 0 1))) 2))
		)
		(= priority temp12)
		(super open:)
		(DrawCel 933 1 1 4 3 temp12)
		(DrawCel 933 1 0 95 28 temp12)
		(DrawCel 933 1 0 131 28 temp12)
		(DrawCel 933 1 0 167 28 temp12)
		(DrawCel 933 0 2 136 (- 24 (+ (CelHigh 933 0 4) 3)) temp12)
		(DrawCel 933 0 3 100 (- 24 (+ (CelHigh 933 0 4) 3)) temp12)
		(DrawCel 933 0 4 64 (- 24 (+ (CelHigh 933 0 4) 3)) temp12)
		(DrawCel 933 0 5 173 (- 24 (+ (CelHigh 933 0 4) 3)) temp12)
		(= temp5 (+ (= temp2 (+ 31 (CelHigh 933 0 1))) 20))
		(= temp4
			(+
				(= temp3 (+ 4 (CelWide 933 1 1)))
				(- (+ 184 (CelWide 933 0 1)) (+ 4 (CelWide 933 1 1) 10))
			)
		)
		(= temp6 22)
		(= temp7 1)
		(Message msgGET 25 16 0 1 1 @temp14) ; "GAME PAUSED"
		(TextSize @temp39 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			123
			dsCOLOR
			30
			dsCOORD
			(- (+ (CelWide 933 0 5) 4 (CelWide 933 1 1)) 30)
			(- (+ 31 (CelHigh 933 0 1) 7) 2)
		)
		(Display
			@temp14
			dsFONT
			123
			dsCOLOR
			25
			dsCOORD
			(- (+ (CelWide 933 0 5) 4 (CelWide 933 1 1)) 31)
			(- (+ 31 (CelHigh 933 0 1) 7) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 933
		loop 0
		cel 1
		nsLeft 67
		nsTop 24
		signal 128
		noun 15
		modNum 25
		helpVerb 9
		sliderView 933
		yStep 2
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
		view 933
		loop 0
		cel 1
		nsLeft 103
		nsTop 24
		signal 128
		noun 24
		modNum 25
		helpVerb 9
		sliderView 933
		yStep 2
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 933
		loop 0
		cel 1
		nsLeft 139
		nsTop 24
		signal 128
		noun 23
		modNum 25
		helpVerb 9
		sliderView 933
		yStep 2
		bottomValue 15
	)

	(method (show)
		(if (or (not (User controls:)) (IsFlag 119))
			(= signal 132)
			(= sliderLoop 9)
		else
			(= sliderLoop 0)
			(= signal 128)
		)
		(super show: &rest)
	)

	(method (move)
		(if (and (User controls:) (not (IsFlag 119)))
			(super move: &rest)
		)
	)

	(method (mask))
)

(instance arcadeSlider of Slider
	(properties
		view 933
		loop 0
		cel 1
		nsLeft 174
		nsTop 24
		signal 128
		noun 4
		modNum 25
		helpVerb 9
		sliderView 933
		yStep 2
		bottomValue 1
		topValue 15
	)

	(method (doit param1)
		(if argc
			(= global209 (/ (+ param1 4) 5))
		)
		(return (* (- global209 1) 8))
	)
)

(instance iconSave of ControlIcon
	(properties
		view 933
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 10
		signal 451
		noun 22
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 933
		loop 3
		cel 0
		nsLeft 8
		nsTop 23
		message 10
		signal 451
		noun 21
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 933
		loop 4
		cel 0
		nsLeft 8
		nsTop 40
		message 10
		signal 451
		noun 20
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 933
		loop 5
		cel 0
		nsLeft 8
		nsTop 57
		message 10
		signal 451
		noun 19
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 933
		loop 6
		cel 0
		nsLeft 8
		nsTop 74
		message 10
		signal 451
		noun 16
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconHelp of IconI
	(properties
		view 933
		loop 7
		cel 0
		nsLeft 8
		nsTop 91
		cursor 949
		message 9
		signal 387
		noun 17
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

(instance iconOk of IconI
	(properties
		view 933
		loop 8
		cel 0
		nsLeft 8
		nsTop 108
		cursor 949
		message 9
		signal 451
		noun 18
		modNum 25
		helpVerb 9
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)
)

