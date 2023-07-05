;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	[local0 6] = [9 53 85 238 271 311]
	[local6 7] = [132 114 101 101 117 131 0]
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 14] = [1640 16 2 1 2 1 2 1 2 1 2 1 2 0]
	[local35 11] = [1640 27 2 1 2 1 2 1 2 2 0]
	[local46 4] = [1625 1 1 0]
	[local50 4] = [1625 2 1 0]
	[local54 4] = [1625 3 1 0]
	[local58 4] = [1625 4 1 0]
	[local62 4] = [1625 5 1 0]
	[local66 4] = [1625 7 1 0]
	[local70 4] = [1625 6 1 0]
	[local74 4] = [1640 37 1 0]
)

(instance rm640 of Rm
	(properties
		picture 640
		picAngle 70
		vanishingX 164
		vanishingY 6
	)

	(method (init &tmp temp0)
		(super init:)
		(= local20 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(LoadMany rsVIEW 22 585)
		(AddToFeatures
			bench1
			bench2
			bench3
			bench4
			bench5
			bench6
			bench7
			bench8
			upLeftTable
			upRightTable
			lowLeftTable
			lowRightTable
			floor
			statue
			niche
			upLeftDoor
			lowLeftDoor
			upRightDoor
			lowRightDoor
			everything
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			((aTorch new:)
				x: [local0 temp0]
				y: [local6 temp0]
				cel: (mod temp0 3)
				init:
				setCycle: Fwd
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 260 113 319 113 319 139 286 139
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 297 148 319 148 319 170 yourself:)
				((Polygon new:) type: PBarredAccess init: 0 150 22 150 0 172 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 111 62 111 31 142 0 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 -1 319 101 250 101 235 87 205 87 201 91 190 91 171 90 150 90 131 91 82 91 70 103 0 103
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 40 138 78 100 155 102 138 140
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 166 102 247 103 273 137 168 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 150 146 144 186 13 186 43 150
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 313 186 170 186 166 150 291 150
					yourself:
				)
		)
		(gEgo posn: 1000 1000 loop: 0 init:)
		(NormalEgo)
		(HandsOff)
		(if (== (Monastery wherePrior:) 0)
			((ScriptID 625 2) ; prior
				loop: 0
				cel: 0
				posn: 177 91
				moveSpeed: 6
				cycleSpeed: 6
				init:
			)
			(monkey1 init: stopUpd:)
			(monkey2 init: stopUpd:)
		)
		(self setScript: cmonIn)
	)

	(method (doit &tmp temp0)
		(if (and (== global115 2) (not (gEgo script:)))
			(gEgo setScript: gotchaRobin)
		)
		(if (and (= temp0 (& $7ffe (gEgo onControl: 1))) (not script))
			(cond
				((& temp0 $0002)
					(Monastery whichDoor: 0)
				)
				((& temp0 $0004)
					(Monastery whichDoor: 1)
				)
				((& temp0 $0008)
					(Monastery whichDoor: 2)
				)
				((& temp0 $0080)
					(Monastery whichDoor: 3)
				)
				((& temp0 $0010)
					(Monastery whichDoor: 4)
				)
				((& temp0 $0020)
					(Monastery whichDoor: 5)
				)
				((& temp0 $0040)
					(Monastery whichDoor: 6)
				)
			)
			(gCurRoom newRoom: 630)
		else
			(super doit:)
		)
	)

	(method (dispose)
		(DisposeScript 927)
		(= gUseSortedFeatures local20)
		(super dispose:)
	)
)

(instance upLeftTable of Feature
	(properties
		x 72
		y 140
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 72 140 98 141 120 144 112 163 104 166 106 185 93 185 92 180 77 173 64 177 60 183 41 186 49 166 35 164 51 140
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 4 1) ; "The tables are old and much used. Probably left behind by the Normans."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance upRightTable of Feature
	(properties
		x 261
		y 98
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 261 137 275 162 263 163 261 182 255 182 240 172 229 173 216 185 200 185 210 164 194 166 186 139
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 4 1) ; "The tables are old and much used. Probably left behind by the Normans."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lowLeftTable of Feature
	(properties
		x 232
		y 92
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 232 92 246 118 236 120 244 134 192 136 202 123 193 122 180 92
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 4 1) ; "The tables are old and much used. Probably left behind by the Normans."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lowRightTable of Feature
	(properties
		x 134
		y 91
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 134 91 120 120 115 124 124 134 121 139 72 137 76 123 65 122 87 91
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 4 1) ; "The tables are old and much used. Probably left behind by the Normans."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench1 of Feature
	(properties
		x 74
		y 97
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 74 97 83 97 65 120 73 121 68 136 53 136 52 122
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench2 of Feature
	(properties
		x 132
		y 135
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 132 98 142 97 133 133 124 135 116 128 115 124 124 113
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench3 of Feature
	(properties
		x 173
		y 135
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 173 97 181 95 191 122 200 122 192 135 182 135 184 123 178 122
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench4 of Feature
	(properties
		x 235
		y 136
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 235 94 248 97 262 124 260 136 249 135 237 121 247 119
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench5 of Feature
	(properties
		x 42
		y 184
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 42 141 53 140 38 161 45 164 40 184 22 183 20 168
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench6 of Feature
	(properties
		x 123
		y 184
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 123 145 138 144 137 157 132 184 115 184 111 165
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench7 of Feature
	(properties
		x 170
		y 184
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 170 143 186 142 194 166 195 184 175 184
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bench8 of Feature
	(properties
		x 267
		y 184
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 267 140 279 142 296 165 295 182 277 182 273 163 277 161
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 35 1) ; "The benches look to be of the same worn vintage as the tables."
			)
			(3 ; Do
				(Say 1640 5 1) ; "This isn't a safe place to sit. I prefer to remain on my feet and ready for danger."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance floor of Feature
	(properties
		x 158
		y 84
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 81 87 238 84 319 164 319 189 0 189 0 160
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 36 1) ; "It's a miserably cold floor."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance statue of Feature
	(properties
		x 163
		y 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 7 1) ; "The Normans who built this fortress must have left behind this effigy of a Norman knight."
			)
			(3 ; Do
				(Say 1640 8 1) ; "A bit large and heavy to carry off, I think."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 163 13 169 26 173 29 171 62 169 72 173 75 174 85 162 87 148 86 148 77 152 74 151 52 146 51 149 38 152 30 157 24 157 17
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance niche of Feature
	(properties
		x 128
		y 7
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 128 86 127 36 132 21 146 9 158 7 170 8 188 17 193 26 193 87 177 78 146 78
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 10 1) ; "The alcove was built to hold the statue."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance upLeftDoor of Feature
	(properties
		x 49
		y 30
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 49 117 48 46 50 33 54 30 62 33 65 91 69 99
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 13 1) ; "The doorway is open, but I can see little in the darkness beyond it."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lowLeftDoor of Feature
	(properties
		x 10
		y 40
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 10 154 6 140 5 47 10 40 17 40 23 46 25 138
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 13 1) ; "The doorway is open, but I can see little in the darkness beyond it."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance upRightDoor of Feature
	(properties
		x 253
		y 33
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 253 97 256 40 259 33 266 33 271 37 273 51 274 119
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 13 1) ; "The doorway is open, but I can see little in the darkness beyond it."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lowRightDoor of Feature
	(properties
		x 293
		y 46
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 293 136 298 51 300 46 307 46 314 61 312 155
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 13 1) ; "The doorway is open, but I can see little in the darkness beyond it."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance everything of Feature
	(properties
		x 160
		nsBottom 189
		nsRight 319
		sightAngle 90
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1640 15 1) ; "More cold and unfriendly stone."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aTorch of Prop
	(properties
		z 70
		view 640
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1640 1 1) ; "The torches provide the only light and warmth this room has."
			)
			(3 ; Do
				(Say 1640 2 1) ; "It wouldn't be easy getting one off the wall. More trouble than it's worth, in fact."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monkey1 of Actor
	(properties
		x 215
		y 100
		view 16
		loop 1
	)

	(method (doVerb theVerb invItem)
		(= local15 monkey1)
		(switch theVerb
			(2 ; Look
				(Say 1625 0 self) ; "They all look the same with a hood over their heads."
			)
			(5 ; Talk
				(Converse @local46 11 0 self) ; "Silence is better than talk, Brother."
			)
			(3 ; Do
				(Converse @local50 11 0 self) ; "Keep your hands to yourself, Brother."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (> (gMoney doit:) 0)
							(gEgo setScript: buckMonkeys)
						)
					)
					(2 ; halfHeart
						(= local16 1)
						(gEgo setScript: takeAndRun)
					)
					(14 ; amethyst
						(= local17 1)
						(gEgo setScript: takeAndRun)
					)
					(17 ; handScroll
						(= local18 1)
						(gEgo setScript: takeAndRun)
					)
					(16 ; fulkScroll
						(= local19 1)
						(gEgo setScript: takeAndRun)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monkey2 of Actor
	(properties
		x 198
		y 105
		view 16
		loop 7
		cel 3
	)

	(method (doVerb theVerb invItem)
		(= local15 monkey2)
		(switch theVerb
			(2 ; Look
				(Say 1625 0 self) ; "They all look the same with a hood over their heads."
			)
			(5 ; Talk
				(Converse @local46 11 0 self) ; "Silence is better than talk, Brother."
			)
			(3 ; Do
				(Converse @local50 11 0 self) ; "Keep your hands to yourself, Brother."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (> (gMoney doit:) 0)
							(gEgo setScript: buckMonkeys)
						)
					)
					(2 ; halfHeart
						(= local16 1)
						(gEgo setScript: takeAndRun)
					)
					(14 ; amethyst
						(= local17 1)
						(gEgo setScript: takeAndRun)
					)
					(17 ; handScroll
						(= local18 1)
						(gEgo setScript: takeAndRun)
					)
					(16 ; fulkScroll
						(= local19 1)
						(gEgo setScript: takeAndRun)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cmonIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (Monastery whichDoor:)
					(0
						(gEgo posn: 43 106 setMotion: MoveTo 67 104 self)
					)
					(1
						(gEgo posn: 20 145 setMotion: MoveTo 48 143 self)
					)
					(2
						(gEgo posn: 2 189 setMotion: MoveTo 29 171 self)
					)
					(3
						(gEgo
							posn: 155 230
							loop: 3
							setMotion: MoveTo 128 184 self
						)
					)
					(4
						(gEgo
							posn: 283 189
							loop: 1
							setMotion: MoveTo 295 188 self
						)
					)
					(5
						(gEgo
							posn: 283 137
							loop: 1
							setMotion: MoveTo 259 138 self
						)
					)
					(6
						(gEgo
							posn: 283 106
							loop: 1
							setMotion: PolyPath 265 137 self
						)
					)
				)
			)
			(1
				(if
					(or
						(== (Monastery whichDoor:) 6)
						(== (Monastery whichDoor:) 5)
						(== (Monastery whichDoor:) 4)
					)
					(gEgo setMotion: PolyPath 123 137 self)
				else
					(self cue:)
				)
			)
			(2
				(Face gEgo (ScriptID 625 2) self) ; prior
			)
			(3
				(gCurRoom south: 630 east: 630 west: 630)
				(if (== (Monastery wherePrior:) 0)
					(client setScript: meetThePrior)
				else
					(HandsOn)
					(gTheIconBar disable: 5)
					(self dispose:)
				)
			)
		)
	)
)

(instance meetThePrior of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 15)
			)
			(1
				(Face (ScriptID 625 2) gEgo) ; prior
				(Face gEgo (ScriptID 625 2)) ; prior
				(= ticks 60)
			)
			(2
				(= ticks 60)
			)
			(3
				(Converse @local21 8 (Monastery tPRIOR:) self) ; "I don't recognize you. Who are you?"
			)
			(4
				(if
					(and
						(IsFlag 25)
						(or
							(gEgo has: 10) ; fireRing
							(== ((gInventory at: 12) owner:) 140) ; puzzleBox
						)
					)
					(Converse @local35 8 (Monastery tPRIOR:) self) ; "Did you come through Nottingham? I seek news of strange happenings there. The Abbot has been robbed of a precious ring."
				else
					(self cue:)
				)
			)
			(5
				((ScriptID 625 2) ; prior
					setStep: 4 2
					setCycle: Walk
					setMotion: PolyPath 155 230 self
				)
			)
			(6
				(Monastery wherePrior: 1)
				(HandsOn)
				(gTheIconBar disable: 5)
				((ScriptID 625 2) dispose:) ; prior
				(self dispose:)
			)
		)
	)
)

(instance takeAndRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 162 95 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 1)
			)
			(2
				(cond
					((== local16 1)
						(Converse @local58 11 0 self) ; "That is a fine piece of emerald! The Prior will be most glad to have it."
						(gEgo put: 2 -1) ; halfHeart
						(SetScore -200)
						(= local16 0)
					)
					((== local17 1)
						(Converse @local62 11 0 self) ; "That is a fine bit of amethyst! The Prior will be most glad to have it."
						(gEgo put: 14 -1) ; amethyst
						(SetScore -50)
						(= local17 0)
					)
					((== local18 1)
						(Converse @local70 11 0 self) ; "That belongs in the scribes' room, Brother. I shall see that it is returned."
						(gEgo put: 17 -1) ; handScroll
						(= local18 0)
					)
					((== local19 1)
						(Converse @local66 11 0 self) ; "The Prior was studying this. A waste of his time, I suspect, but I shall return it to his desk."
						(gEgo put: 16 -1) ; fulkScroll
						(= local19 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (== local15 monkey1)
					(monkey1 setCycle: Walk setMotion: PolyPath 310 110 self)
				else
					(monkey2 setCycle: Walk setMotion: PolyPath 310 110 self)
				)
			)
			(4
				(if (== local15 monkey1)
					(monkey1 dispose:)
				else
					(monkey2 dispose:)
				)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance gotchaRobin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= gDeathNum 20)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 152 135 self)
			)
			(2
				((= local13 ((ScriptID 625 1) new:)) ; chip
					view: 16
					loop: 0
					cel: 0
					x: 12
					y: 146
					setCycle: Walk
					init:
					setMotion: MoveTo 152 155 self
				)
			)
			(3
				(Face gEgo local13 self)
			)
			(4
				(Face local13 gEgo self)
			)
			(5
				(= cycles 10)
			)
			(6
				(Converse @local74 11 0 self) ; "That ring! You're the thief the Abbott wants!"
			)
			(7
				(local13 view: 585 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(8
				(dieSound play:)
				(gEgo view: 22 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance buckMonkeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local54 11 0 self) ; "Have you forgotten our vows of Poverty and Obedience? You should have turned this money over to the Prior."
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

