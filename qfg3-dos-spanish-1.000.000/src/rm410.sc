;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm410 0
)

(local
	[local0 5] = [0 -10 -13 -15 999]
	[local5 6] = [0 59 60 58 57 999]
	[local11 7] = [0 13 -10 -14 14 15 999]
	[local18 4] = [0 16 12 999]
	[local22 4] = [0 17 18 999]
	[local26 4] = [0 12 -19 999]
	[local30 3] = [0 20 999]
	[local33 7]
	[local40 2]
	[local42 2]
	[local44 5] = [0 -10 -14 -19 999]
	[local49 6] = [0 -1 27 10 37 999]
	[local55 5] = [0 21 3 -4 999]
	[local60 5] = [0 5 6 -7 999]
	[local65 3] = [0 8 999]
	[local68 5] = [0 -1 -4 -7 999]
	[local73 6] = [0 -1 27 28 26 999]
	[local79 4] = [0 -21 52 999]
	[local83 4] = [0 -23 -24 999]
	[local87 3] = [0 22 999]
	[local90 3] = [0 25 999]
	[local93 6] = [0 -1 -21 -23 -24 999]
	[local99 6] = [0 -30 34 32 38 999]
	[local105 4] = [0 35 -39 999]
	[local109 3] = [0 40 999]
	[local112 4] = [0 -30 -39 999]
	[local116 6] = [0 30 -34 -32 31 999]
	[local122 4] = [0 35 36 999]
	[local126 3] = [0 33 999]
	[local129 4] = [0 -34 -32 999]
	[local133 5] = [0 42 43 44 999]
	[local138 5] = [0 42 -46 45 999]
	[local143 3] = [0 47 999]
	[local146 3] = [0 -46 999]
	[local149 6] = [0 -13 51 52 53 999]
	[local155 4] = [0 49 50 999]
	[local159 3] = [0 -13 999]
	[local162 3]
	local165
	local166
	local167
	local168
	local169
	local170
	local171
	local172
	local173
)

(procedure (localproc_0 param1)
	(cond
		(local171
			(gMessager say: 1 6 41 0 param1) ; "That be big initiation Yesufu and you do. Much honor to you both."
		)
		(local172
			(gMessager say: 2 6 41 0 param1) ; "Hujambo, bwana. You did very well against the thorn wall in the initiation contest."
		)
		(local169
			(gMessager say: 1 6 29 0 param1) ; "Habari, bwana. So the Leopardman turn out to be the Leopard Lady? Maybe somebody take the lady for a wife now."
		)
		(local170
			(gMessager say: 2 6 29 0 param1) ; "You have broken the spell on the Leopardman, I have heard. She be one fine looking woman. Maybe you make her your wife?"
		)
		(local168
			(gMessager say: 2 6 1 0 param1) ; "Hujambo, bwana. Have you yet seen the prisoner that our warriors have caught?"
		)
		(local167
			(gMessager say: 1 6 1 0 param1) ; "Habari, bwana. Have you heard the news of the village? A prisoner has been captured!"
		)
		(local165
			(gMessager say: 2 6 9 0 param1) ; "Hujambo, bwana."
		)
		(else
			(gMessager say: 1 6 9 0 param1) ; "Habari, bwana."
		)
	)
)

(instance rm410 of Rm
	(properties
		noun 6
		picture 410
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 237 189 132 171 90 148 69 142 69 153 27 153 27 129 0 129
					yourself:
				)
		)
		(Load rsMESSAGE 410)
		(= local165 gNight)
		(= [local40 0] @local5)
		(egoTell init: gEgo @local5 @local40)
		(leftTreeTop init:)
		(leftTreeTrunk init:)
		(rightTreeTop init:)
		(rightTreeTrunk init:)
		(rightTreeBot init:)
		(pens init:)
		(bridge init:)
		(village init:)
		(outCrop init:)
		(super init:)
		(if (not (IsFlag 18))
			((ScriptID 58 1) ; Elder
				noun: (if local165 2 else 1)
				setScale:
				scaleX: 102
				scaleY: 102
				loop: 0
				x: 48
				y: 150
				init:
			)
			(if (IsFlag 29)
				(= local166 1)
			)
			(switch gBaseHeroType
				(0 ; Fighter
					(if (and (not (IsFlag 29)) (IsFlag 64))
						(= local166 1)
					)
				)
				(1 ; Magic User
					(if
						(and
							(not (IsFlag 29))
							(or (gEgo has: 44) [gEgoStats 31]) ; theWood, summonStaffSpell
						)
						(= local166 1)
					)
				)
				(2 ; Thief
					(if (and (not (IsFlag 29)) (IsFlag 63))
						(= local166 1)
					)
				)
			)
			(if (and local166 (not (IsFlag 68)) local165)
				(SetFlag 68)
				(= local168 1)
			)
			(if (and local166 (not (IsFlag 67)) (not local165))
				(SetFlag 67)
				(= local167 1)
			)
			(if (and (IsFlag 38) (not (IsFlag 70)) (not local165))
				(SetFlag 70)
				(= local169 1)
			)
			(if (and (IsFlag 38) (not (IsFlag 71)) local165)
				(SetFlag 71)
				(= local170 1)
			)
			(if (and global406 (not (IsFlag 72)) (not local165))
				(SetFlag 72)
				(= local171 1)
			)
			(if (and global406 (not (IsFlag 73)) local165)
				(SetFlag 73)
				(= local172 1)
			)
			(cond
				(local171
					(= [local33 0] @local133)
					(elderTell init: (ScriptID 58 1) @local133 @local33) ; Elder
				)
				(local172
					(= [local33 0] @local138)
					(= [local33 1] @local143)
					(elderTell init: (ScriptID 58 1) @local138 @local33 @local146) ; Elder
				)
				(local169
					(= [local33 0] @local99)
					(= [local33 1] @local105)
					(= [local33 2] @local109)
					(elderTell init: (ScriptID 58 1) @local99 @local33 @local112) ; Elder
				)
				(local170
					(= [local33 0] @local116)
					(= [local33 1] @local122)
					(= [local33 2] @local126)
					(elderTell init: (ScriptID 58 1) @local116 @local33 @local129) ; Elder
				)
				(local167
					(= [local33 0] @local49)
					(= [local33 1] @local55)
					(= [local33 2] @local60)
					(= [local33 3] @local65)
					(elderTell init: (ScriptID 58 1) @local49 @local33 @local68) ; Elder
				)
				(local168
					(= [local33 0] @local73)
					(= [local33 1] @local79)
					(= [local33 2] @local83)
					(= [local33 3] @local87)
					(= [local33 4] @local90)
					(elderTell init: (ScriptID 58 1) @local73 @local33 @local93) ; Elder
				)
				(local165
					(= [local33 0] @local11)
					(= [local33 1] @local22)
					(= [local33 2] @local26)
					(= [local33 3] @local30)
					(elderTell init: (ScriptID 58 1) @local11 @local33 @local44) ; Elder
				)
				(else
					(= [local33 0] @local11)
					(= [local33 1] @local18)
					(elderTell init: (ScriptID 58 1) @local11 @local33 @local44) ; Elder
				)
			)
			(if local165
				((ScriptID 58 0) view: 416) ; elderTalker
				((ScriptID 58 2) view: 416 nsLeft: 45 nsTop: 38) ; elderBust
				((ScriptID 58 4) view: 416 nsLeft: 41 nsTop: 30) ; elderEyes
				((ScriptID 58 3) view: 416 nsLeft: 45 nsTop: 38) ; elderMouth
			)
		)
		(if (== gPrevRoomNum 420)
			(gEgo
				normalize:
				noun: 4
				x: 120
				y: 200
				setScale:
				scaleX: 102
				scaleY: 102
				init:
			)
		else
			(gEgo
				normalize:
				noun: 4
				x: -10
				y: 180
				setScale:
				scaleX: 102
				scaleY: 102
				init:
			)
		)
		(if (not (IsFlag 86))
			(= [local42 0] @local0)
			(rakeeshTell init: (ScriptID 35 1) @local0 @local42) ; Rakeesh
			((ScriptID 35 1) ; Rakeesh
				x: -10
				y: 160
				setScale:
				scaleX: 102
				scaleY: 102
				noun: 5
				actions: rakeeshTell
				init:
				setCycle: StopWalk 962
				setMotion: PolyPath 15 160
			)
		)
		(if (!= (gLongSong number:) 160)
			(gLongSong number: 160 setLoop: -1 play: 127)
		)
		(gLongSong hold: 0)
		(gWalkHandler addToFront: village)
		(cond
			((== gPrevRoomNum 420)
				(self setScript: enterFromVillage)
			)
			((IsFlag 18)
				(self setScript: postConf)
			)
			((not (IsFlag 86))
				(self setScript: enterWRakeesh)
			)
			(else
				(self setScript: enterRoom)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((<= (gEgo x:) 10)
				(self setScript: exitToMap)
			)
			((>= (gEgo y:) 178)
				(if (IsFlag 18)
					(self setScript: subHonor)
				else
					(self setScript: walkOut)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(gWalkHandler delete: village)
		(LoadMany 0 35 34 58)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(egoTell doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				59
				(and (IsFlag 86) (not local165) (not (IsFlag 18)))
				58
				(and (IsFlag 86) (not local165) (not (IsFlag 18)))
				60
				(and local165 (not (IsFlag 18)))
				57
				(and local165 (not (IsFlag 18)))
				-61
				(not (IsFlag 86))
				-62
				(not (IsFlag 86))
				55
				(IsFlag 18)
				56
				(IsFlag 18)
				-54
				(IsFlag 18)
		)
	)

	(method (doChild)
		(switch query
			(-54
				(if (not local173)
					(++ local173)
					(gEgo addHonor: 30)
				)
			)
			(-62
				(gMessager say: 4 5 62) ; "You say good-bye."
				(gCurRoom setScript: goToVillage)
				(return 0)
			)
			(-61
				(gMessager say: 4 5 61) ; "You say hello to the Elder."
				(gCurRoom setScript: goToVillage)
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gMessager say: 5 6 63) ; "Please wait my friend, perhaps we can learn more from Elder Mngoje."
				(gCurRoom setScript: goToVillage)
				((User curEvent:) claimed: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elderTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -14 local165 14 (not local165))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not (IsFlag 86))
					(gCurRoom setScript: goToVillage)
					(super doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(3 ; Walk
				((User curEvent:) claimed: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rakeeshTell of Teller
	(properties)

	(method (doChild)
		(switch query
			(-10 ; "Simbani"
				(gMessager say: 5 5 10) ; "The Simbani live with their cattle upon the plains of the savanna. They are a brave people and wise. The Simbani have been the friend of Tarna for many generations."
				(gCurRoom setScript: goToVillage)
				(return 0)
			)
			(-13 ; "Village"
				(gMessager say: 5 5 13) ; "This is the village where Uhura was born. The Laibon, the leader of the tribe, is an excellent chief, and guides his people well."
				(gCurRoom setScript: goToVillage)
				(return 0)
			)
			(-15 ; "Elder"
				(gMessager say: 5 5 15) ; "The Elders of the Simbani are the teachers and counselors of the tribe."
				(gCurRoom setScript: goToVillage)
				(return 0)
			)
		)
	)
)

(instance uhuraTell of Teller
	(properties)
)

(instance goToVillage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 58 1) loop: 2 cel: 0 setCycle: End self) ; Elder
			)
			(1
				(gMessager say: 1 6 13 0 self) ; "Behold the village of the Simbani. From the pen where the injured cattle stay, the huts where we sleep, and the places where we work and play, enter and be welcome."
			)
			(2
				(gEgo setMotion: PolyPath 129 200 self)
				((ScriptID 35 1) setMotion: PolyPath 125 190) ; Rakeesh
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0 9)
				(= cycles 12)
			)
			(4
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance enterWRakeesh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 86)
				(gEgo setMotion: PolyPath 55 170 self)
			)
			(1
				(Face gEgo (ScriptID 58 1) self) ; Elder
			)
			(2
				((ScriptID 58 1) setCycle: End self) ; Elder
			)
			(3
				((ScriptID 58 1) cel: 0 loop: 1 setCycle: End self) ; Elder
			)
			(4
				(gMessager say: 5 6 9 0 self) ; "Habari, Mzee Mngoje."
			)
			(5
				(HandsOn)
				(gWalkHandler addToFront: gCurRoom)
				(= seconds 5)
			)
			(6
				(gWalkHandler delete: gCurRoom)
				(client setScript: goToVillage self)
			)
		)
	)
)

(instance exitToMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance enterFromVillage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 90 165 self)
			)
			(1
				((ScriptID 58 1) setCycle: End self) ; Elder
			)
			(2
				((ScriptID 58 1) cel: 0 loop: 1 setCycle: End self) ; Elder
			)
			(3
				(localproc_0 self)
			)
			(4
				(HandsOn)
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
				(HandsOff)
				(gEgo setMotion: PolyPath 129 200 self)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 65 160 self)
			)
			(1
				(gEgo setHeading: 345)
				(= cycles 18)
			)
			(2
				((ScriptID 58 1) setCycle: End self) ; Elder
			)
			(3
				((ScriptID 58 1) cel: 0 loop: 1 setCycle: End self) ; Elder
			)
			(4
				(localproc_0 self)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance postConf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [local162 0] @local149)
				(= [local162 1] @local155)
				(uhuraTell init: (ScriptID 34 1) @local149 @local162 @local159) ; Uhura
				((ScriptID 34 1) ; Uhura
					setScale: 220
					x: 90
					y: 160
					setHeading: 270
					noun: 3
					init:
				)
				(gEgo setMotion: PolyPath 50 150 self)
			)
			(1
				(gMessager say: 3 6 9) ; "Habari, Bringer of Spear. The peace conference did not bring much peace, did it?"
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance subHonor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(gMessager say: 3 6 48) ; "News in the Savanna runs fast, and already the village be in mourning for the Laibon. The gates are closed to all outsiders. You are again an outsider, my friend."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
					addHonor: -20
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leftTreeTop of Feature
	(properties
		x 58
		y 28
		noun 11
		nsTop -2
		nsBottom 59
		nsRight 117
		sightAngle 180
	)
)

(instance leftTreeTrunk of Feature
	(properties
		x 20
		y 93
		noun 12
		nsTop 57
		nsBottom 129
		nsRight 41
		sightAngle 180
	)
)

(instance rightTreeTop of Feature
	(properties
		x 261
		y 29
		noun 13
		nsLeft 203
		nsBottom 58
		nsRight 319
		sightAngle 180
	)
)

(instance rightTreeTrunk of Feature
	(properties
		x 302
		y 124
		noun 14
		nsTop 59
		nsLeft 285
		nsBottom 189
		nsRight 319
		sightAngle 180
	)
)

(instance rightTreeBot of Feature
	(properties
		x 236
		y 168
		noun 15
		nsTop 148
		nsLeft 186
		nsBottom 189
		nsRight 286
		sightAngle 180
	)
)

(instance pens of Feature
	(properties
		x 77
		y 70
		noun 7
		nsTop 60
		nsLeft 33
		nsBottom 81
		nsRight 122
		sightAngle 180
	)
)

(instance bridge of Feature
	(properties
		x 269
		y 93
		noun 8
		nsTop 83
		nsLeft 256
		nsBottom 104
		nsRight 283
		sightAngle 180
	)
)

(instance village of Feature
	(properties
		x 163
		y 59
		noun 10
		nsTop 58
		nsLeft 24
		nsBottom 134
		nsRight 303
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gWalkHandler contains: gCurRoom)
						(super doVerb: 3)
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: walkOut)
						((User curEvent:) claimed: 1)
					)
					(else
						(super doVerb: 3)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance outCrop of Feature
	(properties
		x 117
		y 129
		noun 9
		nsTop 128
		nsBottom 189
		nsRight 234
		sightAngle 180
	)
)

