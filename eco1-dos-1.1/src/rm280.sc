;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	rm280 0
)

(procedure (localproc_0)
	(cond
		((== gPrevRoomNum (gCurRoom south:))
			(if (> (gEgo x:) 240)
				(gEgo x: 272)
			)
		)
		((< (gEgo y:) 32)
			(gEgo y: 35)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (== gPrevRoomNum (gCurRoom south:))
		(if (< 130 (gEgo x:) 239)
			(gDelph x: 80)
		else
			(gDelph x: 175)
		)
		(gDelph y: 270)
		(= temp0 (gDelph x:))
		(= temp1 (- (gDelph y:) 100))
	else
		(if (< (gEgo y:) 100)
			(gDelph y: 150)
		else
			(gDelph y: 50)
		)
		(gDelph x: -70)
		(= temp0 (+ (gDelph x:) 100))
		(= temp1 (gDelph y:))
	)
	(gDelph show: setMotion: MoveTo temp0 temp1)
)

(instance rm280 of EcoRoom
	(properties
		picture 240
		style 7
		horizon 15
		south 300
		west 260
		walkOffTop 1
	)

	(method (init)
		(= global250 3)
		(NormalEgo)
		(gEgo init:)
		(NormalDelph)
		(gDelph
			setPri: 15
			z: 0
			init:
			hide:
			lookStr: 5
			talkScript: (ScriptID 241 0) ; TalkToDel
		)
		(gFeatures
			add: westExit southExit eastBlock southBlock northBlock
			eachElementDo: #init
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 261 189 236 189 235 174 248 134 263 97 267 73 286 73 283 103 270 136 266 153 262 189 238 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 281 189 296 165 306 133 316 96 309 54 219 34 168 37 87 29 28 16 16 30 0 30 0 0 319 0 319 189
					yourself:
				)
		)
		(= style 10)
		(localproc_0)
		(localproc_1)
		(super init:)
	)

	(method (dispose)
		(gDelph lookStr: 0 talkScript: 0)
		(DisposeScript 241)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 1) ; "Adam and Delphineus are in a maze of thick, layered seaweed and kelp. It's up to Adam to lead them out and find Eluria."
			)
			(3 ; Do
				((ScriptID 2 0) init: 2 0 0 1 1) ; Delphineus, "This seaweed forest might be a pain to navigate but the plants are alive. Let's be careful not to disturb anything in here."
			)
			(4 ; Inventory
				((ScriptID 2 0) init: 2 0 0 1 1) ; Delphineus, "This seaweed forest might be a pain to navigate but the plants are alive. Let's be careful not to disturb anything in here."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 9) ; "The seaweed cannot be cleared away with Adam's garbage bag."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westExit of Feature
	(properties
		x 6
		y 110
		nsTop 31
		nsBottom 189
		nsRight 13
		sightAngle 90
		lookStr 7
	)
)

(instance southExit of Feature
	(properties
		x 124
		y 184
		sightAngle 90
		lookStr 6
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(super doVerb: &rest)
	)

	(method (onMe param1)
		(return
			(or
				(InRect 14 180 234 189 param1)
				(InRect 264 183 280 189 param1)
			)
		)
	)
)

(instance southBlock of Feature
	(properties
		x 249
		y 184
		sightAngle 90
		lookStr 4
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(super doVerb: &rest)
	)

	(method (onMe param1)
		(return
			(or
				(InRect 235 180 263 189 param1)
				(InRect 281 180 319 189 param1)
			)
		)
	)
)

(instance eastBlock of Feature
	(properties
		x 313
		y 90
		nsTop 1
		nsLeft 308
		nsBottom 179
		nsRight 319
		sightAngle 90
		lookStr 3
	)
)

(instance northBlock of Feature
	(properties
		x 153
		y 15
		nsTop 1
		nsBottom 29
		nsRight 307
		sightAngle 90
		lookStr 2
	)
)

