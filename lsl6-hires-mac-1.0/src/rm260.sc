;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use fileScr)
(use OccCyc)
(use LarryRoom)
(use Print)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0
)

(instance rm260 of LarryRoom
	(properties
		picture 260
		horizon 11
	)

	(method (init)
		(super init: &rest)
		(gGlobalSound2 number: 0 stop:)
		(= global170 gCurRoom)
		(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
		(self setScript: toTower)
		(star1 init: setCycle: OccCyc self 1 10 65)
		(star2 init: setCycle: OccCyc self 1 10 65)
		(star3 init: setCycle: OccCyc self 1 10 63)
		(star4 init: setCycle: OccCyc self 1 10 65)
		(star5 init: setCycle: OccCyc self 1 10 65)
		(star6 init: setCycle: OccCyc self 1 10 63)
		(star7 init: setCycle: OccCyc self 1 10 65)
		(star8 init: setCycle: OccCyc self 1 10 60)
		(merrButt init:)
	)

	(method (cue)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(= local0 1)
		(= global213 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 235 105)
		(if
			(Print
				width: 200
				font: gUserFont
				addTitle: 0 8 0 2 260
				addText: 0 8 0 1 50 1 260 ; "Do you really want to miss out on what promises to be a unique experience, Larry?"
				addIcon: 1911 0 0 0 0
				addButton: 0 3 8 0 1 50 33 260 ; "Oops"
				addButton: 1 2 8 0 1 150 33 260 ; "Yes"
				init:
			)
			(gEgo get: 40 put: 35 put: 20 put: 2) ; wordsOWisdom, swimsuit, towerkey, beaver
			(= global170 0)
			(gTheIconBar disableIcon: (ScriptID 0 8)) ; icon5
			(gGame changeScore: 20 174 hideControls: handsOff:)
			(ClearFlag 8)
			(gGlobalSound1 stop:)
			(gCast eachElementDo: #hide)
			(gThePlane drawPic: -1 10)
			(gCurRoom newRoom: 620)
		else
			(Platform 0 2 1)
			(= local0 0)
			(= global170 gCurRoom)
			(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
			(gGame setCursor: global213)
		)
	)
)

(instance toTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gMessager say: 0 0 2 0 self) ; "Come on, Larry! Only a few hundred feet to go!"
			)
			(2
				(= ticks 90)
			)
			(3
				(if (and (not local0) (not script))
					(gGame handsOn:)
					(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				)
				(= seconds 5)
			)
			(4
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance buttShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 1 2 1 self) ; "(Perhaps a closer look would inspire me to climb faster...)"
			)
			(1
				(gCurRoom drawPic: 261)
				(= ticks 180)
			)
			(2
				(gMessager say: 0 1 2 2 self) ; "You see something special!"
			)
			(3
				(= seconds 5)
			)
			(4
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance star1 of Prop
	(properties
		x 54
		y 13
		view 260
		cycleSpeed 8
	)
)

(instance star2 of Prop
	(properties
		x 240
		y 23
		view 260
		loop 1
		cycleSpeed 7
	)
)

(instance star3 of Prop
	(properties
		x 17
		y 17
		view 260
		loop 1
		cel 1
		cycleSpeed 7
	)
)

(instance star4 of Prop
	(properties
		x 295
		y 57
		view 260
		cycleSpeed 10
	)
)

(instance star5 of Prop
	(properties
		x 115
		y 3
		view 260
	)
)

(instance star6 of Prop
	(properties
		x 175
		y 5
		view 260
		loop 1
		cel 3
		cycleSpeed 10
	)
)

(instance star7 of Prop
	(properties
		x 285
		y 16
		view 260
		loop 2
		cycleSpeed 7
	)
)

(instance star8 of Prop
	(properties
		x 64
		y 21
		view 260
		loop 3
		cel 4
		cycleSpeed 10
	)
)

(instance merrButt of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 100 35 129 29 147 42 128 60 117 64 88 61 85 49 88 41
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCast eachElementDo: #dispose)
		(gCurRoom setScript: buttShot)
	)
)

