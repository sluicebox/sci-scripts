;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 903)
(include sci.sh)
(use Main)
(use EgoGroop)
(use Kq6Window)
(use Print)
(use Slider)
(use IconBar)
(use GameControls)
(use System)

(public
	kq6Controls 0
)

(local
	local0
)

(instance kq6Controls of GameControls
	(properties)

	(method (init)
		(Load rsVIEW 946)
		(= gGameControls self)
		(self
			window:
				(controlWin
					top: (- (/ (- 200 (+ (CelHigh 946 1 1) 6)) 2) 10)
					left: (- (/ (- 320 (+ 151 (CelWide 946 0 1) 0)) 2) 10)
					bottom:
						(+
							(CelHigh 946 1 1)
							6
							(/ (- 200 (+ (CelHigh 946 1 1) 6)) 2)
							10
						)
					right:
						(+
							151
							(CelWide 946 0 1)
							0
							(/ (- 320 (+ 151 (CelWide 946 0 1) 0)) 2)
							10
						)
					back: 44
					yourself:
				)
			add:
				iconOk
				(iconSave init: theObj: gGame selector: #save yourself:)
				(iconRestore init: theObj: gGame selector: #restore yourself:)
				(iconRestart init: theObj: gGame selector: #restart yourself:)
				(iconQuit init: theObj: gGame selector: #quitGame yourself:)
				(iconAbout init: selector: #doit yourself:)
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
				(speedSlider init: theObj: 0 selector: #y yStep: 2 yourself:)
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 44
			curIcon: iconRestore
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 934)
		(DisposeScript 903)
	)
)

(instance controlWin of Kq6Window
	(properties)

	(method (open &tmp temp0 [temp1 49] temp50 temp51 temp52 temp53)
		(super open: &rest)
		(= local0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel
			946
			0
			7
			(-
				(+
					(/
						(-
							(-
								(+ 151 (CelWide 946 0 1) 0)
								(+ 4 (CelWide 946 1 1))
							)
							(CelWide 946 0 5)
						)
						2
					)
					4
					(CelWide 946 1 1)
				)
				5
			)
			12
			-1
			0
		)
		(DrawCel 946 1 1 14 14 -1 0)
		(DrawCel 946 1 0 104 63 -1 0)
		(DrawCel 946 1 0 145 63 -1 0)
		(DrawCel 946 0 4 73 (+ (- 37 (+ (CelHigh 946 0 4) 3)) 25) -1 0)
		(DrawCel 946 0 3 111 (+ (- 37 (+ (CelHigh 946 0 4) 3)) 25) -1 0)
		(DrawCel 946 0 2 156 (+ (- 37 (+ (CelHigh 946 0 4) 3)) 25) -1 0)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX top left bottom right 1)
		(SetPort temp0)
		(= temp53 gScore)
		(DrawCel
			946
			9
			0
			(+
				(/
					(-
						(-
							(+ 151 (CelWide 946 0 1) 0)
							(+ 10 (CelWide 946 1 1) 6)
						)
						[temp1 3] ; UNINIT
					)
					2
				)
				37
			)
			(+ 46 (CelHigh 946 0 1) 3 20)
			-1
			0
		)
		(= temp51 93)
		(for ((= temp52 0)) (< temp52 3) ((++ temp52))
			(-= temp51 7)
			(if (and (== temp52 2) (== (mod temp53 10) 0) (not (== gScore 0)))
				(= temp50 11)
			else
				(= temp50 (mod temp53 10))
			)
			(/= temp53 10)
			(DrawCel
				946
				10
				temp50
				(+
					(/
						(-
							(-
								(+ 151 (CelWide 946 0 1) 0)
								(+ 10 (CelWide 946 1 1) 6)
							)
							[temp1 3] ; UNINIT
						)
						2
					)
					temp51
				)
				(+ 46 (CelHigh 946 0 1) 3 20)
				-1
				0
			)
		)
		(DrawCel
			946
			10
			10
			(+
				(/
					(-
						(-
							(+ 151 (CelWide 946 0 1) 0)
							(+ 10 (CelWide 946 1 1) 6)
						)
						[temp1 3] ; UNINIT
					)
					2
				)
				93
			)
			(+ 46 (CelHigh 946 0 1) 3 20)
			-1
			0
		)
		(= temp51 123)
		(= temp53 gPossibleScore)
		(for ((= temp52 0)) (< temp52 3) ((++ temp52))
			(-= temp51 7)
			(= temp50 (mod temp53 10))
			(/= temp53 10)
			(DrawCel
				946
				10
				temp50
				(+
					(/
						(-
							(-
								(+ 151 (CelWide 946 0 1) 0)
								(+ 10 (CelWide 946 1 1) 6)
							)
							[temp1 3] ; UNINIT
						)
						2
					)
					temp51
				)
				(+ 46 (CelHigh 946 0 1) 3 20)
				-1
				0
			)
		)
		(gGame setCursor: gNormalCursor)
	)
)

(instance detailSlider of Slider
	(properties
		view 946
		loop 0
		cel 1
		signal 128
		sliderView 946
		topValue 3
	)

	(method (show)
		(= nsLeft 77)
		(= nsTop 62)
		(= sRight 0)
		(super show: &rest)
	)
)

(instance volumeSlider of Slider
	(properties
		view 946
		loop 0
		cel 1
		signal 128
		sliderView 946
		topValue 15
	)

	(method (show)
		(= view 946)
		(= nsLeft 117)
		(= sliderView 946)
		(= nsTop 62)
		(= sRight 0)
		(super show: &rest)
	)

	(method (doit param1)
		(if theObj
			(if (!= (Eval theObj selector) param1)
				(Eval theObj selector param1 &rest)
			else
				(Eval theObj selector)
			)
		)
	)
)

(instance speedSlider of Slider
	(properties
		view 946
		loop 0
		cel 1
		signal 128
		sliderView 946
		bottomValue 15
	)

	(method (show)
		(if (and (gEgo looper:) (== (gEgo looper:) EgoGroop))
			(= topValue ((gEgo looper:) speedState:))
			(= bottomValue (+ topValue 15))
		else
			(= topValue 0)
			(= bottomValue 15)
		)
		(= nsLeft 157)
		(= nsTop 62)
		(= sRight 0)
		(super show: &rest)
	)

	(method (doit param1)
		(if argc
			(gEgo currentSpeed: param1)
			(gEgo setSpeed: (gEgo currentSpeed:))
		)
		(gEgo currentSpeed:)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 946
		loop 2
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 3 else 4) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 3 else 4) 10))
		(super init: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 946
		loop 3
		cel 0
		message 0
		signal 451
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 23 else 24) 10))
		(super init: &rest)
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 23 else 24) 10))
		(super show: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 946
		loop 4
		cel 0
		message 0
		signal 451
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 43 else 44) 10))
		(super init: &rest)
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 43 else 44) 10))
		(super show: &rest)
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 946
		loop 5
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 63 else 64) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 63 else 64) 10))
		(super init: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 946
		loop 6
		cel 0
		message 0
		signal 449
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 83 else 84) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 83 else 84) 10))
		(super init: &rest)
	)

	(method (select)
		(super select: &rest)
		(gGameControls hide:)
		(if (gCurRoom script:)
			(Print font: gUserFont addText: 7 0 16 0 1 0 0 0 init:) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
		else
			(gCurRoom setScript: 905) ; aboutCode
		)
	)
)

(instance iconOk of IconI
	(properties
		view 946
		loop 8
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 3 (if (== global107 256) 103 else 104) 10))
		(super show: &rest)
	)
)

(instance helpCursor of Cursor ; UNUSED
	(properties
		view 998
		loop 1
		cel 4
	)
)

