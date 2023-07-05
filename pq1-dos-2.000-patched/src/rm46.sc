;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use eRS)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm46 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 19] = [98 111 101 120 70 121 70 114 70 121 22 132 21 125 22 132 95 116 -32768]
	local24
	local25
	local26
	local27
	local28
	local29
)

(instance rm46 of PQRoom
	(properties
		noun 1
		picture 146
		west 45
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(= global207 104)
			(= global206 1)
			(gEgo get: 2 get: 0 get: 9) ; Extender, Service_Revolver, Handcuffs
			(= global211 65)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 313 100 199 100 209 92 236 86 236 82 151 94 64 93 64 99 147 99 147 109 0 126 0 0 319 0 319 189 0 189 0 187 198 179 313 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 266 103 297 114 198 133 167 123
					yourself:
				)
		)
		(super init:)
		(bench init:)
		(birchTrees init:)
		(sky init:)
		(frontPlant init:)
		(garbage init:)
		(grass init:)
		(otherPlants init:)
		(pond init:)
		(sidewalk init:)
		(NormalEgo)
		(gEgo setAvoider: PAvoider posn: 0 186 illegalBits: 0 init:)
		(self posn: 80 168 setScript: (ScriptID 896 1)) ; sWI
		(if (== global211 65)
			(colby setScript: theDeal)
			(gLongSong number: 450 loop: -1 play:)
		else
			(gLongSong number: 458 loop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(switch (++ local1)
			(1
				(gEgo setHeading: 360 self)
			)
			(2
				(roomTimer setCycle: self 2)
			)
			(3
				(gMessager say: 2 4 0 0 self) ; "You throw away the three donut wrappers that have been in your pocket since last Tuesday."
			)
			(4
				(HandsOn)
				(= local1 0)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: stopHiding)
		(gWalkHandler delete: goNow)
		(gEgo setScript: 0)
		(DisposeScript 1399)
		(super dispose: &rest)
	)
)

(instance simms of Actor
	(properties
		x 330
		y 120
		noun 13
		view 397
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(21 ; Handcuffs
				(cond
					(local24
						(gMessager say: 13 38 25 0 self) ; "Trying to handcuff a suspect while holding your service revolver could get one or both of you killed, Bonds. Holster it first."
					)
					((IsFlag 175)
						(gMessager say: 11 0 35 2) ; "You've already taken care of that."
					)
					(else
						(gCurRoom setScript: cuffEm)
					)
				)
			)
			(4 ; Do
				(if (IsFlag 177)
					(super doVerb: theVerb &rest)
				else
					(gCurRoom setScript: friskEm)
				)
			)
			(2 ; Talk
				(switch local4
					(3
						(stopHiding doVerb: 3)
					)
					(2
						(stopHiding doVerb: 3)
					)
					(4
						(gCurRoom setScript: stopEm)
						(simms setMotion: 0 setLoop: -1 xStep: 3 yStep: 2)
					)
					(5
						(gEgo setScript: sTalkSimms)
					)
					(6
						(gEgo setScript: sTalkSimms)
					)
				)
			)
			(9 ; Service_Revolver
				(gCurRoom setScript: shootEm)
			)
		)
	)
)

(instance colby of Actor
	(properties
		x -10
		y 180
		noun 14
		view 392
	)

	(method (cue)
		(self dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(if (== local4 1)
					(stopHiding doVerb: 3)
				else
					(simms doVerb: 2)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shootEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 13 9 0 0 self) ; "You may think that shooting an unarmed suspect is the right thing to do, but, unfortunately, the police department and the justice system just don't see it your way. After you were kicked off the force, you were brought up on murder charges."
			)
			(1
				(EgoDead)
			)
		)
	)
)

(instance drugDeal of Prop
	(properties
		x 173
		y 145
		view 950
		priority 15
		signal 16400
		cycleSpeed 18
	)
)

(instance drugInset of View
	(properties
		x 164
		y 145
		view 955
		cel 1
		priority 15
		signal 16657
	)
)

(instance startHiding of Script
	(properties)

	(method (doit)
		(if (== (gEgo onControl: 1) 16)
			(= local0 0)
			(SetScore 194 5)
			(bushFeature init:)
			(gEgo setScript: hiding)
		)
	)
)

(instance hiding of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local0) (> (gEgo x:) 123))
			(= local0 1)
			(stopHiding doVerb: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gWalkHandler add: stopHiding)
				(gEgo
					setPri: (gEgo priority:)
					setLoop: 2
					setMotion: MoveTo 95 117 self
					setCycle: 0
				)
			)
			(1
				(gEgo setCycle: 0 cel: 2 xStep: 1 yStep: 1)
				(gEgo actions: gunTime)
				(HandsOn)
				(= seconds 3)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(WordAt @local5 register)
						(if local24
							(+ (WordAt @local5 (+ register 1)) -6)
						else
							(WordAt @local5 (+ register 1))
						)
						self
				)
				(+= register 2)
				(if (== (WordAt @local5 register) -32768)
					(= register 0)
				)
				(= seconds 4)
			)
			(3
				(-= state 2)
				(= seconds 2)
			)
		)
	)
)

(instance stopHiding of Feature
	(properties)

	(method (doVerb &tmp temp0)
		(HandsOff)
		(bushFeature dispose:)
		(= temp0 (gEgo priority:))
		(if local24
			(NormalEgo 391)
		else
			(NormalEgo)
		)
		(= local3 (gEgo cycleSpeed:))
		(= local2 (gEgo moveSpeed:))
		(gEgo
			setPri: temp0
			cycleSpeed: 2
			moveSpeed: 2
			setMotion: MoveTo 127 98 comeOut
			setScript: comeOut
		)
		(gWalkHandler delete: self)
	)
)

(instance comeOut of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (or (<= local4 0) (> local4 3))
					(+= state 2)
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gLongSong stop: number: 455 loop: 1 play:)
				(gMessager say: 11 0 32 0 self) ; "FREEZE! POLICE!"
			)
			(3
				(gEgo setPri: -1)
				(cond
					((== local4 0)
						(= next startHiding)
						(self dispose:)
						(HandsOn)
					)
					((== local4 3)
						(= next freak)
						(self dispose:)
					)
					((< local4 3)
						(= local4 8)
						(colby
							view: 399
							setLoop: 6
							cycleSpeed: 4
							moveSpeed: 4
							xStep: 9
							yStep: 9
							setCycle: Walk
							setMotion: MoveTo -10 181 colby
						)
						(if (gCast contains: simms)
							(simms
								cycleSpeed: 5
								moveSpeed: 5
								xStep: 5
								yStep: 5
								view: 403
								setLoop: 4
								setCycle: Walk
								setMotion: MoveTo 340 130 self
							)
						else
							(= seconds 3)
						)
						(stopEm start: 0)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gMessager say: 11 0 7 0 self) ; "Good job, Bonds, you arrested them before the drugs had changed hands. The case was thrown out of court. When Lt. Morgan found out you couldn't handle a simple drug bust, he dropped you out of Narcotics within the hour."
			)
			(5
				(EgoDead)
			)
		)
	)
)

(instance freak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local4 4)
				(gEgo setMotion: PolyPath (- (simms x:) 40) (simms y:))
				(colby
					view: 399
					setLoop: 6
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 9
					yStep: 9
					setCycle: Fwd
					setMotion: MoveTo -10 181 colby
				)
				(simms
					cycleSpeed: 5
					moveSpeed: 5
					xStep: 5
					yStep: 5
					view: 403
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 340 130
				)
				(= seconds 3)
			)
			(1
				(if local24
					(gEgo setHeading: 90)
					(simms doVerb: 2)
					(self dispose:)
				else
					(= seconds 6)
				)
			)
			(2
				(gMessager say: 11 0 33 0 self) ; "Looks like they weren't very afraid of you. Have a weapon ready next time."
			)
			(3
				(EgoDead)
			)
			(4
				(HandsOff)
				(NormalEgo)
				(gEgo setMotion: 0)
				(= ticks 10)
			)
			(5
				(gMessager say: 11 0 23 0 self) ; "Hey, that boy can move! Guess you should have ordered him to "halt", huh, Bonds? After you fouled up this simple drug bust, Lt. Morgan lost all confidence in you. You're back on traffic patrol."
			)
			(6
				(EgoDead)
			)
		)
	)
)

(instance gunTime of Actions
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(11 ; Extender
					(cond
						((and (== local4 0) (!= (gEgo script:) hiding))
							(gMessager say: 15 7 26 0) ; "You key the radio to talk to Laura. She's responds by telling you to get in position and keep quiet until it's time to make the bust."
						)
						((<= local4 2)
							(if local27
								(gMessager say: 15 7 28 0) ; "You hear Laura over the radio, "Bonds, keep it quiet or you'll screw-up the operation." You wisely decide to shut up."
							else
								(= local27 1)
								(gMessager say: 15 7 27 0) ; "You key the radio and quietly let Laura know that you're in position. She responds, "10-4.""
							)
						)
						((== local4 3)
							(gCurRoom setScript: getEm)
						)
						(else
							(return 0)
						)
					)
					1
				)
				(9 ; Service_Revolver
					(simms setScript: (if local24 gunAway else drawGun))
					1
				)
				(else 0)
			)
		)
	)
)

(instance drawGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 389
					setLoop:
						(if (>= (gEgo loop:) 8)
							(gEgo cel:)
						else
							(gEgo loop:)
						)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 12 9 24 0 self) ; "You draw your service revolver."
			)
			(2
				(if (== (gEgo script:) hiding)
					(gEgo view: 391)
				else
					(NormalEgo 391)
				)
				(= local24 1)
				(HandsOn)
				(if (OneOf local4 5 6)
					(gTheIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance gunAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 389
					setLoop:
						(if (>= (gEgo loop:) 8)
							(gEgo cel:)
						else
							(gEgo loop:)
						)
				)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(1
				(if (!= (gEgo script:) hiding)
					(NormalEgo)
				)
				(= local24 0)
				(HandsOn)
				(if (OneOf local4 5 6)
					(gTheIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance getEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 15 7 29 0 self) ; "You key the mike, "Laura, I'm movin' in.""
			)
			(1
				(stopHiding doVerb: 3)
				(self dispose:)
			)
		)
	)
)

(instance stopEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (simms x:) 310)
					(gMessager say: 11 0 23 0 self) ; "Hey, that boy can move! Guess you should have ordered him to "halt", huh, Bonds? After you fouled up this simple drug bust, Lt. Morgan lost all confidence in you. You're back on traffic patrol."
				else
					(++ state)
					(gMessager say: 13 2 11 0 self) ; "HALT! I'm a police officer!"
				)
			)
			(1
				(EgoDead)
			)
			(2
				(if (!= (gEgo x:) (- (simms x:) 40))
					(gEgo setMotion: PolyPath (- (simms x:) 40) (simms y:))
				)
				(simms
					view: 402
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(HandsOff)
				(gMessager say: 13 2 12 0 self) ; "I'm not going to shoot you, son. Put your hands over your head."
			)
			(5
				(simms
					view: 402
					setLoop: 1
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(6
				(gLongSong fade: self)
			)
			(7
				(= local4 5)
				(gLongSong number: 458 loop: -1 play:)
				(HandsOn)
				(gTheIconBar disable: 0)
				(gEgo cycleSpeed: local3 moveSpeed: local2)
				(self dispose:)
			)
		)
	)
)

(instance cuffEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ local25)
				(gEgo
					setMotion:
						PolyPath
						(+ -16 (simms x:))
						(+ -2 (simms y:))
						self
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(if (>= local25 2)
					(SetScore 175 1)
					(gMessager say: 13 38 2 0 self) ; "Sorry, son, it's police procedure. They'll come off as soon as you go through booking."
				else
					(gMessager say: 13 38 1 0 self) ; "Hey! Hey, what are you doing? You don't need those. Please, man, don't!"
				)
			)
			(3
				(if (< local25 2)
					(self dispose:)
					(HandsOn)
					(return)
				)
				(simms view: 402 loop: 4 cel: 0 cycleSpeed: 8)
				(= ticks 8)
			)
			(4
				(simms setCycle: End self)
			)
			(5
				(gEgo hide:)
				(simms view: 396 loop: 3 cel: 0)
				(= ticks 8)
			)
			(6
				(simms setCycle: End self)
			)
			(7
				(= ticks 8)
			)
			(8
				(simms loop: 4 cel: 0)
				(= ticks 8)
			)
			(9
				(simms setCycle: End self)
			)
			(10
				(= ticks 8)
			)
			(11
				(gEgo posn: (+ -13 (simms x:)) (+ -1 (simms y:)) show:)
				(simms
					posn: (+ 2 (simms x:)) (+ 3 (simms y:))
					view: 398
					loop: 4
				)
				(simms cel: (simms lastCel:))
				(gWalkHandler add: goNow)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goNow of Feature
	(properties)

	(method (doVerb &tmp temp0)
		(HandsOff)
		(friskEm start: 7)
		(gCurRoom setScript: friskEm)
	)
)

(instance friskEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 177 1)
				(gEgo
					ignoreActors: 1
					setMotion:
						PolyPath
						(+ -16 (simms x:))
						(+ -2 (simms y:))
						self
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(if (>= local25 2)
					(gEgo hide:)
					(simms
						view: 396
						loop: 5
						cel: 0
						cycleSpeed: 8
						setCycle: End self
					)
				else
					(gMessager say: 13 4 20 0 self) ; "Perhaps you should have cuffed the young fellow before attempting to search him. Lt. Morgan was not happy to discover that you let a 17-year-old boy outsmart you. You've been busted back down to Traffic patrol."
				)
			)
			(3
				(if (>= local25 2)
					(simms cel: 0 setCycle: End self)
				else
					(EgoDead)
				)
			)
			(4
				(gEgo posn: (+ -13 (simms x:)) (+ -1 (simms y:)) show:)
				(simms
					posn: (+ -2 (simms x:)) (+ 2 (simms y:))
					view: 398
					loop: 4
				)
				(simms cel: (simms lastCel:))
				(= cycles 2)
			)
			(5
				(gMessager say: 13 4 21 0 self) ; "You find a stick of gum, a movie ticket stub, and a cellophane packet of a white, powdery substance that resembles cocaine. You'll turn the stuff over to Detective Watts to book into evidence."
			)
			(6
				(gMessager say: 13 2 31 (if (>= local26 3) 4 else 0) self)
				(SetFlag 176)
			)
			(7
				(gWalkHandler delete: goNow)
				(simms
					cycleSpeed: (simms moveSpeed:)
					setCycle: Walk
					setLoop: -1
					setMotion: PolyPath -10 186 self
				)
				(= ticks 80)
			)
			(8
				(gEgo
					cycleSpeed: (simms cycleSpeed:)
					moveSpeed: (simms moveSpeed:)
					setMotion: PolyPath -10 186 self
				)
			)
			(9
				(= global211 67)
				(gCurRoom newRoom: 45)
			)
		)
	)
)

(instance tense of Sound ; UNUSED
	(properties
		priority 15
		loop -1
	)
)

(instance sfx of Sound ; UNUSED
	(properties)
)

(instance bench of Feature
	(properties
		noun 3
		onMeCheck 64
		approachX 245
		approachY 125
	)
)

(instance birchTrees of Feature
	(properties
		noun 6
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb (if (== (++ local29) 2) 0 else 1))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance frontPlant of Feature
	(properties
		noun 7
		nsTop 96
		nsBottom 189
		nsRight 187
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(& (OnControl PRIORITY temp0 temp1) $4000)
				(<= nsLeft temp0 nsRight)
				(<= nsTop temp1 nsBottom)
			)
		)
	)
)

(instance garbage of Feature
	(properties
		noun 2
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (== (gEgo script:) hiding) (OneOf local4 5 6))
					(gMessager say: 11 0 34) ; "Not now, Bonds! Follow procedure!"
				else
					(HandsOff)
					(NormalEgo)
					(gEgo setMotion: MoveTo 206 133 gCurRoom)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grass of Feature
	(properties
		noun 8
		onMeCheck 4
	)
)

(instance otherPlants of Feature
	(properties
		noun 9
		onMeCheck 17
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager
				say:
					noun
					theVerb
					(switch (++ local28)
						(2 2)
						(3 3)
						(else 1)
					)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pond of Feature
	(properties
		noun 5
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) (== (Random 2 14) 5)) ; Talk
			(gMessager say: noun theVerb 8)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sidewalk of Feature
	(properties
		noun 4
		onMeCheck 128
	)
)

(instance sky of Feature
	(properties
		noun 10
		onMeCheck 2048
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance sTalkSimms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf local4 5 6)
					(= local26 3)
					(if (not (IsFlag 176))
						(SetScore 176 1)
						(gMessager say: 13 2 13 0 self) ; "What's your name?"
					else
						(gMessager say: 11 0 35 1 self) ; "You've already read him his rights. Time to proceed."
					)
				else
					(= cycles 2)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance theDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(gEgo setScript: startHiding)
				(colby init: hide:)
				(if (== gPrevRoomNum 1)
					(= seconds 20)
				else
					(= seconds 30)
				)
			)
			(1
				(= global211 66)
				(= local4 1)
				(colby show: setCycle: Walk setMotion: MoveTo 17 174 self)
			)
			(2
				(if (!= (gEgo script:) hiding)
					(HandsOff)
					(Face gEgo colby self)
				else
					(+= state 3)
					(= cycles 2)
				)
			)
			(3
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(4
				(gMessager say: 11 0 5 0 self) ; "Hey--who the hell are you? I'm outta here, man. This ain't worth the trouble."
			)
			(5
				(EgoDead)
			)
			(6
				(colby setMotion: MoveTo 165 143 self)
				(= ticks 30)
			)
			(7
				(if (!= (gEgo script:) hiding)
					(HandsOff)
					(colby setMotion: 0)
					(Face gEgo colby self)
				else
					(+= state 3)
				)
			)
			(8
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(9
				(gMessager say: 11 0 5 0 self) ; "Hey--who the hell are you? I'm outta here, man. This ain't worth the trouble."
			)
			(10
				(EgoDead)
			)
			(11
				(colby view: 399 setLoop: 3 cel: 0 setCycle: End self)
			)
			(12
				(gMessager say: 11 0 4 0 self) ; "Where is that little creep, anyway?"
			)
			(13
				(if (== gPrevRoomNum 1)
					(= seconds 2)
				else
					(= seconds 6)
				)
			)
			(14
				(colby cycleSpeed: 10 setLoop: 5 cel: 0 setCycle: End)
				(if (== gPrevRoomNum 1)
					(= seconds 1)
				else
					(= seconds 3)
				)
			)
			(15
				(colby setCycle: Beg)
				(if (== gPrevRoomNum 1)
					(= seconds 1)
				else
					(= seconds 4)
				)
			)
			(16
				(colby setLoop: 4 setCycle: End)
				(if (== gPrevRoomNum 1)
					(= seconds 1)
				else
					(= seconds 3)
				)
			)
			(17
				(colby setCycle: Beg)
				(simms init: setCycle: Walk setMotion: MoveTo 188 144 self)
			)
			(18
				(colby setLoop: -1)
				(= local4 2)
				(simms view: 401 loop: 5 cel: 0)
				(HandsOff)
				(= cycles 2)
			)
			(19
				(if (!= (gEgo script:) comeOut)
					(drugInset init:)
					(drugDeal init: setCycle: End self)
					(gGame setCursor: 996 1)
				)
			)
			(20
				(gMessager say: 11 0 6 0 self) ; "You're late. Where the hell were you, Simms?"
			)
			(21
				(drugDeal view: 951 setCel: 0 setCycle: End self)
			)
			(22
				(= ticks 18)
				(Load rsVIEW 952)
			)
			(23
				(drugDeal view: 952 setCel: 0)
				(= ticks 18)
			)
			(24
				(drugDeal setCycle: End self)
			)
			(25
				(drugDeal view: 953 setCel: 0)
				(= ticks 18)
			)
			(26
				(drugDeal setCycle: End self)
			)
			(27
				(drugDeal view: 954 setCel: 0)
				(= ticks 18)
			)
			(28
				(drugDeal setCycle: End self)
			)
			(29
				(= local4 3)
				(drugInset dispose:)
				(drugDeal dispose:)
				(= cycles 2)
			)
			(30
				(HandsOn)
				(= ticks 30)
			)
			(31
				(colby cycleSpeed: 6 loop: 0 setCycle: End self)
			)
			(32
				(simms setCycle: End self)
			)
			(33
				(colby
					view: 392
					setCycle: Walk
					setLoop: (Grooper new:)
					setMotion: MoveTo -10 180 self
				)
				(simms
					view: 397
					setCycle: Walk
					setLoop: (Grooper new:)
					setMotion: MoveTo 340 130 self
				)
			)
			(34)
			(35
				(HandsOff)
				(NormalEgo)
				(gEgo setMotion: 0)
				(simms dispose:)
				(= cycles 2)
			)
			(36
				(gMessager say: 11 0 23 0 self) ; "Hey, that boy can move! Guess you should have ordered him to "halt", huh, Bonds? After you fouled up this simple drug bust, Lt. Morgan lost all confidence in you. You're back on traffic patrol."
			)
			(37
				(EgoDead)
			)
		)
	)
)

(instance bushFeature of Feature
	(properties
		x 56
		y 85
		nsTop 65
		nsBottom 106
		nsRight 113
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gunTime doVerb: 11)
		else
			(gunTime doVerb: theVerb)
		)
	)
)

