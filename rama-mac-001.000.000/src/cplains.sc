;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2000)
(include sci.sh)
(use Main)
(use RamaRoom)
(use VidmailChoices)
(use InvInitialize)
(use SaveManager)
(use ZoomCycleTo)
(use n1111)
(use Plane)
(use Array)
(use PolyPath)
(use Polygon)
(use Feature)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	cplains 0
)

(local
	local0 = 7
	[local1 85] = [0 0 0 0 0 0 0 175 196 5 340 157 31 2 261 191 6 380 148 31 16 224 94 1 275 169 31 1 216 132 2 415 140 31 1 95 169 4 290 166 31 16 274 238 7 400 146 31 16 405 195 9 380 148 31 16 506 181 11 320 161 31 16 374 55 16 190 185 31 8 392 157 13 220 173 31 4 360 110 14 230 173 38 4 -1]
	local86
	local87
	local88
	local89
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 0)))))
	(if (and (= temp0 (proc70_6 40)) (temp0 ownedBy: -2))
		0
	else
		(= temp0 0)
	)
	(if (and (= temp1 (proc70_6 47)) (temp1 ownedBy: -2))
		0
	else
		(= temp1 0)
	)
	(if (and (= temp2 (proc70_6 37)) (temp2 ownedBy: -2))
		0
	else
		(= temp2 0)
	)
	(if (and (= temp3 (proc70_6 104)) (temp3 ownedBy: -2))
		0
	else
		(= temp3 0)
	)
	(if (and (= temp4 (proc70_6 1)) (temp4 ownedBy: -2))
		0
	else
		(= temp4 0)
	)
	(if (and temp0 temp1 temp2 temp3 temp4)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(1
			((Polygon new:)
				type: PBarredAccess
				init: 190 97 211 88 245 78 257 95 234 101 218 109
				yourself:
			)
		)
		(2
			((Polygon new:)
				type: PBarredAccess
				init: 198 140 201 130 210 120 233 128 227 134 225 141
				yourself:
			)
		)
		(4
			((Polygon new:)
				type: PBarredAccess
				init: 63 136 107 138 106 155 113 175 127 192 88 202 73 183 65 169 62 149
				yourself:
			)
		)
		(5
			((Polygon new:)
				type: PBarredAccess
				init: 148 187 171 181 183 191 202 202 186 211 166 201
				yourself:
			)
		)
		(6
			((Polygon new:)
				type: PBarredAccess
				init: 236 193 255 180 267 184 286 186 283 202 255 199
				yourself:
			)
		)
		(7
			((Polygon new:)
				type: PBarredAccess
				init: 240 227 277 232 315 232 319 248 276 247 253 246 229 242
				yourself:
			)
		)
		(9
			((Polygon new:)
				type: PBarredAccess
				init: 375 200 397 189 410 178 435 185 421 196 391 212
				yourself:
			)
		)
		(11
			((Polygon new:)
				type: PBarredAccess
				init: 474 200 487 188 496 172 500 164 502 152 540 152 532 176 519 195 504 210
				yourself:
			)
		)
		(13
			((Polygon new:)
				type: PBarredAccess
				init: 376 145 414 145 412 156 404 169 370 161 376 152
				yourself:
			)
		)
		(14
			((Polygon new:)
				type: PBarredAccess
				init: 335 111 351 96 368 103 383 112 358 121
				yourself:
			)
		)
		(16
			((Polygon new:)
				type: PBarredAccess
				init: 345 41 378 47 408 55 394 67 366 60 339 55
				yourself:
			)
		)
	)
)

(class CPlainPolyPath of PolyPath
	(properties)

	(method (motionCue)
		(client mover: 0)
		(if (and completed caller)
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees add: ((Cue new:) cuee: caller yourself:))
			(gGame handsOff:)
		)
		(self dispose:)
	)
)

(class FirstPersonFeature of Feature
	(properties
		nextRoom 0
		displayHighlight 1
		zoomView 2006
		zoomLoop 0
		zoomCel 0
		insetView 2006
		insetLoop 1
		insetCel 0
		insetPri 0
		insetX 0
		insetY 31
		areasAccessible 0
		detailObj 0
		radarObj 0
		encounterLoc 0
	)

	(method (init)
		(super init: &rest)
		(if radarObj
			(radarObj init: global117)
		)
		(self setHotspot: 2)
	)

	(method (setHotspot)
		(if (self isActive:)
			(super setHotspot: &rest)
		)
	)

	(method (onMe param1 &tmp temp0)
		(return (and displayHighlight (super onMe: param1)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(not (navCast contains: zoomHighlightRegion))
						(!= (zoomHighlightRegion x:) x)
						(!= (zoomHighlightRegion y:) y)
					)
					(UpdateScreenItem (self setupHighlight:))
					(FrameOut)
				)
			)
			(2
				(if nextRoom
					(radarProp hide:)
					(gCurRoom newRoom: nextRoom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (isActive)
		(= displayHighlight (& (global122 allowedAreas:) areasAccessible))
	)

	(method (setNextRoom))

	(method (dispose)
		(= radarObj (= detailObj 0))
		(super dispose:)
	)

	(method (setupHighlight)
		(zoomHighlightRegion
			posn: x y
			view: zoomView
			setLoop: zoomLoop 1
			setCel: zoomCel
			setProps: self
			setPri: 498
			init: navCast
			setHotspot: 2
			yourself:
		)
	)
)

(class FirstPersonHighlight of Prop
	(properties
		x -1
		y -1
		priority 500
		fixPriority 1
		view 2006
		curFirstPerson 0
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (dispose)
		(= x (= y -1))
		(super dispose:)
	)

	(method (handleEvent event)
		(event localize: navPlane)
		(if (and (not (event type:)) (not (curFirstPerson onMe: event)))
			(self dispose:)
			(FrameOut)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
			)
			(2
				(gCurRoom showDetail: (curFirstPerson detailObj:) self)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setProps param1)
		(= curFirstPerson param1)
	)
)

(class CPDetail of Prop
	(properties
		priority 300
		fixPriority 1
		cycleSpeed 2
		prevFirstPerson 0
		startX 0
		startY 0
		endX 0
		endY 0
	)

	(method (init param1 param2 &tmp [temp0 2])
		(if (< argc 2)
			(self x: (param1 x:) y: (param1 y:))
		else
			(self x: param1 y: param2)
		)
		(self view: 2006 setLoop: 2 1 cel: 0 setPri: 499)
		(super init: navCast)
		(self setCycle: ZoomCycleTo 3 296 146 self)
	)

	(method (cue &tmp temp0 temp1 temp2 temp3 temp4)
		(if (gCurRoom curFirstPerson:)
			(self
				view: ((gCurRoom curFirstPerson:) insetView:)
				loop: ((gCurRoom curFirstPerson:) insetLoop:)
				cel: ((gCurRoom curFirstPerson:) insetCel:)
				setPri: 500
				posn:
					((gCurRoom curFirstPerson:) insetX:)
					((gCurRoom curFirstPerson:) insetY:)
				setCycle: 0
			)
			(= temp0 (- (CelWide view loop cel) 1))
			(= temp1 (- (CelHigh view loop cel) 1))
			(= temp2 (+ (navPlane left:) (- 296 (>> temp0 $0001))))
			(= temp3 (+ (navPlane top:) (- 146 (>> temp1 $0001))))
			(radarPlane setRect: temp2 temp3 (+ temp2 temp0) (+ temp3 temp1))
			(UpdatePlane radarPlane)
			(radarProp
				view: 2004
				loop: 1
				cel: 0
				posn: 0 0
				cycleSpeed: 10
				setCycle: Fwd
			)
			(UpdateScreenItem radarProp)
			(UpdateScreenItem self)
		)
	)

	(method (dispose)
		(if (== (gCurRoom curInset:) self)
			(gCurRoom curInset: 0)
		)
		(userActor setMotion: 0)
		(super dispose:)
	)

	(method (doVerb))

	(method (showUserWalkin)
		(userActor
			posn: startX startY
			setPri: (+ priority 1)
			moveSpeed: 1
			cycleSpeed: 1
			xStep: 3
			yStep: 3
			show:
			setMotion: MoveTo endX endY
		)
		(UpdateScreenItem userActor)
	)

	(method (onMe)
		(if (> argc 2) 0)
		(return (super onMe: &rest))
	)
)

(class EncounterFirstPerson of FirstPersonFeature
	(properties
		encounterType 0
		timer 0
	)

	(method (init)
		(self
			posn:
				[local1 (* encounterLoc local0)]
				[local1 (+ (* encounterLoc local0) 1)]
			insetCel: [local1 (+ (* encounterLoc local0) 2)]
			zoomCel: [local1 (+ (* encounterLoc local0) 2)]
			insetPri: [local1 (+ (* encounterLoc local0) 3)]
			insetX: [local1 (+ (* encounterLoc local0) 4)]
			insetY: [local1 (+ (* encounterLoc local0) 5)]
			areasAccessible: [local1 (+ (* encounterLoc local0) 6)]
		)
		(super init: &rest)
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight (+ x 1))
		(= nsBottom (+ y 1))
	)

	(method (setNextRoom &tmp temp0 temp1)
		(= nextRoom -1)
		(if (== (gCurRoom curFirstPerson:) self)
			(= temp0 (>> (CelWide zoomView zoomLoop zoomCel) $0001))
			(= temp1 (>> (CelHigh zoomView zoomLoop zoomCel) $0001))
			(userActor posn: (+ x 4) (+ y 4))
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if (and (> argc 1) invItem)
					(switch encounterType
						(1
							(gGame autoSave: 1)
							(= encounterType 2)
						)
					)
				)
				(if (OneOf encounterType 3)
					(gGame autoSave: 1)
				)
				(= global411 encounterType)
				(gGame handsOff:)
				(gCurRoom newRoom: 2070) ; encounterCloseup
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class EncounterManager of List
	(properties
		curRangeLow 5
		curRangeHigh 8
		curEncounters 0
		allowOnly 0
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(self setEncounterRange:)
		(= temp0 (Random curRangeLow curRangeHigh))
		(= allowOnly (Max 2 (- curRangeHigh temp0)))
	)

	(method (setEncounterRange)
		(if local86
			(return)
		)
		(if (& (global122 allowedAreas:) $0001)
			(-= curRangeLow 2)
		)
		(if (& (global122 allowedAreas:) $0002)
			(-= curRangeLow 2)
		)
		(if (& (global122 allowedAreas:) $0008)
			(+= curRangeHigh 1)
		)
		(if (& (global122 allowedAreas:) $0004)
			(+= curRangeHigh 2)
		)
	)

	(method (add param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and (== gPrevRoomNum 2070) (== param1 global411)) ; encounterCloseup
			(return)
		)
		(for ((= temp0 0)) (and (< size allowOnly) (< temp0 argc)) ((++ temp0))
			(= temp2 (Random curRangeLow curRangeHigh))
			(if (& curEncounters (<< $0001 temp2))
				(= temp4 temp2)
				(while 1
					(if (== (-- temp2) temp4)
						(= temp2 -1)
						(break)
					)
					(if (< temp2 curRangeLow)
						(= temp2 curRangeHigh)
					)
					(if
						(and
							(!= temp2 global412)
							(not (& curEncounters (<< $0001 temp2)))
						)
						(break)
					)
				)
			)
			(if (== temp2 -1)
				(return)
			)
			(|= curEncounters (<< $0001 temp2))
			(super
				add:
					((= temp1 (encounterFirstPerson new:))
						encounterType: [param1 temp0]
						encounterLoc: temp2
						plane: navPlane
						init:
						yourself:
					)
			)
			(temp1 setPolygon: (localproc_1 (temp1 insetCel:)) setHotspot: 2)
		)
	)

	(method (restoreAdd param1 param2 &tmp temp0 temp1 [temp2 3])
		(|= curEncounters (<< $0001 param2))
		(super
			add:
				((= temp1 (encounterFirstPerson new:))
					encounterType: param1
					encounterLoc: param2
					plane: navPlane
					init:
					yourself:
				)
		)
		(temp1 setPolygon: (localproc_1 (temp1 insetCel:)) setHotspot: 2)
	)
)

(class EncounterDetail of CPDetail
	(properties
		encounterType 0
		assocView 0
		assocActor 0
		startList 0
		endList 0
	)

	(method (cue)
		(super cue:)
		(if (gCurRoom curFirstPerson:)
			(= encounterType ((gCurRoom curFirstPerson:) encounterType:))
			(= assocView ((gCurRoom curFirstPerson:) radarObj:))
			(if (OneOf encounterType 3 1 4 5)
				((= assocActor (EncounterActor new:))
					view: 2000
					heading: 0
					loop: 3
					cel: (- encounterType 1)
					setLooper: Grooper
					setPri: (+ priority 1)
				)
			else
				((= assocActor (EncounterActor new:))
					view: 2000
					setLoop: 8
					setCel:
						(switch encounterType
							(6 8)
							(9 6)
							(10 11)
						)
					setPri: (+ priority 1)
				)
			)
			(if (gCurRoom obstacles:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
			)
			(switch cel
				(1
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 237 146 241 127 261 109 270 76 329 25 422 25 422 48 336 93 334 126 317 144 268 155
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 344 133 352 109 370 92 390 95 396 128 390 155 376 168 357 170 344 155
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 364 205 371 183 423 157 423 231 375 225
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 273 272 273 228 264 208 286 177 308 177 339 201 339 215 363 231 423 251 423 270
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 137 248 180 213 215 179 230 182 256 219 254 236 230 272 139 272
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 145 23 306 23 282 45 245 79 245 105 190 184 170 184 150 163
								yourself:
							)
					)
				)
				(2
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 125 15 414 15 375 52 337 71 271 66 265 31 232 31 179 82 126 88
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 122 157 180 114 216 113 255 89 299 100 330 129 331 156 318 180 293 187 273 196 277 202 304 193 330 190 368 209 449 268 457 261 387 210 383 177 351 159 334 101 391 51 423 51 442 63 467 91 470 281 124 281
								yourself:
							)
					)
				)
				(4
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 149 19 209 19 202 64 157 98
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 233 20 440 20 441 137 387 217 347 217 321 201 299 146 311 94 307 68 265 62 246 51
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 154 116 213 65 244 60 272 73 286 126 279 201 297 213 344 220 392 220 441 147 441 272 151 272
								yourself:
							)
					)
				)
				(5
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 141 21 360 21 310 105 284 116 248 95 214 92 180 117 140 107
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 139 164 204 120 230 128 252 167 295 167 336 99 397 47 447 29 447 274 137 274
								yourself:
							)
					)
				)
				(6
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 135 17 433 17 428 58 404 98 361 119 319 121 315 165 335 203 335 229 297 272 129 272
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 310 271 345 227 347 194 371 128 409 102 454 71 454 271
								yourself:
							)
					)
				)
				(7
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 132 18 463 18 464 64 393 73 345 131 255 131 218 146 200 143 130 92
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 130 187 182 225 180 245 161 268 130 268
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 217 269 218 218 228 183 243 161 265 162 328 164 348 179 390 232 404 270
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 355 141 386 101 460 103 460 256 424 250 402 226
								yourself:
							)
					)
				)
				(9
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 125 18 443 19 365 89 356 168 341 176 305 175 300 110 226 114 127 90
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 130 101 175 108 223 122 271 118 290 136 296 181 339 183 367 167 394 172 417 225 451 261 440 274 130 274
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 394 131 415 103 454 103 454 178 416 169
								yourself:
							)
					)
				)
				(11
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 147 16 182 16 245 78 235 103 202 103 150 129
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 149 141 204 108 263 114 322 150 375 168 446 171 446 269 151 269
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 188 16 327 16 319 59 334 88 330 104 310 107 257 75
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 335 16 445 16 444 152 406 159 364 138 346 87 327 47
								yourself:
							)
					)
				)
				(13
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 153 19 225 19 244 79 230 105 204 140 156 174
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 157 179 214 139 243 133 271 161 300 271 157 271
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 248 49 297 18 432 18 434 273 316 272 291 202 309 171 264 115
								yourself:
							)
					)
				)
				(14
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 154 20 201 22 264 53 265 81 250 102 213 115 173 148 148 148
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 150 158 186 157 219 128 252 119 288 137 322 141 360 161 365 195 355 220 334 244 324 266 148 266
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 286 18 431 18 431 261 384 230 384 186 399 153 354 109 305 94 293 58
								yourself:
							)
					)
				)
				(16
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 229 16 427 16 427 184 382 185 326 155 262 67
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 169 46 217 55 266 114 301 138 334 184 356 208 386 199 428 199 428 270 167 270
								yourself:
							)
					)
				)
			)
		)
	)

	(method (dispose)
		(= assocActor 0)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
			(gCurRoom obstacles: 0)
		)
		(if startList
			(startList dispose:)
			(= startList 0)
		)
		(if endList
			(endList dispose:)
			(= endList 0)
		)
		(switch encounterType
			(6
				(if (not (OneOf (proc70_9 106) -2 -3 2018))
					(assocView
						posn:
							((gCurRoom curFirstPerson:) x:)
							((gCurRoom curFirstPerson:) y:)
						setPri: 499
					)
				)
			)
		)
		(super dispose:)
	)

	(method (setStartList)
		(if (not startList)
			(= startList (IntArray new: argc))
		)
		(startList at: 0 &rest)
	)

	(method (setEndList)
		(if (not endList)
			(= endList (IntArray new: argc))
		)
		(endList at: 0 &rest)
	)

	(method (startActorsWalk &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and assocActor startList endList)
			(= temp5
				(if (> (startList size:) 2)
					(Random 0 (- (>> (startList size:) $0001) 1))
				else
					0
				)
			)
			(= temp1 (startList at: (* temp5 2)))
			(= temp2 (startList at: (+ (* temp5 2) 1)))
			(= temp0
				(if (> (endList size:) 2)
					(Random 0 (- (>> (endList size:) $0001) 1))
				else
					0
				)
			)
			(= temp3 (endList at: (* temp0 2)))
			(= temp4 (endList at: (+ (* temp0 2) 1)))
			(assocActor posn: temp1 temp2)
			(UpdateScreenItem assocActor)
			(assocActor setMotion: CPlainPolyPath temp3 temp4 assocActor)
		)
	)
)

(class CPlains of RamaRoom
	(properties
		picture 2000
		exitStyle 13
		curLoc 16
		curInset 0
		curFirstPerson 0
		iceportCount 0
		encManager 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(Load rsVIEW 2000)
		(Load rsVIEW 2004)
		(Load rsVIEW 2006)
		((= plane (= global116 navPlane)) init:)
		(radarPlane picture: -2 priority: (+ (navPlane priority:) 1) init:)
		(gCast add: navCast)
		(super init: &rest)
		(RemapColors 1 238 0 75 1) ; ByRange
		(RemapColors 1 239 0 75 2) ; ByRange
		(RemapColors 1 240 0 75 3) ; ByRange
		(RemapColors 1 241 0 75 4) ; ByRange
		(global122 migrate:)
		(userActor init: navCast)
		(self setCurLoc:)
		(baseCampFirstPerson init:)
		(wheelFirstPerson init:)
		(bangkokFirstPerson init:)
		(beamFirstPerson init:)
		(iceportFirstPerson init:)
		(londonFirstPerson init:)
		(radarProp x: 0 y: 0 init: detailCast)
		(= encManager ((EncounterManager new:) init: yourself:))
		(if (not local86)
			(self setupEncounters:)
		else
			(if local87
				(for ((= temp0 0)) (< temp0 (local87 size:)) ((+= temp0 2))
					(= temp1 (local87 at: temp0))
					(= temp2 (local87 at: (+ temp0 1)))
					(encManager restoreAdd: temp1 temp2)
				)
				(local87 dispose:)
				(= local87 0)
			)
			(if local88
				(if (<= local88 11)
					(for
						((= temp0 (encManager first:)))
						temp0
						((= temp0 (encManager next: temp0)))
						
						(= temp4 (encManager value: temp0))
						(if (== (temp4 encounterLoc:) local88)
							(= temp2 temp4)
							(break)
						)
					)
				else
					(= temp2
						(switch local88
							(12 wheelFirstPerson)
							(13 beamFirstPerson)
							(14 bangkokFirstPerson)
							(15 iceportFirstPerson)
							(16 londonFirstPerson)
							(17 baseCampFirstPerson)
						)
					)
				)
				(= temp3 (temp2 setupHighlight:))
				(gCurRoom showDetail: (temp2 detailObj:) temp3)
				(temp3 dispose:)
				(= local88 0)
			)
		)
		(if global150
			(gKeyDownHandler add: self)
		)
		(if (not (SetFlag 56))
			(self setScript: (ScriptID 400 0) 0 detailCast) ; typeMsg
		)
		(radarProp setCycle: Fwd)
		(= local86 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(cond
					(curInset
						(self showDetail: 0)
					)
					(script
						(script dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(userActor dispose:)
		(if (!= newRoomNumber 2070) ; encounterCloseup
			(= global411 (= global412 0))
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(self showDetail: 0)
		(encManager dispose:)
		(= encManager 0)
		(if global150
			(gKeyDownHandler delete: self)
		)
		(radarPlane dispose:)
		(if script
			(script dispose: 1)
		)
		(DisposeScript 400)
		(super dispose:)
	)

	(method (drawPic param1)
		(if (and inset (< argc 4))
			((inset plane:) drawPic: param1 &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (setCurLoc param1 &tmp temp0 temp1)
		(= curLoc
			(if (not argc)
				(switch gPrevRoomNum
					(2080 1) ; CPBangkok1
					(2082 2) ; CPBangkok3
					(2040 16) ; BeamRgn1
					(2051 8) ; BeamRgn12
					(2100 6) ; CPIceport1
					(2060 8) ; CPLondon1
					(2065 4) ; CPLondon6
					(2010 1) ; wheelRgn1
					(2014 16) ; wheelRgn5
					(2070 ; encounterCloseup
						(if (OneOf global411 7 8)
							(= temp1 0)
							(if (& (global122 allowedAreas:) $0002)
								(|= temp1 $0002)
							)
							(if (& (global122 allowedAreas:) $0004)
								(|= temp1 $0004)
							)
							temp1
						else
							[local1 (+ (* global412 local0) 6)]
						)
					)
					(else
						(= gPrevRoomNum 2001) ; baseCampTent1
						16
					)
				)
			else
				param1
			)
		)
		(= temp0
			(switch gPrevRoomNum
				(2080 3) ; CPBangkok1
				(2082 3) ; CPBangkok3
				(2040 24) ; BeamRgn1
				(2051 24) ; BeamRgn12
				(2100 6) ; CPIceport1
				(2060 ; CPLondon1
					(if (IsFlag 118) 12 else 8)
				)
				(2065 12) ; CPLondon6
				(2010 17) ; wheelRgn1
				(2014 17) ; wheelRgn5
				(else curLoc)
			)
		)
		(global122 allowedAreas: (| (global122 allowedAreas:) temp0))
	)

	(method (showDetail param1 &tmp temp0)
		(= temp0 curFirstPerson)
		(if curInset
			(if (and (curInset respondsTo: #assocActor) (curInset assocActor:))
				((curInset assocActor:) dispose:)
				(curInset assocActor: 0)
			)
			(curInset dispose:)
			(userActor posn: (curFirstPerson x:) (curFirstPerson y:))
			(radarPlane setRect: 30 40 624 332)
			(UpdatePlane radarPlane)
			(radarProp setLoop: 0 1 cel: 0 posn: 296 146 cycleSpeed: 10)
			(UpdateScreenItem radarProp)
			(= curFirstPerson (= curInset 0))
			(userActor setPri: 501)
			(if (temp0 isKindOf: EncounterDetail)
				(userActor posn: (temp0 userX:) (temp0 userY:))
			else
				(self setUserPosn: (temp0 nextRoom:))
			)
		)
		(if (and (> argc 1) [param1 1] (not curInset))
			(self
				updateUserPosn: (= curFirstPerson ([param1 1] curFirstPerson:))
			)
			(= global412 (curFirstPerson encounterLoc:))
			((= curInset param1) init: &rest prevFirstPerson: temp0)
		)
		(return temp0)
	)

	(method (updateUserPosn param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (gCurRoom curLoc:))
		(= temp1 (global122 allowedAreas:))
		(= temp2 (param1 areasAccessible:))
		(= temp7 (localproc_0))
		(if (not (& temp2 temp0))
			(= temp3 temp0)
			(for ((= temp4 0)) (< temp4 5) ((++ temp4))
				(if (> temp3 16)
					(= temp3 1)
				)
				(if
					(or
						(not (& temp1 temp3))
						(and (not temp7) (not (& temp2 temp3)) (== temp3 2))
						(& temp2 temp3)
					)
					(if (not (& temp2 temp3))
						(= temp4 200)
					)
					(break)
				)
				(<<= temp3 $0001)
			)
			(= temp5 temp0)
			(for ((= temp6 0)) (< temp6 5) ((++ temp6))
				(if (< temp5 1)
					(= temp5 16)
				)
				(if
					(or
						(not (& temp1 temp5))
						(and (not temp7) (not (& temp2 temp5)) (== temp5 4))
						(& temp2 temp5)
					)
					(if (not (& temp2 temp5))
						(= temp6 200)
					)
					(break)
				)
				(>>= temp5 $0001)
			)
			(gCurRoom curLoc: (if (< temp4 temp6) temp3 else temp5))
		)
		((navPlane extMH:) eachElementDo: #perform SetupFirstPersonNextRoom)
		(self setUserPosn: (curFirstPerson nextRoom:))
	)

	(method (setUserPosn param1)
		(switch param1
			(-1 0)
			(2080
				(userActor posn: 134 155)
			)
			(2082
				(userActor posn: 154 170)
			)
			(2040
				(userActor posn: 492 149)
			)
			(2051
				(userActor posn: 435 106)
			)
			(2100
				(userActor posn: 338 197)
			)
			(2060
				(userActor posn: 340 64)
			)
			(2065
				(userActor posn: 362 83)
			)
			(2010
				(userActor posn: 192 83)
			)
			(2014
				(userActor posn: 154 99)
			)
			(2070
				(switch global411
					(7
						(userActor posn: 338 197)
					)
					(8
						(userActor posn: 338 197)
					)
					(else
						(userActor
							posn:
								[local1 (* global412 local0)]
								[local1 (+ (* global412 local0) 1)]
						)
					)
				)
			)
			(else
				(userActor posn: 423 228)
			)
		)
	)

	(method (setupEncounters)
		(if (encManager size:)
			(encManager eachElementDo: #dispose)
		)
		(if (IsFlag 119)
			(encManager add: 3)
		)
		(if (and (not (IsFlag 55)) (localproc_0))
			(encManager add: 9)
		)
		(if
			(and
				(& (global122 allowedAreas:) $0001)
				(& (global122 allowedAreas:) $0008)
				(== (proc70_9 106) 2000)
			)
			(encManager add: 6)
		)
		(cond
			((> (global122 numPiecesDropped:) 2)
				(if
					(and
						(not (mod (global122 numPiecesDropped:) 2))
						(or
							(== (proc70_9 59) 2000)
							(== (proc70_9 67) 2000)
							(== (proc70_9 71) 2000)
						)
					)
					(if (!= global411 4)
						(global122
							numPiecesDropped:
								(+ (global122 numPiecesDropped:) 1)
						)
						(encManager add: 4)
					)
				else
					(encManager add: 5)
				)
			)
			((!= global411 4)
				(global122
					numPiecesDropped: (+ (global122 numPiecesDropped:) 1)
				)
				(encManager add: 4)
			)
		)
		(if (and (not (IsFlag 121)) (not (IsFlag 311)))
			(encManager add: 10)
		)
		(encManager add: 1)
	)

	(method (serialize param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and argc param1)
			(super serialize: param1)
			(= local86 1)
			(= curInset 0)
			(if encManager
				(encManager dispose:)
			)
			(= temp0 (SaveManager readWord:))
			(= local87 (IntArray new: (* temp0 2)))
			(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
				(= temp3 (SaveManager readWord:))
				(= temp4 (SaveManager readWord:))
				(local87 at: (* temp1 2) temp3 temp4)
			)
			(= curLoc (SaveManager readWord:))
			(if (= temp4 (SaveManager readWord:))
				(= local88 temp4)
			)
		else
			(super serialize: param1)
			(SaveManager writeWord: (encManager size:))
			(for
				((= temp1 (encManager first:)))
				temp1
				((= temp1 (encManager next: temp1)))
				
				(= temp2 (encManager value: temp1))
				(SaveManager writeWord: (temp2 encounterType:))
				(SaveManager writeWord: (temp2 encounterLoc:))
			)
			(SaveManager writeWord: curLoc)
			(if curFirstPerson
				(SaveManager writeWord: (curFirstPerson encounterLoc:))
			else
				(SaveManager writeWord: 0)
			)
		)
	)
)

(class RadarBlip of View
	(properties
		priority 499
		fixPriority 1
		view 2000
		loop 9
	)
)

(class NavPlane of Plane
	(properties
		detail 0
	)
)

(instance navPlane of NavPlane
	(properties
		priority 4
	)

	(method (init)
		(super init: 30 40 624 332)
		(self addCast: ((= global117 navCast) add: yourself:))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(return)
		)
		(event localize: self)
		(cond
			(
				(and
					(not (event type:))
					(or
						(gCurRoom curInset:)
						(and extMH (extMH handleEvent: event))
					)
				)
				(if (and (gCurRoom curInset:) ((gCurRoom curInset:) onMe: event))
					(gTheCursor setDirCursor: enterCursor)
				else
					(gTheCursor handleEvent: event)
				)
				(event claimed: 1)
				(return)
			)
			((& (event type:) evMOUSEBUTTON)
				(cond
					((gCurRoom curInset:)
						(cond
							(((gCurRoom curInset:) cycler:)
								((gCurRoom curInset:) setCycle: 0 cue:)
							)
							(
								(not
									((gCurRoom curInset:)
										onMe: (event x:) (event y:)
									)
								)
								(gCurRoom showDetail: 0)
							)
							(
								((gCurRoom curFirstPerson:)
									isKindOf: EncounterFirstPerson
								)
								(= temp1
									(userActor
										facingMe:
											((gCurRoom curInset:) assocActor:)
									)
								)
								((gCurRoom showDetail: 0) doVerb: 2 temp1)
							)
							(else
								((gCurRoom showDetail: 0) doVerb: 2)
							)
						)
					)
					((and extMH (extMH handleEvent: event))
						(if (gCurRoom script:)
							((gCurRoom script:) dispose: 1)
						)
						(return)
					)
				)
				(event claimed: 1)
			)
			((and global150 (& (event type:) evKEYBOARD))
				((ScriptID 10 0) handleEvent: event) ; debugRm
			)
			(else
				(return)
			)
		)
	)
)

(instance navCast of Cast
	(properties)

	(method (dispose)
		(gCast delete: self)
		(super dispose:)
	)
)

(instance EncounterActor of Actor
	(properties
		sightAngle 45
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
	)

	(method (init)
		(super init: &rest)
		(self setLooper: Grooper)
	)

	(method (doit)
		(super doit:)
		(if (and (== gNewRoomNum gCurRoomNum) (<= (self distanceTo: userActor) 20))
			((gCurRoom showDetail: 0) doVerb: 2 1)
		)
	)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			((gCurRoom encManager:) delete: (gCurRoom curFirstPerson:))
			(((gCurRoom curFirstPerson:) radarObj:) dispose:)
			((gCurRoom curFirstPerson:) radarObj: 0)
			((gCurRoom showDetail: 0) dispose:)
		)
		(gGame handsOn:)
	)
)

(instance radarPlane of Plane
	(properties)

	(method (init)
		(super init: 30 40 624 332)
		(self addCast: (detailCast add: yourself:))
		(gCast add: detailCast)
	)

	(method (onMe)
		(return 0)
	)
)

(instance detailCast of Cast
	(properties)

	(method (dispose)
		(gCast delete: self)
		(super dispose:)
	)
)

(instance cplains of CPlains
	(properties)
)

(instance radarProp of Prop
	(properties)

	(method (init)
		(self view: 2004 loop: 0 cel: 11 x: 296 y: 146 cycleSpeed: 10)
		(super init: &rest)
	)

	(method (doit)
		(if (gUser input:)
			(super doit:)
		)
	)
)

(instance userActor of Actor
	(properties
		view 2000
		loop 8
		cel 1
		yStep 4
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(gCurRoom setUserPosn: gPrevRoomNum)
		(super init: &rest)
		(self setPri: 501 setLoop: 8 1)
	)

	(method (facingMe param1 &tmp temp0)
		(if
			(>
				(= temp0
					(Abs
						(-
							(GetAngle (param1 x:) (param1 y:) x y)
							(param1 heading:)
						)
					)
				)
				180
			)
			(= temp0 (- 360 temp0))
		)
		(return (<= temp0 45))
	)
)

(instance ottoWaitingAtIceport of View
	(properties
		x 332
		y 188
		priority 500
		fixPriority 1
		view 2000
		loop 8
		cel 6
	)
)

(instance reggieByBeamTrash of View
	(properties
		x 478
		y 136
		priority 500
		fixPriority 1
		view 2000
		loop 8
		cel 9
	)
)

(instance franInWheelRegion of View
	(properties
		priority 500
		fixPriority 1
		view 2000
		loop 8
		cel 5
	)
)

(instance brownAtIceportRegion of View
	(properties
		priority 500
		fixPriority 1
		view 2000
		loop 8
		cel 4
	)
)

(instance takagishiByBarrier of View
	(properties
		x 363
		y 75
		priority 500
		fixPriority 1
		view 2000
		loop 8
		cel 3
	)
)

(instance beamBlip of RadarBlip
	(properties
		x 476
		y 127
	)
)

(instance wheelBlip of RadarBlip
	(properties
		x 197
		y 58
	)
)

(instance bangkokBlip of RadarBlip
	(properties
		x 147
		y 159
	)
)

(instance londonBlip of RadarBlip
	(properties
		x 345
		y 75
	)
)

(instance iceportBlip of RadarBlip
	(properties
		x 323
		y 179
	)
)

(instance tentBlip of RadarBlip
	(properties
		x 437
		y 240
	)
)

(instance zoomHighlightRegion of FirstPersonHighlight
	(properties)
)

(instance encounterFirstPerson of EncounterFirstPerson
	(properties)

	(method (init)
		(super init: &rest)
		(= detailObj
			(switch insetCel
				(1 encLoc1Detail)
				(2 encLoc2Detail)
				(4 encLoc4Detail)
				(5 encLoc5Detail)
				(6 encLoc6Detail)
				(7 encLoc7Detail)
				(9 encLoc9Detail)
				(11 encLoc11Detail)
				(13 encLoc13Detail)
				(14 encLoc14Detail)
				(16 encLoc16Detail)
			)
		)
		((= radarObj (RadarBlip new:)) x: x y: y init: global117)
	)
)

(instance baseCampFirstPerson of FirstPersonFeature
	(properties
		noun 6
		x 436
		y 238
		zoomCel 10
		insetCel 10
		insetPri 360
		insetX 152
		areasAccessible 16
		encounterLoc 17
	)

	(method (init)
		(self radarObj: tentBlip detailObj: baseCampDetail)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 400 244 423 237 456 221 473 228 458 235 436 245 409 254
					yourself:
				)
		)
	)

	(method (setNextRoom)
		(= nextRoom 2001)
	)
)

(instance wheelFirstPerson of FirstPersonFeature
	(properties
		noun 7
		x 182
		y 70
		insetPri 330
		insetX 159
		areasAccessible 17
		encounterLoc 12
	)

	(method (init)
		(self radarObj: wheelBlip detailObj: wheelDetail)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 119 84 149 65 178 54 210 45 232 41 246 64 214 70 188 80 173 87 159 97
					yourself:
				)
		)
	)

	(method (setNextRoom)
		(= nextRoom
			(cond
				((& (gCurRoom curLoc:) $0001) 2010)
				((& (gCurRoom curLoc:) $0010) 2014)
			)
		)
	)
)

(instance bangkokFirstPerson of FirstPersonFeature
	(properties
		noun 8
		x 148
		y 160
		zoomCel 3
		insetCel 3
		insetPri 173
		insetX 206
		areasAccessible 3
		encounterLoc 14
	)

	(method (init)
		(self radarObj: bangkokBlip detailObj: bangkokDetail)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 133 152 158 152 162 165 139 169
					yourself:
				)
		)
	)

	(method (setNextRoom)
		(= nextRoom
			(cond
				((& (gCurRoom curLoc:) $0001) 2080)
				((& (gCurRoom curLoc:) $0002) 2082)
			)
		)
	)
)

(instance iceportFirstPerson of FirstPersonFeature
	(properties
		noun 4
		x 338
		y 190
		zoomCel 8
		insetCel 8
		insetPri 31
		insetX 222
		encounterLoc 15
	)

	(method (init)
		(self radarObj: iceportBlip detailObj: iceportDetail)
		(if (not (localproc_0))
			(= areasAccessible 0)
			(if (& (global122 allowedAreas:) $0002)
				(|= areasAccessible $0002)
			)
			(if (& (global122 allowedAreas:) $0004)
				(|= areasAccessible $0004)
			)
		else
			(= areasAccessible 6)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 313 179 332 175 362 198 326 205
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (not (localproc_0))
					(radarProp hide:)
					(switch (global122 advanceIceportWarning:)
						(0
							(= global411 7)
							(gCurRoom newRoom: 2070) ; encounterCloseup
						)
						(1
							(= global411 8)
							(gCurRoom newRoom: 2070) ; encounterCloseup
						)
						(2
							(proc55_3 38)
							(radarProp show:)
						)
						(3
							(gGame autoSave: 1)
							(gCurRoom exitStyle: 0)
							(proc55_3 40)
						)
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

	(method (setNextRoom)
		(= nextRoom 2100)
	)
)

(instance londonFirstPerson of FirstPersonFeature
	(properties
		noun 5
		x 353
		y 78
		zoomCel 15
		insetCel 15
		insetPri 250
		insetX 171
		areasAccessible 12
		encounterLoc 16
	)

	(method (init)
		(self radarObj: londonBlip detailObj: londonDetail)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 316 62 355 67 392 77 369 93 343 85 311 82
					yourself:
				)
		)
	)

	(method (setNextRoom)
		(= nextRoom
			(cond
				((& (gCurRoom curLoc:) $0004) 2065)
				((& (gCurRoom curLoc:) $0008) 2060)
			)
		)
	)
)

(instance beamFirstPerson of FirstPersonFeature
	(properties
		noun 1
		x 458
		y 142
		zoomCel 12
		insetCel 12
		insetPri 195
		insetX 174
		areasAccessible 24
		encounterLoc 13
	)

	(method (init)
		(self radarObj: beamBlip detailObj: beamDetail)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 424 119 478 107 492 132 493 150 485 176 427 167 433 153 433 137
					yourself:
				)
		)
	)

	(method (setNextRoom)
		(= nextRoom
			(cond
				((& (gCurRoom curLoc:) $0008) 2051)
				((& (gCurRoom curLoc:) $0010) 2040)
			)
		)
	)
)

(instance baseCampDetail of CPDetail
	(properties
		endX 299
		endY 62
	)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 299 startY: 32)
			(self showUserWalkin:)
		)
	)
)

(instance wheelDetail of CPDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(switch (wheelFirstPerson nextRoom:)
				(2010
					(self startX: 322 startY: 35 endX: 326 endY: 51)
				)
				(2014
					(self startX: 429 startY: 50 endX: 416 endY: 72)
				)
			)
			(if (not (OneOf (proc70_9 31) -2 -3 55 2005))
				(franInWheelRegion
					posn: 391 97
					setPri: (+ priority 1)
					init: global117
				)
			)
			(self showUserWalkin:)
		)
	)

	(method (dispose)
		(if (navCast contains: franInWheelRegion)
			(franInWheelRegion dispose:)
		)
		(super dispose:)
	)
)

(instance bangkokDetail of CPDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(switch (bangkokFirstPerson nextRoom:)
				(2080
					(self startX: 211 startY: 253 endX: 244 endY: 237)
				)
				(2082
					(self startX: 380 startY: 124 endX: 355 endY: 123)
				)
			)
			(self showUserWalkin:)
		)
	)
)

(instance iceportDetail of CPDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self
				startX: (if (& (gCurRoom curLoc:) $0002) 223 else 366)
				startY: (if (& (gCurRoom curLoc:) $0002) 234 else 207)
				endX: 290
				endY: 217
			)
			(if (not (localproc_0))
				(ottoWaitingAtIceport
					posn: 291 174
					setPri: (+ priority 1)
					init: global117
				)
			else
				(brownAtIceportRegion
					posn: 267 114
					setPri: (+ priority 1)
					init: global117
				)
			)
			(self showUserWalkin:)
		)
	)

	(method (dispose)
		(if (navCast contains: ottoWaitingAtIceport)
			(ottoWaitingAtIceport dispose:)
		)
		(if (navCast contains: brownAtIceportRegion)
			(brownAtIceportRegion dispose:)
		)
		(super dispose:)
	)
)

(instance londonDetail of CPDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(switch (londonFirstPerson nextRoom:)
				(2060
					(self startX: 353 startY: 259 endX: 319 endY: 235)
				)
				(2065
					(self startX: 178 startY: 108 endX: 245 endY: 121)
				)
			)
			(if (and (not (IsFlag 51)) (& (global122 allowedAreas:) $0008))
				(takagishiByBarrier
					posn: 257 210
					setPri: (+ priority 1)
					init: global117
				)
			)
			(self showUserWalkin:)
		)
	)

	(method (dispose)
		(if (navCast contains: takagishiByBarrier)
			(takagishiByBarrier dispose:)
		)
		(super dispose:)
	)
)

(instance beamDetail of CPDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(switch (beamFirstPerson nextRoom:)
				(2040
					(self startX: 272 startY: 258 endX: 281 endY: 236)
				)
				(2051
					(self startX: 418 startY: 74 endX: 405 endY: 74)
				)
			)
			(if
				(and
					(== (proc70_9 21) -1)
					(not (proc55_5 22))
					(not (IsFlag 121))
				)
				(reggieByBeamTrash
					posn: 324 215
					setPri: (+ priority 1)
					init: global117
				)
			)
			(self showUserWalkin:)
		)
	)

	(method (dispose)
		(if (navCast contains: reggieByBeamTrash)
			(reggieByBeamTrash dispose:)
		)
		(super dispose:)
	)
)

(instance encLoc1Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 269 startY: 257 endX: 273 endY: 224)
			(if (OneOf encounterType 6 9 10)
				(switch (Random 0 4)
					(0
						(assocActor posn: 280 192)
					)
					(1
						(assocActor posn: 244 132)
					)
					(2
						(assocActor posn: 349 97)
					)
					(3
						(assocActor posn: 402 99)
					)
					(4
						(assocActor posn: 388 175)
					)
				)
			else
				(self
					setStartList: 264 89
					setEndList: 414 73 414 160 414 232 275 252
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc2Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 145 startY: 109 endX: 183 endY: 96)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(switch (Random 0 2)
					(0
						(assocActor posn: 242 82)
					)
					(1
						(assocActor posn: 430 44)
					)
					(2
						(assocActor posn: 400 229)
					)
				)
			else
				(self
					setStartList: 404 231 265 206 423 46
					setEndList: 437 253 151 105 440 46
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc4Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 231 startY: 31 endX: 228 endY: 53)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(switch (Random 0 1)
					(0
						(assocActor posn: 263 102)
					)
					(1
						(assocActor posn: 333 174)
					)
				)
			else
				(self
					setStartList: 293 176 291 101
					setEndList: 416 173 172 95 224 38
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc5Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 157 startY: 132 endX: 177 endY: 127)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 242 182)
			else
				(self setStartList: 258 120 329 91 setEndList: 162 128 377 38)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc6Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 317 startY: 261 endX: 329 endY: 243)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 208 197)
			else
				(self setStartList: 346 163 367 122 setEndList: 322 254 435 65)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc7Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 143 startY: 163 endX: 166 endY: 163)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(switch (Random 0 1)
					(0
						(assocActor posn: 250 86)
					)
					(1
						(assocActor posn: 316 79)
					)
				)
			else
				(self
					setStartList: 224 153 358 171 365 114
					setEndList: 436 81 416 252 197 252 154 152
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc9Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 149 startY: 99 endX: 168 endY: 103)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 208 177)
			else
				(self
					setStartList: 264 115 379 115 364 168
					setEndList: 434 210 434 67 155 100
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc11Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 161 startY: 129 endX: 179 endY: 118)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 232 62)
			else
				(self
					setStartList: 252 72 292 113 344 104
					setEndList: 421 162 322 38 168 122
				)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc13Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 315 startY: 264 endX: 301 endY: 244)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 369 225)
			else
				(self setStartList: 264 130 285 168 setEndList: 301 253 235 39)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc14Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 276 startY: 49 endX: 279 endY: 65)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(assocActor posn: 198 138)
			else
				(self setStartList: 319 123 370 166 setEndList: 361 249 267 44)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance encLoc16Detail of EncounterDetail
	(properties)

	(method (cue)
		(if (gCurRoom curFirstPerson:)
			(super cue:)
			(self startX: 212 startY: 37 endX: 226 endY: 51)
			(if (OneOf encounterType 6 9 10)
				(assocActor setPri: (+ priority 1))
				(switch (Random 0 1)
					(0
						(assocActor posn: 391 77)
					)
					(1
						(assocActor posn: 340 213)
					)
				)
			else
				(self setStartList: 291 118 321 158 setEndList: 396 189 215 38)
			)
			(assocActor init: global117)
			(self showUserWalkin: startActorsWalk:)
			(if (== encounterType 3)
				(assocActor setMotion: PolyPath (userActor x:) (userActor y:))
			)
		)
	)
)

(instance enterCursor of View
	(properties
		view 600
		cel 6
	)
)

(instance SetupFirstPersonNextRoom of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #setNextRoom)
			(param1 setNextRoom:)
		)
	)
)

