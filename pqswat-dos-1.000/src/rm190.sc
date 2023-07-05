;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Button)
(use PQSlider)
(use DSelector)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Motion)
(use Actor)
(use System)

(public
	rm190 0
)

(local
	local0
	[local1 2] = [0 -1]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0)
	(if (not (Message msgGET param4 param1 param2 param3 1))
		(return)
	)
	(= temp0 (Str new: 400))
	(Message msgGET param4 param1 param2 param3 1 (temp0 data:))
	(param5 copy: (temp0 data:))
	(while (Message msgNEXT (temp0 data:))
		(param5 cat: (temp0 data:))
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 (Str new: 50))
	(switch global122
		(5
			(localproc_0 4 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 2 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 6 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 5 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 3 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 1 0 2 190 temp0)
			(param1 setText: temp0)
		)
		(6
			(localproc_0 7 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 8 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 9 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 10 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 11 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 12 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 13 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 14 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 15 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 16 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 17 0 2 190 temp0)
			(param1 setText: temp0)
			(localproc_0 18 0 2 190 temp0)
			(param1 setText: temp0)
		)
	)
	(temp0 dispose:)
	(param1 textList:)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(proc4_5)
	(= temp0 (gGame isHandsOn:))
	(gGame handsOff:)
	(= temp1 (Str new:))
	(switch global122
		(5
			(switch param1
				(0
					(localproc_0 4 0 3 190 temp1)
				)
				(1
					(localproc_0 2 0 3 190 temp1)
				)
				(2
					(gCurRoom setScript: sStealthEntry)
				)
				(3
					(gCurRoom setScript: sSlicePie)
					(return)
				)
				(4
					(localproc_0 3 0 3 190 temp1)
				)
				(5
					(gCurRoom setScript: sButtonHook)
					(return)
				)
			)
		)
		(6
			(switch param1
				(0
					(localproc_0 7 0 0 190 temp1)
				)
				(1
					(localproc_0 8 0 0 190 temp1)
				)
				(2
					(localproc_0 9 0 0 190 temp1)
				)
				(3
					(localproc_0 10 0 0 190 temp1)
				)
				(4
					(localproc_0 11 0 0 190 temp1)
				)
				(5
					(localproc_0 12 0 0 190 temp1)
				)
				(6
					(gCurRoom setScript: sMilDot)
					(return)
				)
				(7
					(localproc_0 14 0 0 190 temp1)
				)
				(8
					(localproc_0 15 0 0 190 temp1)
				)
				(9
					(localproc_0 16 0 0 190 temp1)
				)
				(10
					(localproc_0 17 0 0 190 temp1)
				)
				(11
					(localproc_0 18 0 0 190 temp1)
				)
			)
		)
	)
	(if (temp1 size:)
		(swatLogo hide:)
		(if (gCast contains: showTactics)
			(showTactics dispose:)
		)
		(bigPrint addText: (temp1 data:) posn: 20 60)
		(bigPrint init:)
		(sliderBar init:)
		(sliderObj setup: (temp1 data:))
	else
		(if (bigPrint dialog:)
			((bigPrint dialog:) dispose:)
			(bigPrint dialog: 0)
		)
		(sliderBar dispose:)
		(swatLogo show:)
	)
	(temp1 dispose:)
	(if temp0
		(gGame handsOn:)
	)
)

(procedure (localproc_3)
	(PlayVMD 0 {196.vmd}) ; Open
	(PlayVMD 1 180 86) ; Put
	(PlayVMD 14 3 7) ; WaitEvent
	(PlayVMD 6) ; Close
)

(instance rm190 of PQRoom
	(properties
		picture 190
		infoRoomSignal 5
	)

	(method (init)
		(super init: &rest)
		(titlePlate init:)
		(scrollUpButn init:)
		(scrollDownButn init:)
		(selectArrow init:)
		(= global432 holdIt)
		(self setScript: showOpening)
		(if (!= (gBackMusic number:) 18501)
			(gBackMusic number: 18501 loop: -1 flags: 1 play:)
		)
	)

	(method (dispose)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #perform disposeMyself)
		)
		(proc4_5)
		(= global432 0)
		(if (bigPrint dialog:)
			((bigPrint dialog:) dispose:)
		)
		(if (not (OneOf gNewRoomNum 180 185)) ; tacticsMenu
			(Lock rsAUDIO 18501 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(super dispose: &rest)
	)
)

(instance holdIt of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance sSelectArrow of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(selectArrow trace:)
				((gCurRoom script:) dispose:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance showOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (= local0 (localproc_1 ourSelector))
					(ourSelector
						setSize:
						init: gCast gFtrInitializer
						updatePlane:
						draw:
					)
				)
				(swatLogo init:)
				(if (IsFlag 20)
					(swatLogo cel: (- (NumCels swatLogo) 1))
					(UpdateScreenItem swatLogo)
				)
				(= ticks 5)
			)
			(1
				(if (not (SetFlag 20))
					(swatLogo setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlicePie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swatLogo hide:)
				(if (gCast contains: sliderBar)
					(sliderBar dispose:)
				)
				(showTactics
					view: 190
					loop: 0
					cel: 4
					cycleSpeed: 15
					posn: 106 266
					init:
				)
				(= cycles 5)
			)
			(1
				(gGame handsOn:)
				(gMessager say: 5 0 1 0 self) ; "'Slicing the pie' is the term given to the room entry technique of maximizing your distance from corners while utilizing angles to decrease risk of vulnerability. Slicing the pie allows the tactical officer to systematically search a room segment by segment before entering. Each step allows the offier to view another section of the un-entered room in a controlled manner. This technique is the opposite of entering a room fully and having to successfuly search one-hundred and eighty degrees for threats. Slicing the pie is not a formality, it is an essential tactical tool. In a tactical situation it can mean the difference between life and death."
				(= ticks 180)
			)
			(2
				(showTactics setCycle: End)
				(= ticks 940)
			)
			(3
				(showTactics cel: 0 setCycle: End)
			)
			(4
				(showTactics dispose:)
				(swatLogo show:)
				(self dispose:)
			)
		)
	)
)

(instance sButtonHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swatLogo hide:)
				(if (gCast contains: sliderBar)
					(sliderBar dispose:)
				)
				(showTactics
					view: 193
					loop: 1
					cel: 0
					posn: 231 245
					cycleSpeed: 10
					init:
				)
				(= cycles 5)
			)
			(1
				(gGame handsOn:)
				(gMessager say: 1 0 1 0 self) ; "When a room has a door which, when opened, stops at a dividing wall there is little maneuverability for the entry team. Utilizing the button hook technique will allow the entry team to quickly enter and move into position. To execute the button hook entry, move the foot nearest the wall up to the door jam, being careful not to telescope your position. Shift your weight to that front foot. At the time of entry bring your back foot forward as you pivot on your front foot. Continue forward into the room and into position."
				(= ticks 360)
			)
			(2
				(showTactics setCycle: End self)
			)
			(3
				(showTactics view: 194 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(showTactics
					loop: 1
					cel: 0
					cycleSpeed: 20
					setCycle: CT 14 1 self
				)
			)
			(5
				(showTactics cel: 15 setCycle: End self)
			)
			(6)
			(7
				(= ticks 20)
			)
			(8
				(showTactics dispose:)
				(swatLogo show:)
				(self dispose:)
			)
		)
	)
)

(instance sMilDot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swatLogo hide:)
				(if (gCast contains: sliderBar)
					(sliderBar dispose:)
				)
				(gGame handsOn:)
				(gMessager say: 13 0 1 0 self) ; "Looking through the Leupold Mark Four riflescope you'll see a crosshair with equally spaced dots along a thin, inner line. This is called a mil dot reticle. Mil dot reticles are used to estimate target range and adjust for wind and elevation. The formula used for range estimation is as follows; The size of object in yards multiplied by one-thousand, divided by the size of the object in mil dots. Using this formula, if a target is six feet, or two yards, tall and measures five mils in your scope you can determine the target range to be four hundred yards. One thing to remember when using mil dots to estimate range; the measurement of one mil dot refers to the distance from the center of one mil dot to the center of the next mil dot."
				(showTactics
					view: 192
					loop: 0
					cel: 0
					posn: 454 151
					setPri: 0
					init:
				)
				(= ticks 600)
			)
			(1
				(showTactics loop: 0 cel: 1 init:)
				(= ticks 300)
			)
			(2
				(formula init:)
				(= ticks 390)
			)
			(3
				(showTactics loop: 2 cel: 0 setCycle: End)
				(= ticks 600)
			)
			(4
				(formula loop: 1)
			)
			(5
				(formula dispose:)
				(showTactics dispose:)
				(swatLogo show:)
				(self dispose:)
			)
		)
	)
)

(instance sStealthEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: sliderBar)
					(sliderBar dispose:)
				)
				(if (gCast contains: showTactics)
					(showTactics dispose:)
				)
				(if (gCast contains: formula)
					(formula dispose:)
				)
				(Palette 1 196) ; PalLoad
				(= cycles 5)
			)
			(1
				(gMessager say: 6 0 1 1 self) ; "In a stealth entry, the scout, rear guard and element leader, followed by any number of assaulters, are deployed with the intention of gaining access to a structure without detection. This entry technique is applicable when a suspect has threatened to hurt themselves, has health problems or when hostages or children are present."
			)
			(2
				(localproc_3)
				(gBackMusic number: 18501 loop: -1 flags: 1 play:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance swatLogo of Prop
	(properties
		x 234
		y 254
		view 2
	)
)

(instance showTactics of Prop
	(properties
		x 109
		y 268
		view 190
	)
)

(instance formula of View
	(properties
		x 99
		y 214
		view 195
	)
)

(instance sliderObj of PQSlider
	(properties
		x 516
		view 1904
		loop 2
		topY 92
		bottomY 243
	)

	(method (adjust param1)
		(+= dataTop param1)
		(+= dataBottom param1)
		(super adjust: 0 &rest)
	)

	(method (setup param1 &tmp temp0)
		(super setup:)
		(= temp0 (IntArray with: 0 0 0 0))
		(if (and argc param1)
			(Text 0 (temp0 data:) {W} (bigPrint font:) 0 0)
			(= dataStep (* (temp0 at: 3) 2))
			(temp0 at: 0 0 0 0 0)
			(Text 0 (temp0 data:) param1 (bigPrint font:) (bigPrint width:) 0)
			(= dataTop 0)
			(= dataBottom
				(-
					(/ (temp0 at: 3) dataStep)
					(/
						(/
							(-
								((bigPrint plane:) bottom:)
								((bigPrint plane:) top:)
							)
							dataStep
						)
						2
					)
				)
			)
			(if (< dataBottom dataTop)
				(= dataBottom dataTop)
			)
			(self positionThumb:)
		)
		(temp0 dispose:)
	)

	(method (updateData param1 &tmp temp0)
		(MovePlaneItems (bigPrint plane:) 0 (* (Abs dataTop) dataStep))
		(= dataCur 0)
		(= dataTop (- (/ (* param1 totalHeight) 100)))
		(= dataBottom (+ totalHeight dataTop))
		(self positionThumb:)
		(MovePlaneItems (bigPrint plane:) 0 (* dataTop dataStep))
		(UpdatePlane (bigPrint plane:))
		(FrameOut)
	)
)

(instance sliderBar of View
	(properties
		x 514
		y 72
		view 1904
		loop 4
	)

	(method (init)
		(super init: &rest)
		(upButn init:)
		(downButn init:)
		(sliderObj init:)
	)

	(method (dispose)
		(sliderObj dispose:)
		(upButn dispose:)
		(downButn dispose:)
		(super dispose:)
	)
)

(instance scrollUpButn of Button
	(properties
		x 430
		y 302
		view 1904
		downCel 2
	)

	(method (doVerb)
		(ourSelector scrollUp:)
	)
)

(instance scrollDownButn of Button
	(properties
		x 430
		y 321
		view 1904
		loop 1
		downCel 2
	)

	(method (doVerb)
		(ourSelector scrollDown:)
	)
)

(instance titlePlate of View
	(properties)

	(method (init)
		(= y 16)
		(switch global122
			(5
				(= view 1900)
				(= x 134)
			)
			(6
				(= view 1901)
				(= x 66)
			)
			(else
				(return)
			)
		)
		(super init:)
	)
)

(instance bigPrint of Print
	(properties
		font 20071
		width 400
		fore 28
		back 0
		x 68
		y 69
		modeless 2
	)

	(method (dispose)
		(if (gPrints contains: self)
			(gPrints delete: self)
		)
		(plane dispose:)
		(= mode
			(= ticks (= title (= first (= saveCursor (= plane (= bitmap 0))))))
		)
		(gSounds pause: 0)
		(DisposeClone self)
	)

	(method (showSelf &tmp [temp0 2] temp2 temp3 [temp4 2])
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			setRect: 100 73 511 266
			back: (if (== back -1) 0 else back)
			priority: 7
			picture: -2
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			init:
		)
		(dialog setSize:)
		(dialog center:)
		(= temp2
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp3
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp2 temp3 eachElementDo: #updatePlane)
		(plane setRect: 100 73 511 266)
		(UpdatePlane plane)
		(FrameOut)
		(gPrints addToFront: self)
	)

	(method (handleEvent))
)

(instance ourSelector of DSelector
	(properties
		x 220
		y 307
		font 999
		length 3
		width 242
		fore 28
		back 0
	)

	(method (init param1)
		(= upButton (= downButton -1))
		(gMouseDownHandler add: self)
		(super init: param1 &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (scrollDown param1 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (>= (+= current param1) (textList size:))
			(= current (- (textList size:) 1))
		)
		(if (== current (- (textList size:) 1))
			(= first
				(Min
					(- (textList size:) 1)
					(Max 0 (- current 2))
				)
			)
		else
			(= first (- current 1))
		)
		(self draw:)
	)

	(method (scrollUp param1 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (< (-= current param1) 0)
			(= current 0)
		)
		(if (not current)
			(= first current)
		else
			(= first (- current 1))
		)
		(self draw:)
	)

	(method (setSize &tmp [temp0 4])
		(super setSize:)
		(= nsLeft 218)
		(= nsTop 307)
		(= nsRight 422)
		(= nsBottom 333)
	)
)

(instance upButn of Button
	(properties
		x 518
		y 72
		view 1904
		downCel 2
		doVerbCalled 1
	)

	(method (doVerb)
		(if (not (bigPrint plane:))
			(return)
		)
		(if (< (sliderObj dataTop:) 0)
			(MovePlaneItems (bigPrint plane:) 0 (sliderObj dataStep:))
			(sliderObj adjust: 1)
			(UpdatePlane (bigPrint plane:))
			(FrameOut)
		)
	)
)

(instance downButn of Button
	(properties
		x 518
		y 254
		view 1904
		loop 1
		downCel 2
		doVerbCalled 1
	)

	(method (doVerb)
		(if (not (bigPrint plane:))
			(return)
		)
		(if (> (sliderObj dataBottom:) 0)
			(MovePlaneItems (bigPrint plane:) 0 (- (sliderObj dataStep:)))
			(sliderObj adjust: -1)
			(UpdatePlane (bigPrint plane:))
			(FrameOut)
		)
	)
)

(instance selectArrow of Button
	(properties
		x 186
		y 304
		view 1904
		loop 3
	)

	(method (doVerb)
		(if local0
			(if (bigPrint dialog:)
				((bigPrint dialog:) dispose:)
				(bigPrint dialog: 0)
			)
			(if (not (gTalkers isEmpty:))
				(gTalkers eachElementDo: #perform disposeMyself)
			)
			(if (and (gCast contains: showTactics) (showTactics cycler:))
				(showTactics cycler: 0)
			)
			(localproc_2 (ourSelector current:))
		)
	)
)

(instance disposeMyself of Code
	(properties)

	(method (doit param1)
		(param1 caller: 0 dispose: (param1 disposeWhenDone:))
	)
)

