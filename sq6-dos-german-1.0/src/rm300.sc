;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Cursor)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
	bartenderTalker 1
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
)

(instance rm300 of SQRoom
	(properties
		noun 1
		picture 300
	)

	(method (init &tmp temp0)
		(gEgo init: normalize: posn: -20 130 code: scrollCode setScale: 0)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 7 136 298 136 305 127 342 127 348 135 471 135 471 126 392 124 388 116 383 116 372 120 317 113 318 122 274 122 246 122 239 120 138 120 132 124 84 124 75 121 46 121 54 114 208 114 208 107 38 107 38 110 42 110 38 115 7 121
					yourself:
				)
		)
		(= local7
			((Polygon new:)
				type: PTotalAccess
				init: 304 114 361 114 361 133 304 133
				yourself:
			)
		)
		(gGame handsOff:)
		(PalCycle 0 162 163 1 10) ; Start
		(PalCycle 0 166 169 1 10) ; Start
		(Load rsVIEW 300 3000 3001 3002 3003 3004 3006 3031)
		(Load rsFONT 70)
		(if (== gPrevRoomNum 290)
			(gGSound1 setVol: 127)
		)
		(if (not (or (not (IsFlag 26)) (IsFlag 40)))
			(= local6 1)
		)
		(switch gPrevRoomNum
			(290
				((gCurRoom plane:) setRect: -160 0 321 138)
				(door init: setLoop: 1 setCel: 3 approachVerbs: 3 4) ; Walk, Do
				(gCurRoom setScript: sComeFromBasement self)
			)
			(310
				((gCurRoom plane:) setRect: -160 0 321 138)
				(gEgo hide:)
				(gCurRoom setScript: sPadDown self)
			)
			(else
				(Palette 2 64 78 100) ; PalIntensity
				((gCurRoom plane:) setRect: 0 0 481 138)
				(gEgo enterRoom: -20 130 40 130 self)
			)
		)
		(UpdatePlane plane)
		(if (!= gPrevRoomNum 290)
			(door init: approachVerbs: 3 4) ; Walk, Do
			(cond
				((IsFlag 12)
					(door setLoop: 1)
				)
				((IsFlag 11)
					(door view: 303 setLoop: 1 setCel: 1)
				)
				((IsFlag 10)
					(door view: 303 setLoop: 1 setCel: 0)
				)
			)
		)
		(gWalkHandler addToFront: door)
		(if (proc0_8 0 2)
			(barGeek init:)
		else
			(pinky init: setScript: sPinkyAction)
		)
		(if (Random 0 2)
			(soldier init: setScript: sSoldierAction)
		else
			(flyGirl init: setScript: sFlyGirlAction)
			(flies init: setCycle: Fwd)
		)
		(babe init:)
		(guy1 init: setScript: sGuy1Action)
		(guy2 init: setScript: sGuy2Action)
		(laugher init: setScript: sLaugherAction)
		(blender init: approachVerbs: 4) ; Do
		(bartender init:)
		(if (IsFlag 42)
			(bartender
				view: 3050
				setLoop: 1
				setCel: 0
				posn: 244 87
				setCycle: Fwd
			)
			(blender hide:)
			(= local4 1)
		else
			(Load rsVIEW 3042)
			(bartender approachVerbs: 26 2 setScript: sBartenderAction) ; ???, Talk
		)
		(barfly init: setScript: sBarflyAction)
		(bigLegs init: setScript: sBigLegsAction)
		(padLights init: setCycle: Fwd)
		(restroomSign init: setCycle: Fwd)
		(sign2 init: setCycle: Fwd)
		(Load 140 306) ; WAVE
		(bathLineGuy1 init:)
		(bathLineGuy2 init: setScript: sWaitingForBathroom1)
		(bathLineGuy3 init: setScript: sWaitingForBathroom2)
		(bathLineGuy4 init:)
		(if (IsFlag 55)
			(pad init:)
			(bathLineGuy4 setScript: sWaitingForBathroom3)
		else
			(bathLineGuy4 view: 302 loop: 0 posn: 385 55 setPri: 115)
		)
		(hoverGuys init: setCycle: Fwd setScript: sHover)
		(fridgeDoor init: approachVerbs: 4) ; Do
		(if (not (or (gEgo has: 60) (gEgo has: 61))) ; Empty_Tray, Full_Tray
			(tray init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 37)
			(bentConduit init:)
		)
		(cond
			((IsFlag 15)
				(hoseSproing init: setCel: (hoseSproing lastCel:))
			)
			((IsFlag 39)
				(danglingHose init: approachVerbs: 4) ; Do
			)
			((IsFlag 20)
				(nitro init: setCycle: Fwd)
			)
		)
		(bar init:)
		(bottles init:)
		(conduits1 init: approachVerbs: 4) ; Do
		(conduits2 init: approachVerbs: 4) ; Do
		(conduits3 init: approachVerbs: 4) ; Do
		(conduitSpecial init: approachVerbs: 4 72) ; Do, Hookah_Hose
		(conduitBendable init: approachVerbs: 4) ; Do
		(elevator init:)
		(floor init:)
		(light1 init:)
		(light2 init:)
		(light3 init:)
		(valve1 init: approachVerbs: 4) ; Do
		(valve2 init: approachVerbs: 4) ; Do
		(valve3 init: approachVerbs: 4) ; Do
		(valve4 init: approachVerbs: 4) ; Do
		(exit310 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(exit330 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
	)

	(method (doit)
		(if (<= (= local0 (GetDistance (gEgo x:) (gEgo y:) 386 117)) 20)
			(Palette 2 64 79 (- 200 (* local0 5))) ; PalIntensity
		)
		(cond
			(script)
			((and (< 79 (gEgo x:) 250) (< (gEgo y:) 115) (not local4))
				(gCurRoom setScript: sGetBack 0 1)
			)
			((and (not (IsFlag 55)) (> (gEgo x:) 307))
				(gCurRoom setScript: sElevatorToBathroom)
			)
			((and (IsFlag 55) (local7 onMe: (gEgo x:) (gEgo y:)))
				(gCurRoom setScript: sPlayToilet)
			)
		)
		(super doit:)
	)

	(method (cue)
		(if local6
			(= local6 0)
			(gGame handsOn:)
		else
			(= local6 1)
			(if (not (IsFlag 26))
				(SetFlag 26)
				(gMessager say: 1 1 1 0 self) ; "It would appear that, once again, vice is a bit more profitable than most business ventures. This place is almost too hip for the planet -- but then, that's no mean feat given what a total heap this place appears to be."
			)
			(if (IsFlag 40)
				(ClearFlag 40)
				(gMessager say: 3 0 36 0 self) ; "Drat. It appears that the bartender disconnected your cleverly concocted hose link while you were gone."
			)
		)
	)

	(method (notify)
		(if (IsFlag 15)
			(ClearFlag 20)
			(ClearFlag 15)
			(SetFlag 39)
			(SetFlag 40)
			(bartender setScript: sFinishDrink 0 1)
		else
			(bartender setScript: sFinishDrink 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 290)
			(gGSound2 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (gWalkHandler contains: door)
			(gWalkHandler delete: door)
		)
		(if (bartender script:)
			((bartender script:) dispose:)
		)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(Palette 2 64 78 100) ; PalIntensity
		(super dispose:)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 (gEgo xStep:))
		(if
			(and
				(> (+ (gEgo x:) temp1) 220)
				(> temp3 325)
				(gEgo mover:)
				(> (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (- temp1 temp0) temp2 (- temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo x:) temp1) 100)
				(< temp1 -5)
				(gEgo mover:)
				(< (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (+ temp1 temp0) temp2 (+ temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sPlayToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (proc0_8 1 4) 2)
					(sFXToilet play:)
				)
				(= ticks 180)
			)
			(1
				(if (local7 onMe: (gEgo x:) (gEgo y:))
					(-- state)
					(= ticks 60)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sHover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hoverGuys setMotion: DPath 255 137 154 138 140 137 self)
			)
			(1
				(hoverGuys setHeading: 180 self)
			)
			(2
				(= ticks (proc0_8 600 1800))
			)
			(3
				(hoverGuys setMotion: PolyPath 75 137 self)
			)
			(4
				(hoverGuys setHeading: 180 self)
			)
			(5
				(= ticks (proc0_8 600 1800))
			)
			(6
				(hoverGuys setMotion: DPath 140 138 154 137 self)
			)
			(7
				(hoverGuys setHeading: 180 self)
			)
			(8
				(= ticks (proc0_8 600 1800))
			)
			(9
				(hoverGuys setMotion: DPath 255 137 351 138 self)
			)
			(10
				(hoverGuys setHeading: 180 self)
			)
			(11
				(= ticks (proc0_8 600 1800))
			)
			(12
				(self changeState: 0)
			)
		)
	)
)

(instance sWaitingForBathroom1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 120 300))
			)
			(1
				(switch (= register (proc0_8 1 3))
					(1
						(client
							setLoop: (proc0_8 1 2)
							setCycle: ForwardCounter (proc0_8 2 4) self
						)
					)
					(2
						(client
							setLoop: 3
							setCycle: RandCycle (proc0_8 90 240) self
						)
					)
					(3
						(client setLoop: 4 setCycle: End self)
					)
				)
			)
			(2
				(if (== register 3)
					(= ticks (proc0_8 60 180))
				else
					(= cycles 1)
				)
			)
			(3
				(if (== register 3)
					(client setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(client loop: 1 cel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sWaitingForBathroom2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 120 300))
			)
			(1
				(if (= register (proc0_8 0 2))
					(client
						setLoop: 7
						setCycle: ForwardCounter (proc0_8 2 4) self
					)
				else
					(client setLoop: (proc0_8 5 6) setCycle: End self)
				)
			)
			(2
				(if (== register 0)
					(= ticks (proc0_8 60 180))
				else
					(= cycles 1)
				)
			)
			(3
				(if (== register 0)
					(client setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(client loop: 7 cel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sWaitingForBathroom3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: ForwardCounter (proc0_8 2 4) self)
			)
			(1
				(client cel: 0)
				(= ticks (proc0_8 120 300))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sElevatorToBathroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 301) ; WAVE
				(if (not (IsFlag 202))
					((gCurRoom plane:) setRect: -156 0 325 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(sFX number: 301 loop: -1 play:)
				(bathLineGuy4 setCycle: End self)
			)
			(1
				(sFX stop:)
				(= ticks 60)
			)
			(2
				(pad init:)
				(bathLineGuy4
					loop: 1
					cel: 0
					setPri: 135
					setCycle: ForwardCounter 2 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(bathLineGuy4 loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(bathLineGuy4
					view: 3010
					loop: 8
					cel: 0
					posn: 358 115
					setPri: -1
					setScript: sWaitingForBathroom3
				)
				(gGame handsOn:)
				(SetFlag 55)
				(self dispose:)
			)
		)
	)
)

(instance sGetBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: 0 setMotion: 0)
				(= cycles 3)
			)
			(1
				(if
					(or
						(and (gCurRoom script:) (!= (gCurRoom script:) self))
						(bartender mover:)
						(and
							(== (bartender script:) sMixPinkyDrink)
							(!= (sMixPinkyDrink state:) 0)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(if register
						(bartender setScript: 0)
					)
					(bartender
						view: 304
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(= local5 1)
				(if local1
					(gMessager say: 3 0 12 0 self) ; "Hey, Mac, you gotta keep your can on THAT side of the bar, all right? That's the house rules. Don't make me get rough with ya', okay, huh? We're all here to have a good time, right?"
				else
					(gMessager say: 3 0 11 0 self) ; "Hey, yeah, yeah, hey there, Guy, come on now, hey. You can't come back here. You want something, you let me know, all right?"
				)
				(+= local1 1)
			)
			(3
				(= local5 0)
				(if register
					(bartender setLoop: 1 setCel: 0 setScript: sBartenderAction)
				)
				(if (== (gEgo view:) 308)
					(self setScript: sCloseFridgeAndGet self)
				else
					(gEgo
						setSpeed: 7
						setCycle: StopWalk 901
						setMotion: PolyPath 44 124 self
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComeFromBasement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 500 123 setMotion: MoveTo 441 126 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPadTo310 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 301) ; WAVE
				(gEgo setHeading: 180 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(sFX number: 301 loop: -1 play:)
				(gEgo hide:)
				(pad loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(sFX stop:)
				(gCurRoom newRoom: 310)
				(self dispose:)
			)
		)
	)
)

(instance sPadDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Palette 2 64 79 200) ; PalIntensity
				(Load 140 301) ; WAVE
				(sFX number: 301 loop: -1 play:)
				(pad loop: 2 setCel: (pad lastCel:) setCycle: Beg self)
			)
			(2
				(sFX stop:)
				(gEgo show: posn: 384 116 setLoop: 2)
				(pad loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseFridgeAndGet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sCloseFridge self)
			)
			(1
				(gGame handsOff:)
				(gEgo setSpeed: 7 setMotion: PolyPath 44 124 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sKickDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 305) ; WAVE
				(gEgo
					view: 303
					setLoop: 0
					setCel: 0
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(1
				(cond
					((IsFlag 12)
						(= scratch 0)
						(door setCycle: End self)
					)
					((IsFlag 11)
						(= scratch 0)
						(door view: 303 setLoop: 2 setCel: 0 setCycle: End self)
						(= register 1)
						(SetFlag 12)
					)
					((IsFlag 10)
						(= scratch 1)
						(door view: 303 setLoop: 1 setCel: 1)
						(SetFlag 11)
					)
					(else
						(= scratch 1)
						(door view: 303 setLoop: 1 setCel: 0)
						(SetFlag 10)
					)
				)
				(= cycles 1)
			)
			(2
				(sFX number: 305 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 6)
				(= ticks 60)
			)
			(4
				(if scratch
					(= cycles 1)
				)
			)
			(5
				(if (and (not register) (IsFlag 12))
					(gEgo setMotion: MoveTo 500 123 self)
				else
					(= scratch 1)
					(if register
						(door view: 3030 setLoop: 1 setCel: 0)
						(= register 0)
					)
					(cond
						((IsFlag 12)
							(gGame points: 3)
							(gMessager say: 8 0 6 0 self) ; "Wow. You really did it. Not exactly the subtlest of entry techniques, but effective. That's pretty macho for the likes of you. Who would've guessed you'd have the makings of a Starsky or a Hutch, or a Tango or a Cash."
						)
						((IsFlag 11)
							(gMessager say: 8 0 5 0 self) ; "Nah, you still haven't convinced the door to yield to your obviously superior physical presence."
						)
						((IsFlag 10)
							(gMessager say: 8 0 4 0 self) ; "Well, that wasn't too bad for a borderline physical specimen like you. It didn't quite get the job done, though."
						)
					)
				)
			)
			(6
				(if scratch
					(= scratch 0)
					(gGame handsOn:)
				else
					(SetFlag 24)
					(gCurRoom newRoom: 290)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(= cycles 1)
				else
					(door setCycle: End self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 500 123 self)
			)
			(2
				(SetFlag 24)
				(gCurRoom newRoom: 290)
				(self dispose:)
			)
		)
	)
)

(instance sBarGeekMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 180)
			)
			(1
				(switch (= register (proc0_8 1 5))
					(1
						(geekHead setLoop: 2 setCel: 0 setCycle: End self)
					)
					(2
						(geekHead setLoop: 3 setCel: 0 setCycle: End self)
					)
					(3
						(geekHand
							setLoop: 4
							setCel: 0
							posn: 108 85
							priority: (+ (geekHand priority:) 1)
							setCycle: End self
						)
					)
					(4
						(geekHand
							setLoop: 5
							setCel: 0
							posn: 108 85
							priority: (+ (geekHand priority:) 1)
							setCycle: End self
						)
					)
					(5
						(geekArm setLoop: 6 setCel: 0 setCycle: End self)
					)
				)
			)
			(2
				(switch register
					(1
						(geekHead setLoop: 2 setCel: 0)
					)
					(2
						(geekHead setLoop: 2 setCel: 0)
					)
					(3
						(geekHand
							priority: (- (geekHand priority:) 1)
							setLoop: 4
							setCel: 0
						)
					)
					(4
						(geekHand
							priority: (- (geekHand priority:) 1)
							setLoop: 1
							setCel: 3
							posn: 122 88
						)
					)
					(5
						(geekArm setLoop: 1 setCel: 1)
					)
				)
				(= cycles 6)
			)
			(3
				(if (== register 3)
					(geekHand setLoop: 1 setCel: 3 posn: 122 88)
				)
				(= cycles 6)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sFlyGirlAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flyGirl setCel: 0 setCycle: End self)
			)
			(1
				(= ticks (proc0_8 30 180))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sBigLegsAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 120 240))
			)
			(1
				(switch (= register (proc0_8 1 2))
					(1
						(bigLegs setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
					)
					(2
						(bigLegs setLoop: 1 setCel: 0 setCycle: End self)
					)
				)
			)
			(2
				(switch register
					(1
						(= ticks 30)
					)
					(2
						(= ticks (proc0_8 30 180))
					)
				)
			)
			(3
				(switch register
					(1
						(bigLegs setCycle: End self)
					)
					(2
						(bigLegs setCycle: Beg self)
					)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sLaugherAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laugher
					setLoop: 0
					setCycle: RandCycle (proc0_8 240 360) self 1
				)
			)
			(1
				(if (= register (proc0_8 0 1))
					(laugher setLoop: 1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(laugher setCycle: ROsc (proc0_8 3 10) 2 3 self)
				else
					(= cycles 1)
				)
			)
			(3
				(= ticks (proc0_8 30 60))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sPinkyAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 60 180))
			)
			(1
				(switch (= register (proc0_8 1 3))
					(1
						(pinky setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
					)
					(2
						(pinky setLoop: 3 setCel: 0 setCycle: End self)
					)
					(3
						(pinky setLoop: 4 setCel: 0 setCycle: End self)
					)
				)
			)
			(2
				(switch register
					(1
						(= ticks 30)
					)
					(2
						(= ticks 60)
					)
					(3
						(pinky setCycle: Beg self)
					)
				)
			)
			(3
				(switch register
					(1
						(pinky setCycle: End self)
					)
					(2
						(pinky setCycle: Beg self)
					)
					(3
						(= cycles 1)
					)
				)
			)
			(4
				(pinky setCel: 0)
				(= cycles 6)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance sGuy1Action of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (guy2 scratch:)
					(0
						(if (proc0_8 0 1)
							(= register 1)
						else
							(= register 2)
						)
					)
					(1
						(if (proc0_8 0 1)
							(= register 0)
						else
							(= register 2)
						)
					)
					(2
						(if (proc0_8 0 1)
							(= register 1)
						else
							(= register 2)
						)
					)
				)
				(switch register
					(0
						(guy1
							scratch: 0
							setLoop: 1
							setCel: 0
							setCycle: End self
						)
					)
					(1
						(guy1
							scratch: 1
							setLoop: 2
							setCel: 0
							setCycle: RandCycle (proc0_8 120 240) self 1
						)
					)
					(2
						(guy1
							scratch: 2
							setLoop: 3
							setCel: 0
							setCycle: CT 1 1 self
						)
					)
				)
			)
			(1
				(switch register
					(0
						(= ticks (proc0_8 60 120))
					)
					(1
						(guy1 scratch: 0 setLoop: 2 setCel: 0)
						(= cycles 6)
					)
					(2
						(guy1 setCycle: ROsc (proc0_8 3 6) 1 2 self)
					)
				)
			)
			(2
				(switch register
					(0
						(guy1 setLoop: 0 setCel: 0 setCycle: End self)
					)
					(1
						(= cycles 6)
					)
					(2
						(guy1 setCycle: End self)
					)
				)
			)
			(3
				(switch register
					(0
						(guy1 setLoop: 2 setCel: 0)
					)
					(2
						(guy1 scratch: 0)
					)
				)
				(= cycles 6)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sGuy2Action of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (guy1 scratch:)
					(0
						(if (proc0_8 0 1)
							(= register 1)
						else
							(= register 2)
						)
					)
					(1
						(if (proc0_8 0 1)
							(= register 0)
						else
							(= register 2)
						)
					)
					(2
						(if (proc0_8 0 1)
							(= register 1)
						else
							(= register 2)
						)
					)
				)
				(switch register
					(0
						(guy2 scratch: 0)
						(= ticks (proc0_8 60 240))
					)
					(1
						(guy2
							scratch: 1
							setLoop: 3
							setCel: 0
							setCycle: RandCycle (proc0_8 120 240) self 1
						)
					)
					(2
						(guy2
							scratch: 2
							setLoop: 5
							setCel: 0
							setCycle: CT 2 1 self
						)
					)
				)
			)
			(1
				(switch register
					(0
						(= cycles 6)
					)
					(1
						(guy2 scratch: 0 setLoop: 3 setCel: 0)
						(= cycles 6)
					)
					(2
						(guy2 setCycle: ROsc (proc0_8 3 6) 2 3 self)
					)
				)
			)
			(2
				(switch register
					(0
						(= cycles 6)
					)
					(1
						(= cycles 6)
					)
					(2
						(guy2 setCycle: End self)
					)
				)
			)
			(3
				(if (== register 2)
					(guy2 scratch: 0)
				)
				(= cycles 6)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sBarflyAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (= register (proc0_8 0 1))
					(0
						(barfly setLoop: 0 setCel: 0 setCycle: Fwd)
						(= ticks (proc0_8 60 240))
					)
					(1
						(barfly setLoop: 1 setCel: 0 setCycle: End self)
					)
				)
			)
			(1
				(switch register
					(0
						(barfly setLoop: 0 setCel: 0 setCycle: End self)
					)
					(1
						(= cycles 6)
					)
				)
			)
			(2
				(if (== register 0)
					(barfly loop: 1)
					(barfly cel: (barfly lastCel:))
				)
				(= cycles 6)
			)
			(3
				(= ticks (proc0_8 60 180))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sSoldierAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 60 180))
			)
			(1
				(switch (= register (proc0_8 0 2))
					(0
						(soldier setLoop: 0 setCel: 1 setCycle: End self)
					)
					(1
						(soldier
							setLoop: 1
							setCel: 0
							setCycle: RandCycle (proc0_8 120 240) self
						)
					)
					(2
						(soldier setLoop: 0 setCel: 0)
						(= ticks (proc0_8 30 120))
					)
				)
			)
			(2
				(switch register
					(0
						(= ticks 45)
					)
					(1
						(soldier setLoop: 0 setCel: 1)
						(= cycles 6)
					)
					(2
						(soldier setLoop: 0 setCel: 1)
						(= cycles 6)
					)
				)
			)
			(3
				(if (not register)
					(soldier setCycle: CT 1 -1 self)
				else
					(= cycles 1)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sBartenderAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 60 180))
			)
			(1
				(switch (bartender x:)
					(120
						(bartender
							view: 305
							setLoop: 0
							setCycle: Walk
							setMotion:
								MoveTo
								(if (proc0_8 0 1) 156 else 205)
								(bartender y:)
								self
						)
					)
					(156
						(if (proc0_8 0 1)
							(bartender
								view: 305
								setLoop: 1
								setCycle: Walk
								setMotion: MoveTo 120 (bartender y:) self
							)
						else
							(bartender
								view: 305
								setLoop: 0
								setCycle: Walk
								setMotion: MoveTo 205 (bartender y:) self
							)
						)
					)
					(205
						(bartender
							view: 305
							setLoop: 1
							setCycle: Walk
							setMotion:
								MoveTo
								(if (proc0_8 0 1) 156 else 120)
								(bartender y:)
								self
						)
					)
				)
			)
			(2
				(switch (bartender x:)
					(205
						(if (and (proc0_8 0 1) (gCast contains: pinky))
							(self setScript: sMixPinkyDrink self)
						else
							(self setScript: sCleanBar self)
						)
					)
					(120
						(if (proc0_8 0 1)
							(bartender
								view: 304
								loop: 1
								setCycle: RandCycle (proc0_8 60 240) self 1
							)
						else
							(bartender view: 3042 setLoop: 0 setCel: 0)
							(= ticks (proc0_8 60 120))
						)
					)
					(else
						(if (proc0_8 0 1)
							(self setScript: sCleanBar self)
						else
							(bartender view: 3042 setLoop: 0 setCel: 0)
							(= ticks (proc0_8 60 120))
						)
					)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sCleanBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender view: 3042 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(bartender setCycle: ROsc (proc0_8 1 2) 12 13 self)
			)
			(2
				(bartender setCycle: ROsc (proc0_8 2 4) 9 11 self)
			)
			(3
				(bartender setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sMakeSpecialDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 42)
				(bartender
					view: 305
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 244 87 self
				)
			)
			(1
				(bartender view: 3050 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(sFXMix play:)
				(bartender setLoop: 1 setCel: 0 setCycle: Fwd)
				(blender hide:)
				((ScriptID 0 10) setReal: (ScriptID 0 10) 180) ; bartenderTimer, bartenderTimer
				(self dispose:)
			)
		)
	)
)

(instance sFinishDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(-- state)
					(= ticks 30)
				else
					(= cycles 1)
				)
			)
			(1
				(blender show:)
				(bartender setLoop: 0 setCel: 15 setCycle: Beg self)
			)
			(2
				(if (and (< 79 (gEgo x:) 250) (< (gEgo y:) 115))
					(self setScript: sGetBack self 0)
				else
					(= cycles 1)
				)
			)
			(3
				(if (or register (IsFlag 15))
					(self setScript: sBartUnhook self)
				else
					(bartender
						view: 305
						setLoop: 1
						setCycle: Walk
						setMotion: MoveTo 205 90 self
					)
				)
			)
			(4
				(bartender
					view: 3042
					setLoop: 0
					setCel: 0
					approachVerbs: 26 2 ; ???, Talk
					setScript: sBartenderAction
				)
				(= local4 0)
				(self dispose:)
			)
		)
	)
)

(instance sBartUnhook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bartender
					view: 305
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 189 90 self
				)
			)
			(1
				(ClearFlag 40)
				(bartender
					view: 3072
					loop: 0
					cel: 0
					posn: 187 90
					cycleSpeed: 8
					setCycle: End self
				)
				(hoseSproing dispose:)
			)
			(2
				(if (< (gEgo x:) 360)
					(gMessager say: 3 0 35 0 self) ; "The bartender, noticing the hose attached to the bent conduit, disconnects it -- much to your chagrin."
				else
					(= cycles 1)
				)
			)
			(3
				(danglingHose init: approachVerbs: 4) ; Do
				(bartender
					view: 305
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 156 90 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMixPinkyDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender view: 3041 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(glass init: posn: 159 84 setMotion: MoveTo 118 (glass y:) self)
				(bartender setCel: 0)
			)
			(2
				(glass dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenFridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 308
					setLoop: 0 1
					setCel: 0
					setSpeed: 10
					setMotion: 0
					state: (| (gEgo state:) $fffd)
					setCycle: CT 4 1 self
				)
			)
			(1
				(sFX number: 30009 loop: 1 play:)
				(fridgeDoor hide:)
				(gEgo setCycle: End self)
			)
			(2
				(fridgeOpen init: approachVerbs: 4) ; Do
				(gEgo signal: (| (gEgo signal:) $0800))
				(gMouseDownHandler addToFront: fridgeDoor)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCloseFridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 30010) ; WAVE
				(gEgo
					view: 308
					setLoop: 2
					setCel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(1
				(sFX number: 30010 loop: 1 play:)
				(fridgeDoor show:)
				(gEgo
					normalize: 6
					setSpeed: global158
					signal: (& (gEgo signal:) $f7ff)
				)
				(gMouseDownHandler delete: fridgeDoor)
				(fridgeOpen dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowID of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3040
					loop: 0
					cel: 0
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(1
				(if
					(or
						(bartender mover:)
						(and
							(== (bartender script:) sMixPinkyDrink)
							(!= (sMixPinkyDrink state:) 0)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(bartender setScript: 0)
					(= cycles 1)
				)
			)
			(2
				(if (== (bartender x:) 120)
					(bartender
						view: 305
						setLoop: 0
						setCycle: Walk
						setMotion: MoveTo 156 (bartender y:) self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 202))
						(< ((gCurRoom plane:) left:) 0)
						(== (bartender x:) 156)
					)
					((gCurRoom plane:) setRect: 0 0 481 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(bartender view: 3042 loop: 0 cel: 0)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 3 heading: 0)
				(= cycles 3)
			)
			(5
				(if register
					(if (not (IsFlag 22))
						(SetFlag 22)
						(= local2 0)
						(gGame points: 3)
					)
					(= local3 1)
					(= next sTalkToBartender)
					(self dispose:)
				else
					(gMessager say: 3 67 0 0 self) ; "Uh, heh, heh. That's not a very good likeness of you, Pal. What did you do, steal it? Hey, if you was an okay guy, you'd return it to its rightful owner, you know what I mean? And if it is you, Pal, I'd consider killing whoever took it. Ooh, baby, that is ugly!"
				)
			)
			(6
				(bartender setScript: sBartenderAction)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToBartender of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gUser canInput:)
					(gGame handsOff:)
				)
				(= cycles 3)
			)
			(1
				(if
					(or
						(bartender mover:)
						(and
							(== (bartender script:) sMixPinkyDrink)
							(!= (sMixPinkyDrink state:) 0)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(bartender setScript: 0)
					(= cycles 1)
				)
			)
			(2
				(if (== (bartender x:) 120)
					(bartender
						view: 305
						setLoop: 0
						setCycle: Walk
						setMotion: MoveTo 156 (bartender y:) self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 202))
						(< ((gCurRoom plane:) left:) 0)
						(== (bartender x:) 156)
					)
					((gCurRoom plane:) setRect: 0 0 481 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(bartender view: 3042 loop: 0 cel: 0)
				(cond
					((and (== (bartender x:) 156) (<= 0 (gEgo heading:) 180))
						(gEgo setHeading: 315 self)
					)
					(
						(and
							(== (bartender x:) 205)
							(<= 180 (gEgo heading:) 360)
						)
						(gEgo setHeading: 45 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(if local3
					(= local3 0)
					(gMessager say: 3 68 0 0 self) ; "Ah, so you're with Polysorbate Security, huh? What can I get for ya, Chief?"
				else
					(gMessager say: 3 2 0 0 self) ; "What can I do for ya there, Fella?"
				)
			)
			(5
				(if local2
					(= register 0)
					(= cycles 1)
				else
					(= register 1)
					(gMessager say: 3 2 14 0 self) ; "What have you got?"
				)
				(+= local2 1)
			)
			(6
				(if (and register (IsFlag 22))
					(gMessager say: 3 2 25 0 self) ; "I got just the thing for you guys. It's something I don't even give the regulars here. Whaddaya think, eh?"
				else
					(= cycles 1)
				)
			)
			(7
				(= cycles 3)
			)
			(8
				(= register gTheCursor)
				(gGame setCursor: gNormalCursor)
				(= temp0 (Abs ((gCurRoom plane:) left:)))
				(william init: self x: (+ temp0 54))
				(asimov init: self x: (+ temp0 54))
				(fuzzy init: self x: (+ temp0 54))
				(if (IsFlag 22)
					(choiceDialog init: x: (+ temp0 45) cel: 1)
					(special init: self x: (+ temp0 54))
					(nah init: self x: (+ temp0 54) y: 58)
				else
					(choiceDialog init: x: (+ temp0 45) cel: 0)
					(nah init: self x: (+ temp0 54) y: 51)
				)
				(= scratch 10)
				(while (== scratch 10)
					(gGame doit:)
					(FrameOut)
				)
				(choiceDialog dispose:)
				(william dispose:)
				(asimov dispose:)
				(fuzzy dispose:)
				(nah dispose:)
				(if (IsFlag 22)
					(special dispose:)
				)
				(gGame setCursor: register)
				(= register 0)
				(cond
					((== scratch 5)
						(gMessager say: 3 2 30 0 self) ; "You know what? I think I'll pass."
					)
					((== scratch 4)
						(gGame points: 5 404)
						(= local4 (= register 1))
						(gMessager say: 3 2 15 0 self) ; "Make me a double Uvula Spritzer, twist of fleck rind. And I want it hacked and whipped. Not like one of those shaken or stirred sissy drinks."
					)
					(else
						(gGame points: 1 403)
						(gMessager say: 3 2 26 0 self) ; "Okay, you got it, Pal."
					)
				)
			)
			(9
				(if register
					(bartender approachVerbs: 0 setScript: sMakeSpecialDrink)
				else
					(bartender setScript: sBartenderAction)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoOnBlender of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if
					(or
						(bartender mover:)
						(and
							(== (bartender script:) sMixPinkyDrink)
							(!= (sMixPinkyDrink state:) 0)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(bartender setScript: 0)
					(= cycles 1)
				)
			)
			(2
				(if (== (bartender x:) 120)
					(bartender
						view: 305
						setLoop: 0
						setCycle: Walk
						setMotion: MoveTo 156 (bartender y:) self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 202))
						(< ((gCurRoom plane:) left:) 0)
						(== (bartender x:) 156)
					)
					((gCurRoom plane:) setRect: 0 0 481 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(gMessager say: 10 4 0 0 self) ; "Hey, hey, hey! Back off, here. Only trained professionals like yours truly are allowed to operate the Turbomincer LS."
			)
			(4
				(bartender
					view: 3042
					loop: 0
					cel: 0
					setScript: sBartenderAction
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 1
					setCel: 0
					setSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(1
				(sFX number: 30012 loop: 1 play:)
				(tray dispose:)
				(gEgo setCycle: End self)
			)
			(2
				(if (IsFlag 25)
					(ClearFlag 25)
					(gEgo get: 61) ; Full_Tray
					((ScriptID 0 9) setReal: (ScriptID 0 9) 120) ; reformTimer, reformTimer
				else
					(gEgo get: 60) ; Empty_Tray
				)
				(gGame points: 3 401 handsOn:)
				(gTheIconBar disable: 0)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sPutTray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 30012) ; WAVE
				(gEgo
					setLoop: 1
					setCel: 10
					setSpeed: 10
					setCycle: CT 2 -1 self
				)
			)
			(1
				(sFX number: 30012 loop: 1 play:)
				(if (== register 13)
					(gEgo put: 60) ; Empty_Tray
					(tray init:)
				else
					(gGame points: 5 405)
					((ScriptID 0 9) client: 0 delete: dispose:) ; reformTimer
					(SetFlag 25)
					(gEgo put: 61) ; Full_Tray
					(tray init:)
				)
				(tray init:)
				(gEgo setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sTurnValve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 303) ; WAVE
				(gEgo
					view: 306
					setLoop: 0
					setCel: 0
					setSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(sFX number: 303 loop: 1 play:)
			)
			(2
				(if (!= register 3)
					(gEgo setLoop: 1 setCel: 0 setCycle: End self)
					(sFX number: 304 loop: 1 play:)
				else
					(= cycles 3)
				)
			)
			(3
				(if (== register 3)
					(SetFlag 36)
					(conduitBendable approachVerbs: 4) ; Do
					(gMessager say: 6 4 10 0 self) ; "This one doesn't spew anything."
				else
					(gMessager say: 6 4 9 0 self) ; "Yeow! You quickly close that valve again."
				)
			)
			(4
				(gGame points: 5 503)
				(gEgo setLoop: 0 setCel: 2 setCycle: Beg self)
				(if (!= register 3)
					(sFX stop: number: 303 loop: 1 play:)
				)
			)
			(5
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBendConduit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3060
					setLoop: 0
					setCel: 0
					setSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo setCel: 3 setSpeed: 20 setCycle: CT 4 1 self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gEgo setCel: 3 setCycle: CT 4 1 self)
			)
			(5
				(= ticks 90)
			)
			(6
				(sFX number: 307 loop: 1 play:)
				(gEgo setSpeed: 8 setCycle: End self)
			)
			(7
				(gGame points: 5)
				(SetFlag 37)
				(bentConduit init:)
				(gEgo normalize: 0 posn: 146 113)
				(= cycles 3)
			)
			(8
				(gMessager say: 5 4 10 0 self) ; "With a flick of your very supple wrist, you pull the conduit loose from below the valve. Oops."
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHookHoseLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 307
					setLoop: 0 1
					setCel: 0
					setSpeed: 8
					setMotion: 0
					state: (| (gEgo state:) $fffd)
					setCycle: End self
				)
			)
			(1
				(gEgo put: 57) ; Hookah_Connected
				(gMessager say: 15 73 0 0 self) ; "The hookah hose is now attached to the leftmost conduit."
			)
			(2
				(gMouseDownHandler addToFront: conduitSpecial)
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3 4 7)
				((gTheIconBar at: 2) setCursor: hoseCursor)
				(gTheIconBar
					curIcon: (gTheIconBar at: 2)
					highlight: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sPutHoseDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 307
					setLoop: 1
					setCel: 0
					posn: 44 109
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(SetFlag 39)
				(danglingHose init: approachVerbs: 4) ; Do
				(gGame handsOn:)
				(gEgo normalize: 6)
				((gTheIconBar at: 2) setCursor: gDoCursor)
				(gTheIconBar
					curIcon: (gTheIconBar at: 2)
					highlight: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(self dispose:)
			)
		)
	)
)

(instance sPickHoseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 307
					setLoop: 2
					setCel: 0
					setSpeed: 8
					setCycle: End self
				)
				(danglingHose dispose:)
			)
			(1
				(gMessager say: 16 4 0 0 self) ; "You pick up the loose end of the hookah hose."
			)
			(2
				(ClearFlag 39)
				(gMouseDownHandler addToFront: conduitSpecial)
				(gGame handsOn:)
				(gEgo put: 57) ; Hookah_Connected
				(gTheIconBar disable: 0 1 3 4 7)
				((gTheIconBar at: 2) setCursor: hoseCursor)
				(gTheIconBar
					curIcon: (gTheIconBar at: 2)
					highlight: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sNotGonnaAllowIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMouseDownHandler delete: conduitSpecial)
				(gEgo
					view: 309
					setLoop: 0
					setCel: 0
					posn: 92 110
					setSpeed: 8
					setCycle: CT 9 1 self
				)
			)
			(1
				(if
					(or
						(bartender mover:)
						(and
							(== (bartender script:) sMixPinkyDrink)
							(!= (sMixPinkyDrink state:) 0)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(bartender
						setScript: 0
						view: 304
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(= local5 1)
				(if local1
					(gMessager say: 3 0 12 0 self) ; "Hey, Mac, you gotta keep your can on THAT side of the bar, all right? That's the house rules. Don't make me get rough with ya', okay, huh? We're all here to have a good time, right?"
				else
					(gMessager say: 3 0 11 0 self) ; "Hey, yeah, yeah, hey there, Guy, come on now, hey. You can't come back here. You want something, you let me know, all right?"
				)
				(+= local1 1)
			)
			(3
				(= local5 0)
				(bartender setLoop: 1 setCel: 0 setScript: sBartenderAction)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 307 setLoop: 2)
				(gEgo setCel: (gEgo lastCel:) posn: 44 109)
				(ClearFlag 39)
				(gMouseDownHandler addToFront: conduitSpecial)
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3 4 7)
				((gTheIconBar at: 2) setCursor: hoseCursor)
				(gTheIconBar
					curIcon: (gTheIconBar at: 2)
					highlight: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sMakeConnection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMouseDownHandler delete: conduitSpecial)
				(gEgo
					view: 309
					setLoop: 0
					setCel: 0
					posn: 92 110
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 3071
					setLoop: 0
					setCel: 0
					posn: 151 110
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 2 setCel: 0)
				(hoseSproing init: setCycle: End self)
			)
			(3
				(gGame points: 5 402)
				(gMessager say: 17 73 32 0 self) ; "You complete the connection between the two conduits."
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 135 111
					setSpeed: 10
					setCycle: End self
				)
			)
			(6
				(ClearFlag 39)
				(SetFlag 15)
				(gEgo normalize: 6)
				(gGame handsOn:)
				((gTheIconBar at: 2) setCursor: gDoCursor)
				(gTheIconBar
					curIcon: (gTheIconBar at: 2)
					highlight: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(self dispose:)
			)
		)
	)
)

(class ChooseButton of View
	(properties
		hiliteState 0
		value 0
		client 0
	)

	(method (init param1)
		(= client param1)
		(gMouseDownHandler addToFront: self)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(client scratch: value)
		)
	)

	(method (doit)
		(cond
			((self onMe: (+ (Abs ((gCurRoom plane:) left:)) gMouseX) gMouseY)
				(if (not hiliteState)
					(self setCel: 1 hiliteState: 1)
				)
			)
			(hiliteState
				(self setCel: 0 hiliteState: 0)
			)
		)
		(super doit:)
	)
)

(instance choiceDialog of View
	(properties
		x 45
		y 16
		priority 199
		fixPriority 1
		view 299
	)
)

(instance william of ChooseButton
	(properties
		x 54
		y 31
		priority 200
		fixPriority 1
		view 299
		loop 1
		value 1
	)
)

(instance asimov of ChooseButton
	(properties
		x 54
		y 38
		priority 200
		fixPriority 1
		view 299
		loop 2
		value 2
	)
)

(instance fuzzy of ChooseButton
	(properties
		x 54
		y 45
		priority 200
		fixPriority 1
		view 299
		loop 3
		value 3
	)
)

(instance special of ChooseButton
	(properties
		x 54
		y 51
		priority 200
		fixPriority 1
		view 299
		loop 5
		value 4
	)
)

(instance nah of ChooseButton
	(properties
		x 54
		y 51
		priority 200
		fixPriority 1
		view 299
		loop 4
		value 5
	)
)

(instance hoverGuys of Actor
	(properties
		noun 29
		sightAngle 40
		x 319
		y 137
		view 301
		signal 20513
	)
)

(instance bathLineGuy1 of Prop
	(properties
		noun 30
		sightAngle 40
		x 336
		y 104
		view 3010
		signal 20513
	)
)

(instance bathLineGuy2 of Prop
	(properties
		noun 31
		sightAngle 40
		x 333
		y 106
		view 3010
		loop 1
		signal 20513
	)
)

(instance bathLineGuy3 of Prop
	(properties
		noun 32
		sightAngle 40
		x 337
		y 111
		view 3010
		loop 7
		signal 20513
	)
)

(instance bathLineGuy4 of Prop
	(properties
		noun 33
		sightAngle 40
		x 358
		y 115
		view 3010
		loop 8
		signal 20513
	)
)

(instance pad of Prop
	(properties
		sightAngle 40
		x 385
		y 55
		priority 115
		fixPriority 1
		view 3020
	)
)

(instance door of Prop
	(properties
		noun 8
		approachX 441
		approachY 126
		x 456
		y 42
		view 3030
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 35))
			(self hide:)
			(openDoorExit init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sKickDoor)
			)
			(4 ; Do
				(if (IsFlag 12)
					(gCurRoom setScript: sKickDoor)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(cond
					((IsFlag 24)
						(gMessager say: noun theVerb 3) ; "That's the door to the basement. Surely you remember, or is your brain full already?"
					)
					((IsFlag 12)
						(gMessager say: noun theVerb 2) ; "You probably still wonder what's behind it."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openDoorExit of ExitFeature
	(properties
		nsLeft 454
		nsTop 40
		nsRight 486
		nsBottom 121
		approachX 460
		approachY 126
		x 472
		y 80
		nextRoom 290
		message 7
	)

	(method (init)
		(super init: gTheExitECursor)
		(self approachVerbs: 7) ; ExitRight
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gCurRoom setScript: sOpenDoor 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barGeek of Prop
	(properties
		noun 22
		sightAngle 40
		x 104
		y 122
		priority 122
		fixPriority 1
		view 300
		loop 1
		signal 20513
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(geekHead init:)
		(geekArm init:)
		(geekHand init:)
		(self setScript: sBarGeekMoves)
	)
)

(instance geekHead of Actor
	(properties
		noun 22
		sightAngle 40
		x 108
		y 85
		priority 124
		fixPriority 1
		view 300
		loop 2
		signal 20513
		cycleSpeed 8
	)
)

(instance geekArm of Actor
	(properties
		noun 22
		sightAngle 40
		x 104
		y 122
		priority 122
		fixPriority 1
		view 300
		loop 1
		cel 1
		signal 20513
		cycleSpeed 8
	)
)

(instance geekHand of Actor
	(properties
		noun 22
		sightAngle 40
		x 122
		y 88
		priority 123
		fixPriority 1
		view 300
		loop 1
		cel 3
		signal 20513
	)
)

(instance guy1 of Prop
	(properties
		noun 23
		sightAngle 40
		x 224
		y 151
		view 3000
		loop 1
		signal 20513
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(= scratch (proc0_8 0 2))
	)
)

(instance guy2 of Prop
	(properties
		noun 24
		sightAngle 40
		x 268
		y 155
		view 3001
		loop 3
		signal 20513
	)

	(method (init)
		(super init:)
		(switch (guy1 scratch:)
			(0
				(if (proc0_8 0 1)
					(= scratch 1)
				else
					(= scratch 2)
				)
			)
			(1
				(if (proc0_8 0 1)
					(= scratch 0)
				else
					(= scratch 2)
				)
			)
			(2
				(if (proc0_8 0 1)
					(= scratch 1)
				else
					(= scratch 2)
				)
			)
		)
	)
)

(instance soldier of Prop
	(properties
		noun 28
		sightAngle 40
		x 295
		y 121
		view 3003
		cel 1
		signal 20513
	)
)

(instance laugher of Prop
	(properties
		noun 21
		sightAngle 40
		x 25
		y 113
		view 3002
		cel 8
		signal 20513
	)
)

(instance bartender of Actor
	(properties
		noun 3
		sightAngle 40
		approachX 185
		approachY 122
		x 205
		y 90
		priority 120
		fixPriority 1
		view 3041
		signal 22561
	)

	(method (doit)
		(super doit:)
		(if (!= script sBartUnhook)
			(cond
				((OneOf view 304 305 3050 3072)
					(if (!= priority 89)
						(self setPri: 89)
					)
				)
				((!= priority 120)
					(self setPri: 120)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local4
					(gMessager say: 3 0 37) ; "The bartender is mixing your drink. Leave him alone and solve some puzzles or something."
				else
					(gCurRoom setScript: sShowID)
				)
			)
			(68 ; Roger_ID
				(if local4
					(gMessager say: 3 0 37) ; "The bartender is mixing your drink. Leave him alone and solve some puzzles or something."
				else
					(gCurRoom setScript: sShowID 0 1)
				)
			)
			(4 ; Do
				(if local4
					(gMessager say: 3 0 37) ; "The bartender is mixing your drink. Leave him alone and solve some puzzles or something."
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if local4
					(gMessager say: 3 0 37) ; "The bartender is mixing your drink. Leave him alone and solve some puzzles or something."
				else
					(gCurRoom setScript: sTalkToBartender)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glass of Actor
	(properties
		x 164
		y 84
		priority 120
		fixPriority 1
		view 3041
		loop 1
		xStep 1
		moveSpeed 1
	)
)

(instance barfly of Prop
	(properties
		noun 25
		sightAngle 40
		x 256
		y 118
		priority 121
		fixPriority 1
		view 3006
		cel 1
		signal 20513
	)
)

(instance pinky of Prop
	(properties
		sightAngle 40
		x 113
		y 121
		view 3006
		loop 4
		signal 20513
		cycleSpeed 9
	)
)

(instance bigLegs of Prop
	(properties
		noun 26
		sightAngle 40
		x 322
		y 135
		view 3004
		loop 1
		signal 20513
	)
)

(instance flyGirl of Prop
	(properties
		noun 27
		sightAngle 40
		x 293
		y 112
		view 3005
		signal 20513
		cycleSpeed 10
	)
)

(instance flies of Prop
	(properties
		noun 27
		sightAngle 40
		x 293
		y 56
		priority 113
		fixPriority 1
		view 3005
		loop 1
		cel 9
		signal 16417
	)
)

(instance fridgeDoor of Prop
	(properties
		noun 11
		sightAngle 40
		approachX 119
		approachY 113
		x 130
		y 70
		z 13
		view 3080
		signal 16417
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: hoseSproing)
					(gMessager say: 11 4 34) ; "You can't open the refrigeration unit with the hoses connected and stretched tightly across its front."
				else
					(gCurRoom setScript: sOpenFridge)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (event modifiers:))
				(not (self onMe: event))
				(not (fridgeOpen onMe: event))
				(not (tray onMe: event))
			)
			(gCurRoom setScript: sCloseFridge)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance padLights of Prop
	(properties
		sightAngle 40
		x 376
		y 47
		priority 114
		fixPriority 1
		view 3020
		loop 1
		cel 2
		cycleSpeed 10
	)
)

(instance restroomSign of Prop
	(properties
		sightAngle 40
		x 331
		y 31
		priority 31
		fixPriority 1
		view 3031
		loop 2
		cycleSpeed 10
	)
)

(instance sign2 of Prop
	(properties
		sightAngle 40
		x 177
		y 39
		priority 39
		fixPriority 1
		view 3031
		loop 1
		cycleSpeed 10
	)
)

(instance nitro of Prop
	(properties
		noun 15
		case 17
		sightAngle 40
		x 61
		y 76
		view 3070
		loop 1
		signal 16417
	)
)

(instance hoseSproing of Prop
	(properties
		noun 16
		case 34
		sightAngle 40
		x 61
		y 74
		priority 84
		fixPriority 1
		view 3071
		loop 1
		signal 16417
		cycleSpeed 8
	)
)

(instance danglingHose of View
	(properties
		noun 16
		case 33
		sightAngle 40
		approachX 44
		approachY 109
		x 62
		y 124
		z 35
		priority 89
		fixPriority 1
		view 3070
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sPickHoseUp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bentConduit of View
	(properties
		noun 17
		sightAngle 40
		x 176
		y 83
		view 3061
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(and
							(== ((gTheIconBar at: 2) cursorView:) hoseCursor)
							(not local4)
						)
						(gCurRoom setScript: sNotGonnaAllowIt)
					)
					((== ((gTheIconBar at: 2) cursorView:) hoseCursor)
						(gCurRoom setScript: sMakeConnection)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance babe of View
	(properties
		noun 20
		sightAngle 40
		x 8
		y 117
		view 3002
		loop 2
	)
)

(instance blender of View
	(properties
		noun 10
		sightAngle 40
		approachX 268
		approachY 122
		x 267
		y 84
		view 3031
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (bartender script:) sBartenderAction)
					(gCurRoom setScript: sDoOnBlender)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tray of View
	(properties
		sightAngle 40
		approachX 119
		approachY 113
		x 140
		y 75
		z 15
		priority 56
		fixPriority 1
		view 308
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetTray)
			)
			(1 ; Look
				(fridgeOpen doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bar of Feature
	(properties
		noun 2
		sightAngle 40
		x 183
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 116 61 91 77 87 264 87 274 84 305 91 305 102 294 116
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottles of Feature
	(properties
		noun 14
		sightAngle 40
		x 206
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 84 183 56 229 56 229 84
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 147 55 147 42 153 42 153 55
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance conduits1 of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 102
		approachY 51
		x 102
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 102 41 0 163 0 163 10 101 10 101 58 95 58 95 76 89 76 89 11 64 11 64 63 57 63 57 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun 4 9) ; "It's solidly in place."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance conduits2 of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 173
		approachY 108
		x 173
		y 43
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 87 165 0 258 0 258 85 242 85 242 14 183 14 183 87
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(conduits1 doVerb: theVerb)
	)
)

(instance conduits3 of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 287
		approachY 64
		x 287
		y 44
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 85 278 0 297 0 297 88
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(conduits1 doVerb: theVerb)
	)
)

(instance conduitSpecial of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 44
		approachY 109
		x 60
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 57 77 57 63 64 63 64 77 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1) ; "An interesting arrangement of conduits creates an almost artistic pattern to the backbar area. It's hard to tell what is merely decorative and what is functional."
			)
			(4 ; Do
				(gMessager say: 5 4 9) ; "It's solidly in place."
			)
			(73 ; Hookah_Connected
				(gCurRoom setScript: sHookHoseLeft)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(not (bentConduit onMe: event))
				)
				(valve3 onMe: event)
			)
			(if (gMouseDownHandler contains: self)
				(gMouseDownHandler delete: self)
			)
			(gCurRoom setScript: sPutHoseDown)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance conduitBendable of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 156
		approachY 114
		x 176
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 87 173 77 179 77 179 87
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 36)
					(gCurRoom setScript: sBendConduit)
				else
					(gMessager say: noun 4 9) ; "It's solidly in place."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fridgeOpen of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 119
		approachY 113
		x 145
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 56 159 56 159 80 152 81 131 81
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: tray)
					(tray doVerb: theVerb)
				else
					(gCurRoom setScript: sCloseFridge)
				)
			)
			(1 ; Look
				(cond
					((and (gCast contains: tray) (IsFlag 25))
						(gMessager say: 18 1 20) ; "The same chilled beverages are here, along with an ice cube tray of endodroid."
					)
					((gCast contains: tray)
						(gMessager say: 18 1 18) ; "The refrigeration unit contains an ice cube tray and some chilled beverages, none of which looks very enticing to you. You have to be careful about what you consume in these universal spaceport bars. One creature's wine is another creature's bile and vice versa."
					)
					(else
						(gMessager say: 18 1 19) ; "Just the same old chilled stuff."
					)
				)
			)
			(13 ; Empty_Tray
				(gCurRoom setScript: sPutTray 0 theVerb)
			)
			(65 ; Full_Tray
				(gCurRoom setScript: sPutTray 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevator of Feature
	(properties
		noun 4
		sightAngle 40
		x 386
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 368 120 368 0 376 0 376 113 397 113 397 0 405 0 405 120
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance floor of Feature
	(properties
		noun 12
		sightAngle 40
		x 157
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 112 40 102 59 102 60 119 300 119 305 104 368 111 368 119 444 120 475 124 475 137 312 137 3 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light1 of Feature
	(properties
		noun 13
		sightAngle 40
		x 75
		y 26
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 69 53 69 0 81 0 81 53 yourself:)
		)
		(super init: &rest)
	)
)

(instance light2 of Feature
	(properties
		noun 13
		sightAngle 40
		x 108
		y 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 94 15 94 0 123 0 123 15 yourself:)
		)
		(super init: &rest)
	)
)

(instance light3 of Feature
	(properties
		noun 13
		sightAngle 40
		x 238
		y 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 17 223 0 253 0 253 17
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance valve1 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 146
		approachY 114
		x 163
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 77 161 72 166 72 166 77
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTurnValve 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance valve2 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 150
		approachY 114
		x 169
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 167 77 167 72 171 72 171 77
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTurnValve 0 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance valve3 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 156
		approachY 114
		x 174
		y 84
		z 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 77 172 72 176 72 176 77
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTurnValve 0 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance valve4 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 160
		approachY 114
		x 179
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 77 177 72 181 72 181 77
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTurnValve 0 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit310 of ExitFeature
	(properties
		sightAngle 40
		approachX 384
		approachY 116
		x 388
		y 117
		nextRoom 310
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 370 0 370 119 401 119 401 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(gGame handsOff:)
				(gCurRoom setScript: sPadTo310)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit330 of ExitFeature
	(properties
		nextRoom 330
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 110 0 138 10 138 10 110
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; ExitLeft
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 130 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 8)
	)
)

(instance sFX of Sound
	(properties
		number 303
	)
)

(instance sFXToilet of Sound
	(properties
		number 306
	)
)

(instance sFXMix of Sound
	(properties
		number 30008
	)
)

(instance hoseCursor of Cursor
	(properties
		view 9530
		cel 1
	)
)

(instance bartenderTalker of SmallTalker
	(properties
		talkView 304
		talkLoop 1
	)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Barman})
			)
			(49
				(= name {Barkeeper})
			)
			(else
				(= name {Bartender})
			)
		)
		(= client bartender)
		(if local5
			(= talkLoop 2)
		else
			(= talkLoop 1)
		)
		(super init:)
	)
)

