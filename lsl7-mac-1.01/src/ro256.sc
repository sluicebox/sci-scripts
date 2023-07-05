;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 256)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CueMe)
(use foEExit)
(use Talker)
(use Sync)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro256 0
)

(procedure (localproc_0)
	(if (== (poNailmiEyes loop:) 2)
		(poNailmiEyes cel: 0)
	)
	(poNailmiEyes loop: 3 setCycle: End)
	(UpdateScreenItem poNailmiEyes)
)

(procedure (localproc_1)
	(if (== (poNailmiEyes loop:) 2)
		(return)
	)
	(poNailmiEyes setCycle: Beg coResetNailmi)
	(UpdateScreenItem poNailmiEyes)
)

(instance ro256 of L7Room
	(properties
		picture 25600
	)

	(method (init)
		(super init: &rest)
		(gOMusic1 setMusic: 25202)
		(foCUExit init:)
		(voNailmi init:)
		(voNailmiMouth init:)
		(poNailmiLower init:)
		(poNailmiEyes init:)
		(= global339 toNailmi)
		(voWydoncha init:)
		(voWydonchaMouth init:)
		(poWydonchaLower init:)
		(poWydonchaEyes init:)
		(= global338 toWydoncha)
		(foWHair init:)
		(foNHair init:)
		(foWChest init:)
		(foNChest init:)
		(foWFace init:)
		(foNFace init:)
		(foNLips init:)
		(foNBody init:)
		(foBubbles init:)
		(foChampagne init:)
		(poBubbles init:)
		(foJuggs init:)
		(oBubbles setRelVol: 100 setAmbient: 25201)
		(gGame handsOn:)
		(gCurRoom setScript: soJuggsIntro)
	)

	(method (dispose)
		(= global338 0)
		(= global339 0)
		(super dispose: &rest)
	)
)

(instance oBubbles of TPSound
	(properties)
)

(instance voWydoncha of View
	(properties
		noun 2
		x 482
		y 266
		priority 245
		fixPriority 1
		view 25610
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(if (proc64037_3 theVerb)
					(foJuggs doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance voWydonchaMouth of View
	(properties
		x 482
		y 266
		priority 250
		fixPriority 1
		view 25610
		loop 1
	)
)

(instance poWydonchaEyes of Prop
	(properties
		x 482
		y 266
		priority 250
		fixPriority 1
		view 25610
		loop 2
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance poWydonchaLower of Prop
	(properties
		x 480
		y 265
		priority 240
		fixPriority 1
		view 25612
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance toWydoncha of Talker
	(properties
		x 482
		y 266
		view 25610
		loop 1
		priority 250
	)

	(method (init)
		(voWydonchaMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voWydonchaMouth show:)
		(super dispose: &rest)
	)
)

(instance voNailmi of View
	(properties
		noun 1
		x 127
		y 291
		priority 245
		fixPriority 1
		view 25600
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(if (proc64037_3 theVerb)
					(foJuggs doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance poNailmiLower of Prop
	(properties
		x 127
		y 291
		priority 240
		fixPriority 1
		view 25602
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance voNailmiMouth of View
	(properties
		x 127
		y 291
		priority 250
		fixPriority 1
		view 25600
		loop 1
	)
)

(instance poNailmiEyes of Prop
	(properties
		x 127
		y 291
		priority 250
		fixPriority 1
		view 25600
		loop 2
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance toNailmi of Talker
	(properties
		x 127
		y 291
		view 25600
		loop 1
		priority 250
	)

	(method (init)
		(voNailmiMouth hide:)
		(MouthSync oSpecialSync: coHandleNailmi)
		(MouthSync nSpecialSelector: 181)
		(super init: &rest)
	)

	(method (dispose)
		(voNailmiMouth show:)
		(super dispose: &rest)
		(localproc_1)
		(MouthSync oSpecialSync: 0)
		(MouthSync nSpecialSelector: 0)
	)
)

(instance coHandleNailmi of CueMe
	(properties)

	(method (cue param1)
		(switch param1
			(8
				(localproc_0)
			)
			(9
				(localproc_1)
			)
		)
	)
)

(instance coResetNailmi of CueMe
	(properties)

	(method (cue)
		(poNailmiEyes loop: 2 cel: 0 setCycle: Blink 100)
		(UpdateScreenItem poNailmiEyes)
	)
)

(instance poBubbles of Prop
	(properties
		x 320
		y 341
		view 25601
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 6)
		(self setCycle: Fwd)
	)
)

(instance foJuggs of Feature
	(properties)

	(method (init)
		(self setRect: 0 0 0 0)
		(= noun 7)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(203 ; Cruise
				(L7TalkWindow addTopic: 195)
				(super doVerb: theVerb &rest)
			)
			(195 ; Heat
				(L7TalkWindow addTopic: 227)
				(super doVerb: theVerb &rest)
			)
			(193 ; Music
				(L7TalkWindow addTopic: 202)
				(super doVerb: theVerb &rest)
			)
			(197 ; Big 'Uns
				(L7TalkWindow addTopic: 197)
				(gCurRoom setScript: soTalkHair)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(33 ; Heat Lamp Bulb
				(gMessager sayRange: 7 33 0 1 2) ; "Hey, it's already hot enough here."
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
				(gMessager say: 7 86 0 0 self) ; "It's been nice chatting with you."
			)
			(1
				(gCurRoom newRoom: 255) ; ro255
			)
		)
	)
)

(instance soTalkHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 7 197 0 1 4 self) ; "I notice you both have really large, uh, ...hairstyles."
			)
			(1
				(gMessager sayRange: 7 197 0 7 12 self) ; "To get it really big, I like to hang upside down!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJuggsIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 46) ; oFlags
					(gMessager say: 7 101 0 0 self) ; "Howdy!"
				else
					((ScriptID 64017 0) set: 46) ; oFlags
					(gMessager say: 7 100 0 0 self) ; "Hi ya, girls! My name's Larry; Larry Laffer."
				)
			)
			(1
				(L7TalkWindow init: foJuggs global251)
				(self dispose:)
			)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 255) ; ro255
	)
)

(instance foNBody of Feature
	(properties
		noun 9
		x 85
		y 399
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 178 138 167 149 193 144 289 160 323 146 341 82 364 46 328 64 306 94 280 94 253 79 226
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foNHair of Feature
	(properties
		noun 5
		x 85
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 31 230 14 161 46 98 61 40 81 14 147 18 157 36 157 59 150 100 146 160 115 163 136 129 138 98 141 79 122 88 100 79 80 102 83 118 95 133 89 142 80 171 54 192 49 237 34 241
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foWHair of Feature
	(properties
		noun 6
		x 531
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 457 198 452 181 456 172 474 141 474 120 468 110 476 96 470 84 472 67 493 50 512 48 519 56 554 56 574 66 577 89 573 100 584 114 584 128 575 144 579 155 604 178 610 199 602 223 569 178 541 169 532 154 538 139 547 111 492 101 486 114 492 156 476 164 467 183 470 191
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foBubbles of Feature
	(properties
		noun 11
		x 306
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 282 284 255 340 256 420 276 352 306 379 431 247 429 251 359
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNLips of Feature
	(properties
		noun 10
		x 118
		y 450
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 135 117 132 124 133 126 136 117 142 112 139
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foNChest of Feature
	(properties
		noun 3
		x 143
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 223 140 205 169 201 181 205 192 224 193 240 177 253 163 256 134 274 113 267
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foWChest of Feature
	(properties
		noun 4
		x 490
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 466 210 537 232 537 254 520 275 492 273 479 264 464 265 444 246 444 226
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foNFace of Feature
	(properties
		noun 8
		x 112
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 104 100 86 121 93 138 87 135 110 132 128 122 150 105 150 98 137
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foWFace of Feature
	(properties
		noun 14
		x 515
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 492 106 539 116 532 151 514 168 504 170 497 163
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(foJuggs doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foChampagne of Feature
	(properties
		noun 12
		x 315
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 161 202 131 200 71 172 63 155 17 475 8 473 52 433 76 434 138 464 151 449 169 370 188 291 204
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

