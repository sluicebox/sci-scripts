;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40700)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use SoTwinkle)
(use foEExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	roLavaMountain 0
)

(local
	curRegion
	egosLastCel
	egoInTunnel
	IndyOverride
)

(procedure (PrepSection argv &tmp i)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) release:)
	else
		(gCurRoom obstacles: (List new:))
	)
	(gCurRoom addObstacle: oRoomPolygon)
	(gFeatures dispose: init:)
	(for ((= i 0)) (< i argc) ((++ i))
		([argv i] init:)
	)
)

(procedure (ActivateA)
	(oRoomPolygon
		type: PContainedAccess
		init: 1889 267 1840 267 1786 260 1606 175 1607 159 1629 153 1688 137 1806 128 1893 132 1893 129 1800 125 1760 115 1708 107 1664 101 1611 95 1583 94 1586 90 1656 86 1748 85 1764 85 1696 83 1590 87 1523 98 1573 95 1630 100 1728 113 1792 127 1725 128 1637 137 1582 155 1564 157 1473 136 1416 131 1417 123 1493 111 1499 107 1499 100 1491 94 1493 104 1491 107 1451 115 1406 123 1404 131 1451 137 1489 142 1537 155 1633 200 1753 295 1890 284
	)
	(PrepSection foA2 foA3 foA4 foA5)
	(gEgo setScaler: Scaler 72 10 251 81)
)

(procedure (ActivateB)
	(oRoomPolygon
		type: PContainedAccess
		init: 1460 36 1428 34 1374 31 1321 33 1300 34 1299 36 1389 33 1460 38
	)
	(PrepSection foB1 foB2)
	(gEgo setScalePercent: 15)
)

(procedure (ActivateC)
	(oRoomPolygon
		type: PContainedAccess
		init: 1166 127 1149 126 1143 125 1122 125 1109 125 1101 120 1094 121 1066 122 1062 116 1064 107 1066 100 1064 100 1059 121 1068 124 1101 122 1109 128 1145 127 1159 130 1184 128
	)
	(PrepSection foC1 foC2)
	(gEgo setScalePercent: 15)
)

(procedure (ActivateD)
	(oRoomPolygon
		type: PContainedAccess
		init: 1375 293 1332 278 1315 266 1289 254 1257 249 1252 204 1259 191 1294 181 1304 176 1338 170 1337 163 1271 158 1238 155 1237 150 1244 145 1316 130 1315 122 1281 112 1262 98 1257 89 1226 74 1201 43 1198 29 1195 25 1187 27 1190 53 1228 80 1256 93 1263 102 1283 116 1312 125 1310 128 1237 145 1224 151 1107 164 1068 172 1065 165 1080 151 1061 145 1027 138 1021 133 1027 127 1017 129 1017 139 1044 144 1072 151 1055 164 1057 171 1071 173 1123 165 1230 153 1310 162 1316 169 1254 187 1229 240 1240 255 1288 259 1339 286 1308 307 1308 311 1423 311 1408 287
	)
	(PrepSection foD1 foD2)
	(gEgo setScaler: Scaler 70 15 283 123)
)

(procedure (ActivateE)
	(oRoomPolygon type: PContainedAccess init: 1038 23 960 25 952 27 1039 25)
	(PrepSection foE1 foE2)
	(gEgo setScalePercent: 10)
)

(procedure (ActivateF)
	(oRoomPolygon type: PContainedAccess init: 681 42 661 21 653 15 663 19 681 40)
	(PrepSection foF1 foF2)
	(gEgo setScalePercent: 15)
)

(procedure (ActivateG)
	(oRoomPolygon type: PContainedAccess init: 93 47 83 47 84 49 93 49)
	(PrepSection foG1 foG2)
	(gEgo setScalePercent: 25)
)

(procedure (ActivateH)
	(oRoomPolygon type: PContainedAccess init: 223 119 194 119 194 121 223 121)
	(PrepSection foH1 foH2)
	(gEgo setScalePercent: 25)
)

(procedure (ActivateI)
	(oRoomPolygon
		type: PContainedAccess
		init: 100 245 82 237 74 229 65 236 69 246 389 332 566 240 602 219 625 215 653 215 701 246 727 256 774 257 789 242 876 211 905 215 927 227 942 233 978 224 990 217 976 219 944 228 899 211 876 208 824 222 783 237 771 251 730 254 704 245 679 229 651 213 621 209 597 211 529 241 400 297 357 302 284 295 190 272 192 262 207 253 292 239 294 234 277 228 287 235 208 248 173 267 131 256 121 242
	)
	(PrepSection foI1 foI2 foI3 foI4)
	(gEgo setScalePercent: 40)
)

(procedure (ActivateJ)
	(oRoomPolygon
		type: PContainedAccess
		init: 810 172 854 166 911 164 959 170 970 165 959 164 909 160 814 164 784 143 784 131 790 120 796 115 877 81 880 75 874 80 796 111 786 121 781 132 782 144 786 150 809 164 789 167 728 157 749 165
	)
	(PrepSection foJ1 foJ2 foJ3)
	(gEgo setScaler: Scaler 17 10 156 69)
)

(procedure (ActivateK)
	(oRoomPolygon type: PContainedAccess init: 741 100 689 101 689 103 743 102)
	(PrepSection foK1)
	(gEgo setScalePercent: 15)
)

(procedure (ActivateL)
	(oRoomPolygon type: PContainedAccess init: 603 100 574 100 574 102 603 102)
	(PrepSection foL1 foL2)
	(gEgo setScalePercent: 15)
)

(procedure (ActivateM)
	(oRoomPolygon
		type: PContainedAccess
		init: 246 177 268 161 327 137 385 132 418 134 461 138 517 149 524 150 523 145 514 139 468 121 448 111 420 103 379 89 368 85 363 78 365 69 381 64 417 59 588 58 587 56 411 57 364 67 360 78 367 87 448 114 521 145 521 147 513 147 464 137 400 129 355 130 328 132 262 156
	)
	(PrepSection foM1 foM2)
	(gEgo setScaler: Scaler 27 11 154 66)
)

(procedure (ActivateN)
	(oRoomPolygon type: PContainedAccess init: 828 15 862 26 894 42 894 40 861 24 827 13)
	(PrepSection foN1 foN2)
	(gEgo setScalePercent: 10)
)

(procedure (ActivateO)
	(oRoomPolygon type: PContainedAccess init: 384 55 276 56 277 58 385 57)
	(PrepSection foO1 foO2)
	(gEgo setScalePercent: 10)
)

(procedure (ActivateP)
	(oRoomPolygon
		type: PContainedAccess
		init: 297 84 278 84 261 83 227 83 226 81 261 81 297 82
	)
	(PrepSection foP1 foP2)
	(gEgo setScalePercent: 10)
)

(procedure (ActivateQ)
	(oRoomPolygon
		type: PContainedAccess
		init: 60 124 27 119 23 116 25 113 32 108 23 112 21 117 25 120 38 124 56 127 9 162 5 170 59 129 70 124
	)
	(PrepSection foQ1 foQ2 foWinner)
	(gEgo setScalePercent: 10)
)

(instance soExitSection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(gGame handsOff:)
				(gEgo
					setPri: (register exitPriority:)
					setMotion: MoveTo (register x:) (register y:) self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEnterSection of TPScript
	(properties)

	(method (init)
		(= bHasFF 1)
		(super init: &rest)
	)

	(method (ff)
		(= bHasFF 0)
		(self setButtons:)
		(gEgo
			setMotion: 0
			setPri: (register enterPriority:)
			posn: (register approachX:) (register approachY:)
			show:
		)
		(if (!= -1 (register panTo:))
			(oLavaScrollPlane scrollTo: (register panTo:) 0)
		)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= egoInTunnel 1)
				(gEgo
					hide:
					setMotion: MoveTo (register x:) (register y:) self
				)
			)
			(1
				(= egoInTunnel 0)
				(gEgo
					show:
					setPri: (register exitPriority:)
					setMotion:
						MoveTo
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(2
				(self ff:)
			)
		)
	)
)

(class MountainPath of ExitFeature
	(properties
		arrowDir -1
		panTo -1
		exitPriority 5
		enterPriority 100
	)

	(method (init)
		(super init: &rest)
		(switch arrowDir
			(0
				(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
			)
			(1
				(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
			)
			(2
				(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
			)
			(3
				(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
			)
			(4
				(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
			)
			(5
				(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
			)
			(6
				(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
			)
			(7
				(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
			)
		)
		(gFeatures add: self)
	)

	(method (cue))

	(method (doVerb)
		(gEgo setScript: soExitSection self self)
	)
)

(instance oRoomPolygon of Polygon
	(properties)
)

(instance foA2 of MountainPath
	(properties
		approachX 1883
		approachY 132
		x 1910
		y 130
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1872 101 1870 162 1898 168 1897 89)
	)

	(method (cue)
		(gCurRoom setScript: soEnterSection 0 foA3)
	)
)

(instance foA3 of MountainPath
	(properties
		approachX 1764
		approachY 85
		x 1781
		y 84
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1793 49 1799 116 1760 120 1757 45)
	)

	(method (cue)
		(gCurRoom setScript: soEnterSection 0 foA2)
	)
)

(instance foA4 of MountainPath
	(properties
		approachX 1523
		approachY 98
		x 1471
		y 97
		arrowDir 1
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1537 69 1550 116 1509 128 1501 69)
	)

	(method (cue)
		(ActivateC)
		(gCurRoom setScript: soEnterSection 0 foC1)
	)
)

(instance foA5 of MountainPath
	(properties
		approachX 1491
		approachY 94
		x 1464
		y 89
		arrowDir 7
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1487 64 1498 110 1460 115 1447 54)
	)

	(method (cue)
		(ActivateD)
		(gCurRoom setScript: soEnterSection 0 foD1)
	)
)

(instance foB1 of MountainPath
	(properties
		approachX 1460
		approachY 37
		x 1431
		y 29
		arrowDir 7
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1474 -3 1490 48 1428 45 1428 -1)
	)

	(method (cue)
		(ActivateC)
		(gCurRoom setScript: soEnterSection 0 foC2)
	)
)

(instance foB2 of MountainPath
	(properties
		approachX 1300
		approachY 36
		x 1290
		y 38
		arrowDir 1
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1324 -1 1328 51 1270 50 1269 -1)
	)

	(method (cue)
		(ActivateD)
		(gCurRoom setScript: soEnterSection 0 foD1)
	)
)

(instance foC1 of MountainPath
	(properties
		approachX 1179
		approachY 130
		x 1201
		y 128
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init:)
		(self createPoly: 1207 92 1211 136 1155 139 1159 88)
	)

	(method (cue)
		(ActivateA)
		(gCurRoom setScript: soEnterSection 0 foA4)
	)
)

(instance foC2 of MountainPath
	(properties
		approachX 1063
		approachY 101
		x 1086
		y 101
		arrowDir 6
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1100 65 1088 136 1038 121 1050 75)
	)

	(method (cue)
		(ActivateB)
		(gCurRoom setScript: soEnterSection 0 foB1)
	)
)

(instance foD1 of MountainPath
	(properties
		approachX 1195
		approachY 25
		x 1212
		y 24
		arrowDir 6
		exitPriority 45
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1229 -2 1222 43 1168 46 1164 -3)
	)

	(method (cue)
		(ActivateB)
		(gCurRoom setScript: soEnterSection 0 foB2)
	)
)

(instance poIndy of Prop
	(properties
		x 749
		y 36
		priority 500
		fixPriority 1
		view 40700
		cycleSpeed 9
	)
)

(instance soExitE1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soEnterSection self foE1)
			)
			(1
				(if (and (not IndyOverride) (!= 1 (Random 1 4)))
					(self dispose:)
					(return)
				)
				(gGame handsOff:)
				(gEgo bAutoScroll: 0)
				((gCurRoom plane:) panTo: 582 0 self 1 10 10)
			)
			(2
				(= ticks 30)
				(goSound1 playSound: 40799)
			)
			(3
				(poIndy cel: 0 init: setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(goSound1 stop:)
				(poIndy dispose:)
				((ScriptID 64017 0) set: 145) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance foD2 of MountainPath
	(properties
		approachX 1027
		approachY 127
		x 1056
		y 130
		arrowDir 0
		exitPriority 15
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1006 88 984 144 1056 145 1059 85)
	)

	(method (cue)
		(ActivateE)
		(gCurRoom setScript: soExitE1)
	)
)

(instance foE1 of MountainPath
	(properties
		approachX 1039
		approachY 26
		x 1085
		y 25
		arrowDir 0
		panTo 582
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1038 -3 1048 48 1089 39 1093 -1)
	)

	(method (cue)
		(ActivateD)
		(gCurRoom setScript: soEnterSection 0 foD2)
	)
)

(instance foE2 of MountainPath
	(properties
		approachX 952
		approachY 27
		x 940
		y 27
		arrowDir 1
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 977 -1 969 55 925 49 930 -2)
	)

	(method (cue)
		(ActivateF)
		(gCurRoom setScript: soEnterSection 0 foF1)
	)
)

(instance foF1 of MountainPath
	(properties
		approachX 681
		approachY 42
		x 701
		y 45
		arrowDir 0
		panTo 265
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 671 46 701 63 710 4 680 4)
	)

	(method (cue)
		(ActivateE)
		(gCurRoom setScript: soEnterSection 0 foE2)
	)
)

(instance foF2 of MountainPath
	(properties
		approachX 654
		approachY 15
		x 625
		arrowDir 7
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 660 50 674 -1 611 -1)
	)

	(method (cue)
		(ActivateG)
		(gCurRoom setScript: soEnterSection 0 foG1)
	)
)

(instance foG1 of MountainPath
	(properties
		approachX 88
		approachY 49
		x 120
		y 33
		arrowDir 6
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 83 58 122 9 92 4 67 9 72 52)
	)

	(method (cue)
		(ActivateF)
		(gCurRoom setScript: soEnterSection 0 foF2)
	)
)

(instance foG2 of MountainPath
	(properties
		approachX 97
		approachY 49
		x 115
		y 48
		arrowDir 4
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 125 14 79 67 104 84 145 32)
	)

	(method (cue)
		(ActivateH)
		(gCurRoom setScript: soEnterSection 0 foH1)
	)
)

(instance foH1 of MountainPath
	(properties
		approachX 194
		approachY 121
		x 172
		y 119
		arrowDir 7
		exitPriority 45
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 150 96 206 120 199 79 175 57)
	)

	(method (cue)
		(ActivateG)
		(gCurRoom setScript: soEnterSection 0 foG2)
	)
)

(instance foH2 of MountainPath
	(properties
		approachX 196
		approachY 121
		x 183
		y 122
		arrowDir 5
		exitPriority 45
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 221 129 192 152 160 133 158 104)
	)

	(method (cue)
		(ActivateI)
		(gCurRoom setScript: soEnterSection 0 foI1)
	)
)

(instance foI1 of MountainPath
	(properties
		approachX 119
		approachY 249
		x 140
		y 231
		arrowDir 6
		exitPriority 45
		enterPriority 300
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 107 239 132 161 157 201 158 242)
	)

	(method (cue)
		(ActivateH)
		(gCurRoom setScript: soEnterSection 0 foH2)
	)
)

(instance soExitI2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(goSound1 playSound: 40709 self)
			)
			(1
				(gEgo posn: (foK1 x:) (foK1 y:) show:)
				(ActivateK)
				(self setScript: soEnterSection 0 foK1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance foI2 of MountainPath
	(properties
		approachX 74
		approachY 229
		x 97
		y 224
		arrowDir 6
		exitPriority 35
		enterPriority 300
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 40 235 89 236 108 176 78 147)
	)

	(method (cue)
		(gCurRoom setScript: soExitI2)
	)
)

(instance foI3 of MountainPath
	(properties
		approachX 277
		approachY 228
		x 203
		y 202
		arrowDir 7
		exitPriority 45
		enterPriority 300
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 205 173 240 234 293 234 243 170)
	)

	(method (cue)
		(ActivateM)
		(gCurRoom setScript: soEnterSection 0 foM1)
	)
)

(instance foI4 of MountainPath
	(properties
		approachX 990
		approachY 217
		x 1036
		y 194
		arrowDir 6
		enterPriority 300
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 995 146 997 221 1045 213 1027 179 1030 149)
	)

	(method (cue)
		(ActivateJ)
		(gCurRoom setScript: soEnterSection 0 foJ1)
	)
)

(instance foJ1 of MountainPath
	(properties
		approachX 970
		approachY 165
		x 1016
		y 163
		arrowDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 961 96 980 206 1033 173 984 138 1013 115)
	)

	(method (cue)
		(ActivateI)
		(gCurRoom setScript: soEnterSection 0 foI4)
	)
)

(instance foJ2 of MountainPath
	(properties
		approachX 728
		approachY 157
		x 715
		y 155
		arrowDir 1
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 701 108 695 179 747 182 754 104)
	)

	(method (cue)
		(ActivateL)
		(gCurRoom setScript: soEnterSection 0 foL2)
	)
)

(instance foJ3 of MountainPath
	(properties
		approachX 880
		approachY 75
		x 876
		y 71
		arrowDir 7
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 853 34 842 108 903 100 898 46)
	)

	(method (cue)
		(ActivateP)
		(gCurRoom setScript: soEnterSection 0 foP1)
	)
)

(instance foK1 of MountainPath
	(properties
		approachX 689
		approachY 101
		x 679
		y 102
		arrowDir 1
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 692 58 691 123 662 131 662 55)
	)

	(method (cue)
		(ActivateL)
		(gCurRoom setScript: soEnterSection 0 foL1)
	)
)

(instance foL1 of MountainPath
	(properties
		approachX 603
		approachY 100
		x 617
		y 100
		arrowDir 4
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 622 105 586 110 637 157 664 94 627 87)
	)

	(method (cue)
		(ActivateJ)
		(gCurRoom setScript: soEnterSection 0 foJ2)
	)
)

(instance foL2 of MountainPath
	(properties
		approachX 602
		approachY 101
		x 602
		y 101
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 636 50 651 86 625 79 619 102 597 104 594 45)
	)

	(method (cue)
		(ActivateK)
		(gCurRoom setScript: soEnterSection 0 foK1)
	)
)

(instance foM1 of MountainPath
	(properties
		approachX 246
		approachY 177
		x 204
		y 213
		arrowDir 5
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 222 131 292 200 248 225 189 160)
	)

	(method (cue)
		(ActivateI)
		(gCurRoom setScript: soEnterSection 0 foI3)
	)
)

(instance foM2 of MountainPath
	(properties
		approachX 588
		approachY 58
		x 611
		y 58
		arrowDir 0
		panTo 345
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 566 18 564 75 626 77 626 18)
	)

	(method (cue)
		(ActivateN)
		(gCurRoom setScript: soEnterSection 0 foN2)
	)
)

(instance foN1 of MountainPath
	(properties
		approachX 894
		approachY 42
		x 886
		y 29
		arrowDir 6
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 884 5 848 42 907 68 922 9)
	)

	(method (cue)
		(ActivateP)
		(gCurRoom setScript: soEnterSection 0 foP1)
	)
)

(instance foN2 of MountainPath
	(properties
		approachX 827
		approachY 13
		x 753
		y 1
		arrowDir 1
		panTo 465
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 828 50 864 -4 741 -1 749 33)
	)

	(method (cue)
		(ActivateO)
		(gCurRoom setScript: soEnterSection 0 foO1)
	)
)

(instance foO1 of MountainPath
	(properties
		approachX 385
		approachY 57
		x 394
		y 56
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 379 42 379 69 404 69 404 41)
	)

	(method (cue)
		(ActivateN)
		(gCurRoom setScript: soEnterSection 0 foN2)
	)
)

(instance foO2 of MountainPath
	(properties
		approachX 276
		approachY 57
		x 261
		y 59
		arrowDir 1
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 283 41 283 70 265 70 265 40)
	)

	(method (cue)
		(ActivateQ)
		(gCurRoom setScript: soEnterSection 0 foQ2)
	)
)

(instance foP1 of MountainPath
	(properties
		approachX 297
		approachY 84
		x 310
		y 85
		arrowDir 0
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 276 60 279 101 331 99 321 58)
	)

	(method (cue)
		(ActivateJ)
		(gCurRoom setScript: soEnterSection 0 foJ3)
	)
)

(instance foP2 of MountainPath
	(properties
		approachX 227
		approachY 83
		x 205
		y 84
		arrowDir 1
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 241 43 243 106 204 108 189 45)
	)

	(method (cue)
		(ActivateQ)
		(gCurRoom setScript: soEnterSection 0 foQ1)
	)
)

(instance foQ1 of MountainPath
	(properties
		approachX 70
		approachY 124
		x 80
		y 120
		arrowDir 6
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 59 78 62 162 105 154 97 83)
	)

	(method (cue)
		(ActivateP)
		(gCurRoom setScript: soEnterSection 0 foP2)
	)
)

(instance foQ2 of MountainPath
	(properties
		approachX 32
		approachY 108
		x 32
		y 109
		arrowDir 6
		exitPriority 25
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 9 64 9 116 52 116 52 64)
	)

	(method (cue)
		(ActivateO)
		(gCurRoom setScript: soEnterSection 0 foO2)
	)
)

(instance foWinner of MountainPath
	(properties
		approachX 5
		approachY 170
		x -3
		y 170
		arrowDir 5
		exitPriority 35
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 62 201 -4 205 -3 124 47 137)
	)

	(method (cue)
		((ScriptID 64017 0) set: 146) ; oFlags
		(gGame handsOff:)
		(gCurRoom newRoom: 40800) ; roSteppingStones
	)
)

(instance oLavaScrollPlane of TorScrollPlane
	(properties
		priority 20
		oNScrollExit 0
		oSScrollExit 0
		oEScrollExit 0
		oWScrollExit 0
	)

	(method (addPics)
		(AddPicAt self 40700 0 0)
		(AddPicAt self 40701 632 0)
		(AddPicAt self 40702 1264 0)
	)
)

(instance soLava1 of SoSuperTwinkle
	(properties
		minX 1750
		maxX 1895
		minY 190
		maxY 230
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava1 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava1)
	)
)

(instance soLava2 of SoSuperTwinkle
	(properties
		minX 1514
		maxX 1514
		minY 247
		maxY 247
		minLoop 2
		maxLoop 4
		minCycle 8
		maxCycle 15
	)
)

(instance poLava2 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava2)
	)
)

(instance soLava3 of SoSuperTwinkle
	(properties
		minX 1395
		maxX 1405
		minY 247
		maxY 257
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava3 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava3)
	)
)

(instance soLava4 of SoSuperTwinkle
	(properties
		minX 1029
		maxX 1029
		minY 276
		maxY 276
		minLoop 7
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava4 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava4)
	)
)

(instance soLava5 of SoSuperTwinkle
	(properties
		minX 730
		maxX 740
		minY 216
		maxY 226
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava5 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava5)
	)
)

(instance soLava6 of SoSuperTwinkle
	(properties
		minX 432
		maxX 463
		minY 208
		maxY 249
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava6 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava6)
	)
)

(instance soLava7 of SoSuperTwinkle
	(properties
		maxX 77
		minY 199
		maxY 312
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava7 of Prop
	(properties
		priority 10
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava7)
	)
)

(instance roLavaMountain of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(= plane (oLavaScrollPlane init: 1896 (gThePlane getHeight:) yourself:))
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		(poLava5 init:)
		(poLava6 init:)
		(poLava7 init:)
		(goMusic1 setMusic: 40300)
		(= curRegion 0)
		(gGame handsOff:)
		(gEgo
			normalize:
			posn: 1900 272
			code: oFootsteps
			init:
			setPri: 100
			setMotion: MoveTo 1726 272 (ScriptID 64020 0) ; oHandsOnWhenCued
		)
		(= egosLastCel (gEgo cel:))
		(gOEventHandler registerGlobalHandler: self)
		(foWinner init:)
		(ActivateA)
	)

	(method (dispose)
		(gOEventHandler unregisterGlobalHandler: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== (event modifiers:) emCTRL) (== (event message:) KEY_TAB))
			(= IndyOverride (not IndyOverride))
			(event claimed: 1)
		)
	)
)

(instance leftFoot of TPSound
	(properties)
)

(instance rightFoot of TPSound
	(properties)
)

(instance oFootsteps of Code
	(properties)

	(method (doit &tmp leftCel rightCel footSound)
		(cond
			((or (== 0 (gEgo loop:)) (== 1 (gEgo loop:)))
				(= rightCel 3)
				(= leftCel 10)
			)
			((or (== 2 (gEgo loop:)) (== 3 (gEgo loop:)))
				(= rightCel 2)
				(= leftCel 7)
			)
			(else
				(= rightCel 4)
				(= leftCel 11)
			)
		)
		(= footSound (+ 40703 (Random 0 2)))
		(if egoInTunnel
			(+= footSound 3)
		)
		(if (!= egosLastCel (gEgo cel:))
			(cond
				((== leftCel (gEgo cel:))
					(leftFoot playSound: footSound)
				)
				((== rightCel (gEgo cel:))
					(rightFoot playSound: footSound)
				)
			)
		)
		(= egosLastCel (gEgo cel:))
	)
)

