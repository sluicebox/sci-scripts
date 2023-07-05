;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 903)
(include sci.sh)
(use Main)
(use EgoGroop)
(use KQ6Print)
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
	local1
)

(instance kq6Controls of GameControls
	(properties)

	(method (init)
		(Load rsVIEW 947)
		(= local1 ((gTheIconBar curIcon:) cursor:))
		(gTheIconBar disable:)
		(= gGameControls self)
		(self
			window:
				(controlWin
					top: (- (/ (- 200 (+ (CelHigh 947 1 1) 0)) 2) 15)
					left: (- (/ (- 320 (+ 151 (CelWide 947 0 1) 0)) 2) 10)
					bottom:
						(-
							(+
								(CelHigh 947 1 1)
								0
								(/ (- 200 (+ (CelHigh 947 1 1) 0)) 2)
								10
							)
							5
						)
					right:
						(+
							151
							(CelWide 947 0 1)
							0
							(/ (- 320 (+ 151 (CelWide 947 0 1) 0)) 2)
							10
						)
					back: 19
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
			eachElementDo: #lowlightColor 19
			curIcon: iconRestore
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 934)
		(DisposeScript 903)
		(gGame setCursor: local1)
		(gTheIconBar enable:)
	)
)

(instance controlWin of Kq6Window
	(properties)

	(method (open &tmp temp0 [temp1 49] temp50 temp51 temp52 temp53)
		(super open: &rest)
		(= priority -1)
		(= local0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel
			947
			0
			7
			(-
				(+
					(/
						(-
							(-
								(+ 151 (CelWide 947 0 1) 0)
								(+ 4 (CelWide 947 1 1))
							)
							(CelWide 947 0 5)
						)
						2
					)
					4
					(CelWide 947 1 1)
				)
				35
			)
			12
			-1
			0
		)
		(DrawCel 947 1 1 14 11 -1 0)
		(DrawCel 947 1 0 104 63 -1 0)
		(DrawCel 947 1 0 145 63 -1 0)
		(DrawCel 947 0 4 73 (+ (- 37 (+ (CelHigh 947 0 4) 0)) 24) -1 0)
		(DrawCel 947 0 3 111 (+ (- 37 (+ (CelHigh 947 0 4) 0)) 24) -1 0)
		(DrawCel 947 0 2 156 (+ (- 37 (+ (CelHigh 947 0 4) 0)) 24) -1 0)
		(PicNotValid local0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX top left bottom right 1)
		(SetPort temp0)
		(= temp53 gScore)
		(DrawCel
			947
			10
			0
			(+
				(/ (- (+ 151 (CelWide 947 0 1) 0) (+ 10 (CelWide 947 1 1) 6)) 2)
				37
			)
			(+ 46 (CelHigh 947 0 1) 3 17)
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
				947
				11
				temp50
				(+
					(/
						(-
							(+ 151 (CelWide 947 0 1) 0)
							(+ 10 (CelWide 947 1 1) 6)
						)
						2
					)
					temp51
				)
				(+ 46 (CelHigh 947 0 1) 3 17)
				-1
				0
			)
		)
		(DrawCel
			947
			11
			10
			(+
				(/ (- (+ 151 (CelWide 947 0 1) 0) (+ 10 (CelWide 947 1 1) 6)) 2)
				93
			)
			(+ 46 (CelHigh 947 0 1) 3 17)
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
				947
				11
				temp50
				(+
					(/
						(-
							(+ 151 (CelWide 947 0 1) 0)
							(+ 10 (CelWide 947 1 1) 6)
						)
						2
					)
					temp51
				)
				(+ 46 (CelHigh 947 0 1) 3 17)
				-1
				0
			)
		)
		(gGame setCursor: gNormalCursor)
	)

	(method (showMode &tmp temp0 [temp1 4])
		(if global83
			(= temp0 2)
		else
			(= temp0 1)
		)
		(DrawCel
			947
			12
			temp0
			(+
				(/ (- (+ 151 (CelWide 947 0 1) 0) (+ 10 (CelWide 947 1 1) 6)) 2)
				65
			)
			(+ 46 (CelHigh 947 0 1) 3 30)
			-1
			0
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		signal 128
		sliderView 947
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
		view 947
		loop 0
		cel 1
		signal 128
		sliderView 947
		topValue 15
	)

	(method (show)
		(= view 947)
		(= nsLeft 117)
		(= sliderView 947)
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
		view 947
		loop 0
		cel 1
		signal 128
		sliderView 947
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
		view 947
		loop 2
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 3 else 4) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 3 else 4) 10))
		(super init: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		message 0
		signal 451
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 23 else 24) 10))
		(super init: &rest)
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 23 else 24) 10))
		(super show: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		message 0
		signal 451
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 43 else 44) 10))
		(super init: &rest)
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 43 else 44) 10))
		(super show: &rest)
	)
)

(instance iconTextSwitch of ControlIcon ; UNUSED
	(properties
		view 947
		loop 11
		cel 0
		signal 387
	)

	(method (show &tmp [temp0 59])
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 103 else 104) 10))
		(switch gMsgType
			(1
				(= global83 0)
			)
			(2
				(= global83 1)
			)
		)
		(super show: &rest)
	)

	(method (doit)
		(if 1
			(switch gMsgType
				(1
					(= gMsgType 2)
				)
				(2
					(= gMsgType 1)
				)
			)
		else
			(Print
				font: gUserFont
				addText: {*** You not playing a cd you fok!}
				init:
			)
		)
		(self show:)
		(controlWin showMode:)
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 63 else 64) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 63 else 64) 10))
		(super init: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		message 0
		signal 449
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 83 else 84) 10))
		(super show: &rest)
	)

	(method (init)
		(= nsLeft 18)
		(= nsTop (+ 0 (if (== global107 256) 83 else 84) 10))
		(super init: &rest)
	)

	(method (select)
		(super select: &rest)
		(gGameControls hide:)
		(if (gCurRoom script:)
			(KQ6Print font: gUserFont say: 7 0 16 0 1 0 0 0 init:) ; MISSING MESSAGE
		else
			(gCurRoom setScript: 905) ; aboutCode
		)
	)
)

(instance iconOk of IconI
	(properties
		view 947
		loop 7
		cel 0
		message 0
		signal 451
	)

	(method (show)
		(= nsLeft 18)
		(= nsTop (- (+ 0 (if (== global107 256) 123 else 124)) 10))
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

