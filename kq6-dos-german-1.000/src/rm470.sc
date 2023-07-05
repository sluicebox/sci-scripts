;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	local0
	local1
	local2
	[local3 34] = [5 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	[local37 12]
	[local49 6]
	local55
	local56
	local57
	local58
	local59
	local60
	local61 = 3
	local62
	[local63 10]
	[local73 8] = [276 280 284 283 195 210 213 232]
	[local81 8] = [181 182 185 181 165 158 158 170]
	[local89 8] = [4701 4701 4701 4701 4701 4701 4701 4701]
	[local97 8] = [1 2 5 4 6 7 8 10]
	[local105 5]
	[local110 3] = [273 279 230]
	[local113 3] = [179 179 168]
	[local116 3] = [4703 4703 4703]
	[local119 3] = [0 2 9]
	[local122 4] = [135 177 146 136]
	[local126 4] = [169 179 184 157]
	[local130 5] = [57 30 149 103 220]
	[local135 5] = [147 165 156 135 163]
	local140
	local141
	local142
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		((= [local63 temp0] (aCat new:))
			view: [local89 temp0]
			loop: [local97 temp0]
			x: [local73 temp0]
			y: [local81 temp0]
			signal: 20480
			addToPic:
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		((= [local105 temp0] (aCat new:))
			view: [local116 temp0]
			loop: [local119 temp0]
			x: [local110 temp0]
			y: [local113 temp0]
			signal: 20480 9
			init:
			stopUpd:
		)
	)
)

(procedure (localproc_2 &tmp temp0) ; UNUSED
	(gGlobalSound2 number: 473 setLoop: -1 play:)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		([local105 temp0] setCycle: Fwd)
	)
)

(procedure (localproc_3 &tmp temp0) ; UNUSED
	(gGlobalSound2 stop:)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		([local105 temp0] setCycle: Beg)
	)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		([local105 temp0] stopUpd:)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance rm470 of KQ6Room
	(properties
		noun 3
		picture 470
		horizon 0
		walkOffEdge 1
	)

	(method (init)
		(if (and global100 (== gPrevRoomNum 99) (FileIO fiEXISTS {g})) ; speedRoom
			(gEgo get: 49 get: 46 get: 19 get: 11 get: 8) ; tomato, teaCup, huntersLamp, skull, dagger
		)
		(super init: &rest)
		(gGame handsOn:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 223 189 129 165 141 151 213 151 319 170 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 140 85 161 88 167 53 170 54 174 121 174 137 181 131 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 129 124 129 172 148 89 148 52 132 70 126 67 124 44 126 39 135 0 131 0 0 319 0
					yourself:
				)
		)
		(gGlobalSound number: 470 setLoop: -1 play:)
		(gFeatures
			add: swamp1 swamp2 farTrees pathage milkers dogTree log
			eachElementDo: #init
		)
		(localproc_0)
		(localproc_1)
		(bump init: stopUpd:)
		(cond
			((and (not (IsFlag 127)) (== ((gInventory at: 49) owner:) gCurRoomNum)) ; tomato
				(mater
					view: 475
					z: 60
					posn: 274 189
					setLoop: 5
					cel: 6
					setPri: 5
					init:
					stopUpd:
				)
				((= [local37 0] (slimeBall new:))
					x: 31
					y: 148
					setLoop: 0
					cel: 3
					setPri: 15
					init:
					addToPic:
				)
				((= [local37 1] (slimeBall new:))
					x: 32
					y: 154
					setLoop: 1
					cel: 3
					setPri: 15
					init:
					addToPic:
				)
				(= global150 5)
				(= global152 5)
				(stick init: cue: 1)
				(= local55 2)
			)
			((and (IsFlag 127) (== ((gInventory at: 49) owner:) gCurRoomNum)) ; tomato
				(= global150 5)
				(= global152 5)
				(stick init: cue: 1)
				(= local55 2)
			)
			((IsFlag 134)
				(stick init: cue: 0)
				(= local55 1)
			)
			(else
				(stick init: cue: 1)
				(= local55 0)
			)
		)
		(doggy init: stopUpd:)
		(gEgo init: scaleSignal: 4 scaleX: 128 scaleY: 128 maxScale: 128)
		(gCurRoom setScript: egoEnters)
	)

	(method (doit)
		(super doit:)
		(cond
			((gCurRoom script:))
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: walkOut 0 1)
			)
			((<= (gEgo x:) 8)
				(gCurRoom setScript: walkOut 0 0)
			)
			((== (gEgo onControl: 1) 2)
				(gCurRoom setScript: quagmire)
			)
			((and (gEgo inRect: 104 142 190 167) (not local2))
				(= local2 1)
				(Load rsVIEW 4731)
				(Load rsMESSAGE 470)
			)
			((and (== local0 5) (== local1 5))
				(= local0 6)
				(= local1 6)
				(gGame handsOff:)
				((= local140 (Prop new:)) view: 476 init: setScript: stepOnFrog)
			)
		)
		(Palette palANIMATE 64 68 -10)
	)

	(method (dispose)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance log of Feature
	(properties
		x 30
		y 165
		noun 14
		onMeCheck 128
	)
)

(instance farTrees of Feature
	(properties
		x 168
		y 10
		noun 12
		onMeCheck 8
	)
)

(instance pathage of Feature
	(properties
		noun 13
		onMeCheck 64
	)
)

(instance dogTree of Feature
	(properties
		x 40
		y 17
		noun 5
		onMeCheck 16
		approachX 80
		approachY 146
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(++ local0)
				(gMessager say: 5 1 0 1) ; "A large tree stretches knotted limbs out over the swamp. Part of the tree's trunk is shaped like the face of a dog. Why, it must be a dogwood tree!"
			)
			(0
				(gMessager say: 5 0 0 1) ; "What would a dogwood tree do with that?"
			)
			(2 ; Talk
				(gCurRoom setScript: bowWow 0 theVerb)
			)
			(5 ; Do
				(gCurRoom setScript: bowWow 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swamp1 of Feature
	(properties
		x 180
		y 10
		noun 6
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(gMessager say: 6 44 10 1) ; "That part of the swamp is out of Alexander's reach."
			)
			(0
				(gMessager say: 6 0 0 1) ; "Why would Alexander want to throw that in the swamp?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swamp2 of Feature
	(properties
		x 180
		y 10
		noun 6
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(cond
					((IsFlag 68)
						(gMessager say: 6 44 12 1) ; "Alexander doesn't need any more swamp ooze."
					)
					((== local55 2)
						(gMessager say: 6 44 11) ; "Alexander already knows that's not swamp ooze."
					)
					((= local55 1)
						(gCurRoom setScript: teaParty)
					)
				)
			)
			(0
				(gMessager say: 6 0 0 1) ; "Why would Alexander want to throw that in the swamp?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance milkers of Feature
	(properties
		x 60
		y 120
		noun 9
		nsTop 96
		nsLeft 47
		nsBottom 117
		nsRight 89
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gEgo has: 22) ; milk
					(++ local1)
					(gMessager say: 9 5 20 1) ; "Alexander already has a bottle of milk. One is enough to carry around."
				else
					(gCurRoom setScript: getMilk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mater of Actor
	(properties
		noun 11
		view 475
		loop 6
		priority 15
		signal 16400
	)
)

(instance milkWeed of View ; UNUSED
	(properties
		x 9
		y 117
		noun 9
		view 4701
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gEgo has: 22) ; milk
					(gMessager say: 9 5 20 1) ; "Alexander already has a bottle of milk. One is enough to carry around."
				else
					(gMessager say: 9 5 19 1) ; "Alexander takes a bottle of milk from the milkweed bush."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bump of Prop
	(properties
		x 28
		y 178
		z 25
		noun 7
		approachX 88
		approachY 177
		approachDist 20
		view 4700
		loop 1
		signal 20480
	)

	(method (init)
		(self approachVerbs: 2 setPri: 15) ; Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(switch local55
					(0
						(gMessager say: 7 44 13 1) ; "Why would Alexander want to use the teacup on that bump on a log?"
					)
					(1
						(gMessager say: 7 44 14 1) ; "Bump-on-a-log can't help Alexander out with that teacup. It's his brother that has access to the ooze."
					)
					(else
						(gMessager say: 7 44 15 1) ; "Don't bother Bump with that teacup! He's sleeping!"
					)
				)
			)
			(1 ; Look
				(switch local55
					(0
						(gMessager say: 7 1 13 1) ; "The fallen log has a good-sized knot or bump."
					)
					(1
						(gMessager say: 7 1 14 1) ; "Bump-on-a-log is glaring angrily at his brother, Stick-in-the-mud."
					)
					(else
						(gMessager say: 7 1 15 1) ; "Bump-on-a-log, having reconciled (at least temporarily) with his brother, is enjoying a peaceful nap."
					)
				)
			)
			(5 ; Do
				(switch local55
					(0
						(gMessager say: 7 5 13 1) ; "That bump on the log does not look particularly interesting to Alexander."
					)
					(1
						(gMessager say: 7 5 14 1) ; "Bump and his log are too heavy for Alexander to carry. Besides, Bump-on-a-log is rather a homebody; the ultimate couch potato."
					)
					(else
						(gMessager say: 7 5 15 1) ; "There's no reason to disturb Bump-on-a-log's peaceful nap."
					)
				)
			)
			(2 ; Talk
				(cond
					((== local55 2)
						(gMessager say: 7 5 15 1) ; "There's no reason to disturb Bump-on-a-log's peaceful nap."
					)
					((== local55 0)
						(gMessager say: 7 2 13 1) ; "That bump on the log does not look particularly conversational to Alexander."
					)
					((== (++ global150) 1)
						(self setScript: fightTalk self)
					)
					((== global150 2)
						(gMessager say: 7 2 26 0 stick) ; "Is there anything I can do to make peace between you two? You are brothers, after all."
					)
					(else
						(gMessager say: 7 2 17 0 stick) ; "Is there anything I can do for you, Bump-on-a-log?"
					)
				)
			)
			(34 ; tomato
				(if ((ScriptID 40 0) stickTalk:) ; rWonder
					(= global152 3)
					(gEgo put: 49 bump) ; tomato
					(gCurRoom setScript: bumpMaterToss)
				else
					(gMessager say: 7 34 18 1) ; "What would that bump on the log want with a rotten tomato?"
				)
			)
			(34 ; tomato
				(if (== local55 1)
					(gMessager say: 7 8 14 1) ; "Alexander wouldn't mind giving Bump something to help straighten out his brother, but he doesn't want things to get violent!"
				else
					(gMessager say: 7 0 13 1) ; "Alexander sees no reason to use that on the bump on the log."
				)
			)
			(else
				(switch local55
					(0
						(gMessager say: 7 0 13 1) ; "Alexander sees no reason to use that on the bump on the log."
					)
					(1
						(gMessager say: 7 0 14 0) ; "Would you be interested in this, Bump-on-a-log?"
					)
					(else
						(gMessager say: 7 5 15 1) ; "There's no reason to disturb Bump-on-a-log's peaceful nap."
					)
				)
			)
		)
	)
)

(instance bumpArm of Prop
	(properties
		x 30
		y 150
		view 474
		loop 5
		priority 15
		signal 16400
	)
)

(instance stick of Prop
	(properties
		x 287
		y 189
		z 66
		noun 10
		approachDist 300
		view 4700
		loop 2
		priority 4
		signal 20496
		cycleSpeed 8
	)

	(method (init)
		(if
			(and
				((ScriptID 40 0) stickTalk:) ; rWonder
				(!= ((gInventory at: 49) owner:) gCurRoomNum) ; tomato
			)
			(self view: 475 setLoop: 1)
			(= local55 1)
		else
			(self cue:)
		)
		(super init:)
	)

	(method (cue param1)
		(self view: 4700 setLoop: 2 cel: param1 stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch local55
					(0
						(gMessager say: 10 5 13 1) ; "Alexander can't reach the stick in the swamp."
					)
					(1
						(gMessager say: 10 5 14 1) ; "Alexander can't reach the cranky stick-in-the-mud."
					)
					(else
						(gMessager say: 10 5 15 1) ; "The cranky stick-in-the-mud is sleeping now and waking him up would be rather pointless."
					)
				)
			)
			(1 ; Look
				(switch local55
					(0
						(gMessager say: 10 1 13 1) ; "A stick is stuck in the middle of the swamp."
					)
					(1
						(gMessager say: 10 1 14 1) ; "Stick-in-the-mud glares crankily at his brother, Bump-on-a-log."
					)
					(else
						(gMessager say: 10 1 15 1) ; "Stick-in-the-mud has gone into a delicious snooze."
					)
				)
			)
			(2 ; Talk
				(gCurRoom setScript: sTalkToStick)
			)
			(34 ; tomato
				(cond
					((== local55 0)
						(gMessager say: 10 0 13 1) ; "Why would Alexander want to throw that at the stick in the swamp?"
					)
					(local56
						(gEgo put: 49 470) ; tomato
						(gCurRoom setScript: egoMaterThrowAway)
					)
					(else
						(gCurRoom setScript: egoMaterToss)
					)
				)
			)
			(44 ; teaCup
				(switch local55
					(0
						(gMessager say: 10 44 13 1) ; "Why would Alexander want to use that teacup on the stick in the swamp?"
					)
					(1
						(gMessager say: 10 44 14 1) ; "If Alexander threw the teacup at Stick-in-the-mud, he'd probably never get it back. Stick doesn't seem too accommodating."
					)
					(else
						(gMessager say: 10 44 15 1) ; "Stick wasn't too helpful about that teacup while he was awake, and he certainly wouldn't be interested in it now that he's napping."
					)
				)
			)
			(else
				(switch local55
					(0
						(gMessager say: 10 0 13 1) ; "Why would Alexander want to throw that at the stick in the swamp?"
					)
					(1
						(gMessager say: 10 0 14 0) ; "Would you have any interest in this, Stick-in-the-mud?"
					)
					(else
						(gMessager say: 10 0 15 1) ; "The cranky stick-in-the-mud is sleeping now and waking him up would be rather pointless."
					)
				)
			)
		)
	)
)

(instance fightTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(myConv add: -1 7 2 16 1 add: -1 7 2 16 2 init: self) ; "Who are you?", "I'm Bump-on-a-log, and that's my brother, Stick-in-the-mud. We've had this thing about each other ever since our childhood. Mom always liked me best."
			)
			(2
				(gEgo cel: 2)
				(= cycles 2)
			)
			(3
				(gMessager say: 7 2 16 3 self) ; "SHE DID NOT! That is absolutely NOT TRUE!"
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 7 2 16 4 self) ; "(CONFIDENTIALLY, TO ALEXANDER) He's a bit lazy, you see. He's got the only swamp ooze in the swamp right next to him. But do you think he'd move a finger to help get you some? Hardly. He'd try to brain you with it, more likely. His temper's about the only thing that ever gets a workout--and that on yours truly."
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 7 2 16 5 self) ; "Oh, like YOU'VE moved at all in the last century! Like YOU'RE Mr. Physical Activity!"
			)
			(8
				(= cycles 2)
			)
			(9
				(gMessager say: 7 2 16 6 self) ; "<sniff> Just because I can't reach anything, he thinks he can throw gushy swamp matter at me and just say whatever he likes. If only I could turn the tables on that heckler, he might learn some respect. But, as you see, I am a mere bump-on-a-log and must be content with my lot."
			)
			(10
				(= cycles 2)
			)
			(11
				(gMessager say: 7 2 16 7 self) ; "Oh, SHUT UP! You couldn't hit the broad side of a barn even if you HAD something to throw! Just SHUT UP!"
			)
			(12
				(= cycles 2)
			)
			(13
				(gMessager say: 7 2 16 8 self) ; "(WHISPERS, TO ALEXANDER) You see how he is."
			)
			(14
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance stickTalking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myConv add: -1 10 2 22 1 add: -1 10 2 22 2 init: self) ; "(POLITE) Perhaps you could toss me some swamp ooze since you seem to be able to recognize it. I can only reach this bit by the path.", "(SMART ALECKY) Well, hoity-toity, look who's Mr. Want-so-much! You think I gotta job here passing around precious swamp matter? You should BE so lucky."
			)
			(1
				(gEgo cel: 2)
				(= cycles 2)
			)
			(2
				(gMessager say: 10 2 22 3 self) ; "(TO ALEXANDER) He's an utter waste of oxygen. I'd save my breath if I were you."
			)
			(3
				(gGame handsOn:)
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance slimeBall of Prop
	(properties
		noun 8
		approachX 87
		approachY 181
		approachDist 20
		view 4702
		loop 1
		signal 22544
	)

	(method (init)
		(self approachVerbs: 5 9) ; Do, ???
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(if (not (IsFlag 68))
					(gCurRoom setScript: getOoze)
				else
					(gMessager say: 6 44 12 1) ; "Alexander doesn't need any more swamp ooze."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aCat of Prop
	(properties
		noun 4
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: doPussy 0 2)
			)
			(5 ; Do
				(gCurRoom setScript: doPussy 0 5)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doggy of Prop
	(properties
		x 25
		y 19
		noun 5
		view 4700
		priority 1
		signal 16400
		cycleSpeed 1
	)
)

(instance slime of Actor
	(properties
		yStep 36
		view 474
		loop 4
		signal 16384
		xStep 68
	)
)

(instance materSlime of Actor
	(properties
		yStep 36
		view 475
		signal 20496
		xStep 68
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gPrevRoomNum
					(450
						(gEgo
							setLoop: 3
							posn: 162 249
							setMotion: MoveTo 165 185 self
						)
						(if (not (Random 0 1))
							((= local142 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogX)
							)
						)
					)
					(else
						(gEgo
							setLoop: 0
							posn: -10 135
							setMotion: MoveTo 10 139 self
						)
						(if (not (Random 0 1))
							((= local141 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogY)
							)
						)
						(if (not (Random 0 1))
							((= local142 (Prop new:))
								view: 476
								init:
								setScript: (Clone sFrogX)
							)
						)
					)
				)
			)
			(1
				(gGame handsOn:)
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: MoveTo (gEgo x:) 255 self)
				else
					(gEgo setMotion: MoveTo -25 (gEgo y:) self)
				)
			)
			(1
				(if register
					(gCurRoom newRoom: 450)
				else
					(gCurRoom newRoom: 480)
				)
			)
		)
	)
)

(instance getMilk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(stick stopUpd:)
				(bump stopUpd:)
				(gEgo setMotion: PolyPath 64 141 self)
			)
			(1
				(gEgo setHeading: 0)
				(UnLoad 128 474)
				(UnLoad 128 475)
				(= ticks 6)
			)
			(2
				(gEgo
					view: 472
					normal: 0
					loop: 1
					cel: 0
					posn: 64 141
					setCycle: End self
				)
			)
			(3
				(gMessager say: 9 5 19 1 self) ; "Alexander takes a bottle of milk from the milkweed bush."
			)
			(4
				(if (not (IsFlag 130))
					(SetFlag 130)
					(gGame givePoints: 1)
				)
				(gEgo
					reset: 6
					posn: 53 133
					get: 22 ; milk
					setMotion: PolyPath 79 145 self
				)
			)
			(5
				(gEgo setHeading: 335)
				(= cycles 8)
			)
			(6
				(self setScript: bowWow self 99)
			)
			(7
				(gMessager say: 9 5 19 2 self) ; "Apparently, the dogwood tree doesn't like Alexander standing that close!"
			)
			(8
				(gGame handsOn:)
				(gEgo reset: 3)
				(UnLoad 128 472)
				(self dispose:)
			)
		)
	)
)

(instance getOoze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(if (not (IsFlag 68))
					(SetFlag 68)
					(gGame givePoints: 1)
				)
				(gEgo
					view: 474
					setLoop: 10
					posn: 71 189
					cel: 0
					normal: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 8 44 0 1 self) ; "Alexander fills the teacup with the swamp ooze."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo posn: 87 181 reset: 1 setMotion: MoveTo 107 167 self)
			)
			(5
				(gGame handsOn:)
				(gEgo setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance doPussy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 5)
					(gMessager say: 4 5 0 1 self) ; "Alexander decides to pet the soft-looking cattails."
				else
					(gMessager say: 4 2 0 1 self) ; "Good day, thou most feline of fronds."
				)
			)
			(1
				(if (== register 5)
					(gEgo setMotion: PolyPath 205 186 self)
				else
					(self cue:)
				)
			)
			(2
				(if (== register 5)
					(gEgo setHeading: 135)
					(= ticks 6)
				else
					(self cue:)
				)
			)
			(3
				(gGlobalSound2 number: 473 setLoop: 1 play:)
				([local105 0] view: 4701 startUpd: setCycle: End self)
			)
			(4
				(gGlobalSound2 number: 473 setLoop: 1 play:)
				([local105 0] setCycle: Beg)
				([local105 1] view: 4701 startUpd: setCycle: End self)
			)
			(5
				(gGlobalSound2 number: 473 setLoop: 1 play:)
				([local105 1] setCycle: Beg)
				([local105 2] view: 4701 startUpd: setCycle: End self)
			)
			(6
				(if (< local62 3)
					(++ local62)
					([local105 2] setCycle: Beg)
					(-= state 4)
					(self cue:)
				else
					([local105 2] setCycle: Beg self)
				)
			)
			(7
				(localproc_4)
				(if (== register 5)
					(gEgo setHeading: 315)
				)
				(= cycles 10)
			)
			(8
				(if (== register 5)
					(self setScript: bowWow self 99)
				else
					(self cue:)
				)
			)
			(9
				(if (== register 5)
					(gMessager say: 4 5 0 2 self) ; "Zounds, what a racket! So much for stirring up those cattails!"
				else
					(self cue:)
				)
			)
			(10
				(gGame handsOn:)
				(= local62 0)
				(self dispose:)
			)
		)
	)
)

(instance teaParty of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 40 0) stickTalk: 1) ; rWonder
				(cond
					((>= local57 3)
						(gMessager say: 6 44 11 1) ; "Alexander already knows that's not swamp ooze."
						(self dispose:)
					)
					((IsFlag 68)
						(gMessager say: 6 44 12 1) ; "Alexander doesn't need any more swamp ooze."
						(self dispose:)
					)
					(else
						(gGame handsOff:)
						(= ticks 4)
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 132 155 self)
			)
			(2
				(gEgo
					view: 472
					setLoop: 0
					normal: 0
					cel: 0
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 4)
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(3
				(gGlobalSound2 number: 924 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo posn: (- (gEgo x:) 11) (- (gEgo y:) 8) reset: 4)
				(= ticks 4)
			)
			(5
				(gEgo
					setLoop: 4
					setMotion: MoveTo (- (gEgo x:) 6) (- (gEgo y:) 4)
				)
				(stick view: 475 setLoop: 1 setCycle: End self)
			)
			(6
				(stick setCycle: Beg self)
			)
			(7
				(if (== local57 0)
					(myConv
						add: -1 6 44 4 1 ; "(SCORNFULLY) What do you think YOU'RE doing?"
						add: -1 6 44 4 2 ; "(SURPRISED, NICE) You startled me! I was just getting some swamp ooze."
						add: -1 6 44 4 3 ; "Well, you certainly won't get it THERE!"
						init: self
					)
				else
					(self cue:)
				)
			)
			(8
				(switch (= temp0 (Random 0 2))
					(0
						(gMessager say: 6 44 8 1 self) ; "(DISDAINFUL) THAT'S not swamp ooze! That's swamp SLUDGE!"
					)
					(1
						(gMessager say: 6 44 9 1 self) ; "(DISDAINFUL) THAT'S not swamp ooze! That's swamp MUCK!"
					)
					(2
						(gMessager say: 6 44 7 1 self) ; "(DISDAINFUL) THAT'S not swamp ooze! That's swamp SLIME!"
					)
				)
			)
			(9
				(switch local57
					(0
						(self setScript: teaTalk self 1)
					)
					(1
						(self setScript: teaTalk self 2)
					)
					(2
						(self setScript: teaTalk self 3)
					)
				)
			)
			(10
				(++ local57)
				(gEgo reset:)
				(stick setLoop: 2 setCycle: Osc 1 self)
				(= cycles 1)
			)
			(11
				(gGlobalSound2 number: 478 setLoop: 1 play:)
			)
			(12
				(gGame handsOn:)
				(stick cue: 0)
				(SetFlag 134)
				(self dispose:)
			)
		)
	)
)

(instance teaTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(switch register
					(1
						(gMessager say: 6 44 4 4 self) ; "(TIMID) He's right, you know. But he COULD be a little nicer about telling you. He's not a very pleasant stick-in-the-mud."
					)
					(2
						(gMessager say: 6 44 5 1 self) ; "(MARTYRED)<sigh> It's true. He's right. Extremely irritating, but right."
					)
					(3
						(gMessager say: 6 44 28 1 self) ; "(MARTYRED)<sigh> You really won't make any progress that way. He'll hog that swamp ooze of his. You'll never see a bit of it."
					)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(switch register
					(1
						(gMessager say: 6 44 4 5 self) ; "(ANGRY) Nobody asked you! Be quiet!"
					)
					(2
						(gMessager say: 6 44 5 2 self) ; "(ANGRY) SHUT UP! SHUT UP! YOU WORTHLESS BUMP-ON-A-LOG!"
					)
					(3
						(gMessager say: 6 44 28 2 self) ; "(ANGRY) I'LL SHOW YOU A BIT OF IT! I'LL KNOCK YOUR HEAD OFF WITH IT IF YOU DON'T STOP YAPPING!"
					)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(switch register
					(1
						(gMessager say: 6 44 4 6 self) ; "(UNDER HIS BREATH)<sigh> Oh, the trials of being a mere bump-on-a-log."
					)
					(2
						(gMessager say: 6 44 5 3 self) ; "(DRAMATICALLY) Oh, the cross that I must bear! Would that I could but avenge this uncalled-for abuse!"
					)
					(3
						(gMessager say: 6 44 28 3 self) ; "(DRAMATICALLY) You see how he is."
					)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance backOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 186 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 2)
			)
			(2
				(gEgo view: 4702 setLoop: 2 normal: 0 setCycle: 0)
				(= cycles 2)
			)
			(3
				(Load rsVIEW 475)
				(self dispose:)
			)
		)
	)
)

(instance materTossSlime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UnLoad 128 474)
				(mater setLoop: 8 cel: 0 z: 0 posn: 275 129 setCycle: End self)
			)
			(1
				(mater cel: 0)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 476 setLoop: 1 play:)
				(materSlime
					view: 475
					posn: 217 111
					ignoreActors:
					init:
					setLoop: 10
					cel: 0
					setPri: 15
				)
				(= ticks 4)
			)
			(2
				(materSlime posn: 172 109 forceUpd:)
				(= ticks 2)
			)
			(3
				(materSlime
					view: 4702
					setLoop: 1
					cel: 0
					posn: 121 108
					forceUpd:
				)
				(= ticks 2)
			)
			(4
				(materSlime posn: 87 119 forceUpd:)
				(= ticks 2)
			)
			(5
				(materSlime cel: 0 posn: 87 119 forceUpd:)
				(= ticks 4)
			)
			(6
				((= [local49 local59] (slimeBall new:))
					x: 31
					y: 189
					z: 41
					setLoop: 0
					priority: 15
					init:
					setCycle: End self
				)
				(materSlime setCycle: 0 hide: dispose:)
			)
			(7
				([local49 local59] addToPic:)
				(if (< local59 2)
					(++ local59)
					(-= state 8)
				)
				(self cue:)
			)
			(8
				(mater
					view: 475
					setLoop: 5
					cel: 6
					x: 274
					y: 189
					z: 60
					setPri: 5
				)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterToss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 55 172 self)
			)
			(1
				(gEgo setHeading: 225)
				(= cycles 8)
			)
			(2
				(gMessager say: 10 34 24 0 self) ; "Perhaps I can help you out by throwing a rotten tomato at Stick-in-the-mud for you."
			)
			(3
				(gGame handsOn:)
				(= local56 1)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterThrowAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 127)
				(gMessager say: 10 34 25 1 self) ; "Alexander decides to throw Rotten Tomato at Stick-in-the-Mud himself."
			)
			(1
				(gEgo setMotion: PolyPath 108 149 self)
			)
			(2
				(gEgo view: 472 normal: 0 setLoop: 2 setCycle: End self)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 474 setLoop: 1 play:)
			)
			(3
				(gEgo posn: 108 149 reset: 0)
				(self setScript: egoMaterFlight self)
			)
			(4
				(= cycles 8)
			)
			(5
				(myConv
					add: -1 10 34 25 3 ; "Uh, oh."
					add: -1 10 34 25 4 ; "(SARCASTICALLY) Gee. GREAT arm ya got there."
					add: -1 10 34 25 5 ; "Yeah, great arm! You said it, Stick!"
					add: -1 10 34 25 6 ; "Gee, Bump, did we just agree on something?"
					add: -1 10 34 25 7 ; "Why...you're right, Stick, we did!"
					add: -1 10 34 25 8 ; "Gee! You know, he's even more worthless than you are, Bump! I'm sorry I'm so mean to you sometimes."
					add: -1 10 34 25 9 ; "You MEAN it? Brother!"
					add: -1 10 34 25 10 ; "Brother!"
					add: -1 10 34 25 11 ; "Stick-in-the-mud and Bump-on-a-log, having reconciled at Alexander's expense, fall into a lazy sleep. Unfortunately, Alexander never did get his ooze."
					init: self
				)
			)
			(6
				(gGame handsOn:)
				(= local55 2)
				(stick cue: 1)
				(= global152 2)
				(self dispose:)
			)
		)
	)
)

(instance egoMaterFlight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mater posn: (+ (gEgo x:) 36) (- (gEgo y:) 61) init:)
				(= ticks 4)
			)
			(1
				(mater posn: (+ (mater x:) 31) (- (mater y:) 10))
				(= ticks 4)
			)
			(2
				(mater posn: (+ (mater x:) 31) (+ (mater y:) 2))
				(= ticks 4)
			)
			(3
				(mater posn: (+ (mater x:) 28) (+ (mater y:) 10))
				(= ticks 4)
			)
			(4
				(mater posn: (+ (mater x:) 18) (+ (mater y:) 13))
				(= ticks 4)
			)
			(5
				(mater posn: (+ (mater x:) 6) (+ (mater y:) 16))
				(= ticks 4)
			)
			(6
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 475 setLoop: 1 play:)
				(mater posn: 266 131)
				(= ticks 12)
			)
			(7
				(mater setLoop: 5 posn: 274 130 cel: 0 setCycle: End self)
			)
			(8
				(mater setLoop: 6 posn: 266 131 startUpd: forceUpd:)
				(= cycles 4)
			)
			(9
				(gMessager say: 10 34 25 2 self) ; "Help! Help! I'm melting!"
			)
			(10
				(mater setLoop: 6 setMotion: MoveTo 270 140 self)
			)
			(11
				(mater setLoop: 9 posn: 279 139 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 477 setLoop: 1 play:)
			)
			(12
				(mater dispose:)
				(= ticks 4)
			)
			(13
				(gGlobalSound2 number: 0 stop:)
				(self dispose:)
			)
		)
	)
)

(instance bowWow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(2
						(gMessager say: 5 2 0 1 self) ; "My dear tree, is it true that your bark is worse than your bite?"
					)
					(5
						(gMessager say: 5 5 0 1 self) ; "Alexander considers climbing the tree...."
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(doggy setCycle: End self)
			)
			(2
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 472 setLoop: 1 play:)
				(= ticks 30)
			)
			(3
				(doggy setCel: 1)
				(if (-- local61)
					(-= state 3)
				else
					(doggy setCycle: Beg)
				)
				(= ticks 30)
			)
			(4
				(if (== register 5)
					(gMessager say: 5 5 0 2 self) ; "And quickly changes his mind!"
				else
					(self cue:)
				)
			)
			(5
				(gGame handsOn:)
				(doggy stopUpd:)
				(= local61 3)
				(self dispose:)
			)
		)
	)
)

(instance theBattle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local58)
				(stick view: 475 setLoop: 4 cel: 0 setCycle: End self)
			)
			(1
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 476 setLoop: 1 play:)
				(slime
					posn: (Random 248 252) (Random 88 92)
					ignoreActors:
					init:
					setLoop: 3
					cel: 0
					setPri: 15
					setCycle: Fwd
					setMotion: MoveTo (Random 180 185) (Random 60 65) self
				)
			)
			(2
				(slime setMotion: MoveTo (Random 115 122) (Random 75 82) self)
			)
			(3
				(slime
					cel: 1
					setMotion: MoveTo (Random 68 74) (Random 110 115) self
				)
			)
			(4
				(if (mod local58 2)
					(= temp0 0)
				else
					(= temp0 1)
				)
				((= [local37 local58] (slimeBall new:))
					view: 474
					x: (if temp0 31 else 32)
					y: 189
					z: (if temp0 41 else 35)
					setLoop: (if temp0 0 else 1)
					priority: 15
					init:
					setCycle: End self
				)
				(slime setCycle: 0 dispose:)
				(stick cel: 0)
			)
			(5
				(if (< local58 2)
					([local37 local58] ignoreActors: 1 addToPic:)
					(self changeState: 0)
				else
					(gGlobalSound2 stop:)
					(gEgo reset: 3)
					(stick cue: 0)
					(mater stopUpd:)
					(= local60 1)
					(= local55 2)
					(self dispose:)
				)
			)
		)
	)
)

(instance bumpMaterToss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 87 177 self)
			)
			(1
				(if (not (IsFlag 139))
					(SetFlag 139)
					(gGame givePoints: 3)
				)
				(gEgo
					view: 474
					setLoop: 4
					cel: 0
					posn: 70 185
					normal: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(bumpArm
					init:
					view: 474
					setLoop: 5
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(3
				(gEgo reset: 1)
				(bumpArm setCycle: End self)
			)
			(4
				(= cycles 2)
			)
			(5
				(myConv
					add: -1 7 34 14 1 ; "I thought this might come in handy the next time your brother starts picking on you."
					add: -1 7 34 14 2 ; "(TRIUMPHANT) Ah, ha! Finally, old Bump-on-the-log's not so defenseless, is he?"
					add: -1 7 34 14 3 ; "(PANICKED) Hey! Hey! Whaddya you doin' there? Watch the pulp, would ya?"
					add: -1 7 34 14 4 ; "(AFRAID) Now, Bumpie! Remember all I've given you!"
					add: -1 7 34 14 5 ; "The only thing you've ever given me is mud! Take this!"
					add: -1 7 34 14 6 ; "(SCREAMING) NO! NOT INTO THE SWAMP!"
					init: self
				)
			)
			(6
				(gEgo setScript: backOut self)
			)
			(7
				(self setScript: bumpMaterFlight self)
			)
			(8
				(mater setScript: materTossSlime self)
				(self setScript: theBattle self)
			)
			(9)
			(10
				(stick cue: 0)
				(UnLoad 128 474)
				(UnLoad 128 475)
				(myConv
					add: -1 7 34 14 7 ; "Okay! Okay! I give up! Geez, SORRY!"
					add: -1 7 34 14 8 ; "<sniff> Well, I guess it's not very pleasant having things thrown at you. I'm sorry."
					add: -1 7 34 14 9 ; "You mean it? Really? Brother!"
					add: -1 7 34 14 10 ; "Brother!"
					add: -1 7 34 14 11 ; "Stick-in-the-mud and Bump-on-a-log, exhausted from the battle, immediately doze off into naps. Rotten Tomato, being equally lazy, decides to join them."
					init: self
				)
			)
			(11
				((gInventory at: 49) owner: gCurRoomNum) ; tomato
				(gGlobalSound2 number: 961 setLoop: 1 play:)
				(mater init: view: 4700 setLoop: 1 cel: 2)
				(slimeBall addToPic:)
				(= ticks 120)
			)
			(12
				(gGame handsOn:)
				(mater cel: 1 forceUpd:)
				(stick cue: 1)
				(= global152 2)
				(self dispose:)
			)
		)
	)
)

(instance bumpMaterFlight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bump hide:)
				(bumpArm
					view: 4741
					init:
					posn: 29 154
					setLoop: 0
					cel: 0
					setPri: 15
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(bumpArm setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(bumpArm setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gGlobalSound2 number: 474 setLoop: 1 play:)
				(mater view: 475 loop: 6 posn: 61 145 init:)
				(bump show:)
				(bumpArm dispose:)
				(= ticks 4)
			)
			(5
				(mater posn: 85 118)
				(= ticks 4)
			)
			(6
				(mater posn: 121 97)
				(= ticks 4)
			)
			(7
				(mater posn: 153 82)
				(= ticks 4)
			)
			(8
				(mater posn: 193 78)
				(= ticks 4)
			)
			(9
				(mater posn: 230 83)
				(= ticks 4)
			)
			(10
				(mater posn: 260 90)
				(= ticks 4)
			)
			(11
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 475 setLoop: 1 play:)
				(stick view: 475 setLoop: 11 cel: 0 setCycle: Fwd)
				(mater posn: 280 97)
				(= ticks 4)
			)
			(12
				(mater posn: 270 108)
				(= ticks 4)
			)
			(13
				(mater posn: 263 131)
				(= ticks 4)
			)
			(14
				(stick view: 475 setLoop: 1 cel: 0 stopUpd:)
				(mater setLoop: 5 posn: 274 129 setCycle: End self)
			)
			(15
				(mater
					view: 475
					setLoop: 5
					cel: 6
					x: 274
					y: 189
					z: 60
					setPri: 5
				)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToStick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 121) (!= (gEgo y:) 147))
					(gEgo setMotion: PolyPath 121 147 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= register (GetAngle (gEgo x:) (gEgo y:) 292 135))
				(= cycles 2)
			)
			(2
				(if (!= (gEgo heading:) register)
					(Face gEgo 292 135 self)
				else
					(= cycles 2)
				)
			)
			(3
				(= cycles 4)
			)
			(4
				(++ global152)
				(cond
					((== local55 0)
						(-- global152)
						(gMessager say: 10 2 13 1 self) ; "Alexander sees no point in trying to talk to that stick in the swamp."
					)
					((== global152 1)
						(self setScript: stickTalking self)
					)
					((== global152 2)
						(gMessager say: 10 2 27 0 self) ; "But really, I...."
					)
					((!= ((gInventory at: 49) owner:) gCurRoomNum) ; tomato
						(gMessager say: 10 2 23 0 self) ; "Alexander isn't getting anywhere by talking to that cranky stick-in-the-mud. The creature simply refuses to toss Alexander any swamp ooze!"
					)
					(else
						(gMessager say: 10 2 15 1 self) ; "The cranky stick-in-the-mud is sleeping now and waking him up would be rather pointless."
					)
				)
			)
			(5
				(if (== local55 1)
					(stick cue: 0)
				else
					(stick cue: 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance quagmire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 4731 normal: 0 setLoop: 0 cel: 0 posn: 151 160)
				(= ticks 10)
			)
			(1
				(gEgo
					cycleSpeed: 8
					moveSpeed: 15
					setCycle: End self
					setMotion: MoveTo 211 131
				)
				(= cycles 2)
			)
			(2)
			(3
				(gMessager say: 6 3 0 1 self) ; "The swampy bog sinks beneath Alexander's weight. He feels himself being sucked slowly but firmly down into the muck!"
			)
			(4
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 477 setLoop: -1 play:)
				(gEgo
					view: 473
					setMotion: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 12
				)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(7
				(gMessager say: 6 3 0 2 self) ; "As the marshy water fills Alexander's mouth, he thinks that, although he'd always wanted to try a mud bath, this is hardly what he had in mind."
			)
			(8
				(EgoDead 36) ; "Do you ever get that sinking feeling?"
			)
		)
	)
)

(instance sFrogY of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 0 3))
				(client
					loop: 2
					cel: 0
					x: [local122 register]
					y: [local126 register]
					signal: 26640
				)
				(= cycles 1)
			)
			(1
				(= cycles (Random 4 8))
			)
			(2
				(client setCycle: CT 3 1 self)
			)
			(3
				(client posn: (client x:) (+ (client y:) 15) setCycle: End self)
			)
			(4
				(if (< (client y:) 195)
					(= state 0)
					(= cycles 1)
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance sFrogX of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 0 4))
				(client
					loop: 1
					cel: 0
					x: [local130 register]
					y: [local135 register]
					signal: 26640
				)
				(= cycles 1)
			)
			(1
				(= cycles (Random 4 8))
			)
			(2
				(if (OneOf register 0 1)
					(client setCycle: CT 9 1 self)
				else
					(+= state 2)
					(client setCycle: End self)
				)
			)
			(3
				(client posn: (+ (client x:) 66) (- (client y:) 8) cel: 0)
				(= cycles (Random 2 4))
			)
			(4
				(client setCycle: End self)
			)
			(5
				(client dispose:)
			)
		)
	)
)

(instance stepOnFrog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client posn: 46 168 cel: 0 setLoop: 1 setCycle: CT 9 1 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 103 160 self)
			)
			(2
				(gGlobalSound2 number: 475 setLoop: 1 play:)
				(client
					setLoop: 3
					posn: 109 164
					setPri: 1
					ignoreActors: 1
					addToPic:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

