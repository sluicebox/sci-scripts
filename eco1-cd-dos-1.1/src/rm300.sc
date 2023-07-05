;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use Polygon)
(use Motion)
(use User)
(use System)

(public
	rm300 0
)

(procedure (localproc_0)
	(if (and (== gPrevRoomNum (gCurRoom north:)) (> (gEgo x:) 240))
		(gEgo x: 264)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (== gPrevRoomNum (gCurRoom north:))
		(if (< 105 (gEgo x:) 240)
			(gDelph x: 55)
		else
			(gDelph x: 155)
		)
		(gDelph y: -70)
		(= temp0 (gDelph x:))
		(= temp1 (+ (gDelph y:) 100))
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

(instance rm300 of EcoRoom
	(properties
		picture 260
		style 7
		horizon 15
		north 280
		south 100
		west 240
		walkOffTop 1
	)

	(method (init)
		(= global250 3)
		(NormalEgo)
		(gEgo ignoreHorizon: init:)
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
			add: northExit westExit southExit eastBlock southBlock northBlock
			eachElementDo: #init
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 59 189 55 152 87 167 131 130 167 129 185 141 206 113 215 125 232 125 228 152 255 133 268 130 274 116 261 111 266 95 278 84 282 43 288 7 287 0 319 0 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 220 0 240 0 252 22 261 52 257 73 246 93 239 99 231 91 227 52 234 28 221 0
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 1) ; "Adam and Delphineus are in a maze of thick, layered seaweed and kelp. It's up to Adam to lead them out and find Eluria."
			)
			(4 ; Do
				((ScriptID 2 0) init: 2 0 0 1 1) ; Delphineus, "This seaweed forest might be a pain to navigate but the plants are alive. Let's be careful not to disturb anything in here."
			)
			(44 ; Inventory
				((ScriptID 2 0) init: 2 0 0 1 1) ; Delphineus, "This seaweed forest might be a pain to navigate but the plants are alive. Let's be careful not to disturb anything in here."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 9) ; "There seems to be a path through the seaweed leading down."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber south)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance southExit of EcoFeature
	(properties
		x 27
		y 171
		nsTop 154
		nsBottom 189
		nsRight 55
		sightAngle 90
		lookStr 9
	)
)

(instance northExit of EcoFeature
	(properties
		x 109
		y 6
		sightAngle 90
		lookStr 8
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(super doVerb: &rest)
	)

	(method (onMe param1)
		(return
			(or (InRect 0 0 219 13 param1) (InRect 247 0 286 10 param1))
		)
	)
)

(instance westExit of EcoFeature
	(properties
		x 9
		y 83
		nsTop 14
		nsBottom 153
		nsRight 19
		sightAngle 90
		lookStr 6
	)
)

(instance northBlock of EcoFeature
	(properties
		x 233
		y 6
		sightAngle 90
		lookStr 4
	)

	(method (onMe param1)
		(return
			(or (InRect 220 0 246 12 param1) (InRect 287 0 319 11 param1))
		)
	)
)

(instance eastBlock of EcoFeature
	(properties
		x 312
		y 82
		nsTop 12
		nsLeft 305
		nsBottom 152
		nsRight 319
		sightAngle 90
		lookStr 2
	)
)

(instance southBlock of EcoFeature
	(properties
		x 187
		y 171
		nsTop 153
		nsLeft 56
		nsBottom 189
		nsRight 319
		sightAngle 90
		lookStr 5
	)
)

