;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use n666)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
	Dorff 1
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
	[local9 3]
	local12
	local13
	local14
	local15
)

(instance rm370 of SQRoom
	(properties
		noun 18
		picture 370
	)

	(method (init &tmp temp0)
		(super init:)
		(if (!= gPrevRoomNum 460)
			(gGSound1 number: 370 setLoop: -1 play: setVol: 127)
		)
		(gGame handsOn:)
		(gGame handsOff:)
		(gEgo
			setScaler: Scaler 100 90 107 94
			setCycle: 0
			setMotion: 0
			cycleSpeed: 7
		)
		(Load rsVIEW 364)
		(Load rsVIEW 3630)
		(Load rsVIEW 378)
		(Load 140 376) ; WAVE
		(Load rsVIEW 3702)
		(Load 140 941) ; WAVE
		(Load rsHEAP 64941)
		(Load rsSCRIPT 64941)
		(Load rsHEAP 64938)
		(Load rsSCRIPT 64938)
		(Load 140 375) ; WAVE
		(Load 140 374) ; WAVE
		(Load rsVIEW 9421)
		(Load rsVIEW 3770)
		(Load rsVIEW 9401)
		(Load 140 354) ; WAVE
		(Load 140 355) ; WAVE
		(Load 140 356) ; WAVE
		(Load rsVIEW 3760)
		(Load rsVIEW 9511)
		(Load rsFONT 50)
		(Load 140 373) ; WAVE
		(Lock 140 373 1) ; WAVE
		(fieldOnPolyList init:)
		(fieldOffPolyList init:)
		(self obstacles: fieldOffPolyList)
		(PalCycle 0 137 142 1 5) ; Start
		(button1 init: approachVerbs: 4) ; Do
		(button1Face init: approachVerbs: 4) ; Do
		(leftFieldCover init:)
		(button2 init: approachVerbs: 4) ; Do
		(button2Face init: approachVerbs: 4) ; Do
		(rightFieldCover init:)
		(if (not (IsFlag 9))
			(button2Face show:)
			(rightFieldCover show:)
			(gCurRoom obstacles: fieldOffPolyList)
		else
			(button2Face hide:)
			(rightFieldCover hide:)
			(gCurRoom obstacles: fieldOnPolyList)
		)
		(cart init: approachVerbs: 4) ; Do
		(theEgo init:)
		(leftToilet init:)
		(leftBed init:)
		(rightCel init: approachVerbs: 4) ; Do
		(rightBed init:)
		(rightSink init: approachVerbs: 4) ; Do
		(rightToilet init: approachVerbs: 4) ; Do
		(rightWindow init: approachVerbs: 4) ; Do
		(leftSink init:)
		(leftWindow init:)
		(tubeTop init: approachVerbs: 4) ; Do
		(tubeBottom init: approachVerbs: 4) ; Do
		(leftCel init:)
		(paper init:)
		(comPost init: approachVerbs: 4) ; Do
		(foodRep init: approachVerbs: 4) ; Do
		(donut init: hide:)
		(RemapColors 2 244 27) ; ByPercent
		(if (IsFlag 89)
			(donut show: posn: (- (cart x:) 15) (+ (cart y:) 1) 31)
		)
		(if (IsFlag 8)
			(if (IsFlag 9)
				(rightFieldCover hide:)
				(button2Face hide:)
				(self obstacles: fieldOnPolyList)
			else
				(rightFieldCover show:)
				(button2Face show:)
				(self obstacles: fieldOffPolyList)
			)
			(drog init:)
		)
		(cond
			((IsFlag 3)
				(gEgo
					view: 370
					posn: 206 102
					setLoop: 0
					setCel: 0
					init:
					put: 0 ; Actuator
					put: 29 ; Dead_Fish2
					put: 26 ; Data_Cart
					put: 64 ; Keyring
					put: 41 ; Eulogy
					put: 55 ; Holozine
				)
				(rightFieldCover hide:)
				(button2Face hide:)
				(self obstacles: fieldOnPolyList)
				(SetFlag 9)
				(= local1 1)
				(gEgo state: (& (gEgo state:) $fffd))
				(gWalkHandler addToFront: gCurRoom)
				(dorff init:)
			)
			((== gPrevRoomNum 460)
				(if (or (== global119 370) (== global119 0))
					(gEgo normalize: 0 posn: 296 131 cycleSpeed: 7 init:)
					(gGame handsOn:)
				else
					(gEgo setScript: sExitRoom)
				)
			)
			(else
				(gEgo setScript: sEnterRoom)
			)
		)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) local1)
			(gEgo setScript: sRogerStands 0 0)
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "From where you're sitting, it looks like freedom."
				else
					(gMessager say: noun theVerb) ; "This is the Brig area, where transgressors are placed for punishment and, supposedly, rehabilitation."
				)
			)
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 460)
			(gGSound1 fade: 0 3 1 1)
		)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(RemapColors 0 244) ; Off
		(Lock 140 373 0) ; WAVE
		(if (IsFlag 9)
			(fieldOffPolyList dispose:)
		else
			(fieldOnPolyList dispose:)
		)
		(super dispose: &rest)
	)
)

(instance sTea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(self setScript: sRogerStands self 1)
				else
					(= ticks 1)
				)
			)
			(1
				(gMessager say: 15 2 0 0 self) ; "Tea. Earl Grey. Hot."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(self setScript: sRogerStands self 1)
				else
					(= ticks 1)
				)
			)
			(1
				(gMessager say: 13 2 0 0 self) ; "Hey, Mr. Computer, release the force field, would you?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHalt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(self setScript: sRogerStands self 1)
				else
					(= ticks 1)
				)
			)
			(1
				(gMessager say: 16 2 0 0 self) ; "Halt! Who goes there?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(self setScript: sRogerStands self 1)
				else
					(= ticks 1)
				)
			)
			(1
				(gMessager say: 11 2 0 1 self) ; "Hey, handsome! Let's see that pretty li'l face!"
			)
			(2
				(gGSound2 setLoop: 0 number: 373 play:)
				(theEgo show: setCel: 0 setCycle: End self)
				(= ticks 60)
			)
			(3)
			(4
				(theEgo hide: setCel: 0)
				(gMessager say: 11 2 0 2 self) ; "Impressive."
			)
			(5
				(= local15 0)
				(gGame handsOn:)
				(theEgo setScript: sRandomEvents)
			)
		)
	)
)

(instance sSayNotYet of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 1)
				(= ticks 1)
			)
			(1
				(gMessager say: 21 4 8 0 self) ; "Not now. Dorff is looking."
			)
			(2
				(= local14 0)
				(self dispose:)
			)
		)
	)
)

(instance sGetDonut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 234 121 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo view: 3722 setCel: 0 setLoop: 0 setCycle: CT 4 1 self)
			)
			(3
				(donut hide:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 6)
				(gEgo get: 31) ; Donut
				(ClearFlag 89)
				(donut dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sNoWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 184 114 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gMessager say: 3 4 2 0 self) ; "Oh, no, I'm not going in THERE again."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDonutBounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(donut
					posn: (donut x:) (+ (donut y:) 1)
					setPri: (+ (cart priority:) 5)
				)
				(= ticks 8)
			)
			(1
				(donut posn: (donut x:) (- (donut y:) 1))
				(= ticks 6)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sBuildDummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 185 105 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gEgo
					view: 376
					setLoop: 0
					setCel: 0
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(4
				(gEgo put: 39 normalize: 0) ; dummy6
				(drog init:)
				(gGame points: 3)
				(SetFlag 34)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(cart hide:)
				(gEgo
					view: 3770
					cycleSpeed: 7
					posn: (cart x:) (cart y:)
					setPri: (+ (cart priority:) 1) 1
					setLoop: 0
					show:
					setCycle: CT 13 1 self
				)
			)
			(2
				(donut setScript: sDonutBounce)
				(gEgo setCycle: CT 20 1 self)
			)
			(3
				(donut setScript: 0 posn: (- (cart x:) 15) (+ (cart y:) 1) 31)
				(gEgo setCycle: CT 24 1 self)
			)
			(4
				(cart show:)
				(gEgo setPri: 400 setCycle: End self)
			)
			(5
				(= local0 0)
				(gEgo signal: 4129)
				(gEgo
					normalize:
					setHeading: 135
					setPri: -1
					posn: (- (cart x:) 4) (+ (cart y:) 4)
				)
				(gGame handsOn:)
				(gMessager say: 0 0 2 0 self) ; "Nice work. Sometimes you actually surprise me."
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sGetInCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo signal: 16417)
				(gGame handsOff:)
				(ClearFlag 3)
				(SetFlag 8)
				(gEgo setMotion: MoveTo 184 105 self)
			)
			(1
				(gEgo
					view: 377
					setLoop: 0
					setCel: 0
					cycleSpeed: 7
					setCycle: CT 5 1 self
				)
			)
			(2
				(cart hide:)
				(donut setScript: sDonutBounce)
				(gEgo setCycle: End self)
			)
			(3
				(cart show:)
				(gEgo hide:)
				(donut setScript: 0 posn: (- (cart x:) 15) (- (cart y:) 30))
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sTakeFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 184 105 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(cart setLoop: 1 1 setCel: 0 1)
				(gEgo get: 69 5 107 89 11 113 52 31) ; Melon
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDorffWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 25)
			)
			(1
				(dorff setScript: sDorffEnters setSpeed: 5)
				(self dispose:)
			)
		)
	)
)

(instance sDorffLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff view: 366 setCycle: Walk setMotion: MoveTo 150 132 self)
			)
			(1
				(dorff setMotion: MoveTo 296 134 self)
			)
			(2
				(= local4 1)
				(dorff view: 3660 setLoop: 3 setCel: 0 setCycle: CT 4 1 self)
			)
			(3
				(gGSound2 number: 356 setLoop: 0 play:)
				(dorff setCycle: ROsc 2 4 6 self)
			)
			(4
				(gGSound2 number: 356 setLoop: 0 play:)
				(dorff setCycle: End)
				(= seconds 2)
			)
			(5
				(gGSound2 number: 926 loop: 1 play:)
				(dorff view: 3660 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(dorff setSpeed: 5)
				(if local0
					(gEgo setScript: sLeaveCart)
					(dorff dispose:)
				else
					(dorff hide: setScript: sDorffWait)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDorffGetCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(dorff view: 375 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(dorff view: 366 setCycle: Walk setMotion: MoveTo 146 112 self)
			)
			(2
				(= ticks 10)
			)
			(3
				(cond
					((or (IsFlag 8) (not (IsFlag 34)) local6)
						(= ticks 20)
					)
					(
						(or
							(not (gTalkers isEmpty:))
							(== (theEgo script:) sShowFace)
						)
						(self changeState: 2)
					)
					(else
						(= local5 0)
						(gEgo loop: 2)
						(= local6 1)
						(gMessager say: 0 0 10 0 self) ; "Whoa, I see you have a visitor. I'll leave you two alone, but you know the rules. Ten more minutes and they have to leave."
					)
				)
			)
			(4
				(if
					(or
						(not (gTalkers isEmpty:))
						(gEgo script:)
						(== (theEgo script:) sShowFace)
					)
					(-- state)
					(= ticks 20)
				else
					(gGame handsOff:)
					(= ticks 1)
				)
			)
			(5
				(dorff view: 373 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 50)
			)
			(7
				(dorff setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(gGSound2 setLoop: 0 number: 354 play:)
				(= ticks 50)
			)
			(9
				(gGSound2 setLoop: 0 number: 372 play:)
				(button2Face show:)
				(rightFieldCover show:)
				(gCurRoom obstacles: fieldOffPolyList)
				(ClearFlag 9)
				(dorff setCycle: Beg)
				(cart setScript: sCartLeavesCell self)
			)
			(10
				(dorff setCycle: End self)
			)
			(11
				(gGSound2 setLoop: 0 number: 354 play:)
				(= ticks 50)
			)
			(12
				(if (not (IsFlag 8))
					(gGame handsOn:)
				)
				(gGSound2 setLoop: 0 number: 371 play:)
				(button2Face hide:)
				(rightFieldCover hide:)
				(gCurRoom obstacles: fieldOnPolyList)
				(SetFlag 9)
				(dorff setCycle: Beg self)
			)
			(13
				(dorff setSpeed: 5)
				(dorff setScript: sDorffLeaves)
			)
		)
	)
)

(instance Dorff of SmallTalker
	(properties
		talkView 375
	)

	(method (init)
		(= client dorff)
		(self talkLoop: local5)
		(super init:)
	)
)

(instance sDorffTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff view: 375 setLoop: 2 setCel: 100)
				(= local5 0)
				(= local7 (proc0_8 1 5))
				(gMessager say: 20 0 3 local7 self)
			)
			(1
				(gGame handsOn:)
				(= local4 1)
				(dorff setCycle: Beg self)
			)
			(2
				(dorff
					view: 366
					setCycle: Walk
					setMotion: MoveTo (- (dorff x:) 35) (dorff y:) self
				)
			)
			(3
				(dorff setLoop: 1 setCel: 0)
				(self cue:)
			)
			(4
				(++ local8)
				(= seconds 1)
			)
			(5
				(if (or (IsFlag 8) (== local8 10))
					(self cue:)
				else
					(self changeState: (- state 1))
				)
			)
			(6
				(= local4 0)
				(if (IsFlag 8)
					(= cycles 80)
				else
					(self cue:)
				)
			)
			(7
				(= local8 0)
				(dorff setSpeed: 5)
				(dorff setScript: sDorffGetCart)
				(self dispose:)
			)
		)
	)
)

(instance sCartEntersCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (theEgo script:) sShowFace)
					(-- state)
					(= ticks 30)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOff:)
				(if (not local1)
					(gEgo setMotion: MoveTo 195 102 self)
				else
					(= ticks 1)
				)
			)
			(2
				(donut setMotion: MoveTo 204 85)
				(cartLights show: setMotion: MoveTo 202 111 self)
				(cart setMotion: MoveTo 219 115 self)
			)
			(3)
			(4
				(donut setMotion: MoveTo 180 73)
				(cartLights show: setMotion: MoveTo 178 99 self)
				(cart setMotion: MoveTo 195 103 self)
			)
			(5)
			(6
				(if (and (not local0) (not local1))
					(gEgo setHeading: 180)
				)
				(donut setMotion: MoveTo 162 73)
				(cartLights show: setMotion: MoveTo 160 99 self)
				(cart setMotion: MoveTo 177 103 self)
			)
			(7)
			(8
				(cartLights hide:)
				(cart approachX: 186 approachY: 105)
				(self dispose:)
			)
		)
	)
)

(instance sCartLeavesCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not local0) (not local1))
					(gEgo setMotion: MoveTo 195 102 self)
				else
					(= ticks 1)
				)
			)
			(1
				(donut setMotion: MoveTo 180 73)
				(cartLights show: setMotion: MoveTo 178 99 self)
				(cart setMotion: MoveTo 195 103 self)
			)
			(2)
			(3
				(donut setMotion: MoveTo 204 85)
				(cartLights show: setMotion: MoveTo 202 111 self)
				(cart setMotion: MoveTo 219 115 self)
			)
			(4)
			(5
				(if (and (not local0) (not local1))
					(gEgo setHeading: 180)
				)
				(donut setMotion: MoveTo 251 85)
				(cartLights show: setMotion: MoveTo 249 111 self)
				(cart setMotion: MoveTo 266 115 self)
			)
			(6)
			(7
				(cartLights hide:)
				(cart approachX: 240 approachY: 118)
				(self dispose:)
			)
		)
	)
)

(instance sDorffShutsField of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff view: 366 setCycle: Walk setMotion: MoveTo 175 120 self)
			)
			(1
				(dorff view: 366 setCycle: Walk setMotion: MoveTo 146 112 self)
			)
			(2
				(dorff view: 375 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(= ticks 5)
			)
			(4
				(if
					(or
						(not (gTalkers isEmpty:))
						(gEgo script:)
						(== (theEgo script:) sShowFace)
					)
					(-- state)
					(= ticks 20)
				else
					(= ticks 1)
				)
			)
			(5
				(if (and (not (IsFlag 8)) (IsFlag 34) (== local6 0))
					(if (or local14 (== (theEgo script:) sShowFace))
						(self changeState: 3)
					else
						(= local5 0)
						(= local6 1)
						(gEgo loop: 2)
						(gMessager say: 0 0 10 0 self) ; "Whoa, I see you have a visitor. I'll leave you two alone, but you know the rules. Ten more minutes and they have to leave."
					)
				else
					(= ticks 15)
				)
			)
			(6
				(dorff view: 373 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(7
				(= ticks 50)
			)
			(8
				(dorff setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(gGSound2 setLoop: 0 number: 354 play:)
				(= ticks 50)
			)
			(10
				(gGSound2 setLoop: 0 number: 372 play:)
				(button2Face show:)
				(rightFieldCover show:)
				(gCurRoom obstacles: fieldOffPolyList)
				(ClearFlag 9)
				(dorff setCycle: Beg)
				(cart setScript: sCartEntersCell self)
			)
			(11
				(dorff setCycle: End self)
			)
			(12
				(button2Face hide:)
				(rightFieldCover hide:)
				(gCurRoom obstacles: fieldOnPolyList)
				(SetFlag 9)
				(dorff setCycle: Beg self)
			)
			(13
				(if (and (gTalkers isEmpty:) (!= (theEgo script:) sShowFace))
					(dorff setSpeed: 5)
					(dorff setScript: sDorffTalk)
					(self dispose:)
				else
					(-- state)
					(= ticks 20)
				)
			)
		)
	)
)

(instance sDorffGetsFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(replicator init:)
				(repDoor init:)
				(= local3 2)
				(= ticks 1)
			)
			(1
				(dorff view: 375 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(dorff view: 371 setCel: 0 setLoop: 0 setCycle: CT 2 1 self)
			)
			(3
				(cond
					((== (= local12 (proc0_8 1 3)) 1)
						(gGSound2 number: 354)
					)
					((== local12 2)
						(gGSound2 number: 355)
					)
					((== local12 3)
						(gGSound2 number: 356)
					)
				)
				(gGSound2 loop: 0 play:)
				(dorff setSpeed: 5 setCycle: ROsc 1 2 3 self)
			)
			(4
				(cond
					((== (= local12 (proc0_8 1 3)) 1)
						(gGSound2 number: 354)
					)
					((== local12 2)
						(gGSound2 number: 355)
					)
					((== local12 3)
						(gGSound2 number: 356)
					)
				)
				(gGSound2 loop: 0 play:)
				(dorff cycleSpeed: 7 setCycle: End self)
			)
			(5
				(dorff setSpeed: 5)
				(= ticks 10)
			)
			(6
				(replicator setLoop: local3 setCel: 0 show: setCycle: End self)
			)
			(7
				(if (>= local3 4)
					(dorff
						view: 3720
						setCel: 0
						setLoop: (- local3 4)
						setCycle: CT 3 1 self
					)
				else
					(dorff
						view: 372
						setCel: 0
						setLoop: (- local3 2)
						setCycle: CT 3 1 self
					)
				)
			)
			(8
				(replicator hide:)
				(repDoor setCel: (repDoor lastCel:) show:)
				(if (and (== (dorff loop:) 1) (== (dorff view:) 3720))
					(dorff setCycle: CT 9 1 self)
				else
					(dorff setCycle: CT 10 1 self)
				)
			)
			(9
				(repDoor setCycle: Beg self)
				(cart setCel: (- local3 1))
				(dorff setCycle: End self)
			)
			(10
				(if (< local3 5)
					(++ local3)
					(self changeState: 2)
				else
					(cart view: 374 setLoop: 0 1 setCel: 0)
					(dorff setScript: sDorffShutsField)
					(dorff setSpeed: 5)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDorffGetsDonut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(replicator init:)
				(repDoor init:)
				(= local3 5)
				(= ticks 1)
			)
			(1
				(dorff view: 375 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(dorff view: 371 setCel: 0 setLoop: 0 setCycle: CT 2 1 self)
			)
			(3
				(cond
					((== (= local12 (proc0_8 1 3)) 1)
						(gGSound2 number: 354)
					)
					((== local12 2)
						(gGSound2 number: 355)
					)
					((== local12 3)
						(gGSound2 number: 356)
					)
				)
				(gGSound2 play:)
				(dorff cycleSpeed: 4 setCycle: ROsc 1 2 3 self)
			)
			(4
				(cond
					((== (= local12 (proc0_8 1 3)) 1)
						(gGSound2 number: 354)
					)
					((== local12 2)
						(gGSound2 number: 355)
					)
					((== local12 3)
						(gGSound2 number: 356)
					)
				)
				(gGSound2 play:)
				(dorff cycleSpeed: 7 setCycle: End self)
			)
			(5
				(= ticks 30)
			)
			(6
				(replicator setLoop: local3 setCel: 0 show: setCycle: End self)
			)
			(7
				(dorff
					view: 3720
					setCel: 0
					setLoop: (- local3 4)
					setCycle: CT 3 1 self
				)
			)
			(8
				(replicator hide:)
				(repDoor setCel: (repDoor lastCel:) setCycle: Beg show:)
				(dorff setCycle: CT 8 1 self)
			)
			(9
				(donut show: posn: (- (cart x:) 15) (- (cart y:) 30))
				(dorff setCycle: End self)
			)
			(10
				(cart view: 374 setLoop: 1 1 setCel: 0)
				(SetFlag 89)
				(dorff setScript: sDorffShutsField)
				(dorff setSpeed: 5)
				(self dispose:)
			)
		)
	)
)

(instance sDorffEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 371) ; WAVE
				(Load 140 372) ; WAVE
				(Load 140 373) ; WAVE
				(Load 140 374) ; WAVE
				(Load 140 375) ; WAVE
				(Load rsVIEW 375)
				(Load rsVIEW 376)
				(Load rsVIEW 377)
				(Load rsVIEW 3660)
				(Load rsVIEW 373)
				(Load rsVIEW 371)
				(Load rsVIEW 3720)
				(Load rsVIEW 372)
				(Load rsVIEW 374)
				(= seconds 5)
			)
			(1
				(= local4 0)
				(gGSound2 number: 941 loop: 1 play:)
				(dorff
					view: 3660
					setLoop: 2
					setCel: 0
					show:
					posn: 296 134
					setCycle: End self
				)
			)
			(2
				(if local1
					(gEgo setCycle: End self)
				else
					(self changeState: 3)
				)
			)
			(3
				(dorff view: 366 setCycle: Walk setMotion: MoveTo 272 121 self)
			)
			(4
				(cond
					(
						(or
							(and (== (cart loop:) 0) (== (cart view:) 374))
							(IsFlag 89)
						)
						(dorff setScript: sDorffShutsField)
					)
					((or (gEgo has: 52) (gEgo has: 39) (IsFlag 34)) ; Gragh, dummy6
						(gGame handsOn:)
						(dorff setScript: sDorffGetsDonut)
					)
					(else
						(gGame handsOn:)
						(dorff setScript: sDorffGetsFood)
					)
				)
				(dorff setSpeed: 5)
				(self dispose:)
			)
		)
	)
)

(instance sToggleLeftField of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 95 114 self)
				(= local13 1)
			)
			(1
				(gEgo
					view: 378
					cycleSpeed: 7
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gGSound2 setLoop: 0 number: 354 play:)
				(= ticks 50)
			)
			(3
				(gGSound2 setLoop: 0 number: 372 play:)
				(button1Face show:)
				(leftFieldCover show:)
				(gEgo
					view: 378
					cycleSpeed: 7
					setLoop: 1
					setCel: 100
					setCycle: Beg self
				)
			)
			(4
				(Load 140 265) ; WAVE
				(= ticks 1)
			)
			(5
				(gGSound1 number: 378 setLoop: -1 play:)
				(gEgo
					view: 3702
					cel: 0
					loop: 0
					cycleSpeed: 8
					setCycle: CT 12 1 self
				)
			)
			(6
				(gGSound2 number: 265 loop: 0 play:)
				(gEgo cycleSpeed: 8 setCycle: CT 22 1 self)
			)
			(7
				(gGSound2 number: 265 loop: 0 play:)
				(gEgo cycleSpeed: 8 setCycle: CT 54 1 self)
			)
			(8
				(gGSound2 number: 376 loop: 0 play:)
				(gEgo cycleSpeed: 8 setCycle: CT 63 1 self)
			)
			(9
				(gGSound2 number: 376 loop: 0 play:)
				(gEgo cycleSpeed: 8 setCycle: CT 72 1 self)
			)
			(10
				(gGSound2 number: 376 loop: 0 play:)
				(gEgo cycleSpeed: 8 setCycle: CT 79 1 self)
			)
			(11
				(gGSound2 number: 376 loop: 0 play: self)
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(12
				(gEgo hide:)
			)
			(13
				(gEgo hide:)
				(gMessager say: 13 4 0 2 self) ; "Game over, Man, game over!"
			)
			(14
				(gGSound1 number: 990 setLoop: -1 play:)
				(proc666_0 12 self)
			)
			(15
				(gGSound1 number: 370 setLoop: -1 play:)
				(gEgo show:)
				(gEgo normalize: 3)
				(gGame handsOn:)
				(leftFieldCover hide:)
				(button1Face hide:)
				(= local13 0)
				(self dispose:)
			)
		)
	)
)

(instance sToggleRightField of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 161 114 self)
			)
			(1
				(gEgo
					view: 378
					cycleSpeed: 7
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gGSound2 setLoop: 0 number: 354 play:)
				(= ticks 50)
			)
			(3
				(if (IsFlag 9)
					(gGSound2 setLoop: 0 number: 372 play:)
					(button2Face show:)
					(rightFieldCover show:)
					(gCurRoom obstacles: fieldOffPolyList)
					(ClearFlag 9)
				else
					(gGSound2 setLoop: 0 number: 371 play:)
					(button2Face hide:)
					(rightFieldCover hide:)
					(gCurRoom obstacles: fieldOnPolyList)
					(SetFlag 9)
				)
				(gEgo setCel: (gEgo lastCel:) setCycle: Beg self)
			)
			(4
				(gMessager say: 14 4) ; "You flick the force field on and off, just so you can feel like a real Security guy."
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRandomEvents of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (proc0_8 10 25))
			)
			(1
				(if local13
					(self changeState: 0)
				else
					(= ticks 1)
				)
			)
			(2
				(switch (proc0_8 1 3)
					(1
						(gGSound2 setLoop: 0 number: 374 play:)
						(leftToilet setCycle: End self)
					)
					(2
						(if (not local15)
							(= local15 1)
							(gGSound2 setLoop: 0 number: 373 play:)
							(theEgo show: setCycle: End self)
						)
					)
					(3
						(gGSound2 setLoop: 0 number: 375 play:)
						(leftBed setCycle: End self)
					)
				)
			)
			(3
				(leftBed setCel: 0)
				(leftToilet setCel: 0)
				(= local15 0)
				(theEgo setCel: 0 hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sRogerSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 205 102 self)
			)
			(1
				(gEgo state: (& (gEgo state:) $fffd))
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 370
					posn: 206 102
					setLoop: 2
					setCel: (gEgo lastCel:)
					cycleSpeed: 7
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					setLoop: 1
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					setLoop: 0
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(gWalkHandler add: gCurRoom)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gUser canInput:)
					(gGame handsOff:)
				)
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 7 setCycle: End self)
			)
			(1
				(gEgo normalize: 2)
				(gWalkHandler delete: gCurRoom)
				(= local1 0)
				(if (not register)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 296 129
					setPri: 400
					init:
				)
				(= seconds 4)
			)
			(1
				(gGSound2 number: 941 loop: 1 play:)
				(= ticks 55)
			)
			(2
				(gEgo cycleSpeed: 7 setCycle: End self)
			)
			(3
				(gEgo normalize: 2 setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 0 init:)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(gGSound2 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					cycleSpeed: 7
					posn: 296 131
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: global119)
				(self dispose:)
			)
		)
	)
)

(instance drog of Actor
	(properties
		noun 22
		x 205
		y 107
		view 3760
		cel 1
		signal 4129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Nice!"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "You marvel at how much more handsome this prisoner looks compared to the last one."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance donut of Actor
	(properties
		noun 23
		view 374
		signal 4129
	)

	(method (init)
		(super init:)
		(self
			setCel: 1
			setLoop: 1 1
			setCycle: 0
			posn: (- (cart x:) 22) (- (cart y:) 29)
			setPri: (+ (cart y:) 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 31) ; Donut
						(gMessager say: noun theVerb) ; "You don't need two doughnuts. Trust me."
					)
					((and (< (gEgo y:) 108) (IsFlag 9))
						(gGame points: 3)
						(gEgo setScript: sGetInCart)
					)
					(else
						(gEgo setScript: sGetDonut)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance repDoor of Prop
	(properties
		view 371
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setCel: (self lastCel:) posn: 285 78 hide:)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance replicator of Prop
	(properties
		view 371
	)

	(method (init)
		(super init:)
		(self setLoop: 2 setCel: 0 posn: 285 78)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance dorff of Actor
	(properties
		noun 20
		view 3660
		signal 16417
	)

	(method (init)
		(super init:)
		(self setSpeed: 5 setLoop: 0 setCel: 0 setScript: sDorffEnters)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cartLights of Actor
	(properties
		view 374
		signal 16417
	)

	(method (init)
		(super init:)
		(self setLoop: 2 1 setCycle: Fwd hide:)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance cart of Actor
	(properties
		noun 21
		approachX 240
		approachY 120
		view 3721
		signal 20513
	)

	(method (init)
		(self setPri: 117 setLoop: 0 setCel: 0 posn: 266 115)
		(cartLights init: posn: (- (cart x:) 17) (- (cart y:) 4))
		(super init: &rest)
	)

	(method (doit)
		(self setPri: (+ y 2))
		(donut setPri: (+ priority 2))
		(cartLights setPri: (+ priority 1))
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(
						(and
							(== (cart y:) 103)
							(== (cart loop:) 0)
							(== (cart view:) 374)
							(< (gEgo y:) 108)
							(IsFlag 9)
						)
						(gGame points: 1)
						(gEgo setScript: sTakeFood)
					)
					((and (== (cart y:) 103) (IsFlag 34) local4)
						(if (IsFlag 89)
							(gGame points: 3)
							(gEgo setScript: sGetInCart)
						else
							(gMessager say: noun theVerb 8) ; "Not now. Dorff is looking."
						)
					)
					((and (== (cart y:) 103) (not (IsFlag 34)) local4)
						(gMessager say: noun theVerb 9) ; "While that's an interesting idea, even Dorff would notice that something would be missing where there were two things -- the cart and you."
					)
					((and (== (cart y:) 103) (not local4))
						(gMessager say: 21 4 8) ; "Not now. Dorff is looking."
					)
					((and (< (gEgo y:) 108) (IsFlag 9) (!= (cart y:) 103))
						(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(else
						(gMessager say: 0 4 0 5 0 0) ; "You summon the ability to leave it alone."
					)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "It's a hovercraft for transporting replicated food."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance theEgo of Prop
	(properties
		noun 9
		approachX 69
		approachY 112
		x 60
		y 105
		view 3701
		cycleSpeed 12
	)

	(method (init)
		(self
			setPri: 111
			setCel: (self lastCel:)
			setLoop: 0
			hide:
			setScript: sRandomEvents
		)
		(super init:)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 3)
			(switch theVerb
				(1 ; Look
					(gMessager say: noun theVerb 1) ; "You can hear him and sense his presence, but you can't see him. Which is a good thing if you've just eaten."
				)
				(2 ; Talk
					(gMessager say: 9 2) ; "Hey, if I tease you enough, will you bust out of there and kill me, or what?"
				)
				(else
					(gMessager say: noun 4 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance leftBed of Prop
	(properties
		noun 7
		approachX 104
		approachY 112
		x 83
		y 81
		view 3700
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 110 setLoop: 0 setCel: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
				else
					(gMessager say: noun theVerb) ; "With the force field in place, you can't reach anything in that cell without demolecularizing your arm (which is a trip and a half, but you've kinda grown attached to it)."
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Well, the way this room is arranged, and given that you're locked inside the cell, if you stretch your neck reallll hard ..."
				else
					(gMessager say: noun theVerb) ; "It's a plain Quadro-Full cot. You don't get those nice shimmery sheets when you're in the brig."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance leftToilet of Prop
	(properties
		noun 12
		approachX 24
		approachY 112
		x 17
		y 79
		view 3700
	)

	(method (init)
		(self setPri: 110 setLoop: 1 setCel: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "The only way you'll be able to see that is if you stick your head far enough through the pipes. But you'd probably drown."
				else
					(gMessager say: noun theVerb) ; "This is a receptacle for digestive by-products, which are then briefly churned with dihydrogen oxide and then transported under pressure into the tanks in the Replicator subprocessing unit."
				)
			)
			(4 ; Do
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
				else
					(gMessager say: noun theVerb) ; "With the force field in place, you can't reach anything in that cell without demolecularizing your arm (which is a trip and a half, but you've kinda grown attached to it)."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance button1Face of View
	(properties
		view 373
	)

	(method (init)
		(super init: &rest)
		(self posn: 122 71 setPri: 110 setLoop: 2 setCel: 1 hide:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gEgo setScript: sComputer)
		else
			(super doVerb: theVerb)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance button2Face of View
	(properties
		view 373
	)

	(method (init)
		(self posn: 123 77 setPri: 110 setLoop: 2 setCel: 0 show:)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gEgo setScript: sComputer)
		else
			(super doVerb: theVerb)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance rightFieldCover of View
	(properties
		view 379
		signal 20513
	)

	(method (init)
		(self posn: 141 108 setPri: 115 setLoop: 0 setCel: 1 show:)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance leftFieldCover of View
	(properties
		x 17
		y 108
		view 379
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self posn: 17 108 setPri: 110 setLoop: 0 setCel: 0 hide:)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance button1 of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 95
		approachY 114
		x 130
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 75 138 75 138 70 125 70 120 72
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 3)
						(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(local2
						(gEgo setScript: sToggleLeftField)
					)
					(else
						(= local2 1)
						(gMessager say: noun theVerb 0 1) ; "Now there's a real bright idea. But then, perhaps you'd deserve the consequences. If the force field were turned off, you'd be the only one to suffer the consequences. In the event that someone might be looking over your shoulder, we'll save your embarrassment for another time."
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Well, the way this room is arranged, and given that you're locked inside the cell, if you stretch your neck reallll hard ..."
				else
					(gMessager say: noun theVerb) ; "This sensor pad controls the force field grid for Cell 105."
				)
			)
			(2 ; Talk
				(gEgo setScript: sComputer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance button2 of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 161
		approachY 114
		x 130
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 76 122 81 136 81 140 78 135 76
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 3)
						(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					((IsFlag 8)
						(gMessager say: 3 4 2) ; "Oh, no, I'm not going in THERE again."
					)
					(else
						(gEgo setScript: sToggleRightField)
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Well, the way this room is arranged, and given that you're locked inside the cell, if you stretch your neck reallll hard ..."
				else
					(gMessager say: noun theVerb) ; "This sensor pad controls the force field grid for Cell 106."
				)
			)
			(2 ; Talk
				(gEgo setScript: sComputer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance comPost of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 296
		approachY 131
		x 297
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 88 304 99 316 102 316 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9))
						(gMessager say: noun theVerb 1) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(gCurRoom newRoom: 460)
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "That ComPost represents freedom! Ah, sweet freedom ... you never realize how much you miss something until you've screwed it up so badly that you don't have anything like it anymore."
				else
					(gMessager say: noun theVerb) ; "This is your standard shipwide ComPost panel. Surely you must recognize it by now!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance rightBed of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 205
		approachY 102
		x 210
		y 87
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 87 218 96 242 96 242 91 206 83 186 83
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 34)
						(gMessager say: noun theVerb 4) ; "Hey! There's someone in your "spot.""
					)
					((and (> (gEgo y:) 109) (IsFlag 9))
						(gMessager say: 0 theVerb 6) ; "You don't seem to be able to gain access."
					)
					((IsFlag 8)
						(gEgo setScript: sNoWay)
					)
					((not local1)
						(gEgo setScript: sRogerSits)
					)
					((and local1 (IsFlag 3))
						(gMessager say: noun theVerb 1) ; "You prod the bed a little bit, just to make sure it isn't moving on its own."
					)
					(else
						(gMessager say: noun theVerb) ; "There's nothing like the feel of imitation orat hide."
					)
				)
			)
			(1 ; Look
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9))
						(gMessager say: noun theVerb 1) ; "This is now YOUR bed. Suddenly you find yourself wondering what kind of festering, slimy, pus-laden criminals have sat on this very bed. And what they've left behind."
					)
					((IsFlag 8)
						(gMessager say: noun theVerb 2) ; "The bed now resembles a buffet table."
					)
					(else
						(gMessager say: noun theVerb) ; "It's a plain Quadro-Full cot. You don't get those nice shimmery sheets when you're in the brig."
					)
				)
			)
			(84 ; dummy6
				(cond
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(local4
						(gEgo setScript: sBuildDummy)
					)
					(else
						(gMessager say: 21 4 8) ; "Not now. Dorff is looking."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance rightSink of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 149
		approachY 100
		x 148
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 68 151 68 156 73 156 75 149 80 149 86 143 86 143 83 145 80 141 75
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gMessager say: noun theVerb 1 0 0) ; "Why doesn't this darned sink work? What's WRONG with this ship, anyway? Prisoners have rights, too, y'know! This is an outrage! This treatment is inhumane! I'm sorry, but I'm peeved!"
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					((and (> (gEgo y:) 109) (IsFlag 9))
						(gMessager say: 0 theVerb 6) ; "You don't seem to be able to gain access."
					)
					((IsFlag 8)
						(gEgo setScript: sNoWay)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "If you look at it, it's a sink. If you smell it, it's a toilet."
				else
					(gMessager say: noun theVerb) ; "This is a dispenser that releases a steady stream of dihydrogen oxide, a colorless limpid liquid compound that acts as a solvent and keeps bodily tissues from dehydrating."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightToilet of Feature
	(properties
		noun 17
		sightAngle 40
		approachX 149
		approachY 100
		x 142
		y 180
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 87 147 87 149 90 147 94 145 98 147 99 147 100 141 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "I don't have to go right now. I went just before you started playing."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					((and (> (gEgo y:) 109) (IsFlag 9))
						(gMessager say: 0 theVerb 6) ; "You don't seem to be able to gain access."
					)
					((IsFlag 8)
						(gEgo setScript: sNoWay)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "It looks like a john.*"
				else
					(gMessager say: noun theVerb) ; "This is a receptacle for digestive by-products, which are then briefly churned with dihydrogen oxide and then transported under pressure into the tanks in the Replicator subprocessing unit."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightCel of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 178
		approachY 102
		x 190
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 38 141 107 244 107 244 38
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1) ; "As you run your hand over the grafitti-covered bare Plasto-stone walls of the cell, you wonder why nobody ever cleans this place."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					((and (> (gEgo y:) 109) (IsFlag 9))
						(gMessager say: 0 theVerb 6) ; "You don't seem to be able to gain access."
					)
					((IsFlag 8)
						(gEgo setScript: sNoWay)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9))
						(gMessager say: noun theVerb 1) ; "Home, sweet home -- until you figure out how to get out of here and away from that nearsighted security guard."
					)
					((IsFlag 8)
						(gMessager say: noun theVerb 2) ; "Why ... that's the cell where you spent the most hellish twenty minutes of your entire life!"
					)
					(else
						(gMessager say: noun theVerb) ; "Cell 106 is infamous for the permanent blood stain on the floor. That stain came into being when Red Bovine, a Ferbangi slave trader, tried to escape by crawling out the porthole and immediately imploded."
					)
				)
			)
			(2 ; Talk
				(gEgo setScript: sHalt)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightWindow of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 180
		approachY 98
		x 180
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 55 164 63 169 69 182 72 190 70 194 64 194 60 192 54 189 50 180 47 175 48 168 51
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gMessager say: noun theVerb 1) ; "In desperation, you attempt to bend the bars, roll the toilet paper out the window, slide down the roll and escape."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					((and (> (gEgo y:) 109) (IsFlag 9))
						(gMessager say: 0 theVerb 6) ; "You don't seem to be able to gain access."
					)
					((IsFlag 8)
						(gEgo setScript: sNoWay)
					)
					(else
						(gMessager say: noun theVerb) ; "Last time you checked, you weren't Superman."
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Gazing out the window reminds you of a legendary prisoner named the Birdman of DeepShip 12, who raised homing pigeons in his cell for months."
				else
					(gMessager say: noun theVerb) ; "Gazing out at the peaceful stars drifting slowly by, you can't help but be overcome with a sense of your own total insignificance."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftSink of Feature
	(properties
		noun 1
		sightAngle 40
		approachX 46
		approachY 112
		x 44
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 70 40 68 48 68 51 73 51 75 46 80 46 83 48 85 45 88 42 88 40 86 40 84 42 82 42 80 36 75
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Well, the way this room is arranged, and given that you're locked inside the cell, if you stretch your neck reallll hard ..."
				else
					(gMessager say: noun theVerb) ; "This is a dispenser that releases a steady stream of dihydrogen oxide, a colorless limpid liquid compound that acts as a solvent and keeps bodily tissues from dehydrating."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftWindow of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 79
		approachY 112
		x 76
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 68 73 71 80 72 84 71 91 65 93 60 91 54 86 49 78 46 71 47 65 51 62 59
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "Well, the way this room is arranged, and given that you're locked inside the cell, if you stretch your neck reallll hard ..."
				else
					(gMessager say: noun theVerb) ; "Wow! You can see your house from here!"
				)
			)
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubeTop of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 296
		approachY 131
		x 297
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 0 277 21 288 23 304 23 313 20 313 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubeBottom of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 296
		approachY 131
		x 297
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 130 282 133 295 135 309 133 312 131 309 128 296 126 282 127
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foodRep of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 282
		approachY 123
		x 283
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 45 277 118 300 124 300 45
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9))
						(gMessager say: noun theVerb 1 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(gCurRoom setInset: (ScriptID 800 0) 0 0 1) ; foodReplicatorInset
					)
				)
			)
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "As you look at the Replicator, the old adage "You are what you eat" floats to the surface of your consciousness (along with all the other scum pooling around up there). What could that mean?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(gEgo setScript: sTea)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance leftCel of Feature
	(properties
		noun 11
		nsLeft 16
		nsTop 39
		nsRight 121
		nsBottom 110
		sightAngle 40
		approachX 69
		approachY 112
		x 69
		y 70
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1 0 0) ; "What are you, Plastic Man? You can't possibly reach anything outside the cell when you're locked in."
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Talk
				(if (not local15)
					(= local15 1)
					(theEgo setScript: sShowFace)
				else
					(gMessager say: noun theVerb) ; "Hey, handsome! Let's see that pretty li'l face!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance paper of Feature
	(properties
		noun 19
		nsLeft 19
		nsTop 79
		nsRight 26
		nsBottom 83
		sightAngle 40
		approachX 24
		approachY 112
		x 17
		y 80
	)

	(method (facingMe)
		(if local1
			(return 1)
		else
			(super facingMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (< (gEgo y:) 108) (IsFlag 9))
					(gMessager say: noun theVerb 1) ; "You can't see the paper from where you are, but you just KNOW it's quilted."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(cond
					((and (< (gEgo y:) 108) (IsFlag 9) (not local1))
						(gEgo normalize: 2)
						(gMessager say: noun theVerb 1) ; "You can't reach it from here, but by feeling the paper in your own cell, you just know the paper in the left cell is soft and smooth on your bottom!"
					)
					(local1
						(gEgo setScript: sRogerStands 0 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fieldOnCellPoly of Polygon
	(properties)

	(method (init)
		(self type: 3)
		(super
			init:
				186
				95
				147
				95
				154
				97
				154
				100
				146
				102
				143
				103
				130
				104
				133
				104
				215
				104
		)
	)
)

(instance fieldOnRoomPoly of Polygon
	(properties)

	(method (init)
		(self type: 3)
		(super init: 18 112 11 136 319 136 263 112)
	)
)

(instance cartPolyOn of Polygon
	(properties)

	(method (init)
		(self type: 2)
		(super init: 218 116 260 116 276 119 235 119)
	)
)

(instance fieldOnPolyList of List
	(properties)

	(method (init)
		(fieldOnCellPoly init:)
		(fieldOnRoomPoly init:)
		(cartPolyOn init:)
		(self add: fieldOnCellPoly fieldOnRoomPoly cartPolyOn)
		(super init:)
	)
)

(instance fieldOffPoly of Polygon
	(properties)

	(method (init)
		(self type: 3)
		(super
			init:
				147
				95
				153
				97
				153
				100
				145
				102
				130
				104
				133
				105
				145
				105
				147
				112
				15
				112
				7
				137
				318
				137
				318
				130
				264
				112
				235
				112
				190
				95
		)
	)
)

(instance cartPolyOff of Polygon
	(properties)

	(method (init)
		(self type: 2)
		(super init: 218 115 260 115 278 119 235 119)
	)
)

(instance fieldOffPolyList of List
	(properties)

	(method (init)
		(fieldOffPoly init:)
		(cartPolyOff init:)
		(self add: fieldOffPoly cartPolyOff)
		(super init:)
	)
)

