;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use System)

(public
	rm055 0
)

(local
	[local0 34] = [0 158 16 154 33 164 42 161 92 171 110 164 130 162 140 172 168 165 204 145 222 142 262 160 268 171 295 172 319 178 319 189 0 189]
	[local34 42] = [0 157 15 154 32 164 43 161 69 165 94 147 94 137 102 132 102 127 129 108 129 91 173 89 199 71 198 49 218 47 233 34 234 28 256 28 284 7 284 0 0 0]
	[local76 70] = [95 148 93 130 129 110 133 91 174 89 198 72 199 50 216 48 233 35 235 28 256 28 284 6 284 0 319 0 319 69 283 105 278 104 276 101 283 90 282 87 274 89 262 101 258 100 254 105 240 101 226 114 235 117 214 136 203 139 172 160 133 174 128 167 108 164 91 171 74 164]
	[local146 18] = [319 178 278 171 265 160 271 155 297 126 302 113 298 107 284 104 319 70]
	[local164 68] = [233 122 243 112 240 112 236 114 231 115 227 114 228 110 240 102 245 105 253 105 257 102 265 101 265 98 274 89 279 88 282 90 282 93 275 99 276 104 283 106 291 106 299 110 301 115 299 119 296 123 267 156 259 162 253 164 253 161 243 152 240 142 232 141 223 142 219 140]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(gLongSong2 number: 105 vol: 127 loop: 1 play:)
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

(instance rm055 of SQRoom
	(properties
		picture 55
		style 10
		horizon 29
		north 40
		east 60
		vanishingX 320
		vanishingY -70
	)

	(method (init)
		(Load rsVIEW 106)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(east
				(cond
					((> (gEgo y:) 172)
						(gEgo y: 172)
					)
					((< 110 (gEgo y:) 135)
						(gEgo y: 108)
					)
				)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(if (IsFlag 0)
			(HandsOff)
			(LoadMany rsVIEW 7 13)
			(cop1 init:)
			(cop2 init:)
		)
		(gEgo init:)
		(aircar init:)
		(theRubble init:)
		(theLeftBldg init:)
		(theStreet init:)
		(theSidewalk init:)
		(theArea init:)
		(self setRegions: 701) ; street
		(super init:)
		(self setRegions: 705) ; bunny
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 288 0 288 10 257 33 221 33 170 66 213 66 180 93 127 93 69 138 120 138 86 163 161 163 211 136 223 124 212 121 223 107 307 107 307 126 304 130 301 133 279 158 262 167 274 173 285 170 319 172 319 189 0 189 0 0
					yourself:
				)
		)
		(rubblePoly points: @local0 size: 17)
		(buildingPoly points: @local34 size: 21)
		(streetPoly points: @local146 size: 9)
		(sidewalkPoly points: @local76 size: 35)
		(aircarPoly points: @local164 size: 34)
	)

	(method (newRoom newRoomNumber)
		(cond
			(
				(and
					(== (gEgo edgeHit:) 1)
					(!= script exitScript)
					(!= script (ScriptID 701 3)) ; cyborgScreams
					(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
				)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) 1) (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 315 -1 setMotion: MoveTo 280 47 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 310 -1 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance cop1 of Sq4Actor
	(properties
		x 204
		y 125
		view 7
		loop 2
	)

	(method (doit)
		(super doit: &rest)
		(if (not (self script:))
			(HandsOff)
			(self setScript: shootEgo)
		)
	)
)

(instance cop2 of Sq4Actor
	(properties
		x 88
		y 135
		view 7
	)
)

(instance shootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 15) (+ (gEgo y:) 50)
				)
				(= cycles 1)
			)
			(1
				(cop1 setCycle: Walk setMotion: MoveTo 237 80 self)
				(cop2 setCycle: Walk setMotion: DPath 138 143 236 65)
			)
			(2
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(3
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
			(4
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
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(5
				(gEgo setCycle: CT 1 -1 self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(= seconds 4)
			)
			(8
				(EgoDead 8) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
		)
	)
)

(instance closeup of Sq4View
	(properties
		x 233
		y 188
		z 13
		sightAngle 45
		view 106
		priority 13
		signal 16400
		lookStr 1 ; "The interior of the aircar sports many broken gauges and instruments as well as a glove box."
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(self hide: dispose:)
		)
		(if (> ((ScriptID 701 1) y:) 165) ; deathDroid
			((ScriptID 701 1) setPri: 13) ; deathDroid
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 13)
		)
	)
)

(instance glovebox of Sq4View
	(properties
		x 249
		y 189
		z 30
		sightAngle 45
		view 106
		loop 1
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(self hide: dispose:)
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 30)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch cel
					(0
						(if (== ((gInventory at: 15) owner:) 55) ; laptop
							(= cel 2)
						else
							(= cel 1)
						)
						(latchClick play:)
					)
					(1
						(= cel 0)
						(latchClick play:)
					)
					(2
						(gEgo get: 15) ; laptop
						(= cel 1)
						(SetScore 40 5)
						(gNarrator say: 2) ; "After taking a quick look around to reassure yourself that the place is as dead as it looks, you snitch the PocketPal(tm) laptop."
					)
				)
			)
			(1 ; Look
				(switch cel
					(0
						(gNarrator say: 3) ; "It is a closed glove box."
					)
					(1
						(gNarrator say: 4) ; "The glove box is empty."
					)
					(2
						(gNarrator say: 5) ; "It looks like a genuine PocketPal(tm) portable terminal."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aircar of Sq4Feature
	(properties
		x 257
		y 127
		nsTop 87
		nsLeft 216
		nsBottom 167
		nsRight 299
		sightAngle 45
		lookStr 6 ; "A quick inspection reveals nothing of interest other than a glove box."
	)

	(method (init)
		(super init:)
		(self onMeCheck: aircarPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(HandsOff)
					(if (> (gEgo x:) 260)
						(carScript register: 1)
					)
					(gCurRoom setScript: carScript)
				)
			)
			(6 ; Smell
				(gNarrator say: 7) ; "The zesty tang of nitroglycerin fills the air around the ship."
			)
			(7 ; Taste
				(gNarrator say: 8) ; "It tastes like ship."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aircarPoly of Polygon
	(properties)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 279 158 self)
				else
					(gEgo setMotion: PolyPath 219 131 self)
				)
			)
			(1
				(if register
					(gEgo setHeading: 225 self)
				else
					(gEgo setHeading: 135 self)
				)
			)
			(2
				(glovebox init:)
				(closeup init: stopUpd:)
				(= cycles 1)
			)
			(3
				(self register: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 160
		y 187
		sightAngle 45
		lookStr 9 ; "This place is a mess. Dangerous terrain prevents travel to the south."
	)

	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 10) ; "The rubble is too hazardous to attempt passage over."
			)
			(6 ; Smell
				(gNarrator say: 11) ; "It smells a little like pebbles and a little like the rubbles."
			)
			(7 ; Taste
				(gNarrator say: 12) ; "It tastes like a cement milkshake, only crunchy."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rubblePoly of Polygon
	(properties)
)

(instance theSidewalk of Sq4Feature
	(properties
		lookStr 13 ; "A sidewalk anyone would be proud to own."
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalkPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 14) ; "This section of the sidewalk still smells fresh after hundreds of years."
			)
			(7 ; Taste
				(gNarrator say: 15) ; "There's nothing like fresh air and sunshine to make a sidewalk taste great."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalkPoly of Polygon
	(properties)
)

(instance theStreet of Sq4Feature
	(properties
		lookStr 16 ; "More high-speed travel surface lies useless."
	)

	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 17) ; "It smells like something that wasn't designed for noses."
			)
			(7 ; Taste
				(tROGER say: 1) ; "Eeyew! That was a bitter section! I don't think I want to lick the road around here anymore."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance theLeftBldg of Sq4Feature
	(properties
		x 101
		y 140
		z 113
		sightAngle 25
		lookStr 18 ; "This sealed, battered building is the last one standing in the southwestern area."
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 1) ; "The interior of the aircar sports many broken gauges and instruments as well as a glove box."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 19 ; "You are at the southwestern boundary of this chunk of city."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance latchClick of Sound
	(properties
		number 812
	)
)

(instance tROGER of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

