;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n451)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm450 0
	oyster 1
	giveItemScript 2
	rightInvItem 3
	wrongInvItem 4
	toTheSea 5
	gnomeGroup 6
	snooze4 7
	proc450_8 8
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 param1)
	(tmpGnome
		view: (param1 view:)
		loop: (param1 loop:)
		cel: (param1 cel:)
		x: (param1 x:)
		y: (param1 y:)
		signal: (param1 signal:)
	)
	(if (gCast contains: tmpGnome)
		(tmpGnome show:)
	else
		(tmpGnome init:)
	)
)

(procedure (localproc_1 param1)
	(switch local5
		(1
			((ScriptID 455 0) doVerb: param1) ; smellGnome
		)
		(2
			((ScriptID 456 0) doVerb: param1) ; soundGnome
		)
		(3
			((ScriptID 4561 0) doVerb: param1) ; tasteGnome
		)
		(4
			((ScriptID 457 0) doVerb: param1) ; touchGnome
		)
		(5
			((ScriptID 458 0) doVerb: param1) ; sightGnome
		)
	)
)

(procedure (proc450_8 param1)
	(if param1
		(snoreSong stop:)
		(snooze1 view: 2002)
		(snooze2 view: 2002)
		(snooze3 view: 2002)
		(snooze4 view: 2002)
		(shimmer1 dispose:)
		(shimmer2 dispose:)
	else
		(snoreSong play:)
		(snooze1 view: 450 loop: 3)
		(snooze2 view: 450 loop: 3)
		(snooze3 view: 450 loop: 4)
		(if ((ScriptID 40 0) oysterDozing:) ; rWonder
			(snooze4 view: 450 loop: 5 init: setCycle: Fwd checkDetail:)
		)
		(shimmer1 init:)
		(shimmer2 init:)
	)
)

(instance rm450 of KQ6Room
	(properties
		picture 450
		horizon 70
		walkOffEdge 1
	)

	(method (cue)
		(if (gCast contains: mySentence)
			(mySentence
				y: (+ (mySentence y:) 100)
				z: 0
				setScript: sentenceFloat
			)
		)
	)

	(method (notify param1)
		(cond
			((or (not argc) (not param1)) 0)
			((not local5)
				(gCurRoom setScript: 130) ; pullOutMapScr
			)
			(else
				(if (gCurRoom script:)
					((ScriptID 130) next: resetGnomes) ; pullOutMapScr
				)
				(gCurRoom setScript: 130) ; pullOutMapScr
			)
		)
		(gEgo actions: egoDoVerb)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 130 72 193 0 319 0 319 78 213 78
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 125 72 115 80 115 92 79 97 89 111 75 128 94 141 94 150 58 150 24 189 0 189 0 0 64 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 235 147 233 140 246 124 319 124 319 189 286 189 286 153 299 147 279 144 256 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 125 137 94 137 90 134 93 131 124 131 129 134
					yourself:
				)
		)
		(gGame handsOff:)
		(super init: &rest)
		(oyster init:)
		(if
			(or
				(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
				((ScriptID 40 0) oysterDozing:) ; rWonder
			)
			(oyster setCel: 2)
			(snooze4 init: setCycle: Fwd)
		else
			(oyster setCel: 0)
			(oyBlink
				init:
				setPri: (oyster priority:)
				hide:
				setScript: oyBlinkScript
			)
		)
		(Lock rsMESSAGE 450 0)
		(gGlobalSound4 number: 916 setLoop: -1 play:)
		(gFeatures
			add:
				farFoliage
				rock
				oysterBeds
				otherRocks
				smallRocks
				sky
				beach
				myPath
				oysterCouch
				ocean
			eachElementDo: #init
		)
		(shimmer1 init:)
		(shimmer2 init:)
		(snoreSong play:)
		(snooze1 init: setCycle: Fwd)
		(snooze2 init: setCycle: Fwd)
		(snooze3 init: setCycle: Fwd)
		(if (== ((gInventory at: 50) owner:) gCurRoomNum) ; sentence
			(mySentence init: setCycle: Fwd setScript: sentenceFloat)
		)
		(gGlobalSound number: 915 setLoop: -1 play:)
		(gEgo setScale: Scaler 100 30 126 70 actions: egoDoVerb)
		(if (OneOf gPrevRoomNum 470 460)
			(gCurRoom setScript: egoEnters)
		)
	)

	(method (dispose)
		(ClearFlag 59)
		(LoadMany 0 455 456 4561 457 458)
		(if (!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
			((ScriptID 40 0) oysterDozing: 0) ; rWonder
		)
		((ScriptID 40 0) setScript: 0) ; rWonder
		(if (gCast contains: mySentence)
			(mySentence setMotion: 0)
		)
		(gGlobalSound4 fade: 0 10 10)
		(super dispose:)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			(
				(and
					(!= (gEgo view:) 900)
					(or
						(== (gEgo onControl: 1) 32)
						(== (gEgo onControl: 1) 64)
					)
				)
				(if
					(and
						(gCast contains: mySentence)
						(> (mySentence y:) 158)
						(sentencePoly points:)
					)
					((gCurRoom obstacles:) delete: sentencePoly)
					(sentencePoly dispose: points: 0)
					(mySentence setScript: sentenceFloat)
				)
				(gGlobalSound2 stop:)
				(gEgo view: 900)
			)
			((and (!= (gEgo view:) 308) (== (gEgo onControl: 1) 4))
				(if (gCast contains: mySentence)
					(mySentence setMotion: 0 setScript: 0)
				)
				(cond
					((!= (gEgo view:) 900) 0)
					((< (gEgo heading:) 135)
						(gEgo loop: 0)
					)
					((> (gEgo heading:) 225)
						(gEgo loop: 1)
					)
					(else
						(gEgo loop: 2)
					)
				)
				(gEgo view: 308)
				(gGlobalSound2 number: 922 setLoop: -1 play:)
			)
			((and (!= (gEgo view:) 3081) (== (gEgo onControl: 1) 2))
				(gEgo view: 3081)
			)
			(
				(and
					(not local2)
					(!= (gEgo view:) 3082)
					(== (gEgo onControl: 1) 8192)
				)
				(gEgo view: 3082)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(gCurRoom newRoom: 470)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gCurRoom setScript: egoExits)
			)
			(
				(and
					(OneOf (gEgo onControl: 1) 64 128)
					(not (IsFlag 42))
				)
				(SetFlag 81)
				(gGlobalSound2 number: 451 setLoop: -1 play:)
				(self setScript: mainGnomeScript)
			)
		)
		(super doit:)
	)

	(method (scriptCheck &tmp temp0)
		(= temp0 1)
		(if local5
			(gMessager say: 0 0 194 1 0 899) ; "This is no time for that! Alexander should concentrate on the matter at hand and tend to those funny-looking gnomes!"
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance snoreSong of Sound
	(properties
		number 962
		loop -1
	)
)

(instance oysterGuts of Prop
	(properties
		x 60
		y 132
		noun 1
		view 4531
		cel 1
		priority 11
		signal 16400
	)
)

(instance pearlGlint of Prop
	(properties
		x 72
		y 133
		view 902
		loop 1
		priority 13
		signal 16400
	)
)

(instance snooze1 of Prop
	(properties
		x 66
		y 113
		z 20
		noun 8
		view 450
		loop 3
		signal 20480
		detailLevel 3
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self cel: (- (self lastCel:) 1) stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)
)

(instance snooze2 of Prop
	(properties
		x 40
		y 127
		z 30
		noun 8
		view 450
		loop 3
		signal 20480
		detailLevel 3
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self cel: (- (self lastCel:) 1) stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)
)

(instance snooze3 of Prop
	(properties
		x 90
		y 131
		z 30
		noun 8
		view 450
		loop 4
		signal 20480
		detailLevel 3
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self cel: (- (self lastCel:) 1) stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)
)

(instance snooze4 of Prop
	(properties
		x 103
		y 158
		z 40
		noun 8
		view 450
		loop 5
		signal 20480
		detailLevel 3
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self cel: (- (self lastCel:) 1) stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)
)

(instance oyster of Prop
	(properties
		x 60
		y 132
		noun 1
		view 4531
		loop 2
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local5
						(gMessager say: 1 0 1 1) ; "Alexander can't do anything with the oyster now! The gnomes require all his attention!"
					)
					((!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
						(gMessager say: 1 1 7 1) ; "The little oyster is sleeping peacefully now that Alexander's removed the irritating pearl."
					)
					(((ScriptID 40 0) oysterDozing:) ; rWonder
						(gMessager say: 1 1 8 1) ; "The oyster with the mouthache seems to be resting rather uneasily."
					)
					(else
						(gCurRoom setScript: lookAtOyster)
					)
				)
			)
			(5 ; Do
				(cond
					(
						(or
							(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
							((ScriptID 40 0) oysterDozing:) ; rWonder
						)
						(gMessager say: 1 5 2 1) ; "Alexander doesn't want to wake up the sleeping oyster."
					)
					((IsFlag 107)
						(gMessager say: 1 5 3 0) ; "(CONCERNED) Why don't you let me see if I can help?"
					)
					(else
						(gMessager say: 1 5 4 0) ; "That oyster already looks a little perturbed and probably wouldn't appreciate being picked up by Alexander."
					)
				)
			)
			(2 ; Talk
				(if (gCast contains: gnomeGroup)
					(gMessager say: 1 0 1 1) ; "Alexander can't do anything with the oyster now! The gnomes require all his attention!"
				else
					(gEgo setScript: oysterMessages 0 2)
				)
			)
			(42 ; boringBook
				(if (gCast contains: gnomeGroup)
					(gMessager say: 1 0 1 1) ; "Alexander can't do anything with the oyster now! The gnomes require all his attention!"
				else
					(gEgo setScript: oysterMessages 0 42)
				)
			)
			(66 ; pearl
				(gMessager say: 1 66 0 1) ; "The oyster is sleeping peacefully without that pearl and would be unlikely to want it back!"
			)
			(30 ; feather
				(if
					(or
						(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
						((ScriptID 40 0) oysterDozing:) ; rWonder
					)
					(gMessager say: 1 30 2 1) ; "The oyster would not appreciate being tickled awake!"
				else
					(gMessager say: 1 30 9 1) ; "The little oyster looks far too grumpy to enjoy a good tickling."
				)
			)
			(31 ; flute
				(gGame handsOff:)
				(gCurRoom setScript: oyFluteScript)
			)
			(else
				(cond
					((gCast contains: gnomeGroup)
						(gMessager say: 1 0 1 1) ; "Alexander can't do anything with the oyster now! The gnomes require all his attention!"
					)
					(
						(or
							(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
							((ScriptID 40 0) oysterDozing:) ; rWonder
						)
						(gMessager say: 1 5 2 1) ; "Alexander doesn't want to wake up the sleeping oyster."
					)
					((IsFlag 107)
						(gMessager say: 1 0 3 1 self) ; "That won't do anything for the little oyster."
					)
					(else
						(gMessager say: 1 0 4 1 self) ; "Perhaps Alexander should find out more about the oyster first."
					)
				)
			)
		)
	)
)

(instance oyBlink of Prop
	(properties
		x 60
		y 132
		view 4531
		loop 1
		signal 16384
	)
)

(instance oyBlinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(client show:)
				(= cycles 6)
			)
			(2
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance oyFluteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 140 130 self)
			)
			(1
				(if
					(or
						(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
						((ScriptID 40 0) oysterDozing:) ; rWonder
					)
					(gMessager say: 1 31 2 1 self) ; "Alexander doesn't want to disturb the oyster now that he's finally asleep!"
				else
					(gMessager say: 1 31 9 0 self) ; "Should I play the flute for you?"
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtOyster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 1 9 1 self) ; "One of the oysters is sitting up in bed and doesn't look very happy. He seems to be the only one who can't sleep."
			)
			(1
				(gGlobalSound2 number: 961 setLoop: 1 play:)
				(oysterGuts init:)
				(oyster setPri: 12 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(pearlGlint init: setCycle: End self)
			)
			(3
				(pearlGlint dispose:)
				(oyster setCycle: Beg self)
			)
			(4
				(oysterGuts dispose:)
				(oyster setLoop: 2 cel: 0 setPri: 11)
				(= cycles 2)
			)
			(5
				(gMessager say: 1 1 9 2 self) ; "In the oyster's mouth Alexander can see a glint of white."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oysterMessages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 140 130 self)
			)
			(1
				(gEgo setHeading: 270)
				(= cycles 8)
			)
			(2
				(if
					(and
						(== register 2)
						(== ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
						(not (IsFlag 107))
					)
					(gMessager say: 1 2 10 1 self) ; "Why aren't you asleep like the other oysters?"
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(== register 2)
						(== ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
					)
					(oyster setPri: 12)
				)
				(= cycles 6)
			)
			(4
				(switch register
					(2
						(cond
							(
								(or
									(!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
									((ScriptID 40 0) oysterDozing:) ; rWonder
								)
								(gMessager say: 1 5 2 1 self) ; "Alexander doesn't want to wake up the sleeping oyster."
							)
							((IsFlag 107)
								(gMessager say: 1 2 11 0 self) ; "What's wrong with your mouth?"
							)
							(else
								(SetFlag 107)
								(gMessager say: 1 2 10 2 self) ; "I'm SO weary, but I can't sleep. I have a terrible ache in my mouth."
							)
						)
					)
					(42
						(cond
							((!= ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
								(gMessager say: 1 42 7 1 self) ; "The oyster is already asleep, and if Alexander reads anymore of THAT book HE will fall asleep."
							)
							((not (IsFlag 107))
								(gMessager say: 1 42 4 1 self) ; "Perhaps Alexander should find out more about the oyster first."
							)
							(((ScriptID 40 0) oysterDozing:) ; rWonder
								(gMessager say: 1 42 8 1 self) ; "The oyster is resting rather uneasily, and Alexander doesn't want to disturb him."
							)
							((IsFlag 108)
								(mySentence y: (- (mySentence y:) 100) z: -100)
								(oyBlink dispose:)
								(proc450_8 1)
								(proc451_0 1)
								(self dispose:)
							)
							(else
								(SetFlag 108)
								(gGame givePoints: 2)
								(mySentence y: (- (mySentence y:) 100) z: -100)
								(oyBlink dispose:)
								(proc450_8 1)
								(proc451_0 0)
								(self dispose:)
							)
						)
					)
				)
			)
			(5
				(gGame handsOn:)
				(if (== register 2)
					(oyster setPri: 11)
				)
				(self dispose:)
			)
		)
	)
)

(instance mySentence of Actor
	(properties
		x 160
		y 185
		noun 11
		view 4501
		priority 5
		signal 16
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(cond
			((or (== theVerb 1) (== theVerb 2)) ; Look, Talk
				(super doVerb: theVerb)
			)
			((== theVerb 5) ; Do
				(cond
					((gCast contains: gnomeGroup)
						(gMessager say: 1 0 1 1) ; "Alexander can't do anything with the oyster now! The gnomes require all his attention!"
					)
					((gCast contains: gEgo)
						(gGame handsOff:)
						(gEgo setScript: getSentence)
					)
					(else
						(gMessager say: 11 1 0 1) ; "A string of letters floats in the water. The letters spell out, "Where are you going....?" Alexander's heard of alphabet soup, but this is ridiculous!"
					)
				)
			)
			(else
				(gMessager say: 11 0 0 1) ; "Using that on the sentence in the water would be pointless."
			)
		)
	)
)

(instance shimmer1 of Prop
	(properties
		x 27
		y 169
		noun 7
		view 447
		priority 1
		signal 16400
		cycleSpeed 30
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance shimmer2 of Prop
	(properties
		x 299
		y 171
		noun 7
		view 447
		loop 1
		priority 1
		signal 16400
		cycleSpeed 30
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance farFoliage of Feature
	(properties
		noun 3
		onMeCheck 512
	)
)

(instance oysterBeds of Feature
	(properties
		noun 8
		onMeCheck 16
	)
)

(instance oysterCouch of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(oyster doVerb: theVerb &rest)
	)
)

(instance otherRocks of Feature
	(properties
		noun 6
		onMeCheck 256
	)
)

(instance smallRocks of Feature
	(properties
		noun 13
		onMeCheck 1024
	)
)

(instance sky of Feature
	(properties
		noun 10
		onMeCheck 2048
	)
)

(instance myPath of Feature
	(properties
		noun 9
		onMeCheck 4096
	)
)

(instance rock of Feature
	(properties
		noun 5
		onMeCheck 136
	)
)

(instance beach of Feature
	(properties
		noun 10
		onMeCheck 96
	)
)

(instance ocean of Feature
	(properties
		noun 7
		onMeCheck 8198
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (gUser curEvent:))
		(switch theVerb
			(3 ; Walk
				(if
					(and
						(or
							(== (gEgo onControl: 1) 32)
							(== (gEgo onControl: 1) 64)
						)
						(> (temp0 y:) 171)
					)
					(= local1 165)
					(if (< (temp0 x:) (gEgo x:))
						(= local0 (- (gEgo x:) 30))
					else
						(= local0 (+ (gEgo x:) 30))
					)
				else
					(= local0 (temp0 x:))
					(= local1 (temp0 y:))
				)
				(gEgo setScript: inToWater 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Gnome of Actor
	(properties
		y 127
		z 1
		signal 16384
		xStep 6
		gnomesItem 0
		msgCase 0
		failCase 0
		textCase 0
		EOLx 0
		FOLx 0
		gnomeScript 0
		startPoint 0
	)
)

(instance gnomeGroup of Actor
	(properties
		x 130
		y 71
		noun 4
		yStep 1
		view 454
		signal 16384
		cycleSpeed 12
		illegalBits 0
	)

	(method (cue)
		(if (IsObject scaler)
			(scaler dispose:)
		)
		(= scaler 0)
		(super dispose:)
	)

	(method (dispose)
		(if (IsObject scaler)
			(scaler dispose:)
		)
		(= scaler 0)
		(super dispose:)
	)
)

(instance tmpGnome of Actor
	(properties)
)

(instance mainGnomeScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 10 3 19 1 self) ; "Alexander hears someone coming."
			)
			(1
				(gEgo setMotion: MoveTo 236 128 self)
			)
			(2
				(gEgo setHeading: 335)
				(= cycles 8)
			)
			(3
				(snoreSong stop:)
				(snooze1 dispose:)
				(snooze2 dispose:)
				(snooze3 dispose:)
				(if (gCast contains: snooze4)
					(snooze4 dispose:)
				)
				(gnomeGroup
					setScale: Scaler 100 30 126 70
					init:
					setCycle: Walk
					setMotion: MoveTo 96 126 self
				)
			)
			(4
				(gEgo setHeading: 270)
				(= cycles 8)
			)
			(5
				(gMessager say: 10 3 19 2 self) ; "Five fierce guards of the isle we be! 'Watch for a foreign man,' said he! With ears and nose, tongue, hands, and eyes. Its nature cannot be disguised. If man it be, then man it dies!"
			)
			(6
				(gnomeGroup
					setScale: 0
					view: 4541
					setLoop: 0
					cel: 0
					posn: 146 128
					setCycle: End self
				)
				(UnLoad 128 454)
			)
			(7
				(= local5 1)
				((ScriptID 455 0) init:) ; smellGnome
				(gnomeGroup
					view: 459
					loop: -1
					setLoop: 0
					x: 155
					y: 126
					stopUpd:
					setScript: riddleAlex 0 (ScriptID 455 0) ; smellGnome
				)
				(UnLoad 128 4541)
				(= cycles 2)
			)
			(8)
			(9
				(localproc_0 (ScriptID 455 0)) ; smellGnome
				((ScriptID 455 0) dispose:) ; smellGnome
				(= cycles 2)
			)
			(10
				(DisposeScript 455)
				(UnLoad 128 455)
				(= cycles 2)
			)
			(11
				(= local5 2)
				((ScriptID 456 0) init:) ; soundGnome
				(gnomeGroup
					view: 4591
					loop: -1
					setScript: riddleAlex 0 (ScriptID 456 0) ; soundGnome
				)
				(tmpGnome view: 2002 hide:)
				(UnLoad 128 459)
				(= cycles 2)
			)
			(12)
			(13
				(gEgo setMotion: MoveTo (- (gEgo x:) 6) (gEgo y:) self)
			)
			(14
				(= cycles 2)
			)
			(15
				(localproc_0 (ScriptID 456 0)) ; soundGnome
				((ScriptID 456 0) dispose:) ; soundGnome
				(= cycles 2)
			)
			(16
				(DisposeScript 456)
				(UnLoad 128 456)
				(= cycles 2)
			)
			(17
				(= local5 3)
				((ScriptID 4561 0) init:) ; tasteGnome
				(gnomeGroup
					view: 4592
					loop: -1
					setScript: riddleAlex 0 (ScriptID 4561 0) ; tasteGnome
				)
				(tmpGnome view: 2002 hide:)
				(UnLoad 128 4591)
				(= cycles 2)
			)
			(18)
			(19
				(gEgo setMotion: MoveTo (- (gEgo x:) 1) (gEgo y:) self)
			)
			(20
				(= cycles 2)
			)
			(21
				(localproc_0 (ScriptID 4561 0)) ; tasteGnome
				((ScriptID 4561 0) dispose:) ; tasteGnome
				(= cycles 2)
			)
			(22
				(DisposeScript 4561)
				(UnLoad 128 4561)
				(UnLoad 128 8933)
				(= cycles 2)
			)
			(23
				(= local5 4)
				((ScriptID 457 0) init:) ; touchGnome
				(gnomeGroup
					view: 4593
					loop: -1
					setScript: riddleAlex 0 (ScriptID 457 0) ; touchGnome
				)
				(tmpGnome view: 2002 hide:)
				(UnLoad 128 4592)
				(= cycles 2)
			)
			(24)
			(25
				(= cycles 4)
			)
			(26
				(localproc_0 (ScriptID 457 0)) ; touchGnome
				((ScriptID 457 0) dispose:) ; touchGnome
				(= cycles 2)
			)
			(27
				(DisposeScript 457)
				(UnLoad 128 457)
				(= cycles 2)
			)
			(28
				(= local5 5)
				((ScriptID 458 0) init:) ; sightGnome
				(gnomeGroup
					view: 4594
					loop: -1
					setScript: riddleAlex 0 (ScriptID 458 0) ; sightGnome
				)
				(tmpGnome view: 2002 hide:)
				(UnLoad 128 4593)
				(= cycles 2)
			)
			(29)
			(30
				(localproc_0 (ScriptID 458 0)) ; sightGnome
				((ScriptID 458 0) dispose:) ; sightGnome
				(= cycles 2)
			)
			(31
				(DisposeScript 458)
				(UnLoad 128 458)
				(= local5 0)
				(gnomeGroup
					view: 4544
					setLoop: 1
					cel: 0
					posn: 110 128
					setCycle: End self
				)
				(tmpGnome dispose:)
				(UnLoad 128 4593)
			)
			(32
				(gnomeGroup
					view: 4540
					setScale: Scaler 100 25 126 70
					setLoop: 2
					x: 106
					y: 126
					setCycle: Walk
					setMotion: MoveTo 131 70 self
				)
				(UnLoad 128 4544)
			)
			(33
				(gnomeGroup dispose:)
				(gEgo
					view: 452
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				((ScriptID 40 0) alexInvisible: 0) ; rWonder
			)
			(34
				(if ((ScriptID 40 0) alexX:) ; rWonder
					(= temp0 ((ScriptID 40 0) alexX:)) ; rWonder
					(= temp1 ((ScriptID 40 0) alexY:)) ; rWonder
				else
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
				)
				(gEgo
					posn: temp0 temp1
					setScale: Scaler 100 30 126 70
					reset: 1
				)
				(= ticks 4)
			)
			(35
				(gGame handsOn:)
				(snoreSong play:)
				(snooze1 init: setCycle: Fwd checkDetail:)
				(snooze2 init: setCycle: Fwd checkDetail:)
				(snooze3 init: setCycle: Fwd checkDetail:)
				(if ((ScriptID 40 0) oysterDozing:) ; rWonder
					(snooze4 init: setCycle: Fwd checkDetail:)
				)
				(NextAct)
				(SetFlag 42)
				(gMessager say: 2 83 14 3) ; "Alexander did it! He's fooled the guards!"
				(self dispose:)
				(gGlobalSound2 fade: 0 10 10)
				(DisposeScript 1037)
			)
		)
	)
)

(instance riddleAlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gnomeGroup
					setLoop: (+ (gnomeGroup loop:) 1)
					x: (register FOLx:)
					cel: 0
				)
				(= cycles 4)
			)
			(1
				(gnomeGroup stopUpd:)
			)
			(2
				(gGlobalSound2 number: 452 setLoop: 1 play:)
				(register setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3)
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270)
				)
				(= seconds 12)
			)
			(4
				(if (!= (gCurRoom script:) mainGnomeScript)
					0
				else
					(gGame handsOff:)
					(SetFlag 59)
					(= cycles 6)
				)
			)
			(5
				((register gnomeScript:) start: (register startPoint:))
				(gnomeGroup setScript: (register gnomeScript:))
			)
		)
	)
)

(instance giveItemScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				((ScriptID 40 0) alexX: (gEgo x:)) ; rWonder
				((ScriptID 40 0) alexY: (gEgo y:)) ; rWonder
				(switch register
					(37
						(self setScript: giveGnomeBird self register)
					)
					(83
						(self setScript: inkOutAlex self register)
					)
					(31
						(self setScript: blowFlute self register)
					)
					(else
						(switch register
							(47
								(= temp0 452)
								(= temp1 0)
								(+= temp2 2)
								(= temp4 4)
							)
							(68
								(= temp4 4)
								(= temp0 452)
								(= temp1 4)
							)
							(else
								(= temp0 452)
								(= temp1 3)
								(= temp4 4)
							)
						)
						(gEgo
							view: temp0
							setLoop: temp1
							normal: 0
							cel: 0
							x: temp2
							y: temp3
							cycleSpeed: 0
							setCycle: CT temp4 1 self
						)
						(UnLoad 128 900)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance rightInvItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local5
					(1
						(if (not (SetFlag 145))
							(gGame givePoints: 2)
						)
						(UnLoad 128 8931)
					)
					(2
						(if (not (SetFlag 146))
							(gGame givePoints: 2)
						)
						(UnLoad 128 8932)
					)
					(3
						(if (not (SetFlag 147))
							(gGame givePoints: 2)
						)
						(UnLoad 128 8933)
					)
					(4
						(if (not (SetFlag 148))
							(gGame givePoints: 2)
						)
						(UnLoad 128 8934)
					)
					(5
						(if (not (SetFlag 149))
							(gGame givePoints: 2)
						)
						(UnLoad 128 8935)
					)
				)
				(gGlobalSound2 number: 451 setLoop: -1 play:)
				(register
					setLoop: 0
					cel: 3
					z: 0
					setPri: 8
					setMotion: MoveTo (register x:) (- (register y:) 4) self
				)
			)
			(1
				(register
					cel: 0
					setLoop: 5
					y: 125
					setCycle: Fwd
					setMotion: MoveTo (register EOLx:) 125 self
				)
			)
			(2
				(register loop: 0 cel: 2 setCycle: 0)
				(gnomeGroup setCycle: End self)
			)
			(3
				(register y: 126 cel: 0)
				(= ticks 4)
			)
			(4
				(mainGnomeScript cue:)
				(self dispose:)
			)
		)
	)
)

(instance wrongInvItem of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if ((ScriptID 40 0) alexInvisible:) ; rWonder
					(gEgo view: 452 setLoop: 1 cel: 0 setCycle: End self)
					((ScriptID 40 0) alexInvisible: 0) ; rWonder
				else
					(self cue:)
				)
			)
			(1
				(if ((ScriptID 40 0) alexX:) ; rWonder
					(= temp0 ((ScriptID 40 0) alexX:)) ; rWonder
					(= temp1 ((ScriptID 40 0) alexY:)) ; rWonder
				else
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
				)
				(if (!= (gEgo view:) 900)
					(gEgo reset: 1 posn: temp0 temp1)
				)
				(= cycles 8)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance toTheSea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 59)
				(gCurRoom drawPic: 450 -32758)
				(if (gCast contains: mySentence)
					(mySentence setCycle: 0 setMotion: 0 setScript: 0)
				)
				(gEgo hide:)
				(gGlobalSound2 number: 457 setLoop: 1 play: self)
				(gnomeGroup
					view: 4542
					setLoop: 0
					cel: 0
					posn: 200 138
					init:
					setCycle: Fwd
				)
			)
			(1
				(gGlobalSound3 number: 458 setLoop: 1 play:)
				(gnomeGroup setLoop: 1)
				(gEgo
					view: 4542
					setLoop: 2
					setPri: 15
					posn: 195 110
					normal: 0
					show:
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gCurRoom style: 7)
				(switch local5
					(1
						(DisposeScript 455)
					)
					(2
						(DisposeScript 456)
					)
					(3
						(DisposeScript 4561)
					)
					(4
						(DisposeScript 457)
					)
					(5
						(DisposeScript 458)
					)
				)
				(= global160 35)
				(= cycles 10)
			)
			(3
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance giveGnomeBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 883
					normal: 0
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 1)
					loop: 0
					cycleSpeed: 50
				)
				(UnLoad 128 900)
				(= cycles 6)
			)
			(1
				(gGlobalSound3 number: 930 setLoop: 1 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(2
				(if (< local4 4)
					(++ local4)
					(-= state 2)
				)
				(self cue:)
			)
			(3
				(gGlobalSound3 number: 931 setLoop: 1 play: self)
				(UnLoad 132 930)
				(gEgo setLoop: 6 cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(if (== local5 2)
					((ScriptID 456 0) setLoop: 1 setCycle: Fwd) ; soundGnome
				)
			)
			(4
				(gEgo view: 883 normal: 0 setCycle: 0 loop: 0)
				(= cycles 6)
			)
			(5
				(gGlobalSound3 number: 0)
				(UnLoad 132 931)
				(self dispose:)
			)
		)
	)
)

(instance inkOutAlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 83 14 1 self) ; "Alexander pours the contents of the empty-looking ink bottle over himself."
			)
			(1
				(gEgo
					normal: 0
					view: 452
					setLoop: 5
					cel: 0
					normal: 0
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 1)
					cycleSpeed: 2
					setCycle: End self
				)
				(UnLoad 128 900)
			)
			(2
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gEgo put: 51 450) ; ink
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				((ScriptID 40 0) alexInvisible: 1) ; rWonder
				(self dispose:)
			)
		)
	)
)

(instance blowFlute of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 920
					setLoop: 1
					posn: (gEgo x:) (+ (gEgo y:) 1)
					cel: 0
					cycleSpeed: 6
				)
				(UnLoad 128 900)
				(= cycles 4)
			)
			(1
				(gGlobalSound3 number: 942 setLoop: 1 play: self)
				(gEgo setCycle: Fwd)
			)
			(2
				(if ((ScriptID 40 0) alexX:) ; rWonder
					(= temp0 ((ScriptID 40 0) alexX:)) ; rWonder
					(= temp1 ((ScriptID 40 0) alexY:)) ; rWonder
				else
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
				)
				(gEgo reset: 1 posn: temp0 temp1)
				(= cycles 4)
			)
			(3
				(UnLoad 132 942)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: setScale: Scaler 100 30 126 70)
				(if (gEgo scaler:)
					((gEgo scaler:) doit:)
				)
				(switch gPrevRoomNum
					(460
						(gEgo posn: 345 90 setMotion: PolyPath 300 90 self)
					)
					(470
						(gEgo posn: 130 72 setMotion: PolyPath 134 101 self)
					)
					(else
						(gEgo
							signal: (| (gEgo signal:) $4000)
							posn: 228 121
							loop: 0
						)
						(= ticks 6)
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

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance inToWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (> (mySentence y:) 158) (not (sentencePoly points:)))
					(mySentence ignoreActors: 1)
					(gCurRoom
						addObstacle:
							(sentencePoly
								type: PBarredAccess
								init:
									(- (mySentence x:) 18)
									(mySentence y:)
									(- (mySentence x:) 10)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 17)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 24)
									(mySentence y:)
									(+ (mySentence x:) 18)
									(+ (mySentence y:) 17)
									(- (mySentence x:) 10)
									(+ (mySentence y:) 17)
								yourself:
							)
					)
					(= cycles 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(2
				(= cycles 4)
			)
			(3
				(cond
					((== register mySentence)
						(myConv add: -1 7 3 17 1 add: -1 7 3 17 2 init: self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs.", "Before Alexander can retreat, the currents grab his legs! The shifting sand vanishes from beneath his feet! Against his best efforts, he is dragged out to sea!"
					)
					(
						(or
							(== (gEgo onControl: 1) 4)
							(== (gEgo onControl: 1) 2)
						)
						(gMessager say: 7 3 16 1 self) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					)
					((== (gEgo onControl: 1) 8192)
						(myConv add: -1 7 3 17 1 add: -1 7 3 17 2 init: self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs.", "Before Alexander can retreat, the currents grab his legs! The shifting sand vanishes from beneath his feet! Against his best efforts, he is dragged out to sea!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(if
					(or
						(== (gEgo onControl: 1) 8192)
						(== register mySentence)
					)
					(= cycles 1)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(5
				(= local2 1)
				(gGlobalSound2 number: 921 setLoop: 1 play:)
				(gEgo
					view: 309
					cel: 0
					normal: 0
					cycleSpeed: 6
					posn: (gEgo x:) (+ (gEgo y:) 15)
					setCycle: End self
				)
			)
			(6
				(gGame handsOn:)
				(= global160 34)
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance sentencePoly of Polygon
	(properties)
)

(instance sentenceFloat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(mySentence setStep: 1 1 setLoop: 2)
				(cond
					((> (mySentence y:) 175)
						(mySentence setMotion: MoveTo 135 175 self)
					)
					((> (mySentence y:) 158)
						(mySentence setMotion: MoveTo 120 154 self)
					)
					(else
						(self dispose:)
					)
				)
			)
			(2
				(if (and (< (mySentence y:) 158) (not (sentencePoly points:)))
					(mySentence ignoreActors: 1)
					(gCurRoom
						addObstacle:
							(sentencePoly
								type: PBarredAccess
								init:
									(- (mySentence x:) 18)
									(mySentence y:)
									(- (mySentence x:) 10)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 17)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 24)
									(mySentence y:)
									(+ (mySentence x:) 18)
									(+ (mySentence y:) 17)
									(- (mySentence x:) 10)
									(+ (mySentence y:) 17)
								yourself:
							)
					)
				)
				(self init:)
			)
		)
	)
)

(instance getSentence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySentence setMotion: 0 setScript: 0)
				(if (and (> (mySentence y:) 158) (not (sentencePoly points:)))
					(mySentence ignoreActors: 1)
					(gCurRoom
						addObstacle:
							(sentencePoly
								type: PBarredAccess
								init:
									(- (mySentence x:) 18)
									(mySentence y:)
									(- (mySentence x:) 10)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 17)
									(- (mySentence y:) 5)
									(+ (mySentence x:) 24)
									(mySentence y:)
									(+ (mySentence x:) 18)
									(+ (mySentence y:) 17)
									(- (mySentence x:) 10)
									(+ (mySentence y:) 17)
								yourself:
							)
					)
				)
				(if
					(and
						(or
							(== (gEgo onControl: 1) 32)
							(== (gEgo onControl: 1) 64)
						)
						(> (mySentence y:) 158)
					)
					(= local3 1)
					(gMessager say: 11 5 20 1 self) ; "Alexander wades into the sea to get the strange object in the water."
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(mySentence x:)
						(- (mySentence y:) 11)
						self
				)
			)
			(2
				(gEgo setHeading: 180)
				(= cycles 8)
			)
			(3
				(cond
					((and local3 (> (mySentence y:) 158))
						(gMessager say: 11 5 20 2 self) ; "The ocean currents tug at Alexander's legs. Hmmm. That object is just a bit out of reach."
					)
					((> (mySentence y:) 158)
						(gMessager say: 11 5 21 1 self) ; "Alexander wades deeper into the sea to get the strange object in the water."
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(cond
					((and local3 (> (mySentence y:) 158))
						(= local3 0)
						(gGame handsOn:)
						(self dispose:)
					)
					((> (mySentence y:) 160)
						(= local0 (gEgo x:))
						(= local1 (+ (gEgo y:) 1))
						(self dispose:)
						(mySentence
							setStep: 20 15
							setLoop: 2
							setMotion:
								MoveTo
								(- (mySentence x:) 28)
								(mySentence y:)
						)
						(gCurRoom setScript: inToWater 0 mySentence)
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(gCurRoom setScript: pickUpSentence self)
				((gCurRoom obstacles:) delete: sentencePoly)
				(sentencePoly dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pickUpSentence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 311
					setLoop: 1
					normal: 0
					cel: 0
					setPri: (gEgo priority:)
					posn: (- (gEgo x:) 2) (+ (gEgo y:) 11)
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(mySentence dispose:)
				(gGlobalSound3 number: 924 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gGame givePoints: 1)
				(gEgo
					reset: 2
					posn: (+ (gEgo x:) 2) (- (gEgo y:) 11)
					get: 50 ; sentence
				)
				(= cycles 8)
			)
			(3
				(gMessager say: 11 5 0 0 self) ; "Alexander picks up the object floating in the water. It appears to be a string of letters. They say "Where are you going....?""
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance resetGnomes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local5
					(1
						(mainGnomeScript start: 8)
					)
					(2
						(mainGnomeScript start: 12)
					)
					(3
						(mainGnomeScript start: 18)
					)
					(4
						(mainGnomeScript start: 24)
					)
					(5
						(mainGnomeScript start: 29)
					)
				)
				(gCurRoom setScript: mainGnomeScript)
				((gnomeGroup script:)
					state: (- ((gnomeGroup script:) state:) 1)
					cue:
				)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; map
				(if
					(or
						(== (gEgo onControl: 1) 32)
						(== (gEgo onControl: 1) 64)
					)
					(if (gCurRoom script:)
						((ScriptID 130) next: resetGnomes) ; pullOutMapScr
					)
					(gCurRoom setScript: 130) ; pullOutMapScr
					(return 1)
				else
					(gCurRoom setScript: 130) ; pullOutMapScr
					(return 1)
				)
			)
			(31 ; flute
				(if local5
					(localproc_1 theVerb)
					(return 1)
				else
					(return 0)
				)
			)
			(37 ; nightingale
				(if local5
					(localproc_1 theVerb)
					(return 1)
				else
					(return 0)
				)
			)
			(83 ; ink
				(if local5
					(localproc_1 theVerb)
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

