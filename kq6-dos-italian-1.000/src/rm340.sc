;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use rSacred)
(use genie_341)
(use n342)
(use n343)
(use nightMare)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
	theDoor 1
	labRock 2
)

(local
	local0
	local1
	local2
	local3
)

(instance cliffTalk of Conversation
	(properties)
)

(instance rm340 of KQ6Room
	(properties
		noun 3
		picture 340
		horizon 70
		walkOffEdge 1
	)

	(method (notify)
		(proc344_1)
	)

	(method (init)
		(super init: &rest)
		(Lock rsMESSAGE 340 0)
		(proc343_0)
		(gFeatures
			add: labDoor niteShade cave oracle myPath mount
			eachElementDo: #init
		)
		(if (IsFlag 1)
			(= local2 23)
			(minoOpening init:)
		else
			(= local2 20)
		)
		(gCast add: theDoor labRock rockStep berries eachElementDo: #init)
		(gGlobalSound number: 340 setLoop: -1 play:)
		(rockStep addToPic: dispose:)
		(gEgo actions: egoDoVerb init:)
		(cond
			((== gPrevRoomNum 390)
				(gCurRoom setScript: crawlOutOfCave)
			)
			((== gPrevRoomNum 405)
				(gGame handsOff:)
				(if (and (IsFlag 14) (IsFlag 4) (not (IsFlag 15)))
					(LoadMany rsVIEW 335 337 336)
					(gGlobalSound2 number: 345 play:)
					(Load rsSCRIPT 344)
					(proc344_0)
				)
				(gCurRoom setScript: fromLab)
			)
			((== gPrevRoomNum 440)
				(gEgo
					posn: 18 138
					view: 361
					setLoop: 0
					setPri: 9
					cel: 0
					normal: 0
					hide:
				)
				(if (not (IsFlag 3))
					(Load rsSCRIPT 342)
					(berries addToPic: dispose:)
					(theDoor addToPic: dispose:)
					(UnLoad 128 330)
					(proc342_0)
				else
					(gGame handsOff:)
					(if (and (IsFlag 14) (IsFlag 4) (not (IsFlag 15)))
						(LoadMany rsVIEW 335 337 336)
						(gGlobalSound2 number: 345 play:)
						(Load rsSCRIPT 344)
						(proc344_0)
					)
					(gCurRoom setScript: fromLab)
				)
			)
			((== gPrevRoomNum 370)
				(gCurRoom north: 0)
				(Load rsSCRIPT 342)
				(gEgo posn: 340 -10 reset: ignoreHorizon:)
				(proc342_1)
			)
			((and (not (IsFlag 1)) (IsFlag 2))
				(LoadMany rsVIEW 343 344)
				(Load rsSCRIPT 342)
				(berries addToPic: dispose:)
				(proc342_2)
			)
			((== gPrevRoomNum 350)
				(gGame handsOn:)
				(gEgo
					reset:
					posn: 232 77
					setScale: Scaler 100 5 105 65
					setMotion: MoveTo 236 122
				)
				((gEgo scaler:) doit:)
			)
			(else
				(cond
					((and (OneOf gPrevRoomNum 320 300) (not (IsFlag 4)))
						(LoadMany rsVIEW 334 330)
						(Load rsSCRIPT 341)
						(proc341_0)
					)
					((and (IsFlag 14) (IsFlag 4) (not (IsFlag 15)))
						(LoadMany rsVIEW 335 337 336)
						(gGlobalSound2 number: 345 play:)
						(Load rsSCRIPT 344)
						(proc344_0)
					)
				)
				(gEgo
					view: 301
					loop: 6
					normal: 0
					posn: 219 199
					cycleSpeed: 10
					setPri: 15
					setScale: Scaler 100 5 105 65
				)
				(gCurRoom setScript: egoEnters)
			)
		)
		(SetFlag 157)
	)

	(method (cue)
		(cond
			((== (rSacred geniePresent:) 1)
				(gMessager say: 3 1 21 1) ; "An old woman is standing nearby. She peers at Alexander with friendly interest."
			)
			((== (rSacred marePresent:) 1)
				(gMessager say: 3 1 22 1) ; "A winged horse is feeding from the nightshade bush. Its coat is as black as midnight, and its eyes are as blue as rain."
			)
		)
	)

	(method (dispose)
		(LoadMany 0 341 342 344)
		(if (not (== (gGlobalSound2 number:) 155))
			(gGlobalSound2 fade: 0 5 5)
		)
		(rSacred marePresent: 0)
		(gEgo setScale: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(if (IsFlag 1)
						(gMessager say: 3 1 23 1 self) ; "Alexander is standing at the top of the Cliffs of Logic on the Isle of the Sacred Mountain. To the north, the peak of the Sacred Mountain, scarred with the opening to the Oracle's cave, rises to the clouds. To the left, the doors to the catacombs stand open."
					else
						(gMessager say: 3 1 20 1 self) ; "Alexander is standing at the top of tall cliffs. To the north is the peak of a mountain, rising to meet the clouds. To the left is an ominous set of bolted doors."
					)
					1
				)
				(2 ; Talk
					(cond
						((== (rSacred geniePresent:) 1)
							(gMessager say: 3 2 21 1) ; "There's no one there to talk to. Alexander might try addressing the old woman if he's in the mood for conversation."
						)
						((== (rSacred marePresent:) 1)
							(gMessager say: 3 2 22 1) ; "Alexander refrains from shouting to the wind for fear of startling the winged horse."
						)
						(else
							(gMessager say: 3 2 24 1) ; "There's no one to speak to here."
						)
					)
					1
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			(local3)
			((== (gEgo onControl: 1) 16)
				(gGlobalSound fade: 0 10 10)
				(gCurRoom newRoom: 405)
			)
			((and (== (gEgo onControl: 1) 512) (IsFlag 1))
				(gGlobalSound fade: 0 10 10)
				(gCurRoom setScript: goToLair)
			)
			((== (gEgo onControl: 1) 1024)
				(gGlobalSound fade: 0 10 10)
				(gCurRoom setScript: stepDown)
			)
			((== (gEgo onControl: 1) 2)
				(gGame handsOff:)
				(gCurRoom setScript: dieHard)
			)
			((== (gEgo edgeHit:) 1)
				(gGame handsOff:)
				(gGlobalSound fade: 0 10 10)
				(gCurRoom setScript: goNorth)
			)
		)
		(super doit:)
	)

	(method (newRoom)
		(= local3 1)
		(super newRoom: &rest)
	)

	(method (scriptCheck &tmp temp0)
		(= temp0 1)
		(if (rSacred geniePresent:)
			(gMessager say: 0 0 4 1 0 899) ; "Alexander doesn't want to be rude and do that while in the presence of the old matron. Perhaps he should wait until she leaves."
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance rockStep of View
	(properties
		x 154
		y 185
		noun 6
		view 341
	)
)

(instance theDoor of Prop
	(properties
		x 113
		y 67
		noun 4
		view 340
		priority 7
		signal 28688
		cycleSpeed 10
	)

	(method (init)
		(if (IsFlag 3)
			(self cel: 4 stopUpd:)
		else
			(self cel: 0 stopUpd:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(labDoor doVerb: theVerb &rest)
	)
)

(instance labRock of Actor
	(properties
		noun 5
		view 340
		loop 1
		signal 20480
	)

	(method (init)
		(if (IsFlag 3)
			(self posn: 0 149 stopUpd:)
		else
			(self posn: 9 137 stopUpd:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 local2 1)
			)
			(5 ; Do
				(gMessager say: 5 5 local2 1)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 5 0 local2 1)
			)
		)
	)
)

(instance berries of View
	(properties
		x 283
		y 112
		z 15
		noun 12
		view 330
		priority 7
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: gag_Die)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance labDoor of Feature
	(properties
		x 98
		y 166
		noun 4
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1 local2 1)
			)
			(5 ; Do
				(cond
					((IsFlag 1)
						(gMessager say: 4 5 local2 1)
					)
					((gCurRoom script:) 0)
					(else
						(gCurRoom setScript: tryDoor)
					)
				)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 4 0 local2 1)
			)
		)
	)
)

(instance niteShade of Feature
	(properties
		x 295
		y 110
		noun 9
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cliffTalk add: -1 9 1 0 1 add: -1 9 1 0 2 init:) ; "A bush with dark, shiny leaves grows against the east cliff wall. The old woman identified it as nightshade.", "A small cluster of black berries tops the bush."
			)
			(5 ; Do
				(if (== (rSacred geniePresent:) 1)
					(gMessager say: 9 5 21 0) ; "Perhaps one of the leaves...?"
				else
					(gMessager say: 9 5 27 1) ; "Alexander isn't interested in the nightshade leaves, and there are no berries there."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance minoOpening of Feature
	(properties
		x 18
		y 131
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: goToLair)
		else
			(labRock doVerb: theVerb)
		)
	)
)

(instance cave of Feature
	(properties
		x 307
		y 106
		noun 7
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (== (rSacred geniePresent:) 1)
				(gMessager say: 7 5 21 1) ; "It would be rather rude to crawl into that cave with the old woman standing right in front of it."
			else
				(gCurRoom setScript: crawlIntoCave)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mount of Feature
	(properties
		x 256
		y 41
		noun 13
		onMeCheck 32
	)
)

(instance oracle of Feature
	(properties
		x 258
		y 15
		noun 14
		onMeCheck 128
	)
)

(instance myPath of Feature
	(properties
		x 232
		y 78
		noun 15
		onMeCheck 4096
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 320)
					(gGlobalSound3 number: 341 setLoop: -1 play:)
				)
				(gEgo
					view: 3011
					setLoop: 6
					setPri: 15
					cel: 0
					normal: 0
					posn: 257 237
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 0 posn: 228 223 setCycle: End self)
			)
			(2
				(gEgo cel: 0 posn: 199 209 setCycle: End self)
			)
			(3
				(gEgo cel: 0 posn: 175 195 setCycle: End self)
			)
			(4
				(gEgo
					view: 3011
					setLoop: 1
					cel: 5
					posn: 164 194
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				(gEgo view: 301 setLoop: 0 cel: 2 normal: 0 posn: 161 185)
				(= cycles 4)
			)
			(6
				(gEgo cel: 3 posn: 161 185)
				(= cycles 4)
			)
			(7
				(gEgo cel: 4 posn: 161 185)
				(= cycles 4)
			)
			(8
				(gEgo
					posn: 162 169
					reset: 6
					setScale: Scaler 100 5 105 65
					setMotion: MoveTo 172 160 self
				)
			)
			(9
				(= cycles 6)
			)
			(10
				(cond
					((and (== gPrevRoomNum 320) (not (IsFlag 4)))
						(gMessager say: 1 0 1 1) ; "Alexander finds himself...finally...at the top of the cliffs. Exhausted, he steps over the lip of the plateau and stands."
						(proc341_1)
					)
					((== gPrevRoomNum 300)
						(gGame handsOn:)
						(gMessager say: 1 0 33 1) ; "Alexander arrives at the top of the cliffs somewhat winded after his long but uneventful climb."
					)
					(else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 405)
					(gEgo
						posn: 109 107
						setScale: Scaler 100 5 105 65
						setMotion: PolyPath 138 122 self
					)
				else
					(gEgo
						show:
						ignoreActors: 1
						setScale: Scaler 100 5 105 65
						setPri: 8
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(1
				(if (== gPrevRoomNum 405)
					(self cue:)
				else
					(gEgo
						reset: 0
						posn: 22 138
						setMotion: MoveTo 63 148 self
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crawlOutOfCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 331
					setLoop: 3
					normal: 0
					posn: 331 108
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: Fwd
					setMotion: MoveTo 294 116 self
				)
			)
			(1
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(gEgo
					posn: (- (gEgo x:) 12) (+ (gEgo y:) 3)
					reset: 5
					setScale: Scaler 100 5 105 65
				)
				(self dispose:)
			)
		)
	)
)

(instance crawlIntoCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 283 121 self)
			)
			(1
				(= cycles 6)
			)
			(2
				(if (== (rSacred geniePresent:) 1)
					(gEgo setScript: 0)
					(proc341_3)
				)
				(if (IsFlag 96)
					(gMessager say: 7 5 32 1 self) ; "!!!Do not print this. Comment msg only."
				else
					(gMessager say: 7 5 31 1 self) ; "Alexander crawls through the small opening in the rock."
				)
			)
			(3
				(gEgo setHeading: 45)
				(= cycles 6)
			)
			(4
				(if (== (rSacred geniePresent:) 1)
					(proc341_2)
				)
				(gEgo
					setScale: 0
					view: 331
					normal: 0
					setLoop: 1
					cel: 5
					cycleSpeed: 10
					setPri: 7
					posn: 285 133
					setCycle: Beg self
				)
			)
			(5
				(DisposeScript 341)
				(gEgo
					setLoop: 2
					cel: 0
					cycleSpeed: 8
					moveSpeed: 8
					posn: 290 117
					setCycle: Fwd
					setMotion: MoveTo 331 106 self
				)
			)
			(6
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98 -32758)
				(= cycles 6)
			)
			(7
				(gGame handsOn:)
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance goNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (rSacred geniePresent:) 1)
					(self setScript: (ScriptID 341 5) self) ; poofAwayScript
				else
					(= cycles 6)
				)
			)
			(1
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance goToLair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 35 140 self)
			)
			(1
				(gEgo setHeading: 315)
				(= cycles 10)
			)
			(2
				(gEgo
					view: 362
					setLoop: 3
					cel: 0
					setPri: 9
					normal: 0
					posn: 15 146
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance tryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 127 118 self)
			)
			(1
				(gEgo setMotion: PolyPath 127 113 self)
			)
			(2
				(gEgo
					view: 361
					loop: 1
					normal: 0
					posn: 119 115
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo reset: 7 posn: 127 113)
				(= ticks 18)
			)
			(5
				(gMessager say: 4 5 20 1 self) ; "The huge doors are locked tight."
			)
			(6
				(gMessager say: 4 5 20 2 self) ; "Somebody obviously wants to keep something out--or something IN."
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0 posn: 162 169)
				(if (== (rSacred geniePresent:) 1)
					(self setScript: (ScriptID 341 5) self) ; poofAwayScript
				else
					(= cycles 6)
				)
			)
			(1
				(gEgo view: 301 setLoop: 8 cel: 6 normal: 0 posn: 152 170)
				(= cycles 4)
			)
			(2
				(gEgo cel: 0 normal: 0 posn: 168 177)
				(= cycles 4)
			)
			(3
				(gEgo cel: 5 normal: 0 posn: 151 170)
				(= cycles 4)
			)
			(4
				(gEgo cel: 2 normal: 0 posn: 165 178)
				(= cycles 4)
			)
			(5
				(gEgo
					view: 301
					setPri: 15
					cycleSpeed: 8
					setLoop: 8
					cel: 0
					normal: 0
					posn: 178 184
					setCycle: End self
				)
			)
			(6
				(gEgo cel: 0 normal: 0 posn: 198 197 setCycle: End self)
			)
			(7
				(gEgo cel: 0 normal: 0 posn: 218 209 setCycle: End self)
			)
			(8
				(gEgo cel: 0 normal: 0 posn: 239 220 setCycle: End self)
			)
			(9
				(gEgo y: 280)
				(= cycles 4)
			)
			(10
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance gag_Die of Script
	(properties
		name {gag&Die}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (rSacred geniePresent:)
					((ScriptID 341 4) setScript: 0) ; genie
				)
				(gEgo setScript: 0)
				(if (== (rSacred geniePresent:) 1)
					(= local0 21)
				else
					(= local0 27)
				)
				(gMessager say: 12 5 local0 1 self)
			)
			(1
				(gEgo setMotion: PolyPath 271 118 self)
			)
			(2
				(gEgo
					view: 331
					setLoop: 4
					cel: 0
					normal: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gMessager say: 12 5 local0 2 self)
			)
			(4
				(gMessager say: 12 5 local0 3 self)
			)
			(5
				(if (== (rSacred geniePresent:) 1)
					(proc341_3)
				)
				(gGlobalSound3 stop:)
				(gGlobalSound4 number: 343 setLoop: 1 play:)
				(gEgo
					view: 332
					loop: 1
					cel: 0
					posn: 247 128
					setCycle: End self
				)
			)
			(6
				(if (== (rSacred geniePresent:) 1)
					(proc341_2)
				)
				(= cycles 6)
			)
			(7
				(DisposeScript 341)
				(= cycles 6)
			)
			(8
				(gMessager say: 12 5 local0 4 self)
			)
			(9
				(EgoDead 20) ; "And then there's some land I have for sale in the death bogs of Tamir...."
			)
		)
	)
)

(instance dieHard of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= temp1 0)
				(gMessager say: 3 3 17 1 self 340) ; "Oops."
			)
			(1
				(gGlobalSound4 number: 305 setLoop: 1 play:)
				(gEgo
					setLoop: 2
					normal: 0
					cycleSpeed: 1
					setPri: 15
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(2
				(gGlobalSound4 number: 306 setLoop: 1 play: self)
				(gCurRoom walkOffEdge: 1)
				(gEgo
					setLoop: 2
					setStep: -1 15
					setMotion: MoveTo (gEgo x:) 300 self
				)
			)
			(3 0)
			(4
				(= seconds 4)
			)
			(5
				(gGlobalSound4 number: 307 setLoop: 1 play:)
				(ShakeScreen 3 ssUPDOWN)
				(= seconds 3)
			)
			(6
				(gMessager say: 3 3 17 2 self 340) ; "Alexander has plenty of time to rethink his logic as he falls past the riddles of the logic cliffs."
			)
			(7
				(EgoDead 8) ; "That wasn't a very logical step!"
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(return 0)
			)
			(5 ; Do
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(31 ; flute
				(if (and (IsFlag 14) (IsFlag 4) (not (IsFlag 15)))
					(gGame handsOff:)
					((ScriptID 344 2) setScript: (ScriptID 344 3)) ; nightMare, blowinIt
					(return 1)
				else
					(return 0)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

