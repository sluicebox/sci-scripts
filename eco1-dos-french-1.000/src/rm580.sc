;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use Interface)
(use HandsOffScript)
(use eRS)
(use RangeOsc)
(use n819)
(use Talker)
(use Language)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Grooper)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm580 0
)

(local
	[local0 50] = [0 0 101 0 267 0 222 95 121 86 170 122 175 129 118 127 150 145 143 152 122 147 110 150 121 166 68 161 64 138 78 127 109 127 75 108 57 114 39 93 45 129 14 139 0 143 45 189 0 189]
	[local50 48] = [0 0 101 0 93 21 120 43 115 74 126 84 135 95 169 119 175 129 118 127 150 145 143 152 122 147 115 152 117 164 72 162 59 137 74 128 109 127 81 111 5 134 13 154 43 189 0 189]
	[local98 50] = [0 -9 319 -10 319 86 122 86 122 110 170 122 175 129 118 127 150 145 143 152 122 147 116 167 67 161 62 138 78 127 109 127 75 108 57 114 34 97 42 132 14 139 0 143 5 157 53 189 0 189]
	[local148 8] = [265 245 223 201 175 174 176 169]
	[local156 8] = [20 19 22 30 31 25 13 11]
	local164 = 1
)

(procedure (localproc_0)
	(cond
		(
			(and
				(IsFlag 88)
				(IsFlag 73)
				(not (IsFlag 100))
				(not (IsFlag 71))
			)
			(gCurRoom setScript: exitToLair)
		)
		((and (IsFlag 73) (not (IsFlag 88)))
			(gCurRoom setScript: smackedByManta)
		)
		((not (IsFlag 73))
			(gCurRoom setScript: delCapture)
		)
	)
)

(procedure (localproc_1 param1 param2 param3) ; UNUSED
	(whale view: 589 loop: param1 cel: 0 posn: param2 param3)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(if (== argc 5)
		(manta hide:)
	)
	(whale
		view: param1
		loop: param2
		cel: 0
		posn: param3 param4
		cycleSpeed: 12
		setCycle: End bigFight
	)
)

(procedure (localproc_3 param1 param2 param3)
	(manta
		view: 588
		setLoop: Grooper
		loop: param3
		cel: 0
		posn: param1 param2
		ignoreHorizon: 1
		cycleSpeed: 12
		show:
		setCycle: Walk
	)
)

(procedure (localproc_4 param1 param2 param3) ; UNUSED
	(manta
		view: 583
		loop: param1
		cel: 0
		posn: param2 param3
		show:
		cycleSpeed: 12
		setCycle: End self
	)
)

(procedure (localproc_5 param1 &tmp [temp0 500])
	(Print (proc932_8 16 580 param1 @temp0) 33 310 67 -1 15 28 global207)
)

(instance rm580 of EcoRoom
	(properties
		picture 580
		style -32761
		horizon 10
		south 560
	)

	(method (init)
		(gFeatures
			add:
				mantaLair
				coral
				cactusPlant
				harpoonGun
				harpoonNozzle
				brokenHull
				rockyLedge
				hornPlant
				boat
				doorWay
				shipExit
			eachElementDo: #init
		)
		(if (IsFlag 98)
			(cabinDoor cel: 1 init:)
			(if (IsFlag 71)
				(shipPoly points: @local98 size: 25)
			else
				(shipPoly points: @local0 size: 25)
			)
			(if (not (IsFlag 341))
				(cable3 init:)
			)
		else
			(cabinDoor cel: 0 init:)
			(shipPoly points: @local50 size: 24)
			(cable1 init:)
			(cable2 init:)
			(cable3 view: 580 loop: 4 cel: 2 posn: 93 121 setPri: 15 init:)
		)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph z: 0 ignoreHorizon: 1 ignoreActors: posn: 243 230 init:)
		)
		(super init: &rest)
		(self setRegions: 51 50) ; bubblesRegion, regionFish
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 175 136 245 136 316 125 316 -10 319 -10 319 189 227 189 229 188 310 162 311 140 254 148 245 158 192 158
					yourself:
				)
				shipPoly
		)
		(cond
			((== gPrevRoomNum 600)
				(cond
					((and (IsFlag 88) (not (IsFlag 135)))
						(gCurRoom setScript: startBigFight)
					)
					(
						(and
							(IsFlag 88)
							(not (IsFlag 100))
							(not (IsFlag 71))
						)
						(LoadMany rsVIEW 588 589 583 581 587 644)
						(whale init: setScript: bigFight)
						(self setScript: fromLairScript)
					)
					((and (IsFlag 88) (not (IsFlag 100)))
						(LoadMany rsVIEW 588 589 583 581 587)
						(whale
							view: 589
							loop: 4
							cel: 0
							x: 140
							y: 51
							init:
							setScript: finalFight
						)
						(self setScript: fromLairScript)
					)
					(else
						(self setScript: fromLairScript)
					)
				)
			)
			((== gPrevRoomNum 620)
				(self setScript: outOfShipScript)
			)
			((and (IsFlag 88) (not (IsFlag 135)))
				(gCurRoom setScript: startBigFight)
			)
			((and (IsFlag 88) (not (IsFlag 71)))
				(LoadMany rsVIEW 588 589 583 581 587)
				(whale init: setScript: bigFight)
				(self setScript: fromCavesScript)
			)
			((IsFlag 88)
				(LoadMany rsVIEW 588 589 583 581 587)
				(whale
					view: 589
					loop: 4
					cel: 0
					x: 140
					y: 51
					init:
					setScript: finalFight
				)
				(self setScript: fromCavesScript)
			)
			(else
				(self setScript: fromCavesScript)
			)
		)
		(if
			(and
				(!= gPrevRoomNum 600)
				(not (IsFlag 71))
				(or (not (IsFlag 135)) (IsFlag 100))
				(or
					(!= (gLongSong number:) 420)
					(== (gLongSong prevSignal:) -1)
				)
			)
			(gLongSong number: 420 loop: -1 play:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator store: 75 init: 74) ; "Adam is swimming in front of a huge, strange cavern. In the distance an undersea mountain rises to a peak. A black cave mouth scars the mountain."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (> gHowFast 0)
			(Palette palANIMATE 34 42 7)
		)
		(cond
			(script 0)
			((gEgo inRect: 250 20 296 83)
				(localproc_0)
			)
			((& (gEgo onControl: 1) $0800)
				(gCurRoom setScript: intoShipScript)
			)
			((== (gEgo edgeHit:) 1)
				(gCurRoom setScript: cantGoThatWay)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromLairScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 809
					loop: 3
					cel: 0
					x: 275
					y: 39
					cycleSpeed: 10
					init:
					setCycle: 0
					setCycle: CT 13 1 self
				)
			)
			(1
				(NormalEgo)
				(gEgo
					loop: 2
					x: 276
					y: 42
					setPri: 11
					ignoreHorizon: 1
					setMotion: PolyPath 143 130 self
				)
			)
			(2
				(if (IsFlag 71)
					(shipPoly points: @local98 size: 25)
					(gEgo setMotion: MoveTo 155 114 self)
				else
					(gEgo setHeading: 0)
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(gEgo setHeading: 0)
				(HandsOn)
				(gTheIconBar disable: (gTheIconBar at: 0))
				(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(gTheIconBar curIcon: (gTheIconBar at: 1))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromCavesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame egoMoveSpeed: 7)
				(HandsOff)
				(if (IsFlag 73)
					(= cycles 1)
				else
					(gDelph setMotion: MoveTo 173 144 self)
				)
			)
			(1
				(NormalEgo)
				(gEgo
					x: 220
					y: 240
					init:
					ignoreHorizon: 1
					setMotion: MoveTo 200 160 self
				)
			)
			(2
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 266 114 self)
				else
					(= cycles 1)
				)
			)
			(3
				(cond
					((not (IsFlag 73))
						(Face gDelph gEgo)
						(gDelph setPri: 3)
						(HandsOn)
						(self dispose:)
					)
					((IsFlag 71)
						(gEgo setMotion: MoveTo 155 114 self)
					)
					(else
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(4
				(gEgo setHeading: 0)
				(HandsOn)
				(gTheIconBar disable: (gTheIconBar at: 0))
				(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(gTheIconBar curIcon: (gTheIconBar at: 1))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance exitToLair of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 84 self) ; "Now that Flesh-Eater is distracted by the mighty whale, Adam is free to enter the beast's lair."
			)
			(1
				(if (and (> 261 (gEgo x:) 275) (> 46 (gEgo y:) 48))
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 275 60 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 275 52 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 101
					setLoop: 0
					cel: 4
					x: 271
					y: 41
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance outOfShipScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(gEgo
					setPri: 7
					posn: 10 90
					init:
					ignoreHorizon: 1
					setMotion: MoveTo 63 125 self
				)
				(if (not (IsFlag 85))
					(gEgo setScript: whaleSoundScript)
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance intoShipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((IsFlag 88)
						(Narrator init: 59 self) ; "Adam can't desert Cetus now!"
						(= state 2)
					)
					((& (gEgo onControl: 1) $0800)
						(= cycles 1)
					)
					(else
						(gEgo setMotion: PolyPath 50 111 self)
					)
				)
			)
			(1
				(gEgo setPri: 7 setMotion: MoveTo -4 84 self)
			)
			(2
				(SetScore 5 338)
				(gCurRoom newRoom: 620)
			)
			(3
				(if (not (& (gEgo onControl: 1) $0800))
					(HandsOn)
					(= state 5)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 63 125 self)
				)
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(HandsOn)
				(= state 6)
				(= cycles 1)
			)
			(6
				(if (IsFlag 71)
					(gTheIconBar disable: 0)
				)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance delCapture of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 500] temp500)
		(switch (= state newState)
			(0
				(gLongSong number: 580 loop: -1 play:)
				(Narrator init: 86 self) ; "Adam, I don't like the looks of it here."
			)
			(1
				(gEgo setMotion: PolyPath 251 78 self)
			)
			(2
				(Face gDelph gEgo)
				(gDelph setPri: 3)
				(gEgo setHeading: 180)
				(= seconds 3)
			)
			(3
				(Narrator init: 87 self) ; "Sssh! What's the matter with you? The prophecy has been right so far."
			)
			(4
				(Narrator init: 88 self) ; "I know, but I feel sort of funny, like something's watching us."
			)
			(5
				(Narrator init: 89 self) ; "Don't be such a baby... Wow, take a look at that cave! And this ship, I think it's a whaling vessel, recent, too!"
			)
			(6
				(manta view: 580 loop: 6 cel: 1 posn: 273 34 init:)
				(= seconds 3)
			)
			(7
				(Narrator init: 90 self) ; "A-a-dam..."
			)
			(8
				(Narrator init: 91 self) ; "What is it?"
			)
			(9
				(Narrator init: 92 self) ; "Be-behind you!..."
			)
			(10
				(gEgo setHeading: 0 self)
			)
			(11
				(manta cycleSpeed: 20 setCycle: End self)
			)
			(12
				(Narrator init: 93 self) ; "Flesh-Eater!!!! RUN!"
			)
			(13
				(gLongSong number: 340 loop: -1 play:)
				(gEgo setPri: 3 setMotion: DPath 112 32 60 32 self)
				(gDelph setMotion: DPath 116 64 64 56 self)
			)
			(14 0)
			(15
				(gEgo hide:)
				(gDelph hide:)
				(manta
					view: 603
					setLoop: 0
					cel: 0
					x: [local148 0]
					y: [local156 0]
				)
				(Animate (gCast elements:) 1)
				(for ((= temp500 1)) (< temp500 8) ((++ temp500))
					(Wait 0)
					(Wait 10)
					(manta
						x: [local148 temp500]
						y: [local156 temp500]
						cel: temp500
					)
					(Animate (gCast elements:) 1)
				)
				(manta hide:)
				(Animate (gCast elements:) 1)
				(gCurRoom newRoom: 345)
			)
		)
	)
)

(instance tryToPryOpenDoor of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 75 100 self)
			)
			(1
				(gEgo setMotion: MoveTo 73 100 self)
			)
			(2
				((gEgo looper:) dispose:)
				(gEgo setCycle: 0 looper: 0)
				(= cycles 1)
			)
			(3
				(gEgo
					view: 581
					setLoop: 5
					cel: 0
					x: 43
					y: 103
					cycleSpeed: 17
					setCycle: End self
				)
			)
			(4
				(gEgo setMotion: MoveTo 50 103 self)
			)
			(5
				(NormalEgo)
				(gEgo x: 74 y: 105 ignoreHorizon: 1)
				(= cycles 1)
			)
			(6
				((ScriptID 2 1) init: 5) ; Adam, "It's stuck! That cable is really wedged in there."
				(self dispose:)
			)
		)
	)
)

(instance pryOpenDoor of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 5 336)
				(gEgo setPri: 13 setMotion: PolyPath 15 134 self)
			)
			(1
				(gEgo setMotion: MoveTo 15 114 self)
			)
			(2
				(= cycles 12)
			)
			(3
				(Narrator init: 24 self) ; "Adam wedges the trident under the crack of the bloated ship's door and pushes on the handle as hard as he can."
			)
			(4
				((gCurRoom obstacles:) delete: shipPoly)
				(gEgo
					setCycle: 0
					view: 581
					loop: 0
					cel: 0
					posn: 17 118
					cycleSpeed: 18
					setCycle: ForwardCounter 3 self
				)
			)
			(5
				(Narrator posn: -1 20 init: 25 self) ; "The waterlogged wood suddenly gives way and the door pops free of it's frame!"
			)
			(6
				(cable1 dispose:)
				(cable2 dispose:)
				(cabinDoor cel: 1 forceUpd:)
				(shipPoly points: @local0 size: 25)
				(SetFlag 98)
				(gEgo
					view: 581
					loop: 1
					cel: 0
					posn: 17 118
					setCycle: End self
				)
				(gSoundEffects number: 584 loop: 1 play:)
				(cable3
					view: 580
					loop: 5
					setPri: 14
					cel: 0
					posn: 88 83
					cycleSpeed: 8
					setCycle: ForwardCounter 4 self
				)
			)
			(7
				(gEgo setScript: whaleSoundScript)
				0
			)
			(8
				(cable3
					view: 580
					loop: 4
					cel: 3
					posn: 25 17
					setPri: 14
					ignoreActors:
				)
				(= cycles 1)
			)
			(9
				(Narrator posn: -1 20 init: 26 self) ; "The cable that had been jammed under the door suddenly jerks tight as though pulled by a mighty weight."
			)
			(10
				(= cycles 2)
			)
			(11
				(Narrator posn: -1 20 init: 27) ; "...And through the open ship's door, Adam hears a sound..."
				(NormalEgo)
				(gEgo ignoreHorizon: 1 setPri: 13 posn: 2 110)
				((gCurRoom obstacles:) add: shipPoly)
				(= cycles 12)
			)
			(12
				(gEgo cycleSpeed: 10 setMotion: MoveTo 43 139 self)
			)
			(13
				(Narrator store: 29 init: 28 self) ; "...a sound unmistakably sad, unmistakably deep, unmistakably haunting..."
			)
			(14
				(gEgo setPri: -1 setScript: whaleSoundScript)
				(= cycles 2)
			)
			(15
				(gEgo setHeading: 0 self)
			)
			(16
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance startBigFight of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whale
					x: 0
					y: 56
					view: 589
					setLoop: 4
					cel: 0
					init:
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(1
				(whale setMotion: MoveTo 129 56 self)
				(gEgo
					view: 809
					setLoop: 3
					cel: 0
					x: 0
					y: 65
					init:
					setCycle: 0
					posn: 0 65
					moveSpeed: 6
					cycleSpeed: 7
					setMotion: MoveTo 129 65 self
				)
			)
			(2 0)
			(3
				(gEgo
					view: 809
					setLoop: 3
					cel: 0
					setCycle: End self
					setMotion: MoveTo 186 99 self
				)
			)
			(4 0)
			(5
				(NormalEgo)
				(gEgo ignoreHorizon: 1)
				(= cycles 3)
			)
			(6
				(gEgo setHeading: 0)
				(= cycles 4)
			)
			(7
				(localproc_5 1)
				(= cycles 1)
			)
			(8
				(gSoundEffects number: 646 loop: 1 play: self)
			)
			(9
				(whale setScript: bigFight)
				(self dispose:)
			)
		)
	)
)

(instance bigFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (!= (gLongSong number:) 665) (not (IsFlag 71)))
					(gLongSong number: 664 loop: -1 hold: 0 play:)
				)
				(if (not (IsFlag 135))
					(SetFlag 135)
					(manta
						init:
						setLoop: Grooper
						setPri: 1
						view: 590
						moveSpeed: 3
						loop: 0
						cel: 0
						x: 175
						y: 26
						setCycle: End self
					)
				else
					(manta
						init:
						moveSpeed: 3
						setLoop: Grooper
						setCycle: Fwd
						setPri: 1
						hide:
					)
					(= cycles 1)
				)
			)
			(1
				(manta setCycle: Fwd hide:)
				(whale
					view: 583
					loop: 0
					cel: 0
					posn: 152 57
					setPri: 1
					ignoreActors:
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(whale view: 589 loop: 4 cel: 0 x: 129 y: 57 setCycle: Fwd)
				(localproc_3 172 22 4)
				(manta setMotion: DPath 223 63 218 77 164 75 self)
			)
			(3
				(whale loop: 0 cel: 0 setCycle: End)
				(manta setMotion: DPath 111 64 89 36 129 7 self)
			)
			(4
				(whale x: 143 y: 56 view: 583 loop: 7 cel: 3 setCycle: Beg self)
				(manta setMotion: DPath 146 24 134 33 self)
			)
			(5
				(whale setCycle: End self)
			)
			(6
				(localproc_2 583 1 151 62 1)
			)
			(7
				(whale
					view: 589
					setLoop: 5
					cel: 0
					x: 149
					y: 61
					setCycle: Fwd
					setMotion: MoveTo 128 56
				)
				(localproc_3 130 33 0)
				(manta setMotion: DPath 195 10 262 30 192 46 self)
			)
			(8
				(localproc_2 583 3 135 36 1)
			)
			(9
				(whale view: 589 loop: 5 cel: 0 x: 128 y: 56 setCycle: Fwd)
				(localproc_3 72 73 1)
				(manta setMotion: DPath 136 108 151 101 144 81 self)
			)
			(10
				(localproc_2 583 5 127 56 1)
			)
			(11
				(whale view: 589 loop: 5 cel: 0 x: 140 y: 54 setCycle: Fwd)
				(localproc_3 124 31 1)
				(manta setMotion: DPath 87 32 136 15 self)
			)
			(12
				(whale x: 139 loop: 1 cel: 0 setCycle: End self)
				(manta setMotion: DPath 191 14 208 44 125 105 77 54 self)
			)
			(13
				(whale x: 140 y: 57 loop: 4 setCycle: Fwd)
			)
			(14
				(localproc_2 583 2 156 37 1)
			)
			(15
				(whale view: 589 setLoop: 4 cel: 0 x: 128 y: 60 setCycle: Fwd)
				(localproc_3 203 48 1)
				(manta setMotion: DPath 136 73 85 72 139 113 150 83 self)
			)
			(16
				(localproc_2 583 4 139 58 1)
			)
			(17
				(whale view: 589 loop: 4 cel: 0 x: 129 y: 56 setCycle: Fwd)
				(localproc_3 170 33 0)
				(manta
					setMotion:
						DPath
						194
						43
						244
						90
						296
						50
						292
						20
						149
						5
						138
						15
						152
						29
						self
				)
			)
			(18
				(manta hide:)
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance finalFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manta
					init:
					moveSpeed: 2
					setLoop: Grooper
					setPri: 1
					setCycle: Fwd
					hide:
				)
				(= cycles 1)
			)
			(1
				(whale x: 140 y: 51 view: 589 loop: 4 cel: 0 setCycle: Fwd)
				(manta
					x: 187
					y: 17
					view: 588
					loop: 4
					cel: 0
					show:
					setMotion:
						DPath
						218
						47
						248
						60
						282
						57
						303
						43
						302
						36
						298
						23
						self
				)
			)
			(2
				(if local164
					(manta setMotion: MoveTo 279 13 self)
				else
					(gCurRoom setScript: endOfFight)
				)
			)
			(3
				(manta setMotion: DPath 210 12 194 19 175 32 self)
			)
			(4
				(if (and (== (gEgo script:) stickManta) local164)
					((gEgo script:) cue:)
				)
				(manta hide:)
				(whale view: 583 loop: 0 cel: 2 x: 165 y: 52 setCycle: End self)
			)
			(5
				(= state 0)
				(self cue:)
			)
			(6
				(manta setMotion: DPath 249 25 226 51 206 45 self)
			)
		)
	)
)

(instance endOfFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 56 self) ; "There's a moment of terror in which Adam is sure the poison will not be enough to even slow down the huge beast!"
			)
			(1
				(manta setMotion: DPath 249 25 226 51 206 45 self)
			)
			(2
				(manta hide:)
				(whale
					view: 583
					loop: 10
					cel: 0
					posn: 173 57
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(Narrator init: 57 self) ; "But it's enough to make him hesitate in his attack, if only for a moment..."
			)
			(4
				(whale view: 583 loop: 6 cel: 0 x: 153 y: 45 setCycle: End)
				(manta
					view: 583
					setLoop: 9
					cel: 0
					x: 180
					y: 61
					show:
					setCycle: End self
				)
			)
			(5
				(gLongSong number: 667 loop: -1 play:)
				(Narrator init: 58 self) ; "And that moment is enough!"
			)
			(6
				(manta cel: 1 x: 174 y: 91 setCycle: End self)
				(whale view: 589 loop: 4 cel: 0 x: 140 y: 49 setCycle: Fwd)
			)
			(7
				(manta cel: 1 x: 168 y: 122 setCycle: CT 4 1 self)
			)
			(8
				(SetFlag 100)
				(ShakeScreen 5 ssUPDOWN)
				(= cycles 15)
			)
			(9
				(NormalDelph)
				(gDelph
					z: 0
					ignoreHorizon: 1
					ignoreActors:
					posn: 243 230
					init:
					setMotion: PolyPath 230 110 self
				)
			)
			(10
				((ScriptID 2 0) init: 5 1 self) ; Delphineus, "Cetus! It's really you! And you killed Flesh-Eater! Unbelievable!"
			)
			(11
				(localproc_5 3)
				(localproc_5 4)
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "But where were you and how did Adam find you and why did you disappear for so long and how..."
			)
			(12
				(localproc_5 5)
				(= cycles 1)
			)
			(13
				(gCurRoom newRoom: 101)
			)
		)
	)
)

(instance stickManta of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 51 self) ; "Adam arms himself with the tiny lionfish spine, and with all the courage he can muster, and heads towards the black monster."
			)
			(1
				(gEgo setCycle: 0)
			)
			(2
				(gEgo
					view: 581
					setLoop: 2
					setPri: 15
					cel: 0
					x: 181
					y: 98
					setMotion: MoveTo 218 47
					setCycle: CT 10 1 self
				)
			)
			(3
				(gEgo setCycle: RangeOsc -1 11 13)
				(= cycles 1)
			)
			(4
				(if
					(not
						(and
							(< (Abs (- (gEgo x:) (manta x:))) 3)
							(< (Abs (- (gEgo y:) (manta y:))) 3)
						)
					)
					(-= state 1)
					(= cycles 1)
				else
					(= local164 0)
					(= cycles 1)
				)
			)
			(5
				(Narrator init: 54 self) ; "While the manta is distracted by Cetus, Adam manages to get close to one huge, black wing!"
			)
			(6
				(Narrator init: 55 self) ; "And pierce the tough hide with the lionfish spine!"
			)
			(7
				(gSoundEffects number: 583 loop: 1 play: self)
			)
			(8
				(SetScore 20 337)
				(gEgo
					put: 17 ; spine
					view: 809
					setLoop: 3
					cel: 0
					x: (+ (gEgo x:) 4)
					y: (+ (gEgo y:) 5)
					cycleSpeed: 8
					moveSpeed: 6
					setCycle: End self
				)
			)
			(9
				(NormalEgo)
				(gEgo setMotion: MoveTo 179 108 self)
			)
			(10
				(gEgo setHeading: 0 self)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance tryToStabManta of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 51 self) ; "Adam arms himself with the tiny lionfish spine, and with all the courage he can muster, and heads towards the black monster."
			)
			(1
				(gEgo setCycle: 0)
				(= cycles 1)
			)
			(2
				(if (mod (manta cel:) 2)
					(= temp1 (- (manta x:) 15))
				else
					(= temp1 (+ (manta x:) 15))
				)
				(gEgo
					view: 581
					setLoop: 2
					setPri: 15
					cel: 0
					x: 181
					y: 98
					setMotion: MoveTo temp1 (+ (manta y:) 10)
					setCycle: CT 10 1 self
				)
			)
			(3
				(gEgo setCycle: RangeOsc -1 11 13 moveSpeed: 2)
				(= cycles 1)
			)
			(4
				(if
					(and
						(IsObject (manta mover:))
						(< 177 ((manta mover:) x:) 314)
						(< 9 ((manta mover:) y:) 107)
					)
					(gEgo setMotion: MoveTo (manta x:) (manta y:))
					(= cycles 2)
				else
					(-= state 1)
					(= cycles 1)
				)
			)
			(5
				(if
					(not
						(and
							(< (Abs (- (gEgo x:) (manta x:))) 3)
							(< (Abs (- (gEgo y:) (manta y:))) 3)
						)
					)
					(-= state 2)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(6
				(Narrator init: 52 self) ; "But before he can wield his weapon, he is spotted by the manta and flicked disdainfully away."
			)
			(7
				(gEgo
					view: 587
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 4)
					y: (+ (gEgo y:) 3)
					setPri: 3
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: CT 9 1 self
					setMotion: MoveTo 179 108
				)
			)
			(8
				(gEgo
					view: 644
					setLoop: 0
					cel: 2
					x: (gEgo x:)
					y: (gEgo y:)
					setCycle: Walk
					setMotion: MoveTo 179 108 self
				)
			)
			(9
				(Narrator init: 53 self) ; "He'll have to be more careful in his approach if he's to get close enough to use the spine."
			)
			(10
				(NormalEgo)
				(gEgo setHeading: 0 self)
			)
			(11
				(HandsOn)
				(gTheIconBar disable: (gTheIconBar at: 0))
				(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(gTheIconBar curIcon: (gTheIconBar at: 1))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance smackedByManta of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 30 self) ; "Adam gathers up his courage and approaches Flesh-Eater's lair, determined to save his friend Delphineus."
			)
			(1
				(gEgo setMotion: PolyPath 243 58 self)
			)
			(2
				(= cycles 12)
			)
			(3
				(gEgo
					setCycle: 0
					view: 101
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(4
				(manta
					view: 587
					loop: 1
					cel: 0
					posn: 265 40
					cycleSpeed: 12
					init:
					setCycle: CT 5 1
				)
				(gEgo setCycle: End self)
			)
			(5
				(manta setCycle: End self)
				(gEgo
					view: 587
					loop: 0
					cel: 0
					posn: 246 50
					setCycle: End self
				)
			)
			(6
				(Narrator init: 31 self) ; "But the horrid manta is not in the mood for guests and sends Adam flying as easily as a human might swat a gnat."
			)
			(7
				(manta dispose:)
				(= cycles 1)
			)
			(8 0)
			(9
				(NormalEgo)
				(gEgo posn: 246 50 ignoreHorizon: 1)
				(= cycles 3)
			)
			(10
				(Narrator init: 32) ; "Adam is no match for the great brute. If Delphineus is to be saved, Adam must find Cetus!"
				(self dispose:)
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whaleSound loop: 1 play: self)
			)
			(1
				(= state -1)
				(= seconds 8)
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 647
	)
)

(instance cantGoThatWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Narrator init: 11 self) ; "Adam would be cut to ribbons on the cliff wall if he swam that way."
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 7) self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mantaLair of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 15) ; "Flesh-Eater's lair looms in the distance. Adam eyes it nervously."
				else
					(Narrator init: 14) ; "Far in the distance is a cave mouth. It looks like a gaping wound."
				)
			)
			(3 ; Do
				(if (IsFlag 71)
					(Narrator init: 85) ; "Delphineus has been released. Adam has no reason to go back to the manta's lair."
				else
					(localproc_0)
				)
			)
			(5 ; Talk
				(Narrator init: 63) ; "The cave is too far away for anyone to hear Adam's call."
			)
			(4 ; Inventory
				(Narrator init: 64) ; "Adam can't do anything to the horrid cave."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coral of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 10) ; "The wall of coral rises, sharp and jagged, as high as Adam can see. The only way to the other side is through the ship."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cactusPlant of Feature
	(properties
		onMeCheck 8
		lookStr 17
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 17) ; "Tube coral here has taken on a strange and very unnatural color."
			)
			(3 ; Do
				(Narrator init: 65) ; "Adam doesn't want to touch these strange plants!"
			)
			(4 ; Inventory
				(Narrator init: 66) ; "Adam doesn't want anything to do with these strange plants."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance harpoonGun of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "The harpoon gun is a reminder of the dreadful practice of whale hunting. This one has been triggered."
				(if (not (IsFlag 341))
					(Narrator store: 94)
				)
			)
			(3 ; Do
				(Narrator init: 13) ; "The gun is jammed from its last firing."
			)
			(4 ; Inventory
				(Narrator init: 70) ; "The harpoon gun has already caused all the damage it will ever cause and is no longer of concern to Adam."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance brokenHull of Feature
	(properties
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 19) ; "The boards of the hull are battered and broken."
			)
			(3 ; Do
				(Narrator init: 20) ; "The hull is too broken to repair."
			)
			(4 ; Inventory
				(Narrator init: 67) ; "Adam can't do anything with the broken hull."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rockyLedge of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 10) ; "The wall of coral rises, sharp and jagged, as high as Adam can see. The only way to the other side is through the ship."
			)
			(3 ; Do
				(Narrator init: 12) ; "The wall is full of jagged coral."
			)
			(4 ; Inventory
				(Narrator init: 73) ; "Adam can't alter the coral cave."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hornPlant of Feature
	(properties
		onMeCheck 16
		lookStr 18
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 65) ; "Adam doesn't want to touch these strange plants!"
			)
			(4 ; Inventory
				(Narrator init: 66) ; "Adam doesn't want anything to do with these strange plants."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance harpoonNozzle of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 6) ; "The harpoon gun appears to have been fired recently."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boat of Feature
	(properties
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 3) ; "A modern harpooning vessel has rammed into the reef shelf. Only the prow is visible."
			)
			(4 ; Inventory
				(Narrator init: 72) ; "Adam can't do anything with the ship's cabin."
			)
			(3 ; Do
				(Narrator init: 71) ; "There's nothing Adam can do with the ship's cabin."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorWay of Feature
	(properties
		onMeCheck 4096
	)

	(method (onMe)
		(return
			(if (cabinDoor cel:)
				(super onMe: &rest)
			else
				0
			)
		)
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 88)
					(Narrator init: 34) ; "The ship's door is open."
				else
					(Narrator init: 33) ; "The ship's door is now open and the sound of a whale's call drifts from somewhere on the other side of the ship."
				)
			)
			(3 ; Do
				(gCurRoom setScript: intoShipScript)
			)
			(5 ; Talk
				(Narrator init: 76) ; "There is no response from beyond the ship's door."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shipExit of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(doorWay doVerb: theVerb invItem &rest)
	)
)

(instance cabinDoor of View
	(properties
		x 47
		y 98
		view 581
		loop 3
		priority 6
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((not (IsFlag 98))
						(Narrator store: 61 init: 1) ; "The ship's cabin door is jammed shut."
					)
					((IsFlag 88)
						(Narrator init: 34) ; "The ship's door is open."
					)
					(else
						(Narrator init: 33) ; "The ship's door is now open and the sound of a whale's call drifts from somewhere on the other side of the ship."
					)
				)
			)
			(3 ; Do
				(if (not cel)
					(gCurRoom setScript: tryToPryOpenDoor)
				)
			)
			(5 ; Talk
				(if (IsFlag 98)
					(Narrator init: 76) ; "There is no response from beyond the ship's door."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(4 ; Inventory
				(cond
					((== invItem 12) ; trident
						(if (not (IsFlag 98))
							(if (not (IsFlag 73))
								(gCurRoom setScript: delCapture)
							else
								(gCurRoom setScript: pryOpenDoor)
							)
						else
							(Narrator init: 77) ; "The door is already open."
						)
					)
					((not (IsFlag 98))
						(Narrator init: 81) ; "That won't open the ship's door."
					)
					(else
						(Narrator init: 77) ; "The door is already open."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance whale of Actor
	(properties
		x 152
		y 57
		view 583
		priority 1
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 100))
					(if (IsFlag 71)
						(Narrator init: 36) ; "Cetus is losing ground in the battle. Flesh-Eater shrewdly concentrates his attacks on the whale's harpoon wound and Cetus, in return, seems unable to land a solid blow against his quick-moving opponent. Despite his bravery, Cetus clearly could use some help."
					else
						(Narrator store: 36 init: 35) ; "Cetus is trying hard to keep up with Flesh-Eater, but he's weakened from his recent ordeal and lack of food."
					)
				)
			)
			(3 ; Do
				(if (not (IsFlag 100))
					(Narrator init: 38) ; "Adam's done all he can to strengthen Cetus, there's nothing he can do to him now."
				)
			)
			(5 ; Talk
				(if (not (IsFlag 100))
					(if (IsFlag 71)
						(Narrator init: 37) ; "The whale is struggling to maintain his ground in the battle and isn't paying attention to Adam."
					else
						(localproc_5 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; spine
						(Narrator init: 78) ; "Be careful with that spine! Adam doesn't want to stick Cetus."
					)
					(21 ; healingPotion
						(Narrator init: 79)
					)
					(else
						(Narrator init: 80) ; "That won't help Cetus."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance manta of Actor
	(properties
		view 588
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator store: 42 init: 41) ; "Flesh-Eater is crazed and vicious, enraged that Cetus has escaped his trap. He's exploiting Cetus' weakness by attacking the fresh harpoon wound."
			)
			(3 ; Do
				(if (not (IsFlag 71))
					(localproc_5 2)
				else
					(Narrator init: 43) ; "Adam can't fight the manta with his bare hands."
				)
			)
			(5 ; Talk
				(Narrator init: 39) ; "Though once an Elurian, the toxic waste has mutated Flesh-Eater beyond all sense of reasoning. He does not speak."
			)
			(10 ; Recycle
				(Narrator init: 44) ; "Ah, if only it were that simple!"
			)
			(4 ; Inventory
				(if (IsFlag 71)
					(switch invItem
						(17 ; spine
							(if (== ((whale script:) state:) 3)
								(gEgo setScript: stickManta)
							else
								(gEgo setScript: tryToStabManta)
							)
						)
						(12 ; trident
							(Narrator init: 45) ; "The trident's points would be but a pin prick to the enraged manta."
						)
						(30 ; hackSaw
							(Narrator init: 46) ; "Flesh-Eater would never stand still for the length of time it would take to do any real damage with that saw. Besides, that would be gross!"
						)
						(13 ; sharpShell
							(Narrator init: 48) ; "That would barely scratch the surface of the problem."
						)
						(21 ; healingPotion
							(Narrator init: 50)
						)
						(else
							(Narrator init: 49) ; "That won't stop the rampaging manta!"
						)
					)
				else
					(localproc_5 2)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cable1 of View
	(properties
		x 44
		y 43
		view 580
		loop 4
		priority 4
		signal 20497
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator store: 60 init: 5) ; "The thick, steel cable from the gun is wedged under the ship's door, then continues up into the coral cave."
			)
			(3 ; Do
				(Narrator init: 11) ; "Adam would be cut to ribbons on the cliff wall if he swam that way."
			)
			(4 ; Inventory
				(Narrator init: 69) ; "Adam can't do anything to the cable from this side of the coral cave."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cable2 of View
	(properties
		x 63
		y 79
		view 580
		loop 4
		cel 1
		priority 15
		signal 20497
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator store: 60 init: 5) ; "The thick, steel cable from the gun is wedged under the ship's door, then continues up into the coral cave."
			)
			(3 ; Do
				(Narrator init: 21) ; "The cable is stuck fast in the door."
			)
			(4 ; Inventory
				(Narrator init: 69) ; "Adam can't do anything to the cable from this side of the coral cave."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cable3 of Prop
	(properties
		x 25
		y 17
		view 580
		loop 4
		cel 3
		priority 14
		signal 20497
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 98)
					(Narrator init: 83) ; "There's something big on the other end of that cable!"
				else
					(Narrator store: 60 init: 5) ; "The thick, steel cable from the gun is wedged under the ship's door, then continues up into the coral cave."
				)
			)
			(3 ; Do
				(if (IsFlag 98)
					(Narrator init: 62) ; "The cable is pulled taunt by something powerful on the other end. There's no way Adam can pull it in."
				else
					(Narrator init: 21) ; "The cable is stuck fast in the door."
				)
			)
			(4 ; Inventory
				(Narrator init: 69) ; "Adam can't do anything to the cable from this side of the coral cave."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shipPoly of Polygon
	(properties
		type PBarredAccess
	)
)

