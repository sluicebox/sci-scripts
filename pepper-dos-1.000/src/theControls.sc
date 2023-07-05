;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 888)
(include sci.sh)
(use Main)
(use Slider)
(use GameControls)
(use Window)

(public
	theControls 0
	gcWin 1
)

(class TwistyControlIcon of ControlIcon
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

	(method (show)
		(self view: (if (FileIO fiEXISTS {CDAUDIO}) 1904 else 904))
		(super show: &rest)
	)

	(method (showMode &tmp temp0)
		(= temp0 (GetPort))
		(SetPort 0)
		(switch gMsgType
			(1
				(= gMsgType 2)
				(DrawCel 1904 10 1 204 163 -1 0)
				(DrawCel 1904 10 2 144 162 -1 0)
			)
			(2
				(= gMsgType 1)
				(DrawCel 1904 10 0 144 162 -1 0)
				(DrawCel 1904 10 3 204 163 -1 0)
			)
		)
		(SetPort temp0)
	)
)

(instance gcWin of SysWindow
	(properties)

	(method (open &tmp temp0 [temp1 2])
		(= priority 13)
		(self
			top:
				(+
					(-
						(/
							(-
								200
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelHigh 1908 0 0)
								else
									(CelHigh 908 0 0)
								)
							)
							2
						)
						1
					)
					25
				)
			left:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					9
				)
			bottom:
				(-
					(+
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						(if (FileIO fiEXISTS {CDAUDIO})
							(CelHigh 1908 0 0)
						else
							(CelHigh 908 0 0)
						)
						1
					)
					4
				)
			right:
				(-
					(+
						(-
							(/
								(-
									320
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelWide 1908 0 0)
									else
										(CelWide 908 0 0)
									)
								)
								2
							)
							1
						)
						(if (FileIO fiEXISTS {CDAUDIO})
							(CelWide 1908 0 0)
						else
							(CelWide 908 0 0)
						)
						1
					)
					9
				)
			lsTop:
				(-
					(/
						(-
							200
							(if (FileIO fiEXISTS {CDAUDIO})
								(CelHigh 1908 0 0)
							else
								(CelHigh 908 0 0)
							)
						)
						2
					)
					1
				)
			lsLeft:
				(-
					(/
						(-
							320
							(if (FileIO fiEXISTS {CDAUDIO})
								(CelWide 1908 0 0)
							else
								(CelWide 908 0 0)
							)
						)
						2
					)
					1
				)
			lsBottom:
				(+
					(-
						(/
							(-
								200
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelHigh 1908 0 0)
								else
									(CelHigh 908 0 0)
								)
							)
							2
						)
						1
					)
					(if (FileIO fiEXISTS {CDAUDIO})
						(CelHigh 1908 0 0)
					else
						(CelHigh 908 0 0)
					)
					1
				)
			lsRight:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					(if (FileIO fiEXISTS {CDAUDIO})
						(CelWide 1908 0 0)
					else
						(CelWide 908 0 0)
					)
					1
				)
		)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(if (FileIO fiEXISTS {CDAUDIO})
			(DrawCel
				1908
				0
				0
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					1
				)
				(+
					(-
						(/
							(-
								200
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelHigh 1908 0 0)
								else
									(CelHigh 908 0 0)
								)
							)
							2
						)
						1
					)
					1
				)
				15
				0
			)
		else
			(DrawCel
				908
				0
				0
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					1
				)
				(+
					(-
						(/
							(-
								200
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelHigh 1908 0 0)
								else
									(CelHigh 908 0 0)
								)
							)
							2
						)
						1
					)
					1
				)
				15
			)
		)
		(cond
			((and (FileIO fiEXISTS {CDAUDIO}) (== gMsgType 1))
				(DrawCel 1904 10 0 144 162 -1 0)
			)
			((FileIO fiEXISTS {CDAUDIO})
				(DrawCel 1904 10 1 204 163 -1 0)
			)
		)
		(SetPort temp0)
	)
)

(instance theControls of GameControls
	(properties)

	(method (show)
		(self init: 0)
		(= global224 ((ScriptID 895 0) view:)) ; pepper
		((ScriptID 895 0) view: 2000) ; pepper
		(UnLoad 128 ((ScriptID 895 0) view:)) ; pepper
		(super show: &rest)
	)

	(method (init param1)
		(super init: &rest)
		(gcWin color: 16 back: 16)
		((= gGameControls self)
			window: gcWin
			add:
				textSlider
				(detailSlider theObj: gGame selector: #detailLevel yourself:)
				(speedSlider theObj: gEgo selector: #setSpeed yourself:)
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout selector: #doit yourself:)
				iconHelp
				iconOk
			helpIconItem: iconHelp
			curIcon: iconRestore
			state: 2048
			eachElementDo: #highlightColor global126
			eachElementDo: #lowlightColor global122
		)
		(if (FileIO fiEXISTS {CDAUDIO})
			(theControls addAfter: iconAbout iconMode)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 888)
	)

	(method (hide)
		((ScriptID 895 0) view: global224) ; pepper
		(super hide: &rest)
	)
)

(instance detailSlider of Slider
	(properties
		view 904
		loop 9
		cel 1
		signal 128
		noun 2
		helpVerb 83
		sliderView 904
		sliderLoop 1
		sliderCel 1
		yStep 2
		topValue 3
	)

	(method (show)
		(self
			view: (if (FileIO fiEXISTS {CDAUDIO}) 1904 else 904)
			nsLeft:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					66
				)
			nsTop:
				(if (FileIO fiEXISTS {CDAUDIO})
					(+
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						4
					)
				else
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						9
					)
				)
		)
		(super show: &rest)
	)
)

(instance volumeSlider of Slider
	(properties
		view 904
		loop 9
		cel 3
		signal 128
		noun 10
		helpVerb 83
		sliderView 904
		sliderLoop 1
		sliderCel 3
		yStep 2
		topValue 15
	)

	(method (show)
		(self
			view: (if (FileIO fiEXISTS {CDAUDIO}) 1904 else 904)
			nsLeft:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					127
				)
			nsTop:
				(if (FileIO fiEXISTS {CDAUDIO})
					(+
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						4
					)
				else
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						9
					)
				)
		)
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		view 904
		loop 9
		cel 2
		signal 128
		noun 9
		helpVerb 83
		sliderView 904
		sliderLoop 1
		sliderCel 2
		yStep 2
		bottomValue 15
	)

	(method (show)
		(self
			view: (if (FileIO fiEXISTS {CDAUDIO}) 1904 else 904)
			nsLeft:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					97
				)
			nsTop:
				(if (FileIO fiEXISTS {CDAUDIO})
					(+
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						4
					)
				else
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						9
					)
				)
		)
		(super show: &rest)
	)

	(method (doit param1)
		(if argc
			(gEgo setSpeed: param1)
			(= global197 param1)
		)
		(gEgo moveSpeed:)
	)
)

(instance textSlider of Slider
	(properties
		view 904
		loop 9
		cel 0
		signal 128
		noun 36
		helpVerb 83
		sliderView 904
		sliderLoop 1
		yStep 2
		bottomValue 15
	)

	(method (doit param1)
		(if argc
			(= gTextSpeed param1)
		)
		(return gTextSpeed)
	)

	(method (show)
		(self
			view: (if (FileIO fiEXISTS {CDAUDIO}) 1904 else 904)
			nsLeft:
				(+
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					35
				)
			nsTop:
				(if (FileIO fiEXISTS {CDAUDIO})
					(+
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						4
					)
				else
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						9
					)
				)
		)
		(super show: &rest)
	)
)

(instance iconSave of TwistyControlIcon
	(properties
		view 904
		loop 2
		cel 0
		message 8
		signal 451
		noun 8
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(if (FileIO fiEXISTS {CDAUDIO})
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						13
					)
				else
					(-
						(-
							(/
								(-
									200
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelHigh 1908 0 0)
									else
										(CelHigh 908 0 0)
									)
								)
								2
							)
							1
						)
						23
					)
				)
		)
		(super show: &rest)
	)
)

(instance iconRestore of TwistyControlIcon
	(properties
		view 904
		loop 3
		cel 0
		message 8
		signal 451
		noun 7
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					19
				)
		)
		(super show: &rest)
	)
)

(instance iconRestart of TwistyControlIcon
	(properties
		view 904
		loop 4
		cel 0
		signal 451
		noun 6
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					38
				)
		)
		(super show: &rest)
	)
)

(instance iconQuit of TwistyControlIcon
	(properties
		view 904
		loop 5
		cel 0
		message 8
		signal 451
		noun 5
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					57
				)
		)
		(super show: &rest)
	)
)

(instance iconAbout of TwistyControlIcon
	(properties
		view 904
		loop 6
		cel 0
		message 8
		signal 451
		noun 1
		helpVerb 83
	)

	(method (select)
		(if (super select: &rest)
			((ScriptID 884 0) doit:) ; aboutScript
		)
		(return 1)
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					76
				)
		)
		(super show: &rest)
	)
)

(instance iconHelp of TwistyControlIcon
	(properties
		view 904
		loop 7
		cel 0
		cursor 990
		message 83
		signal 387
		noun 3
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(+
					(-
						(-
							(/
								(-
									320
									(if (FileIO fiEXISTS {CDAUDIO})
										(CelWide 1908 0 0)
									else
										(CelWide 908 0 0)
									)
								)
								2
							)
							1
						)
						27
					)
					(CelWide 904 6 0)
					2
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					76
				)
		)
		(super show: &rest)
	)
)

(instance iconOk of TwistyControlIcon
	(properties
		view 904
		loop 8
		cel 0
		message 8
		signal 451
		noun 4
		helpVerb 83
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					95
				)
		)
		(super show: &rest)
	)
)

(instance iconMode of TwistyControlIcon
	(properties
		view 1904
		loop 11
		cel 0
		message 8
		signal 387
		noun 4
		helpVerb 83
	)

	(method (select &tmp temp0)
		(super select: &rest)
		(self showMode:)
		(DrawCel view loop 3 nsLeft nsTop 15)
	)

	(method (show)
		(self
			nsLeft:
				(-
					(-
						(/
							(-
								320
								(if (FileIO fiEXISTS {CDAUDIO})
									(CelWide 1908 0 0)
								else
									(CelWide 908 0 0)
								)
							)
							2
						)
						1
					)
					27
				)
			nsTop:
				(+
					(if (FileIO fiEXISTS {CDAUDIO})
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							13
						)
					else
						(-
							(-
								(/
									(-
										200
										(if (FileIO fiEXISTS {CDAUDIO})
											(CelHigh 1908 0 0)
										else
											(CelHigh 908 0 0)
										)
									)
									2
								)
								1
							)
							23
						)
					)
					114
					1
				)
		)
		(super show: &rest)
	)
)

