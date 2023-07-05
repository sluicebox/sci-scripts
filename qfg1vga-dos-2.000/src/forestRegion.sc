;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use n101)
(use n102)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Game)
(use System)

(public
	forestRegion 0
	walkIn 1
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
	local9
	local10
	local11
	local12
	local13
)

(instance forestRegion of Rgn
	(properties
		modNum 804
		noun 2
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(Load rsVIEW 510)
		(LoadMany rsSCRIPT 103)
		(= temp0 (gCurRoom picture:))
		(if (<= 704 temp0 707)
			(= local0 1)
		)
		(= temp1 (if gNight 32 else 25))
		(if (or (== (gLongSong prevSignal:) -1) (!= (gLongSong number:) temp1))
			(gLongSong stop: number: temp1 loop: -1 priority: 0 play:)
		)
		(= local1 0)
		(= local2 0)
		(switch (gEgo edgeHit:)
			(1
				(= local1 160)
				(= local2 230)
			)
			(3
				(= local1 145)
				(= local2 56)
			)
			(2
				(= local1 -30)
				(= local2 110)
			)
			(4
				(= local1 350)
				(= local2 110)
			)
		)
		(cond
			((== gCurRoomNum 11)
				(= local6 11)
				(= local7 17)
				(= local8 12)
				(= local9 11)
			)
			((== gCurRoomNum 12)
				(= local6 10)
				(= local7 12)
				(= local8 13)
				(= local9 11)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 103 204 103 162 80 165 26 145 25 126 82 0 80
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 118 123 169 210 168 319 135 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 17)
				(= local6 11)
				(= local7 25)
				(= local8 18)
				(= local9 16)
			)
			((== gCurRoomNum 18)
				(= local6 18)
				(= local7 18)
				(= local8 19)
				(= local9 17)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 65 221 70 170 63 144 67 141 102 106 118 0 102
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 144 126 176 204 176 210 132 254 119 319 119 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 19)
				(= local6 19)
				(= local7 26)
				(= local8 19)
				(= local9 18)
			)
			((== gCurRoomNum 23)
				(= local6 23)
				(= local7 34)
				(= local8 24)
				(= local9 23)
			)
			((== gCurRoomNum 24)
				(= local6 16)
				(= local7 35)
				(= local8 25)
				(= local9 23)
			)
			((== gCurRoomNum 25)
				(= local6 17)
				(= local7 36)
				(= local8 25)
				(= local9 24)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 203 189 208 128 234 83 166 66 153 39 128 39 149 89 121 117 0 109
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 145 89 158 140 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 26)
				(= local6 19)
				(= local7 42)
				(= local8 27)
				(= local9 19)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 103 198 103 162 80 156 26 131 26 131 80 115 80 58 110 118 147 124 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 216 189 248 152 319 136 319 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 27)
				(= local6 27)
				(= local7 27)
				(= local8 28)
				(= local9 26)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 65 221 70 170 63 144 67 141 102 106 118 0 102
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 144 126 176 204 176 210 132 254 119 319 119 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 33)
				(= local6 22)
				(= local7 45)
				(= local8 34)
				(= local9 33)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 94 160 61 160 37 126 37 128 61 143 79 139 107 85 147 133 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 218 189 206 143 228 124 319 136 319 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 34)
				(= local6 23)
				(= local7 51)
				(= local8 35)
				(= local9 33)
			)
			((== gCurRoomNum 35)
				(= local6 24)
				(= local7 52)
				(= local8 36)
				(= local9 34)
			)
			((== gCurRoomNum 36)
				(= local6 25)
				(= local7 53)
				(= local8 36)
				(= local9 35)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 139 27 128 99 0 103 0 0 319 0 319 189 197 189 200 140 221 114 163 71 161 27
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 138 98 146 119 167 121 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 42)
				(= local6 26)
				(= local7 56)
				(= local8 43)
				(= local9 42)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 94 160 61 160 37 126 37 128 61 143 79 139 107 85 147 133 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 218 189 206 143 228 124 319 136 319 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 43)
				(= local6 43)
				(= local7 57)
				(= local8 43)
				(= local9 42)
			)
			((== gCurRoomNum 44)
				(= local6 44)
				(= local7 61)
				(= local8 45)
				(= local9 44)
			)
			((== gCurRoomNum 51)
				(= local6 34)
				(= local7 63)
				(= local8 52)
				(= local9 45)
			)
			((== gCurRoomNum 52)
				(= local6 35)
				(= local7 64)
				(= local8 53)
				(= local9 51)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 67 169 67 154 36 132 36 145 95 104 120 0 101
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 148 132 172 238 172 199 159 197 147 319 110 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 56)
				(= local6 42)
				(= local7 66)
				(= local8 57)
				(= local9 54)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 135 82 104 92 0 88 0 0 319 0 319 99 198 99 154 65 154 26 135 26
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 216 122 319 122 319 189 201 189 201 139
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 102 106 122 121 152 121 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 57)
				(= local6 43)
				(= local7 67)
				(= local8 58)
				(= local9 56)
			)
			((== gCurRoomNum 61)
				(= local6 44)
				(= local7 69)
				(= local8 62)
				(= local9 60)
			)
			((== gCurRoomNum 62)
				(= local6 45)
				(= local7 70)
				(= local8 63)
				(= local9 61)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 71 178 72 146 34 127 34 145 89 123 114 45 114 0 91
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 141 140 173 140 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 208 137 319 111 319 189 208 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 63)
				(= local6 51)
				(= local7 71)
				(= local8 64)
				(= local9 62)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 135 82 104 92 0 88 0 0 319 0 319 99 198 99 154 65 154 26 135 26
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 216 122 319 122 319 189 201 189 201 139
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 102 106 122 121 152 121 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 66)
				(= local6 56)
				(= local7 75)
				(= local8 67)
				(= local9 65)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 121 148 77 125 83 87 106 86 137 79 145 61 175 61 177 66 221 92 228 91 231 122 217 123 182 153 137 159
						yourself:
					)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 86 216 86 180 64 180 27 186 16 157 16 136 76 100 85 0 85
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 127 72 127 129 158 129 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 189 189 189 152 220 127 319 127 319 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 67)
				(= local6 57)
				(= local7 67)
				(= local8 68)
				(= local9 66)
				(++ global287)
				(if (== (gEgo edgeHit:) 3)
					(= local1 132)
					(= local2 71)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 121 161 104 124 74 124 74 87 101 87 120 65 145 65 149 68 187 78 222 78 222 104 208 106 173 164 122 164
						yourself:
					)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 74 185 79 152 69 144 23 130 23 115 68 78 82 0 82
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 120 89 161 177 161 319 117 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 68)
				(= local6 68)
				(= local7 68)
				(= local8 68)
				(= local9 67)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 121 161 104 124 74 124 74 87 101 87 120 65 145 65 149 68 187 78 222 78 222 104 208 106 173 164 122 164
						yourself:
					)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 200 189 0 189 0 124 141 124 184 167 218 148 197 122 217 81 0 81
							yourself:
						)
				)
			)
			((== gCurRoomNum 69)
				(= local6 61)
				(= local7 69)
				(= local8 70)
				(= local9 69)
			)
			((== gCurRoomNum 71)
				(= local6 63)
				(= local7 78)
				(= local8 72)
				(= local9 70)
			)
			((== gCurRoomNum 72)
				(= local6 64)
				(= local7 79)
				(= local8 73)
				(= local9 71)
			)
			((== gCurRoomNum 74)
				(= local6 65)
				(= local7 81)
				(= local8 75)
				(= local9 73)
			)
			((== gCurRoomNum 75)
				(= local6 66)
				(= local7 75)
				(= local8 75)
				(= local9 74)
			)
			((== gCurRoomNum 77)
				(= local6 70)
				(= local7 77)
				(= local8 78)
				(= local9 76)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 149 104 94 116 0 100 0 0 319 0 319 67 183 67 165 59 157 29 138 29 138 59 149 76
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 140 92 140 122 171 201 171 201 139 221 123 319 124 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 78)
				(= local6 71)
				(= local7 84)
				(= local8 79)
				(= local9 77)
			)
			((== gCurRoomNum 79)
				(= local6 72)
				(= local7 85)
				(= local8 80)
				(= local9 78)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 67 169 67 154 36 132 36 145 95 104 120 0 101
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 148 132 172 238 172 199 159 197 147 319 110 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 80)
				(= local6 73)
				(= local7 80)
				(= local8 81)
				(= local9 79)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 128 78 109 89 0 89 0 0 319 0 319 104 203 104 167 65 157 29 138 29
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 109 99 133 122 171 201 171 201 139 221 123 319 124 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 81)
				(= local6 74)
				(= local7 87)
				(= local8 82)
				(= local9 80)
			)
			((== gCurRoomNum 85)
				(= local6 85)
				(= local7 85)
				(= local8 86)
				(= local9 84)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 93 101 0 85 0 0 319 0 319 99 190 101
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 122 106 122 121 166 203 166 202 132 319 132 319 189 0 189
							yourself:
						)
				)
			)
			((== gCurRoomNum 86)
				(= local6 86)
				(= local7 92)
				(= local8 86)
				(= local9 85)
			)
			((== gCurRoomNum 92)
				(= local6 86)
				(= local7 92)
				(= local8 92)
				(= local9 91)
			)
		)
		(cond
			((OneOf gCurRoomNum 12 24 26 34 61 72 74 78)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 133 179 133 148 105 118 105 94 129 94 134 71 153 72 234 130 204 160 204 180 133 180
						yourself:
					)
				)
				(if (and (!= gCurRoomNum 12) (!= gCurRoomNum 26))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 105 208 105 156 69 160 27 137 27 123 88 0 92
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 115 109 150 130 189 0 189
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 213 189 319 136 319 189
								yourself:
							)
					)
				)
			)
			((OneOf gCurRoomNum 36 56 63 77 80 85)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 124 141 106 114 105 94 139 83 172 83 210 121 193 138 193 183 124 183
						yourself:
					)
				)
			)
			((OneOf gCurRoomNum 18 25 27 33 42 52 62 79)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 143 166 98 139 98 117 129 117 148 92 149 67 175 67 185 73 262 76 264 109 200 137 200 184 143 184
						yourself:
					)
				)
			)
			((OneOf gCurRoomNum 17 35 51 57 71 81)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 96 178 68 152 42 125 42 148 89 123 116 0 83
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 140 114 168 133 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 221 189 319 145 319 189
							yourself:
						)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 147 88 226 88 226 139 212 139 212 182 137 182 130 162 99 147 147 87
						yourself:
					)
				)
			)
			((OneOf gCurRoomNum 11 23 44)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 177 95 131 113 127 128 35 154 19 189 0 189 0 0 319 0 319 75 248 81
							yourself:
						)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 125 185 125 128 190 95 220 95 235 85 315 85 315 102 281 102 218 129 206 146 195 169 193 185
						yourself:
					)
				)
			)
			((OneOf gCurRoomNum 19 43 86)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 196 189 223 147 176 109 82 82 0 75
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 118 128 189 0 189
							yourself:
						)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 126 181 39 100 45 84 86 85 174 107 192 125 192 183 126 182
						yourself:
					)
				)
			)
			((== gCurRoomNum 69)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 108 6 103 60 86 82 85 97 70 117 129 132 207 147 319 147 319 189 0 189 0 95 0 0 319 0 319 67 271 67 178 51 176 23 164 6
							yourself:
						)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 115 155 102 125 102 110 143 87 141 73 158 72 193 93 218 93 218 116 173 155
						yourself:
					)
				)
			)
			((OneOf gCurRoomNum 75 92)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 165 0 140 52 0 79
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 114 83 114 131 137 244 116 211 52 211 0 319 0 319 189 0 189
							yourself:
						)
				)
				(= local5
					((Polygon new:)
						type: PTotalAccess
						init: 69 111 68 68 142 54 161 15 206 15 206 54 226 88 227 110 201 121 128 131 84 110
						yourself:
					)
				)
				(if (== (gEgo edgeHit:) 3)
					(= local1 170)
				)
			)
		)
		(forestFloor init:)
		(forestTrees init:)
		(forestRocks init:)
		(gEgo setScript: walkIn)
	)

	(method (doit)
		(super doit:)
		(if local11
			(cond
				(
					(and
						(== local12 0)
						(or
							(and
								(== gCurRoomNum 77)
								(not gNight)
								(!= gPrevRoomNum 76)
								(not (IsFlag 197))
							)
							(and
								(== gCurRoomNum 78)
								(not gNight)
								(not (IsFlag 197))
								(!= gPrevRoomNum 77)
								(not (IsFlag 204))
							)
							(and
								(== gCurRoomNum 67)
								(or
									(== global287 2)
									(== global287 6)
									(== global287 9)
								)
							)
						)
					)
					(HandsOff)
				)
				((< (gEgo y:) 55)
					(HandsOff)
					(if (== (gEgo script:) walkIn)
						(walkIn dispose:)
					)
					(= local1 (gEgo x:))
					(= local2 47)
					(= local10 local6)
					(gEgo setScript: sExitAll)
				)
				((> (gEgo y:) 180)
					(HandsOff)
					(if (== (gEgo script:) walkIn)
						(walkIn dispose:)
					)
					(= local1 (gEgo x:))
					(= local2 250)
					(= local10 local7)
					(gEgo setScript: sExitAll)
				)
				((< (gEgo x:) 20)
					(HandsOff)
					(if (== (gEgo script:) walkIn)
						(walkIn dispose:)
					)
					(= local1 -20)
					(= local2 (gEgo y:))
					(= local10 local9)
					(gEgo setScript: sExitAll)
				)
				((> (gEgo x:) 300)
					(HandsOff)
					(if (== (gEgo script:) walkIn)
						(walkIn dispose:)
					)
					(= local1 335)
					(= local2 (gEgo y:))
					(= local10 local8)
					(gEgo setScript: sExitAll)
				)
				((and (== (gEgo script:) walkIn) (== (gEgo mover:) 0))
					(gEgo setScript: 0)
				)
			)
		else
			(HandsOff)
			(if (and (<= 30 (gEgo x:) 290) (<= 70 (gEgo y:) 180))
				(= local11 1)
				(if (or (== (gEgo script:) 0) (== (gEgo script:) walkIn))
					(HandsOn)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; calmSpell
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 1 0 804) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 1 0 804) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(51 ; openSpell
				(gMessager say: 2 58 0 2 0 804) ; "You don't see anything closed around here."
				(return 1)
			)
			(50 ; detectMagicSpell
				(gMessager say: 2 58 0 3 0 804) ; "You sense no magic here."
				(return 1)
			)
			(78 ; dazzleSpell
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 4 0 804) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(70 ; ???
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 4 0 804) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(81 ; flameDartSpell
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 4 0 804) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(79 ; zapSpell
				(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(if (or (gEgo has: 6) (gEgo has: 2)) ; dagger, sword
					(gMessager say: 2 58 0 5 0 804) ; "Your weapon is now magically charged."
				else
					(gMessager say: 2 58 0 6 0 804) ; "You don't seem to have a weapon to charge."
				)
				(return 1)
			)
			(82 ; fetchSpell
				(if
					(not
						(OneOf
							gCurRoomNum
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
					(gMessager say: 2 58 0 7 0 804) ; "Good practice, but there's nothing worth Fetching here."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(if local0
					(gMessager say: 2 1 1 0 0 804) ; "You are in a clearing at the edge of the forest. You are faced with impassably steep, rocky escarpments on two sides."
					(return 1)
				else
					(gMessager say: 2 1 0 0 0 804) ; "The late frosts of winter give way to to the greenery of spring. There is the crisp smell of cedar in the air. This forest seems to be unusually still and quiet."
					(return 1)
				)
			)
			(10 ; silver
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(11 ; rations
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(12 ; sword
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(13 ; chainMail
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(14 ; leather
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(15 ; shield
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(16 ; dagger
				(ThrowKnife 0)
				(return 1)
			)
			(17 ; lockPick
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(18 ; thiefKit
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(19 ; thiefLicense
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(20 ; rock
				(ThrowRock 0)
				(return 1)
			)
			(21 ; flask
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(22 ; healingPotion
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(23 ; manaPotion
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(24 ; staminaPotion
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(25 ; disenchant
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(26 ; brassKey
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(27 ; magicGem
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(28 ; ring
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(29 ; ghostOil
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(30 ; magicMirror
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(85 ; ???
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(31 ; mandrake
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(32 ; fruit
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(33 ; vegetables
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(34 ; acorn
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(35 ; seed
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(36 ; flowers
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(37 ; greenFur
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(38 ; fairyDust
				(gMessager say: 2 0 4 1 0 804) ; "You'd better not drop that if you ever want to become a hero."
				(return 1)
			)
			(39 ; flyingWater
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(40 ; mushroom
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(41 ; vase
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(42 ; candelabra
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(44 ; candleSticks
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(43 ; musicBox
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(45 ; pearls
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(75 ; ???
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(76 ; ???
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(53 ; paper
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(46 ; cheetaurClaw
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(47 ; trollBeard
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(48 ; Smell [ REMOVED ]
				(gMessager say: 2 48 0 1 0 804) ; "The forest smells alive with spring, but beware! You, too, could be part of the food chain."
				(return 1)
			)
			(49 ; gold
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(54 ; ???
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(55 ; ???
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(56 ; ???
				(gMessager say: 2 0 3 1 0 804) ; "Hey! This is a CLEAN game. Don't be a litterbug!"
				(return 1)
			)
			(4 ; Do
				(gMessager say: 2 0 2 1 0 804) ; "Nothing happens."
				(return 1)
			)
			(4 ; Do
				(gMessager say: 2 0 2 1 0 804) ; "Nothing happens."
				(return 1)
			)
			(2 ; Talk
				(gMessager say: 2 0 2 1 0 804) ; "Nothing happens."
				(return 1)
			)
			(57 ; Talk [ REMOVED ]
				(gMessager say: 2 0 2 1 0 804) ; "Nothing happens."
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forestFloor of Feature
	(properties
		y 1
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init: gFtrInitializer)
		(= onMeCheck local5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 1 1 1 0 0 804) ; "The clearing in which you stand is grassy and littered with blown pine needles and small mossy rocks."
					(return 1)
				else
					(gMessager say: 1 1 0 0 0 804) ; "Pine needles, small moss-covered rocks, and early spring grasses cover the forest floor."
					(return 1)
				)
			)
			(4 ; Do
				(gEgo setScript: (ScriptID 103 0)) ; getRock
			)
			(3 ; Walk
				(super doVerb: theVerb &rest)
			)
			(71 ; ???
				(super doVerb: theVerb &rest)
			)
			(16 ; dagger
				(ThrowKnife 0)
				(return 1)
			)
			(20 ; rock
				(ThrowRock 0)
				(return 1)
			)
			(else
				(forestRegion doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance forestRocks of Feature
	(properties
		x 319
		y 1
		z 188
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 128
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init: gFtrInitializer)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (= local13 (Random 0 12))
					(0
						(gMessager say: 3 1 18 0 0 804) ; "Corning never made these hunks of silicon."
						(return 1)
					)
					(1
						(gMessager say: 3 1 11 0 0 804) ; "Those rocks look solid enough to be taken for granite."
						(return 1)
					)
					(2
						(gMessager say: 3 1 17 0 0 804) ; "Roc's eggs? Or rock eggs?"
						(return 1)
					)
					(3
						(gMessager say: 3 1 15 0 0 804) ; "Those aren't the marbles you lost."
						(return 1)
					)
					(4
						(gMessager say: 3 1 9 0 0 804) ; "There are gallons of rocks here (more than quartz, eh?)"
						(return 1)
					)
					(5
						(gMessager say: 3 1 8 0 0 804) ; "Gibraltar they ain't."
						(return 1)
					)
					(6
						(gMessager say: 3 1 13 0 0 804) ; "Stone-age basketballs, perhaps."
						(return 1)
					)
					(7
						(gMessager say: 3 1 12 0 0 804) ; "You don't WANT to see the kidneys these stones came out of."
						(return 1)
					)
					(8
						(gMessager say: 3 1 6 0 0 804) ; "Mt. Everest, circa 8 zillion BC. (It gets bigger)."
						(return 1)
					)
					(9
						(gMessager say: 3 1 10 0 0 804) ; "Oliver Stone."
					)
					(10
						(gMessager say: 3 1 14 0 0 804) ; "Rock Hudson."
						(return 1)
					)
					(11
						(gMessager say: 3 1 7 0 0 804) ; "Boulder Colorado. Or Dam."
						(return 1)
					)
					(12
						(gMessager say: 3 1 16 0 0 804) ; "Pebble Beach."
						(return 1)
					)
				)
			)
			(4 ; Do
				(gMessager say: 3 4 0 1 0 804) ; "That rock's too big to budge."
				(return 1)
			)
			(2 ; Talk
				(gMessager say: 3 2 0 1 0 804) ; "You hear a stony silence."
				(return 1)
			)
			(57 ; Talk [ REMOVED ]
				(gMessager say: 3 2 0 1 0 804) ; "You hear a stony silence."
				(return 1)
			)
			(12 ; sword
				(gMessager say: 3 16 0 1 0 804) ; "That's not a whetstone."
				(return 1)
			)
			(16 ; dagger
				(gMessager say: 3 16 0 1 0 804) ; "That's not a whetstone."
				(return 1)
			)
			(3 ; Walk
				(super doVerb: theVerb &rest)
			)
			(73 ; Drop Inventory
				(super doVerb: theVerb &rest)
			)
			(71 ; ???
				(super doVerb: theVerb &rest)
			)
			(else
				(forestRegion doVerb: theVerb &rest)
			)
		)
	)
)

(instance forestTrees of Feature
	(properties
		x 319
		y 1
		z 188
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 64
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init: gFtrInitializer)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((<= (= local13 (Random 0 99)) 10)
						(gMessager say: 4 1 11 0 0 804) ; "Larch."
					)
					((<= local13 20)
						(gMessager say: 4 1 17 0 0 804) ; "Fir."
						(return 1)
					)
					((<= local13 30)
						(gMessager say: 4 1 15 0 0 804) ; "Scotch pine."
						(return 1)
					)
					((<= local13 38)
						(gMessager say: 4 1 9 0 0 804) ; "Redwood."
						(return 1)
					)
					((<= local13 56)
						(gMessager say: 4 1 8 0 0 804) ; "Ash. Christmas. Or maybe scrub oak. Do you really care what kind of tree this is?"
						(return 1)
					)
					((<= local13 64)
						(gMessager say: 4 1 13 0 0 804) ; "Spruce."
						(return 1)
					)
					((<= local13 72)
						(gMessager say: 4 1 12 0 0 804) ; "Ponderosa Pine."
						(return 1)
					)
					((<= local13 80)
						(gMessager say: 4 1 6 0 0 804) ; "Maple. Fortunately for it, you're not a sapsucker (regardless of your tummy color)."
						(return 1)
					)
					((== local13 81)
						(gMessager say: 4 1 10 0 0 804) ; "Gazebo on the hoof."
						(return 1)
					)
					((== local13 82)
						(gMessager say: 4 1 14 0 0 804) ; "Careful! If it floats, it could be a witch."
						(return 1)
					)
					((== local13 83)
						(gMessager say: 4 1 7 0 0 804) ; "Elmer Gantree."
						(return 1)
					)
					((== local13 84)
						(gMessager say: 4 1 16 0 0 804) ; "George Bush."
						(return 1)
					)
					((== local13 85)
						(gMessager say: 4 1 25 0 0 804) ; "Congratulations! You have found the world famous money tree! In but forty-seven years it will be ripe for harvest and you will be wealthy beyond your wildest dreams, unless changes in the tax code make it prohibitively expensive to harvest it. On second thought, better leave it alone, while you still have the shirt on your back."
						(return 1)
					)
					((== local13 86)
						(gMessager say: 4 1 21 0 0 804) ; "Buddha-free bodhi tree."
						(return 1)
					)
					((== local13 87)
						(gMessager say: 4 1 20 0 0 804) ; "Refugees from Beirut (Cedars of Lebanon)."
						(return 1)
					)
					((== local13 88)
						(gMessager say: 4 1 24 0 0 804) ; "Family tree."
						(return 1)
					)
					((== local13 89)
						(gMessager say: 4 1 23 0 0 804) ; "Shoe tree."
						(return 1)
					)
					((== local13 90)
						(gMessager say: 4 1 19 0 0 804) ; "It's a logic tree."
						(return 1)
					)
					((== local13 91)
						(gMessager say: 4 1 22 0 0 804) ; "Tree House."
						(return 1)
					)
					((== local13 92)
						(gMessager say: 4 1 33 0 0 804) ; "Not a mallorn."
						(return 1)
					)
					((== local13 93)
						(gMessager say: 4 1 28 0 0 804) ; "The undiscovered countree."
						(return 1)
					)
					((== local13 94)
						(gMessager say: 4 1 32 0 0 804) ; "Daventree."
						(return 1)
					)
					((== local13 95)
						(gMessager say: 4 1 31 0 0 804) ; "The Treety of Versailles."
						(return 1)
					)
					((== local13 96)
						(gMessager say: 4 1 27 0 0 804) ; "Norwegian wood."
						(return 1)
					)
					((== local13 97)
						(gMessager say: 4 1 26 0 0 804) ; "Birnam Wood (not yet marching)."
						(return 1)
					)
					((== local13 99)
						(gMessager say: 4 1 30 0 0 804) ; "Are those a lumberjack's discarded unmentionables in that tree?"
						(return 1)
					)
				)
			)
			(4 ; Do
				(gMessager say: 4 4 0 1 0 804) ; "No, that's not a palm tree."
				(return 1)
			)
			(32 ; fruit
				(gMessager say: 4 32 0 1 0 804) ; "No, that's not a fruit tree."
				(return 1)
			)
			(2 ; Talk
				(gMessager say: 4 2 0 1 0 804) ; "I talk to the trees, but they don't listen to me."
				(return 1)
			)
			(57 ; Talk [ REMOVED ]
				(gMessager say: 4 2 0 1 0 804) ; "I talk to the trees, but they don't listen to me."
				(return 1)
			)
			(12 ; sword
				(gMessager say: 4 12 0 1 0 804) ; "That's a sword, not an axe, fellow."
				(return 1)
			)
			(16 ; dagger
				(gMessager say: 4 16 0 1 0 804) ; "The trees don't appreciate being used for target practice."
				(return 1)
			)
			(3 ; Walk
				(super doVerb: theVerb &rest)
			)
			(71 ; ???
				(super doVerb: theVerb &rest)
			)
			(else
				(forestRegion doVerb: theVerb &rest)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (dispose)
		(= local12 1)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						local1
						local2
						(not
							(OneOf
								gPrevRoomNum
								420 ; bearArena
								425 ; minotaurArena
								430 ; saurusArena
								435 ; mantrayArena
								440 ; cheetaurArena
								445 ; goblinArena
								455 ; ogreArena
								450 ; trollArena
								460 ; dragonArena
								465 ; brigandArena
								470
							)
						)
					)
					(gEgo posn: local1 local2)
					(cond
						((IsFlag 188)
							(= local3 160)
							(= local4 140)
						)
						((>= local2 170)
							(= local3 160)
							(= local4 10)
						)
						((<= local2 90)
							(= local3 160)
							(= local4 181)
							(gEgo loop: 2)
						)
						((<= local1 30)
							(= local3 310)
							(= local4 110)
						)
						((>= local1 300)
							(= local3 10)
							(= local4 110)
						)
						(else
							(= local3 160)
							(= local4 150)
						)
					)
				else
					(gEgo posn: 160 140)
				)
				(if
					(or
						(not global279)
						(and (== gCurRoomNum 80) (> global281 260))
					)
					(gEgo init:)
					(self cue:)
				)
				(= ticks 30)
			)
			(1
				(= ticks 1)
			)
			(2
				(if
					(or
						(IsFlag 188)
						(and
							(== gCurRoomNum 77)
							(not gNight)
							(!= gPrevRoomNum 76)
							(not (IsFlag 197))
						)
						(and
							(== gCurRoomNum 78)
							(not gNight)
							(not (IsFlag 197))
							(!= gPrevRoomNum 77)
							(not (IsFlag 204))
						)
						(and
							(== gCurRoomNum 67)
							(or
								(== global287 2)
								(== global287 6)
								(== global287 9)
							)
						)
					)
					(HandsOff)
				else
					(NormalEgo)
				)
				(if (and local3 local4)
					(gEgo setMotion: PolyPath local3 local4 self)
				else
					(gEgo setMotion: PolyPath 160 150 self)
				)
			)
			(3
				(self changeState: 5)
			)
			(4
				(gEgo setMotion: PolyPath 160 150 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sExitAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local11 0)
				(gEgo setMotion: PolyPath local1 local2 self)
			)
			(1
				(= local1 0)
				(= local2 0)
				(= local3 0)
				(= local4 0)
				(if (and gNight (== local10 70))
					(= local10 170)
				)
				(gCurRoom newRoom: local10)
				(self dispose:)
			)
		)
	)
)

