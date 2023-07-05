;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	[local0 16]
	[local16 17] = [36 264 22 292 298 105 210 55 53 272 272 289 215 29 110 34 159]
	[local33 17] = [10 4 41 44 180 9 6 78 105 72 110 141 179 173 182 147 17]
	[local50 17] = [1 2 3 3 4 2 1 7 7 8 8 2 3 3 4 1 5]
	local67
	[local68 2]
	local70
	local71
	local72
	local73
	local74
	local75
	local76
	[local77 4] = [1630 19 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		((= [local0 temp0] (wave new:))
			x: [local16 temp0]
			y: [local33 temp0]
			loop: [local50 temp0]
			init:
		)
	)
)

(procedure (localproc_1)
	(= local71 512)
	(gEgo
		setMotion:
			DPath
			229
			168
			240
			177
			251
			179
			262
			176
			269
			169
			271
			161
			268
			153
			261
			149
			252
			148
			234
			147
			221
			145
			221
			135
			self
	)
)

(instance rm630 of Rm
	(properties
		picture 630
	)

	(method (init)
		(Load rsSCRIPT 964)
		(super init:)
		(if (!= (gRgnMusic number:) 630)
			(gRgnMusic number: 630 loop: -1 play:)
		)
		(HandsOn)
		(if (not (IsFlag 0))
			(localproc_0)
		)
		(Load rsVIEW 630)
		(AddToFeatures
			monastery
			tortureTower
			swTower
			nwTower
			neTower
			mainGate
			refectory
			yard
			extraRms
			emptyRms
			cel1
			cel2
			cel3
			cel4
			cel5
			cel6
			cel7
			cel8
			cel9
			cel10
			cel11
			cel12
			cel13
			cel14
			cel15
			cel16
		)
		(gEgo view: 48 init:)
		(switch gPrevRoomNum
			(680
				(waterGate init:)
				(gFeatures addToFront: waterGate doit:)
				(= local74 161)
				(= local75 48)
				(gEgo posn: 161 37 setScript: movinOnIn)
			)
			(650
				(gEgo setScript: inFromScribes)
			)
			(670
				(HandsOff)
				(if (and (== (Monastery fulkStatus:) 3) (== local76 0))
					(gEgo posn: 98 51 setMotion: MoveTo 98 61)
					(fulk init:)
					(gEgo setScript: splitToTheGate)
				else
					(= local74 98)
					(= local75 61)
					(gEgo posn: 98 51 setScript: movinOnIn)
				)
			)
			(640
				(switch (Monastery whichDoor:)
					(0
						(= local74 130)
						(= local75 100)
						(gEgo posn: 132 100 setScript: movinOnIn)
					)
					(1
						(= local74 130)
						(= local75 115)
						(gEgo posn: 132 115 setScript: movinOnIn)
					)
					(2
						(= local74 130)
						(= local75 129)
						(gEgo posn: 132 129 setScript: movinOnIn)
					)
					(3
						(= local74 161)
						(= local75 145)
						(gEgo posn: 161 141 setScript: movinOnIn)
					)
					(4
						(= local74 190)
						(= local75 129)
						(gEgo posn: 190 129 setScript: movinOnIn)
					)
					(5
						(= local74 192)
						(= local75 115)
						(gEgo posn: 190 115 setScript: movinOnIn)
					)
					(6
						(= local74 192)
						(= local75 100)
						(gEgo posn: 190 100 setScript: movinOnIn)
					)
				)
			)
			(else
				(gEgo setScript: enterTheMap)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 106 103 106 109 106 118 106 124 121 133 121 138 108 138 98 126 98 80 108 80 108 83 152 83 153 81 170 81 170 83 215 83 215 81 225 81 225 128 214 138 203 138 203 137 203 133 216 124 217 118 217 109 217 103 217 94 188 94 188 97 180 97 180 94 143 94 143 97 135 97 135 94 106 94
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 98 76 98 64 108 54 214 54 225 65 225 76 215 76 209 63 114 63 107 76
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 135 101 143 101 143 112 135 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 135 115 143 115 143 126 135 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 124 132 135 132 135 130 143 130 143 132 159 132 159 138 124 138
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 180 101 188 101 188 112 180 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 180 115 188 115 188 125 180 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 162 132 180 132 180 130 188 130 188 132 200 132 200 138 162 138
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 162 189 162 160 175 143 225 143 226 167 231 178 249 185 272 176 275 153 258 142 229 139 229 52 242 47 237 40 226 49 99 49 86 30 72 39 95 52 95 140 93 145 96 148 97 143 149 143 159 160 159 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 147 96 160 96 160 112 147 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 163 96 176 96 176 112 163 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 147 114 160 114 160 130 147 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 163 114 176 114 176 130 163 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 169 74 160 80 153 74 160 68
					yourself:
				)
		)
		(HandsOff)
	)

	(method (cue)
		(HandsOn)
		(NormalEgo 3 48 49)
		(super cue:)
	)

	(method (newRoom newRoomNumber)
		(if (and (Monastery deathReason:) (!= newRoomNumber 680))
			(Monastery roomToDie: newRoomNumber)
			(super newRoom: 695) ; monDeath
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(if (gEgo script:)
			0
		else
			(cond
				((u>= (= temp0 (& $7ffe (gEgo onControl:))) 1024)
					(self setScript: takeOff 0 temp0)
				)
				((and temp0 (not (& local71 temp0)))
					(cond
						((and (& temp0 $0002) (not (Monastery deathReason:)))
							(gEgo setMotion: 0)
							(= local71 2)
							(if (not (Monastery deathReason:))
								(cond
									((>= (gEgo y:) 130)
										(Say 1630 16 1) ; "This is the way back to the Front Gate."
									)
									((== (Monastery wherePrior:) 0)
										(Say 1630 7 1) ; "A Monk stands guard over a prisoner that's being tortured in this tower."
									)
									((== (Monastery wherePrior:) 1)
										(Say 1630 8 1) ; "The Prior is within, surrounded by torture devices, with his unfortunate victim strung up on one of them."
									)
									((== (Monastery fulkStatus:) 0)
										(Say 1630 9 1) ; "The unfortunate prisoner is still suffering in this Torture Tower."
									)
									(
										(or
											(== (Monastery fulkStatus:) 1)
											(== (Monastery fulkStatus:) 2)
										)
										(Say 1630 10 1) ; "Fulk is still here as I left him."
									)
								)
							)
						)
						((& temp0 $0004)
							(gEgo setMotion: 0)
							(= local71 4)
							(cond
								(local70
									(gEgo setScript: inFromScribes)
								)
								(
									(and
										(== (Monastery stairsMessage:) 0)
										(not (Monastery deathReason:))
									)
									(Monastery stairsMessage: 1)
									(Say 1630 0 1) ; "There are spiral stairs leading upward in this tower."
								)
							)
						)
						((& temp0 $0008)
							(gEgo setMotion: 0)
							(= local71 8)
							(if
								(and
									(not (Monastery stairMessage:))
									(not (Monastery deathReason:))
								)
								(Monastery stairMessage: 1)
								(Say 1630 0 1) ; "There are spiral stairs leading upward in this tower."
							)
						)
						((& temp0 $0020)
							(gEgo setMotion: 0)
							(= local71 32)
							(if (not (Monastery deathReason:))
								(Say 1630 3 1) ; "The door to this tower is locked.  I've a hunch the Prior lives here."
							)
						)
						((& temp0 $0040)
							(gEgo setMotion: 0)
							(= local71 64)
							(if (not (Monastery deathReason:))
								(if (== (Monastery wherePrior:) 0)
									(Say 1630 13 1) ; "The Prior and other monks are in this Refectory."
								else
									(Say 1630 12 1) ; "The Prior is no longer here in the Refectory."
								)
							)
						)
						((& temp0 $0200)
							(gEgo setMotion: 0)
							(gEgo setScript: goOnIn)
						)
					)
				)
			)
			(if (mod gGameTime 2)
				(++ local67)
				(if (and (> (gGame detailLevel:) 2) (== (mod local67 5) 0))
					(Palette palANIMATE 216 239 1)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 964)
		(super dispose:)
	)
)

(instance yard of Feature
	(properties
		x 133
		y 59
		nsTop 59
		nsLeft 90
		nsBottom 90
		nsRight 218
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: toTheYard)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance extraRms of Feature
	(properties
		x 114
		y 92
		nsTop 92
		nsLeft 101
		nsBottom 134
		nsRight 136
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: extraRooms)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance emptyRms of Feature
	(properties
		x 201
		y 93
		nsTop 93
		nsLeft 184
		nsBottom 134
		nsRight 219
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: emptyRooms)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tortureTower of Feature
	(properties
		x 87
		y 52
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 87 47 67 50 56 45 47 35 47 23 63 12 82 11 94 16 101 28 96 39 94 42
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: theTortureTower)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance swTower of Feature
	(properties
		x 223
		y 52
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 223 23 233 12 249 8 267 12 277 21 280 30 277 39 271 46 265 51 250 52 237 48 230 42 223 31
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: prisonTower)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance neTower of Feature
	(properties
		x 102
		y 184
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 102 163 101 171 94 178 86 183 71 184 56 180 46 169 46 156 54 146 67 140 81 141 90 144 95 149 100 155
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: ToTheNETower)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance nwTower of Feature
	(properties
		x 252
		y 184
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 252 139 264 142 274 148 279 157 277 167 270 176 260 181 250 184 232 179 222 169 223 151 232 140
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
				(Say 1630 0 1) ; "There are spiral stairs leading upward in this tower."
			else
				(gEgo setScript: scribesTower)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance monastery of Feature
	(properties
		x 162
		y 30
		nsTop 32
		nsLeft 72
		nsBottom 162
		nsRight 252
		lookStr 6 ; "The stonework of this cheerless place is dank, and chilled by the mists of the fens."
	)
)

(instance cel1 of Feature
	(properties
		x 95
		y 118
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 75 118 90 118 91 141 75 141 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 95)
			(= local73 (Random 120 139))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel2 of Feature
	(properties
		x 93
		y 95
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 73 95 89 96 90 116 75 117 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 95)
			(= local73 (Random 97 115))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel3 of Feature
	(properties
		x 93
		y 73
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 75 73 90 73 89 95 75 94 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 95)
			(= local73 (Random 75 92))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel4 of Feature
	(properties
		x 93
		y 51
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 74 51 88 51 91 73 75 73 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 95)
			(= local73 (Random 53 71))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel5 of Feature
	(properties
		x 101
		y 32
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 112 31 112 44 101 44 101 32 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 102 112))
			(= local73 49)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel6 of Feature
	(properties
		x 124
		y 32
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 134 32 134 45 114 45 114 33 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 116 132))
			(= local73 49)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel7 of Feature
	(properties
		x 200
		y 32
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 211 32 211 45 189 45 188 33 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 190 209))
			(= local73 49)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel8 of Feature
	(properties
		x 218
		y 32
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 222 32 223 45 211 45 211 32 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 213 221))
			(= local73 49)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel9 of Feature
	(properties
		x 240
		y 75
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 233 75 250 76 250 97 234 97 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 229)
			(= local73 (Random 77 95))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel10 of Feature
	(properties
		x 240
		y 51
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 248 51 249 74 234 75 233 51 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 229)
			(= local73 (Random 53 75))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel11 of Feature
	(properties
		x 229
		y 96
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 250 96 251 119 234 119 234 97
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 229)
			(= local73 (Random 98 117))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel12 of Feature
	(properties
		x 240
		y 120
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 249 120 250 140 234 141 235 120
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 229)
			(= local73 (Random 122 139))
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel13 of Feature
	(properties
		x 218
		y 146
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 223 147 224 161 212 161 212 146
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 214 222))
			(= local73 142)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel14 of Feature
	(properties
		x 200
		y 147
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 188 147 211 147 212 160 189 161
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 190 210))
			(= local73 142)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel15 of Feature
	(properties
		x 122
		y 147
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 114 147 138 147 137 159 113 159
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 115 136))
			(= local73 142)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cel16 of Feature
	(properties
		x 110
		y 146
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 100 146 114 147 114 160 101 160
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(= local72 (Random 102 112))
			(= local73 142)
			(gEgo setScript: moveToCell)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance waterGate of Feature
	(properties
		x 162
		y 38
		nsTop 30
		nsLeft 137
		nsBottom 46
		nsRight 187
		lookStr 20 ; "This is the hidden entrance to the water gate that Fulk showed me.  He must be anxiously awaiting my return."
	)
)

(instance mainGate of Feature
	(properties
		x 162
		y 158
		nsTop 147
		nsLeft 137
		nsBottom 170
		nsRight 187
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: moveToFGate)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance refectory of Feature
	(properties
		x 162
		y 112
		nsTop 94
		nsLeft 143
		nsBottom 135
		nsRight 181
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gEgo setScript: toTheRefec)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance wave of Prop
	(properties
		view 630
		signal 16384
		cycleSpeed 18
		detailLevel 2
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance fulk of Actor
	(properties
		x 88
		y 51
		view 675
	)
)

(instance takeOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register
					(cond
						((& register $0400)
							(if (== (Monastery fulkStatus:) 3)
								(gEgo setScript: makeIt)
							)
						)
						((& register $0800)
							(gEgo setScript: moveToScribes)
						)
						((& register $1000)
							(if (>= (gEgo y:) 151)
								(HandsOn)
								(gCurRoom newRoom: 620)
							else
								(HandsOn)
								(gCurRoom newRoom: 670)
							)
						)
						((& register $2000)
							(gEgo setScript: moveToPTower)
						)
						((& register $4000)
							(= global104 (gEgo x:))
							(= global105 (gEgo y:))
							(cond
								((< global104 147)
									(cond
										((< 95 global105 104)
											(Monastery whichDoor: 0)
										)
										((< 110 global105 116)
											(Monastery whichDoor: 1)
										)
										((< 124 global105 132)
											(Monastery whichDoor: 2)
										)
									)
								)
								((and (< global104 170) (< global105 138))
									(Monastery whichDoor: 3)
								)
								((< global104 189)
									(cond
										((< 126 global105 138)
											(Monastery whichDoor: 4)
										)
										((< 110 global105 116)
											(Monastery whichDoor: 5)
										)
										((< 95 global105 104)
											(Monastery whichDoor: 6)
										)
									)
								)
							)
							(gEgo setScript: moveToRef)
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance moveToScribes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						DPath
						252
						148
						261
						149
						268
						153
						271
						161
						269
						169
						262
						176
						251
						179
						240
						177
						232
						172
						self
				)
			)
			(1
				(if (not (Monastery deathReason:))
					(Say 1630 11) ; "I see desks and scrolls inside. This is a room set aside for study."
				)
				(= local70 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inFromScribes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 650)
					(gEgo posn: 227 168)
				)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						DPath
						229
						168
						240
						177
						251
						179
						262
						176
						269
						169
						271
						161
						268
						153
						261
						149
						252
						148
						234
						147
						221
						145
						221
						135
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

(instance moveToRef of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(switch (Monastery whichDoor:)
					(0
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(1
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(3
						(gEgo setMotion: PolyPath 161 130 self)
					)
					(4
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(5
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(6
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 2)
								(gEgo y:)
								self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance moveToPTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						DPath
						240
						46
						256
						46
						264
						42
						269
						34
						269
						24
						260
						18
						244
						15
						236
						20
						229
						27
						self
				)
			)
			(1
				(Say 1630 2 self) ; "At the top of these stairs there's a locked door with a small barred window. Through it I see a small prison cell with no one inside."
			)
			(2
				(gEgo
					setMotion:
						DPath
						229
						27
						236
						20
						244
						15
						260
						18
						269
						24
						264
						42
						256
						46
						240
						46
						223
						51
						self
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveToCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath local72 local73 self)
			)
			(2
				(if (not (Random 0 1))
					(Say 1630 15 self 82 630 0 0) ; "These cells are cold and sparsely furnished. These Monks lead an ascetic life."
				else
					(Say 1630 14 self) ; "There's a Monk within in contemplation. I deem it wise not to disturb him."
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterTheMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 160 160 setMotion: PolyPath 150 145 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance prisonTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 230 52 self)
			)
			(2
				(Monastery stairsMessage: 1)
				(Say 1630 0 self) ; "There are spiral stairs leading upward in this tower."
			)
			(3
				(= local70 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance scribesTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(gEgo setMotion: PolyPath 232 145 self)
			)
			(2
				(Monastery stairMessage: 1)
				(Say 1630 0 self) ; "There are spiral stairs leading upward in this tower."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance extraRooms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 122 136 self)
			)
			(2
				(Say 1630 17) ; "It seems to be used as a kitchen, but is as barren and uninviting as the rest of this dreary place."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheYard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(if (> (gEgo x:) 162)
					(gEgo setMotion: PolyPath 221 79 self)
				else
					(gEgo setMotion: PolyPath 104 79 self)
				)
			)
			(2
				(Say 1630 5) ; "This open court has only a well in the center. Perhaps this is where the Monks practice fighting with the quarterstaff."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance emptyRooms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 202 136 self)
			)
			(2
				(Say 1630 18) ; "It's an empty room."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveToFGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 159 149 self)
			)
			(2
				(Say 1630 16) ; "This is the way back to the Front Gate."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheRefec of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 161 141 self)
			)
			(2
				(if (or (== (Monastery wherePrior:) 0) (== gPrevRoomNum 680))
					(Say 1630 13) ; "The Prior and other monks are in this Refectory."
				else
					(Say 1630 12) ; "The Prior is no longer here in the Refectory."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance makeIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 162 48 self)
			)
			(1
				(gEgo setMotion: MoveTo 162 38 self)
			)
			(2
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance splitToTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fulk setCycle: Walk setMotion: PolyPath 112 53 self)
			)
			(1
				(gEgo setMotion: PolyPath 98 53 self)
			)
			(2
				(fulk setMotion: PolyPath 165 53 self)
			)
			(3
				(gEgo setMotion: PolyPath 153 53 self)
			)
			(4
				(Converse @local77 (Monastery tFULK:) 0 self) ; "The Monks brought me in this way. It looks like a solid wall, but press here and it opens. Follow me."
			)
			(5
				(SetScore 10)
				(fulk setMotion: MoveTo 165 46 self)
			)
			(6
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance theTortureTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 95 47 self)
			)
			(2
				(= local71 2)
				(cond
					((== (Monastery wherePrior:) 0)
						(Say 1630 7 self) ; "A Monk stands guard over a prisoner that's being tortured in this tower."
					)
					((== (Monastery wherePrior:) 1)
						(Say 1630 8 self) ; "The Prior is within, surrounded by torture devices, with his unfortunate victim strung up on one of them."
					)
					((== (Monastery fulkStatus:) 0)
						(Say 1630 9 self) ; "The unfortunate prisoner is still suffering in this Torture Tower."
					)
					(
						(or
							(== (Monastery fulkStatus:) 1)
							(== (Monastery fulkStatus:) 2)
						)
						(Say 1630 10 self) ; "Fulk is still here as I left him."
					)
					(else
						(= cycles 1)
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

(instance movinOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo local74 local75 self)
			)
			(1
				(if (== gPrevRoomNum 680)
					(gEgo setMotion: PolyPath 98 53 self)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 1) (- (gEgo y:) 1) self
				)
			)
			(1
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance ToTheNETower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 170))
					(localproc_1)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 96 141 self)
			)
			(2
				(Say 1630 3 self) ; "The door to this tower is locked.  I've a hunch the Prior lives here."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

