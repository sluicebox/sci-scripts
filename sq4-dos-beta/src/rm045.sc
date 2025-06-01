;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm045 0
)

(local
	local0 = 200
	[local1 30] = [207 0 207 148 252 152 246 175 206 175 191 158 166 159 161 173 147 172 141 178 103 178 81 170 95 160 97 152 97 0]
	[local31 56] = [18 115 42 97 92 85 119 55 130 51 151 66 159 65 163 58 175 52 193 61 211 60 256 67 275 84 274 95 261 104 249 104 230 120 217 119 215 131 184 137 182 146 162 148 107 142 93 134 80 131 63 110 48 119 18 125]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(instance rm045 of SQRoom
	(properties
		style 30
		horizon 150
		north 30
		east 50
		south 60
		west 40
	)

	(method (init)
		(LoadMany rsVIEW 4 27 46)
		(Load rsSOUND 807)
		(switch gPrevRoomNum
			(25
				(gEgo x: 20 y: (+ horizon (gEgo yStep:)))
			)
			(30
				(gEgo
					loop: 2
					x:
						(cond
							((< (gEgo x:) 80) 80)
							((> (gEgo x:) 240) 240)
							(else
								(gEgo x:)
							)
						)
					y: 162
				)
			)
			(35
				(gEgo x: 300 y: (+ horizon (gEgo yStep:)))
			)
			(40
				(gEgo x: 5 y: 160)
			)
			(50
				(gEgo x: 315 y: 160)
			)
			(60
				(gEgo y: 189 setMotion: MoveTo (gEgo x:) 188)
			)
			(72
				(gear1 init: stopUpd:)
				(gear2 init: stopUpd:)
				(flap init: stopUpd:)
				(HandsOff)
				(self setScript: egoClimbsDown)
			)
			(else
				(gEgo loop: 2 posn: 160 162)
			)
		)
		(lightning1 init: hide: setScript: lightningScript)
		(thunder init:)
		(if (IsFlag 0)
			(Load rsPIC 46)
			(shipPoly points: @local31 size: 27)
			(shipFeature init:)
			(self horizon: 140 addObstacle: poly1)
			(gEgo illegalBits: 0)
			(poly1 points: @local1 size: 15)
			(LoadMany rsVIEW 7 45)
			(gear1 init: stopUpd:)
			(gear2 init: stopUpd:)
			(flap init: stopUpd:)
		)
		(self drawPic: 45)
		(if (or (IsFlag 0) (== gPrevRoomNum 72))
			(self overlay: 46 0)
		)
		(theRubble init:)
		(theRightBldg init:)
		(theLeftBldg init:)
		(theBackBldgs init:)
		(theArea init:)
		(self setRegions: 701) ; street
		(super init:)
		(self setRegions: 705) ; bunny
		(gEgo init:)
		(= picture 45)
		(if (!= gPrevRoomNum 72)
			(HandsOn)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 30)
			(cond
				((< (gEgo x:) 80)
					(= newRoomNumber 25)
				)
				((> (gEgo x:) 240)
					(= newRoomNumber 35)
				)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (not (IsFlag 0)) (gCurRoom script:)) 0)
			(
				(or
					(not (< 155 (gEgo y:) 185))
					(> (gEgo x:) 250)
					(< local0 0)
				)
				(gCurRoom setScript: shootEgo)
			)
			(else
				(-= local0 1)
			)
		)
	)
)

(instance enterScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: -5 y: 160 setMotion: MoveTo 10 160 self)
			)
			((HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lightningScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 30))
			)
			(1
				(client
					show:
					setCel: 0
					setCycle: ForwardCounter (Random 1 3) self
				)
			)
			(2
				(thunder play:)
				(client hide:)
				(= cycles 15)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance thunder of Sound
	(properties
		number 807
		vol 110
		priority 15
	)
)

(instance egoHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom horizon: 0)
				(gEgo setMotion: PolyPath 132 150 self)
			)
			(1
				(gEgo
					posn: 137 142
					view: 45
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo hide: dispose:)
				(= seconds 3)
			)
			(3
				(gLongSong init: number: 109 loop: 1 playBed:)
				(gear1
					setPri: 11
					cycleSpeed: 1
					setMotion: MoveTo (gear1 x:) 104
					setCycle: End flap
				)
				(gear2 setPri: 9 setMotion: DPath 188 134 174 120 174 78 self)
			)
			(4
				(gCurRoom newRoom: 72)
				(client setScript: 0)
			)
		)
	)
)

(instance egoClimbsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 45
					loop: 3
					cel: 8
					x: 137
					y: 142
					setCycle: Beg self
				)
			)
			(1
				(AnimateEgoHead)
				(gEgo
					normal: 1
					view: 0
					x: 135
					y: 164
					setCycle: Walk
					setMotion: MoveTo 157 172 self
				)
			)
			(2
				(gEgo setMotion: PolyPath 160 250 self)
			)
			(3
				(gEgo dispose:)
				(egoHides start: 2)
				(gCurRoom setScript: egoHides)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop1 init: setCycle: Walk setMotion: MoveTo 310 (cop1 y:) self)
				(cop2 init: setCycle: Walk setMotion: MoveTo 0 (cop2 y:))
			)
			(1
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(2
				(HandsOff)
				(cop1 setCycle: End self)
				(if (< (cop1 x:) (gEgo x:))
					(localproc_0
						(- (cop1 y:) 27)
						(cop1 x:)
						(- (gEgo y:) 32)
						(gEgo x:)
					)
				else
					(localproc_0
						(- (gEgo y:) 32)
						(gEgo x:)
						(- (cop1 y:) 27)
						(cop1 x:)
					)
				)
			)
			(3
				(gEgo
					view: 26
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo setCycle: CT 1 -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= seconds 4)
				(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lightning1 of Prop
	(properties
		x 150
		y 48
		view 46
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance gear1 of Actor
	(properties
		x 132
		y 120
		description {landing gear}
		lookStr {This is a landing gear assembly. It currently supports the ship.}
		view 45
		priority 13
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 0) (not (gCurRoom script:)))
					(if (not script)
						(HandsOff)
						(gCurRoom setScript: egoHides)
					else
						(Print 45 0) ; "You're starting to show your age."
					)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Inventory
				(switch invItem
					(1 ; rope
						(Print 45 1) ; "*** You look at your puny piece of rope and realize that it wouldn't be strong enough to hold this puppy to the ground."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gear2 of Actor
	(properties
		x 194
		y 134
		description {landing gear}
		lookStr {This is a landing gear assembly. It currently supports the ship.}
		view 45
		loop 1
		priority 11
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(Print 45 2) ; "*** There is no way you can budge the landing gear on this monster."
			)
			(6 ; Inventory
				(switch invItem
					(1 ; rope
						(Print 45 1) ; "*** You look at your puny piece of rope and realize that it wouldn't be strong enough to hold this puppy to the ground."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flap of Prop
	(properties
		x 141
		y 111
		description {flap}
		lookStr {This is the landing gear compartment flap.}
		view 45
		loop 2
		priority 13
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 0)
					(if (not script)
						(HandsOff)
						(gCurRoom setScript: egoHides)
					else
						(Print 45 0) ; "You're starting to show your age."
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setCycle: End)
	)
)

(instance cop1 of Actor
	(properties
		x 319
		y 155
		lookStr {Oh No! Sequel Police!}
		view 7
		loop 2
	)
)

(instance cop2 of Actor
	(properties
		x 330
		y 165
		lookStr {Oh No! Sequel Police!}
		view 7
	)
)

(instance theRubble of Feature
	(properties
		x 144
		y 99
		z 12
		nsBottom 200
		nsRight 320
		description {rubble}
		sightAngle 45
		onMeCheck 64
		lookStr {You see a rubble barrier to the north.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRightBldg of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {right building}
		onMeCheck 128
		lookStr {The relatively undamaged building shows no entrances.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theLeftBldg of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {left building}
		onMeCheck 8192
		lookStr {A once-prosperous bank building stands partially wrecked and sealed shut.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBackBldgs of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {back buildings}
		onMeCheck 16
		lookStr {In the distance not-so-fortunate buildings barely stand in ruin.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You stand centrally located in perhaps the only debris-clear area on the surface of this city. This was a busy intersection of commerce when times we're happier and life... well... just existed. An odd structure looms in the distance.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shipFeature of Feature
	(properties
		x 160
		y 100
		description {ship}
		sightAngle 25
		lookStr {*** It looks like a little shuttle has arrived.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: shipPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(Print 45 3) ; "*** If you took the ship you would have no way of carrying it around."
			)
			(6 ; Inventory
				(switch invItem
					(1 ; rope
						(Print 45 1) ; "*** You look at your puny piece of rope and realize that it wouldn't be strong enough to hold this puppy to the ground."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shipPoly of Polygon
	(properties)
)

