;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Print)
(use PseudoMouse)
(use Slider)
(use BorderWindow)
(use IconBar)
(use GameControls)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	[local13 13] = [-83 -60 23 -23 -63 -45 -29 -103 -65 -72 -104 41 -14]
	[local26 13] = [-53 64 102 206 -60 47 30 151 -25 177 66 53 92]
	[local39 13] = [5 3 2 2 5 4 4 3 5 3 4 1 2]
	[local52 8] = [0 7 6 5 4 3 2 1]
	local60
)

(procedure (localproc_0 &tmp temp0 temp1 [temp2 12] [temp14 4])
	(switch local1
		(0
			(if (!= gMouseY local3)
				(= local3 gMouseY)
				(= temp1 (localproc_3 gMouseY 0))
				(Graph grFILL_BOX 3 50 10 76 1 19 -1 -1)
				(Graph grUPDATE_BOX 3 50 10 76 1)
				(if (< temp1 0)
					(Message msgGET 130 2 0 12 1 @temp14) ; "S"
				else
					(Message msgGET 130 2 0 11 1 @temp14) ; "N"
				)
				(= temp1 (Abs temp1))
				(Format @temp2 {%d %s} temp1 @temp14)
				(Display @temp2 dsCOORD 50 3 dsCOLOR 51 dsALIGN alRIGHT dsWIDTH 26 dsFONT 999)
			)
		)
		(1
			(if (!= gMouseX local4)
				(= local4 gMouseX)
				(= temp0 (localproc_3 gMouseX 1))
				(Graph grFILL_BOX 3 289 10 315 1 19 -1 -1)
				(Graph grUPDATE_BOX 3 289 10 315 1)
				(if (< temp0 0)
					(Message msgGET 130 2 0 14 1 @temp14) ; "W"
				else
					(Message msgGET 130 2 0 13 1 @temp14) ; "E"
				)
				(= temp0 (Abs temp0))
				(Format @temp2 {%d %s} temp0 @temp14)
				(Display @temp2 dsCOORD 289 3 dsCOLOR 51 dsALIGN alRIGHT dsWIDTH 26 dsFONT 999)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 [temp2 200] [temp202 300] [temp502 5] [temp507 6])
	(= local5 (+ (localproc_3 local8 1) [local26 local0]))
	(= local6 (+ (localproc_3 local7 0) [local13 local0]))
	(proc15_0 0 2 9)
	(switch global114
		(0
			(proc15_0 0 2 3 0 1)
		)
		(1
			(proc15_0 0 2 10 0 1)
		)
		(else
			(proc15_0 0 2 11 0 1)
		)
	)
	(= temp0 (- local7 74))
	(= temp1 (- 101 local8))
	(if (< temp0 0)
		(Message msgGET 130 2 0 12 1 @temp502) ; "S"
	else
		(Message msgGET 130 2 0 11 1 @temp502) ; "N"
	)
	(if (< temp1 0)
		(Message msgGET 130 2 0 14 1 @temp507) ; "W"
	else
		(Message msgGET 130 2 0 13 1 @temp507) ; "E"
	)
	(Message msgGET 130 2 0 10 1 @temp2) ; "Your journey begins at Dr. Brain's Castle. It is located at |c2|%d|c| degrees |c2|%s|c| latitude and |c2|%d|c| degrees |c2|%s|c| longitude. Since Dr. Brain's island is located near the"
	(= temp0 (Abs temp0))
	(= temp1 (Abs temp1))
	(Format @temp202 @temp2 temp0 @temp502 temp1 @temp507)
	(Print
		addText: @temp202
		addIcon: 132 0 local0 30 40
		addText: 2 0 9 1 0 60 ; "just use your parallel rulers to mark off the correct coordinates, then place the crosshairs of the cursor over the intersection and either click your mouse button or hit enter."
		init:
	)
	(DrawCel 130 15 0 150 0)
	(DrawCel 132 0 local0 155 3)
)

(procedure (localproc_2 param1 param2 param3 param4 &tmp [temp0 30])
	(Graph grDRAW_LINE param1 param2 param3 param4 0 -1 -1)
	(Graph grUPDATE_BOX (- param1 1) (- param2 1) (+ param3 1) (+ param4 1) 1)
)

(procedure (localproc_3 param1 param2)
	(return
		(if param2
			(- param1 local8)
		else
			(- local7 param1)
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(= gGameControls (ScriptID 25 0)) ; controlBox
	(= temp0 gTheCursor)
	(gGame setCursor: 999)
	(controls130 init: show: release: dispose:)
	(= gGameControls 0)
	(gGame setCursor: temp0)
)

(instance rm130 of Rm
	(properties
		picture 130
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(PseudoMouse minInc: 2 maxInc: 20)
		(super dispose: &rest)
	)

	(method (init &tmp temp0)
		(gTheIconBar disable:)
		(= gMouseY 20)
		(gKeyDownHandler add: gCurRoom)
		(gMouseDownHandler add: gCurRoom)
		(PseudoMouse minInc: 1 maxInc: 10)
		(= local0 (Random 0 12))
		(= local7 74)
		(= local8 101)
		(= local9 local7)
		(= local10 (+ local7 1))
		(= local11 local8)
		(= local12 (+ local8 2))
		(horizLower y: local10 init: stopUpd:)
		(horizUpper y: local9 init: stopUpd:)
		(verticalLeft x: local11 init: hide:)
		(verticalRight x: local12 init: hide:)
		(= local1 2)
		(super init:)
		(DrawCel 130 14 1 0 0)
		(DrawCel 130 14 0 239 0)
		(self setScript: startItOff)
	)

	(method (doit)
		(Palette palANIMATE 231 236 -9)
		(if
			(and
				(< gMouseY 10)
				(not (IsObject gGameControls))
				(not (gCurRoom script:))
			)
			(localproc_4)
		)
		(switch local1
			(0
				(if (> gMouseY (- local9 1))
					(if (!= local2 1)
						(horizUpper y: local9 stopUpd:)
						(horizLower startUpd:)
						(= local2 1)
					)
					(if (> gMouseY 189)
						(= gMouseY 189)
					)
					(horizLower y: (+ gMouseY 1))
				else
					(if (!= local2 0)
						(horizLower y: local10 stopUpd:)
						(horizUpper startUpd:)
						(= local2 0)
					)
					(if (< gMouseY 20)
						(= gMouseY 20)
					)
					(horizUpper y: gMouseY)
				)
				(localproc_0)
			)
			(1
				(gGame setCursor: 996)
				(if (> gMouseX (- local11 1))
					(if (!= local2 3)
						(verticalLeft x: local11 stopUpd:)
						(verticalRight startUpd:)
						(= local2 3)
					)
					(verticalRight x: (+ gMouseX 2))
				else
					(if (!= local2 2)
						(verticalRight x: local12 stopUpd:)
						(verticalLeft startUpd:)
						(= local2 2)
					)
					(verticalLeft x: gMouseX)
				)
				(localproc_0)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 30])
		(cond
			((not (User input:)))
			((== (event type:) evMOUSERELEASE))
			(
				(and
					(== (event type:) evKEYBOARD)
					(or (== (event message:) KEY_ESCAPE) (== (event message:) KEY_DELETE))
				)
				(localproc_4)
			)
			(
				(or
					(and (== local1 0) (not (localproc_3 gMouseY 0)))
					(and (== local1 1) (not (localproc_3 gMouseY 1)))
				)
				(gMessager say: 1 4 1) ; "You need to move the parallel rulers further apart before you can draw a line with them."
			)
			((== local1 0)
				(if (== local2 1)
					(= temp0 gMouseY)
					(= temp1 (horizLower nsLeft:))
					(= temp2 gMouseY)
					(= temp3 (horizLower nsRight:))
				else
					(= temp0 gMouseY)
					(= temp1 (horizUpper nsLeft:))
					(= temp2 gMouseY)
					(= temp3 (horizUpper nsRight:))
				)
				(gCSoundFX setLoop: 1 number: 104 play:)
				(localproc_2 temp0 temp1 temp2 (+ temp3 32))
				(horizLower hide:)
				(horizUpper hide:)
				(verticalLeft show: stopUpd:)
				(verticalRight show: stopUpd:)
				(= local1 1)
				(= local4 -1)
				(gGame setCursor: 996 1 local11 local9)
				(= global172 gMouseX)
			)
			((== local1 1)
				(if (== local2 3)
					(= temp0 (verticalRight nsTop:))
					(= temp1 gMouseX)
					(= temp2 (verticalRight nsBottom:))
					(= temp3 gMouseX)
				else
					(= temp0 (verticalLeft nsTop:))
					(= temp1 gMouseX)
					(= temp2 (verticalLeft nsBottom:))
					(= temp3 gMouseX)
				)
				(gCSoundFX number: 104 play:)
				(localproc_2 (+ temp0 6) temp1 (+ temp2 6) temp3)
				(verticalLeft hide:)
				(verticalRight hide:)
				(= local1 2)
				(gGame setCursor: 905)
				(= global173 gMouseY)
			)
			(else
				(proc5_1)
				(if
					(and
						(< (- local5 3) (localproc_3 gMouseX 1) (+ local5 3))
						(<
							(- local6 3)
							(+ (localproc_3 gMouseY 0) 10)
							(+ local6 3)
						)
					)
					(gCurRoom setScript: doWrapup 0 1)
				else
					(gCurRoom setScript: doWrapup)
				)
			)
		)
		(event claimed: 1)
	)
)

(instance startItOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc5_2)
				(gTheIconBar disable:)
				(gGame setCursor: gTheCursor 1 300 160)
				(gCMusic number: 4 setLoop: -1 play:)
				(gGame setCursor: 996 1 local11 local9)
				(localproc_1)
				(= cycles 1)
			)
			(2
				(= local2 -1)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance doWrapup of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= global172 (- gMouseX 8))
				(= global173 (- gMouseY 12))
				(if
					(and
						(< (- local5 3) (localproc_3 gMouseX 1) (+ local5 3))
						(<
							(- local6 3)
							(+ (localproc_3 gMouseY 0) 10)
							(+ local6 3)
						)
					)
					(= register 1)
					(gCSoundFX number: 106 play:)
					(DrawPic (gCurRoom picture:) 100)
					(Animate 0)
					(theIsland
						init:
						x: (+ global172 6)
						y: (+ global173 2)
						setPri: 3
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(dePlane
					init:
					setLoop: 1
					setCel: 0
					x: 80
					y: 66
					cycleSpeed: 8
					signal: 24576
					illegalBits: 0
					setPri: 4
					setCycle: End self
				)
			)
			(2
				(dePlane
					x: 78
					y: 69
					setCel: 0
					setLoop: (+ (dePlane loop:) 1)
					setCycle: End self
				)
				(gCSoundFX number: 107 setLoop: -1 play:)
			)
			(3
				(dePlane
					x: 100
					y: 36
					setLoop: 3
					setCel: 0
					signal: (| (dePlane signal:) $0800)
					setCycle:
						CT
						(if register
							[local52 [local39 local0]]
						else
							[local52
								(/
									(+
										22
										(GetAngle
											100
											36
											(- (- global172 30) 8)
											(- global173 40)
										)
									)
									45
								)
							]
						)
						1
						self
				)
			)
			(4
				(dePlane
					setStep: 1 1
					moveSpeed: 1
					setCel: (dePlane cel:)
					setMotion:
						MoveTo
						(+ (- global172 30) 8)
						(- global173 40)
						self
				)
			)
			(5
				(dePlane
					setMotion:
						MoveTo
						(+ (dePlane x:) (SinMult (dePlane heading:) 360))
						(- (dePlane y:) (CosMult (dePlane heading:) 360))
				)
				(if
					(and
						(not register)
						(OnControl CONTROL (+ (dePlane x:) 26) (+ (dePlane y:) 43))
					)
					(gCSoundFX number: 255 setLoop: 1 play:)
				else
					(gCSoundFX number: 108 setLoop: 1 play:)
				)
				(parachute
					init:
					setLoop: 4
					setCel: 0
					x: (+ (dePlane x:) 4)
					y: (+ (dePlane y:) 8)
					setPri: 4
					setCycle: End self
				)
			)
			(6
				(if register
					(self cue:)
				else
					(++ local60)
					(parachute
						setLoop: 6
						x: (+ (parachute x:) 22)
						y: (+ (parachute y:) 35)
					)
					(if (== (OnControl CONTROL (parachute x:) (parachute y:)) 64)
						(parachute setLoop: 5)
					else
						(gCSoundFX number: 105 play:)
					)
					(parachute setCel: 0 setCycle: End self)
				)
			)
			(7
				(cond
					(register
						(gGame setCursor: 902 1)
						(proc15_5 56 2 8 3)
						(if global174
							(gGame restore:)
						)
						(gCMusic fade: self)
					)
					((== local60 3)
						(gMessager say: 1 4 6 0 self) ; "Sorry, that is not the correct location of Dr. Brain's Island. You need to consult the map on page 5 in your EncycloAlmanacTionaryOgraphy for the proper coordinates of the island. If you have not legally purchased this game, we encourage you to do so. Copying commercial software is a crime."
					)
					(else
						(dePlane dispose:)
						(parachute dispose:)
						(horizLower show: stopUpd:)
						(horizUpper show: stopUpd:)
						(= local2 -1)
						(DrawPic (gCurRoom picture:) 100)
						(DrawCel 130 14 1 0 0)
						(DrawCel 130 14 0 239 0)
						(Animate 0)
						(localproc_1)
						(= local1 0)
						(= local3 -1)
						(proc5_2)
						(gTheIconBar disable:)
						(gGame setCursor: 996 1 local11 local9)
						(self dispose:)
					)
				)
			)
			(8
				(if register
					(proc5_2)
					(gTheIconBar enable:)
					(gCurRoom newRoom: 140)
				else
					(= gQuit 1)
				)
			)
		)
	)
)

(instance horizLower of Actor
	(properties
		x 150
		view 130
		loop 11
		cel 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance horizUpper of Actor
	(properties
		x 150
		view 130
		loop 11
	)

	(method (onMe)
		(return 0)
	)
)

(instance verticalLeft of Actor
	(properties
		y 89
		view 130
		loop 12
	)

	(method (onMe)
		(return 0)
	)
)

(instance verticalRight of Actor
	(properties
		y 89
		view 130
		loop 13
	)

	(method (onMe)
		(return 0)
	)
)

(instance dePlane of Actor
	(properties
		view 132
	)
)

(instance parachute of Actor
	(properties
		view 132
	)
)

(instance theIsland of Prop
	(properties
		view 130
		loop 8
	)
)

(instance aboutCode130 of Code
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
		(Message msgGET 1 33 1 0 4 @temp1) ; "|c4|Music Composed and Produced by:|c| Rob Atesalp  |c4|Quality Assurance by:|c| Joe Carper"
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

(instance controls130 of GameControls
	(properties
		state 3072
	)

	(method (init)
		(self
			window: gcWin
			add:
				(iconOk theObj: callInfo selector: #init yourself:)
				(volumeSlider
					theObj: gGame
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: aboutCode130 selector: #doit yourself:)
				iconHelp
		)
		(self
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 27
			eachElementDo: #helpVerb 39
			eachElementDo: #modNum 1
			helpIconItem: iconHelp
		)
		(self curIcon: iconOk)
	)

	(method (dispatchEvent event)
		(if (or (> (event x:) 116) (> (event y:) 106))
			(self hide:)
		)
		(super dispatchEvent: event)
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 80
		nsTop 37
		signal 128
		noun 40
		sliderView 947
		topValue 15
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 34
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
		nsTop 54
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
		nsTop 54
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
		nsTop 74
		cursor 900
		signal 451
		noun 36
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp [temp0 33])
		(self
			top: 47
			left: 102
			bottom: 153
			right: 218
			back: 13
			topBordColor: 23
			lftBordColor: 22
			rgtBordColor: 18
			botBordColor: 17
			priority: 15
		)
		(super open:)
		(DrawCel 947 0 5 25 6 15)
		(DrawCel 947 1 0 66 38 15)
		(DrawCel 947 0 3 72 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
	)
)

(instance callInfo of Code
	(properties)

	(method (init)
		((ScriptID 55) init:) ; infoStart
	)
)

