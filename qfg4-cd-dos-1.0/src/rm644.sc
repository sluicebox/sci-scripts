;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 644)
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
	rm644 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm644 of GloryRm
	(properties
		modNum 640
		picture 640
		east 632
	)

	(method (init)
		(switch gPrevRoomNum
			(631
				(= local2 1)
				(= local0 25)
				(= local1 134)
				(gEgo posn: 10 127)
			)
			(else
				(= local0 265)
				(= local1 175)
				(gEgo posn: 300 152)
			)
		)
		(gEgo
			init:
			setScaler: Scaler 100 100 189 0
			normalize: (if (== gPrevRoomNum 632) 1 else 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 304 189 266 153 254 135 227 135 210 126 198 128 98 124 88 116 74 123 46 122 31 133 5 143 5 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 52 130 78 127 233 140 233 156 158 180 140 180 108 180 50 169 42 158
					yourself:
				)
		)
		(super init: &rest)
		((pCandle new:)
			approachX: 72
			approachY: 156
			setLoop: 6 1
			setCel: 2
			posn: 104 107
			setPri: 174
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			approachX: 176
			approachY: 175
			setLoop: 6 1
			setCel: 0
			posn: 149 111
			setPri: 174
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 1
			posn: 99 9
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 0
			posn: 102 9
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:) setLoop: 6 1 setCel: 1 posn: 108 9 init: setCycle: Fwd)
		((pCandle new:)
			setLoop: 6 1
			setCel: 2
			posn: 118 6
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 0
			posn: 133 5
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 1
			posn: 133 9
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 2
			posn: 134 15
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 0
			posn: 151 6
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 1
			posn: 150 14
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 2
			posn: 161 7
			setPri: 207
			init:
			setCycle: Fwd
		)
		((pCandle new:)
			setLoop: 6 1
			setCel: 0
			posn: 117 14
			setPri: 207
			init:
			setCycle: Fwd
		)
		(pLeftSconce ignoreActors: approachVerbs: 4 init: setCycle: Fwd) ; Do
		(pRightSconce ignoreActors: approachVerbs: 4 init: setCycle: Fwd) ; Do
		(pRightDoor init: approachVerbs: 4 32) ; Do, theOil
		(rightDoorTeller init: pRightDoor 640 2 155)
		(pLeftDoor init: setPri: 152 approachVerbs: 4 32) ; Do, theOil
		(leftDoorTeller init: pLeftDoor 640 2 155)
		(vLeftChest ignoreActors: approachVerbs: 4 init:) ; Do
		(vRightChest ignoreActors: approachVerbs: 4 init:) ; Do
		(vMidChest ignoreActors: approachVerbs: 4 init:) ; Do
		(vTheTable ignoreActors: approachVerbs: 4 init:) ; Do
		(vRightColumn ignoreActors: init:)
		(vLeftColumn ignoreActors: init:)
		(vChandelier ignoreActors: init:)
		(vLeftDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vRightDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vRightCandle ignoreActors: approachVerbs: 4 init:) ; Do
		(vLeftCandle ignoreActors: approachVerbs: 4 init:) ; Do
		(vGryCup ignoreActors: approachVerbs: 4 init:) ; Do
		(vBlueCup ignoreActors: approachVerbs: 4 init:) ; Do
		(vGryVace ignoreActors: approachVerbs: 4 init:) ; Do
		(vTheChest ignoreActors: approachVerbs: 4 init:) ; Do
		(vTheRug ignoreActors: init:)
		(fCresset1 init: approachVerbs: 4) ; Do
		(fCresset2 init: approachVerbs: 4) ; Do
		(fHorn init: approachVerbs: 4) ; Do
		(fChair1 init: approachVerbs: 4) ; Do
		(fChair2 init: approachVerbs: 4) ; Do
		(fChair3 init: approachVerbs: 4) ; Do
		(gCurRoom setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 644) ; "This room appears to have once been used for informal dining. The once-elegant furniture is dust-covered and worn with age."
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
				(= ticks 24)
			)
			(1
				(doorSound play:)
				(if local2
					(pLeftDoor setCycle: End self)
				else
					(pRightDoor setCycle: End self)
				)
			)
			(2
				(pLeftDoor setPri: 75)
				(pRightDoor setPri: 75)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(3
				(if local2
					(pLeftDoor setCycle: Beg self)
				else
					(pRightDoor setCycle: Beg self)
				)
			)
			(4
				(doorCloseSound play:)
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
				(if (> (gEgo x:) 60)
					(gEgo setLoop: 0 1)
				else
					(gEgo setLoop: 1 1)
				)
				(gEgo view: 4 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (< (gEgo x:) 60)
					(gMessager say: 2 155 27 1 self 640) ; "You don't see any sign of life or movement beyond the door."
				else
					(gMessager say: 2 155 29 1 self 640) ; "You catch a brief glimpse of the elusive flash of wings on the other side of the door."
				)
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
				(if (< (gEgo x:) 160)
					(= local2 1)
					(if (not (IsFlag 210))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(= local2 0)
					(if (not (IsFlag 211))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(doorCloseSound dispose:)
				(if local2
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 2)
							(- (gEgo y:) 2)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 2)
							(- (gEgo y:) 2)
							self
					)
				)
			)
			(2
				(if local2
					(gCurRoom newRoom: 631)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
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
				(if local2
					(if (not (IsFlag 210))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(if (not (IsFlag 211))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(if local2
					(gEgo
						setMotion:
							PolyPath
							(pLeftDoor approachX:)
							(pLeftDoor approachY:)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(pRightDoor approachX:)
							(pRightDoor approachY:)
							self
					)
				)
			)
			(2
				(if local2
					(gCurRoom newRoom: 631)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
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
				(cond
					((IsFlag 210)
						(self cue:)
					)
					((IsFlag 211)
						(self cue:)
					)
					(else
						(squeakSound play:)
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(self cue:)
					)
				)
			)
			(2
				(doorSound play:)
				(if (< (gEgo x:) 160)
					(= local2 1)
					(pLeftDoor setCycle: End self)
				else
					(= local2 0)
					(pRightDoor setCycle: End self)
				)
			)
			(3
				(squeakSound dispose:)
				(doorSound dispose:)
				(= cycles 5)
			)
			(4
				(if (< (gEgo x:) 160)
					(gCurRoom newRoom: 631)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance sOpenCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch local3
					(1
						(vLeftChest setCycle: End self)
					)
					(2
						(vMidChest setCycle: End self)
					)
					(else
						(vRightChest setCycle: End self)
					)
				)
			)
			(1
				(if (== local3 1)
					(gEgo setLoop: 1 1)
				else
					(gEgo setLoop: 0 1)
				)
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(gMessager say: 7 4 14 1 self 640) ; "The cabinet is empty, save for a thick coating of dust."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(doorCloseSound setLoop: 1 1 play:)
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local3
					(1
						(vLeftChest setCycle: Beg self)
					)
					(2
						(vMidChest setCycle: Beg self)
					)
					(else
						(vRightChest setCycle: Beg self)
					)
				)
			)
			(5
				(= local3 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastOpenCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(switch local3
					(1
						(vLeftChest setCycle: End self)
					)
					(2
						(vMidChest setCycle: End self)
					)
					(else
						(vRightChest setCycle: End self)
					)
				)
			)
			(1
				(switch local3
					(1
						(gEgo
							setMotion:
								PolyPath
								(vLeftChest approachX:)
								(vLeftChest approachY:)
								self
						)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(vMidChest approachX:)
								(vMidChest approachY:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(vRightChest approachX:)
								(vRightChest approachY:)
								self
						)
					)
				)
			)
			(2
				(if (== local3 1)
					(gEgo setLoop: 1 1)
				else
					(gEgo setLoop: 0 1)
				)
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 7 4 14 1 self 640) ; "The cabinet is empty, save for a thick coating of dust."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(doorCloseSound setLoop: 1 1 play:)
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local3
					(1
						(vLeftChest setCycle: Beg self)
					)
					(2
						(vMidChest setCycle: Beg self)
					)
					(else
						(vRightChest setCycle: Beg self)
					)
				)
			)
			(6
				(= local3 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vLeftChest of Prop
	(properties
		noun 7
		modNum 640
		approachX 149
		approachY 127
		x 109
		y 96
		view 643
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 1)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local3 1)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vRightChest of Prop
	(properties
		noun 7
		modNum 640
		approachX 157
		approachY 127
		x 195
		y 98
		view 643
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 3)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local3 3)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vMidChest of Prop
	(properties
		noun 7
		modNum 640
		approachX 135
		approachY 126
		x 163
		y 98
		view 643
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 2)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local3 2)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pRightSconce of Prop
	(properties
		noun 21
		modNum 640
		approachX 189
		approachY 128
		x 191
		y 63
		priority 130
		fixPriority 1
		view 699
		loop 7
		cel 2
		detailLevel 2
	)
)

(instance pLeftSconce of Prop
	(properties
		noun 21
		modNum 640
		approachX 88
		approachY 116
		x 99
		y 63
		view 699
		loop 7
		cel 5
		detailLevel 2
	)
)

(instance pRightDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 269
		approachY 165
		x 271
		y 165
		z 94
		priority 196
		fixPriority 1
		view 644
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 211)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local2 0)
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

(instance pLeftDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 40
		approachY 128
		y 128
		z 97
		priority 31
		fixPriority 1
		view 644
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local2 1)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(SetFlag 210)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCandle of Prop
	(properties
		view 699
		signal 16385
		detailLevel 2
	)
)

(instance vTheTable of View
	(properties
		noun 29
		modNum 640
		approachX 72
		approachY 156
		x 61
		y 126
		z 29
		priority 163
		fixPriority 1
		view 681
		loop 2
		signal 4097
	)
)

(instance vRightColumn of View
	(properties
		modNum 640
		x 216
		y -6
		priority 75
		fixPriority 1
		view 685
		loop 2
	)
)

(instance vLeftColumn of View
	(properties
		modNum 640
		x 43
		y -1
		priority 86
		fixPriority 1
		view 685
	)
)

(instance vChandelier of View
	(properties
		noun 20
		modNum 640
		x 182
		priority 152
		fixPriority 1
		view 681
		loop 1
	)
)

(instance vLeftDoor of View
	(properties
		noun 1
		modNum 640
		approachX 40
		approachY 128
		y 128
		z 99
		priority 29
		fixPriority 1
		view 644
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(pLeftDoor doVerb: theVerb)
	)
)

(instance vRightCandle of View
	(properties
		noun 26
		modNum 640
		approachX 176
		approachY 175
		x 161
		y 127
		z 16
		priority 174
		fixPriority 1
		view 699
		cel 2
	)
)

(instance vLeftCandle of View
	(properties
		noun 26
		modNum 640
		approachX 72
		approachY 156
		x 116
		y 128
		z 20
		priority 174
		fixPriority 1
		view 699
		cel 2
	)
)

(instance vGryCup of View
	(properties
		noun 23
		modNum 640
		approachX 72
		approachY 156
		x 106
		y 127
		z 7
		priority 174
		fixPriority 1
		view 699
		loop 2
	)
)

(instance vBlueCup of View
	(properties
		noun 24
		modNum 640
		approachX 176
		approachY 175
		x 177
		y 128
		z 3
		priority 174
		fixPriority 1
		view 699
		loop 3
		cel 3
	)
)

(instance vGryVace of View
	(properties
		noun 11
		modNum 640
		approachX 176
		approachY 175
		x 151
		y 129
		z 7
		priority 174
		fixPriority 1
		view 699
		loop 2
		cel 2
	)
)

(instance vTheChest of View
	(properties
		noun 7
		modNum 640
		approachX 189
		approachY 128
		x 102
		y 88
		view 643
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 3)
				(gCurRoom setScript: sCastOpenCupboard)
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

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 269
		approachY 165
		x 270
		y 165
		z 97
		priority 68
		fixPriority 1
		view 644
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(pRightDoor doVerb: theVerb)
	)
)

(instance vTheRug of View
	(properties
		noun 33
		modNum 640
		x 11
		y 125
		fixPriority 1
		view 692
	)
)

(instance fCresset1 of Feature
	(properties
		noun 22
		modNum 640
		nsLeft 92
		nsTop 57
		nsRight 114
		nsBottom 90
		sightAngle 180
		approachX 88
		approachY 166
		x 103
		y 73
	)
)

(instance fCresset2 of Feature
	(properties
		noun 22
		modNum 640
		nsLeft 188
		nsTop 60
		nsRight 202
		nsBottom 86
		sightAngle 180
		approachX 189
		approachY 128
		x 195
		y 73
	)
)

(instance fHorn of Feature
	(properties
		noun 25
		modNum 640
		nsLeft 165
		nsTop 125
		nsRight 176
		nsBottom 135
		sightAngle 180
		approachX 176
		approachY 175
		x 170
		y 130
	)
)

(instance fChair1 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 68
		nsTop 97
		nsRight 92
		nsBottom 154
		sightAngle 180
		approachX 72
		approachY 156
		x 80
		y 125
	)
)

(instance fChair2 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 189
		nsTop 103
		nsRight 215
		nsBottom 158
		sightAngle 180
		approachX 204
		approachY 165
		x 202
		y 130
	)
)

(instance fChair3 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 123
		nsTop 122
		nsRight 155
		nsBottom 175
		sightAngle 180
		approachX 176
		approachY 175
		x 139
		y 148
	)
)

(instance rightDoorTeller of Teller
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
					(gMessager say: 3 6 9 1 0 640) ; "The door won't budge -- it's locked."
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
				(super sayMessage:)
			)
		)
	)
)

(instance leftDoorTeller of Teller
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
					(gMessager say: 3 6 9 1 0 640) ; "The door won't budge -- it's locked."
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
				(super sayMessage:)
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

