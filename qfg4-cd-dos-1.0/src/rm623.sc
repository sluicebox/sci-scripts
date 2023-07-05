;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 623)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm623 0
)

(local
	local0
)

(instance rm623 of GloryRm
	(properties
		modNum 640
		picture 640
		east 630
		west 641
	)

	(method (init)
		(switch gPrevRoomNum
			(641
				(gEgo loop: 2 posn: 83 80)
			)
			(630
				(gEgo posn: 292 110)
			)
			(else
				(gEgo posn: 292 110)
			)
		)
		(if (< (gEgo x:) 100)
			(= local0 1)
		)
		(gEgo
			init:
			setScaler: Scaler 100 100 189 0
			normalize:
			setPri: (if local0 68 else 0)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 62 89 36 100 31 115 39 129 102 151 92 164 33 157 34 189 319 189 319 138 293 138 298 142 287 149 184 142 174 136 146 131 114 126 91 125 44 111 59 99 98 100 109 90
					yourself:
				)
		)
		(vLeftSteps ignoreActors: init:)
		(vShelfBarrels ignoreActors: approachVerbs: 4 init:) ; Do
		(vBigBarrels ignoreActors: init:)
		(vColumn ignoreActors: init:)
		((ScriptID 645 0) init:) ; rm640Code
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 623) ; "You are in a storage room just to the west of the Great Hall. Stairs lead up to each of the doors, and barrels lie heaped against the north wall."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		(DisposeScript 645)
		(super dispose:)
	)
)

(instance sGetFlask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 31 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 13 4 23 1 self 640) ; "Most of the containers are broken and useless. You find one intact empty flask and put it in your pack."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(getSound play:)
				(gEgo get: 9 normalize:) ; theFlask
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeave of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self)
			)
			(1
				(if (< (gEgo x:) 150)
					(gCurRoom newRoom: (gCurRoom west:))
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance vLeftSteps of View
	(properties
		noun 8
		modNum 640
		y 85
		view 693
	)
)

(instance vShelfBarrels of View
	(properties
		noun 13
		modNum 640
		approachX 109
		approachY 90
		x 125
		y 59
		z 20
		priority 108
		fixPriority 1
		view 6777
		cel 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 111)
				(gMessager say: 13 4 19 1 0 640) ; "None of the other containers is worth taking."
			else
				(SetFlag 111)
				(gCurRoom setScript: sGetFlask)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vBigBarrels of View
	(properties
		noun 12
		modNum 640
		x 117
		y 44
		priority 108
		fixPriority 1
		view 6777
	)
)

(instance vColumn of View
	(properties
		modNum 640
		priority 255
		fixPriority 1
		view 689
	)
)

(instance getSound of Sound
	(properties
		number 934
	)
)

