;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use PursuitRgn)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
	sOutTapestry 1
	rm440Door 2
	noise 3
	bolt 4
)

(instance rm440 of LBRoom
	(properties
		noun 8
		picture 440
		horizon 135
		north 448
		east 430
		south 490
		vanishingY 90
	)

	(method (init)
		(LoadMany rsVIEW 432 424 423 858 831 426 442 440 443)
		(LoadMany rsSOUND 442 440)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 155 0 190 90
		)
		(if (== gAct 5)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2440 0) doit: (gCurRoom obstacles:)) ; poly2440Code
			(if (not (IsFlag 45))
				((ScriptID 94 1) seconds: 1) ; pursuitTimer
			)
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(switch gPrevRoomNum
			(north
				(gEgo x: 171 y: 148)
				(if (IsFlag 47)
					(gCurRoom setScript: (ScriptID 444 0)) ; sHeKills
				)
				(gGame handsOn:)
			)
			(south
				(gEgo x: 160 y: 210 loop: 3)
				(self setScript: sEnterSouth)
			)
			(east
				(gEgo x: 197 y: 143)
				(self setScript: sEnterEast)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
			((ScriptID 443 1) addToPic:) ; blood
			(if (not (gEgo has: 12)) ; workBoot
				((ScriptID 443 0) init: approachVerbs: 4 1 8) ; boot, Do, Look, magnifier
			)
		)
		(if (and (> gAct 2) (not (== gAct 5)))
			((ScriptID 443 4) init: approachVerbs: 4 1 8) ; armorPippin, Do, Look, magnifier
		else
			(armorPippin
				init:
				approachVerbs:
					(if (== gAct 5)
						0
					else
						4
						1
						8
					)
			)
		)
		(rm440Door init: doubleDoor: otherHalf stopUpd: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(otherHalf init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(bolt init:)
		(if (IsFlag 41)
			(rm440Door cel: 0)
			(otherHalf cel: 0)
			(bolt cel: 3)
		)
		(chest init:)
		(tapestry init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(painting init:)
		(dogArmor init:)
		(genericArmor init:)
		(genericFlag init:)
		(rightDoorway init:)
		(rearDoorway init:)
		(roundWin init:)
		(southExitFeature init:)
		((ScriptID 1881 2) x: 12 y: 85 textX: 125 textY: 0) ; Laura
	)

	(method (dispose)
		(DisposeScript 441)
		(DisposeScript 442)
		(DisposeScript 443)
		(DisposeScript 444)
		(if (== gAct 5)
			(DisposeScript 2440)
		)
		(gWalkHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(otherHalf setPri: 10)
				(bolt setPri: 11)
				(gCurRoom setScript: sExitEast)
			)
			((StepOn gEgo 8)
				(gCurRoom setScript: sExitSouth)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) $0040) ; direction
					(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
					(!= (event message:) JOY_NULL)
					(== (gEgo view:) 443)
				)
				(event claimed: 1)
				(gEgo setScript: sOutTapestry)
			)
			((& (event type:) evMOVE)
				(super handleEvent: event)
			)
			(else
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (== (gEgo view:) 443)
					(gEgo setScript: sOutTapestry)
				else
					((ScriptID 441 4) seconds: 1) ; countTimer
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (notify)
		(cond
			((== gAct 5)
				(if
					(and
						(gCurRoom script:)
						(not (== (gCurRoom script:) (ScriptID 444 0))) ; sHeKills
					)
					((gCurRoom script:) next: (ScriptID 444 0)) ; sHeKills
				else
					(gCurRoom setScript: (ScriptID 444 0)) ; sHeKills
				)
			)
			((and (== gAct 3) (TimeCheck $2020 1)) ; can 2:00 am occur?
				(self setScript: sMeetingNo2)
			)
			((and (== gAct 3) (TimeCheck $1008 1)) ; can 1:00 am occur?
				(LoadMany rsVIEW 444 825)
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gGame handsOff:)
				(if (== (gEgo view:) 443)
					(gGame points: 1 149)
					(self setScript: (ScriptID 441 0)) ; sCountessMeeting
				else
					(self setScript: (ScriptID 441 1)) ; sCountessNoMeet
				)
			)
		)
	)
)

(instance sMeetingNo2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gGame handsOff:)
				(LoadMany rsVIEW 820 814)
				((ScriptID 90 2) moveTo: 440) ; aOlympia
				(= cycles 1)
			)
			(2
				((ScriptID 90 2) loop: 1 x: 228 y: 133) ; aOlympia
				(if ((ScriptID 90 2) scaler:) ; aOlympia
					(((ScriptID 90 2) scaler:) doit:) ; aOlympia
				)
				(= cycles 1)
			)
			(3
				((ScriptID 90 2) view: 820) ; aOlympia
				(= cycles 3)
			)
			(4
				(if (== (gEgo view:) 443)
					((ScriptID 90 2) setScript: (ScriptID 442 0) self) ; aOlympia, sOHMeeting
				else
					((ScriptID 90 2) setScript: (ScriptID 442 1) self) ; aOlympia, sOHNoMeet
				)
			)
			(5
				((ScriptID 90 2) setScript: (ScriptID 442 2) self) ; aOlympia, sOHLeave
			)
			(6
				(= cycles 3)
			)
			(7
				(DisposeScript 442)
				(if (== (gEgo view:) 443)
					(gGame handsOn:)
					(gTheIconBar disable: 1 2 5 6)
				else
					(gGame handsOn:)
				)
				((ScriptID 90 2) moveTo: 430 wandering: 1) ; aOlympia
				(self dispose:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 236 136 self)
			)
			(2
				(if
					(and
						(== gAct 3)
						(TimeCheck $b102 1) ; can 11:15 pm occur?
						(not (IsFlag 72))
					)
					(gCurRoom newRoom: 435)
				else
					(gCurRoom newRoom: 430)
				)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 170 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 275 self)
			)
			(2
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance sHideInTapestry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 1 2 5 6)
				(gGame handsOff:)
				(if (not (== gAct 5))
					(WrapMusic pause: 1)
					(gGameMusic2 number: 5 flags: 1 loop: -1 play:)
				)
				(= cycles 1)
			)
			(1
				(gWalkHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(gEgo
					view: 443
					loop: 1
					cel: 0
					posn: 11 147
					setCycle: CT 5 1 self
				)
			)
			(2
				(noise number: 442 flags: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 0 cel: 0)
				(= cycles 1)
			)
			(4
				(if
					(or
						(and
							(== gAct 3)
							(TimeCheck $1008 1) ; can 1:00 am occur?
							((ScriptID 90 15) seconds:) ; meetingTimer
						)
						(and
							(== gAct 3)
							(TimeCheck $2020 1) ; can 2:00 am occur?
							((ScriptID 90 15) seconds:) ; meetingTimer
						)
					)
					((ScriptID 90 15) seconds: 1) ; meetingTimer
				else
					(gGame handsOn: 1)
				)
				(southExitFeature dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sOutTapestry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (== (gCurRoom script:) (ScriptID 441 0)) ; sCountessMeeting
					(gCurRoom script: 0)
				)
				(gEgo setCycle: End self)
				(noise number: 442 flags: 1 play:)
			)
			(2
				(gEgo
					normalize: (if (== gAct 5) 426 else 831)
					posn: 20 151
				)
				(if
					(and
						(== ((ScriptID 90 1) room:) 440) ; aCountess
						(TimeCheck $1008) ; has 1:00 am occurred?
						(not (TimeCheck $1310)) ; has 1:45 am occurred?
						(not (IsFlag 120))
					)
					(gEgo setScript: (ScriptID 441 3) self) ; sTalkWithCountess
					(self dispose:)
				else
					(gWalkHandler delete: gCurRoom)
					(gDirectionHandler delete: gCurRoom)
					(= cycles 1)
				)
			)
			(3
				(gGameMusic2 fade:)
				(if (not (== gAct 5))
					(WrapMusic pause: 0)
				)
				(gGame handsOn: 1)
				(southExitFeature init:)
				(gTheIconBar enable: 1 2 5 6)
				(self dispose:)
			)
		)
	)
)

(instance sBoltDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 213 146 self)
			)
			(2
				(gEgo
					view: 442
					loop: 2
					cel: 3
					posn: 207 144
					cycleSpeed: 12
					setCycle: Beg self
				)
				(bolt setPri: (- (gEgo priority:) 1))
				(bolt setCycle: End)
			)
			(3
				(noise number: 446 flags: 1 loop: 1 play:)
				(gEgo view: 831 loop: 8 cel: 6 posn: 213 146)
				(= cycles 1)
			)
			(4
				(gEgo normalize: (if (== gAct 5) 426 else 831))
				(= cycles 1)
			)
			(5
				(bolt stopUpd:)
				(if (== gAct 5)
					(= cycles 1)
				else
					(client setScript: sUnBoltDoor)
				)
			)
			(6
				(gGame handsOn:)
				(rm440Door locked: 1)
				(if (== gAct 5)
					(PursuitRgn increaseTime:)
				)
				(SetFlag 41)
				(self dispose:)
			)
		)
	)
)

(instance sUnBoltDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 213 146 self)
			)
			(2
				(gEgo
					view: 442
					loop: 2
					cel: 0
					posn: 207 144
					cycleSpeed: 12
					setCycle: End self
				)
				(bolt setCycle: Beg)
				(noise number: 446 flags: 1 loop: 1 play:)
			)
			(3
				(gEgo view: 831 loop: 8 cel: 6 posn: 213 146)
				(= cycles 1)
			)
			(4
				(gEgo normalize: (if (== gAct 5) 426 else 831))
				(= cycles 1)
			)
			(5
				(bolt stopUpd:)
				(if (== gAct 5)
					(= cycles 1)
				else
					(gMessager say: 12 4 3 0 self) ; "While it was fun to lock the door, you think better of it at this time, since it might annoy the museum staff."
				)
			)
			(6
				(gGame handsOn:)
				(rm440Door locked: 0)
				(if (== gAct 5)
					(PursuitRgn decreaseTime:)
				)
				(ClearFlag 41)
				(self dispose:)
			)
		)
	)
)

(instance otherHalf of Prop
	(properties
		x 225
		y 139
		noun 12
		approachX 199
		approachY 145
		view 440
		loop 4
		cel 7
		signal 16385
	)
)

(instance rm440Door of Door
	(properties
		x 211
		y 137
		noun 12
		approachX 199
		approachY 145
		view 440
		loop 3
		cel 7
		forceOpen 1
		forceClose 0
		moveToX 236
		moveToY 136
	)

	(method (createPoly)
		(super createPoly: 205 130 230 134 229 144 206 138)
	)

	(method (open)
		(bolt setPri: 15)
		(super open:)
	)

	(method (close)
		(bolt setPri: 15)
		(super close:)
	)

	(method (cue)
		(super cue:)
		(bolt setPri: 11)
		(otherHalf stopUpd:)
		(bolt stopUpd:)
	)
)

(instance bolt of Prop
	(properties
		x 225
		y 160
		z 45
		noun 12
		view 440
		loop 5
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((rm440Door locked:)
						(gCurRoom setScript: sUnBoltDoor)
					)
					((== (rm440Door state:) 2)
						(rm440Door close:)
					)
					(else
						(gCurRoom setScript: sBoltDoor)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDoor of Feature ; UNUSED
	(properties
		x 94
		y 88
		noun 6
		nsTop 89
		nsLeft 90
		nsBottom 134
		nsRight 99
		sightAngle 40
	)
)

(instance chest of Feature
	(properties
		x 295
		y 140
		noun 4
		nsTop 118
		nsLeft 271
		nsBottom 163
		nsRight 319
		sightAngle 40
	)
)

(instance tapestry of Feature
	(properties
		x 28
		y 91
		noun 9
		nsTop 35
		nsLeft 5
		nsBottom 147
		nsRight 51
		sightAngle 40
		approachX 20
		approachY 151
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (== (gEgo view:) 443))
						(or
							(== gAct 5)
							(== (== ((ScriptID 90 1) room:) 440) 0) ; aCountess
						)
					)
					(if (or (== gAct 5) (MuseumRgn nobodyAround:))
						(gCurRoom setScript: sHideInTapestry)
					else
						(return 1)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 265
		y 95
		noun 5
		nsTop 79
		nsLeft 255
		nsBottom 111
		nsRight 276
		sightAngle 40
	)
)

(instance dogArmor of Feature
	(properties
		y 100
		noun 3
		onMeCheck 16384
	)
)

(instance genericArmor of Feature
	(properties
		y 160
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 1 4) ; "The steel armor feels smooth and cool."
			)
			(8 ; magnifier
				(gMessager say: 1 8) ; "Up close, the suit of armor looks scratched."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (< 59 gMouseX 70) (< 83 gMouseY 143))
						(= noun 24)
					)
					((and (< 72 gMouseX 84) (< 91 gMouseY 143))
						(= noun 25)
					)
					((and (< 86 gMouseX 100) (< 93 gMouseY 143))
						(= noun 26)
					)
					((and (< 103 gMouseX 110) (< 105 gMouseY 134))
						(= noun 27)
					)
					((and (< 115 gMouseX 130) (< 104 gMouseY 149))
						(= noun 28)
					)
					((and (< 171 gMouseX 185) (< 96 gMouseY 135))
						(= noun 30)
					)
					((and (< 187 gMouseX 201) (< 91 gMouseY 137))
						(= noun 31)
					)
					((and (< 225 gMouseX 256) (< 97 gMouseY 188))
						(= noun 32)
					)
				)
			)
		)
	)
)

(instance genericFlag of Feature
	(properties
		y 50
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 2 4) ; "They're too high for you to reach."
			)
			(8 ; magnifier
				(gMessager say: 2 8) ; "They're too high for you to magnify."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (<= 45 gMouseX 130) (<= 0 gMouseY 23))
						(= noun 14)
					)
					((and (<= 76 gMouseX 116) (<= 25 gMouseY 43))
						(= noun 15)
					)
					((and (<= 92 gMouseX 117) (<= 44 gMouseY 54))
						(= noun 16)
					)
					((and (<= 95 gMouseX 119) (<= 56 gMouseY 72))
						(= noun 17)
					)
					((and (<= 99 gMouseX 118) (<= 72 gMouseY 82))
						(= noun 18)
					)
					((and (<= 106 gMouseX 123) (<= 83 gMouseY 95))
						(= noun 19)
					)
					((and (<= 154 gMouseX 177) (<= 64 gMouseY 77))
						(= noun 20)
					)
					((and (<= 148 gMouseX 191) (<= 39 gMouseY 62))
						(= noun 21)
					)
					((and (<= 139 gMouseX 198) (<= 0 gMouseY 38))
						(= noun 22)
					)
					((and (<= 215 gMouseX 270) (<= 0 gMouseY 20))
						(= noun 23)
					)
				)
			)
		)
	)
)

(instance rightDoorway of Feature
	(properties
		x 218
		y 112
		noun 7
		nsTop 85
		nsLeft 214
		nsBottom 139
		nsRight 223
		sightAngle 40
	)
)

(instance rearDoorway of Feature
	(properties
		x 140
		y 116
		noun 13
		nsTop 101
		nsLeft 111
		nsBottom 131
		nsRight 169
		sightAngle 40
	)
)

(instance roundWin of Feature
	(properties
		x 138
		y 82
		noun 33
		nsTop 73
		nsLeft 125
		nsBottom 91
		nsRight 151
		sightAngle 40
	)
)

(instance armorPippin of Feature
	(properties
		x 151
		y 128
		noun 10
		nsTop 96
		nsLeft 140
		nsBottom 160
		nsRight 164
		sightAngle 40
		approachX 128
		approachY 165
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gAct 5)
					(gMessager say: 38) ; "You don't have time for that! Someone's chasing you!"
				else
					(gMessager say: 10 1 2) ; "The suit of armor is empty."
				)
			)
			(4 ; Do
				(if (== gAct 5)
					(gMessager say: 38) ; "You don't have time for that! Someone's chasing you!"
				else
					(gMessager say: 10 4 2) ; "The suit of armor feels like cold steel and it sounds hollow."
				)
			)
			(8 ; magnifier
				(if (== gAct 5)
					(gMessager say: 38) ; "You don't have time for that! Someone's chasing you!"
				else
					(gMessager say: 10 8 2) ; "No matter how closely you look, you see nothing at all in the suit of armor."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 35
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

