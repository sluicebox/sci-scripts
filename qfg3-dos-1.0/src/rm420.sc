;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use Teller)
(use Inset)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Blk)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	[local0 3] = [0 -1 999]
	[local3 5]
	local8
)

(procedure (localproc_0)
	(crowd x: 92 y: 189 loop: 3 ignoreActors: 1 init: addToPic:)
	((ScriptID 42 1) ; Laibon
		view: 454
		loop: 1
		x: 160
		y: 117
		setScale: 350
		ignoreActors: 1
		init:
	)
	((ScriptID 34 1) ; Uhura
		view: 971
		loop: 4
		cel: 6
		x: 28
		y: 133
		setScale: 350
		init:
		addToPic:
	)
	(simba loop: 4 cel: 0 x: 21 y: 135 setScale: 350 init: addToPic:)
)

(instance rm420 of Rm
	(properties
		noun 3
		picture 420
		vanishingY -60
	)

	(method (init)
		(HandsOff)
		(= [local3 0] @local0)
		(= [local3 1] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 140 161 100 160 78 150 80 137 98 133 121 131 143 133 155 141 155 153
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 120 269 103 272 89 262 88 262 103 238 103 243 83 267 74 319 74
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 145 68 146 84 97 84 94 76 98 64 211 65 219 70 226 82 200 83 167 83 167 68
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 35 102 0 96 0 82 68 76 99 91 93 104 73 104 79 84 72 82 71 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 223 64 212 63 200 58 100 58 49 60 0 63 0 0 319 0 319 60 271 58 267 64 254 65 239 64 230 71
					yourself:
				)
		)
		(guard
			setScale:
			scaleX: 44
			scaleY: 44
			maxScale: 78
			loop: 8
			cel: 2
			stopUpd:
			approachVerbs: 2 ; Talk
			init:
		)
		(egoActions init: gEgo @local0 @local3)
		(gEgo actions: egoActions normalize: setScale: 350 noun: 1 init:)
		(chiefHut approachVerbs: (if (== gBaseHeroType 2) 1 else 0) init:) ; Thief
		(if gNight
			(fire setCycle: Fwd init:)
		)
		(campfire init:)
		(tree init:)
		(fence init:)
		(mountain init:)
		(uhuraHutLook init:)
		(guestHut init:)
		(guestHutLook init:)
		(leaderDoor approachVerbs: 1 init:) ; Look
		(cond
			(
				(and
					(>= gDay (+ global452 3))
					(not (IsFlag 29))
					(!= global366 3)
					(not (IsFlag 74))
				)
				(= global366 2)
			)
			((and (IsFlag 29) (not (IsFlag 38)) (!= global366 5))
				(= global366 4)
			)
			(
				(and
					(IsFlag 38)
					(not (IsFlag 11))
					(not (gEgo has: 22)) ; theHorn
					(== gBaseHeroType 0) ; Fighter
					(!= global366 7)
				)
				(= global366 6)
			)
			(
				(and
					(== gBaseHeroType 0) ; Fighter
					(not (IsFlag 11))
					(gEgo has: 22) ; theHorn
					(!= global366 9)
				)
				(= global366 8)
			)
			(
				(and
					(IsFlag 38)
					(not (IsFlag 65))
					(== global392 0)
					(!= global366 11)
				)
				(= global366 10)
			)
			(
				(and
					(== global392 1)
					(gEgo has: 3) ; theFineSpear
					(gEgo has: 40) ; theRobe
					(gEgo has: 21) ; theSkins
					(> ((gInventory at: 21) amount:) 4) ; theSkins
					(!= global366 13)
				)
				(= global366 12)
			)
		)
		(if (not (IsFlag 87))
			(gCurRoom style: 9)
		)
		(super init:)
		(if (!= (gLongSong number:) 160)
			(gLongSong changeTo: 160)
		)
		(cond
			((not (IsFlag 87))
				(gCurRoom setScript: enterFirstTime)
			)
			((or (== gPrevRoomNum 620) (== gPrevRoomNum 630))
				(gCurRoom setScript: returnSpear)
			)
			((and (== gPrevRoomNum 470) (IsFlag 16) (not (IsFlag 154)))
				(gCurRoom setScript: afterMatch)
			)
			((== gPrevRoomNum 500)
				(gCurRoom setScript: afterContest)
			)
			(
				(and
					(or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
					(IsFlag 11)
					(not (IsFlag 56))
				)
				(gCurRoom setScript: startContest)
			)
			(
				(and
					(>= gDay 5)
					(or (== gTimeOfDay 5) (== gTimeOfDay 4))
					(not (IsFlag 9))
				)
				(gCurRoom setScript: enterStoryTell)
			)
			((== gPrevRoomNum 440)
				(gCurRoom setScript: enterFromUHut)
			)
			(
				(and
					(== gPrevRoomNum 450)
					(== gBaseHeroType 2) ; Thief
					(== gDay global470)
					gNight
				)
				(gCurRoom setScript: enterThief)
			)
			((== gPrevRoomNum 450)
				(gCurRoom setScript: enterFromLHut)
			)
			((== gPrevRoomNum 430)
				(gCurRoom setScript: enterFromEHut)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: enterFromSpRoom)
			)
			((== gPrevRoomNum 470)
				(gCurRoom setScript: enterFromWrRoom)
			)
			((== gPrevRoomNum 480)
				(gCurRoom setScript: enterFromPrisCage)
			)
			(else
				(gCurRoom setScript: enterRoom)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo onControl: 1) 8)
				(if (and gNight (< gTimeOfDay 6))
					(gCurRoom setScript: enterUhHut)
				else
					(gCurRoom setScript: cantEnterUhHut)
				)
			)
			((guestHut onMe: gEgo)
				(gCurRoom newRoom: 430)
			)
			((== (gEgo onControl: 1) 4)
				(if
					(and
						(not gNight)
						(>= gDay (+ global452 3))
						(not (& global366 $0001))
					)
					(gCurRoom setScript: enterLeader)
				else
					(gCurRoom setScript: cantEnter)
				)
			)
			((and (<= (gEgo x:) 90) (< (gEgo y:) 70))
				(gCurRoom setScript: exitWest)
			)
			((< (gEgo x:) 10)
				(gCurRoom setScript: exitWest)
			)
			((>= (gEgo x:) 310)
				(gCurRoom setScript: exitEast)
			)
			((>= (gEgo y:) 180)
				(gCurRoom setScript: exitSouth)
			)
			((and (< 90 (gEgo x:) 240) (< (gEgo y:) 70))
				(gCurRoom newRoom: 480)
			)
			((and (> (gEgo x:) 239) (< (gEgo y:) 80))
				(gCurRoom newRoom: 470)
			)
			((and (< (gEgo x:) 78) (< (gEgo y:) 79))
				(gCurRoom newRoom: 460)
			)
		)
		(super doit:)
	)

	(method (setInset param1 param2 param3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
					&rest
			)
		)
	)

	(method (dispose)
		(LoadMany 0 970 949 34 35 39 42 53 923)
		(super dispose:)
	)
)

(instance egoActions of Teller
	(properties)

	(method (doChild)
		(if (== query -1) ; "The guard says, "Nisamhe sefahamu, bwana.""
			(cond
				((gEgo inRect: 108 79 218 90)
					(gEgo addHonor: 3)
					(= query -2)
				)
				((gEgo inRect: 250 104 280 116)
					(if (and (> gDay global452) gNight (< gTimeOfDay 6))
						(= local8 1)
						(gEgo addHonor: 10)
						(= query -6)
					else
						(= query -7)
					)
				)
				(else
					(= query -3)
				)
			)
		)
		(return 1)
	)
)

(instance enterThief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 221 y: 75 setMotion: PolyPath 230 90 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goTo620 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gHeroType 1) ; Magic User
					(gMessager say: 18 6 42 0 self) ; "Prince of Shapeir, only the return of the Drum of Magic stands in the way of peace between our friends the Simbani and Leopardmen."
				else
					(self cue:)
				)
			)
			(1
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 0 0)
				(= cycles 3)
			)
			(2
				(gMessager say: 11 6 32 0 self) ; "You return to the Leopardmen village with the Drum of Magic."
			)
			(3
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance goTo350 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 0 0)
				(= cycles 3)
			)
			(1
				(gMessager say: 11 6 31 0 self) ; "You travel with Rakeesh back to Tarna by way of the magic portal. The next few days are spent arranging a peace conference between the Simbani and the Leopardmen in the Hall of Judgement. Then you are summoned to the Temple of Sekhmet."
			)
			(2
				(= [gEgoStats 16] (gEgo maxHealth:)) ; health
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 18] (gEgo maxMana:)) ; mana
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance goTo280 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 0 0)
				(= cycles 3)
			)
			(1
				(gMessager say: 11 6 30 0 self) ; "You travel with Rakeesh back to Tarna by way of the magic portal. The next few days are spent arranging a peace conference between the Simbani and the Leopardmen in the Hall of Judgement. At last, the day of the peace conference arrives, but first, Rakeesh calls you to Kreesha's house."
			)
			(2
				(= [gEgoStats 16] (gEgo maxHealth:)) ; health
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 18] (gEgo maxMana:)) ; mana
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance goTo340 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 0 0)
				(= cycles 3)
			)
			(1
				(gMessager say: 11 6 29 0 self) ; "You travel with Rakeesh back to Tarna by way of the magic portal. The next few days are spent arranging a peace conference between the Simbani and the Leopardmen in the Hall of Judgement. At last, the day of the peace conference arrives."
			)
			(2
				(= [gEgoStats 16] (gEgo maxHealth:)) ; health
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 18] (gEgo maxMana:)) ; mana
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance enterUhHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 267 103 self)
			)
			(1
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance enterFromPrisCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 215 y: 68 setMotion: PolyPath 225 75 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantEnterUhHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 11 6 41 0 self) ; "This is not a good time to visit Uhura's hut."
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 5)
						(+ (gEgo y:) 5)
						self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(gMessager say: 11 6 34 0 self) ; "The guard bars the way with his spear. You guess this is not a good time to visit the Laibon."
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterLeader of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(++ global366)
				(gMessager say: 11 6 33 0 self) ; "The guard gestures for you to enter."
			)
			(1
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance exitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(1
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 190 y: 210 setMotion: PolyPath 190 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFromUHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 265
					y: 105
					normalize:
					setMotion: MoveTo 270 115 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFromLHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 125)
					(ClearFlag 125)
					(self setScript: enterFromPrisCage self)
				else
					(gEgo
						x: 154
						y: 78
						normalize:
						setMotion: MoveTo 154 90 self
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFromEHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 74 y: 99 normalize: setMotion: MoveTo 60 110 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFromWrRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 280
					y: 74
					normalize:
					setMotion: PolyPath 240 84 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFromSpRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 65 y: 74 normalize: setMotion: MoveTo 85 82 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFirstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 87)
				(= global452 gDay)
				((ScriptID 34 1) ; Uhura
					view: 969
					loop: 0
					cel: 0
					x: 144
					y: 133
					setScale: 300
					ignoreActors: 1
					init:
				)
				(simba x: 158 y: 135 setScale: 300 ignoreActors: 1 init:)
				(= global126 (gEgo moveSpeed:))
				(gEgo
					normalize:
					x: 215
					y: 220
					setScale: 300
					setSpeed: 6
					setMotion: MoveTo 173 145 self
					ignoreActors: 1
				)
				((ScriptID 35 1) ; Rakeesh
					view: 967
					setLoop: 3
					x: 254
					y: 220
					setCycle: Walk
					setScale: 300
					setLoop: lionGroop
					ignoreActors: 1
					setMotion: PolyPath 195 138 self
					init:
				)
			)
			(1 0)
			(2
				((ScriptID 35 1) view: 962 setLoop: 1) ; Rakeesh
				(= ticks 90)
			)
			(3
				(gMessager say: 8 6 8 0 self) ; "Hujambo, mabwana."
			)
			(4
				(gEgo setSpeed: global126)
				((ScriptID 34 1) ; Uhura
					view: 971
					setCycle: Walk
					setAvoider: PAvoider
					setMotion: PolyPath 144 115 self
				)
			)
			(5
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance enterStoryTell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 420 hold:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 32 189 72 128 122 109 217 109 236 122 235 189
							yourself:
						)
				)
				(crowd init: addToPic:)
				((ScriptID 53 1) ; StoryTeller
					x: 85
					y: 136
					setScale:
					scaleX: 66
					scaleY: 66
					init:
				)
				((ScriptID 34 1) ; Uhura
					view: 971
					loop: 4
					cel: 1
					x: 160
					y: 119
					setScale:
					scaleX: 61
					scaleY: 61
					init:
					addToPic:
				)
				(simba
					loop: 4
					cel: 3
					x: 141
					y: 120
					setScale:
					scaleX: 64
					scaleY: 64
					init:
					addToPic:
				)
				(extra setScale: scaleX: 66 scaleY: 66 init: addToPic:)
				(extra2 setScale: scaleX: 66 scaleY: 66 init: addToPic:)
				(fire setCycle: Fwd init:)
				(switch gPrevRoomNum
					(410
						(gEgo x: 240 y: 210)
					)
					(430
						(gEgo x: 74 y: 99)
					)
					(440
						(gEgo x: 265 y: 105)
					)
					(450
						(gEgo x: 154 y: 75)
					)
					(460
						(gEgo x: -5 y: 160)
					)
					(470
						(gEgo x: 320 y: 160)
					)
					(480
						(gEgo x: 215 y: 68)
					)
					(else
						(gEgo x: 240 y: 210)
					)
				)
				(gEgo
					setScale: 290
					setAvoider: PAvoider
					setMotion: PolyPath 240 140 self
				)
			)
			(1
				(Face gEgo (ScriptID 53 1)) ; StoryTeller
				(= cycles 15)
			)
			(2
				(SetFlag 9)
				(gMessager say: 9 6 9 0 self) ; "Hamjambo, mabwana."
			)
			(3
				((ScriptID 53 1) setCycle: End self) ; StoryTeller
			)
			(4
				(gMessager say: 9 6 11 0 self) ; "There once was a people. A proud people. A people with the wealth of the land and their cattle. A people with a Spear of Death."
			)
			(5
				((ScriptID 53 1) cel: 0 loop: 1 setCycle: End self) ; StoryTeller
			)
			(6
				(gMessager say: 9 6 12 0 self) ; "Now the people be angry. Now the people see the enemy in every stranger. Now the people have lost the great wealth of peace."
			)
			(7
				((ScriptID 53 1) cel: 0 loop: 0 setCycle: End self) ; StoryTeller
			)
			(8
				((ScriptID 53 1) cel: 0 loop: 1 setCycle: End self) ; StoryTeller
			)
			(9
				(gMessager say: 9 6 13 0 self) ; "So the people go to war against an enemy they cannot see. The people go to war against an enemy they cannot hear. The people go to war against an enemy they do not know."
			)
			(10
				((ScriptID 53 1) cel: 0 loop: 1 setCycle: End self) ; StoryTeller
			)
			(11
				(gMessager say: 9 6 14 0 self) ; "That be the story that I found."
			)
			(12
				((ScriptID 53 1) cel: 0 loop: 2 setCycle: End self) ; StoryTeller
			)
			(13
				(gMessager say: 9 6 15 0 self) ; "The crowd breaks up, and everyone goes back to their huts to sleep."
			)
			(14
				(gEgo solvePuzzle: 262 2)
				(SetFlag 118)
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance startContest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 420 hold:)
				(localproc_0)
				(gEgo
					changeGait: 1 ; running
					ignoreActors: 1
					setCycle: StopWalk 5
					x: 187
					y: 117
				)
				((ScriptID 39 1) ; Yesufu
					view: 983
					heading: 180
					loop: 2
					cel: 4
					x: 208
					y: 117
					setScale: 350
					init:
				)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 10)
			)
			(2
				(gMessager say: 10 6 16 0 self) ; "People of the Simbani, today there be two boys who want to be Simbani Warriors. We shall watch, and we shall judge whether these boys deserve to be Simbani Warriors."
			)
			(3
				(gEgo setMotion: PolyPath 187 220 self)
				((ScriptID 39 1) ; Yesufu
					origStep: 2053
					setCycle: StopWalk -1
					setMotion: PolyPath 208 220
				)
			)
			(4
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance afterContest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 420 hold:)
				(SetFlag 56)
				(localproc_0)
				(= global126 (gEgo moveSpeed:))
				(gEgo
					view: 1
					changeGait: 1 ; running
					setCycle: StopWalk 5
					setSpeed: 6
					x: 190
					y: 220
					ignoreActors: 1
					setHeading: 0
					setMotion: PolyPath 190 130 self
				)
				((ScriptID 39 1) ; Yesufu
					view: 983
					x: 220
					y: 220
					origStep: 2053
					setScale: 350
					setCycle: StopWalk -1
					init:
					setMotion: PolyPath 220 130
				)
			)
			(1
				(= cycles 15)
			)
			(2
				(gMessager say: 10 6 17 0 self) ; "Two boys return to the village. Did they do well?"
			)
			(3
				(if global406
					(gEgo
						setMotion: PolyPath 177 117 self
						solvePuzzle: 264 10 9
					)
				else
					(gEgo solvePuzzle: 263 5 9)
					((ScriptID 39 1) setMotion: PolyPath 177 117 self) ; Yesufu
				)
			)
			(4
				(if global406
					(gEgo setHeading: 270)
				else
					((ScriptID 39 1) setHeading: 270) ; Yesufu
				)
				(= cycles 15)
			)
			(5
				(gMessager say: 10 6 18 0 self) ; "This be the boy who raced. This be the boy who defeated his opponent. He has done well."
			)
			(6
				(if global406
					(gEgo view: 13 loop: 0 cel: 0 setCycle: End self)
				else
					((ScriptID 39 1) ; Yesufu
						view: 427
						loop: 0
						cel: 0
						setCycle: End self
					)
				)
			)
			(7
				(gEgo setSpeed: global126)
				(gMessager say: 10 6 19 0 self) ; "The last two contests are the most difficult. First will be the contest of the spear. We shall judge who throws the spear best."
			)
			(8
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance afterMatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 420 hold:)
				(SetFlag 154)
				(localproc_0)
				(gEgo setHeading: 180 x: 152 y: 114)
				((ScriptID 39 1) ; Yesufu
					setHeading: 180
					setScale: 350
					x: 194
					y: 114
					init:
				)
				((ScriptID 42 1) setLoop: (if global406 3 else 2) x: 171 y: 118) ; Laibon
				(= cycles 1)
			)
			(1
				(= cycles 15)
			)
			(2
				(gMessager say: 10 6 20 0 self) ; "Before today these two were boys. Be they still boys?"
			)
			(3
				(gMessager say: 10 6 22 0 self) ; "In life, there is always someone better at some things than at others. This is one lesson of the initiation."
			)
			(4
				(if global406
					(gMessager say: 10 6 23 0 self) ; "I call now upon the winner of the initiation contest. He who was a stranger to the Simbani be now a Warrior of the Simbani. Behold our new Warrior!"
				else
					(gMessager say: 10 6 24 0 self) ; "There is one who has proved himself a better Warrior than the other. I call upon Yesufu to stand before me. Behold the new Warrior!"
				)
			)
			(5
				((ScriptID 42 1) cycleSpeed: 6 setCycle: End self) ; Laibon
			)
			(6
				(if global406
					(gEgo view: 13 setCycle: End self)
				else
					((ScriptID 39 1) view: 427 setCycle: End self) ; Yesufu
				)
			)
			(7
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance returnSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 420 hold:)
				(gCurRoom vanishingY: -80)
				(gEgo solvePuzzle: 265 20 addHonor: 50 drop: 45) ; theMagicSpear
				(crowd loop: 2 x: 146 y: 189 init: addToPic:)
				((ScriptID 42 1) ; Laibon
					view: 454
					loop: 1
					cel: 0
					setScale: 300
					x: 22
					y: 142
					ignoreActors: 1
					init:
				)
				((ScriptID 34 1) ; Uhura
					view: 970
					loop: 4
					cel: 1
					x: 67
					y: 132
					setScale: 300
					init:
				)
				((ScriptID 35 1) ; Rakeesh
					view: 432
					loop: 2
					cel: 0
					setScale: 300
					x: 165
					y: 119
					init:
					addToPic:
				)
				(simba x: 141 y: 120 setScale: 300 init: addToPic:)
				((ScriptID 53 1) ; StoryTeller
					loop: 3
					cel: 0
					setScale: 300
					x: 130
					y: 117
					init:
					addToPic:
				)
				(gEgo
					changeGait: 0 ; walking
					setCycle: StopWalk 5
					setHeading: 0
					setScale: 300
					x: 46
					y: 168
				)
				((ScriptID 39 1) ; Yesufu
					view: 989
					loop: 0
					cel: 0
					x: 9
					y: 165
					setScale: 300
					ignoreActors: 1
					init:
				)
				(extra setScale: scaleX: 69 scaleY: 69 init: addToPic:)
				(extra2 setScale: scaleX: 69 scaleY: 69 init: addToPic:)
				(= cycles 1)
			)
			(1
				(= ticks 180)
			)
			(2
				(gMessager say: 10 6 26 0 self) ; "A stranger once came to the Simbani. This stranger spoke of peace. There can be no peace, said the Simbani."
			)
			(3
				(gEgo setMotion: PolyPath 52 139 self)
			)
			(4
				(gEgo view: 32 loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gEgo
					view: 0
					setCycle: StopWalk 5
					setMotion: MoveTo 30 142 self
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(gEgo setLoop: 1 setCycle: Rev setMotion: MoveTo 52 142 self)
			)
			(8
				(gEgo view: 5 setCycle: 0 setLoop: 1)
				((ScriptID 42 1) loop: 5 setCycle: End self) ; Laibon
			)
			(9
				(= ticks 30)
			)
			(10
				(gMessager say: 10 6 27 0 self) ; "Behold, the Simbani Spear of Death!"
			)
			(11
				(if
					(or
						(== gHeroType 1) ; Magic User
						(and (not (IsFlag 74)) (== gHeroType 2)) ; Thief
					)
					(gEgo get: 46) ; theMagicDrum
					(gMessager say: 10 6 28 0 self) ; "Here is the sign of the Simbani peace. Return to the enemy the Drum of Magic. Show them that the Simbani will speak with them of peace."
				else
					(= cycles 1)
				)
			)
			(12
				(= ticks 60)
			)
			(13
				(cond
					((not (IsFlag 13))
						(gCurRoom setScript: goTo620)
					)
					((and (== gHeroType 0) (>= [gEgoStats 14] 150)) ; Fighter, honor
						(client setScript: goTo280)
					)
					((gEgo has: 36) ; theGem
						(gCurRoom setScript: goTo350)
					)
					(else
						(client setScript: goTo340)
					)
				)
			)
		)
	)
)

(instance showHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 926 setLoop: 1 play: 127)
				(gMessager say: 12 12 40 0 self) ; "You dig at the crack."
			)
			(1
				((hutHole insetView:) setCel: 1)
				(gMessager say: 11 6 38 0 self) ; "You dig a hole in the wall large enough for you to enter the hut."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance campfire of Feature
	(properties
		x 116
		y 145
		noun 13
		nsTop 134
		nsLeft 88
		nsBottom 157
		nsRight 145
		sightAngle 180
	)
)

(instance tree of Feature
	(properties
		x 235
		y 33
		noun 14
		nsTop 16
		nsLeft 202
		nsBottom 51
		nsRight 268
		sightAngle 180
	)
)

(instance fence of Feature
	(properties
		x 159
		y 52
		noun 15
		nsTop 47
		nsBottom 58
		nsRight 319
		sightAngle 180
	)
)

(instance mountain of Feature
	(properties
		x 159
		y 31
		noun 16
		nsTop 26
		nsBottom 37
		nsRight 319
		sightAngle 180
	)
)

(instance guestHut of Feature
	(properties
		x 72
		y 92
		nsTop 81
		nsLeft 68
		nsBottom 103
		nsRight 77
		sightAngle 40
		approachX 58
		approachY 106
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(guestHutLook doVerb: 1 &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance leaderDoor of Feature
	(properties
		x 160
		y 54
		sightAngle 40
		onMeCheck 4
		approachX 120
		approachY 84
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(chiefHut doVerb: 1 &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chiefHut of Feature
	(properties
		x 162
		y 68
		noun 5
		nsTop 54
		nsLeft 107
		nsBottom 82
		nsRight 218
		sightAngle 40
		approachX 225
		approachY 81
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((or (gCurRoom script:) (!= gBaseHeroType 2)) ; Thief
						(super doVerb: 1 &rest)
					)
					((IsFlag 50)
						(gMessager say: 5 1 37) ; "You notice that the hut has been repaired."
					)
					(else
						(gMessager say: 5 1 35 0) ; "You walk around the Chief's hut, carefully looking for details."
						(gCurRoom setInset: hutHole)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uhuraHutLook of Feature
	(properties
		x 283
		y 92
		noun 6
		nsTop 78
		nsLeft 248
		nsBottom 107
		nsRight 318
		sightAngle 40
		approachX 282
		approachY 111
	)
)

(instance guestHutLook of Feature
	(properties
		x 47
		y 87
		noun 4
		nsTop 74
		nsLeft 2
		nsBottom 100
		nsRight 93
		sightAngle 40
		approachX 58
		approachY 106
	)
)

(instance crowd of View
	(properties
		x 146
		y 190
		view 420
		loop 1
		signal 16384
	)
)

(instance fire of Prop
	(properties
		x 117
		y 147
		noun 13
		view 420
		priority 11
		signal 16
	)
)

(instance simba of Actor
	(properties
		view 425
	)
)

(instance guard of Actor
	(properties
		x 140
		y 85
		noun 2
		view 482
		signal 16384
	)
)

(instance extra of Actor
	(properties
		x 191
		y 122
		view 207
		loop 5
		cel 3
	)
)

(instance extra2 of Actor
	(properties
		x 209
		y 132
		view 205
		loop 5
		cel 1
	)
)

(instance simbaCage of Cage ; UNUSED
	(properties
		top 140
		left 240
		bottom 170
		right 280
	)
)

(instance hutHole of Inset
	(properties
		view 420
		loop 4
		x 200
		y 85
		disposeNotOnMe 1
		noun 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(if (not gNight)
					(gMessager say: 12 12 39) ; "It is too dangerous to do that in the daytime when people might see you."
				else
					(self setScript: showHole)
				)
			)
			(12 ; theFineDagger
				(self doVerb: 20)
			)
			(3 ; Walk
				(if (== ((self insetView:) cel:) 1)
					(SetFlag 50)
					(if (not (IsFlag 266))
						(gEgo addHonor: -50)
					)
					(gEgo solvePuzzle: 266 8 4)
					(self dispose:)
					(gCurRoom newRoom: 450)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(if (== ((self insetView:) cel:) 1)
					(gMessager say: 17 1 38) ; "You make a hole big enough to walk through."
				else
					(gMessager say: 17 1 36) ; "You see a definite weakness in the wall at the back of the Laibon's hut."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lionGroop of Grooper
	(properties)

	(method (doit)
		(cond
			((not ((ScriptID 35 1) mover:)) ; Rakeesh
				((ScriptID 35 1) view: 962) ; Rakeesh
			)
			((< 15 ((ScriptID 35 1) heading:) 75) ; Rakeesh
				((ScriptID 35 1) view: 967) ; Rakeesh
			)
			((< 105 ((ScriptID 35 1) heading:) 165) ; Rakeesh
				((ScriptID 35 1) view: 967) ; Rakeesh
			)
			((< 195 ((ScriptID 35 1) heading:) 255) ; Rakeesh
				((ScriptID 35 1) view: 967) ; Rakeesh
			)
			((< 285 ((ScriptID 35 1) heading:) 345) ; Rakeesh
				((ScriptID 35 1) view: 967) ; Rakeesh
			)
		)
		(super doit: &rest)
	)
)

