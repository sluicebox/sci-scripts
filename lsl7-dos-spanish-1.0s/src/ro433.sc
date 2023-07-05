;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 433)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro433 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(if
		(and
			((ScriptID 64017 0) test: 285) ; oFlags
			((ScriptID 64017 0) test: 124) ; oFlags
			((ScriptID 64017 0) test: 112) ; oFlags
			((ScriptID 64017 0) test: 286) ; oFlags
		)
		(if ((ScriptID 64040 2) oPlane:) ; L7TalkWindow
			((ScriptID 64040 2) addTopic: 84) ; L7TalkWindow
		else
			(global248 add: 84)
		)
	)
)

(instance ro433 of L7Room
	(properties
		picture 43300
	)

	(method (init)
		(super init: &rest)
		(= global330 0)
		(= gToVicki 0)
		(poVickiBookDown init:)
		(if (not ((ScriptID 64017 0) test: 120)) ; oFlags
			(voMucilage init:)
		)
		(cond
			((and ((ScriptID 64017 0) test: 306) ((ScriptID 64017 0) test: 286)) ; oFlags, oFlags
				(global248 add: 84)
			)
			((not ((ScriptID 64017 0) test: 124)) ; oFlags
				(global248 add: 247)
			)
		)
		(if (not (gOMusic1 isPlaying:))
			(gOMusic1 setMusic: 43300 setRelVol: 100)
		)
		(foBananaPeel init:)
		(foBattery init:)
		(foBlinds init:)
		(foCalendar init:)
		(foCandle init:)
		(foCatONineTails init:)
		(foChicken init:)
		(foComputer init:)
		(foCurtains init:)
		(foCurtains2 init:)
		(foDeskStuff init:)
		(foGerbilCage init:)
		(foGlove init:)
		(foRedLight init:)
		(foSaddle init:)
		(foTrapeze init:)
		(foWhip init:)
		(foWhipCream init:)
		(foBook1 init:)
		(foBook2 init:)
		(foBook3 init:)
		(foBook4 init:)
		(foShowVicki init:)
		(foVickiBody init:)
		(foVickiBreasts init:)
		(foVickiEyes init:)
		(foVickiFace init:)
		(foVickiHair init:)
		(poYankLarry init: hide:)
		(poClothesFlying init: hide:)
		(poVickiLarry init: hide:)
		(poLarryNoseGrab init: hide:)
		(poLarryGrabTable init: hide:)
		(poVickiDresses init: hide:)
		(poLarryPops init: hide:)
		(foExitSouth init:)
		(poOcean init:)
		(if (not ((ScriptID 64017 0) test: 283)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 617 367
				setDest: 640 494
				view: 43390
				loop: 0
				cel: 0
				setPri: 51
				nMyFlag: 283
				oAltScript: soDildo
				init:
			)
		)
		(self setScript: soVickiBookDown)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 430) ; ro430
			(gOMusic1 setRelVol: 50)
		else
			(gOMusic1 stop: setRelVol: 100)
		)
		(gOSound1 stop:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global330 0)
		(= gToVicki 0)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soVickiBookDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(poVickiBookDown setCycle: End self)
			)
			(3
				(poVickiBookDown
					view: 43300
					loop: 1
					cel: 0
					x: 333
					y: 286
					cycleSpeed: 9
					setCycle: End self 7 9999
				)
			)
			(4
				(gOSound1 playSound: 43305)
			)
			(5
				(= cycles 1)
			)
			(6
				(poVicki init:)
				(voVicki init:)
				(poVickiBookDown dispose:)
				(= gToVicki toVicki)
				(poVicki doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance soLibraryWild of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(local4
						(gMessager say: 16 85 10 0 self) ; "My name is Larry. Want to have sex?"
					)
					(local5
						(gMessager say: 16 75 0 0 self) ; "Particularly nasty weather?"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(L7TalkWindow dispose:)
				(gMessager say: 0 0 3 1 self) ; "(FINALLY! SEXUALLY FILLED OVER-ACTING!) Larry, it's time to turn my literary research into action!"
				(Load 140 43301) ; WAVE
			)
			(2
				(gMessager say: 0 0 3 2) ; "(STUTTER AROUND WHILE ANIMATION PLAYS; NEXT YELP WILL INTERRUPT THIS) Well, yes, I could see that, I'd certainly like to help out, I could offer my services..."
				(= ticks 180)
			)
			(3
				(= global330 0)
				(= gToVicki 0)
				(poYankLarry show: setCycle: End self 4 99)
				(poVicki hide:)
				(voVicki hide:)
				(gOSound1 playSound: 43301)
			)
			(4
				(gMessager kill:)
				((ScriptID 64017 0) set: 305) ; oFlags
				(gOMusic1 playSound: 43304)
				(gMessager say: 0 0 3 3 self) ; "(ONE SECOND YELP AS PULLED ACROSS DESK) Whooaaaww!"
			)
			(5 0)
			(6
				(= local1 0)
				(gOSound1 playSound: 43303)
				(gMessager sayRange: 0 0 3 4 8 coEndTalk) ; "(AS SHE TEARS YOUR CLOTHES OFF YOUR BODY) Oh!"
				(poClothesFlying show: setCycle: End self)
				(poYankLarry dispose:)
				(if local0
					(poVicki setScript: soVickiRides coEndYells)
				else
					(poVicki setScript: soVickiYells coEndYells)
				)
			)
			(7
				(gOSound1 stop:)
				(poClothesFlying dispose:)
				(poVickiLarry show: setCycle: End self)
			)
			(8
				(poVickiLarry cycleSpeed: 4 setCycle: ROsc 15 3 10)
				(= cycles 1)
			)
			(9
				(if (not local1)
					(-= state 1)
				)
				(= cycles 1)
			)
			(10
				(poLarryNoseGrab show: setCycle: End self 6 9999)
			)
			(11
				(Sound1 playSound: 43306)
			)
			(12
				(= local3 1)
				(= local1 0)
				(gMessager sayRange: 0 0 3 9 10 coEndTalk) ; "Yippee-I-yo-kay-eh!"
				(poVickiLarry setCycle: Beg self)
				(poLarryNoseGrab hide:)
			)
			(13
				(poLarryNoseGrab dispose:)
				(poVickiLarry dispose:)
				(poLarryGrabTable show: setCycle: End self)
			)
			(14
				(if (not local1)
					(-= state 1)
				)
				(= cycles 1)
			)
			(15
				(if (not local2)
					(-= state 1)
				)
				(= cycles 1)
			)
			(16
				(poVickiDresses show: setCycle: End self)
			)
			(17
				(poVicki view: 43306 loop: 0 cel: 0 x: 427 y: 303 show:)
				(UpdateScreenItem poVicki)
				(poVickiDresses dispose:)
				(= global330 toLarry)
				(= gToVicki toVicki)
				(voVicki show:)
				(= ticks 30)
			)
			(18
				(poLarryPops show: setCycle: End self)
				(poLarryGrabTable dispose:)
			)
			(19
				(poLarry init:)
				(voLarry init:)
				(poLarryPops dispose:)
				(gMessager sayRange: 0 0 3 16 19 self) ; "(REALIZATION SETS IN) Oh. Now what am I gonna do, Vicki?"
			)
			(20
				((ScriptID 64017 0) set: 124) ; oFlags
				((ScriptID 64017 0) set: 167) ; oFlags
				((ScriptID 64017 0) set: 168) ; oFlags
				(global248 add: 85)
				(UnmarkTopic global248 85)
				(RemoveTopic global248 103)
				(RemoveTopic global248 75)
				((ScriptID 64017 0) set: 175) ; oFlags
				((ScriptID 64017 0) set: 257) ; oFlags
				((ScriptID 64017 0) clear: 305) ; oFlags
				(CopyWinningWallpaper 0)
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

(instance soVickiRides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oShortSound playSound: 43307 self)
			)
			(1
				(oShortSound playSound: 43309 self)
			)
			(2
				(oShortSound playSound: 43308 self)
			)
			(3
				(if local3
					(poVickiPumps init: setCycle: CT 12 1 self)
				else
					(-- state)
					(= cycles 3)
				)
			)
			(4
				(oShortSound playSound: 43310)
				(ShowEasterEgg 1)
				(poVickiPumps cel: 12 setCycle: CT 18 1 self)
			)
			(5
				(poVickiPumps cel: 12 setCycle: CT 18 1 self)
			)
			(6
				(poVickiPumps cel: 12 setCycle: CT 18 1 self)
			)
			(7
				(poVickiPumps setCycle: End self)
			)
			(8
				(poVickiPumps dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soVickiYells of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oShortSound playSound: 43307 self)
			)
			(1
				(oShortSound playSound: 43308 self)
			)
			(2
				(oShortSound playSound: 43309 self)
			)
			(3
				(oShortSound playSound: 43310 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soTalkSexLuvMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 16 85 4 0 self) ; "Ya know, you are the greatest, baby! Ka-chunk, ka-chunk."
			)
			(1
				((ScriptID 64040 2) addTopic: 111) ; L7TalkWindow
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGoToLuvMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 16 84 0 0 self) ; "(REALIZING YOU CAN USE HER TO WIN) Let's see how you do on the old "LoveMaster 2000\05!""
			)
			(1
				((ScriptID 64017 0) set: 164) ; oFlags
				((ScriptID 64040 2) dispose:) ; L7TalkWindow
				(RemoveTopic global248 111)
				(gCurRoom newRoom: 410) ; ro410
				(self dispose:)
			)
		)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 86 0 1 self 432) ; "Nice talking to you, Victorian. Perhaps I'll stop by later."
			)
			(1
				(gCurRoom newRoom: 430) ; ro430
				(self dispose:)
			)
		)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) setCycle: End self) ; oDildo
			)
			(1
				((ScriptID 50 0) hide:) ; oDildo
				(self dispose:)
			)
		)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nCenterY 290
		nRange 12
	)
)

(instance poVickiBookDown of Prop
	(properties
		priority 50
		x 327
		y 303
		view 43300
		fixPriority 1
	)
)

(instance poYankLarry of Prop
	(properties
		priority 500
		x 377
		y 382
		cycleSpeed 4
		view 43302
		fixPriority 1
	)
)

(instance poVickiLarry of Prop
	(properties
		priority 50
		x 350
		y 337
		view 43303
		fixPriority 1
	)
)

(instance poClothesFlying of Prop
	(properties
		priority 50
		x 329
		y 327
		cycleSpeed 9
		loop 2
		view 43303
		fixPriority 1
	)
)

(instance poLarryNoseGrab of Prop
	(properties
		x 300
		y 300
		loop 1
		view 43303
	)
)

(instance poVickiPumps of Prop
	(properties
		priority 50
		x 400
		y 248
		view 43304
		fixPriority 1
	)
)

(instance poVickiDresses of Prop
	(properties
		priority 50
		x 326
		y 299
		loop 2
		view 43306
		fixPriority 1
	)
)

(instance poLarryGrabTable of Prop
	(properties
		priority 50
		x 340
		y 250
		view 43305
		fixPriority 1
	)
)

(instance poLarryPops of Prop
	(properties
		priority 50
		x 340
		y 246
		view 43307
		fixPriority 1
	)
)

(instance poLarryArms of Prop ; UNUSED
	(properties
		x 250
		y 250
		loop 2
		view 43308
	)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super init: &rest)
	)

	(method (show)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super show:)
	)
)

(instance poEroticBook of Prop ; UNUSED
	(properties
		x 379
		y 386
		cycleSpeed 9
		view 43300
	)
)

(instance voMucilage of View
	(properties
		noun 1
		priority 500
		x 55
		y 297
		view 43309
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(super doVerb: theVerb)
				(self dispose:)
				(gEgo get: ((ScriptID 64037 0) get: 26)) ; oInvHandler, ioMucilage
				((ScriptID 64017 0) set: 120) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foVickiBody of Feature
	(properties
		noun 17
		x 382
		y 420
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 376 339 366 328 381 312 391 295 407 267 404 207 313 217 308 225 309 247 308 252 294 253 281 259 278 269 278 272 270 273 276 285 288 297 297 305 309 328 320 344 316 351 330 348 341 360 371 364 367 352 370 343
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiBreasts of Feature
	(properties
		noun 18
		x 374
		y 430
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 355 305 371 297 380 289 387 275 384 259 379 253 370 249 360 247 346 248 336 256 333 268 330 260 322 254 313 249 303 249 288 254 282 259 278 266 278 273 283 286 294 293 302 293 311 292 318 287 323 298 326 276 338 288
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiEyes of Feature
	(properties
		noun 19
		x 376
		y 420
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 355 145 354 136 353 129 339 140 327 144 322 138 316 138 313 144 318 153 320 155 326 156 327 151 327 145 340 142 344 148 350 148
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVickiFace of Feature
	(properties
		noun 20
		x 378
		y 410
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 339 188 346 189 354 181 366 169 367 161 364 152 359 149 355 142 351 130 342 122 334 119 324 123 317 127 314 136 313 145 322 156 324 166 330 176 334 181
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiHair of Feature
	(properties
		noun 21
		x 386
		y 430
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 405 205 405 173 400 138 393 110 386 98 363 85 342 81 331 78 316 80 303 95 303 103 306 114 301 117 299 121 297 128 297 130 288 139 286 152 288 173 298 194 306 208 313 218 322 213 340 210 346 207 346 190 338 189 326 169 321 156 314 146 317 125 336 119 352 128 355 141 360 150 375 150 372 175 373 193 380 202 387 205
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCalendar of Feature
	(properties
		noun 3
		x 390
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 452 232 455 223 453 208 451 189 450 164 445 150 456 72 428 63 411 53 380 55 343 59 324 63 324 76 335 146 336 235 391 239 451 239
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foWhip of Feature
	(properties
		noun 38
		x 488
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 616 280 620 82 624 75 625 68 619 64 623 54 602 42 609 66 607 68 607 78 609 199 611 277
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foWhipCream of Feature
	(properties
		noun 34
		x 488
		y 322
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 502 352 506 307 501 299 495 290 494 279 487 271 487 291 484 294 477 302 474 309 471 310 471 316 473 318 480 371 484 374 493 374 500 374 502 372 502 365 497 358 497 352 501 352 501 352 501 352 500 352
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCrop of Feature ; UNUSED
	(properties
		x 519
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 523 198 527 198 524 176 522 167 522 79 526 46 523 42 516 42 516 105 516 167 516 173 512 197
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPump of Feature ; UNUSED
	(properties
		x 304
		y 202
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 312 290 323 278 326 252 318 225 313 207 317 187 317 176 326 176 327 169 313 165 311 154 305 166 305 125 321 127 325 123 323 113 317 114 302 119 281 122 281 131 284 133 301 128 297 183 291 185 294 190 294 287 306 292
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foComputer of Feature
	(properties
		noun 29
		x 205
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 300 302 300 296 270 286 258 289 259 272 224 271 209 262 260 255 265 248 271 199 281 151 244 140 213 134 177 130 137 163 110 193 127 236 133 257 178 263 169 274 168 314 201 319 244 331 281 310
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 123) ; oFlags
				(super doVerb: theVerb)
			)
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBananaPeel of Feature
	(properties
		noun 27
		x 91
		y 414
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 471 79 437 88 425 86 415 97 425 114 416 117 424 128 419 138 407 132 398 111 396 107 404 103 404 94 388 89 372 86 370 90 358 86 356 81 371 74 383 72 397 74 412 74 415 67 413 54 414 44 418 48 421 56 419 71 423 62 428 60 436 68 459 82 472
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBattery of Feature
	(properties
		noun 37
		x 131
		y 230
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 318 167 312 169 271 170 271 170 266 153 266 152 257 149 253 137 238 132 226 139 211 129 181 128 170 141 160 145 184 145 194 157 212 150 222 158 231 168 230 174 221 166 211 171 183 151 183 147 152 151 151 155 147 148 142 142 146 142 157 134 164 126 164 123 173 125 191 133 208 129 222 113 234 106 241 103 253 99 259 100 263 102 266 88 271 88 277 96 281 96 287 140 293 140 297 136 299 136 318
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBlinds of Feature
	(properties
		noun 24
		x 38
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 198 75 165 73 125 67 82 58 59 41 34 33 31 20 50 5 69 1 74 1 196 42 199
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCandle of Feature
	(properties
		noun 39
		x 20
		y 406
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 425 40 419 25 413 20 409 16 390 7 386 7 404 7 412 1 413 1 426 11 427
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCatONineTails of Feature
	(properties
		noun 33
		x 547
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 551 253 550 235 555 234 561 229 553 226 554 219 558 219 561 215 559 209 563 207 563 202 559 200 561 197 567 186 567 170 560 154 552 142 552 136 555 132 552 127 554 79 552 28 550 24 551 9 551 2 543 0 541 9 543 26 538 32 543 74 545 123 541 128 541 134 546 140 541 149 538 161 531 179 528 190 533 201 530 204 535 208 540 224 537 227 540 231 543 232 541 242 547 245 543 250 546 254
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foChicken of Feature
	(properties
		noun 32
		x 588
		y 156
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 587 289 597 286 602 274 604 261 604 253 600 251 596 237 593 235 593 202 602 219 606 228 608 227 608 215 601 205 599 187 606 152 606 113 603 100 607 95 606 89 598 89 595 71 598 68 598 62 596 60 593 37 579 23 579 55 578 59 578 65 571 94 571 118 569 142 580 173 583 188 579 201 571 220 574 233 584 203 587 205 589 228 583 232 584 245 576 245 572 254 578 254 580 260 576 270 570 266 575 278 579 281 584 269
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCurtains of Feature
	(properties
		noun 23
		x 446
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 514 246 503 176 503 108 507 103 506 76 509 57 528 25 539 1 485 0 471 11 461 13 454 1 353 1 377 26 419 58 465 77 475 88 477 98 481 109 469 169 452 239 441 269 468 267 497 259 503 249
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCurtains2 of Feature
	(properties
		noun 23
		x 128
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 162 114 261 174 269 176 129 168 97 178 68 204 53 240 20 256 1 1 1 0 72 22 46 45 9 71 43 107 74 129 83 137 105
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foGerbilCage of Feature
	(properties
		noun 26
		x 70
		y 351
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 64 414 73 409 73 391 80 367 87 355 90 358 88 370 95 386 109 377 111 374 130 369 133 341 136 302 139 297 140 291 101 289 75 289 37 292 0 295 0 308 0 403 7 403 7 383 13 382 18 390 18 406 46 408
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foGlove of Feature
	(properties
		noun 30
		x 230
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 252 141 255 138 251 131 265 122 271 105 267 94 277 89 284 87 285 78 277 74 270 78 263 89 253 85 237 82 237 75 241 63 232 57 224 64 220 74 227 85 221 86 220 83 216 80 211 82 209 89 209 90 199 95 190 89 180 90 175 98 175 105 184 105 188 104 194 104 188 111 186 118 188 126 192 131 214 134 239 138
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRedLight of Feature
	(properties
		noun 25
		x 26
		y 232
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 264 44 261 44 260 36 258 32 253 34 253 34 245 34 242 36 233 44 221 39 205 31 200 22 200 11 206 9 217 10 226 20 234 22 237 22 244 22 253 23 256 18 257 22 263 31 265
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSaddle of Feature
	(properties
		noun 35
		x 438
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 507 325 524 307 534 279 534 258 525 249 519 248 512 247 504 250 499 258 477 265 454 270 434 270 402 268 380 261 377 260 381 244 384 246 386 242 378 229 367 223 361 223 357 228 358 233 365 238 366 251 355 251 348 257 345 267 347 275 342 282 353 303 373 318 388 319 402 331 412 329 429 335 439 336 458 338 468 335 474 331 473 317 472 310 473 310 478 301 487 293 488 273 494 276 495 293 502 301 506 310 506 314 502 314 502 326
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foTrapeze of Feature
	(properties
		noun 31
		x 289
		y 23
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 388 45 390 42 388 40 380 40 379 37 379 0 373 1 373 39 320 36 239 33 205 31 205 1 199 1 200 31 193 29 190 32 188 39 192 45 201 46 286 46 365 46
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDeskStuff of Feature
	(properties
		noun 6
		x 402
		y 360
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 629 425 638 423 638 340 638 253 634 265 625 244 602 290 598 318 606 332 612 339 603 363 600 366 595 337 593 323 587 339 563 358 543 354 520 340 514 351 510 356 499 354 505 367 492 382 486 378 474 372 444 355 434 357 418 347 408 348 393 367 385 373 376 377 357 371 346 375 346 366 340 359 330 349 317 352 314 355 306 362 284 361 284 356 262 351 244 353 242 359 241 368 241 374 233 371 224 374 206 374 196 381 193 390 188 398 180 402 176 413 167 428 177 429 183 419 194 415 199 421 225 413 247 422 251 427 266 426 268 416 262 408 280 408 298 411 298 421 304 426 312 421 331 421 343 427 359 430 361 437 367 434 374 442 379 431 393 427 395 423 397 417 404 417 444 419 463 428 475 447 482 452 485 465 498 477 542 477 532 467 521 467 498 448 492 432 501 423 512 432 531 434 538 428 549 422 559 421 576 425 591 427 602 423 604 418
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook1 of Feature
	(properties
		noun 4
		x 100
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 310 295 266 271 238 279 238 290 277 318 300 310 301 302
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook2 of Feature
	(properties
		noun 5
		x 100
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 501 280 487 254 479 249 422 257 411 267 421 270 432 291 444 302 502 291
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook3 of Feature
	(properties
		noun 7
		x 100
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 593 410 596 404 589 396 559 385 508 392 509 409 530 426 571 417
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook4 of Feature
	(properties
		noun 8
		x 100
		y 410
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 595 463 596 420 592 410 530 426 505 404 496 404 496 418 514 441 518 441 511 462 515 466 530 468 541 472 561 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 9) ; "Take it? Are you kidding? Most of this stuff scares the crap out of you!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foShowVicki of Feature
	(properties
		noun 29
		x 206
		y 600
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 170 211 177 209 183 210 195 205 195 202 180
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(== (event modifiers:) emCTRL)
				(== (event type:) evMOUSERELEASE)
			)
			((ScriptID 64017 0) set: 302) ; oFlags
			(ShowEasterEgg)
			(= local0 1)
		)
		(super handleEvent: event)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 460 640 460 640 480 0 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(L7TalkWindow dispose:)
		(gCurRoom newRoom: 430) ; ro430
	)
)

(instance poLarry of Prop
	(properties
		priority 50
		x 342
		y 242
		view 43308
		fixPriority 1
	)
)

(instance voLarry of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super show: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= priority (+ (poLarry priority:) 1))
		(voLarry hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarry show:)
		(super dispose: &rest)
	)
)

(instance poLarryEyes of Prop ; UNUSED
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 2))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance poVicki of Prop
	(properties
		noun 16
		priority 50
		x 323
		y 302
		view 43301
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(poVickiEyes init:)
		(AddDefaultVerbs self)
	)

	(method (cue)
		(L7TalkWindow init: poVicki global248)
		(gGame handsOn:)
	)

	(method (hide)
		(super hide:)
		(poVickiEyes dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(if (not ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
					(if (not ((ScriptID 64017 0) test: 270)) ; oFlags
						(gMessager say: 16 100 0 0 self) ; "Excuse me, Miss. Didn't you used to be the ship's librarian?"
						((ScriptID 64017 0) set: 270) ; oFlags
					else
						(gMessager say: 16 101 0 0 self) ; "I'm back!"
					)
				)
			)
			(103 ; Glasses
				(if ((ScriptID 64017 0) test: 168) ; oFlags
					(super doVerb: 70)
				else
					(super doVerb: theVerb)
				)
			)
			(75 ; The weather
				(if ((ScriptID 64017 0) test: 168) ; oFlags
					(super doVerb: 70)
				else
					(= local5 1)
					(gCurRoom setScript: soLibraryWild)
				)
			)
			(84 ; LoveMaster 2000
				(cond
					(((ScriptID 64017 0) test: 165) ; oFlags
						(gMessager say: 16 84 8) ; "Well, Vicki, you did it! You were amazing."
					)
					(((ScriptID 64017 0) test: 168) ; oFlags
						((ScriptID 64017 0) set: 125) ; oFlags
						(gCurRoom setScript: soGoToLuvMaster)
					)
					(else
						(gCurRoom setScript: soLibraryWild)
					)
				)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 168) ; oFlags
					(if ((ScriptID 64017 0) test: 286) ; oFlags
						((ScriptID 64040 2) addTopic: 84) ; L7TalkWindow
					else
						((ScriptID 64040 2) addTopic: 111) ; L7TalkWindow
					)
				else
					(super doVerb: theVerb)
				)
			)
			(111 ; Prove it
				((ScriptID 64017 0) set: 286) ; oFlags
				(localproc_0)
				(if ((ScriptID 64017 0) test: 168) ; oFlags
					(gMessager say: 16 111) ; "There must be SOME way to test your theory that you're the most sexually-competant person aboard ship."
				else
					(gMessager say: 16 70) ; "I don't know about that, but I do know something else!"
				)
			)
			(85 ; Sex
				(cond
					(((ScriptID 64017 0) test: 165) ; oFlags
						(gMessager say: 16 85 8) ; "Waddaya say you share your knowledge with me?"
					)
					(((ScriptID 64017 0) test: 168) ; oFlags
						(gCurRoom setScript: soTalkSexLuvMaster)
					)
					(else
						(= local4 1)
						(gCurRoom setScript: soLibraryWild)
					)
				)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voVicki of View
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super show: &rest)
	)
)

(instance toVicki of Talker
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(= priority (+ (poVicki priority:) 1))
		(voVicki hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voVicki show:)
		(super dispose: &rest)
	)
)

(instance poVickiEyes of Prop
	(properties
		loop 2
		view 43301
	)

	(method (init)
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 2))
		(super init: &rest)
		(self setCycle: Blink 120)
	)
)

(instance poOcean of Prop
	(properties
		priority 2
		y 290
		view 43399
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance Sound1 of TPSound
	(properties)
)

(instance oShortSound of TPSound
	(properties)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local1 1)
	)
)

(instance coEndYells of CueMe
	(properties)

	(method (cue)
		(= local2 1)
	)
)

