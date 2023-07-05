;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm430 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 160
	local6 = 130
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	[local14 12] = [0 50 -30 5 -53 -51 4 -31 -20 -15 -23 999]
	[local26 2]
	[local28 6] = [0 -61 -54 -12 -58 999]
	[local34 4] = [0 -3 -24 999]
	[local38 3] = [0 -62 999]
	[local41 3] = [0 2 999]
	[local44 4] = [0 -60 -7 999]
	[local48 3] = [0 6 999]
	[local51 3] = [0 -56 999]
	[local54 3] = [0 9 999]
	[local57 3] = [0 -16 999]
	[local60 3] = [0 -17 999]
	[local63 4] = [0 -59 -18 999]
	[local67 3] = [0 -21 999]
	[local70 3] = [0 19 999]
	[local73 3] = [0 22 999]
	[local76 3] = [0 -57 999]
	[local79 3] = [0 14 999]
	[local82 5] = [0 -26 29 -25 999]
	[local87 3] = [0 -27 999]
	[local90 3] = [0 28 999]
	[local93 20] = [0 -61 -54 -12 -58 -3 -24 -62 -60 -7 -56 -16 -17 -59 -18 -21 -57 -26 -27 999]
	[local113 20]
	[local133 7] = [0 -34 -3 -37 -38 -19 999]
	[local140 4] = [0 -35 -6 999]
	[local144 3] = [0 -36 999]
	[local147 4] = [0 -34 -6 999]
	[local151 4]
)

(procedure (localproc_0 param1)
	(return (* 2 (/ (+ (* param1 800) (- local3 1)) local3)))
)

(procedure (localproc_1)
	(return
		(and
			(not (gCast contains: (ScriptID 35 1))) ; Rakeesh
			(not local7)
			(not local9)
		)
	)
)

(instance rm430 of Rm
	(properties
		noun 4
		picture 430
		vanishingY -300
	)

	(method (init)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 263 117 219 117 172 106 175 98 141 98 131 91 64 91 64 153 101 139 116 128 168 128 199 128 199 165 183 189 263 189
					yourself:
				)
		)
		(mat approachVerbs: 4 init:) ; Do
		(gLongSong setLoop: -1 changeTo: 430)
		(gLongSong3 number: 913 setLoop: -1 play:)
		(fire setCycle: Fwd init:)
		(shield init:)
		(zebra init:)
		(leftbed init:)
		(rightbed init:)
		(wall init:)
		(fireplace init:)
		(basket init:)
		(log init:)
		(= [local26 0] @local14)
		(egoActions init: gEgo @local14 @local26)
		(if (not (== gPrevRoomNum 440))
			(gWalkHandler addToFront: gCurRoom)
		)
		(cond
			((== gPrevRoomNum 440)
				(gCurRoom setScript: firstTime)
			)
			((IsFlag 118)
				(self style: 8)
				(gCurRoom setScript: afterStory)
			)
			(else
				(gCurRoom setScript: enterRoom)
			)
		)
		(chestLid approachVerbs: 4 58 init: stopUpd:) ; Do, ???
		(chest approachVerbs: 4 58 init:) ; Do, ???
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(74 ; Sleep
				(if (gCast contains: (ScriptID 34 1)) ; Uhura
					(self setScript: uhuraGoodNight 0 0)
				else
					(self setScript: goToBed)
				)
			)
			(3 ; Walk
				(egoActions doVerb: 3)
			)
			(84 ; levitateSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 28)
						((ScriptID 31 0) ; leviCode
							init: (gEgo x:) (+ (gEgo y:) 1) 20
						)
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(82 ; fetchSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 26)
						(self setScript: (ScriptID 37 0)) ; castFetchScript
						(return 1)
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(81 ; flameDartSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 25)
						(self setScript: (ScriptID 32 0) self 81) ; project
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(83 ; forceBoltSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 27)
						(self setScript: (ScriptID 32 0) self 83) ; project
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(75 ; openSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 19)
						(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
						(gEgo setScript: (ScriptID 13) 0 chest) ; castOpenScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(88 ; lightningBallSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 32)
						(self setScript: (ScriptID 32 0) self 88) ; project
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(80 ; calmSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 24)
						(gEgo setScript: (ScriptID 12 0) 0 80) ; castAreaScript
						(super doVerb: 80)
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(86 ; jugglingLightsSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 30)
						(gEgo setScript: (ScriptID 62 0)) ; castJuggle
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(78 ; dazzleSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 22)
						(gEgo setScript: (ScriptID 12 0) 0 78) ; castAreaScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(76 ; detectMagicSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 20)
						(gEgo setScript: (ScriptID 12 0) 0 76) ; castAreaScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(77 ; triggerSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 21)
						(gEgo setScript: (ScriptID 12 0) 0 77) ; castAreaScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(85 ; reversalSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 29)
						(self setScript: (ScriptID 12 0) 0 85) ; castAreaScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(87 ; summonStaffSpell
				(if (localproc_1)
					(gEgo addHonor: -5)
					(if (gEgo castSpell: 31)
						(gEgo setScript: (ScriptID 46 0)) ; staffScript
					)
				else
					(gMessager say: 9 6 45 0 0) ; "It is not a good idea to use magic in the Simbani village."
				)
			)
			(-77 ; triggerSpell
				(gMessager say: 0 0 2 1 0 12) ; "Nothing seems to have been triggered."
			)
			(-76 ; detectMagicSpell
				(gMessager say: 0 0 1 1 0 12) ; "You sense no magic in this area."
			)
			(-80 ; calmSpell
				(gMessager say: 0 0 4 1 0 12) ; "A feeling of peace and tranquility fills the area."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			((and (GameIsRestarting) (== (gEgo view:) 40))
				(= local0 1)
			)
			((gCurRoom script:) 0)
			((and (gEgo mover:) (== (gEgo view:) 40))
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo setMotion: 0 setScript: egoGetUp)
			)
			((and (> (gEgo y:) 155) (> (gEgo x:) 170))
				(gCurRoom setScript: exitRoom)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gLongSong2 stop:)
		(gLongSong3 stop:)
		(gWalkHandler delete: gCurRoom)
		(LoadMany 0 29 34 35)
		(super dispose:)
	)
)

(instance egoActions of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				50 ; "Greet"
				(gCast contains: (ScriptID 35 1)) ; Rakeesh
				-30 ; "Say Good-night"
				(gCast contains: (ScriptID 35 1)) ; Rakeesh
				5 ; "Tell about day"
				(gCast contains: (ScriptID 35 1)) ; Rakeesh
				-53 ; "Say Yes"
				(and (not local8) local7)
				-51 ; "Say No"
				(and (not local8) local7)
				4 ; "Greet"
				(or (and (not local12) local7) local9)
				-31 ; "Say Good-night"
				(or (and (not local12) local7) local9)
				-20 ; "Greet"
				(localproc_1)
				-15 ; "Say Good-night"
				(and gNight (localproc_1))
				-23 ; "Tell about day"
				(localproc_1)
		)
	)

	(method (doChild)
		(switch query
			(-53 ; "Say Yes"
				(= local8 1)
				(HandsOff)
				(gMessager say: 2 5 53 0) ; "You invite Uhura into your hut."
				(gCurRoom setScript: walkUhuraIn)
				(return 0)
			)
			(-51 ; "Say No"
				(= local8 1)
				(= local12 1)
				(return 1)
			)
			(-31 ; "Say Good-night"
				(= local8 1)
				(gMessager say: 2 5 31) ; "You say good-night."
				(gCurRoom setScript: uhuraGoodNight 0 1)
				(return 0)
			)
			(-20 ; "Greet"
				(= query 13)
				(return 1)
			)
			(-15 ; "Say Good-night"
				(= query 13)
				(return 1)
			)
			(-23 ; "Tell about day"
				(= query 13)
				(return 1)
			)
			(-30 ; "Say Good-night"
				(gMessager say: 2 5 30) ; "You say good-night."
				(gCurRoom doVerb: 74)
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gCurRoom script:) 0)
					((== (gEgo view:) 40)
						(= local5 ((User curEvent:) x:))
						(= local6 ((User curEvent:) y:))
						(gCurRoom setScript: egoGetUp)
						(return 1)
					)
				)
			)
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

(instance rakeeshTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -24 (== gBaseHeroType 1) 2 (== gBaseHeroType 1)) ; "Trust", Magic User, "Magic", Magic User
	)

	(method (doChild)
		(if (== query -25) ; "Trust"
			(gCurRoom setScript: checkForMagic)
			(return 0)
		else
			(super doChild: &rest)
		)
	)
)

(instance uhuraTell of Teller
	(properties)

	(method (doChild)
		(switch query
			(-34
				(|= local2 $0001)
				(super doChild: query)
			)
			(-3 ; "War"
				(|= local2 $0002)
				(return 1)
			)
			(-37
				(|= local2 $0004)
				(return 1)
			)
			(-38
				(|= local2 $0008)
				(return 1)
			)
			(-19 ; "Simba"
				(|= local2 $0010)
				(return 1)
			)
			(-35
				(|= local2 $0020)
				(return 1)
			)
			(-36
				(|= local2 $0040)
				(return 1)
			)
			(-6 ; "Magic"
				(|= local2 $0080)
				(super doChild: query)
			)
		)
		(return (= local11 1))
	)
)

(instance checkForMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 5 25 1 self) ; "The longer you stay here, the more the Simbani and the Laibon will learn to respect you."
			)
			(1
				(if [gEgoStats 12] ; magic use
					(gMessager say: 1 5 25 2 self) ; "However, do not use magic before the Simbani. They distrust and fear magic."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance afterStory of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 31)
				(gEgo
					view: 0
					setLoop: 0
					x: 102
					y: 106
					setScale:
					scaleX: 156
					scaleY: 156
					signal: (| (gEgo signal:) $1000)
					init:
				)
				(= cycles 3)
			)
			(1
				(self setScript: goToBed self)
			)
			(2
				(ClearFlag 118)
				(self dispose:)
			)
		)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local0
					(gEgo view: 35 loop: 0 setCel: 8 x: 102 y: 106)
					(self changeState: (+= state 2))
				else
					(gEgo setMotion: PolyPath 76 108 self)
				)
			)
			(1
				(gEgo
					view: 35
					loop: 0
					cel: 0
					x: 102
					y: 106
					setCycle: End self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gCast eachElementDo: #hide)
				(if (gCast contains: (ScriptID 35 1)) ; Rakeesh
					((ScriptID 35 1) dispose:) ; Rakeesh
				)
				(gCurRoom drawPic: 0 9)
				(= seconds 3)
			)
			(4
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 430 9)
				(= cycles 3)
			)
			(5
				(UnLoad 129 0)
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(if (PalVary pvGET_CURRENT_STEP)
					(PalVary pvREVERSE 0)
					(ClearFlag 81)
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 6 cel: 6 x: 76 y: 108)
				(= cycles 3)
			)
			(7
				(if (and (== gDay (+ global456 1)) (not (IsFlag 75)))
					(SetFlag 75)
					(gMessager say: 5 6 55 0 self) ; "Rakeesh left the hut at first light. You vaguely remember hearing his farewell."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance checkTime of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local4 (GetTime))
				(= cycles 1)
			)
			(1
				(= cycles 5)
			)
			(2
				(= local3 (- (= temp0 (GetTime)) local4))
				(self dispose:)
			)
		)
	)
)

(instance uhuraGoodNight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 34 1) ; Uhura
					setMotion:
						PolyPath
						((ScriptID 34 1) x:) ; Uhura
						(+ ((ScriptID 34 1) y:) 100) ; Uhura
						self
				)
			)
			(1
				(if register
					(HandsOn)
				)
				(= local7 0)
				(= local12 1)
				(= local9 0)
				((ScriptID 34 1) dispose:) ; Uhura
				(self dispose:)
			)
		)
	)
)

(instance uhuraLeave of Script
	(properties)

	(method (doit)
		(if local11
			(= local11 0)
			(self cycles: 200)
		)
		(if (== local2 255)
			(self changeState: 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 6 33) ; "It is a strange time we be seeing here. This prisoner make the Simbani think war be easy. The young Warriors are eager for battle. The drums of war beat soon."
				(= local10 1)
				(= cycles 200)
			)
			(1
				(HandsOff)
				(gMessager say: 3 6 39 0 self) ; "I think I hearing Simba's call. I better be going. Lala salama, sultan's son."
			)
			(2
				((ScriptID 34 1) ; Uhura
					setMotion:
						PolyPath
						((ScriptID 34 1) x:) ; Uhura
						(+ ((ScriptID 34 1) y:) 100) ; Uhura
						self
				)
			)
			(3
				(HandsOn)
				(= local7 0)
				(= local12 1)
				(= local9 0)
				((ScriptID 34 1) dispose:) ; Uhura
				(self dispose:)
			)
		)
	)
)

(instance stopEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local8 1)
				(gEgo setMotion: 0)
				(gMessager say: 2 3 52 0 self) ; "No need to get up, hero man. I just come to talk a bit."
			)
			(1
				(gEgo setMotion: PolyPath 190 135 self)
			)
			(2
				(gEgo setHeading: 180)
				(= cycles 18)
			)
			(3
				(client setScript: walkUhuraIn)
			)
		)
	)
)

(instance walkUhuraIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 1)
				(= [local151 0] @local133)
				(= [local151 1] @local140)
				(= [local151 2] @local144)
				(uhuraTell init: (ScriptID 34 1) @local133 @local151 @local147) ; Uhura
				((ScriptID 34 1) ; Uhura
					x: 200
					y: 250
					noun: 3
					setScale:
					scaleX: 156
					scaleY: 156
					init:
					setCycle: Walk
					setMotion: MoveTo 200 155 self
				)
			)
			(1
				((ScriptID 34 1) setScript: uhuraLeave) ; Uhura
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(IsFlag 29)
						(not (IsFlag 38))
						(== gTimeOfDay 5)
						(not local0)
						(not local9)
						(not local12)
						(!= gDay global456)
					)
					(client setScript: stopEgo)
				)
				(HandsOff)
				(if (and local9 (gCast contains: (ScriptID 34 1))) ; Uhura
					(gEgo setMotion: 0)
					(gMessager say: 2 3 54) ; "If you want to be hunting tonight, maybe tomorrow we talk. Good-night."
					((ScriptID 34 1) ; Uhura
						setMotion:
							PolyPath
							((ScriptID 34 1) x:) ; Uhura
							(+ ((ScriptID 34 1) y:) 50) ; Uhura
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance uhuraTryEnter of Script
	(properties)

	(method (doit)
		(cond
			(local9
				(self dispose:)
			)
			(local8
				(= local7 0)
				(self dispose:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 1)
				(gMessager say: 3 6 52 0 self) ; "You hear Uhura's voice say, "Hodi. May I enter?""
			)
			(1
				(= cycles (localproc_0 10))
			)
			(2
				(gMessager say: 3 6 52) ; "You hear Uhura's voice say, "Hodi. May I enter?""
				(= cycles (localproc_0 10))
			)
			(3
				(= local7 0)
				(= local12 1)
				(self dispose:)
			)
		)
	)
)

(instance egoGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo view: 0 normalize: setMotion: PolyPath local5 local6)
				(= local0 0)
				(gWalkHandler delete: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance firstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global456 gDay)
				(= [local113 0] @local28)
				(= [local113 1] @local34)
				(= [local113 2] @local57)
				(= [local113 3] @local76)
				(= [local113 4] @local82)
				(= [local113 5] @local38)
				(= [local113 6] @local41)
				(= [local113 7] @local44)
				(= [local113 8] @local48)
				(= [local113 9] @local51)
				(= [local113 10] @local54)
				(= [local113 11] @local60)
				(= [local113 12] @local63)
				(= [local113 13] @local67)
				(= [local113 14] @local70)
				(= [local113 15] @local73)
				(= [local113 16] @local79)
				(= [local113 17] @local87)
				(= [local113 18] @local90)
				(rakeeshTell init: (ScriptID 35 1) @local28 @local113 @local93) ; Rakeesh
				(= local0 1)
				(gCurRoom drawPic: 0)
				(Animate 0)
				((ScriptID 7 4) init: 20 0) ; fixTime
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					view: 40
					setCycle: 0
					setLoop: -1
					setLoop: 0
					setMotion: 0
					cel: 5
					x: 103
					y: 105
					setScale:
					scaleX: 156
					scaleY: 156
					actions: egoActions
					noun: 2
					signal: (| (gEgo signal:) $1000)
					init:
				)
				((ScriptID 35 1) ; Rakeesh
					view: 432
					loop: 2
					cel: 0
					x: 232
					y: 105
					noun: 1
					signal: (| ((ScriptID 35 1) signal:) $1000) ; Rakeesh
					init:
				)
				(= seconds 1)
			)
			(1
				(if (PalVary pvGET_CURRENT_STEP)
					(PalVary pvCHANGE_TICKS 1)
				)
				(gMessager say: 1 6 1 0 self) ; "We were treated royally by the Simbani. That was meat from the Laibon's own herd."
			)
			(2
				(UnLoad 129 0)
				(switch gBaseHeroType
					(0 ; Fighter
						(gMessager say: 1 6 43 0 self) ; "Do whatever you can to win the respect of the Simbani. We will undoubtedly need their cooperation to restore the peace."
					)
					(1 ; Magic User
						(SetFlag 133)
						(gMessager say: 1 6 6 0 self) ; "I suggest that first you seek some magic wood. Kreesha wishes to teach you the Magic Staff spell, but you must have the magic wood to do so. I think you will need all the magic you can get in order to restore the peace in this land."
					)
					(2 ; Thief
						(gMessager say: 1 6 42 0 self) ; "You will need all your skills to restore the peace here. I suggest that it will be most essential for you to maintain a sense of balance about things. I also think some give and take may be required."
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 103 105 self)
			)
			(1
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo view: 40 setLoop: 0 setCycle: End self)
				(= local0 1)
			)
			(2
				(if
					(and
						(IsFlag 29)
						(not (IsFlag 38))
						(== gTimeOfDay 5)
						(not local7)
						(not local12)
						(!= gDay global456)
					)
					(gEgo setScript: uhuraTryEnter)
				)
				(= cycles 1)
			)
			(3
				(gWalkHandler addToFront: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 75)) (== gDay global456))
					(= [local113 0] @local28)
					(= [local113 1] @local34)
					(= [local113 2] @local57)
					(= [local113 3] @local76)
					(= [local113 4] @local82)
					(= [local113 5] @local38)
					(= [local113 6] @local41)
					(= [local113 7] @local44)
					(= [local113 8] @local48)
					(= [local113 9] @local51)
					(= [local113 10] @local54)
					(= [local113 11] @local60)
					(= [local113 12] @local63)
					(= [local113 13] @local67)
					(= [local113 14] @local70)
					(= [local113 15] @local73)
					(= [local113 16] @local79)
					(= [local113 17] @local87)
					(= [local113 18] @local90)
					(rakeeshTell init: (ScriptID 35 1) @local28 @local113 @local93) ; Rakeesh
					((ScriptID 35 1) ; Rakeesh
						view: 432
						loop: 2
						cel: 0
						x: 232
						y: 105
						noun: 1
						signal: (| ((ScriptID 35 1) signal:) $1000) ; Rakeesh
						init:
					)
				)
				(gEgo
					normalize:
					x: 240
					y: 180
					setScale:
					scaleX: 156
					scaleY: 156
					actions: egoActions
					noun: 2
					setMotion: PolyPath 240 150 self
					signal: (| (gEgo signal:) $1000)
					init:
				)
			)
			(1
				(cond
					((and (== gDay global456) (== gPrevRoomNum 420))
						(gMessager say: 1 6 41 0 self) ; "It is difficult to sleep the first night in a new place, I know, but you should at least try to rest."
					)
					((and (== gDay (+ global456 1)) (not (IsFlag 75)))
						(SetFlag 75)
						(gMessager say: 5 6 46 0 self) ; "You find a note from Rakeesh bidding you farewell. He left for Tarna before sun up."
					)
					((and (IsFlag 29) (== gTimeOfDay 5))
						(self setScript: checkTime self)
					)
					((and (!= gDay global464) (== gTimeOfDay 5))
						(gMessager say: 5 6 63 0 self) ; "You find some food the Simbani have left for you. It looks odd, and it tastes strange, but it fills your belly."
					)
					(else
						(= ticks 1)
					)
				)
			)
			(2
				(= global464 gDay)
				(HandsOn)
				(proc0_16)
				(self dispose:)
			)
		)
	)
)

(instance walkToChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: egoGetUp self)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 155 99 self)
			)
			(2
				(chest doVerb: register)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chestLid setLoop: 1)
				(gLongSong2 number: 311 setLoop: 1 play:)
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks 60)
			)
			(2
				((ScriptID 29 0) init:) ; doCode
				(= cycles 1)
			)
			(3
				(gEgo setCycle: CT 0 -1 self)
			)
			(4
				(gEgo normalize:)
				(chestLid setLoop: 2 stopUpd:)
				(gLongSong2 number: 312 setLoop: 1 play:)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useChestMag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chestLid setLoop: 1)
				(gLongSong2 number: 311 setLoop: 1 play:)
				(= cycles 6)
			)
			(1
				((ScriptID 29 0) init:) ; doCode
				(= cycles 1)
			)
			(2
				(chestLid setLoop: 2 stopUpd:)
				(gLongSong2 number: 312 setLoop: 1 play:)
				(= cycles 1)
			)
			(3
				(chestLid stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fillChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chestLid loop: 1)
				(gLongSong2 number: 311 setLoop: 1 play:)
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks 60)
			)
			(2
				((ScriptID 29 1) init: local1) ; useCode
				(= cycles 1)
			)
			(3
				(gEgo setCycle: CT 0 -1 self)
			)
			(4
				(gEgo normalize:)
				(chestLid loop: 2)
				(gLongSong2 number: 312 setLoop: 1 play:)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance warmHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local0
					(self setScript: egoGetUp self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 149 130 self)
			)
			(2
				(gEgo setHeading: 180)
				(= cycles 18)
			)
			(3
				(gMessager say: 7 4 0 0 self) ; "You warm your hands by the fire."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shield of Feature
	(properties
		x 86
		y 50
		noun 10
		nsTop 26
		nsLeft 72
		nsBottom 74
		nsRight 100
		sightAngle 180
	)
)

(instance zebra of Feature
	(properties
		x 233
		y 50
		noun 11
		nsTop 24
		nsLeft 204
		nsBottom 76
		nsRight 263
		sightAngle 180
	)
)

(instance leftbed of Feature
	(properties
		x 95
		y 97
		noun 12
		nsTop 87
		nsLeft 45
		nsBottom 107
		nsRight 146
		sightAngle 180
	)
)

(instance rightbed of Feature
	(properties
		x 241
		y 100
		noun 13
		nsTop 83
		nsLeft 198
		nsBottom 118
		nsRight 284
		sightAngle 180
	)
)

(instance wall of Feature
	(properties
		x 163
		y 26
		noun 14
		nsTop 24
		nsLeft 38
		nsBottom 82
		nsRight 288
		sightAngle 180
	)
)

(instance fireplace of Feature
	(properties
		x 145
		y 136
		noun 16
		nsTop 122
		nsLeft 108
		nsBottom 150
		nsRight 183
		sightAngle 180
	)
)

(instance basket of Feature
	(properties
		x 59
		y 146
		noun 17
		nsTop 136
		nsLeft 47
		nsBottom 157
		nsRight 71
		sightAngle 180
	)
)

(instance log of Feature
	(properties
		x 81
		y 145
		noun 18
		nsTop 140
		nsLeft 73
		nsBottom 151
		nsRight 89
		sightAngle 180
	)
)

(instance chest of Feature
	(properties
		x 165
		y 82
		noun 15
		nsTop 74
		nsLeft 144
		nsBottom 95
		nsRight 192
		sightAngle 40
		approachX 155
		approachY 99
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb -75) ; openSpell
				(chestLid setScript: useChestMag)
			)
			((== theVerb 4) ; Do
				(if local0
					(gCurRoom setScript: walkToChest 0 theVerb)
				else
					(chestLid setScript: useChest)
				)
			)
			((< 9 theVerb 62) ; ???, ???
				(if (>= theVerb 39) ; thePin
					(= local1 (- theVerb 11))
				else
					(= local1 (- theVerb 10))
				)
				(if local0
					(gCurRoom setScript: walkToChest 0 theVerb)
				else
					(chestLid setScript: fillChest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of Feature
	(properties
		x 95
		y 99
		noun 6
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo script:) 0)
					((== (gEgo view:) 40) 0)
					(else
						(gEgo setScript: sitDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chestLid of Prop
	(properties
		x 161
		y 78
		view 430
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(chest doVerb: theVerb &rest)
	)
)

(instance fire of Prop
	(properties
		x 145
		y 141
		noun 7
		view 423
		priority 14
		signal 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 4)) ; Do
			(gCurRoom setScript: warmHands)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

