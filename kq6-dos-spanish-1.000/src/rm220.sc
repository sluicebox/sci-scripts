;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use rgCrown)
(use walkEgoInScr)
(use KQ6Print)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Rev)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	rm220 0
	guardOpenDoorScr 1
	guardCloseDoorScr 2
	guard1 3
	guard2 4
	castleDoor 5
	saladin 6
	secondGuardDoorScr 7
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
)

(instance rm220 of KQ6Room
	(properties
		noun 3
		picture 220
		horizon 0
		south 210
		west 230
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PTotalAccess
					init: 60 229 -99 229 -99 124 119 122 150 135 154 149 54 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 30 138 134 138 134 149 30 149
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: -100 289 419 289 419 176 281 178 281 168 285 168 285 163 270 163 270 167 276 167 276 178 223 165 215 158 235 150 212 145 237 133 202 126 233 116 216 110 175 116 93 116 82 112 -100 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 182 229 182 185 235 185 235 229
					yourself:
				)
		)
		(LoadMany rsVIEW 725 224 220)
		(if (gEgo has: 5) ; clothes
			(LoadMany rsVIEW 221 733)
		)
		(super init: &rest)
		(SetFlag 162)
		(gEgo
			init:
			actions: egoDoVerbCode
			reset: 3
			setScale: Scaler 100 94 189 95
		)
		(switch gPrevRoomNum
			(150
				(gEgo reset: 2 hide:)
			)
			(230
				(proc12_1 12 118)
			)
			(else
				(proc12_1 155 184 38)
			)
		)
		(castleDoor init:)
		(guard1 init:)
		(guard2 init:)
		(genericFeatures init:)
		(guardHut init:)
		((ScriptID 10 4) onMeCheck: 1024 init:) ; rocks
		(backOffScr client: guard1)
		(cond
			((== gPrevRoomNum 150)
				(self setScript: (ScriptID 221 0)) ; seenVizierScr
			)
			(((ScriptID 10 0) isSet: 2) ; rgCrown
				(= local2 1)
				(proc10_2 (ScriptID 224 0)) ; clownScr
				(if (and (== gAct 3) (not (IsFlag 18)))
					(SetFlag 135)
				)
			)
			(
				(or
					(and
						(== gAct 3)
						(or (not (IsFlag 18)) (IsFlag 135))
					)
					(and (== gAct 5) (gEgo has: 5) (not (IsFlag 18))) ; clothes
				)
				(= local2 1)
				(proc10_2 (ScriptID 223 0)) ; slaveWomenScr
				(ClearFlag 135)
			)
		)
		(gGlobalSound number: 220 loop: -1 play:)
		(SetFlag 18)
	)

	(method (edgeToRoom param1)
		(switch param1
			(3
				(proc12_0 param1 38)
				0
			)
			(4
				(proc12_0 param1)
				0
			)
			(2
				(self setScript: bumpedTheEdgeScr)
				0
			)
			(else
				(super edgeToRoom: param1 &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 1) ; Look
				(gMessager say: noun theVerb (if (IsFlag 64) 23 else 22))
				1
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (InRect 106 110 140 118 (gEgo x:) (gEgo y:)))
		(if (and (== local2 1) ((ScriptID 10 0) isSet: 4096)) ; rgCrown
			(= local2 0)
			(gEgo setHeading: 0)
		)
		(cond
			(script 0)
			(
				(and
					(or (and temp0 (not local0)) (and (not temp0) local0))
					(not (guard1 script:))
					(not (guard2 script:))
				)
				(gCurRoom setScript: guardStanceScr)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 964)
		(DisposeScript 969)
		(if (== gNewRoomNum 210)
			(gGlobalSound fadeTo: 917 -1)
		else
			(gGlobalSound fade:)
		)
	)

	(method (cue)
		(self setScript: 88) ; boringBookScript
	)

	(method (scriptCheck param1 &tmp temp0)
		(switch param1
			(87
				(gMessager say: 0 0 1 0 0 899) ; "Alexander doesn't know what that potion might do! He doesn't want to frighten the guard dogs, and there's no one else here who might be impressed with the results!"
				(return 1)
			)
			(88
				(if (gEgo inRect: 252 148 308 178)
					(gMessager say: 7 0 16 1 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
					(return 0)
				else
					(return 1)
				)
			)
			(else
				(return 1)
			)
		)
	)
)

(instance egoDoVerbCode of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(45 ; clothes
				(gCurRoom setScript: wearClothingScr)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance bumpedTheEdgeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: 1)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 24 0 self) ; "There's nothing of interest beyond the castle."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guardCloseDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard1
					view: 725
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 108 97 self
				)
			)
			(1
				(guard1 setHeading: 0 self)
			)
			(2
				(castleDoor setCycle: Beg self)
			)
			(3
				(gGlobalSound4 number: 223 loop: 1 play:)
				(guard1 setHeading: 180 self)
			)
			(4
				(guard1 setMotion: MoveTo 100 109 self)
			)
			(5
				(guard1 setHeading: 90 self)
			)
			(6
				(guard1 view: 224 setLoop: -1 loop: 0 cel: 0)
				(= cycles 2)
			)
			(7
				(guard1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance guardOpenDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard1
					view: 725
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 112 105 self
				)
			)
			(1
				(guard1 setMotion: MoveTo 108 97 self)
			)
			(2
				(guard1 setHeading: 0 self)
			)
			(3
				(castleDoor setCycle: End self)
				(gGlobalSound4 number: 222 loop: 1 play:)
			)
			(4
				(if (not register)
					(guard1 setMotion: MoveTo 108 92 self)
				else
					(guard1 setMotion: MoveTo 90 97 self)
				)
			)
			(5
				(if (not register)
					(guard1
						setPri: 2
						setScale: Scaler 70 100 103 95
						setMotion: MoveTo 75 100 self
					)
				else
					(guard1 setHeading: 90 self)
				)
			)
			(6
				(client cue:)
			)
			(7
				(if (not register)
					(guard1 setMotion: MoveTo 108 92 self)
					(+= state 3)
				)
				(guard1 setMotion: MoveTo 108 97 self)
			)
			(8
				(guard1 setHeading: 0 self)
			)
			(9
				(castleDoor setCycle: Beg self)
			)
			(10
				(gGlobalSound4 number: 223 loop: 1 play:)
				(guard1 setHeading: 180 self)
			)
			(11
				(guard1 setScale: 0 setPri: -1 setMotion: MoveTo 100 109 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(guard1 setHeading: 90 self)
			)
			(14
				(guard1 view: 224 setLoop: -1 loop: 0 cel: 0)
				(= cycles 2)
			)
			(15
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= register 0)
	)
)

(instance guardStanceScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local4 (not (gEgo isStopped:)))
					(-- state)
				)
				(= cycles 2)
			)
			(1
				(= local4 0)
				(if (not local0)
					(guard1 loop: 2)
					(guard2 loop: 3)
					(guard1 setCycle: End)
					(guard2 setCycle: End self)
				else
					(guard1 setCycle: Beg)
					(guard2 setCycle: Beg self)
				)
			)
			(2
				(if (and (not local0) (not register) (not local1))
					(cond
						((not (IsFlag 20))
							(gMessager say: 4 3 8 1 self) ; "(THREATENING) Halt <growl>! No strangers may enter the Castle of the Crown!"
						)
						(
							(or
								(and (== gAct 1) (IsFlag 72))
								(> gAct 1)
							)
							(gMessager say: 4 3 17 1 self) ; "(THREATENING) We are under orders not to let you anywhere NEAR the castle, Prince Alexander! Begone!"
						)
						(else
							(gMessager say: 4 3 18 1 self) ; "(THREATENING) We said you will not be getting inside! Step away!"
						)
					)
				else
					(self cue:)
				)
				(= local1 0)
			)
			(3
				(if (== (guard1 cel:) 0)
					(guard1 loop: 0)
					(guard2 loop: 1)
					(= local0 0)
					(SetFlag 162)
				else
					(= local0 1)
					(ClearFlag 162)
				)
				(guard1 stopUpd:)
				(guard2 stopUpd:)
				(if register
					(gTheDoits
						add: (CueObj client: guard1 state: 1 cue: yourself:)
					)
				)
				(= cycles 2)
			)
			(4
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance wearClothingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(guardHut approachX:)
						(guardHut approachY:)
						self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 2 45 0 1 self) ; "Taking his cue from the serving women he's seen enter the castle, Alexander decides to try a few 'alterations' to make himself more acceptable to the guards. He ducks into the little hut to put on Beauty's clothes."
			)
			(3
				(gEgo
					setSpeed: 6
					normal: 0
					view: 221
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= cycles 1)
			)
			(5
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(= cycles 1)
			)
			(7
				(gEgo view: 733 normal: 1 setCycle: Walk)
				(= cycles 2)
			)
			(8
				(SetFlag 59)
				(gMessager say: 2 45 0 2 self) ; "Feeling a little foolish, Alexander slips Beauty's old slave clothes on over his own. Imagine if Cassima saw him like this!"
			)
			(9
				(gEgo setMotion: MoveTo 277 181 self)
			)
			(10
				(= cycles 2)
			)
			(11
				(KQ6Print
					font: gUserFont
					posn: 195 65
					width: 100
					say: 0 2 45 0 3 ; "(NERVOUSLY. TO HIMSELF) Well, <sigh> here we go."
					init: self
				)
			)
			(12
				(gEgo setMotion: PolyPath 125 118 self)
			)
			(13
				(gEgo setHeading: 0 self)
			)
			(14
				(= ticks 45)
			)
			(15
				(self setScript: secondGuardDoorScr self)
			)
			(16
				(gMessager say: 2 45 0 4 self) ; "You there! Girl! You're late! Get a move on before the vizier sees you!"
			)
			(17
				(KQ6Print font: gUserFont posn: -1 20 say: 0 2 45 0 5 init: self) ; "YES <a-hem> yes, sir."
			)
			(18
				(gGame givePoints: 4)
				(gEgo ignoreActors: 1 setMotion: DPath 125 110 107 93 self)
			)
			(19
				(gEgo
					setPri: 2
					setScale: Scaler 64 94 103 95
					moveSpeed: 8
					setMotion: MoveTo 75 100 self
				)
			)
			(20
				(gEgo hide:)
				(secondGuardDoorScr cue:)
			)
			(21
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance secondGuardDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard2
					view: 725
					posn: 139 108
					setLoop: Grooper
					loop: 1
					setCycle: Walk
					setMotion: DPath 120 108 108 97 self
				)
			)
			(1
				(castleDoor setCycle: End self)
				(gGlobalSound4 number: 222 loop: 1 play:)
			)
			(2
				(guard2 setMotion: MoveTo 129 96 self)
			)
			(3
				(guard2 setHeading: 270 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(guard2 stopUpd:)
				(client cue:)
			)
			(6
				(guard2 startUpd: setMotion: MoveTo 108 97 self)
			)
			(7
				(guard2 setHeading: 0 self)
			)
			(8
				(= cycles 2)
			)
			(9
				(castleDoor setCycle: Beg self)
			)
			(10
				(gGlobalSound4 number: 223 loop: 1 play:)
				(guard2 setMotion: DPath 120 108 139 109 self)
			)
			(11
				(guard2 setHeading: 270 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(guard2 view: 224 setLoop: -1 loop: 1 cel: 0 posn: 139 109)
				(= cycles 2)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance guardHutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(guardHut approachX:)
						(guardHut approachY:)
						self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(= ticks 45)
			)
			(4
				(gEgo setMotion: MoveTo 277 181 self)
			)
			(5
				(gMessager say: 6 5 0 0 self) ; "The little hut is empty."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance castleDoor of Prop
	(properties
		x 107
		y 94
		noun 4
		approachX 122
		approachY 115
		view 220
		priority 1
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not local3)
					(= local4 1)
					(= local3 1)
					(return)
				)
				(cond
					((not (IsFlag 20))
						(gMessager say: 4 3 8 1 self) ; "(THREATENING) Halt <growl>! No strangers may enter the Castle of the Crown!"
					)
					((or (and (== gAct 1) (IsFlag 72)) (> gAct 1))
						(gMessager say: 4 3 17 1 self) ; "(THREATENING) We are under orders not to let you anywhere NEAR the castle, Prince Alexander! Begone!"
					)
					(else
						(gMessager say: 4 3 18 1 self) ; "(THREATENING) We said you will not be getting inside! Step away!"
					)
				)
			)
			(2 ; Talk
				(gMessager say: noun theVerb) ; "It won't do any good to try to convince the door itself to allow Alexander to pass. It only does as it's told."
			)
			(35 ; skeletonKey
				(gMessager say: noun theVerb) ; "Alexander would never get close enough to that door to try the skeleton key on it."
			)
			(1 ; Look
				(if (== cel 0)
					(gMessager say: noun 1 6) ; "The castle doors are firmly shut and bolted."
				else
					(gMessager say: noun 1 7) ; "The castle doors are open."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(= local4 0)
		(if (self onMe: event)
			(if
				(or
					(and
						(== (gEgo x:) approachX)
						(== (gEgo y:) approachY)
					)
					(InRect 106 110 140 118 (gEgo x:) (gEgo y:))
				)
				(= local3 1)
			else
				(= local3 0)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 stopUpd:) ; Do
	)
)

(instance genericCoinShowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 64)
					(gEgo
						setSpeed: 6
						normal: 0
						view: 221
						loop: 0
						cel: 0
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(gMessager say: 5 40 register 1 self)
			)
			(2
				(if (IsFlag 64)
					(+= state 3)
					(self cue:)
				else
					(guardStanceScr register: 0)
					(= local1 1)
					(if (not (and (== (gEgo x:) 125) (== (gEgo y:) 118)))
						(gEgo setMotion: PolyPath 125 118 self)
					else
						(++ state)
						(self cue:)
					)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (== (gCurRoom script:) guardStanceScr)
					(-- state)
				)
				(= cycles 2)
			)
			(5
				(gEgo
					setSpeed: 6
					normal: 0
					view: 221
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(6
				(if (not (IsFlag 64))
					(gMessager say: 5 40 register 2 self)
				else
					(self cue:)
				)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(if (not (IsFlag 64))
					(gMessager say: 5 40 register 3 self)
				else
					(gMessager say: 5 40 register 2 self oneOnly: 0)
				)
			)
			(9
				(if (not (OneOf register 8 22))
					(self cue:)
				else
					(++ state)
					(backOffScr client: self cue:)
				)
			)
			(10
				(gEgo reset: 7)
				(= cycles 2)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance genericGiveAllScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					normal: 0
					view: 221
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= register 1)
				(gMessager
					say:
						5
						0
						(cond
							((or (IsFlag 72) (> gAct 1))
								(= register 0)
								17
							)
							((not (IsFlag 20)) 8)
							((and (== gAct 1) (IsFlag 20)) 18)
						)
						0
						self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if register
					(self cue:)
				else
					(++ state)
					(backOffScr client: self cue:)
				)
			)
			(4
				(gEgo reset: 7)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backOffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo reset: 7)
				(= cycles 2)
				(gTheDoits add: self)
			)
			(1
				(gEgo
					setCycle: Rev
					setLoop: 3
					setMotion: MoveTo 125 123 self
				)
			)
			(2
				(gEgo reset: 3)
				(= cycles 2)
			)
			(3
				(if (== (gCurRoom script:) guardStanceScr)
					((gCurRoom script:) caller: self)
				else
					(self cue:)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gTheDoits delete: self)
				(= state -1)
				(if (not (== client guard1))
					(client cue:)
					(= client guard1)
				else
					(gGame handsOn:)
				)
			)
		)
	)
)

(instance notAct1NotNameScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 72)
				(SetFlag 20)
				(gEgo setHeading: 0 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 5 register 12 1 self)
			)
			(3
				(if (== register 70)
					(gEgo
						normal: 0
						setSpeed: 6
						view: 221
						loop: 0
						cel: 0
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(roomConv add: -1 5 70 12 2 add: -1 5 70 12 3 init: self) ; "Good day, guard dogs. I am Prince Alexander of Daventry, and I would like....", "(TO THE OTHER GUARD - ALARMED) Prince Alexander of Daventry? He's the one, Woof!"
			)
			(6
				(if (== register 70)
					(gEgo setCycle: Beg self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo reset: 3)
				(= cycles 2)
			)
			(9
				(gMessager say: 5 70 12 4 self) ; "(TO ALEXANDER - THREATENING) See here, now! We've been warned about you! Vizier Alhazred has issued strict orders that you are not to be allowed anywhere NEAR the castle!"
			)
			(10
				(= cycles 2)
			)
			(11
				(roomConv add: -1 5 70 12 5 add: -1 5 70 12 6 init: self) ; "(CONFUSED) Me? But I haven't even met the vizier!", "(TO ALEXANDER - THREATENING) Never mind your excuses! You're on our list of 'undesirables,' and will not be getting into the castle--today, or any day. Now off with you!"
			)
			(12
				(= cycles 2)
			)
			(13
				(backOffScr client: self cue:)
			)
			(14
				(gMessager say: 5 70 12 7 self) ; "!!!Do not print this. Comment msg only."
			)
			(15
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance genericTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo loop:) 9) (!= (gEgo cel:) 3))
					(gEgo setHeading: 0 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (and (== register 10) local0)
					(gMessager say: 5 2 register 2 self oneOnly: 0)
				else
					(gMessager say: 5 2 register 0 self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class GateGuardDog of Actor
	(properties
		noun 5
		approachX 125
		approachY 118
		view 224
		signal 20481
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(self approachVerbs: 2) ; Talk
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (super onMe: param1))
		(if (== (param1 message:) 2)
			(= sightAngle 26505)
		else
			(= sightAngle 40)
		)
		(if temp0
			(= temp1 (gKq6ApproachCode doit: 0))
			(if
				(and
					(not (IsFlag 64))
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(OneOf
						(gTheIconBar curInvIcon:)
						(gInventory at: 39) ; royalRing
						(gInventory at: 9) ; coin
					)
				)
				(self _approachVerbs: (& (~ temp1) (self _approachVerbs:)))
			else
				(self _approachVerbs: (| (self _approachVerbs:) temp1))
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if
			(and
				(self onMe: event)
				(not local0)
				(not (== (event message:) JOY_RIGHT))
				(& _approachVerbs (gKq6ApproachCode doit: (event message:)))
			)
			(guardStanceScr register: 1)
			(CueObj client: 0)
		else
			(guardStanceScr register: 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gEgo setMotion: PolyPath gMouseX (- gMouseY 10))
			)
			(2 ; Talk
				(cond
					((not (IsFlag 64))
						(SetFlag 64)
						(self setScript: genericTalkScr 0 22)
					)
					(
						(or
							(and (== gAct 1) (IsFlag 72))
							(and (> gAct 1) (IsFlag 20))
						)
						(self setScript: genericTalkScr 0 17)
					)
					((and (== gAct 1) (SetFlag 19))
						(if ((ScriptID 10 0) isSet: 8192) ; rgCrown
							(self setScript: genericTalkScr 0 16)
						else
							((ScriptID 10 0) setIt: 8192) ; rgCrown
							(SetFlag 20)
							(self setScript: genericTalkScr 0 15)
						)
					)
					((== gAct 1)
						(self setScript: genericTalkScr 0 10)
					)
					(else
						(self setScript: notAct1NotNameScr 0 theVerb)
					)
				)
			)
			(70 ; royalRing
				(if (not (IsFlag 64))
					(gMessager say: noun theVerb 22) ; "Perhaps Alexander should learn a little more about where he is before offering his family heirloom to total strangers."
				else
					(cond
						(
							(or
								(IsFlag 72)
								(and (> gAct 1) (IsFlag 20))
							)
							(self setScript: genericGiveAllScr)
						)
						((and (== gAct 1) (IsFlag 20))
							(SetFlag 162)
							(self setScript: (ScriptID 222 0) 0 18) ; giveRingScr
						)
						((== gAct 1)
							(SetFlag 162)
							(self setScript: (ScriptID 222 0) 0 14) ; giveRingScr
						)
						(else
							(self setScript: notAct1NotNameScr 0 theVerb)
						)
					)
					(SetFlag 19)
					(SetFlag 20)
					((ScriptID 10 0) setIt: 8192) ; rgCrown
				)
			)
			(5 ; Do
				(gMessager say: noun theVerb) ; "The guards of the castle gate look like efficient fighters, and there are doubtless more of them inside. Alexander decides NOT to try to force his way in."
			)
			(1 ; Look
				(gMessager
					say:
						noun
						theVerb
						(cond
							((not (IsFlag 20)) 8)
							((and (== gAct 1) (IsFlag 72)) 17)
							((== gAct 1) 18)
							(else 17)
						)
				)
			)
			(40 ; coin
				(cond
					((not (IsFlag 64))
						(self setScript: genericCoinShowScr 0 22)
					)
					((not (IsFlag 20))
						(self setScript: genericCoinShowScr 0 8)
					)
					((or (and (== gAct 1) (IsFlag 72)) (> gAct 1))
						(self setScript: genericGiveAllScr)
					)
					((not (IsFlag 66))
						(self setScript: genericCoinShowScr 0 20)
						(SetFlag 66)
					)
					(else
						(gMessager say: noun theVerb 21) ; "The castle guards seemed unimpressed enough with Alexander's coin of Daventry the first time. Funny. Alexander always thought he was the spitting image of King Graham."
					)
				)
			)
			(else
				(self setScript: genericGiveAllScr)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gWalkHandler delete: self)
	)
)

(instance myHeadingCode of Code ; UNUSED
	(properties)

	(method (doit param1 param2)
		(if (and (== param2 CueObj) ((CueObj client:) isKindOf: GateGuardDog))
			(= param1 0)
		)
		(if argc
			(gEgo heading: param1)
		)
		(if (gEgo looper:)
			((gEgo looper:)
				doit: gEgo (gEgo heading:) (and (>= argc 2) param2)
			)
		else
			(DirLoop gEgo (gEgo heading:))
			(if (and (>= argc 2) (IsObject param2))
				(param2 cue: &rest)
			)
		)
		(return param1)
	)
)

(instance guard1 of GateGuardDog
	(properties
		x 100
		y 109
	)
)

(instance guard2 of GateGuardDog
	(properties
		x 139
		y 109
		sightAngle 180
		loop 1
	)
)

(instance saladin of Actor
	(properties
		x 75
		y 100
		view 736
		loop 2
		xStep 4
	)

	(method (cue param1)
		(if (not argc)
			(= param1 0)
		)
		(self
			setPri: 1
			setScale: Scaler 64 94 103 95
			moveSpeed: 8
			setMotion: MoveTo 75 100 param1
		)
	)

	(method (init)
		(super init: &rest)
		(self
			setScale: Scaler 64 94 103 95
			setPri: 1
			setLoop: Grooper
			setCycle: StopWalk -1
			ignoreActors:
		)
	)
)

(instance guardHut of Feature
	(properties
		x 280
		y 170
		noun 6
		sightAngle 40
		onMeCheck 16384
		approachX 279
		approachY 165
	)

	(method (doVerb theVerb)
		(switch theVerb
			(45 ; clothes
				(gCurRoom setScript: wearClothingScr)
			)
			(5 ; Do
				(gCurRoom setScript: guardHutScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance genericFeatures of Feature
	(properties
		sightAngle 40
	)

	(method (onMe param1)
		(genericFeatures x: (param1 x:) y: (param1 y:))
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(8192 8)
					(4096 11)
					(2048 9)
					(512 12)
					(else 0)
				)
			)
		)
	)
)

