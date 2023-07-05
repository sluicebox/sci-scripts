;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm780 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm780 of CastleRoom
	(properties
		noun 3
		picture 780
		style 10
		vanishingX 183
		vanishingY 98
	)

	(method (init)
		(LoadMany rsVIEW 7881 789 788)
		(gEgo init: posn: 20 157 setScale: Scaler 100 70 190 140)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -10 -10 329 -10 329 180 319 180 301 169 282 169 259 152 218 152 218 147 200 147 200 144 134 144 134 149 69 149 57 155 45 155 35 159 35 163 0 178 -10 178
					yourself:
				)
		)
		(gFeatures add: chandelierF rugF eachElementDo: #init)
		(super init: &rest)
		(if (!= ((gInventory at: 25) owner:) 750) ; newLamp
			(theClown init:)
		)
		(candles init:)
		(door init: stopUpd:)
		(doorJam1 addToPic:)
		(doorJam2 addToPic:)
		(fireplace addToPic:)
		(otherFireplace addToPic:)
		(bed addToPic:)
		(chair init:)
		(fire setCycle: Fwd init:)
		((gEgo scaler:) doit:)
		(self setScript: enterRoom)
		(if (IsFlag 10)
			(gGlobalSound fadeTo: 780 -1)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom newRoom: 840)
			)
		)
		(super doit: &rest)
	)

	(method (warnUser param1)
		(switch param1
			(1
				(= local3 1)
			)
		)
	)

	(method (dispose)
		(if local3
			((ScriptID 80 0) weddingRemind: 1) ; rgCastle
		)
		(if (not ((ScriptID 80 0) tstFlag: #rFlag2 512)) ; rgCastle
			((ScriptID 80 0) setFlag: #rFlag2 512) ; rgCastle
		)
		(super dispose:)
		(DisposeScript 964)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 10)
					(gEgo setMotion: MoveTo 44 157 self)
				else
					(gEgo setMotion: MoveTo 64 157 self)
				)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gGlobalSound4 number: 902 setLoop: 1 play:)
				(door stopUpd:)
				(= register 0)
				(if (gCast contains: (ScriptID 80 5)) ; guard1
					((ScriptID 81 0) resetGuard: (ScriptID 80 5) 1) ; RgBasement, guard1
					((ScriptID 80 5) dispose:) ; guard1
					(= register 1)
				)
				(if (gCast contains: (ScriptID 80 6)) ; guard2
					((ScriptID 81 0) resetGuard: (ScriptID 80 6) 2) ; RgBasement, guard2
					((ScriptID 80 6) dispose:) ; guard2
					(= register 1)
				)
				(if (not (and register (IsFlag 10)))
					(++ state)
				)
				(= cycles 2)
			)
			(3
				(gMessager say: 1 0 19 0 self) ; "Alexander hears the guard dog leave the basement. It seems he's safe for the moment."
			)
			(4
				(cond
					((not (IsFlag 10))
						(gCurRoom setScript: callGuards)
					)
					((not ((ScriptID 80 0) tstFlag: #rFlag2 512)) ; rgCastle
						(= local2 1)
						(self setScript: turnClownAround self)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(5
				(gEgo
					setMotion:
						PolyPath
						(theClown approachX:)
						(theClown approachY:)
						self
				)
			)
			(6
				(= cycles 10)
			)
			(7
				(if ((ScriptID 80 0) tstFlag: #rFlag2 256) ; rgCastle
					(if ((ScriptID 80 0) tstFlag: #rFlag3 32) ; rgCastle
						(roomConv add: -1 1 0 16) ; "You found my room! Good! You'll be safe here for a little while. I couldn't risk asking in the hall, but what are you doing here? The wedding is supposed to start any minute!"
					else
						(roomConv add: -1 1 0 9 1) ; "Prince Alexander! I can't believe you're here! The wedding is supposed to start any minute!"
					)
					(SetFlag 155)
					(roomConv
						add: -1 1 0 9 2 ; "I am well aware of that fact, Jollo. Confound it! I've seen Cassima. She does NOT want to marry him, Jollo!"
						add: -1 1 0 9 3 ; "Really? Oh, my friend, I'm so happy for that! Thank heaven she hasn't lost her senses and actually fallen for that black-hearted Alhazred! Did you say that she is well?"
						add: -1 1 0 9 4 ; "She is unharmed if that's what you mean--for the moment, at least. But I have a feeling she won't be fine at all if we can't stop the wedding."
						add: -1 1 0 9 5 ; "Stop the wedding? You'd never even make it to the ceremony, Alexander. The guard dogs are everywhere, and they're very loyal to the Crown. Unfortunately, right now, 'the Crown' means Alhazred."
						add: -1 1 0 9 6 ; "If we had proof of something truly afoul, the guard dogs might listen. As it is, they're your enemies, not his."
						add: -1 1 0 9 7 ; "(DRYLY, ALMOST BITTER) I understand. I've had no lack of 'enemies' since I got here. Still, I can hardly stand by and do nothing."
					)
					(if (IsFlag 52)
						(roomConv add: -1 1 0 4) ; "Not if the princess wishes her freedom, no. Let me know if there's any way I can help. For Cassima's sake, I wish you luck. I'll be here if there's anything you need."
					else
						(roomConv add: -1 1 0 10) ; "There's probably a good reason why so many wish to harm you. I believe the vizier's genie has learned of your presence on the islands."
					)
				else
					(if ((ScriptID 80 0) tstFlag: #rFlag3 32) ; rgCastle
						(roomConv add: -1 1 0 16) ; "You found my room! Good! You'll be safe here for a little while. I couldn't risk asking in the hall, but what are you doing here? The wedding is supposed to start any minute!"
					else
						(roomConv add: -1 1 0 8 1) ; "Prince Alexander! I can't believe it! How did you get into the castle?"
					)
					(roomConv
						add: -1 1 0 8 2 ; "Well, I.... Actually, it's a little hard to explain."
						add: -1 1 0 8 3 ; "I bet! You run a terrible risk being here! The castle is crawling with guard dogs--especially today! The vizier will have your hide if he finds you!"
						add: -1 1 0 8 4 ; "I know that, Jollo, but Cassima is being married today. What greater risk is there than that?"
						add: -1 1 0 8 5 ; "Of course, you're right. Young love--I forget what heartburn it is! But what do you propose to do about it?"
						add: -1 1 0 8 6 ; "I've GOT to try to see her, maybe even stop the wedding."
						add: -1 1 0 8 7 ; "Is that all? And here I thought you would try something dangerous <sigh>."
						add: -1 1 0 8 8 ; "Don't worry about me, friend. Just tell me; where is Cassima?"
						add: -1 1 0 8 9 ; "As far as I know, she's still in her bedroom upstairs. You'd never make it up there, though. The guard dogs are everywhere, and they're very loyal to the Crown. Unfortunately, right now 'the Crown' means Alhazred."
						add: -1 1 0 8 10 ; "If we had proof of something truly afoul, the guard dogs might listen. As it is, they're your enemies, not his."
						add: -1 1 0 8 11 ; "(DRYLY, ALMOST BITTER) I understand. I've had no lack of 'enemies' since I got here. In fact, you'd almost think I wasn't welcome."
					)
					(if (IsFlag 52)
						(roomConv add: -1 1 0 2) ; "Hah! And they say princes have no sense of humor! Well, I can see there's no putting you off. For Cassima's sake, I wish you luck. I'll be here if there's anything you need."
					else
						(roomConv add: -1 1 0 10) ; "There's probably a good reason why so many wish to harm you. I believe the vizier's genie has learned of your presence on the islands."
					)
				)
				(roomConv init: self)
			)
			(8
				(chair priority: 1)
				(theClown priority: 0 loop: 2 cel: 2 setCycle: Beg self)
			)
			(9
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnClownAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theClown loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(chair priority: 0)
				(theClown priority: 1 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance callGuards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: callGuardsConvScr self)
			)
			(1
				(if (IsFlag 154)
					(roomConv add: -1 1 0 18 1 add: -1 1 0 18 2 init: self) ; "You, again? How did you get out of the dungeon?", "Uh.... Just lucky, I guess."
				else
					(roomConv add: -1 1 0 1 1 add: -1 1 0 1 2 init: self) ; "I've seen you around the village! What are you doing in my room?", "Uh.... Wrong room. Sorry."
				)
			)
			(2
				(self setScript: callGuardsConvScr self)
			)
			(3
				(if (IsFlag 154)
					(roomConv add: -1 1 0 18 3 init: self) ; "We'll see about that! GUARDS!! GUARDS!!"
				else
					(roomConv add: -1 1 0 1 3 init: self) ; "Not as sorry as you're going to be! GUARDS!! GUARDS!!"
				)
			)
			(4
				(self setScript: callGuardsConvScr self)
			)
			(5
				(if (IsFlag 154)
					(roomConv
						add: -1 1 0 18 4 ; "What is it, Jollo?"
						add: -1 1 0 18 5 ; "The intruder escaped from the dungeon! Grab him!"
						add: -1 1 0 18 6 ; "He won't get away again, Jollo, and that's a fact!"
						init: self
					)
				else
					(roomConv
						add: -1 1 0 1 4 ; "What is it, Jollo?"
						add: -1 1 0 1 5 ; "This man is an intruder! He's probably here to harm the princess!"
						add: -1 1 0 1 6 ; "Don't worry, we'll take care of him!"
						init: self
					)
				)
			)
			(6
				(SetFlag 154)
				(gCurRoom spotEgo: (ScriptID 80 5)) ; guard1
			)
		)
	)
)

(instance callGuardsConvScr of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chair hide:)
				(theClown
					view: 7881
					loop: 0
					cel: 0
					posn: 242 154 0
					setCycle: End self
				)
			)
			(1
				(chair
					view: 7881
					loop: 3
					cel: 0
					posn: 266 149
					setPri: 14
					show:
					stopUpd:
				)
				(theClown loop: 1 cel: 0 posn: 227 152 0 setCycle: CT 4 1 self)
			)
			(2
				(self dispose:)
			)
			(3
				(theClown setCycle: End self)
			)
			(4
				(theClown loop: 2 cel: 6 posn: 221 151 setCycle: CT 3 -1 self)
			)
			(5
				(self dispose:)
			)
			(6
				(theClown loop: 2 cel: 3 setCycle: Beg self)
			)
			(7
				(= cycles 10)
			)
			(8
				(gGlobalSound4 number: 901 loop: 1 play:)
				(door setCycle: End self)
			)
			(9
				(gGlobalSound4 stop:)
				((ScriptID 80 5) ; guard1
					setScale:
					scaleX: 110
					scaleY: 110
					posn: 13 158
					init:
					setMotion: MoveTo 39 158 self
				)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance jolloScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theClown loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(theClown doVerb: register)
			)
			(2
				(chair priority: 1)
				(theClown
					loop: 2
					cel: 2
					priority: 0
					posn: 232 144
					setCycle: Beg self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					loop:
						(switch register
							(43 2)
							(57 1)
							(58 2)
							(59 0)
							(60 2)
							(96 1)
							(56 0)
						)
				)
				(gEgo
					normal: 0
					view: 789
					setScale:
					scaleX: 104
					scaleY: 104
					cel: 0
					cycleSpeed: 8
				)
				(= cycles (theClown cycleSpeed:))
			)
			(1
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 16)) ; rgCastle
					(chair priority: 0)
					(theClown loop: 5 cel: 0 posn: 225 142 priority: 1)
				)
				(= cycles (theClown cycleSpeed:))
			)
			(2
				(if ((ScriptID 80 0) tstFlag: #rFlag1 16) ; rgCastle
					(if (OneOf register 43 57)
						(roomConv add: -1 4 register 12)
					else
						(= cycles 1)
					)
				else
					((ScriptID 80 0) setFlag: #rFlag1 16) ; rgCastle
					(switch register
						(43
							(roomConv add: -1 4 register 11 0) ; "I've been thinking about what you said about swapping a replica for the genie's lamp.  Do you think this lamp would pass?"
						)
						(57
							(self setScript: gaveNewLamp self register)
						)
						(else
							(gGame givePoints: 3)
							(self setScript: gaveReplicaLamp self register)
						)
					)
				)
				(if (roomConv size:)
					(roomConv init: self)
				)
			)
			(3
				(gGame handsOn:)
				(gEgo
					reset: 0
					posn: (theClown approachX:) (theClown approachY:)
				)
				(self dispose:)
			)
		)
	)
)

(instance gaveNewLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 register 11 1 self)
			)
			(1
				(self setScript: badLampConvScr self)
			)
			(2
				(gMessager say: 4 register 11 2 self oneOnly: 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance gaveReplicaLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 register 11 1 self)
			)
			(1
				(self setScript: goodLampConvScr self)
			)
			(2
				(gMessager say: 4 register 11 2 self oneOnly: 0)
			)
			(3
				(self setScript: goodLampConvScr self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance goodLampConvScr of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 1 1 self)
			)
			(1
				(chair priority: 0)
				(theClown
					view: 788
					loop: 5
					cel: 0
					priority: 1
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 3)
				(theClown setCycle: CT 2 -1 self)
			)
			(3
				(gEgo setCycle: End)
				(theClown loop: 9 setCycle: End self)
			)
			(4
				(gEgo
					reset: 0
					posn: (theClown approachX:) (theClown approachY:)
				)
				(= seconds 3)
			)
			(5
				(theClown loop: 6 setCycle: CT 5 1 self)
			)
			(6
				(theClown loop: 5 cel: 0)
				(self dispose:)
			)
			(7
				(theClown
					view: 717
					setCycle: StopWalk -1
					posn: 218 151 0
					setPri: -1
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					cycleSpeed: 6
					moveSpeed: 6
					setStep: 5 3
					setMotion: DPath 205 157 42 158 self
				)
			)
			(8
				(gGlobalSound4 number: 901 loop: 1 play:)
				(door setCycle: End self)
			)
			(9
				(gGlobalSound4 stop:)
				(theClown setMotion: MoveTo 12 158 self)
			)
			(10
				(theClown hide:)
				(door setCycle: Beg self)
			)
			(11
				(gGlobalSound4 number: 902 loop: 1 play:)
				(theClown setScript: followTimer)
				(gGame handsOn:)
				(gEgo put: 25 750) ; newLamp
				(self dispose:)
			)
		)
	)
)

(instance followTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 0) setFlag: #rFlag3 32768) ; rgCastle
				(= seconds 11)
			)
			(1
				((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
				(theClown dispose:)
			)
		)
	)
)

(instance badLampConvScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 1 1 self)
			)
			(1
				(gEgo setCycle: Beg)
				(theClown view: 788 loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					reset: 0
					posn: (theClown approachX:) (theClown approachY:)
				)
				(theClown cel: 0)
				(= cycles (theClown cycleSpeed:))
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance lookThruKeyhole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 82 1) ; keyHoleView
					noun: 5
					actions: keyHoleActions
					init: 797 0 0 92 54
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 5 1 14) ; "Alexander peers through the keyhole of Jollo's door."
			)
		)
	)
)

(instance doorJam1 of View
	(properties
		x 35
		y 134
		noun 5
		sightAngle 40
		approachX 44
		approachY 157
		view 788
		loop 1
		cel 1
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb)
		(door noun: 5)
		(door doVerb: &rest)
	)
)

(instance doorJam2 of View
	(properties
		x 35
		y 134
		noun 5
		approachX 44
		approachY 157
		view 788
		loop 1
		cel 3
		priority 12
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb)
		(door noun: 5)
		(door doVerb: &rest)
	)
)

(instance door of Prop
	(properties
		x 28
		y 154
		z 20
		noun 5
		approachX 50
		approachY 157
		view 788
		cel 5
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(door setCycle: End self)
			)
			(1 ; Look
				(if (not local1)
					(++ local1)
					(|= _approachVerbs (gKq6ApproachCode doit: 1))
					(gMessager say: noun theVerb 13 0) ; "Jollo's door leads out into the basement hallway."
				else
					(gCurRoom setScript: (ScriptID 82) 0 lookThruKeyhole) ; keyHoleScr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGlobalSound4 stop:)
		(proc80_2 4)
	)
)

(instance bed of View
	(properties
		x 122
		y 135
		view 788
		loop 1
		signal 20496
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return
			(and
				(super onMe: temp0 temp1)
				(-= temp0 nsLeft)
				(-= temp1 nsTop)
				(or (and (> temp0 82) (= noun 12)) (= noun 7))
			)
		)
	)
)

(instance fireplace of View
	(properties
		x 252
		y 134
		view 788
		loop 1
		cel 2
		signal 20496
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return
			(and
				(super onMe: temp0 temp1)
				(-= temp0 nsLeft)
				(-= temp1 nsTop)
				(or
					(and
						(< temp0 61)
						(or
							(and (<= 14 temp0 35) (<= 2 temp1 27) (= noun 13))
							(and (<= 39 temp0 50) (<= 17 temp1 32) (= noun 14))
							(= noun 10)
						)
					)
					(= noun 9)
				)
			)
		)
	)
)

(instance theClown of Actor
	(properties
		x 232
		y 144
		z -10
		noun 4
		approachX 201
		approachY 151
		view 788
		loop 2
		signal 20496
		cycleSpeed 13
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 43 56 57 2) ; huntersLamp, fakeLamp5, fakeLamp6, Talk
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 5) ; Look, Do
				(super doVerb: theVerb &rest)
			)
			((and (not script) (not local2))
				(gGame handsOff:)
				(self setScript: jolloScr 0 theVerb)
			)
			((OneOf theVerb 43 56 57 58 59 60 96) ; huntersLamp, fakeLamp5, fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1
				(= theVerb (Max 43 (Min 57 theVerb)))
				(script setScript: showLamp jolloScr theVerb)
			)
			(
				(and
					((ScriptID 80 0) tstFlag: #rFlag2 256) ; rgCastle
					(not (IsFlag 155))
					(== theVerb 2) ; Talk
				)
				(SetFlag 155)
				(gMessager say: noun theVerb 15 0 jolloScr)
			)
			(else
				(if script
					(jolloScr cycles: 10)
				)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of View
	(properties
		x 226
		y 150
		noun 11
		view 788
		loop 7
		priority 1
		signal 20496
	)
)

(instance otherFireplace of View
	(properties
		x 294
		y 124
		view 788
		loop 1
		cel 4
		priority 12
		signal 16400
	)
)

(instance candles of Prop
	(properties
		x 165
		y 84
		noun 15
		view 788
		loop 8
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance chandelierF of Feature
	(properties
		noun 15
		onMeCheck 4
	)
)

(instance rugF of Feature
	(properties
		noun 8
		onMeCheck 2
	)
)

(instance fire of Prop
	(properties
		x 274
		y 140
		noun 9
		sightAngle 40
		view 788
		loop 10
		cycleSpeed 8
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance keyHoleActions of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 theVerb 14 2) ; "It looks like the hallway outside is clear. There are no guard dogs in sight."
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

