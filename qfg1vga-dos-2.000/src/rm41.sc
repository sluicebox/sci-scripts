;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	[local0 8] = [0 6 7 8 5 3 4 999]
	[local8 9]
	[local17 2] = [0 999]
	[local19 8] = [0 6 7 13 5 -11 4 999]
	[local27 9]
	[local36 4] = [0 999 1 0]
	local40
	local41
	local42
	[local43 2]
	local45
	local46
	local47
	local48
	local49
	local50
	local51
	local52
	local53
)

(instance rm41 of Rm
	(properties
		noun 8
		picture 41
	)

	(method (dispose)
		(SetFlag 31)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(= [local8 0] @local0)
		(= [local8 1] 999)
		(= [local27 0] @local19)
		(= [local8 1] 999)
		(Load rsVIEW 41)
		(= temp0 (if gNight 32 else 25))
		(if (or (== (gLongSong prevSignal:) -1) (!= (gLongSong number:) temp0))
			(gLongSong stop: number: temp0 loop: -1 priority: 0 play:)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 146 284 159 223 160 165 131 106 136 88 189 0 189
					yourself:
				)
		)
		(theGround init:)
		(SL enable:)
		(= local47 (== gPrevRoomNum 141))
		(if (and (IsFlag 170) (not local47) (not (IsFlag 215)))
			(self horizon: 130)
		)
		(if (not gNight)
			(rguardTeller init: rGuard @local19 @local27 @local36)
			(rGuard init: actions: rguardTeller stopUpd:)
			(guardTeller init: lGuard @local0 @local8 @local17)
			(lGuard init: actions: guardTeller stopUpd:)
		)
		(lDoor init: stopUpd:)
		(rDoor init: stopUpd:)
		(= local48 (gEgo x:))
		(gEgo actions: egoActions posn: 163 260 setScript: egoEnters init:)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(= temp0 (gEgo onControl: 1))
					(not (== temp0 1))
					(& temp0 $007e)
					(not (gEgo script:))
					(not (gCurRoom script:))
				)
				(= local50 temp0)
				(gCurRoom setScript: doTheSteps)
			)
			((and (not (gEgo script:)) (gEgo edgeHit:))
				(gEgo setScript: egoExits)
			)
			(else 0)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; openSpell
				(gCurRoom setScript: doTheOpen)
			)
			(1 ; Look
				(gMessager say: 8 1 0) ; "This is the central keep of Baron Stefan von Spielburg's castle. The castle grounds look like no one has taken care of them. The castle is still impressive close up, but it looks rather dirty."
			)
			(4 ; Do
				(gMessager say: 8 4 0) ; "The castle walls are very high. You judge that you would not be able to climb them."
			)
			(52 ; Sleep
				(gCurRoom setScript: sleepAround)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 0) ; "So you says to yourself, "Self," you says..."
			)
			(4 ; Do
				(gMessager say: 1 4 0) ; "You straighten out your cape so that you can make a good impression at the castle."
			)
			(else
				(return 0)
			)
		)
	)
)

(instance theGround of Feature
	(properties
		x 209
		y 180
		noun 9
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 9 1 0) ; "The ground is almost bare here due to the pacing of so many guards."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lGuard of Actor
	(properties
		x 89
		y 146
		noun 3
		view 41
		illegalBits 0
	)

	(method (doit)
		(if (or (not (IsFlag 170)) (IsFlag 215))
			(if
				(and
					(not (== gPrevRoomNum 141))
					(not local46)
					(< (gEgo y:) 142)
					(< 99 (gEgo x:) 209)
				)
				(= local46 1)
				(= local41 12)
				(lGuard setScript: lGuardTalks 0 0)
			)
			(if
				(or
					(< (gEgo x:) 78)
					(< 228 (gEgo x:))
					(> (gEgo y:) 155)
				)
				(= local46 0)
			)
		)
		(super doit:)
	)
)

(instance guardTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1) ; "The guards look to be middle-aged, but in good physical condition. Their clothing is faded and patched. Even the horns look dull."
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(81 ; flameDartSpell
				(gMessager say: 7 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(20 ; rock
				(EgoDead 92 93 0 3 39) ; "No sooner do you draw your weapon than the guards have their weapons out and quickly disarm you. They promptly drag you into the castle and down into the dungeon, which is not a very likely spot for the attainment of hero status."
			)
			(16 ; dagger
				(EgoDead 92 93 0 3 39) ; "No sooner do you draw your weapon than the guards have their weapons out and quickly disarm you. They promptly drag you into the castle and down into the dungeon, which is not a very likely spot for the attainment of hero status."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance rGuard of Actor
	(properties
		x 191
		y 133
		noun 5
		view 41
		loop 1
		illegalBits 0
	)

	(method (doit)
		(if (or (not (IsFlag 170)) (IsFlag 215))
			(if
				(and
					(not (== gPrevRoomNum 141))
					(< (gEgo x:) 78)
					(< 208 (gEgo x:))
					(> (gEgo y:) 141)
				)
				(= local45 0)
			)
			(if local40
				(-- local40)
			)
		)
		(super doit:)
	)
)

(instance rguardTeller of Teller
	(properties)

	(method (doChild)
		(if (== query -11)
			(= local52 1)
		else
			(super doChild: query)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 0) ; "The guard is dressed in worn, but neatly patched, clothing. He has obviously spent a lot of time maintaining that magnificent mustache. (But you'd better not mention his bald spot.)"
			)
			(2 ; Talk
				(if (== local52 1)
					(gMessager say: 5 2 14 1) ; "I'm not talking to you."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 7 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(20 ; rock
				(EgoDead 92 93 0 3 39) ; "No sooner do you draw your weapon than the guards have their weapons out and quickly disarm you. They promptly drag you into the castle and down into the dungeon, which is not a very likely spot for the attainment of hero status."
			)
			(16 ; dagger
				(EgoDead 92 93 0 3 39) ; "No sooner do you draw your weapon than the guards have their weapons out and quickly disarm you. They promptly drag you into the castle and down into the dungeon, which is not a very likely spot for the attainment of hero status."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance lHead of Prop
	(properties
		x 87
		y 146
		z 41
		noun 3
		view 41
		loop 2
	)
)

(instance rHead of Prop
	(properties
		x 193
		y 133
		z 41
		noun 6
		view 41
		loop 5
	)
)

(instance lDoor of Prop
	(properties
		x 92
		y 53
		noun 2
		view 41
		loop 3
		cycleSpeed 12
	)

	(method (init)
		(if (== gPrevRoomNum 141)
			(self cel: 3 setPri: 2 ignoreActors:)
		else
			(self setPri: 2 cel: 0)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 2 1 2) ; "The doors are securely locked for the night."
				else
					(gMessager say: 2 1 1) ; "The doors are guarded by Frederick and Pierre. (You can tell by their nametags.)"
				)
			)
			(4 ; Do
				(gMessager say: 2 17 2) ; "The doors are securely locked and barred from the inside."
			)
			(17 ; lockPick
				(if gNight
					(gMessager say: 2 17 2) ; "The doors are securely locked and barred from the inside."
				else
					(gMessager say: 2 17 2) ; "The doors are securely locked and barred from the inside."
				)
			)
			(18 ; thiefKit
				(if gNight
					(gMessager say: 2 18 2) ; "The doors are securely locked and barred from the inside."
				else
					(gMessager say: 2 18 1) ; "That's not too bright an idea while the guards are watching."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rDoor of Prop
	(properties
		x 163
		y 52
		view 41
		loop 4
		cycleSpeed 12
	)

	(method (init)
		(if (== gPrevRoomNum 141)
			(self cel: 3 setPri: 2 ignoreActors:)
		else
			(self setPri: 2 cel: 0)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(lDoor doVerb: theVerb &rest)
	)
)

(instance light of Prop
	(properties
		x 129
		y 68
		noun 4
		view 41
		loop 6
	)
)

(instance leaveHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(light init: setPri: 1 setCycle: Fwd)
				(gEgo
					ignoreActors: 1
					posn: 126 126
					setMotion: MoveTo 144 139 self
				)
			)
			(1
				(NormalEgo)
				(= ticks 30)
			)
			(2
				(gMessager say: 8 0 16 1 self) ; "After a wonderful meal with the Baron and his son, a peaceful night's sleep in a featherdown bed, and a filling breakfast in bed, you are ready to go adventuring once more."
			)
			(3
				(lDoor setCycle: Beg self)
				(rDoor setCycle: Beg self)
			)
			(4)
			(5
				(doorSnd number: 84 play:)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(light setCycle: 0 stopUpd: dispose:)
				(lDoor ignoreActors: 0)
				(rDoor ignoreActors: 0)
				(SetFlag 215)
				(= local47 0)
				(client setScript: 0)
			)
		)
	)
)

(instance sleepAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 52 0 1 self) ; "You barely get to sleep when the guard on night patrol kicks you out."
			)
			(1
				(if (< 750 gClock 2550)
					(FixTime 21)
				)
				(= seconds 3)
			)
			(2
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance doorSnd of Sound
	(properties)
)

(instance doTheSteps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(switch local50
					(2
						(gEgo setMotion: PolyPath 250 162 self)
					)
					(4
						(gEgo setMotion: PolyPath 195 187 self)
					)
					(8
						(gEgo
							setLoop: 2
							setMotion: PolyPath (gEgo x:) 187 self
						)
					)
					(16
						(gEgo setMotion: PolyPath 171 138 self)
					)
					(32
						(gEgo setMotion: PolyPath 149 137 self)
					)
					(64
						(gEgo
							setLoop: 3
							setMotion: PolyPath (+ (gEgo x:) 5) 147 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (not (lGuard script:))
					(HandsOn)
				)
				(NormalEgo)
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
				(NormalEgo)
				(HandsOff)
				(= ticks 10)
			)
			(1
				(switch gPrevRoomNum
					(38
						(gEgo posn: 18 240 setMotion: MoveTo 200 187 self)
					)
					(39
						(if
							(and
								(not gNight)
								(IsFlag 170)
								(not (IsFlag 215))
							)
							(gEgo
								posn: 160 240
								setMotion: MoveTo 160 178 self
							)
						else
							(gEgo posn: local48 240)
							(cond
								((< local48 10)
									(gEgo
										setMotion:
											MoveTo
											(+ local48 25 self)
											185
									)
								)
								((> local48 310)
									(gEgo
										setMotion:
											MoveTo
											(- local48 25)
											185
											self
									)
								)
								(else
									(gEgo setMotion: MoveTo local48 185 self)
								)
							)
						)
					)
					(40
						(gEgo setMotion: MoveTo 220 185 self)
					)
					(141
						(gEgo setScript: leaveHall)
					)
					(else
						(gEgo setMotion: MoveTo 160 187 self)
					)
				)
			)
			(2
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 1) (- (gEgo y:) 1) self
				)
			)
			(3
				(if (not gNight)
					(if (and (IsFlag 170) (not local47) (not (IsFlag 215)))
						(gLongSong prevSignal: 0)
						(gEgo setScript: GuardsTrumpet self)
					else
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(4
				(HandsOn)
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
				(HandsOff)
				(= ticks 10)
			)
			(1
				(switch (gEgo edgeHit:)
					(EDGE_RIGHT
						(gEgo setMotion: MoveTo 340 (+ (gEgo y:) 10) self)
					)
					(EDGE_BOTTOM
						(gEgo setMotion: MoveTo (gEgo x:) 240 self)
					)
					(EDGE_LEFT
						(gEgo setMotion: MoveTo -20 (gEgo y:) self)
					)
				)
			)
			(2
				(switch (gEgo edgeHit:)
					(EDGE_RIGHT
						(gCurRoom newRoom: 40)
					)
					(EDGE_BOTTOM
						(gCurRoom newRoom: 39)
					)
					(EDGE_LEFT
						(gCurRoom newRoom: 38)
					)
				)
			)
		)
	)
)

(instance guardsGreet of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (== (gLongSong prevSignal:) 10) (== (gLongSong prevSignal:) 20))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(= ticks 10)
			)
			(1
				(light init: setPri: 1)
				(lGuard cycleSpeed: 6 setCycle: End self)
			)
			(2
				(lGuard stopUpd:)
				(gLongSong number: 96 loop: -1 priority: 5 play:)
			)
			(3
				(rGuard cycleSpeed: 6 setCycle: End self)
			)
			(4
				(rGuard stopUpd:)
			)
			(5
				(gLongSong pause: 1)
				(lGuard setCycle: Beg)
				(rGuard setCycle: Beg self)
			)
			(6
				(lGuard stopUpd:)
				(rGuard stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance GuardsTrumpet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gGame setCursor: gWaitCursor)
				(self setScript: guardsGreet self)
			)
			(2
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(gLongSong pause: 0)
				(gMessager say: 8 0 15 1 self) ; "The Baron von Spielburg and the Baronet await you in the great hall."
			)
			(3
				(light setCycle: Fwd)
				(lDoor setCycle: End self)
				(rDoor setCycle: End self)
				(doorSnd number: 90 loop: 1 play:)
			)
			(4)
			(5
				(doorSnd stop:)
				(lDoor stopUpd:)
				(rDoor stopUpd:)
				(= seconds 2)
			)
			(6
				(gEgo setMotion: MoveTo 178 174 self)
			)
			(7
				(gEgo setLoop: 7 setMotion: MoveTo 168 153 self)
			)
			(8
				(gEgo setLoop: -1 setMotion: MoveTo 111 111 self)
			)
			(9
				(gCurRoom newRoom: 141)
			)
		)
	)
)

(instance lGuardTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gUser canInput: 0)
				(gUser canControl: 0)
				(if
					(and
						(not local45)
						(< (gEgo y:) 140)
						(< 99 (gEgo x:) 209)
					)
					(HandsOff)
					(= local45 1)
					(= local42 13)
					(client setScript: rGuardTalks)
				else
					(if (not local51)
						(HandsOff)
						(lHead init: setCycle: Fwd)
					)
					(= ticks 50)
				)
			)
			(2
				(HandsOff)
				(if (not local51)
					(switch register
						(0
							(HandsOff)
							(gMessager say: 8 0 17 1 self) ; "No one enters the castle without the Baron's permission."
						)
						(1
							(HandsOff)
							(gMessager say: 8 0 18 1 self) ; "I'm Frederick."
						)
					)
				else
					(HandsOff)
					(self cue:)
				)
				(= local51 1)
			)
			(3
				(lHead setCycle: 0 dispose:)
				(gUser canInput: 1)
				(gUser canControl: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rGuardTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(HandsOff)
				(gUser canInput: 0)
				(gUser canControl: 0)
				(rHead init: setCycle: Fwd)
				(= ticks 50)
			)
			(2
				(switch register
					(0
						(gMessager say: 8 0 19 1 self) ; "No one enters the castle without the Baron's permission."
					)
					(1
						(gMessager say: 8 0 18 1 self) ; "I'm Frederick."
					)
				)
			)
			(3
				(rHead setCycle: 0 dispose:)
				(gUser canInput: 1)
				(gUser canControl: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doTheOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: PolyPath 250 172 self)
			)
			(2
				(= seconds 1)
			)
			(3
				(gGame setCursor: gWaitCursor 1)
				(gEgo setMotion: 0 setHeading: 270 self)
			)
			(4
				(gEgo
					view: 521
					setLoop: 0
					setCel: 0
					setPri: (gEgo priority:)
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(5
				((= local53 (Sound new:)) number: 28 priority: 6 init: play:)
				(gEgo setCycle: End self)
			)
			(6
				(local53 stop: dispose:)
				(gEgo view: 4 loop: 7 setCel: 0)
				(= ticks 20)
			)
			(7
				(if gNight
					(gMessager say: 2 17 2 1 self) ; "The doors are securely locked and barred from the inside."
				else
					(gMessager say: 2 1 1 1 self) ; "The doors are guarded by Frederick and Pierre. (You can tell by their nametags.)"
				)
			)
			(8
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

