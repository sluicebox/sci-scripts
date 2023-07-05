;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 407)
(include sci.sh)
(use Main)
(use rLab)
(use n401)
(use n913)
(use PolyPath)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm407 0
)

(instance rm407 of LabRoom
	(properties
		west 400
	)

	(method (cue)
		(gGame handsOff:)
		(gCurRoom setScript: emptyHandedDeath)
	)

	(method (init)
		(proc401_2)
		(super init: &rest)
		(hiwEastWall init:)
		(if (and (not (IsFlag 1)) (not (rLab seenSecretLatch:)))
			(gCurRoom setScript: holeInWallEntry)
		else
			((ScriptID 30 0) cue:) ; rLab
			(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		)
		((ScriptID 30 0) initCrypt: 1) ; rLab
		((ScriptID 30 5) addToPic:) ; leftDoor
		((ScriptID 30 9) addToPic:) ; leftWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
	)

	(method (notify)
		((ScriptID 30 5) addToPic:) ; leftDoor
		((ScriptID 30 9) addToPic:) ; leftWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
		((ScriptID 30 3) show:) ; theTorch
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1 44 1 0 400) ; "Alexander is standing in a dead-end room in the catacombs. The only exit is to the west."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance holeInset of View
	(properties
		x 159
		y 190
		z 85
		view 487
		priority 15
		signal 24592
	)
)

(instance holeRoom of View
	(properties
		x 159
		y 139
		view 414
		priority 12
		signal 24592
	)
)

(instance tapestry of View
	(properties
		x 158
		y 135
		view 414
		loop 1
		priority 13
		signal 24592
	)
)

(instance sDoor of Prop
	(properties
		x 204
		y 96
		view 414
		loop 4
		priority 13
		signal 24592
		cycleSpeed 3
	)
)

(instance minoInset of Prop
	(properties
		x 158
		y 135
		view 414
		loop 2
		priority 14
		signal 24592
		cycleSpeed 3
	)
)

(instance tapeMove of Prop
	(properties
		x 158
		y 135
		view 414
		loop 3
		priority 13
		signal 24592
		cycleSpeed 3
	)
)

(instance mino of Actor
	(properties
		x 5
		y 158
		yStep 3
		view 443
		signal 16384
		xStep 5
	)
)

(instance theHole of Actor
	(properties
		x 261
		y 164
		z 50
		noun 17
		modNum 400
		view 232
		loop 6
		signal 26640
		moveSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(holeTimer dispose:)
				(gCurRoom setScript: lookInHole)
			)
			(2 ; Talk
				(gMessager say: 17 2 0 1 0 400) ; "The hole-in-the-wall does not like the walls of the catacombs and is not in the mood for conversation."
			)
			(5 ; Do
				(gCurRoom setScript: getTheHole)
			)
			(else
				(gMessager say: 17 0 0 1 0 400) ; "There is no reason to put that into the hole-in-the-wall."
			)
		)
	)
)

(instance hiwEastWall of Feature
	(properties
		x 255
		y 155
		noun 16
		modNum 400
		approachX 242
		approachY 162
	)

	(method (init)
		(self approachVerbs: 5 setOnMeCheck: 1 1024 16384) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; holeInTheWall
				(gCurRoom setScript: putHoleOnWall 0 1)
			)
			(1 ; Look
				(if (rLab seenSecretLatch:)
					(gMessager say: 16 1 46 1 0 400) ; "This room forms a cul-de-sac with the dead-end wall to the east."
				else
					(gMessager say: 16 1 45 0 0 400) ; "This room forms a cul-de-sac with the dead-end wall to the east."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance holeInWallEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 36 158 init: setMotion: PolyPath 73 158 self)
			)
			(1
				((ScriptID 30 0) cue:) ; rLab
				(gTheIconBar enable: 6)
				(gGlobalSound4 number: 401 setLoop: 1 play: self)
			)
			(2
				(cond
					((== (rLab timesInHoleWallRoom:) 0)
						(gMessager say: 1 0 39 0 self 400) ; "Alexander hears the sound of a wild beast again--this time so loud that the creature itself seems to be in the same room with him."
					)
					((gEgo has: 18) ; holeInTheWall
						(gMessager say: 1 0 41 1 self 400) ; "Alexander hears sounds coming from the other side of the east wall."
					)
					((not (rLab seenSecretLatch:))
						(gMessager say: 1 0 39 1 self 400) ; "Alexander hears the sound of a wild beast again--this time so loud that the creature itself seems to be in the same room with him."
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if
					(and
						(not ((ScriptID 30 0) holeIsUp:)) ; rLab
						(not (gEgo has: 18)) ; holeInTheWall
						(not (rLab seenSecretLatch:))
					)
					(gCurRoom setScript: emptyHandedDeath)
				else
					(self cue:)
				)
			)
			(4
				(if (== (rLab timesInHoleWallRoom:) 0)
					(rLab timesInHoleWallRoom: 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance emptyHandedDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo reset: setMotion: PolyPath 160 160 self)
			)
			(1
				(gGlobalSound4 number: 401 setLoop: 1 play: self)
			)
			(2
				(gMessager say: 1 0 40 1 self 400) ; "Too bad Alexander has no way to see what's on the other side of that wall."
			)
			(3
				(= seconds 3)
			)
			(4
				(if (!= (gEgo heading:) 180)
					(gEgo setHeading: 180)
				)
				(= cycles 12)
			)
			(5
				(gGlobalSound4 number: 401 setLoop: 1 play: self)
			)
			(6
				(gMessager say: 1 0 40 2 self 400) ; "The sounds shift direction and become louder to the south."
			)
			(7
				(= seconds 3)
			)
			(8
				(gEgo setHeading: 270)
				(= cycles 12)
			)
			(9
				(gGlobalSound4 number: 401 setLoop: 1 play: self)
			)
			(10
				(gMessager say: 1 0 40 3 self 400) ; "The sounds get louder still, now coming from the west."
			)
			(11
				(gMessager say: 1 0 40 4 self 400) ; "Uh, oh."
			)
			(12
				(gGlobalSound4 number: 401 setLoop: 1 play:)
				(gGlobalSound number: 407 setLoop: 1 play:)
				(mino init: setCycle: Walk setMotion: PolyPath 84 158 self)
			)
			(13
				(gMessager say: 1 0 40 5 self 400) ; "<Growl> Intruder, eh? URMM, good! Just in time--for DINNER!"
			)
			(14
				(gEgo
					view: 413
					setStep: 2 1
					setLoop: 0
					normal: 0
					setCycle: Fwd
					cycleSpeed: 1
					setMotion: MoveTo 160 144 self
				)
				(mino setMotion: PolyPath 160 160 self)
				(gGlobalSound4 number: 401 setLoop: 1 play:)
			)
			(15
				(gEgo setCycle: 0)
			)
			(16
				(gGlobalSound4 stop:)
				(mino setHeading: 0)
				(= cycles 6)
			)
			(17
				(gMessager say: 1 0 40 6 self 400) ; "Let's not be hasty now...."
			)
			(18
				(gGlobalSound4 number: 401 setLoop: 1 play:)
				(mino setMotion: PolyPath 159 149 self)
			)
			(19
				(gGlobalSound4 stop:)
				(gEgo
					setLoop: 2
					cel: 0
					posn: 159 149
					cycleSpeed: 3
					setCycle: CT 2 1 self
				)
				(mino dispose:)
			)
			(20
				(gEgo setCycle: End self)
				(gGlobalSound stop:)
				(gGlobalSound4 number: 402 setLoop: 1 play:)
			)
			(21
				(gGlobalSound4 number: 960 setLoop: 1 play:)
				(= cycles 6)
			)
			(22
				(if (gCast contains: theHole)
					(EgoDead 28) ; "Sometimes looks ARE everything!"
				else
					(EgoDead 27) ; "Caught in a blind alley! If only Alexander could have seen what was coming...."
				)
			)
		)
	)
)

(instance putHoleOnWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 18 gCurRoomNum) ; holeInTheWall
				(gGame handsOff:)
				(gCurRoom style: 100)
				(gEgo setMotion: PolyPath 242 162 self)
			)
			(1
				(gEgo
					view: 232
					setLoop: 0
					normal: 0
					posn: 254 162
					setCycle: CT 5 1 self
				)
			)
			(2
				(gEgo cel: 6)
				(if (not (IsFlag 114))
					(SetFlag 114)
					(gGame givePoints: 1)
				)
				(theHole init:)
				(gMessager say: 16 25 0 0 self 400) ; "Alexander puts the hole-in-the-wall on the east wall."
			)
			(3
				(gEgo
					posn: 242 162
					reset: 0
					setLoop: (gEgo cel:)
					setMotion: MoveTo 225 162 self
				)
			)
			(4
				(gEgo setLoop: -1)
				(if (== register 1)
					(gEgo setScript: holeTimer)
					(gGame handsOn:)
					(self dispose:)
				else
					(client setScript: emptyHandedDeath)
				)
			)
		)
	)
)

(instance getTheHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: 0 setMotion: PolyPath 242 162 self)
			)
			(1
				(gEgo setHeading: 45)
				(= cycles 6)
			)
			(2
				(gEgo view: 232 normal: 0 setLoop: 0 posn: 254 162 cel: 6)
				(= cycles 3)
			)
			(3
				(theHole dispose:)
				(gEgo cycleSpeed: 6 setCycle: Beg self)
			)
			(4
				(gEgo posn: 242 162 reset: 6)
				(= cycles 8)
			)
			(5
				(gEgo setLoop: (gEgo cel:) setMotion: MoveTo 225 162 self)
			)
			(6
				(gGame handsOn:)
				(gEgo setLoop: -1 get: 18) ; holeInTheWall
				((ScriptID 30 0) holeCoords: 0) ; rLab
				((ScriptID 30 0) holeWall: 0) ; rLab
				(self dispose:)
			)
		)
	)
)

(instance lookInHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 234 162 self)
			)
			(1
				(gEgo
					view: 232
					setLoop: 3
					cel: 0
					normal: 0
					posn: 246 163
					setCycle: End self
				)
			)
			(2
				(gMessager say: 17 1 47 1 self 400) ; "Alexander peers through the hole-in-the-wall and sees...."
			)
			(3
				(gMessager say: 17 1 47 2 self 400) ; "Just another room in the catacombs."
			)
			(4
				(gGame givePoints: 1)
				(self setScript: holie self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo posn: 234 162 reset: 0)
				(= cycles 4)
			)
			(7
				(gMessager say: 17 1 47 3 self 400) ; "Ah, ha! Not just another room at all! So that's why Alexander couldn't find the minotaur's lair!"
			)
			(8
				(gMessager say: 17 1 47 4 self 400) ; "At least Alexander now knows the lair exists...somewhere in the maze on the other side of this wall!"
			)
			(9
				(gGlobalSound4 number: 483 setLoop: 1 play:)
				(theHole
					view: 232
					setLoop: 6
					setPri: 13
					setCycle: Fwd
					setMotion: MoveTo 315 93 self
				)
			)
			(10
				(gMessager say: 17 1 47 5 self 400) ; "While Alexander contemplates what he's just seen, the hole-in-the-wall, frightened by the minotaur, makes a run for it."
			)
			(11
				(gMessager say: 17 1 47 6 self 400) ; "Alexander hopes the little creature finds its way home to the Isle of Wonder."
			)
			(12
				(rLab seenSecretLatch: 1)
				(theHole dispose:)
				(gGame handsOn:)
				(gCurRoom style: 10)
				(self dispose:)
			)
		)
	)
)

(instance holie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 30 3) addToPic:) ; theTorch
				(= seconds 2)
			)
			(1
				(holeInset addToPic:)
				(holeRoom addToPic:)
				(tapestry addToPic:)
				(sDoor init: stopUpd:)
				(minoInset init:)
				(tapeMove init:)
				(= seconds 2)
			)
			(2
				(minoInset setCycle: CT 3 1 self)
				(tapeMove setCycle: CT 3 1)
			)
			(3
				(gGlobalSound4 number: 408 setLoop: 1 play: self)
			)
			(4
				(gGlobalSound4 number: 909 setLoop: 1 play:)
				(sDoor setCycle: End self)
			)
			(5
				(minoInset setCycle: End self)
				(tapeMove setCycle: End)
			)
			(6
				(holeInset dispose:)
				(holeRoom dispose:)
				(tapestry dispose:)
				(sDoor dispose:)
				(minoInset dispose:)
				(tapeMove dispose:)
				(gCurRoom drawPic: 400 (if global169 15 else 100))
				((ScriptID 30 5) addToPic:) ; leftDoor
				((ScriptID 30 9) addToPic:) ; leftWing
				((ScriptID 30 8) addToPic:) ; bottomBlock
				((ScriptID 30 3) init: show:) ; theTorch
				((ScriptID 30 4) addToPic:) ; corpseNiche
				(= cycles 6)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance holeTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 1 0 43 1 self 400) ; "The hole-in-the-wall must have been startled by something on the other side of that wall. Before Alexander can look through it, it runs away in terror!"
			)
			(2
				(gGlobalSound4 number: 483 setLoop: 1 play:)
				(theHole setPri: 13 setCycle: Fwd setMotion: MoveTo 315 93 self)
			)
			(3
				(gMessager say: 1 0 43 2 self 400) ; "Alexander hopes there wasn't anything important on the other side of that wall!"
			)
			(4
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(5
				(theHole setCycle: 0 dispose:)
				(emptyHandedDeath start: 2)
				(gCurRoom setScript: emptyHandedDeath)
			)
		)
	)
)

