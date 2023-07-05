;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Interface)
(use PAvoider)
(use CDActor)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	Room180 0
)

(local
	local0
	local1
	[local2 200]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= local0 (proc10_17 InvFriend))
	(local0 regActorDisp:)
	(local0 owner: 0)
	(param1
		init:
		selection: 0
		posn: ((local0 regActor:) x:) ((local0 regActor:) y:)
	)
	(for ((= temp1 0)) (< temp1 (Inv size:)) ((++ temp1))
		(if (== ((= temp0 (Inv at: temp1)) owner:) gEgo)
			(break)
		)
		(= temp0 0)
	)
	(gTheIconBar curInvIcon: temp0 show:)
)

(procedure (localproc_1)
	(sign1 init:)
	(tree init:)
	(fence init:)
	(wall init:)
	(road init:)
	(rocks init:)
	(flowers init:)
	(grass init:)
)

(instance Room180 of FRoom
	(properties
		lookStr {This must be the crossroads.}
		picture 180
		style 0
		east 190
		south 230
		west 170
		southX 242
		southY 180
		eastX 320
		eastY 49
		westY 93
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(if (== (gBremenStory state:) 7)
			(Load rsSOUND 9)
		)
		(if
			(or
				(and (= local0 (proc10_17 InvFriend)) (== gPrevRoomNum 170))
				(and
					(or (== local0 (gInventory at: 6)) (== local0 (gInventory at: 7)))
					(== gPrevRoomNum 230)
				)
			)
			(self defeatEntrance: 1)
		)
		(super init:)
		(if (== (gBremenStory state:) 7)
			(LoadMany rsSOUND 102 124 125 126 138)
			(gGlobalMusic2 stop:)
			(gGlobalMusic number: 9 priority: 15 setLoop: -1 play:)
		else
			(proc10_29)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 86 0 0 319 0 319 40 249 40 245 49 220 42 186 44 168 52 153 48 127 53 121 61 97 55 69 73 50 70 56 62 40 62 6 75
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 114 69 111 104 122 124 137 136 133 150 137 187 173 0 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 167 274 151 273 141 295 110 241 78 275 66 319 61
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 159 118 132 111 130 106 187 105 195 120 179 120
					yourself:
				)
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(localproc_1)
		(streamSound play:)
		(stream setPri: 15 setCycle: Fwd init:)
		(if (and (== global145 5) (== global144 gCindStory))
			(= global140 2)
			(= local1 2)
			(self setRegions: 400) ; endGame
		else
			(if (gBremenStory inProgress:)
				(gEgo doCode: egoDo180)
			)
			(switch (gBremenStory state:)
				(1 0)
				(2
					(lRooster posn: 151 115 40 loop: 8 init:)
				)
				(3
					(lRooster posn: 151 115 40 loop: 8 init:)
				)
				(4
					(lRooster posn: 151 115 40 loop: 8 init:)
					(lCat
						posn: 147 51
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
				)
				(5
					(lRooster posn: 151 115 40 loop: 8 init:)
					(lCat
						posn: 147 51
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
				)
				(6
					(lRooster posn: 151 115 40 loop: 8 init:)
					(lCat
						posn: 147 51
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
					(lDog
						posn: 90 73
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
				)
				(7
					(lRooster posn: 151 115 40 loop: 8 init:)
					(lCat
						posn: 147 51
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
					(lDog
						posn: 90 73
						normal: 1
						ignoreActors: 0
						setCycle: StopWalk
						init:
					)
				)
			)
		)
	)

	(method (enterSpecial)
		(cond
			((and (== local0 (gInventory at: 6)) (== gPrevRoomNum 230))
				(self setScript: dogFirst self)
			)
			((and (== local0 (gInventory at: 7)) (== gPrevRoomNum 230))
				(self setScript: goDonkey self)
			)
			(else
				(self setScript: friendFirst self)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (== local1 2)
			(self setScript: (ScriptID 400 1)) ; wyrmScript
		else
			(switch (gBremenStory state:)
				(1
					(self setScript: enterWithRoost)
				)
				(2
					(self setScript: enterWithoutCat)
				)
				(3
					(self setScript: enterWithCat)
				)
				(4
					(self setScript: enterWithoutDog)
				)
				(5
					(self setScript: enterWithDog)
				)
				(6
					(self setScript: enterWithoutDonkey)
				)
				(7
					(self setScript: enterWithDonkey)
				)
			)
		)
	)

	(method (dispose)
		(if defeatEntrance
			(self defeatEntrance: 0)
		)
		(if (and (gGlobalMusic2 handle:) (== (gGlobalMusic2 number:) 37))
			(gGlobalMusic2 fade: 0 15 5 1)
			(= global225 6)
		)
		(if (and (gGlobalMusic handle:) (== (gGlobalMusic number:) 9))
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 10)
		)
		(super dispose: &rest)
	)
)

(instance streamSound of Sound
	(properties
		flags 1
		number 119
		loop -1
	)
)

(instance friendFirst of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= local0 (gInventory at: 4))
					((local0 regActor:) normal: 0)
				)
				((local0 regActor:)
					setHeading: 90
					posn: (gCurRoom westX:) (gCurRoom westY:)
					setCycle: Walk
					init:
					setMotion: MoveFwd 60 self
				)
			)
			(1
				(NormalEgo 5 global139)
				(gEgo
					setHeading: 90
					posn: (gCurRoom westX:) (gCurRoom westY:)
					ignoreActors: 0
					init:
					setMotion: MoveFwd 20 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dogFirst of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((local0 regActor:)
					setHeading: 0
					posn: (gCurRoom southX:) (gCurRoom southY:)
					setCycle: StopWalk
					init:
					setMotion: MoveFwd 30 self
				)
			)
			(1
				(NormalEgo 5 global139)
				(gEgo
					setHeading: 0
					normal: 1
					setAvoider: PAvoider
					posn: (gCurRoom southX:) (gCurRoom southY:)
					init:
					setMotion: MoveFwd 20 self
				)
			)
			(2
				(gEgo ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance goDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 5 global139)
				(gEgo
					posn: (gCurRoom southX:) (gCurRoom southY:)
					normal: 1
					setHeading: 0
					setMotion:
						PolyPath
						(- (gCurRoom southX:) 40)
						(- (gCurRoom southY:) 30)
						self
					init:
				)
			)
			(1
				(local0 posn: (gCurRoom southX:) (+ (gCurRoom southY:) 20) init:)
				((local0 regActor:)
					setHeading: 0
					setCycle: Walk
					setMotion:
						PolyPath
						(gCurRoom southX:)
						(- (gCurRoom southY:) 20)
						self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance allAnimalsSound of Sound
	(properties
		flags 1
		number 126
	)
)

(instance donkeySound of Sound
	(properties
		flags 1
		number 138
	)
)

(instance roosterSound of Sound
	(properties
		flags 1
		number 125
	)
)

(instance catSound of Sound
	(properties
		flags 1
		number 124
	)
)

(instance dogSound of Sound
	(properties
		flags 1
		number 102
	)
)

(instance enterWithDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBremenStory incState:)
				(Face gEgo lRooster)
				(cond
					((== gPrevRoomNum 190)
						(lDonkey setHeading: 270)
					)
					((== gPrevRoomNum 230)
						(lDonkey setHeading: 0)
					)
				)
				(localproc_0 lDonkey)
				(= cycles 10)
			)
			(1
				(if (== gPrevRoomNum 190)
					(lDonkey setMotion: 0)
					(gEgo
						setMotion:
							PolyPath
							(- (gEgo x:) 10)
							(- (gEgo y:) 5)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(lDonkey
					setLoop: (ScriptID 92 1) ; donkLooper
					setCycle: StopWalk
					setMotion: PolyPath 221 72 self
				)
			)
			(3
				(lDonkey setMotion: PolyPath 219 72 self)
			)
			(4
				(donkeySound play:)
				(proc10_13 0 lDonkey lDonkey -1 1 180 0)
				(= cycles 1)
			)
			(5
				(roosterSound play:)
				(proc10_13 0 lRooster lDonkey -1 1 180 1)
				(= cycles 1)
			)
			(6
				(catSound play:)
				(proc10_13 0 lCat lDonkey -1 1 (Format @local2 180 2 @global110)) ; "%s has helped us all!."
				(= cycles 1)
			)
			(7
				(dogSound play:)
				(proc10_13 0 lDog lDonkey -1 1 180 3)
				(proc10_13 0 lDonkey lDonkey self 1 180 4)
			)
			(8
				(lDonkey setMotion: PolyPath 221 72 self)
			)
			(9
				(lDonkey normal: 1)
				(lDog setCycle: Walk setMotion: PolyPath 158 72 self)
			)
			(10
				(lDog
					view: 650
					posn: 187 54
					normal: 0
					loop: 0
					cel: 0
					setPri: (+ (lDonkey priority:) 1)
					setCycle: End self
				)
			)
			(11
				(lCat setCycle: Walk setMotion: PolyPath 172 70 self)
			)
			(12
				(lCat
					view: 650
					posn: 189 43
					normal: 0
					loop: 1
					cel: 0
					setPri: (+ (lDog priority:) 1)
					setCycle: CT 6 1 self
				)
			)
			(13
				(lDog hide:)
				(lCat setCycle: End self)
			)
			(14
				(lRooster
					view: 650
					setLoop: 2
					cel: 0
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 208 64 self
				)
			)
			(15
				(lRooster
					setLoop: 3
					cel: 0
					setPri: (+ (lCat priority:) 1)
					setCycle: CT 2 1 self
				)
			)
			(16
				(lDog show:)
				(lCat dispose:)
				(lRooster setCycle: End self)
			)
			(17
				(lRooster dispose:)
				(lDog dispose:)
				(lDonkey view: 651 normal: 0 setLoop: 2 cel: 0)
				(= cycles 1)
			)
			(18
				(proc10_13 0 lRooster lDonkey self 1 180 5)
			)
			(19
				(proc10_13
					0
					lCat
					lDonkey
					self
					1
					(Format @local2 180 6 @global110) ; "Let's let %s hear what we sound like."
				)
			)
			(20
				(proc10_13 0 lDog lDonkey self 1 180 7)
			)
			(21
				(proc10_13 0 lDonkey lDonkey self 1 180 8)
			)
			(22
				(lDonkey view: 651 setLoop: 1 cel: 0 setCycle: Fwd)
				(allAnimalsSound play: self)
				(= ticks 180)
			)
			(23
				(= ticks 0)
				(allAnimalsSound client: 0)
				(lDonkey setLoop: 0 ignoreActors: 0 setCycle: Walk)
				(Print 180 9) ; "They sure are loud!"
				(= cycles 1)
			)
			(24
				(proc10_13 0 lRooster lDonkey self 1 180 10)
			)
			(25
				(proc10_13 0 lCat lDonkey self 1 180 11)
			)
			(26
				(proc10_13 0 lDog lDonkey self 1 180 12)
			)
			(27
				(proc10_13
					0
					lDonkey
					gEgo
					self
					1
					(Format @local2 180 13 @global110) ; "Come with us, %s, this will be fun."
				)
			)
			(28
				(gGlobalMusic fade: 127 10 5 0)
				(self setScript: allGo self)
			)
			(29
				(self dispose:)
			)
		)
	)
)

(instance allGo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gPrevRoomNum 190)
					(gEgo setMotion: PolyPath 238 76 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 268 65 self)
			)
			(2
				(lDonkey ignoreActors: 1 setMotion: NPFollow gEgo 40)
				(gEgo setMotion: PolyPath 319 60 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance enterWithoutDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc10_13 3 lRooster gEgo self 1 180 14)
			)
			(2
				(proc10_13 3 lCat gEgo -1 0 180 15)
				(proc10_13 3 lCat gEgo self 1 180 16)
			)
			(3
				(proc10_13 3 lDog gEgo -1 0 180 17)
				(proc10_13 3 lDog gEgo self 1 180 18)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance enterWithDog of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBremenStory incState:)
				(= cycles 1)
			)
			(1
				(dogSound play:)
				(localproc_0 lDog)
				(lDog
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath 90 73 self
				)
			)
			(2
				(lDog setCycle: StopWalk)
				(Face lDog gEgo self)
			)
			(3
				(proc10_13 0 lRooster lRooster -1 0 180 19)
				(proc10_13 0 lRooster lRooster -1 0 180 20)
				(proc10_13 0 lRooster lRooster self 1 180 21)
			)
			(4
				(proc10_13 2 lCat lDog self 1 180 22)
			)
			(5
				(proc10_13 1 lDog lCat self 1 180 23)
			)
			(6
				(proc10_13 3 lCat gEgo self 1 180 24)
			)
			(7
				(proc10_13
					2
					lRooster
					gEgo
					self
					1
					(Format @local2 180 25 @global110) ; "Cockadoodle-doo, %s, will you find the donkey and bring him, too?"
				)
			)
			(8
				(lDog ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterWithoutDog of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc10_13 3 lRooster gEgo -1 0 180 26)
				(proc10_13 3 lRooster gEgo self 1 180 27)
			)
			(2
				(proc10_13 3 lCat gEgo self 0 180 28)
			)
			(3
				(proc10_13 3 lCat gEgo self 1 180 29)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance enterWithCat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBremenStory incState:)
				(catSound play:)
				(localproc_0 lCat)
				(lCat setCycle: 0)
				(Face lCat lRooster)
				(= cycles 4)
			)
			(1
				(proc10_13 0 lRooster lCat self 1 180 30)
			)
			(2
				(proc10_13 0 lCat lRooster -1 0 180 31)
				(proc10_13
					3
					lCat
					lRooster
					-1
					1
					(Format @local2 180 32 @global110) ; "I was hiding from Bookend when %s found me."
				)
				(proc10_13
					0
					lRooster
					gEgo
					-1
					0
					(Format @local2 180 33 @global110) ; "Thank you, %s, for finding the cat."
				)
				(proc10_13 2 lRooster gEgo self 1 180 34)
			)
			(3
				(lCat
					ignoreActors: 1
					setCycle: StopWalk
					setMotion: PolyPath 147 51 self
				)
			)
			(4
				(lCat setHeading: 180 ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterWithRoost of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBremenStory incState:)
				(if (== gPrevRoomNum 190)
					(gEgo setHeading: 180)
				)
				(= cycles 1)
			)
			(1
				(gEgo ignoreActors: 1)
				(localproc_0 lRooster)
				(lRooster
					view: 650
					setLoop: 2
					setPri: 15
					setCycle: Fwd
					setAvoider: PAvoider
					setMotion: MoveTo 151 75 self
				)
			)
			(2
				(roosterSound play:)
				(lRooster
					view: 634
					setPri: -1
					posn: 151 115 40
					setAvoider: 0
					setLoop: 8
					setCel: 0
					setCycle: 0
				)
				(gEgo ignoreActors: 0)
				(proc10_13 0 lRooster gEgo -1 0 180 35)
				(proc10_13 1 lRooster gEgo self 1 180 36)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance enterWithoutCat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc10_13 3 lRooster gEgo self 0 180 26)
			)
			(1
				(proc10_13 3 lRooster gEgo self 1 180 27)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance lRooster of Tactor
	(properties
		description {Rooster}
		lookStr {The rooster looks very proud.}
		view 634
		talkerID 6
	)

	(method (setUp &tmp temp0)
		((= temp0 ((gInventory at: 4) regActor:)) setUp:)
		(= talkerObj (temp0 talkerObj:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gBremenStory state:)
					(2
						(switch (self selection:)
							(0
								(proc10_13 0 self gEgo -1 0 180 37)
								(proc10_13 3 self gEgo -1 1 180 38)
							)
							(1
								(proc10_13 3 self gEgo -1 0 180 39)
								(proc10_13 3 self gEgo -1 0 180 40)
								(proc10_13 0 self gEgo -1 1 180 41)
							)
							(2
								(proc10_13 0 self gEgo -1 0 180 42)
								(proc10_13 0 self gEgo -1 1 180 43)
							)
							(else
								(proc10_13 0 self gEgo -1 1 180 44)
							)
						)
					)
					(4
						(switch (self selection:)
							(0
								(proc10_13 0 self gEgo -1 0 180 45)
								(proc10_13 0 self gEgo -1 1 180 46)
							)
							(1
								(proc10_13 0 self gEgo -1 0 180 47)
								(proc10_13 0 self gEgo -1 1 180 48)
							)
							(2
								(proc10_13 3 self gEgo -1 0 180 49)
								(proc10_13 3 self gEgo -1 1 180 50)
								(proc10_13 0 lCat gEgo -1 1 180 51)
							)
							(else
								(proc10_13 0 self gEgo -1 1 180 52)
							)
						)
					)
					(6
						(switch (self selection:)
							(0
								(proc10_13 3 self gEgo -1 1 180 53)
							)
							(1
								(proc10_13 0 self gEgo -1 1 180 54)
							)
							(2
								(proc10_13 3 self gEgo -1 1 180 55)
							)
							(else
								(proc10_13 0 self gEgo -1 1 180 56)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoDo180 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBremenStory state:)
					(2
						(switch (gEgo selection:)
							(0
								(proc10_13 3 gEgo lRooster -1 1 180 57)
								(proc10_13 0 lRooster gEgo -1 0 180 58)
								(proc10_13 1 lRooster gEgo -1 1 180 59)
							)
							(1
								(proc10_13 0 gEgo lRooster -1 1 180 60)
								(proc10_13 0 lRooster gEgo -1 0 180 61)
								(proc10_13 0 lRooster gEgo -1 1 180 62)
							)
							(2
								(proc10_13 0 gEgo lRooster -1 1 180 63)
								(proc10_13 0 lRooster gEgo -1 0 180 64)
								(proc10_13 3 lRooster gEgo -1 1 180 65)
							)
							(else
								(proc10_13 0 gEgo lRooster -1 1 180 66)
								(proc10_13 0 lRooster gEgo -1 1 180 67)
							)
						)
					)
					(4
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo lRooster -1 1 180 68)
								(proc10_13 0 lRooster gEgo -1 1 180 69)
								(proc10_13 3 lCat gEgo -1 1 180 70)
							)
							(1
								(proc10_13 0 gEgo lRooster -1 1 180 71)
								(proc10_13 0 lRooster gEgo -1 1 180 72)
								(proc10_13 0 lCat gEgo -1 1 180 73)
							)
							(2
								(proc10_13 0 gEgo lRooster -1 1 180 74)
								(proc10_13 0 lRooster gEgo -1 1 180 75)
								(proc10_13 0 lCat gEgo -1 1 180 76)
							)
							(else
								(proc10_13 0 gEgo lRooster -1 1 180 77)
								(proc10_13 0 lRooster gEgo -1 1 180 78)
								(proc10_13
									0
									lCat
									gEgo
									-1
									1
									(Format @local2 180 79 @global110) ; "Good-bye, %s!"
								)
							)
						)
					)
					(6
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo lRooster -1 1 180 80)
								(proc10_13 0 lRooster lDog -1 1 180 81)
								(proc10_13 0 lDog gEgo -1 1 180 82)
								(proc10_13 3 lCat gEgo -1 0 180 83)
								(proc10_13 0 lCat gEgo -1 1 180 84)
							)
							(1
								(proc10_13 0 gEgo lRooster -1 1 180 85)
								(proc10_13 0 lRooster gEgo -1 1 180 86)
								(proc10_13
									0
									lCat
									gEgo
									-1
									1
									(Format @local2 180 87 @global110) ; "You are very nice, %s."
								)
								(proc10_13 0 lDog gEgo -1 1 180 88)
							)
							(2
								(proc10_13 0 gEgo lRooster -1 1 180 89)
								(proc10_13 0 lRooster gEgo -1 1 180 90)
								(proc10_13 0 lCat gEgo -1 1 180 91)
								(proc10_13 0 lDog gEgo -1 1 180 92)
							)
							(else
								(proc10_13 0 gEgo lRooster -1 1 180 93)
								(proc10_13 0 lRooster gEgo -1 1 180 94)
								(proc10_13 0 lCat gEgo -1 1 180 95)
								(proc10_13 0 lDog gEgo -1 1 180 95)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance lCat of CDAnimal
	(properties
		description {Cat}
		lookStr {The cat has white fur with orange spots.}
		view 642
		talkerID 7
		animRightX -8
		animRightY -10
		animLeftX 8
		animLeftY -10
		animFrontY -4
		animBackY -8
	)

	(method (setUp &tmp temp0)
		((= temp0 ((gInventory at: 5) regActor:)) setUp:)
		(= talkerObj (temp0 talkerObj:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gBremenStory state:)
					(4
						(switch (self selection:)
							(0
								(proc10_13
									3
									self
									gEgo
									-1
									1
									(Format @local2 180 96 @global110) ; "Perhaps, %s, you will find the dog for us, please?"
								)
							)
							(1
								(proc10_13
									0
									self
									gEgo
									-1
									1
									(Format @local2 180 97 @global110) ; "If anyone can find the dog, you can, %s. Please help us."
								)
							)
							(2
								(proc10_13 0 self gEgo -1 1 180 98)
								(proc10_13 0 lRooster gEgo -1 1 180 99)
							)
							(else
								(proc10_13 1 self gEgo -1 1 180 100)
							)
						)
					)
					(6
						(switch (self selection:)
							(0
								(proc10_13
									0
									self
									gEgo
									-1
									1
									(Format @local2 180 101 @global110) ; "The donkey's name is Gray, %s."
								)
							)
							(1
								(proc10_13 0 self gEgo -1 1 180 102)
							)
							(2
								(proc10_13 0 self gEgo -1 1 180 103)
							)
							(else
								(proc10_13
									0
									self
									gEgo
									-1
									1
									(Format @local2 180 104 @global110) ; "I know you will soon find Donkey Gray, %s."
								)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lDog of CDAnimal
	(properties
		description {Dog}
		lookStr {The dog is a brown and grey Scottie dog.}
		view 647
		talkerID 8
		animRightX -10
		animRightY -11
		animLeftX 10
		animLeftY -11
		animFrontY -10
		animBackY -9
	)

	(method (setUp &tmp temp0)
		((= temp0 ((gInventory at: 6) regActor:)) setUp:)
		(= talkerObj (temp0 talkerObj:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gBremenStory state:)
					(6
						(switch (self selection:)
							(0
								(proc10_13
									0
									self
									gEgo
									-1
									0
									(Format @local2 180 105 @global110) ; "Don't be afraid of Bookend, %s."
								)
								(proc10_13 0 self gEgo -1 1 180 106)
							)
							(1
								(proc10_13
									0
									self
									gEgo
									-1
									1
									(Format @local2 180 107 @global110) ; "You are a good pal, %s."
								)
							)
							(2
								(proc10_13 1 self gEgo -1 1 180 108)
							)
							(else
								(proc10_13 0 self gEgo -1 1 180 109)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lDonkey of CDAnimal
	(properties
		description {Donkey}
		lookStr {This is an old grey donkey.}
		view 632
		talkerID 9
		animRightX -20
		animRightY -27
		animLeftX 20
		animLeftY -27
		animFrontY -17
		animBackY -27
	)

	(method (setUp &tmp temp0)
		((= temp0 ((gInventory at: 7) regActor:)) setUp:)
		(= talkerObj (temp0 talkerObj:))
	)
)

(instance stream of Prop
	(properties
		x 69
		y 173
		description {Stream}
		sightAngle 90
		lookStr {Water flows in the stream.}
		view 180
	)
)

(instance tree of Feature
	(properties
		x 68
		y 49
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {This tree is old and very big.}
	)
)

(instance fence of Feature
	(properties
		x 91
		y 140
		description {Fence}
		sightAngle 90
		onMeCheck 4
		lookStr {The fence keeps you from getting too near the stream.}
	)
)

(instance wall of Feature
	(properties
		x 200
		y 35
		description {Wall}
		sightAngle 90
		onMeCheck 16
		lookStr {The wall is around the town.}
	)
)

(instance sign1 of Feature
	(properties
		x 160
		y 56
		description {Sign}
		sightAngle 90
		onMeCheck 32
		lookStr {The sign points east to Bremen Town, south to Bookwyrm's house, and west to the town.}
	)
)

(instance road of Feature
	(properties
		x 199
		y 92
		description {Road}
		sightAngle 90
		onMeCheck 64
		lookStr {The road leads east, south, and west.}
	)
)

(instance rocks of Feature
	(properties
		x 144
		y 58
		description {Rocks}
		sightAngle 90
		onMeCheck 128
		lookStr {The rocks are big.}
	)
)

(instance flowers of Feature
	(properties
		x 220
		y 54
		description {Flowers}
		sightAngle 90
		onMeCheck 256
		lookStr {The flowers are pretty.}
	)
)

(instance grass of Feature
	(properties
		x 151
		y 136
		description {Grass}
		sightAngle 90
		onMeCheck 512
		lookStr {The grass smells like mint.}
	)
)

