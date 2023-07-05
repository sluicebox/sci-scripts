;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)

(public
	rm240 0
)

(procedure (localproc_0)
	(cond
		((== gPrevRoomNum (gCurRoom east:))
			(if (> (gEgo y:) 132)
				(gEgo y: 132)
			)
		)
		((< (gEgo x:) 25)
			(gEgo x: 27)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (== gPrevRoomNum (gCurRoom east:))
		(if (> (gEgo y:) 80)
			(gDelph y: 40)
		else
			(gDelph y: 117)
		)
		(gDelph x: 390)
		(= temp0 (- (gDelph x:) 100))
		(= temp1 (gDelph y:))
	else
		(if (< (gEgo x:) 170)
			(gDelph x: 210)
		else
			(gDelph x: 120)
		)
		(gDelph y: -70)
		(= temp0 (gDelph x:))
		(= temp1 (+ (gDelph y:) 100))
	)
	(gDelph show: setMotion: MoveTo temp0 temp1)
)

(instance rm240 of EcoRoom
	(properties
		picture 280
		style 7
		horizon 15
		north 260
		east 300
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
			add: northExit eastExit westBlock southBlock northBlock
			eachElementDo: #init
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 7 0 15 7 16 41 32 62 19 72 12 99 22 143 44 118 70 132 100 150 143 113 290 129 319 154 319 189 0 189 0 0
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

(instance northExit of Feature
	(properties
		x 168
		y 3
		nsLeft 17
		nsBottom 7
		nsRight 319
		sightAngle 90
		lookStr 8
	)
)

(instance eastExit of Feature
	(properties
		x 314
		y 76
		nsTop 8
		nsLeft 310
		nsBottom 144
		nsRight 319
		sightAngle 90
		lookStr 7
	)
)

(instance northBlock of Feature
	(properties
		x 8
		y 3
		nsBottom 7
		nsRight 15
		sightAngle 90
		lookStr 4
	)
)

(instance southBlock of Feature
	(properties
		x 159
		y 171
		nsTop 155
		nsBottom 189
		nsRight 318
		sightAngle 90
		lookStr 3
	)
)

(instance westBlock of Feature
	(properties
		x 7
		y 81
		nsTop 8
		nsBottom 154
		nsRight 14
		sightAngle 90
		lookStr 2
	)
)

