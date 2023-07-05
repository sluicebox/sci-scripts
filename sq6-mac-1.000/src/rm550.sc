;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use n666)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	[local0 14]
	[local14 14]
	[local28 14]
	local42
	[local43 2]
	local45
	local46 = 1
	local47
	local48
)

(procedure (localproc_0)
	(= [local0 0]
		((Polygon new:)
			type: PContainedAccess
			init: 389 50 376 55 369 61 385 73 358 72 344 74 418 83 614 104 606 97 405 76 395 70 392 65 393 59 397 51
			yourself:
		)
	)
	(= [local0 1]
		((Polygon new:)
			type: PContainedAccess
			init: 412 0 422 16 441 29 474 46 503 55 511 41 485 30 469 20 457 0
			yourself:
		)
	)
	(= [local0 2]
		((Polygon new:)
			type: PContainedAccess
			init: 452 209 434 213 411 220 395 229 391 235 399 242 422 256 448 268 475 276 563 276 511 269 480 259 443 245 436 239 428 231 430 223 439 217 462 212
			yourself:
		)
	)
	(= [local0 3]
		((Polygon new:)
			type: PContainedAccess
			init: 598 74 597 117 609 112 637 110 636 60 619 63 606 68
			yourself:
		)
	)
	(= [local0 4]
		((Polygon new:)
			type: PContainedAccess
			init: 301 238 304 247 345 235 384 228 391 217
			yourself:
		)
	)
	(= [local0 5]
		((Polygon new:)
			type: PContainedAccess
			init: 34 160 12 174 54 186 268 276 332 281
			yourself:
		)
	)
	(= [local0 6]
		((Polygon new:) type: PContainedAccess init: 540 133 545 138 545 77 540 80 yourself:)
	)
	(= [local0 7]
		((Polygon new:)
			type: PContainedAccess
			init: 231 222 265 222 274 224 278 229 277 241 274 254 299 265 295 227 291 221 282 217 276 217 232 217
			yourself:
		)
	)
	(= [local0 8]
		((Polygon new:)
			type: PContainedAccess
			init: 123 229 81 259 55 276 88 277 141 236
			yourself:
		)
	)
	(= [local0 9]
		((Polygon new:)
			type: PContainedAccess
			init: 194 147 184 151 205 159 207 165 203 170 151 203 171 210 217 177 224 171 227 165 226 161 223 158 214 154
			yourself:
		)
	)
	(= [local0 10]
		((Polygon new:)
			type: PContainedAccess
			init: 234 187 221 201 215 214 211 231 224 236 227 220 234 207
			yourself:
		)
	)
	(= [local0 11]
		((Polygon new:) type: PContainedAccess init: 227 157 232 164 416 163 412 158 yourself:)
	)
	(= [local0 12]
		((Polygon new:)
			type: PContainedAccess
			init: 134 46 119 51 148 54 152 55 151 57 119 70 74 94 0 152 0 171 86 99 125 75 170 55 259 63 270 68 280 69 298 64
			yourself:
		)
	)
	(= [local0 13]
		((Polygon new:) type: PContainedAccess init: 37 0 49 0 49 98 36 101 yourself:)
	)
	(transFwd1 setData: teleportFwdData1)
	(transFwd2 setData: teleportFwdData2)
	(transFwd3 setData: teleportFwdData3)
	(transFwd4 setData: teleportFwdData4)
	(transFwd5 setData: teleportFwdData5)
	(transFwd6 setData: teleportFwdData6)
	(transFwd7 setData: teleportFwdData7)
	(transFwd8 setData: teleportFwdData8)
	(transFwd9A setData: teleportFwdData9A)
	(transFwd9B setData: teleportFwdData9B)
	(transFwd10 setData: teleportFwdData10)
	(transFwd11 setData: teleportFwdData11)
	(transFwd12 setData: teleportFwdData12)
	(= [local14 0] transFwd1)
	(= [local14 1] transFwd2)
	(= [local14 2] transFwd3)
	(= [local14 3] transFwd4)
	(= [local14 4] transFwd5)
	(= [local14 5] transFwd6)
	(= [local14 6] transFwd7)
	(= [local14 7] transFwd8)
	(= [local14 8] transFwd9A)
	(= [local14 9] transFwd9B)
	(= [local14 10] transFwd10)
	(= [local14 11] transFwd11)
	(= [local14 12] transFwd12)
	(= [local14 13] 0)
	(transBwd1 setData: teleportBwdData1)
	(transBwd2 setData: teleportBwdData2)
	(transBwd3 setData: teleportBwdData3)
	(transBwd4 setData: teleportBwdData4)
	(transBwd5 setData: teleportBwdData5)
	(transBwd6 setData: teleportBwdData6)
	(transBwd7 setData: teleportBwdData7)
	(transBwd8 setData: teleportBwdData8)
	(transBwd9A setData: teleportBwdData9A)
	(transBwd9B setData: teleportBwdData9B)
	(transBwd10 setData: teleportBwdData10)
	(transBwd11 setData: teleportBwdData11)
	(transBwd12 setData: teleportBwdData12)
	(= [local28 0] 0)
	(= [local28 1] transBwd1)
	(= [local28 2] transBwd2)
	(= [local28 3] transBwd3)
	(= [local28 4] transBwd4)
	(= [local28 5] transBwd5)
	(= [local28 6] transBwd6)
	(= [local28 7] transBwd7)
	(= [local28 8] transBwd8)
	(= [local28 9] transBwd9A)
	(= [local28 10] transBwd9B)
	(= [local28 11] transBwd10)
	(= [local28 12] transBwd11)
	(= [local28 13] transBwd12)
)

(procedure (localproc_1 param1 param2)
	((gCurRoom obstacles:) delete: [local0 local42])
	(if [local14 local42]
		([local14 local42] dispose:)
	)
	(if [local28 local42]
		([local28 local42] dispose:)
	)
	(cond
		((> argc 1)
			(= local42 param2)
		)
		((== param1 1)
			(++ local42)
		)
		((== param1 0)
			(-- local42)
		)
	)
	(gCurRoom addObstacle: [local0 local42])
	(if [local14 local42]
		([local14 local42] init:)
	)
	(if [local28 local42]
		([local28 local42] init:)
	)
)

(class TeleportData of Obj
	(properties
		egoEnd1X 0
		egoEnd1Y 0
		egoStart2X 0
		egoStart2Y 0
		egoEnd2X 0
		egoEnd2Y 0
		egoView -1
		egoBegPri 0
		egoPri -1
		egoEndPri 0
		egoScale 50
		egoHide 1
	)
)

(instance teleportFwdData1 of TeleportData
	(properties
		egoEnd1X 600
		egoEnd1Y 97
		egoStart2X 435
		egoStart2Y -22
		egoEnd2X 440
		egoEnd2Y 12
		egoView 552
		egoPri 79
	)
)

(instance teleportFwdData2 of TeleportData
	(properties
		egoEnd1X 504
		egoEnd1Y 47
		egoStart2X 460
		egoStart2Y 216
		egoEnd2X 428
		egoEnd2Y 224
		egoView 900
		egoBegPri 143
		egoPri 145
		egoScale 80
	)
)

(instance teleportFwdData3 of TeleportData
	(properties
		egoEnd1X 576
		egoEnd1Y 315
		egoStart2X 637
		egoStart2Y 94
		egoEnd2X 628
		egoEnd2Y 93
		egoView 554
		egoPri 96
		egoScale 80
	)
)

(instance teleportFwdData4 of TeleportData
	(properties
		egoStart2X 432
		egoStart2Y 219
		egoEnd2X 381
		egoEnd2Y 226
		egoView 900
		egoBegPri 77
		egoPri 77
		egoScale 45
		egoHide 0
	)
)

(instance teleportFwdData5 of TeleportData
	(properties
		egoEnd1X 295
		egoEnd1Y 249
		egoStart2X 43
		egoStart2Y 173
		egoEnd2X 66
		egoEnd2Y 184
		egoView 900
		egoPri 96
		egoScale 60
	)
)

(instance teleportFwdData6 of TeleportData
	(properties
		egoEnd1X 307
		egoEnd1Y 301
		egoStart2X 543
		egoStart2Y 135
		egoEnd2X 543
		egoEnd2Y 123
		egoView 554
		egoPri 80
	)
)

(instance teleportFwdData7 of TeleportData
	(properties
		egoEnd1X 541
		egoEnd1Y 74
		egoStart2X 233
		egoStart2Y 222
		egoEnd2X 251
		egoEnd2Y 223
		egoView 900
		egoBegPri 77
		egoPri 79
		egoScale 45
	)
)

(instance teleportFwdData8 of TeleportData
	(properties
		egoEnd1X 286
		egoEnd1Y 286
		egoStart2X 126
		egoStart2Y 239
		egoEnd2X 107
		egoEnd2Y 253
		egoView 900
		egoPri 95
	)
)

(instance teleportFwdData9A of TeleportData
	(properties
		egoEnd1X 49
		egoEnd1Y 301
		egoStart2X 143
		egoStart2Y 229
		egoEnd2X 168
		egoEnd2Y 203
		egoView 900
		egoBegPri 95
		egoPri 96
		egoScale 65
	)
)

(instance teleportFwdData9B of TeleportData
	(properties
		egoEnd1X 193
		egoEnd1Y 154
		egoStart2X 234
		egoStart2Y 201
		egoEnd2X 227
		egoEnd2Y 205
		egoView 550
		egoPri 95
		egoEndPri 95
		egoScale 40
	)
)

(instance teleportFwdData10 of TeleportData
	(properties
		egoEnd1X 215
		egoEnd1Y 247
		egoStart2X 420
		egoStart2Y 161
		egoEnd2X 395
		egoEnd2Y 161
		egoView 900
		egoPri 79
		egoScale 40
	)
)

(instance teleportFwdData11 of TeleportData
	(properties
		egoEnd1X 213
		egoEnd1Y 162
		egoStart2X -5
		egoStart2Y 170
		egoEnd2X 8
		egoEnd2Y 158
		egoView 900
		egoPri 96
	)
)

(instance teleportFwdData12 of TeleportData
	(properties
		egoEnd1X 139
		egoEnd1Y 53
		egoStart2X 43
		egoStart2Y 108
		egoEnd2X 43
		egoEnd2Y 90
		egoView 554
		egoPri 79
		egoEndPri 95
	)
)

(instance teleportBwdData1 of TeleportData
	(properties
		egoEnd1X 433
		egoEnd1Y -22
		egoStart2X 602
		egoStart2Y 99
		egoEnd2X 588
		egoEnd2Y 99
		egoView 900
		egoPri 79
	)
)

(instance teleportBwdData2 of TeleportData
	(properties
		egoEnd1X 455
		egoEnd1Y 217
		egoStart2X 498
		egoStart2Y 47
		egoEnd2X 477
		egoEnd2Y 38
		egoView 552
		egoPri 79
		egoEndPri 143
	)
)

(instance teleportBwdData3 of TeleportData
	(properties
		egoEnd1X 680
		egoEnd1Y 91
		egoStart2X 573
		egoStart2Y 298
		egoEnd2X 499
		egoEnd2Y 271
		egoView 900
		egoPri 145
		egoScale 80
	)
)

(instance teleportBwdData4 of TeleportData
	(properties
		egoEnd1X 411
		egoEnd1Y 223
		egoStart2X 601
		egoStart2Y 93
		egoEnd2X 609
		egoEnd2Y 90
		egoView 554
		egoBegPri 96
		egoPri 96
		egoScale 80
	)
)

(instance teleportBwdData5 of TeleportData
	(properties
		egoEnd1X 42
		egoEnd1Y 171
		egoStart2X 295
		egoStart2Y 249
		egoEnd2X 314
		egoEnd2Y 240
		egoView 900
		egoBegPri 77
		egoPri 77
		egoScale 45
	)
)

(instance teleportBwdData6 of TeleportData
	(properties
		egoEnd1X 542
		egoEnd1Y 135
		egoStart2X 290
		egoStart2Y 275
		egoEnd2X 278
		egoEnd2Y 271
		egoView 900
		egoBegPri 96
		egoPri 96
		egoScale 60
	)
)

(instance teleportBwdData7 of TeleportData
	(properties
		egoEnd1X 234
		egoEnd1Y 222
		egoStart2X 544
		egoStart2Y 80
		egoEnd2X 544
		egoEnd2Y 92
		egoView 554
		egoBegPri 80
		egoPri 80
	)
)

(instance teleportBwdData8 of TeleportData
	(properties
		egoEnd1X 125
		egoEnd1Y 241
		egoStart2X 287
		egoStart2Y 275
		egoEnd2X 286
		egoEnd2Y 247
		egoView 900
		egoPri 79
		egoScale 45
	)
)

(instance teleportBwdData9A of TeleportData
	(properties
		egoEnd1X 141
		egoEnd1Y 230
		egoStart2X 57
		egoStart2Y 301
		egoEnd2X 78
		egoEnd2Y 271
		egoView 900
		egoPri 95
		egoEndPri 95
	)
)

(instance teleportBwdData9B of TeleportData
	(properties
		egoEnd1X 235
		egoEnd1Y 199
		egoStart2X 191
		egoStart2Y 152
		egoEnd2X 214
		egoEnd2Y 168
		egoView 900
		egoBegPri 95
		egoPri 96
		egoScale 65
	)
)

(instance teleportBwdData10 of TeleportData
	(properties
		egoEnd1X 419
		egoEnd1Y 160
		egoStart2X 215
		egoStart2Y 246
		egoEnd2X 219
		egoEnd2Y 224
		egoView 550
		egoBegPri 95
		egoPri 95
		egoScale 40
	)
)

(instance teleportBwdData11 of TeleportData
	(properties
		egoEnd1X -5
		egoEnd1Y 168
		egoStart2X 212
		egoStart2Y 162
		egoEnd2X 247
		egoEnd2Y 162
		egoView 900
		egoBegPri 79
		egoPri 79
		egoScale 40
	)
)

(instance teleportBwdData12 of TeleportData
	(properties
		egoEnd1X 42
		egoEnd1Y 106
		egoStart2X 139
		egoStart2Y 51
		egoEnd2X 167
		egoEnd2Y 55
		egoView 900
		egoBegPri 95
		egoPri 96
	)
)

(instance leftCliffData of TeleportData
	(properties
		egoEnd1X 309
		egoEnd1Y 71
		egoStart2X 309
		egoStart2Y 170
		egoEnd2X 270
		egoEnd2Y 66
	)
)

(instance rightCliffData of TeleportData
	(properties
		egoEnd1X 331
		egoEnd1Y 71
		egoStart2X 331
		egoStart2Y 170
		egoEnd2X 384
		egoEnd2Y 65
	)
)

(instance rm550 of SQRoom
	(properties
		noun 4
		picture 5501
	)

	(method (init)
		(localproc_0)
		(super init: &rest)
		(gEgo init: setScale: scaleX: 50 scaleY: 50)
		(switch gPrevRoomNum
			(560
				(= local42 13)
				(gEgo posn: 45 22 normalize: 4 554 setPri: 79)
				(gGame handsOn:)
				(plane setRect: 0 0 639 276)
			)
			(else
				(= local42 0)
				(gEgo posn: 384 65 normalize: 2 setPri: 79)
				(gGame handsOn:)
				(plane setRect: -176 0 463 276)
			)
		)
		(gCurRoom addObstacle: [local0 local42])
		(UpdatePlane plane)
		(if (IsFlag 150)
			(board init:)
		)
		(turnSign init:)
		(turnSign2 init:)
		(birdSeed init:)
		(brokenBridge init:)
		(stopSign init:)
		(officeSign init:)
		(cliff1 init:)
		(cliff2 init:)
		(cactus1 init:)
		(cactus2 init:)
		(cactus3 init:)
		(cactus4 init:)
		(if [local14 local42]
			([local14 local42] init:)
		)
		(if [local28 local42]
			([local28 local42] init:)
		)
		(exit560 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(exit510 init: (gTheExitNCursor new:) approachVerbs: 9) ; ExitUp
		(gGSound1 number: 550 setLoop: -1 play: setVol: 127)
		(self buildPic:)
		(gWalkHandler addToFront: self)
		(gEgo code: scrollCode)
	)

	(method (buildPic)
		(AddPicAt plane 5502 320 0)
		(AddPicAt plane 5503 0 138)
		(AddPicAt plane 5504 320 138)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(gEgo setScale: 0 normalize:)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evVERB) (& (event type:) evMOVE))
			(= local45 1)
		)
		(super handleEvent: event &rest)
	)

	(method (doit)
		(cond
			(script)
			((not local45))
			((cliff1 onMe: gEgo)
				(cond
					((not local46))
					((IsFlag 150)
						(gEgo setScript: crossBoardToEast)
						(= local45 0)
					)
					(else
						(self setScript: fallOffCliff 0 leftCliffData)
						(= local45 0)
					)
				)
			)
			((cliff2 onMe: gEgo)
				(cond
					((not local46))
					((IsFlag 150)
						(gEgo setScript: crossBoardToWest)
						(= local45 0)
					)
					(else
						(self setScript: fallOffCliff 0 rightCliffData)
						(= local45 0)
					)
				)
			)
			((and [local14 local42] ([local14 local42] onMe: gEgo))
				(gCurRoom
					setScript:
						(sTeleport new:)
						0
						([local14 local42] teleportData:)
				)
				(localproc_1 1)
				(= local45 0)
			)
			((and [local28 local42] ([local28 local42] onMe: gEgo))
				(gCurRoom
					setScript:
						(sTeleport new:)
						0
						([local28 local42] teleportData:)
				)
				(localproc_1 0)
				(= local45 0)
			)
		)
		(super doit: &rest)
	)

	(method (updateRect &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if local48
			(return)
		)
		(= temp1 0)
		(= temp2 0)
		(cond
			(
				(and
					(> (+ (gEgo x:) (gThePlane left:)) 310)
					(> (gThePlane right:) 325)
					(or
						local47
						(and
							(gEgo mover:)
							(> (gEgo x:) ((gEgo mover:) xLast:))
						)
					)
				)
				(= temp1 310)
				(if (< (= temp3 (- (gThePlane right:) 310)) 325)
					(= temp1 (- (gThePlane right:) 325))
				)
				(*= temp1 -1)
			)
			(
				(and
					(< (+ (gEgo x:) (gThePlane left:)) 10)
					(< (gThePlane left:) -5)
					(or
						local47
						(and
							(gEgo mover:)
							(< (gEgo x:) ((gEgo mover:) xLast:))
						)
					)
				)
				(= temp1 310)
				(if (> (= temp0 (+ (gThePlane left:) 310)) 0)
					(= temp1 (- 310 temp0))
				)
			)
		)
		(cond
			(
				(and
					(> (+ (gEgo y:) (gThePlane top:)) 133)
					(> (gThePlane bottom:) 140)
					(or
						local47
						(and
							(gEgo mover:)
							(> (gEgo y:) ((gEgo mover:) yLast:))
						)
					)
				)
				(= temp2 126)
				(if (< (= temp5 (- (gThePlane bottom:) 126)) 140)
					(= temp2 (- (gThePlane bottom:) 140))
				)
				(*= temp2 -1)
			)
			(
				(and
					(< (+ (gEgo y:) (gThePlane top:)) 10)
					(< (gThePlane top:) -3)
					(or
						local47
						(and
							(gEgo mover:)
							(< (gEgo y:) ((gEgo mover:) yLast:))
						)
					)
				)
				(= temp2 126)
				(if (> (= temp4 (+ (gThePlane top:) 126)) 0)
					(= temp2 (- 126 temp4))
				)
			)
		)
		(if (or temp1 temp2)
			(gThePlane
				setRect:
					(+ (gThePlane left:) temp1)
					(+ (gThePlane top:) temp2)
					(+ (gThePlane right:) temp1)
					(+ (gThePlane bottom:) temp2)
			)
			(UpdatePlane gThePlane)
		)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 ((gCurRoom plane:) top:))
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) right:))
		(= temp3 ((gCurRoom plane:) bottom:))
		(= temp4 0)
		(= temp5 0)
		(if (and (> (+ (gEgo x:) temp1) 220) (> temp2 325))
			(= temp4 (* -1 (gEgo xStep:)))
		)
		(if (and (< (+ (gEgo x:) temp1) 100) (< temp1 -5))
			(= temp4 (gEgo xStep:))
		)
		(if (and (> (+ (gEgo y:) temp0) 81) (> temp3 139))
			(= temp5 (* -1 (gEgo yStep:)))
		)
		(if (and (< (+ (gEgo y:) temp0) 79) (< temp0 0))
			(= temp5 (gEgo yStep:))
		)
		(if (not local45)
			(*= temp4 2)
			(*= temp5 2)
		)
		(if (or temp4 temp5)
			((gCurRoom plane:)
				setRect:
					(+ temp1 temp4)
					(+ temp0 temp5)
					(+ temp2 temp4)
					(+ temp0 276 temp5)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sTeleport of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (register egoEnd1X:) (register egoEnd1Y:))
					(if (register egoEndPri:)
						(gEgo setPri: (register egoEndPri:))
					)
					(gEgo
						setMotion:
							MoveTo
							(register egoEnd1X:)
							(register egoEnd1Y:)
							self
					)
				else
					(= cycles 2)
				)
			)
			(1
				(= local47 1)
				(if (register egoHide:)
					(gEgo hide:)
				)
				(= cycles 2)
			)
			(2
				(= temp0 (register egoView:))
				(if (register egoBegPri:)
					(gEgo setPri: (register egoBegPri:))
				)
				(gEgo
					view: (if (!= temp0 -1) temp0 else 900)
					loop: 0
					posn: (register egoStart2X:) (register egoStart2Y:)
					scaleX: (register egoScale:)
					scaleY: (register egoScale:)
				)
				(= cycles 2)
			)
			(3
				(= temp0
					(if (!= (register egoView:) -1)
						(register egoView:)
					else
						900
					)
				)
				(gEgo
					show:
					setCycle: StopWalk (+ temp0 1)
					setMotion:
						MoveTo
						(register egoEnd2X:)
						(register egoEnd2Y:)
						self
				)
				(= local47 0)
			)
			(4
				(gEgo setPri: (register egoPri:))
				(if (== local42 13)
					(gGame points: 5 460)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fallOffCliff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 265) ; WAVE
				(gEgo
					setMotion:
						MoveTo
						(register egoEnd1X:)
						(register egoEnd1Y:)
						self
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gMessager sayRange: 8 0 0 1 2 self) ; "Whoops!"
			)
			(3
				(if (IsFlag 202)
					(gEgo code: 0)
				)
				(= local48 1)
				(gEgo
					setStep: -1 10
					setSpeed: 2
					setMotion:
						MoveTo
						(register egoStart2X:)
						(register egoStart2Y:)
						self
				)
			)
			(4
				(gEgo hide:)
				(= cycles 2)
			)
			(5
				(gMessager say: 8 0 0 3 self) ; "Apparently, it does exist. As you plummet to your cyberdeath, you are confronted by a variant of an age-old question: if you fall and hit the ground within cyberspace and no one is there to hear it, will you make an audible splat?"
			)
			(6
				(gGSound2 number: 265 loop: 0 play: setVol: 127)
				(= ticks 45)
			)
			(7
				(gMessager say: 8 0 0 4 self) ; "Yep."
			)
			(8
				(proc666_0 6 self)
			)
			(9
				(gEgo
					posn: (register egoEnd2X:) (register egoEnd2Y:)
					loop: 5
					setStep: 1 1
					setSpeed: global158
					show:
				)
				(if (IsFlag 202)
					(gEgo code: scrollCode)
				)
				(= local48 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putDownBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 551) ; WAVE
				(client
					view: 556
					loop: 0
					cel: 0
					posn: 281 67
					scaleX: 127
					scaleY: 127
					setSpeed: 6
					setCycle: CT 8 1 self
				)
			)
			(1
				(gGSound2 number: 551 setLoop: 0 play: setVol: 127)
				(client setCycle: End self)
			)
			(2
				(gMessager say: 0 160 0 0 self) ; "You smartly drop the board in place, spanning the gap between the two bridge sections."
			)
			(3
				(board init:)
				(SetFlag 150)
				(gEgo put: 10) ; Board
				(gGame points: 3 459)
				(= next crossBoardToEast)
				(self dispose:)
			)
		)
	)
)

(instance crossBoardToEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 556
					setLoop: 1 1
					cel: 0
					posn: 286 68
					scaleX: 127
					scaleY: 127
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 352 75 self
				)
			)
			(1
				(localproc_1 0 0)
				(client
					posn: 355 76
					scaleX: 50
					scaleY: 50
					normalize: 2
					setPri: 79
				)
				(= local46 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crossBoardToWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 556
					setLoop: 2 1
					cel: 0
					posn: 352 75
					scaleX: 127
					scaleY: 127
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 283 67 self
				)
			)
			(1
				(localproc_1 1 12)
				(client
					posn: 277 67
					scaleX: 50
					scaleY: 50
					normalize: 2
					setPri: 96
				)
				(= local46 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveTo560 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setMotion: MoveTo 43 -5 self)
			)
			(1
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance board of View
	(properties
		noun 10
		sightAngle 40
		x 313
		y 82
		z 10
		view 556
		loop 3
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance turnSign of Feature
	(properties
		noun 5
		sightAngle 40
		x 422
		y 37
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 22 415 47 422 52 429 47
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 0 4 1 0) ; "Hey, leave the signs alone. Were you born in North Fork or what?!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance turnSign2 of Feature
	(properties
		noun 5
		sightAngle 40
		x 247
		y 208
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 207 253 207 256 204 261 208 256 212 253 209 234 209
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 0 4 1 0) ; "Hey, leave the signs alone. Were you born in North Fork or what?!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance birdSeed of Feature
	(properties
		noun 3
		sightAngle 40
		x 440
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 436 213 435 223 437 226 441 225 446 218 445 213
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance brokenBridge of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 280
		approachY 68
		x 311
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 301 53 358 61 363 71 342 81 345 96 267 85 259 67
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 160) (not (IsFlag 150)) (== local42 12)) ; Board
			(gEgo setScript: putDownBoard)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(not (event claimed:))
				(== (event message:) $00a0)
			)
			(if (not (IsFlag 150))
				(= local46 0)
			)
			(cond
				((== local42 12)
					(self approachVerbs: 160) ; Board
				)
				(_approachVerbs
					(self approachVerbs:)
				)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance stopSign of Feature
	(properties
		noun 1
		sightAngle 40
		x 171
		y 49
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 36 176 36 176 43 172 62 167 42
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 0 4 1 0) ; "Hey, leave the signs alone. Were you born in North Fork or what?!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance officeSign of Feature
	(properties
		noun 6
		sightAngle 40
		x 24
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 11 35 26 35 26 38 37 38 37 55 27 55 27 58 11 58
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 0 4 1 0) ; "Hey, leave the signs alone. Were you born in North Fork or what?!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cliff1 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 70 295 62 304 63 279 72
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cliff2 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 363 70 343 78 334 77 356 69
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cactus1 of Feature
	(properties
		noun 9
		sightAngle 40
		x 44
		y 26
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 30 22 44 22 48 25 64 25 64 28 54 28 49 31 37 31 25 28 25 26
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cactus2 of Feature
	(properties
		noun 9
		sightAngle 40
		x 46
		y 232
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 31 231 43 231 47 228 61 228 64 233 53 237 41 237 37 235 29 235
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cactus3 of Feature
	(properties
		noun 9
		sightAngle 40
		x 572
		y 259
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 571 249 568 262 571 269 575 269 576 264
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cactus4 of Feature
	(properties
		noun 9
		sightAngle 40
		x 468
		y 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 0 474 8 474 17 470 27 463 22 463 10 467 6 467 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(class TransferFeature of Feature
	(properties
		teleportData 0
	)

	(method (setData param1)
		(if (and argc (param1 isKindOf: TeleportData))
			(= teleportData param1)
		)
	)
)

(instance transFwd1 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 593
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 592 91 597 91 597 103 590 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd2 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 485
		y 41
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 486 32 497 36 491 51 474 46
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd3 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 526
		y 274
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 456 272 584 272 596 276 465 276
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd4 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 601
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 597 74 597 116 603 114 603 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd5 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 308
		y 242
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 238 310 236 315 245 305 248
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd6 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 290
		y 275
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 272 314 272 324 277 268 278
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd7 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 543
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 540 80 546 76 546 87 540 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd8 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 286
		y 253
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 248 298 248 299 258 274 256
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd9A of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 118
		y 243
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 272 93 272 88 276 54 276
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd9B of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 213
		y 159
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 149 199 169 228 160 215 153
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd10 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 218
		y 228
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 222 225 227 225 235 211 229
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd11 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 236
		y 159
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 155 239 155 243 164 236 164
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transFwd12 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 152
		y 52
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 48 164 50 152 57 140 54
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd1 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 435
		y 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 411 0 457 0 460 8 416 8 yourself:)
		)
		(super init: &rest)
	)
)

(instance transBwd2 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 432
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 207 417 214 443 232 445 228
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd3 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 633
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 630 62 637 60 637 110 630 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd4 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 388
		y 222
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 380 217 396 214 397 223 385 231
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd5 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 45
		y 175
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 47 159 67 168 41 191 23 182
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd6 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 543
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 539 134 548 134 548 140 539 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd7 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 244
		y 221
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 217 250 217 250 226 244 226 238 220
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd8 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 75
		y 272
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 240 115 234 127 247 122 253
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd9A of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 161
		y 205
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 198 177 208 170 213 143 202
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd9B of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 230
		y 199
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 187 233 208 230 212 227 192
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd10 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 411
		y 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 407 155 407 165 416 165 416 155
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transBwd11 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 4
		y 158
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 148 5 144 9 166 0 173 yourself:)
		)
		(super init: &rest)
	)
)

(instance transBwd12 of TransferFeature
	(properties
		noun 4
		sightAngle 40
		x 42
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 34 91 51 91 51 97 34 97 yourself:)
		)
		(super init: &rest)
	)
)

(instance exit560 of ExitFeature
	(properties
		nsLeft 37
		nsRight 54
		nsBottom 10
		x 45
		y 4
		nextRoom 560
		message 9
	)

	(method (doVerb theVerb)
		(if (== theVerb message)
			(gEgo setScript: leaveTo560)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance exit510 of ExitFeature
	(properties
		nsLeft 382
		nsTop 38
		nsRight 411
		nsBottom 51
		nextRoom 510
		message 9
	)

	(method (doVerb theVerb)
		(if (and (== theVerb message) (gEgo has: 95)) ; Screwdriver
			(gEgo put: 95) ; Screwdriver
		)
		(super doVerb: theVerb &rest)
	)
)

