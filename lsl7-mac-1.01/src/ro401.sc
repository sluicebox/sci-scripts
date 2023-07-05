;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro401 0
)

(instance ro401 of L7Room
	(properties
		picture 40100
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 40000)
		(if
			(and
				((ScriptID 64017 0) test: 298) ; oFlags
				((ScriptID 64017 0) test: 299) ; oFlags
				((ScriptID 64017 0) test: 285) ; oFlags
			)
			(global252 add: 191)
		)
		(foCUExit init:)
		(poJamie init:)
		(voJamieMouth init:)
		(poJamieEyes init:)
		(= global357 toJamie)
		(foBody init:)
		(foBreasts init:)
		(foLegs init:)
		(foHair init:)
		(foMouth init:)
		(foDrawing init:)
		(foFace init:)
		(gGame handsOn:)
		(gCurRoom setScript: soTalkToJamie)
	)

	(method (dispose)
		(= global357 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 31)) ; oInvHandler, ioPolyester
	)
)

(instance toJamie of Talker
	(properties
		x 108
		y 479
		view 40100
		loop 1
		priority 51
	)

	(method (init)
		(voJamieMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voJamieMouth show:)
		(super dispose: &rest)
	)
)

(instance voJamieMouth of View
	(properties
		x 108
		y 479
		priority 51
		fixPriority 1
		view 40100
		loop 1
	)
)

(instance poJamieEyes of Prop
	(properties
		x 108
		y 479
		priority 52
		fixPriority 1
		view 40100
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance poJamie of Prop
	(properties
		noun 1
		x 108
		y 479
		priority 50
		fixPriority 1
		view 40100
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(192 ; Distressed
				(L7TalkWindow addTopic: 192)
				(L7TalkWindow addTopic: 240)
				(L7TalkWindow addTopic: 226)
				((ScriptID 64017 0) set: 299) ; oFlags
				(if
					(and
						((ScriptID 64017 0) test: 298) ; oFlags
						((ScriptID 64017 0) test: 285) ; oFlags
					)
					(L7TalkWindow addTopic: 191)
				)
				(super doVerb: theVerb &rest)
			)
			(240 ; Your collection
				(L7TalkWindow addTopic: 241)
				(L7TalkWindow addTopic: 225)
				(L7TalkWindow addTopic: 224)
				(super doVerb: theVerb &rest)
			)
			(233 ; Fashion
				(L7TalkWindow addTopic: 239)
				(super doVerb: theVerb &rest)
			)
			(191 ; Leisure suits
				(L7TalkWindow addTopic: 191)
				((ScriptID 64017 0) set: 107) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(224 ; Models
				(L7TalkWindow addTopic: 116)
				(super doVerb: theVerb &rest)
			)
			(53 ; Polyester Cloth
				(if ((ScriptID 64017 0) test: 107) ; oFlags
					(gCurRoom setScript: soGivePolyester)
				else
					(gCurRoom setScript: soJustSayNo)
				)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTalkToJamie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 105) ; oFlags
					(gMessager say: 1 101 0 0 self) ; "Hi, Jamie Lee. I'm back again."
				else
					(gMessager say: 1 100 0 0 self) ; "Hello there, beautiful. What's a mermaid like you doing here in this Atlantis city?"
					((ScriptID 64017 0) set: 105) ; oFlags
				)
			)
			(1
				(L7TalkWindow init: poJamie global252)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJustSayNo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 53 0 1 self) ; "Here, Jamie Lee, I just "dropped in" from the midnight fabric store!"
			)
			(1
				(gMessager say: 1 161 0 0 self) ; "Oh, yeah. Like I would be interested in THAT!"
			)
			(2
				(gGame handsOn:)
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
				(gGame handsOff:)
				(gMessager say: 1 86 0 0 self) ; "Well, I'm off, Jamie Lee."
			)
			(1
				(gCurRoom newRoom: 400) ; ro400
			)
		)
	)
)

(instance soGivePolyester of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 53 0 1 3 self) ; "Here, Jamie Lee, I just "dropped in" from the midnight fabric store!"
			)
			(1
				(if ((ScriptID 64040 2) oPlane:) ; L7TalkWindow
					((ScriptID 64040 2) dispose:) ; L7TalkWindow
				)
				(gCurRoom addRoomPlane: oLSPlane)
				(Palette 1 400) ; PalLoad
				(poLarry
					view: 40025
					loop: 0
					cel: 0
					posn: 198 291
					setPri: 500
					init:
					setCycle: End self
				)
				(gMessager say: 1 53 0 4 self) ; "Well, okay! But you WILL respect me in the morning, won't you?"
			)
			(2)
			(3
				(gCurRoom deleteRoomPlane: oLSPlane)
				(Palette 1 401) ; PalLoad
				(voClothesCU init:)
				(gMessager sayRange: 1 53 0 5 8 self) ; "Move your ass, yo! I got no time for chattin'. I need that leisure suit for a pattern!"
			)
			(4
				(gCurRoom addRoomPlane: oLSPlane)
				(Palette 1 400) ; PalLoad
				(voClothes init:)
				(poLarry
					view: 40030
					loop: 0
					cel: 0
					posn: 198 291
					setPri: 500
					init:
					setCycle: End self
				)
				(= global357 0)
				(gMessager say: 1 53 0 9 self) ; "No time to explain!"
			)
			(5)
			(6
				(if ((ScriptID 64017 0) test: 269) ; oFlags
					(gMessager say: 1 53 0 10 self) ; "Oh, no. Here we go again!"
				else
					(= cycles 1)
				)
			)
			(7
				(gEgo put: ((ScriptID 64037 0) get: 31)) ; oInvHandler, ioPolyester
				((ScriptID 64017 0) set: 106) ; oFlags
				((ScriptID 64017 0) set: 262) ; oFlags
				(proc64896_1 1 3 self)
			)
			(8
				(FrameOut)
				(gCurRoom newRoom: 551) ; ro551
			)
		)
	)
)

(instance voClothesCU of View
	(properties
		x 465
		y 239
		view 40150
		loop 1
	)
)

(instance oLSPlane of Plane
	(properties
		picture 40000
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poJamieLS init:)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poJamieLS of Prop
	(properties
		x 194
		y 290
		priority 330
		fixPriority 1
		view 40020
		cel 5
	)
)

(instance voClothes of View
	(properties
		x 198
		y 291
		priority 490
		fixPriority 1
		view 40025
		loop 1
	)
)

(instance foBreasts of Feature
	(properties
		noun 5
		x 179
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 135 204 153 187 204 191 224 215 222 227 206 240 156 230 138 223
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foHair of Feature
	(properties
		noun 4
		x 143
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 100 82 98 66 88 49 93 31 111 22 110 7 121 0 188 1 192 20 199 29 196 44 185 48 183 74 173 86 166 83 158 95 162 67 160 64 145 68 151 56 121 64 114 80 110 85
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foFace of Feature
	(properties
		noun 7
		x 136
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 87 118 77 162 69 157 113 145 131 134 134 128 127 117 107 114 94 114 85
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foMouth of Feature
	(properties
		noun 2
		x 136
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 112 141 113 144 116 140 121 134 120 130 118 129 112 136 111
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foBody of Feature
	(properties
		noun 8
		x 142
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 137 193 156 203 195 204 254 179 285 181 311 134 334 110 364 120 391 96 379 81 358 92 320 122 286 140 267 126 249 117 236 119 198 126 164 121 152
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foLegs of Feature
	(properties
		noun 6
		x 222
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 367 120 343 162 319 189 308 243 300 279 301 296 307 303 322 306 369 326 462 330 477 307 478 276 419 255 479 221 478 221 434 239 395 197 385 160 393 120 389
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poJamie doVerb: theVerb &rest)
			(return)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foDrawing of Feature
	(properties
		noun 9
		x 422
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 147 637 96 637 230 557 406 306 356 302 308 285 297 235 298 207 258
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 400) ; ro400
	)
)

