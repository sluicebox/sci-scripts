;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 663)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm663 0
)

(local
	local0
	local1
)

(instance rm663 of GloryRm
	(properties
		modNum 640
		picture 640
		east 632
	)

	(method (init)
		(if (or (== gPrevRoomNum 660) (== gPrevRoomNum 661))
			(gEgo posn: 30 129)
			(= local0 1)
			(gEgo hide:)
		else
			(gEgo posn: 278 133)
		)
		(gEgo
			init:
			setScaler: Scaler 100 100 189 0
			normalize: (if (== gPrevRoomNum 660) 4 else 5)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 57 130 0 172 0 0 319 0 319 189 299 189 252 130 130 123 72 121
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 87 133 221 135 214 160 198 169 169 179 118 180 97 168 82 146
					yourself:
				)
		)
		(pDoor approachVerbs: 4 32 init:) ; Do, theOil
		(pFire ignoreActors: approachVerbs: 4 init: setCycle: Fwd) ; Do
		(pSecretDoor2 ignoreActors: init:)
		(pCrest init: ignoreActors: approachVerbs: 4) ; Do
		(vFirePlace ignoreActors: init:)
		(vBookCase ignoreActors: init:)
		(vRightDoor
			ignoreActors:
			approachVerbs: 4 32 ; Do, theOil
			setPri: (if local0 97 else 207)
			init:
		)
		(doorTeller init: vRightDoor 640 2 155)
		(vRug ignoreActors: init:)
		(vTheTable ignoreActors: approachVerbs: 4 init:) ; Do
		(vCeiling ignoreActors: init:)
		(vRightCeiling ignoreActors: init:)
		(vSecretDoor ignoreActors: init:)
		(vBook ignoreActors: init:)
		(fChair1 approachVerbs: 4 init:) ; Do
		(fChair2 approachVerbs: 4 init:) ; Do
		(fChair3 approachVerbs: 4 init:) ; Do
		(gCurRoom setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 663) ; "The fireplace makes this a cozy reading room. Something seems just a little strange about the large bookshelf."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setPri: 130)
				(= ticks 30)
			)
			(1
				(doorSound play:)
				(if local0
					(pSecretDoor2 setCycle: End self)
				else
					(if (not (SetFlag 212))
						(squeakSound play:)
					)
					(pDoor setCycle: End self)
				)
			)
			(2
				(gEgo normalize:)
				(pDoor setPri: 108)
				(vRightDoor setPri: 97)
				(if local0
					(gEgo setMotion: MoveTo 46 175 self)
				else
					(gEgo setMotion: MoveTo 248 143 self)
				)
			)
			(3
				(doorCloseSound play:)
				(if local0
					(pSecretDoor2 setPri: 130 setCycle: Beg self)
				else
					(pDoor setCycle: Beg self)
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPeepingTom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 4 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 2 155 29 1 self 640) ; "You catch a brief glimpse of the elusive flash of wings on the other side of the door."
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(doorSound play:)
				(if (not (IsFlag 212))
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sCastOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(doorSound play:)
				(if (not (IsFlag 212))
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo
					setMotion:
						PolyPath
						(pDoor approachX:)
						(pDoor approachY:)
						self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sPickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo trySkill: 9 global422) ; pick locks
				(gEgo trySkill: 9 global422) ; pick locks
				(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
					(gGlory handsOff:)
					(gMessager say: 1 42 1 1 self 640) ; "You hear a gentle "Snick" -- the lock is open!"
				else
					(gMessager say: 1 42 2 1 0 640) ; "This is a tricky lock; you'll need to keep practicing."
					(self dispose:)
				)
			)
			(1
				(if (IsFlag 212)
					(self cue:)
				else
					(squeakSound play:)
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(self cue:)
				)
			)
			(2
				(doorSound play:)
				(pDoor setCycle: End self)
			)
			(3
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 2) self
				)
				(squeakSound dispose:)
				(doorSound dispose:)
			)
			(4
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sSecret of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= seconds 1)
			)
			(1
				(pCrest setCycle: End self)
			)
			(2
				(doorSound play:)
				(pSecretDoor2 setPri: 150 setCycle: End self)
			)
			(3
				(gMessager say: 37 4 0 0 self 640) ; "You straighten out the crest. The bookshelf opens, revealing a secret passage!"
			)
			(4
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 87 133 212 137 211 154 198 169 169 179 118 180 97 168 82 146
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 305 189 250 131 73 121 63 128 68 149 61 156 36 154 23 144 0 173
							yourself:
						)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseSecretDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= ticks 30)
			)
			(1
				(pCrest setCycle: Beg self)
			)
			(2
				(doorCloseSound play:)
				(pSecretDoor2 setPri: 130 setCycle: Beg self)
			)
			(3
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 130 0 172 0 0 319 0 319 189 299 189 252 130 130 123 72 121
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 87 133 212 137 211 154 198 169 169 179 118 180 97 168 82 146
							yourself:
						)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveSecretly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(gGlory handsOff:)
					(= seconds 1)
				else
					(self dispose:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 29 151 self)
			)
			(2
				(gCurRoom newRoom: 660)
			)
		)
	)
)

(instance pFire of Prop
	(properties
		noun 31
		modNum 640
		x 166
		y 112
		priority 80
		fixPriority 1
		view 679
		loop 2
		cel 4
		detailLevel 2
	)
)

(instance pDoor of Prop
	(properties
		modNum 640
		approachX 248
		approachY 143
		x 252
		y 47
		priority 207
		fixPriority 1
		view 644
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(vRightDoor doVerb: theVerb)
			)
		)
	)
)

(instance pSecretDoor2 of Prop
	(properties
		noun 38
		modNum 640
		x 49
		y 129
		priority 130
		fixPriority 1
		view 691
		loop 3
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 19 147 42 148 41 159 7 159
						yourself:
					)
					1
					7
					3
					sLeaveSecretly
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance pCrest of Prop
	(properties
		noun 37
		modNum 640
		approachX 61
		approachY 129
		x 38
		y 138
		z 80
		view 691
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local1
					(= local1 0)
					(gCurRoom setScript: sCloseSecretDoor)
				else
					(= local1 1)
					(gCurRoom setScript: sSecret)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vFirePlace of View
	(properties
		noun 31
		modNum 640
		x 82
		y 43
		priority 65
		fixPriority 1
		view 679
	)
)

(instance vBookCase of View
	(properties
		noun 38
		modNum 640
		y 31
		view 691
	)
)

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 248
		approachY 143
		x 253
		y 49
		priority 207
		fixPriority 1
		view 644
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 212)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vRug of View
	(properties
		noun 33
		modNum 640
		x 18
		y 123
		view 692
	)
)

(instance vTheTable of View
	(properties
		noun 28
		modNum 640
		approachX 135
		approachY 133
		x 93
		y 128
		z 25
		priority 152
		fixPriority 1
		view 697
	)
)

(instance vCeiling of View
	(properties
		modNum 640
		view 690
	)
)

(instance vRightCeiling of View
	(properties
		modNum 640
		x 180
		view 690
		cel 1
	)
)

(instance vSecretDoor of View
	(properties
		noun 38
		modNum 640
		x 50
		y 129
		view 691
		loop 2
	)
)

(instance vBook of View
	(properties
		noun 38
		modNum 640
		x 5
		y 83
		priority 132
		fixPriority 1
		view 691
		loop 4
	)
)

(instance fChair1 of Feature
	(properties
		noun 27
		nsLeft 123
		nsTop 125
		nsRight 146
		nsBottom 174
		sightAngle 180
		x 134
		y 149
	)
)

(instance fChair2 of Feature
	(properties
		noun 27
		nsLeft 139
		nsTop 105
		nsRight 161
		nsBottom 128
		sightAngle 180
		x 150
		y 116
	)
)

(instance fChair3 of Feature
	(properties
		noun 27
		nsLeft 183
		nsTop 110
		nsRight 209
		nsBottom 157
		sightAngle 180
		x 196
		y 133
	)
)

(instance doorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				13 ; Look for Traps
				(and (== gHeroType 2) (IsFlag 242)) ; Thief
				7 ; Pick the Lock
				(and [gEgoStats 9] (gEgo has: 24)) ; pick locks, theToolkit
		)
	)

	(method (sayMessage)
		(switch iconValue
			(4 ; Open Door
				(if (== gHeroType 2) ; Thief
					(super sayMessage: 3 6 9 &rest) ; The door won't budge -- it's locked.
				else
					(self clean:)
					(gCurRoom setScript: sOpenTheDoor)
				)
			)
			(7 ; Pick the Lock
				(self clean:)
				(gCurRoom setScript: sPickLock)
			)
			(27 ; Peer Through Keyhole
				(self clean:)
				(gCurRoom setScript: sPeepingTom)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance squeakSound of Sound
	(properties
		number 143
	)
)

(instance doorSound of Sound
	(properties
		number 972
	)
)

(instance doorCloseSound of Sound
	(properties
		number 973
	)
)

