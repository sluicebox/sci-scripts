;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2550)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use Print)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2550 0
	brutusTalker 1
)

(local
	local0
	local1
)

(instance localMessager of kqMessager
	(properties)

	(method (say)
		(lavaSound setVol: 60)
		(super say: &rest)
	)

	(method (sayRange)
		(lavaSound setVol: 60)
		(super say: &rest)
	)

	(method (dispose)
		(lavaSound setVol: 128)
		(super dispose: &rest)
	)
)

(instance rm2550 of KQRoom
	(properties
		picture 2550
	)

	(method (dispose)
		(= gMessager kqMessager)
		(super dispose: &rest)
	)

	(method (init)
		(= gMessager localMessager)
		(Load 140 25500) ; WAVE
		(Load 140 25500) ; WAVE
		(brutusTalker client: troll)
		(if (and (IsFlag 370) (not (IsFlag 62)))
			(gKqMusic1
				number: 2524
				loop: -1
				flags: (| (gKqMusic1 flags:) $0001)
				play:
			)
		else
			(gKqMusic1
				number: 2550
				loop: -1
				flags: (| (gKqMusic1 flags:) $0001)
				play:
			)
		)
		(super init:)
		(SetFlag 85)
		(SetFlag 64)
		(if (proc98_9)
			(gEgo get: 35) ; Lantern
			(gEgo get: 32) ; Enchanted_Rope
			(if
				(Print
					addText: {Do you want the shield?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(gEgo get: 29) ; Shield
			)
			(if
				(Print
					addText: {Do you want the spike?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(gEgo get: 30) ; Shield_Spike
			)
			(if
				(Print
					addText: {Are you trollzella?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(ClearFlag 55)
			else
				(SetFlag 55)
			)
			(if
				(Print
					addText: {Is troll out?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(SetFlag 370)
			else
				(ClearFlag 370)
			)
			(if
				(Print
					addText: {Shield spike off?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(SetFlag 79)
			else
				(ClearFlag 79)
			)
			(if
				(Print
					addText: {Working on cart?}
					addButton: 1 {Yes} 0 20
					addButton: 0 {No} 20 20
					init:
				)
				(= local0 1)
			)
		)
		(gEgo normalize: setScaler: Scaler 58 25 135 23 init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 23 46 61 32 91 41 109 56 108 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 91 77 146 98 114 109 121 117 140 124 138 128 116 131 87 127 75 121 77 97
					yourself:
				)
		)
		(bucket init:)
		(if (IsFlag 70)
			(rope setLoop: 2 cel: 11 init:)
		)
		(if (not (IsFlag 62))
			(cart init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 318 45 256 63 283 81 254 91 193 90 154 72 83 32 50 32 42 19 31 20 47 33 10 47 74 65 86 70 81 86 74 95 71 118 8 100 3 102 25 115 64 121 81 133 161 133 126 110 201 98 258 98 300 82 273 70 270 64 320 48
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 318 45 256 63 283 81 254 91 202 91 112 48 79 30 71 27 47 20 37 23 49 33 10 47 74 65 86 70 81 86 74 95 71 118 8 100 3 102 25 115 64 121 81 133 161 133 126 110 201 98 258 98 300 82 273 70 270 64 320 48
						yourself:
					)
			)
		)
		(lava1 init: cycleSpeed: 10 setPri: 10 setCycle: Fwd)
		(lava2 init: cycleSpeed: 10 setPri: 10 setCycle: Fwd)
		(lava3 init: cycleSpeed: 10 setPri: 10 setCycle: Fwd)
		(lava4 init: cycleSpeed: 10 setPri: 10 setCycle: Fwd)
		(hallDoor init:)
		(lairDoor init:)
		(if (and (IsFlag 370) (not (IsFlag 62)))
			(troll view: 2553 loop: 0 cel: 0 posn: 264 100 init:)
		)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(2350
				(= gValOrRoz -4) ; Val
				(self setScript: sChap6Toon)
			)
			(2600
				(gCurRoom setScript: sFromDragon)
			)
			(else
				(gCurRoom setScript: sFromGreatHall)
			)
		)
		(lavaSound number: 25500 loop: -1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not script)
				(gEgo inRect: 216 84 250 120)
				(not (IsFlag 62))
			)
			(gEgo setMotion: 0 x: 214)
			(cond
				((IsFlag 81)
					(gCurRoom setScript: sThrowRose)
				)
				((IsFlag 370)
					(SetFlag 81)
					(brutusTalker clientCel: -2)
					(gMessager say: 0 0 7 1) ; "RRRRAAAAAAAGH!"
					(brutusTalker clientCel: -1)
				)
				(else
					(self setScript: sTrollJumpsOut)
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(gEgo posn: 57 121)
	)

	(method (notify)
		(cond
			((IsFlag 65)
				(self setScript: sRideCart)
			)
			((IsFlag 71)
				(self setScript: sShieldFallsOff)
			)
			(else
				(self setScript: sNoFourthWheel)
			)
		)
	)
)

(instance sChap6Toon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Prints {You and the hooded guy fall into this room.})
				(Prints
					{The both of you avoid some obsticals and start running.}
				)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2200)
			)
		)
	)
)

(instance sFromGreatHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gEgo posn: 36 47)
					(= cycles 1)
				else
					(gEgo posn: -2 105 setMotion: MoveTo 38 115 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromDragon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 330 46 setMotion: PolyPath 290 52 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNoFourthWheel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(Load rsVIEW 2552)
				(Load rsVIEW 2553)
				(Load 140 2525) ; WAVE
				(Load 140 2525) ; WAVE
				(gEgo
					ignoreActors: 1
					cycleSpeed: 12
					setMotion: PolyPath 48 28 self
				)
			)
			(2
				(cart hide:)
				(gEgo
					setScale: 0
					posn: 74 43
					view: 2552
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(cartSound number: 2525 loop: -1 play:)
				(gEgo posn: 85 46 setLoop: 3 setCel: 0 setCycle: CT 3 1 self)
			)
			(4
				(scream init:)
				(gKqSound1 number: 2526 play: scream)
				(gEgo setCycle: CT 15 1 self)
			)
			(5
				(if (not local1)
					(scream cue:)
				)
				(gEgo setCycle: CT 16 1 self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(cartSound stop:)
				(gEgo
					view: 2553
					cel: 0
					setPri: (+ (troll priority:) 70)
					setLoop: 2
					posn: 180 146
					setCycle: End self
				)
			)
			(8
				(= seconds 1)
			)
			(9
				(gKqSound1 number: 812 loop: 1 play:)
				(= seconds 1)
			)
			(10
				(gKqSound1 number: 2529 loop: 1 play: self)
				(troll
					view: 25531
					setLoop: 0
					posn: 269 95
					setCel: 0
					setCycle: Fwd
				)
			)
			(11
				(gKqSound1 stop:)
				(gEgo setScaler: Scaler 58 25 135 23)
				(= cycles 2)
			)
			(12
				(EgoDead 14 self)
			)
			(13
				(ClearFlag 5)
				(cart posn: 72 35 approachX: 59 approachY: 36 show:)
				(gEgo normalize: posn: 48 40 setScaler: Scaler 58 25 135 23)
				(troll
					view: 2553
					setLoop: 0
					setCel: 0
					posn: 264 100
					setCycle: 0
				)
				(= cycles 1)
			)
			(14
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutShieldOn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 71)
				(gEgo ignoreActors: 1 setMotion: PolyPath 61 34 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(cart hide:)
				(gEgo
					setScale: 0
					put: 29 ; Shield
					view: 2555
					setLoop: 0
					setCel: 0
					posn: 61 36
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2)
			(3
				(cart show: setCel: 1)
				(gEgo
					normalize:
					posn: 58 36
					ignoreActors: 1
					cycleSpeed: register
					setScaler: Scaler 58 25 135 23
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutSpikeOn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 65)
				(Load rsVIEW 2555)
				(gEgo ignoreActors: 1 setMotion: PolyPath 61 34 self)
			)
			(1
				(gMessager say: 2 97 4 0 self) ; "(MUTTERING)I'll just make sure that shield doesn't go anywhere...there!"
			)
			(2
				(= register (gEgo cycleSpeed:))
				(cart hide:)
				(gEgo
					setScale: 0
					put: 30 ; Shield_Spike
					view: 2555
					setLoop: 1
					setCel: 0
					posn: 61 36
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3)
			(4
				(cart show: cel: 2)
				(gEgo
					normalize:
					posn: 58 36
					ignoreActors: 1
					cycleSpeed: register
					setScaler: Scaler 58 25 135 23
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpikeNoWheel of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: 1 setMotion: PolyPath 61 29 self)
			)
			(1
				(gMessager say: 2 97 5 0 self) ; "(THINKS TO HERSELF)I wonder if I could somehow use this as a fastener...?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShieldOnFallOff of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2554)
				(Load 140 2530) ; WAVE
				(gEgo ignoreActors: 1 setMotion: PolyPath 63 36 self)
			)
			(1
				(cart hide:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					put: 29 ; Shield
					setScale: 0
					view: 2554
					setLoop: 0
					setCel: 0
					posn: 61 36
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(cart show:)
				(gEgo
					normalize:
					posn: 52 36
					get: 29 ; Shield
					cycleSpeed: register
					ignoreActors: 1
					setScaler: Scaler 58 25 135 23
				)
				(= ticks 30)
			)
			(5
				(gMessager say: 2 38 3 0 self) ; "(THINKS TO HERSELF)That MIGHT work...if it weren't for that darned spike."
			)
			(6
				(gKqSound1 number: 2529 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShieldFallsOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(= register 1)
				(Load rsVIEW 2556)
				(Load 140 2531) ; WAVE
				(gEgo
					ignoreActors: 1
					setPri: (- (gEgo priority:) 10)
					setMotion: PolyPath 59 36 self
				)
			)
			(2
				(cart hide:)
				(Load 140 2525) ; WAVE
				(Load 140 2525) ; WAVE
				(gEgo
					view: 2556
					setScale: 0
					cycleSpeed: 12
					setLoop: 0
					cel: 0
					posn: 55 33
					setCycle: CT 18 1 self
				)
			)
			(3
				(cartSound number: 4088 loop: -1 play:)
				(gEgo setCycle: CT 39 1 self)
			)
			(4
				(cartSound stop:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					view: 2556
					setLoop: 1
					cel: 0
					posn: 74 40
					setCycle: End self
				)
			)
			(6
				(cartSound number: 2525 loop: -1 play:)
				(gEgo
					view: 2556
					setLoop: 2
					cel: 0
					posn: 115 74
					setCycle: CT 3 1 self
				)
			)
			(7
				(scream init:)
				(gKqSound1 number: 2526 play: scream)
				(gEgo setCycle: CT 18 1 self)
			)
			(8
				(if (not local1)
					(scream cue:)
				)
				(gEgo setPri: (+ (troll priority:) 10) setCycle: End self)
			)
			(9
				(cartSound stop:)
				(gKqSound1 number: 2531 loop: 1 play:)
				(gEgo
					view: 2556
					setPri: (+ (troll priority:) 30)
					setLoop: 3
					cel: 0
					posn: 274 102
					setCycle: End self
				)
			)
			(10
				(= seconds 2)
			)
			(11
				(gKqSound1 stop:)
				(gEgo setScaler: Scaler 58 25 135 23 hide:)
				(= cycles 2)
			)
			(12
				(EgoDead 15 self)
			)
			(13
				(if (not (IsFlag 79))
					(cart setCel: 0)
					(cuShield dispose:)
					(gEgo get: 29) ; Shield
					(ClearFlag 65)
				)
				(cart show:)
				(gEgo
					show:
					normalize:
					posn: 48 40
					ignoreActors: 1
					setScaler: Scaler 58 25 135 23
				)
				(troll view: 2553 setLoop: 0 cel: 0 posn: 264 100)
				(shield dispose:)
				(ClearFlag 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullCartOutMud of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2552)
				(Load 140 2523) ; WAVE
				(gEgo ignoreActors: 1 setMotion: PolyPath 57 27 self)
			)
			(1
				(cart hide:)
				(gEgo
					setScale: 0
					view: 2552
					setLoop: 0
					setCel: 0
					posn: 50 27
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(cart show: posn: 69 33)
				(gEgo
					normalize:
					ignoreActors: 1
					posn: 68 34
					setScaler: Scaler 58 25 135 23
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullOnRoad of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2552)
				(Load 140 2523) ; WAVE
				(gEgo ignoreActors: 1 setMotion: PolyPath 68 34 self)
			)
			(1
				(cart hide:)
				(gEgo
					setScale: 0
					view: 2552
					setLoop: 1
					setCel: 0
					posn: 60 30
					setCycle: End self
				)
			)
			(2
				(cart show: posn: 72 35)
				(gEgo
					normalize:
					ignoreActors: 1
					posn: 73 35
					setScaler: Scaler 58 25 135 23
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRideCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(Load 140 2525) ; WAVE
				(Load 140 2525) ; WAVE
				(Load rsVIEW 2556)
				(Load rsVIEW 2557)
				(Load 140 2532) ; WAVE
				(Load rsVIEW 2557)
				(Load 140 2060) ; WAVE
				(gEgo ignoreActors: 1 setPri: 30)
				(if (not (gCast contains: troll))
					(gKqMusic1 number: 2524 loop: -1 play:)
					(troll init: setPri: 90 cycleSpeed: 3 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(cart hide:)
				(gEgo
					setScale: 0
					view: 2556
					setLoop: 0
					posn: 55 33
					cel: 0
					cycleSpeed: 10
					setCycle: CT 18 1 self
				)
			)
			(3
				(cartSound number: 4088 loop: -1 play:)
				(gEgo setCycle: CT 39 1 self)
			)
			(4
				(cartSound stop:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 1 posn: 72 40 cel: 0 setCycle: End self)
			)
			(6
				(cartSound number: 2525 loop: -1 play:)
				(gEgo setLoop: 2 posn: 113 74 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(scream init:)
				(gKqSound1 number: 2526 play: scream)
				(gEgo setCycle: CT 18 1 self)
			)
			(8
				(if (not local1)
					(scream cue:)
				)
				(gEgo setPri: (+ (troll priority:) 1) setCycle: End self)
			)
			(9
				(cartSound stop:)
				(gKqSound1 number: 2532 loop: 1 play:)
				(troll hide:)
				(gEgo
					view: 2557
					setLoop: 0
					posn: 238 96
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(10
				(gEgo setCycle: CT 12 1 self)
			)
			(11
				(splashSound number: 2060 play:)
				(gEgo setCycle: End self)
			)
			(12
				(gKqMusic1 number: 2550 loop: 1 play:)
				(gEgo normalize: posn: 251 90 setScaler: Scaler 58 25 135 23)
				(troll
					view: 2557
					setPri: 200
					posn: 249 142
					show:
					setLoop: 1
					setCel: 0
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(13
				(gGame handsOn:)
				(SetFlag 62)
				(self dispose:)
			)
		)
	)
)

(instance sTrollJumpsOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 370)
				(Load rsVIEW 2553)
				(Load 140 2526) ; WAVE
				(gKqMusic1 number: 2524 loop: -1 play:)
				(troll init: setPri: 90 setCycle: End self)
			)
			(1
				(troll
					view: 2553
					setLoop: 0
					cel: 0
					posn: 264 100
					setCycle: End self
				)
			)
			(2
				(troll view: 2553 setLoop: 0 cel: 0 posn: 264 100)
				(brutusTalker clientCel: -2)
				(gMessager say: 3 8 6 0 self) ; "(FEROCIOUS)COME NO FURTHER!"
				(brutusTalker clientCel: -1)
			)
			(3
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOfferItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 6)
				(= cycles 2)
			)
			(1
				(gEgo view: 8775 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 6)
				(= cycles 1)
			)
			(3
				(brutusTalker clientCel: -2)
				(gMessager say: 0 0 11 0 self) ; "I don't suppose you'd take this as a toll?"
			)
			(4
				(gGame handsOn:)
				(brutusTalker clientCel: -1)
				(gEgo normalize: 6)
				(self dispose:)
			)
		)
	)
)

(instance sThrowRose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2558)
				(Load rsVIEW 2553)
				(gKqSound1 number: 2535 play:)
				(gEgo hide:)
				(troll
					view: 2558
					loop: 2
					cel: 0
					posn: 179 135
					setPri: 110
					cycleSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(1
				(troll setCycle: End self)
			)
			(2
				(troll setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gKqSound1 number: 812 loop: 1 play:)
				(gEgo setScaler: Scaler 58 25 135 23)
				(troll setCycle: End self)
			)
			(4
				(EgoDead 46 self)
			)
			(5
				(gEgo show: normalize:)
				(troll view: 2553 setLoop: 0 cel: 0 posn: 264 100)
				(ClearFlag 81)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRopeTiesItself of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2551)
				(Load rsVIEW 25515)
				(gEgo setMotion: PolyPath 157 138 self)
			)
			(1
				(lSound2 number: 2550 loop: -1 play:)
				(= seconds 2)
			)
			(2
				(gEgo
					setScale: 0
					view: 2551
					setLoop: 0
					setCel: 0
					posn: 148 148
					setCycle: CT 22 1 self
				)
			)
			(3
				(localSound number: 108 play:)
				(gEgo cel: 23 setCycle: End self)
				(rope init: setPri: 130 setCycle: End self)
				(SetFlag 70)
			)
			(4
				(gEgo
					normalize:
					posn: 155 134
					put: 32 ; Enchanted_Rope
					setScaler: Scaler 58 25 135 23
				)
			)
			(5
				(rope setLoop: 2 setCel: 0 setCycle: CT 11 1 self)
			)
			(6
				(lSound2 stop:)
				(localSound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpInBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2551)
				(Load rsVIEW 25515)
				(gEgo setMotion: PolyPath 168 130 self)
			)
			(1
				(gEgo
					setScale: 0
					posn: 158 140
					view: 2551
					setLoop: 2
					cel: 12
					setCycle: End self
				)
			)
			(2
				(gEgo posn: 162 138 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(rope dispose:)
				(gEgo
					view: 25515
					posn: 169 176
					setLoop: 4
					cel: 0
					setCycle: End self
				)
			)
			(4
				(bucket dispose:)
				(gEgo
					setPri: 130
					posn: 171 128
					setLoop: 5
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 2552 loop: -1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(7
				(gEgo setLoop: 6 1 setMotion: MoveTo 170 5 self)
			)
			(8
				(gKqSound1 stop:)
				(gEgo hide:)
				(= seconds 2)
			)
			(9
				(gKqSound1 number: 837 loop: 1 play:)
				(proc98_15)
				(proc98_14)
				(proc98_15)
				(= ticks 180)
			)
			(10
				(gKqSound1 number: 4364 setLoop: 1 play:)
				(proc98_15)
				(= ticks 60)
			)
			(11
				(gGame handsOn:)
				(gCurRoom newRoom: 35) ; chapEndRm
			)
		)
	)
)

(instance sCartInMud of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: 1 setMotion: PolyPath 61 29 self)
			)
			(1
				(gMessager say: 2 38 2 0 self) ; "(THINKS TO HERSELF)I can't do ANYTHING with that cart until I get it out of the mud."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cart of Prop
	(properties
		noun 2
		sightAngle 40
		approachX 56
		approachY 36
		x 56
		y 29
		view 2550
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
		(if (not (IsFlag 62))
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
		(cond
			((IsFlag 64)
				(self posn: 72 35)
			)
			((IsFlag 85)
				(self posn: 69 33)
			)
		)
		(cond
			((IsFlag 65)
				(= cel 2)
			)
			((IsFlag 71)
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setInset: iBrokenCart)
			)
		)
	)
)

(instance shield of Prop
	(properties
		x 243
		y 98
		view 2556
		loop 4
	)
)

(instance troll of Prop
	(properties
		noun 4
		sightAngle 351
		approachX 215
		approachY 98
		approachDist 4
		x 259
		y 89
		view 2552
		loop 4
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 9998 approachVerbs: 8 43 41 38 97 46 45 36 setPri: 90) ; Do, Lantern, Wet_Sulfur, Shield, Shield_Spike, Hammer_and_Chisel, Big_Gem, Dragon_Scale
	)

	(method (cue)
		(brutusTalker clientCel: -1)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((IsFlag 369)
						(gEgo normalize: 6)
						(brutusTalker clientCel: -2)
						(gMessager say: noun theVerb 9 0 self) ; "(THINKS TO HERSELF)That guy just won't listen to reason."
					)
					((IsFlag 368)
						(gEgo normalize: 6)
						(brutusTalker clientCel: -2)
						(SetFlag 369)
						(gMessager say: noun theVerb 8 0 self) ; "I, Princess Rosella of Daventry, order you to let me pass!"
					)
					(else
						(gEgo normalize: 6)
						(brutusTalker clientCel: -2)
						(gMessager say: noun theVerb 6 0 self) ; "(POLITE)Good day, sir. I am--"
						(SetFlag 368)
					)
				)
				(return 1)
			)
			(else
				(if (IsFlag 368)
					(gCurRoom setScript: sOfferItem)
				else
					(gMessager say: 0 0 10 1) ; "(THINKS TO HERSELF)I suppose I should fin out what kind of fellow this really is."
				)
			)
		)
	)
)

(instance rope of Prop
	(properties
		approachX 174
		approachY 135
		x 158
		y 140
		view 2551
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sUpInBucket)
			)
		)
	)
)

(instance bucket of View
	(properties
		noun 1
		approachX 155
		approachY 134
		x 194
		y 119
		view 2550
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 130 approachVerbs: 8 10 40 setHotspot: 8 10 40) ; Do, Exit, Enchanted_Rope, Do, Exit, Enchanted_Rope
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 70)
					(gCurRoom setScript: sUpInBucket)
				else
					(gMessager say: noun theVerb 1 1) ; "(THINKS TO HERSELF NERVOUSLY)That doesn't look too stable."
					(self setHotspot: 0 40) ; Enchanted_Rope
				)
			)
			(40 ; Enchanted_Rope
				(gCurRoom setScript: sRopeTiesItself)
			)
		)
	)
)

(instance bridge of Feature ; UNUSED
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 113 305 96 304 88 275 77 288 67 318 60 315 50 257 68 253 75 276 90 217 101
					yourself:
				)
		)
	)
)

(instance hallDoor of ExitFeature
	(properties
		nsLeft 13
		nsTop 73
		nsRight 38
		nsBottom 106
		sightAngle 351
		approachX -2
		approachY 105
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom newRoom: 2450)
			(return 1)
		)
	)
)

(instance lairDoor of ExitFeature
	(properties
		nsLeft 296
		nsTop 31
		nsRight 315
		nsBottom 52
		sightAngle 351
		approachX 330
		approachY 46
		approachDist 2
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom newRoom: 2600)
			(return 1)
		)
	)
)

(instance lava1 of Actor
	(properties
		x 188
		y 68
		scaleX 0
		scaleY 0
		priority 139
		fixPriority 1
		view 25590
		loop 3
		cel 1
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance lava2 of Actor
	(properties
		x 240
		y 139
		scaleX 0
		scaleY 0
		priority 51
		fixPriority 1
		view 25590
		cel 1
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance lava3 of Actor
	(properties
		x 172
		y 51
		scaleX 0
		scaleY 0
		priority 66
		fixPriority 1
		view 25590
		loop 1
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance lava4 of Actor
	(properties
		x 205
		y 52
		scaleX 0
		scaleY 0
		priority 85
		fixPriority 1
		view 25590
		loop 2
		cel 3
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance brutusTalker of KQTalker
	(properties)
)

(instance iBrokenCart of Inset
	(properties
		picture 2560
		priority 100
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 65)
				(cuShield init:)
				(cuSpike init: setPri: (+ (cuShield priority:) 10))
				(axlFeature init: setHotspot: 0)
			)
			((IsFlag 71)
				(axlFeature init:)
				(cuShield init:)
				(axlFeature
					setHotspot: 97 97 ; Shield_Spike, Shield_Spike
					nsTop: 81
					nsBottom: 145
					nsLeft: 134
					nsRight: 198
				)
			)
			((IsFlag 370)
				(axlFeature init:)
			)
		)
		(proc11_6)
		(if (IsFlag 370)
			(gMessager say: 2 0 14 0) ; "Hmmm...I wonder if I could fix this little cart?"
			(rideButton
				view: 984
				loop: 1
				cel: 0
				posn: 280 10
				roomNum: 0
				disposeNow: 0
				init:
				setHotspot: 0 10 8 ; Exit, Do
			)
		else
			(gMessager say: 2 0 13 0) ; "It's a little cart. Oh, but it's broken. It's no use to me."
		)
	)
)

(instance axlFeature of Feature
	(properties
		nsLeft 121
		nsTop 102
		nsRight 173
		nsBottom 144
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 38 38 97) ; Shield, Shield, Shield_Spike
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Shield_Spike
				(gMessager say: 2 97 5 0) ; "(THINKS TO HERSELF)I wonder if I could somehow use this as a fastener...?"
			)
			(38 ; Shield
				(if (IsFlag 79)
					(gEgo put: 29) ; Shield
					(SetFlag 71)
					(cart setCel: 1)
					(cuShield init:)
					(self setHotspot: 97 97) ; Shield_Spike, Shield_Spike
					(= nsTop 81)
					(= nsBottom 145)
					(= nsLeft 134)
					(= nsRight 198)
				else
					(gMessager say: 2 38 3 0) ; "(THINKS TO HERSELF)That MIGHT work...if it weren't for that darned spike."
				)
			)
		)
	)
)

(instance cuSpike of Actor
	(properties
		x 157
		y 112
		view 25600
		loop 1
	)
)

(instance cuShield of Actor
	(properties
		x 135
		y 137
		view 25600
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 97 97) ; Shield_Spike, Shield_Spike
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Shield_Spike
				(gMessager say: 2 97 4 0) ; "(MUTTERING)I'll just make sure that shield doesn't go anywhere...there!"
				(SetFlag 65)
				(cart setCel: 2)
				(gEgo put: 30) ; Shield_Spike
				(cuSpike init: setPri: 200)
				(self setHotspot: 0)
				(axlFeature setHotspot: 0)
			)
		)
	)
)

(instance rideButton of ExitButton
	(properties)

	(method (doVerb)
		(gCurRoom notify:)
		(= disposeNow 1)
	)
)

(instance lavaSound of Sound
	(properties)
)

(instance cartSound of Sound
	(properties)
)

(instance localSound of Sound
	(properties)
)

(instance splashSound of Sound
	(properties)
)

(instance lSound2 of Sound
	(properties)
)

(instance scream of Prop
	(properties)

	(method (init)
		(self
			view: (troll view:)
			loop: (+ (troll loop:) 20)
			cel: 6
			posn: (troll x:) (troll y:)
		)
		(super init: &rest)
	)

	(method (cue)
		(= local1 1)
		(super cue: &rest)
		(self dispose:)
	)
)

