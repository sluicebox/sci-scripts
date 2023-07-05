;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Print)
(use Slider)
(use BorderWindow)
(use IconBar)
(use GameControls)
(use System)

(public
	controlBox 0
)

(instance controlBox of GameControls
	(properties
		state 3072
	)

	(method (init)
		(self
			window: gcWin
			add:
				(iconOk theObj: callInfo selector: #init yourself:)
				(difficultySlider
					theObj: gGame
					selector: #detailLevel
					topValue: 14
					bottomValue: 0
					yStep: 5
					yourself:
				)
				(volumeSlider
					theObj: gGame
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: aboutCode selector: #doit yourself:)
				iconHelp
		)
		(self
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 27
			eachElementDo: #helpVerb 39
			eachElementDo: #modNum 1
			helpIconItem: iconHelp
		)
		(self curIcon: iconRestore)
	)

	(method (dispatchEvent event)
		(if
			(or
				(>
					(event x:)
					(-
						(+
							144
							(CelWide 947 0 1)
							(/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
						)
						(/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
					)
				)
				(>
					(event y:)
					(-
						(+
							(CelHigh 947 1 1)
							6
							(/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
						)
						(/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
					)
				)
			)
			(self hide:)
		)
		(super dispatchEvent: event)
	)
)

(instance difficultySlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 80
		nsTop 37
		signal 128
		noun 39
		sliderView 947
		topValue 14
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 136
		nsTop 37
		signal 128
		noun 40
		sliderView 947
		topValue 15
	)
)

(instance iconSave of ControlIcon
	(properties
		view 947
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		signal 451
		noun 34
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		signal 451
		noun 35
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		signal 451
		noun 38
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		signal 451
		noun 37
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		signal 451
		noun 33
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 906
		message 39
		signal 387
		noun 29
	)
)

(instance iconOk of ControlIcon
	(properties
		view 947
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 900
		signal 451
		noun 36
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 15] [temp29 4])
		(self
			top: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			left: (/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
			bottom:
				(+ (CelHigh 947 1 1) 6 (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2))
			right:
				(+
					144
					(CelWide 947 0 1)
					(/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
				)
			back: 13
			topBordColor: 23
			lftBordColor: 22
			rgtBordColor: 18
			botBordColor: 17
			priority: 15
		)
		(super open:)
		(DrawCel
			947
			0
			5
			(+
				(/
					(-
						(- (+ 144 (CelWide 947 0 1)) (+ 4 (CelWide 947 1 1)))
						(CelWide 947 0 5)
					)
					2
				)
				4
				(CelWide 947 1 1)
			)
			6
			15
		)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 116 38 15)
		(if (!= gCurRoomNum 130)
			(DrawCel 947 0 4 65 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		)
		(DrawCel 947 0 3 128 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 947 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 144 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 17)
		(= temp11 18)
		(= temp10 22)
		(= temp9 23)
		(= temp1 3)
		(= temp7 3)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grFILL_BOX temp2 temp3 (+ temp2 temp1) temp4 temp7 temp8 temp12)
		(Graph grFILL_BOX (- temp5 temp1) temp3 temp5 temp4 temp7 temp9 temp12)
		(for ((= temp13 0)) (< temp13 temp1) ((++ temp13))
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(+ temp3 temp13)
				(- temp5 (+ temp13 1))
				(+ temp3 temp13)
				temp11
				temp12
				-1
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(- temp4 (+ temp13 1))
				(- temp5 (+ temp13 1))
				(- temp4 (+ temp13 1))
				temp10
				temp12
				-1
			)
		)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 25 0 gScore gPossibleScore) ; "Score: %d / %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			21
			dsCOORD
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(- (+ 144 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 947 0 1) 3)
		)
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 250] [temp251 5] temp256)
		(= temp0 (gSystemWindow back:))
		(gSystemWindow back: 19)
		(Message msgGET 1 33 1 0 1 @temp1) ; "|c5|Island of Dr Brain|c|  Version: %s |c4|Designer:|c| Patrick Bridgemon |c4|Educational Consultant:|c|  Susan Simmons |c4|Produced and Directed by:|c| Brett Miller"
		(Format @temp251 {%s} gVersion)
		(= temp256 (Memory memALLOC_CRIT (+ (StrLen @temp1) (StrLen @temp251) 1)))
		(Format temp256 @temp1 @temp251)
		((Print new:) addText: temp256 55 0 addIcon: 801 0 3 0 5 init:)
		(Memory memFREE temp256)
		(Message msgGET 1 33 1 0 2 @temp1) ; "|c4|Lead Programmer:|c| Todd Powers |c4|Programmed by:|c| Michael Lytton Frank Roan Martin Peters Oliver Brelsford"
		((Print new:) addText: @temp1 55 0 addIcon: 801 0 1 0 5 init:)
		(Message msgGET 1 33 1 0 3 @temp1) ; "|c4|Art Design by:|c| Jon Bock |c4|Senior Artist:|c| Dennis Lewis |c4|Art and Animation by:|c| Frankie Anne Powell Daryle "the gun" Smith"
		((Print new:) addText: @temp1 55 0 addIcon: 801 0 0 0 5 init:)
		(Message msgGET 1 33 1 0 4 @temp1) ; "|c4|Music Composed and Produced by:|c| Robert Atesalp  |c4|Quality Assurance by:|c| Joe Carper"
		((Print new:) addText: @temp1 55 0 addIcon: 801 0 2 0 5 init:)
		(Message msgGET 1 33 1 0 5 @temp1) ; "|c4|Development System by:|c| Larry Scott Dan Foy Ken Koch Mark Wilden Jack Magne Chris Smith Terry McHenry Martin Peters J. Mark Hood Brian Hughes"
		((Print new:) addText: @temp1 55 0 addIcon: 801 0 4 0 5 init:)
		(Message msgGET 1 33 1 0 6 @temp1) ; "|c5|EnclycloAlmanacTionaryOgraphy|c|  |c4|Concept:|c| Josh Mandel |c4|Design:|c| Nathan Gams |c4|Written by:|c| Pat Bridgemon |c4|Additional Written Material:|c| Michael G. Lytton Martin Peters |c4|Additional Research:|c| Susan Simmons"
		((Print new:) addText: @temp1 65 0 addIcon: 801 0 5 0 5 init:)
		(Message msgGET 1 33 1 0 7 @temp1) ; "|c4|Q.A. Configuration Team|c| Dave Clingman Mike Brosius Bill Davis Jr. Lynne Dayton Tina Deardorff Matt Genesi Jon Meek Diana Mulligan Sharon Simmons Doug Wheeler"
		((Print new:) addText: @temp1 65 0 addIcon: 801 0 6 0 5 init:)
		(Message msgGET 1 33 1 0 8 @temp1) ; "|c4|Play Testers:|c| Ron Boyd      Melissa Mueller Cyrus Chan     Megan Nilmeier Rosaline Chan    Jeremy Root Jonathon DeBaun  Matthew Sconce Ryan Duffy     Stan Simmons Zac Halls      Shaun Spurgeon Jade Lazaris    Cassia Thompson Amanda Luthy    Dominic Trupiano Elsa Mueller     Brandi Tsang"
		((Print new:) addText: @temp1 65 0 addIcon: 801 0 6 0 5 init:)
		(gSystemWindow back: temp0)
	)
)

(instance callInfo of Code
	(properties)

	(method (init)
		((ScriptID 55) init:) ; infoStart
	)
)

