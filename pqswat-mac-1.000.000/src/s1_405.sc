;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4051)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use WalkieTalkie)
(use Timer)
(use Actor)
(use System)

(public
	s1_405 0
	doLash 1
)

(local
	local0
	local1
)

(instance s1_405 of PQRoom
	(properties
		modNum 405
		picture 405
	)

	(method (init)
		(SetFlag 14)
		(SetFlag 12)
		(SetFlag 110)
		(super init: &rest)
		(gSwatInterface setMaxInvLevel: 1)
		(Load rsVIEW 4100)
		(Lock rsAUDIO 40101 0)
		(= global114 okToShoot)
		(greaseBoard init:)
		(if (IsFlag 77)
			(self setScript: briefing2)
		else
			(self setScript: briefing1)
		)
	)

	(method (dispose)
		(if (gTimers contains: briefTimer)
			(briefTimer dispose: delete:)
		)
		(proc4_5)
		(= global432 0)
		(ClearFlag 110)
		(ClearFlag 14)
		(gSwatInterface setMaxInvLevel: 4)
		(super dispose:)
	)
)

(instance briefing1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKeyDownHandler addToFront: self)
				(WalkieTalkie showFrame: 40500 0 185 44)
				(= global128 40500)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(2
				(proc4_6 40500 185 44 0 0 -1 1)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 410)
				(= global432 stopTalkers)
				(= cycles 2)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gMessager say: 0 0 12 1 0 405) ; "This is the layout of the house. On side one we have a front door entrance. This is a dangerous approach as it has two windows to contend with: the large front window and a small kitchen window. To compensate for that, we've placed snipers here..."
				(= ticks 10)
			)
			(6
				(houseMap init:)
				(= ticks 110)
			)
			(7
				(houseMap dispose:)
				(sideOne init:)
				(= ticks 60)
			)
			(8
				(sideOne dispose:)
				(frontDoor init:)
				(= ticks 300)
			)
			(9
				(frontDoor dispose:)
				(livRmWindow init:)
				(= ticks 120)
			)
			(10
				(livRmWindow dispose:)
				(kitchenWindow init:)
				(= ticks 240)
			)
			(11
				(gMessager say: 0 0 12 2 self 405) ; "...on this side of the street to watch those ports. Apparently, this house has been somewhat fortified over the years. The garage has been sealed off from the house."
				(kitchenWindow dispose:)
				(xMark init:)
				(= ticks 380)
			)
			(12
				(xMark dispose:)
				(garage init:)
			)
			(13
				(gMessager say: 0 0 12 3 self 405) ; "Side three has one opening, a barricaded window."
				(= ticks 60)
			)
			(14
				(garage dispose:)
				(sideThree init:)
				(= ticks 60)
			)
			(15
				(sideThree dispose:)
				(bedRmWindow init:)
			)
			(16
				(if (== global108 3)
					(gMessager say: 0 0 14 0 self 405) ; "While negotiations continue with the suspect, we're going to place an emergency assault team on side one, for entry through opening two. The emergency entry team will consist of the following: Carmichael - Scout, Pup - Rear Guard, Pacmeyer - Element Lead, Containment - Denton. For rear containment, side three: Rhea and Wixell. Any questions?"
				else
					(gMessager say: 0 0 20 0 self 405) ; "While negotiations continue with the suspect, we're going to place an emergency assault team on side one, for entry through opening two. The emergency entry team will consist of the following: Rhea - Scout, Denton - Rear Guard, Pacmeyer - Element Lead. For rear containment, side three: Pup and Wixell. Any questions?"
				)
				(= ticks 300)
			)
			(17
				(bedRmWindow dispose:)
				(sideOne init:)
				(= ticks 120)
			)
			(18
				(sideOne dispose:)
				(frontDoor init:)
				(= ticks 540)
			)
			(19
				(frontDoor dispose:)
				(sideThree init:)
			)
			(20
				(gKeyDownHandler delete: self)
				(gCast eachElementDo: #dispose)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(sideThree dispose:)
				(rooker init:)
				(pacmeyer init:)
				(greaseBoard init:)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 405)
				(= cycles 2)
			)
			(21
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(briefTimer setReal: briefTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(event claimed: 1)
				(= seconds (= cycles 0))
				(if gAutoRobot
					(proc4_5)
					(= state 2)
				else
					(= state 19)
					(if (not (gTalkers isEmpty:))
						(gTalkers eachElementDo: #perform disposeMyself)
					)
				)
				(self cue:)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance briefing2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKeyDownHandler addToFront: self)
				(WalkieTalkie showFrame: 40559 0 193 84)
				(= global128 40559)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(2
				(Load rsAUDIO 40102)
				(Lock rsAUDIO 40102 1)
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40102 loop: -1 play:)
				(UnLoad 141 40101)
				(proc4_6 40559 193 84 0 0 -1 1)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 410)
				(= global432 stopTalkers)
				(= cycles 2)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gMessager say: 0 0 13 1 self 405) ; "The layout of the house is as follows. Side one, opening two is the front door. Complicating this approach are openings one..."
				(= ticks 160)
			)
			(6
				(sideOne init:)
				(= ticks 20)
			)
			(7
				(sideOne dispose:)
				(frontDoor init:)
				(= ticks 240)
			)
			(8
				(frontDoor dispose:)
				(livRmWindow init:)
			)
			(9
				(gMessager say: 0 0 13 2 self 405) ; "...and three."
				(kitchenWindow init:)
			)
			(10
				(gMessager say: 0 0 13 3 0 405) ; "Both opening one and three are barricaded but could be used to conceal a threat. To help eliminate that threat, we've placed snipers here..."
				(= ticks 440)
			)
			(11
				(livRmWindow dispose:)
				(kitchenWindow dispose:)
				(xMark init:)
				(gMessager say: 0 0 13 4 self 405) ; "...on this side of the street to watch those ports. There is no access from the garage into the house."
				(= ticks 260)
			)
			(12
				(xMark dispose:)
				(garage init:)
			)
			(13
				(gMessager say: 0 0 13 5 self 405) ; "Opening one on side three is a barricaded window leading to the bedroom."
				(= ticks 60)
			)
			(14
				(garage dispose:)
				(bedRmWindow init:)
			)
			(15
				(if (== global108 3)
					(gMessager say: 0 0 15 0 self 405) ; "While negotiations continue with the suspect, we're going to place an emergency assault team on side one, for entry through opening two. The emergency entry team will consist of the following: Carmichael - Scout, Pup - Rear Guard, Pacmeyer - Element Lead. For rear containment, side three: Rhea and Wixell. Any questions?"
				else
					(gMessager say: 0 0 18 0 self 405) ; "While negotiations continue with the suspect, we're going to place an emergency assault team on side one, for entry through opening two. The emergency entry team will consist of the following: Rhea - Scout, Denton - Rear Guard, Pacmeyer - Element Lead. For rear containment, side three: Pup and Wixell. Any questions?"
				)
				(= ticks 300)
			)
			(16
				(bedRmWindow dispose:)
				(sideOne init:)
				(= ticks 120)
			)
			(17
				(sideOne dispose:)
				(frontDoor init:)
				(= ticks 540)
			)
			(18
				(frontDoor dispose:)
				(sideThree init:)
			)
			(19
				(gKeyDownHandler delete: self)
				(gCast eachElementDo: #dispose)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(rooker2 init:)
				(pacmeyer2 init:)
				(greaseBoard init:)
				(xMark dispose:)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 405)
				(= cycles 2)
			)
			(20
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(briefTimer setReal: briefTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(event claimed: 1)
				(= seconds (= cycles 0))
				(if gAutoRobot
					(proc4_5)
					(= state 2)
				else
					(= state 18)
					(if (not (gTalkers isEmpty:))
						(gTalkers eachElementDo: #perform disposeMyself)
					)
				)
				(self cue:)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance startScenario of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 77)
				(if (gTimers contains: briefTimer)
					(briefTimer dispose: delete:)
				)
				(gGame handsOff:)
				(gFxSound number: 40501 setLoop: 1 play: self)
			)
			(1
				(= seconds 2)
			)
			(2
				(Lock rsAUDIO 40102 0)
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40102)
				(gGame showCloseUp: 40507 180 70 self 1)
			)
			(3
				(= global114 0)
				(if (== global108 2)
					(gCurRoom newRoom: 4010) ; s1_4010
				else
					(gCurRoom newRoom: 4350) ; s1_4350
				)
			)
		)
	)
)

(instance talkToPacmeyer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(briefTimer setReal: briefTimer 15)
				(cond
					((== global108 2)
						(if (or local0 (IsFlag 77))
							(gGame showCloseUp: 40566 180 70 self)
						else
							(if (IsFlag 160)
								(gGame showCloseUp: 40508 180 70 self)
							else
								(gGame showCloseUp: 40509 180 70 self)
							)
							(= local0 1)
						)
					)
					(local0
						(gGame showCloseUp: 40567 180 70 self)
					)
					(else
						(= local0 1)
						(gGame showCloseUp: 40506 180 70 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToRooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(briefTimer setReal: briefTimer 15)
				(if local1
					(gGame showCloseUp: 40580 180 70 self)
				else
					(= local1 1)
					(gGame showCloseUp: 40579 180 70 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance invOnPacmeyer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(briefTimer setReal: briefTimer 15)
				(switch register
					(6
						(= temp0 40568)
					)
					(7
						(= temp0 40569)
					)
					(8
						(= temp0 40570)
					)
					(40
						(= temp0 40595)
					)
					(16
						(= temp0 40596)
					)
					(52
						(= temp0 40573)
					)
					(53
						(= temp0 40574)
					)
					(35
						(= temp0 40575)
					)
					(36
						(= temp0 40576)
					)
					(38
						(= temp0 40570)
					)
					(39
						(= temp0 40570)
					)
					(14
						(= temp0 40577)
					)
				)
				(gGame handsOff: showCloseUp: temp0 180 70 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance invOnRooker of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(briefTimer setReal: briefTimer 15)
				(switch register
					(6
						(if (== global108 2)
							(= temp0 40581)
						else
							(= temp0 40560)
						)
					)
					(7
						(= temp0 40569)
					)
					(8
						(= temp0 40570)
					)
					(40
						(= temp0 40584)
					)
					(16
						(= temp0 40596)
					)
					(52
						(= temp0 40586)
					)
					(53
						(= temp0 40587)
					)
					(35
						(= temp0 40588)
					)
					(36
						(= temp0 40589)
					)
					(38
						(= temp0 40570)
					)
					(39
						(= temp0 40583)
					)
					(14
						(= temp0 40530)
					)
				)
				(gGame handsOff: showCloseUp: temp0 180 70 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doLash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(briefTimer setReal: briefTimer 15)
				(gFxSound number: 5 setLoop: 1 play: self)
			)
			(1
				(= seconds 3)
			)
			(2
				(gGame showCloseUp: 40578 180 70 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGreaseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(briefTimer setReal: briefTimer 15)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCurRoom drawPic: 410)
				(gCast eachElementDo: #hide)
				(northE init:)
				(eastE init:)
				(westE init:)
				(southE init:)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(self dispose:)
			)
		)
	)
)

(instance exitGreaseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(briefTimer setReal: briefTimer 15)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCurRoom drawPic: 405)
				(gCast eachElementDo: #show)
				(northE dispose:)
				(eastE dispose:)
				(westE dispose:)
				(southE dispose:)
				(= cycles 2)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(self dispose:)
			)
		)
	)
)

(instance rooker of View
	(properties
		x 187
		y 82
		view 40500
		cel 1
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 29)
				(gCurRoom setScript: talkToRooker)
			)
			((OneOf theVerb 6 8 7 36 53 52 35 38 39 16 14 40)
				(gCurRoom setScript: invOnRooker 0 theVerb)
			)
		)
	)
)

(instance pacmeyer of View
	(properties
		x 187
		y 82
		view 40500
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 29)
				(gCurRoom setScript: talkToPacmeyer)
			)
			((OneOf theVerb 6 8 7 36 53 52 35 38 39 16 14 40)
				(gCurRoom setScript: invOnPacmeyer 0 theVerb)
			)
		)
	)
)

(instance rooker2 of View
	(properties
		x 195
		y 267
		view 40559
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 29)
				(gCurRoom setScript: talkToRooker)
			)
			((OneOf theVerb 6 8 7 36 53 52 35 38 39 16 14 40)
				(gCurRoom setScript: invOnRooker 0 theVerb)
			)
		)
	)
)

(instance pacmeyer2 of View
	(properties
		x 317
		y 264
		view 40559
		cel 1
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 29)
				(gCurRoom setScript: talkToPacmeyer)
			)
			((OneOf theVerb 6 8 7 36 53 52 35 38 39 16 14 40)
				(gCurRoom setScript: invOnPacmeyer 0 theVerb)
			)
		)
	)
)

(instance greaseBoard of View
	(properties
		modNum 405
		x 441
		y 176
		view 410
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(gCurRoom setScript: lookAtGreaseBoard)
		)
	)
)

(instance livRmWindow of View
	(properties
		x 212
		y 248
		view 4100
	)
)

(instance houseMap of View
	(properties
		x 74
		y 23
		view 4100
		cel 1
	)
)

(instance kitchenWindow of View
	(properties
		x 316
		y 211
		view 4100
		loop 1
	)
)

(instance bedRmWindow of View
	(properties
		x 396
		y 120
		view 4100
		loop 2
	)
)

(instance garage of View
	(properties
		x 362
		y 193
		view 4100
		loop 3
	)
)

(instance sideOne of View
	(properties
		x 274
		y 328
		view 4100
		loop 4
	)
)

(instance sideTwo of View ; UNUSED
	(properties
		x 77
		y 155
		view 4100
		loop 4
		cel 1
	)
)

(instance sideThree of View
	(properties
		x 305
		y 31
		view 4100
		loop 4
		cel 2
	)
)

(instance sideFour of View ; UNUSED
	(properties
		x 535
		y 178
		view 4100
		loop 4
		cel 3
	)
)

(instance xMark of View
	(properties
		x 111
		y 325
		view 4100
		loop 5
	)
)

(instance gate of View ; UNUSED
	(properties
		x 74
		y 23
		view 4100
		loop 6
	)
)

(instance frontDoor of View
	(properties
		x 74
		y 23
		view 4100
		loop 6
		cel 1
	)
)

(instance toiletDoor of View ; UNUSED
	(properties
		x 74
		y 23
		view 4100
		loop 6
		cel 2
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom setScript: exitGreaseBoard)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom setScript: exitGreaseBoard)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom setScript: exitGreaseBoard)
	)
)

(instance southE of HotSpot
	(properties
		nsTop 310
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom setScript: exitGreaseBoard)
	)
)

(instance briefTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: startScenario)
		)
	)
)

(instance okToShoot of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance stopTalkers of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance disposeMyself of Code
	(properties)

	(method (doit param1)
		(param1 dispose: (param1 disposeWhenDone:))
	)
)

