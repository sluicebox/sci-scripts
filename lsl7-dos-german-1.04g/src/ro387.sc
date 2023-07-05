;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 387)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro387 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1)
	(if local0
		(param1 cue:)
		(return)
	)
	(poX setScript: soPicturesOut param1)
)

(procedure (localproc_1 param1)
	(if (not local0)
		(param1 cue:)
		(return)
	)
	(poX setScript: soPicturesIn param1)
)

(instance ro387 of L7Room
	(properties
		picture 38700
	)

	(method (init)
		(super init:)
		(cond
			((== gPrevRoomNum 320) ; ro320
				(gOMusic1 setMusic: 53000)
			)
			(((ScriptID 64017 0) test: 100) ; oFlags
				(gOMusic1 setMusic: 38000)
			)
			(else
				(gOMusic1 setMusic: 38700)
			)
		)
		(if
			(and
				((ScriptID 64017 0) test: 175) ; oFlags
				(not ((ScriptID 64017 0) test: 178)) ; oFlags
			)
			(UnmarkTopic global259 118)
		)
		(if (and (proc64040_5 global254 170) ((ScriptID 64017 0) test: 285)) ; oFlags
			(global259 add: 219 122)
		)
		(if global264
			(global259 add: 142)
		)
		(foCUExit init:)
		(if (not ((ScriptID 64017 0) test: 100)) ; oFlags
			(poX init:)
			(voXMouth init:)
			(poXEyes init:)
			(= gToX toX)
			(poCandles init:)
			(voNails init:)
		)
		(foVent init:)
		(foKeyHook init:)
		(foCandle1 init:)
		(foCandle2 init:)
		(foLamp1 init:)
		(foLamp2 init:)
		(foHookah init:)
		(foAncestor init:)
		(foAku init:)
		(foJar init:)
		(foDrum init:)
		(foThygh init:)
		(foShield init:)
		(if
			(and
				((ScriptID 64017 0) test: 100) ; oFlags
				(not ((ScriptID 64017 0) test: 98)) ; oFlags
			)
			(voKey init:)
		)
		(if (proc64896_19)
			(voPlayerBMP init:)
		)
		(if ((ScriptID 64017 0) test: 285) ; oFlags
			(global254 add: 167)
		)
		(gGame handsOn:)
		(if (== gPrevRoomNum 320) ; ro320
			(gCurRoom setScript: soBackThroughVent)
			(return)
		)
		(if (not ((ScriptID 64017 0) test: 100)) ; oFlags
			(gCurRoom setScript: soXIntro)
		)
	)

	(method (dispose)
		(= gToX 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 29)) ; oInvHandler, ioPassport
		(gEgo get: ((ScriptID 64037 0) get: 39)) ; oInvHandler, ioScrewdriver
		((ScriptID 64017 0) set: 175) ; oFlags
	)
)

(instance voPlayerBMP of View
	(properties
		priority 5
		x 247
		y 59
		fixPriority 1
	)

	(method (init)
		(= bitmap (proc64896_20 148 148))
		(if (not bitmap)
			(PrintDebug {Failure to create bitmap})
			(return)
		)
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(if bitmap
			(= temp0 bitmap)
			(= bitmap 0)
		else
			(= temp0 0)
		)
		(super dispose:)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local2 0)
	)
)

(instance soPicturesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voXMouth hide:)
				(poXEyes hide:)
				(poX view: 38701 loop: 0 cel: 0 doit: setCycle: End self)
			)
			(1
				(poX loop: 1 doit:)
				(poPix cel: 0 init: setCycle: End self)
			)
			(2
				(poX view: 38700 loop: 0 cel: 1 doit:)
				(voXMouth show:)
				(poXEyes show:)
				(L7TalkWindow addTopic: 141)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance soPicturesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voXMouth hide:)
				(poXEyes hide:)
				(poPix dispose:)
				(poX view: 38702 loop: 0 cel: 0 doit: setCycle: End self)
			)
			(1
				(poX view: 38700 loop: 0 cel: 0 doit:)
				(voXMouth show:)
				(poXEyes show:)
				(RemoveTopic global259 141)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance foKeyHook of Feature
	(properties)

	(method (init)
		(= noun 14)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 224 58 220 64 223 67 234 74 236 80 229 84 230 80 240 59 240 57 226 51 225
					yourself:
				)
		)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(if ((ScriptID 64017 0) test: 98) ; oFlags
				(= case 7)
			else
				(= case 1)
			)
		else
			(= case 5)
		)
		(AddDefaultVerbs self)
	)
)

(instance voNails of View
	(properties
		noun 16
		priority 100
		x 313
		y 420
		view 38750
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance voKey of View
	(properties
		noun 3
		x 68
		y 259
		loop 1
		view 38750
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8 0 0) ; "Good idea. You may as well get something in trade for your passport."
				((ScriptID 64017 0) set: 98) ; oFlags
				(foKeyHook case: 7)
				(gEgo get: ((ScriptID 64037 0) get: 6)) ; oInvHandler, ioMasterKey
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 86 0 0 self) ; "Bye bye, X-ie."
			)
			(1
				(gCurRoom newRoom: 380) ; ro380
			)
		)
	)
)

(instance soXLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 22 0 1 2 self) ; "I know how much you want to travel, Xqwzts. I'm kind of a world traveller myself. In fact, I have my passport with me right now."
			)
			(1
				(gEgo put: ((ScriptID 64037 0) get: 29)) ; oInvHandler, ioPassport
				(gMessager say: 1 22 0 3 self) ; "Thanks."
			)
			(2
				(poXEyes dispose:)
				(voXMouth dispose:)
				(poX view: 38704 loop: 0 cel: 0 doit: setCycle: End self 36)
			)
			(3
				(voKey init:)
				(= ticks 6)
			)
			(4
				(gOSound1 preload: 38702)
				(poX
					view: 38705
					loop: 0
					cel: 0
					doit:
					setCycle: End self 7 11 12 999
				)
			)
			(5
				(gOSound1 playSound: 38702)
			)
			(6
				(= local2 1)
				(= gToX 0)
				(gMessager say: 1 22 0 5 coDoneTalking) ; "Bye! Ha, ha, ha, ha..."
			)
			(7
				(poCandles dispose:)
				(voNails dispose:)
			)
			(8
				(= cycles 1)
			)
			(9
				(gOMusic1 setMusic: 38000)
				(poX dispose:)
				(if ((ScriptID 64040 2) oPlane:) ; L7TalkWindow
					((ScriptID 64040 2) dispose:) ; L7TalkWindow
				)
				(= cycles 1)
			)
			(10
				(if local2
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(gMessager say: 1 22 0 4 self) ; "Damn! Where'd he go?"
			)
			(12
				((ScriptID 64017 0) set: 100) ; oFlags
				(foVent case: 7)
				(foKeyHook dispose:)
				(foKeyHook init:)
				(foCandle1 case: 7)
				(foCandle2 case: 7)
				(foLamp1 case: 7)
				(foLamp2 case: 7)
				(= gToX 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soClimbVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oVentPlane)
				(gOMusic1 setMusic: 53000)
				(gOSound1 preload: 38603 38803)
				(gOSound1 playSound: 38802 self)
				(Palette 1 388) ; PalLoad
				(poLarryVent cel: 0 init:)
				(poRickyRat cel: 0 init:)
			)
			(1
				(poLarryVent setCycle: End self 15 26 999)
				(poRickyRat setCycle: End)
			)
			(2
				(gOSound1 playSound: 38603)
			)
			(3
				(gOSound1 playSound: 38803)
			)
			(4
				(= cycles 1)
			)
			(5
				(gCurRoom newRoom: 320) ; ro320
			)
		)
	)
)

(instance soClimbVentAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oVentPlane)
				(gOSound1 preload: 38603 38803)
				(gOMusic1 setMusic: 53000)
				(Palette 1 388) ; PalLoad
				(poLarryVent cel: 0 init:)
				(poLarryVent setCycle: End self 15 26 999)
			)
			(1
				(gOSound1 playSound: 38603)
			)
			(2
				(gOSound1 playSound: 38803)
			)
			(3
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 320) ; ro320
			)
		)
	)
)

(instance soBackThroughVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oVentPlane)
				(gOMusic1 setMusic: 53000)
				(Palette 1 388) ; PalLoad
				(poLarryVent cel: 59 init:)
				(poLarryVent setCycle: CT 38 -1 self)
				(gOSound1 playSound: 38901)
			)
			(1
				(gOSound1 stop:)
				(= cycles 1)
			)
			(2
				(gCurRoom deleteRoomPlane: oVentPlane)
				(gGame handsOn:)
			)
		)
	)
)

(instance oVentPlane of Plane
	(properties
		picture 38900
	)

	(method (init)
		(super init: 0 0 639 479)
	)
)

(instance poLarryVent of Prop
	(properties
		x 324
		y 139
		loop 1
		view 38800
	)
)

(instance poRickyRat of Prop
	(properties
		x 254
		y 462
		view 38801
	)
)

(instance foVent of Feature
	(properties)

	(method (init)
		(= noun 2)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(= case 7)
		else
			(= case 6)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 95 37 6 108 56 103 125
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(if (and ((ScriptID 64017 0) test: 100) ((ScriptID 64017 0) test: 99)) ; oFlags, oFlags
			(self addHotspotVerb: 61)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; Screwdriver
				(if (not ((ScriptID 64017 0) test: 100)) ; oFlags
					(gMessager say: 2 189 6 0) ; "Hey! Leave alone. Beat it. Talk me. Hey, hello. Right here!"
					(return)
				)
				(if (not ((ScriptID 64017 0) test: 99)) ; oFlags
					((ScriptID 64017 0) set: 99) ; oFlags
					(gCurRoom setScript: soClimbVent)
				else
					(gMessager say: 2 50 9 0) ; "You want to put the screws back in? It's unscrewed. Just open it on up."
				)
			)
			(61 ; Open
				(cond
					(((ScriptID 64017 0) test: 66) ; oFlags
						(gMessager say: 2 61 8 0) ; "The dessert tasting room is no longer locked. There's no need to climb through the air vent."
					)
					(((ScriptID 64017 0) test: 100) ; oFlags
						(if ((ScriptID 64017 0) test: 99) ; oFlags
							(gCurRoom setScript: soClimbVentAgain)
						else
							(gMessager say: 2 61 7 0) ; "74 tiny screws hold this vent tightly in place."
						)
					)
					(else
						(gMessager say: 2 61 6 0) ; "Hey! What you doing? Mess with stuff right in front of me? What wrong you?!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poX of Prop
	(properties
		noun 1
		x 299
		y 378
		view 38700
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 124) (== theVerb 176)) ; Suitcase, Clothing
			(= theVerb 188) ; Drew Baringmore
		)
		(if
			(and
				(proc64040_1 theVerb)
				(!= theVerb 118) ; Photographs
				(!= theVerb 141) ; How?
				(!= theVerb 190) ; Buy pictures
				local0
			)
			(= local1 theVerb)
			(gCurRoom setScript: soPutBackPixThenAnswer)
		else
			(switch theVerb
				(22 ; Passport
					(gCurRoom setScript: soXLeave)
				)
				(86 ; Goodbye
					(gCurRoom setScript: soGoodbye)
				)
				(122 ; Passport
					((ScriptID 64017 0) set: 160) ; oFlags
					(super doVerb: theVerb &rest)
				)
				(118 ; Photographs
					(if ((ScriptID 64017 0) test: 175) ; oFlags
						((ScriptID 64017 0) set: 178) ; oFlags
						(gCurRoom setScript: soShowPhotos)
					else
						(gMessager say: 1 118 3 0) ; "Zixwurst, you said something about pictures earlier?"
					)
				)
				(141 ; How?
					(L7TalkWindow addTopic: 190)
					(super doVerb: theVerb &rest)
				)
				(171 ; Cabin boy
					(L7TalkWindow addTopic: 133)
					(super doVerb: theVerb &rest)
				)
				(190 ; Buy pictures
					(if ((ScriptID 64017 0) test: 175) ; oFlags
						((ScriptID 64017 0) set: 178) ; oFlags
						(gCurRoom setScript: soBuyPix)
					else
						(gMessager say: 1 118 3 0) ; "Zixwurst, you said something about pictures earlier?"
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance soShowPhotos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 118 2 1 6 self) ; "(HESITANTLY) Do you know where I could obtain some "photographs." You know, the, uh, "good kind." (Wink, wink.)"
			)
			(1
				(localproc_0 self)
				(gMessager say: 1 118 2 7 self) ; "Wha... what!?"
			)
			(2)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBuyPix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 38701)
				(gMessager say: 1 190 0 0 self) ; "Well, I suppose I SHOULD buy some pictures from you. (SLYLY) Can you charge it to my room?"
			)
			(1
				(localproc_0 self)
			)
			(2
				(poLarryArm cel: 0 init: setCycle: CT 3 1 self)
			)
			(3
				(poPix hide:)
				(voXMouth hide:)
				(poXEyes hide:)
				(poX view: 38703 loop: 1 cel: 0 doit: setCycle: End self 4 99)
			)
			(4
				(poLarryArm cel: 4 doit:)
			)
			(5
				(gOSound1 playSound: 38701)
				(poX setCycle: Beg self 3 0)
			)
			(6
				(poLarryArm cel: 3 doit: setCycle: Beg coArmDone)
			)
			(7
				(poX view: 38700 loop: 0 cel: 1 doit:)
				(voXMouth show:)
				(poXEyes show:)
				(poPix show:)
				(localproc_1 self)
			)
			(8
				(gEgo get: ((ScriptID 64037 0) get: 8)) ; oInvHandler, ioLewdPhoto
				((ScriptID 64017 0) set: 97) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coArmDone of CueMe
	(properties)

	(method (cue)
		(poLarryArm dispose:)
	)
)

(instance soPutBackPixThenAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_1 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(poX doVerb: local1)
			)
		)
	)
)

(instance poPix of Prop
	(properties
		priority 380
		x 299
		y 378
		loop 2
		view 38701
		fixPriority 1
	)
)

(instance poLarryArm of Prop
	(properties
		priority 400
		x 318
		y 377
		view 38703
		fixPriority 1
	)
)

(instance voXMouth of View
	(properties
		priority 379
		x 299
		y 378
		loop 1
		view 38700
		fixPriority 1
	)
)

(instance poXEyes of Prop
	(properties
		priority 379
		x 299
		y 378
		loop 2
		view 38700
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance toX of Talker
	(properties
		priority 379
		x 299
		y 378
		loop 1
		view 38700
	)

	(method (init)
		(voXMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voXMouth show:)
		(super dispose: &rest)
	)
)

(instance soXIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 96) ; oFlags
					(gMessager say: 1 101 0 0 self) ; "Hey there, "Zorkwitz!""
				else
					((ScriptID 64017 0) set: 96) ; oFlags
					(gMessager say: 1 100 0 0 self) ; "Hello. Who dares to enter my private chambers? (BEAT) Ah. You here for dirty pictures?"
				)
			)
			(1
				(L7TalkWindow init: poX global259)
				(self dispose:)
			)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 380) ; ro380
	)
)

(instance foAku of Feature
	(properties
		noun 11
		x 609
		y 316
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 584 392 587 373 581 364 589 357 596 339 590 333 591 315 604 290 611 258 622 231 634 230 636 234 638 395 615 402
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foAncestor of Feature
	(properties
		noun 10
		x 320
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 62 393 62 393 203 248 204
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDrum of Feature
	(properties
		noun 9
		x 450
		y 253
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 423 176 441 173 462 173 482 176 489 183 485 190 484 195 489 205 496 244 489 292 481 306 462 333 443 330 415 286 404 249 409 222 426 191 426 184
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)
)

(instance foCandle1 of Feature
	(properties
		noun 12
		x 510
		y 240
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(= case 7)
		else
			(= case 6)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 500 258 509 253 509 235 506 234 512 222 521 222 521 256 511 259
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCandle2 of Feature
	(properties
		noun 12
		x 584
		y 256
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(= case 7)
		else
			(= case 6)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 570 273 578 269 577 245 574 242 574 238 589 231 592 236 592 265 598 270 587 281 575 280
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance poCandles of Prop
	(properties
		priority 100
		x 547
		y 223
		view 38706
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: RandCycle)
	)
)

(instance foJar of Feature
	(properties
		noun 15
		x 549
		y 237
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 537 257 535 237 539 221 539 214 560 212 562 223 564 231 563 258 551 262
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHookah of Feature
	(properties
		noun 8
		x 117
		y 238
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 297 92 267 106 259 106 247 95 232 101 211 120 193 112 171 124 154 118 138 124 122 124 108 129 100 130 85 137 93 138 102 143 110 141 124 148 133 147 143 142 154 150 166 149 183 139 195 153 212 157 236 150 253 142 262 159 278 169 304 168 330 149 348 134 363 148 380 124 391 96 387 87 380 102 362 96 354 71 322 65 308
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLamp1 of Feature
	(properties
		noun 6
		x 448
		y 74
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(= case 7)
		else
			(= case 6)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 461 3 483 24 486 48 472 74 458 86 451 94 457 142 448 147 438 134 445 93 436 79 416 61 411 47 415 25 443 2
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLamp2 of Feature
	(properties
		noun 6
		x 190
		y 79
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 100) ; oFlags
			(= case 7)
		else
			(= case 6)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 9 219 26 228 52 219 73 198 87 197 94 195 150 183 150 176 142 185 95 179 84 164 77 152 56 155 35 169 19 181 8
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foShield of Feature
	(properties
		noun 7
		x 56
		y 180
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 30 118 35 117 40 127 43 144 55 128 68 129 82 148 85 132 92 132 99 143 99 159 93 166 86 168 89 189 84 217 72 235 60 243 47 235 31 221 27 195 33 167 33 160 21 160 14 150 19 128
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foThygh of Feature
	(properties
		noun 17
		x 570
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 532 36 592 0 619 1 616 232 521 220
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

