;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Conversation)
(use PAvoider)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm35 0
	Paul 1
)

(local
	local0
	local1
	local2
	local3 = -1
	local4 = -1
	local5
	local6 = 3
	[local7 42] = [156 120 151 119 289 0 154 119 289 1 157 121 374 6 161 126 158 125 288 0 158 126 288 1 161 126 397 6 154 123 151 121 301 0 151 121 301 2 154 123 353 6]
	[local49 42] = [155 119 294 0 153 120 294 1 0 0 0 0 0 0 173 126 295 0 167 126 295 1 0 0 0 0 0 0 158 120 293 1 0 0 0 0 0 0 0 0 0 0]
	[local91 10]
)

(procedure (localproc_0)
	(switch global211
		(25
			(return 28)
		)
		(48
			(return 0)
		)
		(71
			(return 14)
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 [temp4 6])
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 26) ((++ temp0))
		(= temp3 1)
		(for ((= temp2 0)) (< temp2 5) ((++ temp2))
			(if
				(!=
					(StrAt @local91 temp2)
					(StrAt
						{99999 00377 00364 00322 00399 00337 00349 00359 12876 12755 12509 19221 19227 14304 16310 13301 21490 21650 22679 26504 29211 21603 21068 44729 00308 }
						(+ temp1 temp2)
					)
				)
				(= temp3 0)
				(break)
			)
		)
		(if temp3
			(return temp0)
		)
		(+= temp1 6)
	)
)

(procedure (localproc_2 &tmp [temp0 6])
	(if (== local4 -1)
		(return 0)
	)
	(switch local2
		(28
			(return (OneOf local4 15 16 19 20 21 23))
		)
		(0
			(return (OneOf local4 8 10 11 15 16 19 20 22 24))
		)
		(14
			(return (OneOf local4 8 9 22 24))
		)
	)
)

(instance rm35 of PQRoom
	(properties
		noun 9
		picture 35
		x 78
		y 156
	)

	(method (init)
		(gCurRoom
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 52 138 52 156 0 183 0 0 319 0 319 189 116 189 177 155 246 155 246 151 216 141 247 120 204 110 231 99 213 95 179 105 154 99 131 106 148 111
					yourself:
				)
		)
		(= local2 (localproc_0))
		(LoadMany rsVIEW 0 291 292)
		(LoadMany rsSOUND 351 918 938 352)
		(if (!= local2 -1)
			(switch local2
				(0
					(LoadMany rsVIEW 289 374 294 297 110)
				)
				(14
					(LoadMany rsVIEW 288 397 398 295 394 12)
				)
				(28
					(LoadMany rsVIEW 301 353 342 293)
				)
			)
			(LoadMany rsVIEW 302 296)
		else
			(LoadMany rsVIEW 300)
			(switch global211
				(82
					(cop init:)
					((ScriptID 896 1) next: marieSpeach) ; sWI
				)
				(59
					(cop init:)
					((ScriptID 896 1) next: preWarrantConv) ; sWI
				)
			)
		)
		(super init:)
		(fWindow init:)
		(guard init:)
		(door1 init:)
		(door2 init: ignoreActors: 1 addToPic:)
		(gEgo init: posn: 49 146)
		(if (and (>= local2 0) (!= global211 59))
			((ScriptID 896 1) next: suspectComesIn) ; sWI
		)
		(self posn: 114 130 setScript: (ScriptID 896 1) 0) ; sWI
	)

	(method (notify param1 param2 param3 param4 param5 param6 &tmp temp0 [temp1 19])
		(Format ; "%c%c%c%c%c"
			@local91
			35
			0
			(+ param2 48)
			(+ param3 48)
			(+ param4 48)
			(+ param5 48)
			(+ param6 48)
		)
		(= local5 param1)
		(= local4 (localproc_1))
		(= temp0 0)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(if (< 0 local1 4)
					(self setScript: bounceFromExit)
				else
					(self posn: 51 155 setScript: (ScriptID 896 2) 0 34) ; sWO
				)
			)
		)
		(super doit:)
	)
)

(instance suspectComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(suspect init: setMotion: MoveTo 91 146 self)
				(if (!= local2 14)
					(+= state 2)
				)
			)
			(1
				(suspect2 init: setMotion: MoveTo 64 145 self)
				(cop init: setMotion: MoveTo 116 152 self)
			)
			(2)
			(3
				(gEgo setHeading: 180 self)
				(suspect setHeading: 0 self)
			)
			(4)
			(5
				(guard stopUpd:)
				(if (== local2 14)
					(cop setHeading: 315)
					(suspect2 setHeading: 0)
				)
				(gMessager say: (suspect noun:) 2 1 0 self)
			)
			(6
				(suspect setMotion: MoveTo 76 131 self)
				(if (!= local2 14)
					(+= state 1)
				)
			)
			(7
				(suspect2 setMotion: MoveTo 69 137 self)
			)
			(8
				(= local1 1)
				(suspect setHeading: 315 self)
				(if (== local2 14)
					(cop stopUpd:)
					(suspect2 setHeading: 315)
				)
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance suspectToCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo suspect self)
			)
			(1
				(gMessager say: (suspect noun:) 2 5 0 self)
			)
			(2
				(suspect
					setMotion:
						PolyPath
						[local7 (+ local2 0)]
						[local7 (+ local2 1)]
						self
				)
				(if (== local2 14)
					(suspect2 init: setMotion: PolyPath 195 135 self)
				else
					(= cycles 1)
				)
			)
			(3)
			(4
				(= local1 2)
				(suspect setHeading: 225 self)
				(if (== local2 14)
					(suspect2 setHeading: 225)
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance suspectShootsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(suspect
					view: [local49 (+ local2 2)]
					loop: [local49 (+ local2 3)]
					cel: 0
					posn: [local49 (+ local2 0)] [local49 (+ local2 1)]
					setCycle: End self
				)
			)
			(1
				(if (!= local2 28)
					(suspect
						view: [local49 (+ local2 6)]
						loop: [local49 (+ local2 7)]
						cel: 0
						posn: [local49 (+ local2 4)] [local49 (+ local2 5)]
						setCycle: End self
					)
					(sfx number: 938 loop: 1 play:)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 296
					loop: (if (== global206 0) 0 else 1)
					cel: 0
					posn: 190 119
					setCycle: End self
				)
			)
			(3
				(if (== local2 0)
					(suspect
						view: 294
						loop: 2
						cel: 0
						posn: [local49 (+ local2 4)] [local49 (+ local2 5)]
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(4
				(gMessager say: (suspect noun:) 4 11 0 self)
			)
			(5
				(EgoDead)
			)
		)
	)
)

(instance suspectPutInCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 self)
			)
			(1
				(gMessager say: (suspect noun:) 2 6 0 self)
			)
			(2
				(proc134_4
					suspect
					[local7 (+ local2 12)]
					[local7 (+ local2 13)]
					[local7 (+ local2 10)]
					[local7 (+ local2 11)]
				)
				(suspect setMotion: MoveTo 131 97 self ignoreActors: 1)
			)
			(3
				(suspect setMotion: MoveTo 122 91 self)
			)
			(4
				(suspect setHeading: 135)
				(LoadMany rsSOUND 352)
				(door1 startUpd: setCycle: Beg self)
				(= cycles 2)
			)
			(5
				(sfx number: 352 loop: 1 play:)
			)
			(6
				(suspect stopUpd:)
				(= local1 4)
				(door1 stopUpd:)
				(if (and (!= local2 14) (not (and (== local2 28) (IsFlag 4))))
					(= next copTalksAbout)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance suspectPutInCell2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 205 129 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo
					view: 302
					loop: (if (== global206 0) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(suspect2
					view: 288
					loop: 2
					cel: 0
					posn: 193 135
					setCycle: End self
				)
			)
			(4
				(suspect2
					loop: 3
					cel: (suspect2 lastCel:)
					posn: 198 137
					setCycle: Beg self
				)
			)
			(5
				(NormalEgo -1 5)
				(gMessager say: 3 2 6 0 self) ; "Alright, into the cells with the both of you."
			)
			(6
				(suspect
					view: [local7 (+ local2 12)]
					loop: [local7 (+ local2 13)]
					cel: 0
					posn: [local7 (+ local2 10)] [local7 (+ local2 11)]
				)
				(proc134_4
					suspect
					[local7 (+ local2 12)]
					[local7 (+ local2 13)]
					[local7 (+ local2 10)]
					[local7 (+ local2 11)]
				)
				(proc134_4 suspect2 392 5 195 135)
				(suspect setMotion: MoveTo 145 93 self ignoreActors: 1)
			)
			(7
				(suspect setMotion: MoveTo 128 87 self)
				(suspect2 ignoreActors: 1 setMotion: MoveTo 145 93 self)
			)
			(8)
			(9
				(suspect setMotion: MoveTo 108 89 self)
				(suspect2 setMotion: MoveTo 128 87 self)
			)
			(10)
			(11
				(suspect2 setHeading: 135)
				(door1 startUpd: setCycle: Beg self)
			)
			(12
				(suspect stopUpd:)
				(suspect2 stopUpd:)
				(= local1 4)
				(door1 stopUpd:)
				(cop startUpd: setMotion: MoveTo 170 134 self)
			)
			(13
				(gMessager say: 5 2 13 0 self) ; "Good work, Sonny. This'll be a pleasure to report to Morgan. It increases the likelihood that this could be a permanent position for you. Let's roll back and do the paperwork, partner."
			)
			(14
				(cop setMotion: MoveTo 55 172 self)
			)
			(15
				(cop dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance copTalksAbout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cop
					init:
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 5)
						self
				)
			)
			(1
				(if (== local2 28)
					(gMessager say: 5 2 12 0 self) ; "Sonny! Glad I spotted your black-and-white. I just wanted to let you know about an opening in Narcotics. Morgan is accepting transfer requests now."
				else
					(gMessager say: 6 2 14 0 self) ; "Hey, Sonny. I got the evidence booked on this guy."
				)
			)
			(2
				(cop setMotion: MoveTo 52 154 self)
			)
			(3
				(cop dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 8 0 16 0 self) ; "What do you think you're doing, Officer? You can't leave a prisoner unprocessed."
			)
			(1
				(gEgo setMotion: MoveTo 114 130 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance marieSpeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 171 5)
				(++ global211)
				(gMessager say: 4 0 15 1 self) ; "Geez, Sonny. Do I have to see that ugly mug all day?"
			)
			(1
				(gEgo setMotion: PolyPath 109 122 self)
			)
			(2
				(gMessager say: 4 0 15 2 self) ; "Just keep away from mirrors, Paul."
			)
			(3
				(gMessager say: 4 0 15 3 self) ; "So where's the prisoner I'm supposed to visit?"
			)
			(4
				(gMessager say: 4 0 15 4 self) ; "She's in one of the cells. I hear she's an old flame of yours. So, have you and her performed nature's mystery dance?"
			)
			(5
				(gMessager say: 4 0 15 5 self) ; "Well, you just think about it on one of your lonely Saturday nights, Paul. Thanks for all the great info."
			)
			(6
				(gMessager say: 4 0 15 6 self) ; "That guy proves that evolution hasn't been 100-percent effective."
			)
			(7
				(gEgo setMotion: PolyPath 193 105 self)
			)
			(8
				(gLongSong number: 353 loop: -1 play:)
				(marieConv
					add: marieGestures
					add: -1 7 2 15 1 ; "Sonny, I'm sure sorry I didn't listen to your tip about the sweep. You've gotta help me. I'm afraid I pressed my luck one too many times. I can't afford this bust. They're gonna put me up in County this time. Sonny, those women are scary. I'm not a hardcore criminal. I never hurt anyone."
					add: marieGestures
					add: -1 7 2 15 2 ; "Isn't there anything you can do for an old classmate?"
					add: marieGestures
					add: -1 7 2 15 3 ; "Possibly. The Department's been investigating the Hotel Delphoria, trying to gather enough evidence to move in. Right now, we don't have anything that'd stick. You might be able to help."
					add: marieGestures
					add: -1 7 2 15 4 ; "My boss, Lt. Morgan, has a plan that he believes will get us close to the main dude, someone they call `The Death Angel.' This guy's the worst of the worst in the highest order of social parasites, Marie. He's not only sucking the blood of society, he's spilling it."
					add: marieGestures
					add: -1 7 2 15 5 ; "Wanna help?"
					add: marieGestures
					add: -1 7 2 15 6 ; "Will it get me cleared of these charges? I just can't go to jail."
					add: marieGestures
					add: -1 7 2 15 7 ; "I can't guarantee anything. But Morgan and I can talk to the prosecutor on your behalf."
					init: self
				)
			)
			(9
				(marieConv
					add: marieGestures
					add: -1 7 2 15 8 ; "Just between you and me, I think the odds are in your favor. You'd be doing the department a major favor. But that's just between you and me, right? I'm not guaranteeing anything."
					add: marieGestures
					add: -1 7 2 15 9 ; "So, what do you think?"
					add: marieGestures
					add: -1 7 2 15 10 ; "Okay, Sonny, it's a deal."
					add: marieGestures
					add: -1 7 2 15 11 ; "Great. I've got to head back to the station. A car will be sent by shortly to pick you up. I'll see you later."
					add: marieGestures
					add: -1 7 2 15 12 ; "Whatever you say, Sonny. Thanks."
					add: marieGestures
					add: -1 7 2 15 13 ; "You're puzzled by a strange, warm and fuzzy sensation after your conversation with Marie. Easy, boy. You've got to concentrate on the business at hand. Anything less than 100 percent can prove fatal."
					add: marieGestures
					init: self
				)
			)
			(10
				(gLongSong fade: 0 10 4 1 self)
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance preWarrantConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo guard self)
			)
			(1
				(gMessager say: 4 2 20 0 self) ; "Got something for ya, Paul."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance warrantShit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(gMessager say: 4 2 21 1 self) ; "Here you go."
			)
			(2
				(gEgo put: 12) ; No_Bail_Warrant
				(proc134_3 self)
			)
			(3
				(NormalEgo -1 7)
				(guard
					startUpd:
					setLoop: 1
					cel: 0
					posn: 93 111
					setCycle: End self
				)
			)
			(4
				(gMessager say: 4 2 21 2 self) ; "Well, well! Good thing you got this here when you did, Bonds. Hold on, I'll process it."
			)
			(5
				(guard
					setLoop: 5
					cel: 0
					posn: 84 112
					setCycle: Walk
					setMotion: MoveTo 61 110 self
				)
			)
			(6
				(= seconds 5)
			)
			(7
				(guard
					setLoop: 4
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 84 112 self
				)
			)
			(8
				(guard setLoop: 2 cel: 0 posn: 90 110 setCycle: 0 stopUpd:)
				(SetScore 169 2)
				(= global211 60)
				(gMessager say: 4 2 21 3 self) ; "Thanks, Bonds. He's all checked in...but he ain't checkin' out."
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance marieGestures of Code
	(properties)

	(method (doit)
		(cop
			cel: 0
			setLoop: (= local3 (mod (++ local3) 4))
			setCycle: End marieConv
		)
	)
)

(instance suspect of Actor
	(properties
		x 52
		y 154
		view 0
		loop 6
	)

	(method (init)
		(switch local2
			(0
				(self noun: 2 view: 297)
			)
			(28
				(self noun: 1 view: 342)
			)
			(14
				(self noun: 3 view: 398)
			)
		)
		(super init: &rest)
		(proc134_4 self)
		(self setAvoider: PAvoider)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local1
					(0
						(gMessager say: noun 2 10 0)
					)
					(1
						(if (OneOf global211 49 26 72)
							(gCurRoom setScript: suspectToCell)
						else
							(gMessager say: noun 2 10 0)
						)
					)
					(2
						(gMessager say: noun 2 7 0)
					)
					(4
						(gMessager say: noun 2 8 0)
					)
					(else
						(gMessager say: noun 2 8 0)
					)
				)
			)
			(4 ; Do
				(switch local1
					(2
						(gCurRoom setScript: unCuffSuspect)
					)
					(else
						(gMessager say: 8 4 25 0) ; "You should have the prisoner move to the middle of the room before attempting to remove the handcuffs."
					)
				)
			)
		)
	)
)

(instance suspect2 of Actor
	(properties
		x 43
		y 153
		view 394
	)

	(method (doVerb theVerb)
		(suspect doVerb: theVerb &rest)
	)

	(method (init)
		(super init: &rest)
		(proc134_4 self)
	)
)

(instance cop of Actor
	(properties
		x 55
		y 172
		heading 45
		noun 5
		view 12
		loop 6
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(switch noun
					(7
						(gMessager say: 7 2 0 0) ; "Might as well sit back and relax. Lt. Morgan will be sending a car over for you. I'll see you later at the station."
					)
					(5
						(switch local1
							(1
								(= temp0 10)
							)
							(2
								(= temp0 9)
							)
							(else
								(= temp0 0)
							)
						)
						(gMessager say: 5 2 temp0 0)
					)
					(2
						(switch global211
							(59
								(gMessager say: 2 2 20 0) ; "I've got a little surprise for you."
							)
							(60
								(gMessager say: 2 2 22 0) ; "If there's anything we can do to make your extended stay more comfy, you'll be sure to let us know, right?"
							)
						)
					)
				)
			)
			(4 ; Do
				(if (== noun 7)
					(gMessager say: noun 4 0 0) ; "You think she might be willing but the atmosphere in this prison is a little too much like a cheap Linda Blair movie. Someplace more romantic would be better.", MISSING MESSAGE
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(cond
			((== local2 0)
				(self noun: 6 view: 110)
			)
			((== global211 82)
				(self view: 300 loop: 0 noun: 7 posn: 203 80)
			)
			((== global211 59)
				(self
					noun: 2
					view: 297
					loop: 4
					posn: 122 91
					approachX: 150
					approachY: 101
					approachVerbs: 2 ; Talk
				)
			)
		)
		(super init: &rest)
		(proc134_4 self)
	)
)

(instance guard of Actor
	(properties
		x 93
		y 112
		noun 4
		approachX 109
		approachY 122
		view 291
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(proc134_4 self)
		(self approachVerbs: 2 26 stopUpd:) ; Talk, No_Bail_Warrant
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((and (== (door1 cel:) 8) local0)
						(gMessager say: 13 4 27 0 self) ; "Door's open, Sonny, any time."
					)
					((and (!= local2 -1) (== local1 1))
						(gCurRoom setScript: egoSubmitCharges)
					)
					((== global211 83)
						(gMessager say: 4 2 23 0) ; "Hey, Sonny-boy! Sounds like Marie's warm for your form! Gonna get a little free..."
					)
					(else
						(gMessager say: 4 2 24 0) ; "Hey, Sonny, how's it going?"
					)
				)
			)
			(26 ; No_Bail_Warrant
				(gCurRoom setScript: warrantShit)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		x 120
		y 94
		noun 11
		view 292
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance door2 of View
	(properties
		x 208
		y 63
		z -30
		noun 12
		view 292
		loop 1
		priority 5
		signal 16
	)
)

(instance Paul of Narrator
	(properties
		x 160
		y 100
		talkWidth 130
		showTitle 1
	)
)

(instance marieConv of Conversation
	(properties)
)

(instance fWindow of Feature
	(properties
		x 89
		y 27
		z -50
		noun 10
		onMeCheck 16384
		approachX 109
		approachY 122
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 26) ; Talk, No_Bail_Warrant
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40 ; ???
				(guard doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance unCuffSuspect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(suspect ignoreActors: 1)
				(gEgo setMotion: PolyPath 160 100 self)
			)
			(1
				(gEgo setMotion: PolyPath 168 117 self)
			)
			(2
				(SetScore 170 2)
				(gEgo setHeading: 225)
				(Load rsSOUND 918)
				(= seconds 2)
			)
			(3
				(gEgo
					view: 302
					loop: (if (== global206 0) 0 else 1)
					cel: 0
					setCycle: End self
				)
				(sfx number: 919 play:)
			)
			(4
				(NormalEgo -1 5)
				(suspect
					view: [local7 (+ local2 4)]
					loop: [local7 (+ local2 5)]
					cel: 0
					posn: [local7 (+ local2 2)] [local7 (+ local2 3)]
					setCycle: End self
				)
			)
			(5
				(suspect
					view: [local7 (+ local2 8)]
					loop: [local7 (+ local2 9)]
					cel: 0
					posn: [local7 (+ local2 6)] [local7 (+ local2 7)]
					setCycle: End self
				)
			)
			(6
				(gMessager say: (suspect noun:) 2 9 0 self)
			)
			(7
				(if (gEgo has: 0) ; Service_Revolver
					(gEgo setMotion: MoveTo 175 119 self)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(8
				(gEgo setHeading: 45 self)
			)
			(9
				(= local1 3)
				(cond
					((gEgo has: 0) ; Service_Revolver
						(= next suspectShootsEgo)
					)
					((== local2 14)
						(= next suspectPutInCell2)
					)
					(else
						(= next suspectPutInCell)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoSubmitCharges of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not register)
					(= register 1)
					(++ global211)
					(gEgo put: 17) ; Hoffman_s_License
					(switch local2
						(28
							(gMessager say: 4 2 2 0 self) ; "I've got another guest for your fine establishment, Paul."
						)
						(0
							(gMessager say: 4 2 3 0 self) ; "Paul, we've got another winner. Tell 'em what he's won."
						)
						(14
							(gMessager say: 4 2 4 0 self) ; "Paul, I've got a couple more cell-stuffers for you."
						)
					)
				else
					(= cycles 2)
				)
			)
			(1
				(self setScript: (ScriptID 165 0) self 0 170 57) ; keyStuff
			)
			(2
				(if (== local5 1)
					(if (not (localproc_2))
						(cond
							((and local0 (== local4 0))
								(+= state 3)
								(sfx number: 351 loop: 1 play:)
								(door1 startUpd: setCycle: End self)
							)
							((-- local6)
								(gMessager say: 4 2 17 local6 self)
								(-= state 3)
							)
							(else
								(EgoDead)
							)
						)
					else
						(gMessager say: 4 2 19 (+ local4 1) self)
					)
				else
					(-= state 2)
					(gMessager say: 4 2 18 0 self) ; "Please enter a code."
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(switch local4
					(1
						(SetScore 200 1)
					)
					(2
						(SetScore 201 1)
					)
					(3
						(SetScore 202 1)
					)
					(4
						(SetScore 203 1)
					)
					(5
						(SetScore 204 1)
					)
					(6
						(SetScore 205 1)
					)
					(7
						(SetScore 206 1)
					)
					(8
						(cond
							((IsFlag 82)
								(SetScore 207 1)
							)
							((== global211 71)
								(SetScore 208 1)
							)
							(else
								(gMessager say: 4 2 28) ; "Er...Sonny, I don't think you've got the evidence to book 'em on THAT violation. Better try another."
							)
						)
					)
					(9
						(SetScore 209 1)
					)
					(10
						(SetScore 210 1)
					)
					(11
						(if (IsFlag 83)
							(SetScore 211 1)
						else
							(gMessager say: 4 2 28) ; "Er...Sonny, I don't think you've got the evidence to book 'em on THAT violation. Better try another."
						)
					)
					(12
						(SetScore 212 1)
					)
					(13
						(SetScore 213 1)
					)
					(14
						(SetScore 214 1)
					)
					(15
						(SetScore 215 1)
					)
					(16
						(SetScore 216 1)
					)
					(17
						(SetScore 217 1)
					)
					(18
						(SetScore 218 1)
					)
					(19
						(SetScore 219 1)
					)
					(20
						(SetScore 220 1)
					)
					(21
						(SetScore 221 1)
					)
					(22
						(SetScore 222 1)
					)
					(23
						(SetScore 223 1)
					)
					(24
						(SetScore 224 1)
					)
				)
				(= cycles 2)
			)
			(5
				(HandsOn)
				(guard stopUpd:)
				(suspect stopUpd:)
				(door1 stopUpd:)
				(= local0 1)
				(self init:)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

