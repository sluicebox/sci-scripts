;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
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
	rm260 0
)

(procedure (localproc_0)
	(cond
		((== gPrevRoomNum (gCurRoom north:))
			(if (< (gEgo x:) 110)
				(gEgo x: 115)
			)
		)
		((== gPrevRoomNum (gCurRoom south:))
			(cond
				((<= (gEgo x:) 35)
					(gEgo x: 21)
				)
				((< 35 (gEgo x:) 150)
					(gEgo x: 95)
				)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(cond
		((== gPrevRoomNum (gCurRoom north:))
			(if (> (gEgo x:) 110)
				(if (> (gEgo x:) 210)
					(gDelph x: 140)
				else
					(gDelph x: 270)
				)
				(gDelph y: -70)
			)
			(= temp0 (gDelph x:))
			(= temp1 (+ (gDelph y:) 100))
		)
		((== gPrevRoomNum (gCurRoom south:))
			(cond
				((<= (gEgo x:) 35)
					(gDelph x: 100)
				)
				((< 35 (gEgo x:) 150)
					(gDelph x: 207)
				)
				((> (gEgo x:) 260)
					(gDelph x: 207)
				)
				(else
					(gDelph x: 300)
				)
			)
			(gDelph y: 270)
			(= temp0 (gDelph x:))
			(= temp1 (- (gDelph y:) 100))
		)
		(else
			(if (> (gEgo y:) 100)
				(gDelph y: 50)
			else
				(gDelph y: 150)
			)
			(gDelph x: 390)
			(= temp0 (- (gDelph x:) 100))
			(= temp1 (gDelph y:))
		)
	)
	(gDelph show: setMotion: MoveTo temp0 temp1)
)

(instance rm260 of EcoRoom
	(properties
		picture 300
		style 7
		horizon 15
		north 340
		east 280
		south 240
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
			add: northExit eastExit southExit westBlock southBlock northBlock
			eachElementDo: #init
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 1 0 97 0 97 7 92 15 88 49 100 81 109 106 104 129 83 169 83 189 36 189 28 151 30 132 4 116 2 140 6 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 122 189 143 167 144 150 168 157 182 171 182 176 195 189 123 189
					yourself:
				)
		)
		(= style 10)
		(localproc_0)
		(localproc_1)
		(super init:)
		(if (or (!= (gLongSong number:) 240) (== (gLongSong prevSignal:) -1))
			(gLongSong number: 240 loop: -1 play:)
		)
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

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber north)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance southExit of Feature
	(properties
		x 20
		y 186
		sightAngle 90
		lookStr 8
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(super doVerb: &rest)
	)

	(method (onMe param1)
		(return
			(or
				(InRect 7 183 34 189 param1)
				(InRect 85 183 121 189 param1)
				(InRect 197 180 319 189 param1)
			)
		)
	)
)

(instance eastExit of Feature
	(properties
		x 310
		y 89
		nsLeft 301
		nsBottom 179
		nsRight 319
		sightAngle 90
		lookStr 7
	)
)

(instance northExit of Feature
	(properties
		x 199
		y 6
		nsLeft 98
		nsBottom 12
		nsRight 300
		sightAngle 90
		lookStr 6
	)
)

(instance northBlock of Feature
	(properties
		x 48
		y 6
		nsTop 1
		nsBottom 12
		nsRight 97
		sightAngle 90
		lookStr 4
	)
)

(instance southBlock of Feature
	(properties
		x 3
		y 186
		sightAngle 90
		lookStr 3
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(super doVerb: &rest)
	)

	(method (onMe param1)
		(return
			(or
				(InRect 0 183 6 189 param1)
				(InRect 35 183 84 189 param1)
				(InRect 122 183 196 189 param1)
			)
		)
	)
)

(instance westBlock of Feature
	(properties
		x 3
		y 97
		nsTop 13
		nsBottom 182
		nsRight 7
		sightAngle 90
		lookStr 2
	)
)

