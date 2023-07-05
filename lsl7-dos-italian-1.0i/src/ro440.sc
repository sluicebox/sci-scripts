;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro440 0
)

(local
	local0
	local1
)

(instance ro440 of L7Room
	(properties
		picture 44000
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 160 115 477 311
			posn: 79 421
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 23 465 173 466 179 459 292 403 624 426 631 390 255 353 229 368 217 369 188 370 181 352 183 336 179 316 169 303 157 299 124 302 107 306 94 311 92 327 74 339 70 354 46 367 30 382 26 395
					yourself:
				)
		)
		(gOMusic1 setMusic: 44000 setRelVol: 10)
		(oLowHum setAmbient: 44005)
		(poALarry init: hide:)
		(poScanScreen init:)
		(poTapeDrives init:)
		(foCardreader init:)
		(foConsole init:)
		(foMannequin init:)
		(foMonitor init:)
		(foPlatform init:)
		(foScanner init:)
		(foTapeDrives init:)
		(if (not ((ScriptID 64017 0) test: 239)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 246 460
				setDest: -15 495
				loop: 1
				cel: 6
				setScaleDirect: 95
				setPri: 177
				nMyFlag: 239
				init:
			)
		)
		(foExit init:)
		(gGame handsOn:)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 106) ; oFlags
	)

	(method (dispose)
		(= global330 0)
		(gOMusic1 setRelVol: 100)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soGetScanned of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64017 0) set: 126) ; oFlags
				(gGame handsOff:)
				(gEgo walkTo: 345 347 self 1 1 0)
			)
			(1
				(gEgo normalize: 7 1)
				(gMessager say: 6 231 0 1 self) ; "Let's just see what this guy's got..."
			)
			(2
				(= local0 0)
				(gMessager say: 6 231 0 2 coEndTalk) ; "Whew! What a place to hide a card reader!"
				(poALarry
					view: 44001
					loop: 0
					cel: 0
					x: 376
					y: 347
					show:
					setCycle: End self 4 13 32 35 42 9999
				)
				(gEgo hide:)
			)
			(3
				(gOSound1 playSound: 44001)
			)
			(4
				(gOSound1 playSound: 44002)
			)
			(5
				(gOSound1 playSound: 44003)
			)
			(6
				(gOSound1 playSound: 44004)
			)
			(7
				(gOSound1 playSound: 44001)
			)
			(8
				(gEgo show: walkTo: 154 380 self 1 1 0)
				(poALarry hide:)
			)
			(9
				(poALarry
					view: 44000
					loop: 0
					cel: 0
					x: 130
					y: 380
					show:
					setCycle: End self
				)
				(gEgo hide:)
			)
			(10
				(poElectricSpark init:)
				(= ticks 120)
			)
			(11
				(oTapeWhir setAmbient: 44007)
				(poTapeDrives setCycle: Fwd)
				(= ticks 90)
			)
			(12
				(poScanLight init:)
				(oSparks setAmbient: 50009)
				(poALarry view: 44002)
				(= ticks 70)
			)
			(13
				(gOSound1 playSound: 44006)
				(poBTScanLarry init: 1 158 79 160)
				(poScanScreen
					view: 44003
					loop: 0
					cel: 0
					x: 446
					y: 458
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(14
				(gOMusic1 setRelVol: 50)
				(poScanScreen
					view: 44003
					loop: 1
					cel: 0
					x: 446
					y: 458
					setCycle: End self
				)
				(= local1 1)
			)
			(15
				(oSparks stop:)
				(poScanScreen setCycle: Fwd)
				(poScanLight dispose:)
				(poElectricSpark dispose:)
				(oCrackle stop:)
				(poALarry
					view: 44004
					loop: 0
					cel: 0
					x: 130
					y: 380
					setCycle: End self
				)
				(poTapeDrives setCycle: 0)
				(oTapeWhir stop:)
			)
			(16
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(17
				(gEgo posn: 145 391 show: normalize: 2 1)
				(poALarry hide:)
				(if ((ScriptID 64017 0) test: 104) ; oFlags
					(gMessager sayRange: 6 231 3 3 4 self) ; "(MECHANICAL) Your score is: 100. (NO LONGER MECHANICAL; ACTUALLY, EXCITED, GUNG HO!) Whoa! 100?! A perfect score? Cool! (SOFT & SEXY) You hunk."
					((ScriptID 64017 0) set: 127) ; oFlags
					((ScriptID 80 0) setReal: (ScriptID 80 0) 5) ; oAnnounceTimer, oAnnounceTimer
				else
					(gMessager say: 6 231 2 3 self) ; "(MECHANICAL) Your score is: two."
				)
			)
			(18
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soElectricSpark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oCrackle playSound: 31008 setRelVol: 50)
				(client hide: cel: 0)
				(= ticks 5)
			)
			(1
				(client show:)
				(= ticks 1)
			)
			(2
				(oCrackle playSound: 31008 setRelVol: 80)
				(client hide: cel: 1)
				(= ticks 3)
			)
			(3
				(client show:)
				(= ticks 2)
			)
			(4
				(oCrackle playSound: 31008 setRelVol: 100)
				(client hide: cel: 2)
				(= ticks 2)
			)
			(5
				(client show:)
				(= ticks 3)
			)
			(6
				(oCrackle playSound: 31008 setRelVol: 150)
				(client hide: cel: 3)
				(= ticks 1)
			)
			(7
				(client show:)
				(= ticks 4)
			)
			(8
				(oCrackle playSound: 31008 setRelVol: 170)
				(client hide: cel: 4)
				(= ticks 1)
			)
			(9
				(client show:)
				(= ticks 4)
			)
			(10
				(oCrackle playSound: 31008)
				(client cel: 0 setCycle: End self)
			)
			(11
				(client setCycle: Beg self)
			)
			(12
				(self changeState: (- state 2))
			)
		)
	)
)

(instance soScanLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide: cel: 0)
				(= ticks 5)
			)
			(1
				(client show:)
				(= ticks 10)
			)
			(2
				(client hide: cel: 1)
				(= ticks 5)
			)
			(3
				(client show:)
				(= ticks 10)
			)
			(4
				(client hide: cel: 2)
				(= ticks 5)
			)
			(5
				(client show:)
				(= ticks 10)
			)
			(6
				(client hide: cel: 1)
				(= ticks 5)
			)
			(7
				(client show:)
				(= ticks 10)
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance poALarry of Prop
	(properties
		x 154
		y 365
		view 44000
	)
)

(instance poBTScanLarry of Prop
	(properties
		priority 600
		x 130
		y 380
		cel 15
		view 44000
		fixPriority 1
	)

	(method (init param1 param2 param3 param4)
		(= inLeft param1)
		(= inTop param2)
		(= inRight param3)
		(= inBottom param4)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (> inTop 2)
			(-= inTop 2)
			(-= inBottom 2)
			(= useInsetRect 1)
		else
			(self dispose:)
		)
	)
)

(instance poScanScreen of Prop
	(properties
		x 446
		y 458
		view 44003
	)
)

(instance poTapeDrives of Prop
	(properties
		x 486
		y 162
		view 44005
	)
)

(instance poElectricSpark of Prop
	(properties
		x 472
		y 277
		view 44006
	)

	(method (init)
		(super init: &rest)
		(self setScript: soElectricSpark)
	)
)

(instance poScanLight of Prop
	(properties
		priority 50
		x 140
		y 324
		view 44007
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soScanLight)
	)
)

(instance foCardreader of Feature
	(properties
		noun 6
		x 271
		y 203
		approachX 345
		approachY 347
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 276 225 285 215 285 181 275 181 266 181 258 201 259 208 266 224
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 231)
	)

	(method (doVerb theVerb)
		((ScriptID 64017 0) set: 247) ; oFlags
		(switch theVerb
			(231 ; Unzip
				(if ((ScriptID 64017 0) test: 127) ; oFlags
					(gMessager say: 2 16 2 1 0 420) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gCurRoom setScript: soGetScanned)
				)
			)
			(16 ; TMT Scorecard
				(self doVerb: 231)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foConsole of Feature
	(properties
		noun 3
		x 434
		y 369
		approachX 142
		approachY 453
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 279 309 260 230 448 411 478 637 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 6)
	)
)

(instance foMannequin of Feature
	(properties
		noun 2
		x 267
		y 186
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 263 310 203 317 204 324 191 330 186 334 186 343 181 341 130 330 121 323 111 311 108 290 101 290 94 293 90 294 84 297 82 298 76 302 67 276 31 260 36 259 65 261 68 259 79 261 82 261 91 262 95 255 97 251 94 247 94 244 99 222 117 217 137 214 159 218 171 226 175 239 163 238 202 200 243 207 271 215 306 222 311 207 323 200 329 192 338 202 342 216 340 227 334 233 333 241 333 249 324 240 309 245 305 245 298 243 297 227 255 231 247 267 225 275 227 279 329 294 297
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foMonitor of Feature
	(properties
		noun 4
		x 456
		y 373
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 535 463 563 295 377 283 350 433
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		((ScriptID 64017 0) set: 247) ; oFlags
		(switch theVerb
			(1 ; Look
				(if local1
					(gMessager say: 4 1 1) ; "Hey, that's you!"
				else
					(gMessager say: 4 1) ; "Images scanned by the circular scanning platform are displayed on this high-resolution monitor."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPlatform of Feature
	(properties
		noun 1
		x 143
		y 331
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 346 232 332 222 318 207 314 207 305 201 300 166 292 135 288 98 293 82 299 78 304 78 318 65 321 56 324 55 333 58 345 76 357 101 368 144 375 176 372 211 359
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foScanner of Feature
	(properties
		noun 7
		x 144
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 97 172 95 193 90 206 84 215 76 216 44 212 40 204 20 196 7 195 2 102 0 91 9 82 22 77 38 72 41 72 72 78 81 90 87 113 93 135 96
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTapeDrives of Feature
	(properties
		noun 5
		x 491
		y 117
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 173 638 52 574 61 506 72 416 87 380 91 360 106 348 124 344 146 345 182 414 178 474 177 521 175 632 174
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 429 639 429 639 479 0 479
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

(instance oShortSound of TPSound ; UNUSED
	(properties)
)

(instance oLowHum of TPSound
	(properties)
)

(instance oTapeWhir of TPSound
	(properties)
)

(instance oCrackle of TPSound
	(properties)
)

(instance oSparks of TPSound
	(properties)
)

