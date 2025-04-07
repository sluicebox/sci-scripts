;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use OccCyc)
(use Interface)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm500 of GloryRm
	(properties
		picture 500
		east 571
		south 571
	)

	(method (init)
		(Palette 2 0 255 100) ; PalIntensity
		(if gDebugging
			(if (GetNumber {Want Igor dead? (1 yes, 0 no)})
				(SetFlag 38)
			else
				(ClearFlag 38)
			)
			(SetFlag 37)
		)
		(cond
			((and (IsFlag 37) (not (IsFlag 48)))
				(= local0 4)
				(if (not (IsFlag 236))
					(igor init:)
				)
			)
			(gNight
				(if (not (IsFlag 230))
					(= local0 3)
				)
			)
			((not (IsFlag 229))
				(= local0 1)
			)
			((and (not (IsFlag 37)) (not (IsFlag 231)))
				(= local0 2)
				(SetFlag 231)
				(igor init:)
			)
			(else
				(headStone init: setPri: 138)
				(if (IsFlag 236)
					(headStone cel: 0)
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 176 250 162 250 142 220 132 242 114 242 106 189 106 189 97 241 97 222 75 192 75 132 100 158 100 158 110 137 112 118 106 118 100 103 101 118 115 94 119 115 129 69 170 119 189 0 189 0 0 319 0
					yourself:
				)
				(if
					(or
						(== local0 2)
						(== local0 4)
						(gCast contains: headStone)
					)
					((Polygon new:)
						type: PBarredAccess
						init: 86 169 121 135 187 135 130 179
						yourself:
					)
				else
					((Polygon new:)
						type: PBarredAccess
						init: 86 169 142 137 161 136 170 143 130 179
						yourself:
					)
				)
		)
		(super init: &rest)
		(gEgo init: normalize: setScaler: Scaler 110 65 129 87)
		(= local1 224)
		(= local2 181)
		(if (!= gPrevRoomNum 510)
			(if (== gPrevRoomNum 810) ; combat
				(self setScript: sFromCombat)
			else
				(gEgo posn: 265 240)
				(self setScript: sEnterScr)
			)
		else
			(gEgo posn: -500 0)
			(self setScript: sFromCrypt)
		)
		(door init: setPri: 85 approachVerbs: 4 29 42) ; Do, theKeyRing, theToolkit
		(graveStone init: setPri: 106)
		(ligeiaDoor init: setPri: 131 approachVerbs: 4) ; Do
		(moss init: setPri: 148)
		(moss2 init: setPri: 148)
		(moss3 init: setPri: 148)
		(moss4 init: setPri: 148)
		(moss5 init: setPri: 148)
		(shadow init:)
		(shadow2 setPri: 148 init:)
		(shadow3 setPri: 130 init:)
		(coffin init:)
		(coffin2 init:)
		(rusalkaGrave approachVerbs: 4 58 1 init:) ; Do, theBroom, Look
		(loverGrave init: approachVerbs: 4 58 1) ; Do, theBroom, Look
		(cryptDoor init: approachVerbs: 4 29 42 1) ; Do, theKeyRing, theToolkit, Look
		(doorTeller init: cryptDoor 500 39 155 11)
		(crypt init:)
		(grave1 init:)
		(grave2 init:)
		(grave3 init:)
		(grave4 init:)
		(grave5 init:)
		(urn1 init:)
		(urn2 init:)
		(ligeiaDoorF init: approachVerbs: 4) ; Do
		(ligeiaTomb init:)
		(ligeiaTop init:)
		(thinTree init:)
		(thinBranch init:)
		(bigBranch init:)
		(bigTrunk init: approachVerbs: 4) ; Do
		(coffins init:)
		(dirtPile init:)
		(openGrave init:)
		(gLongSong number: 500 setLoop: -1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((and (== (gEgo view:) 7) (gEgo mover:))
				(gCurRoom setScript: sClimbDown)
			)
		)
	)

	(method (dispose)
		(if (gLongSong2 number:)
			(gLongSong2 stop:)
		)
		(super dispose:)
	)
)

(instance sEgosGone of Script
	(properties)

	(method (dispose)
		(gEgo changeGait: local5 moveSpeed: local4 cycleSpeed: local3)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 30)
			)
			(1
				(= local5 gEgoGait)
				(= local3 (gEgo cycleSpeed:))
				(= local4 (gEgo moveSpeed:))
				(gEgo
					changeGait: 1 ; running
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: MoveTo 242 260 self
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sChip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 7 15))
			)
			(1
				(client
					signal: (| (client signal:) $0001)
					setLoop: 0
					setCycle: Fwd
				)
				(= seconds (Random 3 6))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(client setLoop: 1 setCel: 0)
				(if (Random 0 1)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (!= local0 2)
					(gLongSong2 number: 983 setLoop: -1 play:)
				)
				(gEgo setMotion: MoveTo local1 local2 self)
			)
			(1
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(2
				(cond
					(gNight
						(if (not (IsFlag 230))
							(SetFlag 230)
							(= register 1)
							(gMessager say: 37 6 20 0 self) ; "You have entered an eerie deserted graveyard. Strange moans wail through the trees, and mysterious lights seem to flicker and fade among the tombstones. Two large crypts dominate the cemetery."
						else
							(self cue:)
						)
					)
					((not (IsFlag 229))
						(SetFlag 229)
						(gMessager say: 37 6 18 0 self) ; "The majestic mountains in the background provide a beautiful contrast to the grim gravestones and crypts of the cemetery."
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (and register (== gHeroType 3)) ; Paladin
					(gMessager say: 37 6 21 0 self) ; "You have a bad feeling about this place. There doesn't seem to be any immediate danger, but you suspect that death lies among the crypts and tombstones in this place."
				else
					(self cue:)
				)
			)
			(4
				(if (and (!= local0 2) (> (gGlory detailLevel:) 1))
					(moss setScript: sWind)
				)
				(if (and (== local0 4) (not (IsFlag 38)))
					(soundFX number: 854 play:)
					(self cue:)
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(5
				(gMessager say: 37 6 22) ; "You hear a monstrous groaning noise from beneath the fallen tombstone. Perhaps a horrible monster waits below!"
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromCrypt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (!= local0 2)
					(gLongSong2 number: 983 setLoop: -1 play:)
				)
				(door signal: (| (door signal:) $0001) setCycle: End self)
			)
			(1
				(door setPri: 0 signal: (& (door signal:) $fffe))
				(gEgo
					posn: 87 124
					setLoop: 4 1
					setPri: 2
					setMotion: MoveTo 111 100 self
				)
			)
			(2
				(door signal: (| (door signal:) $0001) setCycle: Beg self)
				(gEgo normalize: 4)
			)
			(3
				(door signal: (& (door signal:) $fffe))
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(4
				(cond
					(gNight
						(if (not (IsFlag 230))
							(SetFlag 230)
							(= register 1)
							(gMessager say: 37 6 20 0 self) ; "You have entered an eerie deserted graveyard. Strange moans wail through the trees, and mysterious lights seem to flicker and fade among the tombstones. Two large crypts dominate the cemetery."
						else
							(self cue:)
						)
					)
					((not (IsFlag 229))
						(SetFlag 229)
						(gMessager say: 37 6 18 0 self) ; "The majestic mountains in the background provide a beautiful contrast to the grim gravestones and crypts of the cemetery."
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(if (and register (== gHeroType 3)) ; Paladin
					(gMessager say: 37 6 21 0 self) ; "You have a bad feeling about this place. There doesn't seem to be any immediate danger, but you suspect that death lies among the crypts and tombstones in this place."
				else
					(self cue:)
				)
			)
			(6
				(if (!= local0 2)
					(moss setScript: sWind)
				)
				(if (and (== local0 4) (not (IsFlag 38)))
					(gLongSong2 number: 983 setLoop: -1 play:)
					(self cue:)
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(7
				(gMessager say: 37 6 22) ; "You hear a monstrous groaning noise from beneath the fallen tombstone. Perhaps a horrible monster waits below!"
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 974 setLoop: 1 play:)
				(moss signal: (| (moss signal:) $0001) setCycle: Osc)
				(moss2 signal: (| (moss2 signal:) $0001) setCycle: Osc)
				(moss3 signal: (| (moss3 signal:) $0001) setCycle: Osc)
				(moss4 signal: (| (moss4 signal:) $0001) setCycle: Osc)
				(moss5 signal: (| (moss5 signal:) $0001) setCycle: Osc)
				(shadow signal: (| (shadow signal:) $0001) setCycle: Fwd)
				(shadow2 signal: (| (shadow2 signal:) $0001) setCycle: Fwd)
				(shadow3 signal: (| (shadow3 signal:) $0001) setCycle: Fwd)
				(coffin signal: (| (coffin signal:) $0001) setCycle: Fwd)
				(coffin2 signal: (| (coffin2 signal:) $0001) setCycle: Fwd)
				(if (= register (Random 0 1))
					(lightning
						init:
						setPri: 126
						signal: (| (lightning signal:) $0001)
						setCel: 0
						show:
						setCycle: End self
					)
				else
					(lightning2
						init:
						setPri: 126
						signal: (| (lightning2 signal:) $0001)
						setCel: 0
						show:
						setCycle: End self
					)
				)
			)
			(1
				(Palette 2 0 255 500) ; PalIntensity
				(Palette 2 0 255 100) ; PalIntensity
				(= ticks 6)
			)
			(2
				(Palette 2 0 255 500) ; PalIntensity
				(Palette 2 0 255 100) ; PalIntensity
				(if register
					(lightning dispose:)
					(self cue:)
				else
					(lightning2 dispose:)
					(if (not (graveStone cel:))
						(graveStone
							signal: (| (graveStone signal:) $0001)
							setCycle: End self
						)
					else
						(self cue:)
					)
				)
			)
			(3
				(graveStone signal: (& (graveStone signal:) $fffe))
				(= ticks (Random 20 60))
			)
			(4
				(if (and register (< (gEgo y:) 100))
					(coffin2 setScript: sLiftLid)
				)
				(= ticks (Random 120 240))
			)
			(5
				(moss2 setCel: 0 signal: (& (moss2 signal:) $fffe))
				(moss3 setCel: 0 signal: (& (moss3 signal:) $fffe))
				(moss4 setCel: 0 signal: (& (moss4 signal:) $fffe))
				(moss5 setCel: 0 signal: (& (moss5 signal:) $fffe))
				(shadow signal: (& (shadow signal:) $fffe) setCycle: 0)
				(shadow2 signal: (& (shadow2 signal:) $fffe) setCycle: 0)
				(shadow3 signal: (& (shadow3 signal:) $fffe) setCycle: 0)
				(coffin signal: (& (coffin signal:) $fffe) setCycle: 0)
				(coffin2 signal: (& (coffin2 signal:) $fffe) setCycle: 0)
				(if (> (gGlory _detailLevel:) 2)
					(self setScript: sMossBlow self)
				else
					(= seconds (Random 15 20))
				)
			)
			(6
				(if (> (gGlory _detailLevel:) 2)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sMossBlow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 4)
					(0
						(= register moss)
					)
					(1
						(= register moss2)
					)
					(2
						(= register moss3)
					)
					(3
						(= register moss4)
					)
					(4
						(= register moss5)
					)
				)
				(register signal: (| (register signal:) $0001) setCycle: Osc)
				(= cycles (Random 20 60))
			)
			(1
				(register setCycle: End self)
			)
			(2
				(register signal: (& (register signal:) $fffe))
				(= cycles 12)
			)
			(3
				(register setCel: 0)
				(= cycles (Random 60 180))
			)
			(4
				(if (> (++ local6) 6)
					(= local6 0)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance castOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(door signal: (| (door signal:) $0001) setCycle: End self)
			)
			(1
				(gMessager say: 11 80 0 0 self) ; "The Crypt Door lock yields to the power of your Open spell."
			)
			(2
				(door signal: (& (door signal:) $fffe))
				(gEgo
					setMotion:
						PolyPath
						(cryptDoor approachX:)
						(cryptDoor approachY:)
						self
				)
			)
			(3
				(sToCrypt start: 3)
				(gCurRoom setScript: sToCrypt)
			)
		)
	)
)

(instance sToCrypt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(gMessager say: 39 155 34 0 self) ; "You turn the large skeleton key in the crypt door. With a sound like the groaning of an undead spirit, the massive door yawns wide open."
				else
					(gMessager say: 11 42 6 0 self) ; "All right! You hear a sharp "Snick!" as your lockpicks catch the tumblers just right. The crypt door opens."
				)
			)
			(1
				(door signal: (| (door signal:) $0001) setCycle: End self)
			)
			(2
				(door signal: (& (door signal:) $fffe))
				(= ticks 30)
			)
			(3
				(= local3 (gEgo cycleSpeed:))
				(door setPri: 0)
				(gEgo
					setSpeed: global433
					setScale:
					setLoop: 7 1
					setPri: 2
					setMotion: MoveTo 87 124 self
				)
			)
			(4
				(gEgo setSpeed: local3)
				(door signal: (| (door signal:) $0001) setCycle: Beg self)
			)
			(5
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance castOpenGrave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(igor show:)
				(headStone
					signal: (| (headStone signal:) $0001)
					setCycle: Beg self
				)
			)
			(1
				(headStone signal: (& (headStone signal:) $fffe))
				(gCurRoom setScript: sIgorLeaves)
			)
		)
	)
)

(instance sLiftStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setLoop: 1 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(if (> (gEgo trySkill: 0 300) 0) ; strength
					(= register 1)
					(headStone
						signal: (| (headStone signal:) $0001)
						setCycle: Beg self
					)
					(igor show:)
					(gEgo setCycle: Beg self)
				else
					(gMessager say: 37 6 35 0 self) ; "You fail to budge the heavy gravestone. It will take more strength than you've got to move this (or better leverage)."
				)
			)
			(3
				(if (not register)
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(headStone signal: (& (headStone signal:) $fffe))
				(gEgo setSpeed: local3 normalize: 1)
				(if register
					(gCurRoom setScript: sIgorLeaves)
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTryTree2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					setPri: (gEgo priority:)
					setScale:
					setMotion: MoveTo 34 166 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 7 setLoop: 3 1 setStep: 1 4 setCycle: Fwd)
				(if (> (gEgo trySkill: 11 200) 0) ; climbing
					(gCurRoom setScript: sClimbTree2)
				else
					(gEgo setSpeed: 1 setCycle: ForwardCounter 5 self)
				)
			)
			(3
				(gMessager say: 37 6 23 0 self) ; "This climbing business isn't quite as simple as that book made out. You'll have to keep practicing."
			)
			(4
				(= start 0)
				(gEgo
					normalize: 3
					setPri: 180
					setScaler: Scaler 110 65 129 87
					setMotion:
						MoveTo
						(bigTrunk approachX:)
						(bigTrunk approachY:)
						self
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbTree2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 30 4 0 0 self) ; "You start to climb the old oak tree."
			)
			(1
				(gEgo
					setSpeed: global433
					setMotion: MoveTo (gEgo x:) 69 self
				)
			)
			(2
				(gEgo setCycle: 0 setSpeed: local3)
				(gEgo
					setLoop: (gEgo loop:) 1
					setCycle: Rev
					setMotion: MoveTo 34 166 self
				)
			)
			(3
				(sTryTree2 start: 4)
				(gCurRoom setScript: sTryTree2)
			)
		)
	)
)

(instance sTryTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					setPri: (gEgo priority:)
					setScale:
					setMotion: MoveTo 34 166 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 7 setLoop: 3 1 setStep: 1 4 setCycle: Fwd)
				(if (> (gEgo trySkill: 11 200) 0) ; climbing
					(gCurRoom setScript: sClimbTree)
				else
					(gEgo setSpeed: 1 setCycle: ForwardCounter 5 self)
				)
			)
			(3
				(gMessager say: 37 6 23 0 self) ; "This climbing business isn't quite as simple as that book made out. You'll have to keep practicing."
			)
			(4
				(= start 0)
				(gEgo
					normalize: 3
					setPri: 180
					setScaler: Scaler 110 65 129 87
					setMotion:
						MoveTo
						(bigTrunk approachX:)
						(bigTrunk approachY:)
						self
				)
			)
			(5
				(if (gCast contains: rope1)
					(gEgo setPri: -1 setMotion: PolyPath 179 141 self)
				else
					(gEgo setSpeed: local3 setPri: -1)
					(= global204 0)
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(6
				(gEgo
					view: 4
					setLoop: 1 1
					setCel: 0
					setPri: (- (gEgo priority:) 3)
					setCycle: End self
				)
			)
			(7
				(rope2 signal: (| (rope2 signal:) $0001) setCycle: End self)
			)
			(8
				(rope2 signal: (& (rope2 signal:) $fffe))
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 7 setMotion: PolyPath 137 174 self)
			)
			(10
				(gEgo setMotion: PolyPath 94 163 self)
			)
			(11
				(gEgo setHeading: 45 self)
			)
			(12
				(gEgo view: 7 setLoop: 0 1 setCel: 0 setCycle: Fwd)
				(rope1
					signal: (| (rope1 signal:) $0001)
					setCycle: End
					setStep: 1 1
					setMotion: MoveTo (rope1 x:) (+ (rope1 y:) 16)
				)
				(rope2
					signal: (| (rope2 signal:) $0001)
					setStep: 1 1
					setMotion: MoveTo (+ (rope2 x:) 50) (- (rope1 y:) 50)
				)
				(igor show:)
				(headStone
					signal: (| (headStone signal:) $0001)
					setCycle: Beg self
				)
			)
			(13
				(headStone signal: (& (headStone signal:) $fffe))
				(gEgo setCycle: End self)
			)
			(14
				(rope2 setMotion: 0)
				(= ticks 60)
			)
			(15
				(rope1 dispose:)
				(rope2 dispose:)
				(gEgo setCycle: Beg self)
			)
			(16
				(gEgo
					normalize: 6
					setSpeed: local3
					setPri: -1
					setScaler: Scaler 110 65 129 87
				)
				(gCurRoom setScript: sIgorLeaves)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setLoop: (gEgo loop:) 1
					setCycle: Rev
					setMotion: MoveTo 34 166 self
				)
			)
			(1
				(sTryTree start: 4)
				(gCurRoom setScript: sTryTree)
			)
		)
	)
)

(instance sClimbTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: global433
					setMotion: MoveTo (gEgo x:) 69 self
				)
			)
			(1
				(gEgo setCycle: 0 setSpeed: local3)
				(if local7
					(= local7 0)
					(bigBranch doVerb: 33)
				else
					(gUser canInput: 1 canControl: 1)
					(gTheIconBar enable: 1 0 7)
					(= global204 1)
					(if (not (gTheIconBar curInvIcon:))
						(gTheIconBar disable: 6)
					)
					(gGlory setCursor: (gTheIconBar getCursor:) 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sIgorLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 236)
				(if (gCast contains: igor)
					(igor show:)
				)
				(if (IsFlag 38)
					(gGlory handsOn:)
					(self dispose:)
				else
					(SetFlag 48)
					(heroTeller dispose:)
					(gEgo actions: 0)
					(= ticks 120)
				)
			)
			(1
				(gEgo solvePuzzle: 441 15)
				(igor signal: (| (igor signal:) $0001) setCycle: End self)
			)
			(2
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) (igor x:) (igor y:))
				)
				(igor setLoop: 4 1 setCel: 0 setCycle: End self)
			)
			(3
				(igor signal: (& (igor signal:) $fffe))
				(= ticks 60)
			)
			(4
				(gMessager say: 34 6 19 0 self) ; ""Igor saved! Kind stranger saved Igor! Good kind stranger. Igor happy grave not Igor's grave."
			)
			(5
				(= ticks 60)
			)
			(6
				(igor
					signal: (| (igor signal:) $0001)
					setLoop: 5 1
					setCycle: Fwd
					setMotion: MoveTo (igor x:) 240 self
				)
			)
			(7
				(igor dispose:)
				(= global204 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLiftLid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coffin2
					setLoop: 3 1
					setCel: 0
					x: 95
					y: 137
					signal: (| (coffin2 signal:) $0001)
					setCycle: End self
				)
			)
			(1
				(coffin2 signal: (& (coffin2 signal:) $fffe))
				(= seconds (Random 3 5))
			)
			(2
				(coffin2 signal: (| (coffin2 signal:) $0001) setCycle: Beg self)
			)
			(3
				(coffin2
					setLoop: 2 1
					x: 55
					y: 125
					signal: (& (coffin2 signal:) $fffe)
				)
				(self dispose:)
			)
		)
	)
)

(instance sLigeiaOPEN of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ligeiaDoor
					signal: (| (ligeiaDoor signal:) $0001)
					setCycle: End self
				)
				(if (gCast contains: shadow3)
					(shadow3 z: 1000)
				)
			)
			(1
				(ligeiaDoor signal: (& (ligeiaDoor signal:) $fffe))
				(gEgo setMotion: PolyPath 249 143 self)
			)
			(2
				(if (and (not gNight) (not (IsFlag 246)))
					(ligeia
						init:
						signal: (| (ligeia signal:) $0001)
						setPri: 138
						setCycle: End self
					)
				else
					(= ticks 1)
				)
			)
			(3
				(if (and gNight (not (IsFlag 246)))
					(SetFlag 398)
					(client setScript: sWraithRise)
				else
					(client setScript: sLigeia 0 1)
				)
			)
		)
	)
)

(instance sLigeia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(if register
					(gEgo cycleSpeed: global433)
					(= ticks 1)
				else
					(gEgo
						view: 31
						setLoop: 0 1
						setCel: 0
						cycleSpeed: global433
						setCycle: End self
					)
				)
			)
			(1
				(if register
					(self changeState: 4)
				else
					(gEgo setCycle: Beg)
					(if (gCast contains: shadow3)
						(shadow3 z: 1000)
					)
					(ligeiaDoor
						signal: (| (ligeiaDoor signal:) $0001)
						setCycle: End self
					)
				)
			)
			(2
				(if (and gNight (not (IsFlag 246)))
					(SetFlag 398)
					(gEgo cycleSpeed: local3)
					(client setScript: sWraithRise)
				else
					(ligeiaDoor signal: (& (ligeiaDoor signal:) $fffe))
					(ligeia
						init:
						setPri: 138
						signal: (| (ligeia signal:) $0001)
						setCycle: End self
					)
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(if (and gNight (IsFlag 246))
					(if (not local8)
						(= local8 1)
						(gMessager say: 21 4 9 0 self) ; "Now that you've sent Ligeia's ghost to another realm, nothing of interest remains in this tomb."
					)
				else
					(gMessager say: 21 4 8 0 self) ; "Sheesh! That rotting corpse sure gave you a fright. Fortunately, it was just a dead body, not some sort of horrible undead creature. (Those only come out at night.)"
				)
			)
			(5
				(if register
					(gEgo view: 31 setLoop: 0 1 setCel: 0)
				)
				(gEgo setCycle: End self)
				(ligeia signal: (| (ligeia signal:) $0001) setCycle: Beg)
			)
			(6
				(ligeia dispose:)
				(gEgo setCycle: Beg)
				(ligeiaDoor
					signal: (| (ligeiaDoor signal:) $0001)
					setCycle: Beg self
				)
			)
			(7
				(if (gCast contains: shadow3)
					(shadow3 z: 0)
				)
				(ligeiaDoor signal: (& (ligeiaDoor signal:) $fffe))
				(gEgo normalize: 6 setSpeed: local3)
				(= register 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWraithRise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (IsFlag 398)
					(wraith posn: 260 120 setPri: 140)
					(= global156 200)
					(gMessager say: 21 4 10 0 self) ; "Ligeia's Ghost comes forth... and she looks MAD! This could turn into a really bad day."
				else
					(= ticks 1)
					(= global156 300)
				)
			)
			(1
				(= gCombatMonsterNum 850) ; wraith
				(soundFX number: 854 play:)
				(wraith init: setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 810) ; combat
			)
		)
	)
)

(instance sFromCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 238)
				(= local2 169)
				(gEgo x: 238 y: 169 normalize: 6)
				(if (IsFlag 398)
					(ligeiaDoor
						signal: (| (ligeiaDoor signal:) $0001)
						setCel: (ligeiaDoor lastCel:)
					)
					(ligeiaDoor signal: (& (ligeiaDoor signal:) $fffe))
					(wraith posn: 260 120 setPri: 140)
				)
				(wraith setCel: 13 init:)
				(if (== gCombatResult 2)
					(wraith setCycle: Beg self)
					(soundFX number: 854 play:)
				else
					(wraith setLoop: 3 setCycle: Fwd)
					(= cycles 3)
				)
			)
			(1
				(switch gCombatResult
					(1
						(if (IsFlag 398)
							(EgoDead 17 50) ; "The Wraith has sucked your life force right out of you. Should you return here (in another life), you will need to be properly protected and strike quickly."
						else
							(EgoDead 45 500) ; "The Rusalka's unfaithful lover got you!"
						)
					)
					(2
						(if (IsFlag 398)
							(SetFlag 246)
							(ClearFlag 398)
							(ligeiaDoor
								signal: (| (ligeiaDoor signal:) $0001)
								setCycle: Beg
							)
						else
							(SetFlag 228)
							(gEgo solvePuzzle: 530 6 8 addHonor: 60)
							(gMessager say: 37 6 13) ; "You have destroyed the untrue lover's ghost and avenged the Rusalka's memory. Nice work if you can get it."
						)
						(wraith dispose:)
						(gGlory handsOn:)
						(self dispose:)
					)
					(3
						(gCurRoom setScript: sEgosGone)
					)
				)
			)
		)
	)
)

(instance igorTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 73)) ; igorTalker
	)
)

(instance heroTeller of Teller
	(properties)
)

(instance doorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 2 (gEgo has: 24) 34 (gEgo has: 60)) ; Pick Lock, theToolkit, Unlock Door, crypt-key
	)

	(method (sayMessage)
		(ClearFlag 51)
		(cond
			((== iconValue 1) ; Open Door
				(SetFlag 205)
				(super sayMessage: &rest) ; The door is securely locked and feels very solid.
			)
			((== iconValue 34) ; Unlock Door
				(self clean:)
				(gCurRoom setScript: sToCrypt 0 1)
			)
			((== iconValue 2) ; Pick Lock
				(if (> (gEgo trySkill: 9 250) 0) ; pick locks
					(self clean:)
					(gCurRoom setScript: sToCrypt)
				else
					(gMessager say: 11 42 7 0 self) ; "You need to practice some more; this lock is tricky."
				)
			)
			((== iconValue 3) ; Force Door
				(SetFlag 205)
				(super sayMessage: &rest) ; You apply your shoulder to the crypt door with a mighty "heave." It won't budge. That's one HEAVY door.
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance igor of Actor
	(properties
		noun 34
		x 140
		y 146
		priority 9
		view 505
		signal 16384
	)

	(method (cue)
		(if loop
			(self setLoop: 0 1 setCel: 0 setCycle: End self)
		else
			(self setLoop: 1 1 setCycle: OccCyc self 1 5 15 (Random 6 36) self)
		)
	)

	(method (init)
		(super init: &rest)
		(switch local0
			(2
				(headStone init:)
				(igorTeller init: igor 500 39 123 34)
				(heroTeller init: gEgo 500 39 128 34)
				(self setScript: sChip)
				(self cue:)
			)
			(4
				(headStone view: 502 loop: 2 cel: 6 init: approachVerbs: 4) ; Do
				(if (IsFlag 38)
					(self loop: 6 posn: 147 145)
					(if (IsFlag 236)
						(headStone cel: 0)
					)
				else
					(self loop: 3 posn: 113 179)
					(heroTeller init: gEgo 500 39 128 38)
				)
				(self hide:)
			)
			(else 0)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 38)
			(switch theVerb
				(1 ; Look
					(gMessager say: 34 1 37) ; "Here lies the body of Igor. He fell in a grave and became an eyesore. RIP"
				)
				(4 ; Do
					(if (gEgo has: 60) ; crypt-key
						(gMessager say: 34 4 12) ; "Haven't you done enough to poor Igor's body?"
					else
						(gEgo get: 60 1) ; crypt-key
						(gMessager say: 34 4 11) ; "Igor seems to have died from thirst, exposure, or simple fright. You search the body and find a large key which you add to your keychain."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance headStone of Prop
	(properties
		noun 41
		approachX 171
		approachY 148
		x 166
		y 157
		z 13
		priority 138
		fixPriority 1
		view 502
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== local0 4)
			(switch theVerb
				(4 ; Do
					(if cel
						(gCurRoom setScript: sLiftStone)
					else
						(super doVerb: theVerb)
					)
				)
				(80 ; openSpell
					(= global441 ((User curEvent:) x:))
					(= global442 ((User curEvent:) y:))
					(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
				)
				(-80 ; openSpell (part 2)
					(if cel
						(gCurRoom setScript: castOpenGrave)
					else
						(super doVerb: theVerb)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lightning of Prop
	(properties
		x 149
		y 22
		view 500
		loop 1
		signal 24577
	)
)

(instance lightning2 of Prop
	(properties
		x 149
		y 22
		view 500
		loop 2
		signal 24577
	)
)

(instance shadow of Prop
	(properties
		x 235
		y 41
		view 500
		loop 3
		signal 16385
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb)
		(ligeiaTomb doVerb: theVerb)
	)
)

(instance shadow2 of Prop
	(properties
		x 238
		y 50
		view 500
		loop 4
		signal 16385
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb)
		(ligeiaTomb doVerb: theVerb)
	)
)

(instance shadow3 of Prop
	(properties
		x 244
		y 63
		view 500
		loop 5
		signal 16385
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb)
		(ligeiaTomb doVerb: theVerb)
	)
)

(instance moss of Prop
	(properties
		noun 40
		x 81
		y 18
		priority 11
		view 500
		loop 6
		signal 16385
		cycleSpeed 16
		detailLevel 3
	)
)

(instance moss2 of Prop
	(properties
		x 15
		y 18
		view 500
		loop 7
		cel 7
		signal 16385
		cycleSpeed 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(moss doVerb: theVerb)
	)
)

(instance moss3 of Prop
	(properties
		x 117
		y 12
		view 500
		loop 8
		signal 16385
		cycleSpeed 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(moss doVerb: theVerb)
	)
)

(instance moss4 of Prop
	(properties
		x 245
		y 9
		view 501
		loop 6
		signal 16385
		cycleSpeed 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(moss doVerb: theVerb)
	)
)

(instance moss5 of Prop
	(properties
		x 173
		view 501
		loop 7
		signal 16385
		cycleSpeed 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(moss doVerb: theVerb)
	)
)

(instance door of Prop
	(properties
		noun 11
		approachX 111
		approachY 100
		x 111
		y 100
		priority 11
		view 500
		loop 9
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(doorTeller doVerb: theVerb)
		else
			(cryptDoor doVerb: theVerb)
		)
	)
)

(instance graveStone of Prop
	(properties
		x 211
		y 85
		view 501
		loop 4
		signal 16384
		cycleSpeed 18
		detailLevel 1
	)

	(method (doVerb theVerb)
		(grave1 doVerb: theVerb)
	)
)

(instance ligeiaDoor of Prop
	(properties
		approachX 249
		approachY 143
		x 252
		y 87
		view 501
		signal 16384
	)

	(method (doVerb theVerb)
		(ligeiaDoorF doVerb: theVerb)
	)
)

(instance ligeia of Prop
	(properties
		x 263
		y 121
		view 501
		loop 8
		signal 16384
	)
)

(instance coffin of Prop
	(properties
		x 71
		y 116
		view 501
		loop 1
		signal 16385
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 138)
	)

	(method (doVerb theVerb)
		(coffins doVerb: theVerb)
	)
)

(instance coffin2 of Prop
	(properties
		x 55
		y 125
		view 501
		loop 2
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 138)
	)

	(method (doVerb theVerb)
		(coffins doVerb: theVerb)
	)
)

(instance rope1 of Actor
	(properties
		x 100
		y -10
		view 502
		signal 24576
	)
)

(instance rope2 of Actor
	(properties
		x 127
		y -5
		view 502
		loop 1
		signal 24576
	)
)

(instance rusalkaGrave of Feature
	(properties
		noun 32
		nsLeft 260
		nsTop 120
		nsRight 291
		nsBottom 158
		sightAngle 180
		x 275
		y 139
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gHeroType 3) ; Paladin
					(SetFlag 227)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance loverGrave of Feature
	(properties
		noun 33
		nsLeft 292
		nsTop 126
		nsRight 319
		nsBottom 167
		sightAngle 180
		approachX 284
		approachY 173
		x 305
		y 146
	)

	(method (doVerb theVerb)
		(switch theVerb
			(58 ; theBroom
				(if
					(and
						gNight
						(not (IsFlag 228))
						((gInventory at: 39) state:) ; theBroom
					)
					(gCurRoom setScript: sWraithRise)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cryptDoor of Feature
	(properties
		noun 11
		nsLeft 99
		nsTop 48
		nsRight 120
		nsBottom 97
		sightAngle 180
		approachX 111
		approachY 100
		x 109
		y 72
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(doorTeller doVerb: theVerb)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: castOpenDoor)
			)
			(29 ; theKeyRing
				(if (gEgo has: 60) ; crypt-key
					(gCurRoom setScript: sToCrypt 0 1)
				else
					(gMessager say: 11 29 43) ; "You don't seem to have the right key on your keyring."
				)
			)
			(42 ; theToolkit
				(if (> (gEgo trySkill: 9 250) 0) ; pick locks
					(gCurRoom setScript: sToCrypt)
				else
					(gMessager say: 11 42 7) ; "You need to practice some more; this lock is tricky."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crypt of Feature
	(properties
		noun 20
		nsLeft 54
		nsTop 24
		nsRight 147
		nsBottom 108
		sightAngle 180
		x 100
		y 66
	)
)

(instance grave1 of Feature
	(properties
		noun 1
		nsLeft 196
		nsTop 85
		nsRight 215
		nsBottom 105
		sightAngle 180
		x 205
		y 95
	)
)

(instance grave2 of Feature
	(properties
		noun 2
		nsLeft 215
		nsTop 83
		nsRight 232
		nsBottom 103
		sightAngle 180
		x 223
		y 93
	)
)

(instance grave3 of Feature
	(properties
		noun 3
		nsLeft 157
		nsTop 71
		nsRight 167
		nsBottom 84
		sightAngle 180
		x 162
		y 77
	)
)

(instance grave4 of Feature
	(properties
		noun 4
		nsLeft 174
		nsTop 66
		nsRight 183
		nsBottom 76
		sightAngle 180
		x 178
		y 71
	)
)

(instance grave5 of Feature
	(properties
		noun 5
		nsLeft 225
		nsTop 67
		nsRight 235
		nsBottom 78
		sightAngle 180
		x 230
		y 72
	)
)

(instance urn1 of Feature
	(properties
		noun 24
		nsLeft 236
		nsTop 88
		nsRight 253
		nsBottom 107
		sightAngle 180
		x 244
		y 97
	)
)

(instance urn2 of Feature
	(properties
		noun 25
		nsLeft 278
		nsTop 91
		nsRight 294
		nsBottom 112
		sightAngle 180
		x 286
		y 101
	)
)

(instance ligeiaDoorF of Feature
	(properties
		noun 21
		nsLeft 255
		nsTop 59
		nsRight 283
		nsBottom 122
		sightAngle 180
		approachX 249
		approachY 143
		x 269
		y 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local8)
					(gCurRoom setScript: sLigeia)
				else
					(super doVerb: theVerb)
				)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(if (not local8)
					(gCurRoom setScript: sLigeiaOPEN 0 1)
				else
					(super doVerb: theVerb)
					(gGlory handsOn:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ligeiaTomb of Feature
	(properties
		noun 22
		nsLeft 235
		nsTop 32
		nsRight 319
		nsBottom 131
		sightAngle 180
		x 277
		y 81
	)
)

(instance ligeiaTop of Feature
	(properties
		noun 23
		nsLeft 257
		nsTop 9
		nsRight 280
		nsBottom 32
		sightAngle 180
		x 268
		y 20
	)
)

(instance thinTree of Feature
	(properties
		noun 27
		nsLeft 299
		nsRight 311
		nsBottom 122
		sightAngle 180
		x 305
		y 82
	)
)

(instance thinBranch of Feature
	(properties
		noun 28
		nsLeft 216
		nsRight 299
		nsBottom 12
		sightAngle 180
		x 257
		y 6
	)
)

(instance bigBranch of Feature
	(properties
		noun 29
		nsLeft 37
		nsRight 135
		nsBottom 19
		sightAngle 180
		x 86
		y 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(cond
					((== (gEgo view:) 7)
						(rope1 init: setPri: 148)
						(rope2 init: setPri: 116)
						(gCurRoom setScript: sClimbDown)
					)
					((or (!= local0 4) (not (headStone cel:)))
						(super doVerb: theVerb)
					)
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 30 4 42) ; "It's at times like this you wish you'd signed up for that course in "Vertical Mobility: How to be a Social Climber." But you didn't, so you'll have to find another approach."
					)
					(else
						(= local7 1)
						(gCurRoom setScript: sTryTree)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigTrunk of Feature
	(properties
		noun 30
		nsTop 11
		nsRight 51
		nsBottom 169
		sightAngle 180
		approachX 98
		approachY 181
		x 25
		y 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((or (!= local0 4) (not (headStone cel:)))
						(gCurRoom setScript: sTryTree2)
					)
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 30 4 42) ; "It's at times like this you wish you'd signed up for that course in "Vertical Mobility: How to be a Social Climber." But you didn't, so you'll have to find another approach."
					)
					(else
						(gCurRoom setScript: sTryTree)
					)
				)
			)
			(33 ; theGrapnel
				(cond
					((or (!= local0 4) (not (headStone cel:)))
						(super doVerb: theVerb)
					)
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 30 4 42) ; "It's at times like this you wish you'd signed up for that course in "Vertical Mobility: How to be a Social Climber." But you didn't, so you'll have to find another approach."
					)
					(else
						(= local7 1)
						(gCurRoom setScript: sTryTree)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coffins of Feature
	(properties
		noun 31
		nsLeft 51
		nsTop 110
		nsRight 104
		nsBottom 158
		sightAngle 180
		x 77
		y 134
	)
)

(instance dirtPile of Feature
	(properties
		noun 17
		nsLeft 134
		nsTop 170
		nsRight 169
		nsBottom 182
		sightAngle 180
		x 151
		y 176
	)
)

(instance openGrave of Feature
	(properties
		noun 16
		nsLeft 103
		nsTop 138
		nsRight 166
		nsBottom 174
		sightAngle 180
		x 134
		y 156
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 97 167 145 138 158 138 165 142 128 176
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(cond
				((and (gCast contains: igor) (igor isNotHidden:) (IsFlag 38))
					(igor doVerb: theVerb)
				)
				(
					(and
						(gCast contains: igor)
						(not (igor isNotHidden:))
						(== theVerb 1) ; Look
					)
					(gMessager say: 16 1 44) ; "The headstone has fallen over the open grave, covering it."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance wraith of Actor
	(properties
		x 275
		y 139
		view 850
		loop 1
		signal 16385
	)
)

(instance soundFX of Sound
	(properties)
)

