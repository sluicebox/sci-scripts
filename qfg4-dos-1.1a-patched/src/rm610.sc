;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
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
	rm610 0
)

(instance rm610 of GloryRm
	(properties
		picture 610
		west 600
	)

	(method (init)
		(gGlory handsOff:)
		(gLongSong doSongs: stop:)
		(gLongSong number: 610 setLoop: -1 1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 115 189 255 151 169 119 154 113 124 121 118 139 89 152 56 154 0 148
					yourself:
				)
		)
		(gEgo
			x: 1
			y: 174
			setScaler: Scaler 60 41 189 108
			init:
			normalize:
			solvePuzzle: 478 2 1 9
			setScript: sComeOnIn
		)
		(if (IsFlag 101)
			(vAKatrina init:)
		)
		(pDoor init: approachVerbs: 4 32) ; Do, theOil
		(pTorch2 setCycle: Fwd init: approachVerbs: 4) ; Do
		(pTorch1 setCycle: Fwd init: approachVerbs: 4) ; Do
		(pFlicker1 setCycle: Fwd init:)
		(pFlicker2 setCycle: Fwd init:)
		(super init: &rest)
		(fLeftTorch init: approachVerbs: 4) ; Do
		(fRightTorch init: approachVerbs: 4) ; Do
		(fWriting init: approachVerbs: 4) ; Do
		(fHoles init: approachVerbs: 4) ; Do
		(fGargoyle1 init: approachVerbs: 4) ; Do
		(fGargoyleArm init: approachVerbs: 4) ; Do
		(fGargoyle2 init: approachVerbs: 4) ; Do
		(doorTeller init: pDoor 610 2 125)
	)

	(method (dispose)
		(gLongSong fade: 0)
		(super dispose:)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 101)
					(self setScript: sWavedOnIn)
				else
					(gEgo setMotion: PolyPath 71 170 self)
				)
			)
			(1
				(sndLightning play:)
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
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: (- (gEgo x:) 6) (- (gEgo y:) 1)
					setCycle: End self
				)
			)
			(1
				(gMessager say: 2 125 5 1 self) ; "Peering through the keyhole, you can see a long empty hallway leading to the castle's Great Hall."
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

(instance sWavedOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sndLightning play:)
				(gEgo setMotion: PolyPath 71 170 self)
			)
			(2
				(pArm init: setPri: 207 setCycle: CT 7 1 self)
			)
			(3
				(sndSpell play:)
				(aSpell init: setCycle: End self)
			)
			(4
				(sndSpell stop:)
				(aSpell dispose:)
				(pArm setCel: 7 setCycle: End)
				(doorOpenSound play:)
				(pDoor setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 221 113 self)
			)
			(6
				(pArm dispose:)
				(doorCloseSound play:)
				(pDoor setCycle: Beg self)
			)
			(7
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance sBustingIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(doorOpenSound play:)
				(pDoor setPri: 119 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 221 113 self)
			)
			(2
				(pDoor setCycle: Beg self)
			)
			(3
				(doorCloseSound play:)
				(= ticks 12)
			)
			(4
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance aSpell of Actor
	(properties
		x 107
		y 21
		view 611
		loop 2
		cel 8
	)
)

(instance pDoor of Prop
	(properties
		noun 1
		sightAngle 40
		approachX 185
		approachY 126
		x 172
		y 79
		view 610
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(if (IsFlag 206)
					(gMessager say: 1 32 6) ; "You have already oiled the doors. You may have an endless supply of oil, but don't waste it!"
				else
					(SetFlag 206)
					(gMessager say: 1 32 0 0) ; "You oil the hinges of the doors. It really takes a stretch to reach the upper hinge; these doors are huge!"
				)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sBustingIn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pTorch2 of Prop
	(properties
		noun 5
		sightAngle 40
		approachX 184
		approachY 125
		x 161
		y 60
		view 610
		loop 2
		cel 1
		cycleSpeed 9
		detailLevel 2
	)
)

(instance pTorch1 of Prop
	(properties
		noun 5
		sightAngle 40
		approachX 204
		approachY 132
		approachDist 47
		x 219
		y 72
		view 610
		loop 1
		cycleSpeed 8
		detailLevel 2
	)
)

(instance pFlicker1 of Prop
	(properties
		x 207
		y 69
		view 610
		loop 3
		cel 1
		cycleSpeed 14
		detailLevel 2
	)
)

(instance pFlicker2 of Prop
	(properties
		x 169
		y 75
		view 610
		loop 4
		cycleSpeed 14
		detailLevel 2
	)
)

(instance pArm of Prop
	(properties
		x 199
		y 153
		view 611
		cel 7
		cycleSpeed 4
	)
)

(instance vAKatrina of View
	(properties
		x 199
		y 189
		priority 255
		fixPriority 1
		view 611
		loop 1
	)
)

(instance fLeftTorch of Feature
	(properties
		noun 5
		nsLeft 162
		nsTop 62
		nsRight 170
		nsBottom 80
		sightAngle 180
		approachX 184
		approachY 125
		x 166
		y 71
	)
)

(instance fRightTorch of Feature
	(properties
		noun 5
		nsLeft 221
		nsTop 75
		nsRight 227
		nsBottom 99
		sightAngle 180
		approachX 204
		approachY 132
		approachDist 47
		x 224
		y 87
	)
)

(instance fWriting of Feature
	(properties
		noun 3
		nsLeft 183
		nsTop 59
		nsRight 199
		nsBottom 80
		sightAngle 180
		approachX 184
		approachY 125
		approachDist 54
		x 191
		y 69
	)
)

(instance fHoles of Feature
	(properties
		noun 4
		nsLeft 241
		nsTop 135
		nsRight 319
		nsBottom 171
		sightAngle 180
		x 280
		y 153
	)
)

(instance fGargoyle1 of Feature
	(properties
		noun 6
		nsLeft 14
		nsTop 2
		nsRight 114
		nsBottom 47
		sightAngle 180
		x 64
		y 24
	)
)

(instance fGargoyleArm of Feature
	(properties
		noun 8
		nsLeft 12
		nsTop 47
		nsRight 74
		nsBottom 84
		sightAngle 180
		x 43
		y 65
	)
)

(instance fGargoyle2 of Feature
	(properties
		noun 7
		nsLeft 241
		nsTop -1
		nsRight 319
		nsBottom 55
		sightAngle 180
		x 280
		y 27
	)
)

(instance doorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (sayMessage)
		(switch iconValue
			(1 ; Open Doors
				(self clean:)
				(gCurRoom setScript: sBustingIn)
			)
			(5 ; Peer Through Keyhole
				(self clean:)
				(gCurRoom setScript: sPeepingTom)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

(instance doorOpenSound of Sound
	(properties
		number 972
	)
)

(instance doorCloseSound of Sound
	(properties
		number 973
	)
)

(instance sndSpell of Sound
	(properties
		number 934
	)
)

(instance sndLightning of Sound
	(properties
		number 974
	)
)

